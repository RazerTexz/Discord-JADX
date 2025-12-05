package com.facebook.imagepipeline.producers;

import android.content.ContentResolver;
import android.content.res.AssetFileDescriptor;
import android.database.Cursor;
import android.graphics.BitmapFactory;
import android.media.ExifInterface;
import android.net.Uri;
import android.os.Build;
import android.util.Pair;
import androidx.core.util.Pools;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.request.ImageRequest;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.Executor;
import p007b.p085c.p086a.p087a0.AnimatableValueParser;
import p007b.p109f.p115d.p119d.ImmutableMap;
import p007b.p109f.p115d.p120e.FLog;
import p007b.p109f.p115d.p122g.PooledByteBufferFactory;
import p007b.p109f.p115d.p122g.PooledByteBufferInputStream;
import p007b.p109f.p115d.p127l.UriUtil;
import p007b.p109f.p160i.DefaultImageFormats;
import p007b.p109f.p161j.p169d.ResizeOptions;
import p007b.p109f.p161j.p175j.EncodedImage2;
import p007b.p109f.p161j.p181p.BaseProducerContextCallbacks;
import p007b.p109f.p161j.p181p.Consumer2;
import p007b.p109f.p161j.p181p.ProducerContext;
import p007b.p109f.p161j.p181p.ProducerListener2;
import p007b.p109f.p161j.p181p.StatefulProducerRunnable;
import p007b.p109f.p161j.p181p.ThumbnailProducer;
import p007b.p109f.p186k.BitmapUtil;
import p007b.p109f.p190m.DoNotOptimize;

/* loaded from: classes3.dex */
public class LocalExifThumbnailProducer implements ThumbnailProducer<EncodedImage2> {

    /* renamed from: a */
    public final Executor f19577a;

    /* renamed from: b */
    public final PooledByteBufferFactory f19578b;

    /* renamed from: c */
    public final ContentResolver f19579c;

    @DoNotOptimize
    public class Api24Utils {
    }

    /* renamed from: com.facebook.imagepipeline.producers.LocalExifThumbnailProducer$a */
    public class C10663a extends StatefulProducerRunnable<EncodedImage2> {

        /* renamed from: o */
        public final /* synthetic */ ImageRequest f19580o;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C10663a(Consumer2 consumer2, ProducerListener2 producerListener2, ProducerContext producerContext, String str, ImageRequest imageRequest) {
            super(consumer2, producerListener2, producerContext, str);
            this.f19580o = imageRequest;
        }

        @Override // p007b.p109f.p161j.p181p.StatefulProducerRunnable
        /* renamed from: b */
        public void mo1465b(EncodedImage2 encodedImage2) {
            EncodedImage2 encodedImage22 = encodedImage2;
            if (encodedImage22 != null) {
                encodedImage22.close();
            }
        }

        @Override // p007b.p109f.p161j.p181p.StatefulProducerRunnable
        /* renamed from: c */
        public Map mo1466c(EncodedImage2 encodedImage2) {
            return ImmutableMap.m967of("createdThumbnail", Boolean.toString(encodedImage2 != null));
        }

        /* JADX WARN: Removed duplicated region for block: B:15:0x0031  */
        /* JADX WARN: Removed duplicated region for block: B:52:0x009b  */
        @Override // p007b.p109f.p161j.p181p.StatefulProducerRunnable
        /* renamed from: d */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public EncodedImage2 mo1467d() throws Exception {
            String path;
            ExifInterface exifInterface;
            AssetFileDescriptor assetFileDescriptorOpenAssetFileDescriptor;
            int i;
            int columnIndex;
            Uri uri = this.f19580o.f19585c;
            LocalExifThumbnailProducer localExifThumbnailProducer = LocalExifThumbnailProducer.this;
            ContentResolver contentResolver = localExifThumbnailProducer.f19579c;
            EncodedImage2 encodedImage2 = null;
            Cursor cursor = null;
            pair = null;
            Pair pair = null;
            encodedImage2 = null;
            if (UriUtil.m1007c(uri)) {
                try {
                    Cursor cursorQuery = contentResolver.query(uri, null, null, null, null);
                    if (cursorQuery != null) {
                        try {
                            path = (!cursorQuery.moveToFirst() || (columnIndex = cursorQuery.getColumnIndex("_data")) == -1) ? null : cursorQuery.getString(columnIndex);
                            if (cursorQuery != null) {
                                cursorQuery.close();
                            }
                        } catch (Throwable th) {
                            th = th;
                            cursor = cursorQuery;
                            if (cursor != null) {
                                cursor.close();
                            }
                            throw th;
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            } else {
                path = UriUtil.m1008d(uri) ? uri.getPath() : null;
            }
            if (path == null) {
                exifInterface = null;
            } else {
                boolean z2 = false;
                try {
                    File file = new File(path);
                    if (file.exists() && file.canRead()) {
                        z2 = true;
                    }
                } catch (IOException unused) {
                } catch (StackOverflowError unused2) {
                    FLog.m973a(LocalExifThumbnailProducer.class, "StackOverflowError in ExifInterface constructor");
                }
                if (z2) {
                    exifInterface = new ExifInterface(path);
                } else {
                    ContentResolver contentResolver2 = localExifThumbnailProducer.f19579c;
                    if (UriUtil.m1007c(uri)) {
                        try {
                            assetFileDescriptorOpenAssetFileDescriptor = contentResolver2.openAssetFileDescriptor(uri, "r");
                        } catch (FileNotFoundException unused3) {
                        }
                        if (assetFileDescriptorOpenAssetFileDescriptor == null && (i = Build.VERSION.SDK_INT) >= 24) {
                            ExifInterface exifInterface2 = i >= 24 ? new ExifInterface(assetFileDescriptorOpenAssetFileDescriptor.getFileDescriptor()) : null;
                            assetFileDescriptorOpenAssetFileDescriptor.close();
                            exifInterface = exifInterface2;
                        }
                    } else {
                        assetFileDescriptorOpenAssetFileDescriptor = null;
                        if (assetFileDescriptorOpenAssetFileDescriptor == null) {
                            exifInterface = null;
                        }
                    }
                }
            }
            if (exifInterface != null && exifInterface.hasThumbnail()) {
                byte[] thumbnail = exifInterface.getThumbnail();
                Objects.requireNonNull(thumbnail);
                PooledByteBuffer pooledByteBufferMo994b = LocalExifThumbnailProducer.this.f19578b.mo994b(thumbnail);
                Objects.requireNonNull(LocalExifThumbnailProducer.this);
                PooledByteBufferInputStream pooledByteBufferInputStream = new PooledByteBufferInputStream(pooledByteBufferMo994b);
                Pools.SynchronizedPool<ByteBuffer> synchronizedPool = BitmapUtil.f4275a;
                Pools.SynchronizedPool<ByteBuffer> synchronizedPool2 = BitmapUtil.f4275a;
                ByteBuffer byteBufferAcquire = synchronizedPool2.acquire();
                if (byteBufferAcquire == null) {
                    byteBufferAcquire = ByteBuffer.allocate(16384);
                }
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inJustDecodeBounds = true;
                try {
                    options.inTempStorage = byteBufferAcquire.array();
                    BitmapFactory.decodeStream(pooledByteBufferInputStream, null, options);
                    if (options.outWidth != -1 && options.outHeight != -1) {
                        pair = new Pair(Integer.valueOf(options.outWidth), Integer.valueOf(options.outHeight));
                    }
                    synchronizedPool2.release(byteBufferAcquire);
                    String attribute = exifInterface.getAttribute(androidx.exifinterface.media.ExifInterface.TAG_ORIENTATION);
                    Objects.requireNonNull(attribute);
                    int iM568s0 = AnimatableValueParser.m568s0(Integer.parseInt(attribute));
                    int iIntValue = pair != null ? ((Integer) pair.first).intValue() : -1;
                    int iIntValue2 = pair != null ? ((Integer) pair.second).intValue() : -1;
                    CloseableReference closeableReferenceM8632A = CloseableReference.m8632A(pooledByteBufferMo994b);
                    try {
                        encodedImage2 = new EncodedImage2(closeableReferenceM8632A);
                        encodedImage2.f3893l = DefaultImageFormats.f3585a;
                        encodedImage2.f3894m = iM568s0;
                        encodedImage2.f3896o = iIntValue;
                        encodedImage2.f3897p = iIntValue2;
                    } finally {
                        if (closeableReferenceM8632A != null) {
                            closeableReferenceM8632A.close();
                        }
                    }
                } catch (Throwable th3) {
                    BitmapUtil.f4275a.release(byteBufferAcquire);
                    throw th3;
                }
            }
            return encodedImage2;
        }
    }

    /* renamed from: com.facebook.imagepipeline.producers.LocalExifThumbnailProducer$b */
    public class C10664b extends BaseProducerContextCallbacks {

        /* renamed from: a */
        public final /* synthetic */ StatefulProducerRunnable f19582a;

        public C10664b(LocalExifThumbnailProducer localExifThumbnailProducer, StatefulProducerRunnable statefulProducerRunnable) {
            this.f19582a = statefulProducerRunnable;
        }

        @Override // p007b.p109f.p161j.p181p.ProducerContextCallbacks
        /* renamed from: a */
        public void mo1438a() {
            this.f19582a.m1464a();
        }
    }

    public LocalExifThumbnailProducer(Executor executor, PooledByteBufferFactory pooledByteBufferFactory, ContentResolver contentResolver) {
        this.f19577a = executor;
        this.f19578b = pooledByteBufferFactory;
        this.f19579c = contentResolver;
    }

    @Override // p007b.p109f.p161j.p181p.ThumbnailProducer
    /* renamed from: a */
    public boolean mo1474a(ResizeOptions resizeOptions) {
        return AnimatableValueParser.m472S0(512, 512, resizeOptions);
    }

    @Override // p007b.p109f.p161j.p181p.Producer2
    /* renamed from: b */
    public void mo1417b(Consumer2<EncodedImage2> consumer2, ProducerContext producerContext) {
        ProducerListener2 producerListener2Mo1457o = producerContext.mo1457o();
        ImageRequest imageRequestMo1447e = producerContext.mo1447e();
        producerContext.mo1451i("local", "exif");
        C10663a c10663a = new C10663a(consumer2, producerListener2Mo1457o, producerContext, "LocalExifThumbnailProducer", imageRequestMo1447e);
        producerContext.mo1448f(new C10664b(this, c10663a));
        this.f19577a.execute(c10663a);
    }
}

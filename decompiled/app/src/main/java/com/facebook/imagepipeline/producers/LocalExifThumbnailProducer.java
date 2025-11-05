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
import b.f.d.d.f;
import b.f.d.g.g;
import b.f.d.g.h;
import b.f.j.j.e;
import b.f.j.p.e1;
import b.f.j.p.k1;
import b.f.j.p.l;
import b.f.j.p.x0;
import b.f.j.p.z0;
import b.f.m.d;
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

/* loaded from: classes3.dex */
public class LocalExifThumbnailProducer implements k1<e> {
    public final Executor a;

    /* renamed from: b, reason: collision with root package name */
    public final g f2901b;
    public final ContentResolver c;

    @d
    public class Api24Utils {
    }

    public class a extends e1<e> {
        public final /* synthetic */ ImageRequest o;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(l lVar, z0 z0Var, x0 x0Var, String str, ImageRequest imageRequest) {
            super(lVar, z0Var, x0Var, str);
            this.o = imageRequest;
        }

        @Override // b.f.j.p.e1
        public void b(e eVar) {
            e eVar2 = eVar;
            if (eVar2 != null) {
                eVar2.close();
            }
        }

        @Override // b.f.j.p.e1
        public Map c(e eVar) {
            return f.of("createdThumbnail", Boolean.toString(eVar != null));
        }

        /* JADX WARN: Removed duplicated region for block: B:15:0x0031  */
        /* JADX WARN: Removed duplicated region for block: B:52:0x009b  */
        @Override // b.f.j.p.e1
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public e d() throws Exception {
            String path;
            ExifInterface exifInterface;
            AssetFileDescriptor assetFileDescriptorOpenAssetFileDescriptor;
            int i;
            int columnIndex;
            Uri uri = this.o.c;
            LocalExifThumbnailProducer localExifThumbnailProducer = LocalExifThumbnailProducer.this;
            ContentResolver contentResolver = localExifThumbnailProducer.c;
            e eVar = null;
            Cursor cursor = null;
            pair = null;
            Pair pair = null;
            eVar = null;
            if (b.f.d.l.b.c(uri)) {
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
                path = b.f.d.l.b.d(uri) ? uri.getPath() : null;
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
                    b.f.d.e.a.a(LocalExifThumbnailProducer.class, "StackOverflowError in ExifInterface constructor");
                }
                if (z2) {
                    exifInterface = new ExifInterface(path);
                } else {
                    ContentResolver contentResolver2 = localExifThumbnailProducer.c;
                    if (b.f.d.l.b.c(uri)) {
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
                PooledByteBuffer pooledByteBufferB = LocalExifThumbnailProducer.this.f2901b.b(thumbnail);
                Objects.requireNonNull(LocalExifThumbnailProducer.this);
                h hVar = new h(pooledByteBufferB);
                Pools.SynchronizedPool<ByteBuffer> synchronizedPool = b.f.k.a.a;
                Pools.SynchronizedPool<ByteBuffer> synchronizedPool2 = b.f.k.a.a;
                ByteBuffer byteBufferAcquire = synchronizedPool2.acquire();
                if (byteBufferAcquire == null) {
                    byteBufferAcquire = ByteBuffer.allocate(16384);
                }
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inJustDecodeBounds = true;
                try {
                    options.inTempStorage = byteBufferAcquire.array();
                    BitmapFactory.decodeStream(hVar, null, options);
                    if (options.outWidth != -1 && options.outHeight != -1) {
                        pair = new Pair(Integer.valueOf(options.outWidth), Integer.valueOf(options.outHeight));
                    }
                    synchronizedPool2.release(byteBufferAcquire);
                    String attribute = exifInterface.getAttribute(androidx.exifinterface.media.ExifInterface.TAG_ORIENTATION);
                    Objects.requireNonNull(attribute);
                    int iS0 = b.c.a.a0.d.s0(Integer.parseInt(attribute));
                    int iIntValue = pair != null ? ((Integer) pair.first).intValue() : -1;
                    int iIntValue2 = pair != null ? ((Integer) pair.second).intValue() : -1;
                    CloseableReference closeableReferenceA = CloseableReference.A(pooledByteBufferB);
                    try {
                        eVar = new e(closeableReferenceA);
                        eVar.l = b.f.i.b.a;
                        eVar.m = iS0;
                        eVar.o = iIntValue;
                        eVar.p = iIntValue2;
                    } finally {
                        if (closeableReferenceA != null) {
                            closeableReferenceA.close();
                        }
                    }
                } catch (Throwable th3) {
                    b.f.k.a.a.release(byteBufferAcquire);
                    throw th3;
                }
            }
            return eVar;
        }
    }

    public class b extends b.f.j.p.e {
        public final /* synthetic */ e1 a;

        public b(LocalExifThumbnailProducer localExifThumbnailProducer, e1 e1Var) {
            this.a = e1Var;
        }

        @Override // b.f.j.p.y0
        public void a() {
            this.a.a();
        }
    }

    public LocalExifThumbnailProducer(Executor executor, g gVar, ContentResolver contentResolver) {
        this.a = executor;
        this.f2901b = gVar;
        this.c = contentResolver;
    }

    @Override // b.f.j.p.k1
    public boolean a(b.f.j.d.e eVar) {
        return b.c.a.a0.d.S0(512, 512, eVar);
    }

    @Override // b.f.j.p.w0
    public void b(l<e> lVar, x0 x0Var) {
        z0 z0VarO = x0Var.o();
        ImageRequest imageRequestE = x0Var.e();
        x0Var.i("local", "exif");
        a aVar = new a(lVar, z0VarO, x0Var, "LocalExifThumbnailProducer", imageRequestE);
        x0Var.f(new b(this, aVar));
        this.a.execute(aVar);
    }
}

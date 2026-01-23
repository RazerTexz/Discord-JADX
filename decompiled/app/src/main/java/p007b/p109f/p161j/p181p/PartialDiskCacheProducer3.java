package p007b.p109f.p161j.p181p;

import android.net.Uri;
import androidx.annotation.VisibleForTesting;
import com.facebook.cache.common.CacheKey;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.memory.MemoryPooledByteBufferOutputStream;
import com.facebook.imagepipeline.request.ImageRequest;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;
import p007b.p109f.p111b.p112a.SimpleCacheKey;
import p007b.p109f.p115d.p119d.ImmutableMap;
import p007b.p109f.p115d.p120e.FLog;
import p007b.p109f.p115d.p122g.ByteArrayPool;
import p007b.p109f.p115d.p122g.PooledByteBufferFactory;
import p007b.p109f.p115d.p122g.PooledByteBufferOutputStream;
import p007b.p109f.p160i.ImageFormat;
import p007b.p109f.p161j.p168c.BufferedDiskCache2;
import p007b.p109f.p161j.p168c.BufferedDiskCache3;
import p007b.p109f.p161j.p168c.CacheKeyFactory;
import p007b.p109f.p161j.p168c.DefaultCacheKeyFactory;
import p007b.p109f.p161j.p169d.BytesRange;
import p007b.p109f.p161j.p175j.EncodedImage2;
import p686z.Task6;

/* JADX INFO: renamed from: b.f.j.p.r0, reason: use source file name */
/* JADX INFO: compiled from: PartialDiskCacheProducer.java */
/* JADX INFO: loaded from: classes3.dex */
public class PartialDiskCacheProducer3 implements Producer2<EncodedImage2> {

    /* JADX INFO: renamed from: a */
    public final BufferedDiskCache2 f4191a;

    /* JADX INFO: renamed from: b */
    public final CacheKeyFactory f4192b;

    /* JADX INFO: renamed from: c */
    public final PooledByteBufferFactory f4193c;

    /* JADX INFO: renamed from: d */
    public final ByteArrayPool f4194d;

    /* JADX INFO: renamed from: e */
    public final Producer2<EncodedImage2> f4195e;

    /* JADX INFO: renamed from: b.f.j.p.r0$a */
    /* JADX INFO: compiled from: PartialDiskCacheProducer.java */
    public static class a extends DelegatingConsumer<EncodedImage2, EncodedImage2> {

        /* JADX INFO: renamed from: c */
        public final BufferedDiskCache2 f4196c;

        /* JADX INFO: renamed from: d */
        public final CacheKey f4197d;

        /* JADX INFO: renamed from: e */
        public final PooledByteBufferFactory f4198e;

        /* JADX INFO: renamed from: f */
        public final ByteArrayPool f4199f;

        /* JADX INFO: renamed from: g */
        public final EncodedImage2 f4200g;

        /* JADX INFO: renamed from: h */
        public final boolean f4201h;

        public a(Consumer2 consumer2, BufferedDiskCache2 bufferedDiskCache2, CacheKey cacheKey, PooledByteBufferFactory pooledByteBufferFactory, ByteArrayPool byteArrayPool, EncodedImage2 encodedImage2, boolean z2, PartialDiskCacheProducer partialDiskCacheProducer) {
            super(consumer2);
            this.f4196c = bufferedDiskCache2;
            this.f4197d = cacheKey;
            this.f4198e = pooledByteBufferFactory;
            this.f4199f = byteArrayPool;
            this.f4200g = encodedImage2;
            this.f4201h = z2;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v8, types: [b.f.j.c.f] */
        /* JADX WARN: Type inference failed for: r3v0, types: [b.f.j.p.p, b.f.j.p.r0$a] */
        /* JADX WARN: Type inference failed for: r4v1, types: [b.f.j.j.e, java.lang.Object] */
        /* JADX WARN: Type inference failed for: r4v2, types: [b.f.j.j.e] */
        /* JADX WARN: Type inference failed for: r4v5, types: [b.f.j.c.f, java.lang.Object] */
        @Override // p007b.p109f.p161j.p181p.BaseConsumer
        /* JADX INFO: renamed from: i */
        public void mo1320i(Object obj, int i) {
            ?? r4 = (EncodedImage2) obj;
            if (BaseConsumer.m1420f(i)) {
                return;
            }
            EncodedImage2 encodedImage2 = this.f4200g;
            if (encodedImage2 != null && r4 != 0) {
                try {
                    if (r4.f3900s != null) {
                        try {
                            m1515p(m1514o(encodedImage2, r4));
                        } catch (IOException e) {
                            FLog.m978f("PartialDiskCacheProducer", "Error while merging image data", e);
                            this.f4179b.mo1425c(e);
                        }
                        r4.close();
                        this.f4200g.close();
                        r4 = this.f4196c;
                        CacheKey cacheKey = this.f4197d;
                        Objects.requireNonNull(r4);
                        Objects.requireNonNull(cacheKey);
                        r4.f3666f.m1210c(cacheKey);
                        try {
                            Task6.m11366a(new BufferedDiskCache3(r4, null, cacheKey), r4.f3665e);
                            return;
                        } catch (Exception e2) {
                            FLog.m986n(BufferedDiskCache2.class, e2, "Failed to schedule disk-cache remove for %s", cacheKey.mo930b());
                            Task6.m11367c(e2);
                            return;
                        }
                    }
                } catch (Throwable th) {
                    r4.close();
                    this.f4200g.close();
                    throw th;
                }
            }
            if (this.f4201h && BaseConsumer.m1422m(i, 8) && BaseConsumer.m1419e(i) && r4 != 0) {
                r4.m1347x();
                if (r4.f3893l != ImageFormat.f3597a) {
                    this.f4196c.m1220f(this.f4197d, r4);
                    this.f4179b.mo1424b(r4, i);
                    return;
                }
            }
            this.f4179b.mo1424b(r4, i);
        }

        /* JADX INFO: renamed from: n */
        public final void m1513n(InputStream inputStream, OutputStream outputStream, int i) throws IOException {
            byte[] bArr = this.f4199f.get(16384);
            int i2 = i;
            while (i2 > 0) {
                try {
                    int i3 = inputStream.read(bArr, 0, Math.min(16384, i2));
                    if (i3 < 0) {
                        break;
                    } else if (i3 > 0) {
                        outputStream.write(bArr, 0, i3);
                        i2 -= i3;
                    }
                } finally {
                    this.f4199f.release(bArr);
                }
            }
            if (i2 > 0) {
                throw new IOException(String.format(null, "Failed to read %d bytes - finished %d short", Integer.valueOf(i), Integer.valueOf(i2)));
            }
        }

        /* JADX INFO: renamed from: o */
        public final PooledByteBufferOutputStream m1514o(EncodedImage2 encodedImage2, EncodedImage2 encodedImage22) throws IOException {
            BytesRange bytesRange = encodedImage22.f3900s;
            Objects.requireNonNull(bytesRange);
            int i = bytesRange.f3704a;
            PooledByteBufferOutputStream pooledByteBufferOutputStreamMo997e = this.f4198e.mo997e(encodedImage22.m1344n() + i);
            m1513n(encodedImage2.m1343f(), pooledByteBufferOutputStreamMo997e, i);
            m1513n(encodedImage22.m1343f(), pooledByteBufferOutputStreamMo997e, encodedImage22.m1344n());
            return pooledByteBufferOutputStreamMo997e;
        }

        /* JADX INFO: renamed from: p */
        public final void m1515p(PooledByteBufferOutputStream pooledByteBufferOutputStream) throws Throwable {
            EncodedImage2 encodedImage2;
            Throwable th;
            CloseableReference closeableReferenceM8632A = CloseableReference.m8632A(((MemoryPooledByteBufferOutputStream) pooledByteBufferOutputStream).m8707b());
            try {
                encodedImage2 = new EncodedImage2(closeableReferenceM8632A);
                try {
                    encodedImage2.m1345q();
                    this.f4179b.mo1424b(encodedImage2, 1);
                    encodedImage2.close();
                    if (closeableReferenceM8632A != null) {
                        closeableReferenceM8632A.close();
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (encodedImage2 != null) {
                        encodedImage2.close();
                    }
                    if (closeableReferenceM8632A != null) {
                        closeableReferenceM8632A.close();
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                encodedImage2 = null;
                th = th3;
            }
        }
    }

    public PartialDiskCacheProducer3(BufferedDiskCache2 bufferedDiskCache2, CacheKeyFactory cacheKeyFactory, PooledByteBufferFactory pooledByteBufferFactory, ByteArrayPool byteArrayPool, Producer2<EncodedImage2> producer2) {
        this.f4191a = bufferedDiskCache2;
        this.f4192b = cacheKeyFactory;
        this.f4193c = pooledByteBufferFactory;
        this.f4194d = byteArrayPool;
        this.f4195e = producer2;
    }

    @VisibleForTesting
    /* JADX INFO: renamed from: c */
    public static Map<String, String> m1511c(ProducerListener2 producerListener2, ProducerContext producerContext, boolean z2, int i) {
        if (producerListener2.mo1360g(producerContext, "PartialDiskCacheProducer")) {
            return z2 ? ImmutableMap.m968of("cached_value_found", String.valueOf(z2), "encodedImageSize", String.valueOf(i)) : ImmutableMap.m967of("cached_value_found", String.valueOf(z2));
        }
        return null;
    }

    @Override // p007b.p109f.p161j.p181p.Producer2
    /* JADX INFO: renamed from: b */
    public void mo1417b(Consumer2<EncodedImage2> consumer2, ProducerContext producerContext) {
        ImageRequest imageRequestMo1447e = producerContext.mo1447e();
        boolean zM8720b = producerContext.mo1447e().m8720b(16);
        ProducerListener2 producerListener2Mo1457o = producerContext.mo1457o();
        producerListener2Mo1457o.mo1358e(producerContext, "PartialDiskCacheProducer");
        Uri uriBuild = imageRequestMo1447e.f19585c.buildUpon().appendQueryParameter("fresco_partial", "true").build();
        CacheKeyFactory cacheKeyFactory = this.f4192b;
        producerContext.mo1444b();
        Objects.requireNonNull((DefaultCacheKeyFactory) cacheKeyFactory);
        SimpleCacheKey simpleCacheKey = new SimpleCacheKey(uriBuild.toString());
        if (!zM8720b) {
            producerListener2Mo1457o.mo1363j(producerContext, "PartialDiskCacheProducer", m1511c(producerListener2Mo1457o, producerContext, false, 0));
            m1512d(consumer2, producerContext, simpleCacheKey, null);
        } else {
            AtomicBoolean atomicBoolean = new AtomicBoolean(false);
            this.f4191a.m1219e(simpleCacheKey, atomicBoolean).m11368b(new PartialDiskCacheProducer(this, producerContext.mo1457o(), producerContext, consumer2, simpleCacheKey));
            producerContext.mo1448f(new PartialDiskCacheProducer2(this, atomicBoolean));
        }
    }

    /* JADX INFO: renamed from: d */
    public final void m1512d(Consumer2<EncodedImage2> consumer2, ProducerContext producerContext, CacheKey cacheKey, EncodedImage2 encodedImage2) {
        this.f4195e.mo1417b(new a(consumer2, this.f4191a, cacheKey, this.f4193c, this.f4194d, encodedImage2, producerContext.mo1447e().m8720b(32), null), producerContext);
    }
}

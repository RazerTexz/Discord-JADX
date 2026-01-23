package p007b.p109f.p161j.p181p;

import com.facebook.cache.common.CacheKey;
import com.facebook.imagepipeline.request.ImageRequest;
import p007b.p109f.p160i.ImageFormat;
import p007b.p109f.p161j.p168c.BufferedDiskCache2;
import p007b.p109f.p161j.p168c.CacheKeyFactory;
import p007b.p109f.p161j.p168c.DefaultCacheKeyFactory;
import p007b.p109f.p161j.p175j.EncodedImage2;

/* JADX INFO: renamed from: b.f.j.p.t, reason: use source file name */
/* JADX INFO: compiled from: DiskCacheWriteProducer.java */
/* JADX INFO: loaded from: classes3.dex */
public class DiskCacheWriteProducer implements Producer2<EncodedImage2> {

    /* JADX INFO: renamed from: a */
    public final BufferedDiskCache2 f4213a;

    /* JADX INFO: renamed from: b */
    public final BufferedDiskCache2 f4214b;

    /* JADX INFO: renamed from: c */
    public final CacheKeyFactory f4215c;

    /* JADX INFO: renamed from: d */
    public final Producer2<EncodedImage2> f4216d;

    /* JADX INFO: renamed from: b.f.j.p.t$b */
    /* JADX INFO: compiled from: DiskCacheWriteProducer.java */
    public static class b extends DelegatingConsumer<EncodedImage2, EncodedImage2> {

        /* JADX INFO: renamed from: c */
        public final ProducerContext f4217c;

        /* JADX INFO: renamed from: d */
        public final BufferedDiskCache2 f4218d;

        /* JADX INFO: renamed from: e */
        public final BufferedDiskCache2 f4219e;

        /* JADX INFO: renamed from: f */
        public final CacheKeyFactory f4220f;

        public b(Consumer2 consumer2, ProducerContext producerContext, BufferedDiskCache2 bufferedDiskCache2, BufferedDiskCache2 bufferedDiskCache22, CacheKeyFactory cacheKeyFactory, a aVar) {
            super(consumer2);
            this.f4217c = producerContext;
            this.f4218d = bufferedDiskCache2;
            this.f4219e = bufferedDiskCache22;
            this.f4220f = cacheKeyFactory;
        }

        @Override // p007b.p109f.p161j.p181p.BaseConsumer
        /* JADX INFO: renamed from: i */
        public void mo1320i(Object obj, int i) {
            EncodedImage2 encodedImage2 = (EncodedImage2) obj;
            this.f4217c.mo1457o().mo1358e(this.f4217c, "DiskCacheWriteProducer");
            if (!BaseConsumer.m1420f(i) && encodedImage2 != null && !BaseConsumer.m1421l(i, 10)) {
                encodedImage2.m1347x();
                if (encodedImage2.f3893l != ImageFormat.f3597a) {
                    ImageRequest imageRequestMo1447e = this.f4217c.mo1447e();
                    CacheKey cacheKeyM1230b = ((DefaultCacheKeyFactory) this.f4220f).m1230b(imageRequestMo1447e, this.f4217c.mo1444b());
                    if (imageRequestMo1447e.f19584b == ImageRequest.EnumC10666b.SMALL) {
                        this.f4219e.m1220f(cacheKeyM1230b, encodedImage2);
                    } else {
                        this.f4218d.m1220f(cacheKeyM1230b, encodedImage2);
                    }
                    this.f4217c.mo1457o().mo1363j(this.f4217c, "DiskCacheWriteProducer", null);
                    this.f4179b.mo1424b(encodedImage2, i);
                    return;
                }
            }
            this.f4217c.mo1457o().mo1363j(this.f4217c, "DiskCacheWriteProducer", null);
            this.f4179b.mo1424b(encodedImage2, i);
        }
    }

    public DiskCacheWriteProducer(BufferedDiskCache2 bufferedDiskCache2, BufferedDiskCache2 bufferedDiskCache22, CacheKeyFactory cacheKeyFactory, Producer2<EncodedImage2> producer2) {
        this.f4213a = bufferedDiskCache2;
        this.f4214b = bufferedDiskCache22;
        this.f4215c = cacheKeyFactory;
        this.f4216d = producer2;
    }

    @Override // p007b.p109f.p161j.p181p.Producer2
    /* JADX INFO: renamed from: b */
    public void mo1417b(Consumer2<EncodedImage2> consumer2, ProducerContext producerContext) {
        if (producerContext.mo1459q().m8722g() >= ImageRequest.EnumC10667c.DISK_CACHE.m8722g()) {
            producerContext.mo1451i("disk", "nil-result_write");
            consumer2.mo1424b(null, 1);
        } else {
            if (producerContext.mo1447e().m8720b(32)) {
                consumer2 = new b(consumer2, producerContext, this.f4213a, this.f4214b, this.f4215c, null);
            }
            this.f4216d.mo1417b(consumer2, producerContext);
        }
    }
}

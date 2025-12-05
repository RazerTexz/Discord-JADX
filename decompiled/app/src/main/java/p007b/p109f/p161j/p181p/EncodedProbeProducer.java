package p007b.p109f.p161j.p181p;

import com.facebook.cache.common.CacheKey;
import com.facebook.imagepipeline.request.ImageRequest;
import p007b.p109f.p160i.ImageFormat;
import p007b.p109f.p161j.p168c.BoundedLinkedHashSet;
import p007b.p109f.p161j.p168c.BufferedDiskCache2;
import p007b.p109f.p161j.p168c.CacheKeyFactory;
import p007b.p109f.p161j.p168c.DefaultCacheKeyFactory;
import p007b.p109f.p161j.p175j.EncodedImage2;
import p007b.p109f.p161j.p183r.FrescoSystrace;

/* compiled from: EncodedProbeProducer.java */
/* renamed from: b.f.j.p.w, reason: use source file name */
/* loaded from: classes3.dex */
public class EncodedProbeProducer implements Producer2<EncodedImage2> {

    /* renamed from: a */
    public final BufferedDiskCache2 f4246a;

    /* renamed from: b */
    public final BufferedDiskCache2 f4247b;

    /* renamed from: c */
    public final CacheKeyFactory f4248c;

    /* renamed from: d */
    public final Producer2<EncodedImage2> f4249d;

    /* renamed from: e */
    public final BoundedLinkedHashSet<CacheKey> f4250e;

    /* renamed from: f */
    public final BoundedLinkedHashSet<CacheKey> f4251f;

    /* compiled from: EncodedProbeProducer.java */
    /* renamed from: b.f.j.p.w$a */
    public static class a extends DelegatingConsumer<EncodedImage2, EncodedImage2> {

        /* renamed from: c */
        public final ProducerContext f4252c;

        /* renamed from: d */
        public final BufferedDiskCache2 f4253d;

        /* renamed from: e */
        public final BufferedDiskCache2 f4254e;

        /* renamed from: f */
        public final CacheKeyFactory f4255f;

        /* renamed from: g */
        public final BoundedLinkedHashSet<CacheKey> f4256g;

        /* renamed from: h */
        public final BoundedLinkedHashSet<CacheKey> f4257h;

        public a(Consumer2<EncodedImage2> consumer2, ProducerContext producerContext, BufferedDiskCache2 bufferedDiskCache2, BufferedDiskCache2 bufferedDiskCache22, CacheKeyFactory cacheKeyFactory, BoundedLinkedHashSet<CacheKey> boundedLinkedHashSet, BoundedLinkedHashSet<CacheKey> boundedLinkedHashSet2) {
            super(consumer2);
            this.f4252c = producerContext;
            this.f4253d = bufferedDiskCache2;
            this.f4254e = bufferedDiskCache22;
            this.f4255f = cacheKeyFactory;
            this.f4256g = boundedLinkedHashSet;
            this.f4257h = boundedLinkedHashSet2;
        }

        @Override // p007b.p109f.p161j.p181p.BaseConsumer
        /* renamed from: i */
        public void mo1320i(Object obj, int i) {
            EncodedImage2 encodedImage2 = (EncodedImage2) obj;
            try {
                FrescoSystrace.m1527b();
                if (BaseConsumer.m1420f(i) || encodedImage2 == null || BaseConsumer.m1421l(i, 10)) {
                    this.f4179b.mo1424b(encodedImage2, i);
                } else {
                    encodedImage2.m1347x();
                    if (encodedImage2.f3893l == ImageFormat.f3597a) {
                        this.f4179b.mo1424b(encodedImage2, i);
                    } else {
                        ImageRequest imageRequestMo1447e = this.f4252c.mo1447e();
                        CacheKey cacheKeyM1230b = ((DefaultCacheKeyFactory) this.f4255f).m1230b(imageRequestMo1447e, this.f4252c.mo1444b());
                        this.f4256g.m1213a(cacheKeyM1230b);
                        if ("memory_encoded".equals(this.f4252c.mo1454l("origin"))) {
                            if (!this.f4257h.m1214b(cacheKeyM1230b)) {
                                (imageRequestMo1447e.f19584b == ImageRequest.EnumC10666b.SMALL ? this.f4254e : this.f4253d).m1217c(cacheKeyM1230b);
                                this.f4257h.m1213a(cacheKeyM1230b);
                            }
                        } else if ("disk".equals(this.f4252c.mo1454l("origin"))) {
                            this.f4257h.m1213a(cacheKeyM1230b);
                        }
                        this.f4179b.mo1424b(encodedImage2, i);
                    }
                }
            } finally {
                FrescoSystrace.m1527b();
            }
        }
    }

    public EncodedProbeProducer(BufferedDiskCache2 bufferedDiskCache2, BufferedDiskCache2 bufferedDiskCache22, CacheKeyFactory cacheKeyFactory, BoundedLinkedHashSet boundedLinkedHashSet, BoundedLinkedHashSet boundedLinkedHashSet2, Producer2<EncodedImage2> producer2) {
        this.f4246a = bufferedDiskCache2;
        this.f4247b = bufferedDiskCache22;
        this.f4248c = cacheKeyFactory;
        this.f4250e = boundedLinkedHashSet;
        this.f4251f = boundedLinkedHashSet2;
        this.f4249d = producer2;
    }

    @Override // p007b.p109f.p161j.p181p.Producer2
    /* renamed from: b */
    public void mo1417b(Consumer2<EncodedImage2> consumer2, ProducerContext producerContext) {
        try {
            FrescoSystrace.m1527b();
            ProducerListener2 producerListener2Mo1457o = producerContext.mo1457o();
            producerListener2Mo1457o.mo1358e(producerContext, "EncodedProbeProducer");
            a aVar = new a(consumer2, producerContext, this.f4246a, this.f4247b, this.f4248c, this.f4250e, this.f4251f);
            producerListener2Mo1457o.mo1363j(producerContext, "EncodedProbeProducer", null);
            FrescoSystrace.m1527b();
            this.f4249d.mo1417b(aVar, producerContext);
            FrescoSystrace.m1527b();
        } finally {
            FrescoSystrace.m1527b();
        }
    }
}

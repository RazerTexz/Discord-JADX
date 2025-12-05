package p007b.p109f.p161j.p181p;

import android.util.Pair;
import com.facebook.cache.common.CacheKey;
import com.facebook.imagepipeline.request.ImageRequest;
import java.io.Closeable;
import p007b.p109f.p161j.p168c.CacheKeyFactory;
import p007b.p109f.p161j.p168c.DefaultCacheKeyFactory;
import p007b.p109f.p161j.p175j.EncodedImage2;

/* compiled from: EncodedCacheKeyMultiplexProducer.java */
/* renamed from: b.f.j.p.u, reason: use source file name */
/* loaded from: classes3.dex */
public class EncodedCacheKeyMultiplexProducer extends MultiplexProducer<Pair<CacheKey, ImageRequest.EnumC10667c>, EncodedImage2> {

    /* renamed from: f */
    public final CacheKeyFactory f4236f;

    public EncodedCacheKeyMultiplexProducer(CacheKeyFactory cacheKeyFactory, boolean z2, Producer2 producer2) {
        super(producer2, "EncodedCacheKeyMultiplexProducer", "multiplex_enc_cnt", z2);
        this.f4236f = cacheKeyFactory;
    }

    @Override // p007b.p109f.p161j.p181p.MultiplexProducer
    /* renamed from: c */
    public Closeable mo1476c(Closeable closeable) {
        return EncodedImage2.m1336a((EncodedImage2) closeable);
    }

    @Override // p007b.p109f.p161j.p181p.MultiplexProducer
    /* renamed from: d */
    public Pair<CacheKey, ImageRequest.EnumC10667c> mo1477d(ProducerContext producerContext) {
        return Pair.create(((DefaultCacheKeyFactory) this.f4236f).m1230b(producerContext.mo1447e(), producerContext.mo1444b()), producerContext.mo1459q());
    }
}

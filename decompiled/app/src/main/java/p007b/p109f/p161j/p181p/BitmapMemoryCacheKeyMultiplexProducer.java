package p007b.p109f.p161j.p181p;

import android.util.Pair;
import com.facebook.cache.common.CacheKey;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.request.ImageRequest;
import java.io.Closeable;
import p007b.p109f.p161j.p168c.CacheKeyFactory;
import p007b.p109f.p161j.p168c.DefaultCacheKeyFactory;
import p007b.p109f.p161j.p175j.CloseableImage;

/* compiled from: BitmapMemoryCacheKeyMultiplexProducer.java */
/* renamed from: b.f.j.p.g, reason: use source file name */
/* loaded from: classes3.dex */
public class BitmapMemoryCacheKeyMultiplexProducer extends MultiplexProducer<Pair<CacheKey, ImageRequest.EnumC10667c>, CloseableReference<CloseableImage>> {

    /* renamed from: f */
    public final CacheKeyFactory f4059f;

    public BitmapMemoryCacheKeyMultiplexProducer(CacheKeyFactory cacheKeyFactory, Producer2 producer2) {
        super(producer2, "BitmapMemoryCacheKeyMultiplexProducer", "multiplex_bmp_cnt");
        this.f4059f = cacheKeyFactory;
    }

    @Override // p007b.p109f.p161j.p181p.MultiplexProducer
    /* renamed from: c */
    public Closeable mo1476c(Closeable closeable) {
        return CloseableReference.m8636n((CloseableReference) closeable);
    }

    @Override // p007b.p109f.p161j.p181p.MultiplexProducer
    /* renamed from: d */
    public Pair<CacheKey, ImageRequest.EnumC10667c> mo1477d(ProducerContext producerContext) {
        return Pair.create(((DefaultCacheKeyFactory) this.f4059f).m1229a(producerContext.mo1447e(), producerContext.mo1444b()), producerContext.mo1459q());
    }
}

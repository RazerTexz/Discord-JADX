package p007b.p109f.p161j.p181p;

import androidx.annotation.VisibleForTesting;
import com.facebook.cache.common.CacheKey;
import com.facebook.imagepipeline.request.ImageRequest;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import p007b.p109f.p115d.p119d.ImmutableMap;
import p007b.p109f.p161j.p168c.BufferedDiskCache2;
import p007b.p109f.p161j.p168c.CacheKeyFactory;
import p007b.p109f.p161j.p168c.DefaultCacheKeyFactory;
import p007b.p109f.p161j.p175j.EncodedImage2;

/* JADX INFO: renamed from: b.f.j.p.s, reason: use source file name */
/* JADX INFO: compiled from: DiskCacheReadProducer.java */
/* JADX INFO: loaded from: classes3.dex */
public class DiskCacheReadProducer3 implements Producer2<EncodedImage2> {

    /* JADX INFO: renamed from: a */
    public final BufferedDiskCache2 f4202a;

    /* JADX INFO: renamed from: b */
    public final BufferedDiskCache2 f4203b;

    /* JADX INFO: renamed from: c */
    public final CacheKeyFactory f4204c;

    /* JADX INFO: renamed from: d */
    public final Producer2<EncodedImage2> f4205d;

    public DiskCacheReadProducer3(BufferedDiskCache2 bufferedDiskCache2, BufferedDiskCache2 bufferedDiskCache22, CacheKeyFactory cacheKeyFactory, Producer2<EncodedImage2> producer2) {
        this.f4202a = bufferedDiskCache2;
        this.f4203b = bufferedDiskCache22;
        this.f4204c = cacheKeyFactory;
        this.f4205d = producer2;
    }

    @VisibleForTesting
    /* JADX INFO: renamed from: c */
    public static Map<String, String> m1516c(ProducerListener2 producerListener2, ProducerContext producerContext, boolean z2, int i) {
        if (producerListener2.mo1360g(producerContext, "DiskCacheProducer")) {
            return z2 ? ImmutableMap.m968of("cached_value_found", String.valueOf(z2), "encodedImageSize", String.valueOf(i)) : ImmutableMap.m967of("cached_value_found", String.valueOf(z2));
        }
        return null;
    }

    @Override // p007b.p109f.p161j.p181p.Producer2
    /* JADX INFO: renamed from: b */
    public void mo1417b(Consumer2<EncodedImage2> consumer2, ProducerContext producerContext) {
        ImageRequest imageRequestMo1447e = producerContext.mo1447e();
        if (!producerContext.mo1447e().m8720b(16)) {
            if (producerContext.mo1459q().m8722g() < ImageRequest.EnumC10667c.DISK_CACHE.m8722g()) {
                this.f4205d.mo1417b(consumer2, producerContext);
                return;
            } else {
                producerContext.mo1451i("disk", "nil-result_read");
                consumer2.mo1424b(null, 1);
                return;
            }
        }
        producerContext.mo1457o().mo1358e(producerContext, "DiskCacheProducer");
        CacheKey cacheKeyM1230b = ((DefaultCacheKeyFactory) this.f4204c).m1230b(imageRequestMo1447e, producerContext.mo1444b());
        BufferedDiskCache2 bufferedDiskCache2 = imageRequestMo1447e.f19584b == ImageRequest.EnumC10666b.SMALL ? this.f4203b : this.f4202a;
        AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        bufferedDiskCache2.m1219e(cacheKeyM1230b, atomicBoolean).m11368b(new DiskCacheReadProducer(this, producerContext.mo1457o(), producerContext, consumer2));
        producerContext.mo1448f(new DiskCacheReadProducer2(this, atomicBoolean));
    }
}

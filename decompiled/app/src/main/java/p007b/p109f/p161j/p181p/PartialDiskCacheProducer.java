package p007b.p109f.p161j.p181p;

import com.facebook.cache.common.CacheKey;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import java.util.concurrent.CancellationException;
import p007b.p085c.p086a.p087a0.AnimatableValueParser;
import p007b.p109f.p161j.p169d.BytesRange;
import p007b.p109f.p161j.p175j.EncodedImage2;
import p686z.Continuation3;
import p686z.Task6;

/* JADX INFO: renamed from: b.f.j.p.p0, reason: use source file name */
/* JADX INFO: compiled from: PartialDiskCacheProducer.java */
/* JADX INFO: loaded from: classes3.dex */
public class PartialDiskCacheProducer implements Continuation3<EncodedImage2, Void> {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ ProducerListener2 f4180a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ ProducerContext f4181b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ Consumer2 f4182c;

    /* JADX INFO: renamed from: d */
    public final /* synthetic */ CacheKey f4183d;

    /* JADX INFO: renamed from: e */
    public final /* synthetic */ PartialDiskCacheProducer3 f4184e;

    public PartialDiskCacheProducer(PartialDiskCacheProducer3 partialDiskCacheProducer3, ProducerListener2 producerListener2, ProducerContext producerContext, Consumer2 consumer2, CacheKey cacheKey) {
        this.f4184e = partialDiskCacheProducer3;
        this.f4180a = producerListener2;
        this.f4181b = producerContext;
        this.f4182c = consumer2;
        this.f4183d = cacheKey;
    }

    @Override // p686z.Continuation3
    /* JADX INFO: renamed from: a */
    public Void mo1510a(Task6<EncodedImage2> task6) throws Exception {
        boolean z2;
        EncodedImage2 encodedImage2;
        synchronized (task6.f27983g) {
            z2 = task6.f27985i;
        }
        if (z2 || (task6.m11370e() && (task6.m11369d() instanceof CancellationException))) {
            this.f4180a.mo1357d(this.f4181b, "PartialDiskCacheProducer", null);
            this.f4182c.mo1426d();
        } else if (task6.m11370e()) {
            this.f4180a.mo1364k(this.f4181b, "PartialDiskCacheProducer", task6.m11369d(), null);
            this.f4184e.m1512d(this.f4182c, this.f4181b, this.f4183d, null);
        } else {
            synchronized (task6.f27983g) {
                encodedImage2 = task6.f27986j;
            }
            EncodedImage2 encodedImage22 = encodedImage2;
            if (encodedImage22 != null) {
                ProducerListener2 producerListener2 = this.f4180a;
                ProducerContext producerContext = this.f4181b;
                producerListener2.mo1363j(producerContext, "PartialDiskCacheProducer", PartialDiskCacheProducer3.m1511c(producerListener2, producerContext, true, encodedImage22.m1344n()));
                int iM1344n = encodedImage22.m1344n() - 1;
                AnimatableValueParser.m527i(Boolean.valueOf(iM1344n > 0));
                encodedImage22.f3900s = new BytesRange(0, iM1344n);
                int iM1344n2 = encodedImage22.m1344n();
                ImageRequest imageRequestMo1447e = this.f4181b.mo1447e();
                BytesRange bytesRange = imageRequestMo1447e.f19594l;
                if (bytesRange != null && bytesRange.f3704a >= 0 && iM1344n >= bytesRange.f3705b) {
                    this.f4181b.mo1451i("disk", "partial");
                    this.f4180a.mo1356c(this.f4181b, "PartialDiskCacheProducer", true);
                    this.f4182c.mo1424b(encodedImage22, 9);
                } else {
                    this.f4182c.mo1424b(encodedImage22, 8);
                    ImageRequestBuilder imageRequestBuilderM8723b = ImageRequestBuilder.m8723b(imageRequestMo1447e.f19585c);
                    imageRequestBuilderM8723b.f19617f = imageRequestMo1447e.f19591i;
                    imageRequestBuilderM8723b.f19626o = imageRequestMo1447e.f19594l;
                    imageRequestBuilderM8723b.f19618g = imageRequestMo1447e.f19584b;
                    imageRequestBuilderM8723b.f19620i = imageRequestMo1447e.f19589g;
                    imageRequestBuilderM8723b.f19621j = imageRequestMo1447e.f19590h;
                    imageRequestBuilderM8723b.f19613b = imageRequestMo1447e.f19596n;
                    imageRequestBuilderM8723b.f19614c = imageRequestMo1447e.f19597o;
                    imageRequestBuilderM8723b.f19623l = imageRequestMo1447e.f19601s;
                    imageRequestBuilderM8723b.f19619h = imageRequestMo1447e.f19588f;
                    imageRequestBuilderM8723b.f19622k = imageRequestMo1447e.f19595m;
                    imageRequestBuilderM8723b.f19615d = imageRequestMo1447e.f19592j;
                    imageRequestBuilderM8723b.f19625n = imageRequestMo1447e.f19602t;
                    imageRequestBuilderM8723b.f19616e = imageRequestMo1447e.f19593k;
                    imageRequestBuilderM8723b.f19624m = imageRequestMo1447e.f19600r;
                    imageRequestBuilderM8723b.f19627p = imageRequestMo1447e.f19603u;
                    int i = iM1344n2 - 1;
                    AnimatableValueParser.m527i(Boolean.valueOf(i >= 0));
                    imageRequestBuilderM8723b.f19626o = new BytesRange(i, Integer.MAX_VALUE);
                    this.f4184e.m1512d(this.f4182c, new SettableProducerContext(imageRequestBuilderM8723b.m8724a(), this.f4181b), this.f4183d, encodedImage22);
                }
            } else {
                ProducerListener2 producerListener22 = this.f4180a;
                ProducerContext producerContext2 = this.f4181b;
                producerListener22.mo1363j(producerContext2, "PartialDiskCacheProducer", PartialDiskCacheProducer3.m1511c(producerListener22, producerContext2, false, 0));
                this.f4184e.m1512d(this.f4182c, this.f4181b, this.f4183d, encodedImage22);
            }
        }
        return null;
    }
}

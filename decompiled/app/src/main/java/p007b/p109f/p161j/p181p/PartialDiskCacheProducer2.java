package p007b.p109f.p161j.p181p;

import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: PartialDiskCacheProducer.java */
/* renamed from: b.f.j.p.q0, reason: use source file name */
/* loaded from: classes3.dex */
public class PartialDiskCacheProducer2 extends BaseProducerContextCallbacks {

    /* renamed from: a */
    public final /* synthetic */ AtomicBoolean f4189a;

    public PartialDiskCacheProducer2(PartialDiskCacheProducer3 partialDiskCacheProducer3, AtomicBoolean atomicBoolean) {
        this.f4189a = atomicBoolean;
    }

    @Override // p007b.p109f.p161j.p181p.ProducerContextCallbacks
    /* renamed from: a */
    public void mo1438a() {
        this.f4189a.set(true);
    }
}

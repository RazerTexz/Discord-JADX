package p007b.p109f.p161j.p181p;

import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: renamed from: b.f.j.p.q0, reason: use source file name */
/* JADX INFO: compiled from: PartialDiskCacheProducer.java */
/* JADX INFO: loaded from: classes3.dex */
public class PartialDiskCacheProducer2 extends BaseProducerContextCallbacks {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ AtomicBoolean f4189a;

    public PartialDiskCacheProducer2(PartialDiskCacheProducer3 partialDiskCacheProducer3, AtomicBoolean atomicBoolean) {
        this.f4189a = atomicBoolean;
    }

    @Override // p007b.p109f.p161j.p181p.ProducerContextCallbacks
    /* JADX INFO: renamed from: a */
    public void mo1438a() {
        this.f4189a.set(true);
    }
}

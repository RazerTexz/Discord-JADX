package p007b.p109f.p161j.p181p;

import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: DiskCacheReadProducer.java */
/* renamed from: b.f.j.p.r, reason: use source file name */
/* loaded from: classes3.dex */
public class DiskCacheReadProducer2 extends BaseProducerContextCallbacks {

    /* renamed from: a */
    public final /* synthetic */ AtomicBoolean f4190a;

    public DiskCacheReadProducer2(DiskCacheReadProducer3 diskCacheReadProducer3, AtomicBoolean atomicBoolean) {
        this.f4190a = atomicBoolean;
    }

    @Override // p007b.p109f.p161j.p181p.ProducerContextCallbacks
    /* renamed from: a */
    public void mo1438a() {
        this.f4190a.set(true);
    }
}

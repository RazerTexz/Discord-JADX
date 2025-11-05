package b.f.j.p;

import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: DiskCacheReadProducer.java */
/* loaded from: classes3.dex */
public class r extends e {
    public final /* synthetic */ AtomicBoolean a;

    public r(s sVar, AtomicBoolean atomicBoolean) {
        this.a = atomicBoolean;
    }

    @Override // b.f.j.p.y0
    public void a() {
        this.a.set(true);
    }
}

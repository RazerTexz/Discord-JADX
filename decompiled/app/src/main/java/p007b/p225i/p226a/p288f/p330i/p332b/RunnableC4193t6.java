package p007b.p225i.p226a.p288f.p330i.p332b;

import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* renamed from: b.i.a.f.i.b.t6 */
/* loaded from: classes3.dex */
public final class RunnableC4193t6 implements Runnable {

    /* renamed from: j */
    public final /* synthetic */ AtomicReference f11227j;

    /* renamed from: k */
    public final /* synthetic */ C3999c6 f11228k;

    public RunnableC4193t6(C3999c6 c3999c6, AtomicReference atomicReference) {
        this.f11228k = c3999c6;
        this.f11227j = atomicReference;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (this.f11227j) {
            try {
                AtomicReference atomicReference = this.f11227j;
                C3999c6 c3999c6 = this.f11228k;
                C3992c c3992c = c3999c6.f11202a.f11260h;
                C4124n3 c4124n3M5970o = c3999c6.m5970o();
                c4124n3M5970o.m5497t();
                atomicReference.set(Long.valueOf(c3992c.m5525n(c4124n3M5970o.f10979c, C4142p.f11044M)));
            } finally {
                this.f11227j.notify();
            }
        }
    }
}

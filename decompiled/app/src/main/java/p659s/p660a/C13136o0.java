package p659s.p660a;

import kotlin.Unit;
import kotlinx.coroutines.Job;
import p007b.p100d.p104b.p105a.outline;

/* compiled from: JobSupport.kt */
/* renamed from: s.a.o0 */
/* loaded from: classes3.dex */
public final class C13136o0 extends AbstractC13113g1<Job> {

    /* renamed from: n */
    public final Job2 f27879n;

    public C13136o0(Job job, Job2 job2) {
        super(job);
        this.f27879n = job2;
    }

    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(Throwable th) {
        this.f27879n.dispose();
        return Unit.f27425a;
    }

    @Override // p659s.p660a.CompletionHandler2
    /* renamed from: q */
    public void mo11198q(Throwable th) {
        this.f27879n.dispose();
    }

    @Override // p659s.p660a.p661a.LockFreeLinkedList3
    public String toString() {
        StringBuilder sbM833U = outline.m833U("DisposeOnCompletion[");
        sbM833U.append(this.f27879n);
        sbM833U.append(']');
        return sbM833U.toString();
    }
}

package p659s.p660a;

import kotlin.Unit;
import p007b.p100d.p104b.p105a.outline;

/* JADX INFO: renamed from: s.a.n0, reason: use source file name */
/* JADX INFO: compiled from: CancellableContinuation.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class CancellableContinuation2 extends CancellableContinuationImpl4 {

    /* JADX INFO: renamed from: j */
    public final Job2 f27876j;

    public CancellableContinuation2(Job2 job2) {
        this.f27876j = job2;
    }

    @Override // p659s.p660a.CompletionHandler
    /* JADX INFO: renamed from: a */
    public void mo11193a(Throwable th) {
        this.f27876j.dispose();
    }

    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(Throwable th) {
        this.f27876j.dispose();
        return Unit.f27425a;
    }

    public String toString() {
        StringBuilder sbM833U = outline.m833U("DisposeOnCancel[");
        sbM833U.append(this.f27876j);
        sbM833U.append(']');
        return sbM833U.toString();
    }
}

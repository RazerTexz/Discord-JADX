package p659s.p660a;

import kotlin.Unit;
import p007b.p100d.p104b.p105a.outline;
import p659s.p660a.p661a.LockFreeLinkedList3;

/* JADX INFO: renamed from: s.a.r1, reason: use source file name */
/* JADX INFO: compiled from: CancellableContinuation.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class CancellableContinuation3 extends CancellableContinuationImpl3 {

    /* JADX INFO: renamed from: j */
    public final LockFreeLinkedList3 f27896j;

    public CancellableContinuation3(LockFreeLinkedList3 lockFreeLinkedList3) {
        this.f27896j = lockFreeLinkedList3;
    }

    @Override // p659s.p660a.CompletionHandler
    /* JADX INFO: renamed from: a */
    public void mo11193a(Throwable th) {
        this.f27896j.mo11151n();
    }

    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(Throwable th) {
        this.f27896j.mo11151n();
        return Unit.f27425a;
    }

    public String toString() {
        StringBuilder sbM833U = outline.m833U("RemoveOnCancel[");
        sbM833U.append(this.f27896j);
        sbM833U.append(']');
        return sbM833U.toString();
    }
}

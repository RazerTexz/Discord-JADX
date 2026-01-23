package p659s.p660a;

import kotlin.Unit;
import p007b.p100d.p104b.p105a.outline;

/* JADX INFO: renamed from: s.a.i, reason: use source file name */
/* JADX INFO: compiled from: Future.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class Future extends CancellableContinuationImpl4 {

    /* JADX INFO: renamed from: j */
    public final java.util.concurrent.Future<?> f27855j;

    public Future(java.util.concurrent.Future<?> future) {
        this.f27855j = future;
    }

    @Override // p659s.p660a.CompletionHandler
    /* JADX INFO: renamed from: a */
    public void mo11193a(Throwable th) {
        this.f27855j.cancel(false);
    }

    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(Throwable th) {
        this.f27855j.cancel(false);
        return Unit.f27425a;
    }

    public String toString() {
        StringBuilder sbM833U = outline.m833U("CancelFutureOnCancel[");
        sbM833U.append(this.f27855j);
        sbM833U.append(']');
        return sbM833U.toString();
    }
}

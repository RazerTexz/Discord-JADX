package p007b.p100d.p101a.p102a;

import java.util.concurrent.Future;
import p007b.p225i.p226a.p288f.p313h.p327n.C3941a;

/* JADX INFO: renamed from: b.d.a.a.a0 */
/* JADX INFO: compiled from: com.android.billingclient:billing@@4.0.0 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class RunnableC1615a0 implements Runnable {

    /* JADX INFO: renamed from: j */
    public final /* synthetic */ Future f2948j;

    /* JADX INFO: renamed from: k */
    public final /* synthetic */ Runnable f2949k;

    public /* synthetic */ RunnableC1615a0(Future future, Runnable runnable) {
        this.f2948j = future;
        this.f2949k = runnable;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Future future = this.f2948j;
        Runnable runnable = this.f2949k;
        if (future.isDone() || future.isCancelled()) {
            return;
        }
        future.cancel(true);
        C3941a.m5416f("BillingClient", "Async task is taking too long, cancel it!");
        if (runnable != null) {
            runnable.run();
        }
    }
}

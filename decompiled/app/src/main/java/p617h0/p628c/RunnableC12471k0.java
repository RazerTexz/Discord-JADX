package p617h0.p628c;

import java.util.concurrent.CountDownLatch;

/* JADX INFO: renamed from: h0.c.k0 */
/* JADX INFO: compiled from: lambda */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class RunnableC12471k0 implements Runnable {

    /* JADX INFO: renamed from: j */
    public final /* synthetic */ CountDownLatch f26445j;

    public /* synthetic */ RunnableC12471k0(CountDownLatch countDownLatch) {
        this.f26445j = countDownLatch;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f26445j.countDown();
    }
}

package p686z;

import java.util.concurrent.CancellationException;

/* JADX INFO: renamed from: z.e, reason: use source file name */
/* JADX INFO: compiled from: Task.java */
/* JADX INFO: loaded from: classes.dex */
public final class Task4 implements Runnable {

    /* JADX INFO: renamed from: j */
    public final /* synthetic */ TaskCompletionSource2 f27972j;

    /* JADX INFO: renamed from: k */
    public final /* synthetic */ Continuation3 f27973k;

    /* JADX INFO: renamed from: l */
    public final /* synthetic */ Task6 f27974l;

    public Task4(TaskCompletionSource2 taskCompletionSource2, Continuation3 continuation3, Task6 task6) {
        this.f27972j = taskCompletionSource2;
        this.f27973k = continuation3;
        this.f27974l = task6;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            this.f27972j.m11376c(this.f27973k.mo1510a(this.f27974l));
        } catch (CancellationException unused) {
            this.f27972j.m11374a();
        } catch (Exception e) {
            this.f27972j.m11375b(e);
        }
    }
}

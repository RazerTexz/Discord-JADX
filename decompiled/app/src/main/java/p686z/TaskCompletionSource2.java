package p686z;

/* JADX INFO: renamed from: z.h, reason: use source file name */
/* JADX INFO: compiled from: TaskCompletionSource.java */
/* JADX INFO: loaded from: classes.dex */
public class TaskCompletionSource2<TResult> {

    /* JADX INFO: renamed from: a */
    public final Task6<TResult> f27990a = new Task6<>();

    /* JADX INFO: renamed from: a */
    public void m11374a() {
        if (!this.f27990a.m11372g()) {
            throw new IllegalStateException("Cannot cancel a completed task.");
        }
    }

    /* JADX INFO: renamed from: b */
    public void m11375b(Exception exc) {
        boolean z2;
        Task6<TResult> task6 = this.f27990a;
        synchronized (task6.f27983g) {
            z2 = false;
            if (!task6.f27984h) {
                task6.f27984h = true;
                task6.f27987k = exc;
                task6.f27988l = false;
                task6.f27983g.notifyAll();
                task6.m11371f();
                z2 = true;
            }
        }
        if (!z2) {
            throw new IllegalStateException("Cannot set the error on a completed task.");
        }
    }

    /* JADX INFO: renamed from: c */
    public void m11376c(TResult tresult) {
        if (!this.f27990a.m11373h(tresult)) {
            throw new IllegalStateException("Cannot set the result of a completed task.");
        }
    }
}

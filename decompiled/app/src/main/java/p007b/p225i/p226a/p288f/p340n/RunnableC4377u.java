package p007b.p225i.p226a.p288f.p340n;

import com.google.android.gms.tasks.Task;

/* compiled from: com.google.android.gms:play-services-tasks@@17.2.1 */
/* renamed from: b.i.a.f.n.u */
/* loaded from: classes3.dex */
public final class RunnableC4377u implements Runnable {

    /* renamed from: j */
    public final /* synthetic */ Task f11514j;

    /* renamed from: k */
    public final /* synthetic */ C4378v f11515k;

    public RunnableC4377u(C4378v c4378v, Task task) {
        this.f11515k = c4378v;
        this.f11514j = task;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (this.f11515k.f11517b) {
            InterfaceC4361e<? super TResult> interfaceC4361e = this.f11515k.f11518c;
            if (interfaceC4361e != 0) {
                interfaceC4361e.onSuccess(this.f11514j.mo6017l());
            }
        }
    }
}

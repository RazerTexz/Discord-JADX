package p007b.p225i.p226a.p288f.p340n;

import com.google.android.gms.tasks.RuntimeExecutionException;
import com.google.android.gms.tasks.Task;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-tasks@@17.2.1 */
/* renamed from: b.i.a.f.n.m */
/* loaded from: classes3.dex */
public final class RunnableC4369m implements Runnable {

    /* renamed from: j */
    public final /* synthetic */ Task f11495j;

    /* renamed from: k */
    public final /* synthetic */ C4370n f11496k;

    public RunnableC4369m(C4370n c4370n, Task task) {
        this.f11496k = c4370n;
        this.f11495j = task;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            Task task = (Task) this.f11496k.f11498b.mo4012a(this.f11495j);
            if (task == null) {
                C4370n c4370n = this.f11496k;
                c4370n.f11499c.m6025t(new NullPointerException("Continuation returned null"));
            } else {
                Executor executor = C4363g.f11480b;
                task.mo6012g(executor, this.f11496k);
                task.mo6010e(executor, this.f11496k);
                task.mo6006a(executor, this.f11496k);
            }
        } catch (RuntimeExecutionException e) {
            if (e.getCause() instanceof Exception) {
                this.f11496k.f11499c.m6025t((Exception) e.getCause());
            } else {
                this.f11496k.f11499c.m6025t(e);
            }
        } catch (Exception e2) {
            this.f11496k.f11499c.m6025t(e2);
        }
    }
}

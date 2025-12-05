package p007b.p225i.p226a.p288f.p340n;

import com.google.android.gms.tasks.RuntimeExecutionException;
import com.google.android.gms.tasks.Task;

/* compiled from: com.google.android.gms:play-services-tasks@@17.2.1 */
/* renamed from: b.i.a.f.n.k */
/* loaded from: classes3.dex */
public final class RunnableC4367k implements Runnable {

    /* renamed from: j */
    public final /* synthetic */ Task f11490j;

    /* renamed from: k */
    public final /* synthetic */ C4368l f11491k;

    public RunnableC4367k(C4368l c4368l, Task task) {
        this.f11491k = c4368l;
        this.f11490j = task;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.f11490j.mo6019n()) {
            this.f11491k.f11494c.m6026u();
            return;
        }
        try {
            this.f11491k.f11494c.m6024s(this.f11491k.f11493b.mo4012a(this.f11490j));
        } catch (RuntimeExecutionException e) {
            if (e.getCause() instanceof Exception) {
                this.f11491k.f11494c.m6025t((Exception) e.getCause());
            } else {
                this.f11491k.f11494c.m6025t(e);
            }
        } catch (Exception e2) {
            this.f11491k.f11494c.m6025t(e2);
        }
    }
}

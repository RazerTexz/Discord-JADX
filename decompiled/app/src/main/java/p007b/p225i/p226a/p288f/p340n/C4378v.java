package p007b.p225i.p226a.p288f.p340n;

import androidx.annotation.NonNull;
import com.google.android.gms.tasks.Task;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-tasks@@17.2.1 */
/* renamed from: b.i.a.f.n.v */
/* loaded from: classes3.dex */
public final class C4378v<TResult> implements InterfaceC4381y<TResult> {

    /* renamed from: a */
    public final Executor f11516a;

    /* renamed from: b */
    public final Object f11517b = new Object();

    /* renamed from: c */
    public InterfaceC4361e<? super TResult> f11518c;

    public C4378v(@NonNull Executor executor, @NonNull InterfaceC4361e<? super TResult> interfaceC4361e) {
        this.f11516a = executor;
        this.f11518c = interfaceC4361e;
    }

    @Override // p007b.p225i.p226a.p288f.p340n.InterfaceC4381y
    /* renamed from: a */
    public final void mo6030a(@NonNull Task<TResult> task) {
        if (task.mo6021p()) {
            synchronized (this.f11517b) {
                if (this.f11518c == null) {
                    return;
                }
                this.f11516a.execute(new RunnableC4377u(this, task));
            }
        }
    }
}

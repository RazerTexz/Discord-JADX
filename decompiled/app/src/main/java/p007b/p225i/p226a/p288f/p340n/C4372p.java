package p007b.p225i.p226a.p288f.p340n;

import androidx.annotation.NonNull;
import com.google.android.gms.tasks.Task;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-tasks@@17.2.1 */
/* renamed from: b.i.a.f.n.p */
/* loaded from: classes3.dex */
public final class C4372p<TResult> implements InterfaceC4381y<TResult> {

    /* renamed from: a */
    public final Executor f11501a;

    /* renamed from: b */
    public final Object f11502b = new Object();

    /* renamed from: c */
    public InterfaceC4355b f11503c;

    public C4372p(@NonNull Executor executor, @NonNull InterfaceC4355b interfaceC4355b) {
        this.f11501a = executor;
        this.f11503c = interfaceC4355b;
    }

    @Override // p007b.p225i.p226a.p288f.p340n.InterfaceC4381y
    /* renamed from: a */
    public final void mo6030a(@NonNull Task<TResult> task) {
        if (task.mo6019n()) {
            synchronized (this.f11502b) {
                if (this.f11503c == null) {
                    return;
                }
                this.f11501a.execute(new RunnableC4371o(this));
            }
        }
    }
}

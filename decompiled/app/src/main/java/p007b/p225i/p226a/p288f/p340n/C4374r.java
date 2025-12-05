package p007b.p225i.p226a.p288f.p340n;

import androidx.annotation.NonNull;
import com.google.android.gms.tasks.Task;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-tasks@@17.2.1 */
/* renamed from: b.i.a.f.n.r */
/* loaded from: classes3.dex */
public final class C4374r<TResult> implements InterfaceC4381y<TResult> {

    /* renamed from: a */
    public final Executor f11506a;

    /* renamed from: b */
    public final Object f11507b = new Object();

    /* renamed from: c */
    public InterfaceC4357c<TResult> f11508c;

    public C4374r(@NonNull Executor executor, @NonNull InterfaceC4357c<TResult> interfaceC4357c) {
        this.f11506a = executor;
        this.f11508c = interfaceC4357c;
    }

    @Override // p007b.p225i.p226a.p288f.p340n.InterfaceC4381y
    /* renamed from: a */
    public final void mo6030a(@NonNull Task<TResult> task) {
        synchronized (this.f11507b) {
            if (this.f11508c == null) {
                return;
            }
            this.f11506a.execute(new RunnableC4373q(this, task));
        }
    }
}

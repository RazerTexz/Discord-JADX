package p007b.p225i.p226a.p288f.p340n;

import androidx.annotation.NonNull;
import com.google.android.gms.tasks.Task;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-tasks@@17.2.1 */
/* renamed from: b.i.a.f.n.l */
/* loaded from: classes3.dex */
public final class C4368l<TResult, TContinuationResult> implements InterfaceC4381y<TResult> {

    /* renamed from: a */
    public final Executor f11492a;

    /* renamed from: b */
    public final InterfaceC4353a<TResult, TContinuationResult> f11493b;

    /* renamed from: c */
    public final C4358c0<TContinuationResult> f11494c;

    public C4368l(@NonNull Executor executor, @NonNull InterfaceC4353a<TResult, TContinuationResult> interfaceC4353a, @NonNull C4358c0<TContinuationResult> c4358c0) {
        this.f11492a = executor;
        this.f11493b = interfaceC4353a;
        this.f11494c = c4358c0;
    }

    @Override // p007b.p225i.p226a.p288f.p340n.InterfaceC4381y
    /* renamed from: a */
    public final void mo6030a(@NonNull Task<TResult> task) {
        this.f11492a.execute(new RunnableC4367k(this, task));
    }
}

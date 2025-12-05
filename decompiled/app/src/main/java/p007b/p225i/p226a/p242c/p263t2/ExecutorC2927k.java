package p007b.p225i.p226a.p242c.p263t2;

import android.os.Handler;
import java.util.concurrent.Executor;

/* compiled from: lambda */
/* renamed from: b.i.a.c.t2.k */
/* loaded from: classes3.dex */
public final /* synthetic */ class ExecutorC2927k implements Executor {

    /* renamed from: j */
    public final /* synthetic */ Handler f7763j;

    public /* synthetic */ ExecutorC2927k(Handler handler) {
        this.f7763j = handler;
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        this.f7763j.post(runnable);
    }
}

package p007b.p225i.p226a.p288f.p340n;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import java.util.concurrent.Executor;
import p007b.p225i.p226a.p288f.p313h.p329p.HandlerC3966a;

/* compiled from: com.google.android.gms:play-services-tasks@@17.2.1 */
/* renamed from: b.i.a.f.n.b0 */
/* loaded from: classes3.dex */
public final class ExecutorC4356b0 implements Executor {

    /* renamed from: j */
    public final Handler f11470j = new HandlerC3966a(Looper.getMainLooper());

    @Override // java.util.concurrent.Executor
    public final void execute(@NonNull Runnable runnable) {
        this.f11470j.post(runnable);
    }
}

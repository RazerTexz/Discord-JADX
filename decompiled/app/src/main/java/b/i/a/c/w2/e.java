package b.i.a.c.w2;

import android.os.Looper;
import b.i.a.c.j1;
import com.google.android.exoplayer2.drm.DefaultDrmSessionManager;
import java.util.Objects;

/* compiled from: lambda */
/* loaded from: classes3.dex */
public final /* synthetic */ class e implements Runnable {
    public final /* synthetic */ DefaultDrmSessionManager.d j;
    public final /* synthetic */ j1 k;

    public /* synthetic */ e(DefaultDrmSessionManager.d dVar, j1 j1Var) {
        this.j = dVar;
        this.k = j1Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        DefaultDrmSessionManager.d dVar = this.j;
        j1 j1Var = this.k;
        DefaultDrmSessionManager defaultDrmSessionManager = DefaultDrmSessionManager.this;
        if (defaultDrmSessionManager.p == 0 || dVar.d) {
            return;
        }
        Looper looper = defaultDrmSessionManager.t;
        Objects.requireNonNull(looper);
        dVar.c = defaultDrmSessionManager.e(looper, dVar.f2932b, j1Var, false);
        DefaultDrmSessionManager.this.n.add(dVar);
    }
}

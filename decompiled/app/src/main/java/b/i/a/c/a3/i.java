package b.i.a.c.a3;

import b.i.a.c.a3.x;
import java.util.Objects;

/* compiled from: lambda */
/* loaded from: classes3.dex */
public final /* synthetic */ class i implements Runnable {
    public final /* synthetic */ e0 j;

    public /* synthetic */ i(e0 e0Var) {
        this.j = e0Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        e0 e0Var = this.j;
        if (e0Var.W) {
            return;
        }
        x.a aVar = e0Var.B;
        Objects.requireNonNull(aVar);
        aVar.a(e0Var);
    }
}

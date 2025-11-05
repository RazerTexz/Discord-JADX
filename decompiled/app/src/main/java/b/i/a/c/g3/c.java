package b.i.a.c.g3;

import b.i.a.c.f3.e0;
import b.i.a.c.g3.x;
import java.util.Objects;

/* compiled from: lambda */
/* loaded from: classes3.dex */
public final /* synthetic */ class c implements Runnable {
    public final /* synthetic */ x.a j;
    public final /* synthetic */ b.i.a.c.v2.e k;

    public /* synthetic */ c(x.a aVar, b.i.a.c.v2.e eVar) {
        this.j = aVar;
        this.k = eVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        x.a aVar = this.j;
        b.i.a.c.v2.e eVar = this.k;
        Objects.requireNonNull(aVar);
        synchronized (eVar) {
        }
        x xVar = aVar.f995b;
        int i = e0.a;
        xVar.Z(eVar);
    }
}

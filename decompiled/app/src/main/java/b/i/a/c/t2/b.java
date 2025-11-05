package b.i.a.c.t2;

import b.i.a.c.t2.r;
import java.util.Objects;

/* compiled from: lambda */
/* loaded from: classes3.dex */
public final /* synthetic */ class b implements Runnable {
    public final /* synthetic */ r.a j;
    public final /* synthetic */ b.i.a.c.v2.e k;

    public /* synthetic */ b(r.a aVar, b.i.a.c.v2.e eVar) {
        this.j = aVar;
        this.k = eVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        r.a aVar = this.j;
        b.i.a.c.v2.e eVar = this.k;
        Objects.requireNonNull(aVar);
        synchronized (eVar) {
        }
        r rVar = aVar.f1126b;
        int i = b.i.a.c.f3.e0.a;
        rVar.k(eVar);
    }
}

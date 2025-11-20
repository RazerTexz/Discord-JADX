package b.i.a.c.f3;

import b.i.a.c.f3.n;
import b.i.a.c.f3.p;
import java.util.concurrent.CopyOnWriteArraySet;

/* compiled from: lambda */
/* loaded from: classes3.dex */
public final /* synthetic */ class a implements Runnable {
    public final /* synthetic */ CopyOnWriteArraySet j;
    public final /* synthetic */ int k;
    public final /* synthetic */ p.a l;

    public /* synthetic */ a(CopyOnWriteArraySet copyOnWriteArraySet, int i, p.a aVar) {
        this.j = copyOnWriteArraySet;
        this.k = i;
        this.l = aVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        CopyOnWriteArraySet<p.c> copyOnWriteArraySet = this.j;
        int i = this.k;
        p.a aVar = this.l;
        for (p.c cVar : copyOnWriteArraySet) {
            if (!cVar.d) {
                if (i != -1) {
                    n.b bVar = cVar.f974b;
                    b.c.a.a0.d.D(!bVar.f972b);
                    bVar.a.append(i, true);
                }
                cVar.c = true;
                aVar.invoke(cVar.a);
            }
        }
    }
}

package b.o.a.n.v;

import b.o.a.n.v.a;
import java.util.Iterator;

/* compiled from: CameraOrchestrator.java */
/* loaded from: classes3.dex */
public class b implements Runnable {
    public final /* synthetic */ a j;

    public b(a aVar) {
        this.j = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        a.c<?> cVar;
        synchronized (this.j.e) {
            cVar = null;
            if (!this.j.d) {
                long jCurrentTimeMillis = System.currentTimeMillis();
                Iterator<a.c<?>> it = this.j.c.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    a.c<?> next = it.next();
                    if (next.e <= jCurrentTimeMillis) {
                        cVar = next;
                        break;
                    }
                }
                if (cVar != null) {
                    this.j.d = true;
                }
            }
        }
        if (cVar != null) {
            a aVar = this.j;
            b.o.a.r.g gVar = b.o.a.n.i.this.k;
            gVar.c(new c(aVar, cVar, gVar));
        }
    }
}

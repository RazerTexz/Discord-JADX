package b.o.a.n.v;

import androidx.annotation.NonNull;
import b.o.a.n.v.a;
import com.google.android.gms.tasks.Task;
import java.util.concurrent.CancellationException;

/* compiled from: CameraOrchestrator.java */
/* loaded from: classes3.dex */
public class c implements Runnable {
    public final /* synthetic */ a.c j;
    public final /* synthetic */ b.o.a.r.g k;
    public final /* synthetic */ b.o.a.n.v.a l;

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: CameraOrchestrator.java */
    public class a<T> implements b.i.a.f.n.c<T> {
        public a() {
        }

        @Override // b.i.a.f.n.c
        public void onComplete(@NonNull Task<T> task) {
            Exception excK = task.k();
            if (excK != null) {
                b.o.a.n.v.a.a.a(2, c.this.j.a.toUpperCase(), "- Finished with ERROR.", excK);
                c cVar = c.this;
                if (cVar.j.d) {
                    b.o.a.n.i.b(b.o.a.n.i.this, excK, false);
                }
                c.this.j.f1942b.a(excK);
            } else if (task.n()) {
                b.o.a.n.v.a.a.a(1, c.this.j.a.toUpperCase(), "- Finished because ABORTED.");
                c.this.j.f1942b.a(new CancellationException());
            } else {
                b.o.a.n.v.a.a.a(1, c.this.j.a.toUpperCase(), "- Finished.");
                c.this.j.f1942b.b(task.l());
            }
            synchronized (c.this.l.e) {
                c cVar2 = c.this;
                b.o.a.n.v.a.a(cVar2.l, cVar2.j);
            }
        }
    }

    public c(b.o.a.n.v.a aVar, a.c cVar, b.o.a.r.g gVar) {
        this.l = aVar;
        this.j = cVar;
        this.k = gVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            b.o.a.n.v.a.a.a(1, this.j.a.toUpperCase(), "- Executing.");
            Task task = (Task) this.j.c.call();
            b.o.a.r.g gVar = this.k;
            a aVar = new a();
            if (task.o()) {
                gVar.c(new d(aVar, task));
            } else {
                task.c(gVar.g, aVar);
            }
        } catch (Exception e) {
            b.o.a.n.v.a.a.a(1, this.j.a.toUpperCase(), "- Finished with ERROR.", e);
            if (this.j.d) {
                b.o.a.n.i.b(b.o.a.n.i.this, e, false);
            }
            this.j.f1942b.a(e);
            synchronized (this.l.e) {
                b.o.a.n.v.a.a(this.l, this.j);
            }
        }
    }
}

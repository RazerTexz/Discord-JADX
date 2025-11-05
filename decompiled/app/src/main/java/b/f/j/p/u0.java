package b.f.j.p;

import b.f.j.p.t0;
import com.facebook.common.references.CloseableReference;

/* compiled from: PostprocessorProducer.java */
/* loaded from: classes3.dex */
public class u0 implements Runnable {
    public final /* synthetic */ t0.b j;

    public u0(t0.b bVar) {
        this.j = bVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        CloseableReference<b.f.j.j.c> closeableReference;
        int i;
        boolean zS;
        synchronized (this.j) {
            t0.b bVar = this.j;
            closeableReference = bVar.g;
            i = bVar.h;
            bVar.g = null;
            bVar.i = false;
        }
        if (CloseableReference.y(closeableReference)) {
            try {
                t0.b.n(this.j, closeableReference, i);
                closeableReference.close();
            } catch (Throwable th) {
                if (closeableReference != null) {
                    closeableReference.close();
                }
                throw th;
            }
        }
        t0.b bVar2 = this.j;
        synchronized (bVar2) {
            bVar2.j = false;
            zS = bVar2.s();
        }
        if (zS) {
            t0.this.c.execute(new u0(bVar2));
        }
    }
}

package j0.l.a;

import j0.l.a.y1;
import rx.Producer;

/* compiled from: OperatorSwitch.java */
/* loaded from: classes3.dex */
public class a2 implements Producer {
    public final /* synthetic */ y1.c j;

    public a2(y1.c cVar) {
        this.j = cVar;
    }

    @Override // rx.Producer
    public void j(long j) {
        Producer producer;
        if (j <= 0) {
            if (j < 0) {
                throw new IllegalArgumentException(b.d.b.a.a.t("n >= 0 expected but it was ", j));
            }
            return;
        }
        y1.c cVar = this.j;
        synchronized (cVar) {
            producer = cVar.f3783s;
            cVar.r = b.i.a.f.e.o.f.f(cVar.r, j);
        }
        if (producer != null) {
            producer.j(j);
        }
        cVar.b();
    }
}

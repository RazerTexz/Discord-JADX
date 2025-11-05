package j0.l.a;

import j0.l.a.z0;
import rx.Producer;

/* compiled from: OperatorObserveOn.java */
/* loaded from: classes3.dex */
public class y0 implements Producer {
    public final /* synthetic */ z0.a j;

    public y0(z0.a aVar) {
        this.j = aVar;
    }

    @Override // rx.Producer
    public void j(long j) {
        if (j > 0) {
            b.i.a.f.e.o.f.c0(this.j.p, j);
            this.j.b();
        }
    }
}

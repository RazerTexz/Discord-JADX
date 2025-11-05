package j0.l.a;

import j0.l.a.h2;
import rx.Producer;

/* compiled from: OperatorTakeUntilPredicate.java */
/* loaded from: classes3.dex */
public class g2 implements Producer {
    public final /* synthetic */ h2.a j;

    public g2(h2 h2Var, h2.a aVar) {
        this.j = aVar;
    }

    @Override // rx.Producer
    public void j(long j) {
        this.j.request(j);
    }
}

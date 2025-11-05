package j0.l.a;

import j0.l.a.n;
import java.util.Objects;
import rx.Producer;

/* compiled from: OnSubscribeFlattenIterable.java */
/* loaded from: classes3.dex */
public class m implements Producer {
    public final /* synthetic */ n.a j;

    public m(n nVar, n.a aVar) {
        this.j = aVar;
    }

    @Override // rx.Producer
    public void j(long j) {
        n.a aVar = this.j;
        Objects.requireNonNull(aVar);
        if (j > 0) {
            b.i.a.f.e.o.f.c0(aVar.o, j);
            aVar.b();
        } else if (j < 0) {
            throw new IllegalStateException(b.d.b.a.a.t("n >= 0 required but it was ", j));
        }
    }
}

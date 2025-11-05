package j0.l.a;

import j0.l.a.h;
import java.util.Objects;
import rx.Producer;

/* compiled from: OnSubscribeConcatMap.java */
/* loaded from: classes3.dex */
public class g implements Producer {
    public final /* synthetic */ h.c j;

    public g(h hVar, h.c cVar) {
        this.j = cVar;
    }

    @Override // rx.Producer
    public void j(long j) {
        h.c cVar = this.j;
        Objects.requireNonNull(cVar);
        if (j > 0) {
            cVar.m.j(j);
        } else if (j < 0) {
            throw new IllegalArgumentException(b.d.b.a.a.t("n >= 0 required but it was ", j));
        }
    }
}

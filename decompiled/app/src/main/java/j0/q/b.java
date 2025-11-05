package j0.q;

import j0.q.c;
import rx.functions.Action0;

/* compiled from: SubjectSubscriptionManager.java */
/* loaded from: classes3.dex */
public class b implements Action0 {
    public final /* synthetic */ c.b j;
    public final /* synthetic */ c k;

    public b(c cVar, c.b bVar) {
        this.k = cVar;
        this.j = bVar;
    }

    @Override // rx.functions.Action0
    public void call() {
        this.k.a(this.j);
    }
}

package j0.l.a;

import j0.l.a.h1;
import rx.functions.Action0;

/* compiled from: OperatorPublish.java */
/* loaded from: classes3.dex */
public class i1 implements Action0 {
    public final /* synthetic */ h1.b j;

    public i1(h1.b bVar) {
        this.j = bVar;
    }

    @Override // rx.functions.Action0
    public void call() {
        this.j.o.getAndSet(h1.b.k);
        h1.b bVar = this.j;
        bVar.m.compareAndSet(bVar, null);
    }
}

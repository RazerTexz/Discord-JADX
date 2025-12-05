package p637j0.p642l.p643a;

import p637j0.p642l.p643a.OperatorPublish2;
import p658rx.functions.Action0;

/* compiled from: OperatorPublish.java */
/* renamed from: j0.l.a.i1, reason: use source file name */
/* loaded from: classes3.dex */
public class OperatorPublish3 implements Action0 {

    /* renamed from: j */
    public final /* synthetic */ OperatorPublish2.b f26850j;

    public OperatorPublish3(OperatorPublish2.b bVar) {
        this.f26850j = bVar;
    }

    @Override // p658rx.functions.Action0
    public void call() {
        this.f26850j.f26837o.getAndSet(OperatorPublish2.b.f26833k);
        OperatorPublish2.b bVar = this.f26850j;
        bVar.f26835m.compareAndSet(bVar, null);
    }
}

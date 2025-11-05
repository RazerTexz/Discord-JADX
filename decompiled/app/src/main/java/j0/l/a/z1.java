package j0.l.a;

import j0.l.a.y1;
import rx.functions.Action0;

/* compiled from: OperatorSwitch.java */
/* loaded from: classes3.dex */
public class z1 implements Action0 {
    public final /* synthetic */ y1.c j;

    public z1(y1.c cVar) {
        this.j = cVar;
    }

    @Override // rx.functions.Action0
    public void call() {
        y1.c cVar = this.j;
        synchronized (cVar) {
            cVar.f3783s = null;
        }
    }
}

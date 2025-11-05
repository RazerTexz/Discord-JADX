package j0.l.a;

import j0.l.a.n0;
import java.util.ArrayList;
import java.util.Collection;
import rx.functions.Action0;

/* compiled from: OperatorBufferWithTime.java */
/* loaded from: classes3.dex */
public class m0 implements Action0 {
    public final /* synthetic */ n0.a j;

    public m0(n0.a aVar) {
        this.j = aVar;
    }

    @Override // rx.functions.Action0
    public void call() {
        n0.a aVar = this.j;
        synchronized (aVar) {
            if (aVar.m) {
                return;
            }
            Collection collection = aVar.l;
            aVar.l = new ArrayList();
            try {
                aVar.j.onNext(collection);
            } catch (Throwable th) {
                b.i.a.f.e.o.f.o1(th);
                aVar.onError(th);
            }
        }
    }
}

package j0.l.a;

import j0.l.a.j1;
import java.util.concurrent.atomic.AtomicReference;
import rx.Observable;
import rx.Subscriber;
import rx.functions.Func0;

/* JADX INFO: Add missing generic type declarations: [T] */
/* compiled from: OperatorReplay.java */
/* loaded from: classes3.dex */
public final class l1<T> implements Observable.a<T> {
    public final /* synthetic */ AtomicReference j;
    public final /* synthetic */ Func0 k;

    public l1(AtomicReference atomicReference, Func0 func0) {
        this.j = atomicReference;
        this.k = func0;
    }

    @Override // rx.functions.Action1
    public void call(Object obj) {
        j1.f fVar;
        Subscriber subscriber = (Subscriber) obj;
        while (true) {
            fVar = (j1.f) this.j.get();
            if (fVar != null) {
                break;
            }
            j1.f fVar2 = new j1.f((j1.e) this.k.call());
            fVar2.add(new j0.r.a(new m1(fVar2)));
            if (this.j.compareAndSet(fVar, fVar2)) {
                fVar = fVar2;
                break;
            }
        }
        j1.c<T> cVar = new j1.c<>(fVar, subscriber);
        if (!fVar.m) {
            synchronized (fVar.n) {
                if (!fVar.m) {
                    fVar.n.a(cVar);
                    fVar.p++;
                }
            }
        }
        subscriber.add(cVar);
        fVar.k.h(cVar);
        subscriber.setProducer(cVar);
    }
}

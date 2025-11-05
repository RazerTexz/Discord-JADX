package j0.l.a;

import j0.l.a.h1;
import java.util.concurrent.atomic.AtomicReference;
import rx.Observable;
import rx.Subscriber;

/* JADX INFO: Add missing generic type declarations: [T] */
/* compiled from: OperatorPublish.java */
/* loaded from: classes3.dex */
public final class g1<T> implements Observable.a<T> {
    public final /* synthetic */ AtomicReference j;

    public g1(AtomicReference atomicReference) {
        this.j = atomicReference;
    }

    @Override // rx.functions.Action1
    public void call(Object obj) {
        boolean z2;
        Subscriber subscriber = (Subscriber) obj;
        while (true) {
            h1.b bVar = (h1.b) this.j.get();
            if (bVar == null || bVar.isUnsubscribed()) {
                h1.b bVar2 = new h1.b(this.j);
                bVar2.add(new j0.r.a(new i1(bVar2)));
                if (this.j.compareAndSet(bVar, bVar2)) {
                    bVar = bVar2;
                } else {
                    continue;
                }
            }
            h1.a aVar = new h1.a(bVar, subscriber);
            while (true) {
                h1.a[] aVarArr = bVar.o.get();
                z2 = false;
                if (aVarArr == h1.b.k) {
                    break;
                }
                int length = aVarArr.length;
                h1.a[] aVarArr2 = new h1.a[length + 1];
                System.arraycopy(aVarArr, 0, aVarArr2, 0, length);
                aVarArr2[length] = aVar;
                if (bVar.o.compareAndSet(aVarArr, aVarArr2)) {
                    z2 = true;
                    break;
                }
            }
            if (z2) {
                subscriber.add(aVar);
                subscriber.setProducer(aVar);
                return;
            }
        }
    }
}

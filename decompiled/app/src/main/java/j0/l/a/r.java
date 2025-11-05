package j0.l.a;

import rx.Observable;
import rx.Subscriber;

/* compiled from: OnSubscribeLift.java */
/* loaded from: classes3.dex */
public final class r<T, R> implements Observable.a<R> {
    public final Observable.a<T> j;
    public final Observable.b<? extends R, ? super T> k;

    public r(Observable.a<T> aVar, Observable.b<? extends R, ? super T> bVar) {
        this.j = aVar;
        this.k = bVar;
    }

    @Override // rx.functions.Action1
    public void call(Object obj) {
        Subscriber subscriber = (Subscriber) obj;
        try {
            Observable.b bVarCall = this.k;
            j0.k.b<Observable.b, Observable.b> bVar = j0.o.l.i;
            if (bVar != null) {
                bVarCall = bVar.call(bVarCall);
            }
            Subscriber subscriber2 = (Subscriber) bVarCall.call(subscriber);
            try {
                subscriber2.onStart();
                this.j.call(subscriber2);
            } catch (Throwable th) {
                b.i.a.f.e.o.f.o1(th);
                subscriber2.onError(th);
            }
        } catch (Throwable th2) {
            b.i.a.f.e.o.f.o1(th2);
            subscriber.onError(th2);
        }
    }
}

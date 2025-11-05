package j0.l.a;

import rx.Observable;
import rx.Producer;
import rx.Subscriber;
import rx.exceptions.OnErrorThrowable;

/* compiled from: OnSubscribeMap.java */
/* loaded from: classes3.dex */
public final class s<T, R> implements Observable.a<R> {
    public final Observable<T> j;
    public final j0.k.b<? super T, ? extends R> k;

    /* compiled from: OnSubscribeMap.java */
    public static final class a<T, R> extends Subscriber<T> {
        public final Subscriber<? super R> j;
        public final j0.k.b<? super T, ? extends R> k;
        public boolean l;

        public a(Subscriber<? super R> subscriber, j0.k.b<? super T, ? extends R> bVar) {
            this.j = subscriber;
            this.k = bVar;
        }

        @Override // j0.g
        public void onCompleted() {
            if (this.l) {
                return;
            }
            this.j.onCompleted();
        }

        @Override // j0.g
        public void onError(Throwable th) {
            if (this.l) {
                j0.o.l.b(th);
            } else {
                this.l = true;
                this.j.onError(th);
            }
        }

        @Override // j0.g
        public void onNext(T t) {
            try {
                this.j.onNext(this.k.call(t));
            } catch (Throwable th) {
                b.i.a.f.e.o.f.o1(th);
                unsubscribe();
                onError(OnErrorThrowable.a(th, t));
            }
        }

        @Override // rx.Subscriber
        public void setProducer(Producer producer) {
            this.j.setProducer(producer);
        }
    }

    public s(Observable<T> observable, j0.k.b<? super T, ? extends R> bVar) {
        this.j = observable;
        this.k = bVar;
    }

    @Override // rx.functions.Action1
    public void call(Object obj) {
        Subscriber subscriber = (Subscriber) obj;
        a aVar = new a(subscriber, this.k);
        subscriber.add(aVar);
        this.j.i0(aVar);
    }
}

package j0.l.a;

import rx.Observable;
import rx.Subscriber;

/* compiled from: OperatorTakeUntilPredicate.java */
/* loaded from: classes3.dex */
public final class h2<T> implements Observable.b<T, T> {
    public final j0.k.b<? super T, Boolean> j;

    /* compiled from: OperatorTakeUntilPredicate.java */
    public final class a extends Subscriber<T> {
        public final Subscriber<? super T> j;
        public boolean k;

        public a(Subscriber<? super T> subscriber) {
            this.j = subscriber;
        }

        @Override // j0.g
        public void onCompleted() {
            if (this.k) {
                return;
            }
            this.j.onCompleted();
        }

        @Override // j0.g
        public void onError(Throwable th) {
            if (this.k) {
                return;
            }
            this.j.onError(th);
        }

        @Override // j0.g
        public void onNext(T t) {
            this.j.onNext(t);
            try {
                if (h2.this.j.call(t).booleanValue()) {
                    this.k = true;
                    this.j.onCompleted();
                    unsubscribe();
                }
            } catch (Throwable th) {
                this.k = true;
                b.i.a.f.e.o.f.p1(th, this.j, t);
                unsubscribe();
            }
        }
    }

    public h2(j0.k.b<? super T, Boolean> bVar) {
        this.j = bVar;
    }

    @Override // j0.k.b
    public Object call(Object obj) {
        Subscriber subscriber = (Subscriber) obj;
        a aVar = new a(subscriber);
        subscriber.add(aVar);
        subscriber.setProducer(new g2(this, aVar));
        return aVar;
    }
}

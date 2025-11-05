package j0.l.a;

import java.util.NoSuchElementException;
import rx.Observable;
import rx.Subscriber;

/* compiled from: OperatorSingle.java */
/* loaded from: classes3.dex */
public final class r1<T> implements Observable.b<T, T> {

    /* compiled from: OperatorSingle.java */
    public static final class a {
        public static final r1<?> a = new r1<>();
    }

    /* compiled from: OperatorSingle.java */
    public static final class b<T> extends Subscriber<T> {
        public final Subscriber<? super T> j;
        public final boolean k;
        public final T l;
        public T m;
        public boolean n;
        public boolean o;

        public b(Subscriber<? super T> subscriber, boolean z2, T t) {
            this.j = subscriber;
            this.k = z2;
            this.l = t;
            request(2L);
        }

        @Override // j0.g
        public void onCompleted() {
            if (this.o) {
                return;
            }
            if (this.n) {
                this.j.setProducer(new j0.l.b.c(this.j, this.m));
            } else if (this.k) {
                this.j.setProducer(new j0.l.b.c(this.j, this.l));
            } else {
                this.j.onError(new NoSuchElementException("Sequence contains no elements"));
            }
        }

        @Override // j0.g
        public void onError(Throwable th) {
            if (this.o) {
                j0.o.l.b(th);
            } else {
                this.j.onError(th);
            }
        }

        @Override // j0.g
        public void onNext(T t) {
            if (this.o) {
                return;
            }
            if (!this.n) {
                this.m = t;
                this.n = true;
            } else {
                this.o = true;
                this.j.onError(new IllegalArgumentException("Sequence contains too many elements"));
                unsubscribe();
            }
        }
    }

    @Override // j0.k.b
    public Object call(Object obj) {
        Subscriber subscriber = (Subscriber) obj;
        b bVar = new b(subscriber, false, null);
        subscriber.add(bVar);
        return bVar;
    }
}

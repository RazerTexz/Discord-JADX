package j0.l.a;

import java.util.Arrays;
import rx.Observable;
import rx.Subscriber;
import rx.exceptions.CompositeException;

/* compiled from: OnSubscribeDoOnEach.java */
/* loaded from: classes3.dex */
public class k<T> implements Observable.a<T> {
    public final j0.g<? super T> j;
    public final Observable<T> k;

    /* compiled from: OnSubscribeDoOnEach.java */
    public static final class a<T> extends Subscriber<T> {
        public final Subscriber<? super T> j;
        public final j0.g<? super T> k;
        public boolean l;

        public a(Subscriber<? super T> subscriber, j0.g<? super T> gVar) {
            super(subscriber);
            this.j = subscriber;
            this.k = gVar;
        }

        @Override // j0.g
        public void onCompleted() {
            if (this.l) {
                return;
            }
            try {
                this.k.onCompleted();
                this.l = true;
                this.j.onCompleted();
            } catch (Throwable th) {
                b.i.a.f.e.o.f.o1(th);
                onError(th);
            }
        }

        @Override // j0.g
        public void onError(Throwable th) {
            if (this.l) {
                j0.o.l.b(th);
                return;
            }
            this.l = true;
            try {
                this.k.onError(th);
                this.j.onError(th);
            } catch (Throwable th2) {
                b.i.a.f.e.o.f.o1(th2);
                this.j.onError(new CompositeException(Arrays.asList(th, th2)));
            }
        }

        @Override // j0.g
        public void onNext(T t) {
            if (this.l) {
                return;
            }
            try {
                this.k.onNext(t);
                this.j.onNext(t);
            } catch (Throwable th) {
                b.i.a.f.e.o.f.p1(th, this, t);
            }
        }
    }

    public k(Observable<T> observable, j0.g<? super T> gVar) {
        this.k = observable;
        this.j = gVar;
    }

    @Override // rx.functions.Action1
    public void call(Object obj) {
        this.k.i0(new a((Subscriber) obj, this.j));
    }
}

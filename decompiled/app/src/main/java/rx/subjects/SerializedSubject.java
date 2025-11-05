package rx.subjects;

import j0.n.c;
import rx.Observable;
import rx.Subscriber;

/* loaded from: classes3.dex */
public class SerializedSubject<T, R> extends Subject<T, R> {
    public final c<T> k;

    public class a implements Observable.a<R> {
        public final /* synthetic */ Subject j;

        public a(Subject subject) {
            this.j = subject;
        }

        @Override // rx.functions.Action1
        public void call(Object obj) {
            this.j.i0((Subscriber) obj);
        }
    }

    public SerializedSubject(Subject<T, R> subject) {
        super(new a(subject));
        this.k = new c<>(subject);
    }

    @Override // j0.g
    public void onCompleted() {
        this.k.onCompleted();
    }

    @Override // j0.g
    public void onError(Throwable th) {
        this.k.onError(th);
    }

    @Override // j0.g
    public void onNext(T t) {
        this.k.onNext(t);
    }
}

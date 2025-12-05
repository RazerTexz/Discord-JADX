package p658rx.subjects;

import p637j0.p651n.SerializedObserver;
import p658rx.Observable;
import p658rx.Subscriber;

/* loaded from: classes3.dex */
public class SerializedSubject<T, R> extends Subject<T, R> {

    /* renamed from: k */
    public final SerializedObserver<T> f27653k;

    /* renamed from: rx.subjects.SerializedSubject$a */
    public class C13017a implements Observable.InterfaceC13005a<R> {

        /* renamed from: j */
        public final /* synthetic */ Subject f27654j;

        public C13017a(Subject subject) {
            this.f27654j = subject;
        }

        @Override // p658rx.functions.Action1
        public void call(Object obj) {
            this.f27654j.m11107i0((Subscriber) obj);
        }
    }

    public SerializedSubject(Subject<T, R> subject) {
        super(new C13017a(subject));
        this.f27653k = new SerializedObserver<>(subject);
    }

    @Override // p637j0.Observer2
    public void onCompleted() {
        this.f27653k.onCompleted();
    }

    @Override // p637j0.Observer2
    public void onError(Throwable th) {
        this.f27653k.onError(th);
    }

    @Override // p637j0.Observer2
    public void onNext(T t) {
        this.f27653k.onNext(t);
    }
}

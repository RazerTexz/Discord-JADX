package p658rx.observers;

import p637j0.Observer2;
import p637j0.p651n.SerializedObserver;
import p658rx.Subscriber;

/* JADX INFO: loaded from: classes3.dex */
public class SerializedSubscriber<T> extends Subscriber<T> {

    /* JADX INFO: renamed from: j */
    public final Observer2<T> f27646j;

    public SerializedSubscriber(Subscriber<? super T> subscriber) {
        super(subscriber, true);
        this.f27646j = new SerializedObserver(subscriber);
    }

    @Override // p637j0.Observer2
    public void onCompleted() {
        this.f27646j.onCompleted();
    }

    @Override // p637j0.Observer2
    public void onError(Throwable th) {
        this.f27646j.onError(th);
    }

    @Override // p637j0.Observer2
    public void onNext(T t) {
        this.f27646j.onNext(t);
    }

    public SerializedSubscriber(Subscriber<? super T> subscriber, boolean z2) {
        super(subscriber, z2);
        this.f27646j = new SerializedObserver(subscriber);
    }
}

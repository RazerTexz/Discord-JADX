package p637j0.p642l.p647e;

import p637j0.Observer2;
import p658rx.Subscriber;

/* compiled from: ObserverSubscriber.java */
/* renamed from: j0.l.e.f, reason: use source file name */
/* loaded from: classes3.dex */
public final class ObserverSubscriber<T> extends Subscriber<T> {

    /* renamed from: j */
    public final Observer2<? super T> f27276j;

    public ObserverSubscriber(Observer2<? super T> observer2) {
        this.f27276j = observer2;
    }

    @Override // p637j0.Observer2
    public void onCompleted() {
        this.f27276j.onCompleted();
    }

    @Override // p637j0.Observer2
    public void onError(Throwable th) {
        this.f27276j.onError(th);
    }

    @Override // p637j0.Observer2
    public void onNext(T t) {
        this.f27276j.onNext(t);
    }
}

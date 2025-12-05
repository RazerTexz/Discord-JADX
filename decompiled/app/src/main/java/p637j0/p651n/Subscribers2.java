package p637j0.p651n;

import p658rx.Subscriber;

/* JADX INFO: Add missing generic type declarations: [T] */
/* compiled from: Subscribers.java */
/* renamed from: j0.n.e, reason: use source file name */
/* loaded from: classes3.dex */
public final class Subscribers2<T> extends Subscriber<T> {

    /* renamed from: j */
    public final /* synthetic */ Subscriber f27373j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Subscribers2(Subscriber subscriber, Subscriber subscriber2) {
        super(subscriber);
        this.f27373j = subscriber2;
    }

    @Override // p637j0.Observer2
    public void onCompleted() {
        this.f27373j.onCompleted();
    }

    @Override // p637j0.Observer2
    public void onError(Throwable th) {
        this.f27373j.onError(th);
    }

    @Override // p637j0.Observer2
    public void onNext(T t) {
        this.f27373j.onNext(t);
    }
}

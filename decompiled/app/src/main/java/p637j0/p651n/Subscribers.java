package p637j0.p651n;

import p637j0.Observer2;
import p658rx.Subscriber;

/* JADX INFO: Add missing generic type declarations: [T] */
/* compiled from: Subscribers.java */
/* renamed from: j0.n.d, reason: use source file name */
/* loaded from: classes3.dex */
public final class Subscribers<T> extends Subscriber<T> {

    /* renamed from: j */
    public final /* synthetic */ Observer2 f27372j;

    public Subscribers(Observer2 observer2) {
        this.f27372j = observer2;
    }

    @Override // p637j0.Observer2
    public void onCompleted() {
        this.f27372j.onCompleted();
    }

    @Override // p637j0.Observer2
    public void onError(Throwable th) {
        this.f27372j.onError(th);
    }

    @Override // p637j0.Observer2
    public void onNext(T t) {
        this.f27372j.onNext(t);
    }
}

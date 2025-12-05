package p637j0.p642l.p647e;

import p658rx.Subscriber;
import p658rx.functions.Action0;
import p658rx.functions.Action1;

/* compiled from: ActionSubscriber.java */
/* renamed from: j0.l.e.b, reason: use source file name */
/* loaded from: classes3.dex */
public final class ActionSubscriber<T> extends Subscriber<T> {

    /* renamed from: j */
    public final Action1<? super T> f27265j;

    /* renamed from: k */
    public final Action1<Throwable> f27266k;

    /* renamed from: l */
    public final Action0 f27267l;

    public ActionSubscriber(Action1<? super T> action1, Action1<Throwable> action12, Action0 action0) {
        this.f27265j = action1;
        this.f27266k = action12;
        this.f27267l = action0;
    }

    @Override // p637j0.Observer2
    public void onCompleted() {
        this.f27267l.call();
    }

    @Override // p637j0.Observer2
    public void onError(Throwable th) {
        this.f27266k.call(th);
    }

    @Override // p637j0.Observer2
    public void onNext(T t) {
        this.f27265j.call(t);
    }
}

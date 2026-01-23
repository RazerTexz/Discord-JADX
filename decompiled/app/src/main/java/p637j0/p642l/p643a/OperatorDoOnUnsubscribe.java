package p637j0.p642l.p643a;

import p637j0.p651n.Subscribers2;
import p637j0.p655r.BooleanSubscription;
import p658rx.Observable;
import p658rx.Subscriber;
import p658rx.functions.Action0;

/* JADX INFO: renamed from: j0.l.a.w0, reason: use source file name */
/* JADX INFO: compiled from: OperatorDoOnUnsubscribe.java */
/* JADX INFO: loaded from: classes3.dex */
public class OperatorDoOnUnsubscribe<T> implements Observable.InterfaceC13006b<T, T> {

    /* JADX INFO: renamed from: j */
    public final Action0 f27074j;

    public OperatorDoOnUnsubscribe(Action0 action0) {
        this.f27074j = action0;
    }

    @Override // p637j0.p641k.Func1
    public Object call(Object obj) {
        Subscriber subscriber = (Subscriber) obj;
        subscriber.add(new BooleanSubscription(this.f27074j));
        return new Subscribers2(subscriber, subscriber);
    }
}

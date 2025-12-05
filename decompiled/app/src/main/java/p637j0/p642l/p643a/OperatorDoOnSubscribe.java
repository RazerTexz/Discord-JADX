package p637j0.p642l.p643a;

import p637j0.p651n.Subscribers2;
import p658rx.Observable;
import p658rx.Subscriber;
import p658rx.functions.Action0;

/* compiled from: OperatorDoOnSubscribe.java */
/* renamed from: j0.l.a.v0, reason: use source file name */
/* loaded from: classes3.dex */
public class OperatorDoOnSubscribe<T> implements Observable.InterfaceC13006b<T, T> {

    /* renamed from: j */
    public final Action0 f27065j;

    public OperatorDoOnSubscribe(Action0 action0) {
        this.f27065j = action0;
    }

    @Override // p637j0.p641k.Func1
    public Object call(Object obj) {
        Subscriber subscriber = (Subscriber) obj;
        this.f27065j.call();
        return new Subscribers2(subscriber, subscriber);
    }
}

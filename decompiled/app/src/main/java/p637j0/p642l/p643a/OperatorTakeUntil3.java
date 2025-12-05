package p637j0.p642l.p643a;

import p658rx.Observable;
import p658rx.Subscriber;
import p658rx.observers.SerializedSubscriber;

/* compiled from: OperatorTakeUntil.java */
/* renamed from: j0.l.a.f2, reason: use source file name */
/* loaded from: classes3.dex */
public final class OperatorTakeUntil3<T, E> implements Observable.InterfaceC13006b<T, T> {

    /* renamed from: j */
    public final Observable<? extends E> f26789j;

    public OperatorTakeUntil3(Observable<? extends E> observable) {
        this.f26789j = observable;
    }

    @Override // p637j0.p641k.Func1
    public Object call(Object obj) {
        Subscriber subscriber = (Subscriber) obj;
        SerializedSubscriber serializedSubscriber = new SerializedSubscriber(subscriber, false);
        OperatorTakeUntil operatorTakeUntil = new OperatorTakeUntil(this, serializedSubscriber, false, serializedSubscriber);
        OperatorTakeUntil2 operatorTakeUntil2 = new OperatorTakeUntil2(this, operatorTakeUntil);
        serializedSubscriber.add(operatorTakeUntil);
        serializedSubscriber.add(operatorTakeUntil2);
        subscriber.add(serializedSubscriber);
        this.f26789j.m11107i0(operatorTakeUntil2);
        return operatorTakeUntil;
    }
}

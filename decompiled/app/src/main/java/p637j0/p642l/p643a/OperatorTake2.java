package p637j0.p642l.p643a;

import p007b.p100d.p104b.p105a.outline;
import p658rx.Observable;
import p658rx.Subscriber;

/* JADX INFO: renamed from: j0.l.a.c2, reason: use source file name */
/* JADX INFO: compiled from: OperatorTake.java */
/* JADX INFO: loaded from: classes3.dex */
public final class OperatorTake2<T> implements Observable.InterfaceC13006b<T, T> {

    /* JADX INFO: renamed from: j */
    public final int f26758j;

    public OperatorTake2(int i) {
        if (i < 0) {
            throw new IllegalArgumentException(outline.m871q("limit >= 0 required but it was ", i));
        }
        this.f26758j = i;
    }

    @Override // p637j0.p641k.Func1
    public Object call(Object obj) {
        Subscriber subscriber = (Subscriber) obj;
        OperatorTake operatorTake = new OperatorTake(this, subscriber);
        if (this.f26758j == 0) {
            subscriber.onCompleted();
            operatorTake.unsubscribe();
        }
        subscriber.add(operatorTake);
        return operatorTake;
    }
}

package p637j0.p642l.p643a;

import java.util.List;
import p637j0.p642l.p644b.SingleDelayedProducer;
import p658rx.Observable;
import p658rx.Subscriber;

/* compiled from: OperatorToObservableList.java */
/* renamed from: j0.l.a.n2, reason: use source file name */
/* loaded from: classes3.dex */
public final class OperatorToObservableList2<T> implements Observable.InterfaceC13006b<List<T>, T> {

    /* compiled from: OperatorToObservableList.java */
    /* renamed from: j0.l.a.n2$a */
    public static final class a {

        /* renamed from: a */
        public static final OperatorToObservableList2<Object> f26954a = new OperatorToObservableList2<>();
    }

    @Override // p637j0.p641k.Func1
    public Object call(Object obj) {
        Subscriber subscriber = (Subscriber) obj;
        SingleDelayedProducer singleDelayedProducer = new SingleDelayedProducer(subscriber);
        OperatorToObservableList operatorToObservableList = new OperatorToObservableList(this, singleDelayedProducer, subscriber);
        subscriber.add(operatorToObservableList);
        subscriber.setProducer(singleDelayedProducer);
        return operatorToObservableList;
    }
}

package p637j0.p642l.p643a;

import p637j0.p641k.Func1;
import p637j0.p642l.p644b.ProducerArbiter;
import p658rx.Observable;
import p658rx.Subscriber;
import p658rx.subscriptions.SerialSubscription;

/* JADX INFO: renamed from: j0.l.a.f1, reason: use source file name */
/* JADX INFO: compiled from: OperatorOnErrorResumeNextViaFunction.java */
/* JADX INFO: loaded from: classes3.dex */
public final class OperatorOnErrorResumeNextViaFunction4<T> implements Observable.InterfaceC13006b<T, T> {

    /* JADX INFO: renamed from: j */
    public final Func1<? super Throwable, ? extends Observable<? extends T>> f26788j;

    public OperatorOnErrorResumeNextViaFunction4(Func1<? super Throwable, ? extends Observable<? extends T>> func1) {
        this.f26788j = func1;
    }

    @Override // p637j0.p641k.Func1
    public Object call(Object obj) {
        Subscriber subscriber = (Subscriber) obj;
        ProducerArbiter producerArbiter = new ProducerArbiter();
        SerialSubscription serialSubscription = new SerialSubscription();
        OperatorOnErrorResumeNextViaFunction3 operatorOnErrorResumeNextViaFunction3 = new OperatorOnErrorResumeNextViaFunction3(this, subscriber, producerArbiter, serialSubscription);
        serialSubscription.m11139a(operatorOnErrorResumeNextViaFunction3);
        subscriber.add(serialSubscription);
        subscriber.setProducer(producerArbiter);
        return operatorOnErrorResumeNextViaFunction3;
    }
}

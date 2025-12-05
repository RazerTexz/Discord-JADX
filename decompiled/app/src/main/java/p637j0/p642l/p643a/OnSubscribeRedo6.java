package p637j0.p642l.p643a;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import p637j0.Notification;
import p637j0.p641k.Func1;
import p637j0.p642l.p644b.ProducerArbiter;
import p637j0.p642l.p645c.TrampolineScheduler;
import p637j0.p651n.Observers;
import p637j0.p651n.Subscribers;
import p658rx.Observable;
import p658rx.Scheduler;
import p658rx.Subscriber;
import p658rx.subjects.BehaviorSubject;
import p658rx.subjects.SerializedSubject;
import p658rx.subscriptions.SerialSubscription;

/* compiled from: OnSubscribeRedo.java */
/* renamed from: j0.l.a.y, reason: use source file name */
/* loaded from: classes3.dex */
public final class OnSubscribeRedo6<T> implements Observable.InterfaceC13005a<T> {

    /* renamed from: j */
    public final Observable<T> f27120j;

    /* renamed from: k */
    public final Func1<? super Observable<? extends Notification<?>>, ? extends Observable<?>> f27121k;

    /* renamed from: l */
    public final boolean f27122l;

    /* renamed from: m */
    public final boolean f27123m;

    public OnSubscribeRedo6(Observable<T> observable, Func1<? super Observable<? extends Notification<?>>, ? extends Observable<?>> func1, boolean z2, boolean z3, Scheduler scheduler) {
        this.f27120j = observable;
        this.f27121k = func1;
        this.f27122l = z2;
        this.f27123m = z3;
    }

    @Override // p658rx.functions.Action1
    public void call(Object obj) {
        Subscriber subscriber = (Subscriber) obj;
        AtomicBoolean atomicBoolean = new AtomicBoolean(true);
        AtomicLong atomicLong = new AtomicLong();
        TrampolineScheduler.a aVar = new TrampolineScheduler.a();
        subscriber.add(aVar);
        SerialSubscription serialSubscription = new SerialSubscription();
        subscriber.add(serialSubscription);
        SerializedSubject serializedSubject = new SerializedSubject(BehaviorSubject.m11129k0());
        serializedSubject.m11095U(new Subscribers(Observers.f27363a));
        ProducerArbiter producerArbiter = new ProducerArbiter();
        OnSubscribeRedo onSubscribeRedo = new OnSubscribeRedo(this, subscriber, serializedSubject, producerArbiter, atomicLong, serialSubscription);
        aVar.mo10740a(new OnSubscribeRedo4(this, this.f27121k.call(Observable.m11074h0(new OnSubscribeLift(serializedSubject.f27640j, new OnSubscribeRedo3(this)))), subscriber, atomicLong, aVar, onSubscribeRedo, atomicBoolean));
        subscriber.setProducer(new OnSubscribeRedo5(this, atomicLong, producerArbiter, atomicBoolean, aVar, onSubscribeRedo));
    }
}

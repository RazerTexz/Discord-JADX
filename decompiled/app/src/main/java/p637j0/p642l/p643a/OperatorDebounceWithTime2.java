package p637j0.p642l.p643a;

import java.util.concurrent.TimeUnit;
import p658rx.Observable;
import p658rx.Scheduler;
import p658rx.Subscriber;
import p658rx.observers.SerializedSubscriber;
import p658rx.subscriptions.SerialSubscription;

/* compiled from: OperatorDebounceWithTime.java */
/* renamed from: j0.l.a.q0, reason: use source file name */
/* loaded from: classes3.dex */
public final class OperatorDebounceWithTime2<T> implements Observable.InterfaceC13006b<T, T> {

    /* renamed from: j */
    public final long f26993j;

    /* renamed from: k */
    public final TimeUnit f26994k;

    /* renamed from: l */
    public final Scheduler f26995l;

    /* compiled from: OperatorDebounceWithTime.java */
    /* renamed from: j0.l.a.q0$a */
    public static final class a<T> {

        /* renamed from: a */
        public int f26996a;

        /* renamed from: b */
        public T f26997b;

        /* renamed from: c */
        public boolean f26998c;

        /* renamed from: d */
        public boolean f26999d;

        /* renamed from: e */
        public boolean f27000e;
    }

    public OperatorDebounceWithTime2(long j, TimeUnit timeUnit, Scheduler scheduler) {
        this.f26993j = j;
        this.f26994k = timeUnit;
        this.f26995l = scheduler;
    }

    @Override // p637j0.p641k.Func1
    public Object call(Object obj) {
        Subscriber subscriber = (Subscriber) obj;
        Scheduler.Worker workerMo10739a = this.f26995l.mo10739a();
        SerializedSubscriber serializedSubscriber = new SerializedSubscriber(subscriber);
        SerialSubscription serialSubscription = new SerialSubscription();
        serializedSubscriber.add(workerMo10739a);
        serializedSubscriber.add(serialSubscription);
        return new OperatorDebounceWithTime(this, subscriber, serialSubscription, workerMo10739a, serializedSubscriber);
    }
}

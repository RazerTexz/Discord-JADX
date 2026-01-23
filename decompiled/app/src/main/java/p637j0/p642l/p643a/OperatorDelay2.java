package p637j0.p642l.p643a;

import java.util.concurrent.TimeUnit;
import p658rx.Observable;
import p658rx.Scheduler;
import p658rx.Subscriber;

/* JADX INFO: renamed from: j0.l.a.s0, reason: use source file name */
/* JADX INFO: compiled from: OperatorDelay.java */
/* JADX INFO: loaded from: classes3.dex */
public final class OperatorDelay2<T> implements Observable.InterfaceC13006b<T, T> {

    /* JADX INFO: renamed from: j */
    public final long f27036j;

    /* JADX INFO: renamed from: k */
    public final TimeUnit f27037k;

    /* JADX INFO: renamed from: l */
    public final Scheduler f27038l;

    public OperatorDelay2(long j, TimeUnit timeUnit, Scheduler scheduler) {
        this.f27036j = j;
        this.f27037k = timeUnit;
        this.f27038l = scheduler;
    }

    @Override // p637j0.p641k.Func1
    public Object call(Object obj) {
        Subscriber subscriber = (Subscriber) obj;
        Scheduler.Worker workerMo10739a = this.f27038l.mo10739a();
        subscriber.add(workerMo10739a);
        return new OperatorDelay(this, subscriber, workerMo10739a, subscriber);
    }
}

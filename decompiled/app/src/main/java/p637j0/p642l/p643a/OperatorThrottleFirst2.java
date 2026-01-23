package p637j0.p642l.p643a;

import java.util.concurrent.TimeUnit;
import p658rx.Observable;
import p658rx.Scheduler;
import p658rx.Subscriber;

/* JADX INFO: renamed from: j0.l.a.l2, reason: use source file name */
/* JADX INFO: compiled from: OperatorThrottleFirst.java */
/* JADX INFO: loaded from: classes3.dex */
public final class OperatorThrottleFirst2<T> implements Observable.InterfaceC13006b<T, T> {

    /* JADX INFO: renamed from: j */
    public final long f26907j;

    /* JADX INFO: renamed from: k */
    public final Scheduler f26908k;

    public OperatorThrottleFirst2(long j, TimeUnit timeUnit, Scheduler scheduler) {
        this.f26907j = timeUnit.toMillis(j);
        this.f26908k = scheduler;
    }

    @Override // p637j0.p641k.Func1
    public Object call(Object obj) {
        Subscriber subscriber = (Subscriber) obj;
        return new OperatorThrottleFirst(this, subscriber, subscriber);
    }
}

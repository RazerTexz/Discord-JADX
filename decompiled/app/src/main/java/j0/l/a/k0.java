package j0.l.a;

import java.util.concurrent.TimeUnit;
import rx.Observable;
import rx.Scheduler;
import rx.Subscriber;

/* compiled from: OnSubscribeTimerPeriodically.java */
/* loaded from: classes3.dex */
public final class k0 implements Observable.a<Long> {
    public final long j;
    public final long k;
    public final TimeUnit l;
    public final Scheduler m;

    public k0(long j, long j2, TimeUnit timeUnit, Scheduler scheduler) {
        this.j = j;
        this.k = j2;
        this.l = timeUnit;
        this.m = scheduler;
    }

    @Override // rx.functions.Action1
    public void call(Object obj) {
        Subscriber subscriber = (Subscriber) obj;
        Scheduler.Worker workerA = this.m.a();
        subscriber.add(workerA);
        workerA.c(new j0(this, subscriber, workerA), this.j, this.k, this.l);
    }
}

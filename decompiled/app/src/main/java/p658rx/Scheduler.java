package p658rx;

import java.util.concurrent.TimeUnit;
import p637j0.p642l.p645c.SchedulePeriodicHelper;
import p637j0.p642l.p645c.SchedulePeriodicHelper2;
import p637j0.p642l.p646d.SequentialSubscription;
import p658rx.functions.Action0;

/* loaded from: classes3.dex */
public abstract class Scheduler {

    public static abstract class Worker implements Subscription {
        /* renamed from: a */
        public abstract Subscription mo10740a(Action0 action0);

        /* renamed from: b */
        public abstract Subscription mo10741b(Action0 action0, long j, TimeUnit timeUnit);

        /* renamed from: c */
        public Subscription m11120c(Action0 action0, long j, long j2, TimeUnit timeUnit) {
            int i = SchedulePeriodicHelper2.f27242b;
            long nanos = timeUnit.toNanos(j2);
            long nanos2 = TimeUnit.MILLISECONDS.toNanos(System.currentTimeMillis());
            long nanos3 = timeUnit.toNanos(j) + nanos2;
            SequentialSubscription sequentialSubscription = new SequentialSubscription();
            SequentialSubscription sequentialSubscription2 = new SequentialSubscription(sequentialSubscription);
            sequentialSubscription.m10809a(mo10741b(new SchedulePeriodicHelper(nanos2, nanos3, action0, sequentialSubscription2, null, this, nanos), j, timeUnit));
            return sequentialSubscription2;
        }
    }

    /* renamed from: a */
    public abstract Worker mo10739a();
}

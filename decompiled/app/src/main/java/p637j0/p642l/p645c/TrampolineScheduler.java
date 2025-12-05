package p637j0.p642l.p645c;

import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import p637j0.p655r.BooleanSubscription;
import p637j0.p655r.Subscriptions;
import p658rx.Scheduler;
import p658rx.Subscription;
import p658rx.functions.Action0;

/* compiled from: TrampolineScheduler.java */
/* renamed from: j0.l.c.m, reason: use source file name */
/* loaded from: classes3.dex */
public final class TrampolineScheduler extends Scheduler {

    /* renamed from: a */
    public static final TrampolineScheduler f27250a = new TrampolineScheduler();

    /* compiled from: TrampolineScheduler.java */
    /* renamed from: j0.l.c.m$a */
    public static final class a extends Scheduler.Worker implements Subscription {

        /* renamed from: j */
        public final AtomicInteger f27251j = new AtomicInteger();

        /* renamed from: k */
        public final PriorityBlockingQueue<b> f27252k = new PriorityBlockingQueue<>();

        /* renamed from: l */
        public final BooleanSubscription f27253l = new BooleanSubscription();

        /* renamed from: m */
        public final AtomicInteger f27254m = new AtomicInteger();

        /* compiled from: TrampolineScheduler.java */
        /* renamed from: j0.l.c.m$a$a, reason: collision with other inner class name */
        public class C13354a implements Action0 {

            /* renamed from: j */
            public final /* synthetic */ b f27255j;

            public C13354a(b bVar) {
                this.f27255j = bVar;
            }

            @Override // p658rx.functions.Action0
            public void call() {
                a.this.f27252k.remove(this.f27255j);
            }
        }

        @Override // rx.Scheduler.Worker
        /* renamed from: a */
        public Subscription mo10740a(Action0 action0) {
            return m10808d(action0, System.currentTimeMillis());
        }

        @Override // rx.Scheduler.Worker
        /* renamed from: b */
        public Subscription mo10741b(Action0 action0, long j, TimeUnit timeUnit) {
            long millis = timeUnit.toMillis(j) + System.currentTimeMillis();
            return m10808d(new SleepingAction(action0, this, millis), millis);
        }

        /* renamed from: d */
        public final Subscription m10808d(Action0 action0, long j) {
            if (this.f27253l.isUnsubscribed()) {
                return Subscriptions.f27422a;
            }
            b bVar = new b(action0, Long.valueOf(j), this.f27251j.incrementAndGet());
            this.f27252k.add(bVar);
            if (this.f27254m.getAndIncrement() != 0) {
                return new BooleanSubscription(new C13354a(bVar));
            }
            do {
                b bVarPoll = this.f27252k.poll();
                if (bVarPoll != null) {
                    bVarPoll.f27257j.call();
                }
            } while (this.f27254m.decrementAndGet() > 0);
            return Subscriptions.f27422a;
        }

        @Override // p658rx.Subscription
        public boolean isUnsubscribed() {
            return this.f27253l.isUnsubscribed();
        }

        @Override // p658rx.Subscription
        public void unsubscribe() {
            this.f27253l.unsubscribe();
        }
    }

    /* compiled from: TrampolineScheduler.java */
    /* renamed from: j0.l.c.m$b */
    public static final class b implements Comparable<b> {

        /* renamed from: j */
        public final Action0 f27257j;

        /* renamed from: k */
        public final Long f27258k;

        /* renamed from: l */
        public final int f27259l;

        public b(Action0 action0, Long l, int i) {
            this.f27257j = action0;
            this.f27258k = l;
            this.f27259l = i;
        }

        @Override // java.lang.Comparable
        public int compareTo(b bVar) {
            b bVar2 = bVar;
            int iCompareTo = this.f27258k.compareTo(bVar2.f27258k);
            if (iCompareTo != 0) {
                return iCompareTo;
            }
            int i = this.f27259l;
            int i2 = bVar2.f27259l;
            if (i < i2) {
                return -1;
            }
            return i == i2 ? 0 : 1;
        }
    }

    @Override // p658rx.Scheduler
    /* renamed from: a */
    public Scheduler.Worker mo10739a() {
        return new a();
    }
}

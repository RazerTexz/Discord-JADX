package p637j0.p642l.p645c;

import java.util.Objects;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import p637j0.p642l.p647e.RxThreadFactory;
import p637j0.p652o.C12774l;
import p637j0.p655r.Subscriptions;
import p658rx.Scheduler;
import p658rx.Subscription;
import p658rx.functions.Action0;
import p658rx.internal.util.SubscriptionList;
import p658rx.subscriptions.CompositeSubscription;

/* compiled from: EventLoopsScheduler.java */
/* renamed from: j0.l.c.b, reason: use source file name */
/* loaded from: classes3.dex */
public final class EventLoopsScheduler extends Scheduler implements SchedulerLifecycle {

    /* renamed from: a */
    public static final int f27187a;

    /* renamed from: b */
    public static final c f27188b;

    /* renamed from: c */
    public static final b f27189c;

    /* renamed from: d */
    public final ThreadFactory f27190d;

    /* renamed from: e */
    public final AtomicReference<b> f27191e;

    /* compiled from: EventLoopsScheduler.java */
    /* renamed from: j0.l.c.b$a */
    public static final class a extends Scheduler.Worker {

        /* renamed from: j */
        public final SubscriptionList f27192j;

        /* renamed from: k */
        public final CompositeSubscription f27193k;

        /* renamed from: l */
        public final SubscriptionList f27194l;

        /* renamed from: m */
        public final c f27195m;

        /* compiled from: EventLoopsScheduler.java */
        /* renamed from: j0.l.c.b$a$a, reason: collision with other inner class name */
        public class C13352a implements Action0 {

            /* renamed from: j */
            public final /* synthetic */ Action0 f27196j;

            public C13352a(Action0 action0) {
                this.f27196j = action0;
            }

            @Override // p658rx.functions.Action0
            public void call() {
                if (a.this.f27194l.f27645k) {
                    return;
                }
                this.f27196j.call();
            }
        }

        /* compiled from: EventLoopsScheduler.java */
        /* renamed from: j0.l.c.b$a$b */
        public class b implements Action0 {

            /* renamed from: j */
            public final /* synthetic */ Action0 f27198j;

            public b(Action0 action0) {
                this.f27198j = action0;
            }

            @Override // p658rx.functions.Action0
            public void call() {
                if (a.this.f27194l.f27645k) {
                    return;
                }
                this.f27198j.call();
            }
        }

        public a(c cVar) {
            SubscriptionList subscriptionList = new SubscriptionList();
            this.f27192j = subscriptionList;
            CompositeSubscription compositeSubscription = new CompositeSubscription();
            this.f27193k = compositeSubscription;
            this.f27194l = new SubscriptionList(subscriptionList, compositeSubscription);
            this.f27195m = cVar;
        }

        @Override // rx.Scheduler.Worker
        /* renamed from: a */
        public Subscription mo10740a(Action0 action0) {
            if (this.f27194l.f27645k) {
                return Subscriptions.f27422a;
            }
            c cVar = this.f27195m;
            C13352a c13352a = new C13352a(action0);
            SubscriptionList subscriptionList = this.f27192j;
            Objects.requireNonNull(cVar);
            ScheduledAction scheduledAction = new ScheduledAction(C12774l.m10865d(c13352a), subscriptionList);
            subscriptionList.m11128a(scheduledAction);
            scheduledAction.m10807a(cVar.f27229p.submit(scheduledAction));
            return scheduledAction;
        }

        @Override // rx.Scheduler.Worker
        /* renamed from: b */
        public Subscription mo10741b(Action0 action0, long j, TimeUnit timeUnit) {
            if (this.f27194l.f27645k) {
                return Subscriptions.f27422a;
            }
            c cVar = this.f27195m;
            b bVar = new b(action0);
            CompositeSubscription compositeSubscription = this.f27193k;
            Objects.requireNonNull(cVar);
            ScheduledAction scheduledAction = new ScheduledAction(C12774l.m10865d(bVar), compositeSubscription);
            compositeSubscription.m11136a(scheduledAction);
            scheduledAction.m10807a(j <= 0 ? cVar.f27229p.submit(scheduledAction) : cVar.f27229p.schedule(scheduledAction, j, timeUnit));
            return scheduledAction;
        }

        @Override // p658rx.Subscription
        public boolean isUnsubscribed() {
            return this.f27194l.f27645k;
        }

        @Override // p658rx.Subscription
        public void unsubscribe() {
            this.f27194l.unsubscribe();
        }
    }

    /* compiled from: EventLoopsScheduler.java */
    /* renamed from: j0.l.c.b$b */
    public static final class b {

        /* renamed from: a */
        public final int f27200a;

        /* renamed from: b */
        public final c[] f27201b;

        /* renamed from: c */
        public long f27202c;

        public b(ThreadFactory threadFactory, int i) {
            this.f27200a = i;
            this.f27201b = new c[i];
            for (int i2 = 0; i2 < i; i2++) {
                this.f27201b[i2] = new c(threadFactory);
            }
        }

        /* renamed from: a */
        public c m10801a() {
            int i = this.f27200a;
            if (i == 0) {
                return EventLoopsScheduler.f27188b;
            }
            c[] cVarArr = this.f27201b;
            long j = this.f27202c;
            this.f27202c = 1 + j;
            return cVarArr[(int) (j % i)];
        }
    }

    /* compiled from: EventLoopsScheduler.java */
    /* renamed from: j0.l.c.b$c */
    public static final class c extends NewThreadWorker {
        public c(ThreadFactory threadFactory) {
            super(threadFactory);
        }
    }

    static {
        int iIntValue = Integer.getInteger("rx.scheduler.max-computation-threads", 0).intValue();
        int iAvailableProcessors = Runtime.getRuntime().availableProcessors();
        if (iIntValue <= 0 || iIntValue > iAvailableProcessors) {
            iIntValue = iAvailableProcessors;
        }
        f27187a = iIntValue;
        c cVar = new c(RxThreadFactory.f27286j);
        f27188b = cVar;
        cVar.unsubscribe();
        f27189c = new b(null, 0);
    }

    public EventLoopsScheduler(ThreadFactory threadFactory) {
        this.f27190d = threadFactory;
        b bVar = f27189c;
        AtomicReference<b> atomicReference = new AtomicReference<>(bVar);
        this.f27191e = atomicReference;
        b bVar2 = new b(threadFactory, f27187a);
        if (atomicReference.compareAndSet(bVar, bVar2)) {
            return;
        }
        for (c cVar : bVar2.f27201b) {
            cVar.unsubscribe();
        }
    }

    @Override // p658rx.Scheduler
    /* renamed from: a */
    public Scheduler.Worker mo10739a() {
        return new a(this.f27191e.get().m10801a());
    }

    @Override // p637j0.p642l.p645c.SchedulerLifecycle
    public void shutdown() {
        b bVar;
        b bVar2;
        do {
            bVar = this.f27191e.get();
            bVar2 = f27189c;
            if (bVar == bVar2) {
                return;
            }
        } while (!this.f27191e.compareAndSet(bVar, bVar2));
        for (c cVar : bVar.f27201b) {
            cVar.unsubscribe();
        }
    }
}

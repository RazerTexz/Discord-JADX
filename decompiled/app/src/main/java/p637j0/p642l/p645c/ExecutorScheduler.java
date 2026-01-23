package p637j0.p642l.p645c;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import p637j0.p652o.C12774l;
import p637j0.p655r.BooleanSubscription;
import p637j0.p655r.MultipleAssignmentSubscription;
import p637j0.p655r.Subscriptions;
import p658rx.Scheduler;
import p658rx.Subscription;
import p658rx.functions.Action0;
import p658rx.subscriptions.CompositeSubscription;

/* JADX INFO: renamed from: j0.l.c.c, reason: use source file name */
/* JADX INFO: compiled from: ExecutorScheduler.java */
/* JADX INFO: loaded from: classes3.dex */
public final class ExecutorScheduler extends Scheduler {

    /* JADX INFO: renamed from: a */
    public final Executor f27203a;

    /* JADX INFO: renamed from: j0.l.c.c$a */
    /* JADX INFO: compiled from: ExecutorScheduler.java */
    public static final class a extends Scheduler.Worker implements Runnable {

        /* JADX INFO: renamed from: j */
        public final Executor f27204j;

        /* JADX INFO: renamed from: n */
        public final ScheduledExecutorService f27208n;

        /* JADX INFO: renamed from: l */
        public final ConcurrentLinkedQueue<ScheduledAction> f27206l = new ConcurrentLinkedQueue<>();

        /* JADX INFO: renamed from: m */
        public final AtomicInteger f27207m = new AtomicInteger();

        /* JADX INFO: renamed from: k */
        public final CompositeSubscription f27205k = new CompositeSubscription();

        /* JADX INFO: renamed from: j0.l.c.c$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: ExecutorScheduler.java */
        public class C13353a implements Action0 {

            /* JADX INFO: renamed from: j */
            public final /* synthetic */ MultipleAssignmentSubscription f27209j;

            public C13353a(MultipleAssignmentSubscription multipleAssignmentSubscription) {
                this.f27209j = multipleAssignmentSubscription;
            }

            @Override // p658rx.functions.Action0
            public void call() {
                a.this.f27205k.m11138c(this.f27209j);
            }
        }

        /* JADX INFO: renamed from: j0.l.c.c$a$b */
        /* JADX INFO: compiled from: ExecutorScheduler.java */
        public class b implements Action0 {

            /* JADX INFO: renamed from: j */
            public final /* synthetic */ MultipleAssignmentSubscription f27211j;

            /* JADX INFO: renamed from: k */
            public final /* synthetic */ Action0 f27212k;

            /* JADX INFO: renamed from: l */
            public final /* synthetic */ Subscription f27213l;

            public b(MultipleAssignmentSubscription multipleAssignmentSubscription, Action0 action0, Subscription subscription) {
                this.f27211j = multipleAssignmentSubscription;
                this.f27212k = action0;
                this.f27213l = subscription;
            }

            @Override // p658rx.functions.Action0
            public void call() {
                if (this.f27211j.isUnsubscribed()) {
                    return;
                }
                Subscription subscriptionMo10740a = a.this.mo10740a(this.f27212k);
                this.f27211j.m10881a(subscriptionMo10740a);
                if (subscriptionMo10740a.getClass() == ScheduledAction.class) {
                    ((ScheduledAction) subscriptionMo10740a).cancel.m11128a(this.f27213l);
                }
            }
        }

        public a(Executor executor) {
            ScheduledExecutorService scheduledExecutorService;
            this.f27204j = executor;
            ScheduledExecutorService[] scheduledExecutorServiceArr = GenericScheduledExecutorService.f27217c.f27219e.get();
            if (scheduledExecutorServiceArr == GenericScheduledExecutorService.f27215a) {
                scheduledExecutorService = GenericScheduledExecutorService.f27216b;
            } else {
                int i = GenericScheduledExecutorService.f27218d + 1;
                i = i >= scheduledExecutorServiceArr.length ? 0 : i;
                GenericScheduledExecutorService.f27218d = i;
                scheduledExecutorService = scheduledExecutorServiceArr[i];
            }
            this.f27208n = scheduledExecutorService;
        }

        @Override // rx.Scheduler.Worker
        /* JADX INFO: renamed from: a */
        public Subscription mo10740a(Action0 action0) {
            if (this.f27205k.f27656k) {
                return Subscriptions.f27422a;
            }
            ScheduledAction scheduledAction = new ScheduledAction(C12774l.m10865d(action0), this.f27205k);
            this.f27205k.m11136a(scheduledAction);
            this.f27206l.offer(scheduledAction);
            if (this.f27207m.getAndIncrement() == 0) {
                try {
                    this.f27204j.execute(this);
                } catch (RejectedExecutionException e) {
                    this.f27205k.m11138c(scheduledAction);
                    this.f27207m.decrementAndGet();
                    C12774l.m10863b(e);
                    throw e;
                }
            }
            return scheduledAction;
        }

        @Override // rx.Scheduler.Worker
        /* JADX INFO: renamed from: b */
        public Subscription mo10741b(Action0 action0, long j, TimeUnit timeUnit) {
            if (j <= 0) {
                return mo10740a(action0);
            }
            if (this.f27205k.f27656k) {
                return Subscriptions.f27422a;
            }
            Action0 action0M10865d = C12774l.m10865d(action0);
            MultipleAssignmentSubscription multipleAssignmentSubscription = new MultipleAssignmentSubscription();
            MultipleAssignmentSubscription multipleAssignmentSubscription2 = new MultipleAssignmentSubscription();
            multipleAssignmentSubscription2.m10881a(multipleAssignmentSubscription);
            this.f27205k.m11136a(multipleAssignmentSubscription2);
            BooleanSubscription booleanSubscription = new BooleanSubscription(new C13353a(multipleAssignmentSubscription2));
            ScheduledAction scheduledAction = new ScheduledAction(new b(multipleAssignmentSubscription2, action0M10865d, booleanSubscription));
            multipleAssignmentSubscription.m10881a(scheduledAction);
            try {
                scheduledAction.m10807a(this.f27208n.schedule(scheduledAction, j, timeUnit));
                return booleanSubscription;
            } catch (RejectedExecutionException e) {
                C12774l.m10863b(e);
                throw e;
            }
        }

        @Override // p658rx.Subscription
        public boolean isUnsubscribed() {
            return this.f27205k.f27656k;
        }

        @Override // java.lang.Runnable
        public void run() {
            while (!this.f27205k.f27656k) {
                ScheduledAction scheduledActionPoll = this.f27206l.poll();
                if (scheduledActionPoll == null) {
                    return;
                }
                if (!scheduledActionPoll.cancel.f27645k) {
                    if (this.f27205k.f27656k) {
                        this.f27206l.clear();
                        return;
                    }
                    scheduledActionPoll.run();
                }
                if (this.f27207m.decrementAndGet() == 0) {
                    return;
                }
            }
            this.f27206l.clear();
        }

        @Override // p658rx.Subscription
        public void unsubscribe() {
            this.f27205k.unsubscribe();
            this.f27206l.clear();
        }
    }

    public ExecutorScheduler(Executor executor) {
        this.f27203a = executor;
    }

    @Override // p658rx.Scheduler
    /* JADX INFO: renamed from: a */
    public Scheduler.Worker mo10739a() {
        return new a(this.f27203a);
    }
}

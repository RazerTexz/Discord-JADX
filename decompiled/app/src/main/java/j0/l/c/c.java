package j0.l.c;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import rx.Scheduler;
import rx.Subscription;
import rx.functions.Action0;
import rx.subscriptions.CompositeSubscription;

/* compiled from: ExecutorScheduler.java */
/* loaded from: classes3.dex */
public final class c extends Scheduler {
    public final Executor a;

    /* compiled from: ExecutorScheduler.java */
    public static final class a extends Scheduler.Worker implements Runnable {
        public final Executor j;
        public final ScheduledExecutorService n;
        public final ConcurrentLinkedQueue<j> l = new ConcurrentLinkedQueue<>();
        public final AtomicInteger m = new AtomicInteger();
        public final CompositeSubscription k = new CompositeSubscription();

        /* compiled from: ExecutorScheduler.java */
        /* renamed from: j0.l.c.c$a$a, reason: collision with other inner class name */
        public class C0632a implements Action0 {
            public final /* synthetic */ j0.r.b j;

            public C0632a(j0.r.b bVar) {
                this.j = bVar;
            }

            @Override // rx.functions.Action0
            public void call() {
                a.this.k.c(this.j);
            }
        }

        /* compiled from: ExecutorScheduler.java */
        public class b implements Action0 {
            public final /* synthetic */ j0.r.b j;
            public final /* synthetic */ Action0 k;
            public final /* synthetic */ Subscription l;

            public b(j0.r.b bVar, Action0 action0, Subscription subscription) {
                this.j = bVar;
                this.k = action0;
                this.l = subscription;
            }

            @Override // rx.functions.Action0
            public void call() {
                if (this.j.isUnsubscribed()) {
                    return;
                }
                Subscription subscriptionA = a.this.a(this.k);
                this.j.a(subscriptionA);
                if (subscriptionA.getClass() == j.class) {
                    ((j) subscriptionA).cancel.a(this.l);
                }
            }
        }

        public a(Executor executor) {
            ScheduledExecutorService scheduledExecutorService;
            this.j = executor;
            ScheduledExecutorService[] scheduledExecutorServiceArr = d.c.e.get();
            if (scheduledExecutorServiceArr == d.a) {
                scheduledExecutorService = d.f3789b;
            } else {
                int i = d.d + 1;
                i = i >= scheduledExecutorServiceArr.length ? 0 : i;
                d.d = i;
                scheduledExecutorService = scheduledExecutorServiceArr[i];
            }
            this.n = scheduledExecutorService;
        }

        @Override // rx.Scheduler.Worker
        public Subscription a(Action0 action0) {
            if (this.k.k) {
                return j0.r.c.a;
            }
            j jVar = new j(j0.o.l.d(action0), this.k);
            this.k.a(jVar);
            this.l.offer(jVar);
            if (this.m.getAndIncrement() == 0) {
                try {
                    this.j.execute(this);
                } catch (RejectedExecutionException e) {
                    this.k.c(jVar);
                    this.m.decrementAndGet();
                    j0.o.l.b(e);
                    throw e;
                }
            }
            return jVar;
        }

        @Override // rx.Scheduler.Worker
        public Subscription b(Action0 action0, long j, TimeUnit timeUnit) {
            if (j <= 0) {
                return a(action0);
            }
            if (this.k.k) {
                return j0.r.c.a;
            }
            Action0 action0D = j0.o.l.d(action0);
            j0.r.b bVar = new j0.r.b();
            j0.r.b bVar2 = new j0.r.b();
            bVar2.a(bVar);
            this.k.a(bVar2);
            j0.r.a aVar = new j0.r.a(new C0632a(bVar2));
            j jVar = new j(new b(bVar2, action0D, aVar));
            bVar.a(jVar);
            try {
                jVar.a(this.n.schedule(jVar, j, timeUnit));
                return aVar;
            } catch (RejectedExecutionException e) {
                j0.o.l.b(e);
                throw e;
            }
        }

        @Override // rx.Subscription
        public boolean isUnsubscribed() {
            return this.k.k;
        }

        @Override // java.lang.Runnable
        public void run() {
            while (!this.k.k) {
                j jVarPoll = this.l.poll();
                if (jVarPoll == null) {
                    return;
                }
                if (!jVarPoll.cancel.k) {
                    if (this.k.k) {
                        this.l.clear();
                        return;
                    }
                    jVarPoll.run();
                }
                if (this.m.decrementAndGet() == 0) {
                    return;
                }
            }
            this.l.clear();
        }

        @Override // rx.Subscription
        public void unsubscribe() {
            this.k.unsubscribe();
            this.l.clear();
        }
    }

    public c(Executor executor) {
        this.a = executor;
    }

    @Override // rx.Scheduler
    public Scheduler.Worker a() {
        return new a(this.a);
    }
}

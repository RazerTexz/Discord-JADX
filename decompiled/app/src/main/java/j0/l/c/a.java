package j0.l.c;

import j0.l.c.j;
import java.util.Objects;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import rx.Scheduler;
import rx.Subscription;
import rx.functions.Action0;
import rx.subscriptions.CompositeSubscription;

/* compiled from: CachedThreadScheduler.java */
/* loaded from: classes3.dex */
public final class a extends Scheduler implements k {
    public static final long a;

    /* renamed from: b, reason: collision with root package name */
    public static final TimeUnit f3785b = TimeUnit.SECONDS;
    public static final c c;
    public static final C0626a d;
    public final ThreadFactory e;
    public final AtomicReference<C0626a> f;

    /* compiled from: CachedThreadScheduler.java */
    /* renamed from: j0.l.c.a$a, reason: collision with other inner class name */
    public static final class C0626a {
        public final ThreadFactory a;

        /* renamed from: b, reason: collision with root package name */
        public final long f3786b;
        public final ConcurrentLinkedQueue<c> c;
        public final CompositeSubscription d;
        public final ScheduledExecutorService e;
        public final Future<?> f;

        /* compiled from: CachedThreadScheduler.java */
        /* renamed from: j0.l.c.a$a$a, reason: collision with other inner class name */
        public class ThreadFactoryC0627a implements ThreadFactory {
            public final /* synthetic */ ThreadFactory j;

            public ThreadFactoryC0627a(C0626a c0626a, ThreadFactory threadFactory) {
                this.j = threadFactory;
            }

            @Override // java.util.concurrent.ThreadFactory
            public Thread newThread(Runnable runnable) {
                Thread threadNewThread = this.j.newThread(runnable);
                threadNewThread.setName(threadNewThread.getName() + " (Evictor)");
                return threadNewThread;
            }
        }

        /* compiled from: CachedThreadScheduler.java */
        /* renamed from: j0.l.c.a$a$b */
        public class b implements Runnable {
            public b() {
            }

            @Override // java.lang.Runnable
            public void run() {
                C0626a c0626a = C0626a.this;
                if (c0626a.c.isEmpty()) {
                    return;
                }
                long jNanoTime = System.nanoTime();
                for (c cVar : c0626a.c) {
                    if (cVar.r > jNanoTime) {
                        return;
                    }
                    if (c0626a.c.remove(cVar)) {
                        c0626a.d.c(cVar);
                    }
                }
            }
        }

        public C0626a(ThreadFactory threadFactory, long j, TimeUnit timeUnit) throws SecurityException {
            ScheduledFuture<?> scheduledFutureScheduleWithFixedDelay;
            this.a = threadFactory;
            long nanos = timeUnit != null ? timeUnit.toNanos(j) : 0L;
            this.f3786b = nanos;
            this.c = new ConcurrentLinkedQueue<>();
            this.d = new CompositeSubscription();
            ScheduledExecutorService scheduledExecutorServiceNewScheduledThreadPool = null;
            if (timeUnit != null) {
                scheduledExecutorServiceNewScheduledThreadPool = Executors.newScheduledThreadPool(1, new ThreadFactoryC0627a(this, threadFactory));
                g.g(scheduledExecutorServiceNewScheduledThreadPool);
                scheduledFutureScheduleWithFixedDelay = scheduledExecutorServiceNewScheduledThreadPool.scheduleWithFixedDelay(new b(), nanos, nanos, TimeUnit.NANOSECONDS);
            } else {
                scheduledFutureScheduleWithFixedDelay = null;
            }
            this.e = scheduledExecutorServiceNewScheduledThreadPool;
            this.f = scheduledFutureScheduleWithFixedDelay;
        }

        public void a() {
            try {
                Future<?> future = this.f;
                if (future != null) {
                    future.cancel(true);
                }
                ScheduledExecutorService scheduledExecutorService = this.e;
                if (scheduledExecutorService != null) {
                    scheduledExecutorService.shutdownNow();
                }
            } finally {
                this.d.unsubscribe();
            }
        }
    }

    /* compiled from: CachedThreadScheduler.java */
    public static final class b extends Scheduler.Worker implements Action0 {
        public final C0626a k;
        public final c l;
        public final CompositeSubscription j = new CompositeSubscription();
        public final AtomicBoolean m = new AtomicBoolean();

        /* compiled from: CachedThreadScheduler.java */
        /* renamed from: j0.l.c.a$b$a, reason: collision with other inner class name */
        public class C0628a implements Action0 {
            public final /* synthetic */ Action0 j;

            public C0628a(Action0 action0) {
                this.j = action0;
            }

            @Override // rx.functions.Action0
            public void call() {
                if (b.this.j.k) {
                    return;
                }
                this.j.call();
            }
        }

        public b(C0626a c0626a) {
            c cVar;
            c cVar2;
            this.k = c0626a;
            if (c0626a.d.k) {
                cVar2 = a.c;
            } else {
                while (true) {
                    if (c0626a.c.isEmpty()) {
                        cVar = new c(c0626a.a);
                        c0626a.d.a(cVar);
                        break;
                    } else {
                        cVar = c0626a.c.poll();
                        if (cVar != null) {
                            break;
                        }
                    }
                }
                cVar2 = cVar;
            }
            this.l = cVar2;
        }

        @Override // rx.Scheduler.Worker
        public Subscription a(Action0 action0) {
            return b(action0, 0L, null);
        }

        @Override // rx.Scheduler.Worker
        public Subscription b(Action0 action0, long j, TimeUnit timeUnit) {
            if (this.j.k) {
                return j0.r.c.a;
            }
            j jVarF = this.l.f(new C0628a(action0), j, timeUnit);
            this.j.a(jVarF);
            jVarF.cancel.a(new j.c(jVarF, this.j));
            return jVarF;
        }

        @Override // rx.functions.Action0
        public void call() {
            C0626a c0626a = this.k;
            c cVar = this.l;
            Objects.requireNonNull(c0626a);
            cVar.r = System.nanoTime() + c0626a.f3786b;
            c0626a.c.offer(cVar);
        }

        @Override // rx.Subscription
        public boolean isUnsubscribed() {
            return this.j.k;
        }

        @Override // rx.Subscription
        public void unsubscribe() {
            if (this.m.compareAndSet(false, true)) {
                this.l.a(this);
            }
            this.j.unsubscribe();
        }
    }

    /* compiled from: CachedThreadScheduler.java */
    public static final class c extends g {
        public long r;

        public c(ThreadFactory threadFactory) {
            super(threadFactory);
            this.r = 0L;
        }
    }

    static {
        c cVar = new c(j0.l.e.j.j);
        c = cVar;
        cVar.unsubscribe();
        C0626a c0626a = new C0626a(null, 0L, null);
        d = c0626a;
        c0626a.a();
        a = Integer.getInteger("rx.io-scheduler.keepalive", 60).intValue();
    }

    public a(ThreadFactory threadFactory) {
        this.e = threadFactory;
        C0626a c0626a = d;
        AtomicReference<C0626a> atomicReference = new AtomicReference<>(c0626a);
        this.f = atomicReference;
        C0626a c0626a2 = new C0626a(threadFactory, a, f3785b);
        if (atomicReference.compareAndSet(c0626a, c0626a2)) {
            return;
        }
        c0626a2.a();
    }

    @Override // rx.Scheduler
    public Scheduler.Worker a() {
        return new b(this.f.get());
    }

    @Override // j0.l.c.k
    public void shutdown() {
        C0626a c0626a;
        C0626a c0626a2;
        do {
            c0626a = this.f.get();
            c0626a2 = d;
            if (c0626a == c0626a2) {
                return;
            }
        } while (!this.f.compareAndSet(c0626a, c0626a2));
        c0626a.a();
    }
}

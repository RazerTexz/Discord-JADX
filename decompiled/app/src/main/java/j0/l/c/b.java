package j0.l.c;

import java.util.Objects;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import rx.Scheduler;
import rx.Subscription;
import rx.functions.Action0;
import rx.internal.util.SubscriptionList;
import rx.subscriptions.CompositeSubscription;

/* compiled from: EventLoopsScheduler.java */
/* loaded from: classes3.dex */
public final class b extends Scheduler implements k {
    public static final int a;

    /* renamed from: b, reason: collision with root package name */
    public static final c f3787b;
    public static final C0631b c;
    public final ThreadFactory d;
    public final AtomicReference<C0631b> e;

    /* compiled from: EventLoopsScheduler.java */
    public static final class a extends Scheduler.Worker {
        public final SubscriptionList j;
        public final CompositeSubscription k;
        public final SubscriptionList l;
        public final c m;

        /* compiled from: EventLoopsScheduler.java */
        /* renamed from: j0.l.c.b$a$a, reason: collision with other inner class name */
        public class C0629a implements Action0 {
            public final /* synthetic */ Action0 j;

            public C0629a(Action0 action0) {
                this.j = action0;
            }

            @Override // rx.functions.Action0
            public void call() {
                if (a.this.l.k) {
                    return;
                }
                this.j.call();
            }
        }

        /* compiled from: EventLoopsScheduler.java */
        /* renamed from: j0.l.c.b$a$b, reason: collision with other inner class name */
        public class C0630b implements Action0 {
            public final /* synthetic */ Action0 j;

            public C0630b(Action0 action0) {
                this.j = action0;
            }

            @Override // rx.functions.Action0
            public void call() {
                if (a.this.l.k) {
                    return;
                }
                this.j.call();
            }
        }

        public a(c cVar) {
            SubscriptionList subscriptionList = new SubscriptionList();
            this.j = subscriptionList;
            CompositeSubscription compositeSubscription = new CompositeSubscription();
            this.k = compositeSubscription;
            this.l = new SubscriptionList(subscriptionList, compositeSubscription);
            this.m = cVar;
        }

        @Override // rx.Scheduler.Worker
        public Subscription a(Action0 action0) {
            if (this.l.k) {
                return j0.r.c.a;
            }
            c cVar = this.m;
            C0629a c0629a = new C0629a(action0);
            SubscriptionList subscriptionList = this.j;
            Objects.requireNonNull(cVar);
            j jVar = new j(j0.o.l.d(c0629a), subscriptionList);
            subscriptionList.a(jVar);
            jVar.a(cVar.p.submit(jVar));
            return jVar;
        }

        @Override // rx.Scheduler.Worker
        public Subscription b(Action0 action0, long j, TimeUnit timeUnit) {
            if (this.l.k) {
                return j0.r.c.a;
            }
            c cVar = this.m;
            C0630b c0630b = new C0630b(action0);
            CompositeSubscription compositeSubscription = this.k;
            Objects.requireNonNull(cVar);
            j jVar = new j(j0.o.l.d(c0630b), compositeSubscription);
            compositeSubscription.a(jVar);
            jVar.a(j <= 0 ? cVar.p.submit(jVar) : cVar.p.schedule(jVar, j, timeUnit));
            return jVar;
        }

        @Override // rx.Subscription
        public boolean isUnsubscribed() {
            return this.l.k;
        }

        @Override // rx.Subscription
        public void unsubscribe() {
            this.l.unsubscribe();
        }
    }

    /* compiled from: EventLoopsScheduler.java */
    /* renamed from: j0.l.c.b$b, reason: collision with other inner class name */
    public static final class C0631b {
        public final int a;

        /* renamed from: b, reason: collision with root package name */
        public final c[] f3788b;
        public long c;

        public C0631b(ThreadFactory threadFactory, int i) {
            this.a = i;
            this.f3788b = new c[i];
            for (int i2 = 0; i2 < i; i2++) {
                this.f3788b[i2] = new c(threadFactory);
            }
        }

        public c a() {
            int i = this.a;
            if (i == 0) {
                return b.f3787b;
            }
            c[] cVarArr = this.f3788b;
            long j = this.c;
            this.c = 1 + j;
            return cVarArr[(int) (j % i)];
        }
    }

    /* compiled from: EventLoopsScheduler.java */
    public static final class c extends g {
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
        a = iIntValue;
        c cVar = new c(j0.l.e.j.j);
        f3787b = cVar;
        cVar.unsubscribe();
        c = new C0631b(null, 0);
    }

    public b(ThreadFactory threadFactory) {
        this.d = threadFactory;
        C0631b c0631b = c;
        AtomicReference<C0631b> atomicReference = new AtomicReference<>(c0631b);
        this.e = atomicReference;
        C0631b c0631b2 = new C0631b(threadFactory, a);
        if (atomicReference.compareAndSet(c0631b, c0631b2)) {
            return;
        }
        for (c cVar : c0631b2.f3788b) {
            cVar.unsubscribe();
        }
    }

    @Override // rx.Scheduler
    public Scheduler.Worker a() {
        return new a(this.e.get().a());
    }

    @Override // j0.l.c.k
    public void shutdown() {
        C0631b c0631b;
        C0631b c0631b2;
        do {
            c0631b = this.e.get();
            c0631b2 = c;
            if (c0631b == c0631b2) {
                return;
            }
        } while (!this.e.compareAndSet(c0631b, c0631b2));
        for (c cVar : c0631b.f3788b) {
            cVar.unsubscribe();
        }
    }
}

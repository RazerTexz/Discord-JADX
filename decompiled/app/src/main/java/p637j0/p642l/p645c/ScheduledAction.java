package p637j0.p642l.p645c;

import java.util.List;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import p637j0.p652o.C12774l;
import p658rx.Subscription;
import p658rx.exceptions.OnErrorNotImplementedException;
import p658rx.functions.Action0;
import p658rx.internal.util.SubscriptionList;
import p658rx.subscriptions.CompositeSubscription;

/* compiled from: ScheduledAction.java */
/* renamed from: j0.l.c.j, reason: use source file name */
/* loaded from: classes3.dex */
public final class ScheduledAction extends AtomicReference<Thread> implements Runnable, Subscription {
    private static final long serialVersionUID = -3962399486978279857L;
    public final Action0 action;
    public final SubscriptionList cancel;

    /* compiled from: ScheduledAction.java */
    /* renamed from: j0.l.c.j$a */
    public final class a implements Subscription {

        /* renamed from: j */
        public final Future<?> f27243j;

        public a(Future<?> future) {
            this.f27243j = future;
        }

        @Override // p658rx.Subscription
        public boolean isUnsubscribed() {
            return this.f27243j.isCancelled();
        }

        @Override // p658rx.Subscription
        public void unsubscribe() {
            if (ScheduledAction.this.get() != Thread.currentThread()) {
                this.f27243j.cancel(true);
            } else {
                this.f27243j.cancel(false);
            }
        }
    }

    /* compiled from: ScheduledAction.java */
    /* renamed from: j0.l.c.j$b */
    public static final class b extends AtomicBoolean implements Subscription {
        private static final long serialVersionUID = 247232374289553518L;
        public final SubscriptionList parent;

        /* renamed from: s */
        public final ScheduledAction f27245s;

        public b(ScheduledAction scheduledAction, SubscriptionList subscriptionList) {
            this.f27245s = scheduledAction;
            this.parent = subscriptionList;
        }

        @Override // p658rx.Subscription
        public boolean isUnsubscribed() {
            return this.f27245s.cancel.f27645k;
        }

        @Override // p658rx.Subscription
        public void unsubscribe() {
            if (compareAndSet(false, true)) {
                SubscriptionList subscriptionList = this.parent;
                ScheduledAction scheduledAction = this.f27245s;
                if (subscriptionList.f27645k) {
                    return;
                }
                synchronized (subscriptionList) {
                    List<Subscription> list = subscriptionList.f27644j;
                    if (!subscriptionList.f27645k && list != null) {
                        boolean zRemove = list.remove(scheduledAction);
                        if (zRemove) {
                            scheduledAction.unsubscribe();
                        }
                    }
                }
            }
        }
    }

    /* compiled from: ScheduledAction.java */
    /* renamed from: j0.l.c.j$c */
    public static final class c extends AtomicBoolean implements Subscription {
        private static final long serialVersionUID = 247232374289553518L;
        public final CompositeSubscription parent;

        /* renamed from: s */
        public final ScheduledAction f27246s;

        public c(ScheduledAction scheduledAction, CompositeSubscription compositeSubscription) {
            this.f27246s = scheduledAction;
            this.parent = compositeSubscription;
        }

        @Override // p658rx.Subscription
        public boolean isUnsubscribed() {
            return this.f27246s.cancel.f27645k;
        }

        @Override // p658rx.Subscription
        public void unsubscribe() {
            if (compareAndSet(false, true)) {
                this.parent.m11138c(this.f27246s);
            }
        }
    }

    public ScheduledAction(Action0 action0) {
        this.action = action0;
        this.cancel = new SubscriptionList();
    }

    /* renamed from: a */
    public void m10807a(Future<?> future) {
        this.cancel.m11128a(new a(future));
    }

    @Override // p658rx.Subscription
    public boolean isUnsubscribed() {
        return this.cancel.f27645k;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            try {
                lazySet(Thread.currentThread());
                this.action.call();
            } finally {
                unsubscribe();
            }
        } catch (OnErrorNotImplementedException e) {
            IllegalStateException illegalStateException = new IllegalStateException("Exception thrown on Scheduler.Worker thread. Add `onError` handling.", e);
            C12774l.m10863b(illegalStateException);
            Thread threadCurrentThread = Thread.currentThread();
            threadCurrentThread.getUncaughtExceptionHandler().uncaughtException(threadCurrentThread, illegalStateException);
        } catch (Throwable th) {
            IllegalStateException illegalStateException2 = new IllegalStateException("Fatal Exception thrown on Scheduler.Worker thread.", th);
            C12774l.m10863b(illegalStateException2);
            Thread threadCurrentThread2 = Thread.currentThread();
            threadCurrentThread2.getUncaughtExceptionHandler().uncaughtException(threadCurrentThread2, illegalStateException2);
        }
    }

    @Override // p658rx.Subscription
    public void unsubscribe() {
        if (this.cancel.f27645k) {
            return;
        }
        this.cancel.unsubscribe();
    }

    public ScheduledAction(Action0 action0, CompositeSubscription compositeSubscription) {
        this.action = action0;
        this.cancel = new SubscriptionList(new c(this, compositeSubscription));
    }

    public ScheduledAction(Action0 action0, SubscriptionList subscriptionList) {
        this.action = action0;
        this.cancel = new SubscriptionList(new b(this, subscriptionList));
    }
}

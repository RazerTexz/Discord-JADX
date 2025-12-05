package p637j0.p638j.p640b;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import p637j0.p638j.p639a.RxAndroidPlugins;
import p637j0.p638j.p639a.RxAndroidSchedulersHook;
import p637j0.p652o.RxJavaPlugins;
import p637j0.p655r.Subscriptions;
import p658rx.Scheduler;
import p658rx.Subscription;
import p658rx.exceptions.OnErrorNotImplementedException;
import p658rx.functions.Action0;

/* compiled from: LooperScheduler.java */
/* renamed from: j0.j.b.b, reason: use source file name */
/* loaded from: classes3.dex */
public class LooperScheduler extends Scheduler {

    /* renamed from: a */
    public final Handler f26703a;

    /* compiled from: LooperScheduler.java */
    /* renamed from: j0.j.b.b$a */
    public static class a extends Scheduler.Worker {

        /* renamed from: j */
        public final Handler f26704j;

        /* renamed from: k */
        public final RxAndroidSchedulersHook f26705k = RxAndroidPlugins.f26698a.m10737a();

        /* renamed from: l */
        public volatile boolean f26706l;

        public a(Handler handler) {
            this.f26704j = handler;
        }

        @Override // rx.Scheduler.Worker
        /* renamed from: a */
        public Subscription mo10740a(Action0 action0) {
            return mo10741b(action0, 0L, TimeUnit.MILLISECONDS);
        }

        @Override // rx.Scheduler.Worker
        /* renamed from: b */
        public Subscription mo10741b(Action0 action0, long j, TimeUnit timeUnit) {
            if (this.f26706l) {
                return Subscriptions.f27422a;
            }
            Objects.requireNonNull(this.f26705k);
            Handler handler = this.f26704j;
            b bVar = new b(action0, handler);
            Message messageObtain = Message.obtain(handler, bVar);
            messageObtain.obj = this;
            this.f26704j.sendMessageDelayed(messageObtain, timeUnit.toMillis(j));
            if (!this.f26706l) {
                return bVar;
            }
            this.f26704j.removeCallbacks(bVar);
            return Subscriptions.f27422a;
        }

        @Override // p658rx.Subscription
        public boolean isUnsubscribed() {
            return this.f26706l;
        }

        @Override // p658rx.Subscription
        public void unsubscribe() {
            this.f26706l = true;
            this.f26704j.removeCallbacksAndMessages(this);
        }
    }

    /* compiled from: LooperScheduler.java */
    /* renamed from: j0.j.b.b$b */
    public static final class b implements Runnable, Subscription {

        /* renamed from: j */
        public final Action0 f26707j;

        /* renamed from: k */
        public final Handler f26708k;

        /* renamed from: l */
        public volatile boolean f26709l;

        public b(Action0 action0, Handler handler) {
            this.f26707j = action0;
            this.f26708k = handler;
        }

        @Override // p658rx.Subscription
        public boolean isUnsubscribed() {
            return this.f26709l;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.f26707j.call();
            } catch (Throwable th) {
                IllegalStateException illegalStateException = th instanceof OnErrorNotImplementedException ? new IllegalStateException("Exception thrown on Scheduler.Worker thread. Add `onError` handling.", th) : new IllegalStateException("Fatal Exception thrown on Scheduler.Worker thread.", th);
                Objects.requireNonNull(RxJavaPlugins.f27384a.m10869b());
                Thread threadCurrentThread = Thread.currentThread();
                threadCurrentThread.getUncaughtExceptionHandler().uncaughtException(threadCurrentThread, illegalStateException);
            }
        }

        @Override // p658rx.Subscription
        public void unsubscribe() {
            this.f26709l = true;
            this.f26708k.removeCallbacks(this);
        }
    }

    public LooperScheduler(Looper looper) {
        this.f26703a = new Handler(looper);
    }

    @Override // p658rx.Scheduler
    /* renamed from: a */
    public Scheduler.Worker mo10739a() {
        return new a(this.f26703a);
    }
}

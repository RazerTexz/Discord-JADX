package j0.j.b;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import j0.o.o;
import j0.r.c;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import rx.Scheduler;
import rx.Subscription;
import rx.exceptions.OnErrorNotImplementedException;
import rx.functions.Action0;

/* compiled from: LooperScheduler.java */
/* loaded from: classes3.dex */
public class b extends Scheduler {
    public final Handler a;

    /* compiled from: LooperScheduler.java */
    public static class a extends Scheduler.Worker {
        public final Handler j;
        public final j0.j.a.b k = j0.j.a.a.a.a();
        public volatile boolean l;

        public a(Handler handler) {
            this.j = handler;
        }

        @Override // rx.Scheduler.Worker
        public Subscription a(Action0 action0) {
            return b(action0, 0L, TimeUnit.MILLISECONDS);
        }

        @Override // rx.Scheduler.Worker
        public Subscription b(Action0 action0, long j, TimeUnit timeUnit) {
            if (this.l) {
                return c.a;
            }
            Objects.requireNonNull(this.k);
            Handler handler = this.j;
            RunnableC0619b runnableC0619b = new RunnableC0619b(action0, handler);
            Message messageObtain = Message.obtain(handler, runnableC0619b);
            messageObtain.obj = this;
            this.j.sendMessageDelayed(messageObtain, timeUnit.toMillis(j));
            if (!this.l) {
                return runnableC0619b;
            }
            this.j.removeCallbacks(runnableC0619b);
            return c.a;
        }

        @Override // rx.Subscription
        public boolean isUnsubscribed() {
            return this.l;
        }

        @Override // rx.Subscription
        public void unsubscribe() {
            this.l = true;
            this.j.removeCallbacksAndMessages(this);
        }
    }

    /* compiled from: LooperScheduler.java */
    /* renamed from: j0.j.b.b$b, reason: collision with other inner class name */
    public static final class RunnableC0619b implements Runnable, Subscription {
        public final Action0 j;
        public final Handler k;
        public volatile boolean l;

        public RunnableC0619b(Action0 action0, Handler handler) {
            this.j = action0;
            this.k = handler;
        }

        @Override // rx.Subscription
        public boolean isUnsubscribed() {
            return this.l;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.j.call();
            } catch (Throwable th) {
                IllegalStateException illegalStateException = th instanceof OnErrorNotImplementedException ? new IllegalStateException("Exception thrown on Scheduler.Worker thread. Add `onError` handling.", th) : new IllegalStateException("Fatal Exception thrown on Scheduler.Worker thread.", th);
                Objects.requireNonNull(o.a.b());
                Thread threadCurrentThread = Thread.currentThread();
                threadCurrentThread.getUncaughtExceptionHandler().uncaughtException(threadCurrentThread, illegalStateException);
            }
        }

        @Override // rx.Subscription
        public void unsubscribe() {
            this.l = true;
            this.k.removeCallbacks(this);
        }
    }

    public b(Looper looper) {
        this.a = new Handler(looper);
    }

    @Override // rx.Scheduler
    public Scheduler.Worker a() {
        return new a(this.a);
    }
}

package com.discord.utilities.rx;

import androidx.core.app.NotificationCompat;
import androidx.exifinterface.media.ExifInterface;
import b.i.a.f.e.o.f;
import d0.z.d.m;
import j0.l.a.r;
import j0.p.a;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.Scheduler;
import rx.Subscriber;
import rx.Subscription;
import rx.observers.SerializedSubscriber;

/* compiled from: OperatorBufferedDelay.kt */
/* loaded from: classes2.dex */
public final class OperatorBufferedDelay<T> implements Observable.b<List<? extends T>, T> {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final Scheduler scheduler;
    private final int size;
    private final long timeSpan;
    private final TimeUnit timeUnit;

    /* compiled from: OperatorBufferedDelay.kt */
    public static final class Companion {
        private Companion() {
        }

        public static /* synthetic */ Observable bufferedDelay$default(Companion companion, Observable observable, long j, TimeUnit timeUnit, int i, Scheduler scheduler, int i2, Object obj) {
            if ((i2 & 2) != 0) {
                timeUnit = TimeUnit.MILLISECONDS;
            }
            TimeUnit timeUnit2 = timeUnit;
            if ((i2 & 8) != 0) {
                scheduler = a.a();
                m.checkNotNullExpressionValue(scheduler, "Schedulers.computation()");
            }
            return companion.bufferedDelay(observable, j, timeUnit2, i, scheduler);
        }

        public final <T> Observable<List<T>> bufferedDelay(Observable<T> observable, long j, TimeUnit timeUnit, int i, Scheduler scheduler) {
            m.checkNotNullParameter(observable, "$this$bufferedDelay");
            m.checkNotNullParameter(timeUnit, "timeUnit");
            m.checkNotNullParameter(scheduler, "scheduler");
            Observable<List<T>> observableH0 = Observable.h0(new r(observable.j, new OperatorBufferedDelay(j, timeUnit, i, scheduler)));
            m.checkNotNullExpressionValue(observableH0, "this.lift(OperatorBuffer…meUnit, size, scheduler))");
            return observableH0;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: OperatorBufferedDelay.kt */
    public final class ExactSubscriber<T> extends Subscriber<T> {
        private List<T> buffer;
        private final Subscriber<List<T>> child;
        private final Scheduler.Worker inner;
        private Subscription ongoingBufferTimer;
        public final /* synthetic */ OperatorBufferedDelay this$0;

        public ExactSubscriber(OperatorBufferedDelay operatorBufferedDelay, Subscriber<List<T>> subscriber, Scheduler.Worker worker) {
            m.checkNotNullParameter(subscriber, "child");
            m.checkNotNullParameter(worker, "inner");
            this.this$0 = operatorBufferedDelay;
            this.child = subscriber;
            this.inner = worker;
            this.buffer = new ArrayList();
        }

        private final void cancelBufferTimer() {
            Subscription subscription = this.ongoingBufferTimer;
            if (subscription != null) {
                subscription.unsubscribe();
            }
            this.ongoingBufferTimer = null;
        }

        private final List<T> getAndSetBuffer(List<T> newValue) {
            List<T> list = this.buffer;
            this.buffer = newValue;
            return list;
        }

        private final void publish(List<? extends T> bufferedValues) {
            try {
                if (!bufferedValues.isEmpty()) {
                    this.child.onNext(bufferedValues);
                }
            } catch (Throwable th) {
                f.o1(th);
                onError(th);
            }
        }

        private final void tryEmit(List<T> newBufferValue) {
            synchronized (this) {
                cancelBufferTimer();
                if (this.buffer == null) {
                    return;
                }
                List<T> andSetBuffer = getAndSetBuffer(newBufferValue);
                if (andSetBuffer != null) {
                    publish(andSetBuffer);
                }
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void tryEmit$default(ExactSubscriber exactSubscriber, List list, int i, Object obj) {
            if ((i & 1) != 0) {
                list = new ArrayList();
            }
            exactSubscriber.tryEmit(list);
        }

        public final Subscriber<List<T>> getChild() {
            return this.child;
        }

        public final Scheduler.Worker getInner() {
            return this.inner;
        }

        @Override // j0.g
        public void onCompleted() {
            this.inner.unsubscribe();
            tryEmit(null);
            this.child.onCompleted();
            unsubscribe();
        }

        @Override // j0.g
        public void onError(Throwable e) {
            tryEmit(null);
            this.child.onError(e);
            unsubscribe();
        }

        @Override // j0.g
        public void onNext(T t) {
            synchronized (this) {
                List<T> list = this.buffer;
                if (list != null) {
                    list.add(t);
                    if (list.size() < this.this$0.getSize()) {
                        if (this.ongoingBufferTimer == null) {
                            this.ongoingBufferTimer = this.inner.b(new OperatorBufferedDelay$ExactSubscriber$onNext$$inlined$synchronized$lambda$1(this, t), this.this$0.getTimeSpan(), this.this$0.getTimeUnit());
                        }
                    } else {
                        cancelBufferTimer();
                        List<T> andSetBuffer = getAndSetBuffer(new ArrayList());
                        if (andSetBuffer != null) {
                            publish(andSetBuffer);
                        }
                    }
                }
            }
        }
    }

    public OperatorBufferedDelay(long j, TimeUnit timeUnit, int i, Scheduler scheduler) {
        m.checkNotNullParameter(timeUnit, "timeUnit");
        m.checkNotNullParameter(scheduler, "scheduler");
        this.timeSpan = j;
        this.timeUnit = timeUnit;
        this.size = i;
        this.scheduler = scheduler;
    }

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ Object call(Object obj) {
        return call((Subscriber) obj);
    }

    public final Scheduler getScheduler() {
        return this.scheduler;
    }

    public final int getSize() {
        return this.size;
    }

    public final long getTimeSpan() {
        return this.timeSpan;
    }

    public final TimeUnit getTimeUnit() {
        return this.timeUnit;
    }

    public /* synthetic */ OperatorBufferedDelay(long j, TimeUnit timeUnit, int i, Scheduler scheduler, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, (i2 & 2) != 0 ? TimeUnit.MILLISECONDS : timeUnit, i, scheduler);
    }

    public Subscriber<? super T> call(Subscriber<? super List<? extends T>> childSubscriber) {
        m.checkNotNullParameter(childSubscriber, "childSubscriber");
        Scheduler.Worker workerA = this.scheduler.a();
        SerializedSubscriber serializedSubscriber = new SerializedSubscriber(childSubscriber);
        m.checkNotNullExpressionValue(workerA, "inner");
        ExactSubscriber exactSubscriber = new ExactSubscriber(this, serializedSubscriber, workerA);
        exactSubscriber.add(workerA);
        childSubscriber.add(exactSubscriber);
        return exactSubscriber;
    }
}

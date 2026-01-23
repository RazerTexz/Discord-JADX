package com.discord.utilities.p501rx;

import androidx.core.app.NotificationCompat;
import androidx.exifinterface.media.ExifInterface;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p507d0.p592z.p594d.Intrinsics3;
import p637j0.p642l.p643a.OnSubscribeLift;
import p637j0.p653p.Schedulers2;
import p658rx.Observable;
import p658rx.Scheduler;
import p658rx.Subscriber;
import p658rx.Subscription;
import p658rx.observers.SerializedSubscriber;

/* JADX INFO: compiled from: OperatorBufferedDelay.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class OperatorBufferedDelay<T> implements Observable.InterfaceC13006b<List<? extends T>, T> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final Scheduler scheduler;
    private final int size;
    private final long timeSpan;
    private final TimeUnit timeUnit;

    /* JADX INFO: compiled from: OperatorBufferedDelay.kt */
    public static final class Companion {
        private Companion() {
        }

        public static /* synthetic */ Observable bufferedDelay$default(Companion companion, Observable observable, long j, TimeUnit timeUnit, int i, Scheduler scheduler, int i2, Object obj) {
            if ((i2 & 2) != 0) {
                timeUnit = TimeUnit.MILLISECONDS;
            }
            TimeUnit timeUnit2 = timeUnit;
            if ((i2 & 8) != 0) {
                scheduler = Schedulers2.m10873a();
                Intrinsics3.checkNotNullExpressionValue(scheduler, "Schedulers.computation()");
            }
            return companion.bufferedDelay(observable, j, timeUnit2, i, scheduler);
        }

        public final <T> Observable<List<T>> bufferedDelay(Observable<T> observable, long j, TimeUnit timeUnit, int i, Scheduler scheduler) {
            Intrinsics3.checkNotNullParameter(observable, "$this$bufferedDelay");
            Intrinsics3.checkNotNullParameter(timeUnit, "timeUnit");
            Intrinsics3.checkNotNullParameter(scheduler, "scheduler");
            Observable<List<T>> observableM11074h0 = Observable.m11074h0(new OnSubscribeLift(observable.f27640j, new OperatorBufferedDelay(j, timeUnit, i, scheduler)));
            Intrinsics3.checkNotNullExpressionValue(observableM11074h0, "this.lift(OperatorBuffer…meUnit, size, scheduler))");
            return observableM11074h0;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: OperatorBufferedDelay.kt */
    public final class ExactSubscriber<T> extends Subscriber<T> {
        private List<T> buffer;
        private final Subscriber<List<T>> child;
        private final Scheduler.Worker inner;
        private Subscription ongoingBufferTimer;
        public final /* synthetic */ OperatorBufferedDelay this$0;

        public ExactSubscriber(OperatorBufferedDelay operatorBufferedDelay, Subscriber<List<T>> subscriber, Scheduler.Worker worker) {
            Intrinsics3.checkNotNullParameter(subscriber, "child");
            Intrinsics3.checkNotNullParameter(worker, "inner");
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
                C3404f.m4325o1(th);
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

        @Override // p637j0.Observer2
        public void onCompleted() {
            this.inner.unsubscribe();
            tryEmit(null);
            this.child.onCompleted();
            unsubscribe();
        }

        @Override // p637j0.Observer2
        public void onError(Throwable e) {
            tryEmit(null);
            this.child.onError(e);
            unsubscribe();
        }

        @Override // p637j0.Observer2
        public void onNext(T t) {
            synchronized (this) {
                List<T> list = this.buffer;
                if (list != null) {
                    list.add(t);
                    if (list.size() < this.this$0.getSize()) {
                        if (this.ongoingBufferTimer == null) {
                            this.ongoingBufferTimer = this.inner.mo10741b(new OperatorBufferedDelay2(this, t), this.this$0.getTimeSpan(), this.this$0.getTimeUnit());
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
        Intrinsics3.checkNotNullParameter(timeUnit, "timeUnit");
        Intrinsics3.checkNotNullParameter(scheduler, "scheduler");
        this.timeSpan = j;
        this.timeUnit = timeUnit;
        this.size = i;
        this.scheduler = scheduler;
    }

    @Override // p637j0.p641k.Func1
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
        Intrinsics3.checkNotNullParameter(childSubscriber, "childSubscriber");
        Scheduler.Worker workerMo10739a = this.scheduler.mo10739a();
        SerializedSubscriber serializedSubscriber = new SerializedSubscriber(childSubscriber);
        Intrinsics3.checkNotNullExpressionValue(workerMo10739a, "inner");
        ExactSubscriber exactSubscriber = new ExactSubscriber(this, serializedSubscriber, workerMo10739a);
        exactSubscriber.add(workerMo10739a);
        childSubscriber.add(exactSubscriber);
        return exactSubscriber;
    }
}

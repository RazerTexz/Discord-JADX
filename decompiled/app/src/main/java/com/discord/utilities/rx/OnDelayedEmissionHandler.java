package com.discord.utilities.rx;

import android.content.Context;
import androidx.core.app.NotificationCompat;
import androidx.exifinterface.media.ExifInterface;
import com.discord.utilities.error.Error;
import d0.z.d.m;
import d0.z.d.o;
import j0.j.b.a;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.Scheduler;
import rx.Subscriber;
import rx.Subscription;

/* compiled from: OnDelayedEmissionHandler.kt */
/* loaded from: classes2.dex */
public final class OnDelayedEmissionHandler<T> implements Observable.b<T, T> {
    private Subscription delaySubscription;
    private final AtomicBoolean hasFinished;
    private final Function1<Boolean, Unit> onDelayCallback;
    private final Scheduler scheduler;
    private final long timeout;
    private final TimeUnit unit;

    /* compiled from: OnDelayedEmissionHandler.kt */
    /* renamed from: com.discord.utilities.rx.OnDelayedEmissionHandler$call$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function1<Long, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Long l) {
            invoke2(l);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Long l) {
            if (OnDelayedEmissionHandler.access$getHasFinished$p(OnDelayedEmissionHandler.this).get()) {
                return;
            }
            OnDelayedEmissionHandler.access$getOnDelayCallback$p(OnDelayedEmissionHandler.this).invoke(Boolean.TRUE);
        }
    }

    /* compiled from: OnDelayedEmissionHandler.kt */
    /* renamed from: com.discord.utilities.rx.OnDelayedEmissionHandler$call$2, reason: invalid class name */
    public static final class AnonymousClass2 extends o implements Function1<Error, Unit> {
        public final /* synthetic */ OnDelayedEmissionHandler$call$wrappedSubscriber$1 $wrappedSubscriber;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(OnDelayedEmissionHandler$call$wrappedSubscriber$1 onDelayedEmissionHandler$call$wrappedSubscriber$1) {
            super(1);
            this.$wrappedSubscriber = onDelayedEmissionHandler$call$wrappedSubscriber$1;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Error error) {
            invoke2(error);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Error error) {
            m.checkNotNullParameter(error, "error");
            OnDelayedEmissionHandler$call$wrappedSubscriber$1 onDelayedEmissionHandler$call$wrappedSubscriber$1 = this.$wrappedSubscriber;
            Throwable throwable = error.getThrowable();
            m.checkNotNullExpressionValue(throwable, "error.throwable");
            onDelayedEmissionHandler$call$wrappedSubscriber$1.onError(throwable);
        }
    }

    /* compiled from: OnDelayedEmissionHandler.kt */
    /* renamed from: com.discord.utilities.rx.OnDelayedEmissionHandler$call$3, reason: invalid class name */
    public static final class AnonymousClass3 extends o implements Function1<Subscription, Unit> {
        public AnonymousClass3() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Subscription subscription) {
            invoke2(subscription);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Subscription subscription) {
            m.checkNotNullParameter(subscription, "it");
            OnDelayedEmissionHandler.access$setDelaySubscription$p(OnDelayedEmissionHandler.this, subscription);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public OnDelayedEmissionHandler(Function1<? super Boolean, Unit> function1, long j, TimeUnit timeUnit, Scheduler scheduler) {
        m.checkNotNullParameter(function1, "onDelayCallback");
        m.checkNotNullParameter(timeUnit, "unit");
        m.checkNotNullParameter(scheduler, "scheduler");
        this.onDelayCallback = function1;
        this.timeout = j;
        this.unit = timeUnit;
        this.scheduler = scheduler;
        this.hasFinished = new AtomicBoolean(false);
    }

    public static final /* synthetic */ Subscription access$getDelaySubscription$p(OnDelayedEmissionHandler onDelayedEmissionHandler) {
        return onDelayedEmissionHandler.delaySubscription;
    }

    public static final /* synthetic */ AtomicBoolean access$getHasFinished$p(OnDelayedEmissionHandler onDelayedEmissionHandler) {
        return onDelayedEmissionHandler.hasFinished;
    }

    public static final /* synthetic */ Function1 access$getOnDelayCallback$p(OnDelayedEmissionHandler onDelayedEmissionHandler) {
        return onDelayedEmissionHandler.onDelayCallback;
    }

    public static final /* synthetic */ Scheduler access$getScheduler$p(OnDelayedEmissionHandler onDelayedEmissionHandler) {
        return onDelayedEmissionHandler.scheduler;
    }

    public static final /* synthetic */ void access$setDelaySubscription$p(OnDelayedEmissionHandler onDelayedEmissionHandler, Subscription subscription) {
        onDelayedEmissionHandler.delaySubscription = subscription;
    }

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ Object call(Object obj) {
        return call((Subscriber) obj);
    }

    public Subscriber<? super T> call(Subscriber<? super T> subscriber) {
        m.checkNotNullParameter(subscriber, "subscriber");
        OnDelayedEmissionHandler$call$wrappedSubscriber$1 onDelayedEmissionHandler$call$wrappedSubscriber$1 = new OnDelayedEmissionHandler$call$wrappedSubscriber$1(this, subscriber);
        Observable<Long> observableJ = Observable.d0(this.timeout, this.unit).J(this.scheduler);
        m.checkNotNullExpressionValue(observableJ, "Observable\n        .time…    .observeOn(scheduler)");
        AnonymousClass1 anonymousClass1 = new AnonymousClass1();
        ObservableExtensionsKt.appSubscribe$default(observableJ, OnDelayedEmissionHandler.class, (Context) null, new AnonymousClass3(), new AnonymousClass2(onDelayedEmissionHandler$call$wrappedSubscriber$1), (Function0) null, (Function0) null, anonymousClass1, 50, (Object) null);
        return onDelayedEmissionHandler$call$wrappedSubscriber$1;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ OnDelayedEmissionHandler(Function1 function1, long j, TimeUnit timeUnit, Scheduler scheduler, int i, DefaultConstructorMarker defaultConstructorMarker) {
        long j2 = (i & 2) != 0 ? 0L : j;
        TimeUnit timeUnit2 = (i & 4) != 0 ? TimeUnit.MILLISECONDS : timeUnit;
        if ((i & 8) != 0) {
            scheduler = a.a();
            m.checkNotNullExpressionValue(scheduler, "AndroidSchedulers.mainThread()");
        }
        this(function1, j2, timeUnit2, scheduler);
    }
}

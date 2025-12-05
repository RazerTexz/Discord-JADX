package com.discord.utilities.p501rx;

import android.content.Context;
import androidx.core.app.NotificationCompat;
import androidx.exifinterface.media.ExifInterface;
import com.discord.utilities.error.Error;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;
import p637j0.p638j.p640b.AndroidSchedulers;
import p658rx.Observable;
import p658rx.Scheduler;
import p658rx.Subscriber;
import p658rx.Subscription;

/* compiled from: OnDelayedEmissionHandler.kt */
/* loaded from: classes2.dex */
public final class OnDelayedEmissionHandler<T> implements Observable.InterfaceC13006b<T, T> {
    private Subscription delaySubscription;
    private final AtomicBoolean hasFinished;
    private final Function1<Boolean, Unit> onDelayCallback;
    private final Scheduler scheduler;
    private final long timeout;
    private final TimeUnit unit;

    /* compiled from: OnDelayedEmissionHandler.kt */
    /* renamed from: com.discord.utilities.rx.OnDelayedEmissionHandler$call$1 */
    public static final class C68941 extends Lambda implements Function1<Long, Unit> {
        public C68941() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Long l) {
            invoke2(l);
            return Unit.f27425a;
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
    /* renamed from: com.discord.utilities.rx.OnDelayedEmissionHandler$call$2 */
    public static final class C68952 extends Lambda implements Function1<Error, Unit> {
        public final /* synthetic */ OnDelayedEmissionHandler2 $wrappedSubscriber;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C68952(OnDelayedEmissionHandler2 onDelayedEmissionHandler2) {
            super(1);
            this.$wrappedSubscriber = onDelayedEmissionHandler2;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Error error) {
            invoke2(error);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Error error) {
            Intrinsics3.checkNotNullParameter(error, "error");
            OnDelayedEmissionHandler2 onDelayedEmissionHandler2 = this.$wrappedSubscriber;
            Throwable throwable = error.getThrowable();
            Intrinsics3.checkNotNullExpressionValue(throwable, "error.throwable");
            onDelayedEmissionHandler2.onError(throwable);
        }
    }

    /* compiled from: OnDelayedEmissionHandler.kt */
    /* renamed from: com.discord.utilities.rx.OnDelayedEmissionHandler$call$3 */
    public static final class C68963 extends Lambda implements Function1<Subscription, Unit> {
        public C68963() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Subscription subscription) {
            invoke2(subscription);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Subscription subscription) {
            Intrinsics3.checkNotNullParameter(subscription, "it");
            OnDelayedEmissionHandler.access$setDelaySubscription$p(OnDelayedEmissionHandler.this, subscription);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public OnDelayedEmissionHandler(Function1<? super Boolean, Unit> function1, long j, TimeUnit timeUnit, Scheduler scheduler) {
        Intrinsics3.checkNotNullParameter(function1, "onDelayCallback");
        Intrinsics3.checkNotNullParameter(timeUnit, "unit");
        Intrinsics3.checkNotNullParameter(scheduler, "scheduler");
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

    @Override // p637j0.p641k.Func1
    public /* bridge */ /* synthetic */ Object call(Object obj) {
        return call((Subscriber) obj);
    }

    public Subscriber<? super T> call(Subscriber<? super T> subscriber) {
        Intrinsics3.checkNotNullParameter(subscriber, "subscriber");
        OnDelayedEmissionHandler2 onDelayedEmissionHandler2 = new OnDelayedEmissionHandler2(this, subscriber);
        Observable<Long> observableM11084J = Observable.m11068d0(this.timeout, this.unit).m11084J(this.scheduler);
        Intrinsics3.checkNotNullExpressionValue(observableM11084J, "Observable\n        .time…    .observeOn(scheduler)");
        C68941 c68941 = new C68941();
        ObservableExtensionsKt.appSubscribe$default(observableM11084J, OnDelayedEmissionHandler.class, (Context) null, new C68963(), new C68952(onDelayedEmissionHandler2), (Function0) null, (Function0) null, c68941, 50, (Object) null);
        return onDelayedEmissionHandler2;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ OnDelayedEmissionHandler(Function1 function1, long j, TimeUnit timeUnit, Scheduler scheduler, int i, DefaultConstructorMarker defaultConstructorMarker) {
        long j2 = (i & 2) != 0 ? 0L : j;
        TimeUnit timeUnit2 = (i & 4) != 0 ? TimeUnit.MILLISECONDS : timeUnit;
        if ((i & 8) != 0) {
            scheduler = AndroidSchedulers.m10738a();
            Intrinsics3.checkNotNullExpressionValue(scheduler, "AndroidSchedulers.mainThread()");
        }
        this(function1, j2, timeUnit2, scheduler);
    }
}

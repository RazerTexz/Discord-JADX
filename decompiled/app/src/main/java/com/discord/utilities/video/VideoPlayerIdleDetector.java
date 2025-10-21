package com.discord.utilities.video;

import android.content.Context;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import j0.j.b.AndroidSchedulers;
import j0.p.Schedulers2;
import java.util.concurrent.TimeUnit;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.Scheduler;
import rx.Subscription;

/* compiled from: VideoPlayerIdleDetector.kt */
/* loaded from: classes2.dex */
public final class VideoPlayerIdleDetector {
    private final Scheduler backgroundThreadScheduler;
    private final long idleDetectionMs;
    private final Scheduler idleDetectionScheduler;
    private Subscription idleDetectionSubscription;
    private boolean isIdle;
    private final Function1<Boolean, Unit> onIdleStateChanged;

    /* compiled from: VideoPlayerIdleDetector.kt */
    /* renamed from: com.discord.utilities.video.VideoPlayerIdleDetector$beginIdleDetectionTimer$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<Long, Unit> {
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
            VideoPlayerIdleDetector.access$setIdle(VideoPlayerIdleDetector.this, true);
        }
    }

    /* compiled from: VideoPlayerIdleDetector.kt */
    /* renamed from: com.discord.utilities.video.VideoPlayerIdleDetector$beginIdleDetectionTimer$2, reason: invalid class name */
    public static final class AnonymousClass2 extends Lambda implements Function1<Subscription, Unit> {
        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Subscription subscription) {
            invoke2(subscription);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Subscription subscription) {
            Intrinsics3.checkNotNullParameter(subscription, "it");
            VideoPlayerIdleDetector.access$setIdleDetectionSubscription$p(VideoPlayerIdleDetector.this, subscription);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public VideoPlayerIdleDetector(long j, Scheduler scheduler, Scheduler scheduler2, Function1<? super Boolean, Unit> function1) {
        Intrinsics3.checkNotNullParameter(scheduler, "idleDetectionScheduler");
        Intrinsics3.checkNotNullParameter(scheduler2, "backgroundThreadScheduler");
        Intrinsics3.checkNotNullParameter(function1, "onIdleStateChanged");
        this.idleDetectionMs = j;
        this.idleDetectionScheduler = scheduler;
        this.backgroundThreadScheduler = scheduler2;
        this.onIdleStateChanged = function1;
    }

    public static final /* synthetic */ Subscription access$getIdleDetectionSubscription$p(VideoPlayerIdleDetector videoPlayerIdleDetector) {
        return videoPlayerIdleDetector.idleDetectionSubscription;
    }

    public static final /* synthetic */ void access$setIdle(VideoPlayerIdleDetector videoPlayerIdleDetector, boolean z2) {
        videoPlayerIdleDetector.setIdle(z2);
    }

    public static final /* synthetic */ void access$setIdleDetectionSubscription$p(VideoPlayerIdleDetector videoPlayerIdleDetector, Subscription subscription) {
        videoPlayerIdleDetector.idleDetectionSubscription = subscription;
    }

    private final void beginIdleDetectionTimer() {
        cancelIdleDetectionTimer();
        Observable<Long> observableJ = Observable.e0(this.idleDetectionMs, TimeUnit.MILLISECONDS, this.backgroundThreadScheduler).J(this.idleDetectionScheduler);
        Intrinsics3.checkNotNullExpressionValue(observableJ, "Observable\n        .time…n(idleDetectionScheduler)");
        ObservableExtensionsKt.appSubscribe$default(observableJ, VideoPlayerIdleDetector.class, (Context) null, new AnonymousClass2(), (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(), 58, (Object) null);
    }

    private final void cancelIdleDetectionTimer() {
        Subscription subscription = this.idleDetectionSubscription;
        if (subscription != null) {
            subscription.unsubscribe();
        }
        this.idleDetectionSubscription = null;
    }

    public static /* synthetic */ void onInteraction$default(VideoPlayerIdleDetector videoPlayerIdleDetector, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            z2 = true;
        }
        videoPlayerIdleDetector.onInteraction(z2);
    }

    private final void setIdle(boolean isIdle) {
        if (isIdle != this.isIdle) {
            this.isIdle = isIdle;
            this.onIdleStateChanged.invoke(Boolean.valueOf(isIdle));
        }
    }

    public final void beginIdleDetection() {
        if (this.idleDetectionSubscription == null) {
            setIdle(false);
            beginIdleDetectionTimer();
        }
    }

    public final void dispose() {
        cancelIdleDetectionTimer();
        setIdle(false);
    }

    public final void endIdleDetection() {
        cancelIdleDetectionTimer();
        setIdle(false);
    }

    /* renamed from: isIdle, reason: from getter */
    public final boolean getIsIdle() {
        return this.isIdle;
    }

    public final void onInteraction(boolean otherIsIdle) {
        if ((this.isIdle || otherIsIdle) ? false : true) {
            cancelIdleDetectionTimer();
            setIdle(true);
        } else {
            setIdle(false);
            beginIdleDetectionTimer();
        }
    }

    public final void onPreventIdle() {
        setIdle(false);
        if (this.idleDetectionSubscription != null) {
            beginIdleDetectionTimer();
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ VideoPlayerIdleDetector(long j, Scheduler scheduler, Scheduler scheduler2, Function1 function1, int i, DefaultConstructorMarker defaultConstructorMarker) {
        long j2 = (i & 1) != 0 ? 3000L : j;
        if ((i & 2) != 0) {
            scheduler = AndroidSchedulers.a();
            Intrinsics3.checkNotNullExpressionValue(scheduler, "AndroidSchedulers.mainThread()");
        }
        Scheduler scheduler3 = scheduler;
        if ((i & 4) != 0) {
            scheduler2 = Schedulers2.a();
            Intrinsics3.checkNotNullExpressionValue(scheduler2, "Schedulers.computation()");
        }
        this(j2, scheduler3, scheduler2, function1);
    }
}

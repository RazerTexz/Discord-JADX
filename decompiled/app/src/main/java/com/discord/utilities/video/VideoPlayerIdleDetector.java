package com.discord.utilities.video;

import android.content.Context;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import java.util.concurrent.TimeUnit;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;
import p637j0.p638j.p640b.AndroidSchedulers;
import p637j0.p653p.Schedulers2;
import p658rx.Observable;
import p658rx.Scheduler;
import p658rx.Subscription;

/* JADX INFO: compiled from: VideoPlayerIdleDetector.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class VideoPlayerIdleDetector {
    private final Scheduler backgroundThreadScheduler;
    private final long idleDetectionMs;
    private final Scheduler idleDetectionScheduler;
    private Subscription idleDetectionSubscription;
    private boolean isIdle;
    private final Function1<Boolean, Unit> onIdleStateChanged;

    /* JADX INFO: renamed from: com.discord.utilities.video.VideoPlayerIdleDetector$beginIdleDetectionTimer$1 */
    /* JADX INFO: compiled from: VideoPlayerIdleDetector.kt */
    public static final class C69871 extends Lambda implements Function1<Long, Unit> {
        public C69871() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Long l) {
            invoke2(l);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Long l) {
            VideoPlayerIdleDetector.access$setIdle(VideoPlayerIdleDetector.this, true);
        }
    }

    /* JADX INFO: renamed from: com.discord.utilities.video.VideoPlayerIdleDetector$beginIdleDetectionTimer$2 */
    /* JADX INFO: compiled from: VideoPlayerIdleDetector.kt */
    public static final class C69882 extends Lambda implements Function1<Subscription, Unit> {
        public C69882() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Subscription subscription) {
            invoke2(subscription);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
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
        Observable<Long> observableM11084J = Observable.m11070e0(this.idleDetectionMs, TimeUnit.MILLISECONDS, this.backgroundThreadScheduler).m11084J(this.idleDetectionScheduler);
        Intrinsics3.checkNotNullExpressionValue(observableM11084J, "Observable\n        .time…n(idleDetectionScheduler)");
        ObservableExtensionsKt.appSubscribe$default(observableM11084J, VideoPlayerIdleDetector.class, (Context) null, new C69882(), (Function1) null, (Function0) null, (Function0) null, new C69871(), 58, (Object) null);
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

    /* JADX INFO: renamed from: isIdle, reason: from getter */
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
            scheduler = AndroidSchedulers.m10738a();
            Intrinsics3.checkNotNullExpressionValue(scheduler, "AndroidSchedulers.mainThread()");
        }
        Scheduler scheduler3 = scheduler;
        if ((i & 4) != 0) {
            scheduler2 = Schedulers2.m10873a();
            Intrinsics3.checkNotNullExpressionValue(scheduler2, "Schedulers.computation()");
        }
        this(j2, scheduler3, scheduler2, function1);
    }
}

package com.discord.utilities.networking;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ExecutorService;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;

/* compiled from: Backoff.kt */
/* loaded from: classes2.dex */
public final class Backoff {
    private long current;
    private int fails;
    private final int failureThreshold;
    private boolean isPending;
    private final boolean jitter;
    private final long maxBackoffMs;
    private final long minBackoffMs;
    private final Scheduler scheduler;

    /* compiled from: Backoff.kt */
    public interface Scheduler {
        void cancel();

        void schedule(Function0<Unit> action, long delayMs);
    }

    /* compiled from: Backoff.kt */
    public static final class TimerScheduler extends Timer implements Scheduler {
        private final ExecutorService delegateExecutor;
        private final String tag;
        private TimerTask timeoutTimerTask;

        public TimerScheduler() {
            this(null, null, 3, null);
        }

        public /* synthetic */ TimerScheduler(String str, ExecutorService executorService, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? "TimerScheduler" : str, (i & 2) != 0 ? null : executorService);
        }

        public static final /* synthetic */ ExecutorService access$getDelegateExecutor$p(TimerScheduler timerScheduler) {
            return timerScheduler.delegateExecutor;
        }

        public static final /* synthetic */ String access$getTag$p(TimerScheduler timerScheduler) {
            return timerScheduler.tag;
        }

        @Override // java.util.Timer, com.discord.utilities.networking.Backoff.Scheduler
        public synchronized void cancel() {
            TimerTask timerTask = this.timeoutTimerTask;
            if (timerTask != null) {
                timerTask.cancel();
            }
        }

        @Override // com.discord.utilities.networking.Backoff.Scheduler
        public synchronized void schedule(Function0<Unit> action, long delayMs) {
            Intrinsics3.checkNotNullParameter(action, "action");
            TimerTask timerTask = this.timeoutTimerTask;
            if (timerTask != null) {
                timerTask.cancel();
            }
            Backoff2 backoff2 = new Backoff2(this, action);
            this.timeoutTimerTask = backoff2;
            schedule(backoff2, delayMs);
        }

        public TimerScheduler(String str, ExecutorService executorService) {
            Intrinsics3.checkNotNullParameter(str, "tag");
            this.tag = str;
            this.delegateExecutor = executorService;
        }
    }

    /* compiled from: Backoff.kt */
    /* renamed from: com.discord.utilities.networking.Backoff$fail$1 */
    public static final class C68191 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ Function0 $callback;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C68191(Function0 function0) {
            super(0);
            this.$callback = function0;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            Backoff.access$executeFailureCallback(Backoff.this, this.$callback);
        }
    }

    public Backoff() {
        this(0L, 0L, 0, false, null, 31, null);
    }

    public Backoff(long j, long j2, int i, boolean z2, Scheduler scheduler) {
        Intrinsics3.checkNotNullParameter(scheduler, "scheduler");
        this.minBackoffMs = j;
        this.maxBackoffMs = j2;
        this.failureThreshold = i;
        this.jitter = z2;
        this.scheduler = scheduler;
        this.current = j;
    }

    public static final /* synthetic */ void access$executeFailureCallback(Backoff backoff, Function0 function0) {
        backoff.executeFailureCallback(function0);
    }

    private final synchronized void executeFailureCallback(Function0<Unit> callback) {
        this.isPending = false;
        callback.invoke();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ long fail$default(Backoff backoff, Function0 function0, int i, Object obj) {
        if ((i & 1) != 0) {
            function0 = null;
        }
        return backoff.fail(function0);
    }

    public final synchronized void cancel() {
        this.scheduler.cancel();
        this.isPending = false;
    }

    public final synchronized long fail(Function0<Unit> callback) {
        this.fails++;
        double dRandom = this.jitter ? Math.random() : 1.0d;
        this.current = Math.min(this.current + ((long) (2 * r4 * dRandom)), this.maxBackoffMs);
        if (callback != null && !this.isPending) {
            this.isPending = true;
            this.scheduler.schedule(new C68191(callback), this.current);
        }
        return this.current;
    }

    public final boolean hasReachedFailureThreshold() {
        return this.fails > this.failureThreshold;
    }

    /* renamed from: isPending, reason: from getter */
    public final boolean getIsPending() {
        return this.isPending;
    }

    public final synchronized void succeed() {
        cancel();
        this.fails = 0;
        this.current = this.minBackoffMs;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ Backoff(long j, long j2, int i, boolean z2, Scheduler scheduler, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        long j3 = (i2 & 1) != 0 ? 500L : j;
        this(j3, (i2 & 2) != 0 ? 10 * j3 : j2, (i2 & 4) != 0 ? Integer.MAX_VALUE : i, (i2 & 8) != 0 ? true : z2, (i2 & 16) != 0 ? new TimerScheduler(null, null, 3, null) : scheduler);
    }
}

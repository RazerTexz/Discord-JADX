package com.discord.utilities.time;

import d0.LazyJVM;
import d0.z.d.Intrinsics3;
import kotlin.Lazy;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: TimeElapsed.kt */
/* loaded from: classes2.dex */
public final class TimeElapsed {

    /* renamed from: milliseconds$delegate, reason: from kotlin metadata */
    private final Lazy milliseconds;

    /* renamed from: seconds$delegate, reason: from kotlin metadata */
    private final Lazy seconds;
    private final long startTime;

    public TimeElapsed(Clock clock, long j) {
        Intrinsics3.checkNotNullParameter(clock, "clock");
        this.startTime = j;
        this.milliseconds = LazyJVM.lazy(new TimeElapsed2(this, clock));
        this.seconds = LazyJVM.lazy(new TimeElapsed3(this));
    }

    public static final /* synthetic */ long access$getStartTime$p(TimeElapsed timeElapsed) {
        return timeElapsed.startTime;
    }

    public final long getMilliseconds() {
        return ((Number) this.milliseconds.getValue()).longValue();
    }

    public final float getSeconds() {
        return ((Number) this.seconds.getValue()).floatValue();
    }

    public /* synthetic */ TimeElapsed(Clock clock, long j, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(clock, (i & 2) != 0 ? clock.currentTimeMillis() : j);
    }
}

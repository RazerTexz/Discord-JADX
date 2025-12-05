package com.facebook.common.time;

import android.os.SystemClock;
import p007b.p109f.p115d.p119d.DoNotStrip;
import p007b.p109f.p115d.p126k.MonotonicClock;

@DoNotStrip
/* loaded from: classes.dex */
public class AwakeTimeSinceBootClock implements MonotonicClock {

    @DoNotStrip
    private static final AwakeTimeSinceBootClock INSTANCE = new AwakeTimeSinceBootClock();

    private AwakeTimeSinceBootClock() {
    }

    @DoNotStrip
    public static AwakeTimeSinceBootClock get() {
        return INSTANCE;
    }

    @Override // p007b.p109f.p115d.p126k.MonotonicClock
    @DoNotStrip
    public long now() {
        return SystemClock.uptimeMillis();
    }

    @DoNotStrip
    public long nowNanos() {
        return System.nanoTime();
    }
}

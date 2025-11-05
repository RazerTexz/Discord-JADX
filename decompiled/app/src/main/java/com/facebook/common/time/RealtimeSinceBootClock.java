package com.facebook.common.time;

import android.os.SystemClock;
import b.f.d.d.c;
import b.f.d.k.b;

@c
/* loaded from: classes.dex */
public class RealtimeSinceBootClock implements b {
    public static final RealtimeSinceBootClock a = new RealtimeSinceBootClock();

    private RealtimeSinceBootClock() {
    }

    @c
    public static RealtimeSinceBootClock get() {
        return a;
    }

    @Override // b.f.d.k.b
    public long now() {
        return SystemClock.elapsedRealtime();
    }
}

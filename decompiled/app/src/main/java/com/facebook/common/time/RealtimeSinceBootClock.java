package com.facebook.common.time;

import android.os.SystemClock;
import p007b.p109f.p115d.p119d.DoNotStrip;
import p007b.p109f.p115d.p126k.MonotonicClock;

/* JADX INFO: loaded from: classes.dex */
@DoNotStrip
public class RealtimeSinceBootClock implements MonotonicClock {

    /* JADX INFO: renamed from: a */
    public static final RealtimeSinceBootClock f19450a = new RealtimeSinceBootClock();

    private RealtimeSinceBootClock() {
    }

    @DoNotStrip
    public static RealtimeSinceBootClock get() {
        return f19450a;
    }

    @Override // p007b.p109f.p115d.p126k.MonotonicClock
    public long now() {
        return SystemClock.elapsedRealtime();
    }
}

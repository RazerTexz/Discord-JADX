package com.discord.utilities.time;

import com.lyft.kronos.KronosClock;
import d0.z.d.m;

/* compiled from: NtpClock.kt */
/* loaded from: classes2.dex */
public final class NtpClock implements Clock {
    private final KronosClock kronosClock;

    public NtpClock(KronosClock kronosClock) {
        m.checkNotNullParameter(kronosClock, "kronosClock");
        this.kronosClock = kronosClock;
    }

    @Override // com.discord.utilities.time.Clock
    public long currentTimeMillis() {
        return this.kronosClock.a();
    }

    public final KronosClock getKronosClock() {
        return this.kronosClock;
    }
}

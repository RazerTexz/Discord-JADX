package com.discord.utilities.time;

import com.lyft.kronos.Clock8;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: compiled from: NtpClock.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class NtpClock implements Clock {
    private final Clock8 kronosClock;

    public NtpClock(Clock8 clock8) {
        Intrinsics3.checkNotNullParameter(clock8, "kronosClock");
        this.kronosClock = clock8;
    }

    @Override // com.discord.utilities.time.Clock
    public long currentTimeMillis() {
        return this.kronosClock.mo7128a();
    }

    public final Clock8 getKronosClock() {
        return this.kronosClock;
    }
}

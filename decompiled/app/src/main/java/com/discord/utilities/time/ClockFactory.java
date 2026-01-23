package com.discord.utilities.time;

import android.app.Application;
import com.lyft.kronos.Clock8;
import p007b.p445m.p446a.AndroidClockFactory;
import p007b.p445m.p446a.p447g.KronosClockImpl;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: compiled from: ClockFactory.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ClockFactory {
    public static final ClockFactory INSTANCE = new ClockFactory();
    private static NtpClock ntpClock;

    private ClockFactory() {
    }

    public static final Clock get() {
        NtpClock ntpClock2 = ntpClock;
        if (ntpClock2 == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("ntpClock");
        }
        return ntpClock2;
    }

    public final void init(Application application) {
        Intrinsics3.checkNotNullParameter(application, "application");
        Clock8 clock8M7127a = AndroidClockFactory.m7127a(application, null, null, 0L, 0L, 0L, 62);
        ((KronosClockImpl) clock8M7127a).f13646a.mo7151b();
        ntpClock = new NtpClock(clock8M7127a);
    }
}

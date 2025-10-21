package com.discord.models.domain;

import com.discord.utilities.SnowflakeUtils;
import com.discord.utilities.time.Clock;
import com.discord.utilities.time.ClockFactory;
import d0.z.d.Intrinsics3;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: NonceGenerator.kt */
/* loaded from: classes.dex */
public final class NonceGenerator {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static long previousNonce;

    /* compiled from: NonceGenerator.kt */
    public static final class Companion {
        private Companion() {
        }

        public static /* synthetic */ long computeNonce$default(Companion companion, Clock clock, int i, Object obj) {
            if ((i & 1) != 0) {
                clock = ClockFactory.get();
            }
            return companion.computeNonce(clock);
        }

        public final synchronized long computeNonce(Clock clock) {
            long jCurrentTimeMillis;
            Intrinsics3.checkNotNullParameter(clock, "clock");
            jCurrentTimeMillis = ((clock.currentTimeMillis() + 1471228928) - SnowflakeUtils.DISCORD_EPOCH) << 22;
            if (jCurrentTimeMillis <= NonceGenerator.access$getPreviousNonce$cp()) {
                jCurrentTimeMillis = NonceGenerator.access$getPreviousNonce$cp() + 1;
            }
            NonceGenerator.access$setPreviousNonce$cp(jCurrentTimeMillis);
            return jCurrentTimeMillis;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public static final /* synthetic */ long access$getPreviousNonce$cp() {
        return previousNonce;
    }

    public static final /* synthetic */ void access$setPreviousNonce$cp(long j) {
        previousNonce = j;
    }

    public static final synchronized long computeNonce(Clock clock) {
        return INSTANCE.computeNonce(clock);
    }

    public final long nonce() {
        return Companion.computeNonce$default(INSTANCE, null, 1, null);
    }
}

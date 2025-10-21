package com.discord.utilities;

import d0.g0.StringNumberConversions;
import d0.z.d.Intrinsics3;

/* compiled from: SnowflakeUtils.kt */
/* loaded from: classes2.dex */
public final class SnowflakeUtils {
    public static final long DISCORD_EPOCH = 1420070400000L;
    public static final SnowflakeUtils INSTANCE = new SnowflakeUtils();
    public static final int SNOWFLAKE_TIMESTAMP_SHIFT = 22;

    private SnowflakeUtils() {
    }

    public static final long atPreviousMillisecond(long snowflakeId) {
        return (((snowflakeId >>> 22) - 1) - DISCORD_EPOCH) << 22;
    }

    public static final long fromTimestamp(long timestamp) {
        return (timestamp - DISCORD_EPOCH) << 22;
    }

    public static final long getTimestampPart(long j) {
        return j >>> 22;
    }

    public static /* synthetic */ void getTimestampPart$annotations(long j) {
    }

    public static final long toTimestamp(long snowflakeId) {
        return (snowflakeId >>> 22) + DISCORD_EPOCH;
    }

    public final Long toSnowflake(String str) {
        Intrinsics3.checkNotNullParameter(str, "$this$toSnowflake");
        Long longOrNull = StringNumberConversions.toLongOrNull(str);
        if (longOrNull != null) {
            if (longOrNull.longValue() > DISCORD_EPOCH) {
                return longOrNull;
            }
        }
        return null;
    }
}

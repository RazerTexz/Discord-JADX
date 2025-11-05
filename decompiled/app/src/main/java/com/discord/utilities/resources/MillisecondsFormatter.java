package com.discord.utilities.resources;

import android.content.Context;
import androidx.recyclerview.widget.RecyclerView;
import d0.a0.a;
import d0.o;
import d0.z.d.m;

/* compiled from: DurationUtils.kt */
/* loaded from: classes2.dex */
public final class MillisecondsFormatter {
    public static final MillisecondsFormatter INSTANCE = new MillisecondsFormatter();
    private static final long MS_IN_DAY = 86400000;
    private static final long MS_IN_HOUR = 3600000;
    private static final long MS_IN_MINUTE = 60000;
    private static final long MS_IN_MONTH = 2592000000L;
    private static final long MS_IN_WEEK = 604800000;

    private MillisecondsFormatter() {
    }

    public final CharSequence formatDurationInMillis(Context context, long j) {
        m.checkNotNullParameter(context, "$this$formatDurationInMillis");
        return DurationUtilsKt.formatDuration(context, (DurationUnit) ((2592000000L <= j && RecyclerView.FOREVER_NS >= j) ? o.to(DurationUnit.MONTHS, 2592000000L) : (MS_IN_WEEK <= j && 2592000000L >= j) ? o.to(DurationUnit.WEEKS, Long.valueOf(MS_IN_WEEK)) : (MS_IN_DAY <= j && MS_IN_WEEK >= j) ? o.to(DurationUnit.DAYS, Long.valueOf(MS_IN_DAY)) : (MS_IN_HOUR <= j && MS_IN_DAY >= j) ? o.to(DurationUnit.HOURS, Long.valueOf(MS_IN_HOUR)) : o.to(DurationUnit.MINUTES, 60000L)).component1(), a.roundToInt(j / ((Number) r0.component2()).longValue()));
    }
}

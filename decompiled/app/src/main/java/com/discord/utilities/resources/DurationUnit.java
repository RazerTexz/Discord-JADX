package com.discord.utilities.resources;

import androidx.annotation.PluralsRes;
import androidx.annotation.StringRes;
import com.discord.R;

/* compiled from: DurationUtils.kt */
/* loaded from: classes2.dex */
public enum DurationUnit {
    SECONDS(R.string.duration_seconds, R.plurals.duration_seconds_seconds),
    MINUTES(R.string.duration_minutes, R.plurals.duration_minutes_minutes),
    MINS(R.string.duration_mins, R.plurals.duration_mins_mins),
    HOURS(R.string.duration_hours, R.plurals.duration_hours_hours),
    DAYS(R.string.duration_days, R.plurals.duration_days_days),
    WEEKS(R.string.duration_weeks, R.plurals.duration_weeks_weeks),
    MONTHS(R.string.duration_months, R.plurals.duration_months_months);

    private final int quantityPluralRes;
    private final int stringRes;

    DurationUnit(@StringRes int i, @PluralsRes int i2) {
        this.stringRes = i;
        this.quantityPluralRes = i2;
    }

    /* renamed from: getQuantityPluralRes$app_productionGoogleRelease, reason: from getter */
    public final int getQuantityPluralRes() {
        return this.quantityPluralRes;
    }

    /* renamed from: getStringRes$app_productionGoogleRelease, reason: from getter */
    public final int getStringRes() {
        return this.stringRes;
    }
}

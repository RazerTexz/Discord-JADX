package com.discord.utilities.resources;

import androidx.annotation.PluralsRes;
import androidx.annotation.StringRes;
import com.discord.C5419R;

/* JADX INFO: renamed from: com.discord.utilities.resources.DurationUnit, reason: use source file name */
/* JADX INFO: compiled from: DurationUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public enum DurationUtils2 {
    SECONDS(C5419R.string.duration_seconds, C5419R.plurals.duration_seconds_seconds),
    MINUTES(C5419R.string.duration_minutes, C5419R.plurals.duration_minutes_minutes),
    MINS(C5419R.string.duration_mins, C5419R.plurals.duration_mins_mins),
    HOURS(C5419R.string.duration_hours, C5419R.plurals.duration_hours_hours),
    DAYS(C5419R.string.duration_days, C5419R.plurals.duration_days_days),
    WEEKS(C5419R.string.duration_weeks, C5419R.plurals.duration_weeks_weeks),
    MONTHS(C5419R.string.duration_months, C5419R.plurals.duration_months_months);

    private final int quantityPluralRes;
    private final int stringRes;

    DurationUtils2(@StringRes int i, @PluralsRes int i2) {
        this.stringRes = i;
        this.quantityPluralRes = i2;
    }

    /* JADX INFO: renamed from: getQuantityPluralRes$app_productionGoogleRelease, reason: from getter */
    public final int getQuantityPluralRes() {
        return this.quantityPluralRes;
    }

    /* JADX INFO: renamed from: getStringRes$app_productionGoogleRelease, reason: from getter */
    public final int getStringRes() {
        return this.stringRes;
    }
}

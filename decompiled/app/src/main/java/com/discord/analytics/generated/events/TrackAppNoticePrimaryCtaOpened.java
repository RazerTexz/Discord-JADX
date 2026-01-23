package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.api.science.AnalyticsSchema;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: compiled from: TrackAppNoticePrimaryCtaOpened.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackAppNoticePrimaryCtaOpened implements AnalyticsSchema, TrackBase2 {
    private TrackBase trackBase;
    private final CharSequence noticeType = null;
    private final transient String analyticsSchemaTypeName = "app_notice_primary_cta_opened";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof TrackAppNoticePrimaryCtaOpened) && Intrinsics3.areEqual(this.noticeType, ((TrackAppNoticePrimaryCtaOpened) other).noticeType);
        }
        return true;
    }

    public int hashCode() {
        CharSequence charSequence = this.noticeType;
        if (charSequence != null) {
            return charSequence.hashCode();
        }
        return 0;
    }

    public String toString() {
        return outline.m817E(outline.m833U("TrackAppNoticePrimaryCtaOpened(noticeType="), this.noticeType, ")");
    }
}

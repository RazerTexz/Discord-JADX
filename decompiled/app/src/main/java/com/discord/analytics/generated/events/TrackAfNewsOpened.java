package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackAfCard;
import com.discord.analytics.generated.traits.TrackAfCard2;
import com.discord.analytics.generated.traits.TrackAfGame;
import com.discord.analytics.generated.traits.TrackAfGame2;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.api.science.AnalyticsSchema;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: compiled from: TrackAfNewsOpened.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackAfNewsOpened implements AnalyticsSchema, TrackBase2, TrackAfCard2, TrackAfGame2 {
    private TrackAfCard trackAfCard;
    private TrackAfGame trackAfGame;
    private TrackBase trackBase;
    private final CharSequence newsUrl = null;
    private final Long newsIndex = null;
    private final transient String analyticsSchemaTypeName = "af_news_opened";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackAfNewsOpened)) {
            return false;
        }
        TrackAfNewsOpened trackAfNewsOpened = (TrackAfNewsOpened) other;
        return Intrinsics3.areEqual(this.newsUrl, trackAfNewsOpened.newsUrl) && Intrinsics3.areEqual(this.newsIndex, trackAfNewsOpened.newsIndex);
    }

    public int hashCode() {
        CharSequence charSequence = this.newsUrl;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        Long l = this.newsIndex;
        return iHashCode + (l != null ? l.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = outline.m833U("TrackAfNewsOpened(newsUrl=");
        sbM833U.append(this.newsUrl);
        sbM833U.append(", newsIndex=");
        return outline.m819G(sbM833U, this.newsIndex, ")");
    }
}

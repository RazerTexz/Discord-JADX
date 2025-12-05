package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackAfCard;
import com.discord.analytics.generated.traits.TrackAfCard2;
import com.discord.analytics.generated.traits.TrackAfGame;
import com.discord.analytics.generated.traits.TrackAfGame2;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.analytics.generated.traits.TrackLocationMetadata;
import com.discord.analytics.generated.traits.TrackLocationMetadata2;
import com.discord.api.science.AnalyticsSchema;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: TrackGameNewsOpened.kt */
/* loaded from: classes.dex */
public final /* data */ class TrackGameNewsOpened implements AnalyticsSchema, TrackBase2, TrackLocationMetadata2, TrackAfCard2, TrackAfGame2 {
    private TrackAfCard trackAfCard;
    private TrackAfGame trackAfGame;
    private TrackBase trackBase;
    private TrackLocationMetadata trackLocationMetadata;
    private final CharSequence newsUrl = null;
    private final Long newsIndex = null;
    private final Long newsId = null;
    private final transient String analyticsSchemaTypeName = "game_news_opened";

    @Override // com.discord.api.science.AnalyticsSchema
    /* renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackGameNewsOpened)) {
            return false;
        }
        TrackGameNewsOpened trackGameNewsOpened = (TrackGameNewsOpened) other;
        return Intrinsics3.areEqual(this.newsUrl, trackGameNewsOpened.newsUrl) && Intrinsics3.areEqual(this.newsIndex, trackGameNewsOpened.newsIndex) && Intrinsics3.areEqual(this.newsId, trackGameNewsOpened.newsId);
    }

    public int hashCode() {
        CharSequence charSequence = this.newsUrl;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        Long l = this.newsIndex;
        int iHashCode2 = (iHashCode + (l != null ? l.hashCode() : 0)) * 31;
        Long l2 = this.newsId;
        return iHashCode2 + (l2 != null ? l2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = outline.m833U("TrackGameNewsOpened(newsUrl=");
        sbM833U.append(this.newsUrl);
        sbM833U.append(", newsIndex=");
        sbM833U.append(this.newsIndex);
        sbM833U.append(", newsId=");
        return outline.m819G(sbM833U, this.newsId, ")");
    }
}

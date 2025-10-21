package com.discord.analytics.generated.events;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.analytics.generated.traits.TrackChannel;
import com.discord.analytics.generated.traits.TrackChannel2;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;

/* compiled from: TrackEmojiUpsellPopoutMoreEmojisOpened.kt */
/* loaded from: classes.dex */
public final /* data */ class TrackEmojiUpsellPopoutMoreEmojisOpened implements AnalyticsSchema, TrackBase2, TrackChannel2 {
    private TrackBase trackBase;
    private TrackChannel trackChannel;
    private final Long guildId = null;
    private final Long emojiId = null;
    private final transient String analyticsSchemaTypeName = "emoji_upsell_popout_more_emojis_opened";

    @Override // com.discord.api.science.AnalyticsSchema
    /* renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackEmojiUpsellPopoutMoreEmojisOpened)) {
            return false;
        }
        TrackEmojiUpsellPopoutMoreEmojisOpened trackEmojiUpsellPopoutMoreEmojisOpened = (TrackEmojiUpsellPopoutMoreEmojisOpened) other;
        return Intrinsics3.areEqual(this.guildId, trackEmojiUpsellPopoutMoreEmojisOpened.guildId) && Intrinsics3.areEqual(this.emojiId, trackEmojiUpsellPopoutMoreEmojisOpened.emojiId);
    }

    public int hashCode() {
        Long l = this.guildId;
        int iHashCode = (l != null ? l.hashCode() : 0) * 31;
        Long l2 = this.emojiId;
        return iHashCode + (l2 != null ? l2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackEmojiUpsellPopoutMoreEmojisOpened(guildId=");
        sbU.append(this.guildId);
        sbU.append(", emojiId=");
        return outline.G(sbU, this.emojiId, ")");
    }
}

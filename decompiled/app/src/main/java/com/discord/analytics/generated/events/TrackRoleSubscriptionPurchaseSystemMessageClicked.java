package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.analytics.generated.traits.TrackChannel;
import com.discord.analytics.generated.traits.TrackChannel2;
import com.discord.analytics.generated.traits.TrackGuild;
import com.discord.analytics.generated.traits.TrackGuild2;
import com.discord.api.science.AnalyticsSchema;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: TrackRoleSubscriptionPurchaseSystemMessageClicked.kt */
/* loaded from: classes.dex */
public final /* data */ class TrackRoleSubscriptionPurchaseSystemMessageClicked implements AnalyticsSchema, TrackBase2, TrackGuild2, TrackChannel2 {
    private final transient String analyticsSchemaTypeName;
    private final Long messageId;
    private final Long roleSubscriptionListingId;
    private TrackBase trackBase;
    private TrackChannel trackChannel;
    private TrackGuild trackGuild;

    public TrackRoleSubscriptionPurchaseSystemMessageClicked() {
        this.messageId = null;
        this.roleSubscriptionListingId = null;
        this.analyticsSchemaTypeName = "role_subscription_purchase_system_message_clicked";
    }

    @Override // com.discord.analytics.generated.traits.TrackGuild2
    /* renamed from: a, reason: from getter */
    public TrackGuild getTrackGuild() {
        return this.trackGuild;
    }

    @Override // com.discord.analytics.generated.traits.TrackGuild2
    /* renamed from: c */
    public void mo7508c(TrackGuild trackGuild) {
        this.trackGuild = trackGuild;
    }

    @Override // com.discord.api.science.AnalyticsSchema
    /* renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    /* renamed from: e */
    public void m7512e(TrackBase trackBase) {
        this.trackBase = trackBase;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackRoleSubscriptionPurchaseSystemMessageClicked)) {
            return false;
        }
        TrackRoleSubscriptionPurchaseSystemMessageClicked trackRoleSubscriptionPurchaseSystemMessageClicked = (TrackRoleSubscriptionPurchaseSystemMessageClicked) other;
        return Intrinsics3.areEqual(this.messageId, trackRoleSubscriptionPurchaseSystemMessageClicked.messageId) && Intrinsics3.areEqual(this.roleSubscriptionListingId, trackRoleSubscriptionPurchaseSystemMessageClicked.roleSubscriptionListingId);
    }

    /* renamed from: f */
    public void m7513f(TrackChannel trackChannel) {
        this.trackChannel = trackChannel;
    }

    public int hashCode() {
        Long l = this.messageId;
        int iHashCode = (l != null ? l.hashCode() : 0) * 31;
        Long l2 = this.roleSubscriptionListingId;
        return iHashCode + (l2 != null ? l2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = outline.m833U("TrackRoleSubscriptionPurchaseSystemMessageClicked(messageId=");
        sbM833U.append(this.messageId);
        sbM833U.append(", roleSubscriptionListingId=");
        return outline.m819G(sbM833U, this.roleSubscriptionListingId, ")");
    }

    public TrackRoleSubscriptionPurchaseSystemMessageClicked(Long l, Long l2) {
        this.messageId = l;
        this.roleSubscriptionListingId = l2;
        this.analyticsSchemaTypeName = "role_subscription_purchase_system_message_clicked";
    }
}

package com.discord.analytics.generated.events.network_action;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.analytics.generated.traits.TrackLocationMetadata;
import com.discord.analytics.generated.traits.TrackLocationMetadata2;
import com.discord.analytics.generated.traits.TrackNetworkMetadata;
import com.discord.analytics.generated.traits.TrackNetworkMetadata2;
import com.discord.api.science.AnalyticsSchema;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: TrackNetworkActionUserRegister.kt */
/* loaded from: classes.dex */
public final /* data */ class TrackNetworkActionUserRegister implements AnalyticsSchema, TrackBase2, TrackLocationMetadata2, TrackNetworkMetadata2 {
    private final transient String analyticsSchemaTypeName;
    private final CharSequence inviteCode;
    private final Boolean promotionalEmailOptIn;
    private final Boolean promotionalEmailPreChecked;
    private TrackBase trackBase;
    private TrackLocationMetadata trackLocationMetadata;
    private TrackNetworkMetadata trackNetworkMetadata;

    public TrackNetworkActionUserRegister() {
        this.inviteCode = null;
        this.promotionalEmailOptIn = null;
        this.promotionalEmailPreChecked = null;
        this.analyticsSchemaTypeName = "network_action_user_register";
    }

    @Override // com.discord.analytics.generated.traits.TrackNetworkMetadata2
    /* renamed from: b */
    public void mo7529b(TrackNetworkMetadata trackNetworkMetadata) {
        this.trackNetworkMetadata = trackNetworkMetadata;
    }

    @Override // com.discord.api.science.AnalyticsSchema
    /* renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackNetworkActionUserRegister)) {
            return false;
        }
        TrackNetworkActionUserRegister trackNetworkActionUserRegister = (TrackNetworkActionUserRegister) other;
        return Intrinsics3.areEqual(this.inviteCode, trackNetworkActionUserRegister.inviteCode) && Intrinsics3.areEqual(this.promotionalEmailOptIn, trackNetworkActionUserRegister.promotionalEmailOptIn) && Intrinsics3.areEqual(this.promotionalEmailPreChecked, trackNetworkActionUserRegister.promotionalEmailPreChecked);
    }

    public int hashCode() {
        CharSequence charSequence = this.inviteCode;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        Boolean bool = this.promotionalEmailOptIn;
        int iHashCode2 = (iHashCode + (bool != null ? bool.hashCode() : 0)) * 31;
        Boolean bool2 = this.promotionalEmailPreChecked;
        return iHashCode2 + (bool2 != null ? bool2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = outline.m833U("TrackNetworkActionUserRegister(inviteCode=");
        sbM833U.append(this.inviteCode);
        sbM833U.append(", promotionalEmailOptIn=");
        sbM833U.append(this.promotionalEmailOptIn);
        sbM833U.append(", promotionalEmailPreChecked=");
        return outline.m816D(sbM833U, this.promotionalEmailPreChecked, ")");
    }

    public TrackNetworkActionUserRegister(CharSequence charSequence, Boolean bool, Boolean bool2) {
        this.inviteCode = charSequence;
        this.promotionalEmailOptIn = bool;
        this.promotionalEmailPreChecked = bool2;
        this.analyticsSchemaTypeName = "network_action_user_register";
    }
}

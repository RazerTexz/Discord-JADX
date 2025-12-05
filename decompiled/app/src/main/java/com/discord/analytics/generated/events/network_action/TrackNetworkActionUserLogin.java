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

/* compiled from: TrackNetworkActionUserLogin.kt */
/* loaded from: classes.dex */
public final /* data */ class TrackNetworkActionUserLogin implements AnalyticsSchema, TrackBase2, TrackLocationMetadata2, TrackNetworkMetadata2 {
    private final transient String analyticsSchemaTypeName;
    private final CharSequence inviteCode;
    private final Boolean isMultiAccount;
    private TrackBase trackBase;
    private TrackLocationMetadata trackLocationMetadata;
    private TrackNetworkMetadata trackNetworkMetadata;

    public TrackNetworkActionUserLogin() {
        this(null, null, 3);
    }

    public TrackNetworkActionUserLogin(CharSequence charSequence, Boolean bool, int i) {
        int i2 = i & 2;
        this.inviteCode = (i & 1) != 0 ? null : charSequence;
        this.isMultiAccount = null;
        this.analyticsSchemaTypeName = "network_action_user_login";
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
        if (!(other instanceof TrackNetworkActionUserLogin)) {
            return false;
        }
        TrackNetworkActionUserLogin trackNetworkActionUserLogin = (TrackNetworkActionUserLogin) other;
        return Intrinsics3.areEqual(this.inviteCode, trackNetworkActionUserLogin.inviteCode) && Intrinsics3.areEqual(this.isMultiAccount, trackNetworkActionUserLogin.isMultiAccount);
    }

    public int hashCode() {
        CharSequence charSequence = this.inviteCode;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        Boolean bool = this.isMultiAccount;
        return iHashCode + (bool != null ? bool.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = outline.m833U("TrackNetworkActionUserLogin(inviteCode=");
        sbM833U.append(this.inviteCode);
        sbM833U.append(", isMultiAccount=");
        return outline.m816D(sbM833U, this.isMultiAccount, ")");
    }
}

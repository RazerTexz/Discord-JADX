package com.discord.analytics.generated.events.network_action;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.analytics.generated.traits.TrackLocationMetadata;
import com.discord.analytics.generated.traits.TrackLocationMetadata2;
import com.discord.analytics.generated.traits.TrackNetworkMetadata;
import com.discord.analytics.generated.traits.TrackNetworkMetadata2;
import com.discord.api.science.AnalyticsSchema;
import java.util.List;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: TrackNetworkActionEmailSettingsUpdate.kt */
/* loaded from: classes.dex */
public final /* data */ class TrackNetworkActionEmailSettingsUpdate implements AnalyticsSchema, TrackBase2, TrackLocationMetadata2, TrackNetworkMetadata2 {
    private TrackBase trackBase;
    private TrackLocationMetadata trackLocationMetadata;
    private TrackNetworkMetadata trackNetworkMetadata;
    private final CharSequence category = null;
    private final Boolean value = null;
    private final List<CharSequence> categories = null;
    private final List<Boolean> values = null;
    private final transient String analyticsSchemaTypeName = "network_action_email_settings_update";

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
        if (!(other instanceof TrackNetworkActionEmailSettingsUpdate)) {
            return false;
        }
        TrackNetworkActionEmailSettingsUpdate trackNetworkActionEmailSettingsUpdate = (TrackNetworkActionEmailSettingsUpdate) other;
        return Intrinsics3.areEqual(this.category, trackNetworkActionEmailSettingsUpdate.category) && Intrinsics3.areEqual(this.value, trackNetworkActionEmailSettingsUpdate.value) && Intrinsics3.areEqual(this.categories, trackNetworkActionEmailSettingsUpdate.categories) && Intrinsics3.areEqual(this.values, trackNetworkActionEmailSettingsUpdate.values);
    }

    public int hashCode() {
        CharSequence charSequence = this.category;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        Boolean bool = this.value;
        int iHashCode2 = (iHashCode + (bool != null ? bool.hashCode() : 0)) * 31;
        List<CharSequence> list = this.categories;
        int iHashCode3 = (iHashCode2 + (list != null ? list.hashCode() : 0)) * 31;
        List<Boolean> list2 = this.values;
        return iHashCode3 + (list2 != null ? list2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = outline.m833U("TrackNetworkActionEmailSettingsUpdate(category=");
        sbM833U.append(this.category);
        sbM833U.append(", value=");
        sbM833U.append(this.value);
        sbM833U.append(", categories=");
        sbM833U.append(this.categories);
        sbM833U.append(", values=");
        return outline.m824L(sbM833U, this.values, ")");
    }
}

package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.analytics.generated.traits.TrackGuild;
import com.discord.analytics.generated.traits.TrackGuild2;
import com.discord.analytics.generated.traits.TrackGuildWelcomeScreen;
import com.discord.analytics.generated.traits.TrackGuildWelcomeScreen2;
import com.discord.api.science.AnalyticsSchema;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: TrackGuildWelcomeScreenSettingsUpdated.kt */
/* loaded from: classes.dex */
public final /* data */ class TrackGuildWelcomeScreenSettingsUpdated implements AnalyticsSchema, TrackBase2, TrackGuild2, TrackGuildWelcomeScreen2 {
    private TrackBase trackBase;
    private TrackGuild trackGuild;
    private TrackGuildWelcomeScreen trackGuildWelcomeScreen;
    private final Boolean isEnabled = null;
    private final transient String analyticsSchemaTypeName = "guild_welcome_screen_settings_updated";

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

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof TrackGuildWelcomeScreenSettingsUpdated) && Intrinsics3.areEqual(this.isEnabled, ((TrackGuildWelcomeScreenSettingsUpdated) other).isEnabled);
        }
        return true;
    }

    public int hashCode() {
        Boolean bool = this.isEnabled;
        if (bool != null) {
            return bool.hashCode();
        }
        return 0;
    }

    public String toString() {
        return outline.m816D(outline.m833U("TrackGuildWelcomeScreenSettingsUpdated(isEnabled="), this.isEnabled, ")");
    }
}

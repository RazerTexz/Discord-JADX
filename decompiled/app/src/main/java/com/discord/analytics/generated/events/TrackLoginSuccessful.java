package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.analytics.generated.traits.TrackGiftCodeMetadata;
import com.discord.analytics.generated.traits.TrackGiftCodeMetadata2;
import com.discord.api.science.AnalyticsSchema;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: TrackLoginSuccessful.kt */
/* loaded from: classes.dex */
public final /* data */ class TrackLoginSuccessful implements AnalyticsSchema, TrackBase2, TrackGiftCodeMetadata2 {
    private TrackBase trackBase;
    private TrackGiftCodeMetadata trackGiftCodeMetadata;
    private final CharSequence loginSource = null;
    private final CharSequence source = null;
    private final Boolean isNewUser = null;
    private final Long fingerprint = null;
    private final CharSequence loginMethod = null;
    private final transient String analyticsSchemaTypeName = "login_successful";

    @Override // com.discord.api.science.AnalyticsSchema
    /* renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackLoginSuccessful)) {
            return false;
        }
        TrackLoginSuccessful trackLoginSuccessful = (TrackLoginSuccessful) other;
        return Intrinsics3.areEqual(this.loginSource, trackLoginSuccessful.loginSource) && Intrinsics3.areEqual(this.source, trackLoginSuccessful.source) && Intrinsics3.areEqual(this.isNewUser, trackLoginSuccessful.isNewUser) && Intrinsics3.areEqual(this.fingerprint, trackLoginSuccessful.fingerprint) && Intrinsics3.areEqual(this.loginMethod, trackLoginSuccessful.loginMethod);
    }

    public int hashCode() {
        CharSequence charSequence = this.loginSource;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        CharSequence charSequence2 = this.source;
        int iHashCode2 = (iHashCode + (charSequence2 != null ? charSequence2.hashCode() : 0)) * 31;
        Boolean bool = this.isNewUser;
        int iHashCode3 = (iHashCode2 + (bool != null ? bool.hashCode() : 0)) * 31;
        Long l = this.fingerprint;
        int iHashCode4 = (iHashCode3 + (l != null ? l.hashCode() : 0)) * 31;
        CharSequence charSequence3 = this.loginMethod;
        return iHashCode4 + (charSequence3 != null ? charSequence3.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = outline.m833U("TrackLoginSuccessful(loginSource=");
        sbM833U.append(this.loginSource);
        sbM833U.append(", source=");
        sbM833U.append(this.source);
        sbM833U.append(", isNewUser=");
        sbM833U.append(this.isNewUser);
        sbM833U.append(", fingerprint=");
        sbM833U.append(this.fingerprint);
        sbM833U.append(", loginMethod=");
        return outline.m817E(sbM833U, this.loginMethod, ")");
    }
}

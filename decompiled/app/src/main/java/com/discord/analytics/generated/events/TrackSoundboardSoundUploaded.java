package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.api.science.AnalyticsSchema;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: TrackSoundboardSoundUploaded.kt */
/* loaded from: classes.dex */
public final /* data */ class TrackSoundboardSoundUploaded implements AnalyticsSchema, TrackBase2 {
    private TrackBase trackBase;
    private final Long guildId = null;
    private final Boolean success = null;
    private final Long reasonCode = null;
    private final CharSequence reasonMessage = null;
    private final CharSequence mimeType = null;
    private final Float durationS = null;
    private final transient String analyticsSchemaTypeName = "soundboard_sound_uploaded";

    @Override // com.discord.api.science.AnalyticsSchema
    /* renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackSoundboardSoundUploaded)) {
            return false;
        }
        TrackSoundboardSoundUploaded trackSoundboardSoundUploaded = (TrackSoundboardSoundUploaded) other;
        return Intrinsics3.areEqual(this.guildId, trackSoundboardSoundUploaded.guildId) && Intrinsics3.areEqual(this.success, trackSoundboardSoundUploaded.success) && Intrinsics3.areEqual(this.reasonCode, trackSoundboardSoundUploaded.reasonCode) && Intrinsics3.areEqual(this.reasonMessage, trackSoundboardSoundUploaded.reasonMessage) && Intrinsics3.areEqual(this.mimeType, trackSoundboardSoundUploaded.mimeType) && Intrinsics3.areEqual(this.durationS, trackSoundboardSoundUploaded.durationS);
    }

    public int hashCode() {
        Long l = this.guildId;
        int iHashCode = (l != null ? l.hashCode() : 0) * 31;
        Boolean bool = this.success;
        int iHashCode2 = (iHashCode + (bool != null ? bool.hashCode() : 0)) * 31;
        Long l2 = this.reasonCode;
        int iHashCode3 = (iHashCode2 + (l2 != null ? l2.hashCode() : 0)) * 31;
        CharSequence charSequence = this.reasonMessage;
        int iHashCode4 = (iHashCode3 + (charSequence != null ? charSequence.hashCode() : 0)) * 31;
        CharSequence charSequence2 = this.mimeType;
        int iHashCode5 = (iHashCode4 + (charSequence2 != null ? charSequence2.hashCode() : 0)) * 31;
        Float f = this.durationS;
        return iHashCode5 + (f != null ? f.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = outline.m833U("TrackSoundboardSoundUploaded(guildId=");
        sbM833U.append(this.guildId);
        sbM833U.append(", success=");
        sbM833U.append(this.success);
        sbM833U.append(", reasonCode=");
        sbM833U.append(this.reasonCode);
        sbM833U.append(", reasonMessage=");
        sbM833U.append(this.reasonMessage);
        sbM833U.append(", mimeType=");
        sbM833U.append(this.mimeType);
        sbM833U.append(", durationS=");
        sbM833U.append(this.durationS);
        sbM833U.append(")");
        return sbM833U.toString();
    }
}

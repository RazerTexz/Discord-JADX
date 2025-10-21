package com.discord.analytics.generated.events;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.analytics.generated.traits.TrackOverlayClientMetadata;
import com.discord.analytics.generated.traits.TrackOverlayClientMetadata2;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;

/* compiled from: TrackAppNativeCrash.kt */
/* loaded from: classes.dex */
public final /* data */ class TrackAppNativeCrash implements AnalyticsSchema, TrackBase2, TrackOverlayClientMetadata2 {
    private TrackBase trackBase;
    private TrackOverlayClientMetadata trackOverlayClientMetadata;
    private final Boolean didCrash = null;
    private final CharSequence rendererCrashReason = null;
    private final CharSequence minidumpExceptionType = null;
    private final CharSequence exitReason = null;
    private final CharSequence exitDescription = null;
    private final CharSequence tombstoneHash = null;
    private final CharSequence tombstoneCause = null;
    private final Long signal = null;
    private final Long exceptionType = null;
    private final Long exceptionCode = null;
    private final CharSequence terminationReason = null;
    private final CharSequence binaryName = null;
    private final CharSequence callstackHash = null;
    private final transient String analyticsSchemaTypeName = "app_native_crash";

    @Override // com.discord.api.science.AnalyticsSchema
    /* renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackAppNativeCrash)) {
            return false;
        }
        TrackAppNativeCrash trackAppNativeCrash = (TrackAppNativeCrash) other;
        return Intrinsics3.areEqual(this.didCrash, trackAppNativeCrash.didCrash) && Intrinsics3.areEqual(this.rendererCrashReason, trackAppNativeCrash.rendererCrashReason) && Intrinsics3.areEqual(this.minidumpExceptionType, trackAppNativeCrash.minidumpExceptionType) && Intrinsics3.areEqual(this.exitReason, trackAppNativeCrash.exitReason) && Intrinsics3.areEqual(this.exitDescription, trackAppNativeCrash.exitDescription) && Intrinsics3.areEqual(this.tombstoneHash, trackAppNativeCrash.tombstoneHash) && Intrinsics3.areEqual(this.tombstoneCause, trackAppNativeCrash.tombstoneCause) && Intrinsics3.areEqual(this.signal, trackAppNativeCrash.signal) && Intrinsics3.areEqual(this.exceptionType, trackAppNativeCrash.exceptionType) && Intrinsics3.areEqual(this.exceptionCode, trackAppNativeCrash.exceptionCode) && Intrinsics3.areEqual(this.terminationReason, trackAppNativeCrash.terminationReason) && Intrinsics3.areEqual(this.binaryName, trackAppNativeCrash.binaryName) && Intrinsics3.areEqual(this.callstackHash, trackAppNativeCrash.callstackHash);
    }

    public int hashCode() {
        Boolean bool = this.didCrash;
        int iHashCode = (bool != null ? bool.hashCode() : 0) * 31;
        CharSequence charSequence = this.rendererCrashReason;
        int iHashCode2 = (iHashCode + (charSequence != null ? charSequence.hashCode() : 0)) * 31;
        CharSequence charSequence2 = this.minidumpExceptionType;
        int iHashCode3 = (iHashCode2 + (charSequence2 != null ? charSequence2.hashCode() : 0)) * 31;
        CharSequence charSequence3 = this.exitReason;
        int iHashCode4 = (iHashCode3 + (charSequence3 != null ? charSequence3.hashCode() : 0)) * 31;
        CharSequence charSequence4 = this.exitDescription;
        int iHashCode5 = (iHashCode4 + (charSequence4 != null ? charSequence4.hashCode() : 0)) * 31;
        CharSequence charSequence5 = this.tombstoneHash;
        int iHashCode6 = (iHashCode5 + (charSequence5 != null ? charSequence5.hashCode() : 0)) * 31;
        CharSequence charSequence6 = this.tombstoneCause;
        int iHashCode7 = (iHashCode6 + (charSequence6 != null ? charSequence6.hashCode() : 0)) * 31;
        Long l = this.signal;
        int iHashCode8 = (iHashCode7 + (l != null ? l.hashCode() : 0)) * 31;
        Long l2 = this.exceptionType;
        int iHashCode9 = (iHashCode8 + (l2 != null ? l2.hashCode() : 0)) * 31;
        Long l3 = this.exceptionCode;
        int iHashCode10 = (iHashCode9 + (l3 != null ? l3.hashCode() : 0)) * 31;
        CharSequence charSequence7 = this.terminationReason;
        int iHashCode11 = (iHashCode10 + (charSequence7 != null ? charSequence7.hashCode() : 0)) * 31;
        CharSequence charSequence8 = this.binaryName;
        int iHashCode12 = (iHashCode11 + (charSequence8 != null ? charSequence8.hashCode() : 0)) * 31;
        CharSequence charSequence9 = this.callstackHash;
        return iHashCode12 + (charSequence9 != null ? charSequence9.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackAppNativeCrash(didCrash=");
        sbU.append(this.didCrash);
        sbU.append(", rendererCrashReason=");
        sbU.append(this.rendererCrashReason);
        sbU.append(", minidumpExceptionType=");
        sbU.append(this.minidumpExceptionType);
        sbU.append(", exitReason=");
        sbU.append(this.exitReason);
        sbU.append(", exitDescription=");
        sbU.append(this.exitDescription);
        sbU.append(", tombstoneHash=");
        sbU.append(this.tombstoneHash);
        sbU.append(", tombstoneCause=");
        sbU.append(this.tombstoneCause);
        sbU.append(", signal=");
        sbU.append(this.signal);
        sbU.append(", exceptionType=");
        sbU.append(this.exceptionType);
        sbU.append(", exceptionCode=");
        sbU.append(this.exceptionCode);
        sbU.append(", terminationReason=");
        sbU.append(this.terminationReason);
        sbU.append(", binaryName=");
        sbU.append(this.binaryName);
        sbU.append(", callstackHash=");
        return outline.E(sbU, this.callstackHash, ")");
    }
}

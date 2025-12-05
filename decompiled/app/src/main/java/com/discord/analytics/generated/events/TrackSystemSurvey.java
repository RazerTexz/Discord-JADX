package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.api.science.AnalyticsSchema;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: TrackSystemSurvey.kt */
/* loaded from: classes.dex */
public final /* data */ class TrackSystemSurvey implements AnalyticsSchema, TrackBase2 {
    private TrackBase trackBase;
    private final CharSequence cpuBrand = null;
    private final CharSequence cpuVendor = null;
    private final Long cpuMemory = null;
    private final CharSequence gpuBrand = null;
    private final Long gpuCount = null;
    private final Long gpuMemory = null;
    private final Long batteries = null;
    private final Long displayMonitors = null;
    private final Long displayPrimaryWidth = null;
    private final Long displayPrimaryHeight = null;
    private final Long displayDesktopWidth = null;
    private final Long displayDesktopHeight = null;
    private final transient String analyticsSchemaTypeName = "system_survey";

    @Override // com.discord.api.science.AnalyticsSchema
    /* renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackSystemSurvey)) {
            return false;
        }
        TrackSystemSurvey trackSystemSurvey = (TrackSystemSurvey) other;
        return Intrinsics3.areEqual(this.cpuBrand, trackSystemSurvey.cpuBrand) && Intrinsics3.areEqual(this.cpuVendor, trackSystemSurvey.cpuVendor) && Intrinsics3.areEqual(this.cpuMemory, trackSystemSurvey.cpuMemory) && Intrinsics3.areEqual(this.gpuBrand, trackSystemSurvey.gpuBrand) && Intrinsics3.areEqual(this.gpuCount, trackSystemSurvey.gpuCount) && Intrinsics3.areEqual(this.gpuMemory, trackSystemSurvey.gpuMemory) && Intrinsics3.areEqual(this.batteries, trackSystemSurvey.batteries) && Intrinsics3.areEqual(this.displayMonitors, trackSystemSurvey.displayMonitors) && Intrinsics3.areEqual(this.displayPrimaryWidth, trackSystemSurvey.displayPrimaryWidth) && Intrinsics3.areEqual(this.displayPrimaryHeight, trackSystemSurvey.displayPrimaryHeight) && Intrinsics3.areEqual(this.displayDesktopWidth, trackSystemSurvey.displayDesktopWidth) && Intrinsics3.areEqual(this.displayDesktopHeight, trackSystemSurvey.displayDesktopHeight);
    }

    public int hashCode() {
        CharSequence charSequence = this.cpuBrand;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        CharSequence charSequence2 = this.cpuVendor;
        int iHashCode2 = (iHashCode + (charSequence2 != null ? charSequence2.hashCode() : 0)) * 31;
        Long l = this.cpuMemory;
        int iHashCode3 = (iHashCode2 + (l != null ? l.hashCode() : 0)) * 31;
        CharSequence charSequence3 = this.gpuBrand;
        int iHashCode4 = (iHashCode3 + (charSequence3 != null ? charSequence3.hashCode() : 0)) * 31;
        Long l2 = this.gpuCount;
        int iHashCode5 = (iHashCode4 + (l2 != null ? l2.hashCode() : 0)) * 31;
        Long l3 = this.gpuMemory;
        int iHashCode6 = (iHashCode5 + (l3 != null ? l3.hashCode() : 0)) * 31;
        Long l4 = this.batteries;
        int iHashCode7 = (iHashCode6 + (l4 != null ? l4.hashCode() : 0)) * 31;
        Long l5 = this.displayMonitors;
        int iHashCode8 = (iHashCode7 + (l5 != null ? l5.hashCode() : 0)) * 31;
        Long l6 = this.displayPrimaryWidth;
        int iHashCode9 = (iHashCode8 + (l6 != null ? l6.hashCode() : 0)) * 31;
        Long l7 = this.displayPrimaryHeight;
        int iHashCode10 = (iHashCode9 + (l7 != null ? l7.hashCode() : 0)) * 31;
        Long l8 = this.displayDesktopWidth;
        int iHashCode11 = (iHashCode10 + (l8 != null ? l8.hashCode() : 0)) * 31;
        Long l9 = this.displayDesktopHeight;
        return iHashCode11 + (l9 != null ? l9.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = outline.m833U("TrackSystemSurvey(cpuBrand=");
        sbM833U.append(this.cpuBrand);
        sbM833U.append(", cpuVendor=");
        sbM833U.append(this.cpuVendor);
        sbM833U.append(", cpuMemory=");
        sbM833U.append(this.cpuMemory);
        sbM833U.append(", gpuBrand=");
        sbM833U.append(this.gpuBrand);
        sbM833U.append(", gpuCount=");
        sbM833U.append(this.gpuCount);
        sbM833U.append(", gpuMemory=");
        sbM833U.append(this.gpuMemory);
        sbM833U.append(", batteries=");
        sbM833U.append(this.batteries);
        sbM833U.append(", displayMonitors=");
        sbM833U.append(this.displayMonitors);
        sbM833U.append(", displayPrimaryWidth=");
        sbM833U.append(this.displayPrimaryWidth);
        sbM833U.append(", displayPrimaryHeight=");
        sbM833U.append(this.displayPrimaryHeight);
        sbM833U.append(", displayDesktopWidth=");
        sbM833U.append(this.displayDesktopWidth);
        sbM833U.append(", displayDesktopHeight=");
        return outline.m819G(sbM833U, this.displayDesktopHeight, ")");
    }
}

package com.discord.stores;

import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p001a0.p002a.p003a.C0002b;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p580t.Collections2;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: StoreRtcRegion.kt */
/* renamed from: com.discord.stores.RtcLatencyTestResult, reason: use source file name */
/* loaded from: classes2.dex */
public final /* data */ class StoreRtcRegion2 {
    private final List<String> geoRankedRegions;
    private final long lastTestTimestampMs;
    private final List<String> latencyRankedRegions;

    public StoreRtcRegion2() {
        this(null, null, 0L, 7, null);
    }

    public StoreRtcRegion2(List<String> list, List<String> list2, long j) {
        Intrinsics3.checkNotNullParameter(list, "latencyRankedRegions");
        Intrinsics3.checkNotNullParameter(list2, "geoRankedRegions");
        this.latencyRankedRegions = list;
        this.geoRankedRegions = list2;
        this.lastTestTimestampMs = j;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ StoreRtcRegion2 copy$default(StoreRtcRegion2 storeRtcRegion2, List list, List list2, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            list = storeRtcRegion2.latencyRankedRegions;
        }
        if ((i & 2) != 0) {
            list2 = storeRtcRegion2.geoRankedRegions;
        }
        if ((i & 4) != 0) {
            j = storeRtcRegion2.lastTestTimestampMs;
        }
        return storeRtcRegion2.copy(list, list2, j);
    }

    public final List<String> component1() {
        return this.latencyRankedRegions;
    }

    public final List<String> component2() {
        return this.geoRankedRegions;
    }

    /* renamed from: component3, reason: from getter */
    public final long getLastTestTimestampMs() {
        return this.lastTestTimestampMs;
    }

    public final StoreRtcRegion2 copy(List<String> latencyRankedRegions, List<String> geoRankedRegions, long lastTestTimestampMs) {
        Intrinsics3.checkNotNullParameter(latencyRankedRegions, "latencyRankedRegions");
        Intrinsics3.checkNotNullParameter(geoRankedRegions, "geoRankedRegions");
        return new StoreRtcRegion2(latencyRankedRegions, geoRankedRegions, lastTestTimestampMs);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof StoreRtcRegion2)) {
            return false;
        }
        StoreRtcRegion2 storeRtcRegion2 = (StoreRtcRegion2) other;
        return Intrinsics3.areEqual(this.latencyRankedRegions, storeRtcRegion2.latencyRankedRegions) && Intrinsics3.areEqual(this.geoRankedRegions, storeRtcRegion2.geoRankedRegions) && this.lastTestTimestampMs == storeRtcRegion2.lastTestTimestampMs;
    }

    public final List<String> getGeoRankedRegions() {
        return this.geoRankedRegions;
    }

    public final long getLastTestTimestampMs() {
        return this.lastTestTimestampMs;
    }

    public final List<String> getLatencyRankedRegions() {
        return this.latencyRankedRegions;
    }

    public int hashCode() {
        List<String> list = this.latencyRankedRegions;
        int iHashCode = (list != null ? list.hashCode() : 0) * 31;
        List<String> list2 = this.geoRankedRegions;
        return C0002b.m3a(this.lastTestTimestampMs) + ((iHashCode + (list2 != null ? list2.hashCode() : 0)) * 31);
    }

    public String toString() {
        StringBuilder sbM833U = outline.m833U("RtcLatencyTestResult(latencyRankedRegions=");
        sbM833U.append(this.latencyRankedRegions);
        sbM833U.append(", geoRankedRegions=");
        sbM833U.append(this.geoRankedRegions);
        sbM833U.append(", lastTestTimestampMs=");
        return outline.m815C(sbM833U, this.lastTestTimestampMs, ")");
    }

    public /* synthetic */ StoreRtcRegion2(List list, List list2, long j, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? Collections2.emptyList() : list, (i & 2) != 0 ? Collections2.emptyList() : list2, (i & 4) != 0 ? 0L : j);
    }
}

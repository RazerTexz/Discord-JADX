package com.discord.models.domain;

import java.util.List;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: ModelRtcLatencyRegion.kt */
/* loaded from: classes.dex */
public final /* data */ class ModelRtcLatencyRegion {
    private final List<String> ips;
    private final String region;

    public ModelRtcLatencyRegion(String str, List<String> list) {
        Intrinsics3.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_REGION);
        Intrinsics3.checkNotNullParameter(list, "ips");
        this.region = str;
        this.ips = list;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ModelRtcLatencyRegion copy$default(ModelRtcLatencyRegion modelRtcLatencyRegion, String str, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            str = modelRtcLatencyRegion.region;
        }
        if ((i & 2) != 0) {
            list = modelRtcLatencyRegion.ips;
        }
        return modelRtcLatencyRegion.copy(str, list);
    }

    /* renamed from: component1, reason: from getter */
    public final String getRegion() {
        return this.region;
    }

    public final List<String> component2() {
        return this.ips;
    }

    public final ModelRtcLatencyRegion copy(String region, List<String> ips) {
        Intrinsics3.checkNotNullParameter(region, ModelAuditLogEntry.CHANGE_KEY_REGION);
        Intrinsics3.checkNotNullParameter(ips, "ips");
        return new ModelRtcLatencyRegion(region, ips);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ModelRtcLatencyRegion)) {
            return false;
        }
        ModelRtcLatencyRegion modelRtcLatencyRegion = (ModelRtcLatencyRegion) other;
        return Intrinsics3.areEqual(this.region, modelRtcLatencyRegion.region) && Intrinsics3.areEqual(this.ips, modelRtcLatencyRegion.ips);
    }

    public final List<String> getIps() {
        return this.ips;
    }

    public final String getRegion() {
        return this.region;
    }

    public int hashCode() {
        String str = this.region;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        List<String> list = this.ips;
        return iHashCode + (list != null ? list.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = outline.m833U("ModelRtcLatencyRegion(region=");
        sbM833U.append(this.region);
        sbM833U.append(", ips=");
        return outline.m824L(sbM833U, this.ips, ")");
    }
}

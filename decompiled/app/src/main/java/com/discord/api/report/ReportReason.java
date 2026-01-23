package com.discord.api.report;

import com.discord.models.domain.ModelAuditLogEntry;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: compiled from: ReportReason.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class ReportReason {
    private final String description;
    private final String label;
    private final int reason;

    /* JADX INFO: renamed from: a, reason: from getter */
    public final String getDescription() {
        return this.description;
    }

    /* JADX INFO: renamed from: b, reason: from getter */
    public final String getLabel() {
        return this.label;
    }

    /* JADX INFO: renamed from: c, reason: from getter */
    public final int getReason() {
        return this.reason;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ReportReason)) {
            return false;
        }
        ReportReason reportReason = (ReportReason) other;
        return this.reason == reportReason.reason && Intrinsics3.areEqual(this.label, reportReason.label) && Intrinsics3.areEqual(this.description, reportReason.description);
    }

    public int hashCode() {
        int i = this.reason * 31;
        String str = this.label;
        int iHashCode = (i + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.description;
        return iHashCode + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = outline.m833U("ReportReason(reason=");
        sbM833U.append(this.reason);
        sbM833U.append(", label=");
        sbM833U.append(this.label);
        sbM833U.append(", description=");
        return outline.m822J(sbM833U, this.description, ")");
    }
}

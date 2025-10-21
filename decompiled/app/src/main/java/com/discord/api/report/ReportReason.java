package com.discord.api.report;

import b.d.b.a.outline;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.Intrinsics3;

/* compiled from: ReportReason.kt */
/* loaded from: classes.dex */
public final /* data */ class ReportReason {
    private final String description;
    private final String label;
    private final int reason;

    /* renamed from: a, reason: from getter */
    public final String getDescription() {
        return this.description;
    }

    /* renamed from: b, reason: from getter */
    public final String getLabel() {
        return this.label;
    }

    /* renamed from: c, reason: from getter */
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
        StringBuilder sbU = outline.U("ReportReason(reason=");
        sbU.append(this.reason);
        sbU.append(", label=");
        sbU.append(this.label);
        sbU.append(", description=");
        return outline.J(sbU, this.description, ")");
    }
}

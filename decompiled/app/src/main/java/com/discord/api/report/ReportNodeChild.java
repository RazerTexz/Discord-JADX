package com.discord.api.report;

import com.discord.models.domain.ModelAuditLogEntry;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: InAppReportsMenu.kt */
/* loaded from: classes.dex */
public final /* data */ class ReportNodeChild {
    private final String name;
    private final int ref;

    public ReportNodeChild(String str, int i) {
        Intrinsics3.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_NAME);
        this.name = str;
        this.ref = i;
    }

    /* renamed from: a, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* renamed from: b, reason: from getter */
    public final int getRef() {
        return this.ref;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ReportNodeChild)) {
            return false;
        }
        ReportNodeChild reportNodeChild = (ReportNodeChild) other;
        return Intrinsics3.areEqual(this.name, reportNodeChild.name) && this.ref == reportNodeChild.ref;
    }

    public int hashCode() {
        String str = this.name;
        return ((str != null ? str.hashCode() : 0) * 31) + this.ref;
    }

    public String toString() {
        StringBuilder sbM833U = outline.m833U("ReportNodeChild(name=");
        sbM833U.append(this.name);
        sbM833U.append(", ref=");
        return outline.m814B(sbM833U, this.ref, ")");
    }
}

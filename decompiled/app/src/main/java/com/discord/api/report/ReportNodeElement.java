package com.discord.api.report;

import b.d.b.a.outline;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.Intrinsics3;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: InAppReportsMenu.kt */
/* loaded from: classes.dex */
public final /* data */ class ReportNodeElement {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final List<ReportNodeElementData> data;
    private final String name;
    private final boolean should_submit_data;
    private final String type;

    /* compiled from: InAppReportsMenu.kt */
    public static final class Companion {
        public Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
        }
    }

    public final List<ReportNodeElementData> a() {
        return this.data;
    }

    /* renamed from: b, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* renamed from: c, reason: from getter */
    public final String getType() {
        return this.type;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ReportNodeElement)) {
            return false;
        }
        ReportNodeElement reportNodeElement = (ReportNodeElement) other;
        return Intrinsics3.areEqual(this.type, reportNodeElement.type) && Intrinsics3.areEqual(this.name, reportNodeElement.name) && Intrinsics3.areEqual(this.data, reportNodeElement.data) && this.should_submit_data == reportNodeElement.should_submit_data;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        String str = this.type;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.name;
        int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        List<ReportNodeElementData> list = this.data;
        int iHashCode3 = (iHashCode2 + (list != null ? list.hashCode() : 0)) * 31;
        boolean z2 = this.should_submit_data;
        int i = z2;
        if (z2 != 0) {
            i = 1;
        }
        return iHashCode3 + i;
    }

    public String toString() {
        StringBuilder sbU = outline.U("ReportNodeElement(type=");
        sbU.append(this.type);
        sbU.append(", name=");
        sbU.append(this.name);
        sbU.append(", data=");
        sbU.append(this.data);
        sbU.append(", should_submit_data=");
        return outline.O(sbU, this.should_submit_data, ")");
    }
}

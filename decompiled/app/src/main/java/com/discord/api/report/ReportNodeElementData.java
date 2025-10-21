package com.discord.api.report;

import b.d.b.a.outline;
import d0.z.d.Intrinsics3;

/* compiled from: InAppReportsMenu.kt */
/* loaded from: classes.dex */
public final /* data */ class ReportNodeElementData {
    private final String elementKey;
    private final String elementValue;

    public ReportNodeElementData(String str, String str2) {
        Intrinsics3.checkNotNullParameter(str, "elementKey");
        Intrinsics3.checkNotNullParameter(str2, "elementValue");
        this.elementKey = str;
        this.elementValue = str2;
    }

    /* renamed from: a, reason: from getter */
    public final String getElementKey() {
        return this.elementKey;
    }

    /* renamed from: b, reason: from getter */
    public final String getElementValue() {
        return this.elementValue;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ReportNodeElementData)) {
            return false;
        }
        ReportNodeElementData reportNodeElementData = (ReportNodeElementData) other;
        return Intrinsics3.areEqual(this.elementKey, reportNodeElementData.elementKey) && Intrinsics3.areEqual(this.elementValue, reportNodeElementData.elementValue);
    }

    public int hashCode() {
        String str = this.elementKey;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.elementValue;
        return iHashCode + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("ReportNodeElementData(elementKey=");
        sbU.append(this.elementKey);
        sbU.append(", elementValue=");
        return outline.J(sbU, this.elementValue, ")");
    }
}

package com.discord.api.report;

import java.util.List;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: InAppReportsMenu.kt */
/* loaded from: classes.dex */
public final /* data */ class NodeElementResult {
    private final List<ReportNodeElementData> data;
    private final String key;

    public NodeElementResult(String str, List<ReportNodeElementData> list) {
        Intrinsics3.checkNotNullParameter(str, "key");
        Intrinsics3.checkNotNullParameter(list, "data");
        this.key = str;
        this.data = list;
    }

    /* renamed from: a */
    public final List<ReportNodeElementData> m8166a() {
        return this.data;
    }

    /* renamed from: b, reason: from getter */
    public final String getKey() {
        return this.key;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof NodeElementResult)) {
            return false;
        }
        NodeElementResult nodeElementResult = (NodeElementResult) other;
        return Intrinsics3.areEqual(this.key, nodeElementResult.key) && Intrinsics3.areEqual(this.data, nodeElementResult.data);
    }

    public int hashCode() {
        String str = this.key;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        List<ReportNodeElementData> list = this.data;
        return iHashCode + (list != null ? list.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = outline.m833U("NodeElementResult(key=");
        sbM833U.append(this.key);
        sbM833U.append(", data=");
        return outline.m824L(sbM833U, this.data, ")");
    }
}

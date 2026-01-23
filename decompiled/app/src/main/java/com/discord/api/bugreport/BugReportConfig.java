package com.discord.api.bugreport;

import java.util.List;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: compiled from: BugReportConfig.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class BugReportConfig {
    private final List<BugReportConfig2> features;

    /* JADX INFO: renamed from: a */
    public final List<BugReportConfig2> m7625a() {
        return this.features;
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof BugReportConfig) && Intrinsics3.areEqual(this.features, ((BugReportConfig) other).features);
        }
        return true;
    }

    public int hashCode() {
        List<BugReportConfig2> list = this.features;
        if (list != null) {
            return list.hashCode();
        }
        return 0;
    }

    public String toString() {
        return outline.m824L(outline.m833U("BugReportConfig(features="), this.features, ")");
    }
}

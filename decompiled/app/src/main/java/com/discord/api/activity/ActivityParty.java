package com.discord.api.activity;

import com.discord.models.domain.ModelAuditLogEntry;
import java.util.List;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: ActivityParty.kt */
/* loaded from: classes.dex */
public final /* data */ class ActivityParty {
    private final String id;
    private final List<Long> size;

    public ActivityParty(String str, List<Long> list) {
        this.id = str;
        this.size = list;
    }

    /* renamed from: a, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* renamed from: b */
    public final List<Long> m7559b() {
        return this.size;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ActivityParty)) {
            return false;
        }
        ActivityParty activityParty = (ActivityParty) other;
        return Intrinsics3.areEqual(this.id, activityParty.id) && Intrinsics3.areEqual(this.size, activityParty.size);
    }

    public int hashCode() {
        String str = this.id;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        List<Long> list = this.size;
        return iHashCode + (list != null ? list.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = outline.m833U("ActivityParty(id=");
        sbM833U.append(this.id);
        sbM833U.append(", size=");
        return outline.m824L(sbM833U, this.size, ")");
    }
}

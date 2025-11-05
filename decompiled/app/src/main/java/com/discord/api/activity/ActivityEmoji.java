package com.discord.api.activity;

import b.d.b.a.outline;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.Intrinsics3;

/* compiled from: ActivityEmoji.kt */
/* loaded from: classes.dex */
public final /* data */ class ActivityEmoji {
    private final boolean animated;
    private final String id;
    private final String name;

    public ActivityEmoji(String str, String str2, boolean z2) {
        this.id = str;
        this.name = str2;
        this.animated = z2;
    }

    /* renamed from: a, reason: from getter */
    public final boolean getAnimated() {
        return this.animated;
    }

    /* renamed from: b, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* renamed from: c, reason: from getter */
    public final String getName() {
        return this.name;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ActivityEmoji)) {
            return false;
        }
        ActivityEmoji activityEmoji = (ActivityEmoji) other;
        return Intrinsics3.areEqual(this.id, activityEmoji.id) && Intrinsics3.areEqual(this.name, activityEmoji.name) && this.animated == activityEmoji.animated;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        String str = this.id;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.name;
        int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        boolean z2 = this.animated;
        int i = z2;
        if (z2 != 0) {
            i = 1;
        }
        return iHashCode2 + i;
    }

    public String toString() {
        StringBuilder sbU = outline.U("ActivityEmoji(id=");
        sbU.append(this.id);
        sbU.append(", name=");
        sbU.append(this.name);
        sbU.append(", animated=");
        return outline.O(sbU, this.animated, ")");
    }
}

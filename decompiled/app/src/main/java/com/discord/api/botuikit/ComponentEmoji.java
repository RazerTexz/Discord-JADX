package com.discord.api.botuikit;

import com.discord.models.domain.ModelAuditLogEntry;
import java.io.Serializable;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: compiled from: ComponentEmoji.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class ComponentEmoji implements Serializable {
    private final Boolean animated;
    private final String id;
    private final String name;

    /* JADX INFO: renamed from: a, reason: from getter */
    public final Boolean getAnimated() {
        return this.animated;
    }

    /* JADX INFO: renamed from: b, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: c, reason: from getter */
    public final String getName() {
        return this.name;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ComponentEmoji)) {
            return false;
        }
        ComponentEmoji componentEmoji = (ComponentEmoji) other;
        return Intrinsics3.areEqual(this.id, componentEmoji.id) && Intrinsics3.areEqual(this.name, componentEmoji.name) && Intrinsics3.areEqual(this.animated, componentEmoji.animated);
    }

    public int hashCode() {
        String str = this.id;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.name;
        int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        Boolean bool = this.animated;
        return iHashCode2 + (bool != null ? bool.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = outline.m833U("ComponentEmoji(id=");
        sbM833U.append(this.id);
        sbM833U.append(", name=");
        sbM833U.append(this.name);
        sbM833U.append(", animated=");
        return outline.m816D(sbM833U, this.animated, ")");
    }
}

package com.discord.api.botuikit;

import java.util.List;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: ActionRowComponent.kt */
/* loaded from: classes.dex */
public final /* data */ class ActionRowComponent extends Component8 {
    private final List<Component> components;
    private final Component6 type;

    @Override // com.discord.api.botuikit.Component8
    /* renamed from: a */
    public List<Component> mo7593a() {
        return this.components;
    }

    /* renamed from: b */
    public final List<Component> m7594b() {
        return this.components;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ActionRowComponent)) {
            return false;
        }
        ActionRowComponent actionRowComponent = (ActionRowComponent) other;
        return Intrinsics3.areEqual(this.type, actionRowComponent.type) && Intrinsics3.areEqual(this.components, actionRowComponent.components);
    }

    @Override // com.discord.api.botuikit.Component
    public Component6 getType() {
        return this.type;
    }

    public int hashCode() {
        Component6 component6 = this.type;
        int iHashCode = (component6 != null ? component6.hashCode() : 0) * 31;
        List<Component> list = this.components;
        return iHashCode + (list != null ? list.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = outline.m833U("ActionRowComponent(type=");
        sbM833U.append(this.type);
        sbM833U.append(", components=");
        return outline.m824L(sbM833U, this.components, ")");
    }
}

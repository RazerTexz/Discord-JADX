package com.discord.api.botuikit;

import b.d.b.a.outline;
import d0.z.d.Intrinsics3;
import java.util.List;

/* compiled from: SelectComponent.kt */
/* loaded from: classes.dex */
public final /* data */ class SelectComponent extends Component5 {
    private final String customId;
    private final boolean disabled;
    private final int maxValues;
    private final int minValues;
    private final List<SelectComponent2> options;
    private final String placeholder;
    private final Component6 type;

    /* renamed from: a, reason: from getter */
    public final String getCustomId() {
        return this.customId;
    }

    /* renamed from: b, reason: from getter */
    public final boolean getDisabled() {
        return this.disabled;
    }

    /* renamed from: c, reason: from getter */
    public final int getMaxValues() {
        return this.maxValues;
    }

    /* renamed from: d, reason: from getter */
    public final int getMinValues() {
        return this.minValues;
    }

    public final List<SelectComponent2> e() {
        return this.options;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SelectComponent)) {
            return false;
        }
        SelectComponent selectComponent = (SelectComponent) other;
        return Intrinsics3.areEqual(this.type, selectComponent.type) && Intrinsics3.areEqual(this.customId, selectComponent.customId) && this.disabled == selectComponent.disabled && Intrinsics3.areEqual(this.placeholder, selectComponent.placeholder) && this.minValues == selectComponent.minValues && this.maxValues == selectComponent.maxValues && Intrinsics3.areEqual(this.options, selectComponent.options);
    }

    /* renamed from: f, reason: from getter */
    public final String getPlaceholder() {
        return this.placeholder;
    }

    @Override // com.discord.api.botuikit.Component
    public Component6 getType() {
        return this.type;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        Component6 component6 = this.type;
        int iHashCode = (component6 != null ? component6.hashCode() : 0) * 31;
        String str = this.customId;
        int iHashCode2 = (iHashCode + (str != null ? str.hashCode() : 0)) * 31;
        boolean z2 = this.disabled;
        int i = z2;
        if (z2 != 0) {
            i = 1;
        }
        int i2 = (iHashCode2 + i) * 31;
        String str2 = this.placeholder;
        int iHashCode3 = (((((i2 + (str2 != null ? str2.hashCode() : 0)) * 31) + this.minValues) * 31) + this.maxValues) * 31;
        List<SelectComponent2> list = this.options;
        return iHashCode3 + (list != null ? list.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("SelectComponent(type=");
        sbU.append(this.type);
        sbU.append(", customId=");
        sbU.append(this.customId);
        sbU.append(", disabled=");
        sbU.append(this.disabled);
        sbU.append(", placeholder=");
        sbU.append(this.placeholder);
        sbU.append(", minValues=");
        sbU.append(this.minValues);
        sbU.append(", maxValues=");
        sbU.append(this.maxValues);
        sbU.append(", options=");
        return outline.L(sbU, this.options, ")");
    }
}

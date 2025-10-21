package com.discord.api.botuikit;

import b.d.b.a.outline;
import d0.z.d.Intrinsics3;

/* compiled from: ButtonComponent.kt */
/* loaded from: classes.dex */
public final /* data */ class ButtonComponent extends Component5 {
    private final String customId;
    private final boolean disabled;
    private final ComponentEmoji emoji;
    private final String label;
    private final ButtonComponent2 style;
    private final Component6 type;
    private final String url;

    /* renamed from: a, reason: from getter */
    public final String getCustomId() {
        return this.customId;
    }

    /* renamed from: b, reason: from getter */
    public final boolean getDisabled() {
        return this.disabled;
    }

    /* renamed from: c, reason: from getter */
    public final ComponentEmoji getEmoji() {
        return this.emoji;
    }

    /* renamed from: d, reason: from getter */
    public final String getLabel() {
        return this.label;
    }

    /* renamed from: e, reason: from getter */
    public final ButtonComponent2 getStyle() {
        return this.style;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ButtonComponent)) {
            return false;
        }
        ButtonComponent buttonComponent = (ButtonComponent) other;
        return Intrinsics3.areEqual(this.type, buttonComponent.type) && Intrinsics3.areEqual(this.customId, buttonComponent.customId) && Intrinsics3.areEqual(this.label, buttonComponent.label) && Intrinsics3.areEqual(this.style, buttonComponent.style) && this.disabled == buttonComponent.disabled && Intrinsics3.areEqual(this.emoji, buttonComponent.emoji) && Intrinsics3.areEqual(this.url, buttonComponent.url);
    }

    /* renamed from: f, reason: from getter */
    public final String getUrl() {
        return this.url;
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
        String str2 = this.label;
        int iHashCode3 = (iHashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31;
        ButtonComponent2 buttonComponent2 = this.style;
        int iHashCode4 = (iHashCode3 + (buttonComponent2 != null ? buttonComponent2.hashCode() : 0)) * 31;
        boolean z2 = this.disabled;
        int i = z2;
        if (z2 != 0) {
            i = 1;
        }
        int i2 = (iHashCode4 + i) * 31;
        ComponentEmoji componentEmoji = this.emoji;
        int iHashCode5 = (i2 + (componentEmoji != null ? componentEmoji.hashCode() : 0)) * 31;
        String str3 = this.url;
        return iHashCode5 + (str3 != null ? str3.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("ButtonComponent(type=");
        sbU.append(this.type);
        sbU.append(", customId=");
        sbU.append(this.customId);
        sbU.append(", label=");
        sbU.append(this.label);
        sbU.append(", style=");
        sbU.append(this.style);
        sbU.append(", disabled=");
        sbU.append(this.disabled);
        sbU.append(", emoji=");
        sbU.append(this.emoji);
        sbU.append(", url=");
        return outline.J(sbU, this.url, ")");
    }
}

package com.discord.api.botuikit;

import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: TextComponent.kt */
/* loaded from: classes.dex */
public final /* data */ class TextComponent extends Component5 {
    private final String customId;
    private final String label;
    private final int maxLength;
    private final int minLength;
    private final String placeholder;
    private final Boolean required;
    private final TextComponent2 style;
    private final Component6 type;
    private final String value;

    /* renamed from: a, reason: from getter */
    public final String getCustomId() {
        return this.customId;
    }

    /* renamed from: b, reason: from getter */
    public final String getLabel() {
        return this.label;
    }

    /* renamed from: c, reason: from getter */
    public final int getMaxLength() {
        return this.maxLength;
    }

    /* renamed from: d, reason: from getter */
    public final int getMinLength() {
        return this.minLength;
    }

    /* renamed from: e, reason: from getter */
    public final String getPlaceholder() {
        return this.placeholder;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TextComponent)) {
            return false;
        }
        TextComponent textComponent = (TextComponent) other;
        return Intrinsics3.areEqual(this.type, textComponent.type) && Intrinsics3.areEqual(this.style, textComponent.style) && Intrinsics3.areEqual(this.customId, textComponent.customId) && Intrinsics3.areEqual(this.label, textComponent.label) && Intrinsics3.areEqual(this.value, textComponent.value) && Intrinsics3.areEqual(this.placeholder, textComponent.placeholder) && this.minLength == textComponent.minLength && this.maxLength == textComponent.maxLength && Intrinsics3.areEqual(this.required, textComponent.required);
    }

    /* renamed from: f, reason: from getter */
    public final Boolean getRequired() {
        return this.required;
    }

    /* renamed from: g, reason: from getter */
    public final TextComponent2 getStyle() {
        return this.style;
    }

    @Override // com.discord.api.botuikit.Component
    public Component6 getType() {
        return this.type;
    }

    /* renamed from: h, reason: from getter */
    public final String getValue() {
        return this.value;
    }

    public int hashCode() {
        Component6 component6 = this.type;
        int iHashCode = (component6 != null ? component6.hashCode() : 0) * 31;
        TextComponent2 textComponent2 = this.style;
        int iHashCode2 = (iHashCode + (textComponent2 != null ? textComponent2.hashCode() : 0)) * 31;
        String str = this.customId;
        int iHashCode3 = (iHashCode2 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.label;
        int iHashCode4 = (iHashCode3 + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.value;
        int iHashCode5 = (iHashCode4 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.placeholder;
        int iHashCode6 = (((((iHashCode5 + (str4 != null ? str4.hashCode() : 0)) * 31) + this.minLength) * 31) + this.maxLength) * 31;
        Boolean bool = this.required;
        return iHashCode6 + (bool != null ? bool.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = outline.m833U("TextComponent(type=");
        sbM833U.append(this.type);
        sbM833U.append(", style=");
        sbM833U.append(this.style);
        sbM833U.append(", customId=");
        sbM833U.append(this.customId);
        sbM833U.append(", label=");
        sbM833U.append(this.label);
        sbM833U.append(", value=");
        sbM833U.append(this.value);
        sbM833U.append(", placeholder=");
        sbM833U.append(this.placeholder);
        sbM833U.append(", minLength=");
        sbM833U.append(this.minLength);
        sbM833U.append(", maxLength=");
        sbM833U.append(this.maxLength);
        sbM833U.append(", required=");
        return outline.m816D(sbM833U, this.required, ")");
    }
}

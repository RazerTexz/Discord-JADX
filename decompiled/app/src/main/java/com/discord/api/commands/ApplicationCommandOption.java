package com.discord.api.commands;

import com.discord.models.domain.ModelAuditLogEntry;
import java.util.List;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: ApplicationCommandOption.kt */
/* loaded from: classes.dex */
public final /* data */ class ApplicationCommandOption {
    private final boolean autocomplete;
    private final List<Integer> channelTypes;
    private final List<CommandChoice> choices;
    private final boolean default;
    private final String description;
    private final Number maxValue;
    private final Number minValue;
    private final String name;
    private final List<ApplicationCommandOption> options;
    private final boolean required;
    private final ApplicationCommandType type;

    /* renamed from: a, reason: from getter */
    public final boolean getAutocomplete() {
        return this.autocomplete;
    }

    /* renamed from: b */
    public final List<Integer> m7727b() {
        return this.channelTypes;
    }

    /* renamed from: c */
    public final List<CommandChoice> m7728c() {
        return this.choices;
    }

    /* renamed from: d, reason: from getter */
    public final boolean getDefault() {
        return this.default;
    }

    /* renamed from: e, reason: from getter */
    public final String getDescription() {
        return this.description;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ApplicationCommandOption)) {
            return false;
        }
        ApplicationCommandOption applicationCommandOption = (ApplicationCommandOption) other;
        return Intrinsics3.areEqual(this.type, applicationCommandOption.type) && Intrinsics3.areEqual(this.name, applicationCommandOption.name) && Intrinsics3.areEqual(this.description, applicationCommandOption.description) && this.required == applicationCommandOption.required && this.default == applicationCommandOption.default && Intrinsics3.areEqual(this.channelTypes, applicationCommandOption.channelTypes) && Intrinsics3.areEqual(this.choices, applicationCommandOption.choices) && Intrinsics3.areEqual(this.options, applicationCommandOption.options) && this.autocomplete == applicationCommandOption.autocomplete && Intrinsics3.areEqual(this.minValue, applicationCommandOption.minValue) && Intrinsics3.areEqual(this.maxValue, applicationCommandOption.maxValue);
    }

    /* renamed from: f, reason: from getter */
    public final Number getMaxValue() {
        return this.maxValue;
    }

    /* renamed from: g, reason: from getter */
    public final Number getMinValue() {
        return this.minValue;
    }

    /* renamed from: h, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        ApplicationCommandType applicationCommandType = this.type;
        int iHashCode = (applicationCommandType != null ? applicationCommandType.hashCode() : 0) * 31;
        String str = this.name;
        int iHashCode2 = (iHashCode + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.description;
        int iHashCode3 = (iHashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31;
        boolean z2 = this.required;
        int i = z2;
        if (z2 != 0) {
            i = 1;
        }
        int i2 = (iHashCode3 + i) * 31;
        boolean z3 = this.default;
        int i3 = z3;
        if (z3 != 0) {
            i3 = 1;
        }
        int i4 = (i2 + i3) * 31;
        List<Integer> list = this.channelTypes;
        int iHashCode4 = (i4 + (list != null ? list.hashCode() : 0)) * 31;
        List<CommandChoice> list2 = this.choices;
        int iHashCode5 = (iHashCode4 + (list2 != null ? list2.hashCode() : 0)) * 31;
        List<ApplicationCommandOption> list3 = this.options;
        int iHashCode6 = (iHashCode5 + (list3 != null ? list3.hashCode() : 0)) * 31;
        boolean z4 = this.autocomplete;
        int i5 = (iHashCode6 + (z4 ? 1 : z4 ? 1 : 0)) * 31;
        Number number = this.minValue;
        int iHashCode7 = (i5 + (number != null ? number.hashCode() : 0)) * 31;
        Number number2 = this.maxValue;
        return iHashCode7 + (number2 != null ? number2.hashCode() : 0);
    }

    /* renamed from: i */
    public final List<ApplicationCommandOption> m7734i() {
        return this.options;
    }

    /* renamed from: j, reason: from getter */
    public final boolean getRequired() {
        return this.required;
    }

    /* renamed from: k, reason: from getter */
    public final ApplicationCommandType getType() {
        return this.type;
    }

    public String toString() {
        StringBuilder sbM833U = outline.m833U("ApplicationCommandOption(type=");
        sbM833U.append(this.type);
        sbM833U.append(", name=");
        sbM833U.append(this.name);
        sbM833U.append(", description=");
        sbM833U.append(this.description);
        sbM833U.append(", required=");
        sbM833U.append(this.required);
        sbM833U.append(", default=");
        sbM833U.append(this.default);
        sbM833U.append(", channelTypes=");
        sbM833U.append(this.channelTypes);
        sbM833U.append(", choices=");
        sbM833U.append(this.choices);
        sbM833U.append(", options=");
        sbM833U.append(this.options);
        sbM833U.append(", autocomplete=");
        sbM833U.append(this.autocomplete);
        sbM833U.append(", minValue=");
        sbM833U.append(this.minValue);
        sbM833U.append(", maxValue=");
        sbM833U.append(this.maxValue);
        sbM833U.append(")");
        return sbM833U.toString();
    }
}

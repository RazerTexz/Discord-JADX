package com.discord.api.commands;

import b.d.b.a.a;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.m;
import java.util.List;

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

    public final List<Integer> b() {
        return this.channelTypes;
    }

    public final List<CommandChoice> c() {
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
        return m.areEqual(this.type, applicationCommandOption.type) && m.areEqual(this.name, applicationCommandOption.name) && m.areEqual(this.description, applicationCommandOption.description) && this.required == applicationCommandOption.required && this.default == applicationCommandOption.default && m.areEqual(this.channelTypes, applicationCommandOption.channelTypes) && m.areEqual(this.choices, applicationCommandOption.choices) && m.areEqual(this.options, applicationCommandOption.options) && this.autocomplete == applicationCommandOption.autocomplete && m.areEqual(this.minValue, applicationCommandOption.minValue) && m.areEqual(this.maxValue, applicationCommandOption.maxValue);
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

    public final List<ApplicationCommandOption> i() {
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
        StringBuilder sbU = a.U("ApplicationCommandOption(type=");
        sbU.append(this.type);
        sbU.append(", name=");
        sbU.append(this.name);
        sbU.append(", description=");
        sbU.append(this.description);
        sbU.append(", required=");
        sbU.append(this.required);
        sbU.append(", default=");
        sbU.append(this.default);
        sbU.append(", channelTypes=");
        sbU.append(this.channelTypes);
        sbU.append(", choices=");
        sbU.append(this.choices);
        sbU.append(", options=");
        sbU.append(this.options);
        sbU.append(", autocomplete=");
        sbU.append(this.autocomplete);
        sbU.append(", minValue=");
        sbU.append(this.minValue);
        sbU.append(", maxValue=");
        sbU.append(this.maxValue);
        sbU.append(")");
        return sbU.toString();
    }
}

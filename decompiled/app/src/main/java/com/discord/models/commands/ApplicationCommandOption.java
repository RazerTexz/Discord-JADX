package com.discord.models.commands;

import com.discord.api.commands.ApplicationCommandType;
import com.discord.api.commands.CommandChoice;
import com.discord.models.domain.ModelAuditLogEntry;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p580t.Collections2;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: ApplicationCommandOption.kt */
/* loaded from: classes.dex */
public final /* data */ class ApplicationCommandOption {
    private final boolean autocomplete;
    private final List<Integer> channelTypes;
    private final List<CommandChoice> choices;
    private final boolean default;
    private final String description;
    private final Integer descriptionRes;
    private final Number maxValue;
    private final Number minValue;
    private final String name;
    private final List<ApplicationCommandOption> options;
    private final boolean required;
    private final ApplicationCommandType type;

    public ApplicationCommandOption(ApplicationCommandType applicationCommandType, String str, String str2, Integer num, boolean z2, boolean z3, List<Integer> list, List<CommandChoice> list2, List<ApplicationCommandOption> list3, boolean z4, Number number, Number number2) {
        Intrinsics3.checkNotNullParameter(applicationCommandType, "type");
        Intrinsics3.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_NAME);
        this.type = applicationCommandType;
        this.name = str;
        this.description = str2;
        this.descriptionRes = num;
        this.required = z2;
        this.default = z3;
        this.channelTypes = list;
        this.choices = list2;
        this.options = list3;
        this.autocomplete = z4;
        this.minValue = number;
        this.maxValue = number2;
    }

    public static /* synthetic */ ApplicationCommandOption copy$default(ApplicationCommandOption applicationCommandOption, ApplicationCommandType applicationCommandType, String str, String str2, Integer num, boolean z2, boolean z3, List list, List list2, List list3, boolean z4, Number number, Number number2, int i, Object obj) {
        return applicationCommandOption.copy((i & 1) != 0 ? applicationCommandOption.type : applicationCommandType, (i & 2) != 0 ? applicationCommandOption.name : str, (i & 4) != 0 ? applicationCommandOption.description : str2, (i & 8) != 0 ? applicationCommandOption.descriptionRes : num, (i & 16) != 0 ? applicationCommandOption.required : z2, (i & 32) != 0 ? applicationCommandOption.default : z3, (i & 64) != 0 ? applicationCommandOption.channelTypes : list, (i & 128) != 0 ? applicationCommandOption.choices : list2, (i & 256) != 0 ? applicationCommandOption.options : list3, (i & 512) != 0 ? applicationCommandOption.autocomplete : z4, (i & 1024) != 0 ? applicationCommandOption.minValue : number, (i & 2048) != 0 ? applicationCommandOption.maxValue : number2);
    }

    /* renamed from: component1, reason: from getter */
    public final ApplicationCommandType getType() {
        return this.type;
    }

    /* renamed from: component10, reason: from getter */
    public final boolean getAutocomplete() {
        return this.autocomplete;
    }

    /* renamed from: component11, reason: from getter */
    public final Number getMinValue() {
        return this.minValue;
    }

    /* renamed from: component12, reason: from getter */
    public final Number getMaxValue() {
        return this.maxValue;
    }

    /* renamed from: component2, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* renamed from: component3, reason: from getter */
    public final String getDescription() {
        return this.description;
    }

    /* renamed from: component4, reason: from getter */
    public final Integer getDescriptionRes() {
        return this.descriptionRes;
    }

    /* renamed from: component5, reason: from getter */
    public final boolean getRequired() {
        return this.required;
    }

    /* renamed from: component6, reason: from getter */
    public final boolean getDefault() {
        return this.default;
    }

    public final List<Integer> component7() {
        return this.channelTypes;
    }

    public final List<CommandChoice> component8() {
        return this.choices;
    }

    public final List<ApplicationCommandOption> component9() {
        return this.options;
    }

    public final ApplicationCommandOption copy(ApplicationCommandType type, String name, String description, Integer descriptionRes, boolean required, boolean z2, List<Integer> channelTypes, List<CommandChoice> choices, List<ApplicationCommandOption> options, boolean autocomplete, Number minValue, Number maxValue) {
        Intrinsics3.checkNotNullParameter(type, "type");
        Intrinsics3.checkNotNullParameter(name, ModelAuditLogEntry.CHANGE_KEY_NAME);
        return new ApplicationCommandOption(type, name, description, descriptionRes, required, z2, channelTypes, choices, options, autocomplete, minValue, maxValue);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ApplicationCommandOption)) {
            return false;
        }
        ApplicationCommandOption applicationCommandOption = (ApplicationCommandOption) other;
        return Intrinsics3.areEqual(this.type, applicationCommandOption.type) && Intrinsics3.areEqual(this.name, applicationCommandOption.name) && Intrinsics3.areEqual(this.description, applicationCommandOption.description) && Intrinsics3.areEqual(this.descriptionRes, applicationCommandOption.descriptionRes) && this.required == applicationCommandOption.required && this.default == applicationCommandOption.default && Intrinsics3.areEqual(this.channelTypes, applicationCommandOption.channelTypes) && Intrinsics3.areEqual(this.choices, applicationCommandOption.choices) && Intrinsics3.areEqual(this.options, applicationCommandOption.options) && this.autocomplete == applicationCommandOption.autocomplete && Intrinsics3.areEqual(this.minValue, applicationCommandOption.minValue) && Intrinsics3.areEqual(this.maxValue, applicationCommandOption.maxValue);
    }

    public final boolean getAutocomplete() {
        return this.autocomplete;
    }

    public final List<Integer> getChannelTypes() {
        return this.channelTypes;
    }

    public final List<CommandChoice> getChoices() {
        return this.choices;
    }

    public final boolean getDefault() {
        return this.default;
    }

    public final String getDescription() {
        return this.description;
    }

    public final Integer getDescriptionRes() {
        return this.descriptionRes;
    }

    public final Number getMaxValue() {
        return this.maxValue;
    }

    public final Number getMinValue() {
        return this.minValue;
    }

    public final String getName() {
        return this.name;
    }

    public final List<ApplicationCommandOption> getOptions() {
        return this.options;
    }

    public final boolean getRequired() {
        return this.required;
    }

    public final ApplicationCommandType getType() {
        return this.type;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        ApplicationCommandType applicationCommandType = this.type;
        int iHashCode = (applicationCommandType != null ? applicationCommandType.hashCode() : 0) * 31;
        String str = this.name;
        int iHashCode2 = (iHashCode + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.description;
        int iHashCode3 = (iHashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31;
        Integer num = this.descriptionRes;
        int iHashCode4 = (iHashCode3 + (num != null ? num.hashCode() : 0)) * 31;
        boolean z2 = this.required;
        int i = z2;
        if (z2 != 0) {
            i = 1;
        }
        int i2 = (iHashCode4 + i) * 31;
        boolean z3 = this.default;
        int i3 = z3;
        if (z3 != 0) {
            i3 = 1;
        }
        int i4 = (i2 + i3) * 31;
        List<Integer> list = this.channelTypes;
        int iHashCode5 = (i4 + (list != null ? list.hashCode() : 0)) * 31;
        List<CommandChoice> list2 = this.choices;
        int iHashCode6 = (iHashCode5 + (list2 != null ? list2.hashCode() : 0)) * 31;
        List<ApplicationCommandOption> list3 = this.options;
        int iHashCode7 = (iHashCode6 + (list3 != null ? list3.hashCode() : 0)) * 31;
        boolean z4 = this.autocomplete;
        int i5 = (iHashCode7 + (z4 ? 1 : z4 ? 1 : 0)) * 31;
        Number number = this.minValue;
        int iHashCode8 = (i5 + (number != null ? number.hashCode() : 0)) * 31;
        Number number2 = this.maxValue;
        return iHashCode8 + (number2 != null ? number2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = outline.m833U("ApplicationCommandOption(type=");
        sbM833U.append(this.type);
        sbM833U.append(", name=");
        sbM833U.append(this.name);
        sbM833U.append(", description=");
        sbM833U.append(this.description);
        sbM833U.append(", descriptionRes=");
        sbM833U.append(this.descriptionRes);
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

    public /* synthetic */ ApplicationCommandOption(ApplicationCommandType applicationCommandType, String str, String str2, Integer num, boolean z2, boolean z3, List list, List list2, List list3, boolean z4, Number number, Number number2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(applicationCommandType, str, (i & 4) != 0 ? null : str2, (i & 8) != 0 ? null : num, z2, z3, (i & 64) != 0 ? Collections2.emptyList() : list, (i & 128) != 0 ? null : list2, (i & 256) != 0 ? null : list3, (i & 512) != 0 ? false : z4, (i & 1024) != 0 ? null : number, (i & 2048) != 0 ? null : number2);
    }
}

package com.discord.api.commands;

import com.discord.models.domain.ModelAuditLogEntry;
import java.util.List;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: ApplicationCommandData.kt */
/* renamed from: com.discord.api.commands.ApplicationCommandValue, reason: use source file name */
/* loaded from: classes.dex */
public final /* data */ class ApplicationCommandData3 {
    private final Boolean focused;
    private final String name;
    private final List<ApplicationCommandData3> options;
    private final int type;
    private final Object value;

    public ApplicationCommandData3(String str, Object obj, int i, List<ApplicationCommandData3> list, Boolean bool) {
        Intrinsics3.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_NAME);
        this.name = str;
        this.value = obj;
        this.type = i;
        this.options = list;
        this.focused = bool;
    }

    /* renamed from: a */
    public static ApplicationCommandData3 m7739a(ApplicationCommandData3 applicationCommandData3, String str, Object obj, int i, List list, Boolean bool, int i2) {
        String str2 = (i2 & 1) != 0 ? applicationCommandData3.name : null;
        if ((i2 & 2) != 0) {
            obj = applicationCommandData3.value;
        }
        Object obj2 = obj;
        if ((i2 & 4) != 0) {
            i = applicationCommandData3.type;
        }
        int i3 = i;
        List<ApplicationCommandData3> list2 = (i2 & 8) != 0 ? applicationCommandData3.options : null;
        Boolean bool2 = (i2 & 16) != 0 ? applicationCommandData3.focused : null;
        Intrinsics3.checkNotNullParameter(str2, ModelAuditLogEntry.CHANGE_KEY_NAME);
        return new ApplicationCommandData3(str2, obj2, i3, list2, bool2);
    }

    /* renamed from: b, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* renamed from: c */
    public final List<ApplicationCommandData3> m7741c() {
        return this.options;
    }

    /* renamed from: d, reason: from getter */
    public final int getType() {
        return this.type;
    }

    /* renamed from: e, reason: from getter */
    public final Object getValue() {
        return this.value;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ApplicationCommandData3)) {
            return false;
        }
        ApplicationCommandData3 applicationCommandData3 = (ApplicationCommandData3) other;
        return Intrinsics3.areEqual(this.name, applicationCommandData3.name) && Intrinsics3.areEqual(this.value, applicationCommandData3.value) && this.type == applicationCommandData3.type && Intrinsics3.areEqual(this.options, applicationCommandData3.options) && Intrinsics3.areEqual(this.focused, applicationCommandData3.focused);
    }

    public int hashCode() {
        String str = this.name;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        Object obj = this.value;
        int iHashCode2 = (((iHashCode + (obj != null ? obj.hashCode() : 0)) * 31) + this.type) * 31;
        List<ApplicationCommandData3> list = this.options;
        int iHashCode3 = (iHashCode2 + (list != null ? list.hashCode() : 0)) * 31;
        Boolean bool = this.focused;
        return iHashCode3 + (bool != null ? bool.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = outline.m833U("ApplicationCommandValue(name=");
        sbM833U.append(this.name);
        sbM833U.append(", value=");
        sbM833U.append(this.value);
        sbM833U.append(", type=");
        sbM833U.append(this.type);
        sbM833U.append(", options=");
        sbM833U.append(this.options);
        sbM833U.append(", focused=");
        return outline.m816D(sbM833U, this.focused, ")");
    }
}

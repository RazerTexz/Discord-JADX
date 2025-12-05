package com.discord.api.commands;

import com.discord.models.domain.ModelAuditLogEntry;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: CommandChoice.kt */
/* loaded from: classes.dex */
public final /* data */ class CommandChoice {
    private final String name;
    private final String value;

    public CommandChoice(String str, String str2) {
        Intrinsics3.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_NAME);
        Intrinsics3.checkNotNullParameter(str2, "value");
        this.name = str;
        this.value = str2;
    }

    /* renamed from: a, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* renamed from: b, reason: from getter */
    public final String getValue() {
        return this.value;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CommandChoice)) {
            return false;
        }
        CommandChoice commandChoice = (CommandChoice) other;
        return Intrinsics3.areEqual(this.name, commandChoice.name) && Intrinsics3.areEqual(this.value, commandChoice.value);
    }

    public int hashCode() {
        String str = this.name;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.value;
        return iHashCode + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = outline.m833U("CommandChoice(name=");
        sbM833U.append(this.name);
        sbM833U.append(", value=");
        return outline.m822J(sbM833U, this.value, ")");
    }
}

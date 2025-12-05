package com.discord.api.commands;

import com.discord.models.domain.ModelAuditLogEntry;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: ApplicationCommandData.kt */
/* renamed from: com.discord.api.commands.ApplicationCommandAttachment, reason: use source file name */
/* loaded from: classes.dex */
public final /* data */ class ApplicationCommandData2 {
    private final String filename;
    private final String id;

    public ApplicationCommandData2(String str, String str2) {
        Intrinsics3.checkNotNullParameter(str, "filename");
        Intrinsics3.checkNotNullParameter(str2, ModelAuditLogEntry.CHANGE_KEY_ID);
        this.filename = str;
        this.id = str2;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ApplicationCommandData2)) {
            return false;
        }
        ApplicationCommandData2 applicationCommandData2 = (ApplicationCommandData2) other;
        return Intrinsics3.areEqual(this.filename, applicationCommandData2.filename) && Intrinsics3.areEqual(this.id, applicationCommandData2.id);
    }

    public int hashCode() {
        String str = this.filename;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.id;
        return iHashCode + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = outline.m833U("ApplicationCommandAttachment(filename=");
        sbM833U.append(this.filename);
        sbM833U.append(", id=");
        return outline.m822J(sbM833U, this.id, ")");
    }
}

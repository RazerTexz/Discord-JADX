package com.discord.api.message;

import b.d.b.a.outline;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.Intrinsics3;

/* compiled from: LocalAttachment.kt */
/* loaded from: classes.dex */
public final /* data */ class LocalAttachment {
    private final String displayName;
    private final long id;
    private final String uriString;

    public LocalAttachment(long j, String str, String str2) {
        Intrinsics3.checkNotNullParameter(str, "uriString");
        Intrinsics3.checkNotNullParameter(str2, "displayName");
        this.id = j;
        this.uriString = str;
        this.displayName = str2;
    }

    /* renamed from: a, reason: from getter */
    public final String getDisplayName() {
        return this.displayName;
    }

    /* renamed from: b, reason: from getter */
    public final long getId() {
        return this.id;
    }

    /* renamed from: c, reason: from getter */
    public final String getUriString() {
        return this.uriString;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof LocalAttachment)) {
            return false;
        }
        LocalAttachment localAttachment = (LocalAttachment) other;
        return this.id == localAttachment.id && Intrinsics3.areEqual(this.uriString, localAttachment.uriString) && Intrinsics3.areEqual(this.displayName, localAttachment.displayName);
    }

    public int hashCode() {
        long j = this.id;
        int i = ((int) (j ^ (j >>> 32))) * 31;
        String str = this.uriString;
        int iHashCode = (i + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.displayName;
        return iHashCode + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("LocalAttachment(id=");
        sbU.append(this.id);
        sbU.append(", uriString=");
        sbU.append(this.uriString);
        sbU.append(", displayName=");
        return outline.J(sbU, this.displayName, ")");
    }
}

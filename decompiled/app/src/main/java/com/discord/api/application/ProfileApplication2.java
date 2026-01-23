package com.discord.api.application;

import com.discord.models.domain.ModelAuditLogEntry;
import java.util.Arrays;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: renamed from: com.discord.api.application.ApplicationInstallParams, reason: use source file name */
/* JADX INFO: compiled from: ProfileApplication.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class ProfileApplication2 {
    private final String permissions;
    private final String[] scopes;

    /* JADX INFO: renamed from: a, reason: from getter */
    public final String getPermissions() {
        return this.permissions;
    }

    /* JADX INFO: renamed from: b, reason: from getter */
    public final String[] getScopes() {
        return this.scopes;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ProfileApplication2)) {
            return false;
        }
        ProfileApplication2 profileApplication2 = (ProfileApplication2) other;
        return Intrinsics3.areEqual(this.permissions, profileApplication2.permissions) && Intrinsics3.areEqual(this.scopes, profileApplication2.scopes);
    }

    public int hashCode() {
        String str = this.permissions;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        String[] strArr = this.scopes;
        return iHashCode + (strArr != null ? Arrays.hashCode(strArr) : 0);
    }

    public String toString() {
        StringBuilder sbM833U = outline.m833U("ApplicationInstallParams(permissions=");
        sbM833U.append(this.permissions);
        sbM833U.append(", scopes=");
        return outline.m822J(sbM833U, Arrays.toString(this.scopes), ")");
    }
}

package com.discord.api.connectedaccounts;

import b.d.b.a.outline;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.Intrinsics3;
import java.util.List;

/* compiled from: ConnectedAccount.kt */
/* loaded from: classes.dex */
public final /* data */ class ConnectedAccount {
    public static final int HIDDEN = 0;
    public static final int VISIBLE = 1;
    private final boolean friendSync;
    private final String id;
    private final List<ConnectedAccountIntegration> integrations;
    private final String name;
    private final boolean revoked;
    private final boolean showActivity;
    private final String type;
    private final boolean verified;
    private final int visibility;

    public ConnectedAccount() {
        outline.q0("", ModelAuditLogEntry.CHANGE_KEY_ID, "", ModelAuditLogEntry.CHANGE_KEY_NAME, "", "type");
        this.id = "";
        this.name = "";
        this.visibility = 0;
        this.friendSync = false;
        this.showActivity = false;
        this.revoked = false;
        this.verified = false;
        this.integrations = null;
        this.type = "";
    }

    /* renamed from: a, reason: from getter */
    public final boolean getFriendSync() {
        return this.friendSync;
    }

    /* renamed from: b, reason: from getter */
    public final String getId() {
        return this.id;
    }

    public final List<ConnectedAccountIntegration> c() {
        return this.integrations;
    }

    /* renamed from: d, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* renamed from: e, reason: from getter */
    public final boolean getRevoked() {
        return this.revoked;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ConnectedAccount)) {
            return false;
        }
        ConnectedAccount connectedAccount = (ConnectedAccount) other;
        return Intrinsics3.areEqual(this.id, connectedAccount.id) && Intrinsics3.areEqual(this.name, connectedAccount.name) && this.visibility == connectedAccount.visibility && this.friendSync == connectedAccount.friendSync && this.showActivity == connectedAccount.showActivity && this.revoked == connectedAccount.revoked && this.verified == connectedAccount.verified && Intrinsics3.areEqual(this.integrations, connectedAccount.integrations) && Intrinsics3.areEqual(this.type, connectedAccount.type);
    }

    /* renamed from: f, reason: from getter */
    public final boolean getShowActivity() {
        return this.showActivity;
    }

    /* renamed from: g, reason: from getter */
    public final String getType() {
        return this.type;
    }

    /* renamed from: h, reason: from getter */
    public final boolean getVerified() {
        return this.verified;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        String str = this.id;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.name;
        int iHashCode2 = (((iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31) + this.visibility) * 31;
        boolean z2 = this.friendSync;
        int i = z2;
        if (z2 != 0) {
            i = 1;
        }
        int i2 = (iHashCode2 + i) * 31;
        boolean z3 = this.showActivity;
        int i3 = z3;
        if (z3 != 0) {
            i3 = 1;
        }
        int i4 = (i2 + i3) * 31;
        boolean z4 = this.revoked;
        int i5 = z4;
        if (z4 != 0) {
            i5 = 1;
        }
        int i6 = (i4 + i5) * 31;
        boolean z5 = this.verified;
        int i7 = (i6 + (z5 ? 1 : z5 ? 1 : 0)) * 31;
        List<ConnectedAccountIntegration> list = this.integrations;
        int iHashCode3 = (i7 + (list != null ? list.hashCode() : 0)) * 31;
        String str3 = this.type;
        return iHashCode3 + (str3 != null ? str3.hashCode() : 0);
    }

    /* renamed from: i, reason: from getter */
    public final int getVisibility() {
        return this.visibility;
    }

    public String toString() {
        StringBuilder sbU = outline.U("ConnectedAccount(id=");
        sbU.append(this.id);
        sbU.append(", name=");
        sbU.append(this.name);
        sbU.append(", visibility=");
        sbU.append(this.visibility);
        sbU.append(", friendSync=");
        sbU.append(this.friendSync);
        sbU.append(", showActivity=");
        sbU.append(this.showActivity);
        sbU.append(", revoked=");
        sbU.append(this.revoked);
        sbU.append(", verified=");
        sbU.append(this.verified);
        sbU.append(", integrations=");
        sbU.append(this.integrations);
        sbU.append(", type=");
        return outline.J(sbU, this.type, ")");
    }
}

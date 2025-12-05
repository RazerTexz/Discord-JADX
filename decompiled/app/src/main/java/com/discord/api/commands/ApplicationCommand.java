package com.discord.api.commands;

import com.discord.models.domain.ModelAuditLogEntry;
import java.util.List;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: ApplicationCommand.kt */
/* loaded from: classes.dex */
public final /* data */ class ApplicationCommand {
    private final long applicationId;
    private final Boolean defaultPermissions;
    private final String description;
    private final String guildId;
    private final long id;
    private final String name;
    private final List<ApplicationCommandOption> options;
    private final List<ApplicationCommandPermission> permissions;
    private final String version;

    /* renamed from: a, reason: from getter */
    public final long getApplicationId() {
        return this.applicationId;
    }

    /* renamed from: b, reason: from getter */
    public final Boolean getDefaultPermissions() {
        return this.defaultPermissions;
    }

    /* renamed from: c, reason: from getter */
    public final String getDescription() {
        return this.description;
    }

    /* renamed from: d, reason: from getter */
    public final String getGuildId() {
        return this.guildId;
    }

    /* renamed from: e, reason: from getter */
    public final long getId() {
        return this.id;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ApplicationCommand)) {
            return false;
        }
        ApplicationCommand applicationCommand = (ApplicationCommand) other;
        return this.id == applicationCommand.id && this.applicationId == applicationCommand.applicationId && Intrinsics3.areEqual(this.name, applicationCommand.name) && Intrinsics3.areEqual(this.description, applicationCommand.description) && Intrinsics3.areEqual(this.options, applicationCommand.options) && Intrinsics3.areEqual(this.version, applicationCommand.version) && Intrinsics3.areEqual(this.guildId, applicationCommand.guildId) && Intrinsics3.areEqual(this.defaultPermissions, applicationCommand.defaultPermissions) && Intrinsics3.areEqual(this.permissions, applicationCommand.permissions);
    }

    /* renamed from: f, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* renamed from: g */
    public final List<ApplicationCommandOption> m7717g() {
        return this.options;
    }

    /* renamed from: h */
    public final List<ApplicationCommandPermission> m7718h() {
        return this.permissions;
    }

    public int hashCode() {
        long j = this.id;
        long j2 = this.applicationId;
        int i = ((((int) (j ^ (j >>> 32))) * 31) + ((int) (j2 ^ (j2 >>> 32)))) * 31;
        String str = this.name;
        int iHashCode = (i + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.description;
        int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        List<ApplicationCommandOption> list = this.options;
        int iHashCode3 = (iHashCode2 + (list != null ? list.hashCode() : 0)) * 31;
        String str3 = this.version;
        int iHashCode4 = (iHashCode3 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.guildId;
        int iHashCode5 = (iHashCode4 + (str4 != null ? str4.hashCode() : 0)) * 31;
        Boolean bool = this.defaultPermissions;
        int iHashCode6 = (iHashCode5 + (bool != null ? bool.hashCode() : 0)) * 31;
        List<ApplicationCommandPermission> list2 = this.permissions;
        return iHashCode6 + (list2 != null ? list2.hashCode() : 0);
    }

    /* renamed from: i, reason: from getter */
    public final String getVersion() {
        return this.version;
    }

    public String toString() {
        StringBuilder sbM833U = outline.m833U("ApplicationCommand(id=");
        sbM833U.append(this.id);
        sbM833U.append(", applicationId=");
        sbM833U.append(this.applicationId);
        sbM833U.append(", name=");
        sbM833U.append(this.name);
        sbM833U.append(", description=");
        sbM833U.append(this.description);
        sbM833U.append(", options=");
        sbM833U.append(this.options);
        sbM833U.append(", version=");
        sbM833U.append(this.version);
        sbM833U.append(", guildId=");
        sbM833U.append(this.guildId);
        sbM833U.append(", defaultPermissions=");
        sbM833U.append(this.defaultPermissions);
        sbM833U.append(", permissions=");
        return outline.m824L(sbM833U, this.permissions, ")");
    }
}

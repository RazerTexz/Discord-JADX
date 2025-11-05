package com.discord.utilities.permissions;

import b.d.b.a.a;
import com.discord.api.channel.Channel;
import com.discord.api.permission.Permission;
import d0.z.d.m;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: PermissionsContexts.kt */
/* loaded from: classes2.dex */
public final /* data */ class ManageGuildContext {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final boolean canManageBans;
    private final boolean canManageChannels;
    private final boolean canManageEmojisAndStickers;
    private final boolean canManageEvents;
    private final boolean canManageNicknames;
    private final boolean canManageRoles;
    private final boolean canManageServer;
    private final boolean canViewAuditLogs;
    private final boolean isOwnerWithRequiredMFALevel;

    /* compiled from: PermissionsContexts.kt */
    public static final class Companion {
        private Companion() {
        }

        public final ManageGuildContext from(List<Channel> categories, boolean isOwner, Long guildPermissions, Map<Long, Long> channelPermissions, int guildMfaLevel, boolean isMeMfaEnabled) {
            boolean z2;
            m.checkNotNullParameter(categories, "categories");
            m.checkNotNullParameter(channelPermissions, "channelPermissions");
            if ((categories instanceof Collection) && categories.isEmpty()) {
                z2 = false;
            } else {
                Iterator<T> it = categories.iterator();
                while (it.hasNext()) {
                    if (PermissionUtils.can(16L, (Long) a.d((Channel) it.next(), channelPermissions))) {
                        z2 = true;
                        break;
                    }
                }
                z2 = false;
            }
            return new ManageGuildContext(isOwner || PermissionUtils.can(32L, guildPermissions), isOwner || PermissionUtils.can(16L, guildPermissions) || z2, isOwner || PermissionUtils.can(Permission.MANAGE_ROLES, guildPermissions), isOwner || PermissionUtils.can(4L, guildPermissions), isOwner || PermissionUtils.can(Permission.MANAGE_NICKNAMES, guildPermissions), isOwner || PermissionUtils.can(Permission.MANAGE_EMOJIS_AND_STICKERS, guildPermissions), isOwner || PermissionUtils.can(128L, guildPermissions), isOwner || PermissionUtils.can(Permission.MANAGE_EVENTS, guildPermissions), isOwner && PermissionUtils.isElevated(isMeMfaEnabled, guildMfaLevel));
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public ManageGuildContext(boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, boolean z8, boolean z9, boolean z10) {
        this.canManageServer = z2;
        this.canManageChannels = z3;
        this.canManageRoles = z4;
        this.canManageBans = z5;
        this.canManageNicknames = z6;
        this.canManageEmojisAndStickers = z7;
        this.canViewAuditLogs = z8;
        this.canManageEvents = z9;
        this.isOwnerWithRequiredMFALevel = z10;
    }

    public static /* synthetic */ ManageGuildContext copy$default(ManageGuildContext manageGuildContext, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, boolean z8, boolean z9, boolean z10, int i, Object obj) {
        return manageGuildContext.copy((i & 1) != 0 ? manageGuildContext.canManageServer : z2, (i & 2) != 0 ? manageGuildContext.canManageChannels : z3, (i & 4) != 0 ? manageGuildContext.canManageRoles : z4, (i & 8) != 0 ? manageGuildContext.canManageBans : z5, (i & 16) != 0 ? manageGuildContext.canManageNicknames : z6, (i & 32) != 0 ? manageGuildContext.canManageEmojisAndStickers : z7, (i & 64) != 0 ? manageGuildContext.canViewAuditLogs : z8, (i & 128) != 0 ? manageGuildContext.canManageEvents : z9, (i & 256) != 0 ? manageGuildContext.isOwnerWithRequiredMFALevel : z10);
    }

    public static final ManageGuildContext from(List<Channel> list, boolean z2, Long l, Map<Long, Long> map, int i, boolean z3) {
        return INSTANCE.from(list, z2, l, map, i, z3);
    }

    public final boolean canManage() {
        return this.canManageServer || this.canManageChannels || this.canManageRoles || this.canManageBans || this.canViewAuditLogs || this.canManageEmojisAndStickers || this.isOwnerWithRequiredMFALevel;
    }

    /* renamed from: component1, reason: from getter */
    public final boolean getCanManageServer() {
        return this.canManageServer;
    }

    /* renamed from: component2, reason: from getter */
    public final boolean getCanManageChannels() {
        return this.canManageChannels;
    }

    /* renamed from: component3, reason: from getter */
    public final boolean getCanManageRoles() {
        return this.canManageRoles;
    }

    /* renamed from: component4, reason: from getter */
    public final boolean getCanManageBans() {
        return this.canManageBans;
    }

    /* renamed from: component5, reason: from getter */
    public final boolean getCanManageNicknames() {
        return this.canManageNicknames;
    }

    /* renamed from: component6, reason: from getter */
    public final boolean getCanManageEmojisAndStickers() {
        return this.canManageEmojisAndStickers;
    }

    /* renamed from: component7, reason: from getter */
    public final boolean getCanViewAuditLogs() {
        return this.canViewAuditLogs;
    }

    /* renamed from: component8, reason: from getter */
    public final boolean getCanManageEvents() {
        return this.canManageEvents;
    }

    /* renamed from: component9, reason: from getter */
    public final boolean getIsOwnerWithRequiredMFALevel() {
        return this.isOwnerWithRequiredMFALevel;
    }

    public final ManageGuildContext copy(boolean canManageServer, boolean canManageChannels, boolean canManageRoles, boolean canManageBans, boolean canManageNicknames, boolean canManageEmojisAndStickers, boolean canViewAuditLogs, boolean canManageEvents, boolean isOwnerWithRequiredMFALevel) {
        return new ManageGuildContext(canManageServer, canManageChannels, canManageRoles, canManageBans, canManageNicknames, canManageEmojisAndStickers, canViewAuditLogs, canManageEvents, isOwnerWithRequiredMFALevel);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ManageGuildContext)) {
            return false;
        }
        ManageGuildContext manageGuildContext = (ManageGuildContext) other;
        return this.canManageServer == manageGuildContext.canManageServer && this.canManageChannels == manageGuildContext.canManageChannels && this.canManageRoles == manageGuildContext.canManageRoles && this.canManageBans == manageGuildContext.canManageBans && this.canManageNicknames == manageGuildContext.canManageNicknames && this.canManageEmojisAndStickers == manageGuildContext.canManageEmojisAndStickers && this.canViewAuditLogs == manageGuildContext.canViewAuditLogs && this.canManageEvents == manageGuildContext.canManageEvents && this.isOwnerWithRequiredMFALevel == manageGuildContext.isOwnerWithRequiredMFALevel;
    }

    public final boolean getCanManageBans() {
        return this.canManageBans;
    }

    public final boolean getCanManageChannels() {
        return this.canManageChannels;
    }

    public final boolean getCanManageEmojisAndStickers() {
        return this.canManageEmojisAndStickers;
    }

    public final boolean getCanManageEvents() {
        return this.canManageEvents;
    }

    public final boolean getCanManageNicknames() {
        return this.canManageNicknames;
    }

    public final boolean getCanManageRoles() {
        return this.canManageRoles;
    }

    public final boolean getCanManageServer() {
        return this.canManageServer;
    }

    public final boolean getCanViewAuditLogs() {
        return this.canViewAuditLogs;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v18 */
    /* JADX WARN: Type inference failed for: r0v19 */
    /* JADX WARN: Type inference failed for: r2v0, types: [boolean] */
    /* JADX WARN: Type inference failed for: r2v10, types: [boolean] */
    /* JADX WARN: Type inference failed for: r2v12, types: [boolean] */
    /* JADX WARN: Type inference failed for: r2v2, types: [boolean] */
    /* JADX WARN: Type inference failed for: r2v4, types: [boolean] */
    /* JADX WARN: Type inference failed for: r2v6, types: [boolean] */
    /* JADX WARN: Type inference failed for: r2v8, types: [boolean] */
    public int hashCode() {
        boolean z2 = this.canManageServer;
        ?? r0 = z2;
        if (z2) {
            r0 = 1;
        }
        int i = r0 * 31;
        ?? r2 = this.canManageChannels;
        int i2 = r2;
        if (r2 != 0) {
            i2 = 1;
        }
        int i3 = (i + i2) * 31;
        ?? r22 = this.canManageRoles;
        int i4 = r22;
        if (r22 != 0) {
            i4 = 1;
        }
        int i5 = (i3 + i4) * 31;
        ?? r23 = this.canManageBans;
        int i6 = r23;
        if (r23 != 0) {
            i6 = 1;
        }
        int i7 = (i5 + i6) * 31;
        ?? r24 = this.canManageNicknames;
        int i8 = r24;
        if (r24 != 0) {
            i8 = 1;
        }
        int i9 = (i7 + i8) * 31;
        ?? r25 = this.canManageEmojisAndStickers;
        int i10 = r25;
        if (r25 != 0) {
            i10 = 1;
        }
        int i11 = (i9 + i10) * 31;
        ?? r26 = this.canViewAuditLogs;
        int i12 = r26;
        if (r26 != 0) {
            i12 = 1;
        }
        int i13 = (i11 + i12) * 31;
        ?? r27 = this.canManageEvents;
        int i14 = r27;
        if (r27 != 0) {
            i14 = 1;
        }
        int i15 = (i13 + i14) * 31;
        boolean z3 = this.isOwnerWithRequiredMFALevel;
        return i15 + (z3 ? 1 : z3 ? 1 : 0);
    }

    public final boolean isOwnerWithRequiredMFALevel() {
        return this.isOwnerWithRequiredMFALevel;
    }

    public String toString() {
        StringBuilder sbU = a.U("ManageGuildContext(canManageServer=");
        sbU.append(this.canManageServer);
        sbU.append(", canManageChannels=");
        sbU.append(this.canManageChannels);
        sbU.append(", canManageRoles=");
        sbU.append(this.canManageRoles);
        sbU.append(", canManageBans=");
        sbU.append(this.canManageBans);
        sbU.append(", canManageNicknames=");
        sbU.append(this.canManageNicknames);
        sbU.append(", canManageEmojisAndStickers=");
        sbU.append(this.canManageEmojisAndStickers);
        sbU.append(", canViewAuditLogs=");
        sbU.append(this.canViewAuditLogs);
        sbU.append(", canManageEvents=");
        sbU.append(this.canManageEvents);
        sbU.append(", isOwnerWithRequiredMFALevel=");
        return a.O(sbU, this.isOwnerWithRequiredMFALevel, ")");
    }
}

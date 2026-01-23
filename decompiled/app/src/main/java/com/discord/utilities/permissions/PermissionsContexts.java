package com.discord.utilities.permissions;

import com.discord.api.channel.Channel;
import com.discord.api.permission.Permission;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: renamed from: com.discord.utilities.permissions.ManageGuildContext, reason: use source file name */
/* JADX INFO: compiled from: PermissionsContexts.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class PermissionsContexts {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
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

    /* JADX INFO: renamed from: com.discord.utilities.permissions.ManageGuildContext$Companion, reason: from kotlin metadata */
    /* JADX INFO: compiled from: PermissionsContexts.kt */
    public static final class Companion {
        private Companion() {
        }

        public final PermissionsContexts from(List<Channel> categories, boolean isOwner, Long guildPermissions, Map<Long, Long> channelPermissions, int guildMfaLevel, boolean isMeMfaEnabled) {
            boolean z2;
            Intrinsics3.checkNotNullParameter(categories, "categories");
            Intrinsics3.checkNotNullParameter(channelPermissions, "channelPermissions");
            if ((categories instanceof Collection) && categories.isEmpty()) {
                z2 = false;
            } else {
                Iterator<T> it = categories.iterator();
                while (it.hasNext()) {
                    if (PermissionUtils.can(16L, (Long) outline.m845d((Channel) it.next(), channelPermissions))) {
                        z2 = true;
                        break;
                    }
                }
                z2 = false;
            }
            return new PermissionsContexts(isOwner || PermissionUtils.can(32L, guildPermissions), isOwner || PermissionUtils.can(16L, guildPermissions) || z2, isOwner || PermissionUtils.can(Permission.MANAGE_ROLES, guildPermissions), isOwner || PermissionUtils.can(4L, guildPermissions), isOwner || PermissionUtils.can(Permission.MANAGE_NICKNAMES, guildPermissions), isOwner || PermissionUtils.can(Permission.MANAGE_EMOJIS_AND_STICKERS, guildPermissions), isOwner || PermissionUtils.can(128L, guildPermissions), isOwner || PermissionUtils.can(Permission.MANAGE_EVENTS, guildPermissions), isOwner && PermissionUtils.isElevated(isMeMfaEnabled, guildMfaLevel));
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public PermissionsContexts(boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, boolean z8, boolean z9, boolean z10) {
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

    public static /* synthetic */ PermissionsContexts copy$default(PermissionsContexts permissionsContexts, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, boolean z8, boolean z9, boolean z10, int i, Object obj) {
        return permissionsContexts.copy((i & 1) != 0 ? permissionsContexts.canManageServer : z2, (i & 2) != 0 ? permissionsContexts.canManageChannels : z3, (i & 4) != 0 ? permissionsContexts.canManageRoles : z4, (i & 8) != 0 ? permissionsContexts.canManageBans : z5, (i & 16) != 0 ? permissionsContexts.canManageNicknames : z6, (i & 32) != 0 ? permissionsContexts.canManageEmojisAndStickers : z7, (i & 64) != 0 ? permissionsContexts.canViewAuditLogs : z8, (i & 128) != 0 ? permissionsContexts.canManageEvents : z9, (i & 256) != 0 ? permissionsContexts.isOwnerWithRequiredMFALevel : z10);
    }

    public static final PermissionsContexts from(List<Channel> list, boolean z2, Long l, Map<Long, Long> map, int i, boolean z3) {
        return INSTANCE.from(list, z2, l, map, i, z3);
    }

    public final boolean canManage() {
        return this.canManageServer || this.canManageChannels || this.canManageRoles || this.canManageBans || this.canViewAuditLogs || this.canManageEmojisAndStickers || this.isOwnerWithRequiredMFALevel;
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final boolean getCanManageServer() {
        return this.canManageServer;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final boolean getCanManageChannels() {
        return this.canManageChannels;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final boolean getCanManageRoles() {
        return this.canManageRoles;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final boolean getCanManageBans() {
        return this.canManageBans;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final boolean getCanManageNicknames() {
        return this.canManageNicknames;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final boolean getCanManageEmojisAndStickers() {
        return this.canManageEmojisAndStickers;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final boolean getCanViewAuditLogs() {
        return this.canViewAuditLogs;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final boolean getCanManageEvents() {
        return this.canManageEvents;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final boolean getIsOwnerWithRequiredMFALevel() {
        return this.isOwnerWithRequiredMFALevel;
    }

    public final PermissionsContexts copy(boolean canManageServer, boolean canManageChannels, boolean canManageRoles, boolean canManageBans, boolean canManageNicknames, boolean canManageEmojisAndStickers, boolean canViewAuditLogs, boolean canManageEvents, boolean isOwnerWithRequiredMFALevel) {
        return new PermissionsContexts(canManageServer, canManageChannels, canManageRoles, canManageBans, canManageNicknames, canManageEmojisAndStickers, canViewAuditLogs, canManageEvents, isOwnerWithRequiredMFALevel);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PermissionsContexts)) {
            return false;
        }
        PermissionsContexts permissionsContexts = (PermissionsContexts) other;
        return this.canManageServer == permissionsContexts.canManageServer && this.canManageChannels == permissionsContexts.canManageChannels && this.canManageRoles == permissionsContexts.canManageRoles && this.canManageBans == permissionsContexts.canManageBans && this.canManageNicknames == permissionsContexts.canManageNicknames && this.canManageEmojisAndStickers == permissionsContexts.canManageEmojisAndStickers && this.canViewAuditLogs == permissionsContexts.canViewAuditLogs && this.canManageEvents == permissionsContexts.canManageEvents && this.isOwnerWithRequiredMFALevel == permissionsContexts.isOwnerWithRequiredMFALevel;
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
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v11, types: [int] */
    /* JADX WARN: Type inference failed for: r2v13, types: [int] */
    /* JADX WARN: Type inference failed for: r2v15 */
    /* JADX WARN: Type inference failed for: r2v16 */
    /* JADX WARN: Type inference failed for: r2v17 */
    /* JADX WARN: Type inference failed for: r2v18 */
    /* JADX WARN: Type inference failed for: r2v19 */
    /* JADX WARN: Type inference failed for: r2v20 */
    /* JADX WARN: Type inference failed for: r2v21 */
    /* JADX WARN: Type inference failed for: r2v22 */
    /* JADX WARN: Type inference failed for: r2v23 */
    /* JADX WARN: Type inference failed for: r2v24 */
    /* JADX WARN: Type inference failed for: r2v25 */
    /* JADX WARN: Type inference failed for: r2v26 */
    /* JADX WARN: Type inference failed for: r2v27 */
    /* JADX WARN: Type inference failed for: r2v28 */
    /* JADX WARN: Type inference failed for: r2v3, types: [int] */
    /* JADX WARN: Type inference failed for: r2v5, types: [int] */
    /* JADX WARN: Type inference failed for: r2v7, types: [int] */
    /* JADX WARN: Type inference failed for: r2v9, types: [int] */
    public int hashCode() {
        boolean z2 = this.canManageServer;
        ?? r0 = z2;
        if (z2) {
            r0 = 1;
        }
        int i = r0 * 31;
        boolean z3 = this.canManageChannels;
        ?? r2 = z3;
        if (z3) {
            r2 = 1;
        }
        int i2 = (i + r2) * 31;
        boolean z4 = this.canManageRoles;
        ?? r22 = z4;
        if (z4) {
            r22 = 1;
        }
        int i3 = (i2 + r22) * 31;
        boolean z5 = this.canManageBans;
        ?? r23 = z5;
        if (z5) {
            r23 = 1;
        }
        int i4 = (i3 + r23) * 31;
        boolean z6 = this.canManageNicknames;
        ?? r24 = z6;
        if (z6) {
            r24 = 1;
        }
        int i5 = (i4 + r24) * 31;
        boolean z7 = this.canManageEmojisAndStickers;
        ?? r25 = z7;
        if (z7) {
            r25 = 1;
        }
        int i6 = (i5 + r25) * 31;
        boolean z8 = this.canViewAuditLogs;
        ?? r26 = z8;
        if (z8) {
            r26 = 1;
        }
        int i7 = (i6 + r26) * 31;
        boolean z9 = this.canManageEvents;
        ?? r27 = z9;
        if (z9) {
            r27 = 1;
        }
        int i8 = (i7 + r27) * 31;
        boolean z10 = this.isOwnerWithRequiredMFALevel;
        return i8 + (z10 ? 1 : z10);
    }

    public final boolean isOwnerWithRequiredMFALevel() {
        return this.isOwnerWithRequiredMFALevel;
    }

    public String toString() {
        StringBuilder sbM833U = outline.m833U("ManageGuildContext(canManageServer=");
        sbM833U.append(this.canManageServer);
        sbM833U.append(", canManageChannels=");
        sbM833U.append(this.canManageChannels);
        sbM833U.append(", canManageRoles=");
        sbM833U.append(this.canManageRoles);
        sbM833U.append(", canManageBans=");
        sbM833U.append(this.canManageBans);
        sbM833U.append(", canManageNicknames=");
        sbM833U.append(this.canManageNicknames);
        sbM833U.append(", canManageEmojisAndStickers=");
        sbM833U.append(this.canManageEmojisAndStickers);
        sbM833U.append(", canViewAuditLogs=");
        sbM833U.append(this.canViewAuditLogs);
        sbM833U.append(", canManageEvents=");
        sbM833U.append(this.canManageEvents);
        sbM833U.append(", isOwnerWithRequiredMFALevel=");
        return outline.m827O(sbM833U, this.isOwnerWithRequiredMFALevel, ")");
    }
}

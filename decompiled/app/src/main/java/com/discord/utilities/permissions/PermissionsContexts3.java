package com.discord.utilities.permissions;

import b.d.b.a.outline;
import com.discord.api.permission.Permission;
import com.discord.api.role.GuildRole;
import com.discord.models.guild.Guild;
import com.discord.models.user.MeUser;
import com.discord.models.user.User;
import com.discord.utilities.guilds.RoleUtils;
import d0.z.d.Intrinsics3;
import java.util.Collection;
import java.util.Map;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: PermissionsContexts.kt */
/* renamed from: com.discord.utilities.permissions.ManageUserContext, reason: use source file name */
/* loaded from: classes2.dex */
public final /* data */ class PermissionsContexts3 {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final boolean canBan;
    private final boolean canChangeNickname;
    private final boolean canDeafen;
    private final boolean canDisableCommunication;
    private final boolean canKick;
    private final boolean canManageRoles;
    private final boolean canMove;
    private final boolean canMute;
    private final boolean canTransferOwnership;

    /* compiled from: PermissionsContexts.kt */
    /* renamed from: com.discord.utilities.permissions.ManageUserContext$Companion, reason: from kotlin metadata */
    public static final class Companion {
        private Companion() {
        }

        public final PermissionsContexts3 from(Guild guild, MeUser actingUser, User targetUser, Collection<Long> actingUserRoles, Collection<Long> userRoles, Long myPermissions, Map<Long, GuildRole> guildRoles) {
            Intrinsics3.checkNotNullParameter(guild, "guild");
            Intrinsics3.checkNotNullParameter(actingUser, "actingUser");
            Intrinsics3.checkNotNullParameter(targetUser, "targetUser");
            Intrinsics3.checkNotNullParameter(actingUserRoles, "actingUserRoles");
            Intrinsics3.checkNotNullParameter(userRoles, "userRoles");
            Intrinsics3.checkNotNullParameter(guildRoles, "guildRoles");
            long id2 = targetUser.getId();
            long id3 = actingUser.getId();
            boolean z2 = id3 == id2;
            boolean z3 = id3 == guild.getOwnerId();
            boolean z4 = z3 || (!((id2 > guild.getOwnerId() ? 1 : (id2 == guild.getOwnerId() ? 0 : -1)) == 0) && RoleUtils.rankIsHigher(RoleUtils.getHighestRole(guildRoles, actingUserRoles), RoleUtils.getHighestRole(guildRoles, userRoles)));
            int mfaLevel = guild.getMfaLevel();
            boolean mfaEnabled = actingUser.getMfaEnabled();
            boolean z5 = z3 || PermissionUtils.canAndIsElevated(8L, myPermissions, mfaEnabled, mfaLevel);
            boolean z6 = (z2 || z4) && (z5 || PermissionUtils.canAndIsElevated(Permission.MANAGE_ROLES, myPermissions, mfaEnabled, mfaLevel));
            boolean z7 = !z2 && z4 && (z5 || PermissionUtils.canAndIsElevated(2L, myPermissions, mfaEnabled, mfaLevel));
            boolean z8 = !z2 && z4 && (z5 || PermissionUtils.canAndIsElevated(4L, myPermissions, mfaEnabled, mfaLevel));
            boolean z9 = !z2 && z4 && (z5 || PermissionUtils.canAndIsElevated(Permission.MODERATE_MEMBERS, myPermissions, mfaEnabled, mfaLevel));
            return new PermissionsContexts3(z6, z7, z8, z5 || PermissionUtils.can(Permission.MUTE_MEMBERS, myPermissions), z5 || PermissionUtils.can(Permission.DEAFEN_MEMBERS, myPermissions), z5 || PermissionUtils.can(Permission.MOVE_MEMBERS, myPermissions), !z2 ? !(z4 && (z5 || PermissionUtils.canAndIsElevated(Permission.MANAGE_NICKNAMES, myPermissions, mfaEnabled, mfaLevel))) : !(z5 || PermissionUtils.can(Permission.CHANGE_NICKNAME, myPermissions)), z9, !z2 && z3);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public PermissionsContexts3(boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, boolean z8, boolean z9, boolean z10) {
        this.canManageRoles = z2;
        this.canKick = z3;
        this.canBan = z4;
        this.canMute = z5;
        this.canDeafen = z6;
        this.canMove = z7;
        this.canChangeNickname = z8;
        this.canDisableCommunication = z9;
        this.canTransferOwnership = z10;
    }

    /* renamed from: component9, reason: from getter */
    private final boolean getCanTransferOwnership() {
        return this.canTransferOwnership;
    }

    public static /* synthetic */ PermissionsContexts3 copy$default(PermissionsContexts3 permissionsContexts3, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, boolean z8, boolean z9, boolean z10, int i, Object obj) {
        return permissionsContexts3.copy((i & 1) != 0 ? permissionsContexts3.canManageRoles : z2, (i & 2) != 0 ? permissionsContexts3.canKick : z3, (i & 4) != 0 ? permissionsContexts3.canBan : z4, (i & 8) != 0 ? permissionsContexts3.canMute : z5, (i & 16) != 0 ? permissionsContexts3.canDeafen : z6, (i & 32) != 0 ? permissionsContexts3.canMove : z7, (i & 64) != 0 ? permissionsContexts3.canChangeNickname : z8, (i & 128) != 0 ? permissionsContexts3.canDisableCommunication : z9, (i & 256) != 0 ? permissionsContexts3.canTransferOwnership : z10);
    }

    public static final PermissionsContexts3 from(Guild guild, MeUser meUser, User user, Collection<Long> collection, Collection<Long> collection2, Long l, Map<Long, GuildRole> map) {
        return INSTANCE.from(guild, meUser, user, collection, collection2, l, map);
    }

    public final boolean canManage() {
        return this.canManageRoles || this.canKick || this.canBan || this.canMute || this.canDeafen || this.canMove || this.canChangeNickname || this.canTransferOwnership;
    }

    /* renamed from: component1, reason: from getter */
    public final boolean getCanManageRoles() {
        return this.canManageRoles;
    }

    /* renamed from: component2, reason: from getter */
    public final boolean getCanKick() {
        return this.canKick;
    }

    /* renamed from: component3, reason: from getter */
    public final boolean getCanBan() {
        return this.canBan;
    }

    /* renamed from: component4, reason: from getter */
    public final boolean getCanMute() {
        return this.canMute;
    }

    /* renamed from: component5, reason: from getter */
    public final boolean getCanDeafen() {
        return this.canDeafen;
    }

    /* renamed from: component6, reason: from getter */
    public final boolean getCanMove() {
        return this.canMove;
    }

    /* renamed from: component7, reason: from getter */
    public final boolean getCanChangeNickname() {
        return this.canChangeNickname;
    }

    /* renamed from: component8, reason: from getter */
    public final boolean getCanDisableCommunication() {
        return this.canDisableCommunication;
    }

    public final PermissionsContexts3 copy(boolean canManageRoles, boolean canKick, boolean canBan, boolean canMute, boolean canDeafen, boolean canMove, boolean canChangeNickname, boolean canDisableCommunication, boolean canTransferOwnership) {
        return new PermissionsContexts3(canManageRoles, canKick, canBan, canMute, canDeafen, canMove, canChangeNickname, canDisableCommunication, canTransferOwnership);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PermissionsContexts3)) {
            return false;
        }
        PermissionsContexts3 permissionsContexts3 = (PermissionsContexts3) other;
        return this.canManageRoles == permissionsContexts3.canManageRoles && this.canKick == permissionsContexts3.canKick && this.canBan == permissionsContexts3.canBan && this.canMute == permissionsContexts3.canMute && this.canDeafen == permissionsContexts3.canDeafen && this.canMove == permissionsContexts3.canMove && this.canChangeNickname == permissionsContexts3.canChangeNickname && this.canDisableCommunication == permissionsContexts3.canDisableCommunication && this.canTransferOwnership == permissionsContexts3.canTransferOwnership;
    }

    public final boolean getCanBan() {
        return this.canBan;
    }

    public final boolean getCanChangeNickname() {
        return this.canChangeNickname;
    }

    public final boolean getCanDeafen() {
        return this.canDeafen;
    }

    public final boolean getCanDisableCommunication() {
        return this.canDisableCommunication;
    }

    public final boolean getCanKick() {
        return this.canKick;
    }

    public final boolean getCanManageRoles() {
        return this.canManageRoles;
    }

    public final boolean getCanMove() {
        return this.canMove;
    }

    public final boolean getCanMute() {
        return this.canMute;
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
        boolean z2 = this.canManageRoles;
        ?? r0 = z2;
        if (z2) {
            r0 = 1;
        }
        int i = r0 * 31;
        ?? r2 = this.canKick;
        int i2 = r2;
        if (r2 != 0) {
            i2 = 1;
        }
        int i3 = (i + i2) * 31;
        ?? r22 = this.canBan;
        int i4 = r22;
        if (r22 != 0) {
            i4 = 1;
        }
        int i5 = (i3 + i4) * 31;
        ?? r23 = this.canMute;
        int i6 = r23;
        if (r23 != 0) {
            i6 = 1;
        }
        int i7 = (i5 + i6) * 31;
        ?? r24 = this.canDeafen;
        int i8 = r24;
        if (r24 != 0) {
            i8 = 1;
        }
        int i9 = (i7 + i8) * 31;
        ?? r25 = this.canMove;
        int i10 = r25;
        if (r25 != 0) {
            i10 = 1;
        }
        int i11 = (i9 + i10) * 31;
        ?? r26 = this.canChangeNickname;
        int i12 = r26;
        if (r26 != 0) {
            i12 = 1;
        }
        int i13 = (i11 + i12) * 31;
        ?? r27 = this.canDisableCommunication;
        int i14 = r27;
        if (r27 != 0) {
            i14 = 1;
        }
        int i15 = (i13 + i14) * 31;
        boolean z3 = this.canTransferOwnership;
        return i15 + (z3 ? 1 : z3 ? 1 : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("ManageUserContext(canManageRoles=");
        sbU.append(this.canManageRoles);
        sbU.append(", canKick=");
        sbU.append(this.canKick);
        sbU.append(", canBan=");
        sbU.append(this.canBan);
        sbU.append(", canMute=");
        sbU.append(this.canMute);
        sbU.append(", canDeafen=");
        sbU.append(this.canDeafen);
        sbU.append(", canMove=");
        sbU.append(this.canMove);
        sbU.append(", canChangeNickname=");
        sbU.append(this.canChangeNickname);
        sbU.append(", canDisableCommunication=");
        sbU.append(this.canDisableCommunication);
        sbU.append(", canTransferOwnership=");
        return outline.O(sbU, this.canTransferOwnership, ")");
    }
}

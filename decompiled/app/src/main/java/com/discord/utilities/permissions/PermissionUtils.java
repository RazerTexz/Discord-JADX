package com.discord.utilities.permissions;

import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.api.permission.Permission;
import com.discord.api.permission.PermissionOverwrite;
import com.discord.api.role.GuildRole;
import com.discord.api.stageinstance.StageInstance;
import com.discord.api.stageinstance.StageInstancePrivacyLevel;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.member.GuildMember;
import com.discord.stores.StoreSlowMode;
import com.discord.utilities.PermissionOverwriteUtils;
import com.discord.utilities.guildmember.GuildMemberUtils;
import com.discord.widgets.chat.list.NewThreadsPermissionsFeatureFlag;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p580t.Collections2;
import p507d0.p580t.Maps6;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: compiled from: PermissionUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class PermissionUtils {
    public static final PermissionUtils INSTANCE = new PermissionUtils();

    private PermissionUtils() {
    }

    private final long applyEveryone(long guildId, Map<Long, GuildRole> guildRoles) {
        GuildRole guildRole = guildRoles != null ? guildRoles.get(Long.valueOf(guildId)) : null;
        return guildRole != null ? guildRole.getPermissions() : Permission.DEFAULT;
    }

    private final long applyEveryoneOverwrites(long guildId, Collection<PermissionOverwrite> overwrites, long permissions) {
        Object next;
        Iterator<T> it = overwrites.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (((PermissionOverwrite) next).m8131e() == guildId) {
                break;
            }
        }
        PermissionOverwrite permissionOverwrite = (PermissionOverwrite) next;
        return permissionOverwrite != null ? ((permissionOverwrite.getDeny() & permissions) ^ permissions) | permissionOverwrite.getAllow() : permissions;
    }

    private final long applyRoleOverwrites(GuildMember member, Collection<PermissionOverwrite> overwrites, long permissions, long userId) {
        long j;
        Object next;
        Object obj = null;
        long allow = 0;
        if (member != null) {
            Iterator<Long> it = member.getRoles().iterator();
            long deny = 0;
            while (it.hasNext()) {
                long jLongValue = it.next().longValue();
                Iterator<T> it2 = overwrites.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        next = null;
                        break;
                    }
                    next = it2.next();
                    if (((PermissionOverwrite) next).m8131e() == jLongValue) {
                        break;
                    }
                }
                PermissionOverwrite permissionOverwrite = (PermissionOverwrite) next;
                if (permissionOverwrite != null) {
                    allow |= permissionOverwrite.getAllow();
                    deny |= permissionOverwrite.getDeny();
                }
            }
            long j2 = allow;
            allow = deny;
            j = j2;
        } else {
            j = 0;
        }
        long j3 = (permissions ^ (permissions & allow)) | j;
        Iterator<T> it3 = overwrites.iterator();
        while (true) {
            if (!it3.hasNext()) {
                break;
            }
            Object next2 = it3.next();
            if (((PermissionOverwrite) next2).m8131e() == userId) {
                obj = next2;
                break;
            }
        }
        PermissionOverwrite permissionOverwrite2 = (PermissionOverwrite) obj;
        return permissionOverwrite2 != null ? ((permissionOverwrite2.getDeny() & j3) ^ j3) | permissionOverwrite2.getAllow() : j3;
    }

    private final long applyRoles(GuildMember member, Map<Long, GuildRole> guildRoles, long permissions) {
        if (member != null) {
            Iterator<Long> it = member.getRoles().iterator();
            while (it.hasNext()) {
                GuildRole guildRole = guildRoles != null ? guildRoles.get(Long.valueOf(it.next().longValue())) : null;
                if (guildRole != null) {
                    permissions |= guildRole.getPermissions();
                }
            }
        }
        return permissions;
    }

    public static final boolean can(long permission, Long computedPermissions) {
        return ((computedPermissions != null ? computedPermissions.longValue() : 0L) & permission) == permission;
    }

    public static final boolean canAndIsElevated(long permission, Long computedPermissions, boolean userMfaEnabled, int guildMfaLevel) {
        return can(permission, computedPermissions) && isElevated(permission, userMfaEnabled, guildMfaLevel);
    }

    public static final boolean canEveryone(long permission, Channel channel, Channel parentChannel, Map<Long, GuildRole> roles) {
        Intrinsics3.checkNotNullParameter(channel, "channel");
        Intrinsics3.checkNotNullParameter(roles, "roles");
        if (ChannelUtils.m7673H(channel)) {
            if (parentChannel == null || ChannelUtils.m7668C(channel)) {
                return false;
            }
            return canEveryone(permission, parentChannel, null, roles);
        }
        GuildRole guildRole = (GuildRole) outline.m843c(channel, roles);
        if (guildRole != null && (guildRole.getPermissions() & permission) != permission) {
            return false;
        }
        List<PermissionOverwrite> listM7655v = channel.m7655v();
        if (listM7655v == null) {
            return true;
        }
        Iterator<PermissionOverwrite> it = listM7655v.iterator();
        while (it.hasNext()) {
            if (PermissionOverwriteUtils.denies(it.next(), permission)) {
                return false;
            }
        }
        return true;
    }

    public static /* synthetic */ boolean canEveryone$default(long j, Channel channel, Channel channel2, Map map, int i, Object obj) {
        if ((i & 4) != 0) {
            channel2 = null;
        }
        return canEveryone(j, channel, channel2, map);
    }

    public static final boolean canManageGuildMembers(boolean isOwner, boolean userMfaEnabled, int guildMfaLevel, Long permissions) {
        return isOwner || canAndIsElevated(8L, permissions, userMfaEnabled, guildMfaLevel) || canAndIsElevated(2L, permissions, userMfaEnabled, guildMfaLevel) || canAndIsElevated(4L, permissions, userMfaEnabled, guildMfaLevel) || canAndIsElevated(Permission.MANAGE_ROLES, permissions, userMfaEnabled, guildMfaLevel) || can(Permission.MANAGE_NICKNAMES, permissions);
    }

    public static final long computeNonThreadPermissions(long userId, long guildId, long guildOwnerId, GuildMember member, Map<Long, GuildRole> guildRoles, Collection<PermissionOverwrite> permissionOverwrites) {
        if (guildOwnerId == userId) {
            return Permission.ALL;
        }
        PermissionUtils permissionUtils = INSTANCE;
        long jApplyRoles = permissionUtils.applyRoles(member, guildRoles, permissionUtils.applyEveryone(guildId, guildRoles));
        return (jApplyRoles & 8) == 8 ? Permission.ALL : (permissionOverwrites == null || !(permissionOverwrites.isEmpty() ^ true)) ? jApplyRoles : permissionUtils.applyRoleOverwrites(member, permissionOverwrites, permissionUtils.applyEveryoneOverwrites(guildId, permissionOverwrites, jApplyRoles), userId);
    }

    public static final long computePermissions(long userId, Channel channel, Channel parentChannel, long guildOwnerId, GuildMember member, Map<Long, GuildRole> guildRoles, Map<Long, StageInstance> stageInstances, boolean hasJoinedThread) {
        long jComputeNonThreadPermissions;
        Intrinsics3.checkNotNullParameter(channel, "channel");
        if (ChannelUtils.m7673H(channel)) {
            jComputeNonThreadPermissions = parentChannel == null ? 0L : computeThreadPermissions(userId, channel, parentChannel, guildOwnerId, member, guildRoles, hasJoinedThread);
        } else {
            long guildId = channel.getGuildId();
            List<PermissionOverwrite> listM7655v = channel.m7655v();
            if (listM7655v == null) {
                listM7655v = Collections2.emptyList();
            }
            jComputeNonThreadPermissions = computeNonThreadPermissions(userId, guildId, guildOwnerId, member, guildRoles, listM7655v);
        }
        long j = 66560;
        if (!GuildMemberUtils.isLurker(member)) {
            return (member == null || !member.isCommunicationDisabled()) ? jComputeNonThreadPermissions : jComputeNonThreadPermissions & 66560;
        }
        Map<Long, StageInstance> mapEmptyMap = stageInstances != null ? stageInstances : Maps6.emptyMap();
        Intrinsics3.checkNotNullParameter(channel, "$this$computeLurkerPermissionsAllowList");
        Intrinsics3.checkNotNullParameter(mapEmptyMap, "stageInstances");
        if (ChannelUtils.m7669D(channel)) {
            StageInstance stageInstance = (StageInstance) outline.m845d(channel, mapEmptyMap);
            if ((stageInstance != null ? stageInstance.getPrivacyLevel() : null) == StageInstancePrivacyLevel.PUBLIC) {
                j = Permission.AllowList.LURKER_STAGE_CHANNEL;
            }
        }
        return jComputeNonThreadPermissions & j;
    }

    public static final long computeThreadPermissions(long userId, Channel thread, Channel parentChannel, long guildOwnerId, GuildMember member, Map<Long, GuildRole> guildRoles, boolean hasJoined) {
        Intrinsics3.checkNotNullParameter(thread, "thread");
        Intrinsics3.checkNotNullParameter(parentChannel, "parentChannel");
        long guildId = parentChannel.getGuildId();
        List<PermissionOverwrite> listM7655v = parentChannel.m7655v();
        if (listM7655v == null) {
            listM7655v = Collections2.emptyList();
        }
        long jComputeNonThreadPermissions = computeNonThreadPermissions(userId, guildId, guildOwnerId, member, guildRoles, listM7655v);
        if (NewThreadsPermissionsFeatureFlag.INSTANCE.getINSTANCE().isEnabled(thread.getGuildId())) {
            if (ChannelUtils.m7668C(thread) && !hasJoined) {
                can(Permission.MANAGE_THREADS, Long.valueOf(jComputeNonThreadPermissions));
            }
            return can(Permission.SEND_MESSAGES_IN_THREADS, Long.valueOf(jComputeNonThreadPermissions)) ? jComputeNonThreadPermissions | Permission.SEND_MESSAGES : (-2049) & jComputeNonThreadPermissions;
        }
        if (ChannelUtils.m7668C(thread)) {
            if (can(Permission.CREATE_PRIVATE_THREADS, Long.valueOf(jComputeNonThreadPermissions))) {
                jComputeNonThreadPermissions |= Permission.SEND_MESSAGES;
            }
            if (!hasJoined && !can(Permission.MANAGE_THREADS, Long.valueOf(jComputeNonThreadPermissions))) {
                return 0L;
            }
        } else if (can(Permission.CREATE_PUBLIC_THREADS, Long.valueOf(jComputeNonThreadPermissions))) {
            jComputeNonThreadPermissions |= Permission.SEND_MESSAGES;
        }
        return jComputeNonThreadPermissions;
    }

    public static final boolean hasAccess(Channel channel, Map<Long, Long> permissions) {
        Intrinsics3.checkNotNullParameter(channel, "channel");
        Intrinsics3.checkNotNullParameter(permissions, ModelAuditLogEntry.CHANGE_KEY_PERMISSIONS);
        return INSTANCE.hasAccess(channel, (Long) outline.m845d(channel, permissions));
    }

    public static final boolean isElevated(long permission, boolean userMfaEnabled, int guildMfaLevel) {
        if ((Permission.ELEVATED & permission) != permission) {
            return true;
        }
        return isElevated(userMfaEnabled, guildMfaLevel);
    }

    public static final boolean isElevated(boolean userMfaEnabled, int guildMfaLevel) {
        if (guildMfaLevel == 0) {
            return true;
        }
        return userMfaEnabled;
    }

    public final boolean canEveryoneRole(long permission, Channel channel, Map<Long, GuildRole> roles) {
        Intrinsics3.checkNotNullParameter(channel, "channel");
        Intrinsics3.checkNotNullParameter(roles, "roles");
        long guildId = channel.getGuildId();
        GuildRole guildRole = roles.get(Long.valueOf(guildId));
        return canRole(permission, guildRole, guildRole != null ? ChannelUtils.m7682f(channel, guildId) : null);
    }

    public final boolean canRole(long permission, GuildRole role, PermissionOverwrite roleOverwrite) {
        if (role == null) {
            return false;
        }
        long permissions = role.getPermissions();
        return ((((permissions & (roleOverwrite != null ? roleOverwrite.getDeny() : 0L)) ^ permissions) | (roleOverwrite != null ? roleOverwrite.getAllow() : 0L)) & permission) == permission;
    }

    public final long computeChannelOverwrite(long userId, long guildId, GuildMember member, Collection<PermissionOverwrite> permissionOverwrites) {
        if (permissionOverwrites == null || !(!permissionOverwrites.isEmpty())) {
            return 0L;
        }
        return applyRoleOverwrites(member, permissionOverwrites, applyEveryoneOverwrites(guildId, permissionOverwrites, 0L), userId);
    }

    public final boolean hasAccessWrite(Channel channel, Long computedPermission) {
        Intrinsics3.checkNotNullParameter(channel, "channel");
        return ChannelUtils.m7667B(channel) || can(3072L, computedPermission);
    }

    public final boolean hasBypassSlowmodePermissions(Long channelPermissions, StoreSlowMode.Type type) {
        Intrinsics3.checkNotNullParameter(type, "type");
        return Intrinsics3.areEqual(type, StoreSlowMode.Type.MessageSend.INSTANCE) ? can(16L, channelPermissions) || can(Permission.MANAGE_MESSAGES, channelPermissions) : can(Permission.MANAGE_THREADS, channelPermissions);
    }

    public final boolean hasAccess(Channel channel, Long computedPermission) {
        Intrinsics3.checkNotNullParameter(channel, "channel");
        if (ChannelUtils.m7667B(channel)) {
            return true;
        }
        long j = Permission.VIEW_CHANNEL;
        if (ChannelUtils.m7699w(channel)) {
            j = 1049600;
        }
        return can(j, computedPermission);
    }
}

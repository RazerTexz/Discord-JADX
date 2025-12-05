package com.discord.widgets.channels.permissions;

import androidx.core.app.NotificationCompat;
import com.discord.api.channel.Channel;
import com.discord.api.permission.Permission;
import com.discord.api.permission.PermissionOverwrite;
import com.discord.api.role.GuildRole;
import com.discord.models.guild.Guild;
import com.discord.models.member.GuildMember;
import com.discord.models.user.MeUser;
import com.discord.utilities.permissions.PermissionUtils;
import com.discord.widgets.channels.permissions.WidgetChannelSettingsEditPermissionsModel;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.jvm.functions.Function1;
import p507d0.p580t.Collections2;
import p507d0.p580t.MutableCollections;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;
import p658rx.functions.Func7;

/* compiled from: WidgetChannelSettingsEditPermissionsModel.kt */
/* renamed from: com.discord.widgets.channels.permissions.WidgetChannelSettingsEditPermissionsModel$Companion$getForRole$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetChannelSettingsEditPermissionsModel2<T1, T2, T3, T4, T5, T6, T7, R> implements Func7<Channel, MeUser, Guild, Long, Map<Long, ? extends GuildRole>, Map<Long, ? extends GuildMember>, Boolean, WidgetChannelSettingsEditPermissionsModel> {
    public final /* synthetic */ long $targetRoleId;

    /* compiled from: WidgetChannelSettingsEditPermissionsModel.kt */
    /* renamed from: com.discord.widgets.channels.permissions.WidgetChannelSettingsEditPermissionsModel$Companion$getForRole$1$1 */
    public static final class C75431 extends Lambda implements Function1<PermissionOverwrite, Boolean> {
        public C75431() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Boolean invoke(PermissionOverwrite permissionOverwrite) {
            return Boolean.valueOf(invoke2(permissionOverwrite));
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final boolean invoke2(PermissionOverwrite permissionOverwrite) {
            return permissionOverwrite.getId() == WidgetChannelSettingsEditPermissionsModel2.this.$targetRoleId;
        }
    }

    /* compiled from: WidgetChannelSettingsEditPermissionsModel.kt */
    /* renamed from: com.discord.widgets.channels.permissions.WidgetChannelSettingsEditPermissionsModel$Companion$getForRole$1$2 */
    public static final class C75442 extends Lambda implements Function1<PermissionOverwrite, Boolean> {
        public C75442() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Boolean invoke(PermissionOverwrite permissionOverwrite) {
            return Boolean.valueOf(invoke2(permissionOverwrite));
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final boolean invoke2(PermissionOverwrite permissionOverwrite) {
            return permissionOverwrite.getId() == WidgetChannelSettingsEditPermissionsModel2.this.$targetRoleId;
        }
    }

    public WidgetChannelSettingsEditPermissionsModel2(long j) {
        this.$targetRoleId = j;
    }

    @Override // p658rx.functions.Func7
    public /* bridge */ /* synthetic */ WidgetChannelSettingsEditPermissionsModel call(Channel channel, MeUser meUser, Guild guild, Long l, Map<Long, ? extends GuildRole> map, Map<Long, ? extends GuildMember> map2, Boolean bool) {
        return call2(channel, meUser, guild, l, (Map<Long, GuildRole>) map, (Map<Long, GuildMember>) map2, bool);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final WidgetChannelSettingsEditPermissionsModel call2(Channel channel, MeUser meUser, Guild guild, Long l, Map<Long, GuildRole> map, Map<Long, GuildMember> map2, Boolean bool) {
        GuildMember guildMember;
        List<Long> roles;
        GuildRole guildRole = map.get(Long.valueOf(this.$targetRoleId));
        if (channel != null && guild != null && guildRole != null && l != null) {
            WidgetChannelSettingsEditPermissionsModel.Companion companion = WidgetChannelSettingsEditPermissionsModel.INSTANCE;
            Intrinsics3.checkNotNullExpressionValue(meUser, "meUser");
            if (WidgetChannelSettingsEditPermissionsModel.Companion.access$isAbleToManagePerms(companion, guild, meUser, l.longValue())) {
                ArrayList arrayList = new ArrayList(channel.m7655v() != null ? channel.m7655v() : Collections2.emptyList());
                long j = this.$targetRoleId;
                PermissionOverwrite.Type type = PermissionOverwrite.Type.ROLE;
                PermissionOverwrite permissionOverwrite = new PermissionOverwrite(j, type, 0L, Permission.ALL);
                MutableCollections.removeAll((List) arrayList, (Function1) new C75431());
                arrayList.add(permissionOverwrite);
                PermissionOverwrite permissionOverwrite2 = new PermissionOverwrite(this.$targetRoleId, type, 0L, 0L);
                MutableCollections.removeAll((List) arrayList, (Function1) new C75442());
                arrayList.add(permissionOverwrite2);
                boolean z2 = false;
                boolean z3 = this.$targetRoleId == guild.getId();
                long jLongValue = l.longValue();
                long j2 = this.$targetRoleId;
                long jComputeNonThreadPermissions = PermissionUtils.computeNonThreadPermissions(meUser.getId(), guild.getId(), guild.getOwnerId(), map2.get(Long.valueOf(meUser.getId())), map, arrayList);
                long jComputeNonThreadPermissions2 = PermissionUtils.computeNonThreadPermissions(meUser.getId(), guild.getId(), guild.getOwnerId(), map2.get(Long.valueOf(meUser.getId())), map, arrayList);
                if (z3 || ((guildMember = map2.get(Long.valueOf(meUser.getId()))) != null && (roles = guildMember.getRoles()) != null && roles.contains(Long.valueOf(this.$targetRoleId)))) {
                    z2 = true;
                }
                Intrinsics3.checkNotNullExpressionValue(bool, "useNewThreadsPermissions");
                return new WidgetChannelSettingsEditPermissionsModel.ModelForRole(channel, jLongValue, guildRole, j2, jComputeNonThreadPermissions, jComputeNonThreadPermissions2, z2, z3, bool.booleanValue());
            }
        }
        return null;
    }
}

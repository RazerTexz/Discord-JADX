package com.discord.widgets.servers;

import androidx.core.app.NotificationCompat;
import com.discord.api.guild.GuildFeature;
import com.discord.api.role.GuildRole;
import com.discord.models.guild.Guild;
import com.discord.models.member.GuildMember;
import com.discord.models.user.MeUser;
import com.discord.stores.StoreStream;
import com.discord.utilities.guilds.RoleUtils;
import com.discord.utilities.permissions.PermissionUtils;
import com.discord.widgets.chat.list.NewThreadsPermissionsFeatureFlag;
import com.discord.widgets.guildcommunicationdisabled.start.GuildCommunicationDisabledGuildsFeatureFlag;
import com.discord.widgets.servers.WidgetServerSettingsEditRole;
import d0.z.d.m;
import j0.k.b;
import java.util.Map;
import rx.Observable;
import rx.functions.Func6;

/* compiled from: WidgetServerSettingsEditRole.kt */
/* loaded from: classes2.dex */
public final class WidgetServerSettingsEditRole$Model$Companion$get$1<T, R> implements b<MeUser, Observable<? extends WidgetServerSettingsEditRole.Model>> {
    public final /* synthetic */ long $guildId;
    public final /* synthetic */ long $roleId;

    /* compiled from: WidgetServerSettingsEditRole.kt */
    /* renamed from: com.discord.widgets.servers.WidgetServerSettingsEditRole$Model$Companion$get$1$1, reason: invalid class name */
    public static final class AnonymousClass1<T1, T2, T3, T4, T5, T6, R> implements Func6<Guild, Map<Long, ? extends GuildMember>, Map<Long, ? extends GuildRole>, Long, Boolean, Boolean, WidgetServerSettingsEditRole.Model> {
        public final /* synthetic */ MeUser $meUser;

        public AnonymousClass1(MeUser meUser) {
            this.$meUser = meUser;
        }

        @Override // rx.functions.Func6
        public /* bridge */ /* synthetic */ WidgetServerSettingsEditRole.Model call(Guild guild, Map<Long, ? extends GuildMember> map, Map<Long, ? extends GuildRole> map2, Long l, Boolean bool, Boolean bool2) {
            return call2(guild, (Map<Long, GuildMember>) map, (Map<Long, GuildRole>) map2, l, bool, bool2);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final WidgetServerSettingsEditRole.Model call2(Guild guild, Map<Long, GuildMember> map, Map<Long, GuildRole> map2, Long l, Boolean bool, Boolean bool2) {
            GuildMember guildMember = map.get(Long.valueOf(this.$meUser.getId()));
            GuildRole guildRole = map2 != null ? map2.get(Long.valueOf(WidgetServerSettingsEditRole$Model$Companion$get$1.this.$roleId)) : null;
            if (guildRole == null || guild == null || guildMember == null) {
                return null;
            }
            GuildRole highestRole = RoleUtils.getHighestRole(map2, guildMember);
            boolean z2 = guild.getOwnerId() == this.$meUser.getId();
            boolean zIsElevated = PermissionUtils.isElevated(this.$meUser.getMfaEnabled(), guild.getMfaLevel());
            WidgetServerSettingsEditRole.Model.Companion companion = WidgetServerSettingsEditRole.Model.INSTANCE;
            WidgetServerSettingsEditRole.Model.ManageStatus manageStatusAccess$computeManageStatus = WidgetServerSettingsEditRole.Model.Companion.access$computeManageStatus(companion, z2, zIsElevated, l, highestRole, guildRole);
            long jAccess$computeMyOtherPermissions = WidgetServerSettingsEditRole.Model.Companion.access$computeMyOtherPermissions(companion, guildMember.getRoles(), map2, WidgetServerSettingsEditRole$Model$Companion$get$1.this.$roleId, guild.getId());
            boolean zContains = guild.getFeatures().contains(GuildFeature.COMMUNITY);
            long id2 = guild.getId();
            m.checkNotNullExpressionValue(bool, "useNewThreadPermissions");
            boolean zBooleanValue = bool.booleanValue();
            m.checkNotNullExpressionValue(bool2, "hasDisabledGuildCommunicationFeature");
            return new WidgetServerSettingsEditRole.Model(z2, id2, guildRole, manageStatusAccess$computeManageStatus, l, jAccess$computeMyOtherPermissions, zContains, zBooleanValue, bool2.booleanValue());
        }
    }

    public WidgetServerSettingsEditRole$Model$Companion$get$1(long j, long j2) {
        this.$guildId = j;
        this.$roleId = j2;
    }

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ Observable<? extends WidgetServerSettingsEditRole.Model> call(MeUser meUser) {
        return call2(meUser);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends WidgetServerSettingsEditRole.Model> call2(MeUser meUser) {
        m.checkNotNullParameter(meUser, "meUser");
        StoreStream.Companion companion = StoreStream.INSTANCE;
        return Observable.f(companion.getGuilds().observeGuild(this.$guildId), companion.getGuilds().observeComputed(this.$guildId, d0.t.m.listOf(Long.valueOf(meUser.getId()))), companion.getGuilds().observeRoles(this.$guildId), companion.getPermissions().observePermissionsForGuild(this.$guildId), NewThreadsPermissionsFeatureFlag.INSTANCE.getINSTANCE().observeEnabled(this.$guildId), GuildCommunicationDisabledGuildsFeatureFlag.INSTANCE.getINSTANCE().observeCanGuildAccessCommunicationDisabled(this.$guildId), new AnonymousClass1(meUser));
    }
}

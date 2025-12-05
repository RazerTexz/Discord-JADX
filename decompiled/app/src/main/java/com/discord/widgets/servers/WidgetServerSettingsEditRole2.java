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
import java.util.Map;
import p507d0.p580t.CollectionsJVM;
import p507d0.p592z.p594d.Intrinsics3;
import p637j0.p641k.Func1;
import p658rx.Observable;
import p658rx.functions.Func6;

/* compiled from: WidgetServerSettingsEditRole.kt */
/* renamed from: com.discord.widgets.servers.WidgetServerSettingsEditRole$Model$Companion$get$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetServerSettingsEditRole2<T, R> implements Func1<MeUser, Observable<? extends WidgetServerSettingsEditRole.Model>> {
    public final /* synthetic */ long $guildId;
    public final /* synthetic */ long $roleId;

    /* compiled from: WidgetServerSettingsEditRole.kt */
    /* renamed from: com.discord.widgets.servers.WidgetServerSettingsEditRole$Model$Companion$get$1$1 */
    public static final class C92341<T1, T2, T3, T4, T5, T6, R> implements Func6<Guild, Map<Long, ? extends GuildMember>, Map<Long, ? extends GuildRole>, Long, Boolean, Boolean, WidgetServerSettingsEditRole.Model> {
        public final /* synthetic */ MeUser $meUser;

        public C92341(MeUser meUser) {
            this.$meUser = meUser;
        }

        @Override // p658rx.functions.Func6
        public /* bridge */ /* synthetic */ WidgetServerSettingsEditRole.Model call(Guild guild, Map<Long, ? extends GuildMember> map, Map<Long, ? extends GuildRole> map2, Long l, Boolean bool, Boolean bool2) {
            return call2(guild, (Map<Long, GuildMember>) map, (Map<Long, GuildRole>) map2, l, bool, bool2);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final WidgetServerSettingsEditRole.Model call2(Guild guild, Map<Long, GuildMember> map, Map<Long, GuildRole> map2, Long l, Boolean bool, Boolean bool2) {
            GuildMember guildMember = map.get(Long.valueOf(this.$meUser.getId()));
            GuildRole guildRole = map2 != null ? map2.get(Long.valueOf(WidgetServerSettingsEditRole2.this.$roleId)) : null;
            if (guildRole == null || guild == null || guildMember == null) {
                return null;
            }
            GuildRole highestRole = RoleUtils.getHighestRole(map2, guildMember);
            boolean z2 = guild.getOwnerId() == this.$meUser.getId();
            boolean zIsElevated = PermissionUtils.isElevated(this.$meUser.getMfaEnabled(), guild.getMfaLevel());
            WidgetServerSettingsEditRole.Model.Companion companion = WidgetServerSettingsEditRole.Model.INSTANCE;
            WidgetServerSettingsEditRole.Model.ManageStatus manageStatusAccess$computeManageStatus = WidgetServerSettingsEditRole.Model.Companion.access$computeManageStatus(companion, z2, zIsElevated, l, highestRole, guildRole);
            long jAccess$computeMyOtherPermissions = WidgetServerSettingsEditRole.Model.Companion.access$computeMyOtherPermissions(companion, guildMember.getRoles(), map2, WidgetServerSettingsEditRole2.this.$roleId, guild.getId());
            boolean zContains = guild.getFeatures().contains(GuildFeature.COMMUNITY);
            long id2 = guild.getId();
            Intrinsics3.checkNotNullExpressionValue(bool, "useNewThreadPermissions");
            boolean zBooleanValue = bool.booleanValue();
            Intrinsics3.checkNotNullExpressionValue(bool2, "hasDisabledGuildCommunicationFeature");
            return new WidgetServerSettingsEditRole.Model(z2, id2, guildRole, manageStatusAccess$computeManageStatus, l, jAccess$computeMyOtherPermissions, zContains, zBooleanValue, bool2.booleanValue());
        }
    }

    public WidgetServerSettingsEditRole2(long j, long j2) {
        this.$guildId = j;
        this.$roleId = j2;
    }

    @Override // p637j0.p641k.Func1
    public /* bridge */ /* synthetic */ Observable<? extends WidgetServerSettingsEditRole.Model> call(MeUser meUser) {
        return call2(meUser);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends WidgetServerSettingsEditRole.Model> call2(MeUser meUser) {
        Intrinsics3.checkNotNullParameter(meUser, "meUser");
        StoreStream.Companion companion = StoreStream.INSTANCE;
        return Observable.m11071f(companion.getGuilds().observeGuild(this.$guildId), companion.getGuilds().observeComputed(this.$guildId, CollectionsJVM.listOf(Long.valueOf(meUser.getId()))), companion.getGuilds().observeRoles(this.$guildId), companion.getPermissions().observePermissionsForGuild(this.$guildId), NewThreadsPermissionsFeatureFlag.INSTANCE.getINSTANCE().observeEnabled(this.$guildId), GuildCommunicationDisabledGuildsFeatureFlag.INSTANCE.getINSTANCE().observeCanGuildAccessCommunicationDisabled(this.$guildId), new C92341(meUser));
    }
}

package com.discord.widgets.servers;

import androidx.core.app.NotificationCompat;
import com.discord.api.permission.Permission;
import com.discord.api.role.GuildRole;
import com.discord.models.guild.Guild;
import com.discord.models.member.GuildMember;
import com.discord.models.user.MeUser;
import com.discord.stores.StoreStream;
import com.discord.utilities.guilds.RoleUtils;
import com.discord.utilities.permissions.PermissionUtils;
import com.discord.widgets.servers.WidgetServerSettingsRoles;
import com.discord.widgets.servers.WidgetServerSettingsRolesAdapter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import p507d0.p580t.CollectionsJVM;
import p637j0.p641k.Func1;
import p658rx.Observable;
import p658rx.functions.Func4;

/* JADX INFO: renamed from: com.discord.widgets.servers.WidgetServerSettingsRoles$Model$Companion$get$1, reason: use source file name */
/* JADX INFO: compiled from: WidgetServerSettingsRoles.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsRoles2<T, R> implements Func1<MeUser, Observable<? extends WidgetServerSettingsRoles.Model>> {
    public final /* synthetic */ long $guildId;

    /* JADX INFO: renamed from: com.discord.widgets.servers.WidgetServerSettingsRoles$Model$Companion$get$1$1 */
    /* JADX INFO: compiled from: WidgetServerSettingsRoles.kt */
    public static final class C92981<T, R> implements Func1<Map<Long, ? extends GuildMember>, GuildMember> {
        public final /* synthetic */ MeUser $meUser;

        public C92981(MeUser meUser) {
            this.$meUser = meUser;
        }

        @Override // p637j0.p641k.Func1
        public /* bridge */ /* synthetic */ GuildMember call(Map<Long, ? extends GuildMember> map) {
            return call2((Map<Long, GuildMember>) map);
        }

        /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
        public final GuildMember call2(Map<Long, GuildMember> map) {
            return map.get(Long.valueOf(this.$meUser.getId()));
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.servers.WidgetServerSettingsRoles$Model$Companion$get$1$2 */
    /* JADX INFO: compiled from: WidgetServerSettingsRoles.kt */
    public static final class C92992<T1, T2, T3, T4, R> implements Func4<Guild, GuildMember, Long, Map<Long, ? extends GuildRole>, WidgetServerSettingsRoles.Model> {
        public final /* synthetic */ MeUser $meUser;

        public C92992(MeUser meUser) {
            this.$meUser = meUser;
        }

        @Override // p658rx.functions.Func4
        public /* bridge */ /* synthetic */ WidgetServerSettingsRoles.Model call(Guild guild, GuildMember guildMember, Long l, Map<Long, ? extends GuildRole> map) {
            return call2(guild, guildMember, l, (Map<Long, GuildRole>) map);
        }

        /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
        public final WidgetServerSettingsRoles.Model call2(Guild guild, GuildMember guildMember, Long l, Map<Long, GuildRole> map) {
            if (guild == null || guildMember == null || l == null || map == null) {
                return null;
            }
            boolean zCan = PermissionUtils.can(Permission.MANAGE_ROLES, l);
            boolean zIsElevated = PermissionUtils.isElevated(this.$meUser.getMfaEnabled(), guild.getMfaLevel());
            GuildRole highestRole = RoleUtils.getHighestRole(map, guildMember);
            ArrayList<GuildRole> arrayList = new ArrayList(map.values());
            Collections.sort(arrayList, RoleUtils.getROLE_COMPARATOR());
            ArrayList arrayList2 = new ArrayList(arrayList.size() + 1);
            arrayList2.add(new WidgetServerSettingsRolesAdapter.HelpItem(WidgetServerSettingsRoles2.this.$guildId));
            for (GuildRole guildRole : arrayList) {
                arrayList2.add(new WidgetServerSettingsRolesAdapter.RoleItem(guildRole, WidgetServerSettingsRoles2.this.$guildId == guildRole.getId(), (guild.getOwnerId() == this.$meUser.getId() || RoleUtils.rankIsHigher(highestRole, guildRole)) ? false : true, zCan, zIsElevated, WidgetServerSettingsRoles2.this.$guildId));
            }
            return new WidgetServerSettingsRoles.Model(WidgetServerSettingsRoles2.this.$guildId, guild.getName(), zCan, zIsElevated, arrayList2);
        }
    }

    public WidgetServerSettingsRoles2(long j) {
        this.$guildId = j;
    }

    @Override // p637j0.p641k.Func1
    public /* bridge */ /* synthetic */ Observable<? extends WidgetServerSettingsRoles.Model> call(MeUser meUser) {
        return call2(meUser);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends WidgetServerSettingsRoles.Model> call2(MeUser meUser) {
        StoreStream.Companion companion = StoreStream.INSTANCE;
        return Observable.m11073h(companion.getGuilds().observeGuild(this.$guildId), companion.getGuilds().observeComputed(this.$guildId, CollectionsJVM.listOf(Long.valueOf(meUser.getId()))).m11083G(new C92981(meUser)), companion.getPermissions().observePermissionsForGuild(this.$guildId), companion.getGuilds().observeRoles(this.$guildId), new C92992(meUser));
    }
}

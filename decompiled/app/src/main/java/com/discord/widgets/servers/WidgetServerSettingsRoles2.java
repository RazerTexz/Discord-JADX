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
import d0.t.CollectionsJVM;
import j0.k.Func1;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import rx.Observable;
import rx.functions.Func4;

/* compiled from: WidgetServerSettingsRoles.kt */
/* renamed from: com.discord.widgets.servers.WidgetServerSettingsRoles$Model$Companion$get$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetServerSettingsRoles2<T, R> implements Func1<MeUser, Observable<? extends WidgetServerSettingsRoles.Model>> {
    public final /* synthetic */ long $guildId;

    /* compiled from: WidgetServerSettingsRoles.kt */
    /* renamed from: com.discord.widgets.servers.WidgetServerSettingsRoles$Model$Companion$get$1$1, reason: invalid class name */
    public static final class AnonymousClass1<T, R> implements Func1<Map<Long, ? extends GuildMember>, GuildMember> {
        public final /* synthetic */ MeUser $meUser;

        public AnonymousClass1(MeUser meUser) {
            this.$meUser = meUser;
        }

        @Override // j0.k.Func1
        public /* bridge */ /* synthetic */ GuildMember call(Map<Long, ? extends GuildMember> map) {
            return call2((Map<Long, GuildMember>) map);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final GuildMember call2(Map<Long, GuildMember> map) {
            return map.get(Long.valueOf(this.$meUser.getId()));
        }
    }

    /* compiled from: WidgetServerSettingsRoles.kt */
    /* renamed from: com.discord.widgets.servers.WidgetServerSettingsRoles$Model$Companion$get$1$2, reason: invalid class name */
    public static final class AnonymousClass2<T1, T2, T3, T4, R> implements Func4<Guild, GuildMember, Long, Map<Long, ? extends GuildRole>, WidgetServerSettingsRoles.Model> {
        public final /* synthetic */ MeUser $meUser;

        public AnonymousClass2(MeUser meUser) {
            this.$meUser = meUser;
        }

        @Override // rx.functions.Func4
        public /* bridge */ /* synthetic */ WidgetServerSettingsRoles.Model call(Guild guild, GuildMember guildMember, Long l, Map<Long, ? extends GuildRole> map) {
            return call2(guild, guildMember, l, (Map<Long, GuildRole>) map);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
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

    @Override // j0.k.Func1
    public /* bridge */ /* synthetic */ Observable<? extends WidgetServerSettingsRoles.Model> call(MeUser meUser) {
        return call2(meUser);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends WidgetServerSettingsRoles.Model> call2(MeUser meUser) {
        StoreStream.Companion companion = StoreStream.INSTANCE;
        return Observable.h(companion.getGuilds().observeGuild(this.$guildId), companion.getGuilds().observeComputed(this.$guildId, CollectionsJVM.listOf(Long.valueOf(meUser.getId()))).G(new AnonymousClass1(meUser)), companion.getPermissions().observePermissionsForGuild(this.$guildId), companion.getGuilds().observeRoles(this.$guildId), new AnonymousClass2(meUser));
    }
}

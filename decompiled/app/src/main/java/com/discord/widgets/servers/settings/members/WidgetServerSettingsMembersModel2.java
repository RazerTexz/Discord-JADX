package com.discord.widgets.servers.settings.members;

import androidx.core.app.NotificationCompat;
import com.discord.api.role.GuildRole;
import com.discord.models.guild.Guild;
import com.discord.models.member.GuildMember;
import com.discord.models.user.MeUser;
import com.discord.models.user.User;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUser;
import com.discord.utilities.guilds.RoleUtils;
import com.discord.utilities.permissions.PermissionUtils;
import com.discord.utilities.permissions.PermissionsContexts3;
import com.discord.widgets.servers.settings.members.WidgetServerSettingsMembersModel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;
import java.util.concurrent.TimeUnit;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p579g0.StringNumberConversions;
import p507d0.p579g0.Strings4;
import p507d0.p592z.p594d.Intrinsics3;
import p637j0.p641k.Func1;
import p658rx.Observable;
import p658rx.functions.Func7;

/* compiled from: WidgetServerSettingsMembersModel.kt */
/* renamed from: com.discord.widgets.servers.settings.members.WidgetServerSettingsMembersModel$Companion$get$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetServerSettingsMembersModel2<T, R> implements Func1<Map<Long, ? extends GuildMember>, Observable<? extends WidgetServerSettingsMembersModel>> {
    public final /* synthetic */ Observable $filterPublisher;
    public final /* synthetic */ long $guildId;
    public final /* synthetic */ Observable $roleFilterPublisher;

    /* compiled from: WidgetServerSettingsMembersModel.kt */
    /* renamed from: com.discord.widgets.servers.settings.members.WidgetServerSettingsMembersModel$Companion$get$1$1 */
    public static final class C95951<T1, T2, T3, T4, T5, T6, T7, R> implements Func7<Guild, Long, MeUser, Map<Long, ? extends User>, Map<Long, ? extends GuildRole>, String, Long, WidgetServerSettingsMembersModel> {
        public final /* synthetic */ Map $members;

        public C95951(Map map) {
            this.$members = map;
        }

        @Override // p658rx.functions.Func7
        public /* bridge */ /* synthetic */ WidgetServerSettingsMembersModel call(Guild guild, Long l, MeUser meUser, Map<Long, ? extends User> map, Map<Long, ? extends GuildRole> map2, String str, Long l2) {
            return call2(guild, l, meUser, map, (Map<Long, GuildRole>) map2, str, l2);
        }

        /* JADX WARN: Removed duplicated region for block: B:37:0x0108  */
        /* renamed from: call, reason: avoid collision after fix types in other method */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final WidgetServerSettingsMembersModel call2(Guild guild, Long l, MeUser meUser, Map<Long, ? extends User> map, Map<Long, GuildRole> map2, String str, Long l2) {
            TreeSet treeSet;
            String nick;
            C95951<T1, T2, T3, T4, T5, T6, T7, R> c95951 = this;
            String str2 = str;
            Long l3 = l2;
            GuildMember guildMember = (GuildMember) c95951.$members.get(Long.valueOf(meUser.getId()));
            if (guild == null || l == null || guildMember == null) {
                return null;
            }
            TreeSet treeSet2 = new TreeSet(WidgetServerSettingsMembersModel.Companion.access$sortMembersComparator(WidgetServerSettingsMembersModel.INSTANCE));
            for (User user : map.values()) {
                GuildMember guildMember2 = (GuildMember) outline.m849f(user, c95951.$members);
                if (guildMember2 != null) {
                    long id2 = guild.getId();
                    if ((l3 != null && l2.longValue() == id2) || guildMember2.getRoles().contains(l3)) {
                        long id3 = user.getId();
                        Intrinsics3.checkNotNullExpressionValue(str2, "filter");
                        Long longOrNull = StringNumberConversions.toLongOrNull(str);
                        if ((longOrNull != null && id3 == longOrNull.longValue()) || Strings4.contains((CharSequence) user.getUsername(), (CharSequence) str2, true) || ((nick = guildMember2.getNick()) != null && Strings4.contains((CharSequence) nick, (CharSequence) str2, true))) {
                            PermissionsContexts3.Companion companion = PermissionsContexts3.INSTANCE;
                            Intrinsics3.checkNotNullExpressionValue(meUser, "me");
                            List<Long> roles = guildMember.getRoles();
                            List<Long> roles2 = guildMember2.getRoles();
                            Intrinsics3.checkNotNullExpressionValue(map2, "roles");
                            treeSet = treeSet2;
                            PermissionsContexts3 permissionsContexts3From = companion.from(guild, meUser, user, roles, roles2, l, map2);
                            String nickOrUsername = GuildMember.INSTANCE.getNickOrUsername(guildMember2, user);
                            List<Long> roles3 = guildMember2.getRoles();
                            ArrayList arrayList = new ArrayList();
                            Iterator<T> it = roles3.iterator();
                            while (it.hasNext()) {
                                GuildRole guildRole = map2.get(Long.valueOf(((Number) it.next()).longValue()));
                                if (guildRole != null) {
                                    arrayList.add(guildRole);
                                }
                            }
                            treeSet.add(new WidgetServerSettingsMembersModel.MemberItem(user, nickOrUsername, arrayList, permissionsContexts3From.canManage(), guildMember2));
                        } else {
                            treeSet = treeSet2;
                        }
                    }
                }
                c95951 = this;
                str2 = str;
                treeSet2 = treeSet;
                l3 = l2;
            }
            WidgetServerSettingsMembersModel.Companion companion2 = WidgetServerSettingsMembersModel.INSTANCE;
            Intrinsics3.checkNotNullExpressionValue(map2, "roles");
            Map mapAccess$sortRoles = WidgetServerSettingsMembersModel.Companion.access$sortRoles(companion2, map2);
            ArrayList arrayList2 = new ArrayList(treeSet2);
            GuildRole highestRole = RoleUtils.getHighestRole(map2, guildMember);
            Intrinsics3.checkNotNullExpressionValue(meUser, "me");
            return new WidgetServerSettingsMembersModel(guild, mapAccess$sortRoles, arrayList2, highestRole, meUser, guild.isOwner(meUser.getId()) || PermissionUtils.canAndIsElevated(2L, l, meUser.getMfaEnabled(), guild.getMfaLevel()), PermissionUtils.canManageGuildMembers(guild.isOwner(meUser.getId()), meUser.getMfaEnabled(), guild.getMfaLevel(), l));
        }
    }

    public WidgetServerSettingsMembersModel2(long j, Observable observable, Observable observable2) {
        this.$guildId = j;
        this.$filterPublisher = observable;
        this.$roleFilterPublisher = observable2;
    }

    @Override // p637j0.p641k.Func1
    public /* bridge */ /* synthetic */ Observable<? extends WidgetServerSettingsMembersModel> call(Map<Long, ? extends GuildMember> map) {
        return call2((Map<Long, GuildMember>) map);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends WidgetServerSettingsMembersModel> call2(Map<Long, GuildMember> map) {
        StoreStream.Companion companion = StoreStream.INSTANCE;
        return Observable.m11069e(companion.getGuilds().observeGuild(this.$guildId), companion.getPermissions().observePermissionsForGuild(this.$guildId), StoreUser.observeMe$default(companion.getUsers(), false, 1, null), companion.getUsers().observeUsers(map.keySet()), companion.getGuilds().observeRoles(this.$guildId), this.$filterPublisher.m11110p(300L, TimeUnit.MILLISECONDS), this.$roleFilterPublisher, new C95951(map));
    }
}

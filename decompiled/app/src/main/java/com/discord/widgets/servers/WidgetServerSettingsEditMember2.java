package com.discord.widgets.servers;

import androidx.core.app.NotificationCompat;
import com.discord.api.role.GuildRole;
import com.discord.models.guild.Guild;
import com.discord.models.member.GuildMember;
import com.discord.models.user.MeUser;
import com.discord.models.user.User;
import com.discord.utilities.guilds.RoleUtils;
import com.discord.utilities.permissions.PermissionsContexts3;
import com.discord.widgets.servers.WidgetServerSettingsEditMember;
import com.discord.widgets.servers.WidgetServerSettingsEditMemberRolesAdapter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import p507d0.p580t.Iterables2;
import p507d0.p592z.p594d.Intrinsics3;
import p658rx.functions.Func6;

/* compiled from: WidgetServerSettingsEditMember.kt */
/* renamed from: com.discord.widgets.servers.WidgetServerSettingsEditMember$Model$Companion$get$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetServerSettingsEditMember2<T1, T2, T3, T4, T5, T6, R> implements Func6<MeUser, User, Map<Long, ? extends GuildMember>, Guild, Map<Long, ? extends GuildRole>, Long, WidgetServerSettingsEditMember.Model> {
    public final /* synthetic */ long $guildId;
    public final /* synthetic */ long $userId;

    public WidgetServerSettingsEditMember2(long j, long j2) {
        this.$guildId = j;
        this.$userId = j2;
    }

    @Override // p658rx.functions.Func6
    public /* bridge */ /* synthetic */ WidgetServerSettingsEditMember.Model call(MeUser meUser, User user, Map<Long, ? extends GuildMember> map, Guild guild, Map<Long, ? extends GuildRole> map2, Long l) {
        return call2(meUser, user, (Map<Long, GuildMember>) map, guild, (Map<Long, GuildRole>) map2, l);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final WidgetServerSettingsEditMember.Model call2(MeUser meUser, User user, Map<Long, GuildMember> map, Guild guild, Map<Long, GuildRole> map2, Long l) {
        Intrinsics3.checkNotNullExpressionValue(map2, "guildRoles");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator<Map.Entry<Long, GuildRole>> it = map2.entrySet().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Map.Entry<Long, GuildRole> next = it.next();
            if (next.getKey().longValue() != this.$guildId) {
                linkedHashMap.put(next.getKey(), next.getValue());
            }
        }
        GuildMember guildMember = map.get(Long.valueOf(meUser.getId()));
        GuildMember guildMember2 = map.get(Long.valueOf(this.$userId));
        if (guild == null || user == null || l == null || guildMember == null || guildMember2 == null) {
            return null;
        }
        PermissionsContexts3.Companion companion = PermissionsContexts3.INSTANCE;
        Intrinsics3.checkNotNullExpressionValue(meUser, "meUser");
        PermissionsContexts3 permissionsContexts3From = companion.from(guild, meUser, user, guildMember.getRoles(), guildMember2.getRoles(), l, linkedHashMap);
        HashSet hashSet = new HashSet(guildMember2.getRoles());
        GuildRole highestRole = RoleUtils.getHighestRole(linkedHashMap, guildMember);
        ArrayList<GuildRole> arrayList = new ArrayList(linkedHashMap.values());
        Collections.sort(arrayList, RoleUtils.getROLE_COMPARATOR());
        ArrayList arrayList2 = new ArrayList(Iterables2.collectionSizeOrDefault(arrayList, 10));
        for (GuildRole guildRole : arrayList) {
            arrayList2.add(new WidgetServerSettingsEditMemberRolesAdapter.RoleItem(guildRole, hashSet.contains(Long.valueOf(guildRole.getId())), highestRole, meUser.getId() == guild.getOwnerId(), permissionsContexts3From.getCanManageRoles()));
        }
        return new WidgetServerSettingsEditMember.Model(meUser.getId(), guild, guildMember2, hashSet, user, arrayList2, permissionsContexts3From.canManage(), permissionsContexts3From.getCanKick(), permissionsContexts3From.getCanBan(), permissionsContexts3From.getCanChangeNickname(), meUser.getId() != this.$userId && meUser.getId() == guild.getOwnerId(), permissionsContexts3From.getCanDisableCommunication());
    }
}

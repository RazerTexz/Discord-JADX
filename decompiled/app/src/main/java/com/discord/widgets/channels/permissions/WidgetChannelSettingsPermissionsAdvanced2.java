package com.discord.widgets.channels.permissions;

import com.discord.api.channel.Channel;
import com.discord.api.permission.PermissionOverwrite;
import com.discord.api.role.GuildRole;
import com.discord.models.guild.Guild;
import com.discord.models.user.MeUser;
import com.discord.models.user.User;
import com.discord.stores.StoreChannels;
import com.discord.stores.StoreGuilds;
import com.discord.stores.StorePermissions;
import com.discord.stores.StoreUser;
import com.discord.widgets.channels.SimpleMembersAdapter;
import com.discord.widgets.channels.permissions.WidgetChannelSettingsPermissionsAdvanced;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.functions.Function0;
import p507d0.p580t.Iterables2;
import p507d0.p580t.Maps6;
import p507d0.p580t._Collections;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;

/* compiled from: WidgetChannelSettingsPermissionsAdvanced.kt */
/* renamed from: com.discord.widgets.channels.permissions.WidgetChannelSettingsPermissionsAdvanced$Model$Companion$get$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetChannelSettingsPermissionsAdvanced2 extends Lambda implements Function0<WidgetChannelSettingsPermissionsAdvanced.Model> {
    public final /* synthetic */ long $channelId;
    public final /* synthetic */ StoreChannels $storeChannels;
    public final /* synthetic */ StoreGuilds $storeGuilds;
    public final /* synthetic */ StorePermissions $storePermissions;
    public final /* synthetic */ StoreUser $storeUser;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChannelSettingsPermissionsAdvanced2(StoreChannels storeChannels, long j, StoreGuilds storeGuilds, StoreUser storeUser, StorePermissions storePermissions) {
        super(0);
        this.$storeChannels = storeChannels;
        this.$channelId = j;
        this.$storeGuilds = storeGuilds;
        this.$storeUser = storeUser;
        this.$storePermissions = storePermissions;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ WidgetChannelSettingsPermissionsAdvanced.Model invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final WidgetChannelSettingsPermissionsAdvanced.Model invoke() {
        Channel channel = this.$storeChannels.getChannel(this.$channelId);
        if (channel == null) {
            return null;
        }
        Collection collectionAccess$getOverwriteIds = WidgetChannelSettingsPermissionsAdvanced.Model.Companion.access$getOverwriteIds(WidgetChannelSettingsPermissionsAdvanced.Model.INSTANCE, channel, PermissionOverwrite.Type.MEMBER);
        long guildId = channel.getGuildId();
        Guild guild = this.$storeGuilds.getGuild(guildId);
        Map<Long, GuildRole> mapEmptyMap = this.$storeGuilds.getRoles().get(Long.valueOf(guildId));
        if (mapEmptyMap == null) {
            mapEmptyMap = Maps6.emptyMap();
        }
        Map<Long, GuildRole> map = mapEmptyMap;
        MeUser meSnapshot = this.$storeUser.getMeSnapshot();
        Long l = this.$storePermissions.getPermissionsByChannel().get(Long.valueOf(this.$channelId));
        Map<Long, User> users = this.$storeUser.getUsers();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<Long, User> entry : users.entrySet()) {
            if (collectionAccess$getOverwriteIds.contains(Long.valueOf(entry.getKey().longValue()))) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        Collection collectionValues = linkedHashMap.values();
        WidgetChannelSettingsPermissionsAdvanced3 widgetChannelSettingsPermissionsAdvanced3 = WidgetChannelSettingsPermissionsAdvanced3.INSTANCE;
        Object widgetChannelSettingsPermissionsAdvanced4 = widgetChannelSettingsPermissionsAdvanced3;
        if (widgetChannelSettingsPermissionsAdvanced3 != null) {
            widgetChannelSettingsPermissionsAdvanced4 = new WidgetChannelSettingsPermissionsAdvanced4(widgetChannelSettingsPermissionsAdvanced3);
        }
        List<User> listSortedWith = _Collections.sortedWith(collectionValues, (Comparator) widgetChannelSettingsPermissionsAdvanced4);
        ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(listSortedWith, 10));
        for (User user : listSortedWith) {
            arrayList.add(new SimpleMembersAdapter.MemberItem(user, this.$storeGuilds.getMember(guildId, user.getId())));
        }
        if (!WidgetChannelSettingsPermissionsAdvanced.Model.INSTANCE.isValid(meSnapshot, guild, channel, l)) {
            return null;
        }
        Intrinsics3.checkNotNull(guild);
        Intrinsics3.checkNotNull(l);
        return new WidgetChannelSettingsPermissionsAdvanced.Model(meSnapshot, guild, channel, l.longValue(), map, arrayList);
    }
}

package com.discord.widgets.channels.permissions;

import androidx.core.app.NotificationCompat;
import com.discord.api.channel.Channel;
import com.discord.api.permission.PermissionOverwrite;
import com.discord.api.role.GuildRole;
import com.discord.models.guild.Guild;
import com.discord.models.member.GuildMember;
import com.discord.models.user.User;
import com.discord.stores.StoreGuilds;
import com.discord.stores.StoreUser;
import com.discord.widgets.channels.permissions.WidgetChannelSettingsAddMemberFragmentViewModel;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import p507d0.p512d0._Ranges;
import p507d0.p580t.Iterables2;
import p507d0.p580t.Maps6;
import p507d0.p580t.MapsJVM;
import p507d0.p592z.p594d.Intrinsics3;
import p637j0.p641k.Func1;
import p658rx.Observable;
import p658rx.functions.Func4;

/* JADX INFO: renamed from: com.discord.widgets.channels.permissions.WidgetChannelSettingsAddMemberFragmentViewModel$Companion$observeStoreState$1, reason: use source file name */
/* JADX INFO: compiled from: WidgetChannelSettingsAddMemberFragmentViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChannelSettingsAddMemberFragmentViewModel2<T, R> implements Func1<Channel, Observable<? extends WidgetChannelSettingsAddMemberFragmentViewModel.StoreState>> {
    public final /* synthetic */ StoreGuilds $guildsStore;
    public final /* synthetic */ StoreUser $userStore;

    /* JADX INFO: renamed from: com.discord.widgets.channels.permissions.WidgetChannelSettingsAddMemberFragmentViewModel$Companion$observeStoreState$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetChannelSettingsAddMemberFragmentViewModel.kt */
    public static final class AnonymousClass1<T1, T2, T3, T4, R> implements Func4<Guild, Map<Long, ? extends GuildRole>, Map<Long, ? extends GuildMember>, Map<Long, ? extends User>, WidgetChannelSettingsAddMemberFragmentViewModel.StoreState> {
        public final /* synthetic */ Channel $channel;

        public AnonymousClass1(Channel channel) {
            this.$channel = channel;
        }

        @Override // p658rx.functions.Func4
        public /* bridge */ /* synthetic */ WidgetChannelSettingsAddMemberFragmentViewModel.StoreState call(Guild guild, Map<Long, ? extends GuildRole> map, Map<Long, ? extends GuildMember> map2, Map<Long, ? extends User> map3) {
            return call2(guild, (Map<Long, GuildRole>) map, (Map<Long, GuildMember>) map2, map3);
        }

        /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
        public final WidgetChannelSettingsAddMemberFragmentViewModel.StoreState call2(Guild guild, Map<Long, GuildRole> map, Map<Long, GuildMember> map2, Map<Long, ? extends User> map3) {
            Map mapEmptyMap;
            Channel channel = this.$channel;
            Intrinsics3.checkNotNullExpressionValue(channel, "channel");
            List<PermissionOverwrite> listM7655v = this.$channel.m7655v();
            if (listM7655v != null) {
                mapEmptyMap = new LinkedHashMap(_Ranges.coerceAtLeast(MapsJVM.mapCapacity(Iterables2.collectionSizeOrDefault(listM7655v, 10)), 16));
                for (T t : listM7655v) {
                    mapEmptyMap.put(Long.valueOf(((PermissionOverwrite) t).m8131e()), t);
                }
            } else {
                mapEmptyMap = Maps6.emptyMap();
            }
            Intrinsics3.checkNotNullExpressionValue(map, "roles");
            Intrinsics3.checkNotNullExpressionValue(map2, "members");
            Intrinsics3.checkNotNullExpressionValue(map3, "users");
            return new WidgetChannelSettingsAddMemberFragmentViewModel.StoreState(guild, channel, mapEmptyMap, map, map2, map3);
        }
    }

    public WidgetChannelSettingsAddMemberFragmentViewModel2(StoreGuilds storeGuilds, StoreUser storeUser) {
        this.$guildsStore = storeGuilds;
        this.$userStore = storeUser;
    }

    @Override // p637j0.p641k.Func1
    public /* bridge */ /* synthetic */ Observable<? extends WidgetChannelSettingsAddMemberFragmentViewModel.StoreState> call(Channel channel) {
        return call2(channel);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends WidgetChannelSettingsAddMemberFragmentViewModel.StoreState> call2(Channel channel) {
        return Observable.m11073h(this.$guildsStore.observeGuild(channel.getGuildId()), this.$guildsStore.observeRoles(channel.getGuildId()), this.$guildsStore.observeComputed(channel.getGuildId()), this.$userStore.observeAllUsers(), new AnonymousClass1(channel));
    }
}

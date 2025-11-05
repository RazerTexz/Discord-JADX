package com.discord.widgets.servers.community;

import androidx.core.app.NotificationCompat;
import com.discord.api.channel.Channel;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.guild.Guild;
import com.discord.models.user.MeUser;
import com.discord.stores.StoreChannels;
import com.discord.stores.StorePermissions;
import com.discord.stores.StoreUser;
import com.discord.widgets.servers.community.WidgetServerSettingsCommunityOverviewViewModel;
import d0.z.d.m;
import j0.k.b;
import j0.l.e.k;
import rx.Observable;
import rx.functions.Func4;

/* compiled from: WidgetServerSettingsCommunityOverviewViewModel.kt */
/* loaded from: classes2.dex */
public final class WidgetServerSettingsCommunityOverviewViewModel$Companion$observeStoreState$1<T, R> implements b<Guild, Observable<? extends WidgetServerSettingsCommunityOverviewViewModel.StoreState>> {
    public final /* synthetic */ long $guildId;
    public final /* synthetic */ StoreChannels $storeChannels;
    public final /* synthetic */ StorePermissions $storePermissions;
    public final /* synthetic */ StoreUser $storeUsers;

    /* compiled from: WidgetServerSettingsCommunityOverviewViewModel.kt */
    /* renamed from: com.discord.widgets.servers.community.WidgetServerSettingsCommunityOverviewViewModel$Companion$observeStoreState$1$1, reason: invalid class name */
    public static final class AnonymousClass1<T1, T2, T3, T4, R> implements Func4<MeUser, Long, Channel, Channel, WidgetServerSettingsCommunityOverviewViewModel.StoreState.Valid> {
        public final /* synthetic */ Guild $guild;

        public AnonymousClass1(Guild guild) {
            this.$guild = guild;
        }

        @Override // rx.functions.Func4
        public /* bridge */ /* synthetic */ WidgetServerSettingsCommunityOverviewViewModel.StoreState.Valid call(MeUser meUser, Long l, Channel channel, Channel channel2) {
            return call2(meUser, l, channel, channel2);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final WidgetServerSettingsCommunityOverviewViewModel.StoreState.Valid call2(MeUser meUser, Long l, Channel channel, Channel channel2) {
            Guild guild = this.$guild;
            m.checkNotNullExpressionValue(meUser, "me");
            return new WidgetServerSettingsCommunityOverviewViewModel.StoreState.Valid(guild, meUser, l, channel, channel2);
        }
    }

    public WidgetServerSettingsCommunityOverviewViewModel$Companion$observeStoreState$1(StoreUser storeUser, StorePermissions storePermissions, long j, StoreChannels storeChannels) {
        this.$storeUsers = storeUser;
        this.$storePermissions = storePermissions;
        this.$guildId = j;
        this.$storeChannels = storeChannels;
    }

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ Observable<? extends WidgetServerSettingsCommunityOverviewViewModel.StoreState> call(Guild guild) {
        return call2(guild);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends WidgetServerSettingsCommunityOverviewViewModel.StoreState> call2(Guild guild) {
        if (guild == null) {
            return new k(WidgetServerSettingsCommunityOverviewViewModel.StoreState.Invalid.INSTANCE);
        }
        Observable observableObserveMe$default = StoreUser.observeMe$default(this.$storeUsers, false, 1, null);
        Observable<Long> observableObservePermissionsForGuild = this.$storePermissions.observePermissionsForGuild(this.$guildId);
        StoreChannels storeChannels = this.$storeChannels;
        Long rulesChannelId = guild.getRulesChannelId();
        Observable<Channel> observableObserveChannel = storeChannels.observeChannel(rulesChannelId != null ? rulesChannelId.longValue() : 0L);
        StoreChannels storeChannels2 = this.$storeChannels;
        Long publicUpdatesChannelId = guild.getPublicUpdatesChannelId();
        return Observable.h(observableObserveMe$default, observableObservePermissionsForGuild, observableObserveChannel, storeChannels2.observeChannel(publicUpdatesChannelId != null ? publicUpdatesChannelId.longValue() : 0L), new AnonymousClass1(guild));
    }
}

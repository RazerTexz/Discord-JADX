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
import p507d0.p592z.p594d.Intrinsics3;
import p637j0.p641k.Func1;
import p637j0.p642l.p647e.ScalarSynchronousObservable;
import p658rx.Observable;
import p658rx.functions.Func4;

/* JADX INFO: renamed from: com.discord.widgets.servers.community.WidgetServerSettingsCommunityOverviewViewModel$Companion$observeStoreState$1, reason: use source file name */
/* JADX INFO: compiled from: WidgetServerSettingsCommunityOverviewViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsCommunityOverviewViewModel2<T, R> implements Func1<Guild, Observable<? extends WidgetServerSettingsCommunityOverviewViewModel.StoreState>> {
    public final /* synthetic */ long $guildId;
    public final /* synthetic */ StoreChannels $storeChannels;
    public final /* synthetic */ StorePermissions $storePermissions;
    public final /* synthetic */ StoreUser $storeUsers;

    /* JADX INFO: renamed from: com.discord.widgets.servers.community.WidgetServerSettingsCommunityOverviewViewModel$Companion$observeStoreState$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetServerSettingsCommunityOverviewViewModel.kt */
    public static final class AnonymousClass1<T1, T2, T3, T4, R> implements Func4<MeUser, Long, Channel, Channel, WidgetServerSettingsCommunityOverviewViewModel.StoreState.Valid> {
        public final /* synthetic */ Guild $guild;

        public AnonymousClass1(Guild guild) {
            this.$guild = guild;
        }

        @Override // p658rx.functions.Func4
        public /* bridge */ /* synthetic */ WidgetServerSettingsCommunityOverviewViewModel.StoreState.Valid call(MeUser meUser, Long l, Channel channel, Channel channel2) {
            return call2(meUser, l, channel, channel2);
        }

        /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
        public final WidgetServerSettingsCommunityOverviewViewModel.StoreState.Valid call2(MeUser meUser, Long l, Channel channel, Channel channel2) {
            Guild guild = this.$guild;
            Intrinsics3.checkNotNullExpressionValue(meUser, "me");
            return new WidgetServerSettingsCommunityOverviewViewModel.StoreState.Valid(guild, meUser, l, channel, channel2);
        }
    }

    public WidgetServerSettingsCommunityOverviewViewModel2(StoreUser storeUser, StorePermissions storePermissions, long j, StoreChannels storeChannels) {
        this.$storeUsers = storeUser;
        this.$storePermissions = storePermissions;
        this.$guildId = j;
        this.$storeChannels = storeChannels;
    }

    @Override // p637j0.p641k.Func1
    public /* bridge */ /* synthetic */ Observable<? extends WidgetServerSettingsCommunityOverviewViewModel.StoreState> call(Guild guild) {
        return call2(guild);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends WidgetServerSettingsCommunityOverviewViewModel.StoreState> call2(Guild guild) {
        if (guild == null) {
            return new ScalarSynchronousObservable(WidgetServerSettingsCommunityOverviewViewModel.StoreState.Invalid.INSTANCE);
        }
        Observable observableObserveMe$default = StoreUser.observeMe$default(this.$storeUsers, false, 1, null);
        Observable<Long> observableObservePermissionsForGuild = this.$storePermissions.observePermissionsForGuild(this.$guildId);
        StoreChannels storeChannels = this.$storeChannels;
        Long rulesChannelId = guild.getRulesChannelId();
        Observable<Channel> observableObserveChannel = storeChannels.observeChannel(rulesChannelId != null ? rulesChannelId.longValue() : 0L);
        StoreChannels storeChannels2 = this.$storeChannels;
        Long publicUpdatesChannelId = guild.getPublicUpdatesChannelId();
        return Observable.m11073h(observableObserveMe$default, observableObservePermissionsForGuild, observableObserveChannel, storeChannels2.observeChannel(publicUpdatesChannelId != null ? publicUpdatesChannelId.longValue() : 0L), new AnonymousClass1(guild));
    }
}

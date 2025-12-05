package com.discord.widgets.servers.community;

import androidx.core.app.NotificationCompat;
import com.discord.api.channel.Channel;
import com.discord.api.role.GuildRole;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.guild.Guild;
import com.discord.models.user.MeUser;
import com.discord.stores.StoreChannels;
import com.discord.stores.StorePermissions;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUser;
import com.discord.widgets.servers.community.WidgetServerSettingsEnableCommunityViewModel;
import java.util.Map;
import p507d0.p592z.p594d.Intrinsics3;
import p637j0.p641k.Func1;
import p637j0.p642l.p647e.ScalarSynchronousObservable;
import p658rx.Observable;
import p658rx.functions.Func5;

/* compiled from: WidgetServerSettingsEnableCommunityViewModel.kt */
/* renamed from: com.discord.widgets.servers.community.WidgetServerSettingsEnableCommunityViewModel$Companion$observeStoreState$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetServerSettingsEnableCommunityViewModel2<T, R> implements Func1<Guild, Observable<? extends WidgetServerSettingsEnableCommunityViewModel.StoreState>> {
    public final /* synthetic */ long $guildId;
    public final /* synthetic */ StoreChannels $storeChannels;
    public final /* synthetic */ StorePermissions $storePermissions;
    public final /* synthetic */ StoreUser $storeUsers;

    /* compiled from: WidgetServerSettingsEnableCommunityViewModel.kt */
    /* renamed from: com.discord.widgets.servers.community.WidgetServerSettingsEnableCommunityViewModel$Companion$observeStoreState$1$1, reason: invalid class name */
    public static final class AnonymousClass1<T1, T2, T3, T4, T5, R> implements Func5<MeUser, Long, Map<Long, ? extends GuildRole>, Channel, Channel, WidgetServerSettingsEnableCommunityViewModel.StoreState.Valid> {
        public final /* synthetic */ Guild $guild;

        public AnonymousClass1(Guild guild) {
            this.$guild = guild;
        }

        @Override // p658rx.functions.Func5
        public /* bridge */ /* synthetic */ WidgetServerSettingsEnableCommunityViewModel.StoreState.Valid call(MeUser meUser, Long l, Map<Long, ? extends GuildRole> map, Channel channel, Channel channel2) {
            return call2(meUser, l, (Map<Long, GuildRole>) map, channel, channel2);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final WidgetServerSettingsEnableCommunityViewModel.StoreState.Valid call2(MeUser meUser, Long l, Map<Long, GuildRole> map, Channel channel, Channel channel2) {
            Guild guild = this.$guild;
            Intrinsics3.checkNotNullExpressionValue(meUser, "me");
            return new WidgetServerSettingsEnableCommunityViewModel.StoreState.Valid(guild, meUser, l, map, channel, channel2);
        }
    }

    public WidgetServerSettingsEnableCommunityViewModel2(StoreUser storeUser, StorePermissions storePermissions, long j, StoreChannels storeChannels) {
        this.$storeUsers = storeUser;
        this.$storePermissions = storePermissions;
        this.$guildId = j;
        this.$storeChannels = storeChannels;
    }

    @Override // p637j0.p641k.Func1
    public /* bridge */ /* synthetic */ Observable<? extends WidgetServerSettingsEnableCommunityViewModel.StoreState> call(Guild guild) {
        return call2(guild);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends WidgetServerSettingsEnableCommunityViewModel.StoreState> call2(Guild guild) {
        if (guild == null) {
            return new ScalarSynchronousObservable(WidgetServerSettingsEnableCommunityViewModel.StoreState.Invalid.INSTANCE);
        }
        Observable observableObserveMe$default = StoreUser.observeMe$default(this.$storeUsers, false, 1, null);
        Observable<Long> observableObservePermissionsForGuild = this.$storePermissions.observePermissionsForGuild(this.$guildId);
        Observable<Map<Long, GuildRole>> observableObserveRoles = StoreStream.INSTANCE.getGuilds().observeRoles(this.$guildId);
        StoreChannels storeChannels = this.$storeChannels;
        Long rulesChannelId = guild.getRulesChannelId();
        Observable<Channel> observableObserveChannel = storeChannels.observeChannel(rulesChannelId != null ? rulesChannelId.longValue() : 0L);
        StoreChannels storeChannels2 = this.$storeChannels;
        Long publicUpdatesChannelId = guild.getPublicUpdatesChannelId();
        return Observable.m11072g(observableObserveMe$default, observableObservePermissionsForGuild, observableObserveRoles, observableObserveChannel, storeChannels2.observeChannel(publicUpdatesChannelId != null ? publicUpdatesChannelId.longValue() : 0L), new AnonymousClass1(guild));
    }
}

package com.discord.widgets.channels.threads.browser;

import androidx.core.app.NotificationCompat;
import com.discord.api.channel.Channel;
import com.discord.api.role.GuildRole;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.guild.Guild;
import com.discord.models.member.GuildMember;
import com.discord.models.user.MeUser;
import com.discord.models.user.User;
import com.discord.stores.StoreChannels;
import com.discord.stores.StoreGuilds;
import com.discord.stores.StorePermissions;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreThreadMessages;
import com.discord.stores.StoreUser;
import com.discord.utilities.p501rx.ObservableCombineLatestOverloads2;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.widgets.channels.threads.browser.WidgetThreadBrowserActiveViewModel;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Tuples2;
import kotlin.jvm.functions.Function10;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;
import p637j0.p641k.Func1;
import p658rx.Observable;

/* JADX INFO: renamed from: com.discord.widgets.channels.threads.browser.WidgetThreadBrowserActiveViewModel$Companion$observeStoreState$3, reason: use source file name */
/* JADX INFO: compiled from: WidgetThreadBrowserActiveViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetThreadBrowserActiveViewModel4<T, R> implements Func1<Tuples2<? extends Map<Long, ? extends Channel>, ? extends Map<Long, ? extends Channel>>, Observable<? extends WidgetThreadBrowserActiveViewModel.StoreState>> {
    public final /* synthetic */ long $channelId;
    public final /* synthetic */ long $guildId;
    public final /* synthetic */ StoreChannels $storeChannels;
    public final /* synthetic */ StoreGuilds $storeGuilds;
    public final /* synthetic */ StorePermissions $storePermissions;
    public final /* synthetic */ StoreThreadMessages $storeThreadMessages;
    public final /* synthetic */ StoreUser $storeUser;

    /* JADX INFO: renamed from: com.discord.widgets.channels.threads.browser.WidgetThreadBrowserActiveViewModel$Companion$observeStoreState$3$2 */
    /* JADX INFO: compiled from: WidgetThreadBrowserActiveViewModel.kt */
    public static final class C76492 extends Lambda implements Function10<MeUser, Map<Long, ? extends User>, Map<Long, ? extends StoreThreadMessages.ThreadState>, Map<Long, ? extends GuildMember>, Map<Long, ? extends GuildRole>, Map<Long, ? extends String>, Long, Map<Long, ? extends Integer>, Channel, Guild, WidgetThreadBrowserActiveViewModel.StoreState> {
        public final /* synthetic */ Map $activeJoinedThreads;
        public final /* synthetic */ Map $activeThreads;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C76492(Map map, Map map2) {
            super(10);
            this.$activeJoinedThreads = map;
            this.$activeThreads = map2;
        }

        @Override // kotlin.jvm.functions.Function10
        public /* bridge */ /* synthetic */ WidgetThreadBrowserActiveViewModel.StoreState invoke(MeUser meUser, Map<Long, ? extends User> map, Map<Long, ? extends StoreThreadMessages.ThreadState> map2, Map<Long, ? extends GuildMember> map3, Map<Long, ? extends GuildRole> map4, Map<Long, ? extends String> map5, Long l, Map<Long, ? extends Integer> map6, Channel channel, Guild guild) {
            return invoke2(meUser, map, (Map<Long, StoreThreadMessages.ThreadState>) map2, (Map<Long, GuildMember>) map3, (Map<Long, GuildRole>) map4, (Map<Long, String>) map5, l, (Map<Long, Integer>) map6, channel, guild);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final WidgetThreadBrowserActiveViewModel.StoreState invoke2(MeUser meUser, Map<Long, ? extends User> map, Map<Long, StoreThreadMessages.ThreadState> map2, Map<Long, GuildMember> map3, Map<Long, GuildRole> map4, Map<Long, String> map5, Long l, Map<Long, Integer> map6, Channel channel, Guild guild) {
            Intrinsics3.checkNotNullParameter(meUser, "meUser");
            Intrinsics3.checkNotNullParameter(map, "users");
            Intrinsics3.checkNotNullParameter(map2, "threadStates");
            Intrinsics3.checkNotNullParameter(map4, "guildRoles");
            Intrinsics3.checkNotNullParameter(map5, "channelNames");
            Intrinsics3.checkNotNullParameter(map6, "blockedUsers");
            Map map7 = this.$activeJoinedThreads;
            Intrinsics3.checkNotNullExpressionValue(map7, "activeJoinedThreads");
            Map map8 = this.$activeThreads;
            Intrinsics3.checkNotNullExpressionValue(map8, "activeThreads");
            Intrinsics3.checkNotNullExpressionValue(map3, "guildMembers");
            return new WidgetThreadBrowserActiveViewModel.StoreState(meUser, map7, map8, map2, map3, map, map4, map5, l, map6, channel, guild);
        }
    }

    public WidgetThreadBrowserActiveViewModel4(StoreUser storeUser, StoreThreadMessages storeThreadMessages, StoreGuilds storeGuilds, long j, StoreChannels storeChannels, StorePermissions storePermissions, long j2) {
        this.$storeUser = storeUser;
        this.$storeThreadMessages = storeThreadMessages;
        this.$storeGuilds = storeGuilds;
        this.$guildId = j;
        this.$storeChannels = storeChannels;
        this.$storePermissions = storePermissions;
        this.$channelId = j2;
    }

    @Override // p637j0.p641k.Func1
    public /* bridge */ /* synthetic */ Observable<? extends WidgetThreadBrowserActiveViewModel.StoreState> call(Tuples2<? extends Map<Long, ? extends Channel>, ? extends Map<Long, ? extends Channel>> tuples2) {
        return call2((Tuples2<? extends Map<Long, Channel>, ? extends Map<Long, Channel>>) tuples2);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends WidgetThreadBrowserActiveViewModel.StoreState> call2(Tuples2<? extends Map<Long, Channel>, ? extends Map<Long, Channel>> tuples2) {
        Map<Long, Channel> mapComponent1 = tuples2.component1();
        Map<Long, Channel> mapComponent2 = tuples2.component2();
        Observable observableObserveMe$default = StoreUser.observeMe$default(this.$storeUser, false, 1, null);
        StoreUser storeUser = this.$storeUser;
        HashSet hashSet = new HashSet();
        Intrinsics3.checkNotNullExpressionValue(mapComponent1, "activeJoinedThreads");
        Iterator<Map.Entry<Long, Channel>> it = mapComponent1.entrySet().iterator();
        while (it.hasNext()) {
            hashSet.add(Long.valueOf(it.next().getValue().getOwnerId()));
        }
        Intrinsics3.checkNotNullExpressionValue(mapComponent2, "activeThreads");
        Iterator<Map.Entry<Long, Channel>> it2 = mapComponent2.entrySet().iterator();
        while (it2.hasNext()) {
            hashSet.add(Long.valueOf(it2.next().getValue().getOwnerId()));
        }
        Observable<Map<Long, User>> observableObserveUsers = storeUser.observeUsers(hashSet);
        Observable<Map<Long, StoreThreadMessages.ThreadState>> observableObserveThreadCountAndLatestMessage = this.$storeThreadMessages.observeThreadCountAndLatestMessage();
        Observable<Map<Long, GuildMember>> observableObserveGuildMembers = this.$storeGuilds.observeGuildMembers(this.$guildId);
        Intrinsics3.checkNotNullExpressionValue(observableObserveGuildMembers, "storeGuilds\n            …erveGuildMembers(guildId)");
        Observable<T> observableM11112r = ObservableExtensionsKt.leadingEdgeThrottle(observableObserveGuildMembers, 1L, TimeUnit.SECONDS).m11112r();
        Intrinsics3.checkNotNullExpressionValue(observableM11112r, "storeGuilds\n            …  .distinctUntilChanged()");
        return ObservableCombineLatestOverloads2.combineLatest(observableObserveMe$default, observableObserveUsers, observableObserveThreadCountAndLatestMessage, observableM11112r, this.$storeGuilds.observeRoles(this.$guildId), this.$storeChannels.observeNames(), this.$storePermissions.observePermissionsForChannel(this.$channelId), StoreStream.INSTANCE.getUserRelationships().observeForType(2), this.$storeChannels.observeChannel(this.$channelId), this.$storeGuilds.observeGuild(this.$guildId), new C76492(mapComponent1, mapComponent2));
    }
}

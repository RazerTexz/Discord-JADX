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
import com.discord.utilities.rx.ObservableCombineLatestOverloadsKt;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.widgets.channels.threads.browser.WidgetThreadBrowserActiveViewModel;
import d0.z.d.m;
import d0.z.d.o;
import j0.k.b;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Pair;
import kotlin.jvm.functions.Function10;
import rx.Observable;

/* compiled from: WidgetThreadBrowserActiveViewModel.kt */
/* loaded from: classes2.dex */
public final class WidgetThreadBrowserActiveViewModel$Companion$observeStoreState$3<T, R> implements b<Pair<? extends Map<Long, ? extends Channel>, ? extends Map<Long, ? extends Channel>>, Observable<? extends WidgetThreadBrowserActiveViewModel.StoreState>> {
    public final /* synthetic */ long $channelId;
    public final /* synthetic */ long $guildId;
    public final /* synthetic */ StoreChannels $storeChannels;
    public final /* synthetic */ StoreGuilds $storeGuilds;
    public final /* synthetic */ StorePermissions $storePermissions;
    public final /* synthetic */ StoreThreadMessages $storeThreadMessages;
    public final /* synthetic */ StoreUser $storeUser;

    /* compiled from: WidgetThreadBrowserActiveViewModel.kt */
    /* renamed from: com.discord.widgets.channels.threads.browser.WidgetThreadBrowserActiveViewModel$Companion$observeStoreState$3$2, reason: invalid class name */
    public static final class AnonymousClass2 extends o implements Function10<MeUser, Map<Long, ? extends User>, Map<Long, ? extends StoreThreadMessages.ThreadState>, Map<Long, ? extends GuildMember>, Map<Long, ? extends GuildRole>, Map<Long, ? extends String>, Long, Map<Long, ? extends Integer>, Channel, Guild, WidgetThreadBrowserActiveViewModel.StoreState> {
        public final /* synthetic */ Map $activeJoinedThreads;
        public final /* synthetic */ Map $activeThreads;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(Map map, Map map2) {
            super(10);
            this.$activeJoinedThreads = map;
            this.$activeThreads = map2;
        }

        @Override // kotlin.jvm.functions.Function10
        public /* bridge */ /* synthetic */ WidgetThreadBrowserActiveViewModel.StoreState invoke(MeUser meUser, Map<Long, ? extends User> map, Map<Long, ? extends StoreThreadMessages.ThreadState> map2, Map<Long, ? extends GuildMember> map3, Map<Long, ? extends GuildRole> map4, Map<Long, ? extends String> map5, Long l, Map<Long, ? extends Integer> map6, Channel channel, Guild guild) {
            return invoke2(meUser, map, (Map<Long, StoreThreadMessages.ThreadState>) map2, (Map<Long, GuildMember>) map3, (Map<Long, GuildRole>) map4, (Map<Long, String>) map5, l, (Map<Long, Integer>) map6, channel, guild);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final WidgetThreadBrowserActiveViewModel.StoreState invoke2(MeUser meUser, Map<Long, ? extends User> map, Map<Long, StoreThreadMessages.ThreadState> map2, Map<Long, GuildMember> map3, Map<Long, GuildRole> map4, Map<Long, String> map5, Long l, Map<Long, Integer> map6, Channel channel, Guild guild) {
            m.checkNotNullParameter(meUser, "meUser");
            m.checkNotNullParameter(map, "users");
            m.checkNotNullParameter(map2, "threadStates");
            m.checkNotNullParameter(map4, "guildRoles");
            m.checkNotNullParameter(map5, "channelNames");
            m.checkNotNullParameter(map6, "blockedUsers");
            Map map7 = this.$activeJoinedThreads;
            m.checkNotNullExpressionValue(map7, "activeJoinedThreads");
            Map map8 = this.$activeThreads;
            m.checkNotNullExpressionValue(map8, "activeThreads");
            m.checkNotNullExpressionValue(map3, "guildMembers");
            return new WidgetThreadBrowserActiveViewModel.StoreState(meUser, map7, map8, map2, map3, map, map4, map5, l, map6, channel, guild);
        }
    }

    public WidgetThreadBrowserActiveViewModel$Companion$observeStoreState$3(StoreUser storeUser, StoreThreadMessages storeThreadMessages, StoreGuilds storeGuilds, long j, StoreChannels storeChannels, StorePermissions storePermissions, long j2) {
        this.$storeUser = storeUser;
        this.$storeThreadMessages = storeThreadMessages;
        this.$storeGuilds = storeGuilds;
        this.$guildId = j;
        this.$storeChannels = storeChannels;
        this.$storePermissions = storePermissions;
        this.$channelId = j2;
    }

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ Observable<? extends WidgetThreadBrowserActiveViewModel.StoreState> call(Pair<? extends Map<Long, ? extends Channel>, ? extends Map<Long, ? extends Channel>> pair) {
        return call2((Pair<? extends Map<Long, Channel>, ? extends Map<Long, Channel>>) pair);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends WidgetThreadBrowserActiveViewModel.StoreState> call2(Pair<? extends Map<Long, Channel>, ? extends Map<Long, Channel>> pair) {
        Map<Long, Channel> mapComponent1 = pair.component1();
        Map<Long, Channel> mapComponent2 = pair.component2();
        Observable observableObserveMe$default = StoreUser.observeMe$default(this.$storeUser, false, 1, null);
        StoreUser storeUser = this.$storeUser;
        HashSet hashSet = new HashSet();
        m.checkNotNullExpressionValue(mapComponent1, "activeJoinedThreads");
        Iterator<Map.Entry<Long, Channel>> it = mapComponent1.entrySet().iterator();
        while (it.hasNext()) {
            hashSet.add(Long.valueOf(it.next().getValue().getOwnerId()));
        }
        m.checkNotNullExpressionValue(mapComponent2, "activeThreads");
        Iterator<Map.Entry<Long, Channel>> it2 = mapComponent2.entrySet().iterator();
        while (it2.hasNext()) {
            hashSet.add(Long.valueOf(it2.next().getValue().getOwnerId()));
        }
        Observable<Map<Long, User>> observableObserveUsers = storeUser.observeUsers(hashSet);
        Observable<Map<Long, StoreThreadMessages.ThreadState>> observableObserveThreadCountAndLatestMessage = this.$storeThreadMessages.observeThreadCountAndLatestMessage();
        Observable<Map<Long, GuildMember>> observableObserveGuildMembers = this.$storeGuilds.observeGuildMembers(this.$guildId);
        m.checkNotNullExpressionValue(observableObserveGuildMembers, "storeGuilds\n            …erveGuildMembers(guildId)");
        Observable<T> observableR = ObservableExtensionsKt.leadingEdgeThrottle(observableObserveGuildMembers, 1L, TimeUnit.SECONDS).r();
        m.checkNotNullExpressionValue(observableR, "storeGuilds\n            …  .distinctUntilChanged()");
        return ObservableCombineLatestOverloadsKt.combineLatest(observableObserveMe$default, observableObserveUsers, observableObserveThreadCountAndLatestMessage, observableR, this.$storeGuilds.observeRoles(this.$guildId), this.$storeChannels.observeNames(), this.$storePermissions.observePermissionsForChannel(this.$channelId), StoreStream.INSTANCE.getUserRelationships().observeForType(2), this.$storeChannels.observeChannel(this.$channelId), this.$storeGuilds.observeGuild(this.$guildId), new AnonymousClass2(mapComponent1, mapComponent2));
    }
}

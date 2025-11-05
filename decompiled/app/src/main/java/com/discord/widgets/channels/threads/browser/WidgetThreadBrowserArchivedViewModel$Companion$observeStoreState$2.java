package com.discord.widgets.channels.threads.browser;

import androidx.core.app.NotificationCompat;
import com.discord.api.channel.Channel;
import com.discord.models.guild.Guild;
import com.discord.models.member.GuildMember;
import com.discord.models.user.User;
import com.discord.stores.ArchivedThreadsStore;
import com.discord.stores.StoreGuilds;
import com.discord.stores.StorePermissions;
import com.discord.stores.StoreUser;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.threads.ThreadUtils;
import com.discord.widgets.channels.threads.browser.WidgetThreadBrowserArchivedViewModel;
import d0.t.h0;
import d0.t.o;
import d0.z.d.m;
import j0.k.b;
import j0.l.e.k;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import kotlin.Pair;
import rx.Observable;
import rx.functions.Func4;

/* compiled from: WidgetThreadBrowserArchivedViewModel.kt */
/* loaded from: classes2.dex */
public final class WidgetThreadBrowserArchivedViewModel$Companion$observeStoreState$2<T, R> implements b<Pair<? extends ArchivedThreadsStore.ThreadListingState, ? extends Channel>, Observable<? extends WidgetThreadBrowserArchivedViewModel.StoreState>> {
    public final /* synthetic */ long $guildId;
    public final /* synthetic */ StoreGuilds $storeGuilds;
    public final /* synthetic */ StorePermissions $storePermissions;
    public final /* synthetic */ StoreUser $storeUser;
    public final /* synthetic */ WidgetThreadBrowserArchivedViewModel.ViewMode $viewMode;

    /* compiled from: WidgetThreadBrowserArchivedViewModel.kt */
    /* renamed from: com.discord.widgets.channels.threads.browser.WidgetThreadBrowserArchivedViewModel$Companion$observeStoreState$2$1, reason: invalid class name */
    public static final class AnonymousClass1<T, R> implements b<Map<Long, ? extends Map<Long, ? extends GuildMember>>, Map<Long, ? extends GuildMember>> {
        public AnonymousClass1() {
        }

        @Override // j0.k.b
        public /* bridge */ /* synthetic */ Map<Long, ? extends GuildMember> call(Map<Long, ? extends Map<Long, ? extends GuildMember>> map) {
            return call2((Map<Long, ? extends Map<Long, GuildMember>>) map);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final Map<Long, GuildMember> call2(Map<Long, ? extends Map<Long, GuildMember>> map) {
            Map<Long, GuildMember> map2 = map.get(Long.valueOf(WidgetThreadBrowserArchivedViewModel$Companion$observeStoreState$2.this.$guildId));
            return map2 != null ? map2 : h0.emptyMap();
        }
    }

    /* compiled from: WidgetThreadBrowserArchivedViewModel.kt */
    /* renamed from: com.discord.widgets.channels.threads.browser.WidgetThreadBrowserArchivedViewModel$Companion$observeStoreState$2$2, reason: invalid class name */
    public static final class AnonymousClass2<T1, T2, T3, T4, R> implements Func4<Map<Long, ? extends GuildMember>, Guild, Map<Long, ? extends User>, Long, WidgetThreadBrowserArchivedViewModel.StoreState> {
        public final /* synthetic */ Channel $channel;
        public final /* synthetic */ ArchivedThreadsStore.ThreadListingState $listingState;

        public AnonymousClass2(ArchivedThreadsStore.ThreadListingState threadListingState, Channel channel) {
            this.$listingState = threadListingState;
            this.$channel = channel;
        }

        @Override // rx.functions.Func4
        public /* bridge */ /* synthetic */ WidgetThreadBrowserArchivedViewModel.StoreState call(Map<Long, ? extends GuildMember> map, Guild guild, Map<Long, ? extends User> map2, Long l) {
            return call2((Map<Long, GuildMember>) map, guild, map2, l);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final WidgetThreadBrowserArchivedViewModel.StoreState call2(Map<Long, GuildMember> map, Guild guild, Map<Long, ? extends User> map2, Long l) {
            boolean zCanViewAllPrivateThreads = ThreadUtils.INSTANCE.canViewAllPrivateThreads(l);
            WidgetThreadBrowserArchivedViewModel.ViewMode viewMode = WidgetThreadBrowserArchivedViewModel$Companion$observeStoreState$2.this.$viewMode;
            m.checkNotNullExpressionValue(map, "guildMembers");
            m.checkNotNullExpressionValue(map2, "users");
            ArchivedThreadsStore.ThreadListingState threadListingState = this.$listingState;
            m.checkNotNullExpressionValue(threadListingState, "listingState");
            return new WidgetThreadBrowserArchivedViewModel.StoreState(viewMode, map, map2, threadListingState, zCanViewAllPrivateThreads, this.$channel, guild, l);
        }
    }

    public WidgetThreadBrowserArchivedViewModel$Companion$observeStoreState$2(StoreUser storeUser, StoreGuilds storeGuilds, long j, StorePermissions storePermissions, WidgetThreadBrowserArchivedViewModel.ViewMode viewMode) {
        this.$storeUser = storeUser;
        this.$storeGuilds = storeGuilds;
        this.$guildId = j;
        this.$storePermissions = storePermissions;
        this.$viewMode = viewMode;
    }

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ Observable<? extends WidgetThreadBrowserArchivedViewModel.StoreState> call(Pair<? extends ArchivedThreadsStore.ThreadListingState, ? extends Channel> pair) {
        return call2((Pair<? extends ArchivedThreadsStore.ThreadListingState, Channel>) pair);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends WidgetThreadBrowserArchivedViewModel.StoreState> call2(Pair<? extends ArchivedThreadsStore.ThreadListingState, Channel> pair) {
        Observable<Map<Long, User>> kVar;
        ArchivedThreadsStore.ThreadListingState threadListingStateComponent1 = pair.component1();
        Channel channelComponent2 = pair.component2();
        if (threadListingStateComponent1 instanceof ArchivedThreadsStore.ThreadListingState.Listing) {
            StoreUser storeUser = this.$storeUser;
            List<Channel> threads = ((ArchivedThreadsStore.ThreadListingState.Listing) threadListingStateComponent1).getThreads();
            ArrayList arrayList = new ArrayList(o.collectionSizeOrDefault(threads, 10));
            Iterator<T> it = threads.iterator();
            while (it.hasNext()) {
                arrayList.add(Long.valueOf(((Channel) it.next()).getOwnerId()));
            }
            kVar = storeUser.observeUsers(arrayList);
        } else {
            kVar = new k(h0.emptyMap());
        }
        Observable<R> observableG = this.$storeGuilds.observeComputed().G(new AnonymousClass1());
        m.checkNotNullExpressionValue(observableG, "storeGuilds\n            …[guildId] ?: emptyMap() }");
        Observable<T> observableR = ObservableExtensionsKt.leadingEdgeThrottle(observableG, 1L, TimeUnit.SECONDS).r();
        Observable<Guild> observableObserveGuild = this.$storeGuilds.observeGuild(this.$guildId);
        StorePermissions storePermissions = this.$storePermissions;
        Long lValueOf = channelComponent2 != null ? Long.valueOf(channelComponent2.getParentId()) : null;
        Objects.requireNonNull(lValueOf, "null cannot be cast to non-null type com.discord.primitives.Snowflake /* = kotlin.Long */");
        return Observable.h(observableR, observableObserveGuild, kVar, storePermissions.observePermissionsForChannel(lValueOf.longValue()), new AnonymousClass2(threadListingStateComponent1, channelComponent2));
    }
}

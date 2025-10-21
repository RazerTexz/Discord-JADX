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
import d0.t.Iterables2;
import d0.t.Maps6;
import d0.z.d.Intrinsics3;
import j0.k.Func1;
import j0.l.e.ScalarSynchronousObservable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import kotlin.Tuples2;
import rx.Observable;
import rx.functions.Func4;

/* compiled from: WidgetThreadBrowserArchivedViewModel.kt */
/* renamed from: com.discord.widgets.channels.threads.browser.WidgetThreadBrowserArchivedViewModel$Companion$observeStoreState$2, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetThreadBrowserArchivedViewModel3<T, R> implements Func1<Tuples2<? extends ArchivedThreadsStore.ThreadListingState, ? extends Channel>, Observable<? extends WidgetThreadBrowserArchivedViewModel.StoreState>> {
    public final /* synthetic */ long $guildId;
    public final /* synthetic */ StoreGuilds $storeGuilds;
    public final /* synthetic */ StorePermissions $storePermissions;
    public final /* synthetic */ StoreUser $storeUser;
    public final /* synthetic */ WidgetThreadBrowserArchivedViewModel.ViewMode $viewMode;

    /* compiled from: WidgetThreadBrowserArchivedViewModel.kt */
    /* renamed from: com.discord.widgets.channels.threads.browser.WidgetThreadBrowserArchivedViewModel$Companion$observeStoreState$2$1, reason: invalid class name */
    public static final class AnonymousClass1<T, R> implements Func1<Map<Long, ? extends Map<Long, ? extends GuildMember>>, Map<Long, ? extends GuildMember>> {
        public AnonymousClass1() {
        }

        @Override // j0.k.Func1
        public /* bridge */ /* synthetic */ Map<Long, ? extends GuildMember> call(Map<Long, ? extends Map<Long, ? extends GuildMember>> map) {
            return call2((Map<Long, ? extends Map<Long, GuildMember>>) map);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final Map<Long, GuildMember> call2(Map<Long, ? extends Map<Long, GuildMember>> map) {
            Map<Long, GuildMember> map2 = map.get(Long.valueOf(WidgetThreadBrowserArchivedViewModel3.this.$guildId));
            return map2 != null ? map2 : Maps6.emptyMap();
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
            WidgetThreadBrowserArchivedViewModel.ViewMode viewMode = WidgetThreadBrowserArchivedViewModel3.this.$viewMode;
            Intrinsics3.checkNotNullExpressionValue(map, "guildMembers");
            Intrinsics3.checkNotNullExpressionValue(map2, "users");
            ArchivedThreadsStore.ThreadListingState threadListingState = this.$listingState;
            Intrinsics3.checkNotNullExpressionValue(threadListingState, "listingState");
            return new WidgetThreadBrowserArchivedViewModel.StoreState(viewMode, map, map2, threadListingState, zCanViewAllPrivateThreads, this.$channel, guild, l);
        }
    }

    public WidgetThreadBrowserArchivedViewModel3(StoreUser storeUser, StoreGuilds storeGuilds, long j, StorePermissions storePermissions, WidgetThreadBrowserArchivedViewModel.ViewMode viewMode) {
        this.$storeUser = storeUser;
        this.$storeGuilds = storeGuilds;
        this.$guildId = j;
        this.$storePermissions = storePermissions;
        this.$viewMode = viewMode;
    }

    @Override // j0.k.Func1
    public /* bridge */ /* synthetic */ Observable<? extends WidgetThreadBrowserArchivedViewModel.StoreState> call(Tuples2<? extends ArchivedThreadsStore.ThreadListingState, ? extends Channel> tuples2) {
        return call2((Tuples2<? extends ArchivedThreadsStore.ThreadListingState, Channel>) tuples2);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends WidgetThreadBrowserArchivedViewModel.StoreState> call2(Tuples2<? extends ArchivedThreadsStore.ThreadListingState, Channel> tuples2) {
        Observable<Map<Long, User>> scalarSynchronousObservable;
        ArchivedThreadsStore.ThreadListingState threadListingStateComponent1 = tuples2.component1();
        Channel channelComponent2 = tuples2.component2();
        if (threadListingStateComponent1 instanceof ArchivedThreadsStore.ThreadListingState.Listing) {
            StoreUser storeUser = this.$storeUser;
            List<Channel> threads = ((ArchivedThreadsStore.ThreadListingState.Listing) threadListingStateComponent1).getThreads();
            ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(threads, 10));
            Iterator<T> it = threads.iterator();
            while (it.hasNext()) {
                arrayList.add(Long.valueOf(((Channel) it.next()).getOwnerId()));
            }
            scalarSynchronousObservable = storeUser.observeUsers(arrayList);
        } else {
            scalarSynchronousObservable = new ScalarSynchronousObservable(Maps6.emptyMap());
        }
        Observable<R> observableG = this.$storeGuilds.observeComputed().G(new AnonymousClass1());
        Intrinsics3.checkNotNullExpressionValue(observableG, "storeGuilds\n            …[guildId] ?: emptyMap() }");
        Observable<T> observableR = ObservableExtensionsKt.leadingEdgeThrottle(observableG, 1L, TimeUnit.SECONDS).r();
        Observable<Guild> observableObserveGuild = this.$storeGuilds.observeGuild(this.$guildId);
        StorePermissions storePermissions = this.$storePermissions;
        Long lValueOf = channelComponent2 != null ? Long.valueOf(channelComponent2.getParentId()) : null;
        Objects.requireNonNull(lValueOf, "null cannot be cast to non-null type com.discord.primitives.Snowflake /* = kotlin.Long */");
        return Observable.h(observableR, observableObserveGuild, scalarSynchronousObservable, storePermissions.observePermissionsForChannel(lValueOf.longValue()), new AnonymousClass2(threadListingStateComponent1, channelComponent2));
    }
}

package com.discord.widgets.channels.memberlist;

import androidx.core.app.NotificationCompat;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.api.role.GuildRole;
import com.discord.models.domain.ModelApplicationStream;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.guild.Guild;
import com.discord.models.member.GuildMember;
import com.discord.models.presence.Presence;
import com.discord.models.user.User;
import com.discord.stores.StoreApplicationStreaming;
import com.discord.stores.StoreChannelMembers;
import com.discord.stores.StoreChannels;
import com.discord.stores.StoreGuilds;
import com.discord.stores.StorePermissions;
import com.discord.stores.StoreThreadMembers;
import com.discord.stores.StoreThreadsJoined;
import com.discord.stores.StoreUser;
import com.discord.stores.StoreUserPresence;
import com.discord.stores.StoreUserRelationships;
import com.discord.utilities.lazy.memberlist.ChannelMemberList;
import com.discord.widgets.channels.memberlist.PrivateChannelMemberListService;
import com.discord.widgets.channels.memberlist.WidgetChannelMembersListViewModel;
import d0.z.d.Intrinsics3;
import j0.k.Func1;
import java.util.Map;
import java.util.Set;
import rx.Observable;
import rx.functions.Func2;
import rx.functions.Func5;
import rx.functions.Func9;

/* compiled from: WidgetChannelMembersListViewModel.kt */
/* renamed from: com.discord.widgets.channels.memberlist.WidgetChannelMembersListViewModel$Companion$observeStoreState$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetChannelMembersListViewModel2<T, R> implements Func1<Channel, Observable<? extends WidgetChannelMembersListViewModel.StoreState>> {
    public final /* synthetic */ Observable $isPanelOpenObservable;
    public final /* synthetic */ PrivateChannelMemberListService $privateChannelMemberListService;
    public final /* synthetic */ StoreApplicationStreaming $storeApplicationStreaming;
    public final /* synthetic */ StoreChannelMembers $storeChannelMembers;
    public final /* synthetic */ StoreChannels $storeChannels;
    public final /* synthetic */ StoreGuilds $storeGuilds;
    public final /* synthetic */ StorePermissions $storePermissions;
    public final /* synthetic */ StoreUserPresence $storePresence;
    public final /* synthetic */ StoreThreadMembers $storeThreadMembers;
    public final /* synthetic */ StoreThreadsJoined $storeThreadsJoined;
    public final /* synthetic */ StoreUser $storeUser;
    public final /* synthetic */ StoreUserRelationships $storeUserRelationships;

    /* compiled from: WidgetChannelMembersListViewModel.kt */
    /* renamed from: com.discord.widgets.channels.memberlist.WidgetChannelMembersListViewModel$Companion$observeStoreState$1$1, reason: invalid class name */
    public static final class AnonymousClass1<T, R> implements Func1<Boolean, WidgetChannelMembersListViewModel.StoreState.None> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        @Override // j0.k.Func1
        public /* bridge */ /* synthetic */ WidgetChannelMembersListViewModel.StoreState.None call(Boolean bool) {
            return call2(bool);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final WidgetChannelMembersListViewModel.StoreState.None call2(Boolean bool) {
            Intrinsics3.checkNotNullExpressionValue(bool, "isPanelOpen");
            return new WidgetChannelMembersListViewModel.StoreState.None(bool.booleanValue());
        }
    }

    /* compiled from: WidgetChannelMembersListViewModel.kt */
    /* renamed from: com.discord.widgets.channels.memberlist.WidgetChannelMembersListViewModel$Companion$observeStoreState$1$2, reason: invalid class name */
    public static final class AnonymousClass2<T1, T2, R> implements Func2<PrivateChannelMemberListService.State, Boolean, WidgetChannelMembersListViewModel.StoreState.Private> {
        public AnonymousClass2() {
        }

        @Override // rx.functions.Func2
        public /* bridge */ /* synthetic */ WidgetChannelMembersListViewModel.StoreState.Private call(PrivateChannelMemberListService.State state, Boolean bool) {
            return call2(state, bool);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final WidgetChannelMembersListViewModel.StoreState.Private call2(PrivateChannelMemberListService.State state, Boolean bool) {
            Intrinsics3.checkNotNullExpressionValue(bool, "isPanelOpen");
            return new WidgetChannelMembersListViewModel.StoreState.Private(bool.booleanValue(), state.getChannel(), state.getUsers(), state.getPresences(), state.getApplicationStreams(), WidgetChannelMembersListViewModel2.this.$storeUserRelationships.getRelationships());
        }
    }

    /* compiled from: WidgetChannelMembersListViewModel.kt */
    /* renamed from: com.discord.widgets.channels.memberlist.WidgetChannelMembersListViewModel$Companion$observeStoreState$1$3, reason: invalid class name */
    public static final class AnonymousClass3<T, R> implements Func1<Channel, Observable<? extends WidgetChannelMembersListViewModel.StoreState>> {
        public final /* synthetic */ Channel $channel;

        /* compiled from: WidgetChannelMembersListViewModel.kt */
        /* renamed from: com.discord.widgets.channels.memberlist.WidgetChannelMembersListViewModel$Companion$observeStoreState$1$3$1, reason: invalid class name */
        public static final class AnonymousClass1<T, R> implements Func1<Boolean, WidgetChannelMembersListViewModel.StoreState.None> {
            public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

            @Override // j0.k.Func1
            public /* bridge */ /* synthetic */ WidgetChannelMembersListViewModel.StoreState.None call(Boolean bool) {
                return call2(bool);
            }

            /* renamed from: call, reason: avoid collision after fix types in other method */
            public final WidgetChannelMembersListViewModel.StoreState.None call2(Boolean bool) {
                Intrinsics3.checkNotNullExpressionValue(bool, "isPanelOpen");
                return new WidgetChannelMembersListViewModel.StoreState.None(bool.booleanValue());
            }
        }

        /* compiled from: WidgetChannelMembersListViewModel.kt */
        /* renamed from: com.discord.widgets.channels.memberlist.WidgetChannelMembersListViewModel$Companion$observeStoreState$1$3$2, reason: invalid class name */
        public static final class AnonymousClass2<T1, T2, T3, T4, T5, R> implements Func5<Long, ChannelMemberList, Boolean, Map<Long, ? extends GuildRole>, Guild, WidgetChannelMembersListViewModel.StoreState.Guild> {
            public final /* synthetic */ Channel $parentChannel;

            public AnonymousClass2(Channel channel) {
                this.$parentChannel = channel;
            }

            @Override // rx.functions.Func5
            public /* bridge */ /* synthetic */ WidgetChannelMembersListViewModel.StoreState.Guild call(Long l, ChannelMemberList channelMemberList, Boolean bool, Map<Long, ? extends GuildRole> map, Guild guild) {
                return call2(l, channelMemberList, bool, (Map<Long, GuildRole>) map, guild);
            }

            /* renamed from: call, reason: avoid collision after fix types in other method */
            public final WidgetChannelMembersListViewModel.StoreState.Guild call2(Long l, ChannelMemberList channelMemberList, Boolean bool, Map<Long, GuildRole> map, Guild guild) {
                Intrinsics3.checkNotNullExpressionValue(bool, "isPanelOpen");
                boolean zBooleanValue = bool.booleanValue();
                Channel channel = this.$parentChannel;
                Intrinsics3.checkNotNullExpressionValue(channelMemberList, "channelMemberList");
                Intrinsics3.checkNotNullExpressionValue(map, "roles");
                return new WidgetChannelMembersListViewModel.StoreState.Guild(zBooleanValue, channel, guild, channelMemberList, l, map);
            }
        }

        /* compiled from: WidgetChannelMembersListViewModel.kt */
        /* renamed from: com.discord.widgets.channels.memberlist.WidgetChannelMembersListViewModel$Companion$observeStoreState$1$3$3, reason: invalid class name and collision with other inner class name */
        public static final class C02473<T1, T2, T3, T4, T5, T6, T7, T8, T9, R> implements Func9<Set<? extends Long>, Boolean, Map<Long, ? extends GuildRole>, Map<Long, ? extends GuildMember>, Guild, Map<Long, ? extends User>, Map<Long, ? extends Presence>, Map<Long, ? extends ModelApplicationStream>, StoreThreadsJoined.JoinedThread, WidgetChannelMembersListViewModel.StoreState.Thread> {
            public final /* synthetic */ Channel $parentChannel;

            public C02473(Channel channel) {
                this.$parentChannel = channel;
            }

            @Override // rx.functions.Func9
            public /* bridge */ /* synthetic */ WidgetChannelMembersListViewModel.StoreState.Thread call(Set<? extends Long> set, Boolean bool, Map<Long, ? extends GuildRole> map, Map<Long, ? extends GuildMember> map2, Guild guild, Map<Long, ? extends User> map3, Map<Long, ? extends Presence> map4, Map<Long, ? extends ModelApplicationStream> map5, StoreThreadsJoined.JoinedThread joinedThread) {
                return call2((Set<Long>) set, bool, (Map<Long, GuildRole>) map, (Map<Long, GuildMember>) map2, guild, map3, (Map<Long, Presence>) map4, map5, joinedThread);
            }

            /* renamed from: call, reason: avoid collision after fix types in other method */
            public final WidgetChannelMembersListViewModel.StoreState.Thread call2(Set<Long> set, Boolean bool, Map<Long, GuildRole> map, Map<Long, GuildMember> map2, Guild guild, Map<Long, ? extends User> map3, Map<Long, Presence> map4, Map<Long, ? extends ModelApplicationStream> map5, StoreThreadsJoined.JoinedThread joinedThread) {
                Intrinsics3.checkNotNullExpressionValue(bool, "isPanelOpen");
                boolean zBooleanValue = bool.booleanValue();
                Channel channel = AnonymousClass3.this.$channel;
                Channel channel2 = this.$parentChannel;
                Intrinsics3.checkNotNullExpressionValue(map, "roles");
                Intrinsics3.checkNotNullExpressionValue(map2, "guildMembers");
                Intrinsics3.checkNotNullExpressionValue(map3, "users");
                Intrinsics3.checkNotNullExpressionValue(map4, "presences");
                Intrinsics3.checkNotNullExpressionValue(map5, "streams");
                Intrinsics3.checkNotNullExpressionValue(set, "threadMembers");
                return new WidgetChannelMembersListViewModel.StoreState.Thread(zBooleanValue, channel, channel2, guild, map, map2, map3, map4, map5, set, joinedThread);
            }
        }

        public AnonymousClass3(Channel channel) {
            this.$channel = channel;
        }

        @Override // j0.k.Func1
        public /* bridge */ /* synthetic */ Observable<? extends WidgetChannelMembersListViewModel.StoreState> call(Channel channel) {
            return call2(channel);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final Observable<? extends WidgetChannelMembersListViewModel.StoreState> call2(Channel channel) {
            if (channel == null) {
                return WidgetChannelMembersListViewModel2.this.$isPanelOpenObservable.G(AnonymousClass1.INSTANCE);
            }
            if (!ChannelUtils.i(channel)) {
                Observable<Set<Long>> observableObserveThreadMembers = WidgetChannelMembersListViewModel2.this.$storeThreadMembers.observeThreadMembers(this.$channel.getId());
                WidgetChannelMembersListViewModel2 widgetChannelMembersListViewModel2 = WidgetChannelMembersListViewModel2.this;
                return Observable.c(observableObserveThreadMembers, widgetChannelMembersListViewModel2.$isPanelOpenObservable, widgetChannelMembersListViewModel2.$storeGuilds.observeRoles(this.$channel.getGuildId()), WidgetChannelMembersListViewModel2.this.$storeGuilds.observeGuildMembers(this.$channel.getGuildId()), WidgetChannelMembersListViewModel2.this.$storeGuilds.observeGuild(this.$channel.getGuildId()), WidgetChannelMembersListViewModel2.this.$storeUser.observeAllUsers(), WidgetChannelMembersListViewModel2.this.$storePresence.observeAllPresences(), WidgetChannelMembersListViewModel2.this.$storeApplicationStreaming.observeStreamsByUser(), WidgetChannelMembersListViewModel2.this.$storeThreadsJoined.observeJoinedThread(this.$channel.getId()), new C02473(channel));
            }
            Observable<Long> observableObservePermissionsForChannel = WidgetChannelMembersListViewModel2.this.$storePermissions.observePermissionsForChannel(channel.getId());
            Observable<ChannelMemberList> observableObserveChannelMemberList = WidgetChannelMembersListViewModel2.this.$storeChannelMembers.observeChannelMemberList(channel.getGuildId(), channel.getId());
            WidgetChannelMembersListViewModel2 widgetChannelMembersListViewModel22 = WidgetChannelMembersListViewModel2.this;
            return Observable.g(observableObservePermissionsForChannel, observableObserveChannelMemberList, widgetChannelMembersListViewModel22.$isPanelOpenObservable, widgetChannelMembersListViewModel22.$storeGuilds.observeRoles(this.$channel.getGuildId()), WidgetChannelMembersListViewModel2.this.$storeGuilds.observeGuild(this.$channel.getGuildId()), new AnonymousClass2(channel));
        }
    }

    /* compiled from: WidgetChannelMembersListViewModel.kt */
    /* renamed from: com.discord.widgets.channels.memberlist.WidgetChannelMembersListViewModel$Companion$observeStoreState$1$4, reason: invalid class name */
    public static final class AnonymousClass4<T1, T2, T3, T4, T5, R> implements Func5<Guild, Map<Long, ? extends GuildRole>, Long, ChannelMemberList, Boolean, WidgetChannelMembersListViewModel.StoreState.Guild> {
        public final /* synthetic */ Channel $channel;

        public AnonymousClass4(Channel channel) {
            this.$channel = channel;
        }

        @Override // rx.functions.Func5
        public /* bridge */ /* synthetic */ WidgetChannelMembersListViewModel.StoreState.Guild call(Guild guild, Map<Long, ? extends GuildRole> map, Long l, ChannelMemberList channelMemberList, Boolean bool) {
            return call2(guild, (Map<Long, GuildRole>) map, l, channelMemberList, bool);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final WidgetChannelMembersListViewModel.StoreState.Guild call2(Guild guild, Map<Long, GuildRole> map, Long l, ChannelMemberList channelMemberList, Boolean bool) {
            Intrinsics3.checkNotNullExpressionValue(bool, "isPanelOpen");
            boolean zBooleanValue = bool.booleanValue();
            Channel channel = this.$channel;
            Intrinsics3.checkNotNullExpressionValue(channelMemberList, "channelMemberList");
            Intrinsics3.checkNotNullExpressionValue(map, "guildRoles");
            return new WidgetChannelMembersListViewModel.StoreState.Guild(zBooleanValue, channel, guild, channelMemberList, l, map);
        }
    }

    public WidgetChannelMembersListViewModel2(Observable observable, PrivateChannelMemberListService privateChannelMemberListService, StoreUserRelationships storeUserRelationships, StoreChannels storeChannels, StorePermissions storePermissions, StoreChannelMembers storeChannelMembers, StoreGuilds storeGuilds, StoreThreadMembers storeThreadMembers, StoreUser storeUser, StoreUserPresence storeUserPresence, StoreApplicationStreaming storeApplicationStreaming, StoreThreadsJoined storeThreadsJoined) {
        this.$isPanelOpenObservable = observable;
        this.$privateChannelMemberListService = privateChannelMemberListService;
        this.$storeUserRelationships = storeUserRelationships;
        this.$storeChannels = storeChannels;
        this.$storePermissions = storePermissions;
        this.$storeChannelMembers = storeChannelMembers;
        this.$storeGuilds = storeGuilds;
        this.$storeThreadMembers = storeThreadMembers;
        this.$storeUser = storeUser;
        this.$storePresence = storeUserPresence;
        this.$storeApplicationStreaming = storeApplicationStreaming;
        this.$storeThreadsJoined = storeThreadsJoined;
    }

    @Override // j0.k.Func1
    public /* bridge */ /* synthetic */ Observable<? extends WidgetChannelMembersListViewModel.StoreState> call(Channel channel) {
        return call2(channel);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends WidgetChannelMembersListViewModel.StoreState> call2(Channel channel) {
        return channel == null ? this.$isPanelOpenObservable.G(AnonymousClass1.INSTANCE) : ChannelUtils.B(channel) ? Observable.j(this.$privateChannelMemberListService.observeStateForGroupDm(channel), this.$isPanelOpenObservable, new AnonymousClass2()) : ChannelUtils.H(channel) ? this.$storeChannels.observeChannel(channel.getParentId()).Y(new AnonymousClass3(channel)) : Observable.g(this.$storeGuilds.observeGuild(channel.getGuildId()), this.$storeGuilds.observeRoles(channel.getGuildId()), this.$storePermissions.observePermissionsForChannel(channel.getId()), this.$storeChannelMembers.observeChannelMemberList(channel.getGuildId(), channel.getId()), this.$isPanelOpenObservable, new AnonymousClass4(channel));
    }
}

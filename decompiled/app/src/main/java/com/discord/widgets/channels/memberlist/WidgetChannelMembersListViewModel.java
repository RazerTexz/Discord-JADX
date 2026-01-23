package com.discord.widgets.channels.memberlist;

import android.content.Context;
import androidx.annotation.MainThread;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.api.role.GuildRole;
import com.discord.models.domain.ModelApplicationStream;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.domain.ModelUserRelationship;
import com.discord.models.member.GuildMember;
import com.discord.models.presence.Presence;
import com.discord.models.user.User;
import com.discord.restapi.RestAPIParams;
import com.discord.stores.StoreApplicationStreaming;
import com.discord.stores.StoreChannelMembers;
import com.discord.stores.StoreChannels;
import com.discord.stores.StoreChannelsSelected;
import com.discord.stores.StoreEmojiCustom;
import com.discord.stores.StoreGuilds;
import com.discord.stores.StoreNavigation;
import com.discord.stores.StorePermissions;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreThreadMembers;
import com.discord.stores.StoreThreadsJoined;
import com.discord.stores.StoreUser;
import com.discord.stores.StoreUserPresence;
import com.discord.stores.StoreUserRelationships;
import com.discord.utilities.error.Error;
import com.discord.utilities.lazy.memberlist.ChannelMemberList;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.permissions.PermissionUtils;
import com.discord.utilities.rest.RestAPI;
import com.discord.widgets.channels.memberlist.adapter.ChannelMembersListAdapter;
import java.util.Map;
import java.util.Set;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.ranges.Ranges2;
import p007b.p008a.p018d.AppViewModel;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;
import p658rx.Observable;
import p658rx.subjects.PublishSubject;

/* JADX INFO: compiled from: WidgetChannelMembersListViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChannelMembersListViewModel extends AppViewModel<ViewState> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final PublishSubject<Event> eventSubject;
    private final GuildChannelSubscriber guildChannelSubscriber;
    private final StoreEmojiCustom storeCustomEmojis;
    private final StoreGuilds storeGuilds;

    /* JADX INFO: renamed from: com.discord.widgets.channels.memberlist.WidgetChannelMembersListViewModel$1 */
    /* JADX INFO: compiled from: WidgetChannelMembersListViewModel.kt */
    public static final class C74941 implements GuildChannelSubscriber {
        @Override // com.discord.widgets.channels.memberlist.WidgetChannelMembersListViewModel.GuildChannelSubscriber
        public void subscribeToChannelRange(Channel channel, Ranges2 range) {
            Intrinsics3.checkNotNullParameter(channel, "channel");
            Intrinsics3.checkNotNullParameter(range, "range");
            StoreStream.INSTANCE.getGuildSubscriptions().subscribeChannelRange(channel.getGuildId(), channel.getId(), range);
        }

        @Override // com.discord.widgets.channels.memberlist.WidgetChannelMembersListViewModel.GuildChannelSubscriber
        public void subscribeToThread(Channel channel) {
            Intrinsics3.checkNotNullParameter(channel, "channel");
            StoreStream.INSTANCE.getGuildSubscriptions().subscribeThread(channel.getGuildId(), channel.getId());
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.channels.memberlist.WidgetChannelMembersListViewModel$2 */
    /* JADX INFO: compiled from: WidgetChannelMembersListViewModel.kt */
    public static final class C74952 extends Lambda implements Function1<StoreState, Unit> {
        public C74952() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(StoreState storeState) {
            invoke2(storeState);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(StoreState storeState) {
            Intrinsics3.checkNotNullParameter(storeState, "storeState");
            WidgetChannelMembersListViewModel.access$handleStoreState(WidgetChannelMembersListViewModel.this, storeState);
        }
    }

    /* JADX INFO: compiled from: WidgetChannelMembersListViewModel.kt */
    public static final class Companion {
        private Companion() {
        }

        private final Observable<StoreState> observeStoreState(StoreGuilds storeGuilds, StoreChannelMembers storeChannelMembers, StoreThreadMembers storeThreadMembers, StoreChannelsSelected storeChannelsSelected, StoreNavigation storeNavigation, PrivateChannelMemberListService privateChannelMemberListService, StorePermissions storePermissions, StoreUserRelationships storeUserRelationships, StoreChannels storeChannels, StoreUser storeUser, StoreUserPresence storePresence, StoreApplicationStreaming storeApplicationStreaming, StoreThreadsJoined storeThreadsJoined) {
            Observable observableM11099Y = storeChannelsSelected.observeSelectedChannel().m11099Y(new WidgetChannelMembersListViewModel2(storeNavigation.observeRightPanelState().m11083G(WidgetChannelMembersListViewModel3.INSTANCE), privateChannelMemberListService, storeUserRelationships, storeChannels, storePermissions, storeChannelMembers, storeGuilds, storeThreadMembers, storeUser, storePresence, storeApplicationStreaming, storeThreadsJoined));
            Intrinsics3.checkNotNullExpressionValue(observableM11099Y, "storeChannelsSelected\n  …            }\n          }");
            return observableM11099Y;
        }

        public static /* synthetic */ Observable observeStoreState$default(Companion companion, StoreGuilds storeGuilds, StoreChannelMembers storeChannelMembers, StoreThreadMembers storeThreadMembers, StoreChannelsSelected storeChannelsSelected, StoreNavigation storeNavigation, PrivateChannelMemberListService privateChannelMemberListService, StorePermissions storePermissions, StoreUserRelationships storeUserRelationships, StoreChannels storeChannels, StoreUser storeUser, StoreUserPresence storeUserPresence, StoreApplicationStreaming storeApplicationStreaming, StoreThreadsJoined storeThreadsJoined, int i, Object obj) {
            return companion.observeStoreState((i & 1) != 0 ? StoreStream.INSTANCE.getGuilds() : storeGuilds, (i & 2) != 0 ? StoreStream.INSTANCE.getChannelMembers() : storeChannelMembers, (i & 4) != 0 ? StoreStream.INSTANCE.getThreadMembers() : storeThreadMembers, (i & 8) != 0 ? StoreStream.INSTANCE.getChannelsSelected() : storeChannelsSelected, (i & 16) != 0 ? StoreStream.INSTANCE.getNavigation() : storeNavigation, (i & 32) != 0 ? new PrivateChannelMemberListService(null, null, null, 7, null) : privateChannelMemberListService, (i & 64) != 0 ? StoreStream.INSTANCE.getPermissions() : storePermissions, (i & 128) != 0 ? StoreStream.INSTANCE.getUserRelationships() : storeUserRelationships, (i & 256) != 0 ? StoreStream.INSTANCE.getChannels() : storeChannels, (i & 512) != 0 ? StoreStream.INSTANCE.getUsers() : storeUser, (i & 1024) != 0 ? StoreStream.INSTANCE.getPresences() : storeUserPresence, (i & 2048) != 0 ? StoreStream.INSTANCE.getApplicationStreaming() : storeApplicationStreaming, (i & 4096) != 0 ? StoreStream.INSTANCE.getThreadsJoined() : storeThreadsJoined);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: WidgetChannelMembersListViewModel.kt */
    public static abstract class Event {

        /* JADX INFO: compiled from: WidgetChannelMembersListViewModel.kt */
        public static final /* data */ class Error extends Event {
            private final int code;

            public Error(int i) {
                super(null);
                this.code = i;
            }

            public static /* synthetic */ Error copy$default(Error error, int i, int i2, Object obj) {
                if ((i2 & 1) != 0) {
                    i = error.code;
                }
                return error.copy(i);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final int getCode() {
                return this.code;
            }

            public final Error copy(int code) {
                return new Error(code);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof Error) && this.code == ((Error) other).code;
                }
                return true;
            }

            public final int getCode() {
                return this.code;
            }

            public int hashCode() {
                return this.code;
            }

            public String toString() {
                return outline.m814B(outline.m833U("Error(code="), this.code, ")");
            }
        }

        /* JADX INFO: compiled from: WidgetChannelMembersListViewModel.kt */
        public static final class ScrollToTop extends Event {
            public static final ScrollToTop INSTANCE = new ScrollToTop();

            private ScrollToTop() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: WidgetChannelMembersListViewModel.kt */
        public static final class UpdateRanges extends Event {
            public static final UpdateRanges INSTANCE = new UpdateRanges();

            private UpdateRanges() {
                super(null);
            }
        }

        private Event() {
        }

        public /* synthetic */ Event(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: WidgetChannelMembersListViewModel.kt */
    public interface GuildChannelSubscriber {
        void subscribeToChannelRange(Channel channel, Ranges2 range);

        void subscribeToThread(Channel channel);
    }

    /* JADX INFO: compiled from: WidgetChannelMembersListViewModel.kt */
    public interface MemberList {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = Companion.$$INSTANCE;

        /* JADX INFO: compiled from: WidgetChannelMembersListViewModel.kt */
        public static final class Companion {
            public static final /* synthetic */ Companion $$INSTANCE = new Companion();
            private static final MemberList EMPTY = new WidgetChannelMembersListViewModel4();

            private Companion() {
            }

            public final MemberList getEMPTY() {
                return EMPTY;
            }
        }

        ChannelMembersListAdapter.Item get(int index);

        Integer getHeaderPositionForItem(int itemPosition);

        String getListId();

        int getSize();
    }

    /* JADX INFO: compiled from: WidgetChannelMembersListViewModel.kt */
    public static abstract class StoreState {
        private final Channel channel;
        private final boolean isPanelOpen;

        /* JADX INFO: compiled from: WidgetChannelMembersListViewModel.kt */
        public static final /* data */ class Guild extends StoreState {
            private final Channel channel;
            private final ChannelMemberList channelMembers;
            private final Long channelPermissions;
            private final com.discord.models.guild.Guild guild;
            private final Map<Long, GuildRole> guildRoles;
            private final boolean isPanelOpen;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Guild(boolean z2, Channel channel, com.discord.models.guild.Guild guild, ChannelMemberList channelMemberList, Long l, Map<Long, GuildRole> map) {
                super(z2, channel, null);
                Intrinsics3.checkNotNullParameter(channel, "channel");
                Intrinsics3.checkNotNullParameter(channelMemberList, "channelMembers");
                Intrinsics3.checkNotNullParameter(map, "guildRoles");
                this.isPanelOpen = z2;
                this.channel = channel;
                this.guild = guild;
                this.channelMembers = channelMemberList;
                this.channelPermissions = l;
                this.guildRoles = map;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ Guild copy$default(Guild guild, boolean z2, Channel channel, com.discord.models.guild.Guild guild2, ChannelMemberList channelMemberList, Long l, Map map, int i, Object obj) {
                if ((i & 1) != 0) {
                    z2 = guild.getIsPanelOpen();
                }
                if ((i & 2) != 0) {
                    channel = guild.getChannel();
                }
                Channel channel2 = channel;
                if ((i & 4) != 0) {
                    guild2 = guild.guild;
                }
                com.discord.models.guild.Guild guild3 = guild2;
                if ((i & 8) != 0) {
                    channelMemberList = guild.channelMembers;
                }
                ChannelMemberList channelMemberList2 = channelMemberList;
                if ((i & 16) != 0) {
                    l = guild.channelPermissions;
                }
                Long l2 = l;
                if ((i & 32) != 0) {
                    map = guild.guildRoles;
                }
                return guild.copy(z2, channel2, guild3, channelMemberList2, l2, map);
            }

            public final boolean component1() {
                return getIsPanelOpen();
            }

            public final Channel component2() {
                return getChannel();
            }

            /* JADX INFO: renamed from: component3, reason: from getter */
            public final com.discord.models.guild.Guild getGuild() {
                return this.guild;
            }

            /* JADX INFO: renamed from: component4, reason: from getter */
            public final ChannelMemberList getChannelMembers() {
                return this.channelMembers;
            }

            /* JADX INFO: renamed from: component5, reason: from getter */
            public final Long getChannelPermissions() {
                return this.channelPermissions;
            }

            public final Map<Long, GuildRole> component6() {
                return this.guildRoles;
            }

            public final Guild copy(boolean isPanelOpen, Channel channel, com.discord.models.guild.Guild guild, ChannelMemberList channelMembers, Long channelPermissions, Map<Long, GuildRole> guildRoles) {
                Intrinsics3.checkNotNullParameter(channel, "channel");
                Intrinsics3.checkNotNullParameter(channelMembers, "channelMembers");
                Intrinsics3.checkNotNullParameter(guildRoles, "guildRoles");
                return new Guild(isPanelOpen, channel, guild, channelMembers, channelPermissions, guildRoles);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Guild)) {
                    return false;
                }
                Guild guild = (Guild) other;
                return getIsPanelOpen() == guild.getIsPanelOpen() && Intrinsics3.areEqual(getChannel(), guild.getChannel()) && Intrinsics3.areEqual(this.guild, guild.guild) && Intrinsics3.areEqual(this.channelMembers, guild.channelMembers) && Intrinsics3.areEqual(this.channelPermissions, guild.channelPermissions) && Intrinsics3.areEqual(this.guildRoles, guild.guildRoles);
            }

            @Override // com.discord.widgets.channels.memberlist.WidgetChannelMembersListViewModel.StoreState
            public Channel getChannel() {
                return this.channel;
            }

            public final ChannelMemberList getChannelMembers() {
                return this.channelMembers;
            }

            public final Long getChannelPermissions() {
                return this.channelPermissions;
            }

            public final com.discord.models.guild.Guild getGuild() {
                return this.guild;
            }

            public final Map<Long, GuildRole> getGuildRoles() {
                return this.guildRoles;
            }

            public int hashCode() {
                boolean isPanelOpen = getIsPanelOpen();
                int i = isPanelOpen;
                if (isPanelOpen) {
                    i = 1;
                }
                int i2 = i * 31;
                Channel channel = getChannel();
                int iHashCode = (i2 + (channel != null ? channel.hashCode() : 0)) * 31;
                com.discord.models.guild.Guild guild = this.guild;
                int iHashCode2 = (iHashCode + (guild != null ? guild.hashCode() : 0)) * 31;
                ChannelMemberList channelMemberList = this.channelMembers;
                int iHashCode3 = (iHashCode2 + (channelMemberList != null ? channelMemberList.hashCode() : 0)) * 31;
                Long l = this.channelPermissions;
                int iHashCode4 = (iHashCode3 + (l != null ? l.hashCode() : 0)) * 31;
                Map<Long, GuildRole> map = this.guildRoles;
                return iHashCode4 + (map != null ? map.hashCode() : 0);
            }

            @Override // com.discord.widgets.channels.memberlist.WidgetChannelMembersListViewModel.StoreState
            /* JADX INFO: renamed from: isPanelOpen, reason: from getter */
            public boolean getIsPanelOpen() {
                return this.isPanelOpen;
            }

            public String toString() {
                StringBuilder sbM833U = outline.m833U("Guild(isPanelOpen=");
                sbM833U.append(getIsPanelOpen());
                sbM833U.append(", channel=");
                sbM833U.append(getChannel());
                sbM833U.append(", guild=");
                sbM833U.append(this.guild);
                sbM833U.append(", channelMembers=");
                sbM833U.append(this.channelMembers);
                sbM833U.append(", channelPermissions=");
                sbM833U.append(this.channelPermissions);
                sbM833U.append(", guildRoles=");
                return outline.m825M(sbM833U, this.guildRoles, ")");
            }
        }

        /* JADX INFO: compiled from: WidgetChannelMembersListViewModel.kt */
        public static final /* data */ class None extends StoreState {
            private final boolean isPanelOpen;

            public None(boolean z2) {
                super(z2, null, null);
                this.isPanelOpen = z2;
            }

            public static /* synthetic */ None copy$default(None none, boolean z2, int i, Object obj) {
                if ((i & 1) != 0) {
                    z2 = none.getIsPanelOpen();
                }
                return none.copy(z2);
            }

            public final boolean component1() {
                return getIsPanelOpen();
            }

            public final None copy(boolean isPanelOpen) {
                return new None(isPanelOpen);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof None) && getIsPanelOpen() == ((None) other).getIsPanelOpen();
                }
                return true;
            }

            public int hashCode() {
                boolean isPanelOpen = getIsPanelOpen();
                if (isPanelOpen) {
                    return 1;
                }
                return isPanelOpen ? 1 : 0;
            }

            @Override // com.discord.widgets.channels.memberlist.WidgetChannelMembersListViewModel.StoreState
            /* JADX INFO: renamed from: isPanelOpen, reason: from getter */
            public boolean getIsPanelOpen() {
                return this.isPanelOpen;
            }

            public String toString() {
                StringBuilder sbM833U = outline.m833U("None(isPanelOpen=");
                sbM833U.append(getIsPanelOpen());
                sbM833U.append(")");
                return sbM833U.toString();
            }
        }

        /* JADX INFO: compiled from: WidgetChannelMembersListViewModel.kt */
        public static final /* data */ class Private extends StoreState {
            private final Map<Long, ModelApplicationStream> applicationStreams;
            private final Channel channel;
            private final boolean isPanelOpen;
            private final Map<Long, Presence> presences;
            private final Map<Long, Integer> relationships;
            private final Map<Long, User> users;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            public Private(boolean z2, Channel channel, Map<Long, ? extends User> map, Map<Long, Presence> map2, Map<Long, ? extends ModelApplicationStream> map3, Map<Long, Integer> map4) {
                super(z2, channel, null);
                Intrinsics3.checkNotNullParameter(channel, "channel");
                Intrinsics3.checkNotNullParameter(map, "users");
                Intrinsics3.checkNotNullParameter(map2, "presences");
                Intrinsics3.checkNotNullParameter(map3, "applicationStreams");
                Intrinsics3.checkNotNullParameter(map4, "relationships");
                this.isPanelOpen = z2;
                this.channel = channel;
                this.users = map;
                this.presences = map2;
                this.applicationStreams = map3;
                this.relationships = map4;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ Private copy$default(Private r4, boolean z2, Channel channel, Map map, Map map2, Map map3, Map map4, int i, Object obj) {
                if ((i & 1) != 0) {
                    z2 = r4.getIsPanelOpen();
                }
                if ((i & 2) != 0) {
                    channel = r4.getChannel();
                }
                Channel channel2 = channel;
                if ((i & 4) != 0) {
                    map = r4.users;
                }
                Map map5 = map;
                if ((i & 8) != 0) {
                    map2 = r4.presences;
                }
                Map map6 = map2;
                if ((i & 16) != 0) {
                    map3 = r4.applicationStreams;
                }
                Map map7 = map3;
                if ((i & 32) != 0) {
                    map4 = r4.relationships;
                }
                return r4.copy(z2, channel2, map5, map6, map7, map4);
            }

            public final boolean component1() {
                return getIsPanelOpen();
            }

            public final Channel component2() {
                return getChannel();
            }

            public final Map<Long, User> component3() {
                return this.users;
            }

            public final Map<Long, Presence> component4() {
                return this.presences;
            }

            public final Map<Long, ModelApplicationStream> component5() {
                return this.applicationStreams;
            }

            public final Map<Long, Integer> component6() {
                return this.relationships;
            }

            public final Private copy(boolean isPanelOpen, Channel channel, Map<Long, ? extends User> users, Map<Long, Presence> presences, Map<Long, ? extends ModelApplicationStream> applicationStreams, Map<Long, Integer> relationships) {
                Intrinsics3.checkNotNullParameter(channel, "channel");
                Intrinsics3.checkNotNullParameter(users, "users");
                Intrinsics3.checkNotNullParameter(presences, "presences");
                Intrinsics3.checkNotNullParameter(applicationStreams, "applicationStreams");
                Intrinsics3.checkNotNullParameter(relationships, "relationships");
                return new Private(isPanelOpen, channel, users, presences, applicationStreams, relationships);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Private)) {
                    return false;
                }
                Private r3 = (Private) other;
                return getIsPanelOpen() == r3.getIsPanelOpen() && Intrinsics3.areEqual(getChannel(), r3.getChannel()) && Intrinsics3.areEqual(this.users, r3.users) && Intrinsics3.areEqual(this.presences, r3.presences) && Intrinsics3.areEqual(this.applicationStreams, r3.applicationStreams) && Intrinsics3.areEqual(this.relationships, r3.relationships);
            }

            public final Map<Long, ModelApplicationStream> getApplicationStreams() {
                return this.applicationStreams;
            }

            @Override // com.discord.widgets.channels.memberlist.WidgetChannelMembersListViewModel.StoreState
            public Channel getChannel() {
                return this.channel;
            }

            public final Map<Long, Presence> getPresences() {
                return this.presences;
            }

            public final Map<Long, Integer> getRelationships() {
                return this.relationships;
            }

            public final Map<Long, User> getUsers() {
                return this.users;
            }

            public int hashCode() {
                boolean isPanelOpen = getIsPanelOpen();
                int i = isPanelOpen;
                if (isPanelOpen) {
                    i = 1;
                }
                int i2 = i * 31;
                Channel channel = getChannel();
                int iHashCode = (i2 + (channel != null ? channel.hashCode() : 0)) * 31;
                Map<Long, User> map = this.users;
                int iHashCode2 = (iHashCode + (map != null ? map.hashCode() : 0)) * 31;
                Map<Long, Presence> map2 = this.presences;
                int iHashCode3 = (iHashCode2 + (map2 != null ? map2.hashCode() : 0)) * 31;
                Map<Long, ModelApplicationStream> map3 = this.applicationStreams;
                int iHashCode4 = (iHashCode3 + (map3 != null ? map3.hashCode() : 0)) * 31;
                Map<Long, Integer> map4 = this.relationships;
                return iHashCode4 + (map4 != null ? map4.hashCode() : 0);
            }

            @Override // com.discord.widgets.channels.memberlist.WidgetChannelMembersListViewModel.StoreState
            /* JADX INFO: renamed from: isPanelOpen, reason: from getter */
            public boolean getIsPanelOpen() {
                return this.isPanelOpen;
            }

            public String toString() {
                StringBuilder sbM833U = outline.m833U("Private(isPanelOpen=");
                sbM833U.append(getIsPanelOpen());
                sbM833U.append(", channel=");
                sbM833U.append(getChannel());
                sbM833U.append(", users=");
                sbM833U.append(this.users);
                sbM833U.append(", presences=");
                sbM833U.append(this.presences);
                sbM833U.append(", applicationStreams=");
                sbM833U.append(this.applicationStreams);
                sbM833U.append(", relationships=");
                return outline.m825M(sbM833U, this.relationships, ")");
            }
        }

        /* JADX INFO: compiled from: WidgetChannelMembersListViewModel.kt */
        public static final /* data */ class Thread extends StoreState {
            private final Channel channel;
            private final com.discord.models.guild.Guild guild;
            private final Map<Long, GuildMember> guildMembers;
            private final boolean isPanelOpen;
            private final StoreThreadsJoined.JoinedThread joinedThread;
            private final Channel parentChannel;
            private final Map<Long, Presence> presences;
            private final Map<Long, GuildRole> roles;
            private final Map<Long, ModelApplicationStream> streams;
            private final Set<Long> threadMembers;
            private final Map<Long, User> users;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            public Thread(boolean z2, Channel channel, Channel channel2, com.discord.models.guild.Guild guild, Map<Long, GuildRole> map, Map<Long, GuildMember> map2, Map<Long, ? extends User> map3, Map<Long, Presence> map4, Map<Long, ? extends ModelApplicationStream> map5, Set<Long> set, StoreThreadsJoined.JoinedThread joinedThread) {
                super(z2, channel, null);
                Intrinsics3.checkNotNullParameter(channel, "channel");
                Intrinsics3.checkNotNullParameter(map, "roles");
                Intrinsics3.checkNotNullParameter(map2, "guildMembers");
                Intrinsics3.checkNotNullParameter(map3, "users");
                Intrinsics3.checkNotNullParameter(map4, "presences");
                Intrinsics3.checkNotNullParameter(map5, "streams");
                Intrinsics3.checkNotNullParameter(set, "threadMembers");
                this.isPanelOpen = z2;
                this.channel = channel;
                this.parentChannel = channel2;
                this.guild = guild;
                this.roles = map;
                this.guildMembers = map2;
                this.users = map3;
                this.presences = map4;
                this.streams = map5;
                this.threadMembers = set;
                this.joinedThread = joinedThread;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ Thread copy$default(Thread thread, boolean z2, Channel channel, Channel channel2, com.discord.models.guild.Guild guild, Map map, Map map2, Map map3, Map map4, Map map5, Set set, StoreThreadsJoined.JoinedThread joinedThread, int i, Object obj) {
                return thread.copy((i & 1) != 0 ? thread.getIsPanelOpen() : z2, (i & 2) != 0 ? thread.getChannel() : channel, (i & 4) != 0 ? thread.parentChannel : channel2, (i & 8) != 0 ? thread.guild : guild, (i & 16) != 0 ? thread.roles : map, (i & 32) != 0 ? thread.guildMembers : map2, (i & 64) != 0 ? thread.users : map3, (i & 128) != 0 ? thread.presences : map4, (i & 256) != 0 ? thread.streams : map5, (i & 512) != 0 ? thread.threadMembers : set, (i & 1024) != 0 ? thread.joinedThread : joinedThread);
            }

            public final boolean component1() {
                return getIsPanelOpen();
            }

            public final Set<Long> component10() {
                return this.threadMembers;
            }

            /* JADX INFO: renamed from: component11, reason: from getter */
            public final StoreThreadsJoined.JoinedThread getJoinedThread() {
                return this.joinedThread;
            }

            public final Channel component2() {
                return getChannel();
            }

            /* JADX INFO: renamed from: component3, reason: from getter */
            public final Channel getParentChannel() {
                return this.parentChannel;
            }

            /* JADX INFO: renamed from: component4, reason: from getter */
            public final com.discord.models.guild.Guild getGuild() {
                return this.guild;
            }

            public final Map<Long, GuildRole> component5() {
                return this.roles;
            }

            public final Map<Long, GuildMember> component6() {
                return this.guildMembers;
            }

            public final Map<Long, User> component7() {
                return this.users;
            }

            public final Map<Long, Presence> component8() {
                return this.presences;
            }

            public final Map<Long, ModelApplicationStream> component9() {
                return this.streams;
            }

            public final Thread copy(boolean isPanelOpen, Channel channel, Channel parentChannel, com.discord.models.guild.Guild guild, Map<Long, GuildRole> roles, Map<Long, GuildMember> guildMembers, Map<Long, ? extends User> users, Map<Long, Presence> presences, Map<Long, ? extends ModelApplicationStream> streams, Set<Long> threadMembers, StoreThreadsJoined.JoinedThread joinedThread) {
                Intrinsics3.checkNotNullParameter(channel, "channel");
                Intrinsics3.checkNotNullParameter(roles, "roles");
                Intrinsics3.checkNotNullParameter(guildMembers, "guildMembers");
                Intrinsics3.checkNotNullParameter(users, "users");
                Intrinsics3.checkNotNullParameter(presences, "presences");
                Intrinsics3.checkNotNullParameter(streams, "streams");
                Intrinsics3.checkNotNullParameter(threadMembers, "threadMembers");
                return new Thread(isPanelOpen, channel, parentChannel, guild, roles, guildMembers, users, presences, streams, threadMembers, joinedThread);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Thread)) {
                    return false;
                }
                Thread thread = (Thread) other;
                return getIsPanelOpen() == thread.getIsPanelOpen() && Intrinsics3.areEqual(getChannel(), thread.getChannel()) && Intrinsics3.areEqual(this.parentChannel, thread.parentChannel) && Intrinsics3.areEqual(this.guild, thread.guild) && Intrinsics3.areEqual(this.roles, thread.roles) && Intrinsics3.areEqual(this.guildMembers, thread.guildMembers) && Intrinsics3.areEqual(this.users, thread.users) && Intrinsics3.areEqual(this.presences, thread.presences) && Intrinsics3.areEqual(this.streams, thread.streams) && Intrinsics3.areEqual(this.threadMembers, thread.threadMembers) && Intrinsics3.areEqual(this.joinedThread, thread.joinedThread);
            }

            @Override // com.discord.widgets.channels.memberlist.WidgetChannelMembersListViewModel.StoreState
            public Channel getChannel() {
                return this.channel;
            }

            public final com.discord.models.guild.Guild getGuild() {
                return this.guild;
            }

            public final Map<Long, GuildMember> getGuildMembers() {
                return this.guildMembers;
            }

            public final StoreThreadsJoined.JoinedThread getJoinedThread() {
                return this.joinedThread;
            }

            public final Channel getParentChannel() {
                return this.parentChannel;
            }

            public final Map<Long, Presence> getPresences() {
                return this.presences;
            }

            public final Map<Long, GuildRole> getRoles() {
                return this.roles;
            }

            public final Map<Long, ModelApplicationStream> getStreams() {
                return this.streams;
            }

            public final Set<Long> getThreadMembers() {
                return this.threadMembers;
            }

            public final Map<Long, User> getUsers() {
                return this.users;
            }

            public int hashCode() {
                boolean isPanelOpen = getIsPanelOpen();
                int i = isPanelOpen;
                if (isPanelOpen) {
                    i = 1;
                }
                int i2 = i * 31;
                Channel channel = getChannel();
                int iHashCode = (i2 + (channel != null ? channel.hashCode() : 0)) * 31;
                Channel channel2 = this.parentChannel;
                int iHashCode2 = (iHashCode + (channel2 != null ? channel2.hashCode() : 0)) * 31;
                com.discord.models.guild.Guild guild = this.guild;
                int iHashCode3 = (iHashCode2 + (guild != null ? guild.hashCode() : 0)) * 31;
                Map<Long, GuildRole> map = this.roles;
                int iHashCode4 = (iHashCode3 + (map != null ? map.hashCode() : 0)) * 31;
                Map<Long, GuildMember> map2 = this.guildMembers;
                int iHashCode5 = (iHashCode4 + (map2 != null ? map2.hashCode() : 0)) * 31;
                Map<Long, User> map3 = this.users;
                int iHashCode6 = (iHashCode5 + (map3 != null ? map3.hashCode() : 0)) * 31;
                Map<Long, Presence> map4 = this.presences;
                int iHashCode7 = (iHashCode6 + (map4 != null ? map4.hashCode() : 0)) * 31;
                Map<Long, ModelApplicationStream> map5 = this.streams;
                int iHashCode8 = (iHashCode7 + (map5 != null ? map5.hashCode() : 0)) * 31;
                Set<Long> set = this.threadMembers;
                int iHashCode9 = (iHashCode8 + (set != null ? set.hashCode() : 0)) * 31;
                StoreThreadsJoined.JoinedThread joinedThread = this.joinedThread;
                return iHashCode9 + (joinedThread != null ? joinedThread.hashCode() : 0);
            }

            @Override // com.discord.widgets.channels.memberlist.WidgetChannelMembersListViewModel.StoreState
            /* JADX INFO: renamed from: isPanelOpen, reason: from getter */
            public boolean getIsPanelOpen() {
                return this.isPanelOpen;
            }

            public String toString() {
                StringBuilder sbM833U = outline.m833U("Thread(isPanelOpen=");
                sbM833U.append(getIsPanelOpen());
                sbM833U.append(", channel=");
                sbM833U.append(getChannel());
                sbM833U.append(", parentChannel=");
                sbM833U.append(this.parentChannel);
                sbM833U.append(", guild=");
                sbM833U.append(this.guild);
                sbM833U.append(", roles=");
                sbM833U.append(this.roles);
                sbM833U.append(", guildMembers=");
                sbM833U.append(this.guildMembers);
                sbM833U.append(", users=");
                sbM833U.append(this.users);
                sbM833U.append(", presences=");
                sbM833U.append(this.presences);
                sbM833U.append(", streams=");
                sbM833U.append(this.streams);
                sbM833U.append(", threadMembers=");
                sbM833U.append(this.threadMembers);
                sbM833U.append(", joinedThread=");
                sbM833U.append(this.joinedThread);
                sbM833U.append(")");
                return sbM833U.toString();
            }
        }

        private StoreState(boolean z2, Channel channel) {
            this.isPanelOpen = z2;
            this.channel = channel;
        }

        public Channel getChannel() {
            return this.channel;
        }

        /* JADX INFO: renamed from: isPanelOpen, reason: from getter */
        public boolean getIsPanelOpen() {
            return this.isPanelOpen;
        }

        public /* synthetic */ StoreState(boolean z2, Channel channel, DefaultConstructorMarker defaultConstructorMarker) {
            this(z2, channel);
        }
    }

    /* JADX INFO: compiled from: WidgetChannelMembersListViewModel.kt */
    public static abstract class ViewState {
        private final String listId;

        /* JADX INFO: compiled from: WidgetChannelMembersListViewModel.kt */
        public static final class Empty extends ViewState {
            public static final Empty INSTANCE = new Empty();

            private Empty() {
                super("empty", null);
            }
        }

        /* JADX INFO: compiled from: WidgetChannelMembersListViewModel.kt */
        public static final /* data */ class Loaded extends ViewState {
            private final Channel channel;
            private final boolean isOpen;
            private final boolean isThreadJoined;
            private final MemberList listItems;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Loaded(MemberList memberList, boolean z2, Channel channel, boolean z3) {
                super(memberList.getListId(), null);
                Intrinsics3.checkNotNullParameter(memberList, "listItems");
                this.listItems = memberList;
                this.isOpen = z2;
                this.channel = channel;
                this.isThreadJoined = z3;
            }

            public static /* synthetic */ Loaded copy$default(Loaded loaded, MemberList memberList, boolean z2, Channel channel, boolean z3, int i, Object obj) {
                if ((i & 1) != 0) {
                    memberList = loaded.listItems;
                }
                if ((i & 2) != 0) {
                    z2 = loaded.isOpen;
                }
                if ((i & 4) != 0) {
                    channel = loaded.channel;
                }
                if ((i & 8) != 0) {
                    z3 = loaded.isThreadJoined;
                }
                return loaded.copy(memberList, z2, channel, z3);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final MemberList getListItems() {
                return this.listItems;
            }

            /* JADX INFO: renamed from: component2, reason: from getter */
            public final boolean getIsOpen() {
                return this.isOpen;
            }

            /* JADX INFO: renamed from: component3, reason: from getter */
            public final Channel getChannel() {
                return this.channel;
            }

            /* JADX INFO: renamed from: component4, reason: from getter */
            public final boolean getIsThreadJoined() {
                return this.isThreadJoined;
            }

            public final Loaded copy(MemberList listItems, boolean isOpen, Channel channel, boolean isThreadJoined) {
                Intrinsics3.checkNotNullParameter(listItems, "listItems");
                return new Loaded(listItems, isOpen, channel, isThreadJoined);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Loaded)) {
                    return false;
                }
                Loaded loaded = (Loaded) other;
                return Intrinsics3.areEqual(this.listItems, loaded.listItems) && this.isOpen == loaded.isOpen && Intrinsics3.areEqual(this.channel, loaded.channel) && this.isThreadJoined == loaded.isThreadJoined;
            }

            public final Channel getChannel() {
                return this.channel;
            }

            public final MemberList getListItems() {
                return this.listItems;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r2v1, types: [int] */
            /* JADX WARN: Type inference failed for: r2v3 */
            /* JADX WARN: Type inference failed for: r2v4 */
            /* JADX WARN: Type inference failed for: r3v0 */
            /* JADX WARN: Type inference failed for: r3v1, types: [int] */
            /* JADX WARN: Type inference failed for: r3v2 */
            public int hashCode() {
                MemberList memberList = this.listItems;
                int iHashCode = (memberList != null ? memberList.hashCode() : 0) * 31;
                boolean z2 = this.isOpen;
                ?? r2 = z2;
                if (z2) {
                    r2 = 1;
                }
                int i = (iHashCode + r2) * 31;
                Channel channel = this.channel;
                int iHashCode2 = (i + (channel != null ? channel.hashCode() : 0)) * 31;
                boolean z3 = this.isThreadJoined;
                return iHashCode2 + (z3 ? 1 : z3);
            }

            public final boolean isOpen() {
                return this.isOpen;
            }

            public final boolean isThreadJoined() {
                return this.isThreadJoined;
            }

            public String toString() {
                StringBuilder sbM833U = outline.m833U("Loaded(listItems=");
                sbM833U.append(this.listItems);
                sbM833U.append(", isOpen=");
                sbM833U.append(this.isOpen);
                sbM833U.append(", channel=");
                sbM833U.append(this.channel);
                sbM833U.append(", isThreadJoined=");
                return outline.m827O(sbM833U, this.isThreadJoined, ")");
            }
        }

        private ViewState(String str) {
            this.listId = str;
        }

        public final String getListId() {
            return this.listId;
        }

        public /* synthetic */ ViewState(String str, DefaultConstructorMarker defaultConstructorMarker) {
            this(str);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.channels.memberlist.WidgetChannelMembersListViewModel$onThreadJoinLeaveClicked$1 */
    /* JADX INFO: compiled from: WidgetChannelMembersListViewModel.kt */
    public static final class C75011 extends Lambda implements Function1<Error, Unit> {
        public C75011() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Error error) {
            invoke2(error);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Error error) {
            Intrinsics3.checkNotNullParameter(error, "error");
            PublishSubject publishSubjectAccess$getEventSubject$p = WidgetChannelMembersListViewModel.access$getEventSubject$p(WidgetChannelMembersListViewModel.this);
            Error.Response response = error.getResponse();
            Intrinsics3.checkNotNullExpressionValue(response, "error.response");
            publishSubjectAccess$getEventSubject$p.f27650k.onNext(new Event.Error(response.getCode()));
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.channels.memberlist.WidgetChannelMembersListViewModel$onThreadJoinLeaveClicked$2 */
    /* JADX INFO: compiled from: WidgetChannelMembersListViewModel.kt */
    public static final class C75022 extends Lambda implements Function1<Void, Unit> {
        public static final C75022 INSTANCE = new C75022();

        public C75022() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Void r1) {
            invoke2(r1);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Void r1) {
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.channels.memberlist.WidgetChannelMembersListViewModel$onThreadJoinLeaveClicked$3 */
    /* JADX INFO: compiled from: WidgetChannelMembersListViewModel.kt */
    public static final class C75033 extends Lambda implements Function1<Error, Unit> {
        public C75033() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Error error) {
            invoke2(error);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Error error) {
            Intrinsics3.checkNotNullParameter(error, "error");
            PublishSubject publishSubjectAccess$getEventSubject$p = WidgetChannelMembersListViewModel.access$getEventSubject$p(WidgetChannelMembersListViewModel.this);
            Error.Response response = error.getResponse();
            Intrinsics3.checkNotNullExpressionValue(response, "error.response");
            publishSubjectAccess$getEventSubject$p.f27650k.onNext(new Event.Error(response.getCode()));
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.channels.memberlist.WidgetChannelMembersListViewModel$onThreadJoinLeaveClicked$4 */
    /* JADX INFO: compiled from: WidgetChannelMembersListViewModel.kt */
    public static final class C75044 extends Lambda implements Function1<Void, Unit> {
        public static final C75044 INSTANCE = new C75044();

        public C75044() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Void r1) {
            invoke2(r1);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Void r1) {
        }
    }

    public WidgetChannelMembersListViewModel() {
        this(null, null, null, null, 15, null);
    }

    /*  JADX ERROR: NullPointerException in pass: InitCodeVariables
        java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.SSAVar.getPhiList()" because "resultVar" is null
        	at jadx.core.dex.visitors.InitCodeVariables.collectConnectedVars(InitCodeVariables.java:119)
        	at jadx.core.dex.visitors.InitCodeVariables.setCodeVar(InitCodeVariables.java:82)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVar(InitCodeVariables.java:74)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVars(InitCodeVariables.java:48)
        	at jadx.core.dex.visitors.InitCodeVariables.visit(InitCodeVariables.java:29)
        */
    public /* synthetic */ WidgetChannelMembersListViewModel(com.discord.widgets.channels.memberlist.WidgetChannelMembersListViewModel.GuildChannelSubscriber r21, com.discord.stores.StoreGuilds r22, com.discord.stores.StoreEmojiCustom r23, p658rx.Observable r24, int r25, kotlin.jvm.internal.DefaultConstructorMarker r26) {
        /*
            r20 = this;
            r0 = r25 & 1
            if (r0 == 0) goto La
            com.discord.widgets.channels.memberlist.WidgetChannelMembersListViewModel$1 r0 = new com.discord.widgets.channels.memberlist.WidgetChannelMembersListViewModel$1
            r0.<init>()
            goto Lc
        La:
            r0 = r21
        Lc:
            r1 = r25 & 2
            if (r1 == 0) goto L17
            com.discord.stores.StoreStream$Companion r1 = com.discord.stores.StoreStream.INSTANCE
            com.discord.stores.StoreGuilds r1 = r1.getGuilds()
            goto L19
        L17:
            r1 = r22
        L19:
            r2 = r25 & 4
            if (r2 == 0) goto L25
            com.discord.stores.StoreStream$Companion r2 = com.discord.stores.StoreStream.INSTANCE
            com.discord.stores.StoreEmojiCustom r2 = r2.getCustomEmojis()
            r15 = r2
            goto L27
        L25:
            r15 = r23
        L27:
            r2 = r25 & 8
            if (r2 == 0) goto L50
            com.discord.widgets.channels.memberlist.WidgetChannelMembersListViewModel$Companion r2 = com.discord.widgets.channels.memberlist.WidgetChannelMembersListViewModel.INSTANCE
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            r12 = 0
            r13 = 0
            r14 = 0
            r16 = 0
            r17 = 8190(0x1ffe, float:1.1477E-41)
            r18 = 0
            r3 = r1
            r19 = r15
            r15 = r16
            r16 = r17
            r17 = r18
            rx.Observable r2 = com.discord.widgets.channels.memberlist.WidgetChannelMembersListViewModel.Companion.observeStoreState$default(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17)
            r3 = r20
            r4 = r19
            goto L55
        L50:
            r3 = r20
            r2 = r24
            r4 = r15
        L55:
            r3.<init>(r0, r1, r4, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.discord.widgets.channels.memberlist.WidgetChannelMembersListViewModel.<init>(com.discord.widgets.channels.memberlist.WidgetChannelMembersListViewModel$GuildChannelSubscriber, com.discord.stores.StoreGuilds, com.discord.stores.StoreEmojiCustom, rx.Observable, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public static final /* synthetic */ PublishSubject access$getEventSubject$p(WidgetChannelMembersListViewModel widgetChannelMembersListViewModel) {
        return widgetChannelMembersListViewModel.eventSubject;
    }

    public static final /* synthetic */ void access$handleStoreState(WidgetChannelMembersListViewModel widgetChannelMembersListViewModel, StoreState storeState) {
        widgetChannelMembersListViewModel.handleStoreState(storeState);
    }

    @MainThread
    private final void handleStoreState(StoreState storeState) {
        MemberList memberListGenerateThreadMemberListItems;
        if (storeState instanceof StoreState.None) {
            updateViewState(ViewState.Empty.INSTANCE);
            return;
        }
        boolean z2 = false;
        if (storeState instanceof StoreState.Guild) {
            StoreState.Guild guild = (StoreState.Guild) storeState;
            memberListGenerateThreadMemberListItems = GuildMemberListItemGenerator.generateGuildMemberListItems(guild.getChannelMembers(), guild.getGuild(), guild.getChannel(), guild.getGuildRoles(), PermissionUtils.can(1L, guild.getChannelPermissions()), false, this.storeGuilds, this.storeCustomEmojis);
        } else if (storeState instanceof StoreState.Private) {
            StoreState.Private r0 = (StoreState.Private) storeState;
            Map<Long, Integer> relationships = r0.getRelationships();
            User userM7677a = ChannelUtils.m7677a(r0.getChannel());
            memberListGenerateThreadMemberListItems = PrivateChannelMemberListItemGenerator.generateGroupDmMemberListItems(r0.getChannel(), r0.getUsers(), r0.getPresences(), r0.getApplicationStreams(), ChannelUtils.m7692p(r0.getChannel()) || ModelUserRelationship.isType(relationships.get(userM7677a != null ? Long.valueOf(userM7677a.getId()) : null), 1));
        } else {
            if (!(storeState instanceof StoreState.Thread)) {
                throw new NoWhenBranchMatchedException();
            }
            StoreState.Thread thread = (StoreState.Thread) storeState;
            memberListGenerateThreadMemberListItems = ThreadMemberListItemGenerator.generateThreadMemberListItems(thread.getChannel(), thread.getRoles(), thread.getGuild(), thread.getGuildMembers(), thread.getUsers(), thread.getPresences(), thread.getStreams(), thread.getThreadMembers(), thread.getJoinedThread(), this.storeGuilds, this.storeCustomEmojis);
        }
        ViewState viewState = getViewState();
        boolean isPanelOpen = storeState.getIsPanelOpen();
        Channel channel = storeState.getChannel();
        if ((storeState instanceof StoreState.Thread) && ((StoreState.Thread) storeState).getJoinedThread() != null) {
            z2 = true;
        }
        ViewState.Loaded loaded = new ViewState.Loaded(memberListGenerateThreadMemberListItems, isPanelOpen, channel, z2);
        updateViewState(loaded);
        updateSubscriptions(viewState, loaded, storeState);
    }

    public final Observable<Event> observeEvents() {
        PublishSubject<Event> publishSubject = this.eventSubject;
        Intrinsics3.checkNotNullExpressionValue(publishSubject, "eventSubject");
        return publishSubject;
    }

    public final void onThreadJoinLeaveClicked(long channelId, boolean isThreadJoined) {
        if (isThreadJoined) {
            ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.INSTANCE.getApi().leaveThread(channelId, "Thread Member List"), false, 1, null), this, null, 2, null), WidgetChannelMembersListViewModel.class, (Context) null, (Function1) null, new C75011(), (Function0) null, (Function0) null, C75022.INSTANCE, 54, (Object) null);
            StoreNavigation.setNavigationPanelAction$default(StoreStream.INSTANCE.getNavigation(), StoreNavigation.PanelAction.CLOSE, null, 2, null);
        } else {
            ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.INSTANCE.getApi().joinThread(channelId, "Thread Member List", new RestAPIParams.EmptyBody()), false, 1, null), WidgetChannelMembersListViewModel.class, (Context) null, (Function1) null, new C75033(), (Function0) null, (Function0) null, C75044.INSTANCE, 54, (Object) null);
            StoreNavigation.setNavigationPanelAction$default(StoreStream.INSTANCE.getNavigation(), StoreNavigation.PanelAction.CLOSE, null, 2, null);
        }
    }

    public final void updateSubscriptions(ViewState prevViewState, ViewState.Loaded newViewState, StoreState storeState) {
        Intrinsics3.checkNotNullParameter(newViewState, "newViewState");
        Intrinsics3.checkNotNullParameter(storeState, "storeState");
        boolean z2 = (Intrinsics3.areEqual(prevViewState != null ? prevViewState.getListId() : null, newViewState.getListId()) ^ true) && storeState.getIsPanelOpen();
        Channel channel = newViewState.getChannel();
        if (channel != null && ChannelUtils.m7673H(channel)) {
            if (z2) {
                this.eventSubject.f27650k.onNext(Event.ScrollToTop.INSTANCE);
                updateSubscriptionsForThread(newViewState.getChannel());
                return;
            } else {
                if ((prevViewState instanceof ViewState.Loaded) && !((ViewState.Loaded) prevViewState).isOpen() && newViewState.isOpen()) {
                    updateSubscriptionsForThread(newViewState.getChannel());
                    return;
                }
                return;
            }
        }
        if (z2) {
            this.eventSubject.f27650k.onNext(Event.ScrollToTop.INSTANCE);
            updateSubscriptionsForChannel(new Ranges2(0, 99));
        } else if ((prevViewState instanceof ViewState.Loaded) && !((ViewState.Loaded) prevViewState).isOpen() && newViewState.isOpen()) {
            this.eventSubject.f27650k.onNext(Event.UpdateRanges.INSTANCE);
        }
    }

    @MainThread
    public final void updateSubscriptionsForChannel(Ranges2 range) {
        Intrinsics3.checkNotNullParameter(range, "range");
        ViewState viewState = getViewState();
        if (!(viewState instanceof ViewState.Loaded)) {
            viewState = null;
        }
        ViewState.Loaded loaded = (ViewState.Loaded) viewState;
        if (loaded == null || loaded.getChannel() == null || !loaded.isOpen()) {
            return;
        }
        this.guildChannelSubscriber.subscribeToChannelRange(loaded.getChannel(), range);
    }

    public final void updateSubscriptionsForThread(Channel channel) {
        if (channel == null || ChannelUtils.m7686j(channel)) {
            return;
        }
        Intrinsics3.checkNotNullParameter(channel, "$this$isAnnouncementThread");
        if (channel.getType() == 10) {
            return;
        }
        this.guildChannelSubscriber.subscribeToThread(channel);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChannelMembersListViewModel(GuildChannelSubscriber guildChannelSubscriber, StoreGuilds storeGuilds, StoreEmojiCustom storeEmojiCustom, Observable<StoreState> observable) {
        super(ViewState.Empty.INSTANCE);
        Intrinsics3.checkNotNullParameter(guildChannelSubscriber, "guildChannelSubscriber");
        Intrinsics3.checkNotNullParameter(storeGuilds, "storeGuilds");
        Intrinsics3.checkNotNullParameter(storeEmojiCustom, "storeCustomEmojis");
        Intrinsics3.checkNotNullParameter(observable, "storeStateObservable");
        this.guildChannelSubscriber = guildChannelSubscriber;
        this.storeGuilds = storeGuilds;
        this.storeCustomEmojis = storeEmojiCustom;
        this.eventSubject = PublishSubject.m11133k0();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationLatest(observable), this, null, 2, null), WidgetChannelMembersListViewModel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new C74952(), 62, (Object) null);
    }
}

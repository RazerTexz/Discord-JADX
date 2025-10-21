package com.discord.widgets.forums;

import a0.a.a.b;
import android.content.Context;
import androidx.annotation.MainThread;
import b.a.d.AppViewModel;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.api.channel.ForumTag;
import com.discord.api.message.reaction.MessageReaction;
import com.discord.api.role.GuildRole;
import com.discord.api.user.NsfwAllowance;
import com.discord.models.domain.emoji.Emoji;
import com.discord.models.domain.emoji.ModelEmojiCustom;
import com.discord.models.guild.UserGuildMember;
import com.discord.models.member.GuildMember;
import com.discord.models.message.Message;
import com.discord.models.user.MeUser;
import com.discord.models.user.User;
import com.discord.stores.ArchivedThreadsStore;
import com.discord.stores.StoreChannels;
import com.discord.stores.StoreChannelsSelected;
import com.discord.stores.StoreEmoji;
import com.discord.stores.StoreExperiments;
import com.discord.stores.StoreForumPostMessages;
import com.discord.stores.StoreForumPostReadStates;
import com.discord.stores.StoreGuildMemberRequester;
import com.discord.stores.StoreGuilds;
import com.discord.stores.StoreMessagesMostRecent;
import com.discord.stores.StorePermissions;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreTabsNavigation;
import com.discord.stores.StoreThreadMessages;
import com.discord.stores.StoreThreadsActive;
import com.discord.stores.StoreUser;
import com.discord.stores.StoreUserRelationships;
import com.discord.stores.StoreUserTyping;
import com.discord.utilities.SnowflakeUtils;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.widgets.forums.ForumBrowserItem;
import d0.d0._Ranges;
import d0.f0._Sequences2;
import d0.t.Collections2;
import d0.t.Iterables2;
import d0.t.MapsJVM;
import d0.t.MutableCollections;
import d0.t._Collections;
import d0.t._Maps;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Tuples2;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.sequences.Sequence;
import rx.Observable;
import rx.subjects.PublishSubject;

/* compiled from: WidgetForumBrowserViewModel.kt */
/* loaded from: classes2.dex */
public final class WidgetForumBrowserViewModel extends AppViewModel<ViewState> {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final int MAX_TYPING_USERS = 3;
    private boolean canFetchMoreOlderPosts;
    private final PublishSubject<Event> eventSubject;
    private final StoreGuildMemberRequester guildMemberRequester;
    private final Set<Long> initialChannelActivePostFirstMessageFetches;
    private boolean isFetchingMoreOlderPosts;
    private long lastSelectedForumChannelId;
    private final ArchivedThreadsStore storeArchivedThreads;
    private final StoreChannels storeChannels;
    private final StoreChannelsSelected storeChannelsSelected;
    private final StoreEmoji storeEmoji;
    private final StoreExperiments storeExperiments;
    private final StoreForumPostMessages storeForumPostMessages;
    private final StoreForumPostReadStates storeForumPostReadStates;
    private final StoreGuilds storeGuilds;
    private final StoreMessagesMostRecent storeMessagesMostRecent;
    private final StorePermissions storePermissions;
    private final StoreTabsNavigation storeTabsNavigation;
    private final StoreThreadsActive storeThreadsActive;
    private final StoreThreadMessages storeThreadsMessages;
    private final StoreUser storeUser;
    private final StoreUserRelationships storeUserRelationships;
    private final StoreUserTyping storeUserTyping;

    /* compiled from: WidgetForumBrowserViewModel.kt */
    /* renamed from: com.discord.widgets.forums.WidgetForumBrowserViewModel$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<StoreState, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(StoreState storeState) {
            invoke2(storeState);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(StoreState storeState) {
            WidgetForumBrowserViewModel widgetForumBrowserViewModel = WidgetForumBrowserViewModel.this;
            Intrinsics3.checkNotNullExpressionValue(storeState, "storeState");
            WidgetForumBrowserViewModel.access$handleStoreState(widgetForumBrowserViewModel, storeState);
        }
    }

    /* compiled from: WidgetForumBrowserViewModel.kt */
    public static final class Companion {
        private Companion() {
        }

        public static final /* synthetic */ Observable access$observeStoreState(Companion companion, StoreUser storeUser, StoreChannels storeChannels, StoreGuilds storeGuilds, StoreThreadsActive storeThreadsActive, ArchivedThreadsStore archivedThreadsStore, StoreThreadMessages storeThreadMessages, StoreForumPostMessages storeForumPostMessages, StoreUserRelationships storeUserRelationships, StoreChannelsSelected storeChannelsSelected, StoreTabsNavigation storeTabsNavigation, StoreExperiments storeExperiments, StorePermissions storePermissions, StoreMessagesMostRecent storeMessagesMostRecent, StoreEmoji storeEmoji, StoreForumPostReadStates storeForumPostReadStates, StoreUserTyping storeUserTyping) {
            return companion.observeStoreState(storeUser, storeChannels, storeGuilds, storeThreadsActive, archivedThreadsStore, storeThreadMessages, storeForumPostMessages, storeUserRelationships, storeChannelsSelected, storeTabsNavigation, storeExperiments, storePermissions, storeMessagesMostRecent, storeEmoji, storeForumPostReadStates, storeUserTyping);
        }

        private final Observable<MinimalStoreState> observeMinimalStoreState(StoreThreadsActive storeThreadsActive, StoreChannelsSelected storeChannelsSelected, StoreTabsNavigation storeTabsNavigation, StoreExperiments storeExperiments) {
            Observable observableY = storeChannelsSelected.observeResolvedSelectedChannel().Y(new WidgetForumBrowserViewModel2(storeTabsNavigation, storeThreadsActive, storeExperiments));
            Intrinsics3.checkNotNullExpressionValue(observableY, "storeChannelsSelected.ob…      }\n        }\n      }");
            return observableY;
        }

        private final Observable<StoreState> observeStoreState(StoreUser storeUser, StoreChannels storeChannels, StoreGuilds storeGuilds, StoreThreadsActive storeThreadsActive, ArchivedThreadsStore storeArchivedThreads, StoreThreadMessages storeThreadsMessages, StoreForumPostMessages storeForumPostMessages, StoreUserRelationships storeUserRelationships, StoreChannelsSelected storeChannelsSelected, StoreTabsNavigation storeTabsNavigation, StoreExperiments storeExperiments, StorePermissions storePermissions, StoreMessagesMostRecent storeMessagesMostRecent, StoreEmoji storeEmoji, StoreForumPostReadStates storeForumPostReadStates, StoreUserTyping storeUserTyping) {
            Observable observableY = observeMinimalStoreState(storeThreadsActive, storeChannelsSelected, storeTabsNavigation, storeExperiments).Y(new WidgetForumBrowserViewModel3(storeUser, storeArchivedThreads, storeChannels, storeGuilds, storeForumPostMessages, storeThreadsMessages, storeUserRelationships, storePermissions, storeMessagesMostRecent, storeEmoji, storeForumPostReadStates, storeThreadsActive, storeUserTyping));
            Intrinsics3.checkNotNullExpressionValue(observableY, "observeMinimalStoreState…      }\n        }\n      }");
            return observableY;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetForumBrowserViewModel.kt */
    public static abstract class Event {

        /* compiled from: WidgetForumBrowserViewModel.kt */
        public static final class ScrollToTop extends Event {
            public static final ScrollToTop INSTANCE = new ScrollToTop();

            private ScrollToTop() {
                super(null);
            }
        }

        private Event() {
        }

        public /* synthetic */ Event(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetForumBrowserViewModel.kt */
    public static abstract class MinimalStoreState {

        /* compiled from: WidgetForumBrowserViewModel.kt */
        public static final class Invalid extends MinimalStoreState {
            public static final Invalid INSTANCE = new Invalid();

            private Invalid() {
                super(null);
            }
        }

        /* compiled from: WidgetForumBrowserViewModel.kt */
        public static final /* data */ class Valid extends MinimalStoreState {
            private final Map<Long, Channel> activeThreads;
            private final Channel channel;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Valid(Channel channel, Map<Long, Channel> map) {
                super(null);
                Intrinsics3.checkNotNullParameter(channel, "channel");
                Intrinsics3.checkNotNullParameter(map, "activeThreads");
                this.channel = channel;
                this.activeThreads = map;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ Valid copy$default(Valid valid, Channel channel, Map map, int i, Object obj) {
                if ((i & 1) != 0) {
                    channel = valid.channel;
                }
                if ((i & 2) != 0) {
                    map = valid.activeThreads;
                }
                return valid.copy(channel, map);
            }

            /* renamed from: component1, reason: from getter */
            public final Channel getChannel() {
                return this.channel;
            }

            public final Map<Long, Channel> component2() {
                return this.activeThreads;
            }

            public final Valid copy(Channel channel, Map<Long, Channel> activeThreads) {
                Intrinsics3.checkNotNullParameter(channel, "channel");
                Intrinsics3.checkNotNullParameter(activeThreads, "activeThreads");
                return new Valid(channel, activeThreads);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Valid)) {
                    return false;
                }
                Valid valid = (Valid) other;
                return Intrinsics3.areEqual(this.channel, valid.channel) && Intrinsics3.areEqual(this.activeThreads, valid.activeThreads);
            }

            public final Map<Long, Channel> getActiveThreads() {
                return this.activeThreads;
            }

            public final Channel getChannel() {
                return this.channel;
            }

            public int hashCode() {
                Channel channel = this.channel;
                int iHashCode = (channel != null ? channel.hashCode() : 0) * 31;
                Map<Long, Channel> map = this.activeThreads;
                return iHashCode + (map != null ? map.hashCode() : 0);
            }

            public String toString() {
                StringBuilder sbU = outline.U("Valid(channel=");
                sbU.append(this.channel);
                sbU.append(", activeThreads=");
                return outline.M(sbU, this.activeThreads, ")");
            }
        }

        private MinimalStoreState() {
        }

        public /* synthetic */ MinimalStoreState(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetForumBrowserViewModel.kt */
    public static final /* data */ class NsfwPanelState {
        private final long guildId;
        private final boolean isChannelNsfw;
        private final boolean isNsfwUnconsented;
        private final NsfwAllowance nsfwAllowed;

        public NsfwPanelState(boolean z2, boolean z3, NsfwAllowance nsfwAllowance, long j) {
            this.isNsfwUnconsented = z2;
            this.isChannelNsfw = z3;
            this.nsfwAllowed = nsfwAllowance;
            this.guildId = j;
        }

        public static /* synthetic */ NsfwPanelState copy$default(NsfwPanelState nsfwPanelState, boolean z2, boolean z3, NsfwAllowance nsfwAllowance, long j, int i, Object obj) {
            if ((i & 1) != 0) {
                z2 = nsfwPanelState.isNsfwUnconsented;
            }
            if ((i & 2) != 0) {
                z3 = nsfwPanelState.isChannelNsfw;
            }
            boolean z4 = z3;
            if ((i & 4) != 0) {
                nsfwAllowance = nsfwPanelState.nsfwAllowed;
            }
            NsfwAllowance nsfwAllowance2 = nsfwAllowance;
            if ((i & 8) != 0) {
                j = nsfwPanelState.guildId;
            }
            return nsfwPanelState.copy(z2, z4, nsfwAllowance2, j);
        }

        /* renamed from: component1, reason: from getter */
        public final boolean getIsNsfwUnconsented() {
            return this.isNsfwUnconsented;
        }

        /* renamed from: component2, reason: from getter */
        public final boolean getIsChannelNsfw() {
            return this.isChannelNsfw;
        }

        /* renamed from: component3, reason: from getter */
        public final NsfwAllowance getNsfwAllowed() {
            return this.nsfwAllowed;
        }

        /* renamed from: component4, reason: from getter */
        public final long getGuildId() {
            return this.guildId;
        }

        public final NsfwPanelState copy(boolean isNsfwUnconsented, boolean isChannelNsfw, NsfwAllowance nsfwAllowed, long guildId) {
            return new NsfwPanelState(isNsfwUnconsented, isChannelNsfw, nsfwAllowed, guildId);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof NsfwPanelState)) {
                return false;
            }
            NsfwPanelState nsfwPanelState = (NsfwPanelState) other;
            return this.isNsfwUnconsented == nsfwPanelState.isNsfwUnconsented && this.isChannelNsfw == nsfwPanelState.isChannelNsfw && Intrinsics3.areEqual(this.nsfwAllowed, nsfwPanelState.nsfwAllowed) && this.guildId == nsfwPanelState.guildId;
        }

        public final long getGuildId() {
            return this.guildId;
        }

        public final NsfwAllowance getNsfwAllowed() {
            return this.nsfwAllowed;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v1, types: [int] */
        /* JADX WARN: Type inference failed for: r0v7 */
        /* JADX WARN: Type inference failed for: r0v8 */
        public int hashCode() {
            boolean z2 = this.isNsfwUnconsented;
            ?? r0 = z2;
            if (z2) {
                r0 = 1;
            }
            int i = r0 * 31;
            boolean z3 = this.isChannelNsfw;
            int i2 = (i + (z3 ? 1 : z3 ? 1 : 0)) * 31;
            NsfwAllowance nsfwAllowance = this.nsfwAllowed;
            return b.a(this.guildId) + ((i2 + (nsfwAllowance != null ? nsfwAllowance.hashCode() : 0)) * 31);
        }

        public final boolean isChannelNsfw() {
            return this.isChannelNsfw;
        }

        public final boolean isNsfwUnconsented() {
            return this.isNsfwUnconsented;
        }

        public String toString() {
            StringBuilder sbU = outline.U("NsfwPanelState(isNsfwUnconsented=");
            sbU.append(this.isNsfwUnconsented);
            sbU.append(", isChannelNsfw=");
            sbU.append(this.isChannelNsfw);
            sbU.append(", nsfwAllowed=");
            sbU.append(this.nsfwAllowed);
            sbU.append(", guildId=");
            return outline.C(sbU, this.guildId, ")");
        }
    }

    /* compiled from: WidgetForumBrowserViewModel.kt */
    public static abstract class StoreState {

        /* compiled from: WidgetForumBrowserViewModel.kt */
        public static final class Invalid extends StoreState {
            public static final Invalid INSTANCE = new Invalid();

            private Invalid() {
                super(null);
            }
        }

        /* compiled from: WidgetForumBrowserViewModel.kt */
        public static final /* data */ class Loaded extends StoreState {
            private final Map<Long, Channel> activeThreads;
            private final ArchivedThreadsStore.ThreadListingState archivedThreadsState;
            private final boolean canCreateForumChannelPosts;
            private final Channel channel;
            private final Map<Long, String> channelNames;
            private final Map<Long, Message> forumPostFirstMessages;
            private final Map<Long, StoreThreadMessages.ThreadState> forumPostMessageCounts;
            private final Map<Long, ForumPostReadState> forumPostReadStates;
            private final Map<Long, Integer> forumPostUnreadCounts;
            private final Map<String, Emoji> guildEmojis;
            private final Map<Long, GuildMember> guildMembers;
            private final Map<Long, GuildRole> guildRoles;
            private final boolean isThreadSyncedGuild;
            private final MeUser meUser;
            private final Map<Long, Long> mostRecentMessageIds;
            private final Set<Long> myBlockedUserIds;
            private final Map<Long, Set<Long>> typingUsers;
            private final Map<Long, User> users;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            public Loaded(MeUser meUser, Map<Long, ? extends User> map, ArchivedThreadsStore.ThreadListingState threadListingState, Map<Long, Channel> map2, Map<Long, GuildMember> map3, Map<Long, GuildRole> map4, Map<Long, String> map5, Channel channel, Map<Long, Message> map6, Map<Long, StoreThreadMessages.ThreadState> map7, Set<Long> set, boolean z2, Map<Long, Long> map8, Map<String, ? extends Emoji> map9, Map<Long, ForumPostReadState> map10, Map<Long, Integer> map11, boolean z3, Map<Long, ? extends Set<Long>> map12) {
                super(null);
                Intrinsics3.checkNotNullParameter(meUser, "meUser");
                Intrinsics3.checkNotNullParameter(map, "users");
                Intrinsics3.checkNotNullParameter(threadListingState, "archivedThreadsState");
                Intrinsics3.checkNotNullParameter(map2, "activeThreads");
                Intrinsics3.checkNotNullParameter(map3, "guildMembers");
                Intrinsics3.checkNotNullParameter(map4, "guildRoles");
                Intrinsics3.checkNotNullParameter(map5, "channelNames");
                Intrinsics3.checkNotNullParameter(channel, "channel");
                Intrinsics3.checkNotNullParameter(map6, "forumPostFirstMessages");
                Intrinsics3.checkNotNullParameter(map7, "forumPostMessageCounts");
                Intrinsics3.checkNotNullParameter(set, "myBlockedUserIds");
                Intrinsics3.checkNotNullParameter(map8, "mostRecentMessageIds");
                Intrinsics3.checkNotNullParameter(map9, "guildEmojis");
                Intrinsics3.checkNotNullParameter(map10, "forumPostReadStates");
                Intrinsics3.checkNotNullParameter(map11, "forumPostUnreadCounts");
                Intrinsics3.checkNotNullParameter(map12, "typingUsers");
                this.meUser = meUser;
                this.users = map;
                this.archivedThreadsState = threadListingState;
                this.activeThreads = map2;
                this.guildMembers = map3;
                this.guildRoles = map4;
                this.channelNames = map5;
                this.channel = channel;
                this.forumPostFirstMessages = map6;
                this.forumPostMessageCounts = map7;
                this.myBlockedUserIds = set;
                this.canCreateForumChannelPosts = z2;
                this.mostRecentMessageIds = map8;
                this.guildEmojis = map9;
                this.forumPostReadStates = map10;
                this.forumPostUnreadCounts = map11;
                this.isThreadSyncedGuild = z3;
                this.typingUsers = map12;
            }

            public static /* synthetic */ Loaded copy$default(Loaded loaded, MeUser meUser, Map map, ArchivedThreadsStore.ThreadListingState threadListingState, Map map2, Map map3, Map map4, Map map5, Channel channel, Map map6, Map map7, Set set, boolean z2, Map map8, Map map9, Map map10, Map map11, boolean z3, Map map12, int i, Object obj) {
                return loaded.copy((i & 1) != 0 ? loaded.meUser : meUser, (i & 2) != 0 ? loaded.users : map, (i & 4) != 0 ? loaded.archivedThreadsState : threadListingState, (i & 8) != 0 ? loaded.activeThreads : map2, (i & 16) != 0 ? loaded.guildMembers : map3, (i & 32) != 0 ? loaded.guildRoles : map4, (i & 64) != 0 ? loaded.channelNames : map5, (i & 128) != 0 ? loaded.channel : channel, (i & 256) != 0 ? loaded.forumPostFirstMessages : map6, (i & 512) != 0 ? loaded.forumPostMessageCounts : map7, (i & 1024) != 0 ? loaded.myBlockedUserIds : set, (i & 2048) != 0 ? loaded.canCreateForumChannelPosts : z2, (i & 4096) != 0 ? loaded.mostRecentMessageIds : map8, (i & 8192) != 0 ? loaded.guildEmojis : map9, (i & 16384) != 0 ? loaded.forumPostReadStates : map10, (i & 32768) != 0 ? loaded.forumPostUnreadCounts : map11, (i & 65536) != 0 ? loaded.isThreadSyncedGuild : z3, (i & 131072) != 0 ? loaded.typingUsers : map12);
            }

            /* renamed from: component1, reason: from getter */
            public final MeUser getMeUser() {
                return this.meUser;
            }

            public final Map<Long, StoreThreadMessages.ThreadState> component10() {
                return this.forumPostMessageCounts;
            }

            public final Set<Long> component11() {
                return this.myBlockedUserIds;
            }

            /* renamed from: component12, reason: from getter */
            public final boolean getCanCreateForumChannelPosts() {
                return this.canCreateForumChannelPosts;
            }

            public final Map<Long, Long> component13() {
                return this.mostRecentMessageIds;
            }

            public final Map<String, Emoji> component14() {
                return this.guildEmojis;
            }

            public final Map<Long, ForumPostReadState> component15() {
                return this.forumPostReadStates;
            }

            public final Map<Long, Integer> component16() {
                return this.forumPostUnreadCounts;
            }

            /* renamed from: component17, reason: from getter */
            public final boolean getIsThreadSyncedGuild() {
                return this.isThreadSyncedGuild;
            }

            public final Map<Long, Set<Long>> component18() {
                return this.typingUsers;
            }

            public final Map<Long, User> component2() {
                return this.users;
            }

            /* renamed from: component3, reason: from getter */
            public final ArchivedThreadsStore.ThreadListingState getArchivedThreadsState() {
                return this.archivedThreadsState;
            }

            public final Map<Long, Channel> component4() {
                return this.activeThreads;
            }

            public final Map<Long, GuildMember> component5() {
                return this.guildMembers;
            }

            public final Map<Long, GuildRole> component6() {
                return this.guildRoles;
            }

            public final Map<Long, String> component7() {
                return this.channelNames;
            }

            /* renamed from: component8, reason: from getter */
            public final Channel getChannel() {
                return this.channel;
            }

            public final Map<Long, Message> component9() {
                return this.forumPostFirstMessages;
            }

            public final Loaded copy(MeUser meUser, Map<Long, ? extends User> users, ArchivedThreadsStore.ThreadListingState archivedThreadsState, Map<Long, Channel> activeThreads, Map<Long, GuildMember> guildMembers, Map<Long, GuildRole> guildRoles, Map<Long, String> channelNames, Channel channel, Map<Long, Message> forumPostFirstMessages, Map<Long, StoreThreadMessages.ThreadState> forumPostMessageCounts, Set<Long> myBlockedUserIds, boolean canCreateForumChannelPosts, Map<Long, Long> mostRecentMessageIds, Map<String, ? extends Emoji> guildEmojis, Map<Long, ForumPostReadState> forumPostReadStates, Map<Long, Integer> forumPostUnreadCounts, boolean isThreadSyncedGuild, Map<Long, ? extends Set<Long>> typingUsers) {
                Intrinsics3.checkNotNullParameter(meUser, "meUser");
                Intrinsics3.checkNotNullParameter(users, "users");
                Intrinsics3.checkNotNullParameter(archivedThreadsState, "archivedThreadsState");
                Intrinsics3.checkNotNullParameter(activeThreads, "activeThreads");
                Intrinsics3.checkNotNullParameter(guildMembers, "guildMembers");
                Intrinsics3.checkNotNullParameter(guildRoles, "guildRoles");
                Intrinsics3.checkNotNullParameter(channelNames, "channelNames");
                Intrinsics3.checkNotNullParameter(channel, "channel");
                Intrinsics3.checkNotNullParameter(forumPostFirstMessages, "forumPostFirstMessages");
                Intrinsics3.checkNotNullParameter(forumPostMessageCounts, "forumPostMessageCounts");
                Intrinsics3.checkNotNullParameter(myBlockedUserIds, "myBlockedUserIds");
                Intrinsics3.checkNotNullParameter(mostRecentMessageIds, "mostRecentMessageIds");
                Intrinsics3.checkNotNullParameter(guildEmojis, "guildEmojis");
                Intrinsics3.checkNotNullParameter(forumPostReadStates, "forumPostReadStates");
                Intrinsics3.checkNotNullParameter(forumPostUnreadCounts, "forumPostUnreadCounts");
                Intrinsics3.checkNotNullParameter(typingUsers, "typingUsers");
                return new Loaded(meUser, users, archivedThreadsState, activeThreads, guildMembers, guildRoles, channelNames, channel, forumPostFirstMessages, forumPostMessageCounts, myBlockedUserIds, canCreateForumChannelPosts, mostRecentMessageIds, guildEmojis, forumPostReadStates, forumPostUnreadCounts, isThreadSyncedGuild, typingUsers);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Loaded)) {
                    return false;
                }
                Loaded loaded = (Loaded) other;
                return Intrinsics3.areEqual(this.meUser, loaded.meUser) && Intrinsics3.areEqual(this.users, loaded.users) && Intrinsics3.areEqual(this.archivedThreadsState, loaded.archivedThreadsState) && Intrinsics3.areEqual(this.activeThreads, loaded.activeThreads) && Intrinsics3.areEqual(this.guildMembers, loaded.guildMembers) && Intrinsics3.areEqual(this.guildRoles, loaded.guildRoles) && Intrinsics3.areEqual(this.channelNames, loaded.channelNames) && Intrinsics3.areEqual(this.channel, loaded.channel) && Intrinsics3.areEqual(this.forumPostFirstMessages, loaded.forumPostFirstMessages) && Intrinsics3.areEqual(this.forumPostMessageCounts, loaded.forumPostMessageCounts) && Intrinsics3.areEqual(this.myBlockedUserIds, loaded.myBlockedUserIds) && this.canCreateForumChannelPosts == loaded.canCreateForumChannelPosts && Intrinsics3.areEqual(this.mostRecentMessageIds, loaded.mostRecentMessageIds) && Intrinsics3.areEqual(this.guildEmojis, loaded.guildEmojis) && Intrinsics3.areEqual(this.forumPostReadStates, loaded.forumPostReadStates) && Intrinsics3.areEqual(this.forumPostUnreadCounts, loaded.forumPostUnreadCounts) && this.isThreadSyncedGuild == loaded.isThreadSyncedGuild && Intrinsics3.areEqual(this.typingUsers, loaded.typingUsers);
            }

            public final Map<Long, Channel> getActiveThreads() {
                return this.activeThreads;
            }

            public final ArchivedThreadsStore.ThreadListingState getArchivedThreadsState() {
                return this.archivedThreadsState;
            }

            public final boolean getCanCreateForumChannelPosts() {
                return this.canCreateForumChannelPosts;
            }

            public final Channel getChannel() {
                return this.channel;
            }

            public final Map<Long, String> getChannelNames() {
                return this.channelNames;
            }

            public final Map<Long, Message> getForumPostFirstMessages() {
                return this.forumPostFirstMessages;
            }

            public final Map<Long, StoreThreadMessages.ThreadState> getForumPostMessageCounts() {
                return this.forumPostMessageCounts;
            }

            public final Map<Long, ForumPostReadState> getForumPostReadStates() {
                return this.forumPostReadStates;
            }

            public final Map<Long, Integer> getForumPostUnreadCounts() {
                return this.forumPostUnreadCounts;
            }

            public final Map<String, Emoji> getGuildEmojis() {
                return this.guildEmojis;
            }

            public final Map<Long, GuildMember> getGuildMembers() {
                return this.guildMembers;
            }

            public final Map<Long, GuildRole> getGuildRoles() {
                return this.guildRoles;
            }

            public final MeUser getMeUser() {
                return this.meUser;
            }

            public final Map<Long, Long> getMostRecentMessageIds() {
                return this.mostRecentMessageIds;
            }

            public final Set<Long> getMyBlockedUserIds() {
                return this.myBlockedUserIds;
            }

            public final Map<Long, Set<Long>> getTypingUsers() {
                return this.typingUsers;
            }

            public final Map<Long, User> getUsers() {
                return this.users;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public int hashCode() {
                MeUser meUser = this.meUser;
                int iHashCode = (meUser != null ? meUser.hashCode() : 0) * 31;
                Map<Long, User> map = this.users;
                int iHashCode2 = (iHashCode + (map != null ? map.hashCode() : 0)) * 31;
                ArchivedThreadsStore.ThreadListingState threadListingState = this.archivedThreadsState;
                int iHashCode3 = (iHashCode2 + (threadListingState != null ? threadListingState.hashCode() : 0)) * 31;
                Map<Long, Channel> map2 = this.activeThreads;
                int iHashCode4 = (iHashCode3 + (map2 != null ? map2.hashCode() : 0)) * 31;
                Map<Long, GuildMember> map3 = this.guildMembers;
                int iHashCode5 = (iHashCode4 + (map3 != null ? map3.hashCode() : 0)) * 31;
                Map<Long, GuildRole> map4 = this.guildRoles;
                int iHashCode6 = (iHashCode5 + (map4 != null ? map4.hashCode() : 0)) * 31;
                Map<Long, String> map5 = this.channelNames;
                int iHashCode7 = (iHashCode6 + (map5 != null ? map5.hashCode() : 0)) * 31;
                Channel channel = this.channel;
                int iHashCode8 = (iHashCode7 + (channel != null ? channel.hashCode() : 0)) * 31;
                Map<Long, Message> map6 = this.forumPostFirstMessages;
                int iHashCode9 = (iHashCode8 + (map6 != null ? map6.hashCode() : 0)) * 31;
                Map<Long, StoreThreadMessages.ThreadState> map7 = this.forumPostMessageCounts;
                int iHashCode10 = (iHashCode9 + (map7 != null ? map7.hashCode() : 0)) * 31;
                Set<Long> set = this.myBlockedUserIds;
                int iHashCode11 = (iHashCode10 + (set != null ? set.hashCode() : 0)) * 31;
                boolean z2 = this.canCreateForumChannelPosts;
                int i = z2;
                if (z2 != 0) {
                    i = 1;
                }
                int i2 = (iHashCode11 + i) * 31;
                Map<Long, Long> map8 = this.mostRecentMessageIds;
                int iHashCode12 = (i2 + (map8 != null ? map8.hashCode() : 0)) * 31;
                Map<String, Emoji> map9 = this.guildEmojis;
                int iHashCode13 = (iHashCode12 + (map9 != null ? map9.hashCode() : 0)) * 31;
                Map<Long, ForumPostReadState> map10 = this.forumPostReadStates;
                int iHashCode14 = (iHashCode13 + (map10 != null ? map10.hashCode() : 0)) * 31;
                Map<Long, Integer> map11 = this.forumPostUnreadCounts;
                int iHashCode15 = (iHashCode14 + (map11 != null ? map11.hashCode() : 0)) * 31;
                boolean z3 = this.isThreadSyncedGuild;
                int i3 = (iHashCode15 + (z3 ? 1 : z3 ? 1 : 0)) * 31;
                Map<Long, Set<Long>> map12 = this.typingUsers;
                return i3 + (map12 != null ? map12.hashCode() : 0);
            }

            public final boolean isThreadSyncedGuild() {
                return this.isThreadSyncedGuild;
            }

            public String toString() {
                StringBuilder sbU = outline.U("Loaded(meUser=");
                sbU.append(this.meUser);
                sbU.append(", users=");
                sbU.append(this.users);
                sbU.append(", archivedThreadsState=");
                sbU.append(this.archivedThreadsState);
                sbU.append(", activeThreads=");
                sbU.append(this.activeThreads);
                sbU.append(", guildMembers=");
                sbU.append(this.guildMembers);
                sbU.append(", guildRoles=");
                sbU.append(this.guildRoles);
                sbU.append(", channelNames=");
                sbU.append(this.channelNames);
                sbU.append(", channel=");
                sbU.append(this.channel);
                sbU.append(", forumPostFirstMessages=");
                sbU.append(this.forumPostFirstMessages);
                sbU.append(", forumPostMessageCounts=");
                sbU.append(this.forumPostMessageCounts);
                sbU.append(", myBlockedUserIds=");
                sbU.append(this.myBlockedUserIds);
                sbU.append(", canCreateForumChannelPosts=");
                sbU.append(this.canCreateForumChannelPosts);
                sbU.append(", mostRecentMessageIds=");
                sbU.append(this.mostRecentMessageIds);
                sbU.append(", guildEmojis=");
                sbU.append(this.guildEmojis);
                sbU.append(", forumPostReadStates=");
                sbU.append(this.forumPostReadStates);
                sbU.append(", forumPostUnreadCounts=");
                sbU.append(this.forumPostUnreadCounts);
                sbU.append(", isThreadSyncedGuild=");
                sbU.append(this.isThreadSyncedGuild);
                sbU.append(", typingUsers=");
                return outline.M(sbU, this.typingUsers, ")");
            }
        }

        private StoreState() {
        }

        public /* synthetic */ StoreState(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetForumBrowserViewModel.kt */
    public static abstract class ViewState {
        private final NsfwPanelState nsfwPanelState;

        /* compiled from: WidgetForumBrowserViewModel.kt */
        public static final /* data */ class Loaded extends ViewState {
            private final boolean canCreateForumChannelPosts;
            private final long channelId;
            private final String channelName;
            private final String channelTopic;
            private final long guildId;
            private final List<ForumBrowserItem> listItems;
            private final NsfwPanelState nsfwPanelState;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            public Loaded(NsfwPanelState nsfwPanelState, List<? extends ForumBrowserItem> list, boolean z2, String str, String str2, long j, long j2) {
                super(nsfwPanelState, null);
                Intrinsics3.checkNotNullParameter(nsfwPanelState, "nsfwPanelState");
                Intrinsics3.checkNotNullParameter(list, "listItems");
                Intrinsics3.checkNotNullParameter(str, "channelName");
                this.nsfwPanelState = nsfwPanelState;
                this.listItems = list;
                this.canCreateForumChannelPosts = z2;
                this.channelName = str;
                this.channelTopic = str2;
                this.channelId = j;
                this.guildId = j2;
            }

            public static /* synthetic */ Loaded copy$default(Loaded loaded, NsfwPanelState nsfwPanelState, List list, boolean z2, String str, String str2, long j, long j2, int i, Object obj) {
                return loaded.copy((i & 1) != 0 ? loaded.getNsfwPanelState() : nsfwPanelState, (i & 2) != 0 ? loaded.listItems : list, (i & 4) != 0 ? loaded.canCreateForumChannelPosts : z2, (i & 8) != 0 ? loaded.channelName : str, (i & 16) != 0 ? loaded.channelTopic : str2, (i & 32) != 0 ? loaded.channelId : j, (i & 64) != 0 ? loaded.guildId : j2);
            }

            public final NsfwPanelState component1() {
                return getNsfwPanelState();
            }

            public final List<ForumBrowserItem> component2() {
                return this.listItems;
            }

            /* renamed from: component3, reason: from getter */
            public final boolean getCanCreateForumChannelPosts() {
                return this.canCreateForumChannelPosts;
            }

            /* renamed from: component4, reason: from getter */
            public final String getChannelName() {
                return this.channelName;
            }

            /* renamed from: component5, reason: from getter */
            public final String getChannelTopic() {
                return this.channelTopic;
            }

            /* renamed from: component6, reason: from getter */
            public final long getChannelId() {
                return this.channelId;
            }

            /* renamed from: component7, reason: from getter */
            public final long getGuildId() {
                return this.guildId;
            }

            public final Loaded copy(NsfwPanelState nsfwPanelState, List<? extends ForumBrowserItem> listItems, boolean canCreateForumChannelPosts, String channelName, String channelTopic, long channelId, long guildId) {
                Intrinsics3.checkNotNullParameter(nsfwPanelState, "nsfwPanelState");
                Intrinsics3.checkNotNullParameter(listItems, "listItems");
                Intrinsics3.checkNotNullParameter(channelName, "channelName");
                return new Loaded(nsfwPanelState, listItems, canCreateForumChannelPosts, channelName, channelTopic, channelId, guildId);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Loaded)) {
                    return false;
                }
                Loaded loaded = (Loaded) other;
                return Intrinsics3.areEqual(getNsfwPanelState(), loaded.getNsfwPanelState()) && Intrinsics3.areEqual(this.listItems, loaded.listItems) && this.canCreateForumChannelPosts == loaded.canCreateForumChannelPosts && Intrinsics3.areEqual(this.channelName, loaded.channelName) && Intrinsics3.areEqual(this.channelTopic, loaded.channelTopic) && this.channelId == loaded.channelId && this.guildId == loaded.guildId;
            }

            public final boolean getCanCreateForumChannelPosts() {
                return this.canCreateForumChannelPosts;
            }

            public final long getChannelId() {
                return this.channelId;
            }

            public final String getChannelName() {
                return this.channelName;
            }

            public final String getChannelTopic() {
                return this.channelTopic;
            }

            public final long getGuildId() {
                return this.guildId;
            }

            public final List<ForumBrowserItem> getListItems() {
                return this.listItems;
            }

            @Override // com.discord.widgets.forums.WidgetForumBrowserViewModel.ViewState
            public NsfwPanelState getNsfwPanelState() {
                return this.nsfwPanelState;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public int hashCode() {
                NsfwPanelState nsfwPanelState = getNsfwPanelState();
                int iHashCode = (nsfwPanelState != null ? nsfwPanelState.hashCode() : 0) * 31;
                List<ForumBrowserItem> list = this.listItems;
                int iHashCode2 = (iHashCode + (list != null ? list.hashCode() : 0)) * 31;
                boolean z2 = this.canCreateForumChannelPosts;
                int i = z2;
                if (z2 != 0) {
                    i = 1;
                }
                int i2 = (iHashCode2 + i) * 31;
                String str = this.channelName;
                int iHashCode3 = (i2 + (str != null ? str.hashCode() : 0)) * 31;
                String str2 = this.channelTopic;
                return b.a(this.guildId) + ((b.a(this.channelId) + ((iHashCode3 + (str2 != null ? str2.hashCode() : 0)) * 31)) * 31);
            }

            public String toString() {
                StringBuilder sbU = outline.U("Loaded(nsfwPanelState=");
                sbU.append(getNsfwPanelState());
                sbU.append(", listItems=");
                sbU.append(this.listItems);
                sbU.append(", canCreateForumChannelPosts=");
                sbU.append(this.canCreateForumChannelPosts);
                sbU.append(", channelName=");
                sbU.append(this.channelName);
                sbU.append(", channelTopic=");
                sbU.append(this.channelTopic);
                sbU.append(", channelId=");
                sbU.append(this.channelId);
                sbU.append(", guildId=");
                return outline.C(sbU, this.guildId, ")");
            }
        }

        /* compiled from: WidgetForumBrowserViewModel.kt */
        public static final /* data */ class Loading extends ViewState {
            private final NsfwPanelState nsfwPanelState;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Loading(NsfwPanelState nsfwPanelState) {
                super(nsfwPanelState, null);
                Intrinsics3.checkNotNullParameter(nsfwPanelState, "nsfwPanelState");
                this.nsfwPanelState = nsfwPanelState;
            }

            public static /* synthetic */ Loading copy$default(Loading loading, NsfwPanelState nsfwPanelState, int i, Object obj) {
                if ((i & 1) != 0) {
                    nsfwPanelState = loading.getNsfwPanelState();
                }
                return loading.copy(nsfwPanelState);
            }

            public final NsfwPanelState component1() {
                return getNsfwPanelState();
            }

            public final Loading copy(NsfwPanelState nsfwPanelState) {
                Intrinsics3.checkNotNullParameter(nsfwPanelState, "nsfwPanelState");
                return new Loading(nsfwPanelState);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof Loading) && Intrinsics3.areEqual(getNsfwPanelState(), ((Loading) other).getNsfwPanelState());
                }
                return true;
            }

            @Override // com.discord.widgets.forums.WidgetForumBrowserViewModel.ViewState
            public NsfwPanelState getNsfwPanelState() {
                return this.nsfwPanelState;
            }

            public int hashCode() {
                NsfwPanelState nsfwPanelState = getNsfwPanelState();
                if (nsfwPanelState != null) {
                    return nsfwPanelState.hashCode();
                }
                return 0;
            }

            public String toString() {
                StringBuilder sbU = outline.U("Loading(nsfwPanelState=");
                sbU.append(getNsfwPanelState());
                sbU.append(")");
                return sbU.toString();
            }
        }

        private ViewState(NsfwPanelState nsfwPanelState) {
            this.nsfwPanelState = nsfwPanelState;
        }

        public NsfwPanelState getNsfwPanelState() {
            return this.nsfwPanelState;
        }

        public /* synthetic */ ViewState(NsfwPanelState nsfwPanelState, DefaultConstructorMarker defaultConstructorMarker) {
            this(nsfwPanelState);
        }
    }

    /* compiled from: WidgetForumBrowserViewModel.kt */
    /* renamed from: com.discord.widgets.forums.WidgetForumBrowserViewModel$maybeFetchOlderPosts$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public AnonymousClass1() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            WidgetForumBrowserViewModel.access$setFetchingMoreOlderPosts$p(WidgetForumBrowserViewModel.this, false);
        }
    }

    /* compiled from: WidgetForumBrowserViewModel.kt */
    /* renamed from: com.discord.widgets.forums.WidgetForumBrowserViewModel$setupListViewState$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<Channel, ForumBrowserItem.PostItem> {
        public final /* synthetic */ Set $seenChannelIds;
        public final /* synthetic */ StoreState.Loaded $storeState;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Set set, StoreState.Loaded loaded) {
            super(1);
            this.$seenChannelIds = set;
            this.$storeState = loaded;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ ForumBrowserItem.PostItem invoke(Channel channel) {
            return invoke2(channel);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final ForumBrowserItem.PostItem invoke2(Channel channel) {
            Intrinsics3.checkNotNullParameter(channel, "channel");
            if (this.$seenChannelIds.contains(Long.valueOf(channel.getId()))) {
                return null;
            }
            this.$seenChannelIds.add(Long.valueOf(channel.getId()));
            WidgetForumBrowserViewModel.access$getGuildMemberRequester$p(WidgetForumBrowserViewModel.this).queueRequest(channel.getGuildId(), channel.getOwnerId());
            return WidgetForumBrowserViewModel.access$createPostItem(WidgetForumBrowserViewModel.this, this.$storeState, channel);
        }
    }

    public WidgetForumBrowserViewModel() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 262143, null);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ WidgetForumBrowserViewModel(StoreUser storeUser, StoreChannels storeChannels, StoreGuilds storeGuilds, ArchivedThreadsStore archivedThreadsStore, StoreThreadsActive storeThreadsActive, StoreThreadMessages storeThreadMessages, StoreForumPostMessages storeForumPostMessages, StoreUserRelationships storeUserRelationships, StoreGuildMemberRequester storeGuildMemberRequester, StoreChannelsSelected storeChannelsSelected, StoreTabsNavigation storeTabsNavigation, StoreExperiments storeExperiments, StorePermissions storePermissions, StoreMessagesMostRecent storeMessagesMostRecent, StoreEmoji storeEmoji, StoreForumPostReadStates storeForumPostReadStates, StoreUserTyping storeUserTyping, Observable observable, int i, DefaultConstructorMarker defaultConstructorMarker) {
        StoreUser users = (i & 1) != 0 ? StoreStream.INSTANCE.getUsers() : storeUser;
        StoreChannels channels = (i & 2) != 0 ? StoreStream.INSTANCE.getChannels() : storeChannels;
        StoreGuilds guilds = (i & 4) != 0 ? StoreStream.INSTANCE.getGuilds() : storeGuilds;
        ArchivedThreadsStore archivedThreads = (i & 8) != 0 ? StoreStream.INSTANCE.getArchivedThreads() : archivedThreadsStore;
        StoreThreadsActive threadsActive = (i & 16) != 0 ? StoreStream.INSTANCE.getThreadsActive() : storeThreadsActive;
        StoreThreadMessages threadMessages = (i & 32) != 0 ? StoreStream.INSTANCE.getThreadMessages() : storeThreadMessages;
        StoreForumPostMessages forumPostMessages = (i & 64) != 0 ? StoreStream.INSTANCE.getForumPostMessages() : storeForumPostMessages;
        StoreUserRelationships userRelationships = (i & 128) != 0 ? StoreStream.INSTANCE.getUserRelationships() : storeUserRelationships;
        StoreGuildMemberRequester guildMemberRequester = (i & 256) != 0 ? StoreStream.INSTANCE.getGuildMemberRequester() : storeGuildMemberRequester;
        StoreChannelsSelected channelsSelected = (i & 512) != 0 ? StoreStream.INSTANCE.getChannelsSelected() : storeChannelsSelected;
        StoreTabsNavigation tabsNavigation = (i & 1024) != 0 ? StoreStream.INSTANCE.getTabsNavigation() : storeTabsNavigation;
        StoreExperiments experiments = (i & 2048) != 0 ? StoreStream.INSTANCE.getExperiments() : storeExperiments;
        StorePermissions permissions = (i & 4096) != 0 ? StoreStream.INSTANCE.getPermissions() : storePermissions;
        StoreMessagesMostRecent messagesMostRecent = (i & 8192) != 0 ? StoreStream.INSTANCE.getMessagesMostRecent() : storeMessagesMostRecent;
        StoreEmoji emojis = (i & 16384) != 0 ? StoreStream.INSTANCE.getEmojis() : storeEmoji;
        StoreForumPostReadStates forumPostReadStates = (i & 32768) != 0 ? StoreStream.INSTANCE.getForumPostReadStates() : storeForumPostReadStates;
        StoreUserTyping usersTyping = (i & 65536) != 0 ? StoreStream.INSTANCE.getUsersTyping() : storeUserTyping;
        this(users, channels, guilds, archivedThreads, threadsActive, threadMessages, forumPostMessages, userRelationships, guildMemberRequester, channelsSelected, tabsNavigation, experiments, permissions, messagesMostRecent, emojis, forumPostReadStates, usersTyping, (i & 131072) != 0 ? Companion.access$observeStoreState(INSTANCE, users, channels, guilds, threadsActive, archivedThreads, threadMessages, forumPostMessages, userRelationships, channelsSelected, tabsNavigation, experiments, permissions, messagesMostRecent, emojis, forumPostReadStates, usersTyping) : observable);
    }

    public static final /* synthetic */ ForumBrowserItem.PostItem access$createPostItem(WidgetForumBrowserViewModel widgetForumBrowserViewModel, StoreState.Loaded loaded, Channel channel) {
        return widgetForumBrowserViewModel.createPostItem(loaded, channel);
    }

    public static final /* synthetic */ StoreGuildMemberRequester access$getGuildMemberRequester$p(WidgetForumBrowserViewModel widgetForumBrowserViewModel) {
        return widgetForumBrowserViewModel.guildMemberRequester;
    }

    public static final /* synthetic */ void access$handleStoreState(WidgetForumBrowserViewModel widgetForumBrowserViewModel, StoreState storeState) {
        widgetForumBrowserViewModel.handleStoreState(storeState);
    }

    public static final /* synthetic */ boolean access$isFetchingMoreOlderPosts$p(WidgetForumBrowserViewModel widgetForumBrowserViewModel) {
        return widgetForumBrowserViewModel.isFetchingMoreOlderPosts;
    }

    public static final /* synthetic */ void access$setFetchingMoreOlderPosts$p(WidgetForumBrowserViewModel widgetForumBrowserViewModel, boolean z2) {
        widgetForumBrowserViewModel.isFetchingMoreOlderPosts = z2;
    }

    /* JADX WARN: Removed duplicated region for block: B:49:0x0122  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x01af  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final ForumBrowserItem.PostItem createPostItem(StoreState.Loaded storeState, Channel channel) {
        LinkedHashMap linkedHashMap;
        PostData2 postData2;
        List listEmptyList;
        GuildMember guildMember;
        PostData2 postData2FromTag;
        ForumTag forumTag;
        boolean z2;
        com.discord.api.user.User author;
        User user = storeState.getUsers().get(Long.valueOf(channel.getOwnerId()));
        Message message = (Message) outline.d(channel, storeState.getForumPostFirstMessages());
        Long lValueOf = (message == null || (author = message.getAuthor()) == null) ? null : Long.valueOf(author.getId());
        boolean z3 = lValueOf != null && storeState.getMyBlockedUserIds().contains(lValueOf);
        StoreThreadMessages.ThreadState threadState = (StoreThreadMessages.ThreadState) outline.d(channel, storeState.getForumPostMessageCounts());
        Integer numValueOf = threadState != null ? Integer.valueOf(threadState.getCount()) : null;
        Long l = (Long) outline.d(channel, storeState.getMostRecentMessageIds());
        Long lValueOf2 = l != null ? Long.valueOf((l.longValue() >>> 22) + SnowflakeUtils.DISCORD_EPOCH) : null;
        ForumPostReadState forumPostReadStateCreateDefault = (ForumPostReadState) outline.d(channel, storeState.getForumPostReadStates());
        if (forumPostReadStateCreateDefault == null) {
            forumPostReadStateCreateDefault = ForumPostReadState.INSTANCE.createDefault(channel.getId());
        }
        ForumPostReadState forumPostReadState = forumPostReadStateCreateDefault;
        List<ForumTag> listD = storeState.getChannel().d();
        if (listD != null) {
            linkedHashMap = new LinkedHashMap(_Ranges.coerceAtLeast(MapsJVM.mapCapacity(Iterables2.collectionSizeOrDefault(listD, 10)), 16));
            for (Object obj : listD) {
                linkedHashMap.put(Long.valueOf(((ForumTag) obj).getId()), obj);
            }
        } else {
            linkedHashMap = null;
        }
        List<Long> listC = channel.c();
        if (listC != null) {
            ArrayList arrayList = new ArrayList();
            Iterator<T> it = listC.iterator();
            while (it.hasNext()) {
                long jLongValue = ((Number) it.next()).longValue();
                if (linkedHashMap == null || (forumTag = (ForumTag) linkedHashMap.get(Long.valueOf(jLongValue))) == null) {
                    postData2FromTag = null;
                } else if (forumTag.getCustomEmojiId() == null) {
                    z2 = false;
                    postData2FromTag = PostData2.INSTANCE.fromTag(forumTag, z2);
                } else {
                    Emoji emoji = storeState.getGuildEmojis().get(forumTag.getCustomEmojiId());
                    if ((emoji instanceof ModelEmojiCustom) && ((ModelEmojiCustom) emoji).isAnimated()) {
                        z2 = true;
                    }
                    postData2FromTag = PostData2.INSTANCE.fromTag(forumTag, z2);
                }
                if (postData2FromTag != null) {
                    arrayList.add(postData2FromTag);
                }
            }
            postData2 = (PostData2) _Collections.firstOrNull((List) arrayList);
        } else {
            postData2 = null;
        }
        MessageReaction messageReactionMostCommonReaction = message != null ? ForumUtils.INSTANCE.mostCommonReaction(message, this.storeEmoji) : null;
        boolean zIsDefaultPostReaction = messageReactionMostCommonReaction != null ? ForumUtils.INSTANCE.isDefaultPostReaction(messageReactionMostCommonReaction, this.storeEmoji) : false;
        Set set = (Set) outline.d(channel, storeState.getTypingUsers());
        if (set != null) {
            ArrayList arrayList2 = new ArrayList();
            Iterator it2 = set.iterator();
            while (it2.hasNext()) {
                long jLongValue2 = ((Number) it2.next()).longValue();
                User user2 = storeState.getUsers().get(Long.valueOf(jLongValue2));
                UserGuildMember userGuildMember = (user2 == null || (guildMember = storeState.getGuildMembers().get(Long.valueOf(jLongValue2))) == null) ? null : new UserGuildMember(user2, guildMember);
                if (userGuildMember != null) {
                    arrayList2.add(userGuildMember);
                }
            }
            listEmptyList = _Collections.take(arrayList2, 3);
            if (listEmptyList == null) {
                listEmptyList = Collections2.emptyList();
            }
        }
        return new ForumBrowserItem.PostItem(new PostData(channel, user, storeState.getMeUser().getId(), storeState.getGuildMembers(), storeState.getGuildRoles(), storeState.getChannelNames(), message, z3, lValueOf2, numValueOf, postData2, messageReactionMostCommonReaction, zIsDefaultPostReaction, forumPostReadState, (Integer) outline.d(channel, storeState.getForumPostUnreadCounts()), listEmptyList));
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0033  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void handleStoreState(StoreState storeState) {
        boolean z2;
        if (storeState instanceof StoreState.Loaded) {
            StoreState.Loaded loaded = (StoreState.Loaded) storeState;
            boolean zIsEmpty = loaded.getActiveThreads().isEmpty();
            ArchivedThreadsStore.ThreadListingState archivedThreadsState = loaded.getArchivedThreadsState();
            boolean z3 = false;
            if (archivedThreadsState instanceof ArchivedThreadsStore.ThreadListingState.Uninitialized) {
                z2 = true;
            } else {
                if (archivedThreadsState instanceof ArchivedThreadsStore.ThreadListingState.Listing) {
                    ArchivedThreadsStore.ThreadListingState.Listing listing = (ArchivedThreadsStore.ThreadListingState.Listing) archivedThreadsState;
                    if (!listing.getThreads().isEmpty() || !listing.isLoadingMore()) {
                    }
                }
                z2 = false;
            }
            if (archivedThreadsState instanceof ArchivedThreadsStore.ThreadListingState.Listing) {
                ArchivedThreadsStore.ThreadListingState.Listing listing2 = (ArchivedThreadsStore.ThreadListingState.Listing) archivedThreadsState;
                if (listing2.getThreads().isEmpty() && !listing2.isLoadingMore()) {
                    z3 = true;
                }
            }
            NsfwPanelState nsfwPanelState = new NsfwPanelState(!StoreStream.INSTANCE.getGuildsNsfw().isGuildNsfwGateAgreed(loaded.getChannel().getGuildId()), loaded.getChannel().getNsfw(), loaded.getMeUser().getNsfwAllowance(), loaded.getChannel().getGuildId());
            if (!loaded.isThreadSyncedGuild()) {
                setupLoadingViewState(nsfwPanelState);
                return;
            }
            if (zIsEmpty && z2) {
                setupLoadingViewState(nsfwPanelState);
            } else if (zIsEmpty && z3) {
                setupEmptyViewState(loaded, nsfwPanelState);
            } else {
                setupListViewState(loaded, nsfwPanelState);
            }
        }
    }

    public static /* synthetic */ void maybeFetchForumPostFirstMessages$default(WidgetForumBrowserViewModel widgetForumBrowserViewModel, long j, long j2, boolean z2, int i, Object obj) {
        widgetForumBrowserViewModel.maybeFetchForumPostFirstMessages(j, j2, (i & 4) != 0 ? false : z2);
    }

    private final void setupEmptyViewState(StoreState.Loaded storeState, NsfwPanelState nsfwPanelState) {
        List listEmptyList = Collections2.emptyList();
        boolean canCreateForumChannelPosts = storeState.getCanCreateForumChannelPosts();
        String name = storeState.getChannel().getName();
        if (name == null) {
            name = "";
        }
        updateViewState(new ViewState.Loaded(nsfwPanelState, listEmptyList, canCreateForumChannelPosts, name, storeState.getChannel().getTopic(), storeState.getChannel().getId(), storeState.getChannel().getGuildId()));
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x0140  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void setupListViewState(StoreState.Loaded storeState, NsfwPanelState nsfwPanelState) {
        if (this.lastSelectedForumChannelId != storeState.getChannel().getId()) {
            this.lastSelectedForumChannelId = storeState.getChannel().getId();
            this.eventSubject.k.onNext(Event.ScrollToTop.INSTANCE);
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        ArrayList arrayList = new ArrayList();
        AnonymousClass1 anonymousClass1 = new AnonymousClass1(linkedHashSet, storeState);
        Sequence sequenceAsSequence = _Maps.asSequence(storeState.getActiveThreads());
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        for (Object obj : sequenceAsSequence) {
            if (ChannelUtils.A((Channel) ((Map.Entry) obj).getValue())) {
                arrayList2.add(obj);
            } else {
                arrayList3.add(obj);
            }
        }
        Tuples2 tuples2 = new Tuples2(arrayList2, arrayList3);
        List list = (List) tuples2.component1();
        List list2 = (List) tuples2.component2();
        ArrayList arrayList4 = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            ForumBrowserItem.PostItem postItemInvoke2 = anonymousClass1.invoke2((Channel) ((Map.Entry) it.next()).getValue());
            if (postItemInvoke2 != null) {
                arrayList4.add(postItemInvoke2);
            }
        }
        List listSortedWith = _Collections.sortedWith(arrayList4, ForumBrowserItem.INSTANCE.getPostItemComparatorByMostRecent());
        ArrayList arrayList5 = new ArrayList();
        Iterator it2 = list2.iterator();
        while (it2.hasNext()) {
            ForumBrowserItem.PostItem postItemInvoke22 = anonymousClass1.invoke2((Channel) ((Map.Entry) it2.next()).getValue());
            if (postItemInvoke22 != null) {
                arrayList5.add(postItemInvoke22);
            }
        }
        ForumBrowserItem.Companion companion = ForumBrowserItem.INSTANCE;
        List listSortedWith2 = _Collections.sortedWith(arrayList5, companion.getPostItemComparatorByMostRecent());
        arrayList.addAll(listSortedWith);
        arrayList.addAll(listSortedWith2);
        List<Channel> threads = storeState.getArchivedThreadsState() instanceof ArchivedThreadsStore.ThreadListingState.Listing ? ((ArchivedThreadsStore.ThreadListingState.Listing) storeState.getArchivedThreadsState()).getThreads() : Collections2.emptyList();
        boolean z2 = true;
        if (!threads.isEmpty()) {
            arrayList.add(new ForumBrowserItem.HeaderItem(R.string.forum_section_archived));
            MutableCollections.addAll(arrayList, _Sequences2.sortedWith(_Sequences2.mapNotNull(_Collections.asSequence(threads), new WidgetForumBrowserViewModel4(anonymousClass1)), companion.getPostItemComparatorByMostRecent()));
        }
        if ((storeState.getArchivedThreadsState() instanceof ArchivedThreadsStore.ThreadListingState.Listing) && ((ArchivedThreadsStore.ThreadListingState.Listing) storeState.getArchivedThreadsState()).isLoadingMore()) {
            arrayList.add(ForumBrowserItem.LoadingItem.INSTANCE);
        }
        ArchivedThreadsStore.ThreadListingState archivedThreadsState = storeState.getArchivedThreadsState();
        if (!(archivedThreadsState instanceof ArchivedThreadsStore.ThreadListingState.Error)) {
            if (!(archivedThreadsState instanceof ArchivedThreadsStore.ThreadListingState.Uninitialized)) {
                if (!(archivedThreadsState instanceof ArchivedThreadsStore.ThreadListingState.Listing)) {
                    throw new NoWhenBranchMatchedException();
                }
                if (!((ArchivedThreadsStore.ThreadListingState.Listing) storeState.getArchivedThreadsState()).getHasMore() || ((ArchivedThreadsStore.ThreadListingState.Listing) storeState.getArchivedThreadsState()).isLoadingMore()) {
                    z2 = false;
                }
            }
        }
        this.canFetchMoreOlderPosts = z2;
        this.guildMemberRequester.performQueuedRequests();
        boolean canCreateForumChannelPosts = storeState.getCanCreateForumChannelPosts();
        String name = storeState.getChannel().getName();
        if (name == null) {
            name = "";
        }
        updateViewState(new ViewState.Loaded(nsfwPanelState, arrayList, canCreateForumChannelPosts, name, storeState.getChannel().getTopic(), storeState.getChannel().getId(), storeState.getChannel().getGuildId()));
    }

    private final void setupLoadingViewState(NsfwPanelState nsfwPanelState) {
        updateViewState(new ViewState.Loading(nsfwPanelState));
    }

    @MainThread
    public final void enqueueForumPostFirstMessageFetch(long channelId, long guildId, long postId) {
        if (ForumUtils.canAccessRedesignedForumChannels$default(ForumUtils.INSTANCE, guildId, null, 2, null)) {
            this.storeForumPostMessages.enqueueForumPostFirstMessageFetch(channelId, postId);
        }
    }

    @MainThread
    public final void maybeFetchForumPostFirstMessages(long channelId, long guildId, boolean isInitialFetch) {
        if (ForumUtils.canAccessRedesignedForumChannels$default(ForumUtils.INSTANCE, guildId, null, 2, null)) {
            if (isInitialFetch && this.initialChannelActivePostFirstMessageFetches.contains(Long.valueOf(channelId))) {
                return;
            }
            if (isInitialFetch) {
                this.initialChannelActivePostFirstMessageFetches.add(Long.valueOf(channelId));
            }
            this.storeForumPostMessages.flushForumPostFirstMessageQueue(channelId);
        }
    }

    @MainThread
    public final void maybeFetchOlderPosts(long channelId, long guildId) {
        if (ForumUtils.canAccessRedesignedForumChannels$default(ForumUtils.INSTANCE, guildId, null, 2, null) && this.canFetchMoreOlderPosts && !this.isFetchingMoreOlderPosts) {
            this.isFetchingMoreOlderPosts = true;
            ArchivedThreadsStore.fetchGuildForumThreadListing$default(this.storeArchivedThreads, channelId, false, new AnonymousClass1(), 2, null);
        }
    }

    public final Observable<Event> observeEvents() {
        PublishSubject<Event> publishSubject = this.eventSubject;
        Intrinsics3.checkNotNullExpressionValue(publishSubject, "eventSubject");
        return publishSubject;
    }

    @MainThread
    public final void requestForumUnreads(long channelId, long guildId) {
        if (ForumUtils.canAccessRedesignedForumChannels$default(ForumUtils.INSTANCE, guildId, null, 2, null)) {
            this.storeForumPostReadStates.requestForumUnreads(guildId, channelId);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetForumBrowserViewModel(StoreUser storeUser, StoreChannels storeChannels, StoreGuilds storeGuilds, ArchivedThreadsStore archivedThreadsStore, StoreThreadsActive storeThreadsActive, StoreThreadMessages storeThreadMessages, StoreForumPostMessages storeForumPostMessages, StoreUserRelationships storeUserRelationships, StoreGuildMemberRequester storeGuildMemberRequester, StoreChannelsSelected storeChannelsSelected, StoreTabsNavigation storeTabsNavigation, StoreExperiments storeExperiments, StorePermissions storePermissions, StoreMessagesMostRecent storeMessagesMostRecent, StoreEmoji storeEmoji, StoreForumPostReadStates storeForumPostReadStates, StoreUserTyping storeUserTyping, Observable<StoreState> observable) {
        super(null, 1, null);
        Intrinsics3.checkNotNullParameter(storeUser, "storeUser");
        Intrinsics3.checkNotNullParameter(storeChannels, "storeChannels");
        Intrinsics3.checkNotNullParameter(storeGuilds, "storeGuilds");
        Intrinsics3.checkNotNullParameter(archivedThreadsStore, "storeArchivedThreads");
        Intrinsics3.checkNotNullParameter(storeThreadsActive, "storeThreadsActive");
        Intrinsics3.checkNotNullParameter(storeThreadMessages, "storeThreadsMessages");
        Intrinsics3.checkNotNullParameter(storeForumPostMessages, "storeForumPostMessages");
        Intrinsics3.checkNotNullParameter(storeUserRelationships, "storeUserRelationships");
        Intrinsics3.checkNotNullParameter(storeGuildMemberRequester, "guildMemberRequester");
        Intrinsics3.checkNotNullParameter(storeChannelsSelected, "storeChannelsSelected");
        Intrinsics3.checkNotNullParameter(storeTabsNavigation, "storeTabsNavigation");
        Intrinsics3.checkNotNullParameter(storeExperiments, "storeExperiments");
        Intrinsics3.checkNotNullParameter(storePermissions, "storePermissions");
        Intrinsics3.checkNotNullParameter(storeMessagesMostRecent, "storeMessagesMostRecent");
        Intrinsics3.checkNotNullParameter(storeEmoji, "storeEmoji");
        Intrinsics3.checkNotNullParameter(storeForumPostReadStates, "storeForumPostReadStates");
        Intrinsics3.checkNotNullParameter(storeUserTyping, "storeUserTyping");
        Intrinsics3.checkNotNullParameter(observable, "storeStateObservable");
        this.storeUser = storeUser;
        this.storeChannels = storeChannels;
        this.storeGuilds = storeGuilds;
        this.storeArchivedThreads = archivedThreadsStore;
        this.storeThreadsActive = storeThreadsActive;
        this.storeThreadsMessages = storeThreadMessages;
        this.storeForumPostMessages = storeForumPostMessages;
        this.storeUserRelationships = storeUserRelationships;
        this.guildMemberRequester = storeGuildMemberRequester;
        this.storeChannelsSelected = storeChannelsSelected;
        this.storeTabsNavigation = storeTabsNavigation;
        this.storeExperiments = storeExperiments;
        this.storePermissions = storePermissions;
        this.storeMessagesMostRecent = storeMessagesMostRecent;
        this.storeEmoji = storeEmoji;
        this.storeForumPostReadStates = storeForumPostReadStates;
        this.storeUserTyping = storeUserTyping;
        this.eventSubject = PublishSubject.k0();
        this.initialChannelActivePostFirstMessageFetches = new LinkedHashSet();
        Observable observableR = ObservableExtensionsKt.computationLatest(observable).r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "storeStateObservable\n   …  .distinctUntilChanged()");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(observableR, this, null, 2, null), WidgetForumBrowserViewModel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(), 62, (Object) null);
        ForumPostReadStateManager.initialize$default(ForumPostReadStateManager.INSTANCE, null, null, null, 7, null);
    }
}

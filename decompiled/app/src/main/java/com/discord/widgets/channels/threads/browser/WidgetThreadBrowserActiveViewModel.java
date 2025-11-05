package com.discord.widgets.channels.threads.browser;

import android.content.Context;
import androidx.annotation.MainThread;
import b.a.d.d0;
import b.d.b.a.a;
import com.discord.R;
import com.discord.api.channel.Channel;
import com.discord.api.role.GuildRole;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.guild.Guild;
import com.discord.models.member.GuildMember;
import com.discord.models.message.Message;
import com.discord.models.user.MeUser;
import com.discord.models.user.User;
import com.discord.stores.StoreChannels;
import com.discord.stores.StoreGuildMemberRequester;
import com.discord.stores.StoreGuilds;
import com.discord.stores.StorePermissions;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreThreadMessages;
import com.discord.stores.StoreThreadsActive;
import com.discord.stores.StoreThreadsActiveJoined;
import com.discord.stores.StoreUser;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.threads.ThreadUtils;
import com.discord.widgets.channels.threads.browser.ThreadBrowserThreadView;
import com.discord.widgets.channels.threads.browser.WidgetThreadBrowserAdapter;
import d0.t.n;
import d0.z.d.m;
import d0.z.d.o;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import kotlin.Triple;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* compiled from: WidgetThreadBrowserActiveViewModel.kt */
/* loaded from: classes2.dex */
public final class WidgetThreadBrowserActiveViewModel extends d0<ViewState> {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final long channelId;
    private final long guildId;
    private final StoreChannels storeChannels;
    private final StoreGuildMemberRequester storeGuildMemberRequester;
    private final StoreGuilds storeGuilds;
    private final StorePermissions storePermissions;
    private final StoreThreadMessages storeThreadMessages;
    private final StoreThreadsActive storeThreadsActive;
    private final StoreThreadsActiveJoined storeThreadsActiveJoined;
    private final StoreUser storeUser;

    /* compiled from: WidgetThreadBrowserActiveViewModel.kt */
    /* renamed from: com.discord.widgets.channels.threads.browser.WidgetThreadBrowserActiveViewModel$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function1<StoreState, Unit> {
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
            m.checkNotNullParameter(storeState, "storeState");
            WidgetThreadBrowserActiveViewModel.access$handleStoreState(WidgetThreadBrowserActiveViewModel.this, storeState);
        }
    }

    /* compiled from: WidgetThreadBrowserActiveViewModel.kt */
    public static final class Companion {
        private Companion() {
        }

        public static final /* synthetic */ Observable access$observeStoreState(Companion companion, long j, long j2, StoreUser storeUser, StoreThreadsActive storeThreadsActive, StoreThreadsActiveJoined storeThreadsActiveJoined, StoreThreadMessages storeThreadMessages, StoreGuilds storeGuilds, StoreChannels storeChannels, StorePermissions storePermissions) {
            return companion.observeStoreState(j, j2, storeUser, storeThreadsActive, storeThreadsActiveJoined, storeThreadMessages, storeGuilds, storeChannels, storePermissions);
        }

        private final Observable<StoreState> observeStoreState(long guildId, long channelId, StoreUser storeUser, StoreThreadsActive storeThreadsActive, StoreThreadsActiveJoined storeThreadsActiveJoined, StoreThreadMessages storeThreadMessages, StoreGuilds storeGuilds, StoreChannels storeChannels, StorePermissions storePermissions) {
            Observable<StoreState> observableY = Observable.j(storeThreadsActiveJoined.observeActiveJoinedThreadsForChannel(guildId, channelId).G(WidgetThreadBrowserActiveViewModel$Companion$observeStoreState$1.INSTANCE), storeThreadsActive.observeActiveThreadsForChannel(guildId, Long.valueOf(channelId)), WidgetThreadBrowserActiveViewModel$Companion$observeStoreState$2.INSTANCE).Y(new WidgetThreadBrowserActiveViewModel$Companion$observeStoreState$3(storeUser, storeThreadMessages, storeGuilds, guildId, storeChannels, storePermissions, channelId));
            m.checkNotNullExpressionValue(observableY, "Observable.combineLatest…            }\n          }");
            return observableY;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetThreadBrowserActiveViewModel.kt */
    public static final /* data */ class StoreState {
        private final Map<Long, Channel> activeJoinedThreads;
        private final Map<Long, Channel> activeThreads;
        private final Map<Long, Integer> blockedUsers;
        private final Channel channel;
        private final Map<Long, String> channelNames;
        private final Guild guild;
        private final Map<Long, GuildMember> guildMembers;
        private final Map<Long, GuildRole> guildRoles;
        private final MeUser meUser;
        private final Long permissions;
        private final Map<Long, StoreThreadMessages.ThreadState> threadStates;
        private final Map<Long, User> users;

        /* JADX WARN: Multi-variable type inference failed */
        public StoreState(MeUser meUser, Map<Long, Channel> map, Map<Long, Channel> map2, Map<Long, StoreThreadMessages.ThreadState> map3, Map<Long, GuildMember> map4, Map<Long, ? extends User> map5, Map<Long, GuildRole> map6, Map<Long, String> map7, Long l, Map<Long, Integer> map8, Channel channel, Guild guild) {
            m.checkNotNullParameter(meUser, "meUser");
            m.checkNotNullParameter(map, "activeJoinedThreads");
            m.checkNotNullParameter(map2, "activeThreads");
            m.checkNotNullParameter(map3, "threadStates");
            m.checkNotNullParameter(map4, "guildMembers");
            m.checkNotNullParameter(map5, "users");
            m.checkNotNullParameter(map6, "guildRoles");
            m.checkNotNullParameter(map7, "channelNames");
            m.checkNotNullParameter(map8, "blockedUsers");
            this.meUser = meUser;
            this.activeJoinedThreads = map;
            this.activeThreads = map2;
            this.threadStates = map3;
            this.guildMembers = map4;
            this.users = map5;
            this.guildRoles = map6;
            this.channelNames = map7;
            this.permissions = l;
            this.blockedUsers = map8;
            this.channel = channel;
            this.guild = guild;
        }

        public static /* synthetic */ StoreState copy$default(StoreState storeState, MeUser meUser, Map map, Map map2, Map map3, Map map4, Map map5, Map map6, Map map7, Long l, Map map8, Channel channel, Guild guild, int i, Object obj) {
            return storeState.copy((i & 1) != 0 ? storeState.meUser : meUser, (i & 2) != 0 ? storeState.activeJoinedThreads : map, (i & 4) != 0 ? storeState.activeThreads : map2, (i & 8) != 0 ? storeState.threadStates : map3, (i & 16) != 0 ? storeState.guildMembers : map4, (i & 32) != 0 ? storeState.users : map5, (i & 64) != 0 ? storeState.guildRoles : map6, (i & 128) != 0 ? storeState.channelNames : map7, (i & 256) != 0 ? storeState.permissions : l, (i & 512) != 0 ? storeState.blockedUsers : map8, (i & 1024) != 0 ? storeState.channel : channel, (i & 2048) != 0 ? storeState.guild : guild);
        }

        /* renamed from: component1, reason: from getter */
        public final MeUser getMeUser() {
            return this.meUser;
        }

        public final Map<Long, Integer> component10() {
            return this.blockedUsers;
        }

        /* renamed from: component11, reason: from getter */
        public final Channel getChannel() {
            return this.channel;
        }

        /* renamed from: component12, reason: from getter */
        public final Guild getGuild() {
            return this.guild;
        }

        public final Map<Long, Channel> component2() {
            return this.activeJoinedThreads;
        }

        public final Map<Long, Channel> component3() {
            return this.activeThreads;
        }

        public final Map<Long, StoreThreadMessages.ThreadState> component4() {
            return this.threadStates;
        }

        public final Map<Long, GuildMember> component5() {
            return this.guildMembers;
        }

        public final Map<Long, User> component6() {
            return this.users;
        }

        public final Map<Long, GuildRole> component7() {
            return this.guildRoles;
        }

        public final Map<Long, String> component8() {
            return this.channelNames;
        }

        /* renamed from: component9, reason: from getter */
        public final Long getPermissions() {
            return this.permissions;
        }

        public final StoreState copy(MeUser meUser, Map<Long, Channel> activeJoinedThreads, Map<Long, Channel> activeThreads, Map<Long, StoreThreadMessages.ThreadState> threadStates, Map<Long, GuildMember> guildMembers, Map<Long, ? extends User> users, Map<Long, GuildRole> guildRoles, Map<Long, String> channelNames, Long permissions, Map<Long, Integer> blockedUsers, Channel channel, Guild guild) {
            m.checkNotNullParameter(meUser, "meUser");
            m.checkNotNullParameter(activeJoinedThreads, "activeJoinedThreads");
            m.checkNotNullParameter(activeThreads, "activeThreads");
            m.checkNotNullParameter(threadStates, "threadStates");
            m.checkNotNullParameter(guildMembers, "guildMembers");
            m.checkNotNullParameter(users, "users");
            m.checkNotNullParameter(guildRoles, "guildRoles");
            m.checkNotNullParameter(channelNames, "channelNames");
            m.checkNotNullParameter(blockedUsers, "blockedUsers");
            return new StoreState(meUser, activeJoinedThreads, activeThreads, threadStates, guildMembers, users, guildRoles, channelNames, permissions, blockedUsers, channel, guild);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof StoreState)) {
                return false;
            }
            StoreState storeState = (StoreState) other;
            return m.areEqual(this.meUser, storeState.meUser) && m.areEqual(this.activeJoinedThreads, storeState.activeJoinedThreads) && m.areEqual(this.activeThreads, storeState.activeThreads) && m.areEqual(this.threadStates, storeState.threadStates) && m.areEqual(this.guildMembers, storeState.guildMembers) && m.areEqual(this.users, storeState.users) && m.areEqual(this.guildRoles, storeState.guildRoles) && m.areEqual(this.channelNames, storeState.channelNames) && m.areEqual(this.permissions, storeState.permissions) && m.areEqual(this.blockedUsers, storeState.blockedUsers) && m.areEqual(this.channel, storeState.channel) && m.areEqual(this.guild, storeState.guild);
        }

        public final Map<Long, Channel> getActiveJoinedThreads() {
            return this.activeJoinedThreads;
        }

        public final Map<Long, Channel> getActiveThreads() {
            return this.activeThreads;
        }

        public final Map<Long, Integer> getBlockedUsers() {
            return this.blockedUsers;
        }

        public final Channel getChannel() {
            return this.channel;
        }

        public final Map<Long, String> getChannelNames() {
            return this.channelNames;
        }

        public final Guild getGuild() {
            return this.guild;
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

        public final Long getPermissions() {
            return this.permissions;
        }

        public final Map<Long, StoreThreadMessages.ThreadState> getThreadStates() {
            return this.threadStates;
        }

        public final Map<Long, User> getUsers() {
            return this.users;
        }

        public int hashCode() {
            MeUser meUser = this.meUser;
            int iHashCode = (meUser != null ? meUser.hashCode() : 0) * 31;
            Map<Long, Channel> map = this.activeJoinedThreads;
            int iHashCode2 = (iHashCode + (map != null ? map.hashCode() : 0)) * 31;
            Map<Long, Channel> map2 = this.activeThreads;
            int iHashCode3 = (iHashCode2 + (map2 != null ? map2.hashCode() : 0)) * 31;
            Map<Long, StoreThreadMessages.ThreadState> map3 = this.threadStates;
            int iHashCode4 = (iHashCode3 + (map3 != null ? map3.hashCode() : 0)) * 31;
            Map<Long, GuildMember> map4 = this.guildMembers;
            int iHashCode5 = (iHashCode4 + (map4 != null ? map4.hashCode() : 0)) * 31;
            Map<Long, User> map5 = this.users;
            int iHashCode6 = (iHashCode5 + (map5 != null ? map5.hashCode() : 0)) * 31;
            Map<Long, GuildRole> map6 = this.guildRoles;
            int iHashCode7 = (iHashCode6 + (map6 != null ? map6.hashCode() : 0)) * 31;
            Map<Long, String> map7 = this.channelNames;
            int iHashCode8 = (iHashCode7 + (map7 != null ? map7.hashCode() : 0)) * 31;
            Long l = this.permissions;
            int iHashCode9 = (iHashCode8 + (l != null ? l.hashCode() : 0)) * 31;
            Map<Long, Integer> map8 = this.blockedUsers;
            int iHashCode10 = (iHashCode9 + (map8 != null ? map8.hashCode() : 0)) * 31;
            Channel channel = this.channel;
            int iHashCode11 = (iHashCode10 + (channel != null ? channel.hashCode() : 0)) * 31;
            Guild guild = this.guild;
            return iHashCode11 + (guild != null ? guild.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = a.U("StoreState(meUser=");
            sbU.append(this.meUser);
            sbU.append(", activeJoinedThreads=");
            sbU.append(this.activeJoinedThreads);
            sbU.append(", activeThreads=");
            sbU.append(this.activeThreads);
            sbU.append(", threadStates=");
            sbU.append(this.threadStates);
            sbU.append(", guildMembers=");
            sbU.append(this.guildMembers);
            sbU.append(", users=");
            sbU.append(this.users);
            sbU.append(", guildRoles=");
            sbU.append(this.guildRoles);
            sbU.append(", channelNames=");
            sbU.append(this.channelNames);
            sbU.append(", permissions=");
            sbU.append(this.permissions);
            sbU.append(", blockedUsers=");
            sbU.append(this.blockedUsers);
            sbU.append(", channel=");
            sbU.append(this.channel);
            sbU.append(", guild=");
            sbU.append(this.guild);
            sbU.append(")");
            return sbU.toString();
        }
    }

    /* compiled from: WidgetThreadBrowserActiveViewModel.kt */
    public static final /* data */ class ViewState {
        private final boolean canCreateThread;
        private final List<WidgetThreadBrowserAdapter.Item> listItems;

        /* JADX WARN: Multi-variable type inference failed */
        public ViewState(List<? extends WidgetThreadBrowserAdapter.Item> list, boolean z2) {
            m.checkNotNullParameter(list, "listItems");
            this.listItems = list;
            this.canCreateThread = z2;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ ViewState copy$default(ViewState viewState, List list, boolean z2, int i, Object obj) {
            if ((i & 1) != 0) {
                list = viewState.listItems;
            }
            if ((i & 2) != 0) {
                z2 = viewState.canCreateThread;
            }
            return viewState.copy(list, z2);
        }

        public final List<WidgetThreadBrowserAdapter.Item> component1() {
            return this.listItems;
        }

        /* renamed from: component2, reason: from getter */
        public final boolean getCanCreateThread() {
            return this.canCreateThread;
        }

        public final ViewState copy(List<? extends WidgetThreadBrowserAdapter.Item> listItems, boolean canCreateThread) {
            m.checkNotNullParameter(listItems, "listItems");
            return new ViewState(listItems, canCreateThread);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ViewState)) {
                return false;
            }
            ViewState viewState = (ViewState) other;
            return m.areEqual(this.listItems, viewState.listItems) && this.canCreateThread == viewState.canCreateThread;
        }

        public final boolean getCanCreateThread() {
            return this.canCreateThread;
        }

        public final List<WidgetThreadBrowserAdapter.Item> getListItems() {
            return this.listItems;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            List<WidgetThreadBrowserAdapter.Item> list = this.listItems;
            int iHashCode = (list != null ? list.hashCode() : 0) * 31;
            boolean z2 = this.canCreateThread;
            int i = z2;
            if (z2 != 0) {
                i = 1;
            }
            return iHashCode + i;
        }

        public String toString() {
            StringBuilder sbU = a.U("ViewState(listItems=");
            sbU.append(this.listItems);
            sbU.append(", canCreateThread=");
            return a.O(sbU, this.canCreateThread, ")");
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ WidgetThreadBrowserActiveViewModel(long j, long j2, StoreUser storeUser, StoreGuildMemberRequester storeGuildMemberRequester, StoreThreadsActive storeThreadsActive, StoreThreadsActiveJoined storeThreadsActiveJoined, StoreThreadMessages storeThreadMessages, StoreGuilds storeGuilds, StoreChannels storeChannels, StorePermissions storePermissions, Observable observable, int i, DefaultConstructorMarker defaultConstructorMarker) {
        StoreUser users = (i & 4) != 0 ? StoreStream.INSTANCE.getUsers() : storeUser;
        StoreGuildMemberRequester guildMemberRequester = (i & 8) != 0 ? StoreStream.INSTANCE.getGuildMemberRequester() : storeGuildMemberRequester;
        StoreThreadsActive threadsActive = (i & 16) != 0 ? StoreStream.INSTANCE.getThreadsActive() : storeThreadsActive;
        StoreThreadsActiveJoined threadsActiveJoined = (i & 32) != 0 ? StoreStream.INSTANCE.getThreadsActiveJoined() : storeThreadsActiveJoined;
        StoreThreadMessages threadMessages = (i & 64) != 0 ? StoreStream.INSTANCE.getThreadMessages() : storeThreadMessages;
        StoreGuilds guilds = (i & 128) != 0 ? StoreStream.INSTANCE.getGuilds() : storeGuilds;
        StoreChannels channels = (i & 256) != 0 ? StoreStream.INSTANCE.getChannels() : storeChannels;
        StorePermissions permissions = (i & 512) != 0 ? StoreStream.INSTANCE.getPermissions() : storePermissions;
        this(j, j2, users, guildMemberRequester, threadsActive, threadsActiveJoined, threadMessages, guilds, channels, permissions, (i & 1024) != 0 ? Companion.access$observeStoreState(INSTANCE, j, j2, users, threadsActive, threadsActiveJoined, threadMessages, guilds, channels, permissions) : observable);
    }

    public static final /* synthetic */ void access$handleStoreState(WidgetThreadBrowserActiveViewModel widgetThreadBrowserActiveViewModel, StoreState storeState) {
        widgetThreadBrowserActiveViewModel.handleStoreState(storeState);
    }

    @MainThread
    private final void handleStoreState(StoreState storeState) {
        int i;
        Iterator it;
        Iterator it2;
        com.discord.api.user.User author;
        com.discord.api.user.User author2;
        ArrayList arrayList = new ArrayList();
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        boolean z2 = true;
        List listListOf = n.listOf((Object[]) new Triple[]{new Triple("joined", Integer.valueOf(R.string.thread_browser_joined_header), storeState.getActiveJoinedThreads()), new Triple("other", Integer.valueOf(R.string.thread_browser_other_header), storeState.getActiveThreads())});
        Channel channel = storeState.getChannel();
        Message message = null;
        if (channel != null && channel.getType() == 15) {
            arrayList.add(new WidgetThreadBrowserAdapter.Item.Warning(null, 1, null));
        }
        Iterator it3 = listListOf.iterator();
        while (it3.hasNext()) {
            Triple triple = (Triple) it3.next();
            String str = (String) triple.component1();
            int iIntValue = ((Number) triple.component2()).intValue();
            Map map = (Map) triple.component3();
            if (map.isEmpty()) {
                i = 0;
            } else {
                Iterator it4 = map.entrySet().iterator();
                i = 0;
                while (it4.hasNext()) {
                    if (linkedHashSet.contains(Long.valueOf(((Number) ((Map.Entry) it4.next()).getKey()).longValue())) ^ z2) {
                        i++;
                    }
                }
            }
            if (i != 0) {
                arrayList.add(new WidgetThreadBrowserAdapter.Item.Header(str, iIntValue, i));
                Iterator it5 = map.entrySet().iterator();
                while (it5.hasNext()) {
                    Map.Entry entry = (Map.Entry) it5.next();
                    long jLongValue = ((Number) entry.getKey()).longValue();
                    Channel channel2 = (Channel) entry.getValue();
                    if (linkedHashSet.contains(Long.valueOf(jLongValue))) {
                        it = it3;
                        it2 = it5;
                    } else {
                        User user = storeState.getUsers().get(Long.valueOf(channel2.getOwnerId()));
                        if (user == null || !storeState.getGuildMembers().containsKey(Long.valueOf(channel2.getOwnerId()))) {
                            this.storeGuildMemberRequester.queueRequest(channel2.getGuildId(), channel2.getOwnerId());
                        }
                        StoreThreadMessages.ThreadState threadState = storeState.getThreadStates().get(Long.valueOf(jLongValue));
                        Message mostRecentMessage = threadState != null ? threadState.getMostRecentMessage() : message;
                        if (mostRecentMessage == null || (author2 = mostRecentMessage.getAuthor()) == null || storeState.getGuildMembers().containsKey(Long.valueOf(author2.getId()))) {
                            it = it3;
                            it2 = it5;
                        } else {
                            it = it3;
                            it2 = it5;
                            this.storeGuildMemberRequester.queueRequest(channel2.getGuildId(), author2.getId());
                        }
                        arrayList.add(new WidgetThreadBrowserAdapter.Item.Thread(new ThreadBrowserThreadView.ThreadData.ActiveThread(channel2, user, mostRecentMessage, storeState.getMeUser().getId(), storeState.getGuildMembers(), storeState.getGuildRoles(), storeState.getChannelNames(), storeState.getBlockedUsers().containsKey((mostRecentMessage == null || (author = mostRecentMessage.getAuthor()) == null) ? null : Long.valueOf(author.getId())))));
                        linkedHashSet.add(Long.valueOf(jLongValue));
                    }
                    it3 = it;
                    it5 = it2;
                    message = null;
                }
            }
            it3 = it3;
            z2 = true;
            message = null;
        }
        if (linkedHashSet.isEmpty()) {
            arrayList.clear();
        }
        this.storeGuildMemberRequester.performQueuedRequests();
        updateViewState(new ViewState(arrayList, ThreadUtils.INSTANCE.canCreateThread(storeState.getPermissions(), storeState.getChannel(), null, storeState.getGuild())));
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetThreadBrowserActiveViewModel(long j, long j2, StoreUser storeUser, StoreGuildMemberRequester storeGuildMemberRequester, StoreThreadsActive storeThreadsActive, StoreThreadsActiveJoined storeThreadsActiveJoined, StoreThreadMessages storeThreadMessages, StoreGuilds storeGuilds, StoreChannels storeChannels, StorePermissions storePermissions, Observable<StoreState> observable) {
        super(null, 1, null);
        m.checkNotNullParameter(storeUser, "storeUser");
        m.checkNotNullParameter(storeGuildMemberRequester, "storeGuildMemberRequester");
        m.checkNotNullParameter(storeThreadsActive, "storeThreadsActive");
        m.checkNotNullParameter(storeThreadsActiveJoined, "storeThreadsActiveJoined");
        m.checkNotNullParameter(storeThreadMessages, "storeThreadMessages");
        m.checkNotNullParameter(storeGuilds, "storeGuilds");
        m.checkNotNullParameter(storeChannels, "storeChannels");
        m.checkNotNullParameter(storePermissions, "storePermissions");
        m.checkNotNullParameter(observable, "storeStateObservable");
        this.guildId = j;
        this.channelId = j2;
        this.storeUser = storeUser;
        this.storeGuildMemberRequester = storeGuildMemberRequester;
        this.storeThreadsActive = storeThreadsActive;
        this.storeThreadsActiveJoined = storeThreadsActiveJoined;
        this.storeThreadMessages = storeThreadMessages;
        this.storeGuilds = storeGuilds;
        this.storeChannels = storeChannels;
        this.storePermissions = storePermissions;
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(observable, this, null, 2, null), WidgetThreadBrowserActiveViewModel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(), 62, (Object) null);
    }
}

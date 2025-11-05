package com.discord.widgets.channels.threads.browser;

import android.content.Context;
import androidx.annotation.MainThread;
import b.a.d.d0;
import b.d.b.a.a;
import com.discord.R;
import com.discord.api.channel.Channel;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.guild.Guild;
import com.discord.models.member.GuildMember;
import com.discord.models.user.User;
import com.discord.stores.ArchivedThreadsStore;
import com.discord.stores.StoreChannels;
import com.discord.stores.StoreGuildMemberRequester;
import com.discord.stores.StoreGuilds;
import com.discord.stores.StorePermissions;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUser;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.threads.ThreadUtils;
import com.discord.widgets.channels.threads.browser.ThreadBrowserThreadView;
import com.discord.widgets.channels.threads.browser.WidgetThreadBrowserAdapter;
import d0.z.d.m;
import d0.z.d.o;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.subjects.BehaviorSubject;

/* compiled from: WidgetThreadBrowserArchivedViewModel.kt */
/* loaded from: classes2.dex */
public final class WidgetThreadBrowserArchivedViewModel extends d0<ViewState> {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private boolean canLoadMore;
    private final long channelId;
    private final long guildId;
    private final ArchivedThreadsStore storeArchivedThreads;
    private final StoreChannels storeChannels;
    private final StoreGuildMemberRequester storeGuildMemberRequester;
    private final StoreGuilds storeGuilds;
    private final StorePermissions storePermissions;
    private final Observable<StoreState> storeStateObservable;
    private final StoreUser storeUser;
    private final BehaviorSubject<ViewMode> viewModeSubject;

    /* compiled from: WidgetThreadBrowserArchivedViewModel.kt */
    /* renamed from: com.discord.widgets.channels.threads.browser.WidgetThreadBrowserArchivedViewModel$1, reason: invalid class name */
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
            WidgetThreadBrowserArchivedViewModel.access$handleStoreState(WidgetThreadBrowserArchivedViewModel.this, storeState);
        }
    }

    /* compiled from: WidgetThreadBrowserArchivedViewModel.kt */
    public static final class Companion {
        private Companion() {
        }

        public static final /* synthetic */ Observable access$observeStoreState(Companion companion, ViewMode viewMode, long j, long j2, StoreGuilds storeGuilds, StoreChannels storeChannels, StoreUser storeUser, ArchivedThreadsStore archivedThreadsStore, StorePermissions storePermissions) {
            return companion.observeStoreState(viewMode, j, j2, storeGuilds, storeChannels, storeUser, archivedThreadsStore, storePermissions);
        }

        private final Observable<StoreState> observeStoreState(ViewMode viewMode, long guildId, long channelId, StoreGuilds storeGuilds, StoreChannels storeChannels, StoreUser storeUser, ArchivedThreadsStore storeArchivedThreads, StorePermissions storePermissions) {
            Observable<StoreState> observableY = Observable.j(storeArchivedThreads.loadAndObserveThreadListing(channelId, viewMode.getThreadListingType()), storeChannels.observeChannel(channelId), WidgetThreadBrowserArchivedViewModel$Companion$observeStoreState$1.INSTANCE).Y(new WidgetThreadBrowserArchivedViewModel$Companion$observeStoreState$2(storeUser, storeGuilds, guildId, storePermissions, viewMode));
            m.checkNotNullExpressionValue(observableY, "Observable.combineLatest…            }\n          }");
            return observableY;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetThreadBrowserArchivedViewModel.kt */
    public static final /* data */ class StoreState {
        private final Channel channel;
        private final Guild guild;
        private final Map<Long, GuildMember> guildMembers;
        private final boolean isModerator;
        private final ArchivedThreadsStore.ThreadListingState listingState;
        private final Long permissions;
        private final Map<Long, User> users;
        private final ViewMode viewMode;

        /* JADX WARN: Multi-variable type inference failed */
        public StoreState(ViewMode viewMode, Map<Long, GuildMember> map, Map<Long, ? extends User> map2, ArchivedThreadsStore.ThreadListingState threadListingState, boolean z2, Channel channel, Guild guild, Long l) {
            m.checkNotNullParameter(viewMode, "viewMode");
            m.checkNotNullParameter(map, "guildMembers");
            m.checkNotNullParameter(map2, "users");
            m.checkNotNullParameter(threadListingState, "listingState");
            m.checkNotNullParameter(channel, "channel");
            this.viewMode = viewMode;
            this.guildMembers = map;
            this.users = map2;
            this.listingState = threadListingState;
            this.isModerator = z2;
            this.channel = channel;
            this.guild = guild;
            this.permissions = l;
        }

        public static /* synthetic */ StoreState copy$default(StoreState storeState, ViewMode viewMode, Map map, Map map2, ArchivedThreadsStore.ThreadListingState threadListingState, boolean z2, Channel channel, Guild guild, Long l, int i, Object obj) {
            return storeState.copy((i & 1) != 0 ? storeState.viewMode : viewMode, (i & 2) != 0 ? storeState.guildMembers : map, (i & 4) != 0 ? storeState.users : map2, (i & 8) != 0 ? storeState.listingState : threadListingState, (i & 16) != 0 ? storeState.isModerator : z2, (i & 32) != 0 ? storeState.channel : channel, (i & 64) != 0 ? storeState.guild : guild, (i & 128) != 0 ? storeState.permissions : l);
        }

        /* renamed from: component1, reason: from getter */
        public final ViewMode getViewMode() {
            return this.viewMode;
        }

        public final Map<Long, GuildMember> component2() {
            return this.guildMembers;
        }

        public final Map<Long, User> component3() {
            return this.users;
        }

        /* renamed from: component4, reason: from getter */
        public final ArchivedThreadsStore.ThreadListingState getListingState() {
            return this.listingState;
        }

        /* renamed from: component5, reason: from getter */
        public final boolean getIsModerator() {
            return this.isModerator;
        }

        /* renamed from: component6, reason: from getter */
        public final Channel getChannel() {
            return this.channel;
        }

        /* renamed from: component7, reason: from getter */
        public final Guild getGuild() {
            return this.guild;
        }

        /* renamed from: component8, reason: from getter */
        public final Long getPermissions() {
            return this.permissions;
        }

        public final StoreState copy(ViewMode viewMode, Map<Long, GuildMember> guildMembers, Map<Long, ? extends User> users, ArchivedThreadsStore.ThreadListingState listingState, boolean isModerator, Channel channel, Guild guild, Long permissions) {
            m.checkNotNullParameter(viewMode, "viewMode");
            m.checkNotNullParameter(guildMembers, "guildMembers");
            m.checkNotNullParameter(users, "users");
            m.checkNotNullParameter(listingState, "listingState");
            m.checkNotNullParameter(channel, "channel");
            return new StoreState(viewMode, guildMembers, users, listingState, isModerator, channel, guild, permissions);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof StoreState)) {
                return false;
            }
            StoreState storeState = (StoreState) other;
            return m.areEqual(this.viewMode, storeState.viewMode) && m.areEqual(this.guildMembers, storeState.guildMembers) && m.areEqual(this.users, storeState.users) && m.areEqual(this.listingState, storeState.listingState) && this.isModerator == storeState.isModerator && m.areEqual(this.channel, storeState.channel) && m.areEqual(this.guild, storeState.guild) && m.areEqual(this.permissions, storeState.permissions);
        }

        public final Channel getChannel() {
            return this.channel;
        }

        public final Guild getGuild() {
            return this.guild;
        }

        public final Map<Long, GuildMember> getGuildMembers() {
            return this.guildMembers;
        }

        public final ArchivedThreadsStore.ThreadListingState getListingState() {
            return this.listingState;
        }

        public final Long getPermissions() {
            return this.permissions;
        }

        public final Map<Long, User> getUsers() {
            return this.users;
        }

        public final ViewMode getViewMode() {
            return this.viewMode;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            ViewMode viewMode = this.viewMode;
            int iHashCode = (viewMode != null ? viewMode.hashCode() : 0) * 31;
            Map<Long, GuildMember> map = this.guildMembers;
            int iHashCode2 = (iHashCode + (map != null ? map.hashCode() : 0)) * 31;
            Map<Long, User> map2 = this.users;
            int iHashCode3 = (iHashCode2 + (map2 != null ? map2.hashCode() : 0)) * 31;
            ArchivedThreadsStore.ThreadListingState threadListingState = this.listingState;
            int iHashCode4 = (iHashCode3 + (threadListingState != null ? threadListingState.hashCode() : 0)) * 31;
            boolean z2 = this.isModerator;
            int i = z2;
            if (z2 != 0) {
                i = 1;
            }
            int i2 = (iHashCode4 + i) * 31;
            Channel channel = this.channel;
            int iHashCode5 = (i2 + (channel != null ? channel.hashCode() : 0)) * 31;
            Guild guild = this.guild;
            int iHashCode6 = (iHashCode5 + (guild != null ? guild.hashCode() : 0)) * 31;
            Long l = this.permissions;
            return iHashCode6 + (l != null ? l.hashCode() : 0);
        }

        public final boolean isModerator() {
            return this.isModerator;
        }

        public String toString() {
            StringBuilder sbU = a.U("StoreState(viewMode=");
            sbU.append(this.viewMode);
            sbU.append(", guildMembers=");
            sbU.append(this.guildMembers);
            sbU.append(", users=");
            sbU.append(this.users);
            sbU.append(", listingState=");
            sbU.append(this.listingState);
            sbU.append(", isModerator=");
            sbU.append(this.isModerator);
            sbU.append(", channel=");
            sbU.append(this.channel);
            sbU.append(", guild=");
            sbU.append(this.guild);
            sbU.append(", permissions=");
            return a.G(sbU, this.permissions, ")");
        }
    }

    /* compiled from: WidgetThreadBrowserArchivedViewModel.kt */
    public static final /* data */ class ViewMode {
        private final boolean isModeratorMode;
        private final ArchivedThreadsStore.ThreadListingType threadListingType;
        private final VisibilityMode visibility;

        public final /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                VisibilityMode.values();
                int[] iArr = new int[2];
                $EnumSwitchMapping$0 = iArr;
                iArr[VisibilityMode.PublicThreads.ordinal()] = 1;
            }
        }

        public ViewMode(VisibilityMode visibilityMode, boolean z2) {
            ArchivedThreadsStore.ThreadListingType threadListingType;
            m.checkNotNullParameter(visibilityMode, "visibility");
            this.visibility = visibilityMode;
            this.isModeratorMode = z2;
            if (visibilityMode.ordinal() == 0) {
                threadListingType = ArchivedThreadsStore.ThreadListingType.ALL_ARCHIVED_PUBLIC_THREADS;
            } else if (!z2) {
                threadListingType = ArchivedThreadsStore.ThreadListingType.MY_ARCHIVED_PRIVATE_THREADS;
            } else {
                if (!z2) {
                    throw new NoWhenBranchMatchedException();
                }
                threadListingType = ArchivedThreadsStore.ThreadListingType.ALL_ARCHIVED_PRIVATE_THREADS;
            }
            this.threadListingType = threadListingType;
        }

        public static /* synthetic */ ViewMode copy$default(ViewMode viewMode, VisibilityMode visibilityMode, boolean z2, int i, Object obj) {
            if ((i & 1) != 0) {
                visibilityMode = viewMode.visibility;
            }
            if ((i & 2) != 0) {
                z2 = viewMode.isModeratorMode;
            }
            return viewMode.copy(visibilityMode, z2);
        }

        /* renamed from: component1, reason: from getter */
        public final VisibilityMode getVisibility() {
            return this.visibility;
        }

        /* renamed from: component2, reason: from getter */
        public final boolean getIsModeratorMode() {
            return this.isModeratorMode;
        }

        public final ViewMode copy(VisibilityMode visibility, boolean isModeratorMode) {
            m.checkNotNullParameter(visibility, "visibility");
            return new ViewMode(visibility, isModeratorMode);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ViewMode)) {
                return false;
            }
            ViewMode viewMode = (ViewMode) other;
            return m.areEqual(this.visibility, viewMode.visibility) && this.isModeratorMode == viewMode.isModeratorMode;
        }

        public final ArchivedThreadsStore.ThreadListingType getThreadListingType() {
            return this.threadListingType;
        }

        public final VisibilityMode getVisibility() {
            return this.visibility;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            VisibilityMode visibilityMode = this.visibility;
            int iHashCode = (visibilityMode != null ? visibilityMode.hashCode() : 0) * 31;
            boolean z2 = this.isModeratorMode;
            int i = z2;
            if (z2 != 0) {
                i = 1;
            }
            return iHashCode + i;
        }

        public final boolean isModeratorMode() {
            return this.isModeratorMode;
        }

        public String toString() {
            StringBuilder sbU = a.U("ViewMode(visibility=");
            sbU.append(this.visibility);
            sbU.append(", isModeratorMode=");
            return a.O(sbU, this.isModeratorMode, ")");
        }
    }

    /* compiled from: WidgetThreadBrowserArchivedViewModel.kt */
    public static final /* data */ class ViewState {
        private final boolean canCreateThread;
        private final boolean isError;
        private final boolean isModerator;
        private final List<WidgetThreadBrowserAdapter.Item> listItems;
        private final ViewMode viewMode;

        /* JADX WARN: Multi-variable type inference failed */
        public ViewState(ViewMode viewMode, List<? extends WidgetThreadBrowserAdapter.Item> list, boolean z2, boolean z3, boolean z4) {
            m.checkNotNullParameter(viewMode, "viewMode");
            m.checkNotNullParameter(list, "listItems");
            this.viewMode = viewMode;
            this.listItems = list;
            this.isModerator = z2;
            this.isError = z3;
            this.canCreateThread = z4;
        }

        public static /* synthetic */ ViewState copy$default(ViewState viewState, ViewMode viewMode, List list, boolean z2, boolean z3, boolean z4, int i, Object obj) {
            if ((i & 1) != 0) {
                viewMode = viewState.viewMode;
            }
            if ((i & 2) != 0) {
                list = viewState.listItems;
            }
            List list2 = list;
            if ((i & 4) != 0) {
                z2 = viewState.isModerator;
            }
            boolean z5 = z2;
            if ((i & 8) != 0) {
                z3 = viewState.isError;
            }
            boolean z6 = z3;
            if ((i & 16) != 0) {
                z4 = viewState.canCreateThread;
            }
            return viewState.copy(viewMode, list2, z5, z6, z4);
        }

        /* renamed from: component1, reason: from getter */
        public final ViewMode getViewMode() {
            return this.viewMode;
        }

        public final List<WidgetThreadBrowserAdapter.Item> component2() {
            return this.listItems;
        }

        /* renamed from: component3, reason: from getter */
        public final boolean getIsModerator() {
            return this.isModerator;
        }

        /* renamed from: component4, reason: from getter */
        public final boolean getIsError() {
            return this.isError;
        }

        /* renamed from: component5, reason: from getter */
        public final boolean getCanCreateThread() {
            return this.canCreateThread;
        }

        public final ViewState copy(ViewMode viewMode, List<? extends WidgetThreadBrowserAdapter.Item> listItems, boolean isModerator, boolean isError, boolean canCreateThread) {
            m.checkNotNullParameter(viewMode, "viewMode");
            m.checkNotNullParameter(listItems, "listItems");
            return new ViewState(viewMode, listItems, isModerator, isError, canCreateThread);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ViewState)) {
                return false;
            }
            ViewState viewState = (ViewState) other;
            return m.areEqual(this.viewMode, viewState.viewMode) && m.areEqual(this.listItems, viewState.listItems) && this.isModerator == viewState.isModerator && this.isError == viewState.isError && this.canCreateThread == viewState.canCreateThread;
        }

        public final boolean getCanCreateThread() {
            return this.canCreateThread;
        }

        public final List<WidgetThreadBrowserAdapter.Item> getListItems() {
            return this.listItems;
        }

        public final ViewMode getViewMode() {
            return this.viewMode;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            ViewMode viewMode = this.viewMode;
            int iHashCode = (viewMode != null ? viewMode.hashCode() : 0) * 31;
            List<WidgetThreadBrowserAdapter.Item> list = this.listItems;
            int iHashCode2 = (iHashCode + (list != null ? list.hashCode() : 0)) * 31;
            boolean z2 = this.isModerator;
            int i = z2;
            if (z2 != 0) {
                i = 1;
            }
            int i2 = (iHashCode2 + i) * 31;
            boolean z3 = this.isError;
            int i3 = z3;
            if (z3 != 0) {
                i3 = 1;
            }
            int i4 = (i2 + i3) * 31;
            boolean z4 = this.canCreateThread;
            return i4 + (z4 ? 1 : z4 ? 1 : 0);
        }

        public final boolean isError() {
            return this.isError;
        }

        public final boolean isModerator() {
            return this.isModerator;
        }

        public String toString() {
            StringBuilder sbU = a.U("ViewState(viewMode=");
            sbU.append(this.viewMode);
            sbU.append(", listItems=");
            sbU.append(this.listItems);
            sbU.append(", isModerator=");
            sbU.append(this.isModerator);
            sbU.append(", isError=");
            sbU.append(this.isError);
            sbU.append(", canCreateThread=");
            return a.O(sbU, this.canCreateThread, ")");
        }
    }

    /* compiled from: WidgetThreadBrowserArchivedViewModel.kt */
    public enum VisibilityMode {
        PublicThreads,
        PrivateThreads
    }

    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            VisibilityMode.values();
            int[] iArr = new int[2];
            $EnumSwitchMapping$0 = iArr;
            iArr[VisibilityMode.PublicThreads.ordinal()] = 1;
            iArr[VisibilityMode.PrivateThreads.ordinal()] = 2;
            ArchivedThreadsStore.ThreadListingType.values();
            int[] iArr2 = new int[3];
            $EnumSwitchMapping$1 = iArr2;
            iArr2[ArchivedThreadsStore.ThreadListingType.ALL_ARCHIVED_PUBLIC_THREADS.ordinal()] = 1;
            iArr2[ArchivedThreadsStore.ThreadListingType.MY_ARCHIVED_PRIVATE_THREADS.ordinal()] = 2;
            iArr2[ArchivedThreadsStore.ThreadListingType.ALL_ARCHIVED_PRIVATE_THREADS.ordinal()] = 3;
        }
    }

    public /* synthetic */ WidgetThreadBrowserArchivedViewModel(long j, long j2, StoreGuilds storeGuilds, StoreChannels storeChannels, StoreUser storeUser, ArchivedThreadsStore archivedThreadsStore, StorePermissions storePermissions, StoreGuildMemberRequester storeGuildMemberRequester, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, j2, (i & 4) != 0 ? StoreStream.INSTANCE.getGuilds() : storeGuilds, (i & 8) != 0 ? StoreStream.INSTANCE.getChannels() : storeChannels, (i & 16) != 0 ? StoreStream.INSTANCE.getUsers() : storeUser, (i & 32) != 0 ? StoreStream.INSTANCE.getArchivedThreads() : archivedThreadsStore, (i & 64) != 0 ? StoreStream.INSTANCE.getPermissions() : storePermissions, (i & 128) != 0 ? StoreStream.INSTANCE.getGuildMemberRequester() : storeGuildMemberRequester);
    }

    public static final /* synthetic */ long access$getChannelId$p(WidgetThreadBrowserArchivedViewModel widgetThreadBrowserArchivedViewModel) {
        return widgetThreadBrowserArchivedViewModel.channelId;
    }

    public static final /* synthetic */ long access$getGuildId$p(WidgetThreadBrowserArchivedViewModel widgetThreadBrowserArchivedViewModel) {
        return widgetThreadBrowserArchivedViewModel.guildId;
    }

    public static final /* synthetic */ ArchivedThreadsStore access$getStoreArchivedThreads$p(WidgetThreadBrowserArchivedViewModel widgetThreadBrowserArchivedViewModel) {
        return widgetThreadBrowserArchivedViewModel.storeArchivedThreads;
    }

    public static final /* synthetic */ StoreChannels access$getStoreChannels$p(WidgetThreadBrowserArchivedViewModel widgetThreadBrowserArchivedViewModel) {
        return widgetThreadBrowserArchivedViewModel.storeChannels;
    }

    public static final /* synthetic */ StoreGuilds access$getStoreGuilds$p(WidgetThreadBrowserArchivedViewModel widgetThreadBrowserArchivedViewModel) {
        return widgetThreadBrowserArchivedViewModel.storeGuilds;
    }

    public static final /* synthetic */ StorePermissions access$getStorePermissions$p(WidgetThreadBrowserArchivedViewModel widgetThreadBrowserArchivedViewModel) {
        return widgetThreadBrowserArchivedViewModel.storePermissions;
    }

    public static final /* synthetic */ StoreUser access$getStoreUser$p(WidgetThreadBrowserArchivedViewModel widgetThreadBrowserArchivedViewModel) {
        return widgetThreadBrowserArchivedViewModel.storeUser;
    }

    public static final /* synthetic */ void access$handleStoreState(WidgetThreadBrowserArchivedViewModel widgetThreadBrowserArchivedViewModel, StoreState storeState) {
        widgetThreadBrowserArchivedViewModel.handleStoreState(storeState);
    }

    @MainThread
    private final void handleStoreState(StoreState storeState) {
        int i;
        ThreadBrowserThreadView.TimestampMode timestampMode;
        ViewMode viewMode = storeState.getViewMode();
        ArrayList arrayList = new ArrayList();
        boolean zIsModerator = storeState.isModerator();
        ArchivedThreadsStore.ThreadListingState listingState = storeState.getListingState();
        if (listingState instanceof ArchivedThreadsStore.ThreadListingState.Listing) {
            Channel channel = storeState.getChannel();
            if (channel != null && channel.getType() == 15) {
                arrayList.add(new WidgetThreadBrowserAdapter.Item.Warning(null, 1, null));
            }
            ArchivedThreadsStore.ThreadListingState.Listing listing = (ArchivedThreadsStore.ThreadListingState.Listing) listingState;
            if (!listing.getThreads().isEmpty()) {
                int iOrdinal = viewMode.getVisibility().ordinal();
                if (iOrdinal == 0) {
                    i = R.string.thread_browser_public_header;
                } else {
                    if (iOrdinal != 1) {
                        throw new NoWhenBranchMatchedException();
                    }
                    i = R.string.thread_browser_private_header;
                }
                arrayList.add(new WidgetThreadBrowserAdapter.Item.Header("header", i, listing.getThreads().size()));
                for (Channel channel2 : listing.getThreads()) {
                    User user = storeState.getUsers().get(Long.valueOf(channel2.getOwnerId()));
                    if (user == null || !storeState.getGuildMembers().containsKey(Long.valueOf(channel2.getOwnerId()))) {
                        this.storeGuildMemberRequester.queueRequest(channel2.getGuildId(), channel2.getOwnerId());
                    }
                    Map<Long, GuildMember> guildMembers = storeState.getGuildMembers();
                    boolean z2 = viewMode.getThreadListingType() == ArchivedThreadsStore.ThreadListingType.MY_ARCHIVED_PRIVATE_THREADS;
                    if (z2) {
                        timestampMode = ThreadBrowserThreadView.TimestampMode.CreatedAt;
                    } else {
                        if (z2) {
                            throw new NoWhenBranchMatchedException();
                        }
                        timestampMode = ThreadBrowserThreadView.TimestampMode.ArchivedAt;
                    }
                    arrayList.add(new WidgetThreadBrowserAdapter.Item.Thread(new ThreadBrowserThreadView.ThreadData.ArchivedThread(channel2, guildMembers, user, timestampMode)));
                }
            }
            if (listing.isLoadingMore()) {
                arrayList.add(new WidgetThreadBrowserAdapter.Item.Loading(null, 1, null));
            }
            this.canLoadMore = !listing.isLoadingMore() && listing.getHasMore();
        } else {
            if (!(listingState instanceof ArchivedThreadsStore.ThreadListingState.Uninitialized)) {
                boolean z3 = listingState instanceof ArchivedThreadsStore.ThreadListingState.Error;
                this.storeGuildMemberRequester.performQueuedRequests();
                updateViewState(new ViewState(viewMode, arrayList, zIsModerator, z3, ThreadUtils.INSTANCE.canCreateThread(storeState.getPermissions(), storeState.getChannel(), null, storeState.getGuild())));
            }
            arrayList.add(new WidgetThreadBrowserAdapter.Item.Loading(null, 1, null));
        }
        this.storeGuildMemberRequester.performQueuedRequests();
        updateViewState(new ViewState(viewMode, arrayList, zIsModerator, z3, ThreadUtils.INSTANCE.canCreateThread(storeState.getPermissions(), storeState.getChannel(), null, storeState.getGuild())));
    }

    public static /* synthetic */ void maybeLoadMore$default(WidgetThreadBrowserArchivedViewModel widgetThreadBrowserArchivedViewModel, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            z2 = false;
        }
        widgetThreadBrowserArchivedViewModel.maybeLoadMore(z2);
    }

    @MainThread
    public final void maybeLoadMore(boolean force) {
        if (this.canLoadMore || force) {
            ArchivedThreadsStore.fetchListing$default(this.storeArchivedThreads, this.channelId, this.viewModeSubject.n0().getThreadListingType(), false, null, 12, null);
        }
    }

    @MainThread
    public final void onModeratorModeChanged(boolean isModeratorMode) {
        BehaviorSubject<ViewMode> behaviorSubject = this.viewModeSubject;
        behaviorSubject.onNext(ViewMode.copy$default(behaviorSubject.n0(), null, isModeratorMode, 1, null));
        trackTabChanged();
    }

    @MainThread
    public final void onVisibilityChanged(VisibilityMode visibility) {
        m.checkNotNullParameter(visibility, "visibility");
        BehaviorSubject<ViewMode> behaviorSubject = this.viewModeSubject;
        behaviorSubject.onNext(ViewMode.copy$default(behaviorSubject.n0(), visibility, false, 2, null));
        trackTabChanged();
    }

    public final void trackTabChanged() {
        String str;
        ViewMode viewModeN0 = this.viewModeSubject.n0();
        if (viewModeN0 != null) {
            int iOrdinal = viewModeN0.getThreadListingType().ordinal();
            if (iOrdinal == 0) {
                str = "My Private Archived Threads";
            } else if (iOrdinal == 1) {
                str = "Public Archived Threads";
            } else {
                if (iOrdinal != 2) {
                    throw new NoWhenBranchMatchedException();
                }
                str = "All Private Archived Threads";
            }
            StoreStream.INSTANCE.getAnalytics().trackThreadBrowserTabChanged(this.channelId, str);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetThreadBrowserArchivedViewModel(long j, long j2, StoreGuilds storeGuilds, StoreChannels storeChannels, StoreUser storeUser, ArchivedThreadsStore archivedThreadsStore, StorePermissions storePermissions, StoreGuildMemberRequester storeGuildMemberRequester) {
        super(null, 1, null);
        m.checkNotNullParameter(storeGuilds, "storeGuilds");
        m.checkNotNullParameter(storeChannels, "storeChannels");
        m.checkNotNullParameter(storeUser, "storeUser");
        m.checkNotNullParameter(archivedThreadsStore, "storeArchivedThreads");
        m.checkNotNullParameter(storePermissions, "storePermissions");
        m.checkNotNullParameter(storeGuildMemberRequester, "storeGuildMemberRequester");
        this.guildId = j;
        this.channelId = j2;
        this.storeGuilds = storeGuilds;
        this.storeChannels = storeChannels;
        this.storeUser = storeUser;
        this.storeArchivedThreads = archivedThreadsStore;
        this.storePermissions = storePermissions;
        this.storeGuildMemberRequester = storeGuildMemberRequester;
        BehaviorSubject<ViewMode> behaviorSubjectL0 = BehaviorSubject.l0(new ViewMode(VisibilityMode.PublicThreads, false));
        m.checkNotNullExpressionValue(behaviorSubjectL0, "BehaviorSubject.create(\n…rMode = false\n      )\n  )");
        this.viewModeSubject = behaviorSubjectL0;
        Observable observableY = behaviorSubjectL0.Y(new WidgetThreadBrowserArchivedViewModel$storeStateObservable$1(this));
        m.checkNotNullExpressionValue(observableY, "viewModeSubject\n        …            )\n          }");
        this.storeStateObservable = observableY;
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(observableY, this, null, 2, null), WidgetThreadBrowserArchivedViewModel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(), 62, (Object) null);
    }
}

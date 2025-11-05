package com.discord.widgets.directories;

import android.content.Context;
import androidx.core.app.NotificationCompat;
import b.a.d.d0;
import b.d.b.a.a;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.api.directory.DirectoryEntryGuild;
import com.discord.api.guild.Guild;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.hubs.DirectoryEntryCategory;
import com.discord.stores.StoreChannels;
import com.discord.stores.StoreChannelsSelected;
import com.discord.stores.StoreDirectories;
import com.discord.stores.StoreGuildSelected;
import com.discord.stores.StoreGuilds;
import com.discord.stores.StorePermissions;
import com.discord.stores.StoreReadStates;
import com.discord.stores.StoreStream;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeckProvider;
import com.discord.stores.utilities.Default;
import com.discord.stores.utilities.RestCallState;
import com.discord.utilities.directories.DirectoryUtils;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.widgets.guilds.join.GuildJoinHelperKt;
import d0.g;
import d0.t.n0;
import d0.z.d.k;
import d0.z.d.m;
import d0.z.d.o;
import j0.k.b;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.objectweb.asm.Opcodes;
import rx.Observable;

/* compiled from: WidgetDirectoriesViewModel.kt */
/* loaded from: classes2.dex */
public final class WidgetDirectoriesViewModel extends d0<ViewState> {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final StoreDirectories directoriesStore;
    private final RestAPI restAPI;

    /* compiled from: WidgetDirectoriesViewModel.kt */
    /* renamed from: com.discord.widgets.directories.WidgetDirectoriesViewModel$1, reason: invalid class name */
    public static final class AnonymousClass1<T, R> implements b<ViewState, Boolean> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        @Override // j0.k.b
        public /* bridge */ /* synthetic */ Boolean call(ViewState viewState) {
            return call2(viewState);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final Boolean call2(ViewState viewState) {
            Channel channel = viewState.getChannel();
            return Boolean.valueOf(channel != null && ChannelUtils.o(channel));
        }
    }

    /* compiled from: WidgetDirectoriesViewModel.kt */
    /* renamed from: com.discord.widgets.directories.WidgetDirectoriesViewModel$2, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass2 extends k implements Function1<ViewState, Unit> {
        public AnonymousClass2(WidgetDirectoriesViewModel widgetDirectoriesViewModel) {
            super(1, widgetDirectoriesViewModel, WidgetDirectoriesViewModel.class, "updateViewState", "updateViewState(Ljava/lang/Object;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ViewState viewState) {
            invoke2(viewState);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ViewState viewState) {
            m.checkNotNullParameter(viewState, "p1");
            WidgetDirectoriesViewModel.access$updateViewState((WidgetDirectoriesViewModel) this.receiver, viewState);
        }
    }

    /* compiled from: WidgetDirectoriesViewModel.kt */
    /* renamed from: com.discord.widgets.directories.WidgetDirectoriesViewModel$3, reason: invalid class name */
    public static final class AnonymousClass3<T, R> implements b<Channel, Boolean> {
        public static final AnonymousClass3 INSTANCE = new AnonymousClass3();

        @Override // j0.k.b
        public /* bridge */ /* synthetic */ Boolean call(Channel channel) {
            return call2(channel);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final Boolean call2(Channel channel) {
            return Boolean.valueOf(channel != null && ChannelUtils.o(channel));
        }
    }

    /* compiled from: WidgetDirectoriesViewModel.kt */
    /* renamed from: com.discord.widgets.directories.WidgetDirectoriesViewModel$4, reason: invalid class name */
    public static final class AnonymousClass4 extends o implements Function1<Channel, Unit> {
        public AnonymousClass4() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Channel channel) {
            invoke2(channel);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Channel channel) {
            WidgetDirectoriesViewModel.access$getDirectoriesStore$p(WidgetDirectoriesViewModel.this).fetchDirectoriesForChannel(channel.getId());
            WidgetDirectoriesViewModel.access$getDirectoriesStore$p(WidgetDirectoriesViewModel.this).fetchEntryCountsForChannel(channel.getId());
            WidgetDirectoriesViewModel.access$getDirectoriesStore$p(WidgetDirectoriesViewModel.this).fetchGuildScheduledEventsForChannel(channel.getGuildId(), channel.getId());
        }
    }

    /* compiled from: WidgetDirectoriesViewModel.kt */
    /* renamed from: com.discord.widgets.directories.WidgetDirectoriesViewModel$5, reason: invalid class name */
    public static final class AnonymousClass5<T, R> implements b<Long, Boolean> {
        public final /* synthetic */ StoreChannels $channelsStore;

        public AnonymousClass5(StoreChannels storeChannels) {
            this.$channelsStore = storeChannels;
        }

        @Override // j0.k.b
        public /* bridge */ /* synthetic */ Boolean call(Long l) {
            return call2(l);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final Boolean call2(Long l) {
            StoreChannels storeChannels = this.$channelsStore;
            m.checkNotNullExpressionValue(l, ModelAuditLogEntry.CHANGE_KEY_ID);
            Channel channelFindChannelById = storeChannels.findChannelById(l.longValue());
            return Boolean.valueOf(channelFindChannelById != null && ChannelUtils.o(channelFindChannelById));
        }
    }

    /* compiled from: WidgetDirectoriesViewModel.kt */
    /* renamed from: com.discord.widgets.directories.WidgetDirectoriesViewModel$6, reason: invalid class name */
    public static final class AnonymousClass6 extends o implements Function1<Long, Unit> {
        public final /* synthetic */ StoreReadStates $readStatesStore;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass6(StoreReadStates storeReadStates) {
            super(1);
            this.$readStatesStore = storeReadStates;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Long l) {
            invoke2(l);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Long l) {
            this.$readStatesStore.markAsRead(l);
        }
    }

    /* compiled from: WidgetDirectoriesViewModel.kt */
    public static final class Companion {
        private Companion() {
        }

        public static final /* synthetic */ Observable access$observeStores(Companion companion, ObservationDeck observationDeck, StoreGuilds storeGuilds, StoreGuildSelected storeGuildSelected, StoreChannelsSelected storeChannelsSelected, StoreDirectories storeDirectories, StorePermissions storePermissions) {
            return companion.observeStores(observationDeck, storeGuilds, storeGuildSelected, storeChannelsSelected, storeDirectories, storePermissions);
        }

        private final Observable<ViewState> observeStores(ObservationDeck observationDeck, StoreGuilds guildsStore, StoreGuildSelected guildSelectedStore, StoreChannelsSelected channelsSelectedStore, StoreDirectories directoriesStore, StorePermissions permissionsStore) {
            return ObservationDeck.connectRx$default(observationDeck, new ObservationDeck.UpdateSource[]{guildsStore, guildSelectedStore, directoriesStore, channelsSelectedStore, permissionsStore}, false, null, null, new WidgetDirectoriesViewModel$Companion$observeStores$1(channelsSelectedStore, guildSelectedStore, guildsStore, permissionsStore, directoriesStore), 14, null);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetDirectoriesViewModel.kt */
    /* renamed from: com.discord.widgets.directories.WidgetDirectoriesViewModel$joinGuild$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function1<Guild, Unit> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Guild guild) {
            invoke2(guild);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Guild guild) {
            m.checkNotNullParameter(guild, "it");
        }
    }

    public WidgetDirectoriesViewModel() {
        this(null, null, null, null, null, null, 63, null);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ WidgetDirectoriesViewModel(StoreDirectories storeDirectories, StoreChannelsSelected storeChannelsSelected, StoreChannels storeChannels, StoreReadStates storeReadStates, RestAPI restAPI, Observable observable, int i, DefaultConstructorMarker defaultConstructorMarker) {
        Observable observableAccess$observeStores;
        StoreDirectories directories = (i & 1) != 0 ? StoreStream.INSTANCE.getDirectories() : storeDirectories;
        StoreChannelsSelected channelsSelected = (i & 2) != 0 ? StoreStream.INSTANCE.getChannelsSelected() : storeChannelsSelected;
        StoreChannels channels = (i & 4) != 0 ? StoreStream.INSTANCE.getChannels() : storeChannels;
        StoreReadStates readStates = (i & 8) != 0 ? StoreStream.INSTANCE.getReadStates() : storeReadStates;
        RestAPI api = (i & 16) != 0 ? RestAPI.INSTANCE.getApi() : restAPI;
        if ((i & 32) != 0) {
            Companion companion = INSTANCE;
            ObservationDeck observationDeck = ObservationDeckProvider.get();
            StoreStream.Companion companion2 = StoreStream.INSTANCE;
            observableAccess$observeStores = Companion.access$observeStores(companion, observationDeck, companion2.getGuilds(), companion2.getGuildSelected(), companion2.getChannelsSelected(), companion2.getDirectories(), companion2.getPermissions());
        } else {
            observableAccess$observeStores = observable;
        }
        this(directories, channelsSelected, channels, readStates, api, observableAccess$observeStores);
    }

    public static final /* synthetic */ StoreDirectories access$getDirectoriesStore$p(WidgetDirectoriesViewModel widgetDirectoriesViewModel) {
        return widgetDirectoriesViewModel.directoriesStore;
    }

    public static final /* synthetic */ void access$updateViewState(WidgetDirectoriesViewModel widgetDirectoriesViewModel, ViewState viewState) {
        widgetDirectoriesViewModel.updateViewState(viewState);
    }

    public final String getHubName() {
        com.discord.models.guild.Guild guild;
        ViewState viewState = getViewState();
        String name = (viewState == null || (guild = viewState.getGuild()) == null) ? null : guild.getName();
        return name != null ? name : "";
    }

    public final RestAPI getRestAPI() {
        return this.restAPI;
    }

    public final void joinGuild(Context context, long id2, long directoryChannelId) {
        m.checkNotNullParameter(context, "context");
        GuildJoinHelperKt.joinGuild$default(context, id2, false, null, Long.valueOf(directoryChannelId), this.restAPI.jsonObjectOf(d0.o.to("source", DirectoryUtils.JOIN_GUILD_SOURCE)), WidgetDirectoriesViewModel.class, null, null, null, AnonymousClass1.INSTANCE, 896, null);
    }

    public final void removeGuild(long id2, long directoryChannelId) {
        this.directoriesStore.removeServerFromDirectory(directoryChannelId, id2);
    }

    /* compiled from: WidgetDirectoriesViewModel.kt */
    public static final /* data */ class ViewState {
        private final Set<Long> adminGuildIds;

        /* renamed from: allDirectoryEntryData$delegate, reason: from kotlin metadata */
        private final Lazy allDirectoryEntryData;
        private final Channel channel;
        private final RestCallState<List<DirectoryEntryGuild>> directories;

        /* renamed from: directoryEntryData$delegate, reason: from kotlin metadata */
        private final Lazy directoryEntryData;
        private final com.discord.models.guild.Guild guild;
        private final boolean hasAddGuildPermissions;
        private final Set<Long> joinedGuildIds;

        /* renamed from: mappedTabs$delegate, reason: from kotlin metadata */
        private final Lazy mappedTabs;
        private final RestCallState<Map<Integer, Integer>> tabs;

        public ViewState() {
            this(null, null, null, null, false, null, null, Opcodes.LAND, null);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public ViewState(com.discord.models.guild.Guild guild, Channel channel, Set<Long> set, Set<Long> set2, boolean z2, RestCallState<? extends List<DirectoryEntryGuild>> restCallState, RestCallState<? extends Map<Integer, Integer>> restCallState2) {
            m.checkNotNullParameter(set, "joinedGuildIds");
            m.checkNotNullParameter(set2, "adminGuildIds");
            m.checkNotNullParameter(restCallState, "directories");
            m.checkNotNullParameter(restCallState2, "tabs");
            this.guild = guild;
            this.channel = channel;
            this.joinedGuildIds = set;
            this.adminGuildIds = set2;
            this.hasAddGuildPermissions = z2;
            this.directories = restCallState;
            this.tabs = restCallState2;
            this.allDirectoryEntryData = g.lazy(new WidgetDirectoriesViewModel$ViewState$allDirectoryEntryData$2(this));
            this.directoryEntryData = g.lazy(new WidgetDirectoriesViewModel$ViewState$directoryEntryData$2(this));
            this.mappedTabs = g.lazy(new WidgetDirectoriesViewModel$ViewState$mappedTabs$2(this));
        }

        public static /* synthetic */ ViewState copy$default(ViewState viewState, com.discord.models.guild.Guild guild, Channel channel, Set set, Set set2, boolean z2, RestCallState restCallState, RestCallState restCallState2, int i, Object obj) {
            if ((i & 1) != 0) {
                guild = viewState.guild;
            }
            if ((i & 2) != 0) {
                channel = viewState.channel;
            }
            Channel channel2 = channel;
            if ((i & 4) != 0) {
                set = viewState.joinedGuildIds;
            }
            Set set3 = set;
            if ((i & 8) != 0) {
                set2 = viewState.adminGuildIds;
            }
            Set set4 = set2;
            if ((i & 16) != 0) {
                z2 = viewState.hasAddGuildPermissions;
            }
            boolean z3 = z2;
            if ((i & 32) != 0) {
                restCallState = viewState.directories;
            }
            RestCallState restCallState3 = restCallState;
            if ((i & 64) != 0) {
                restCallState2 = viewState.tabs;
            }
            return viewState.copy(guild, channel2, set3, set4, z3, restCallState3, restCallState2);
        }

        /* renamed from: component1, reason: from getter */
        public final com.discord.models.guild.Guild getGuild() {
            return this.guild;
        }

        /* renamed from: component2, reason: from getter */
        public final Channel getChannel() {
            return this.channel;
        }

        public final Set<Long> component3() {
            return this.joinedGuildIds;
        }

        public final Set<Long> component4() {
            return this.adminGuildIds;
        }

        /* renamed from: component5, reason: from getter */
        public final boolean getHasAddGuildPermissions() {
            return this.hasAddGuildPermissions;
        }

        public final RestCallState<List<DirectoryEntryGuild>> component6() {
            return this.directories;
        }

        public final RestCallState<Map<Integer, Integer>> component7() {
            return this.tabs;
        }

        public final ViewState copy(com.discord.models.guild.Guild guild, Channel channel, Set<Long> joinedGuildIds, Set<Long> adminGuildIds, boolean hasAddGuildPermissions, RestCallState<? extends List<DirectoryEntryGuild>> directories, RestCallState<? extends Map<Integer, Integer>> tabs) {
            m.checkNotNullParameter(joinedGuildIds, "joinedGuildIds");
            m.checkNotNullParameter(adminGuildIds, "adminGuildIds");
            m.checkNotNullParameter(directories, "directories");
            m.checkNotNullParameter(tabs, "tabs");
            return new ViewState(guild, channel, joinedGuildIds, adminGuildIds, hasAddGuildPermissions, directories, tabs);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ViewState)) {
                return false;
            }
            ViewState viewState = (ViewState) other;
            return m.areEqual(this.guild, viewState.guild) && m.areEqual(this.channel, viewState.channel) && m.areEqual(this.joinedGuildIds, viewState.joinedGuildIds) && m.areEqual(this.adminGuildIds, viewState.adminGuildIds) && this.hasAddGuildPermissions == viewState.hasAddGuildPermissions && m.areEqual(this.directories, viewState.directories) && m.areEqual(this.tabs, viewState.tabs);
        }

        public final Set<Long> getAdminGuildIds() {
            return this.adminGuildIds;
        }

        public final List<DirectoryEntryData> getAllDirectoryEntryData() {
            return (List) this.allDirectoryEntryData.getValue();
        }

        public final Channel getChannel() {
            return this.channel;
        }

        public final RestCallState<List<DirectoryEntryGuild>> getDirectories() {
            return this.directories;
        }

        public final Map<Integer, List<DirectoryEntryData>> getDirectoryEntryData() {
            return (Map) this.directoryEntryData.getValue();
        }

        public final com.discord.models.guild.Guild getGuild() {
            return this.guild;
        }

        public final boolean getHasAddGuildPermissions() {
            return this.hasAddGuildPermissions;
        }

        public final Set<Long> getJoinedGuildIds() {
            return this.joinedGuildIds;
        }

        public final List<Pair<DirectoryEntryCategory, Integer>> getMappedTabs() {
            return (List) this.mappedTabs.getValue();
        }

        public final RestCallState<Map<Integer, Integer>> getTabs() {
            return this.tabs;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            com.discord.models.guild.Guild guild = this.guild;
            int iHashCode = (guild != null ? guild.hashCode() : 0) * 31;
            Channel channel = this.channel;
            int iHashCode2 = (iHashCode + (channel != null ? channel.hashCode() : 0)) * 31;
            Set<Long> set = this.joinedGuildIds;
            int iHashCode3 = (iHashCode2 + (set != null ? set.hashCode() : 0)) * 31;
            Set<Long> set2 = this.adminGuildIds;
            int iHashCode4 = (iHashCode3 + (set2 != null ? set2.hashCode() : 0)) * 31;
            boolean z2 = this.hasAddGuildPermissions;
            int i = z2;
            if (z2 != 0) {
                i = 1;
            }
            int i2 = (iHashCode4 + i) * 31;
            RestCallState<List<DirectoryEntryGuild>> restCallState = this.directories;
            int iHashCode5 = (i2 + (restCallState != null ? restCallState.hashCode() : 0)) * 31;
            RestCallState<Map<Integer, Integer>> restCallState2 = this.tabs;
            return iHashCode5 + (restCallState2 != null ? restCallState2.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = a.U("ViewState(guild=");
            sbU.append(this.guild);
            sbU.append(", channel=");
            sbU.append(this.channel);
            sbU.append(", joinedGuildIds=");
            sbU.append(this.joinedGuildIds);
            sbU.append(", adminGuildIds=");
            sbU.append(this.adminGuildIds);
            sbU.append(", hasAddGuildPermissions=");
            sbU.append(this.hasAddGuildPermissions);
            sbU.append(", directories=");
            sbU.append(this.directories);
            sbU.append(", tabs=");
            sbU.append(this.tabs);
            sbU.append(")");
            return sbU.toString();
        }

        public /* synthetic */ ViewState(com.discord.models.guild.Guild guild, Channel channel, Set set, Set set2, boolean z2, RestCallState restCallState, RestCallState restCallState2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : guild, (i & 2) == 0 ? channel : null, (i & 4) != 0 ? n0.emptySet() : set, (i & 8) != 0 ? n0.emptySet() : set2, (i & 16) != 0 ? true : z2, (i & 32) != 0 ? Default.INSTANCE : restCallState, (i & 64) != 0 ? Default.INSTANCE : restCallState2);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetDirectoriesViewModel(StoreDirectories storeDirectories, StoreChannelsSelected storeChannelsSelected, StoreChannels storeChannels, StoreReadStates storeReadStates, RestAPI restAPI, Observable<ViewState> observable) {
        super(null);
        m.checkNotNullParameter(storeDirectories, "directoriesStore");
        m.checkNotNullParameter(storeChannelsSelected, "channelsSelectedStore");
        m.checkNotNullParameter(storeChannels, "channelsStore");
        m.checkNotNullParameter(storeReadStates, "readStatesStore");
        m.checkNotNullParameter(restAPI, "restAPI");
        m.checkNotNullParameter(observable, "storeObservable");
        this.directoriesStore = storeDirectories;
        this.restAPI = restAPI;
        Observable observableY = ObservableExtensionsKt.computationLatest(observable).y(AnonymousClass1.INSTANCE);
        m.checkNotNullExpressionValue(observableY, "storeObservable\n        …?.isDirectory() == true }");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(observableY, this, null, 2, null), WidgetDirectoriesViewModel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass2(this), 62, (Object) null);
        Observable<Channel> observableR = storeChannelsSelected.observeSelectedChannel().r();
        m.checkNotNullExpressionValue(observableR, "channelsSelectedStore\n  …  .distinctUntilChanged()");
        Observable<R> observableG = observableR.y(ObservableExtensionsKt.AnonymousClass1.INSTANCE).G(ObservableExtensionsKt.AnonymousClass2.INSTANCE);
        m.checkNotNullExpressionValue(observableG, "filter { it != null }.map { it!! }");
        Observable observableY2 = observableG.y(AnonymousClass3.INSTANCE);
        m.checkNotNullExpressionValue(observableY2, "channelsSelectedStore\n  …?.isDirectory() == true }");
        ObservableExtensionsKt.appSubscribe$default(observableY2, WidgetDirectoriesViewModel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass4(), 62, (Object) null);
        Observable<Long> observableY3 = storeChannelsSelected.observePreviousId().r().y(new AnonymousClass5(storeChannels));
        m.checkNotNullExpressionValue(observableY3, "channelsSelectedStore.ob…?.isDirectory() == true }");
        ObservableExtensionsKt.appSubscribe$default(observableY3, WidgetDirectoriesViewModel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass6(storeReadStates), 62, (Object) null);
    }
}

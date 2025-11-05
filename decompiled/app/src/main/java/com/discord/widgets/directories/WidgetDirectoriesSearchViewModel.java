package com.discord.widgets.directories;

import android.content.Context;
import b.a.d.d0;
import b.d.b.a.a;
import com.discord.api.directory.DirectoryEntryGuild;
import com.discord.api.guild.Guild;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.stores.StoreChannels;
import com.discord.stores.StoreDirectories;
import com.discord.stores.StoreGuildSelected;
import com.discord.stores.StoreGuilds;
import com.discord.stores.StorePermissions;
import com.discord.stores.StoreStream;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeckProvider;
import com.discord.stores.utilities.Default;
import com.discord.stores.utilities.RestCallState;
import com.discord.stores.utilities.RestCallStateKt;
import com.discord.utilities.directories.DirectoryUtils;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.widgets.guilds.join.GuildJoinHelperKt;
import d0.g;
import d0.g0.t;
import d0.t.n;
import d0.t.n0;
import d0.z.d.k;
import d0.z.d.m;
import d0.z.d.o;
import java.util.List;
import java.util.Set;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.objectweb.asm.Opcodes;
import rx.Observable;

/* compiled from: WidgetDirectoriesSearchViewModel.kt */
/* loaded from: classes2.dex */
public final class WidgetDirectoriesSearchViewModel extends d0<ViewState> {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final long channelId;
    private final StoreDirectories directoriesStore;
    private final RestAPI restAPI;

    /* compiled from: WidgetDirectoriesSearchViewModel.kt */
    /* renamed from: com.discord.widgets.directories.WidgetDirectoriesSearchViewModel$1, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass1 extends k implements Function1<ViewState, Unit> {
        public AnonymousClass1(WidgetDirectoriesSearchViewModel widgetDirectoriesSearchViewModel) {
            super(1, widgetDirectoriesSearchViewModel, WidgetDirectoriesSearchViewModel.class, "handleNewState", "handleNewState(Lcom/discord/widgets/directories/WidgetDirectoriesSearchViewModel$ViewState;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ViewState viewState) {
            invoke2(viewState);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ViewState viewState) {
            m.checkNotNullParameter(viewState, "p1");
            WidgetDirectoriesSearchViewModel.access$handleNewState((WidgetDirectoriesSearchViewModel) this.receiver, viewState);
        }
    }

    /* compiled from: WidgetDirectoriesSearchViewModel.kt */
    public static final class Companion {
        private Companion() {
        }

        public static final /* synthetic */ Observable access$observeStores(Companion companion, long j, ObservationDeck observationDeck, StoreGuilds storeGuilds, StoreGuildSelected storeGuildSelected, StoreChannels storeChannels, StorePermissions storePermissions) {
            return companion.observeStores(j, observationDeck, storeGuilds, storeGuildSelected, storeChannels, storePermissions);
        }

        private final Observable<ViewState> observeStores(long channelId, ObservationDeck observationDeck, StoreGuilds guildsStore, StoreGuildSelected guildSelectedStore, StoreChannels channelsStore, StorePermissions permissionsStore) {
            return ObservationDeck.connectRx$default(observationDeck, new ObservationDeck.UpdateSource[]{guildsStore, guildSelectedStore, channelsStore, permissionsStore}, false, null, null, new WidgetDirectoriesSearchViewModel$Companion$observeStores$1(permissionsStore, guildsStore, guildSelectedStore, channelId), 14, null);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetDirectoriesSearchViewModel.kt */
    /* renamed from: com.discord.widgets.directories.WidgetDirectoriesSearchViewModel$joinGuild$1, reason: invalid class name */
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

    /* compiled from: WidgetDirectoriesSearchViewModel.kt */
    /* renamed from: com.discord.widgets.directories.WidgetDirectoriesSearchViewModel$searchForDirectories$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function1<RestCallState<? extends List<? extends DirectoryEntryGuild>>, Unit> {
        public final /* synthetic */ CharSequence $query;
        public final /* synthetic */ ViewState $viewState;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(ViewState viewState, CharSequence charSequence) {
            super(1);
            this.$viewState = viewState;
            this.$query = charSequence;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(RestCallState<? extends List<? extends DirectoryEntryGuild>> restCallState) {
            invoke2((RestCallState<? extends List<DirectoryEntryGuild>>) restCallState);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(RestCallState<? extends List<DirectoryEntryGuild>> restCallState) {
            m.checkNotNullParameter(restCallState, "entriesState");
            WidgetDirectoriesSearchViewModel widgetDirectoriesSearchViewModel = WidgetDirectoriesSearchViewModel.this;
            ViewState viewState = this.$viewState;
            String string = this.$query.toString();
            List<DirectoryEntryGuild> listInvoke = restCallState.invoke();
            if (listInvoke == null) {
                listInvoke = this.$viewState.getDirectories();
            }
            WidgetDirectoriesSearchViewModel.access$updateViewState(widgetDirectoriesSearchViewModel, ViewState.copy$default(viewState, null, string, listInvoke, null, null, false, restCallState, 57, null));
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ WidgetDirectoriesSearchViewModel(long j, RestAPI restAPI, StoreDirectories storeDirectories, Observable observable, int i, DefaultConstructorMarker defaultConstructorMarker) {
        Observable observableAccess$observeStores;
        RestAPI api = (i & 2) != 0 ? RestAPI.INSTANCE.getApi() : restAPI;
        StoreDirectories directories = (i & 4) != 0 ? StoreStream.INSTANCE.getDirectories() : storeDirectories;
        if ((i & 8) != 0) {
            Companion companion = INSTANCE;
            ObservationDeck observationDeck = ObservationDeckProvider.get();
            StoreStream.Companion companion2 = StoreStream.INSTANCE;
            observableAccess$observeStores = Companion.access$observeStores(companion, j, observationDeck, companion2.getGuilds(), companion2.getGuildSelected(), companion2.getChannels(), companion2.getPermissions());
        } else {
            observableAccess$observeStores = observable;
        }
        this(j, api, directories, observableAccess$observeStores);
    }

    public static final /* synthetic */ void access$handleNewState(WidgetDirectoriesSearchViewModel widgetDirectoriesSearchViewModel, ViewState viewState) {
        widgetDirectoriesSearchViewModel.handleNewState(viewState);
    }

    public static final /* synthetic */ void access$updateViewState(WidgetDirectoriesSearchViewModel widgetDirectoriesSearchViewModel, ViewState viewState) {
        widgetDirectoriesSearchViewModel.updateViewState(viewState);
    }

    private final void handleNewState(ViewState state) {
        ViewState viewState = getViewState();
        if (viewState != null) {
            updateViewState(ViewState.copy$default(viewState, state.getGuild(), null, null, state.getJoinedGuildIds(), state.getAdminGuildIds(), state.getHasAddGuildPermissions(), null, 70, null));
        }
    }

    public final long getChannelId() {
        return this.channelId;
    }

    public final StoreDirectories getDirectoriesStore() {
        return this.directoriesStore;
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
        GuildJoinHelperKt.joinGuild$default(context, id2, false, null, Long.valueOf(directoryChannelId), this.restAPI.jsonObjectOf(d0.o.to("source", DirectoryUtils.JOIN_GUILD_SOURCE)), WidgetDirectoriesSearchViewModel.class, null, null, null, AnonymousClass1.INSTANCE, 896, null);
    }

    public final void removeGuild(long id2, long directoryChannelId) {
        this.directoriesStore.removeServerFromDirectory(directoryChannelId, id2);
    }

    public final void searchForDirectories(long channelId, CharSequence query) {
        m.checkNotNullParameter(query, "query");
        ViewState viewState = getViewState();
        if (viewState == null || shouldNotSearch(query)) {
            return;
        }
        RestCallStateKt.executeRequest(this.restAPI.searchServers(channelId, query.toString()), new AnonymousClass1(viewState, query));
    }

    public final boolean shouldNotSearch(CharSequence searchTerm) {
        m.checkNotNullParameter(searchTerm, "searchTerm");
        if (!t.isBlank(searchTerm)) {
            ViewState viewState = getViewState();
            if (!m.areEqual(viewState != null ? viewState.getCurrentSearchTerm() : null, searchTerm.toString())) {
                return false;
            }
        }
        return true;
    }

    /* compiled from: WidgetDirectoriesSearchViewModel.kt */
    public static final /* data */ class ViewState {
        private final Set<Long> adminGuildIds;
        private final String currentSearchTerm;
        private final List<DirectoryEntryGuild> directories;
        private final RestCallState<List<DirectoryEntryGuild>> directoriesState;

        /* renamed from: directoryEntryData$delegate, reason: from kotlin metadata */
        private final Lazy directoryEntryData;
        private final com.discord.models.guild.Guild guild;
        private final boolean hasAddGuildPermissions;
        private final Set<Long> joinedGuildIds;

        public ViewState() {
            this(null, null, null, null, null, false, null, Opcodes.LAND, null);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public ViewState(com.discord.models.guild.Guild guild, String str, List<DirectoryEntryGuild> list, Set<Long> set, Set<Long> set2, boolean z2, RestCallState<? extends List<DirectoryEntryGuild>> restCallState) {
            m.checkNotNullParameter(str, "currentSearchTerm");
            m.checkNotNullParameter(list, "directories");
            m.checkNotNullParameter(set, "joinedGuildIds");
            m.checkNotNullParameter(set2, "adminGuildIds");
            m.checkNotNullParameter(restCallState, "directoriesState");
            this.guild = guild;
            this.currentSearchTerm = str;
            this.directories = list;
            this.joinedGuildIds = set;
            this.adminGuildIds = set2;
            this.hasAddGuildPermissions = z2;
            this.directoriesState = restCallState;
            this.directoryEntryData = g.lazy(new WidgetDirectoriesSearchViewModel$ViewState$directoryEntryData$2(this));
        }

        public static /* synthetic */ ViewState copy$default(ViewState viewState, com.discord.models.guild.Guild guild, String str, List list, Set set, Set set2, boolean z2, RestCallState restCallState, int i, Object obj) {
            if ((i & 1) != 0) {
                guild = viewState.guild;
            }
            if ((i & 2) != 0) {
                str = viewState.currentSearchTerm;
            }
            String str2 = str;
            if ((i & 4) != 0) {
                list = viewState.directories;
            }
            List list2 = list;
            if ((i & 8) != 0) {
                set = viewState.joinedGuildIds;
            }
            Set set3 = set;
            if ((i & 16) != 0) {
                set2 = viewState.adminGuildIds;
            }
            Set set4 = set2;
            if ((i & 32) != 0) {
                z2 = viewState.hasAddGuildPermissions;
            }
            boolean z3 = z2;
            if ((i & 64) != 0) {
                restCallState = viewState.directoriesState;
            }
            return viewState.copy(guild, str2, list2, set3, set4, z3, restCallState);
        }

        /* renamed from: component1, reason: from getter */
        public final com.discord.models.guild.Guild getGuild() {
            return this.guild;
        }

        /* renamed from: component2, reason: from getter */
        public final String getCurrentSearchTerm() {
            return this.currentSearchTerm;
        }

        public final List<DirectoryEntryGuild> component3() {
            return this.directories;
        }

        public final Set<Long> component4() {
            return this.joinedGuildIds;
        }

        public final Set<Long> component5() {
            return this.adminGuildIds;
        }

        /* renamed from: component6, reason: from getter */
        public final boolean getHasAddGuildPermissions() {
            return this.hasAddGuildPermissions;
        }

        public final RestCallState<List<DirectoryEntryGuild>> component7() {
            return this.directoriesState;
        }

        public final ViewState copy(com.discord.models.guild.Guild guild, String currentSearchTerm, List<DirectoryEntryGuild> directories, Set<Long> joinedGuildIds, Set<Long> adminGuildIds, boolean hasAddGuildPermissions, RestCallState<? extends List<DirectoryEntryGuild>> directoriesState) {
            m.checkNotNullParameter(currentSearchTerm, "currentSearchTerm");
            m.checkNotNullParameter(directories, "directories");
            m.checkNotNullParameter(joinedGuildIds, "joinedGuildIds");
            m.checkNotNullParameter(adminGuildIds, "adminGuildIds");
            m.checkNotNullParameter(directoriesState, "directoriesState");
            return new ViewState(guild, currentSearchTerm, directories, joinedGuildIds, adminGuildIds, hasAddGuildPermissions, directoriesState);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ViewState)) {
                return false;
            }
            ViewState viewState = (ViewState) other;
            return m.areEqual(this.guild, viewState.guild) && m.areEqual(this.currentSearchTerm, viewState.currentSearchTerm) && m.areEqual(this.directories, viewState.directories) && m.areEqual(this.joinedGuildIds, viewState.joinedGuildIds) && m.areEqual(this.adminGuildIds, viewState.adminGuildIds) && this.hasAddGuildPermissions == viewState.hasAddGuildPermissions && m.areEqual(this.directoriesState, viewState.directoriesState);
        }

        public final Set<Long> getAdminGuildIds() {
            return this.adminGuildIds;
        }

        public final String getCurrentSearchTerm() {
            return this.currentSearchTerm;
        }

        public final List<DirectoryEntryGuild> getDirectories() {
            return this.directories;
        }

        public final RestCallState<List<DirectoryEntryGuild>> getDirectoriesState() {
            return this.directoriesState;
        }

        public final List<DirectoryEntryData> getDirectoryEntryData() {
            return (List) this.directoryEntryData.getValue();
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

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            com.discord.models.guild.Guild guild = this.guild;
            int iHashCode = (guild != null ? guild.hashCode() : 0) * 31;
            String str = this.currentSearchTerm;
            int iHashCode2 = (iHashCode + (str != null ? str.hashCode() : 0)) * 31;
            List<DirectoryEntryGuild> list = this.directories;
            int iHashCode3 = (iHashCode2 + (list != null ? list.hashCode() : 0)) * 31;
            Set<Long> set = this.joinedGuildIds;
            int iHashCode4 = (iHashCode3 + (set != null ? set.hashCode() : 0)) * 31;
            Set<Long> set2 = this.adminGuildIds;
            int iHashCode5 = (iHashCode4 + (set2 != null ? set2.hashCode() : 0)) * 31;
            boolean z2 = this.hasAddGuildPermissions;
            int i = z2;
            if (z2 != 0) {
                i = 1;
            }
            int i2 = (iHashCode5 + i) * 31;
            RestCallState<List<DirectoryEntryGuild>> restCallState = this.directoriesState;
            return i2 + (restCallState != null ? restCallState.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = a.U("ViewState(guild=");
            sbU.append(this.guild);
            sbU.append(", currentSearchTerm=");
            sbU.append(this.currentSearchTerm);
            sbU.append(", directories=");
            sbU.append(this.directories);
            sbU.append(", joinedGuildIds=");
            sbU.append(this.joinedGuildIds);
            sbU.append(", adminGuildIds=");
            sbU.append(this.adminGuildIds);
            sbU.append(", hasAddGuildPermissions=");
            sbU.append(this.hasAddGuildPermissions);
            sbU.append(", directoriesState=");
            sbU.append(this.directoriesState);
            sbU.append(")");
            return sbU.toString();
        }

        public /* synthetic */ ViewState(com.discord.models.guild.Guild guild, String str, List list, Set set, Set set2, boolean z2, RestCallState restCallState, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : guild, (i & 2) != 0 ? "" : str, (i & 4) != 0 ? n.emptyList() : list, (i & 8) != 0 ? n0.emptySet() : set, (i & 16) != 0 ? n0.emptySet() : set2, (i & 32) != 0 ? true : z2, (i & 64) != 0 ? Default.INSTANCE : restCallState);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetDirectoriesSearchViewModel(long j, RestAPI restAPI, StoreDirectories storeDirectories, Observable<ViewState> observable) {
        super(new ViewState(null, null, null, null, null, false, null, Opcodes.LAND, null));
        m.checkNotNullParameter(restAPI, "restAPI");
        m.checkNotNullParameter(storeDirectories, "directoriesStore");
        m.checkNotNullParameter(observable, "storeObservable");
        this.channelId = j;
        this.restAPI = restAPI;
        this.directoriesStore = storeDirectories;
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationLatest(observable), this, null, 2, null), WidgetDirectoriesSearchViewModel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(this), 62, (Object) null);
    }
}

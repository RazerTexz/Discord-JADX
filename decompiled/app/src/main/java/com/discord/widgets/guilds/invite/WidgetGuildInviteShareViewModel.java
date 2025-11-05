package com.discord.widgets.guilds.invite;

import android.content.Context;
import android.content.res.Resources;
import androidx.core.app.NotificationCompat;
import b.a.d.d0;
import b.d.b.a.a;
import com.discord.BuildConfig;
import com.discord.api.channel.Channel;
import com.discord.api.guildscheduledevent.GuildScheduledEvent;
import com.discord.api.stageinstance.StageInstance;
import com.discord.app.AppComponent;
import com.discord.models.domain.ModelInvite;
import com.discord.models.experiments.domain.Experiment;
import com.discord.models.guild.Guild;
import com.discord.models.user.MeUser;
import com.discord.stores.StoreChannels;
import com.discord.stores.StoreGuildScheduledEvents;
import com.discord.stores.StoreGuilds;
import com.discord.stores.StoreInstantInvites;
import com.discord.stores.StoreInviteSettings;
import com.discord.stores.StoreMessages;
import com.discord.stores.StoreStageInstances;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUser;
import com.discord.utilities.messagesend.MessageResult;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableCombineLatestOverloadsKt;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.widgets.guilds.invite.InviteGenerator;
import com.discord.widgets.guilds.invite.WidgetInviteModel;
import d0.t.g0;
import d0.t.h0;
import d0.t.n0;
import d0.t.o0;
import d0.z.d.k;
import d0.z.d.m;
import d0.z.d.o;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function10;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.functions.Action1;
import rx.subjects.BehaviorSubject;

/* compiled from: WidgetGuildInviteShareViewModel.kt */
/* loaded from: classes2.dex */
public final class WidgetGuildInviteShareViewModel extends d0<ViewState> implements AppComponent {
    private final Long eventId;
    private final BehaviorSubject<String> filterPublisher;
    private final long guildId;
    private final InviteGenerator inviteGenerator;
    private final String inviteStoreKey;
    private final InviteSuggestionsManager inviteSuggestionsManager;
    private final BehaviorSubject<Unit> refreshUiSubject;
    private final Resources resources;
    private final BehaviorSubject<Long> selectedChannelSubject;
    private final BehaviorSubject<Map<String, Set<Long>>> sentInvitesSubject;
    private final StoreChannels storeChannels;
    private final StoreGuildScheduledEvents storeGuildScheduledEvents;
    private final StoreGuilds storeGuilds;
    private final StoreInstantInvites storeInstantInvites;
    private final StoreInviteSettings storeInviteSettings;
    private final StoreStageInstances storeStageInstances;
    private final StoreUser storeUser;
    private final boolean subscribeOnInit;

    /* compiled from: WidgetGuildInviteShareViewModel.kt */
    /* renamed from: com.discord.widgets.guilds.invite.WidgetGuildInviteShareViewModel$1, reason: invalid class name */
    public static final class AnonymousClass1<T> implements Action1<ViewState.Loaded> {
        public AnonymousClass1() {
        }

        @Override // rx.functions.Action1
        public /* bridge */ /* synthetic */ void call(ViewState.Loaded loaded) {
            call2(loaded);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final void call2(ViewState.Loaded loaded) {
            WidgetGuildInviteShareViewModel widgetGuildInviteShareViewModel = WidgetGuildInviteShareViewModel.this;
            m.checkNotNullExpressionValue(loaded, "viewState");
            WidgetGuildInviteShareViewModel.access$generateInviteLinkFromViewState(widgetGuildInviteShareViewModel, loaded);
        }
    }

    /* compiled from: WidgetGuildInviteShareViewModel.kt */
    /* renamed from: com.discord.widgets.guilds.invite.WidgetGuildInviteShareViewModel$2, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass2 extends k implements Function1<ViewState, Unit> {
        public AnonymousClass2(WidgetGuildInviteShareViewModel widgetGuildInviteShareViewModel) {
            super(1, widgetGuildInviteShareViewModel, WidgetGuildInviteShareViewModel.class, "updateViewState", "updateViewState(Ljava/lang/Object;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ViewState viewState) {
            invoke2(viewState);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ViewState viewState) {
            m.checkNotNullParameter(viewState, "p1");
            WidgetGuildInviteShareViewModel.access$updateViewState((WidgetGuildInviteShareViewModel) this.receiver, viewState);
        }
    }

    /* compiled from: WidgetGuildInviteShareViewModel.kt */
    public static abstract class ViewState {

        /* compiled from: WidgetGuildInviteShareViewModel.kt */
        public static final /* data */ class Loaded extends ViewState {
            private final List<InviteSuggestionItem> inviteSuggestionItems;
            private final String searchQuery;
            private final Map<String, Set<Long>> sentInvites;
            private final boolean showInviteSettings;
            private final WidgetInviteModel widgetInviteModel;

            public /* synthetic */ Loaded(WidgetInviteModel widgetInviteModel, List list, String str, Map map, boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this(widgetInviteModel, list, (i & 4) != 0 ? "" : str, map, (i & 16) != 0 ? true : z2);
            }

            public static /* synthetic */ Loaded copy$default(Loaded loaded, WidgetInviteModel widgetInviteModel, List list, String str, Map map, boolean z2, int i, Object obj) {
                if ((i & 1) != 0) {
                    widgetInviteModel = loaded.widgetInviteModel;
                }
                if ((i & 2) != 0) {
                    list = loaded.inviteSuggestionItems;
                }
                List list2 = list;
                if ((i & 4) != 0) {
                    str = loaded.searchQuery;
                }
                String str2 = str;
                if ((i & 8) != 0) {
                    map = loaded.sentInvites;
                }
                Map map2 = map;
                if ((i & 16) != 0) {
                    z2 = loaded.showInviteSettings;
                }
                return loaded.copy(widgetInviteModel, list2, str2, map2, z2);
            }

            /* renamed from: component1, reason: from getter */
            public final WidgetInviteModel getWidgetInviteModel() {
                return this.widgetInviteModel;
            }

            public final List<InviteSuggestionItem> component2() {
                return this.inviteSuggestionItems;
            }

            /* renamed from: component3, reason: from getter */
            public final String getSearchQuery() {
                return this.searchQuery;
            }

            public final Map<String, Set<Long>> component4() {
                return this.sentInvites;
            }

            /* renamed from: component5, reason: from getter */
            public final boolean getShowInviteSettings() {
                return this.showInviteSettings;
            }

            public final Loaded copy(WidgetInviteModel widgetInviteModel, List<? extends InviteSuggestionItem> inviteSuggestionItems, String searchQuery, Map<String, ? extends Set<Long>> sentInvites, boolean showInviteSettings) {
                m.checkNotNullParameter(widgetInviteModel, "widgetInviteModel");
                m.checkNotNullParameter(inviteSuggestionItems, "inviteSuggestionItems");
                m.checkNotNullParameter(searchQuery, "searchQuery");
                m.checkNotNullParameter(sentInvites, "sentInvites");
                return new Loaded(widgetInviteModel, inviteSuggestionItems, searchQuery, sentInvites, showInviteSettings);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Loaded)) {
                    return false;
                }
                Loaded loaded = (Loaded) other;
                return m.areEqual(this.widgetInviteModel, loaded.widgetInviteModel) && m.areEqual(this.inviteSuggestionItems, loaded.inviteSuggestionItems) && m.areEqual(this.searchQuery, loaded.searchQuery) && m.areEqual(this.sentInvites, loaded.sentInvites) && this.showInviteSettings == loaded.showInviteSettings;
            }

            public final List<InviteSuggestionItem> getInviteSuggestionItems() {
                return this.inviteSuggestionItems;
            }

            public final String getSearchQuery() {
                return this.searchQuery;
            }

            public final Map<String, Set<Long>> getSentInvites() {
                return this.sentInvites;
            }

            public final boolean getShowInviteSettings() {
                return this.showInviteSettings;
            }

            public final WidgetInviteModel getWidgetInviteModel() {
                return this.widgetInviteModel;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public int hashCode() {
                WidgetInviteModel widgetInviteModel = this.widgetInviteModel;
                int iHashCode = (widgetInviteModel != null ? widgetInviteModel.hashCode() : 0) * 31;
                List<InviteSuggestionItem> list = this.inviteSuggestionItems;
                int iHashCode2 = (iHashCode + (list != null ? list.hashCode() : 0)) * 31;
                String str = this.searchQuery;
                int iHashCode3 = (iHashCode2 + (str != null ? str.hashCode() : 0)) * 31;
                Map<String, Set<Long>> map = this.sentInvites;
                int iHashCode4 = (iHashCode3 + (map != null ? map.hashCode() : 0)) * 31;
                boolean z2 = this.showInviteSettings;
                int i = z2;
                if (z2 != 0) {
                    i = 1;
                }
                return iHashCode4 + i;
            }

            public String toString() {
                StringBuilder sbU = a.U("Loaded(widgetInviteModel=");
                sbU.append(this.widgetInviteModel);
                sbU.append(", inviteSuggestionItems=");
                sbU.append(this.inviteSuggestionItems);
                sbU.append(", searchQuery=");
                sbU.append(this.searchQuery);
                sbU.append(", sentInvites=");
                sbU.append(this.sentInvites);
                sbU.append(", showInviteSettings=");
                return a.O(sbU, this.showInviteSettings, ")");
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            public Loaded(WidgetInviteModel widgetInviteModel, List<? extends InviteSuggestionItem> list, String str, Map<String, ? extends Set<Long>> map, boolean z2) {
                super(null);
                m.checkNotNullParameter(widgetInviteModel, "widgetInviteModel");
                m.checkNotNullParameter(list, "inviteSuggestionItems");
                m.checkNotNullParameter(str, "searchQuery");
                m.checkNotNullParameter(map, "sentInvites");
                this.widgetInviteModel = widgetInviteModel;
                this.inviteSuggestionItems = list;
                this.searchQuery = str;
                this.sentInvites = map;
                this.showInviteSettings = z2;
            }
        }

        /* compiled from: WidgetGuildInviteShareViewModel.kt */
        public static final class Uninitialized extends ViewState {
            public static final Uninitialized INSTANCE = new Uninitialized();

            private Uninitialized() {
                super(null);
            }
        }

        private ViewState() {
        }

        public /* synthetic */ ViewState(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetGuildInviteShareViewModel.kt */
    /* renamed from: com.discord.widgets.guilds.invite.WidgetGuildInviteShareViewModel$observeWidgetInviteViewModel$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function10<ModelInvite.Settings, Map<Long, ? extends Channel>, InviteGenerator.InviteGenerationState, Long, MeUser, List<? extends Channel>, Guild, Map<Long, ? extends StageInstance>, GuildScheduledEvent, StoreInstantInvites.InviteState, WidgetInviteModel> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(10);
        }

        @Override // kotlin.jvm.functions.Function10
        public /* bridge */ /* synthetic */ WidgetInviteModel invoke(ModelInvite.Settings settings, Map<Long, ? extends Channel> map, InviteGenerator.InviteGenerationState inviteGenerationState, Long l, MeUser meUser, List<? extends Channel> list, Guild guild, Map<Long, ? extends StageInstance> map2, GuildScheduledEvent guildScheduledEvent, StoreInstantInvites.InviteState inviteState) {
            return invoke2(settings, (Map<Long, Channel>) map, inviteGenerationState, l, meUser, (List<Channel>) list, guild, (Map<Long, StageInstance>) map2, guildScheduledEvent, inviteState);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final WidgetInviteModel invoke2(ModelInvite.Settings settings, Map<Long, Channel> map, InviteGenerator.InviteGenerationState inviteGenerationState, Long l, MeUser meUser, List<Channel> list, Guild guild, Map<Long, StageInstance> map2, GuildScheduledEvent guildScheduledEvent, StoreInstantInvites.InviteState inviteState) {
            StoreInstantInvites.InviteState inviteState2 = inviteState;
            m.checkNotNullParameter(settings, "settings");
            m.checkNotNullParameter(map, "invitableChannels");
            m.checkNotNullParameter(inviteGenerationState, "inviteGenerationState");
            m.checkNotNullParameter(meUser, "me");
            m.checkNotNullParameter(list, "dms");
            m.checkNotNullParameter(map2, "guildStageInstances");
            m.checkNotNullParameter(inviteState2, "storeInvite");
            WidgetInviteModel.Companion companion = WidgetInviteModel.INSTANCE;
            if (!(inviteState2 instanceof StoreInstantInvites.InviteState.Resolved)) {
                inviteState2 = null;
            }
            StoreInstantInvites.InviteState.Resolved resolved = (StoreInstantInvites.InviteState.Resolved) inviteState2;
            return companion.create(settings, map, inviteGenerationState, l, meUser, list, guild, map2, guildScheduledEvent, resolved != null ? resolved.getInvite() : null);
        }
    }

    /* compiled from: WidgetGuildInviteShareViewModel.kt */
    /* renamed from: com.discord.widgets.guilds.invite.WidgetGuildInviteShareViewModel$sendInviteToChannel$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function1<MessageResult, Unit> {
        public final /* synthetic */ ModelInvite $invite;
        public final /* synthetic */ String $inviteLink;
        public final /* synthetic */ ViewState.Loaded $viewState;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(ModelInvite modelInvite, ViewState.Loaded loaded, String str) {
            super(1);
            this.$invite = modelInvite;
            this.$viewState = loaded;
            this.$inviteLink = str;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(MessageResult messageResult) {
            invoke2(messageResult);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(MessageResult messageResult) {
            m.checkNotNullParameter(messageResult, "result");
            if (messageResult instanceof MessageResult.Success) {
                MessageResult.Success success = (MessageResult.Success) messageResult;
                StoreStream.INSTANCE.getAnalytics().inviteSent(this.$invite, success.getMessage(), "Guild Create Invite Suggestion");
                Map<String, Set<Long>> sentInvites = this.$viewState.getSentInvites();
                String str = this.$inviteLink;
                m.checkNotNullExpressionValue(str, "inviteLink");
                Set<Long> setEmptySet = sentInvites.get(str);
                if (setEmptySet == null) {
                    setEmptySet = n0.emptySet();
                }
                WidgetGuildInviteShareViewModel.access$updateSentInvites(WidgetGuildInviteShareViewModel.this, h0.plus(sentInvites, g0.mapOf(d0.o.to(this.$inviteLink, o0.plus(setEmptySet, Long.valueOf(success.getMessage().getChannelId()))))));
            }
        }
    }

    /* compiled from: WidgetGuildInviteShareViewModel.kt */
    /* renamed from: com.discord.widgets.guilds.invite.WidgetGuildInviteShareViewModel$sendInviteToUser$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function1<Channel, Unit> {
        public final /* synthetic */ ModelInvite $invite;
        public final /* synthetic */ ViewState.Loaded $viewState;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(ViewState.Loaded loaded, ModelInvite modelInvite) {
            super(1);
            this.$viewState = loaded;
            this.$invite = modelInvite;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Channel channel) {
            invoke2(channel);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Channel channel) {
            m.checkNotNullParameter(channel, "channel");
            WidgetGuildInviteShareViewModel.this.sendInviteToChannel(channel.getId(), this.$viewState, this.$invite);
        }
    }

    public /* synthetic */ WidgetGuildInviteShareViewModel(StoreChannels storeChannels, StoreGuilds storeGuilds, StoreInviteSettings storeInviteSettings, StoreUser storeUser, StoreStageInstances storeStageInstances, StoreGuildScheduledEvents storeGuildScheduledEvents, StoreInstantInvites storeInstantInvites, InviteGenerator inviteGenerator, InviteSuggestionsManager inviteSuggestionsManager, Resources resources, boolean z2, long j, Long l, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? StoreStream.INSTANCE.getChannels() : storeChannels, (i & 2) != 0 ? StoreStream.INSTANCE.getGuilds() : storeGuilds, (i & 4) != 0 ? StoreStream.INSTANCE.getInviteSettings() : storeInviteSettings, (i & 8) != 0 ? StoreStream.INSTANCE.getUsers() : storeUser, (i & 16) != 0 ? StoreStream.INSTANCE.getStageInstances() : storeStageInstances, (i & 32) != 0 ? StoreStream.INSTANCE.getGuildScheduledEvents() : storeGuildScheduledEvents, (i & 64) != 0 ? StoreStream.INSTANCE.getInstantInvites() : storeInstantInvites, (i & 128) != 0 ? new InviteGenerator() : inviteGenerator, (i & 256) != 0 ? new InviteSuggestionsManager(null, null, null, null, null, 31, null) : inviteSuggestionsManager, resources, (i & 1024) != 0 ? true : z2, j, l, str);
    }

    public static final /* synthetic */ void access$generateInviteLinkFromViewState(WidgetGuildInviteShareViewModel widgetGuildInviteShareViewModel, ViewState.Loaded loaded) {
        widgetGuildInviteShareViewModel.generateInviteLinkFromViewState(loaded);
    }

    public static final /* synthetic */ String access$getInviteLink$p(WidgetGuildInviteShareViewModel widgetGuildInviteShareViewModel, ModelInvite modelInvite) {
        return widgetGuildInviteShareViewModel.getInviteLink(modelInvite);
    }

    public static final /* synthetic */ void access$updateSentInvites(WidgetGuildInviteShareViewModel widgetGuildInviteShareViewModel, Map map) {
        widgetGuildInviteShareViewModel.updateSentInvites(map);
    }

    public static final /* synthetic */ void access$updateViewState(WidgetGuildInviteShareViewModel widgetGuildInviteShareViewModel, ViewState viewState) {
        widgetGuildInviteShareViewModel.updateViewState(viewState);
    }

    private final void generateInviteLinkFromViewState(ViewState.Loaded viewState) {
        WidgetInviteModel widgetInviteModel = viewState.getWidgetInviteModel();
        if (widgetInviteModel.isValidInvite() || widgetInviteModel.isGeneratingInvite() || widgetInviteModel.getTargetChannel() == null) {
            return;
        }
        this.inviteGenerator.generateForAppComponent(this, widgetInviteModel.getTargetChannel().getId());
    }

    private final String getInviteLink(ModelInvite modelInvite) {
        return modelInvite == null ? BuildConfig.HOST_INVITE : modelInvite.toLink(this.resources, BuildConfig.HOST_INVITE);
    }

    private final Observable<WidgetInviteModel> observeWidgetInviteViewModel(long guildId, Long eventId, String inviteStoreKey) {
        Observable<WidgetInviteModel> observableR = ObservableExtensionsKt.computationLatest(ObservableCombineLatestOverloadsKt.combineLatest(this.storeInviteSettings.getInviteSettings(), this.storeInviteSettings.getInvitableChannels(guildId), this.inviteGenerator.getGenerationState(), this.selectedChannelSubject, StoreUser.observeMe$default(this.storeUser, false, 1, null), this.storeChannels.observeDMs(), this.storeGuilds.observeGuild(guildId), this.storeStageInstances.observeStageInstancesForGuild(guildId), this.storeGuildScheduledEvents.observeGuildScheduledEvent(eventId, Long.valueOf(guildId)), this.storeInstantInvites.observeInvite(inviteStoreKey), AnonymousClass1.INSTANCE)).r();
        m.checkNotNullExpressionValue(observableR, "combineLatest(\n        s…  .distinctUntilChanged()");
        return observableR;
    }

    private final void updateSentInvites(Map<String, ? extends Set<Long>> sentInvites) {
        this.sentInvitesSubject.onNext(sentInvites);
    }

    public final void generateInviteLink(long channelId) {
        this.inviteGenerator.generateForAppComponent(this, channelId);
    }

    public final Experiment getDefaultInviteExperiment() {
        return this.storeInviteSettings.getInviteGuildExperiment(this.guildId, true);
    }

    public final Long getEventId() {
        return this.eventId;
    }

    public final long getGuildId() {
        return this.guildId;
    }

    public final InviteGenerator getInviteGenerator() {
        return this.inviteGenerator;
    }

    public final String getInviteStoreKey() {
        return this.inviteStoreKey;
    }

    public final InviteSuggestionsManager getInviteSuggestionsManager() {
        return this.inviteSuggestionsManager;
    }

    public final Resources getResources() {
        return this.resources;
    }

    public final StoreChannels getStoreChannels() {
        return this.storeChannels;
    }

    public final StoreGuildScheduledEvents getStoreGuildScheduledEvents() {
        return this.storeGuildScheduledEvents;
    }

    public final StoreGuilds getStoreGuilds() {
        return this.storeGuilds;
    }

    public final StoreInstantInvites getStoreInstantInvites() {
        return this.storeInstantInvites;
    }

    public final StoreInviteSettings getStoreInviteSettings() {
        return this.storeInviteSettings;
    }

    public final StoreStageInstances getStoreStageInstances() {
        return this.storeStageInstances;
    }

    public final StoreUser getStoreUser() {
        return this.storeUser;
    }

    public final boolean getSubscribeOnInit() {
        return this.subscribeOnInit;
    }

    public final Observable<ViewState.Loaded> observeViewStateFromStores$app_productionGoogleRelease(long guildId, Long eventId, String inviteStoreKey) {
        Observable<ViewState.Loaded> observableG = Observable.g(observeWidgetInviteViewModel(guildId, eventId, inviteStoreKey), this.inviteSuggestionsManager.observeInviteSuggestions(), this.filterPublisher, this.sentInvitesSubject, this.refreshUiSubject, new WidgetGuildInviteShareViewModel$observeViewStateFromStores$1(this));
        m.checkNotNullExpressionValue(observableG, "Observable.combineLatest…iteSettings\n      )\n    }");
        return observableG;
    }

    public final void refreshUi() {
        this.refreshUiSubject.onNext(Unit.a);
    }

    public final void selectChannel(long channelId) {
        this.selectedChannelSubject.onNext(Long.valueOf(channelId));
    }

    public final void sendInviteToChannel(long channelId, ViewState.Loaded viewState, ModelInvite invite) {
        m.checkNotNullParameter(viewState, "viewState");
        String inviteLink = getInviteLink(invite);
        StoreMessages messages = StoreStream.INSTANCE.getMessages();
        MeUser me2 = viewState.getWidgetInviteModel().getMe();
        m.checkNotNullExpressionValue(inviteLink, "inviteLink");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(StoreMessages.sendMessage$default(messages, channelId, me2, inviteLink, null, null, null, null, null, null, null, null, null, null, null, null, 32736, null), this, null, 2, null), WidgetGuildInviteShareViewModel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(invite, viewState, inviteLink), 62, (Object) null);
    }

    public final void sendInviteToUser(long userId, ViewState.Loaded viewState, ModelInvite invite) {
        m.checkNotNullParameter(viewState, "viewState");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.INSTANCE.getApi().createOrFetchDM(userId), false, 1, null), this, null, 2, null), WidgetGuildInviteShareViewModel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(viewState, invite), 62, (Object) null);
    }

    public final void updateInviteSettings(ModelInvite.Settings settings) {
        m.checkNotNullParameter(settings, "settings");
        this.storeInviteSettings.setInviteSettings(settings);
    }

    public final void updateSearchQuery(String searchQuery) {
        m.checkNotNullParameter(searchQuery, "searchQuery");
        this.filterPublisher.onNext(searchQuery);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetGuildInviteShareViewModel(StoreChannels storeChannels, StoreGuilds storeGuilds, StoreInviteSettings storeInviteSettings, StoreUser storeUser, StoreStageInstances storeStageInstances, StoreGuildScheduledEvents storeGuildScheduledEvents, StoreInstantInvites storeInstantInvites, InviteGenerator inviteGenerator, InviteSuggestionsManager inviteSuggestionsManager, Resources resources, boolean z2, long j, Long l, String str) {
        super(ViewState.Uninitialized.INSTANCE);
        m.checkNotNullParameter(storeChannels, "storeChannels");
        m.checkNotNullParameter(storeGuilds, "storeGuilds");
        m.checkNotNullParameter(storeInviteSettings, "storeInviteSettings");
        m.checkNotNullParameter(storeUser, "storeUser");
        m.checkNotNullParameter(storeStageInstances, "storeStageInstances");
        m.checkNotNullParameter(storeGuildScheduledEvents, "storeGuildScheduledEvents");
        m.checkNotNullParameter(storeInstantInvites, "storeInstantInvites");
        m.checkNotNullParameter(inviteGenerator, "inviteGenerator");
        m.checkNotNullParameter(inviteSuggestionsManager, "inviteSuggestionsManager");
        m.checkNotNullParameter(resources, "resources");
        this.storeChannels = storeChannels;
        this.storeGuilds = storeGuilds;
        this.storeInviteSettings = storeInviteSettings;
        this.storeUser = storeUser;
        this.storeStageInstances = storeStageInstances;
        this.storeGuildScheduledEvents = storeGuildScheduledEvents;
        this.storeInstantInvites = storeInstantInvites;
        this.inviteGenerator = inviteGenerator;
        this.inviteSuggestionsManager = inviteSuggestionsManager;
        this.resources = resources;
        this.subscribeOnInit = z2;
        this.guildId = j;
        this.eventId = l;
        this.inviteStoreKey = str;
        BehaviorSubject<Map<String, Set<Long>>> behaviorSubjectL0 = BehaviorSubject.l0(h0.emptyMap());
        m.checkNotNullExpressionValue(behaviorSubjectL0, "BehaviorSubject.create(emptyMap())");
        this.sentInvitesSubject = behaviorSubjectL0;
        this.filterPublisher = BehaviorSubject.l0("");
        BehaviorSubject<Long> behaviorSubjectL02 = BehaviorSubject.l0(null);
        m.checkNotNullExpressionValue(behaviorSubjectL02, "BehaviorSubject.create(null as ChannelId?)");
        this.selectedChannelSubject = behaviorSubjectL02;
        BehaviorSubject<Unit> behaviorSubjectL03 = BehaviorSubject.l0(Unit.a);
        m.checkNotNullExpressionValue(behaviorSubjectL03, "BehaviorSubject.create(Unit)");
        this.refreshUiSubject = behaviorSubjectL03;
        if (z2) {
            Observable<ViewState.Loaded> observableU = observeViewStateFromStores$app_productionGoogleRelease(j, l, str).u(new AnonymousClass1());
            m.checkNotNullExpressionValue(observableU, "observeViewStateFromStor…romViewState(viewState) }");
            ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationBuffered(observableU), this, null, 2, null), WidgetGuildInviteShareViewModel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass2(this), 62, (Object) null);
        }
    }
}

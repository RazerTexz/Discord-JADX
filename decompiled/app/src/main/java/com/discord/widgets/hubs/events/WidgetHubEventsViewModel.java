package com.discord.widgets.hubs.events;

import android.content.Context;
import b.a.d.d0;
import com.discord.api.channel.Channel;
import com.discord.api.directory.DirectoryEntryEvent;
import com.discord.api.guildscheduledevent.GuildScheduledEvent;
import com.discord.api.permission.Permission;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.stores.StoreChannels;
import com.discord.stores.StoreDirectories;
import com.discord.stores.StoreGuildScheduledEvents;
import com.discord.stores.StoreGuilds;
import com.discord.stores.StorePermissions;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreVoiceChannelSelected;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeckProvider;
import com.discord.stores.utilities.Default;
import com.discord.stores.utilities.RestCallState;
import com.discord.utilities.guildscheduledevent.GuildScheduledEventUtilities;
import com.discord.utilities.permissions.PermissionUtils;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.t.n;
import d0.z.d.k;
import d0.z.d.m;
import d0.z.d.o;
import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* compiled from: WidgetHubEventsViewModel.kt */
/* loaded from: classes2.dex */
public final class WidgetHubEventsViewModel extends d0<WidgetHubEventsState> {
    private final StoreDirectories directoriesStore;
    private final long directoryChannelId;
    private final long guildId;
    private final StoreGuildScheduledEvents guildScheduledEventsStore;

    /* compiled from: WidgetHubEventsViewModel.kt */
    /* renamed from: com.discord.widgets.hubs.events.WidgetHubEventsViewModel$1, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass1 extends k implements Function1<WidgetHubEventsState, Unit> {
        public AnonymousClass1(WidgetHubEventsViewModel widgetHubEventsViewModel) {
            super(1, widgetHubEventsViewModel, WidgetHubEventsViewModel.class, "updateViewState", "updateViewState(Ljava/lang/Object;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(WidgetHubEventsState widgetHubEventsState) {
            invoke2(widgetHubEventsState);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(WidgetHubEventsState widgetHubEventsState) {
            m.checkNotNullParameter(widgetHubEventsState, "p1");
            WidgetHubEventsViewModel.access$updateViewState((WidgetHubEventsViewModel) this.receiver, widgetHubEventsState);
        }
    }

    /* compiled from: WidgetHubEventsViewModel.kt */
    /* renamed from: com.discord.widgets.hubs.events.WidgetHubEventsViewModel$getObservableFromStores$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function0<WidgetHubEventsState> {
        public final /* synthetic */ StoreChannels $channelsStore;
        public final /* synthetic */ StoreDirectories $directoriesStore;
        public final /* synthetic */ long $directoryChannelId;
        public final /* synthetic */ StoreGuildScheduledEvents $guildScheduledEventsStore;
        public final /* synthetic */ StoreGuilds $guildsStore;
        public final /* synthetic */ StorePermissions $permissionsStore;
        public final /* synthetic */ StoreVoiceChannelSelected $voiceChannelSelectedStore;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(StoreDirectories storeDirectories, long j, StoreChannels storeChannels, StoreGuildScheduledEvents storeGuildScheduledEvents, StoreVoiceChannelSelected storeVoiceChannelSelected, StorePermissions storePermissions, StoreGuilds storeGuilds) {
            super(0);
            this.$directoriesStore = storeDirectories;
            this.$directoryChannelId = j;
            this.$channelsStore = storeChannels;
            this.$guildScheduledEventsStore = storeGuildScheduledEvents;
            this.$voiceChannelSelectedStore = storeVoiceChannelSelected;
            this.$permissionsStore = storePermissions;
            this.$guildsStore = storeGuilds;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ WidgetHubEventsState invoke() {
            return invoke();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        /* JADX WARN: Removed duplicated region for block: B:27:0x00c7  */
        @Override // kotlin.jvm.functions.Function0
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final WidgetHubEventsState invoke() {
            List<HubGuildScheduledEventData> listEmptyList;
            boolean z2;
            RestCallState<List<DirectoryEntryEvent>> guildScheduledEventsForChannel = this.$directoriesStore.getGuildScheduledEventsForChannel(this.$directoryChannelId);
            if (guildScheduledEventsForChannel == null) {
                return WidgetHubEventsViewModel.access$getViewState$p(WidgetHubEventsViewModel.this);
            }
            List<DirectoryEntryEvent> listInvoke = guildScheduledEventsForChannel.invoke();
            if (listInvoke != null) {
                listEmptyList = new ArrayList<>(d0.t.o.collectionSizeOrDefault(listInvoke, 10));
                for (DirectoryEntryEvent directoryEntryEvent : listInvoke) {
                    long guildId = directoryEntryEvent.getGuildScheduledEvent().getGuildId();
                    Long channelId = directoryEntryEvent.getGuildScheduledEvent().getChannelId();
                    long j = this.$directoryChannelId;
                    GuildScheduledEvent guildScheduledEvent = directoryEntryEvent.getGuildScheduledEvent();
                    Channel channel = channelId != null ? this.$channelsStore.getChannel(channelId.longValue()) : null;
                    boolean zContains = this.$guildScheduledEventsStore.getMeGuildScheduledEventIds(guildId).contains(Long.valueOf(directoryEntryEvent.getGuildScheduledEvent().getId()));
                    GuildScheduledEventUtilities.Companion companion = GuildScheduledEventUtilities.INSTANCE;
                    boolean zCanStartEvent$default = GuildScheduledEventUtilities.Companion.canStartEvent$default(companion, guildId, channelId, null, null, 12, null);
                    boolean zCanShareEvent$default = GuildScheduledEventUtilities.Companion.canShareEvent$default(companion, channelId, guildId, null, null, null, null, 60, null);
                    Long lValueOf = Long.valueOf(this.$voiceChannelSelectedStore.getSelectedVoiceChannelId());
                    if (!(lValueOf.longValue() != 0)) {
                        lValueOf = null;
                    }
                    if (lValueOf != null) {
                        z2 = channelId != null && lValueOf.longValue() == channelId.longValue();
                    }
                    listEmptyList.add(new HubGuildScheduledEventData(j, guildScheduledEvent, channel, zContains, zCanShareEvent$default, zCanStartEvent$default, channelId != null ? PermissionUtils.can(Permission.CONNECT, this.$permissionsStore.getPermissionsByChannel().get(Long.valueOf(channelId.longValue()))) : false, z2, this.$guildsStore.getGuild(guildId) != null));
                }
            } else {
                WidgetHubEventsState widgetHubEventsStateAccess$getViewState$p = WidgetHubEventsViewModel.access$getViewState$p(WidgetHubEventsViewModel.this);
                List<HubGuildScheduledEventData> eventsData = widgetHubEventsStateAccess$getViewState$p != null ? widgetHubEventsStateAccess$getViewState$p.getEventsData() : null;
                listEmptyList = eventsData != null ? eventsData : n.emptyList();
            }
            return new WidgetHubEventsState(!this.$directoriesStore.getGuildScheduledEventsHeaderDismissed(), listEmptyList, guildScheduledEventsForChannel);
        }
    }

    public /* synthetic */ WidgetHubEventsViewModel(long j, long j2, StoreDirectories storeDirectories, StoreGuilds storeGuilds, StoreChannels storeChannels, StoreVoiceChannelSelected storeVoiceChannelSelected, StoreGuildScheduledEvents storeGuildScheduledEvents, StorePermissions storePermissions, ObservationDeck observationDeck, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, j2, (i & 4) != 0 ? StoreStream.INSTANCE.getDirectories() : storeDirectories, (i & 8) != 0 ? StoreStream.INSTANCE.getGuilds() : storeGuilds, (i & 16) != 0 ? StoreStream.INSTANCE.getChannels() : storeChannels, (i & 32) != 0 ? StoreStream.INSTANCE.getVoiceChannelSelected() : storeVoiceChannelSelected, (i & 64) != 0 ? StoreStream.INSTANCE.getGuildScheduledEvents() : storeGuildScheduledEvents, (i & 128) != 0 ? StoreStream.INSTANCE.getPermissions() : storePermissions, (i & 256) != 0 ? ObservationDeckProvider.get() : observationDeck);
    }

    public static final /* synthetic */ WidgetHubEventsState access$getViewState$p(WidgetHubEventsViewModel widgetHubEventsViewModel) {
        return widgetHubEventsViewModel.getViewState();
    }

    public static final /* synthetic */ void access$updateViewState(WidgetHubEventsViewModel widgetHubEventsViewModel, WidgetHubEventsState widgetHubEventsState) {
        widgetHubEventsViewModel.updateViewState(widgetHubEventsState);
    }

    private final Observable<WidgetHubEventsState> getObservableFromStores(ObservationDeck observationDeck, StoreDirectories directoriesStore, StoreGuilds guildsStore, StoreChannels channelsStore, StoreVoiceChannelSelected voiceChannelSelectedStore, StoreGuildScheduledEvents guildScheduledEventsStore, StorePermissions permissionsStore, long directoryChannelId) {
        return ObservationDeck.connectRx$default(observationDeck, new ObservationDeck.UpdateSource[]{directoriesStore, guildsStore, channelsStore, voiceChannelSelectedStore, guildScheduledEventsStore, permissionsStore}, false, null, null, new AnonymousClass1(directoriesStore, directoryChannelId, channelsStore, guildScheduledEventsStore, voiceChannelSelectedStore, permissionsStore, guildsStore), 14, null);
    }

    public final void dismissHeader() {
        WidgetHubEventsState viewState = getViewState();
        if (viewState != null) {
            updateViewState(WidgetHubEventsState.copy$default(viewState, false, null, null, 6, null));
        }
        this.directoriesStore.markGuildScheduledEventsHeaderDismissed();
    }

    public final void fetchGuildScheduledEvents() {
        this.directoriesStore.fetchGuildScheduledEventsForChannel(this.guildId, this.directoryChannelId);
    }

    public final StoreGuildScheduledEvents getGuildScheduledEventsStore() {
        return this.guildScheduledEventsStore;
    }

    public final void reset() {
        WidgetHubEventsState viewState = getViewState();
        m.checkNotNull(viewState);
        updateViewState(WidgetHubEventsState.copy$default(viewState, false, null, Default.INSTANCE, 3, null));
    }

    public final void toggleRsvp(GuildScheduledEvent event) {
        m.checkNotNullParameter(event, "event");
        this.guildScheduledEventsStore.toggleMeRsvpForEvent(event);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetHubEventsViewModel(long j, long j2, StoreDirectories storeDirectories, StoreGuilds storeGuilds, StoreChannels storeChannels, StoreVoiceChannelSelected storeVoiceChannelSelected, StoreGuildScheduledEvents storeGuildScheduledEvents, StorePermissions storePermissions, ObservationDeck observationDeck) {
        super(new WidgetHubEventsState(false, null, null, 7, null));
        m.checkNotNullParameter(storeDirectories, "directoriesStore");
        m.checkNotNullParameter(storeGuilds, "guildsStore");
        m.checkNotNullParameter(storeChannels, "channelsStore");
        m.checkNotNullParameter(storeVoiceChannelSelected, "voiceChannelSelectedStore");
        m.checkNotNullParameter(storeGuildScheduledEvents, "guildScheduledEventsStore");
        m.checkNotNullParameter(storePermissions, "permissionsStore");
        m.checkNotNullParameter(observationDeck, "observationDeck");
        this.guildId = j;
        this.directoryChannelId = j2;
        this.directoriesStore = storeDirectories;
        this.guildScheduledEventsStore = storeGuildScheduledEvents;
        Observable observableG = ObservableExtensionsKt.computationLatest(getObservableFromStores(observationDeck, storeDirectories, storeGuilds, storeChannels, storeVoiceChannelSelected, storeGuildScheduledEvents, storePermissions, j2)).y(ObservableExtensionsKt.AnonymousClass1.INSTANCE).G(ObservableExtensionsKt.AnonymousClass2.INSTANCE);
        m.checkNotNullExpressionValue(observableG, "filter { it != null }.map { it!! }");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(observableG, this, null, 2, null), WidgetHubEventsViewModel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(this), 62, (Object) null);
        fetchGuildScheduledEvents();
    }
}

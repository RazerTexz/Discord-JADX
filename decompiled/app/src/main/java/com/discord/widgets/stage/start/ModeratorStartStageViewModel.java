package com.discord.widgets.stage.start;

import android.content.Context;
import com.discord.api.guildscheduledevent.GuildScheduledEvent;
import com.discord.api.guildscheduledevent.GuildScheduledEventStatus;
import com.discord.models.guild.UserGuildMember;
import com.discord.stores.StoreChannels;
import com.discord.stores.StoreGuildScheduledEvents;
import com.discord.stores.StorePermissions;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreVoiceChannelSelected;
import com.discord.stores.StoreVoiceParticipants;
import com.discord.utilities.guildscheduledevent.GuildScheduledEventUtilities5;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.widgets.stage.start.ModeratorStartStageItem;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p007b.p008a.p018d.AppViewModel;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p580t.Collections2;
import p507d0.p580t._Collections;
import p507d0.p592z.p594d.FunctionReferenceImpl;
import p507d0.p592z.p594d.Intrinsics3;
import p658rx.Observable;

/* JADX INFO: compiled from: ModeratorStartStageViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ModeratorStartStageViewModel extends AppViewModel<ViewState> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final int MAX_DISPLAY_WAITING_USERS = 3;
    private final long channelId;
    private final StoreChannels channelsStore;
    private final StoreGuildScheduledEvents guildScheduledEventsStore;
    private final StorePermissions permissionsStore;
    private final StoreVoiceChannelSelected selectedVoiceChannelStore;
    private final StoreVoiceParticipants voiceParticipants;

    /* JADX INFO: renamed from: com.discord.widgets.stage.start.ModeratorStartStageViewModel$1 */
    /* JADX INFO: compiled from: ModeratorStartStageViewModel.kt */
    public static final /* synthetic */ class C100681 extends FunctionReferenceImpl implements Function1<StoreState, Unit> {
        public C100681(ModeratorStartStageViewModel moderatorStartStageViewModel) {
            super(1, moderatorStartStageViewModel, ModeratorStartStageViewModel.class, "handleStoreState", "handleStoreState(Lcom/discord/widgets/stage/start/ModeratorStartStageViewModel$StoreState;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(StoreState storeState) {
            invoke2(storeState);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(StoreState storeState) {
            Intrinsics3.checkNotNullParameter(storeState, "p1");
            ModeratorStartStageViewModel.access$handleStoreState((ModeratorStartStageViewModel) this.receiver, storeState);
        }
    }

    /* JADX INFO: compiled from: ModeratorStartStageViewModel.kt */
    public static final class Companion {
        private Companion() {
        }

        public static final /* synthetic */ Observable access$observeStores(Companion companion, long j, StoreChannels storeChannels, StoreGuildScheduledEvents storeGuildScheduledEvents, StorePermissions storePermissions, StoreVoiceParticipants storeVoiceParticipants) {
            return companion.observeStores(j, storeChannels, storeGuildScheduledEvents, storePermissions, storeVoiceParticipants);
        }

        private final Observable<StoreState> observeStores(long channelId, StoreChannels channelStore, StoreGuildScheduledEvents guildScheduledEventsStore, StorePermissions permissionsStore, StoreVoiceParticipants voiceParticipantsStore) {
            Observable<R> observableM11083G = channelStore.observeChannel(channelId).m11118y(ObservableExtensionsKt.C68871.INSTANCE).m11083G(ObservableExtensionsKt.C68882.INSTANCE);
            Intrinsics3.checkNotNullExpressionValue(observableM11083G, "filter { it != null }.map { it!! }");
            Observable<StoreState> observableM11099Y = observableM11083G.m11099Y(new ModeratorStartStageViewModel2(voiceParticipantsStore, guildScheduledEventsStore, permissionsStore, channelId));
            Intrinsics3.checkNotNullExpressionValue(observableM11099Y, "channelStore.observeChan…  )\n          }\n        }");
            return observableM11099Y;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: ModeratorStartStageViewModel.kt */
    public static final /* data */ class StoreState {
        private final boolean canStartEvent;
        private final List<GuildScheduledEvent> channelEvents;
        private final List<UserGuildMember> voiceParticipants;

        public StoreState(List<GuildScheduledEvent> list, List<UserGuildMember> list2, boolean z2) {
            Intrinsics3.checkNotNullParameter(list, "channelEvents");
            Intrinsics3.checkNotNullParameter(list2, "voiceParticipants");
            this.channelEvents = list;
            this.voiceParticipants = list2;
            this.canStartEvent = z2;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ StoreState copy$default(StoreState storeState, List list, List list2, boolean z2, int i, Object obj) {
            if ((i & 1) != 0) {
                list = storeState.channelEvents;
            }
            if ((i & 2) != 0) {
                list2 = storeState.voiceParticipants;
            }
            if ((i & 4) != 0) {
                z2 = storeState.canStartEvent;
            }
            return storeState.copy(list, list2, z2);
        }

        public final List<GuildScheduledEvent> component1() {
            return this.channelEvents;
        }

        public final List<UserGuildMember> component2() {
            return this.voiceParticipants;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final boolean getCanStartEvent() {
            return this.canStartEvent;
        }

        public final StoreState copy(List<GuildScheduledEvent> channelEvents, List<UserGuildMember> voiceParticipants, boolean canStartEvent) {
            Intrinsics3.checkNotNullParameter(channelEvents, "channelEvents");
            Intrinsics3.checkNotNullParameter(voiceParticipants, "voiceParticipants");
            return new StoreState(channelEvents, voiceParticipants, canStartEvent);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof StoreState)) {
                return false;
            }
            StoreState storeState = (StoreState) other;
            return Intrinsics3.areEqual(this.channelEvents, storeState.channelEvents) && Intrinsics3.areEqual(this.voiceParticipants, storeState.voiceParticipants) && this.canStartEvent == storeState.canStartEvent;
        }

        public final boolean getCanStartEvent() {
            return this.canStartEvent;
        }

        public final List<GuildScheduledEvent> getChannelEvents() {
            return this.channelEvents;
        }

        public final List<UserGuildMember> getVoiceParticipants() {
            return this.voiceParticipants;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r1v3, types: [int] */
        /* JADX WARN: Type inference failed for: r1v4 */
        /* JADX WARN: Type inference failed for: r1v6 */
        public int hashCode() {
            List<GuildScheduledEvent> list = this.channelEvents;
            int iHashCode = (list != null ? list.hashCode() : 0) * 31;
            List<UserGuildMember> list2 = this.voiceParticipants;
            int iHashCode2 = (iHashCode + (list2 != null ? list2.hashCode() : 0)) * 31;
            boolean z2 = this.canStartEvent;
            ?? r1 = z2;
            if (z2) {
                r1 = 1;
            }
            return iHashCode2 + r1;
        }

        public String toString() {
            StringBuilder sbM833U = outline.m833U("StoreState(channelEvents=");
            sbM833U.append(this.channelEvents);
            sbM833U.append(", voiceParticipants=");
            sbM833U.append(this.voiceParticipants);
            sbM833U.append(", canStartEvent=");
            return outline.m827O(sbM833U, this.canStartEvent, ")");
        }
    }

    /* JADX INFO: compiled from: ModeratorStartStageViewModel.kt */
    public static final /* data */ class ViewState {
        private final boolean channelEventActive;
        private final List<GuildScheduledEvent> channelEvents;
        private final List<ModeratorStartStageItem> items;

        /* JADX WARN: Multi-variable type inference failed */
        public ViewState(List<GuildScheduledEvent> list, List<? extends ModeratorStartStageItem> list2, boolean z2) {
            Intrinsics3.checkNotNullParameter(list, "channelEvents");
            Intrinsics3.checkNotNullParameter(list2, "items");
            this.channelEvents = list;
            this.items = list2;
            this.channelEventActive = z2;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ ViewState copy$default(ViewState viewState, List list, List list2, boolean z2, int i, Object obj) {
            if ((i & 1) != 0) {
                list = viewState.channelEvents;
            }
            if ((i & 2) != 0) {
                list2 = viewState.items;
            }
            if ((i & 4) != 0) {
                z2 = viewState.channelEventActive;
            }
            return viewState.copy(list, list2, z2);
        }

        public final List<GuildScheduledEvent> component1() {
            return this.channelEvents;
        }

        public final List<ModeratorStartStageItem> component2() {
            return this.items;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final boolean getChannelEventActive() {
            return this.channelEventActive;
        }

        public final ViewState copy(List<GuildScheduledEvent> channelEvents, List<? extends ModeratorStartStageItem> items, boolean channelEventActive) {
            Intrinsics3.checkNotNullParameter(channelEvents, "channelEvents");
            Intrinsics3.checkNotNullParameter(items, "items");
            return new ViewState(channelEvents, items, channelEventActive);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ViewState)) {
                return false;
            }
            ViewState viewState = (ViewState) other;
            return Intrinsics3.areEqual(this.channelEvents, viewState.channelEvents) && Intrinsics3.areEqual(this.items, viewState.items) && this.channelEventActive == viewState.channelEventActive;
        }

        public final boolean getChannelEventActive() {
            return this.channelEventActive;
        }

        public final List<GuildScheduledEvent> getChannelEvents() {
            return this.channelEvents;
        }

        public final List<ModeratorStartStageItem> getItems() {
            return this.items;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r1v3, types: [int] */
        /* JADX WARN: Type inference failed for: r1v4 */
        /* JADX WARN: Type inference failed for: r1v6 */
        public int hashCode() {
            List<GuildScheduledEvent> list = this.channelEvents;
            int iHashCode = (list != null ? list.hashCode() : 0) * 31;
            List<ModeratorStartStageItem> list2 = this.items;
            int iHashCode2 = (iHashCode + (list2 != null ? list2.hashCode() : 0)) * 31;
            boolean z2 = this.channelEventActive;
            ?? r1 = z2;
            if (z2) {
                r1 = 1;
            }
            return iHashCode2 + r1;
        }

        public String toString() {
            StringBuilder sbM833U = outline.m833U("ViewState(channelEvents=");
            sbM833U.append(this.channelEvents);
            sbM833U.append(", items=");
            sbM833U.append(this.items);
            sbM833U.append(", channelEventActive=");
            return outline.m827O(sbM833U, this.channelEventActive, ")");
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ ModeratorStartStageViewModel(long j, StoreChannels storeChannels, StoreGuildScheduledEvents storeGuildScheduledEvents, StoreVoiceChannelSelected storeVoiceChannelSelected, StorePermissions storePermissions, StoreVoiceParticipants storeVoiceParticipants, Observable observable, int i, DefaultConstructorMarker defaultConstructorMarker) {
        StoreChannels channels = (i & 2) != 0 ? StoreStream.INSTANCE.getChannels() : storeChannels;
        StoreGuildScheduledEvents guildScheduledEvents = (i & 4) != 0 ? StoreStream.INSTANCE.getGuildScheduledEvents() : storeGuildScheduledEvents;
        StoreVoiceChannelSelected voiceChannelSelected = (i & 8) != 0 ? StoreStream.INSTANCE.getVoiceChannelSelected() : storeVoiceChannelSelected;
        StorePermissions permissions = (i & 16) != 0 ? StoreStream.INSTANCE.getPermissions() : storePermissions;
        StoreVoiceParticipants voiceParticipants = (i & 32) != 0 ? StoreStream.INSTANCE.getVoiceParticipants() : storeVoiceParticipants;
        this(j, channels, guildScheduledEvents, voiceChannelSelected, permissions, voiceParticipants, (i & 64) != 0 ? Companion.access$observeStores(INSTANCE, j, channels, guildScheduledEvents, permissions, voiceParticipants) : observable);
    }

    public static final /* synthetic */ void access$handleStoreState(ModeratorStartStageViewModel moderatorStartStageViewModel, StoreState storeState) {
        moderatorStartStageViewModel.handleStoreState(storeState);
    }

    private final void handleStoreState(StoreState storeState) {
        Object next;
        Object obj = null;
        List listMutableListOf = Collections2.mutableListOf(new ModeratorStartStageItem.Header(0, null, 3, null));
        if (storeState.getCanStartEvent()) {
            Iterator<T> it = storeState.getChannelEvents().iterator();
            while (true) {
                if (!it.hasNext()) {
                    next = null;
                    break;
                } else {
                    next = it.next();
                    if (GuildScheduledEventUtilities5.getEventTiming((GuildScheduledEvent) next).isStartable()) {
                        break;
                    }
                }
            }
            GuildScheduledEvent guildScheduledEvent = (GuildScheduledEvent) next;
            if (guildScheduledEvent != null) {
                listMutableListOf.add(new ModeratorStartStageItem.ListItem.Event(guildScheduledEvent));
            }
        }
        listMutableListOf.add(new ModeratorStartStageItem.ListItem.StaticOption.StartStage(null, 1, null));
        if (storeState.getCanStartEvent()) {
            listMutableListOf.add(new ModeratorStartStageItem.ListItem.StaticOption.ScheduleEvent(null, 1, null));
        }
        listMutableListOf.add(new ModeratorStartStageItem.Continue(0, null, 3, null));
        if (!storeState.getVoiceParticipants().isEmpty()) {
            listMutableListOf.add(new ModeratorStartStageItem.Waiting(0, null, _Collections.take(storeState.getVoiceParticipants(), 3), 3, null));
        }
        List<GuildScheduledEvent> channelEvents = storeState.getChannelEvents();
        Iterator<T> it2 = storeState.getChannelEvents().iterator();
        while (true) {
            if (!it2.hasNext()) {
                break;
            }
            Object next2 = it2.next();
            if (((GuildScheduledEvent) next2).getStatus() == GuildScheduledEventStatus.ACTIVE) {
                obj = next2;
                break;
            }
        }
        updateViewState(new ViewState(channelEvents, listMutableListOf, obj != null));
    }

    public final void disconnectFromStage() {
        this.selectedVoiceChannelStore.clear();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ModeratorStartStageViewModel(long j, StoreChannels storeChannels, StoreGuildScheduledEvents storeGuildScheduledEvents, StoreVoiceChannelSelected storeVoiceChannelSelected, StorePermissions storePermissions, StoreVoiceParticipants storeVoiceParticipants, Observable<StoreState> observable) {
        super(null, 1, null);
        Intrinsics3.checkNotNullParameter(storeChannels, "channelsStore");
        Intrinsics3.checkNotNullParameter(storeGuildScheduledEvents, "guildScheduledEventsStore");
        Intrinsics3.checkNotNullParameter(storeVoiceChannelSelected, "selectedVoiceChannelStore");
        Intrinsics3.checkNotNullParameter(storePermissions, "permissionsStore");
        Intrinsics3.checkNotNullParameter(storeVoiceParticipants, "voiceParticipants");
        Intrinsics3.checkNotNullParameter(observable, "storeStateObservable");
        this.channelId = j;
        this.channelsStore = storeChannels;
        this.guildScheduledEventsStore = storeGuildScheduledEvents;
        this.selectedVoiceChannelStore = storeVoiceChannelSelected;
        this.permissionsStore = storePermissions;
        this.voiceParticipants = storeVoiceParticipants;
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationLatest(observable), this, null, 2, null), ModeratorStartStageViewModel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new C100681(this), 62, (Object) null);
    }
}

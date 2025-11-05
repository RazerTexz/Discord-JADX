package com.discord.widgets.voice.fullscreen;

import a0.a.a.b;
import android.content.Context;
import androidx.annotation.MainThread;
import androidx.core.app.NotificationCompat;
import b.a.d.d0;
import b.d.b.a.a;
import com.discord.api.channel.Channel;
import com.discord.stores.StoreChannels;
import com.discord.stores.StoreGuilds;
import com.discord.stores.StorePermissions;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreVoiceChannelSelected;
import com.discord.stores.StoreVoiceStates;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.voice.VoiceChannelJoinability;
import com.discord.utilities.voice.VoiceChannelJoinabilityUtils;
import d0.z.d.k;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.functions.Func2;
import rx.subjects.PublishSubject;

/* compiled from: WidgetGuildCallOnboardingSheetViewModel.kt */
/* loaded from: classes.dex */
public final class WidgetGuildCallOnboardingSheetViewModel extends d0<ViewState> {
    private final long channelId;
    private final StoreChannels channelsStore;
    private final PublishSubject<Event> eventSubject;
    private final StoreGuilds guildsStore;
    private final StorePermissions permissionsStore;
    private final StoreVoiceChannelSelected selectedVoiceChannelStore;
    private final StoreVoiceStates voiceStatesStore;

    /* compiled from: WidgetGuildCallOnboardingSheetViewModel.kt */
    /* renamed from: com.discord.widgets.voice.fullscreen.WidgetGuildCallOnboardingSheetViewModel$1, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass1 extends k implements Function1<StoreState, Unit> {
        public AnonymousClass1(WidgetGuildCallOnboardingSheetViewModel widgetGuildCallOnboardingSheetViewModel) {
            super(1, widgetGuildCallOnboardingSheetViewModel, WidgetGuildCallOnboardingSheetViewModel.class, "handleStoreState", "handleStoreState(Lcom/discord/widgets/voice/fullscreen/WidgetGuildCallOnboardingSheetViewModel$StoreState;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(StoreState storeState) {
            invoke2(storeState);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(StoreState storeState) {
            m.checkNotNullParameter(storeState, "p1");
            WidgetGuildCallOnboardingSheetViewModel.access$handleStoreState((WidgetGuildCallOnboardingSheetViewModel) this.receiver, storeState);
        }
    }

    /* compiled from: WidgetGuildCallOnboardingSheetViewModel.kt */
    public static abstract class Event {

        /* compiled from: WidgetGuildCallOnboardingSheetViewModel.kt */
        public static final /* data */ class LaunchGuildCallScreen extends Event {
            private final long channelId;
            private final Long guildId;

            public LaunchGuildCallScreen(long j, Long l) {
                super(null);
                this.channelId = j;
                this.guildId = l;
            }

            public static /* synthetic */ LaunchGuildCallScreen copy$default(LaunchGuildCallScreen launchGuildCallScreen, long j, Long l, int i, Object obj) {
                if ((i & 1) != 0) {
                    j = launchGuildCallScreen.channelId;
                }
                if ((i & 2) != 0) {
                    l = launchGuildCallScreen.guildId;
                }
                return launchGuildCallScreen.copy(j, l);
            }

            /* renamed from: component1, reason: from getter */
            public final long getChannelId() {
                return this.channelId;
            }

            /* renamed from: component2, reason: from getter */
            public final Long getGuildId() {
                return this.guildId;
            }

            public final LaunchGuildCallScreen copy(long channelId, Long guildId) {
                return new LaunchGuildCallScreen(channelId, guildId);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof LaunchGuildCallScreen)) {
                    return false;
                }
                LaunchGuildCallScreen launchGuildCallScreen = (LaunchGuildCallScreen) other;
                return this.channelId == launchGuildCallScreen.channelId && m.areEqual(this.guildId, launchGuildCallScreen.guildId);
            }

            public final long getChannelId() {
                return this.channelId;
            }

            public final Long getGuildId() {
                return this.guildId;
            }

            public int hashCode() {
                int iA = b.a(this.channelId) * 31;
                Long l = this.guildId;
                return iA + (l != null ? l.hashCode() : 0);
            }

            public String toString() {
                StringBuilder sbU = a.U("LaunchGuildCallScreen(channelId=");
                sbU.append(this.channelId);
                sbU.append(", guildId=");
                return a.G(sbU, this.guildId, ")");
            }
        }

        /* compiled from: WidgetGuildCallOnboardingSheetViewModel.kt */
        public static final class ShowGuildVideoCapacityDialog extends Event {
            public static final ShowGuildVideoCapacityDialog INSTANCE = new ShowGuildVideoCapacityDialog();

            private ShowGuildVideoCapacityDialog() {
                super(null);
            }
        }

        private Event() {
        }

        public /* synthetic */ Event(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetGuildCallOnboardingSheetViewModel.kt */
    public static final /* data */ class StoreState {
        private final Long guildId;
        private final VoiceChannelJoinability voiceChannelJoinability;

        public StoreState(Long l, VoiceChannelJoinability voiceChannelJoinability) {
            m.checkNotNullParameter(voiceChannelJoinability, "voiceChannelJoinability");
            this.guildId = l;
            this.voiceChannelJoinability = voiceChannelJoinability;
        }

        public static /* synthetic */ StoreState copy$default(StoreState storeState, Long l, VoiceChannelJoinability voiceChannelJoinability, int i, Object obj) {
            if ((i & 1) != 0) {
                l = storeState.guildId;
            }
            if ((i & 2) != 0) {
                voiceChannelJoinability = storeState.voiceChannelJoinability;
            }
            return storeState.copy(l, voiceChannelJoinability);
        }

        /* renamed from: component1, reason: from getter */
        public final Long getGuildId() {
            return this.guildId;
        }

        /* renamed from: component2, reason: from getter */
        public final VoiceChannelJoinability getVoiceChannelJoinability() {
            return this.voiceChannelJoinability;
        }

        public final StoreState copy(Long guildId, VoiceChannelJoinability voiceChannelJoinability) {
            m.checkNotNullParameter(voiceChannelJoinability, "voiceChannelJoinability");
            return new StoreState(guildId, voiceChannelJoinability);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof StoreState)) {
                return false;
            }
            StoreState storeState = (StoreState) other;
            return m.areEqual(this.guildId, storeState.guildId) && m.areEqual(this.voiceChannelJoinability, storeState.voiceChannelJoinability);
        }

        public final Long getGuildId() {
            return this.guildId;
        }

        public final VoiceChannelJoinability getVoiceChannelJoinability() {
            return this.voiceChannelJoinability;
        }

        public int hashCode() {
            Long l = this.guildId;
            int iHashCode = (l != null ? l.hashCode() : 0) * 31;
            VoiceChannelJoinability voiceChannelJoinability = this.voiceChannelJoinability;
            return iHashCode + (voiceChannelJoinability != null ? voiceChannelJoinability.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = a.U("StoreState(guildId=");
            sbU.append(this.guildId);
            sbU.append(", voiceChannelJoinability=");
            sbU.append(this.voiceChannelJoinability);
            sbU.append(")");
            return sbU.toString();
        }
    }

    /* compiled from: WidgetGuildCallOnboardingSheetViewModel.kt */
    public static abstract class ViewState {

        /* compiled from: WidgetGuildCallOnboardingSheetViewModel.kt */
        public static final /* data */ class Loaded extends ViewState {
            private final Long guildId;
            private final VoiceChannelJoinability joinability;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Loaded(Long l, VoiceChannelJoinability voiceChannelJoinability) {
                super(null);
                m.checkNotNullParameter(voiceChannelJoinability, "joinability");
                this.guildId = l;
                this.joinability = voiceChannelJoinability;
            }

            public static /* synthetic */ Loaded copy$default(Loaded loaded, Long l, VoiceChannelJoinability voiceChannelJoinability, int i, Object obj) {
                if ((i & 1) != 0) {
                    l = loaded.guildId;
                }
                if ((i & 2) != 0) {
                    voiceChannelJoinability = loaded.joinability;
                }
                return loaded.copy(l, voiceChannelJoinability);
            }

            /* renamed from: component1, reason: from getter */
            public final Long getGuildId() {
                return this.guildId;
            }

            /* renamed from: component2, reason: from getter */
            public final VoiceChannelJoinability getJoinability() {
                return this.joinability;
            }

            public final Loaded copy(Long guildId, VoiceChannelJoinability joinability) {
                m.checkNotNullParameter(joinability, "joinability");
                return new Loaded(guildId, joinability);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Loaded)) {
                    return false;
                }
                Loaded loaded = (Loaded) other;
                return m.areEqual(this.guildId, loaded.guildId) && m.areEqual(this.joinability, loaded.joinability);
            }

            public final Long getGuildId() {
                return this.guildId;
            }

            public final VoiceChannelJoinability getJoinability() {
                return this.joinability;
            }

            public int hashCode() {
                Long l = this.guildId;
                int iHashCode = (l != null ? l.hashCode() : 0) * 31;
                VoiceChannelJoinability voiceChannelJoinability = this.joinability;
                return iHashCode + (voiceChannelJoinability != null ? voiceChannelJoinability.hashCode() : 0);
            }

            public String toString() {
                StringBuilder sbU = a.U("Loaded(guildId=");
                sbU.append(this.guildId);
                sbU.append(", joinability=");
                sbU.append(this.joinability);
                sbU.append(")");
                return sbU.toString();
            }
        }

        /* compiled from: WidgetGuildCallOnboardingSheetViewModel.kt */
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

    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            VoiceChannelJoinability.values();
            int[] iArr = new int[5];
            $EnumSwitchMapping$0 = iArr;
            iArr[VoiceChannelJoinability.CAN_JOIN.ordinal()] = 1;
            iArr[VoiceChannelJoinability.GUILD_VIDEO_AT_CAPACITY.ordinal()] = 2;
            iArr[VoiceChannelJoinability.PERMISSIONS_MISSING.ordinal()] = 3;
            iArr[VoiceChannelJoinability.CHANNEL_FULL.ordinal()] = 4;
            iArr[VoiceChannelJoinability.CHANNEL_DOES_NOT_EXIST.ordinal()] = 5;
        }
    }

    /* compiled from: WidgetGuildCallOnboardingSheetViewModel.kt */
    /* renamed from: com.discord.widgets.voice.fullscreen.WidgetGuildCallOnboardingSheetViewModel$observeStoreState$1, reason: invalid class name */
    public static final class AnonymousClass1<T1, T2, R> implements Func2<Channel, VoiceChannelJoinability, StoreState> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        @Override // rx.functions.Func2
        public /* bridge */ /* synthetic */ StoreState call(Channel channel, VoiceChannelJoinability voiceChannelJoinability) {
            return call2(channel, voiceChannelJoinability);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final StoreState call2(Channel channel, VoiceChannelJoinability voiceChannelJoinability) {
            Long lValueOf = channel != null ? Long.valueOf(channel.getGuildId()) : null;
            m.checkNotNullExpressionValue(voiceChannelJoinability, "joinability");
            return new StoreState(lValueOf, voiceChannelJoinability);
        }
    }

    public /* synthetic */ WidgetGuildCallOnboardingSheetViewModel(long j, StoreVoiceChannelSelected storeVoiceChannelSelected, StorePermissions storePermissions, StoreChannels storeChannels, StoreGuilds storeGuilds, StoreVoiceStates storeVoiceStates, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, (i & 2) != 0 ? StoreStream.INSTANCE.getVoiceChannelSelected() : storeVoiceChannelSelected, (i & 4) != 0 ? StoreStream.INSTANCE.getPermissions() : storePermissions, (i & 8) != 0 ? StoreStream.INSTANCE.getChannels() : storeChannels, (i & 16) != 0 ? StoreStream.INSTANCE.getGuilds() : storeGuilds, (i & 32) != 0 ? StoreStream.INSTANCE.getVoiceStates() : storeVoiceStates);
    }

    public static final /* synthetic */ void access$handleStoreState(WidgetGuildCallOnboardingSheetViewModel widgetGuildCallOnboardingSheetViewModel, StoreState storeState) {
        widgetGuildCallOnboardingSheetViewModel.handleStoreState(storeState);
    }

    @MainThread
    private final void handleStoreState(StoreState storeState) {
        updateViewState(new ViewState.Loaded(storeState.getGuildId(), storeState.getVoiceChannelJoinability()));
    }

    private final Observable<StoreState> observeStoreState() {
        Observable<StoreState> observableJ = Observable.j(this.channelsStore.observeChannel(this.channelId), VoiceChannelJoinabilityUtils.observeJoinability$default(VoiceChannelJoinabilityUtils.INSTANCE, this.channelId, this.channelsStore, this.guildsStore, this.permissionsStore, this.voiceStatesStore, null, null, 96, null), AnonymousClass1.INSTANCE);
        m.checkNotNullExpressionValue(observableJ, "Observable.combineLatest…dId, joinability)\n      }");
        return observableJ;
    }

    public final Observable<Event> observeEvents() {
        PublishSubject<Event> publishSubject = this.eventSubject;
        m.checkNotNullExpressionValue(publishSubject, "eventSubject");
        return publishSubject;
    }

    @MainThread
    public final void onConnectPressed() {
        ViewState viewState = getViewState();
        if (!(viewState instanceof ViewState.Loaded)) {
            viewState = null;
        }
        ViewState.Loaded loaded = (ViewState.Loaded) viewState;
        if (loaded != null) {
            int iOrdinal = loaded.getJoinability().ordinal();
            if (iOrdinal == 0) {
                this.selectedVoiceChannelStore.selectVoiceChannel(this.channelId);
                PublishSubject<Event> publishSubject = this.eventSubject;
                publishSubject.k.onNext(new Event.LaunchGuildCallScreen(this.channelId, loaded.getGuildId()));
                return;
            }
            if (iOrdinal != 2) {
                return;
            }
            PublishSubject<Event> publishSubject2 = this.eventSubject;
            publishSubject2.k.onNext(Event.ShowGuildVideoCapacityDialog.INSTANCE);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetGuildCallOnboardingSheetViewModel(long j, StoreVoiceChannelSelected storeVoiceChannelSelected, StorePermissions storePermissions, StoreChannels storeChannels, StoreGuilds storeGuilds, StoreVoiceStates storeVoiceStates) {
        super(ViewState.Uninitialized.INSTANCE);
        m.checkNotNullParameter(storeVoiceChannelSelected, "selectedVoiceChannelStore");
        m.checkNotNullParameter(storePermissions, "permissionsStore");
        m.checkNotNullParameter(storeChannels, "channelsStore");
        m.checkNotNullParameter(storeGuilds, "guildsStore");
        m.checkNotNullParameter(storeVoiceStates, "voiceStatesStore");
        this.channelId = j;
        this.selectedVoiceChannelStore = storeVoiceChannelSelected;
        this.permissionsStore = storePermissions;
        this.channelsStore = storeChannels;
        this.guildsStore = storeGuilds;
        this.voiceStatesStore = storeVoiceStates;
        this.eventSubject = PublishSubject.k0();
        Observable<StoreState> observableR = observeStoreState().r();
        m.checkNotNullExpressionValue(observableR, "observeStoreState()\n    …  .distinctUntilChanged()");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationLatest(observableR), this, null, 2, null), WidgetGuildCallOnboardingSheetViewModel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(this), 62, (Object) null);
    }
}

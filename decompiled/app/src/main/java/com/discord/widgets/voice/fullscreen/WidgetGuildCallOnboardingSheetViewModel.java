package com.discord.widgets.voice.fullscreen;

import android.content.Context;
import androidx.annotation.MainThread;
import androidx.core.app.NotificationCompat;
import com.discord.api.channel.Channel;
import com.discord.stores.StoreChannels;
import com.discord.stores.StoreGuilds;
import com.discord.stores.StorePermissions;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreVoiceChannelSelected;
import com.discord.stores.StoreVoiceStates;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.voice.VoiceChannelJoinabilityUtils;
import com.discord.utilities.voice.VoiceChannelJoinabilityUtils2;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p001a0.p002a.p003a.C0002b;
import p007b.p008a.p018d.AppViewModel;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.FunctionReferenceImpl;
import p507d0.p592z.p594d.Intrinsics3;
import p658rx.Observable;
import p658rx.functions.Func2;
import p658rx.subjects.PublishSubject;

/* compiled from: WidgetGuildCallOnboardingSheetViewModel.kt */
/* loaded from: classes.dex */
public final class WidgetGuildCallOnboardingSheetViewModel extends AppViewModel<ViewState> {
    private final long channelId;
    private final StoreChannels channelsStore;
    private final PublishSubject<Event> eventSubject;
    private final StoreGuilds guildsStore;
    private final StorePermissions permissionsStore;
    private final StoreVoiceChannelSelected selectedVoiceChannelStore;
    private final StoreVoiceStates voiceStatesStore;

    /* compiled from: WidgetGuildCallOnboardingSheetViewModel.kt */
    /* renamed from: com.discord.widgets.voice.fullscreen.WidgetGuildCallOnboardingSheetViewModel$1 */
    public static final /* synthetic */ class C105511 extends FunctionReferenceImpl implements Function1<StoreState, Unit> {
        public C105511(WidgetGuildCallOnboardingSheetViewModel widgetGuildCallOnboardingSheetViewModel) {
            super(1, widgetGuildCallOnboardingSheetViewModel, WidgetGuildCallOnboardingSheetViewModel.class, "handleStoreState", "handleStoreState(Lcom/discord/widgets/voice/fullscreen/WidgetGuildCallOnboardingSheetViewModel$StoreState;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(StoreState storeState) {
            invoke2(storeState);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(StoreState storeState) {
            Intrinsics3.checkNotNullParameter(storeState, "p1");
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
                return this.channelId == launchGuildCallScreen.channelId && Intrinsics3.areEqual(this.guildId, launchGuildCallScreen.guildId);
            }

            public final long getChannelId() {
                return this.channelId;
            }

            public final Long getGuildId() {
                return this.guildId;
            }

            public int hashCode() {
                int iM3a = C0002b.m3a(this.channelId) * 31;
                Long l = this.guildId;
                return iM3a + (l != null ? l.hashCode() : 0);
            }

            public String toString() {
                StringBuilder sbM833U = outline.m833U("LaunchGuildCallScreen(channelId=");
                sbM833U.append(this.channelId);
                sbM833U.append(", guildId=");
                return outline.m819G(sbM833U, this.guildId, ")");
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
        private final VoiceChannelJoinabilityUtils2 voiceChannelJoinability;

        public StoreState(Long l, VoiceChannelJoinabilityUtils2 voiceChannelJoinabilityUtils2) {
            Intrinsics3.checkNotNullParameter(voiceChannelJoinabilityUtils2, "voiceChannelJoinability");
            this.guildId = l;
            this.voiceChannelJoinability = voiceChannelJoinabilityUtils2;
        }

        public static /* synthetic */ StoreState copy$default(StoreState storeState, Long l, VoiceChannelJoinabilityUtils2 voiceChannelJoinabilityUtils2, int i, Object obj) {
            if ((i & 1) != 0) {
                l = storeState.guildId;
            }
            if ((i & 2) != 0) {
                voiceChannelJoinabilityUtils2 = storeState.voiceChannelJoinability;
            }
            return storeState.copy(l, voiceChannelJoinabilityUtils2);
        }

        /* renamed from: component1, reason: from getter */
        public final Long getGuildId() {
            return this.guildId;
        }

        /* renamed from: component2, reason: from getter */
        public final VoiceChannelJoinabilityUtils2 getVoiceChannelJoinability() {
            return this.voiceChannelJoinability;
        }

        public final StoreState copy(Long guildId, VoiceChannelJoinabilityUtils2 voiceChannelJoinability) {
            Intrinsics3.checkNotNullParameter(voiceChannelJoinability, "voiceChannelJoinability");
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
            return Intrinsics3.areEqual(this.guildId, storeState.guildId) && Intrinsics3.areEqual(this.voiceChannelJoinability, storeState.voiceChannelJoinability);
        }

        public final Long getGuildId() {
            return this.guildId;
        }

        public final VoiceChannelJoinabilityUtils2 getVoiceChannelJoinability() {
            return this.voiceChannelJoinability;
        }

        public int hashCode() {
            Long l = this.guildId;
            int iHashCode = (l != null ? l.hashCode() : 0) * 31;
            VoiceChannelJoinabilityUtils2 voiceChannelJoinabilityUtils2 = this.voiceChannelJoinability;
            return iHashCode + (voiceChannelJoinabilityUtils2 != null ? voiceChannelJoinabilityUtils2.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbM833U = outline.m833U("StoreState(guildId=");
            sbM833U.append(this.guildId);
            sbM833U.append(", voiceChannelJoinability=");
            sbM833U.append(this.voiceChannelJoinability);
            sbM833U.append(")");
            return sbM833U.toString();
        }
    }

    /* compiled from: WidgetGuildCallOnboardingSheetViewModel.kt */
    public static abstract class ViewState {

        /* compiled from: WidgetGuildCallOnboardingSheetViewModel.kt */
        public static final /* data */ class Loaded extends ViewState {
            private final Long guildId;
            private final VoiceChannelJoinabilityUtils2 joinability;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Loaded(Long l, VoiceChannelJoinabilityUtils2 voiceChannelJoinabilityUtils2) {
                super(null);
                Intrinsics3.checkNotNullParameter(voiceChannelJoinabilityUtils2, "joinability");
                this.guildId = l;
                this.joinability = voiceChannelJoinabilityUtils2;
            }

            public static /* synthetic */ Loaded copy$default(Loaded loaded, Long l, VoiceChannelJoinabilityUtils2 voiceChannelJoinabilityUtils2, int i, Object obj) {
                if ((i & 1) != 0) {
                    l = loaded.guildId;
                }
                if ((i & 2) != 0) {
                    voiceChannelJoinabilityUtils2 = loaded.joinability;
                }
                return loaded.copy(l, voiceChannelJoinabilityUtils2);
            }

            /* renamed from: component1, reason: from getter */
            public final Long getGuildId() {
                return this.guildId;
            }

            /* renamed from: component2, reason: from getter */
            public final VoiceChannelJoinabilityUtils2 getJoinability() {
                return this.joinability;
            }

            public final Loaded copy(Long guildId, VoiceChannelJoinabilityUtils2 joinability) {
                Intrinsics3.checkNotNullParameter(joinability, "joinability");
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
                return Intrinsics3.areEqual(this.guildId, loaded.guildId) && Intrinsics3.areEqual(this.joinability, loaded.joinability);
            }

            public final Long getGuildId() {
                return this.guildId;
            }

            public final VoiceChannelJoinabilityUtils2 getJoinability() {
                return this.joinability;
            }

            public int hashCode() {
                Long l = this.guildId;
                int iHashCode = (l != null ? l.hashCode() : 0) * 31;
                VoiceChannelJoinabilityUtils2 voiceChannelJoinabilityUtils2 = this.joinability;
                return iHashCode + (voiceChannelJoinabilityUtils2 != null ? voiceChannelJoinabilityUtils2.hashCode() : 0);
            }

            public String toString() {
                StringBuilder sbM833U = outline.m833U("Loaded(guildId=");
                sbM833U.append(this.guildId);
                sbM833U.append(", joinability=");
                sbM833U.append(this.joinability);
                sbM833U.append(")");
                return sbM833U.toString();
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
            VoiceChannelJoinabilityUtils2.values();
            int[] iArr = new int[5];
            $EnumSwitchMapping$0 = iArr;
            iArr[VoiceChannelJoinabilityUtils2.CAN_JOIN.ordinal()] = 1;
            iArr[VoiceChannelJoinabilityUtils2.GUILD_VIDEO_AT_CAPACITY.ordinal()] = 2;
            iArr[VoiceChannelJoinabilityUtils2.PERMISSIONS_MISSING.ordinal()] = 3;
            iArr[VoiceChannelJoinabilityUtils2.CHANNEL_FULL.ordinal()] = 4;
            iArr[VoiceChannelJoinabilityUtils2.CHANNEL_DOES_NOT_EXIST.ordinal()] = 5;
        }
    }

    /* compiled from: WidgetGuildCallOnboardingSheetViewModel.kt */
    /* renamed from: com.discord.widgets.voice.fullscreen.WidgetGuildCallOnboardingSheetViewModel$observeStoreState$1 */
    public static final class C105521<T1, T2, R> implements Func2<Channel, VoiceChannelJoinabilityUtils2, StoreState> {
        public static final C105521 INSTANCE = new C105521();

        @Override // p658rx.functions.Func2
        public /* bridge */ /* synthetic */ StoreState call(Channel channel, VoiceChannelJoinabilityUtils2 voiceChannelJoinabilityUtils2) {
            return call2(channel, voiceChannelJoinabilityUtils2);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final StoreState call2(Channel channel, VoiceChannelJoinabilityUtils2 voiceChannelJoinabilityUtils2) {
            Long lValueOf = channel != null ? Long.valueOf(channel.getGuildId()) : null;
            Intrinsics3.checkNotNullExpressionValue(voiceChannelJoinabilityUtils2, "joinability");
            return new StoreState(lValueOf, voiceChannelJoinabilityUtils2);
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
        Observable<StoreState> observableM11076j = Observable.m11076j(this.channelsStore.observeChannel(this.channelId), VoiceChannelJoinabilityUtils.observeJoinability$default(VoiceChannelJoinabilityUtils.INSTANCE, this.channelId, this.channelsStore, this.guildsStore, this.permissionsStore, this.voiceStatesStore, null, null, 96, null), C105521.INSTANCE);
        Intrinsics3.checkNotNullExpressionValue(observableM11076j, "Observable.combineLatest…dId, joinability)\n      }");
        return observableM11076j;
    }

    public final Observable<Event> observeEvents() {
        PublishSubject<Event> publishSubject = this.eventSubject;
        Intrinsics3.checkNotNullExpressionValue(publishSubject, "eventSubject");
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
                publishSubject.f27650k.onNext(new Event.LaunchGuildCallScreen(this.channelId, loaded.getGuildId()));
                return;
            }
            if (iOrdinal != 2) {
                return;
            }
            PublishSubject<Event> publishSubject2 = this.eventSubject;
            publishSubject2.f27650k.onNext(Event.ShowGuildVideoCapacityDialog.INSTANCE);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetGuildCallOnboardingSheetViewModel(long j, StoreVoiceChannelSelected storeVoiceChannelSelected, StorePermissions storePermissions, StoreChannels storeChannels, StoreGuilds storeGuilds, StoreVoiceStates storeVoiceStates) {
        super(ViewState.Uninitialized.INSTANCE);
        Intrinsics3.checkNotNullParameter(storeVoiceChannelSelected, "selectedVoiceChannelStore");
        Intrinsics3.checkNotNullParameter(storePermissions, "permissionsStore");
        Intrinsics3.checkNotNullParameter(storeChannels, "channelsStore");
        Intrinsics3.checkNotNullParameter(storeGuilds, "guildsStore");
        Intrinsics3.checkNotNullParameter(storeVoiceStates, "voiceStatesStore");
        this.channelId = j;
        this.selectedVoiceChannelStore = storeVoiceChannelSelected;
        this.permissionsStore = storePermissions;
        this.channelsStore = storeChannels;
        this.guildsStore = storeGuilds;
        this.voiceStatesStore = storeVoiceStates;
        this.eventSubject = PublishSubject.m11133k0();
        Observable<StoreState> observableM11112r = observeStoreState().m11112r();
        Intrinsics3.checkNotNullExpressionValue(observableM11112r, "observeStoreState()\n    …  .distinctUntilChanged()");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationLatest(observableM11112r), this, null, 2, null), WidgetGuildCallOnboardingSheetViewModel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new C105511(this), 62, (Object) null);
    }
}

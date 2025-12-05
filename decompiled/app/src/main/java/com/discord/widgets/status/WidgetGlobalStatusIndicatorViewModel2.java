package com.discord.widgets.status;

import androidx.core.app.NotificationCompat;
import com.discord.api.channel.Channel;
import com.discord.api.stageinstance.StageInstance;
import com.discord.api.voice.state.StageRequestToSpeakState;
import com.discord.models.guild.Guild;
import com.discord.rtcconnection.RtcConnection;
import com.discord.stores.StoreChannelsSelected;
import com.discord.stores.StoreConnectivity;
import com.discord.stores.StoreGuilds;
import com.discord.stores.StoreRtcConnection;
import com.discord.stores.StoreStageChannels;
import com.discord.stores.StoreStageInstances;
import com.discord.stores.StoreUserRelationships;
import com.discord.stores.StoreVoiceParticipants;
import com.discord.stores.updates.ObservationDeck;
import com.discord.utilities.p501rx.ObservableCombineLatestOverloads2;
import com.discord.utilities.streams.StreamContext;
import com.discord.utilities.streams.StreamContextService;
import com.discord.widgets.stage.StageRoles;
import com.discord.widgets.status.WidgetGlobalStatusIndicatorViewModel;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function10;
import p507d0.p592z.p594d.FunctionReferenceImpl;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;
import p637j0.p641k.Func1;
import p637j0.p642l.p647e.ScalarSynchronousObservable;
import p658rx.Observable;

/* compiled from: WidgetGlobalStatusIndicatorViewModel.kt */
/* renamed from: com.discord.widgets.status.WidgetGlobalStatusIndicatorViewModel$Companion$observeStoreState$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetGlobalStatusIndicatorViewModel2<T, R> implements Func1<Channel, Observable<? extends WidgetGlobalStatusIndicatorViewModel.StoreState>> {
    public final /* synthetic */ ObservationDeck $observationDeck;
    public final /* synthetic */ StoreChannelsSelected $storeChannelsSelected;
    public final /* synthetic */ StoreConnectivity $storeConnectivity;
    public final /* synthetic */ StoreGuilds $storeGuilds;
    public final /* synthetic */ StoreRtcConnection $storeRtcConnection;
    public final /* synthetic */ StoreStageChannels $storeStageChannels;
    public final /* synthetic */ StoreStageInstances $storeStageInstances;
    public final /* synthetic */ StoreUserRelationships $storeUserRelationships;
    public final /* synthetic */ StoreVoiceParticipants $storeVoiceParticipants;
    public final /* synthetic */ StreamContextService $streamContextService;

    /* compiled from: WidgetGlobalStatusIndicatorViewModel.kt */
    /* renamed from: com.discord.widgets.status.WidgetGlobalStatusIndicatorViewModel$Companion$observeStoreState$1$1, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<StoreConnectivity.DelayedState, WidgetGlobalStatusIndicatorViewModel.StoreState.ConnectivityState> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(1, WidgetGlobalStatusIndicatorViewModel.StoreState.ConnectivityState.class, "<init>", "<init>(Lcom/discord/stores/StoreConnectivity$DelayedState;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ WidgetGlobalStatusIndicatorViewModel.StoreState.ConnectivityState invoke(StoreConnectivity.DelayedState delayedState) {
            return invoke2(delayedState);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final WidgetGlobalStatusIndicatorViewModel.StoreState.ConnectivityState invoke2(StoreConnectivity.DelayedState delayedState) {
            Intrinsics3.checkNotNullParameter(delayedState, "p1");
            return new WidgetGlobalStatusIndicatorViewModel.StoreState.ConnectivityState(delayedState);
        }
    }

    /* compiled from: WidgetGlobalStatusIndicatorViewModel.kt */
    /* renamed from: com.discord.widgets.status.WidgetGlobalStatusIndicatorViewModel$Companion$observeStoreState$1$2, reason: invalid class name */
    public static final class AnonymousClass2 extends Lambda implements Function0<Integer> {
        public final /* synthetic */ Channel $channel;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(Channel channel) {
            super(0);
            this.$channel = channel;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Integer invoke() {
            return Integer.valueOf(invoke2());
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final int invoke2() {
            Map<Long, StageRoles> channelRoles = WidgetGlobalStatusIndicatorViewModel2.this.$storeStageChannels.getChannelRoles(this.$channel.getId());
            Map<Long, Integer> relationships = WidgetGlobalStatusIndicatorViewModel2.this.$storeUserRelationships.getRelationships();
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (Map.Entry<Long, Integer> entry : relationships.entrySet()) {
                if (entry.getValue().intValue() == 2 && channelRoles != null && channelRoles.containsKey(Long.valueOf(entry.getKey().longValue()))) {
                    linkedHashMap.put(entry.getKey(), entry.getValue());
                }
            }
            return linkedHashMap.size();
        }
    }

    /* compiled from: WidgetGlobalStatusIndicatorViewModel.kt */
    /* renamed from: com.discord.widgets.status.WidgetGlobalStatusIndicatorViewModel$Companion$observeStoreState$1$3, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass3 extends FunctionReferenceImpl implements Function10<Channel, Channel, RtcConnection.StateChange, RtcConnection.Quality, Guild, Map<Long, ? extends StoreVoiceParticipants.VoiceUser>, StreamContext, StageRequestToSpeakState, Integer, StageInstance, WidgetGlobalStatusIndicatorViewModel.StoreState.CallOngoing> {
        public static final AnonymousClass3 INSTANCE = new AnonymousClass3();

        public AnonymousClass3() {
            super(10, WidgetGlobalStatusIndicatorViewModel.StoreState.CallOngoing.class, "<init>", "<init>(Lcom/discord/api/channel/Channel;Lcom/discord/api/channel/Channel;Lcom/discord/rtcconnection/RtcConnection$StateChange;Lcom/discord/rtcconnection/RtcConnection$Quality;Lcom/discord/models/guild/Guild;Ljava/util/Map;Lcom/discord/utilities/streams/StreamContext;Lcom/discord/api/voice/state/StageRequestToSpeakState;ILcom/discord/api/stageinstance/StageInstance;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function10
        public /* bridge */ /* synthetic */ WidgetGlobalStatusIndicatorViewModel.StoreState.CallOngoing invoke(Channel channel, Channel channel2, RtcConnection.StateChange stateChange, RtcConnection.Quality quality, Guild guild, Map<Long, ? extends StoreVoiceParticipants.VoiceUser> map, StreamContext streamContext, StageRequestToSpeakState stageRequestToSpeakState, Integer num, StageInstance stageInstance) {
            return invoke(channel, channel2, stateChange, quality, guild, (Map<Long, StoreVoiceParticipants.VoiceUser>) map, streamContext, stageRequestToSpeakState, num.intValue(), stageInstance);
        }

        public final WidgetGlobalStatusIndicatorViewModel.StoreState.CallOngoing invoke(Channel channel, Channel channel2, RtcConnection.StateChange stateChange, RtcConnection.Quality quality, Guild guild, Map<Long, StoreVoiceParticipants.VoiceUser> map, StreamContext streamContext, StageRequestToSpeakState stageRequestToSpeakState, int i, StageInstance stageInstance) {
            Intrinsics3.checkNotNullParameter(channel, "p1");
            Intrinsics3.checkNotNullParameter(stateChange, "p3");
            Intrinsics3.checkNotNullParameter(quality, "p4");
            Intrinsics3.checkNotNullParameter(map, "p6");
            Intrinsics3.checkNotNullParameter(stageRequestToSpeakState, "p8");
            return new WidgetGlobalStatusIndicatorViewModel.StoreState.CallOngoing(channel, channel2, stateChange, quality, guild, map, streamContext, stageRequestToSpeakState, i, stageInstance);
        }
    }

    public WidgetGlobalStatusIndicatorViewModel2(StoreConnectivity storeConnectivity, StoreChannelsSelected storeChannelsSelected, StoreRtcConnection storeRtcConnection, StoreGuilds storeGuilds, StoreVoiceParticipants storeVoiceParticipants, StreamContextService streamContextService, StoreStageChannels storeStageChannels, ObservationDeck observationDeck, StoreUserRelationships storeUserRelationships, StoreStageInstances storeStageInstances) {
        this.$storeConnectivity = storeConnectivity;
        this.$storeChannelsSelected = storeChannelsSelected;
        this.$storeRtcConnection = storeRtcConnection;
        this.$storeGuilds = storeGuilds;
        this.$storeVoiceParticipants = storeVoiceParticipants;
        this.$streamContextService = streamContextService;
        this.$storeStageChannels = storeStageChannels;
        this.$observationDeck = observationDeck;
        this.$storeUserRelationships = storeUserRelationships;
        this.$storeStageInstances = storeStageInstances;
    }

    @Override // p637j0.p641k.Func1
    public /* bridge */ /* synthetic */ Observable<? extends WidgetGlobalStatusIndicatorViewModel.StoreState> call(Channel channel) {
        return call2(channel);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v1, types: [com.discord.widgets.status.WidgetGlobalStatusIndicatorViewModel$Companion$observeStoreState$1$1, kotlin.jvm.functions.Function1] */
    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends WidgetGlobalStatusIndicatorViewModel.StoreState> call2(Channel channel) {
        if (channel != null) {
            ScalarSynchronousObservable scalarSynchronousObservable = new ScalarSynchronousObservable(channel);
            Intrinsics3.checkNotNullExpressionValue(scalarSynchronousObservable, "Observable\n                        .just(channel)");
            return ObservableCombineLatestOverloads2.combineLatest(scalarSynchronousObservable, this.$storeChannelsSelected.observeSelectedChannel(), this.$storeRtcConnection.getConnectionState(), this.$storeRtcConnection.getQuality(), this.$storeGuilds.observeGuild(channel.getGuildId()), this.$storeVoiceParticipants.get(channel.getId()), this.$streamContextService.getForActiveStream(), this.$storeStageChannels.observeMyRequestToSpeakState(channel.getId()), ObservationDeck.connectRx$default(this.$observationDeck, new ObservationDeck.UpdateSource[]{this.$storeUserRelationships, this.$storeStageChannels}, false, null, null, new AnonymousClass2(channel), 14, null), this.$storeStageInstances.observeStageInstanceForChannel(channel.getId()), AnonymousClass3.INSTANCE);
        }
        Observable<StoreConnectivity.DelayedState> observableObserveState = this.$storeConnectivity.observeState();
        ?? r2 = AnonymousClass1.INSTANCE;
        WidgetGlobalStatusIndicatorViewModel3 widgetGlobalStatusIndicatorViewModel3 = r2;
        if (r2 != 0) {
            widgetGlobalStatusIndicatorViewModel3 = new WidgetGlobalStatusIndicatorViewModel3(r2);
        }
        return observableObserveState.m11083G(widgetGlobalStatusIndicatorViewModel3);
    }
}

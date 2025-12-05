package com.discord.widgets.status;

import android.content.Context;
import androidx.annotation.MainThread;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.api.stageinstance.StageInstance;
import com.discord.api.voice.state.StageRequestToSpeakState;
import com.discord.api.voice.state.VoiceState;
import com.discord.models.guild.Guild;
import com.discord.rtcconnection.RtcConnection;
import com.discord.stores.StoreChannelsSelected;
import com.discord.stores.StoreConnectivity;
import com.discord.stores.StoreGuilds;
import com.discord.stores.StoreRtcConnection;
import com.discord.stores.StoreStageChannels;
import com.discord.stores.StoreStageInstances;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUserRelationships;
import com.discord.stores.StoreVoiceChannelSelected;
import com.discord.stores.StoreVoiceParticipants;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeck4;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.media.AppSound;
import com.discord.utilities.media.AppSoundManager;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.streams.StreamContext;
import com.discord.utilities.streams.StreamContextService;
import com.discord.widgets.stage.StageChannelAPI;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p001a0.p002a.p003a.C0002b;
import p007b.p008a.p018d.AppViewModel;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.FunctionReferenceImpl;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;
import p658rx.Observable;

/* compiled from: WidgetGlobalStatusIndicatorViewModel.kt */
/* loaded from: classes2.dex */
public final class WidgetGlobalStatusIndicatorViewModel extends AppViewModel<ViewState> {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* compiled from: WidgetGlobalStatusIndicatorViewModel.kt */
    /* renamed from: com.discord.widgets.status.WidgetGlobalStatusIndicatorViewModel$1 */
    public static final /* synthetic */ class C101081 extends FunctionReferenceImpl implements Function1<StoreState, Unit> {
        public C101081(WidgetGlobalStatusIndicatorViewModel widgetGlobalStatusIndicatorViewModel) {
            super(1, widgetGlobalStatusIndicatorViewModel, WidgetGlobalStatusIndicatorViewModel.class, "handleStoreState", "handleStoreState(Lcom/discord/widgets/status/WidgetGlobalStatusIndicatorViewModel$StoreState;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(StoreState storeState) {
            invoke2(storeState);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(StoreState storeState) {
            Intrinsics3.checkNotNullParameter(storeState, "p1");
            WidgetGlobalStatusIndicatorViewModel.access$handleStoreState((WidgetGlobalStatusIndicatorViewModel) this.receiver, storeState);
        }
    }

    /* compiled from: WidgetGlobalStatusIndicatorViewModel.kt */
    public static final class Companion {
        private Companion() {
        }

        private final Observable<StoreState> observeStoreState(StreamContextService streamContextService, StoreVoiceChannelSelected storeVoiceChannelSelected, StoreConnectivity storeConnectivity, StoreChannelsSelected storeChannelsSelected, StoreRtcConnection storeRtcConnection, StoreGuilds storeGuilds, StoreVoiceParticipants storeVoiceParticipants, StoreStageChannels storeStageChannels, StoreUserRelationships storeUserRelationships, StoreStageInstances storeStageInstances, ObservationDeck observationDeck) {
            return storeVoiceChannelSelected.observeSelectedChannel().m11099Y(new WidgetGlobalStatusIndicatorViewModel2(storeConnectivity, storeChannelsSelected, storeRtcConnection, storeGuilds, storeVoiceParticipants, streamContextService, storeStageChannels, observationDeck, storeUserRelationships, storeStageInstances));
        }

        public static /* synthetic */ Observable observeStoreState$default(Companion companion, StreamContextService streamContextService, StoreVoiceChannelSelected storeVoiceChannelSelected, StoreConnectivity storeConnectivity, StoreChannelsSelected storeChannelsSelected, StoreRtcConnection storeRtcConnection, StoreGuilds storeGuilds, StoreVoiceParticipants storeVoiceParticipants, StoreStageChannels storeStageChannels, StoreUserRelationships storeUserRelationships, StoreStageInstances storeStageInstances, ObservationDeck observationDeck, int i, Object obj) {
            return companion.observeStoreState(streamContextService, storeVoiceChannelSelected, storeConnectivity, storeChannelsSelected, storeRtcConnection, storeGuilds, storeVoiceParticipants, storeStageChannels, storeUserRelationships, storeStageInstances, (i & 1024) != 0 ? ObservationDeck4.get() : observationDeck);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetGlobalStatusIndicatorViewModel.kt */
    public static abstract class StoreState {

        /* compiled from: WidgetGlobalStatusIndicatorViewModel.kt */
        public static final /* data */ class CallOngoing extends StoreState {
            private final int blockedUsersOnStage;
            private final RtcConnection.Quality connectionQuality;
            private final RtcConnection.StateChange connectionStateChange;
            private final Guild guild;
            private final Map<Long, StoreVoiceParticipants.VoiceUser> participants;
            private final StageRequestToSpeakState requestToSpeakState;
            private final Channel selectedTextChannel;
            private final Channel selectedVoiceChannel;
            private final StageInstance stageInstance;
            private final StreamContext streamContext;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public CallOngoing(Channel channel, Channel channel2, RtcConnection.StateChange stateChange, RtcConnection.Quality quality, Guild guild, Map<Long, StoreVoiceParticipants.VoiceUser> map, StreamContext streamContext, StageRequestToSpeakState stageRequestToSpeakState, int i, StageInstance stageInstance) {
                super(null);
                Intrinsics3.checkNotNullParameter(channel, "selectedVoiceChannel");
                Intrinsics3.checkNotNullParameter(stateChange, "connectionStateChange");
                Intrinsics3.checkNotNullParameter(quality, "connectionQuality");
                Intrinsics3.checkNotNullParameter(map, "participants");
                Intrinsics3.checkNotNullParameter(stageRequestToSpeakState, "requestToSpeakState");
                this.selectedVoiceChannel = channel;
                this.selectedTextChannel = channel2;
                this.connectionStateChange = stateChange;
                this.connectionQuality = quality;
                this.guild = guild;
                this.participants = map;
                this.streamContext = streamContext;
                this.requestToSpeakState = stageRequestToSpeakState;
                this.blockedUsersOnStage = i;
                this.stageInstance = stageInstance;
            }

            public static /* synthetic */ CallOngoing copy$default(CallOngoing callOngoing, Channel channel, Channel channel2, RtcConnection.StateChange stateChange, RtcConnection.Quality quality, Guild guild, Map map, StreamContext streamContext, StageRequestToSpeakState stageRequestToSpeakState, int i, StageInstance stageInstance, int i2, Object obj) {
                return callOngoing.copy((i2 & 1) != 0 ? callOngoing.selectedVoiceChannel : channel, (i2 & 2) != 0 ? callOngoing.selectedTextChannel : channel2, (i2 & 4) != 0 ? callOngoing.connectionStateChange : stateChange, (i2 & 8) != 0 ? callOngoing.connectionQuality : quality, (i2 & 16) != 0 ? callOngoing.guild : guild, (i2 & 32) != 0 ? callOngoing.participants : map, (i2 & 64) != 0 ? callOngoing.streamContext : streamContext, (i2 & 128) != 0 ? callOngoing.requestToSpeakState : stageRequestToSpeakState, (i2 & 256) != 0 ? callOngoing.blockedUsersOnStage : i, (i2 & 512) != 0 ? callOngoing.stageInstance : stageInstance);
            }

            /* renamed from: component1, reason: from getter */
            public final Channel getSelectedVoiceChannel() {
                return this.selectedVoiceChannel;
            }

            /* renamed from: component10, reason: from getter */
            public final StageInstance getStageInstance() {
                return this.stageInstance;
            }

            /* renamed from: component2, reason: from getter */
            public final Channel getSelectedTextChannel() {
                return this.selectedTextChannel;
            }

            /* renamed from: component3, reason: from getter */
            public final RtcConnection.StateChange getConnectionStateChange() {
                return this.connectionStateChange;
            }

            /* renamed from: component4, reason: from getter */
            public final RtcConnection.Quality getConnectionQuality() {
                return this.connectionQuality;
            }

            /* renamed from: component5, reason: from getter */
            public final Guild getGuild() {
                return this.guild;
            }

            public final Map<Long, StoreVoiceParticipants.VoiceUser> component6() {
                return this.participants;
            }

            /* renamed from: component7, reason: from getter */
            public final StreamContext getStreamContext() {
                return this.streamContext;
            }

            /* renamed from: component8, reason: from getter */
            public final StageRequestToSpeakState getRequestToSpeakState() {
                return this.requestToSpeakState;
            }

            /* renamed from: component9, reason: from getter */
            public final int getBlockedUsersOnStage() {
                return this.blockedUsersOnStage;
            }

            public final CallOngoing copy(Channel selectedVoiceChannel, Channel selectedTextChannel, RtcConnection.StateChange connectionStateChange, RtcConnection.Quality connectionQuality, Guild guild, Map<Long, StoreVoiceParticipants.VoiceUser> participants, StreamContext streamContext, StageRequestToSpeakState requestToSpeakState, int blockedUsersOnStage, StageInstance stageInstance) {
                Intrinsics3.checkNotNullParameter(selectedVoiceChannel, "selectedVoiceChannel");
                Intrinsics3.checkNotNullParameter(connectionStateChange, "connectionStateChange");
                Intrinsics3.checkNotNullParameter(connectionQuality, "connectionQuality");
                Intrinsics3.checkNotNullParameter(participants, "participants");
                Intrinsics3.checkNotNullParameter(requestToSpeakState, "requestToSpeakState");
                return new CallOngoing(selectedVoiceChannel, selectedTextChannel, connectionStateChange, connectionQuality, guild, participants, streamContext, requestToSpeakState, blockedUsersOnStage, stageInstance);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof CallOngoing)) {
                    return false;
                }
                CallOngoing callOngoing = (CallOngoing) other;
                return Intrinsics3.areEqual(this.selectedVoiceChannel, callOngoing.selectedVoiceChannel) && Intrinsics3.areEqual(this.selectedTextChannel, callOngoing.selectedTextChannel) && Intrinsics3.areEqual(this.connectionStateChange, callOngoing.connectionStateChange) && Intrinsics3.areEqual(this.connectionQuality, callOngoing.connectionQuality) && Intrinsics3.areEqual(this.guild, callOngoing.guild) && Intrinsics3.areEqual(this.participants, callOngoing.participants) && Intrinsics3.areEqual(this.streamContext, callOngoing.streamContext) && Intrinsics3.areEqual(this.requestToSpeakState, callOngoing.requestToSpeakState) && this.blockedUsersOnStage == callOngoing.blockedUsersOnStage && Intrinsics3.areEqual(this.stageInstance, callOngoing.stageInstance);
            }

            public final int getBlockedUsersOnStage() {
                return this.blockedUsersOnStage;
            }

            public final RtcConnection.Quality getConnectionQuality() {
                return this.connectionQuality;
            }

            public final RtcConnection.StateChange getConnectionStateChange() {
                return this.connectionStateChange;
            }

            public final Guild getGuild() {
                return this.guild;
            }

            public final Map<Long, StoreVoiceParticipants.VoiceUser> getParticipants() {
                return this.participants;
            }

            public final StageRequestToSpeakState getRequestToSpeakState() {
                return this.requestToSpeakState;
            }

            public final Channel getSelectedTextChannel() {
                return this.selectedTextChannel;
            }

            public final Channel getSelectedVoiceChannel() {
                return this.selectedVoiceChannel;
            }

            public final StageInstance getStageInstance() {
                return this.stageInstance;
            }

            public final StreamContext getStreamContext() {
                return this.streamContext;
            }

            public int hashCode() {
                Channel channel = this.selectedVoiceChannel;
                int iHashCode = (channel != null ? channel.hashCode() : 0) * 31;
                Channel channel2 = this.selectedTextChannel;
                int iHashCode2 = (iHashCode + (channel2 != null ? channel2.hashCode() : 0)) * 31;
                RtcConnection.StateChange stateChange = this.connectionStateChange;
                int iHashCode3 = (iHashCode2 + (stateChange != null ? stateChange.hashCode() : 0)) * 31;
                RtcConnection.Quality quality = this.connectionQuality;
                int iHashCode4 = (iHashCode3 + (quality != null ? quality.hashCode() : 0)) * 31;
                Guild guild = this.guild;
                int iHashCode5 = (iHashCode4 + (guild != null ? guild.hashCode() : 0)) * 31;
                Map<Long, StoreVoiceParticipants.VoiceUser> map = this.participants;
                int iHashCode6 = (iHashCode5 + (map != null ? map.hashCode() : 0)) * 31;
                StreamContext streamContext = this.streamContext;
                int iHashCode7 = (iHashCode6 + (streamContext != null ? streamContext.hashCode() : 0)) * 31;
                StageRequestToSpeakState stageRequestToSpeakState = this.requestToSpeakState;
                int iHashCode8 = (((iHashCode7 + (stageRequestToSpeakState != null ? stageRequestToSpeakState.hashCode() : 0)) * 31) + this.blockedUsersOnStage) * 31;
                StageInstance stageInstance = this.stageInstance;
                return iHashCode8 + (stageInstance != null ? stageInstance.hashCode() : 0);
            }

            public String toString() {
                StringBuilder sbM833U = outline.m833U("CallOngoing(selectedVoiceChannel=");
                sbM833U.append(this.selectedVoiceChannel);
                sbM833U.append(", selectedTextChannel=");
                sbM833U.append(this.selectedTextChannel);
                sbM833U.append(", connectionStateChange=");
                sbM833U.append(this.connectionStateChange);
                sbM833U.append(", connectionQuality=");
                sbM833U.append(this.connectionQuality);
                sbM833U.append(", guild=");
                sbM833U.append(this.guild);
                sbM833U.append(", participants=");
                sbM833U.append(this.participants);
                sbM833U.append(", streamContext=");
                sbM833U.append(this.streamContext);
                sbM833U.append(", requestToSpeakState=");
                sbM833U.append(this.requestToSpeakState);
                sbM833U.append(", blockedUsersOnStage=");
                sbM833U.append(this.blockedUsersOnStage);
                sbM833U.append(", stageInstance=");
                sbM833U.append(this.stageInstance);
                sbM833U.append(")");
                return sbM833U.toString();
            }
        }

        /* compiled from: WidgetGlobalStatusIndicatorViewModel.kt */
        public static final /* data */ class ConnectivityState extends StoreState {
            private final StoreConnectivity.DelayedState connectivityState;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public ConnectivityState(StoreConnectivity.DelayedState delayedState) {
                super(null);
                Intrinsics3.checkNotNullParameter(delayedState, "connectivityState");
                this.connectivityState = delayedState;
            }

            public static /* synthetic */ ConnectivityState copy$default(ConnectivityState connectivityState, StoreConnectivity.DelayedState delayedState, int i, Object obj) {
                if ((i & 1) != 0) {
                    delayedState = connectivityState.connectivityState;
                }
                return connectivityState.copy(delayedState);
            }

            /* renamed from: component1, reason: from getter */
            public final StoreConnectivity.DelayedState getConnectivityState() {
                return this.connectivityState;
            }

            public final ConnectivityState copy(StoreConnectivity.DelayedState connectivityState) {
                Intrinsics3.checkNotNullParameter(connectivityState, "connectivityState");
                return new ConnectivityState(connectivityState);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof ConnectivityState) && Intrinsics3.areEqual(this.connectivityState, ((ConnectivityState) other).connectivityState);
                }
                return true;
            }

            public final StoreConnectivity.DelayedState getConnectivityState() {
                return this.connectivityState;
            }

            public int hashCode() {
                StoreConnectivity.DelayedState delayedState = this.connectivityState;
                if (delayedState != null) {
                    return delayedState.hashCode();
                }
                return 0;
            }

            public String toString() {
                StringBuilder sbM833U = outline.m833U("ConnectivityState(connectivityState=");
                sbM833U.append(this.connectivityState);
                sbM833U.append(")");
                return sbM833U.toString();
            }
        }

        private StoreState() {
        }

        public /* synthetic */ StoreState(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetGlobalStatusIndicatorViewModel.kt */
    public static abstract class ViewState {
        private final boolean isSpeakingInOngoingCall;

        /* compiled from: WidgetGlobalStatusIndicatorViewModel.kt */
        public static final /* data */ class CallOngoing extends ViewState {
            private final RtcConnection.Quality connectionQuality;
            private final RtcConnection.State connectionState;
            private final Guild guild;
            private final boolean hasVideo;
            private final boolean isSpeakingInOngoingCall;
            private final int participants;
            private final Channel selectedTextChannel;
            private final Channel selectedVoiceChannel;
            private final StreamContext streamContext;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public CallOngoing(Channel channel, Channel channel2, RtcConnection.State state, RtcConnection.Quality quality, Guild guild, int i, boolean z2, StreamContext streamContext) {
                super(null);
                Intrinsics3.checkNotNullParameter(channel, "selectedVoiceChannel");
                Intrinsics3.checkNotNullParameter(state, "connectionState");
                Intrinsics3.checkNotNullParameter(quality, "connectionQuality");
                this.selectedVoiceChannel = channel;
                this.selectedTextChannel = channel2;
                this.connectionState = state;
                this.connectionQuality = quality;
                this.guild = guild;
                this.participants = i;
                this.hasVideo = z2;
                this.streamContext = streamContext;
                this.isSpeakingInOngoingCall = true;
            }

            public static /* synthetic */ CallOngoing copy$default(CallOngoing callOngoing, Channel channel, Channel channel2, RtcConnection.State state, RtcConnection.Quality quality, Guild guild, int i, boolean z2, StreamContext streamContext, int i2, Object obj) {
                return callOngoing.copy((i2 & 1) != 0 ? callOngoing.selectedVoiceChannel : channel, (i2 & 2) != 0 ? callOngoing.selectedTextChannel : channel2, (i2 & 4) != 0 ? callOngoing.connectionState : state, (i2 & 8) != 0 ? callOngoing.connectionQuality : quality, (i2 & 16) != 0 ? callOngoing.guild : guild, (i2 & 32) != 0 ? callOngoing.participants : i, (i2 & 64) != 0 ? callOngoing.hasVideo : z2, (i2 & 128) != 0 ? callOngoing.streamContext : streamContext);
            }

            /* renamed from: component1, reason: from getter */
            public final Channel getSelectedVoiceChannel() {
                return this.selectedVoiceChannel;
            }

            /* renamed from: component2, reason: from getter */
            public final Channel getSelectedTextChannel() {
                return this.selectedTextChannel;
            }

            /* renamed from: component3, reason: from getter */
            public final RtcConnection.State getConnectionState() {
                return this.connectionState;
            }

            /* renamed from: component4, reason: from getter */
            public final RtcConnection.Quality getConnectionQuality() {
                return this.connectionQuality;
            }

            /* renamed from: component5, reason: from getter */
            public final Guild getGuild() {
                return this.guild;
            }

            /* renamed from: component6, reason: from getter */
            public final int getParticipants() {
                return this.participants;
            }

            /* renamed from: component7, reason: from getter */
            public final boolean getHasVideo() {
                return this.hasVideo;
            }

            /* renamed from: component8, reason: from getter */
            public final StreamContext getStreamContext() {
                return this.streamContext;
            }

            public final CallOngoing copy(Channel selectedVoiceChannel, Channel selectedTextChannel, RtcConnection.State connectionState, RtcConnection.Quality connectionQuality, Guild guild, int participants, boolean hasVideo, StreamContext streamContext) {
                Intrinsics3.checkNotNullParameter(selectedVoiceChannel, "selectedVoiceChannel");
                Intrinsics3.checkNotNullParameter(connectionState, "connectionState");
                Intrinsics3.checkNotNullParameter(connectionQuality, "connectionQuality");
                return new CallOngoing(selectedVoiceChannel, selectedTextChannel, connectionState, connectionQuality, guild, participants, hasVideo, streamContext);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof CallOngoing)) {
                    return false;
                }
                CallOngoing callOngoing = (CallOngoing) other;
                return Intrinsics3.areEqual(this.selectedVoiceChannel, callOngoing.selectedVoiceChannel) && Intrinsics3.areEqual(this.selectedTextChannel, callOngoing.selectedTextChannel) && Intrinsics3.areEqual(this.connectionState, callOngoing.connectionState) && Intrinsics3.areEqual(this.connectionQuality, callOngoing.connectionQuality) && Intrinsics3.areEqual(this.guild, callOngoing.guild) && this.participants == callOngoing.participants && this.hasVideo == callOngoing.hasVideo && Intrinsics3.areEqual(this.streamContext, callOngoing.streamContext);
            }

            public final RtcConnection.Quality getConnectionQuality() {
                return this.connectionQuality;
            }

            public final RtcConnection.State getConnectionState() {
                return this.connectionState;
            }

            public final Guild getGuild() {
                return this.guild;
            }

            public final boolean getHasVideo() {
                return this.hasVideo;
            }

            public final int getParticipants() {
                return this.participants;
            }

            public final Channel getSelectedTextChannel() {
                return this.selectedTextChannel;
            }

            public final Channel getSelectedVoiceChannel() {
                return this.selectedVoiceChannel;
            }

            public final StreamContext getStreamContext() {
                return this.streamContext;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public int hashCode() {
                Channel channel = this.selectedVoiceChannel;
                int iHashCode = (channel != null ? channel.hashCode() : 0) * 31;
                Channel channel2 = this.selectedTextChannel;
                int iHashCode2 = (iHashCode + (channel2 != null ? channel2.hashCode() : 0)) * 31;
                RtcConnection.State state = this.connectionState;
                int iHashCode3 = (iHashCode2 + (state != null ? state.hashCode() : 0)) * 31;
                RtcConnection.Quality quality = this.connectionQuality;
                int iHashCode4 = (iHashCode3 + (quality != null ? quality.hashCode() : 0)) * 31;
                Guild guild = this.guild;
                int iHashCode5 = (((iHashCode4 + (guild != null ? guild.hashCode() : 0)) * 31) + this.participants) * 31;
                boolean z2 = this.hasVideo;
                int i = z2;
                if (z2 != 0) {
                    i = 1;
                }
                int i2 = (iHashCode5 + i) * 31;
                StreamContext streamContext = this.streamContext;
                return i2 + (streamContext != null ? streamContext.hashCode() : 0);
            }

            @Override // com.discord.widgets.status.WidgetGlobalStatusIndicatorViewModel.ViewState
            /* renamed from: isSpeakingInOngoingCall, reason: from getter */
            public boolean getIsSpeakingInOngoingCall() {
                return this.isSpeakingInOngoingCall;
            }

            public String toString() {
                StringBuilder sbM833U = outline.m833U("CallOngoing(selectedVoiceChannel=");
                sbM833U.append(this.selectedVoiceChannel);
                sbM833U.append(", selectedTextChannel=");
                sbM833U.append(this.selectedTextChannel);
                sbM833U.append(", connectionState=");
                sbM833U.append(this.connectionState);
                sbM833U.append(", connectionQuality=");
                sbM833U.append(this.connectionQuality);
                sbM833U.append(", guild=");
                sbM833U.append(this.guild);
                sbM833U.append(", participants=");
                sbM833U.append(this.participants);
                sbM833U.append(", hasVideo=");
                sbM833U.append(this.hasVideo);
                sbM833U.append(", streamContext=");
                sbM833U.append(this.streamContext);
                sbM833U.append(")");
                return sbM833U.toString();
            }
        }

        /* compiled from: WidgetGlobalStatusIndicatorViewModel.kt */
        public static final /* data */ class Connecting extends ViewState {
            private final long delay;

            public Connecting(long j) {
                super(null);
                this.delay = j;
            }

            public static /* synthetic */ Connecting copy$default(Connecting connecting, long j, int i, Object obj) {
                if ((i & 1) != 0) {
                    j = connecting.delay;
                }
                return connecting.copy(j);
            }

            /* renamed from: component1, reason: from getter */
            public final long getDelay() {
                return this.delay;
            }

            public final Connecting copy(long delay) {
                return new Connecting(delay);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof Connecting) && this.delay == ((Connecting) other).delay;
                }
                return true;
            }

            public final long getDelay() {
                return this.delay;
            }

            public int hashCode() {
                return C0002b.m3a(this.delay);
            }

            public String toString() {
                return outline.m815C(outline.m833U("Connecting(delay="), this.delay, ")");
            }
        }

        /* compiled from: WidgetGlobalStatusIndicatorViewModel.kt */
        public static final class Inactive extends ViewState {
            public static final Inactive INSTANCE = new Inactive();

            private Inactive() {
                super(null);
            }
        }

        /* compiled from: WidgetGlobalStatusIndicatorViewModel.kt */
        public static final /* data */ class Offline extends ViewState {
            private final boolean airplaneMode;
            private final long delay;

            public Offline(long j, boolean z2) {
                super(null);
                this.delay = j;
                this.airplaneMode = z2;
            }

            public static /* synthetic */ Offline copy$default(Offline offline, long j, boolean z2, int i, Object obj) {
                if ((i & 1) != 0) {
                    j = offline.delay;
                }
                if ((i & 2) != 0) {
                    z2 = offline.airplaneMode;
                }
                return offline.copy(j, z2);
            }

            /* renamed from: component1, reason: from getter */
            public final long getDelay() {
                return this.delay;
            }

            /* renamed from: component2, reason: from getter */
            public final boolean getAirplaneMode() {
                return this.airplaneMode;
            }

            public final Offline copy(long delay, boolean airplaneMode) {
                return new Offline(delay, airplaneMode);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Offline)) {
                    return false;
                }
                Offline offline = (Offline) other;
                return this.delay == offline.delay && this.airplaneMode == offline.airplaneMode;
            }

            public final boolean getAirplaneMode() {
                return this.airplaneMode;
            }

            public final long getDelay() {
                return this.delay;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public int hashCode() {
                int iM3a = C0002b.m3a(this.delay) * 31;
                boolean z2 = this.airplaneMode;
                int i = z2;
                if (z2 != 0) {
                    i = 1;
                }
                return iM3a + i;
            }

            public String toString() {
                StringBuilder sbM833U = outline.m833U("Offline(delay=");
                sbM833U.append(this.delay);
                sbM833U.append(", airplaneMode=");
                return outline.m827O(sbM833U, this.airplaneMode, ")");
            }
        }

        /* compiled from: WidgetGlobalStatusIndicatorViewModel.kt */
        public static final /* data */ class StageChannelOngoing extends ViewState {
            private final int blockedUsersOnStage;
            private final RtcConnection.Quality connectionQuality;
            private final RtcConnection.State connectionState;
            private final Guild guild;
            private final boolean isAckingInvitation;
            private final boolean isInvitedToSpeak;
            private final boolean isSpeaking;
            private final boolean isSpeakingInOngoingCall;
            private final Channel selectedVoiceChannel;
            private final StageInstance stageInstance;
            private final StreamContext streamContext;

            public /* synthetic */ StageChannelOngoing(Channel channel, RtcConnection.State state, RtcConnection.Quality quality, Guild guild, StreamContext streamContext, boolean z2, StageInstance stageInstance, boolean z3, boolean z4, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
                this(channel, state, quality, guild, streamContext, z2, stageInstance, (i2 & 128) != 0 ? false : z3, (i2 & 256) != 0 ? false : z4, (i2 & 512) != 0 ? 0 : i);
            }

            public static /* synthetic */ StageChannelOngoing copy$default(StageChannelOngoing stageChannelOngoing, Channel channel, RtcConnection.State state, RtcConnection.Quality quality, Guild guild, StreamContext streamContext, boolean z2, StageInstance stageInstance, boolean z3, boolean z4, int i, int i2, Object obj) {
                return stageChannelOngoing.copy((i2 & 1) != 0 ? stageChannelOngoing.selectedVoiceChannel : channel, (i2 & 2) != 0 ? stageChannelOngoing.connectionState : state, (i2 & 4) != 0 ? stageChannelOngoing.connectionQuality : quality, (i2 & 8) != 0 ? stageChannelOngoing.guild : guild, (i2 & 16) != 0 ? stageChannelOngoing.streamContext : streamContext, (i2 & 32) != 0 ? stageChannelOngoing.isSpeaking : z2, (i2 & 64) != 0 ? stageChannelOngoing.stageInstance : stageInstance, (i2 & 128) != 0 ? stageChannelOngoing.isInvitedToSpeak : z3, (i2 & 256) != 0 ? stageChannelOngoing.isAckingInvitation : z4, (i2 & 512) != 0 ? stageChannelOngoing.blockedUsersOnStage : i);
            }

            /* renamed from: component1, reason: from getter */
            public final Channel getSelectedVoiceChannel() {
                return this.selectedVoiceChannel;
            }

            /* renamed from: component10, reason: from getter */
            public final int getBlockedUsersOnStage() {
                return this.blockedUsersOnStage;
            }

            /* renamed from: component2, reason: from getter */
            public final RtcConnection.State getConnectionState() {
                return this.connectionState;
            }

            /* renamed from: component3, reason: from getter */
            public final RtcConnection.Quality getConnectionQuality() {
                return this.connectionQuality;
            }

            /* renamed from: component4, reason: from getter */
            public final Guild getGuild() {
                return this.guild;
            }

            /* renamed from: component5, reason: from getter */
            public final StreamContext getStreamContext() {
                return this.streamContext;
            }

            /* renamed from: component6, reason: from getter */
            public final boolean getIsSpeaking() {
                return this.isSpeaking;
            }

            /* renamed from: component7, reason: from getter */
            public final StageInstance getStageInstance() {
                return this.stageInstance;
            }

            /* renamed from: component8, reason: from getter */
            public final boolean getIsInvitedToSpeak() {
                return this.isInvitedToSpeak;
            }

            /* renamed from: component9, reason: from getter */
            public final boolean getIsAckingInvitation() {
                return this.isAckingInvitation;
            }

            public final StageChannelOngoing copy(Channel selectedVoiceChannel, RtcConnection.State connectionState, RtcConnection.Quality connectionQuality, Guild guild, StreamContext streamContext, boolean isSpeaking, StageInstance stageInstance, boolean isInvitedToSpeak, boolean isAckingInvitation, int blockedUsersOnStage) {
                Intrinsics3.checkNotNullParameter(selectedVoiceChannel, "selectedVoiceChannel");
                Intrinsics3.checkNotNullParameter(connectionState, "connectionState");
                Intrinsics3.checkNotNullParameter(connectionQuality, "connectionQuality");
                return new StageChannelOngoing(selectedVoiceChannel, connectionState, connectionQuality, guild, streamContext, isSpeaking, stageInstance, isInvitedToSpeak, isAckingInvitation, blockedUsersOnStage);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof StageChannelOngoing)) {
                    return false;
                }
                StageChannelOngoing stageChannelOngoing = (StageChannelOngoing) other;
                return Intrinsics3.areEqual(this.selectedVoiceChannel, stageChannelOngoing.selectedVoiceChannel) && Intrinsics3.areEqual(this.connectionState, stageChannelOngoing.connectionState) && Intrinsics3.areEqual(this.connectionQuality, stageChannelOngoing.connectionQuality) && Intrinsics3.areEqual(this.guild, stageChannelOngoing.guild) && Intrinsics3.areEqual(this.streamContext, stageChannelOngoing.streamContext) && this.isSpeaking == stageChannelOngoing.isSpeaking && Intrinsics3.areEqual(this.stageInstance, stageChannelOngoing.stageInstance) && this.isInvitedToSpeak == stageChannelOngoing.isInvitedToSpeak && this.isAckingInvitation == stageChannelOngoing.isAckingInvitation && this.blockedUsersOnStage == stageChannelOngoing.blockedUsersOnStage;
            }

            public final int getBlockedUsersOnStage() {
                return this.blockedUsersOnStage;
            }

            public final RtcConnection.Quality getConnectionQuality() {
                return this.connectionQuality;
            }

            public final RtcConnection.State getConnectionState() {
                return this.connectionState;
            }

            public final Guild getGuild() {
                return this.guild;
            }

            public final Channel getSelectedVoiceChannel() {
                return this.selectedVoiceChannel;
            }

            public final StageInstance getStageInstance() {
                return this.stageInstance;
            }

            public final StreamContext getStreamContext() {
                return this.streamContext;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public int hashCode() {
                Channel channel = this.selectedVoiceChannel;
                int iHashCode = (channel != null ? channel.hashCode() : 0) * 31;
                RtcConnection.State state = this.connectionState;
                int iHashCode2 = (iHashCode + (state != null ? state.hashCode() : 0)) * 31;
                RtcConnection.Quality quality = this.connectionQuality;
                int iHashCode3 = (iHashCode2 + (quality != null ? quality.hashCode() : 0)) * 31;
                Guild guild = this.guild;
                int iHashCode4 = (iHashCode3 + (guild != null ? guild.hashCode() : 0)) * 31;
                StreamContext streamContext = this.streamContext;
                int iHashCode5 = (iHashCode4 + (streamContext != null ? streamContext.hashCode() : 0)) * 31;
                boolean z2 = this.isSpeaking;
                int i = z2;
                if (z2 != 0) {
                    i = 1;
                }
                int i2 = (iHashCode5 + i) * 31;
                StageInstance stageInstance = this.stageInstance;
                int iHashCode6 = (i2 + (stageInstance != null ? stageInstance.hashCode() : 0)) * 31;
                boolean z3 = this.isInvitedToSpeak;
                int i3 = z3;
                if (z3 != 0) {
                    i3 = 1;
                }
                int i4 = (iHashCode6 + i3) * 31;
                boolean z4 = this.isAckingInvitation;
                return ((i4 + (z4 ? 1 : z4 ? 1 : 0)) * 31) + this.blockedUsersOnStage;
            }

            public final boolean isAckingInvitation() {
                return this.isAckingInvitation;
            }

            public final boolean isInvitedToSpeak() {
                return this.isInvitedToSpeak;
            }

            public final boolean isSpeaking() {
                return this.isSpeaking;
            }

            @Override // com.discord.widgets.status.WidgetGlobalStatusIndicatorViewModel.ViewState
            /* renamed from: isSpeakingInOngoingCall, reason: from getter */
            public boolean getIsSpeakingInOngoingCall() {
                return this.isSpeakingInOngoingCall;
            }

            public String toString() {
                StringBuilder sbM833U = outline.m833U("StageChannelOngoing(selectedVoiceChannel=");
                sbM833U.append(this.selectedVoiceChannel);
                sbM833U.append(", connectionState=");
                sbM833U.append(this.connectionState);
                sbM833U.append(", connectionQuality=");
                sbM833U.append(this.connectionQuality);
                sbM833U.append(", guild=");
                sbM833U.append(this.guild);
                sbM833U.append(", streamContext=");
                sbM833U.append(this.streamContext);
                sbM833U.append(", isSpeaking=");
                sbM833U.append(this.isSpeaking);
                sbM833U.append(", stageInstance=");
                sbM833U.append(this.stageInstance);
                sbM833U.append(", isInvitedToSpeak=");
                sbM833U.append(this.isInvitedToSpeak);
                sbM833U.append(", isAckingInvitation=");
                sbM833U.append(this.isAckingInvitation);
                sbM833U.append(", blockedUsersOnStage=");
                return outline.m814B(sbM833U, this.blockedUsersOnStage, ")");
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public StageChannelOngoing(Channel channel, RtcConnection.State state, RtcConnection.Quality quality, Guild guild, StreamContext streamContext, boolean z2, StageInstance stageInstance, boolean z3, boolean z4, int i) {
                super(null);
                Intrinsics3.checkNotNullParameter(channel, "selectedVoiceChannel");
                Intrinsics3.checkNotNullParameter(state, "connectionState");
                Intrinsics3.checkNotNullParameter(quality, "connectionQuality");
                this.selectedVoiceChannel = channel;
                this.connectionState = state;
                this.connectionQuality = quality;
                this.guild = guild;
                this.streamContext = streamContext;
                this.isSpeaking = z2;
                this.stageInstance = stageInstance;
                this.isInvitedToSpeak = z3;
                this.isAckingInvitation = z4;
                this.blockedUsersOnStage = i;
                this.isSpeakingInOngoingCall = z2 || z3;
            }
        }

        private ViewState() {
        }

        /* renamed from: isSpeakingInOngoingCall, reason: from getter */
        public boolean getIsSpeakingInOngoingCall() {
            return this.isSpeakingInOngoingCall;
        }

        public /* synthetic */ ViewState(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            StoreConnectivity.State.values();
            int[] iArr = new int[4];
            $EnumSwitchMapping$0 = iArr;
            iArr[StoreConnectivity.State.ONLINE.ordinal()] = 1;
            iArr[StoreConnectivity.State.CONNECTING.ordinal()] = 2;
            iArr[StoreConnectivity.State.OFFLINE.ordinal()] = 3;
            iArr[StoreConnectivity.State.OFFLINE_AIRPLANE_MODE.ordinal()] = 4;
        }
    }

    /* compiled from: WidgetGlobalStatusIndicatorViewModel.kt */
    /* renamed from: com.discord.widgets.status.WidgetGlobalStatusIndicatorViewModel$ackStageInvitationToSpeak$1 */
    public static final class C101101 extends Lambda implements Function1<Void, Unit> {
        public final /* synthetic */ boolean $accept;
        public final /* synthetic */ ViewState.StageChannelOngoing $stageState;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C101101(boolean z2, ViewState.StageChannelOngoing stageChannelOngoing) {
            super(1);
            this.$accept = z2;
            this.$stageState = stageChannelOngoing;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Void r1) {
            invoke2(r1);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Void r14) {
            if (this.$accept) {
                AnalyticsTracker.INSTANCE.promotedToSpeaker(this.$stageState.getSelectedVoiceChannel().getId());
            }
            ViewState viewStateAccess$getViewState$p = WidgetGlobalStatusIndicatorViewModel.access$getViewState$p(WidgetGlobalStatusIndicatorViewModel.this);
            if (!(viewStateAccess$getViewState$p instanceof ViewState.StageChannelOngoing)) {
                viewStateAccess$getViewState$p = null;
            }
            ViewState.StageChannelOngoing stageChannelOngoing = (ViewState.StageChannelOngoing) viewStateAccess$getViewState$p;
            if (stageChannelOngoing != null) {
                WidgetGlobalStatusIndicatorViewModel.access$updateViewState(WidgetGlobalStatusIndicatorViewModel.this, ViewState.StageChannelOngoing.copy$default(stageChannelOngoing, null, null, null, null, null, false, null, false, false, 0, 767, null));
            }
        }
    }

    public WidgetGlobalStatusIndicatorViewModel() {
        this(null, 1, null);
    }

    public /* synthetic */ WidgetGlobalStatusIndicatorViewModel(Observable observable, int i, DefaultConstructorMarker defaultConstructorMarker) {
        Observable observableObserveStoreState$default;
        if ((i & 1) != 0) {
            Companion companion = INSTANCE;
            StreamContextService streamContextService = new StreamContextService(null, null, null, null, null, null, null, null, 255, null);
            StoreStream.Companion companion2 = StoreStream.INSTANCE;
            observableObserveStoreState$default = Companion.observeStoreState$default(companion, streamContextService, companion2.getVoiceChannelSelected(), companion2.getConnectivity(), companion2.getChannelsSelected(), companion2.getRtcConnection(), companion2.getGuilds(), companion2.getVoiceParticipants(), companion2.getStageChannels(), companion2.getUserRelationships(), companion2.getStageInstances(), null, 1024, null);
            Intrinsics3.checkNotNullExpressionValue(observableObserveStoreState$default, "observeStoreState(\n     ….getStageInstances(),\n  )");
        } else {
            observableObserveStoreState$default = observable;
        }
        this(observableObserveStoreState$default);
    }

    public static final /* synthetic */ ViewState access$getViewState$p(WidgetGlobalStatusIndicatorViewModel widgetGlobalStatusIndicatorViewModel) {
        return widgetGlobalStatusIndicatorViewModel.getViewState();
    }

    public static final /* synthetic */ void access$handleStoreState(WidgetGlobalStatusIndicatorViewModel widgetGlobalStatusIndicatorViewModel, StoreState storeState) {
        widgetGlobalStatusIndicatorViewModel.handleStoreState(storeState);
    }

    public static final /* synthetic */ void access$updateViewState(WidgetGlobalStatusIndicatorViewModel widgetGlobalStatusIndicatorViewModel, ViewState viewState) {
        widgetGlobalStatusIndicatorViewModel.updateViewState(viewState);
    }

    @MainThread
    private final void handleStoreState(StoreState storeState) {
        boolean z2;
        if (storeState instanceof StoreState.ConnectivityState) {
            StoreState.ConnectivityState connectivityState = (StoreState.ConnectivityState) storeState;
            int iOrdinal = connectivityState.getConnectivityState().getState().ordinal();
            if (iOrdinal == 0) {
                updateViewState(ViewState.Inactive.INSTANCE);
                return;
            }
            if (iOrdinal == 1) {
                updateViewState(new ViewState.Offline(connectivityState.getConnectivityState().getDelay(), false));
                return;
            } else if (iOrdinal == 2) {
                updateViewState(new ViewState.Offline(connectivityState.getConnectivityState().getDelay(), true));
                return;
            } else {
                if (iOrdinal != 3) {
                    return;
                }
                updateViewState(new ViewState.Connecting(connectivityState.getConnectivityState().getDelay()));
                return;
            }
        }
        if (storeState instanceof StoreState.CallOngoing) {
            StoreState.CallOngoing callOngoing = (StoreState.CallOngoing) storeState;
            if (ChannelUtils.m7669D(callOngoing.getSelectedVoiceChannel())) {
                boolean z3 = callOngoing.getRequestToSpeakState() == StageRequestToSpeakState.REQUESTED_TO_SPEAK_AND_AWAITING_USER_ACK;
                boolean z4 = callOngoing.getRequestToSpeakState() == StageRequestToSpeakState.ON_STAGE;
                ViewState viewState = getViewState();
                if (!(viewState instanceof ViewState.StageChannelOngoing)) {
                    viewState = null;
                }
                ViewState.StageChannelOngoing stageChannelOngoing = (ViewState.StageChannelOngoing) viewState;
                if (stageChannelOngoing != null && !stageChannelOngoing.isInvitedToSpeak() && z3) {
                    AppSoundManager.Provider.INSTANCE.get().play(AppSound.INSTANCE.getSOUND_RECONNECT());
                }
                updateViewState(new ViewState.StageChannelOngoing(callOngoing.getSelectedVoiceChannel(), callOngoing.getConnectionStateChange().state, callOngoing.getConnectionQuality(), callOngoing.getGuild(), callOngoing.getStreamContext(), z4, callOngoing.getStageInstance(), z3, false, callOngoing.getBlockedUsersOnStage(), 256, null));
                return;
            }
            int size = callOngoing.getParticipants().size();
            Collection<StoreVoiceParticipants.VoiceUser> collectionValues = callOngoing.getParticipants().values();
            if ((collectionValues instanceof Collection) && collectionValues.isEmpty()) {
                z2 = false;
            } else {
                Iterator<T> it = collectionValues.iterator();
                while (it.hasNext()) {
                    VoiceState voiceState = ((StoreVoiceParticipants.VoiceUser) it.next()).getVoiceState();
                    if (voiceState != null && voiceState.getSelfVideo()) {
                        z2 = true;
                        break;
                    }
                }
                z2 = false;
            }
            updateViewState(new ViewState.CallOngoing(callOngoing.getSelectedVoiceChannel(), callOngoing.getSelectedTextChannel(), callOngoing.getConnectionStateChange().state, callOngoing.getConnectionQuality(), callOngoing.getGuild(), size, z2, callOngoing.getStreamContext()));
        }
    }

    public final void ackStageInvitationToSpeak(boolean accept) {
        ViewState viewState = getViewState();
        if (!(viewState instanceof ViewState.StageChannelOngoing)) {
            viewState = null;
        }
        ViewState.StageChannelOngoing stageChannelOngoing = (ViewState.StageChannelOngoing) viewState;
        if (stageChannelOngoing != null) {
            updateViewState(ViewState.StageChannelOngoing.copy$default(stageChannelOngoing, null, null, null, null, null, false, null, false, true, 0, 767, null));
            ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(StageChannelAPI.INSTANCE.ackInvitationToSpeak(stageChannelOngoing.getSelectedVoiceChannel(), accept), false, 1, null), this, null, 2, null), WidgetGlobalStatusIndicatorViewModel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new C101101(accept, stageChannelOngoing), 62, (Object) null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetGlobalStatusIndicatorViewModel(Observable<StoreState> observable) {
        super(ViewState.Inactive.INSTANCE);
        Intrinsics3.checkNotNullParameter(observable, "storeStateObservable");
        Observable<StoreState> observableM11112r = observable.m11112r();
        Intrinsics3.checkNotNullExpressionValue(observableM11112r, "storeStateObservable\n   …  .distinctUntilChanged()");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationLatest(observableM11112r), this, null, 2, null), WidgetGlobalStatusIndicatorViewModel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new C101081(this), 62, (Object) null);
    }
}

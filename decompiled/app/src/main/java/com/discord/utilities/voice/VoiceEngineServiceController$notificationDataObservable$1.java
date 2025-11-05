package com.discord.utilities.voice;

import androidx.core.app.NotificationCompat;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.rtcconnection.RtcConnection;
import com.discord.rtcconnection.audio.DiscordAudioManager;
import com.discord.stores.StoreAudioManagerV2;
import com.discord.stores.StoreMediaSettings;
import com.discord.utilities.rx.ObservableWithLeadingEdgeThrottle;
import com.discord.utilities.voice.VoiceEngineServiceController;
import com.discord.widgets.voice.model.CallModel;
import d0.z.d.m;
import j0.k.b;
import j0.l.e.k;
import java.util.concurrent.TimeUnit;
import rx.Observable;
import rx.functions.Func3;

/* compiled from: VoiceEngineServiceController.kt */
/* loaded from: classes2.dex */
public final class VoiceEngineServiceController$notificationDataObservable$1<T, R> implements b<RtcConnection.StateChange, Observable<? extends VoiceEngineServiceController.NotificationData>> {
    public final /* synthetic */ VoiceEngineServiceController this$0;

    /* compiled from: VoiceEngineServiceController.kt */
    /* renamed from: com.discord.utilities.voice.VoiceEngineServiceController$notificationDataObservable$1$1, reason: invalid class name */
    public static final class AnonymousClass1<T, R> implements b<Long, Observable<? extends VoiceEngineServiceController.NotificationData>> {
        public final /* synthetic */ RtcConnection.State $state;

        /* compiled from: VoiceEngineServiceController.kt */
        /* renamed from: com.discord.utilities.voice.VoiceEngineServiceController$notificationDataObservable$1$1$1, reason: invalid class name and collision with other inner class name */
        public static final class C03501<T1, T2, T3, R> implements Func3<StoreMediaSettings.VoiceConfiguration, StoreAudioManagerV2.State, CallModel, VoiceEngineServiceController.NotificationData> {
            public C03501() {
            }

            @Override // rx.functions.Func3
            public /* bridge */ /* synthetic */ VoiceEngineServiceController.NotificationData call(StoreMediaSettings.VoiceConfiguration voiceConfiguration, StoreAudioManagerV2.State state, CallModel callModel) {
                return call2(voiceConfiguration, state, callModel);
            }

            /* renamed from: call, reason: avoid collision after fix types in other method */
            public final VoiceEngineServiceController.NotificationData call2(StoreMediaSettings.VoiceConfiguration voiceConfiguration, StoreAudioManagerV2.State state, CallModel callModel) {
                Channel channel;
                Channel channel2;
                Channel channel3;
                boolean z2 = false;
                boolean z3 = callModel != null && callModel.getIsVideoCall();
                boolean z4 = !z3 && (state.getActiveAudioDevice() == DiscordAudioManager.DeviceTypes.EARPIECE);
                boolean z5 = callModel == null || !callModel.isSuppressed();
                RtcConnection.State state2 = AnonymousClass1.this.$state;
                String strC = (callModel == null || (channel3 = callModel.getChannel()) == null) ? null : ChannelUtils.c(channel3);
                if (strC == null) {
                    strC = "";
                }
                boolean zIsSelfMuted = voiceConfiguration.isSelfMuted();
                boolean zIsSelfDeafened = voiceConfiguration.isSelfDeafened();
                boolean z6 = callModel != null && callModel.isStreaming();
                long id2 = (callModel == null || (channel2 = callModel.getChannel()) == null) ? -1L : channel2.getId();
                Long lValueOf = (callModel == null || (channel = callModel.getChannel()) == null) ? null : Long.valueOf(channel.getGuildId());
                if (lValueOf != null && lValueOf.longValue() > 0) {
                    z2 = true;
                }
                if (!z2) {
                    lValueOf = null;
                }
                return new VoiceEngineServiceController.NotificationData(state2, strC, zIsSelfMuted, zIsSelfDeafened, z6, z3, id2, lValueOf, z4, z5);
            }
        }

        public AnonymousClass1(RtcConnection.State state) {
            this.$state = state;
        }

        @Override // j0.k.b
        public /* bridge */ /* synthetic */ Observable<? extends VoiceEngineServiceController.NotificationData> call(Long l) {
            return call2(l);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final Observable<? extends VoiceEngineServiceController.NotificationData> call2(Long l) {
            Observable<StoreMediaSettings.VoiceConfiguration> voiceConfig = VoiceEngineServiceController.access$getMediaSettingsStore$p(VoiceEngineServiceController$notificationDataObservable$1.this.this$0).getVoiceConfig();
            Observable<StoreAudioManagerV2.State> observableObserveAudioManagerState = VoiceEngineServiceController.access$getAudioManagerStore$p(VoiceEngineServiceController$notificationDataObservable$1.this.this$0).observeAudioManagerState();
            CallModel.Companion companion = CallModel.INSTANCE;
            m.checkNotNullExpressionValue(l, "selectedVoiceChannelId");
            return ObservableWithLeadingEdgeThrottle.combineLatest(voiceConfig, observableObserveAudioManagerState, companion.get(l.longValue()), new C03501(), 300L, TimeUnit.MILLISECONDS);
        }
    }

    public VoiceEngineServiceController$notificationDataObservable$1(VoiceEngineServiceController voiceEngineServiceController) {
        this.this$0 = voiceEngineServiceController;
    }

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ Observable<? extends VoiceEngineServiceController.NotificationData> call(RtcConnection.StateChange stateChange) {
        return call2(stateChange);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends VoiceEngineServiceController.NotificationData> call2(RtcConnection.StateChange stateChange) {
        RtcConnection.State state = stateChange.state;
        return m.areEqual(state, RtcConnection.State.h.a) ? new k(VoiceEngineServiceController.access$getNOTIFICATION_DATA_DISCONNECTED$cp()) : VoiceEngineServiceController.access$getVoiceChannelSelectedStore$p(this.this$0).observeSelectedVoiceChannelId().Y(new AnonymousClass1(state));
    }
}

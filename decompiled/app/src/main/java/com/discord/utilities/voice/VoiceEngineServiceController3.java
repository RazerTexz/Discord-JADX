package com.discord.utilities.voice;

import androidx.core.app.NotificationCompat;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.rtcconnection.RtcConnection;
import com.discord.rtcconnection.audio.DiscordAudioManager;
import com.discord.stores.StoreAudioManagerV2;
import com.discord.stores.StoreMediaSettings;
import com.discord.utilities.p501rx.ObservableWithLeadingEdgeThrottle;
import com.discord.utilities.voice.VoiceEngineServiceController;
import com.discord.widgets.voice.model.CallModel;
import java.util.concurrent.TimeUnit;
import p507d0.p592z.p594d.Intrinsics3;
import p637j0.p641k.Func1;
import p637j0.p642l.p647e.ScalarSynchronousObservable;
import p658rx.Observable;
import p658rx.functions.Func3;

/* compiled from: VoiceEngineServiceController.kt */
/* renamed from: com.discord.utilities.voice.VoiceEngineServiceController$notificationDataObservable$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class VoiceEngineServiceController3<T, R> implements Func1<RtcConnection.StateChange, Observable<? extends VoiceEngineServiceController.NotificationData>> {
    public final /* synthetic */ VoiceEngineServiceController this$0;

    /* compiled from: VoiceEngineServiceController.kt */
    /* renamed from: com.discord.utilities.voice.VoiceEngineServiceController$notificationDataObservable$1$1 */
    public static final class C70551<T, R> implements Func1<Long, Observable<? extends VoiceEngineServiceController.NotificationData>> {
        public final /* synthetic */ RtcConnection.State $state;

        /* compiled from: VoiceEngineServiceController.kt */
        /* renamed from: com.discord.utilities.voice.VoiceEngineServiceController$notificationDataObservable$1$1$1, reason: invalid class name */
        public static final class AnonymousClass1<T1, T2, T3, R> implements Func3<StoreMediaSettings.VoiceConfiguration, StoreAudioManagerV2.State, CallModel, VoiceEngineServiceController.NotificationData> {
            public AnonymousClass1() {
            }

            @Override // p658rx.functions.Func3
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
                RtcConnection.State state2 = C70551.this.$state;
                String strM7679c = (callModel == null || (channel3 = callModel.getChannel()) == null) ? null : ChannelUtils.m7679c(channel3);
                if (strM7679c == null) {
                    strM7679c = "";
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
                return new VoiceEngineServiceController.NotificationData(state2, strM7679c, zIsSelfMuted, zIsSelfDeafened, z6, z3, id2, lValueOf, z4, z5);
            }
        }

        public C70551(RtcConnection.State state) {
            this.$state = state;
        }

        @Override // p637j0.p641k.Func1
        public /* bridge */ /* synthetic */ Observable<? extends VoiceEngineServiceController.NotificationData> call(Long l) {
            return call2(l);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final Observable<? extends VoiceEngineServiceController.NotificationData> call2(Long l) {
            Observable<StoreMediaSettings.VoiceConfiguration> voiceConfig = VoiceEngineServiceController.access$getMediaSettingsStore$p(VoiceEngineServiceController3.this.this$0).getVoiceConfig();
            Observable<StoreAudioManagerV2.State> observableObserveAudioManagerState = VoiceEngineServiceController.access$getAudioManagerStore$p(VoiceEngineServiceController3.this.this$0).observeAudioManagerState();
            CallModel.Companion companion = CallModel.INSTANCE;
            Intrinsics3.checkNotNullExpressionValue(l, "selectedVoiceChannelId");
            return ObservableWithLeadingEdgeThrottle.combineLatest(voiceConfig, observableObserveAudioManagerState, companion.get(l.longValue()), new AnonymousClass1(), 300L, TimeUnit.MILLISECONDS);
        }
    }

    public VoiceEngineServiceController3(VoiceEngineServiceController voiceEngineServiceController) {
        this.this$0 = voiceEngineServiceController;
    }

    @Override // p637j0.p641k.Func1
    public /* bridge */ /* synthetic */ Observable<? extends VoiceEngineServiceController.NotificationData> call(RtcConnection.StateChange stateChange) {
        return call2(stateChange);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends VoiceEngineServiceController.NotificationData> call2(RtcConnection.StateChange stateChange) {
        RtcConnection.State state = stateChange.state;
        return Intrinsics3.areEqual(state, RtcConnection.State.C5614h.f18816a) ? new ScalarSynchronousObservable(VoiceEngineServiceController.access$getNOTIFICATION_DATA_DISCONNECTED$cp()) : VoiceEngineServiceController.access$getVoiceChannelSelectedStore$p(this.this$0).observeSelectedVoiceChannelId().m11099Y(new C70551(state));
    }
}

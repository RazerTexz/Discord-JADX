package com.discord.widgets.voice.model;

import androidx.core.app.NotificationCompat;
import co.discord.media_engine.DeviceDescription4;
import com.discord.api.channel.Channel;
import com.discord.stores.StoreAudioManagerV2;
import com.discord.stores.StoreMediaSettings;
import com.discord.stores.StoreVoiceParticipants;
import com.discord.widgets.voice.model.CallModel;
import java.util.List;
import java.util.Map;
import p507d0.p592z.p594d.Intrinsics3;
import p658rx.functions.Func8;

/* JADX INFO: renamed from: com.discord.widgets.voice.model.CallModel$Companion$observeChunk$1, reason: use source file name */
/* JADX INFO: compiled from: CallModel.kt */
/* JADX INFO: loaded from: classes.dex */
public final class CallModel3<T1, T2, T3, T4, T5, T6, T7, T8, R> implements Func8<Long, Long, StoreMediaSettings.VoiceConfiguration, Map<Long, ? extends StoreVoiceParticipants.VoiceUser>, Long, List<? extends DeviceDescription4>, DeviceDescription4, StoreAudioManagerV2.State, CallModel.Companion.Chunk> {
    public final /* synthetic */ Channel $channel;

    public CallModel3(Channel channel) {
        this.$channel = channel;
    }

    @Override // p658rx.functions.Func8
    public /* bridge */ /* synthetic */ CallModel.Companion.Chunk call(Long l, Long l2, StoreMediaSettings.VoiceConfiguration voiceConfiguration, Map<Long, ? extends StoreVoiceParticipants.VoiceUser> map, Long l3, List<? extends DeviceDescription4> list, DeviceDescription4 deviceDescription4, StoreAudioManagerV2.State state) {
        return call2(l, l2, voiceConfiguration, (Map<Long, StoreVoiceParticipants.VoiceUser>) map, l3, (List<DeviceDescription4>) list, deviceDescription4, state);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final CallModel.Companion.Chunk call2(Long l, Long l2, StoreMediaSettings.VoiceConfiguration voiceConfiguration, Map<Long, StoreVoiceParticipants.VoiceUser> map, Long l3, List<DeviceDescription4> list, DeviceDescription4 deviceDescription4, StoreAudioManagerV2.State state) {
        Channel channel = this.$channel;
        Intrinsics3.checkNotNullExpressionValue(l, "myUserId");
        long jLongValue = l.longValue();
        Intrinsics3.checkNotNullExpressionValue(l2, "timeConnectedMs");
        long jLongValue2 = l2.longValue();
        Intrinsics3.checkNotNullExpressionValue(voiceConfiguration, "voiceConfig");
        Intrinsics3.checkNotNullExpressionValue(map, "voiceParticipants");
        Intrinsics3.checkNotNullExpressionValue(list, "videoDevices");
        Intrinsics3.checkNotNullExpressionValue(state, "audioManagerState");
        return new CallModel.Companion.Chunk(channel, jLongValue, jLongValue2, voiceConfiguration, map, l3, list, deviceDescription4, state);
    }
}

package com.discord.utilities.voice;

import androidx.core.app.NotificationCompat;
import com.discord.api.channel.Channel;
import com.discord.models.domain.ModelApplicationStream;
import com.discord.models.user.MeUser;
import com.discord.rtcconnection.RtcConnection;
import com.discord.stores.StoreApplicationStreaming;
import com.discord.stores.StoreVoiceParticipants;
import com.discord.utilities.voice.CallSoundManager;
import java.util.List;
import java.util.Map;
import p507d0.p592z.p594d.Intrinsics3;
import p658rx.functions.Func7;

/* JADX INFO: renamed from: com.discord.utilities.voice.CallSoundManager$StoreStateGenerator$observeStoreState$1, reason: use source file name */
/* JADX INFO: compiled from: CallSoundManager.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class CallSoundManager2<T1, T2, T3, T4, T5, T6, T7, R> implements Func7<Map<Long, ? extends StoreVoiceParticipants.VoiceUser>, RtcConnection.StateChange, Map<Long, ? extends ModelApplicationStream>, Map<String, ? extends List<? extends Long>>, StoreApplicationStreaming.ActiveApplicationStream, MeUser, Channel, CallSoundManager.StoreState> {
    public static final CallSoundManager2 INSTANCE = new CallSoundManager2();

    @Override // p658rx.functions.Func7
    public /* bridge */ /* synthetic */ CallSoundManager.StoreState call(Map<Long, ? extends StoreVoiceParticipants.VoiceUser> map, RtcConnection.StateChange stateChange, Map<Long, ? extends ModelApplicationStream> map2, Map<String, ? extends List<? extends Long>> map3, StoreApplicationStreaming.ActiveApplicationStream activeApplicationStream, MeUser meUser, Channel channel) {
        return call2((Map<Long, StoreVoiceParticipants.VoiceUser>) map, stateChange, map2, (Map<String, ? extends List<Long>>) map3, activeApplicationStream, meUser, channel);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final CallSoundManager.StoreState call2(Map<Long, StoreVoiceParticipants.VoiceUser> map, RtcConnection.StateChange stateChange, Map<Long, ? extends ModelApplicationStream> map2, Map<String, ? extends List<Long>> map3, StoreApplicationStreaming.ActiveApplicationStream activeApplicationStream, MeUser meUser, Channel channel) {
        Intrinsics3.checkNotNullExpressionValue(map, "voiceParticipants");
        RtcConnection.State state = stateChange.state;
        Intrinsics3.checkNotNullExpressionValue(map2, "streamsByUser");
        Intrinsics3.checkNotNullExpressionValue(map3, "streamSpectators");
        Intrinsics3.checkNotNullExpressionValue(meUser, "me");
        return new CallSoundManager.StoreState(map, state, map2, map3, activeApplicationStream, meUser, channel);
    }
}

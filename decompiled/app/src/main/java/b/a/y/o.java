package b.a.y;

import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.api.voice.state.StageRequestToSpeakState;
import com.discord.api.voice.state.VoiceState;
import com.discord.stores.StoreVoiceParticipants;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/* compiled from: OverlayMenuBubbleDialog.kt */
/* loaded from: classes2.dex */
public final class o<T, R> implements j0.k.b<Map<Long, ? extends StoreVoiceParticipants.VoiceUser>, List<? extends StoreVoiceParticipants.VoiceUser>> {
    public final /* synthetic */ Channel j;

    public o(Channel channel) {
        this.j = channel;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x003c  */
    @Override // j0.k.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public List<? extends StoreVoiceParticipants.VoiceUser> call(Map<Long, ? extends StoreVoiceParticipants.VoiceUser> map) {
        boolean z2;
        Collection<? extends StoreVoiceParticipants.VoiceUser> collectionValues = map.values();
        ArrayList arrayList = new ArrayList();
        for (T t : collectionValues) {
            StoreVoiceParticipants.VoiceUser voiceUser = (StoreVoiceParticipants.VoiceUser) t;
            if (voiceUser.isConnected()) {
                if (ChannelUtils.D(this.j)) {
                    VoiceState voiceState = voiceUser.getVoiceState();
                    if ((voiceState != null ? b.c.a.a0.d.y0(voiceState) : null) == StageRequestToSpeakState.ON_STAGE) {
                    }
                }
                z2 = true;
            } else {
                z2 = false;
            }
            if (z2) {
                arrayList.add(t);
            }
        }
        return arrayList;
    }
}

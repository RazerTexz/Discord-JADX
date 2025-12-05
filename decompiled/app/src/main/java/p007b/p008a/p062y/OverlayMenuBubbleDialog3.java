package p007b.p008a.p062y;

import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.api.voice.state.StageRequestToSpeakState;
import com.discord.api.voice.state.VoiceState;
import com.discord.stores.StoreVoiceParticipants;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import p007b.p085c.p086a.p087a0.AnimatableValueParser;
import p637j0.p641k.Func1;

/* compiled from: OverlayMenuBubbleDialog.kt */
/* renamed from: b.a.y.o, reason: use source file name */
/* loaded from: classes2.dex */
public final class OverlayMenuBubbleDialog3<T, R> implements Func1<Map<Long, ? extends StoreVoiceParticipants.VoiceUser>, List<? extends StoreVoiceParticipants.VoiceUser>> {

    /* renamed from: j */
    public final /* synthetic */ Channel f2051j;

    public OverlayMenuBubbleDialog3(Channel channel) {
        this.f2051j = channel;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x003c  */
    @Override // p637j0.p641k.Func1
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
                if (ChannelUtils.m7669D(this.f2051j)) {
                    VoiceState voiceState = voiceUser.getVoiceState();
                    if ((voiceState != null ? AnimatableValueParser.m592y0(voiceState) : null) == StageRequestToSpeakState.ON_STAGE) {
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

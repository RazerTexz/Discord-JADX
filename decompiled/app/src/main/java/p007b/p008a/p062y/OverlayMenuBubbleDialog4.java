package p007b.p008a.p062y;

import com.discord.api.channel.Channel;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreVoiceParticipants;
import java.util.List;
import p507d0.p580t.Collections2;
import p507d0.p592z.p594d.Intrinsics3;
import p637j0.p641k.Func1;
import p637j0.p642l.p647e.ScalarSynchronousObservable;
import p658rx.Observable;

/* JADX INFO: renamed from: b.a.y.p, reason: use source file name */
/* JADX INFO: compiled from: OverlayMenuBubbleDialog.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class OverlayMenuBubbleDialog4<T, R> implements Func1<Channel, Observable<? extends List<? extends StoreVoiceParticipants.VoiceUser>>> {

    /* JADX INFO: renamed from: j */
    public final /* synthetic */ Long f2063j;

    public OverlayMenuBubbleDialog4(Long l) {
        this.f2063j = l;
    }

    @Override // p637j0.p641k.Func1
    public Observable<? extends List<? extends StoreVoiceParticipants.VoiceUser>> call(Channel channel) {
        Channel channel2 = channel;
        if (channel2 == null) {
            return new ScalarSynchronousObservable(Collections2.emptyList());
        }
        StoreVoiceParticipants voiceParticipants = StoreStream.INSTANCE.getVoiceParticipants();
        Long l = this.f2063j;
        Intrinsics3.checkNotNullExpressionValue(l, "channelId");
        return voiceParticipants.get(l.longValue()).m11083G(new OverlayMenuBubbleDialog3(channel2)).m11112r();
    }
}

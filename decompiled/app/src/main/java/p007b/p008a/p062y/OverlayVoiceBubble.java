package p007b.p008a.p062y;

import com.discord.stores.StoreVoiceParticipants;
import java.util.Iterator;
import java.util.Map;
import p637j0.p641k.Func1;

/* compiled from: OverlayVoiceBubble.kt */
/* renamed from: b.a.y.v, reason: use source file name */
/* loaded from: classes2.dex */
public final class OverlayVoiceBubble<T, R> implements Func1<Map<Long, ? extends StoreVoiceParticipants.VoiceUser>, StoreVoiceParticipants.VoiceUser> {

    /* renamed from: j */
    public static final OverlayVoiceBubble f2072j = new OverlayVoiceBubble();

    @Override // p637j0.p641k.Func1
    public StoreVoiceParticipants.VoiceUser call(Map<Long, ? extends StoreVoiceParticipants.VoiceUser> map) {
        T next;
        Iterator<T> it = map.values().iterator();
        while (true) {
            if (!it.hasNext()) {
                next = (T) null;
                break;
            }
            next = it.next();
            if (((StoreVoiceParticipants.VoiceUser) next).getIsSpeaking()) {
                break;
            }
        }
        return next;
    }
}

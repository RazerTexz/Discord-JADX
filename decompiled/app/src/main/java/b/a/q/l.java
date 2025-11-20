package b.a.q;

import com.discord.rtcconnection.EncodeQuality;
import com.discord.rtcconnection.MediaSinkWantsManager;
import com.discord.rtcconnection.VideoMetadata;
import com.discord.rtcconnection.socket.io.Payloads;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* compiled from: MediaSinkWantsManager.kt */
/* loaded from: classes.dex */
public final class l extends d0.z.d.o implements Function0<Unit> {
    public final /* synthetic */ List $ssrcs;
    public final /* synthetic */ long $userId;
    public final /* synthetic */ MediaSinkWantsManager this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l(MediaSinkWantsManager mediaSinkWantsManager, List list, long j) {
        super(0);
        this.this$0 = mediaSinkWantsManager;
        this.$ssrcs = list;
        this.$userId = j;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0039  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0089  */
    @Override // kotlin.jvm.functions.Function0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Unit invoke() {
        EncodeQuality encodeQuality;
        List list = this.$ssrcs;
        ArrayList<Payloads.Stream> arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (true) {
            boolean z2 = true;
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            Payloads.Stream stream = (Payloads.Stream) next;
            Boolean active = stream.getActive();
            if (active != null ? active.booleanValue() : false) {
                Integer ssrc = stream.getSsrc();
                if ((ssrc != null ? ssrc.intValue() : 0) <= 0) {
                }
            } else {
                z2 = false;
            }
            if (z2) {
                arrayList.add(next);
            }
        }
        ArrayList arrayList2 = new ArrayList(d0.t.o.collectionSizeOrDefault(arrayList, 10));
        for (Payloads.Stream stream2 : arrayList) {
            Integer quality = stream2.getQuality();
            VideoMetadata videoMetadata = null;
            if (quality != null) {
                int iIntValue = quality.intValue();
                Objects.requireNonNull(EncodeQuality.INSTANCE);
                EncodeQuality[] encodeQualityArrValues = EncodeQuality.values();
                int i = 0;
                while (true) {
                    if (i >= 11) {
                        encodeQuality = null;
                        break;
                    }
                    encodeQuality = encodeQualityArrValues[i];
                    if (encodeQuality.getValue() == iIntValue) {
                        break;
                    }
                    i++;
                }
                if (encodeQuality == null) {
                    encodeQuality = EncodeQuality.Hundred;
                }
            }
            Integer ssrc2 = stream2.getSsrc();
            d0.z.d.m.checkNotNull(ssrc2);
            long jIntValue = ssrc2.intValue();
            MediaSinkWantsManager mediaSinkWantsManager = this.this$0;
            long j = this.$userId;
            Objects.requireNonNull(mediaSinkWantsManager);
            if (stream2.getMaxResolution() != null) {
                videoMetadata = new VideoMetadata(j, stream2.getMaxResolution().getWidth(), stream2.getMaxResolution().getHeight(), stream2.getMaxFrameRate(), stream2.getMaxResolution().getType());
            } else {
                mediaSinkWantsManager.a("metadataOf: " + stream2 + " has no maxResolution!");
            }
            arrayList2.add(new MediaSinkWantsManager.b(encodeQuality, jIntValue, videoMetadata));
        }
        if (arrayList2.isEmpty()) {
            this.this$0.f2771b.remove(Long.valueOf(this.$userId));
            this.this$0.c.remove(Long.valueOf(this.$userId));
        } else {
            this.this$0.f2771b.put(Long.valueOf(this.$userId), arrayList2);
            this.this$0.c.add(Long.valueOf(this.$userId));
        }
        this.this$0.d(arrayList2.isEmpty() ? d0.t.n.emptyList() : d0.t.m.listOf(String.valueOf(this.$userId)));
        return Unit.a;
    }
}

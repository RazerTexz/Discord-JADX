package co.discord.media_engine.internal;

import b.d.b.a.outline;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.Intrinsics3;
import org.webrtc.MediaStreamTrack;

/* compiled from: NativeStatistics.kt */
/* loaded from: classes.dex */
public final /* data */ class Inbound {
    private final InboundAudio audio;
    private final String id;
    private final InboundPlayout playout;
    private final InboundVideo video;

    public Inbound(String str, InboundAudio inboundAudio, InboundVideo inboundVideo, InboundPlayout inboundPlayout) {
        Intrinsics3.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_ID);
        Intrinsics3.checkNotNullParameter(inboundAudio, MediaStreamTrack.AUDIO_TRACK_KIND);
        this.id = str;
        this.audio = inboundAudio;
        this.video = inboundVideo;
        this.playout = inboundPlayout;
    }

    public static /* synthetic */ Inbound copy$default(Inbound inbound, String str, InboundAudio inboundAudio, InboundVideo inboundVideo, InboundPlayout inboundPlayout, int i, Object obj) {
        if ((i & 1) != 0) {
            str = inbound.id;
        }
        if ((i & 2) != 0) {
            inboundAudio = inbound.audio;
        }
        if ((i & 4) != 0) {
            inboundVideo = inbound.video;
        }
        if ((i & 8) != 0) {
            inboundPlayout = inbound.playout;
        }
        return inbound.copy(str, inboundAudio, inboundVideo, inboundPlayout);
    }

    /* renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* renamed from: component2, reason: from getter */
    public final InboundAudio getAudio() {
        return this.audio;
    }

    /* renamed from: component3, reason: from getter */
    public final InboundVideo getVideo() {
        return this.video;
    }

    /* renamed from: component4, reason: from getter */
    public final InboundPlayout getPlayout() {
        return this.playout;
    }

    public final Inbound copy(String id2, InboundAudio audio, InboundVideo video, InboundPlayout playout) {
        Intrinsics3.checkNotNullParameter(id2, ModelAuditLogEntry.CHANGE_KEY_ID);
        Intrinsics3.checkNotNullParameter(audio, MediaStreamTrack.AUDIO_TRACK_KIND);
        return new Inbound(id2, audio, video, playout);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Inbound)) {
            return false;
        }
        Inbound inbound = (Inbound) other;
        return Intrinsics3.areEqual(this.id, inbound.id) && Intrinsics3.areEqual(this.audio, inbound.audio) && Intrinsics3.areEqual(this.video, inbound.video) && Intrinsics3.areEqual(this.playout, inbound.playout);
    }

    public final InboundAudio getAudio() {
        return this.audio;
    }

    public final String getId() {
        return this.id;
    }

    public final InboundPlayout getPlayout() {
        return this.playout;
    }

    public final InboundVideo getVideo() {
        return this.video;
    }

    public int hashCode() {
        String str = this.id;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        InboundAudio inboundAudio = this.audio;
        int iHashCode2 = (iHashCode + (inboundAudio != null ? inboundAudio.hashCode() : 0)) * 31;
        InboundVideo inboundVideo = this.video;
        int iHashCode3 = (iHashCode2 + (inboundVideo != null ? inboundVideo.hashCode() : 0)) * 31;
        InboundPlayout inboundPlayout = this.playout;
        return iHashCode3 + (inboundPlayout != null ? inboundPlayout.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("Inbound(id=");
        sbU.append(this.id);
        sbU.append(", audio=");
        sbU.append(this.audio);
        sbU.append(", video=");
        sbU.append(this.video);
        sbU.append(", playout=");
        sbU.append(this.playout);
        sbU.append(")");
        return sbU.toString();
    }
}

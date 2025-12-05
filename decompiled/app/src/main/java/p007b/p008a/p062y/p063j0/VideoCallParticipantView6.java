package p007b.p008a.p062y.p063j0;

import android.view.View;
import com.discord.views.calls.VideoCallParticipantView;

/* compiled from: VideoCallParticipantView.kt */
/* renamed from: b.a.y.j0.n, reason: use source file name */
/* loaded from: classes2.dex */
public final class VideoCallParticipantView6 implements View.OnClickListener {

    /* renamed from: j */
    public final /* synthetic */ VideoCallParticipantView f2037j;

    /* renamed from: k */
    public final /* synthetic */ VideoCallParticipantView.ParticipantData f2038k;

    public VideoCallParticipantView6(VideoCallParticipantView videoCallParticipantView, VideoCallParticipantView.ParticipantData participantData) {
        this.f2037j = videoCallParticipantView;
        this.f2038k = participantData;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (this.f2038k.voiceParticipant.getApplicationStream() != null) {
            this.f2037j.onWatchStreamClicked.invoke(this.f2038k.voiceParticipant.getApplicationStream().getEncodedStreamKey());
        }
    }
}

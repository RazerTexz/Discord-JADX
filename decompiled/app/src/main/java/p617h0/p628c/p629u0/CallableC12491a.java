package p617h0.p628c.p629u0;

import android.media.AudioRecord;
import java.util.concurrent.Callable;
import org.webrtc.audio.WebRtcAudioRecord;

/* JADX INFO: renamed from: h0.c.u0.a */
/* JADX INFO: compiled from: lambda */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class CallableC12491a implements Callable {

    /* JADX INFO: renamed from: j */
    public final /* synthetic */ WebRtcAudioRecord f26463j;

    /* JADX INFO: renamed from: k */
    public final /* synthetic */ AudioRecord f26464k;

    public /* synthetic */ CallableC12491a(WebRtcAudioRecord webRtcAudioRecord, AudioRecord audioRecord) {
        this.f26463j = webRtcAudioRecord;
        this.f26464k = audioRecord;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        this.f26463j.m11054a(this.f26464k);
        return "Scheduled task is done";
    }
}

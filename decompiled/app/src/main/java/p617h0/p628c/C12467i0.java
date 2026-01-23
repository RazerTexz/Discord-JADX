package p617h0.p628c;

import org.webrtc.VideoFrame;
import org.webrtc.VideoSink;
import org.webrtc.VideoSource;

/* JADX INFO: renamed from: h0.c.i0 */
/* JADX INFO: compiled from: lambda */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class C12467i0 implements VideoSink {

    /* JADX INFO: renamed from: j */
    public final /* synthetic */ VideoSource f26438j;

    public /* synthetic */ C12467i0(VideoSource videoSource) {
        this.f26438j = videoSource;
    }

    @Override // org.webrtc.VideoSink
    public final void onFrame(VideoFrame videoFrame) {
        VideoSource videoSource = this.f26438j;
        videoSource.runWithReference(new RunnableC12465h0(videoSource, videoFrame));
    }
}

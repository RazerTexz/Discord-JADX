package p617h0.p628c;

import org.webrtc.Camera1Session;
import org.webrtc.VideoFrame;
import org.webrtc.VideoSink;

/* JADX INFO: renamed from: h0.c.c */
/* JADX INFO: compiled from: lambda */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class C12454c implements VideoSink {

    /* JADX INFO: renamed from: j */
    public final /* synthetic */ Camera1Session f26412j;

    public /* synthetic */ C12454c(Camera1Session camera1Session) {
        this.f26412j = camera1Session;
    }

    @Override // org.webrtc.VideoSink
    public final void onFrame(VideoFrame videoFrame) {
        this.f26412j.m11014a(videoFrame);
    }
}

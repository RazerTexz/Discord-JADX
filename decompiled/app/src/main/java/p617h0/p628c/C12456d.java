package p617h0.p628c;

import org.webrtc.Camera2Session;
import org.webrtc.VideoFrame;
import org.webrtc.VideoSink;

/* JADX INFO: renamed from: h0.c.d */
/* JADX INFO: compiled from: lambda */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class C12456d implements VideoSink {

    /* JADX INFO: renamed from: j */
    public final /* synthetic */ Camera2Session.CaptureSessionCallback f26414j;

    public /* synthetic */ C12456d(Camera2Session.CaptureSessionCallback captureSessionCallback) {
        this.f26414j = captureSessionCallback;
    }

    @Override // org.webrtc.VideoSink
    public final void onFrame(VideoFrame videoFrame) {
        this.f26414j.m11015a(videoFrame);
    }
}

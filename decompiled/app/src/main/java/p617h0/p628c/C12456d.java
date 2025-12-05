package p617h0.p628c;

import org.webrtc.Camera2Session;
import org.webrtc.VideoFrame;
import org.webrtc.VideoSink;

/* compiled from: lambda */
/* renamed from: h0.c.d */
/* loaded from: classes3.dex */
public final /* synthetic */ class C12456d implements VideoSink {

    /* renamed from: j */
    public final /* synthetic */ Camera2Session.CaptureSessionCallback f26414j;

    public /* synthetic */ C12456d(Camera2Session.CaptureSessionCallback captureSessionCallback) {
        this.f26414j = captureSessionCallback;
    }

    @Override // org.webrtc.VideoSink
    public final void onFrame(VideoFrame videoFrame) {
        this.f26414j.m11015a(videoFrame);
    }
}

package p617h0.p628c;

import org.webrtc.Camera1Session;
import org.webrtc.VideoFrame;
import org.webrtc.VideoSink;

/* compiled from: lambda */
/* renamed from: h0.c.c */
/* loaded from: classes3.dex */
public final /* synthetic */ class C12454c implements VideoSink {

    /* renamed from: j */
    public final /* synthetic */ Camera1Session f26412j;

    public /* synthetic */ C12454c(Camera1Session camera1Session) {
        this.f26412j = camera1Session;
    }

    @Override // org.webrtc.VideoSink
    public final void onFrame(VideoFrame videoFrame) {
        this.f26412j.m11014a(videoFrame);
    }
}

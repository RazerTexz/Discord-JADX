package p617h0.p628c;

import org.webrtc.VideoFileRenderer;
import org.webrtc.VideoFrame;

/* compiled from: lambda */
/* renamed from: h0.c.g0 */
/* loaded from: classes3.dex */
public final /* synthetic */ class RunnableC12463g0 implements Runnable {

    /* renamed from: j */
    public final /* synthetic */ VideoFileRenderer f26430j;

    /* renamed from: k */
    public final /* synthetic */ VideoFrame.I420Buffer f26431k;

    /* renamed from: l */
    public final /* synthetic */ VideoFrame f26432l;

    public /* synthetic */ RunnableC12463g0(VideoFileRenderer videoFileRenderer, VideoFrame.I420Buffer i420Buffer, VideoFrame videoFrame) {
        this.f26430j = videoFileRenderer;
        this.f26431k = i420Buffer;
        this.f26432l = videoFrame;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f26430j.m11052d(this.f26431k, this.f26432l);
    }
}

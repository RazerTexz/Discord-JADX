package p617h0.p628c;

import org.webrtc.VideoFrame;
import org.webrtc.VideoSource;

/* compiled from: lambda */
/* renamed from: h0.c.h0 */
/* loaded from: classes3.dex */
public final /* synthetic */ class RunnableC12465h0 implements Runnable {

    /* renamed from: j */
    public final /* synthetic */ VideoSource f26435j;

    /* renamed from: k */
    public final /* synthetic */ VideoFrame f26436k;

    public /* synthetic */ RunnableC12465h0(VideoSource videoSource, VideoFrame videoFrame) {
        this.f26435j = videoSource;
        this.f26436k = videoFrame;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f26435j.m11053a(this.f26436k);
    }
}

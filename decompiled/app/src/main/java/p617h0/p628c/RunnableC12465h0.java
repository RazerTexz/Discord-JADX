package p617h0.p628c;

import org.webrtc.VideoFrame;
import org.webrtc.VideoSource;

/* JADX INFO: renamed from: h0.c.h0 */
/* JADX INFO: compiled from: lambda */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class RunnableC12465h0 implements Runnable {

    /* JADX INFO: renamed from: j */
    public final /* synthetic */ VideoSource f26435j;

    /* JADX INFO: renamed from: k */
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

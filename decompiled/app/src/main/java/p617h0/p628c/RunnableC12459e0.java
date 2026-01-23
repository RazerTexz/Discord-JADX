package p617h0.p628c;

import org.webrtc.VideoFileRenderer;
import org.webrtc.VideoFrame;

/* JADX INFO: renamed from: h0.c.e0 */
/* JADX INFO: compiled from: lambda */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class RunnableC12459e0 implements Runnable {

    /* JADX INFO: renamed from: j */
    public final /* synthetic */ VideoFileRenderer f26418j;

    /* JADX INFO: renamed from: k */
    public final /* synthetic */ VideoFrame f26419k;

    public /* synthetic */ RunnableC12459e0(VideoFileRenderer videoFileRenderer, VideoFrame videoFrame) {
        this.f26418j = videoFileRenderer;
        this.f26419k = videoFrame;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f26418j.m11049a(this.f26419k);
    }
}

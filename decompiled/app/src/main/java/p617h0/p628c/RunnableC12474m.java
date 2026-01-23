package p617h0.p628c;

import org.webrtc.VideoFrame;

/* JADX INFO: renamed from: h0.c.m */
/* JADX INFO: compiled from: lambda */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class RunnableC12474m implements Runnable {

    /* JADX INFO: renamed from: j */
    public final /* synthetic */ VideoFrame.I420Buffer f26451j;

    public /* synthetic */ RunnableC12474m(VideoFrame.I420Buffer i420Buffer) {
        this.f26451j = i420Buffer;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f26451j.release();
    }
}

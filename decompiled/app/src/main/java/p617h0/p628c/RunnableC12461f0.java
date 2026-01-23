package p617h0.p628c;

import java.util.concurrent.CountDownLatch;
import org.webrtc.VideoFileRenderer;

/* JADX INFO: renamed from: h0.c.f0 */
/* JADX INFO: compiled from: lambda */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class RunnableC12461f0 implements Runnable {

    /* JADX INFO: renamed from: j */
    public final /* synthetic */ VideoFileRenderer f26425j;

    /* JADX INFO: renamed from: k */
    public final /* synthetic */ CountDownLatch f26426k;

    public /* synthetic */ RunnableC12461f0(VideoFileRenderer videoFileRenderer, CountDownLatch countDownLatch) {
        this.f26425j = videoFileRenderer;
        this.f26426k = countDownLatch;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f26425j.m11050b(this.f26426k);
    }
}

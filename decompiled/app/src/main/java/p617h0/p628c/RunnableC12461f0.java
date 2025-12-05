package p617h0.p628c;

import java.util.concurrent.CountDownLatch;
import org.webrtc.VideoFileRenderer;

/* compiled from: lambda */
/* renamed from: h0.c.f0 */
/* loaded from: classes3.dex */
public final /* synthetic */ class RunnableC12461f0 implements Runnable {

    /* renamed from: j */
    public final /* synthetic */ VideoFileRenderer f26425j;

    /* renamed from: k */
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

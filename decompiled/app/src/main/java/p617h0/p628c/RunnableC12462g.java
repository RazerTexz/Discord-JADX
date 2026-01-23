package p617h0.p628c;

import java.util.concurrent.CountDownLatch;
import org.webrtc.EglRenderer;

/* JADX INFO: renamed from: h0.c.g */
/* JADX INFO: compiled from: lambda */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class RunnableC12462g implements Runnable {

    /* JADX INFO: renamed from: j */
    public final /* synthetic */ EglRenderer f26427j;

    /* JADX INFO: renamed from: k */
    public final /* synthetic */ CountDownLatch f26428k;

    /* JADX INFO: renamed from: l */
    public final /* synthetic */ EglRenderer.FrameListener f26429l;

    public /* synthetic */ RunnableC12462g(EglRenderer eglRenderer, CountDownLatch countDownLatch, EglRenderer.FrameListener frameListener) {
        this.f26427j = eglRenderer;
        this.f26428k = countDownLatch;
        this.f26429l = frameListener;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f26427j.m11024h(this.f26428k, this.f26429l);
    }
}

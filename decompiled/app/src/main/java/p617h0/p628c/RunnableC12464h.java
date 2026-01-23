package p617h0.p628c;

import java.util.concurrent.CountDownLatch;
import org.webrtc.EglRenderer;

/* JADX INFO: renamed from: h0.c.h */
/* JADX INFO: compiled from: lambda */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class RunnableC12464h implements Runnable {

    /* JADX INFO: renamed from: j */
    public final /* synthetic */ EglRenderer f26433j;

    /* JADX INFO: renamed from: k */
    public final /* synthetic */ CountDownLatch f26434k;

    public /* synthetic */ RunnableC12464h(EglRenderer eglRenderer, CountDownLatch countDownLatch) {
        this.f26433j = eglRenderer;
        this.f26434k = countDownLatch;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f26433j.m11021e(this.f26434k);
    }
}

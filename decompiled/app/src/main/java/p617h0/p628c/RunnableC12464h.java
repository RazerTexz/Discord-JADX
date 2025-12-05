package p617h0.p628c;

import java.util.concurrent.CountDownLatch;
import org.webrtc.EglRenderer;

/* compiled from: lambda */
/* renamed from: h0.c.h */
/* loaded from: classes3.dex */
public final /* synthetic */ class RunnableC12464h implements Runnable {

    /* renamed from: j */
    public final /* synthetic */ EglRenderer f26433j;

    /* renamed from: k */
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

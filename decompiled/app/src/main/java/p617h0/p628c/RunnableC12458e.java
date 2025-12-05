package p617h0.p628c;

import org.webrtc.EglRenderer;

/* compiled from: lambda */
/* renamed from: h0.c.e */
/* loaded from: classes3.dex */
public final /* synthetic */ class RunnableC12458e implements Runnable {

    /* renamed from: j */
    public final /* synthetic */ EglRenderer f26416j;

    /* renamed from: k */
    public final /* synthetic */ Runnable f26417k;

    public /* synthetic */ RunnableC12458e(EglRenderer eglRenderer, Runnable runnable) {
        this.f26416j = eglRenderer;
        this.f26417k = runnable;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f26416j.m11023g(this.f26417k);
    }
}

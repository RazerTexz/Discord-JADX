package p617h0.p628c;

import org.webrtc.EglRenderer;
import org.webrtc.RendererCommon;

/* JADX INFO: renamed from: h0.c.l */
/* JADX INFO: compiled from: lambda */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class RunnableC12472l implements Runnable {

    /* JADX INFO: renamed from: j */
    public final /* synthetic */ EglRenderer f26446j;

    /* JADX INFO: renamed from: k */
    public final /* synthetic */ RendererCommon.GlDrawer f26447k;

    /* JADX INFO: renamed from: l */
    public final /* synthetic */ EglRenderer.FrameListener f26448l;

    /* JADX INFO: renamed from: m */
    public final /* synthetic */ float f26449m;

    /* JADX INFO: renamed from: n */
    public final /* synthetic */ boolean f26450n;

    public /* synthetic */ RunnableC12472l(EglRenderer eglRenderer, RendererCommon.GlDrawer glDrawer, EglRenderer.FrameListener frameListener, float f, boolean z2) {
        this.f26446j = eglRenderer;
        this.f26447k = glDrawer;
        this.f26448l = frameListener;
        this.f26449m = f;
        this.f26450n = z2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f26446j.m11018a(this.f26447k, this.f26448l, this.f26449m, this.f26450n);
    }
}

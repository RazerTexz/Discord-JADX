package p617h0.p628c;

import org.webrtc.SurfaceViewRenderer;

/* JADX INFO: renamed from: h0.c.y */
/* JADX INFO: compiled from: lambda */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class RunnableC12495y implements Runnable {

    /* JADX INFO: renamed from: j */
    public final /* synthetic */ SurfaceViewRenderer f26469j;

    /* JADX INFO: renamed from: k */
    public final /* synthetic */ int f26470k;

    /* JADX INFO: renamed from: l */
    public final /* synthetic */ int f26471l;

    public /* synthetic */ RunnableC12495y(SurfaceViewRenderer surfaceViewRenderer, int i, int i2) {
        this.f26469j = surfaceViewRenderer;
        this.f26470k = i;
        this.f26471l = i2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f26469j.m11047a(this.f26470k, this.f26471l);
    }
}

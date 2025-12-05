package p617h0.p628c;

import org.webrtc.SurfaceViewRenderer;

/* compiled from: lambda */
/* renamed from: h0.c.y */
/* loaded from: classes3.dex */
public final /* synthetic */ class RunnableC12495y implements Runnable {

    /* renamed from: j */
    public final /* synthetic */ SurfaceViewRenderer f26469j;

    /* renamed from: k */
    public final /* synthetic */ int f26470k;

    /* renamed from: l */
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

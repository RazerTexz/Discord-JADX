package p617h0.p628c;

import org.webrtc.SurfaceTextureHelper;

/* compiled from: lambda */
/* renamed from: h0.c.t */
/* loaded from: classes3.dex */
public final /* synthetic */ class RunnableC12488t implements Runnable {

    /* renamed from: j */
    public final /* synthetic */ SurfaceTextureHelper f26459j;

    /* renamed from: k */
    public final /* synthetic */ int f26460k;

    /* renamed from: l */
    public final /* synthetic */ int f26461l;

    public /* synthetic */ RunnableC12488t(SurfaceTextureHelper surfaceTextureHelper, int i, int i2) {
        this.f26459j = surfaceTextureHelper;
        this.f26460k = i;
        this.f26461l = i2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f26459j.m11045f(this.f26460k, this.f26461l);
    }
}

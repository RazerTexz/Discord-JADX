package p617h0.p628c;

import org.webrtc.SurfaceTextureHelper;

/* JADX INFO: renamed from: h0.c.v */
/* JADX INFO: compiled from: lambda */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class RunnableC12492v implements Runnable {

    /* JADX INFO: renamed from: j */
    public final /* synthetic */ SurfaceTextureHelper f26465j;

    /* JADX INFO: renamed from: k */
    public final /* synthetic */ int f26466k;

    public /* synthetic */ RunnableC12492v(SurfaceTextureHelper surfaceTextureHelper, int i) {
        this.f26465j = surfaceTextureHelper;
        this.f26466k = i;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f26465j.m11044e(this.f26466k);
    }
}

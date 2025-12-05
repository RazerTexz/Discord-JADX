package p617h0.p628c;

import android.graphics.SurfaceTexture;
import org.webrtc.SurfaceTextureHelper;

/* compiled from: lambda */
/* renamed from: h0.c.r */
/* loaded from: classes3.dex */
public final /* synthetic */ class C12484r implements SurfaceTexture.OnFrameAvailableListener {

    /* renamed from: j */
    public final /* synthetic */ SurfaceTextureHelper f26457j;

    public /* synthetic */ C12484r(SurfaceTextureHelper surfaceTextureHelper) {
        this.f26457j = surfaceTextureHelper;
    }

    @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
    public final void onFrameAvailable(SurfaceTexture surfaceTexture) {
        this.f26457j.m11042c(surfaceTexture);
    }
}

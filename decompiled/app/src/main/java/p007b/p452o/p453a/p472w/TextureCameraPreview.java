package p007b.p452o.p453a.p472w;

import android.graphics.SurfaceTexture;
import android.view.TextureView;

/* JADX INFO: renamed from: b.o.a.w.i, reason: use source file name */
/* JADX INFO: compiled from: TextureCameraPreview.java */
/* JADX INFO: loaded from: classes3.dex */
public class TextureCameraPreview implements TextureView.SurfaceTextureListener {

    /* JADX INFO: renamed from: j */
    public final /* synthetic */ TextureCameraPreview2 f14241j;

    public TextureCameraPreview(TextureCameraPreview2 textureCameraPreview2) {
        this.f14241j = textureCameraPreview2;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        this.f14241j.m7426f(i, i2);
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        this.f14241j.m7427g();
        return true;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
        this.f14241j.m7428h(i, i2);
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }
}

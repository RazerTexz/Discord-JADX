package p007b.p225i.p226a.p242c.p260g3.p261z;

import android.graphics.SurfaceTexture;

/* JADX INFO: renamed from: b.i.a.c.g3.z.a */
/* JADX INFO: compiled from: lambda */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class C2789a implements SurfaceTexture.OnFrameAvailableListener {

    /* JADX INFO: renamed from: j */
    public final /* synthetic */ SceneRenderer f6959j;

    public /* synthetic */ C2789a(SceneRenderer sceneRenderer) {
        this.f6959j = sceneRenderer;
    }

    @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
    public final void onFrameAvailable(SurfaceTexture surfaceTexture) {
        this.f6959j.f7008j.set(true);
    }
}

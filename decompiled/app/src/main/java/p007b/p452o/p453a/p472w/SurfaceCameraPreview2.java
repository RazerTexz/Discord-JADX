package p007b.p452o.p453a.p472w;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import com.otaliastudios.cameraview.C11196R;
import p007b.p452o.p453a.CameraLogger;

/* compiled from: SurfaceCameraPreview.java */
/* renamed from: b.o.a.w.h, reason: use source file name */
/* loaded from: classes3.dex */
public class SurfaceCameraPreview2 extends CameraPreview<SurfaceView, SurfaceHolder> {

    /* renamed from: j */
    public static final CameraLogger f14238j = new CameraLogger(SurfaceCameraPreview2.class.getSimpleName());

    /* renamed from: k */
    public boolean f14239k;

    /* renamed from: l */
    public View f14240l;

    public SurfaceCameraPreview2(@NonNull Context context, @NonNull ViewGroup viewGroup) {
        super(context, viewGroup);
    }

    @Override // p007b.p452o.p453a.p472w.CameraPreview
    @NonNull
    /* renamed from: i */
    public SurfaceHolder mo7429i() {
        return ((SurfaceView) this.f14208c).getHolder();
    }

    @Override // p007b.p452o.p453a.p472w.CameraPreview
    @NonNull
    /* renamed from: j */
    public Class<SurfaceHolder> mo7430j() {
        return SurfaceHolder.class;
    }

    @Override // p007b.p452o.p453a.p472w.CameraPreview
    @NonNull
    /* renamed from: k */
    public View mo7431k() {
        return this.f14240l;
    }

    @Override // p007b.p452o.p453a.p472w.CameraPreview
    @NonNull
    /* renamed from: n */
    public View mo7434n(@NonNull Context context, @NonNull ViewGroup viewGroup) {
        View viewInflate = LayoutInflater.from(context).inflate(C11196R.b.cameraview_surface_view, viewGroup, false);
        viewGroup.addView(viewInflate, 0);
        SurfaceView surfaceView = (SurfaceView) viewInflate.findViewById(C11196R.a.surface_view);
        SurfaceHolder holder = surfaceView.getHolder();
        holder.setType(3);
        holder.addCallback(new SurfaceCameraPreview(this));
        this.f14240l = viewInflate;
        return surfaceView;
    }
}

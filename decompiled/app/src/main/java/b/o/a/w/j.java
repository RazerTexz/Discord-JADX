package b.o.a.w;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.SurfaceTexture;
import android.view.LayoutInflater;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import b.o.a.w.a;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.otaliastudios.cameraview.R;
import java.util.concurrent.ExecutionException;

/* compiled from: TextureCameraPreview.java */
/* loaded from: classes3.dex */
public class j extends b.o.a.w.a<TextureView, SurfaceTexture> {
    public View j;

    /* compiled from: TextureCameraPreview.java */
    public class a implements Runnable {
        public final /* synthetic */ a.b j;

        public a(a.b bVar) {
            this.j = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            int i;
            int i2;
            float fI;
            j jVar = j.this;
            if (jVar.h == 0 || jVar.g == 0 || (i = jVar.f) == 0 || (i2 = jVar.e) == 0) {
                a.b bVar = this.j;
                if (bVar != null) {
                    bVar.a();
                    return;
                }
                return;
            }
            b.o.a.x.a aVarF = b.o.a.x.a.f(i2, i);
            j jVar2 = j.this;
            b.o.a.x.a aVarF2 = b.o.a.x.a.f(jVar2.g, jVar2.h);
            float fI2 = 1.0f;
            if (aVarF.i() >= aVarF2.i()) {
                fI = aVarF.i() / aVarF2.i();
            } else {
                fI2 = aVarF2.i() / aVarF.i();
                fI = 1.0f;
            }
            ((TextureView) j.this.c).setScaleX(fI2);
            ((TextureView) j.this.c).setScaleY(fI);
            j.this.d = fI2 > 1.02f || fI > 1.02f;
            b.o.a.b bVar2 = b.o.a.w.a.a;
            bVar2.a(1, "crop:", "applied scaleX=", Float.valueOf(fI2));
            bVar2.a(1, "crop:", "applied scaleY=", Float.valueOf(fI));
            a.b bVar3 = this.j;
            if (bVar3 != null) {
                bVar3.a();
            }
        }
    }

    /* compiled from: TextureCameraPreview.java */
    public class b implements Runnable {
        public final /* synthetic */ int j;
        public final /* synthetic */ TaskCompletionSource k;

        public b(int i, TaskCompletionSource taskCompletionSource) {
            this.j = i;
            this.k = taskCompletionSource;
        }

        @Override // java.lang.Runnable
        public void run() {
            Matrix matrix = new Matrix();
            j jVar = j.this;
            int i = jVar.e;
            float f = i / 2.0f;
            int i2 = jVar.f;
            float f2 = i2 / 2.0f;
            if (this.j % 180 != 0) {
                float f3 = i2 / i;
                matrix.postScale(f3, 1.0f / f3, f, f2);
            }
            matrix.postRotate(this.j, f, f2);
            ((TextureView) j.this.c).setTransform(matrix);
            this.k.a.s(null);
        }
    }

    public j(@NonNull Context context, @NonNull ViewGroup viewGroup) {
        super(context, viewGroup);
    }

    @Override // b.o.a.w.a
    public void e(@Nullable a.b bVar) {
        ((TextureView) this.c).post(new a(null));
    }

    @Override // b.o.a.w.a
    @NonNull
    public SurfaceTexture i() {
        return ((TextureView) this.c).getSurfaceTexture();
    }

    @Override // b.o.a.w.a
    @NonNull
    public Class<SurfaceTexture> j() {
        return SurfaceTexture.class;
    }

    @Override // b.o.a.w.a
    @NonNull
    public View k() {
        return this.j;
    }

    @Override // b.o.a.w.a
    @NonNull
    public View n(@NonNull Context context, @NonNull ViewGroup viewGroup) {
        View viewInflate = LayoutInflater.from(context).inflate(R.b.cameraview_texture_view, viewGroup, false);
        viewGroup.addView(viewInflate, 0);
        TextureView textureView = (TextureView) viewInflate.findViewById(R.a.texture_view);
        textureView.setSurfaceTextureListener(new i(this));
        this.j = viewInflate;
        return textureView;
    }

    @Override // b.o.a.w.a
    public void r(int i) {
        this.i = i;
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        ((TextureView) this.c).post(new b(i, taskCompletionSource));
        try {
            b.i.a.f.e.o.f.j(taskCompletionSource.a);
        } catch (InterruptedException | ExecutionException unused) {
        }
    }

    @Override // b.o.a.w.a
    public boolean u() {
        return true;
    }
}

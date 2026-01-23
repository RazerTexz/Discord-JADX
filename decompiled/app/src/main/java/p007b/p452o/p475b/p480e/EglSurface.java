package p007b.p452o.p475b.p480e;

import android.graphics.Bitmap;
import android.opengl.EGL14;
import android.opengl.GLES20;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Objects;
import p007b.p452o.p475b.p476a.EglCore;
import p007b.p452o.p475b.p476a.Egloo;
import p007b.p452o.p475b.p478c.egl2;
import p007b.p452o.p475b.p478c.egl4;
import p007b.p452o.p475b.p478c.egl5;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: renamed from: b.o.b.e.a, reason: use source file name */
/* JADX INFO: compiled from: EglSurface.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class EglSurface {

    /* JADX INFO: renamed from: a */
    public EglCore f14327a;

    /* JADX INFO: renamed from: b */
    public egl5 f14328b;

    /* JADX INFO: renamed from: c */
    public int f14329c;

    /* JADX INFO: renamed from: d */
    public int f14330d;

    public EglSurface(EglCore eglCore, egl5 egl5Var) {
        Intrinsics3.checkNotNullParameter(eglCore, "eglCore");
        Intrinsics3.checkNotNullParameter(egl5Var, "eglSurface");
        Intrinsics3.checkNotNullParameter(eglCore, "eglCore");
        Intrinsics3.checkNotNullParameter(egl5Var, "eglSurface");
        this.f14327a = eglCore;
        this.f14328b = egl5Var;
        this.f14329c = -1;
        this.f14330d = -1;
    }

    /* JADX INFO: renamed from: a */
    public final void m7460a(OutputStream outputStream, Bitmap.CompressFormat compressFormat) {
        Intrinsics3.checkNotNullParameter(outputStream, "stream");
        Intrinsics3.checkNotNullParameter(compressFormat, "format");
        EglCore eglCore = this.f14327a;
        egl5 egl5Var = this.f14328b;
        Objects.requireNonNull(eglCore);
        Intrinsics3.checkNotNullParameter(egl5Var, "eglSurface");
        if (!(Intrinsics3.areEqual(eglCore.f14261b, new egl2(EGL14.eglGetCurrentContext())) && Intrinsics3.areEqual(egl5Var, new egl5(EGL14.eglGetCurrentSurface(egl4.f14278h))))) {
            throw new RuntimeException("Expected EGL context/surface is not current");
        }
        int iM7455a = this.f14329c;
        if (iM7455a < 0) {
            iM7455a = this.f14327a.m7455a(this.f14328b, egl4.f14276f);
        }
        int iM7455a2 = this.f14330d;
        if (iM7455a2 < 0) {
            iM7455a2 = this.f14327a.m7455a(this.f14328b, egl4.f14277g);
        }
        int i = iM7455a2;
        ByteBuffer byteBufferAllocateDirect = ByteBuffer.allocateDirect(iM7455a * i * 4);
        byteBufferAllocateDirect.order(ByteOrder.LITTLE_ENDIAN);
        GLES20.glReadPixels(0, 0, iM7455a, i, 6408, 5121, byteBufferAllocateDirect);
        Egloo.m7457b("glReadPixels");
        byteBufferAllocateDirect.rewind();
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(iM7455a, i, Bitmap.Config.ARGB_8888);
        bitmapCreateBitmap.copyPixelsFromBuffer(byteBufferAllocateDirect);
        bitmapCreateBitmap.compress(compressFormat, 90, outputStream);
        bitmapCreateBitmap.recycle();
    }
}

package p007b.p225i.p226a.p242c.p260g3.p261z;

import android.opengl.Matrix;
import p007b.p225i.p226a.p242c.p259f3.TimedValueQueue;

/* compiled from: FrameRotationQueue.java */
/* renamed from: b.i.a.c.g3.z.f, reason: use source file name */
/* loaded from: classes3.dex */
public final class FrameRotationQueue {

    /* renamed from: a */
    public final float[] f6968a = new float[16];

    /* renamed from: b */
    public final float[] f6969b = new float[16];

    /* renamed from: c */
    public final TimedValueQueue<float[]> f6970c = new TimedValueQueue<>();

    /* renamed from: d */
    public boolean f6971d;

    /* renamed from: a */
    public static void m3198a(float[] fArr, float[] fArr2) {
        Matrix.setIdentityM(fArr, 0);
        float fSqrt = (float) Math.sqrt((fArr2[8] * fArr2[8]) + (fArr2[10] * fArr2[10]));
        fArr[0] = fArr2[10] / fSqrt;
        fArr[2] = fArr2[8] / fSqrt;
        fArr[8] = (-fArr2[8]) / fSqrt;
        fArr[10] = fArr2[10] / fSqrt;
    }
}

package p007b.p452o.p475b.p479d;

import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: GlProgram.kt */
/* renamed from: b.o.b.d.a, reason: use source file name */
/* loaded from: classes3.dex */
public class GlProgram {

    /* renamed from: a */
    public final int f14306a;

    /* renamed from: b */
    public final boolean f14307b;

    /* renamed from: c */
    public final GlShader2[] f14308c;

    /* renamed from: d */
    public boolean f14309d;

    public GlProgram(int i, boolean z2, GlShader2... glShader2Arr) {
        Intrinsics3.checkNotNullParameter(glShader2Arr, "shaders");
        this.f14306a = i;
        this.f14307b = z2;
        this.f14308c = glShader2Arr;
    }
}

package p007b.p452o.p475b.p481f;

import android.opengl.GLES20;
import p007b.p452o.p475b.p476a.Egloo;
import p007b.p452o.p475b.p478c.gl;
import p507d0.UInt;
import p507d0.UIntArray;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: renamed from: b.o.b.f.b, reason: use source file name */
/* JADX INFO: compiled from: GlTexture.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class GlTexture2 {

    /* JADX INFO: renamed from: a */
    public final int f14331a;

    /* JADX INFO: renamed from: b */
    public final int f14332b;

    /* JADX INFO: renamed from: c */
    public final Integer f14333c;

    /* JADX INFO: renamed from: d */
    public final Integer f14334d;

    /* JADX INFO: renamed from: e */
    public final Integer f14335e;

    /* JADX INFO: renamed from: f */
    public final Integer f14336f;

    /* JADX INFO: renamed from: g */
    public final int f14337g;

    public GlTexture2(int i, int i2, Integer num) {
        int iIntValue;
        this.f14331a = i;
        this.f14332b = i2;
        this.f14333c = null;
        this.f14334d = null;
        this.f14335e = null;
        this.f14336f = null;
        if (num == null) {
            int[] iArrM11483constructorimpl = UIntArray.m11483constructorimpl(1);
            int iM11486getSizeimpl = UIntArray.m11486getSizeimpl(iArrM11483constructorimpl);
            int[] iArr = new int[iM11486getSizeimpl];
            for (int i3 = 0; i3 < iM11486getSizeimpl; i3++) {
                iArr[i3] = UIntArray.m11485getpVg5ArA(iArrM11483constructorimpl, i3);
            }
            GLES20.glGenTextures(1, iArr, 0);
            UIntArray.m11487setVXSXFK8(iArrM11483constructorimpl, 0, UInt.m11482constructorimpl(iArr[0]));
            Egloo.m7457b("glGenTextures");
            iIntValue = UIntArray.m11485getpVg5ArA(iArrM11483constructorimpl, 0);
        } else {
            iIntValue = num.intValue();
        }
        this.f14337g = iIntValue;
        if (num == null) {
            GlTexture glTexture = new GlTexture(this, null);
            Intrinsics3.checkNotNullParameter(this, "<this>");
            Intrinsics3.checkNotNullParameter(glTexture, "block");
            m7461a();
            glTexture.invoke();
            m7462b();
        }
    }

    /* JADX INFO: renamed from: a */
    public void m7461a() {
        GLES20.glActiveTexture(UInt.m11482constructorimpl(this.f14331a));
        GLES20.glBindTexture(UInt.m11482constructorimpl(this.f14332b), UInt.m11482constructorimpl(this.f14337g));
        Egloo.m7457b("bind");
    }

    /* JADX INFO: renamed from: b */
    public void m7462b() {
        GLES20.glBindTexture(UInt.m11482constructorimpl(this.f14332b), UInt.m11482constructorimpl(0));
        GLES20.glActiveTexture(gl.f14293c);
        Egloo.m7457b("unbind");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public GlTexture2(int i, int i2, Integer num, int i3) {
        this((i3 & 1) != 0 ? gl.f14293c : i, (i3 & 2) != 0 ? gl.f14294d : i2, null);
        int i4 = i3 & 4;
    }
}

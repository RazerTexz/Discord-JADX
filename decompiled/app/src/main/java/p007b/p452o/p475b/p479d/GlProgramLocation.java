package p007b.p452o.p475b.p479d;

import android.opengl.GLES20;
import android.util.Log;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p007b.p452o.p475b.p476a.Egloo;
import p507d0.UInt;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: GlProgramLocation.kt */
/* renamed from: b.o.b.d.b, reason: use source file name */
/* loaded from: classes3.dex */
public final class GlProgramLocation {

    /* renamed from: a */
    public final String f14310a;

    /* renamed from: b */
    public final int f14311b;

    /* renamed from: c */
    public final int f14312c;

    /* compiled from: GlProgramLocation.kt */
    /* renamed from: b.o.b.d.b$a */
    public enum a {
        ATTRIB,
        UNIFORM
    }

    public GlProgramLocation(int i, a aVar, String str, DefaultConstructorMarker defaultConstructorMarker) {
        int iGlGetAttribLocation;
        this.f14310a = str;
        int iOrdinal = aVar.ordinal();
        if (iOrdinal == 0) {
            iGlGetAttribLocation = GLES20.glGetAttribLocation(UInt.m11482constructorimpl(i), str);
        } else {
            if (iOrdinal != 1) {
                throw new NoWhenBranchMatchedException();
            }
            iGlGetAttribLocation = GLES20.glGetUniformLocation(UInt.m11482constructorimpl(i), str);
        }
        this.f14311b = iGlGetAttribLocation;
        float[] fArr = Egloo.f14263a;
        Intrinsics3.checkNotNullParameter(str, "label");
        if (iGlGetAttribLocation >= 0) {
            this.f14312c = UInt.m11482constructorimpl(iGlGetAttribLocation);
            return;
        }
        String str2 = "Unable to locate " + str + " in program";
        Log.e("Egloo", str2);
        throw new RuntimeException(str2);
    }
}

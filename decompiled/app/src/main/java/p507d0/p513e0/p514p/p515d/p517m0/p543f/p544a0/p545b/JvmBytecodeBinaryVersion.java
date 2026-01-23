package p507d0.p513e0.p514p.p515d.p517m0.p543f.p544a0.p545b;

import kotlin.jvm.internal.DefaultConstructorMarker;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.p547z.BinaryVersion;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: renamed from: d0.e0.p.d.m0.f.a0.b.c, reason: use source file name */
/* JADX INFO: compiled from: JvmBytecodeBinaryVersion.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class JvmBytecodeBinaryVersion extends BinaryVersion {

    /* JADX INFO: renamed from: f */
    public static final JvmBytecodeBinaryVersion f23703f;

    /* JADX INFO: renamed from: d0.e0.p.d.m0.f.a0.b.c$a */
    /* JADX INFO: compiled from: JvmBytecodeBinaryVersion.kt */
    public static final class a {
        public a(DefaultConstructorMarker defaultConstructorMarker) {
        }
    }

    static {
        new a(null);
        f23703f = new JvmBytecodeBinaryVersion(1, 0, 3);
        new JvmBytecodeBinaryVersion(new int[0]);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public JvmBytecodeBinaryVersion(int... iArr) {
        Intrinsics3.checkNotNullParameter(iArr, "numbers");
        int[] iArr2 = new int[iArr.length];
        System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
        super(iArr2);
    }
}

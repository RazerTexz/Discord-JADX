package p507d0.p513e0.p514p.p515d.p517m0.p543f.p544a0.p545b;

import kotlin.jvm.internal.DefaultConstructorMarker;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.p547z.BinaryVersion;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: JvmMetadataVersion.kt */
/* renamed from: d0.e0.p.d.m0.f.a0.b.f, reason: use source file name */
/* loaded from: classes3.dex */
public final class JvmMetadataVersion extends BinaryVersion {

    /* renamed from: f */
    public static final JvmMetadataVersion f23711f;

    /* renamed from: g */
    public final boolean f23712g;

    /* compiled from: JvmMetadataVersion.kt */
    /* renamed from: d0.e0.p.d.m0.f.a0.b.f$a */
    public static final class a {
        public a(DefaultConstructorMarker defaultConstructorMarker) {
        }
    }

    static {
        new a(null);
        f23711f = new JvmMetadataVersion(1, 4, 2);
        new JvmMetadataVersion(new int[0]);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public JvmMetadataVersion(int[] iArr, boolean z2) {
        Intrinsics3.checkNotNullParameter(iArr, "versionArray");
        int[] iArr2 = new int[iArr.length];
        System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
        super(iArr2);
        this.f23712g = z2;
    }

    public boolean isCompatible() {
        boolean zM9813a;
        if (getMajor() == 1 && getMinor() == 0) {
            return false;
        }
        if (this.f23712g) {
            zM9813a = m9813a(f23711f);
        } else {
            int major = getMajor();
            JvmMetadataVersion jvmMetadataVersion = f23711f;
            zM9813a = major == jvmMetadataVersion.getMajor() && getMinor() <= jvmMetadataVersion.getMinor() + 1;
        }
        return zM9813a;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public JvmMetadataVersion(int... iArr) {
        this(iArr, false);
        Intrinsics3.checkNotNullParameter(iArr, "numbers");
    }
}

package d0;

import java.util.Collection;

/* compiled from: UIntArray.kt */
/* loaded from: classes3.dex */
public final class q implements Collection<p>, d0.z.d.g0.a {
    /* renamed from: constructor-impl, reason: not valid java name */
    public static int[] m106constructorimpl(int i) {
        return m107constructorimpl(new int[i]);
    }

    /* renamed from: constructor-impl, reason: not valid java name */
    public static int[] m107constructorimpl(int[] iArr) {
        d0.z.d.m.checkNotNullParameter(iArr, "storage");
        return iArr;
    }

    /* renamed from: get-pVg5ArA, reason: not valid java name */
    public static final int m108getpVg5ArA(int[] iArr, int i) {
        return p.m105constructorimpl(iArr[i]);
    }

    /* renamed from: getSize-impl, reason: not valid java name */
    public static int m109getSizeimpl(int[] iArr) {
        return iArr.length;
    }

    /* renamed from: set-VXSXFK8, reason: not valid java name */
    public static final void m110setVXSXFK8(int[] iArr, int i, int i2) {
        iArr[i] = i2;
    }
}

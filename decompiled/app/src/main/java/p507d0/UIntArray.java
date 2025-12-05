package p507d0;

import java.util.Collection;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.p595g0.KMarkers;

/* compiled from: UIntArray.kt */
/* renamed from: d0.q, reason: use source file name */
/* loaded from: classes3.dex */
public final class UIntArray implements Collection<UInt>, KMarkers {
    /* renamed from: constructor-impl, reason: not valid java name */
    public static int[] m11483constructorimpl(int i) {
        return m11484constructorimpl(new int[i]);
    }

    /* renamed from: constructor-impl, reason: not valid java name */
    public static int[] m11484constructorimpl(int[] iArr) {
        Intrinsics3.checkNotNullParameter(iArr, "storage");
        return iArr;
    }

    /* renamed from: get-pVg5ArA, reason: not valid java name */
    public static final int m11485getpVg5ArA(int[] iArr, int i) {
        return UInt.m11482constructorimpl(iArr[i]);
    }

    /* renamed from: getSize-impl, reason: not valid java name */
    public static int m11486getSizeimpl(int[] iArr) {
        return iArr.length;
    }

    /* renamed from: set-VXSXFK8, reason: not valid java name */
    public static final void m11487setVXSXFK8(int[] iArr, int i, int i2) {
        iArr[i] = i2;
    }
}

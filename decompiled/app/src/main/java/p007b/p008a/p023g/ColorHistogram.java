package p007b.p008a.p023g;

import java.util.Arrays;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: ColorHistogram.kt */
/* renamed from: b.a.g.b, reason: use source file name */
/* loaded from: classes.dex */
public final class ColorHistogram {

    /* renamed from: a */
    public static final a f641a = new a(null);

    /* renamed from: b */
    public final int[] f642b;

    /* renamed from: c */
    public final int[] f643c;

    /* renamed from: d */
    public final int f644d;

    /* compiled from: ColorHistogram.kt */
    /* renamed from: b.a.g.b$a */
    public static final class a {
        public a(DefaultConstructorMarker defaultConstructorMarker) {
        }
    }

    public ColorHistogram(int[] iArr) {
        int length;
        Intrinsics3.checkNotNullParameter(iArr, "pixels");
        Arrays.sort(iArr);
        int i = 0;
        if (iArr.length < 2) {
            length = iArr.length;
        } else {
            int i2 = iArr[0];
            int length2 = iArr.length;
            int i3 = i2;
            length = 1;
            for (int i4 = 1; i4 < length2; i4++) {
                if (iArr[i4] != i3) {
                    i3 = iArr[i4];
                    length++;
                }
            }
        }
        this.f644d = length;
        int[] iArr2 = new int[length];
        this.f642b = iArr2;
        int[] iArr3 = new int[length];
        this.f643c = iArr3;
        if (iArr.length == 0) {
            return;
        }
        int i5 = iArr[0];
        iArr2[0] = i5;
        iArr3[0] = 1;
        if (iArr.length == 1) {
            return;
        }
        int length3 = iArr.length;
        for (int i6 = 1; i6 < length3; i6++) {
            if (iArr[i6] == i5) {
                int[] iArr4 = this.f643c;
                iArr4[i] = iArr4[i] + 1;
            } else {
                i5 = iArr[i6];
                i++;
                this.f642b[i] = i5;
                this.f643c[i] = 1;
            }
        }
    }
}

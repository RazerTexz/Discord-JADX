package p007b.p225i.p414e.p434s.p436c;

import java.util.ArrayList;
import java.util.List;
import p007b.p225i.p414e.ResultPointCallback;
import p007b.p225i.p414e.p418n.BitMatrix;

/* compiled from: AlignmentPatternFinder.java */
/* renamed from: b.i.e.s.c.b, reason: use source file name */
/* loaded from: classes3.dex */
public final class AlignmentPatternFinder {

    /* renamed from: a */
    public final BitMatrix f13559a;

    /* renamed from: c */
    public final int f13561c;

    /* renamed from: d */
    public final int f13562d;

    /* renamed from: e */
    public final int f13563e;

    /* renamed from: f */
    public final int f13564f;

    /* renamed from: g */
    public final float f13565g;

    /* renamed from: i */
    public final ResultPointCallback f13567i;

    /* renamed from: b */
    public final List<AlignmentPattern> f13560b = new ArrayList(5);

    /* renamed from: h */
    public final int[] f13566h = new int[3];

    public AlignmentPatternFinder(BitMatrix bitMatrix, int i, int i2, int i3, int i4, float f, ResultPointCallback resultPointCallback) {
        this.f13559a = bitMatrix;
        this.f13561c = i;
        this.f13562d = i2;
        this.f13563e = i3;
        this.f13564f = i4;
        this.f13565g = f;
        this.f13567i = resultPointCallback;
    }

    /* renamed from: a */
    public static float m7106a(int[] iArr, int i) {
        return (i - iArr[2]) - (iArr[1] / 2.0f);
    }

    /* renamed from: b */
    public final boolean m7107b(int[] iArr) {
        float f = this.f13565g;
        float f2 = f / 2.0f;
        for (int i = 0; i < 3; i++) {
            if (Math.abs(f - iArr[i]) >= f2) {
                return false;
            }
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:63:0x00fd  */
    /* renamed from: c */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final AlignmentPattern m7108c(int[] iArr, int i, int i2) {
        boolean z2;
        int i3 = iArr[0] + iArr[1] + iArr[2];
        float fM7106a = m7106a(iArr, i2);
        int i4 = (int) fM7106a;
        int i5 = iArr[1] * 2;
        BitMatrix bitMatrix = this.f13559a;
        int i6 = bitMatrix.f13230k;
        int[] iArr2 = this.f13566h;
        iArr2[0] = 0;
        iArr2[1] = 0;
        iArr2[2] = 0;
        int i7 = i;
        while (i7 >= 0 && bitMatrix.m6942f(i4, i7) && iArr2[1] <= i5) {
            iArr2[1] = iArr2[1] + 1;
            i7--;
        }
        float fM7106a2 = Float.NaN;
        if (i7 >= 0 && iArr2[1] <= i5) {
            while (i7 >= 0 && !bitMatrix.m6942f(i4, i7) && iArr2[0] <= i5) {
                iArr2[0] = iArr2[0] + 1;
                i7--;
            }
            if (iArr2[0] <= i5) {
                int i8 = i + 1;
                while (i8 < i6 && bitMatrix.m6942f(i4, i8) && iArr2[1] <= i5) {
                    iArr2[1] = iArr2[1] + 1;
                    i8++;
                }
                if (i8 != i6 && iArr2[1] <= i5) {
                    while (i8 < i6 && !bitMatrix.m6942f(i4, i8) && iArr2[2] <= i5) {
                        iArr2[2] = iArr2[2] + 1;
                        i8++;
                    }
                    if (iArr2[2] <= i5 && Math.abs(((iArr2[0] + iArr2[1]) + iArr2[2]) - i3) * 5 < i3 * 2 && m7107b(iArr2)) {
                        fM7106a2 = m7106a(iArr2, i8);
                    }
                }
            }
        }
        if (Float.isNaN(fM7106a2)) {
            return null;
        }
        float f = ((iArr[0] + iArr[1]) + iArr[2]) / 3.0f;
        for (AlignmentPattern alignmentPattern : this.f13560b) {
            if (Math.abs(fM7106a2 - alignmentPattern.f13208b) > f || Math.abs(fM7106a - alignmentPattern.f13207a) > f) {
                z2 = false;
            } else {
                float fAbs = Math.abs(f - alignmentPattern.f13558c);
                if (fAbs <= 1.0f || fAbs <= alignmentPattern.f13558c) {
                    z2 = true;
                }
            }
            if (z2) {
                return new AlignmentPattern((alignmentPattern.f13207a + fM7106a) / 2.0f, (alignmentPattern.f13208b + fM7106a2) / 2.0f, (alignmentPattern.f13558c + f) / 2.0f);
            }
        }
        AlignmentPattern alignmentPattern2 = new AlignmentPattern(fM7106a, fM7106a2, f);
        this.f13560b.add(alignmentPattern2);
        ResultPointCallback resultPointCallback = this.f13567i;
        if (resultPointCallback == null) {
            return null;
        }
        resultPointCallback.m6924a(alignmentPattern2);
        return null;
    }
}

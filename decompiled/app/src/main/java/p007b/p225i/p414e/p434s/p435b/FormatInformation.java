package p007b.p225i.p414e.p434s.p435b;

/* compiled from: FormatInformation.java */
/* renamed from: b.i.e.s.b.g, reason: use source file name */
/* loaded from: classes3.dex */
public final class FormatInformation {

    /* renamed from: a */
    public static final int[][] f13533a = {new int[]{21522, 0}, new int[]{20773, 1}, new int[]{24188, 2}, new int[]{23371, 3}, new int[]{17913, 4}, new int[]{16590, 5}, new int[]{20375, 6}, new int[]{19104, 7}, new int[]{30660, 8}, new int[]{29427, 9}, new int[]{32170, 10}, new int[]{30877, 11}, new int[]{26159, 12}, new int[]{25368, 13}, new int[]{27713, 14}, new int[]{26998, 15}, new int[]{5769, 16}, new int[]{5054, 17}, new int[]{7399, 18}, new int[]{6608, 19}, new int[]{1890, 20}, new int[]{597, 21}, new int[]{3340, 22}, new int[]{2107, 23}, new int[]{13663, 24}, new int[]{12392, 25}, new int[]{16177, 26}, new int[]{14854, 27}, new int[]{9396, 28}, new int[]{8579, 29}, new int[]{11994, 30}, new int[]{11245, 31}};

    /* renamed from: b */
    public final ErrorCorrectionLevel f13534b;

    /* renamed from: c */
    public final byte f13535c;

    public FormatInformation(int i) {
        int i2 = (i >> 3) & 3;
        if (i2 >= 0) {
            ErrorCorrectionLevel[] errorCorrectionLevelArr = ErrorCorrectionLevel.f13531n;
            if (i2 < errorCorrectionLevelArr.length) {
                this.f13534b = errorCorrectionLevelArr[i2];
                this.f13535c = (byte) (i & 7);
                return;
            }
        }
        throw new IllegalArgumentException();
    }

    /* renamed from: a */
    public static FormatInformation m7099a(int i, int i2) {
        int iM7100b;
        int i3 = Integer.MAX_VALUE;
        int i4 = 0;
        for (int[] iArr : f13533a) {
            int i5 = iArr[0];
            if (i5 == i || i5 == i2) {
                return new FormatInformation(iArr[1]);
            }
            int iM7100b2 = m7100b(i, i5);
            if (iM7100b2 < i3) {
                i4 = iArr[1];
                i3 = iM7100b2;
            }
            if (i != i2 && (iM7100b = m7100b(i2, i5)) < i3) {
                i4 = iArr[1];
                i3 = iM7100b;
            }
        }
        if (i3 <= 3) {
            return new FormatInformation(i4);
        }
        return null;
    }

    /* renamed from: b */
    public static int m7100b(int i, int i2) {
        return Integer.bitCount(i ^ i2);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof FormatInformation)) {
            return false;
        }
        FormatInformation formatInformation = (FormatInformation) obj;
        return this.f13534b == formatInformation.f13534b && this.f13535c == formatInformation.f13535c;
    }

    public int hashCode() {
        return (this.f13534b.ordinal() << 3) | this.f13535c;
    }
}

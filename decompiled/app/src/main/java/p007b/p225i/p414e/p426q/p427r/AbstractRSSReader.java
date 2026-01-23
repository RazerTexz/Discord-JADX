package p007b.p225i.p414e.p426q.p427r;

import com.google.zxing.NotFoundException;
import p007b.p225i.p414e.p426q.OneDReader;

/* JADX INFO: renamed from: b.i.e.q.r.a, reason: use source file name */
/* JADX INFO: compiled from: AbstractRSSReader.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractRSSReader extends OneDReader {

    /* JADX INFO: renamed from: b */
    public final int[] f13400b;

    /* JADX INFO: renamed from: e */
    public final int[] f13403e;

    /* JADX INFO: renamed from: f */
    public final int[] f13404f;

    /* JADX INFO: renamed from: a */
    public final int[] f13399a = new int[4];

    /* JADX INFO: renamed from: c */
    public final float[] f13401c = new float[4];

    /* JADX INFO: renamed from: d */
    public final float[] f13402d = new float[4];

    public AbstractRSSReader() {
        int[] iArr = new int[8];
        this.f13400b = iArr;
        this.f13403e = new int[iArr.length / 2];
        this.f13404f = new int[iArr.length / 2];
    }

    /* JADX INFO: renamed from: g */
    public static void m7009g(int[] iArr, float[] fArr) {
        int i = 0;
        float f = fArr[0];
        for (int i2 = 1; i2 < iArr.length; i2++) {
            if (fArr[i2] < f) {
                f = fArr[i2];
                i = i2;
            }
        }
        iArr[i] = iArr[i] - 1;
    }

    /* JADX INFO: renamed from: h */
    public static void m7010h(int[] iArr, float[] fArr) {
        int i = 0;
        float f = fArr[0];
        for (int i2 = 1; i2 < iArr.length; i2++) {
            if (fArr[i2] > f) {
                f = fArr[i2];
                i = i2;
            }
        }
        iArr[i] = iArr[i] + 1;
    }

    /* JADX INFO: renamed from: i */
    public static boolean m7011i(int[] iArr) {
        float f = (iArr[0] + iArr[1]) / ((iArr[2] + r1) + iArr[3]);
        if (f >= 0.7916667f && f <= 0.89285713f) {
            int i = Integer.MAX_VALUE;
            int i2 = Integer.MIN_VALUE;
            for (int i3 : iArr) {
                if (i3 > i2) {
                    i2 = i3;
                }
                if (i3 < i) {
                    i = i3;
                }
            }
            if (i2 < i * 10) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: renamed from: j */
    public static int m7012j(int[] iArr, int[][] iArr2) throws NotFoundException {
        for (int i = 0; i < iArr2.length; i++) {
            if (OneDReader.m6996d(iArr, iArr2[i], 0.45f) < 0.2f) {
                return i;
            }
        }
        throw NotFoundException.f21665l;
    }
}

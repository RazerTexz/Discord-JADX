package p007b.p225i.p414e.p430r.p431d;

import java.util.Formatter;
import p007b.p225i.p414e.ResultPoint;

/* JADX INFO: renamed from: b.i.e.r.d.f, reason: use source file name */
/* JADX INFO: compiled from: DetectionResult.java */
/* JADX INFO: loaded from: classes3.dex */
public final class DetectionResult {

    /* JADX INFO: renamed from: a */
    public final BarcodeMetadata f13487a;

    /* JADX INFO: renamed from: b */
    public final DetectionResultColumn[] f13488b;

    /* JADX INFO: renamed from: c */
    public BoundingBox f13489c;

    /* JADX INFO: renamed from: d */
    public final int f13490d;

    public DetectionResult(BarcodeMetadata barcodeMetadata, BoundingBox boundingBox) {
        this.f13487a = barcodeMetadata;
        int i = barcodeMetadata.f13464a;
        this.f13490d = i;
        this.f13489c = boundingBox;
        this.f13488b = new DetectionResultColumn[i + 2];
    }

    /* JADX INFO: renamed from: b */
    public static int m7055b(int i, int i2, Codeword codeword) {
        if (codeword.m7050a()) {
            return i2;
        }
        if (!(i != -1 && codeword.f13481c == (i % 3) * 3)) {
            return i2 + 1;
        }
        codeword.f13483e = i;
        return 0;
    }

    /* JADX INFO: renamed from: a */
    public final void m7056a(DetectionResultColumn detectionResultColumn) {
        int i;
        if (detectionResultColumn != null) {
            DetectionResultRowIndicatorColumn detectionResultRowIndicatorColumn = (DetectionResultRowIndicatorColumn) detectionResultColumn;
            BarcodeMetadata barcodeMetadata = this.f13487a;
            Codeword[] codewordArr = detectionResultRowIndicatorColumn.f13492b;
            for (Codeword codeword : codewordArr) {
                if (codeword != null) {
                    codeword.m7051b();
                }
            }
            detectionResultRowIndicatorColumn.m7060d(codewordArr, barcodeMetadata);
            BoundingBox boundingBox = detectionResultRowIndicatorColumn.f13491a;
            boolean z2 = detectionResultRowIndicatorColumn.f13493c;
            ResultPoint resultPoint = z2 ? boundingBox.f13471b : boundingBox.f13473d;
            ResultPoint resultPoint2 = z2 ? boundingBox.f13472c : boundingBox.f13474e;
            int iM7058b = detectionResultRowIndicatorColumn.m7058b((int) resultPoint.f13208b);
            int iM7058b2 = detectionResultRowIndicatorColumn.m7058b((int) resultPoint2.f13208b);
            int i2 = -1;
            int i3 = 0;
            int i4 = 1;
            while (iM7058b < iM7058b2) {
                if (codewordArr[iM7058b] != null) {
                    Codeword codeword2 = codewordArr[iM7058b];
                    int i5 = codeword2.f13483e;
                    int i6 = i5 - i2;
                    if (i6 == 0) {
                        i3++;
                    } else {
                        if (i6 == 1) {
                            int iMax = Math.max(i4, i3);
                            i = codeword2.f13483e;
                            i4 = iMax;
                        } else if (i6 < 0 || i5 >= barcodeMetadata.f13468e || i6 > iM7058b) {
                            codewordArr[iM7058b] = null;
                        } else {
                            if (i4 > 2) {
                                i6 *= i4 - 2;
                            }
                            boolean z3 = i6 >= iM7058b;
                            for (int i7 = 1; i7 <= i6 && !z3; i7++) {
                                z3 = codewordArr[iM7058b - i7] != null;
                            }
                            if (z3) {
                                codewordArr[iM7058b] = null;
                            } else {
                                i = codeword2.f13483e;
                            }
                        }
                        i2 = i;
                        i3 = 1;
                    }
                }
                iM7058b++;
            }
        }
    }

    public String toString() {
        DetectionResultColumn[] detectionResultColumnArr = this.f13488b;
        DetectionResultColumn detectionResultColumn = detectionResultColumnArr[0];
        if (detectionResultColumn == null) {
            detectionResultColumn = detectionResultColumnArr[this.f13490d + 1];
        }
        Formatter formatter = new Formatter();
        for (int i = 0; i < detectionResultColumn.f13492b.length; i++) {
            try {
                formatter.format("CW %3d:", Integer.valueOf(i));
                for (int i2 = 0; i2 < this.f13490d + 2; i2++) {
                    DetectionResultColumn[] detectionResultColumnArr2 = this.f13488b;
                    if (detectionResultColumnArr2[i2] == null) {
                        formatter.format("    |   ", new Object[0]);
                    } else {
                        Codeword codeword = detectionResultColumnArr2[i2].f13492b[i];
                        if (codeword == null) {
                            formatter.format("    |   ", new Object[0]);
                        } else {
                            formatter.format(" %3d|%3d", Integer.valueOf(codeword.f13483e), Integer.valueOf(codeword.f13482d));
                        }
                    }
                }
                formatter.format("%n", new Object[0]);
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    try {
                        formatter.close();
                    } catch (Throwable th3) {
                        th.addSuppressed(th3);
                    }
                    throw th2;
                }
            }
        }
        String string = formatter.toString();
        formatter.close();
        return string;
    }
}

package p007b.p225i.p414e.p430r.p431d;

import java.util.Formatter;

/* JADX INFO: renamed from: b.i.e.r.d.g, reason: use source file name */
/* JADX INFO: compiled from: DetectionResultColumn.java */
/* JADX INFO: loaded from: classes3.dex */
public class DetectionResultColumn {

    /* JADX INFO: renamed from: a */
    public final BoundingBox f13491a;

    /* JADX INFO: renamed from: b */
    public final Codeword[] f13492b;

    public DetectionResultColumn(BoundingBox boundingBox) {
        this.f13491a = new BoundingBox(boundingBox);
        this.f13492b = new Codeword[(boundingBox.f13478i - boundingBox.f13477h) + 1];
    }

    /* JADX INFO: renamed from: a */
    public final Codeword m7057a(int i) {
        Codeword codeword;
        Codeword codeword2;
        Codeword codeword3 = this.f13492b[i - this.f13491a.f13477h];
        if (codeword3 != null) {
            return codeword3;
        }
        for (int i2 = 1; i2 < 5; i2++) {
            int i3 = i - this.f13491a.f13477h;
            int i4 = i3 - i2;
            if (i4 >= 0 && (codeword2 = this.f13492b[i4]) != null) {
                return codeword2;
            }
            int i5 = i3 + i2;
            Codeword[] codewordArr = this.f13492b;
            if (i5 < codewordArr.length && (codeword = codewordArr[i5]) != null) {
                return codeword;
            }
        }
        return null;
    }

    /* JADX INFO: renamed from: b */
    public final int m7058b(int i) {
        return i - this.f13491a.f13477h;
    }

    public String toString() {
        Formatter formatter = new Formatter();
        try {
            int i = 0;
            for (Codeword codeword : this.f13492b) {
                if (codeword == null) {
                    formatter.format("%3d:    |   %n", Integer.valueOf(i));
                    i++;
                } else {
                    formatter.format("%3d: %3d|%3d%n", Integer.valueOf(i), Integer.valueOf(codeword.f13483e), Integer.valueOf(codeword.f13482d));
                    i++;
                }
            }
            String string = formatter.toString();
            formatter.close();
            return string;
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
}

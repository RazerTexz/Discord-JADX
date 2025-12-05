package p007b.p225i.p414e.p430r.p431d;

/* compiled from: DetectionResultRowIndicatorColumn.java */
/* renamed from: b.i.e.r.d.h, reason: use source file name */
/* loaded from: classes3.dex */
public final class DetectionResultRowIndicatorColumn extends DetectionResultColumn {

    /* renamed from: c */
    public final boolean f13493c;

    public DetectionResultRowIndicatorColumn(BoundingBox boundingBox, boolean z2) {
        super(boundingBox);
        this.f13493c = z2;
    }

    /* renamed from: c */
    public BarcodeMetadata m7059c() {
        Codeword[] codewordArr = this.f13492b;
        BarcodeValue barcodeValue = new BarcodeValue();
        BarcodeValue barcodeValue2 = new BarcodeValue();
        BarcodeValue barcodeValue3 = new BarcodeValue();
        BarcodeValue barcodeValue4 = new BarcodeValue();
        for (Codeword codeword : codewordArr) {
            if (codeword != null) {
                codeword.m7051b();
                int i = codeword.f13482d % 30;
                int i2 = codeword.f13483e;
                if (!this.f13493c) {
                    i2 += 2;
                }
                int i3 = i2 % 3;
                if (i3 == 0) {
                    barcodeValue2.m7049b((i * 3) + 1);
                } else if (i3 == 1) {
                    barcodeValue4.m7049b(i / 3);
                    barcodeValue3.m7049b(i % 3);
                } else if (i3 == 2) {
                    barcodeValue.m7049b(i + 1);
                }
            }
        }
        if (barcodeValue.m7048a().length == 0 || barcodeValue2.m7048a().length == 0 || barcodeValue3.m7048a().length == 0 || barcodeValue4.m7048a().length == 0 || barcodeValue.m7048a()[0] <= 0 || barcodeValue2.m7048a()[0] + barcodeValue3.m7048a()[0] < 3 || barcodeValue2.m7048a()[0] + barcodeValue3.m7048a()[0] > 90) {
            return null;
        }
        BarcodeMetadata barcodeMetadata = new BarcodeMetadata(barcodeValue.m7048a()[0], barcodeValue2.m7048a()[0], barcodeValue3.m7048a()[0], barcodeValue4.m7048a()[0]);
        m7060d(codewordArr, barcodeMetadata);
        return barcodeMetadata;
    }

    /* renamed from: d */
    public final void m7060d(Codeword[] codewordArr, BarcodeMetadata barcodeMetadata) {
        for (int i = 0; i < codewordArr.length; i++) {
            Codeword codeword = codewordArr[i];
            if (codewordArr[i] != null) {
                int i2 = codeword.f13482d % 30;
                int i3 = codeword.f13483e;
                if (i3 > barcodeMetadata.f13468e) {
                    codewordArr[i] = null;
                } else {
                    if (!this.f13493c) {
                        i3 += 2;
                    }
                    int i4 = i3 % 3;
                    if (i4 != 0) {
                        if (i4 != 1) {
                            if (i4 == 2 && i2 + 1 != barcodeMetadata.f13464a) {
                                codewordArr[i] = null;
                            }
                        } else if (i2 / 3 != barcodeMetadata.f13465b || i2 % 3 != barcodeMetadata.f13467d) {
                            codewordArr[i] = null;
                        }
                    } else if ((i2 * 3) + 1 != barcodeMetadata.f13466c) {
                        codewordArr[i] = null;
                    }
                }
            }
        }
    }

    @Override // p007b.p225i.p414e.p430r.p431d.DetectionResultColumn
    public String toString() {
        return "IsLeft: " + this.f13493c + '\n' + super.toString();
    }
}

package p007b.p225i.p414e;

/* JADX INFO: renamed from: b.i.e.e, reason: use source file name */
/* JADX INFO: compiled from: InvertedLuminanceSource.java */
/* JADX INFO: loaded from: classes3.dex */
public final class InvertedLuminanceSource extends LuminanceSource {

    /* JADX INFO: renamed from: c */
    public final LuminanceSource f13185c;

    public InvertedLuminanceSource(LuminanceSource luminanceSource) {
        super(luminanceSource.f13186a, luminanceSource.f13187b);
        this.f13185c = luminanceSource;
    }

    @Override // p007b.p225i.p414e.LuminanceSource
    /* JADX INFO: renamed from: a */
    public byte[] mo6915a() {
        byte[] bArrMo6915a = this.f13185c.mo6915a();
        int i = this.f13186a * this.f13187b;
        byte[] bArr = new byte[i];
        for (int i2 = 0; i2 < i; i2++) {
            bArr[i2] = (byte) (255 - (bArrMo6915a[i2] & 255));
        }
        return bArr;
    }

    @Override // p007b.p225i.p414e.LuminanceSource
    /* JADX INFO: renamed from: b */
    public byte[] mo6916b(int i, byte[] bArr) {
        byte[] bArrMo6916b = this.f13185c.mo6916b(i, bArr);
        int i2 = this.f13186a;
        for (int i3 = 0; i3 < i2; i3++) {
            bArrMo6916b[i3] = (byte) (255 - (bArrMo6916b[i3] & 255));
        }
        return bArrMo6916b;
    }

    @Override // p007b.p225i.p414e.LuminanceSource
    /* JADX INFO: renamed from: c */
    public boolean mo6917c() {
        return this.f13185c.mo6917c();
    }

    @Override // p007b.p225i.p414e.LuminanceSource
    /* JADX INFO: renamed from: d */
    public LuminanceSource mo6918d() {
        return new InvertedLuminanceSource(this.f13185c.mo6918d());
    }
}

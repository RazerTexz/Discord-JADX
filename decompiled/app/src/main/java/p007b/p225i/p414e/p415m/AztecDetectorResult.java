package p007b.p225i.p414e.p415m;

import p007b.p225i.p414e.ResultPoint;
import p007b.p225i.p414e.p418n.BitMatrix;
import p007b.p225i.p414e.p418n.DetectorResult;

/* JADX INFO: renamed from: b.i.e.m.a, reason: use source file name */
/* JADX INFO: compiled from: AztecDetectorResult.java */
/* JADX INFO: loaded from: classes3.dex */
public final class AztecDetectorResult extends DetectorResult {

    /* JADX INFO: renamed from: c */
    public final boolean f13209c;

    /* JADX INFO: renamed from: d */
    public final int f13210d;

    /* JADX INFO: renamed from: e */
    public final int f13211e;

    public AztecDetectorResult(BitMatrix bitMatrix, ResultPoint[] resultPointArr, boolean z2, int i, int i2) {
        super(bitMatrix, resultPointArr);
        this.f13209c = z2;
        this.f13210d = i;
        this.f13211e = i2;
    }
}

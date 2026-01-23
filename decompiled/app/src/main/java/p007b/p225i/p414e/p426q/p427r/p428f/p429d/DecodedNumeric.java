package p007b.p225i.p414e.p426q.p427r.p428f.p429d;

import com.google.zxing.FormatException;

/* JADX INFO: renamed from: b.i.e.q.r.f.d.p, reason: use source file name */
/* JADX INFO: compiled from: DecodedNumeric.java */
/* JADX INFO: loaded from: classes3.dex */
public final class DecodedNumeric extends DecodedObject {

    /* JADX INFO: renamed from: b */
    public final int f13449b;

    /* JADX INFO: renamed from: c */
    public final int f13450c;

    public DecodedNumeric(int i, int i2, int i3) throws FormatException {
        super(i);
        if (i2 < 0 || i2 > 10 || i3 < 0 || i3 > 10) {
            throw FormatException.m9260a();
        }
        this.f13449b = i2;
        this.f13450c = i3;
    }
}

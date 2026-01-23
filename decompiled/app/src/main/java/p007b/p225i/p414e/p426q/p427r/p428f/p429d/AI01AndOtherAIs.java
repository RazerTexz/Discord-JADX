package p007b.p225i.p414e.p426q.p427r.p428f.p429d;

import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import p007b.p100d.p104b.p105a.outline;
import p007b.p225i.p414e.p418n.BitArray;

/* JADX INFO: renamed from: b.i.e.q.r.f.d.g, reason: use source file name */
/* JADX INFO: compiled from: AI01AndOtherAIs.java */
/* JADX INFO: loaded from: classes3.dex */
public final class AI01AndOtherAIs extends AI01decoder {
    public AI01AndOtherAIs(BitArray bitArray) {
        super(bitArray);
    }

    @Override // p007b.p225i.p414e.p426q.p427r.p428f.p429d.AbstractExpandedDecoder
    /* JADX INFO: renamed from: a */
    public String mo7030a() throws NotFoundException, FormatException {
        StringBuilder sbM833U = outline.m833U("(01)");
        int length = sbM833U.length();
        sbM833U.append(this.f13440b.m7041c(4, 4));
        m7032c(sbM833U, 8, length);
        return this.f13440b.m7039a(sbM833U, 48);
    }
}

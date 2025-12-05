package p007b.p225i.p414e.p426q.p427r.p428f.p429d;

import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import p007b.p225i.p414e.p418n.BitArray;

/* compiled from: AI01393xDecoder.java */
/* renamed from: b.i.e.q.r.f.d.d, reason: use source file name */
/* loaded from: classes3.dex */
public final class AI01393xDecoder extends AI01decoder {
    public AI01393xDecoder(BitArray bitArray) {
        super(bitArray);
    }

    @Override // p007b.p225i.p414e.p426q.p427r.p428f.p429d.AbstractExpandedDecoder
    /* renamed from: a */
    public String mo7030a() throws NotFoundException, FormatException {
        if (this.f13439a.f13228k < 48) {
            throw NotFoundException.f21665l;
        }
        StringBuilder sb = new StringBuilder();
        m7031b(sb, 8);
        int iM7041c = this.f13440b.m7041c(48, 2);
        sb.append("(393");
        sb.append(iM7041c);
        sb.append(')');
        int iM7041c2 = this.f13440b.m7041c(50, 10);
        if (iM7041c2 / 100 == 0) {
            sb.append('0');
        }
        if (iM7041c2 / 10 == 0) {
            sb.append('0');
        }
        sb.append(iM7041c2);
        sb.append(this.f13440b.m7040b(60, null).f13446b);
        return sb.toString();
    }
}

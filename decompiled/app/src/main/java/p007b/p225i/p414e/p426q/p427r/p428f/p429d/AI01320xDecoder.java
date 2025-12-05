package p007b.p225i.p414e.p426q.p427r.p428f.p429d;

import p007b.p225i.p414e.p418n.BitArray;

/* compiled from: AI01320xDecoder.java */
/* renamed from: b.i.e.q.r.f.d.b, reason: use source file name */
/* loaded from: classes3.dex */
public final class AI01320xDecoder extends AI013x0xDecoder {
    public AI01320xDecoder(BitArray bitArray) {
        super(bitArray);
    }

    @Override // p007b.p225i.p414e.p426q.p427r.p428f.p429d.AI01weightDecoder
    /* renamed from: d */
    public void mo7028d(StringBuilder sb, int i) {
        if (i < 10000) {
            sb.append("(3202)");
        } else {
            sb.append("(3203)");
        }
    }

    @Override // p007b.p225i.p414e.p426q.p427r.p428f.p429d.AI01weightDecoder
    /* renamed from: e */
    public int mo7029e(int i) {
        return i < 10000 ? i : i - 10000;
    }
}

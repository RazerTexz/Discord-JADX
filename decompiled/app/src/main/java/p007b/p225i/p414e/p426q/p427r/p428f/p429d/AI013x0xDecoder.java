package p007b.p225i.p414e.p426q.p427r.p428f.p429d;

import com.google.zxing.NotFoundException;
import p007b.p225i.p414e.p418n.BitArray;

/* JADX INFO: renamed from: b.i.e.q.r.f.d.f, reason: use source file name */
/* JADX INFO: compiled from: AI013x0xDecoder.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AI013x0xDecoder extends AI01weightDecoder {
    public AI013x0xDecoder(BitArray bitArray) {
        super(bitArray);
    }

    @Override // p007b.p225i.p414e.p426q.p427r.p428f.p429d.AbstractExpandedDecoder
    /* JADX INFO: renamed from: a */
    public String mo7030a() throws NotFoundException {
        if (this.f13439a.f13228k != 60) {
            throw NotFoundException.f21665l;
        }
        StringBuilder sb = new StringBuilder();
        m7031b(sb, 5);
        m7033f(sb, 45, 15);
        return sb.toString();
    }
}

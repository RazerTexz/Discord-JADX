package p007b.p225i.p414e.p426q.p427r.p428f.p429d;

import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import p007b.p225i.p414e.p418n.BitArray;

/* JADX INFO: renamed from: b.i.e.q.r.f.d.j, reason: use source file name */
/* JADX INFO: compiled from: AbstractExpandedDecoder.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractExpandedDecoder {

    /* JADX INFO: renamed from: a */
    public final BitArray f13439a;

    /* JADX INFO: renamed from: b */
    public final GeneralAppIdDecoder f13440b;

    public AbstractExpandedDecoder(BitArray bitArray) {
        this.f13439a = bitArray;
        this.f13440b = new GeneralAppIdDecoder(bitArray);
    }

    /* JADX INFO: renamed from: a */
    public abstract String mo7030a() throws NotFoundException, FormatException;
}

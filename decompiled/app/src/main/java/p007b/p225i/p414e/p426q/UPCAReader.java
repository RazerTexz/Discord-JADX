package p007b.p225i.p414e.p426q;

import com.google.zxing.ChecksumException;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import java.util.Map;
import p007b.p225i.p414e.BarcodeFormat;
import p007b.p225i.p414e.BinaryBitmap;
import p007b.p225i.p414e.DecodeHintType;
import p007b.p225i.p414e.ResultMetadataType;
import p007b.p225i.p414e.p418n.BitArray;

/* JADX INFO: renamed from: b.i.e.q.l, reason: use source file name */
/* JADX INFO: compiled from: UPCAReader.java */
/* JADX INFO: loaded from: classes3.dex */
public final class UPCAReader extends UPCEANReader {

    /* JADX INFO: renamed from: h */
    public final UPCEANReader f13380h = new EAN13Reader();

    /* JADX INFO: renamed from: o */
    public static Result m7000o(Result result) throws FormatException {
        String str = result.f21668a;
        if (str.charAt(0) != '0') {
            throw FormatException.m9260a();
        }
        Result result2 = new Result(str.substring(1), null, result.f21670c, BarcodeFormat.UPC_A);
        Map<ResultMetadataType, Object> map = result.f21672e;
        if (map != null) {
            result2.m9261a(map);
        }
        return result2;
    }

    @Override // p007b.p225i.p414e.p426q.OneDReader, p007b.p225i.p414e.Reader
    /* JADX INFO: renamed from: a */
    public Result mo6919a(BinaryBitmap binaryBitmap, Map<DecodeHintType, ?> map) throws NotFoundException, FormatException {
        return m7000o(this.f13380h.mo6919a(binaryBitmap, map));
    }

    @Override // p007b.p225i.p414e.p426q.UPCEANReader, p007b.p225i.p414e.p426q.OneDReader
    /* JADX INFO: renamed from: b */
    public Result mo6983b(int i, BitArray bitArray, Map<DecodeHintType, ?> map) throws NotFoundException, ChecksumException, FormatException {
        return m7000o(this.f13380h.mo6983b(i, bitArray, map));
    }

    @Override // p007b.p225i.p414e.p426q.UPCEANReader
    /* JADX INFO: renamed from: j */
    public int mo6989j(BitArray bitArray, int[] iArr, StringBuilder sb) throws NotFoundException {
        return this.f13380h.mo6989j(bitArray, iArr, sb);
    }

    @Override // p007b.p225i.p414e.p426q.UPCEANReader
    /* JADX INFO: renamed from: k */
    public Result mo7001k(int i, BitArray bitArray, int[] iArr, Map<DecodeHintType, ?> map) throws NotFoundException, ChecksumException, FormatException {
        return m7000o(this.f13380h.mo7001k(i, bitArray, iArr, map));
    }

    @Override // p007b.p225i.p414e.p426q.UPCEANReader
    /* JADX INFO: renamed from: n */
    public BarcodeFormat mo6990n() {
        return BarcodeFormat.UPC_A;
    }
}

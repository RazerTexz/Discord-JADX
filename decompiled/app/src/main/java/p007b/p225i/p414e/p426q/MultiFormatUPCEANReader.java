package p007b.p225i.p414e.p426q;

import com.google.zxing.NotFoundException;
import com.google.zxing.ReaderException;
import com.google.zxing.Result;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import java.util.Objects;
import p007b.p225i.p414e.BarcodeFormat;
import p007b.p225i.p414e.DecodeHintType;
import p007b.p225i.p414e.p418n.BitArray;

/* compiled from: MultiFormatUPCEANReader.java */
/* renamed from: b.i.e.q.j, reason: use source file name */
/* loaded from: classes3.dex */
public final class MultiFormatUPCEANReader extends OneDReader {

    /* renamed from: a */
    public final UPCEANReader[] f13379a;

    public MultiFormatUPCEANReader(Map<DecodeHintType, ?> map) {
        Collection collection = map == null ? null : (Collection) map.get(DecodeHintType.POSSIBLE_FORMATS);
        ArrayList arrayList = new ArrayList();
        if (collection != null) {
            if (collection.contains(BarcodeFormat.EAN_13)) {
                arrayList.add(new EAN13Reader());
            } else if (collection.contains(BarcodeFormat.UPC_A)) {
                arrayList.add(new UPCAReader());
            }
            if (collection.contains(BarcodeFormat.EAN_8)) {
                arrayList.add(new EAN8Reader());
            }
            if (collection.contains(BarcodeFormat.UPC_E)) {
                arrayList.add(new UPCEReader());
            }
        }
        if (arrayList.isEmpty()) {
            arrayList.add(new EAN13Reader());
            arrayList.add(new EAN8Reader());
            arrayList.add(new UPCEReader());
        }
        this.f13379a = (UPCEANReader[]) arrayList.toArray(new UPCEANReader[arrayList.size()]);
    }

    @Override // p007b.p225i.p414e.p426q.OneDReader
    /* renamed from: b */
    public Result mo6983b(int i, BitArray bitArray, Map<DecodeHintType, ?> map) throws NotFoundException, NumberFormatException {
        BarcodeFormat barcodeFormat = BarcodeFormat.UPC_A;
        int[] iArrM7006m = UPCEANReader.m7006m(bitArray);
        for (UPCEANReader uPCEANReader : this.f13379a) {
            try {
                Result resultMo7001k = uPCEANReader.mo7001k(i, bitArray, iArrM7006m, map);
                boolean z2 = resultMo7001k.f21671d == BarcodeFormat.EAN_13 && resultMo7001k.f21668a.charAt(0) == '0';
                Collection collection = map == null ? null : (Collection) map.get(DecodeHintType.POSSIBLE_FORMATS);
                boolean z3 = collection == null || collection.contains(barcodeFormat);
                if (!z2 || !z3) {
                    return resultMo7001k;
                }
                Result result = new Result(resultMo7001k.f21668a.substring(1), resultMo7001k.f21669b, resultMo7001k.f21670c, barcodeFormat);
                result.m9261a(resultMo7001k.f21672e);
                return result;
            } catch (ReaderException unused) {
            }
        }
        throw NotFoundException.f21665l;
    }

    @Override // p007b.p225i.p414e.p426q.OneDReader, p007b.p225i.p414e.Reader
    public void reset() {
        for (UPCEANReader uPCEANReader : this.f13379a) {
            Objects.requireNonNull(uPCEANReader);
        }
    }
}

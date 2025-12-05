package p007b.p225i.p414e;

import com.google.zxing.NotFoundException;
import com.google.zxing.ReaderException;
import com.google.zxing.Result;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import p007b.p225i.p414e.p415m.AztecReader;
import p007b.p225i.p414e.p421o.DataMatrixReader;
import p007b.p225i.p414e.p424p.MaxiCodeReader;
import p007b.p225i.p414e.p426q.MultiFormatOneDReader;
import p007b.p225i.p414e.p430r.PDF417Reader;
import p007b.p225i.p414e.p434s.QRCodeReader;

/* compiled from: MultiFormatReader.java */
/* renamed from: b.i.e.g, reason: use source file name */
/* loaded from: classes3.dex */
public final class MultiFormatReader implements Reader {

    /* renamed from: a */
    public Map<DecodeHintType, ?> f13188a;

    /* renamed from: b */
    public Reader[] f13189b;

    @Override // p007b.p225i.p414e.Reader
    /* renamed from: a */
    public Result mo6919a(BinaryBitmap binaryBitmap, Map<DecodeHintType, ?> map) throws NotFoundException {
        m6921c(map);
        return m6920b(binaryBitmap);
    }

    /* renamed from: b */
    public final Result m6920b(BinaryBitmap binaryBitmap) throws NotFoundException {
        Reader[] readerArr = this.f13189b;
        if (readerArr != null) {
            for (Reader reader : readerArr) {
                try {
                    return reader.mo6919a(binaryBitmap, this.f13188a);
                } catch (ReaderException unused) {
                }
            }
        }
        throw NotFoundException.f21665l;
    }

    /* renamed from: c */
    public void m6921c(Map<DecodeHintType, ?> map) {
        this.f13188a = map;
        boolean z2 = map != null && map.containsKey(DecodeHintType.TRY_HARDER);
        Collection collection = map == null ? null : (Collection) map.get(DecodeHintType.POSSIBLE_FORMATS);
        ArrayList arrayList = new ArrayList();
        if (collection != null) {
            boolean z3 = collection.contains(BarcodeFormat.UPC_A) || collection.contains(BarcodeFormat.UPC_E) || collection.contains(BarcodeFormat.EAN_13) || collection.contains(BarcodeFormat.EAN_8) || collection.contains(BarcodeFormat.CODABAR) || collection.contains(BarcodeFormat.CODE_39) || collection.contains(BarcodeFormat.CODE_93) || collection.contains(BarcodeFormat.CODE_128) || collection.contains(BarcodeFormat.ITF) || collection.contains(BarcodeFormat.RSS_14) || collection.contains(BarcodeFormat.RSS_EXPANDED);
            if (z3 && !z2) {
                arrayList.add(new MultiFormatOneDReader(map));
            }
            if (collection.contains(BarcodeFormat.QR_CODE)) {
                arrayList.add(new QRCodeReader());
            }
            if (collection.contains(BarcodeFormat.DATA_MATRIX)) {
                arrayList.add(new DataMatrixReader());
            }
            if (collection.contains(BarcodeFormat.AZTEC)) {
                arrayList.add(new AztecReader());
            }
            if (collection.contains(BarcodeFormat.PDF_417)) {
                arrayList.add(new PDF417Reader());
            }
            if (collection.contains(BarcodeFormat.MAXICODE)) {
                arrayList.add(new MaxiCodeReader());
            }
            if (z3 && z2) {
                arrayList.add(new MultiFormatOneDReader(map));
            }
        }
        if (arrayList.isEmpty()) {
            if (!z2) {
                arrayList.add(new MultiFormatOneDReader(map));
            }
            arrayList.add(new QRCodeReader());
            arrayList.add(new DataMatrixReader());
            arrayList.add(new AztecReader());
            arrayList.add(new PDF417Reader());
            arrayList.add(new MaxiCodeReader());
            if (z2) {
                arrayList.add(new MultiFormatOneDReader(map));
            }
        }
        this.f13189b = (Reader[]) arrayList.toArray(new Reader[arrayList.size()]);
    }

    @Override // p007b.p225i.p414e.Reader
    public void reset() {
        Reader[] readerArr = this.f13189b;
        if (readerArr != null) {
            for (Reader reader : readerArr) {
                reader.reset();
            }
        }
    }
}

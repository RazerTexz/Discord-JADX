package p007b.p225i.p414e.p415m;

import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import java.util.List;
import java.util.Map;
import p007b.p225i.p414e.BarcodeFormat;
import p007b.p225i.p414e.BinaryBitmap;
import p007b.p225i.p414e.DecodeHintType;
import p007b.p225i.p414e.Reader;
import p007b.p225i.p414e.ResultMetadataType;
import p007b.p225i.p414e.ResultPoint;
import p007b.p225i.p414e.ResultPointCallback;
import p007b.p225i.p414e.p415m.p416c.Decoder2;
import p007b.p225i.p414e.p415m.p417d.Detector;
import p007b.p225i.p414e.p418n.DecoderResult;

/* JADX INFO: renamed from: b.i.e.m.b, reason: use source file name */
/* JADX INFO: compiled from: AztecReader.java */
/* JADX INFO: loaded from: classes3.dex */
public final class AztecReader implements Reader {
    @Override // p007b.p225i.p414e.Reader
    /* JADX INFO: renamed from: a */
    public Result mo6919a(BinaryBitmap binaryBitmap, Map<DecodeHintType, ?> map) throws NotFoundException, FormatException {
        ResultPoint[] resultPointArr;
        ResultPoint[] resultPointArr2;
        FormatException formatException;
        ResultPointCallback resultPointCallback;
        AztecDetectorResult aztecDetectorResultM6928a;
        Detector detector = new Detector(binaryBitmap.m6913a());
        DecoderResult decoderResultM6926a = null;
        try {
            aztecDetectorResultM6928a = detector.m6928a(false);
            resultPointArr = aztecDetectorResultM6928a.f13276b;
        } catch (FormatException e) {
            e = e;
            resultPointArr = null;
        } catch (NotFoundException e2) {
            e = e2;
            resultPointArr = null;
        }
        try {
            resultPointArr2 = resultPointArr;
            formatException = null;
            decoderResultM6926a = new Decoder2().m6926a(aztecDetectorResultM6928a);
            e = null;
        } catch (FormatException e3) {
            e = e3;
            resultPointArr2 = resultPointArr;
            formatException = e;
            e = null;
        } catch (NotFoundException e4) {
            e = e4;
            resultPointArr2 = resultPointArr;
            formatException = null;
        }
        if (decoderResultM6926a == null) {
            try {
                AztecDetectorResult aztecDetectorResultM6928a2 = detector.m6928a(true);
                resultPointArr2 = aztecDetectorResultM6928a2.f13276b;
                decoderResultM6926a = new Decoder2().m6926a(aztecDetectorResultM6928a2);
            } catch (FormatException | NotFoundException e5) {
                if (e != null) {
                    throw e;
                }
                if (formatException != null) {
                    throw formatException;
                }
                throw e5;
            }
        }
        ResultPoint[] resultPointArr3 = resultPointArr2;
        if (map != null && (resultPointCallback = (ResultPointCallback) map.get(DecodeHintType.NEED_RESULT_POINT_CALLBACK)) != null) {
            for (ResultPoint resultPoint : resultPointArr3) {
                resultPointCallback.m6924a(resultPoint);
            }
        }
        Result result = new Result(decoderResultM6926a.f13268c, decoderResultM6926a.f13266a, decoderResultM6926a.f13267b, resultPointArr3, BarcodeFormat.AZTEC, System.currentTimeMillis());
        List<byte[]> list = decoderResultM6926a.f13269d;
        if (list != null) {
            result.m9262b(ResultMetadataType.BYTE_SEGMENTS, list);
        }
        String str = decoderResultM6926a.f13270e;
        if (str != null) {
            result.m9262b(ResultMetadataType.ERROR_CORRECTION_LEVEL, str);
        }
        return result;
    }

    @Override // p007b.p225i.p414e.Reader
    public void reset() {
    }
}

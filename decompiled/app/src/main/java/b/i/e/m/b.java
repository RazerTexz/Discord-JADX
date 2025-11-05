package b.i.e.m;

import b.i.e.c;
import b.i.e.d;
import b.i.e.i;
import b.i.e.j;
import b.i.e.k;
import b.i.e.l;
import b.i.e.n.e;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import java.util.List;
import java.util.Map;

/* compiled from: AztecReader.java */
/* loaded from: classes3.dex */
public final class b implements i {
    /* JADX WARN: Removed duplicated region for block: B:17:0x002f  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x005a A[LOOP:0: B:33:0x0058->B:34:0x005a, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0078  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0081  */
    @Override // b.i.e.i
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Result a(c cVar, Map<d, ?> map) throws NotFoundException, FormatException {
        k[] kVarArr;
        k[] kVarArr2;
        FormatException formatException;
        k[] kVarArr3;
        List<byte[]> list;
        String str;
        l lVar;
        a aVarA;
        b.i.e.m.d.a aVar = new b.i.e.m.d.a(cVar.a());
        e eVarA = null;
        try {
            aVarA = aVar.a(false);
            kVarArr = aVarA.f1836b;
        } catch (FormatException e) {
            e = e;
            kVarArr = null;
        } catch (NotFoundException e2) {
            e = e2;
            kVarArr = null;
        }
        try {
            kVarArr2 = kVarArr;
            formatException = null;
            eVarA = new b.i.e.m.c.a().a(aVarA);
            e = null;
        } catch (FormatException e3) {
            e = e3;
            kVarArr2 = kVarArr;
            formatException = e;
            e = null;
            if (eVarA == null) {
            }
            kVarArr3 = kVarArr2;
            if (map != null) {
                while (i < r0) {
                }
            }
            Result result = new Result(eVarA.c, eVarA.a, eVarA.f1835b, kVarArr3, b.i.e.a.AZTEC, System.currentTimeMillis());
            list = eVarA.d;
            if (list != null) {
            }
            str = eVarA.e;
            if (str != null) {
            }
            return result;
        } catch (NotFoundException e4) {
            e = e4;
            kVarArr2 = kVarArr;
            formatException = null;
            if (eVarA == null) {
            }
            kVarArr3 = kVarArr2;
            if (map != null) {
            }
            Result result2 = new Result(eVarA.c, eVarA.a, eVarA.f1835b, kVarArr3, b.i.e.a.AZTEC, System.currentTimeMillis());
            list = eVarA.d;
            if (list != null) {
            }
            str = eVarA.e;
            if (str != null) {
            }
            return result2;
        }
        if (eVarA == null) {
            try {
                a aVarA2 = aVar.a(true);
                kVarArr2 = aVarA2.f1836b;
                eVarA = new b.i.e.m.c.a().a(aVarA2);
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
        kVarArr3 = kVarArr2;
        if (map != null && (lVar = (l) map.get(d.NEED_RESULT_POINT_CALLBACK)) != null) {
            for (k kVar : kVarArr3) {
                lVar.a(kVar);
            }
        }
        Result result22 = new Result(eVarA.c, eVarA.a, eVarA.f1835b, kVarArr3, b.i.e.a.AZTEC, System.currentTimeMillis());
        list = eVarA.d;
        if (list != null) {
            result22.b(j.BYTE_SEGMENTS, list);
        }
        str = eVarA.e;
        if (str != null) {
            result22.b(j.ERROR_CORRECTION_LEVEL, str);
        }
        return result22;
    }

    @Override // b.i.e.i
    public void reset() {
    }
}

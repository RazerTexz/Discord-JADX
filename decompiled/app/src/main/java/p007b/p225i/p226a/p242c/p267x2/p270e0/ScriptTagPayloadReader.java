package p007b.p225i.p226a.p242c.p267x2.p270e0;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.extractor.flv.TagPayloadReader;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import p007b.p225i.p226a.p242c.p259f3.ParsableByteArray;
import p007b.p225i.p226a.p242c.p267x2.DummyTrackOutput;

/* compiled from: ScriptTagPayloadReader.java */
/* renamed from: b.i.a.c.x2.e0.d, reason: use source file name */
/* loaded from: classes3.dex */
public final class ScriptTagPayloadReader extends TagPayloadReader {

    /* renamed from: b */
    public long f8142b;

    /* renamed from: c */
    public long[] f8143c;

    /* renamed from: d */
    public long[] f8144d;

    public ScriptTagPayloadReader() {
        super(new DummyTrackOutput());
        this.f8142b = -9223372036854775807L;
        this.f8143c = new long[0];
        this.f8144d = new long[0];
    }

    @Nullable
    /* renamed from: d */
    public static Object m3661d(ParsableByteArray parsableByteArray, int i) {
        if (i == 0) {
            return Double.valueOf(Double.longBitsToDouble(parsableByteArray.m3093m()));
        }
        if (i == 1) {
            return Boolean.valueOf(parsableByteArray.m3100t() == 1);
        }
        if (i == 2) {
            return m3663f(parsableByteArray);
        }
        if (i != 3) {
            if (i == 8) {
                return m3662e(parsableByteArray);
            }
            if (i != 10) {
                if (i != 11) {
                    return null;
                }
                Date date = new Date((long) Double.valueOf(Double.longBitsToDouble(parsableByteArray.m3093m())).doubleValue());
                parsableByteArray.m3080F(2);
                return date;
            }
            int iM3103w = parsableByteArray.m3103w();
            ArrayList arrayList = new ArrayList(iM3103w);
            for (int i2 = 0; i2 < iM3103w; i2++) {
                Object objM3661d = m3661d(parsableByteArray, parsableByteArray.m3100t());
                if (objM3661d != null) {
                    arrayList.add(objM3661d);
                }
            }
            return arrayList;
        }
        HashMap map = new HashMap();
        while (true) {
            String strM3663f = m3663f(parsableByteArray);
            int iM3100t = parsableByteArray.m3100t();
            if (iM3100t == 9) {
                return map;
            }
            Object objM3661d2 = m3661d(parsableByteArray, iM3100t);
            if (objM3661d2 != null) {
                map.put(strM3663f, objM3661d2);
            }
        }
    }

    /* renamed from: e */
    public static HashMap<String, Object> m3662e(ParsableByteArray parsableByteArray) {
        int iM3103w = parsableByteArray.m3103w();
        HashMap<String, Object> map = new HashMap<>(iM3103w);
        for (int i = 0; i < iM3103w; i++) {
            String strM3663f = m3663f(parsableByteArray);
            Object objM3661d = m3661d(parsableByteArray, parsableByteArray.m3100t());
            if (objM3661d != null) {
                map.put(strM3663f, objM3661d);
            }
        }
        return map;
    }

    /* renamed from: f */
    public static String m3663f(ParsableByteArray parsableByteArray) {
        int iM3105y = parsableByteArray.m3105y();
        int i = parsableByteArray.f6794b;
        parsableByteArray.m3080F(iM3105y);
        return new String(parsableByteArray.f6793a, i, iM3105y);
    }

    @Override // com.google.android.exoplayer2.extractor.flv.TagPayloadReader
    /* renamed from: b */
    public boolean mo3657b(ParsableByteArray parsableByteArray) {
        return true;
    }

    @Override // com.google.android.exoplayer2.extractor.flv.TagPayloadReader
    /* renamed from: c */
    public boolean mo3658c(ParsableByteArray parsableByteArray, long j) {
        if (parsableByteArray.m3100t() != 2 || !"onMetaData".equals(m3663f(parsableByteArray)) || parsableByteArray.m3100t() != 8) {
            return false;
        }
        HashMap<String, Object> mapM3662e = m3662e(parsableByteArray);
        Object obj = mapM3662e.get("duration");
        if (obj instanceof Double) {
            double dDoubleValue = ((Double) obj).doubleValue();
            if (dDoubleValue > 0.0d) {
                this.f8142b = (long) (dDoubleValue * 1000000.0d);
            }
        }
        Object obj2 = mapM3662e.get("keyframes");
        if (obj2 instanceof Map) {
            Map map = (Map) obj2;
            Object obj3 = map.get("filepositions");
            Object obj4 = map.get("times");
            if ((obj3 instanceof List) && (obj4 instanceof List)) {
                List list = (List) obj3;
                List list2 = (List) obj4;
                int size = list2.size();
                this.f8143c = new long[size];
                this.f8144d = new long[size];
                for (int i = 0; i < size; i++) {
                    Object obj5 = list.get(i);
                    Object obj6 = list2.get(i);
                    if (!(obj6 instanceof Double) || !(obj5 instanceof Double)) {
                        this.f8143c = new long[0];
                        this.f8144d = new long[0];
                        break;
                    }
                    this.f8143c[i] = (long) (((Double) obj6).doubleValue() * 1000000.0d);
                    this.f8144d[i] = ((Double) obj5).longValue();
                }
            }
        }
        return false;
    }
}

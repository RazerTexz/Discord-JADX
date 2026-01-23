package p007b.p085c.p086a.p087a0;

import android.graphics.PointF;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import p007b.p085c.p086a.p087a0.p088i0.JsonReader2;
import p007b.p085c.p086a.p089b0.MiscUtils;
import p007b.p085c.p086a.p095y.CubicCurveData;
import p007b.p085c.p086a.p095y.p097l.ShapeData;

/* JADX INFO: renamed from: b.c.a.a0.b0, reason: use source file name */
/* JADX INFO: compiled from: ShapeDataParser.java */
/* JADX INFO: loaded from: classes.dex */
public class ShapeDataParser implements ValueParser<ShapeData> {

    /* JADX INFO: renamed from: a */
    public static final ShapeDataParser f2211a = new ShapeDataParser();

    /* JADX INFO: renamed from: b */
    public static final JsonReader2.a f2212b = JsonReader2.a.m616a("c", "v", "i", "o");

    @Override // p007b.p085c.p086a.p087a0.ValueParser
    /* JADX INFO: renamed from: a */
    public ShapeData mo413a(JsonReader2 jsonReader2, float f) throws IOException {
        if (jsonReader2.mo613u() == JsonReader2.b.BEGIN_ARRAY) {
            jsonReader2.mo603a();
        }
        jsonReader2.mo604b();
        List<PointF> listM629c = null;
        List<PointF> listM629c2 = null;
        List<PointF> listM629c3 = null;
        boolean zMo608f = false;
        while (jsonReader2.mo607e()) {
            int iMo615y = jsonReader2.mo615y(f2212b);
            if (iMo615y == 0) {
                zMo608f = jsonReader2.mo608f();
            } else if (iMo615y == 1) {
                listM629c = JsonUtils.m629c(jsonReader2, f);
            } else if (iMo615y == 2) {
                listM629c2 = JsonUtils.m629c(jsonReader2, f);
            } else if (iMo615y != 3) {
                jsonReader2.mo600A();
                jsonReader2.mo601C();
            } else {
                listM629c3 = JsonUtils.m629c(jsonReader2, f);
            }
        }
        jsonReader2.mo606d();
        if (jsonReader2.mo613u() == JsonReader2.b.END_ARRAY) {
            jsonReader2.mo605c();
        }
        if (listM629c == null || listM629c2 == null || listM629c3 == null) {
            throw new IllegalArgumentException("Shape data was missing information.");
        }
        if (listM629c.isEmpty()) {
            return new ShapeData(new PointF(), false, Collections.emptyList());
        }
        int size = listM629c.size();
        PointF pointF = listM629c.get(0);
        ArrayList arrayList = new ArrayList(size);
        for (int i = 1; i < size; i++) {
            PointF pointF2 = listM629c.get(i);
            int i2 = i - 1;
            arrayList.add(new CubicCurveData(MiscUtils.m651a(listM629c.get(i2), listM629c3.get(i2)), MiscUtils.m651a(pointF2, listM629c2.get(i)), pointF2));
        }
        if (zMo608f) {
            PointF pointF3 = listM629c.get(0);
            int i3 = size - 1;
            arrayList.add(new CubicCurveData(MiscUtils.m651a(listM629c.get(i3), listM629c3.get(i3)), MiscUtils.m651a(pointF3, listM629c2.get(0)), pointF3));
        }
        return new ShapeData(pointF, zMo608f, arrayList);
    }
}

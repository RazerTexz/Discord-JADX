package p007b.p085c.p086a.p087a0;

import android.graphics.PointF;
import java.io.IOException;
import p007b.p085c.p086a.p087a0.p088i0.JsonReader2;

/* JADX INFO: renamed from: b.c.a.a0.w, reason: use source file name */
/* JADX INFO: compiled from: PointFParser.java */
/* JADX INFO: loaded from: classes.dex */
public class PointFParser implements ValueParser<PointF> {

    /* JADX INFO: renamed from: a */
    public static final PointFParser f2289a = new PointFParser();

    @Override // p007b.p085c.p086a.p087a0.ValueParser
    /* JADX INFO: renamed from: a */
    public PointF mo413a(JsonReader2 jsonReader2, float f) throws IOException {
        JsonReader2.b bVarMo613u = jsonReader2.mo613u();
        if (bVarMo613u == JsonReader2.b.BEGIN_ARRAY) {
            return JsonUtils.m628b(jsonReader2, f);
        }
        if (bVarMo613u == JsonReader2.b.BEGIN_OBJECT) {
            return JsonUtils.m628b(jsonReader2, f);
        }
        if (bVarMo613u == JsonReader2.b.NUMBER) {
            PointF pointF = new PointF(((float) jsonReader2.mo609n()) * f, ((float) jsonReader2.mo609n()) * f);
            while (jsonReader2.mo607e()) {
                jsonReader2.mo601C();
            }
            return pointF;
        }
        throw new IllegalArgumentException("Cannot convert json to point. Next token is " + bVarMo613u);
    }
}

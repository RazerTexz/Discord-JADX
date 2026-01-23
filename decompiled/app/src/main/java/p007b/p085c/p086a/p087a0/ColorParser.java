package p007b.p085c.p086a.p087a0;

import android.graphics.Color;
import java.io.IOException;
import p007b.p085c.p086a.p087a0.p088i0.JsonReader2;

/* JADX INFO: renamed from: b.c.a.a0.f, reason: use source file name */
/* JADX INFO: compiled from: ColorParser.java */
/* JADX INFO: loaded from: classes.dex */
public class ColorParser implements ValueParser<Integer> {

    /* JADX INFO: renamed from: a */
    public static final ColorParser f2228a = new ColorParser();

    @Override // p007b.p085c.p086a.p087a0.ValueParser
    /* JADX INFO: renamed from: a */
    public Integer mo413a(JsonReader2 jsonReader2, float f) throws IOException {
        boolean z2 = jsonReader2.mo613u() == JsonReader2.b.BEGIN_ARRAY;
        if (z2) {
            jsonReader2.mo603a();
        }
        double dMo609n = jsonReader2.mo609n();
        double dMo609n2 = jsonReader2.mo609n();
        double dMo609n3 = jsonReader2.mo609n();
        double dMo609n4 = jsonReader2.mo609n();
        if (z2) {
            jsonReader2.mo605c();
        }
        if (dMo609n <= 1.0d && dMo609n2 <= 1.0d && dMo609n3 <= 1.0d) {
            dMo609n *= 255.0d;
            dMo609n2 *= 255.0d;
            dMo609n3 *= 255.0d;
            if (dMo609n4 <= 1.0d) {
                dMo609n4 *= 255.0d;
            }
        }
        return Integer.valueOf(Color.argb((int) dMo609n4, (int) dMo609n, (int) dMo609n2, (int) dMo609n3));
    }
}

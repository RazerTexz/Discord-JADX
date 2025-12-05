package p007b.p085c.p086a.p087a0;

import java.io.IOException;
import p007b.p085c.p086a.p087a0.p088i0.JsonReader2;
import p007b.p085c.p086a.p090c0.ScaleXY;

/* compiled from: ScaleXYParser.java */
/* renamed from: b.c.a.a0.a0, reason: use source file name */
/* loaded from: classes.dex */
public class ScaleXYParser implements ValueParser<ScaleXY> {

    /* renamed from: a */
    public static final ScaleXYParser f2208a = new ScaleXYParser();

    @Override // p007b.p085c.p086a.p087a0.ValueParser
    /* renamed from: a */
    public ScaleXY mo413a(JsonReader2 jsonReader2, float f) throws IOException {
        boolean z2 = jsonReader2.mo613u() == JsonReader2.b.BEGIN_ARRAY;
        if (z2) {
            jsonReader2.mo603a();
        }
        float fMo609n = (float) jsonReader2.mo609n();
        float fMo609n2 = (float) jsonReader2.mo609n();
        while (jsonReader2.mo607e()) {
            jsonReader2.mo601C();
        }
        if (z2) {
            jsonReader2.mo605c();
        }
        return new ScaleXY((fMo609n / 100.0f) * f, (fMo609n2 / 100.0f) * f);
    }
}

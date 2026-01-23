package p007b.p085c.p086a.p087a0;

import java.io.IOException;
import p007b.p085c.p086a.p087a0.p088i0.JsonReader2;

/* JADX INFO: renamed from: b.c.a.a0.i, reason: use source file name */
/* JADX INFO: compiled from: FloatParser.java */
/* JADX INFO: loaded from: classes.dex */
public class FloatParser implements ValueParser<Float> {

    /* JADX INFO: renamed from: a */
    public static final FloatParser f2235a = new FloatParser();

    @Override // p007b.p085c.p086a.p087a0.ValueParser
    /* JADX INFO: renamed from: a */
    public Float mo413a(JsonReader2 jsonReader2, float f) throws IOException {
        return Float.valueOf(JsonUtils.m630d(jsonReader2) * f);
    }
}

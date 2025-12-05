package p007b.p085c.p086a.p087a0;

import java.io.IOException;
import p007b.p085c.p086a.p087a0.p088i0.JsonReader2;

/* compiled from: FloatParser.java */
/* renamed from: b.c.a.a0.i, reason: use source file name */
/* loaded from: classes.dex */
public class FloatParser implements ValueParser<Float> {

    /* renamed from: a */
    public static final FloatParser f2235a = new FloatParser();

    @Override // p007b.p085c.p086a.p087a0.ValueParser
    /* renamed from: a */
    public Float mo413a(JsonReader2 jsonReader2, float f) throws IOException {
        return Float.valueOf(JsonUtils.m630d(jsonReader2) * f);
    }
}

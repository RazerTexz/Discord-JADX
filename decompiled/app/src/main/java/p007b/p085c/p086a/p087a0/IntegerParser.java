package p007b.p085c.p086a.p087a0;

import java.io.IOException;
import p007b.p085c.p086a.p087a0.p088i0.JsonReader2;

/* compiled from: IntegerParser.java */
/* renamed from: b.c.a.a0.o, reason: use source file name */
/* loaded from: classes.dex */
public class IntegerParser implements ValueParser<Integer> {

    /* renamed from: a */
    public static final IntegerParser f2274a = new IntegerParser();

    @Override // p007b.p085c.p086a.p087a0.ValueParser
    /* renamed from: a */
    public Integer mo413a(JsonReader2 jsonReader2, float f) throws IOException {
        return Integer.valueOf(Math.round(JsonUtils.m630d(jsonReader2) * f));
    }
}

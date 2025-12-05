package p007b.p195g.p196a.p205c.p215g0.p217u;

import java.io.IOException;
import p007b.p195g.p196a.p198b.JsonGenerator;
import p007b.p195g.p196a.p198b.JsonToken2;
import p007b.p195g.p196a.p198b.p203s.WritableTypeId;
import p007b.p195g.p196a.p205c.SerializerProvider;
import p007b.p195g.p196a.p205c.p212e0.TypeSerializer;

/* compiled from: RawSerializer.java */
/* renamed from: b.g.a.c.g0.u.e0, reason: use source file name */
/* loaded from: classes3.dex */
public class RawSerializer<T> extends StdSerializer<T> {
    public RawSerializer(Class<?> cls) {
        super(cls, false);
    }

    @Override // p007b.p195g.p196a.p205c.JsonSerializer
    /* renamed from: f */
    public void mo1807f(T t, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.mo1644V(t.toString());
    }

    @Override // p007b.p195g.p196a.p205c.JsonSerializer
    /* renamed from: g */
    public void mo1808g(T t, JsonGenerator jsonGenerator, SerializerProvider serializerProvider, TypeSerializer typeSerializer) throws IOException {
        WritableTypeId writableTypeIdMo1959e = typeSerializer.mo1959e(jsonGenerator, typeSerializer.m1958d(t, JsonToken2.VALUE_EMBEDDED_OBJECT));
        jsonGenerator.mo1644V(t.toString());
        typeSerializer.mo1960f(jsonGenerator, writableTypeIdMo1959e);
    }
}

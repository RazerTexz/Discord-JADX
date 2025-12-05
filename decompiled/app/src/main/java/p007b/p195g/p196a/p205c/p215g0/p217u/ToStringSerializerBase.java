package p007b.p195g.p196a.p205c.p215g0.p217u;

import java.io.IOException;
import p007b.p195g.p196a.p198b.JsonGenerator;
import p007b.p195g.p196a.p198b.JsonToken2;
import p007b.p195g.p196a.p198b.p203s.WritableTypeId;
import p007b.p195g.p196a.p205c.SerializerProvider;
import p007b.p195g.p196a.p205c.p212e0.TypeSerializer;

/* compiled from: ToStringSerializerBase.java */
/* renamed from: b.g.a.c.g0.u.u0, reason: use source file name */
/* loaded from: classes3.dex */
public abstract class ToStringSerializerBase extends StdSerializer<Object> {
    public ToStringSerializerBase(Class<?> cls) {
        super(cls, false);
    }

    @Override // p007b.p195g.p196a.p205c.JsonSerializer
    /* renamed from: d */
    public boolean mo2021d(SerializerProvider serializerProvider, Object obj) {
        return mo2087p(obj).isEmpty();
    }

    @Override // p007b.p195g.p196a.p205c.JsonSerializer
    /* renamed from: f */
    public void mo1807f(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.mo1658j0(mo2087p(obj));
    }

    @Override // p007b.p195g.p196a.p205c.JsonSerializer
    /* renamed from: g */
    public void mo1808g(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider, TypeSerializer typeSerializer) throws IOException {
        WritableTypeId writableTypeIdMo1959e = typeSerializer.mo1959e(jsonGenerator, typeSerializer.m1958d(obj, JsonToken2.VALUE_STRING));
        mo1807f(obj, jsonGenerator, serializerProvider);
        typeSerializer.mo1960f(jsonGenerator, writableTypeIdMo1959e);
    }

    /* renamed from: p */
    public abstract String mo2087p(Object obj);
}

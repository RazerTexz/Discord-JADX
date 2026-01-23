package p007b.p195g.p196a.p205c.p215g0.p217u;

import java.io.IOException;
import p007b.p195g.p196a.p198b.JsonGenerator;
import p007b.p195g.p196a.p198b.JsonToken2;
import p007b.p195g.p196a.p198b.p203s.WritableTypeId;
import p007b.p195g.p196a.p205c.SerializerProvider;
import p007b.p195g.p196a.p205c.p212e0.TypeSerializer;

/* JADX INFO: renamed from: b.g.a.c.g0.u.p0, reason: use source file name */
/* JADX INFO: compiled from: StdScalarSerializer.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class StdScalarSerializer<T> extends StdSerializer<T> {
    public StdScalarSerializer(Class<T> cls) {
        super(cls);
    }

    @Override // p007b.p195g.p196a.p205c.JsonSerializer
    /* JADX INFO: renamed from: g */
    public void mo1808g(T t, JsonGenerator jsonGenerator, SerializerProvider serializerProvider, TypeSerializer typeSerializer) throws IOException {
        WritableTypeId writableTypeIdMo1959e = typeSerializer.mo1959e(jsonGenerator, typeSerializer.m1958d(t, JsonToken2.VALUE_STRING));
        mo1807f(t, jsonGenerator, serializerProvider);
        typeSerializer.mo1960f(jsonGenerator, writableTypeIdMo1959e);
    }

    public StdScalarSerializer(Class<?> cls, boolean z2) {
        super(cls);
    }
}

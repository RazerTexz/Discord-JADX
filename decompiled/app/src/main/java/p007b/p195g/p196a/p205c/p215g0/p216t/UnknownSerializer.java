package p007b.p195g.p196a.p205c.p215g0.p216t;

import com.fasterxml.jackson.databind.JsonMappingException;
import java.io.IOException;
import p007b.p195g.p196a.p198b.JsonGenerator;
import p007b.p195g.p196a.p198b.JsonToken2;
import p007b.p195g.p196a.p205c.SerializationFeature;
import p007b.p195g.p196a.p205c.SerializerProvider;
import p007b.p195g.p196a.p205c.p212e0.TypeSerializer;
import p007b.p195g.p196a.p205c.p215g0.p217u.StdSerializer;

/* JADX INFO: renamed from: b.g.a.c.g0.t.q, reason: use source file name */
/* JADX INFO: compiled from: UnknownSerializer.java */
/* JADX INFO: loaded from: classes3.dex */
public class UnknownSerializer extends StdSerializer<Object> {
    public UnknownSerializer() {
        super(Object.class);
    }

    @Override // p007b.p195g.p196a.p205c.JsonSerializer
    /* JADX INFO: renamed from: d */
    public boolean mo2021d(SerializerProvider serializerProvider, Object obj) {
        return true;
    }

    @Override // p007b.p195g.p196a.p205c.JsonSerializer
    /* JADX INFO: renamed from: f */
    public void mo1807f(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        if (serializerProvider.m2240D(SerializationFeature.FAIL_ON_EMPTY_BEANS)) {
            m2042p(serializerProvider, obj);
        }
        jsonGenerator.mo1656f0(obj, 0);
        jsonGenerator.mo1664u();
    }

    @Override // p007b.p195g.p196a.p205c.JsonSerializer
    /* JADX INFO: renamed from: g */
    public final void mo1808g(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider, TypeSerializer typeSerializer) throws IOException {
        if (serializerProvider.m2240D(SerializationFeature.FAIL_ON_EMPTY_BEANS)) {
            m2042p(serializerProvider, obj);
        }
        typeSerializer.mo1960f(jsonGenerator, typeSerializer.mo1959e(jsonGenerator, typeSerializer.m1958d(obj, JsonToken2.START_OBJECT)));
    }

    /* JADX INFO: renamed from: p */
    public void m2042p(SerializerProvider serializerProvider, Object obj) throws JsonMappingException {
        serializerProvider.m1943g(this._handledType, String.format("No serializer found for class %s and no properties discovered to create BeanSerializer (to avoid exception, disable SerializationFeature.FAIL_ON_EMPTY_BEANS)", obj.getClass().getName()));
    }

    public UnknownSerializer(Class<?> cls) {
        super(cls, false);
    }
}

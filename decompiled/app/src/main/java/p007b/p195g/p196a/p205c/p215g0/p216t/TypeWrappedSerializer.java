package p007b.p195g.p196a.p205c.p215g0.p216t;

import com.fasterxml.jackson.databind.JsonMappingException;
import java.io.IOException;
import p007b.p195g.p196a.p198b.JsonGenerator;
import p007b.p195g.p196a.p205c.BeanProperty;
import p007b.p195g.p196a.p205c.JsonSerializer;
import p007b.p195g.p196a.p205c.SerializerProvider;
import p007b.p195g.p196a.p205c.p212e0.TypeSerializer;
import p007b.p195g.p196a.p205c.p215g0.ContextualSerializer;

/* JADX INFO: renamed from: b.g.a.c.g0.t.p, reason: use source file name */
/* JADX INFO: compiled from: TypeWrappedSerializer.java */
/* JADX INFO: loaded from: classes3.dex */
public final class TypeWrappedSerializer extends JsonSerializer<Object> implements ContextualSerializer {

    /* JADX INFO: renamed from: j */
    public final TypeSerializer f4845j;

    /* JADX INFO: renamed from: k */
    public final JsonSerializer<Object> f4846k;

    public TypeWrappedSerializer(TypeSerializer typeSerializer, JsonSerializer<?> jsonSerializer) {
        this.f4845j = typeSerializer;
        this.f4846k = jsonSerializer;
    }

    @Override // p007b.p195g.p196a.p205c.p215g0.ContextualSerializer
    /* JADX INFO: renamed from: a */
    public JsonSerializer<?> mo1997a(SerializerProvider serializerProvider, BeanProperty beanProperty) throws JsonMappingException {
        JsonSerializer<?> jsonSerializerM2261z = this.f4846k;
        if (jsonSerializerM2261z instanceof ContextualSerializer) {
            jsonSerializerM2261z = serializerProvider.m2261z(jsonSerializerM2261z, beanProperty);
        }
        return jsonSerializerM2261z == this.f4846k ? this : new TypeWrappedSerializer(this.f4845j, jsonSerializerM2261z);
    }

    @Override // p007b.p195g.p196a.p205c.JsonSerializer
    /* JADX INFO: renamed from: c */
    public Class<Object> mo2041c() {
        return Object.class;
    }

    @Override // p007b.p195g.p196a.p205c.JsonSerializer
    /* JADX INFO: renamed from: f */
    public void mo1807f(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        this.f4846k.mo1808g(obj, jsonGenerator, serializerProvider, this.f4845j);
    }

    @Override // p007b.p195g.p196a.p205c.JsonSerializer
    /* JADX INFO: renamed from: g */
    public void mo1808g(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider, TypeSerializer typeSerializer) throws IOException {
        this.f4846k.mo1808g(obj, jsonGenerator, serializerProvider, typeSerializer);
    }
}

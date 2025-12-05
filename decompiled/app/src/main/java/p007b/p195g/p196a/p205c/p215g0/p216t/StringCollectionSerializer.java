package p007b.p195g.p196a.p205c.p215g0.p216t;

import java.io.IOException;
import java.util.Collection;
import p007b.p195g.p196a.p198b.JsonGenerator;
import p007b.p195g.p196a.p198b.JsonToken2;
import p007b.p195g.p196a.p198b.p203s.WritableTypeId;
import p007b.p195g.p196a.p205c.BeanProperty;
import p007b.p195g.p196a.p205c.JsonSerializer;
import p007b.p195g.p196a.p205c.SerializationFeature;
import p007b.p195g.p196a.p205c.SerializerProvider;
import p007b.p195g.p196a.p205c.p212e0.TypeSerializer;
import p007b.p195g.p196a.p205c.p215g0.p217u.StaticListSerializerBase;
import p007b.p195g.p196a.p205c.p220y.JacksonStdImpl;

/* compiled from: StringCollectionSerializer.java */
@JacksonStdImpl
/* renamed from: b.g.a.c.g0.t.o, reason: use source file name */
/* loaded from: classes3.dex */
public class StringCollectionSerializer extends StaticListSerializerBase<Collection<String>> {

    /* renamed from: k */
    public static final StringCollectionSerializer f4844k = new StringCollectionSerializer();

    public StringCollectionSerializer() {
        super(Collection.class);
    }

    @Override // p007b.p195g.p196a.p205c.JsonSerializer
    /* renamed from: f */
    public void mo1807f(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        Collection<String> collection = (Collection) obj;
        int size = collection.size();
        if (size == 1 && ((this._unwrapSingle == null && serializerProvider.m2240D(SerializationFeature.WRITE_SINGLE_ELEM_ARRAYS_UNWRAPPED)) || this._unwrapSingle == Boolean.TRUE)) {
            m2040r(collection, jsonGenerator, serializerProvider);
            return;
        }
        jsonGenerator.mo1649b0(collection, size);
        m2040r(collection, jsonGenerator, serializerProvider);
        jsonGenerator.mo1663t();
    }

    @Override // p007b.p195g.p196a.p205c.p215g0.p217u.StaticListSerializerBase, p007b.p195g.p196a.p205c.JsonSerializer
    /* renamed from: g */
    public void mo1808g(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider, TypeSerializer typeSerializer) throws IOException {
        Collection<String> collection = (Collection) obj;
        WritableTypeId writableTypeIdMo1959e = typeSerializer.mo1959e(jsonGenerator, typeSerializer.m1958d(collection, JsonToken2.START_ARRAY));
        jsonGenerator.mo1654e(collection);
        m2040r(collection, jsonGenerator, serializerProvider);
        typeSerializer.mo1960f(jsonGenerator, writableTypeIdMo1959e);
    }

    @Override // p007b.p195g.p196a.p205c.p215g0.p217u.StaticListSerializerBase
    /* renamed from: p */
    public JsonSerializer<?> mo2025p(BeanProperty beanProperty, Boolean bool) {
        return new StringCollectionSerializer(this, bool);
    }

    @Override // p007b.p195g.p196a.p205c.p215g0.p217u.StaticListSerializerBase
    /* renamed from: q */
    public void mo2026q(Collection<String> collection, JsonGenerator jsonGenerator, SerializerProvider serializerProvider, TypeSerializer typeSerializer) throws IOException {
        WritableTypeId writableTypeIdMo1959e = typeSerializer.mo1959e(jsonGenerator, typeSerializer.m1958d(collection, JsonToken2.START_ARRAY));
        jsonGenerator.mo1654e(collection);
        m2040r(collection, jsonGenerator, serializerProvider);
        typeSerializer.mo1960f(jsonGenerator, writableTypeIdMo1959e);
    }

    /* renamed from: r */
    public final void m2040r(Collection<String> collection, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        int i = 0;
        try {
            for (String str : collection) {
                if (str == null) {
                    serializerProvider.m2248l(jsonGenerator);
                } else {
                    jsonGenerator.mo1658j0(str);
                }
                i++;
            }
        } catch (Exception e) {
            m2076n(serializerProvider, e, collection, i);
            throw null;
        }
    }

    public StringCollectionSerializer(StringCollectionSerializer stringCollectionSerializer, Boolean bool) {
        super(stringCollectionSerializer, bool);
    }
}

package p007b.p195g.p196a.p205c.p215g0.p216t;

import java.io.IOException;
import java.util.Collection;
import java.util.List;
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

/* JADX INFO: renamed from: b.g.a.c.g0.t.g, reason: use source file name */
/* JADX INFO: compiled from: IndexedStringListSerializer.java */
/* JADX INFO: loaded from: classes3.dex */
@JacksonStdImpl
public final class IndexedStringListSerializer extends StaticListSerializerBase<List<String>> {

    /* JADX INFO: renamed from: k */
    public static final IndexedStringListSerializer f4817k = new IndexedStringListSerializer();
    private static final long serialVersionUID = 1;

    public IndexedStringListSerializer() {
        super(List.class);
    }

    @Override // p007b.p195g.p196a.p205c.JsonSerializer
    /* JADX INFO: renamed from: f */
    public void mo1807f(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        List<String> list = (List) obj;
        int size = list.size();
        if (size == 1 && ((this._unwrapSingle == null && serializerProvider.m2240D(SerializationFeature.WRITE_SINGLE_ELEM_ARRAYS_UNWRAPPED)) || this._unwrapSingle == Boolean.TRUE)) {
            m2027r(list, jsonGenerator, serializerProvider, 1);
            return;
        }
        jsonGenerator.mo1649b0(list, size);
        m2027r(list, jsonGenerator, serializerProvider, size);
        jsonGenerator.mo1663t();
    }

    @Override // p007b.p195g.p196a.p205c.p215g0.p217u.StaticListSerializerBase, p007b.p195g.p196a.p205c.JsonSerializer
    /* JADX INFO: renamed from: g */
    public /* bridge */ /* synthetic */ void mo1808g(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider, TypeSerializer typeSerializer) throws IOException {
        m2028s((List) obj, jsonGenerator, serializerProvider, typeSerializer);
    }

    @Override // p007b.p195g.p196a.p205c.p215g0.p217u.StaticListSerializerBase
    /* JADX INFO: renamed from: p */
    public JsonSerializer<?> mo2025p(BeanProperty beanProperty, Boolean bool) {
        return new IndexedStringListSerializer(this, bool);
    }

    @Override // p007b.p195g.p196a.p205c.p215g0.p217u.StaticListSerializerBase
    /* JADX INFO: renamed from: q */
    public /* bridge */ /* synthetic */ void mo2026q(Collection collection, JsonGenerator jsonGenerator, SerializerProvider serializerProvider, TypeSerializer typeSerializer) throws IOException {
        m2028s((List) collection, jsonGenerator, serializerProvider, typeSerializer);
    }

    /* JADX INFO: renamed from: r */
    public final void m2027r(List<String> list, JsonGenerator jsonGenerator, SerializerProvider serializerProvider, int i) throws IOException {
        for (int i2 = 0; i2 < i; i2++) {
            try {
                String str = list.get(i2);
                if (str == null) {
                    serializerProvider.m2248l(jsonGenerator);
                } else {
                    jsonGenerator.mo1658j0(str);
                }
            } catch (Exception e) {
                m2076n(serializerProvider, e, list, i2);
                throw null;
            }
        }
    }

    /* JADX INFO: renamed from: s */
    public void m2028s(List<String> list, JsonGenerator jsonGenerator, SerializerProvider serializerProvider, TypeSerializer typeSerializer) throws IOException {
        WritableTypeId writableTypeIdMo1959e = typeSerializer.mo1959e(jsonGenerator, typeSerializer.m1958d(list, JsonToken2.START_ARRAY));
        jsonGenerator.mo1654e(list);
        m2027r(list, jsonGenerator, serializerProvider, list.size());
        typeSerializer.mo1960f(jsonGenerator, writableTypeIdMo1959e);
    }

    public IndexedStringListSerializer(IndexedStringListSerializer indexedStringListSerializer, Boolean bool) {
        super(indexedStringListSerializer, bool);
    }
}

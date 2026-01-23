package p007b.p195g.p196a.p205c.p215g0.p216t;

import java.io.IOException;
import java.util.List;
import p007b.p195g.p196a.p198b.JsonGenerator;
import p007b.p195g.p196a.p205c.BeanProperty;
import p007b.p195g.p196a.p205c.JavaType;
import p007b.p195g.p196a.p205c.JsonSerializer;
import p007b.p195g.p196a.p205c.SerializationFeature;
import p007b.p195g.p196a.p205c.SerializerProvider;
import p007b.p195g.p196a.p205c.p212e0.TypeSerializer;
import p007b.p195g.p196a.p205c.p215g0.ContainerSerializer;
import p007b.p195g.p196a.p205c.p215g0.p216t.PropertySerializerMap;
import p007b.p195g.p196a.p205c.p215g0.p217u.AsArraySerializerBase;
import p007b.p195g.p196a.p205c.p220y.JacksonStdImpl;

/* JADX INFO: renamed from: b.g.a.c.g0.t.f, reason: use source file name */
/* JADX INFO: compiled from: IndexedListSerializer.java */
/* JADX INFO: loaded from: classes3.dex */
@JacksonStdImpl
public final class IndexedListSerializer extends AsArraySerializerBase<List<?>> {
    private static final long serialVersionUID = 1;

    public IndexedListSerializer(JavaType javaType, boolean z2, TypeSerializer typeSerializer, JsonSerializer<Object> jsonSerializer) {
        super((Class<?>) List.class, javaType, z2, typeSerializer, jsonSerializer);
    }

    @Override // p007b.p195g.p196a.p205c.JsonSerializer
    /* JADX INFO: renamed from: d */
    public boolean mo2021d(SerializerProvider serializerProvider, Object obj) {
        return ((List) obj).isEmpty();
    }

    @Override // p007b.p195g.p196a.p205c.p215g0.p217u.AsArraySerializerBase, p007b.p195g.p196a.p205c.JsonSerializer
    /* JADX INFO: renamed from: f */
    public void mo1807f(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        List<?> list = (List) obj;
        int size = list.size();
        if (size == 1 && ((this._unwrapSingle == null && serializerProvider.m2240D(SerializationFeature.WRITE_SINGLE_ELEM_ARRAYS_UNWRAPPED)) || this._unwrapSingle == Boolean.TRUE)) {
            m2024u(list, jsonGenerator, serializerProvider);
            return;
        }
        jsonGenerator.mo1649b0(list, size);
        m2024u(list, jsonGenerator, serializerProvider);
        jsonGenerator.mo1663t();
    }

    @Override // p007b.p195g.p196a.p205c.p215g0.ContainerSerializer
    /* JADX INFO: renamed from: p */
    public ContainerSerializer<?> mo1995p(TypeSerializer typeSerializer) {
        return new IndexedListSerializer(this, this._property, typeSerializer, this._elementSerializer, this._unwrapSingle);
    }

    @Override // p007b.p195g.p196a.p205c.p215g0.ContainerSerializer
    /* JADX INFO: renamed from: q */
    public boolean mo1996q(Object obj) {
        return ((List) obj).size() == 1;
    }

    @Override // p007b.p195g.p196a.p205c.p215g0.p217u.AsArraySerializerBase
    /* JADX INFO: renamed from: s */
    public /* bridge */ /* synthetic */ void mo2022s(List<?> list, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        m2024u(list, jsonGenerator, serializerProvider);
    }

    @Override // p007b.p195g.p196a.p205c.p215g0.p217u.AsArraySerializerBase
    /* JADX INFO: renamed from: t */
    public AsArraySerializerBase<List<?>> mo2023t(BeanProperty beanProperty, TypeSerializer typeSerializer, JsonSerializer jsonSerializer, Boolean bool) {
        return new IndexedListSerializer(this, beanProperty, typeSerializer, jsonSerializer, bool);
    }

    /* JADX INFO: renamed from: u */
    public void m2024u(List<?> list, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        JsonSerializer<Object> jsonSerializerM2045r;
        JsonSerializer<Object> jsonSerializerM2045r2;
        JsonSerializer<Object> jsonSerializer = this._elementSerializer;
        int i = 0;
        if (jsonSerializer != null) {
            int size = list.size();
            if (size == 0) {
                return;
            }
            TypeSerializer typeSerializer = this._valueTypeSerializer;
            while (i < size) {
                Object obj = list.get(i);
                if (obj == null) {
                    try {
                        serializerProvider.m2248l(jsonGenerator);
                    } catch (Exception e) {
                        m2076n(serializerProvider, e, list, i);
                        throw null;
                    }
                } else if (typeSerializer == null) {
                    jsonSerializer.mo1807f(obj, jsonGenerator, serializerProvider);
                } else {
                    jsonSerializer.mo1808g(obj, jsonGenerator, serializerProvider, typeSerializer);
                }
                i++;
            }
            return;
        }
        if (this._valueTypeSerializer == null) {
            int size2 = list.size();
            if (size2 == 0) {
                return;
            }
            try {
                PropertySerializerMap propertySerializerMap = this._dynamicSerializers;
                while (i < size2) {
                    Object obj2 = list.get(i);
                    if (obj2 == null) {
                        serializerProvider.m2248l(jsonGenerator);
                    } else {
                        Class<?> cls = obj2.getClass();
                        JsonSerializer<Object> jsonSerializerMo2034c = propertySerializerMap.mo2034c(cls);
                        if (jsonSerializerMo2034c == null) {
                            if (this._elementType.mo2102r()) {
                                PropertySerializerMap.d dVarM2032a = propertySerializerMap.m2032a(serializerProvider.m2247k(this._elementType, cls), serializerProvider, this._property);
                                PropertySerializerMap propertySerializerMap2 = dVarM2032a.f4831b;
                                if (propertySerializerMap != propertySerializerMap2) {
                                    this._dynamicSerializers = propertySerializerMap2;
                                }
                                jsonSerializerM2045r = dVarM2032a.f4830a;
                            } else {
                                jsonSerializerM2045r = m2045r(propertySerializerMap, cls, serializerProvider);
                            }
                            jsonSerializerMo2034c = jsonSerializerM2045r;
                            propertySerializerMap = this._dynamicSerializers;
                        }
                        jsonSerializerMo2034c.mo1807f(obj2, jsonGenerator, serializerProvider);
                    }
                    i++;
                }
                return;
            } catch (Exception e2) {
                m2076n(serializerProvider, e2, list, i);
                throw null;
            }
        }
        int size3 = list.size();
        if (size3 == 0) {
            return;
        }
        try {
            TypeSerializer typeSerializer2 = this._valueTypeSerializer;
            PropertySerializerMap propertySerializerMap3 = this._dynamicSerializers;
            while (i < size3) {
                Object obj3 = list.get(i);
                if (obj3 == null) {
                    serializerProvider.m2248l(jsonGenerator);
                } else {
                    Class<?> cls2 = obj3.getClass();
                    JsonSerializer<Object> jsonSerializerMo2034c2 = propertySerializerMap3.mo2034c(cls2);
                    if (jsonSerializerMo2034c2 == null) {
                        if (this._elementType.mo2102r()) {
                            PropertySerializerMap.d dVarM2032a2 = propertySerializerMap3.m2032a(serializerProvider.m2247k(this._elementType, cls2), serializerProvider, this._property);
                            PropertySerializerMap propertySerializerMap4 = dVarM2032a2.f4831b;
                            if (propertySerializerMap3 != propertySerializerMap4) {
                                this._dynamicSerializers = propertySerializerMap4;
                            }
                            jsonSerializerM2045r2 = dVarM2032a2.f4830a;
                        } else {
                            jsonSerializerM2045r2 = m2045r(propertySerializerMap3, cls2, serializerProvider);
                        }
                        jsonSerializerMo2034c2 = jsonSerializerM2045r2;
                        propertySerializerMap3 = this._dynamicSerializers;
                    }
                    jsonSerializerMo2034c2.mo1808g(obj3, jsonGenerator, serializerProvider, typeSerializer2);
                }
                i++;
            }
        } catch (Exception e3) {
            m2076n(serializerProvider, e3, list, i);
            throw null;
        }
    }

    public IndexedListSerializer(IndexedListSerializer indexedListSerializer, BeanProperty beanProperty, TypeSerializer typeSerializer, JsonSerializer<?> jsonSerializer, Boolean bool) {
        super(indexedListSerializer, beanProperty, typeSerializer, jsonSerializer, bool);
    }
}

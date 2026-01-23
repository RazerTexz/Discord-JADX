package p007b.p195g.p196a.p205c.p215g0.p217u;

import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;
import p007b.p195g.p196a.p198b.JsonGenerator;
import p007b.p195g.p196a.p205c.BeanProperty;
import p007b.p195g.p196a.p205c.JavaType;
import p007b.p195g.p196a.p205c.JsonSerializer;
import p007b.p195g.p196a.p205c.SerializationFeature;
import p007b.p195g.p196a.p205c.SerializerProvider;
import p007b.p195g.p196a.p205c.p212e0.TypeSerializer;
import p007b.p195g.p196a.p205c.p215g0.ContainerSerializer;
import p007b.p195g.p196a.p205c.p215g0.p216t.PropertySerializerMap;

/* JADX INFO: renamed from: b.g.a.c.g0.u.j, reason: use source file name */
/* JADX INFO: compiled from: CollectionSerializer.java */
/* JADX INFO: loaded from: classes3.dex */
public class CollectionSerializer2 extends AsArraySerializerBase<Collection<?>> {
    private static final long serialVersionUID = 1;

    public CollectionSerializer2(JavaType javaType, boolean z2, TypeSerializer typeSerializer, JsonSerializer<Object> jsonSerializer) {
        super((Class<?>) Collection.class, javaType, z2, typeSerializer, jsonSerializer);
    }

    @Override // p007b.p195g.p196a.p205c.JsonSerializer
    /* JADX INFO: renamed from: d */
    public boolean mo2021d(SerializerProvider serializerProvider, Object obj) {
        return ((Collection) obj).isEmpty();
    }

    @Override // p007b.p195g.p196a.p205c.p215g0.p217u.AsArraySerializerBase, p007b.p195g.p196a.p205c.JsonSerializer
    /* JADX INFO: renamed from: f */
    public void mo1807f(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        Collection<?> collection = (Collection) obj;
        int size = collection.size();
        if (size == 1 && ((this._unwrapSingle == null && serializerProvider.m2240D(SerializationFeature.WRITE_SINGLE_ELEM_ARRAYS_UNWRAPPED)) || this._unwrapSingle == Boolean.TRUE)) {
            m2064u(collection, jsonGenerator, serializerProvider);
            return;
        }
        jsonGenerator.mo1649b0(collection, size);
        m2064u(collection, jsonGenerator, serializerProvider);
        jsonGenerator.mo1663t();
    }

    @Override // p007b.p195g.p196a.p205c.p215g0.ContainerSerializer
    /* JADX INFO: renamed from: p */
    public ContainerSerializer<?> mo1995p(TypeSerializer typeSerializer) {
        return new CollectionSerializer2(this, this._property, typeSerializer, this._elementSerializer, this._unwrapSingle);
    }

    @Override // p007b.p195g.p196a.p205c.p215g0.ContainerSerializer
    /* JADX INFO: renamed from: q */
    public boolean mo1996q(Object obj) {
        return ((Collection) obj).size() == 1;
    }

    @Override // p007b.p195g.p196a.p205c.p215g0.p217u.AsArraySerializerBase
    /* JADX INFO: renamed from: s */
    public /* bridge */ /* synthetic */ void mo2022s(Collection<?> collection, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        m2064u(collection, jsonGenerator, serializerProvider);
    }

    @Override // p007b.p195g.p196a.p205c.p215g0.p217u.AsArraySerializerBase
    /* JADX INFO: renamed from: t */
    public AsArraySerializerBase<Collection<?>> mo2023t(BeanProperty beanProperty, TypeSerializer typeSerializer, JsonSerializer jsonSerializer, Boolean bool) {
        return new CollectionSerializer2(this, beanProperty, typeSerializer, jsonSerializer, bool);
    }

    /* JADX INFO: renamed from: u */
    public void m2064u(Collection<?> collection, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        JsonSerializer<Object> jsonSerializerM2045r;
        jsonGenerator.mo1654e(collection);
        JsonSerializer<Object> jsonSerializer = this._elementSerializer;
        int i = 0;
        if (jsonSerializer != null) {
            Iterator<?> it = collection.iterator();
            if (it.hasNext()) {
                TypeSerializer typeSerializer = this._valueTypeSerializer;
                do {
                    Object next = it.next();
                    if (next == null) {
                        try {
                            serializerProvider.m2248l(jsonGenerator);
                        } catch (Exception e) {
                            m2076n(serializerProvider, e, collection, i);
                            throw null;
                        }
                    } else if (typeSerializer == null) {
                        jsonSerializer.mo1807f(next, jsonGenerator, serializerProvider);
                    } else {
                        jsonSerializer.mo1808g(next, jsonGenerator, serializerProvider, typeSerializer);
                    }
                    i++;
                } while (it.hasNext());
                return;
            }
            return;
        }
        Iterator<?> it2 = collection.iterator();
        if (it2.hasNext()) {
            PropertySerializerMap propertySerializerMap = this._dynamicSerializers;
            TypeSerializer typeSerializer2 = this._valueTypeSerializer;
            do {
                try {
                    Object next2 = it2.next();
                    if (next2 == null) {
                        serializerProvider.m2248l(jsonGenerator);
                    } else {
                        Class<?> cls = next2.getClass();
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
                        if (typeSerializer2 == null) {
                            jsonSerializerMo2034c.mo1807f(next2, jsonGenerator, serializerProvider);
                        } else {
                            jsonSerializerMo2034c.mo1808g(next2, jsonGenerator, serializerProvider, typeSerializer2);
                        }
                    }
                    i++;
                } catch (Exception e2) {
                    m2076n(serializerProvider, e2, collection, i);
                    throw null;
                }
            } while (it2.hasNext());
        }
    }

    public CollectionSerializer2(CollectionSerializer2 collectionSerializer2, BeanProperty beanProperty, TypeSerializer typeSerializer, JsonSerializer<?> jsonSerializer, Boolean bool) {
        super(collectionSerializer2, beanProperty, typeSerializer, jsonSerializer, bool);
    }
}

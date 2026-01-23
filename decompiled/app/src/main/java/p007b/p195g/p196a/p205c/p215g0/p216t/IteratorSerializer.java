package p007b.p195g.p196a.p205c.p215g0.p216t;

import java.io.IOException;
import java.util.Iterator;
import p007b.p195g.p196a.p198b.JsonGenerator;
import p007b.p195g.p196a.p205c.BeanProperty;
import p007b.p195g.p196a.p205c.JavaType;
import p007b.p195g.p196a.p205c.JsonSerializer;
import p007b.p195g.p196a.p205c.SerializerProvider;
import p007b.p195g.p196a.p205c.p212e0.TypeSerializer;
import p007b.p195g.p196a.p205c.p215g0.ContainerSerializer;
import p007b.p195g.p196a.p205c.p215g0.p216t.PropertySerializerMap;
import p007b.p195g.p196a.p205c.p215g0.p217u.AsArraySerializerBase;
import p007b.p195g.p196a.p205c.p220y.JacksonStdImpl;

/* JADX INFO: renamed from: b.g.a.c.g0.t.h, reason: use source file name */
/* JADX INFO: compiled from: IteratorSerializer.java */
/* JADX INFO: loaded from: classes3.dex */
@JacksonStdImpl
public class IteratorSerializer extends AsArraySerializerBase<Iterator<?>> {
    public IteratorSerializer(JavaType javaType, boolean z2, TypeSerializer typeSerializer) {
        super((Class<?>) Iterator.class, javaType, z2, typeSerializer, (JsonSerializer<Object>) null);
    }

    @Override // p007b.p195g.p196a.p205c.JsonSerializer
    /* JADX INFO: renamed from: d */
    public boolean mo2021d(SerializerProvider serializerProvider, Object obj) {
        return !((Iterator) obj).hasNext();
    }

    @Override // p007b.p195g.p196a.p205c.p215g0.p217u.AsArraySerializerBase, p007b.p195g.p196a.p205c.JsonSerializer
    /* JADX INFO: renamed from: f */
    public void mo1807f(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        Iterator<?> it = (Iterator) obj;
        jsonGenerator.mo1646X(it);
        m2029u(it, jsonGenerator, serializerProvider);
        jsonGenerator.mo1663t();
    }

    @Override // p007b.p195g.p196a.p205c.p215g0.ContainerSerializer
    /* JADX INFO: renamed from: p */
    public ContainerSerializer<?> mo1995p(TypeSerializer typeSerializer) {
        return new IteratorSerializer(this, this._property, typeSerializer, this._elementSerializer, this._unwrapSingle);
    }

    @Override // p007b.p195g.p196a.p205c.p215g0.ContainerSerializer
    /* JADX INFO: renamed from: q */
    public /* bridge */ /* synthetic */ boolean mo1996q(Object obj) {
        return false;
    }

    @Override // p007b.p195g.p196a.p205c.p215g0.p217u.AsArraySerializerBase
    /* JADX INFO: renamed from: s */
    public /* bridge */ /* synthetic */ void mo2022s(Iterator<?> it, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        m2029u(it, jsonGenerator, serializerProvider);
    }

    @Override // p007b.p195g.p196a.p205c.p215g0.p217u.AsArraySerializerBase
    /* JADX INFO: renamed from: t */
    public AsArraySerializerBase<Iterator<?>> mo2023t(BeanProperty beanProperty, TypeSerializer typeSerializer, JsonSerializer jsonSerializer, Boolean bool) {
        return new IteratorSerializer(this, beanProperty, typeSerializer, jsonSerializer, bool);
    }

    /* JADX INFO: renamed from: u */
    public void m2029u(Iterator<?> it, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        JsonSerializer<Object> jsonSerializerM2045r;
        if (it.hasNext()) {
            JsonSerializer<Object> jsonSerializer = this._elementSerializer;
            if (jsonSerializer != null) {
                TypeSerializer typeSerializer = this._valueTypeSerializer;
                do {
                    Object next = it.next();
                    if (next == null) {
                        serializerProvider.m2248l(jsonGenerator);
                    } else if (typeSerializer == null) {
                        jsonSerializer.mo1807f(next, jsonGenerator, serializerProvider);
                    } else {
                        jsonSerializer.mo1808g(next, jsonGenerator, serializerProvider, typeSerializer);
                    }
                } while (it.hasNext());
                return;
            }
            TypeSerializer typeSerializer2 = this._valueTypeSerializer;
            PropertySerializerMap propertySerializerMap = this._dynamicSerializers;
            do {
                Object next2 = it.next();
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
            } while (it.hasNext());
        }
    }

    public IteratorSerializer(IteratorSerializer iteratorSerializer, BeanProperty beanProperty, TypeSerializer typeSerializer, JsonSerializer<?> jsonSerializer, Boolean bool) {
        super(iteratorSerializer, beanProperty, typeSerializer, jsonSerializer, bool);
    }
}

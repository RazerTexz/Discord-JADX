package p007b.p195g.p196a.p205c.p215g0.p217u;

import java.io.IOException;
import java.util.Iterator;
import p007b.p195g.p196a.p198b.JsonGenerator;
import p007b.p195g.p196a.p205c.BeanProperty;
import p007b.p195g.p196a.p205c.JavaType;
import p007b.p195g.p196a.p205c.JsonSerializer;
import p007b.p195g.p196a.p205c.SerializationFeature;
import p007b.p195g.p196a.p205c.SerializerProvider;
import p007b.p195g.p196a.p205c.p212e0.TypeSerializer;
import p007b.p195g.p196a.p205c.p215g0.ContainerSerializer;
import p007b.p195g.p196a.p205c.p220y.JacksonStdImpl;

/* JADX INFO: renamed from: b.g.a.c.g0.u.r, reason: use source file name */
/* JADX INFO: compiled from: IterableSerializer.java */
/* JADX INFO: loaded from: classes3.dex */
@JacksonStdImpl
public class IterableSerializer extends AsArraySerializerBase<Iterable<?>> {
    public IterableSerializer(JavaType javaType, boolean z2, TypeSerializer typeSerializer) {
        super((Class<?>) Iterable.class, javaType, z2, typeSerializer, (JsonSerializer<Object>) null);
    }

    @Override // p007b.p195g.p196a.p205c.JsonSerializer
    /* JADX INFO: renamed from: d */
    public boolean mo2021d(SerializerProvider serializerProvider, Object obj) {
        return !((Iterable) obj).iterator().hasNext();
    }

    @Override // p007b.p195g.p196a.p205c.p215g0.p217u.AsArraySerializerBase, p007b.p195g.p196a.p205c.JsonSerializer
    /* JADX INFO: renamed from: f */
    public void mo1807f(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        Iterable<?> iterable = (Iterable) obj;
        if (((this._unwrapSingle == null && serializerProvider.m2240D(SerializationFeature.WRITE_SINGLE_ELEM_ARRAYS_UNWRAPPED)) || this._unwrapSingle == Boolean.TRUE) && m2078u(iterable)) {
            m2079v(iterable, jsonGenerator, serializerProvider);
            return;
        }
        jsonGenerator.mo1646X(iterable);
        m2079v(iterable, jsonGenerator, serializerProvider);
        jsonGenerator.mo1663t();
    }

    @Override // p007b.p195g.p196a.p205c.p215g0.ContainerSerializer
    /* JADX INFO: renamed from: p */
    public ContainerSerializer<?> mo1995p(TypeSerializer typeSerializer) {
        return new IterableSerializer(this, this._property, typeSerializer, this._elementSerializer, this._unwrapSingle);
    }

    @Override // p007b.p195g.p196a.p205c.p215g0.ContainerSerializer
    /* JADX INFO: renamed from: q */
    public /* bridge */ /* synthetic */ boolean mo1996q(Object obj) {
        return m2078u((Iterable) obj);
    }

    @Override // p007b.p195g.p196a.p205c.p215g0.p217u.AsArraySerializerBase
    /* JADX INFO: renamed from: s */
    public /* bridge */ /* synthetic */ void mo2022s(Iterable<?> iterable, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        m2079v(iterable, jsonGenerator, serializerProvider);
    }

    @Override // p007b.p195g.p196a.p205c.p215g0.p217u.AsArraySerializerBase
    /* JADX INFO: renamed from: t */
    public AsArraySerializerBase<Iterable<?>> mo2023t(BeanProperty beanProperty, TypeSerializer typeSerializer, JsonSerializer jsonSerializer, Boolean bool) {
        return new IterableSerializer(this, beanProperty, typeSerializer, jsonSerializer, bool);
    }

    /* JADX INFO: renamed from: u */
    public boolean m2078u(Iterable<?> iterable) {
        if (iterable == null) {
            return false;
        }
        Iterator<?> it = iterable.iterator();
        if (!it.hasNext()) {
            return false;
        }
        it.next();
        return !it.hasNext();
    }

    /* JADX INFO: renamed from: v */
    public void m2079v(Iterable<?> iterable, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        JsonSerializer<Object> jsonSerializer;
        Iterator<?> it = iterable.iterator();
        if (it.hasNext()) {
            TypeSerializer typeSerializer = this._valueTypeSerializer;
            Class<?> cls = null;
            JsonSerializer<Object> jsonSerializerM2256u = null;
            do {
                Object next = it.next();
                if (next == null) {
                    serializerProvider.m2248l(jsonGenerator);
                } else {
                    JsonSerializer<Object> jsonSerializer2 = this._elementSerializer;
                    if (jsonSerializer2 == null) {
                        Class<?> cls2 = next.getClass();
                        if (cls2 != cls) {
                            jsonSerializerM2256u = serializerProvider.m2256u(cls2, this._property);
                            cls = cls2;
                        }
                        jsonSerializer = jsonSerializerM2256u;
                    } else {
                        jsonSerializer = jsonSerializerM2256u;
                        jsonSerializerM2256u = jsonSerializer2;
                    }
                    if (typeSerializer == null) {
                        jsonSerializerM2256u.mo1807f(next, jsonGenerator, serializerProvider);
                    } else {
                        jsonSerializerM2256u.mo1808g(next, jsonGenerator, serializerProvider, typeSerializer);
                    }
                    jsonSerializerM2256u = jsonSerializer;
                }
            } while (it.hasNext());
        }
    }

    public IterableSerializer(IterableSerializer iterableSerializer, BeanProperty beanProperty, TypeSerializer typeSerializer, JsonSerializer<?> jsonSerializer, Boolean bool) {
        super(iterableSerializer, beanProperty, typeSerializer, jsonSerializer, bool);
    }
}

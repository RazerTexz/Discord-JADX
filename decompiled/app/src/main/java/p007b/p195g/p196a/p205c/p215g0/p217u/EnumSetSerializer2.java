package p007b.p195g.p196a.p205c.p215g0.p217u;

import java.io.IOException;
import java.util.EnumSet;
import java.util.Iterator;
import p007b.p195g.p196a.p198b.JsonGenerator;
import p007b.p195g.p196a.p205c.BeanProperty;
import p007b.p195g.p196a.p205c.JavaType;
import p007b.p195g.p196a.p205c.JsonSerializer;
import p007b.p195g.p196a.p205c.SerializationFeature;
import p007b.p195g.p196a.p205c.SerializerProvider;
import p007b.p195g.p196a.p205c.p212e0.TypeSerializer;
import p007b.p195g.p196a.p205c.p215g0.ContainerSerializer;

/* JADX INFO: renamed from: b.g.a.c.g0.u.n, reason: use source file name */
/* JADX INFO: compiled from: EnumSetSerializer.java */
/* JADX INFO: loaded from: classes3.dex */
public class EnumSetSerializer2 extends AsArraySerializerBase<EnumSet<? extends Enum<?>>> {
    public EnumSetSerializer2(JavaType javaType) {
        super((Class<?>) EnumSet.class, javaType, true, (TypeSerializer) null, (JsonSerializer<Object>) null);
    }

    @Override // p007b.p195g.p196a.p205c.JsonSerializer
    /* JADX INFO: renamed from: d */
    public boolean mo2021d(SerializerProvider serializerProvider, Object obj) {
        return ((EnumSet) obj).isEmpty();
    }

    @Override // p007b.p195g.p196a.p205c.p215g0.p217u.AsArraySerializerBase, p007b.p195g.p196a.p205c.JsonSerializer
    /* JADX INFO: renamed from: f */
    public void mo1807f(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        EnumSet<? extends Enum<?>> enumSet = (EnumSet) obj;
        int size = enumSet.size();
        if (size == 1 && ((this._unwrapSingle == null && serializerProvider.m2240D(SerializationFeature.WRITE_SINGLE_ELEM_ARRAYS_UNWRAPPED)) || this._unwrapSingle == Boolean.TRUE)) {
            m2069u(enumSet, jsonGenerator, serializerProvider);
            return;
        }
        jsonGenerator.mo1649b0(enumSet, size);
        m2069u(enumSet, jsonGenerator, serializerProvider);
        jsonGenerator.mo1663t();
    }

    @Override // p007b.p195g.p196a.p205c.p215g0.ContainerSerializer
    /* JADX INFO: renamed from: p */
    public ContainerSerializer mo1995p(TypeSerializer typeSerializer) {
        return this;
    }

    @Override // p007b.p195g.p196a.p205c.p215g0.ContainerSerializer
    /* JADX INFO: renamed from: q */
    public boolean mo1996q(Object obj) {
        return ((EnumSet) obj).size() == 1;
    }

    @Override // p007b.p195g.p196a.p205c.p215g0.p217u.AsArraySerializerBase
    /* JADX INFO: renamed from: s */
    public /* bridge */ /* synthetic */ void mo2022s(EnumSet<? extends Enum<?>> enumSet, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        m2069u(enumSet, jsonGenerator, serializerProvider);
    }

    @Override // p007b.p195g.p196a.p205c.p215g0.p217u.AsArraySerializerBase
    /* JADX INFO: renamed from: t */
    public AsArraySerializerBase<EnumSet<? extends Enum<?>>> mo2023t(BeanProperty beanProperty, TypeSerializer typeSerializer, JsonSerializer jsonSerializer, Boolean bool) {
        return new EnumSetSerializer2(this, beanProperty, typeSerializer, jsonSerializer, bool);
    }

    /* JADX INFO: renamed from: u */
    public void m2069u(EnumSet<? extends Enum<?>> enumSet, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        JsonSerializer<Object> jsonSerializerM2250n = this._elementSerializer;
        Iterator it = enumSet.iterator();
        while (it.hasNext()) {
            Enum r1 = (Enum) it.next();
            if (jsonSerializerM2250n == null) {
                jsonSerializerM2250n = serializerProvider.m2250n(r1.getDeclaringClass(), this._property);
            }
            jsonSerializerM2250n.mo1807f(r1, jsonGenerator, serializerProvider);
        }
    }

    public EnumSetSerializer2(EnumSetSerializer2 enumSetSerializer2, BeanProperty beanProperty, TypeSerializer typeSerializer, JsonSerializer<?> jsonSerializer, Boolean bool) {
        super(enumSetSerializer2, beanProperty, typeSerializer, jsonSerializer, bool);
    }
}

package p007b.p195g.p196a.p205c.p215g0.p217u;

import com.fasterxml.jackson.databind.JsonMappingException;
import java.io.IOException;
import java.util.Objects;
import p007b.p195g.p196a.p197a.JsonFormat;
import p007b.p195g.p196a.p198b.JsonGenerator;
import p007b.p195g.p196a.p198b.JsonToken2;
import p007b.p195g.p196a.p198b.p203s.WritableTypeId;
import p007b.p195g.p196a.p205c.BeanProperty;
import p007b.p195g.p196a.p205c.JsonSerializer;
import p007b.p195g.p196a.p205c.SerializationFeature;
import p007b.p195g.p196a.p205c.SerializerProvider;
import p007b.p195g.p196a.p205c.p212e0.TypeSerializer;
import p007b.p195g.p196a.p205c.p215g0.ContainerSerializer;
import p007b.p195g.p196a.p205c.p215g0.ContextualSerializer;

/* JADX INFO: renamed from: b.g.a.c.g0.u.a, reason: use source file name */
/* JADX INFO: compiled from: ArraySerializerBase.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class ArraySerializerBase<T> extends ContainerSerializer<T> implements ContextualSerializer {
    public final BeanProperty _property;
    public final Boolean _unwrapSingle;

    public ArraySerializerBase(Class<T> cls) {
        super(cls);
        this._property = null;
        this._unwrapSingle = null;
    }

    /* JADX INFO: renamed from: a */
    public JsonSerializer<?> mo1997a(SerializerProvider serializerProvider, BeanProperty beanProperty) throws JsonMappingException {
        JsonFormat.d dVarM2074l;
        if (beanProperty != null && (dVarM2074l = m2074l(serializerProvider, beanProperty, this._handledType)) != null) {
            Boolean boolM1598b = dVarM2074l.m1598b(JsonFormat.a.WRITE_SINGLE_ELEM_ARRAYS_UNWRAPPED);
            if (!Objects.equals(boolM1598b, this._unwrapSingle)) {
                return mo2037s(beanProperty, boolM1598b);
            }
        }
        return this;
    }

    @Override // p007b.p195g.p196a.p205c.JsonSerializer
    /* JADX INFO: renamed from: f */
    public void mo1807f(T t, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        if (m2044r(serializerProvider) && mo1996q(t)) {
            mo2038t(t, jsonGenerator, serializerProvider);
            return;
        }
        jsonGenerator.mo1646X(t);
        mo2038t(t, jsonGenerator, serializerProvider);
        jsonGenerator.mo1663t();
    }

    @Override // p007b.p195g.p196a.p205c.JsonSerializer
    /* JADX INFO: renamed from: g */
    public final void mo1808g(T t, JsonGenerator jsonGenerator, SerializerProvider serializerProvider, TypeSerializer typeSerializer) throws IOException {
        WritableTypeId writableTypeIdMo1959e = typeSerializer.mo1959e(jsonGenerator, typeSerializer.m1958d(t, JsonToken2.START_ARRAY));
        jsonGenerator.mo1654e(t);
        mo2038t(t, jsonGenerator, serializerProvider);
        typeSerializer.mo1960f(jsonGenerator, writableTypeIdMo1959e);
    }

    /* JADX INFO: renamed from: r */
    public final boolean m2044r(SerializerProvider serializerProvider) {
        Boolean bool = this._unwrapSingle;
        return bool == null ? serializerProvider.m2240D(SerializationFeature.WRITE_SINGLE_ELEM_ARRAYS_UNWRAPPED) : bool.booleanValue();
    }

    /* JADX INFO: renamed from: s */
    public abstract JsonSerializer<?> mo2037s(BeanProperty beanProperty, Boolean bool);

    /* JADX INFO: renamed from: t */
    public abstract void mo2038t(T t, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException;

    public ArraySerializerBase(ArraySerializerBase<?> arraySerializerBase, BeanProperty beanProperty, Boolean bool) {
        super(arraySerializerBase._handledType, false);
        this._property = beanProperty;
        this._unwrapSingle = bool;
    }
}

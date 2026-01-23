package p007b.p195g.p196a.p205c.p215g0.p217u;

import com.fasterxml.jackson.databind.JsonMappingException;
import java.io.IOException;
import java.util.Objects;
import p007b.p195g.p196a.p197a.JsonFormat;
import p007b.p195g.p196a.p198b.JsonGenerator;
import p007b.p195g.p196a.p198b.JsonToken2;
import p007b.p195g.p196a.p198b.p203s.WritableTypeId;
import p007b.p195g.p196a.p205c.AnnotationIntrospector;
import p007b.p195g.p196a.p205c.BeanProperty;
import p007b.p195g.p196a.p205c.JavaType;
import p007b.p195g.p196a.p205c.JsonSerializer;
import p007b.p195g.p196a.p205c.SerializationFeature;
import p007b.p195g.p196a.p205c.SerializerProvider;
import p007b.p195g.p196a.p205c.p210c0.AnnotatedMember;
import p007b.p195g.p196a.p205c.p212e0.TypeSerializer;
import p007b.p195g.p196a.p205c.p215g0.ContainerSerializer;
import p007b.p195g.p196a.p205c.p215g0.ContextualSerializer;
import p007b.p195g.p196a.p205c.p215g0.p216t.PropertySerializerMap;

/* JADX INFO: renamed from: b.g.a.c.g0.u.b, reason: use source file name */
/* JADX INFO: compiled from: AsArraySerializerBase.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AsArraySerializerBase<T> extends ContainerSerializer<T> implements ContextualSerializer {
    public PropertySerializerMap _dynamicSerializers;
    public final JsonSerializer<Object> _elementSerializer;
    public final JavaType _elementType;
    public final BeanProperty _property;
    public final boolean _staticTyping;
    public final Boolean _unwrapSingle;
    public final TypeSerializer _valueTypeSerializer;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AsArraySerializerBase(Class<?> cls, JavaType javaType, boolean z2, TypeSerializer typeSerializer, JsonSerializer<Object> jsonSerializer) {
        super(cls, false);
        boolean z3 = false;
        this._elementType = javaType;
        if (z2 || (javaType != null && javaType.m2220x())) {
            z3 = true;
        }
        this._staticTyping = z3;
        this._valueTypeSerializer = typeSerializer;
        this._property = null;
        this._elementSerializer = jsonSerializer;
        this._dynamicSerializers = PropertySerializerMap.b.f4828b;
        this._unwrapSingle = null;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0020  */
    @Override // p007b.p195g.p196a.p205c.p215g0.ContextualSerializer
    /* JADX INFO: renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public JsonSerializer<?> mo1997a(SerializerProvider serializerProvider, BeanProperty beanProperty) throws JsonMappingException {
        JsonSerializer<?> jsonSerializerMo2000H;
        JavaType javaType;
        Object objMo1775c;
        TypeSerializer typeSerializerMo1955a = this._valueTypeSerializer;
        if (typeSerializerMo1955a != null) {
            typeSerializerMo1955a = typeSerializerMo1955a.mo1955a(beanProperty);
        }
        if (beanProperty != null) {
            AnnotationIntrospector annotationIntrospectorM2257v = serializerProvider.m2257v();
            AnnotatedMember member = beanProperty.getMember();
            jsonSerializerMo2000H = (member == null || (objMo1775c = annotationIntrospectorM2257v.mo1775c(member)) == null) ? null : serializerProvider.mo2000H(member, objMo1775c);
        }
        JsonFormat.d dVarM2074l = m2074l(serializerProvider, beanProperty, this._handledType);
        Boolean boolM1598b = dVarM2074l != null ? dVarM2074l.m1598b(JsonFormat.a.WRITE_SINGLE_ELEM_ARRAYS_UNWRAPPED) : null;
        if (jsonSerializerMo2000H == null) {
            jsonSerializerMo2000H = this._elementSerializer;
        }
        JsonSerializer<?> jsonSerializerM2073k = m2073k(serializerProvider, beanProperty, jsonSerializerMo2000H);
        if (jsonSerializerM2073k == null && (javaType = this._elementType) != null && this._staticTyping && !javaType.m2221y()) {
            jsonSerializerM2073k = serializerProvider.m2249m(this._elementType, beanProperty);
        }
        return (jsonSerializerM2073k == this._elementSerializer && beanProperty == this._property && this._valueTypeSerializer == typeSerializerMo1955a && Objects.equals(this._unwrapSingle, boolM1598b)) ? this : mo2023t(beanProperty, typeSerializerMo1955a, jsonSerializerM2073k, boolM1598b);
    }

    @Override // p007b.p195g.p196a.p205c.JsonSerializer
    /* JADX INFO: renamed from: f */
    public void mo1807f(T t, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        if (serializerProvider.m2240D(SerializationFeature.WRITE_SINGLE_ELEM_ARRAYS_UNWRAPPED) && mo1996q(t)) {
            mo2022s(t, jsonGenerator, serializerProvider);
            return;
        }
        jsonGenerator.mo1646X(t);
        mo2022s(t, jsonGenerator, serializerProvider);
        jsonGenerator.mo1663t();
    }

    @Override // p007b.p195g.p196a.p205c.JsonSerializer
    /* JADX INFO: renamed from: g */
    public void mo1808g(T t, JsonGenerator jsonGenerator, SerializerProvider serializerProvider, TypeSerializer typeSerializer) throws IOException {
        WritableTypeId writableTypeIdMo1959e = typeSerializer.mo1959e(jsonGenerator, typeSerializer.m1958d(t, JsonToken2.START_ARRAY));
        jsonGenerator.mo1654e(t);
        mo2022s(t, jsonGenerator, serializerProvider);
        typeSerializer.mo1960f(jsonGenerator, writableTypeIdMo1959e);
    }

    /* JADX INFO: renamed from: r */
    public final JsonSerializer<Object> m2045r(PropertySerializerMap propertySerializerMap, Class<?> cls, SerializerProvider serializerProvider) throws JsonMappingException {
        JsonSerializer<Object> jsonSerializerM2250n = serializerProvider.m2250n(cls, this._property);
        PropertySerializerMap propertySerializerMapMo2033b = propertySerializerMap.mo2033b(cls, jsonSerializerM2250n);
        if (propertySerializerMap != propertySerializerMapMo2033b) {
            this._dynamicSerializers = propertySerializerMapMo2033b;
        }
        return jsonSerializerM2250n;
    }

    /* JADX INFO: renamed from: s */
    public abstract void mo2022s(T t, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException;

    /* JADX INFO: renamed from: t */
    public abstract AsArraySerializerBase<T> mo2023t(BeanProperty beanProperty, TypeSerializer typeSerializer, JsonSerializer<?> jsonSerializer, Boolean bool);

    public AsArraySerializerBase(AsArraySerializerBase<?> asArraySerializerBase, BeanProperty beanProperty, TypeSerializer typeSerializer, JsonSerializer<?> jsonSerializer, Boolean bool) {
        super(asArraySerializerBase);
        this._elementType = asArraySerializerBase._elementType;
        this._staticTyping = asArraySerializerBase._staticTyping;
        this._valueTypeSerializer = typeSerializer;
        this._property = beanProperty;
        this._elementSerializer = jsonSerializer;
        this._dynamicSerializers = PropertySerializerMap.b.f4828b;
        this._unwrapSingle = bool;
    }
}

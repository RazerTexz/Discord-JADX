package p007b.p195g.p196a.p205c.p215g0.p217u;

import com.fasterxml.jackson.databind.JsonMappingException;
import java.io.IOException;
import java.util.Objects;
import p007b.p195g.p196a.p197a.JsonFormat;
import p007b.p195g.p196a.p198b.JsonGenerator;
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
import p007b.p195g.p196a.p205c.p220y.JacksonStdImpl;

/* JADX INFO: renamed from: b.g.a.c.g0.u.d0, reason: use source file name */
/* JADX INFO: compiled from: ObjectArraySerializer.java */
/* JADX INFO: loaded from: classes3.dex */
@JacksonStdImpl
public class ObjectArraySerializer2 extends ArraySerializerBase<Object[]> implements ContextualSerializer {
    public PropertySerializerMap _dynamicSerializers;
    public JsonSerializer<Object> _elementSerializer;
    public final JavaType _elementType;
    public final boolean _staticTyping;
    public final TypeSerializer _valueTypeSerializer;

    public ObjectArraySerializer2(JavaType javaType, boolean z2, TypeSerializer typeSerializer, JsonSerializer<Object> jsonSerializer) {
        super(Object[].class);
        this._elementType = javaType;
        this._staticTyping = z2;
        this._valueTypeSerializer = typeSerializer;
        this._dynamicSerializers = PropertySerializerMap.b.f4828b;
        this._elementSerializer = jsonSerializer;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0021  */
    @Override // p007b.p195g.p196a.p205c.p215g0.p217u.ArraySerializerBase, p007b.p195g.p196a.p205c.p215g0.ContextualSerializer
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
        TypeSerializer typeSerializer = typeSerializerMo1955a;
        if (beanProperty != null) {
            AnnotatedMember member = beanProperty.getMember();
            jsonSerializerMo2000H = (member == null || (objMo1775c = serializerProvider.m2257v().mo1775c(member)) == null) ? null : serializerProvider.mo2000H(member, objMo1775c);
        }
        JsonFormat.d dVarM2074l = m2074l(serializerProvider, beanProperty, this._handledType);
        Boolean boolM1598b = dVarM2074l != null ? dVarM2074l.m1598b(JsonFormat.a.WRITE_SINGLE_ELEM_ARRAYS_UNWRAPPED) : null;
        if (jsonSerializerMo2000H == null) {
            jsonSerializerMo2000H = this._elementSerializer;
        }
        JsonSerializer<?> jsonSerializerM2073k = m2073k(serializerProvider, beanProperty, jsonSerializerMo2000H);
        JsonSerializer<?> jsonSerializerM2249m = (jsonSerializerM2073k != null || (javaType = this._elementType) == null || !this._staticTyping || javaType.m2221y()) ? jsonSerializerM2073k : serializerProvider.m2249m(this._elementType, beanProperty);
        return (this._property == beanProperty && jsonSerializerM2249m == this._elementSerializer && this._valueTypeSerializer == typeSerializer && Objects.equals(this._unwrapSingle, boolM1598b)) ? this : new ObjectArraySerializer2(this, beanProperty, typeSerializer, jsonSerializerM2249m, boolM1598b);
    }

    @Override // p007b.p195g.p196a.p205c.JsonSerializer
    /* JADX INFO: renamed from: d */
    public boolean mo2021d(SerializerProvider serializerProvider, Object obj) {
        return ((Object[]) obj).length == 0;
    }

    @Override // p007b.p195g.p196a.p205c.p215g0.p217u.ArraySerializerBase, p007b.p195g.p196a.p205c.JsonSerializer
    /* JADX INFO: renamed from: f */
    public void mo1807f(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        Object[] objArr = (Object[]) obj;
        int length = objArr.length;
        if (length == 1 && ((this._unwrapSingle == null && serializerProvider.m2240D(SerializationFeature.WRITE_SINGLE_ELEM_ARRAYS_UNWRAPPED)) || this._unwrapSingle == Boolean.TRUE)) {
            m2057u(objArr, jsonGenerator, serializerProvider);
            return;
        }
        jsonGenerator.mo1649b0(objArr, length);
        m2057u(objArr, jsonGenerator, serializerProvider);
        jsonGenerator.mo1663t();
    }

    @Override // p007b.p195g.p196a.p205c.p215g0.ContainerSerializer
    /* JADX INFO: renamed from: p */
    public ContainerSerializer<?> mo1995p(TypeSerializer typeSerializer) {
        return new ObjectArraySerializer2(this._elementType, this._staticTyping, typeSerializer, this._elementSerializer);
    }

    @Override // p007b.p195g.p196a.p205c.p215g0.ContainerSerializer
    /* JADX INFO: renamed from: q */
    public boolean mo1996q(Object obj) {
        return ((Object[]) obj).length == 1;
    }

    @Override // p007b.p195g.p196a.p205c.p215g0.p217u.ArraySerializerBase
    /* JADX INFO: renamed from: s */
    public JsonSerializer<?> mo2037s(BeanProperty beanProperty, Boolean bool) {
        return new ObjectArraySerializer2(this, beanProperty, this._valueTypeSerializer, this._elementSerializer, bool);
    }

    @Override // p007b.p195g.p196a.p205c.p215g0.p217u.ArraySerializerBase
    /* JADX INFO: renamed from: t */
    public /* bridge */ /* synthetic */ void mo2038t(Object[] objArr, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        m2057u(objArr, jsonGenerator, serializerProvider);
    }

    /* JADX INFO: renamed from: u */
    public void m2057u(Object[] objArr, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        Object obj;
        Object obj2;
        PropertySerializerMap propertySerializerMapMo2033b;
        int length = objArr.length;
        if (length == 0) {
            return;
        }
        JsonSerializer<Object> jsonSerializer = this._elementSerializer;
        int i = 0;
        if (jsonSerializer != null) {
            int length2 = objArr.length;
            TypeSerializer typeSerializer = this._valueTypeSerializer;
            Object obj3 = null;
            while (i < length2) {
                try {
                    obj3 = objArr[i];
                    if (obj3 == null) {
                        serializerProvider.m2248l(jsonGenerator);
                    } else if (typeSerializer == null) {
                        jsonSerializer.mo1807f(obj3, jsonGenerator, serializerProvider);
                    } else {
                        jsonSerializer.mo1808g(obj3, jsonGenerator, serializerProvider, typeSerializer);
                    }
                    i++;
                } catch (Exception e) {
                    m2076n(serializerProvider, e, obj3, i);
                    throw null;
                }
            }
            return;
        }
        TypeSerializer typeSerializer2 = this._valueTypeSerializer;
        if (typeSerializer2 != null) {
            int length3 = objArr.length;
            try {
                PropertySerializerMap propertySerializerMap = this._dynamicSerializers;
                obj2 = null;
                while (i < length3) {
                    try {
                        obj2 = objArr[i];
                        if (obj2 == null) {
                            serializerProvider.m2248l(jsonGenerator);
                        } else {
                            Class<?> cls = obj2.getClass();
                            JsonSerializer<Object> jsonSerializerMo2034c = propertySerializerMap.mo2034c(cls);
                            if (jsonSerializerMo2034c == null && propertySerializerMap != (propertySerializerMapMo2033b = propertySerializerMap.mo2033b(cls, (jsonSerializerMo2034c = serializerProvider.m2250n(cls, this._property))))) {
                                this._dynamicSerializers = propertySerializerMapMo2033b;
                            }
                            jsonSerializerMo2034c.mo1808g(obj2, jsonGenerator, serializerProvider, typeSerializer2);
                        }
                        i++;
                    } catch (Exception e2) {
                        e = e2;
                        m2076n(serializerProvider, e, obj2, i);
                        throw null;
                    }
                }
            } catch (Exception e3) {
                e = e3;
                obj2 = null;
            }
        } else {
            try {
                PropertySerializerMap propertySerializerMap2 = this._dynamicSerializers;
                obj = null;
                while (i < length) {
                    try {
                        obj = objArr[i];
                        if (obj == null) {
                            serializerProvider.m2248l(jsonGenerator);
                        } else {
                            Class<?> cls2 = obj.getClass();
                            JsonSerializer<Object> jsonSerializerMo2034c2 = propertySerializerMap2.mo2034c(cls2);
                            if (jsonSerializerMo2034c2 == null) {
                                if (this._elementType.mo2102r()) {
                                    PropertySerializerMap.d dVarM2032a = propertySerializerMap2.m2032a(serializerProvider.m2247k(this._elementType, cls2), serializerProvider, this._property);
                                    PropertySerializerMap propertySerializerMap3 = dVarM2032a.f4831b;
                                    if (propertySerializerMap2 != propertySerializerMap3) {
                                        this._dynamicSerializers = propertySerializerMap3;
                                    }
                                    jsonSerializerMo2034c2 = dVarM2032a.f4830a;
                                } else {
                                    jsonSerializerMo2034c2 = serializerProvider.m2250n(cls2, this._property);
                                    PropertySerializerMap propertySerializerMapMo2033b2 = propertySerializerMap2.mo2033b(cls2, jsonSerializerMo2034c2);
                                    if (propertySerializerMap2 != propertySerializerMapMo2033b2) {
                                        this._dynamicSerializers = propertySerializerMapMo2033b2;
                                    }
                                }
                            }
                            jsonSerializerMo2034c2.mo1807f(obj, jsonGenerator, serializerProvider);
                        }
                        i++;
                    } catch (Exception e4) {
                        e = e4;
                        m2076n(serializerProvider, e, obj, i);
                        throw null;
                    }
                }
            } catch (Exception e5) {
                e = e5;
                obj = null;
            }
        }
    }

    public ObjectArraySerializer2(ObjectArraySerializer2 objectArraySerializer2, BeanProperty beanProperty, TypeSerializer typeSerializer, JsonSerializer<?> jsonSerializer, Boolean bool) {
        super(objectArraySerializer2, beanProperty, bool);
        this._elementType = objectArraySerializer2._elementType;
        this._valueTypeSerializer = typeSerializer;
        this._staticTyping = objectArraySerializer2._staticTyping;
        this._dynamicSerializers = PropertySerializerMap.b.f4828b;
        this._elementSerializer = jsonSerializer;
    }
}

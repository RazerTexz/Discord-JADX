package p007b.p195g.p196a.p205c.p215g0.p216t;

import com.fasterxml.jackson.databind.JsonMappingException;
import java.io.IOException;
import java.util.Map;
import java.util.Objects;
import p007b.p085c.p086a.p087a0.AnimatableValueParser;
import p007b.p100d.p104b.p105a.outline;
import p007b.p195g.p196a.p197a.JsonInclude;
import p007b.p195g.p196a.p198b.JsonGenerator;
import p007b.p195g.p196a.p198b.JsonToken2;
import p007b.p195g.p196a.p198b.p203s.WritableTypeId;
import p007b.p195g.p196a.p205c.AnnotationIntrospector;
import p007b.p195g.p196a.p205c.BeanProperty;
import p007b.p195g.p196a.p205c.JavaType;
import p007b.p195g.p196a.p205c.JsonSerializer;
import p007b.p195g.p196a.p205c.SerializerProvider;
import p007b.p195g.p196a.p205c.p210c0.AnnotatedMember;
import p007b.p195g.p196a.p205c.p212e0.TypeSerializer;
import p007b.p195g.p196a.p205c.p215g0.ContainerSerializer;
import p007b.p195g.p196a.p205c.p215g0.ContextualSerializer;
import p007b.p195g.p196a.p205c.p215g0.p216t.PropertySerializerMap;
import p007b.p195g.p196a.p205c.p220y.JacksonStdImpl;

/* compiled from: MapEntrySerializer.java */
@JacksonStdImpl
/* renamed from: b.g.a.c.g0.t.i, reason: use source file name */
/* loaded from: classes3.dex */
public class MapEntrySerializer extends ContainerSerializer<Map.Entry<?, ?>> implements ContextualSerializer {
    public PropertySerializerMap _dynamicValueSerializers;
    public final JavaType _entryType;
    public JsonSerializer<Object> _keySerializer;
    public final JavaType _keyType;
    public final BeanProperty _property;
    public final boolean _suppressNulls;
    public final Object _suppressableValue;
    public JsonSerializer<Object> _valueSerializer;
    public final JavaType _valueType;
    public final boolean _valueTypeIsStatic;
    public final TypeSerializer _valueTypeSerializer;

    public MapEntrySerializer(JavaType javaType, JavaType javaType2, JavaType javaType3, boolean z2, TypeSerializer typeSerializer, BeanProperty beanProperty) {
        super(javaType);
        this._entryType = javaType;
        this._keyType = javaType2;
        this._valueType = javaType3;
        this._valueTypeIsStatic = z2;
        this._valueTypeSerializer = typeSerializer;
        this._property = beanProperty;
        this._dynamicValueSerializers = PropertySerializerMap.b.f4828b;
        this._suppressableValue = null;
        this._suppressNulls = false;
    }

    @Override // p007b.p195g.p196a.p205c.p215g0.ContextualSerializer
    /* renamed from: a */
    public JsonSerializer<?> mo1997a(SerializerProvider serializerProvider, BeanProperty beanProperty) throws JsonMappingException {
        JsonSerializer<Object> jsonSerializerMo2000H;
        JsonSerializer<?> jsonSerializerMo2000H2;
        Object obj;
        boolean zMo1999B;
        JsonInclude.b bVarMo1929b;
        JsonInclude.a aVar;
        Object objM572t0 = JsonInclude.a.NON_EMPTY;
        AnnotationIntrospector annotationIntrospectorM2257v = serializerProvider.m2257v();
        AnnotatedMember member = beanProperty == null ? null : beanProperty.getMember();
        if (member == null || annotationIntrospectorM2257v == null) {
            jsonSerializerMo2000H = null;
            jsonSerializerMo2000H2 = null;
        } else {
            Object objMo1788l = annotationIntrospectorM2257v.mo1788l(member);
            jsonSerializerMo2000H2 = objMo1788l != null ? serializerProvider.mo2000H(member, objMo1788l) : null;
            Object objMo1775c = annotationIntrospectorM2257v.mo1775c(member);
            jsonSerializerMo2000H = objMo1775c != null ? serializerProvider.mo2000H(member, objMo1775c) : null;
        }
        if (jsonSerializerMo2000H == null) {
            jsonSerializerMo2000H = this._valueSerializer;
        }
        JsonSerializer<?> jsonSerializerM2073k = m2073k(serializerProvider, beanProperty, jsonSerializerMo2000H);
        if (jsonSerializerM2073k == null && this._valueTypeIsStatic && !this._valueType.m2221y()) {
            jsonSerializerM2073k = serializerProvider.m2249m(this._valueType, beanProperty);
        }
        JsonSerializer<?> jsonSerializer = jsonSerializerM2073k;
        if (jsonSerializerMo2000H2 == null) {
            jsonSerializerMo2000H2 = this._keySerializer;
        }
        JsonSerializer<?> jsonSerializerM2251o = jsonSerializerMo2000H2 == null ? serializerProvider.m2251o(this._keyType, beanProperty) : serializerProvider.m2261z(jsonSerializerMo2000H2, beanProperty);
        Object obj2 = this._suppressableValue;
        boolean z2 = this._suppressNulls;
        if (beanProperty == null || (bVarMo1929b = beanProperty.mo1929b(serializerProvider._config, null)) == null || (aVar = bVarMo1929b._contentInclusion) == JsonInclude.a.USE_DEFAULTS) {
            obj = obj2;
            zMo1999B = z2;
        } else {
            int iOrdinal = aVar.ordinal();
            if (iOrdinal != 1) {
                if (iOrdinal != 2) {
                    if (iOrdinal != 3) {
                        if (iOrdinal == 4) {
                            objM572t0 = AnimatableValueParser.m572t0(this._valueType);
                            if (objM572t0 != null && objM572t0.getClass().isArray()) {
                                objM572t0 = AnimatableValueParser.m560q0(objM572t0);
                            }
                        } else if (iOrdinal != 5) {
                            obj = null;
                            zMo1999B = false;
                        } else {
                            objM572t0 = serializerProvider.mo1998A(null, bVarMo1929b._contentFilter);
                            if (objM572t0 != null) {
                                zMo1999B = serializerProvider.mo1999B(objM572t0);
                                obj = objM572t0;
                            }
                        }
                    }
                } else if (!this._valueType.mo1728b()) {
                    objM572t0 = null;
                }
                obj = objM572t0;
            } else {
                obj = null;
            }
            zMo1999B = true;
        }
        return new MapEntrySerializer(this, jsonSerializerM2251o, jsonSerializer, obj, zMo1999B);
    }

    @Override // p007b.p195g.p196a.p205c.JsonSerializer
    /* renamed from: d */
    public boolean mo2021d(SerializerProvider serializerProvider, Object obj) {
        Object value = ((Map.Entry) obj).getValue();
        if (value == null) {
            return this._suppressNulls;
        }
        if (this._suppressableValue != null) {
            JsonSerializer<Object> jsonSerializer = this._valueSerializer;
            if (jsonSerializer == null) {
                Class<?> cls = value.getClass();
                JsonSerializer<Object> jsonSerializerMo2034c = this._dynamicValueSerializers.mo2034c(cls);
                if (jsonSerializerMo2034c == null) {
                    try {
                        PropertySerializerMap propertySerializerMap = this._dynamicValueSerializers;
                        BeanProperty beanProperty = this._property;
                        Objects.requireNonNull(propertySerializerMap);
                        JsonSerializer<Object> jsonSerializerM2250n = serializerProvider.m2250n(cls, beanProperty);
                        PropertySerializerMap propertySerializerMapMo2033b = propertySerializerMap.mo2033b(cls, jsonSerializerM2250n);
                        if (propertySerializerMap != propertySerializerMapMo2033b) {
                            this._dynamicValueSerializers = propertySerializerMapMo2033b;
                        }
                        jsonSerializer = jsonSerializerM2250n;
                    } catch (JsonMappingException unused) {
                    }
                } else {
                    jsonSerializer = jsonSerializerMo2034c;
                }
            }
            Object obj2 = this._suppressableValue;
            return obj2 == JsonInclude.a.NON_EMPTY ? jsonSerializer.mo2021d(serializerProvider, value) : obj2.equals(value);
        }
        return false;
    }

    @Override // p007b.p195g.p196a.p205c.JsonSerializer
    /* renamed from: f */
    public void mo1807f(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        Map.Entry<?, ?> entry = (Map.Entry) obj;
        jsonGenerator.mo1653d0(entry);
        m2030r(entry, jsonGenerator, serializerProvider);
        jsonGenerator.mo1664u();
    }

    @Override // p007b.p195g.p196a.p205c.JsonSerializer
    /* renamed from: g */
    public void mo1808g(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider, TypeSerializer typeSerializer) throws IOException {
        Map.Entry<?, ?> entry = (Map.Entry) obj;
        jsonGenerator.mo1654e(entry);
        WritableTypeId writableTypeIdMo1959e = typeSerializer.mo1959e(jsonGenerator, typeSerializer.m1958d(entry, JsonToken2.START_OBJECT));
        m2030r(entry, jsonGenerator, serializerProvider);
        typeSerializer.mo1960f(jsonGenerator, writableTypeIdMo1959e);
    }

    @Override // p007b.p195g.p196a.p205c.p215g0.ContainerSerializer
    /* renamed from: p */
    public ContainerSerializer<?> mo1995p(TypeSerializer typeSerializer) {
        return new MapEntrySerializer(this, this._keySerializer, this._valueSerializer, this._suppressableValue, this._suppressNulls);
    }

    /* renamed from: r */
    public void m2030r(Map.Entry<?, ?> entry, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        JsonSerializer<Object> jsonSerializer;
        TypeSerializer typeSerializer = this._valueTypeSerializer;
        Object key = entry.getKey();
        JsonSerializer<Object> jsonSerializer2 = key == null ? serializerProvider._nullKeySerializer : this._keySerializer;
        Object value = entry.getValue();
        if (value != null) {
            jsonSerializer = this._valueSerializer;
            if (jsonSerializer == null) {
                Class<?> cls = value.getClass();
                JsonSerializer<Object> jsonSerializerMo2034c = this._dynamicValueSerializers.mo2034c(cls);
                if (jsonSerializerMo2034c != null) {
                    jsonSerializer = jsonSerializerMo2034c;
                } else if (this._valueType.mo2102r()) {
                    PropertySerializerMap propertySerializerMap = this._dynamicValueSerializers;
                    PropertySerializerMap.d dVarM2032a = propertySerializerMap.m2032a(serializerProvider.m2247k(this._valueType, cls), serializerProvider, this._property);
                    PropertySerializerMap propertySerializerMap2 = dVarM2032a.f4831b;
                    if (propertySerializerMap != propertySerializerMap2) {
                        this._dynamicValueSerializers = propertySerializerMap2;
                    }
                    jsonSerializer = dVarM2032a.f4830a;
                } else {
                    PropertySerializerMap propertySerializerMap3 = this._dynamicValueSerializers;
                    BeanProperty beanProperty = this._property;
                    Objects.requireNonNull(propertySerializerMap3);
                    JsonSerializer<Object> jsonSerializerM2250n = serializerProvider.m2250n(cls, beanProperty);
                    PropertySerializerMap propertySerializerMapMo2033b = propertySerializerMap3.mo2033b(cls, jsonSerializerM2250n);
                    if (propertySerializerMap3 != propertySerializerMapMo2033b) {
                        this._dynamicValueSerializers = propertySerializerMapMo2033b;
                    }
                    jsonSerializer = jsonSerializerM2250n;
                }
            }
            Object obj = this._suppressableValue;
            if (obj != null && ((obj == JsonInclude.a.NON_EMPTY && jsonSerializer.mo2021d(serializerProvider, value)) || this._suppressableValue.equals(value))) {
                return;
            }
        } else if (this._suppressNulls) {
            return;
        } else {
            jsonSerializer = serializerProvider._nullValueSerializer;
        }
        jsonSerializer2.mo1807f(key, jsonGenerator, serializerProvider);
        try {
            if (typeSerializer == null) {
                jsonSerializer.mo1807f(value, jsonGenerator, serializerProvider);
            } else {
                jsonSerializer.mo1808g(value, jsonGenerator, serializerProvider, typeSerializer);
            }
        } catch (Exception e) {
            m2077o(serializerProvider, e, entry, outline.m881v("", key));
            throw null;
        }
    }

    public MapEntrySerializer(MapEntrySerializer mapEntrySerializer, JsonSerializer jsonSerializer, JsonSerializer jsonSerializer2, Object obj, boolean z2) {
        super(Map.class, false);
        this._entryType = mapEntrySerializer._entryType;
        this._keyType = mapEntrySerializer._keyType;
        this._valueType = mapEntrySerializer._valueType;
        this._valueTypeIsStatic = mapEntrySerializer._valueTypeIsStatic;
        this._valueTypeSerializer = mapEntrySerializer._valueTypeSerializer;
        this._keySerializer = jsonSerializer;
        this._valueSerializer = jsonSerializer2;
        this._dynamicValueSerializers = PropertySerializerMap.b.f4828b;
        this._property = mapEntrySerializer._property;
        this._suppressableValue = obj;
        this._suppressNulls = z2;
    }
}

package p007b.p195g.p196a.p205c.p215g0.p217u;

import com.fasterxml.jackson.databind.JsonMappingException;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Properties;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;
import p007b.p085c.p086a.p087a0.AnimatableValueParser;
import p007b.p195g.p196a.p197a.JsonFormat;
import p007b.p195g.p196a.p197a.JsonInclude;
import p007b.p195g.p196a.p198b.JsonGenerator;
import p007b.p195g.p196a.p198b.JsonToken2;
import p007b.p195g.p196a.p198b.p203s.WritableTypeId;
import p007b.p195g.p196a.p205c.AnnotationIntrospector;
import p007b.p195g.p196a.p205c.BeanProperty;
import p007b.p195g.p196a.p205c.JavaType;
import p007b.p195g.p196a.p205c.JsonSerializer;
import p007b.p195g.p196a.p205c.SerializationConfig;
import p007b.p195g.p196a.p205c.SerializationFeature;
import p007b.p195g.p196a.p205c.SerializerProvider;
import p007b.p195g.p196a.p205c.p210c0.AnnotatedMember;
import p007b.p195g.p196a.p205c.p212e0.TypeSerializer;
import p007b.p195g.p196a.p205c.p215g0.ContainerSerializer;
import p007b.p195g.p196a.p205c.p215g0.ContextualSerializer;
import p007b.p195g.p196a.p205c.p215g0.p216t.PropertySerializerMap;
import p007b.p195g.p196a.p205c.p218h0.TypeFactory;
import p007b.p195g.p196a.p205c.p219i0.ClassUtil;
import p007b.p195g.p196a.p205c.p219i0.IgnorePropertiesUtil;
import p007b.p195g.p196a.p205c.p220y.JacksonStdImpl;

/* compiled from: MapSerializer.java */
@JacksonStdImpl
/* renamed from: b.g.a.c.g0.u.t, reason: use source file name */
/* loaded from: classes3.dex */
public class MapSerializer2 extends ContainerSerializer<Map<?, ?>> implements ContextualSerializer {

    /* renamed from: k */
    public static final JavaType f4864k = TypeFactory.m2158k();

    /* renamed from: l */
    public static final Object f4865l = JsonInclude.a.NON_EMPTY;
    private static final long serialVersionUID = 1;
    public PropertySerializerMap _dynamicValueSerializers;
    public final Object _filterId;
    public final Set<String> _ignoredEntries;
    public final Set<String> _includedEntries;
    public final IgnorePropertiesUtil _inclusionChecker;
    public JsonSerializer<Object> _keySerializer;
    public final JavaType _keyType;
    public final BeanProperty _property;
    public final boolean _sortKeys;
    public final boolean _suppressNulls;
    public final Object _suppressableValue;
    public JsonSerializer<Object> _valueSerializer;
    public final JavaType _valueType;
    public final boolean _valueTypeIsStatic;
    public final TypeSerializer _valueTypeSerializer;

    public MapSerializer2(Set<String> set, Set<String> set2, JavaType javaType, JavaType javaType2, boolean z2, TypeSerializer typeSerializer, JsonSerializer<?> jsonSerializer, JsonSerializer<?> jsonSerializer2) {
        super(Map.class, false);
        IgnorePropertiesUtil ignorePropertiesUtil = null;
        set = (set == null || set.isEmpty()) ? null : set;
        this._ignoredEntries = set;
        this._includedEntries = set2;
        this._keyType = javaType;
        this._valueType = javaType2;
        this._valueTypeIsStatic = z2;
        this._valueTypeSerializer = typeSerializer;
        this._keySerializer = jsonSerializer;
        this._valueSerializer = jsonSerializer2;
        this._dynamicValueSerializers = PropertySerializerMap.b.f4828b;
        this._property = null;
        this._filterId = null;
        this._sortKeys = false;
        this._suppressableValue = null;
        this._suppressNulls = false;
        if (set2 != null || (set != null && !set.isEmpty())) {
            ignorePropertiesUtil = new IgnorePropertiesUtil(set, set2);
        }
        this._inclusionChecker = ignorePropertiesUtil;
    }

    /* renamed from: s */
    public static MapSerializer2 m2082s(Set<String> set, Set<String> set2, JavaType javaType, boolean z2, TypeSerializer typeSerializer, JsonSerializer<Object> jsonSerializer, JsonSerializer<Object> jsonSerializer2, Object obj) {
        JavaType javaTypeM2158k;
        JavaType javaType2;
        boolean z3;
        if (javaType == null) {
            javaType2 = f4864k;
            javaTypeM2158k = javaType2;
        } else {
            JavaType javaTypeMo2121o = javaType.mo2121o();
            javaTypeM2158k = javaType._class == Properties.class ? TypeFactory.m2158k() : javaType.mo2099k();
            javaType2 = javaTypeMo2121o;
        }
        if (z2) {
            z3 = javaTypeM2158k._class == Object.class ? false : z2;
        } else {
            z3 = javaTypeM2158k != null && javaTypeM2158k.m2220x();
        }
        MapSerializer2 mapSerializer2 = new MapSerializer2(set, set2, javaType2, javaTypeM2158k, z3, typeSerializer, jsonSerializer, jsonSerializer2);
        if (obj == null || mapSerializer2._filterId == obj) {
            return mapSerializer2;
        }
        ClassUtil.m2194z(MapSerializer2.class, mapSerializer2, "withFilterId");
        return new MapSerializer2(mapSerializer2, obj, mapSerializer2._sortKeys);
    }

    /* JADX WARN: Removed duplicated region for block: B:107:0x0194 A[PHI: r11
      0x0194: PHI (r11v1 java.lang.Object) = (r11v0 java.lang.Object), (r11v0 java.lang.Object), (r11v3 java.lang.Object), (r11v4 java.lang.Object) binds: [B:83:0x0151, B:104:0x018f, B:106:0x0193, B:94:0x0167] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // p007b.p195g.p196a.p205c.p215g0.ContextualSerializer
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public JsonSerializer<?> mo1997a(SerializerProvider serializerProvider, BeanProperty beanProperty) throws JsonMappingException {
        JsonSerializer<?> jsonSerializerMo2000H;
        JsonSerializer<Object> jsonSerializerMo2000H2;
        Set<String> set;
        Set<String> set2;
        boolean zBooleanValue;
        JsonInclude.a aVar;
        boolean zMo1999B;
        Object objM572t0;
        Object objMo1783g;
        Boolean boolM1598b;
        AnnotationIntrospector annotationIntrospectorM2257v = serializerProvider.m2257v();
        Object objMo1998A = null;
        AnnotatedMember member = beanProperty == null ? null : beanProperty.getMember();
        if (StdSerializer.m2072j(member, annotationIntrospectorM2257v)) {
            Object objMo1788l = annotationIntrospectorM2257v.mo1788l(member);
            jsonSerializerMo2000H = objMo1788l != null ? serializerProvider.mo2000H(member, objMo1788l) : null;
            Object objMo1775c = annotationIntrospectorM2257v.mo1775c(member);
            jsonSerializerMo2000H2 = objMo1775c != null ? serializerProvider.mo2000H(member, objMo1775c) : null;
        } else {
            jsonSerializerMo2000H = null;
            jsonSerializerMo2000H2 = null;
        }
        if (jsonSerializerMo2000H2 == null) {
            jsonSerializerMo2000H2 = this._valueSerializer;
        }
        JsonSerializer<?> jsonSerializerM2073k = m2073k(serializerProvider, beanProperty, jsonSerializerMo2000H2);
        if (jsonSerializerM2073k == null && this._valueTypeIsStatic && !this._valueType.m2221y()) {
            jsonSerializerM2073k = serializerProvider.m2249m(this._valueType, beanProperty);
        }
        JsonSerializer<?> jsonSerializer = jsonSerializerM2073k;
        if (jsonSerializerMo2000H == null) {
            jsonSerializerMo2000H = this._keySerializer;
        }
        JsonSerializer<?> jsonSerializerM2251o = jsonSerializerMo2000H == null ? serializerProvider.m2251o(this._keyType, beanProperty) : serializerProvider.m2261z(jsonSerializerMo2000H, beanProperty);
        Set<String> hashSet = this._ignoredEntries;
        Set<String> hashSet2 = this._includedEntries;
        if (StdSerializer.m2072j(member, annotationIntrospectorM2257v)) {
            SerializationConfig serializationConfig = serializerProvider._config;
            Set<String> setM1617d = annotationIntrospectorM2257v.mo1800x(serializationConfig, member).m1617d();
            if ((setM1617d == null || setM1617d.isEmpty()) ? false : true) {
                hashSet = hashSet == null ? new HashSet<>() : new HashSet(hashSet);
                Iterator<String> it = setM1617d.iterator();
                while (it.hasNext()) {
                    hashSet.add(it.next());
                }
            }
            Set<String> set3 = annotationIntrospectorM2257v.mo1745A(serializationConfig, member)._included;
            if (set3 != null) {
                hashSet2 = hashSet2 == null ? new HashSet<>() : new HashSet(hashSet2);
                Iterator<String> it2 = set3.iterator();
                while (it2.hasNext()) {
                    hashSet2.add(it2.next());
                }
            }
            zBooleanValue = Boolean.TRUE.equals(annotationIntrospectorM2257v.mo1754J(member));
            set = hashSet;
            set2 = hashSet2;
        } else {
            set = hashSet;
            set2 = hashSet2;
            zBooleanValue = false;
        }
        JsonFormat.d dVarM2074l = m2074l(serializerProvider, beanProperty, Map.class);
        if (dVarM2074l != null && (boolM1598b = dVarM2074l.m1598b(JsonFormat.a.WRITE_SORTED_MAP_ENTRIES)) != null) {
            zBooleanValue = boolM1598b.booleanValue();
        }
        boolean z2 = zBooleanValue;
        ClassUtil.m2194z(MapSerializer2.class, this, "withResolved");
        MapSerializer2 mapSerializer2 = new MapSerializer2(this, beanProperty, jsonSerializerM2251o, jsonSerializer, set, set2);
        MapSerializer2 mapSerializer22 = z2 != mapSerializer2._sortKeys ? new MapSerializer2(mapSerializer2, this._filterId, z2) : mapSerializer2;
        if (member != null && (objMo1783g = annotationIntrospectorM2257v.mo1783g(member)) != null && mapSerializer22._filterId != objMo1783g) {
            ClassUtil.m2194z(MapSerializer2.class, mapSerializer22, "withFilterId");
            mapSerializer22 = new MapSerializer2(mapSerializer22, objMo1783g, mapSerializer22._sortKeys);
        }
        JsonInclude.b bVarMo1929b = beanProperty != null ? beanProperty.mo1929b(serializerProvider._config, Map.class) : serializerProvider._config.mo2272j(Map.class);
        if (bVarMo1929b == null || (aVar = bVarMo1929b._contentInclusion) == JsonInclude.a.USE_DEFAULTS) {
            return mapSerializer22;
        }
        int iOrdinal = aVar.ordinal();
        if (iOrdinal == 1) {
            zMo1999B = true;
        } else if (iOrdinal != 2) {
            if (iOrdinal == 3) {
                objM572t0 = f4865l;
            } else if (iOrdinal == 4) {
                objM572t0 = AnimatableValueParser.m572t0(this._valueType);
                if (objM572t0 != null && objM572t0.getClass().isArray()) {
                    objM572t0 = AnimatableValueParser.m560q0(objM572t0);
                }
            } else if (iOrdinal != 5) {
                zMo1999B = false;
            } else {
                objMo1998A = serializerProvider.mo1998A(null, bVarMo1929b._contentFilter);
                if (objMo1998A != null) {
                    zMo1999B = serializerProvider.mo1999B(objMo1998A);
                }
            }
            objMo1998A = objM572t0;
            zMo1999B = true;
        } else {
            if (this._valueType.mo1728b()) {
                objM572t0 = f4865l;
                objMo1998A = objM572t0;
            }
            zMo1999B = true;
        }
        return mapSerializer22.m2086v(objMo1998A, zMo1999B);
    }

    @Override // p007b.p195g.p196a.p205c.JsonSerializer
    /* renamed from: d */
    public boolean mo2021d(SerializerProvider serializerProvider, Object obj) {
        Map map = (Map) obj;
        if (!map.isEmpty()) {
            Object obj2 = this._suppressableValue;
            if (obj2 == null && !this._suppressNulls) {
                return false;
            }
            JsonSerializer<Object> jsonSerializer = this._valueSerializer;
            boolean z2 = f4865l == obj2;
            if (jsonSerializer != null) {
                for (Object obj3 : map.values()) {
                    if (obj3 == null) {
                        if (!this._suppressNulls) {
                            return false;
                        }
                    } else if (z2) {
                        if (!jsonSerializer.mo2021d(serializerProvider, obj3)) {
                            return false;
                        }
                    } else if (obj2 == null || !obj2.equals(map)) {
                        return false;
                    }
                }
            } else {
                for (Object obj4 : map.values()) {
                    if (obj4 != null) {
                        try {
                            JsonSerializer<Object> jsonSerializerM2083r = m2083r(serializerProvider, obj4);
                            if (z2) {
                                if (!jsonSerializerM2083r.mo2021d(serializerProvider, obj4)) {
                                    return false;
                                }
                            } else if (obj2 == null || !obj2.equals(map)) {
                                return false;
                            }
                        } catch (JsonMappingException unused) {
                            return false;
                        }
                    } else if (!this._suppressNulls) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    @Override // p007b.p195g.p196a.p205c.JsonSerializer
    /* renamed from: f */
    public void mo1807f(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        Map<?, ?> map = (Map) obj;
        jsonGenerator.mo1653d0(map);
        m2085u(map, jsonGenerator, serializerProvider);
        jsonGenerator.mo1664u();
    }

    @Override // p007b.p195g.p196a.p205c.JsonSerializer
    /* renamed from: g */
    public void mo1808g(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider, TypeSerializer typeSerializer) throws IOException {
        Map<?, ?> map = (Map) obj;
        jsonGenerator.mo1654e(map);
        WritableTypeId writableTypeIdMo1959e = typeSerializer.mo1959e(jsonGenerator, typeSerializer.m1958d(map, JsonToken2.START_OBJECT));
        m2085u(map, jsonGenerator, serializerProvider);
        typeSerializer.mo1960f(jsonGenerator, writableTypeIdMo1959e);
    }

    @Override // p007b.p195g.p196a.p205c.p215g0.ContainerSerializer
    /* renamed from: p */
    public ContainerSerializer mo1995p(TypeSerializer typeSerializer) {
        if (this._valueTypeSerializer == typeSerializer) {
            return this;
        }
        ClassUtil.m2194z(MapSerializer2.class, this, "_withValueTypeSerializer");
        return new MapSerializer2(this, typeSerializer, this._suppressableValue, this._suppressNulls);
    }

    /* renamed from: r */
    public final JsonSerializer<Object> m2083r(SerializerProvider serializerProvider, Object obj) throws JsonMappingException {
        Class<?> cls = obj.getClass();
        JsonSerializer<Object> jsonSerializerMo2034c = this._dynamicValueSerializers.mo2034c(cls);
        if (jsonSerializerMo2034c != null) {
            return jsonSerializerMo2034c;
        }
        if (this._valueType.mo2102r()) {
            PropertySerializerMap propertySerializerMap = this._dynamicValueSerializers;
            PropertySerializerMap.d dVarM2032a = propertySerializerMap.m2032a(serializerProvider.m2247k(this._valueType, cls), serializerProvider, this._property);
            PropertySerializerMap propertySerializerMap2 = dVarM2032a.f4831b;
            if (propertySerializerMap != propertySerializerMap2) {
                this._dynamicValueSerializers = propertySerializerMap2;
            }
            return dVarM2032a.f4830a;
        }
        PropertySerializerMap propertySerializerMap3 = this._dynamicValueSerializers;
        BeanProperty beanProperty = this._property;
        Objects.requireNonNull(propertySerializerMap3);
        JsonSerializer<Object> jsonSerializerM2250n = serializerProvider.m2250n(cls, beanProperty);
        PropertySerializerMap propertySerializerMapMo2033b = propertySerializerMap3.mo2033b(cls, jsonSerializerM2250n);
        if (propertySerializerMap3 != propertySerializerMapMo2033b) {
            this._dynamicValueSerializers = propertySerializerMapMo2033b;
        }
        return jsonSerializerM2250n;
    }

    /* renamed from: t */
    public void m2084t(Map<?, ?> map, JsonGenerator jsonGenerator, SerializerProvider serializerProvider, Object obj) throws IOException {
        JsonSerializer<Object> jsonSerializer;
        JsonSerializer<Object> jsonSerializerM2083r;
        boolean z2 = f4865l == obj;
        for (Map.Entry<?, ?> entry : map.entrySet()) {
            Object key = entry.getKey();
            if (key == null) {
                jsonSerializer = serializerProvider._nullKeySerializer;
            } else {
                IgnorePropertiesUtil ignorePropertiesUtil = this._inclusionChecker;
                if (ignorePropertiesUtil == null || !ignorePropertiesUtil.m2201a(key)) {
                    jsonSerializer = this._keySerializer;
                }
            }
            Object value = entry.getValue();
            if (value != null) {
                jsonSerializerM2083r = this._valueSerializer;
                if (jsonSerializerM2083r == null) {
                    jsonSerializerM2083r = m2083r(serializerProvider, value);
                }
                if (z2) {
                    if (jsonSerializerM2083r.mo2021d(serializerProvider, value)) {
                        continue;
                    } else {
                        jsonSerializer.mo1807f(key, jsonGenerator, serializerProvider);
                        jsonSerializerM2083r.mo1808g(value, jsonGenerator, serializerProvider, this._valueTypeSerializer);
                    }
                } else if (obj == null || !obj.equals(value)) {
                    jsonSerializer.mo1807f(key, jsonGenerator, serializerProvider);
                    jsonSerializerM2083r.mo1808g(value, jsonGenerator, serializerProvider, this._valueTypeSerializer);
                }
            } else if (this._suppressNulls) {
                continue;
            } else {
                jsonSerializerM2083r = serializerProvider._nullValueSerializer;
                jsonSerializer.mo1807f(key, jsonGenerator, serializerProvider);
                try {
                    jsonSerializerM2083r.mo1808g(value, jsonGenerator, serializerProvider, this._valueTypeSerializer);
                } catch (Exception e) {
                    m2077o(serializerProvider, e, map, String.valueOf(key));
                    throw null;
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:153:0x0077 A[EXC_TOP_SPLITTER, PHI: r6
      0x0077: PHI (r6v2 b.g.a.c.n<java.lang.Object>) = 
      (r6v1 b.g.a.c.n<java.lang.Object>)
      (r6v4 b.g.a.c.n<java.lang.Object>)
      (r6v4 b.g.a.c.n<java.lang.Object>)
      (r6v4 b.g.a.c.n<java.lang.Object>)
     binds: [B:28:0x0056, B:35:0x006b, B:37:0x006e, B:39:0x0074] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:157:0x01b1 A[EXC_TOP_SPLITTER, PHI: r7
      0x01b1: PHI (r7v5 b.g.a.c.n<java.lang.Object>) = 
      (r7v4 b.g.a.c.n<java.lang.Object>)
      (r7v7 b.g.a.c.n<java.lang.Object>)
      (r7v7 b.g.a.c.n<java.lang.Object>)
      (r7v7 b.g.a.c.n<java.lang.Object>)
     binds: [B:133:0x0194, B:139:0x01a5, B:141:0x01a8, B:143:0x01ae] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC] */
    /* renamed from: u */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void m2085u(Map<?, ?> map, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        TreeMap treeMap;
        JsonSerializer<Object> jsonSerializerM2083r;
        JsonSerializer<Object> jsonSerializer;
        JsonSerializer<Object> jsonSerializerM2083r2;
        Object key;
        if (map.isEmpty()) {
            return;
        }
        if ((this._sortKeys || serializerProvider.m2240D(SerializationFeature.ORDER_MAP_ENTRIES_BY_KEYS)) && !(map instanceof SortedMap)) {
            if ((map instanceof HashMap) && map.containsKey(null)) {
                treeMap = new TreeMap();
                for (Map.Entry<?, ?> entry : map.entrySet()) {
                    Object key2 = entry.getKey();
                    if (key2 == null) {
                        Object value = entry.getValue();
                        JsonSerializer<Object> jsonSerializer2 = serializerProvider._nullKeySerializer;
                        if (value != null) {
                            jsonSerializerM2083r = this._valueSerializer;
                            if (jsonSerializerM2083r == null) {
                                jsonSerializerM2083r = m2083r(serializerProvider, value);
                            }
                            Object obj = this._suppressableValue;
                            if (obj == f4865l) {
                                if (jsonSerializerM2083r.mo2021d(serializerProvider, value)) {
                                    continue;
                                } else {
                                    jsonSerializer2.mo1807f(null, jsonGenerator, serializerProvider);
                                    jsonSerializerM2083r.mo1807f(value, jsonGenerator, serializerProvider);
                                }
                            } else if (obj == null || !obj.equals(value)) {
                            }
                        } else if (this._suppressNulls) {
                            continue;
                        } else {
                            jsonSerializerM2083r = serializerProvider._nullValueSerializer;
                            try {
                                jsonSerializer2.mo1807f(null, jsonGenerator, serializerProvider);
                                jsonSerializerM2083r.mo1807f(value, jsonGenerator, serializerProvider);
                            } catch (Exception e) {
                                m2077o(serializerProvider, e, value, "");
                                throw null;
                            }
                        }
                    } else {
                        treeMap.put(key2, entry.getValue());
                    }
                }
            } else {
                treeMap = new TreeMap(map);
            }
            map = treeMap;
        }
        Object obj2 = this._filterId;
        if (obj2 != null) {
            m2075m(serializerProvider, obj2, map);
            throw null;
        }
        Object obj3 = this._suppressableValue;
        if (obj3 != null || this._suppressNulls) {
            if (this._valueTypeSerializer != null) {
                m2084t(map, jsonGenerator, serializerProvider, obj3);
                return;
            }
            boolean z2 = f4865l == obj3;
            for (Map.Entry<?, ?> entry2 : map.entrySet()) {
                Object key3 = entry2.getKey();
                if (key3 == null) {
                    jsonSerializer = serializerProvider._nullKeySerializer;
                } else {
                    IgnorePropertiesUtil ignorePropertiesUtil = this._inclusionChecker;
                    if (ignorePropertiesUtil == null || !ignorePropertiesUtil.m2201a(key3)) {
                        jsonSerializer = this._keySerializer;
                    }
                }
                Object value2 = entry2.getValue();
                if (value2 != null) {
                    jsonSerializerM2083r2 = this._valueSerializer;
                    if (jsonSerializerM2083r2 == null) {
                        jsonSerializerM2083r2 = m2083r(serializerProvider, value2);
                    }
                    if (z2) {
                        if (jsonSerializerM2083r2.mo2021d(serializerProvider, value2)) {
                            continue;
                        } else {
                            jsonSerializer.mo1807f(key3, jsonGenerator, serializerProvider);
                            jsonSerializerM2083r2.mo1807f(value2, jsonGenerator, serializerProvider);
                        }
                    } else if (obj3 == null || !obj3.equals(value2)) {
                    }
                } else if (this._suppressNulls) {
                    continue;
                } else {
                    jsonSerializerM2083r2 = serializerProvider._nullValueSerializer;
                    try {
                        jsonSerializer.mo1807f(key3, jsonGenerator, serializerProvider);
                        jsonSerializerM2083r2.mo1807f(value2, jsonGenerator, serializerProvider);
                    } catch (Exception e2) {
                        m2077o(serializerProvider, e2, map, String.valueOf(key3));
                        throw null;
                    }
                }
            }
            return;
        }
        JsonSerializer<Object> jsonSerializer3 = this._valueSerializer;
        if (jsonSerializer3 != null) {
            JsonSerializer<Object> jsonSerializer4 = this._keySerializer;
            TypeSerializer typeSerializer = this._valueTypeSerializer;
            for (Map.Entry<?, ?> entry3 : map.entrySet()) {
                Object key4 = entry3.getKey();
                IgnorePropertiesUtil ignorePropertiesUtil2 = this._inclusionChecker;
                if (ignorePropertiesUtil2 == null || !ignorePropertiesUtil2.m2201a(key4)) {
                    if (key4 == null) {
                        serializerProvider._nullKeySerializer.mo1807f(null, jsonGenerator, serializerProvider);
                    } else {
                        jsonSerializer4.mo1807f(key4, jsonGenerator, serializerProvider);
                    }
                    Object value3 = entry3.getValue();
                    if (value3 == null) {
                        serializerProvider.m2248l(jsonGenerator);
                    } else if (typeSerializer == null) {
                        try {
                            jsonSerializer3.mo1807f(value3, jsonGenerator, serializerProvider);
                        } catch (Exception e3) {
                            m2077o(serializerProvider, e3, map, String.valueOf(key4));
                            throw null;
                        }
                    } else {
                        jsonSerializer3.mo1808g(value3, jsonGenerator, serializerProvider, typeSerializer);
                    }
                }
            }
            return;
        }
        if (this._valueTypeSerializer != null) {
            m2084t(map, jsonGenerator, serializerProvider, null);
            return;
        }
        JsonSerializer<Object> jsonSerializer5 = this._keySerializer;
        try {
            key = null;
            for (Map.Entry<?, ?> entry4 : map.entrySet()) {
                try {
                    Object value4 = entry4.getValue();
                    key = entry4.getKey();
                    if (key == null) {
                        serializerProvider._nullKeySerializer.mo1807f(null, jsonGenerator, serializerProvider);
                    } else {
                        IgnorePropertiesUtil ignorePropertiesUtil3 = this._inclusionChecker;
                        if (ignorePropertiesUtil3 == null || !ignorePropertiesUtil3.m2201a(key)) {
                            jsonSerializer5.mo1807f(key, jsonGenerator, serializerProvider);
                        }
                    }
                    if (value4 == null) {
                        serializerProvider.m2248l(jsonGenerator);
                    } else {
                        JsonSerializer<Object> jsonSerializerM2083r3 = this._valueSerializer;
                        if (jsonSerializerM2083r3 == null) {
                            jsonSerializerM2083r3 = m2083r(serializerProvider, value4);
                        }
                        jsonSerializerM2083r3.mo1807f(value4, jsonGenerator, serializerProvider);
                    }
                } catch (Exception e4) {
                    e = e4;
                    m2077o(serializerProvider, e, map, String.valueOf(key));
                    throw null;
                }
            }
        } catch (Exception e5) {
            e = e5;
            key = null;
        }
    }

    /* renamed from: v */
    public MapSerializer2 m2086v(Object obj, boolean z2) {
        if (obj == this._suppressableValue && z2 == this._suppressNulls) {
            return this;
        }
        ClassUtil.m2194z(MapSerializer2.class, this, "withContentInclusion");
        return new MapSerializer2(this, this._valueTypeSerializer, obj, z2);
    }

    public MapSerializer2(MapSerializer2 mapSerializer2, BeanProperty beanProperty, JsonSerializer<?> jsonSerializer, JsonSerializer<?> jsonSerializer2, Set<String> set, Set<String> set2) {
        super(Map.class, false);
        IgnorePropertiesUtil ignorePropertiesUtil = null;
        set = (set == null || set.isEmpty()) ? null : set;
        this._ignoredEntries = set;
        this._includedEntries = set2;
        this._keyType = mapSerializer2._keyType;
        this._valueType = mapSerializer2._valueType;
        this._valueTypeIsStatic = mapSerializer2._valueTypeIsStatic;
        this._valueTypeSerializer = mapSerializer2._valueTypeSerializer;
        this._keySerializer = jsonSerializer;
        this._valueSerializer = jsonSerializer2;
        this._dynamicValueSerializers = PropertySerializerMap.b.f4828b;
        this._property = beanProperty;
        this._filterId = mapSerializer2._filterId;
        this._sortKeys = mapSerializer2._sortKeys;
        this._suppressableValue = mapSerializer2._suppressableValue;
        this._suppressNulls = mapSerializer2._suppressNulls;
        if (set2 != null || (set != null && !set.isEmpty())) {
            ignorePropertiesUtil = new IgnorePropertiesUtil(set, set2);
        }
        this._inclusionChecker = ignorePropertiesUtil;
    }

    public MapSerializer2(MapSerializer2 mapSerializer2, TypeSerializer typeSerializer, Object obj, boolean z2) {
        super(Map.class, false);
        this._ignoredEntries = mapSerializer2._ignoredEntries;
        this._includedEntries = mapSerializer2._includedEntries;
        this._keyType = mapSerializer2._keyType;
        this._valueType = mapSerializer2._valueType;
        this._valueTypeIsStatic = mapSerializer2._valueTypeIsStatic;
        this._valueTypeSerializer = typeSerializer;
        this._keySerializer = mapSerializer2._keySerializer;
        this._valueSerializer = mapSerializer2._valueSerializer;
        this._dynamicValueSerializers = mapSerializer2._dynamicValueSerializers;
        this._property = mapSerializer2._property;
        this._filterId = mapSerializer2._filterId;
        this._sortKeys = mapSerializer2._sortKeys;
        this._suppressableValue = obj;
        this._suppressNulls = z2;
        this._inclusionChecker = mapSerializer2._inclusionChecker;
    }

    public MapSerializer2(MapSerializer2 mapSerializer2, Object obj, boolean z2) {
        super(Map.class, false);
        this._ignoredEntries = mapSerializer2._ignoredEntries;
        this._includedEntries = mapSerializer2._includedEntries;
        this._keyType = mapSerializer2._keyType;
        this._valueType = mapSerializer2._valueType;
        this._valueTypeIsStatic = mapSerializer2._valueTypeIsStatic;
        this._valueTypeSerializer = mapSerializer2._valueTypeSerializer;
        this._keySerializer = mapSerializer2._keySerializer;
        this._valueSerializer = mapSerializer2._valueSerializer;
        this._dynamicValueSerializers = PropertySerializerMap.b.f4828b;
        this._property = mapSerializer2._property;
        this._filterId = obj;
        this._sortKeys = z2;
        this._suppressableValue = mapSerializer2._suppressableValue;
        this._suppressNulls = mapSerializer2._suppressNulls;
        this._inclusionChecker = mapSerializer2._inclusionChecker;
    }
}

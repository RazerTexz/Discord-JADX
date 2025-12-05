package p007b.p195g.p196a.p205c.p215g0;

import com.fasterxml.jackson.databind.JsonMappingException;
import java.io.File;
import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Currency;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.regex.Pattern;
import p007b.p100d.p104b.p105a.outline;
import p007b.p195g.p196a.p197a.JsonInclude;
import p007b.p195g.p196a.p205c.AnnotationIntrospector;
import p007b.p195g.p196a.p205c.BeanDescription;
import p007b.p195g.p196a.p205c.JavaType;
import p007b.p195g.p196a.p205c.JsonSerializable;
import p007b.p195g.p196a.p205c.JsonSerializer;
import p007b.p195g.p196a.p205c.MapperFeature;
import p007b.p195g.p196a.p205c.SerializationConfig;
import p007b.p195g.p196a.p205c.SerializerProvider;
import p007b.p195g.p196a.p205c.p210c0.Annotated;
import p007b.p195g.p196a.p205c.p210c0.AnnotatedClass;
import p007b.p195g.p196a.p205c.p210c0.AnnotatedClassResolver;
import p007b.p195g.p196a.p205c.p210c0.AnnotatedMember;
import p007b.p195g.p196a.p205c.p210c0.BasicBeanDescription;
import p007b.p195g.p196a.p205c.p210c0.POJOPropertiesCollector;
import p007b.p195g.p196a.p205c.p212e0.NamedType;
import p007b.p195g.p196a.p205c.p212e0.TypeResolverBuilder;
import p007b.p195g.p196a.p205c.p212e0.TypeSerializer;
import p007b.p195g.p196a.p205c.p212e0.p213h.StdSubtypeResolver;
import p007b.p195g.p196a.p205c.p215g0.p217u.BooleanSerializer2;
import p007b.p195g.p196a.p205c.p215g0.p217u.CalendarSerializer2;
import p007b.p195g.p196a.p205c.p215g0.p217u.ClassSerializer2;
import p007b.p195g.p196a.p205c.p215g0.p217u.DateSerializer2;
import p007b.p195g.p196a.p205c.p215g0.p217u.FileSerializer;
import p007b.p195g.p196a.p205c.p215g0.p217u.JsonValueSerializer;
import p007b.p195g.p196a.p205c.p215g0.p217u.NullSerializer;
import p007b.p195g.p196a.p205c.p215g0.p217u.NumberSerializer;
import p007b.p195g.p196a.p205c.p215g0.p217u.NumberSerializers;
import p007b.p195g.p196a.p205c.p215g0.p217u.NumberSerializers2;
import p007b.p195g.p196a.p205c.p215g0.p217u.NumberSerializers3;
import p007b.p195g.p196a.p205c.p215g0.p217u.NumberSerializers5;
import p007b.p195g.p196a.p205c.p215g0.p217u.NumberSerializers6;
import p007b.p195g.p196a.p205c.p215g0.p217u.NumberSerializers7;
import p007b.p195g.p196a.p205c.p215g0.p217u.SerializableSerializer;
import p007b.p195g.p196a.p205c.p215g0.p217u.StdDelegatingSerializer;
import p007b.p195g.p196a.p205c.p215g0.p217u.StdJdkSerializers;
import p007b.p195g.p196a.p205c.p215g0.p217u.StdJdkSerializers2;
import p007b.p195g.p196a.p205c.p215g0.p217u.StdJdkSerializers3;
import p007b.p195g.p196a.p205c.p215g0.p217u.StdKeySerializers;
import p007b.p195g.p196a.p205c.p215g0.p217u.StringSerializer2;
import p007b.p195g.p196a.p205c.p215g0.p217u.ToStringSerializer;
import p007b.p195g.p196a.p205c.p215g0.p217u.TokenBufferSerializer;
import p007b.p195g.p196a.p205c.p215g0.p217u.UUIDSerializer;
import p007b.p195g.p196a.p205c.p219i0.ArrayIterator2;
import p007b.p195g.p196a.p205c.p219i0.ClassUtil;
import p007b.p195g.p196a.p205c.p219i0.Converter;
import p007b.p195g.p196a.p205c.p219i0.EnumValues;
import p007b.p195g.p196a.p205c.p219i0.TokenBuffer;
import p007b.p195g.p196a.p205c.p220y.JsonSerialize;
import p007b.p195g.p196a.p205c.p221z.SerializerFactoryConfig;

/* compiled from: BasicSerializerFactory.java */
/* renamed from: b.g.a.c.g0.b, reason: use source file name */
/* loaded from: classes3.dex */
public abstract class BasicSerializerFactory extends SerializerFactory2 implements Serializable {

    /* renamed from: j */
    public static final HashMap<String, JsonSerializer<?>> f4788j;

    /* renamed from: k */
    public static final HashMap<String, Class<? extends JsonSerializer<?>>> f4789k;
    public final SerializerFactoryConfig _factoryConfig;

    static {
        HashMap<String, Class<? extends JsonSerializer<?>>> map = new HashMap<>();
        HashMap<String, JsonSerializer<?>> map2 = new HashMap<>();
        map2.put(String.class.getName(), new StringSerializer2());
        ToStringSerializer toStringSerializer = ToStringSerializer.f4866k;
        map2.put(StringBuffer.class.getName(), toStringSerializer);
        map2.put(StringBuilder.class.getName(), toStringSerializer);
        map2.put(Character.class.getName(), toStringSerializer);
        map2.put(Character.TYPE.getName(), toStringSerializer);
        map2.put(Integer.class.getName(), new NumberSerializers(Integer.class));
        Class cls = Integer.TYPE;
        map2.put(cls.getName(), new NumberSerializers(cls));
        map2.put(Long.class.getName(), new NumberSerializers2(Long.class));
        Class cls2 = Long.TYPE;
        map2.put(cls2.getName(), new NumberSerializers2(cls2));
        String name = Byte.class.getName();
        NumberSerializers7 numberSerializers7 = NumberSerializers7.f4872k;
        map2.put(name, numberSerializers7);
        map2.put(Byte.TYPE.getName(), numberSerializers7);
        String name2 = Short.class.getName();
        NumberSerializers3 numberSerializers3 = NumberSerializers3.f4850k;
        map2.put(name2, numberSerializers3);
        map2.put(Short.TYPE.getName(), numberSerializers3);
        map2.put(Double.class.getName(), new NumberSerializers5(Double.class));
        map2.put(Double.TYPE.getName(), new NumberSerializers5(Double.TYPE));
        String name3 = Float.class.getName();
        NumberSerializers6 numberSerializers6 = NumberSerializers6.f4871k;
        map2.put(name3, numberSerializers6);
        map2.put(Float.TYPE.getName(), numberSerializers6);
        map2.put(Boolean.TYPE.getName(), new BooleanSerializer2(true));
        map2.put(Boolean.class.getName(), new BooleanSerializer2(false));
        map2.put(BigInteger.class.getName(), new NumberSerializer(BigInteger.class));
        map2.put(BigDecimal.class.getName(), new NumberSerializer(BigDecimal.class));
        map2.put(Calendar.class.getName(), CalendarSerializer2.f4854k);
        map2.put(Date.class.getName(), DateSerializer2.f4856k);
        HashMap map3 = new HashMap();
        map3.put(URL.class, new ToStringSerializer(URL.class));
        map3.put(URI.class, new ToStringSerializer(URI.class));
        map3.put(Currency.class, new ToStringSerializer(Currency.class));
        map3.put(UUID.class, new UUIDSerializer());
        map3.put(Pattern.class, new ToStringSerializer(Pattern.class));
        map3.put(Locale.class, new ToStringSerializer(Locale.class));
        map3.put(AtomicBoolean.class, StdJdkSerializers.class);
        map3.put(AtomicInteger.class, StdJdkSerializers2.class);
        map3.put(AtomicLong.class, StdJdkSerializers3.class);
        map3.put(File.class, FileSerializer.class);
        map3.put(Class.class, ClassSerializer2.class);
        NullSerializer nullSerializer = NullSerializer.f4867k;
        map3.put(Void.class, nullSerializer);
        map3.put(Void.TYPE, nullSerializer);
        for (Map.Entry entry : map3.entrySet()) {
            Object value = entry.getValue();
            if (value instanceof JsonSerializer) {
                map2.put(((Class) entry.getKey()).getName(), (JsonSerializer) value);
            } else {
                map.put(((Class) entry.getKey()).getName(), (Class) value);
            }
        }
        map.put(TokenBuffer.class.getName(), TokenBufferSerializer.class);
        f4788j = map2;
        f4789k = map;
    }

    public BasicSerializerFactory(SerializerFactoryConfig serializerFactoryConfig) {
        this._factoryConfig = serializerFactoryConfig == null ? new SerializerFactoryConfig() : serializerFactoryConfig;
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x015a  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x01a2  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x01a8 A[PHI: r3
      0x01a8: PHI (r3v6 b.g.a.c.n<java.lang.Object>) = (r3v5 b.g.a.c.n<java.lang.Object>), (r3v9 b.g.a.c.n<java.lang.Object>) binds: [B:20:0x0046, B:86:0x0121] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // p007b.p195g.p196a.p205c.p215g0.SerializerFactory2
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public JsonSerializer<Object> mo1971a(SerializerProvider serializerProvider, JavaType javaType, JsonSerializer<Object> jsonSerializer) throws JsonMappingException {
        JsonSerializer<?> jsonSerializerM2011b;
        AnnotatedMember annotatedMemberMo1813b;
        StdKeySerializers.a aVar;
        SerializationConfig serializationConfig = serializerProvider._config;
        BeanDescription beanDescriptionM2236u = serializationConfig.m2236u(javaType);
        Serializers[] serializersArr = this._factoryConfig._additionalKeySerializers;
        if (serializersArr.length > 0) {
            ArrayIterator2 arrayIterator2 = new ArrayIterator2(serializersArr);
            jsonSerializerM2011b = null;
            while (arrayIterator2.hasNext() && (jsonSerializerM2011b = ((Serializers) arrayIterator2.next()).m2011b(serializationConfig, javaType, beanDescriptionM2236u)) == null) {
            }
        } else {
            jsonSerializerM2011b = null;
        }
        if (jsonSerializerM2011b == null) {
            BasicBeanDescription basicBeanDescription = (BasicBeanDescription) beanDescriptionM2236u;
            AnnotatedClass annotatedClass = basicBeanDescription.f4736f;
            Object objMo1788l = serializerProvider.m2257v().mo1788l(annotatedClass);
            JsonSerializer<Object> jsonSerializerMo2000H = objMo1788l != null ? serializerProvider.mo2000H(annotatedClass, objMo1788l) : null;
            if (jsonSerializerMo2000H != null) {
                jsonSerializer = jsonSerializerMo2000H;
            } else if (jsonSerializer == null) {
                Class cls = javaType._class;
                JsonSerializer<Object> jsonSerializer2 = StdKeySerializers.f4858a;
                if (cls == null || cls == Object.class) {
                    jsonSerializerMo2000H = new StdKeySerializers.b();
                } else if (cls == String.class) {
                    jsonSerializerMo2000H = StdKeySerializers.f4858a;
                } else {
                    if (cls.isPrimitive()) {
                        Annotation[] annotationArr = ClassUtil.f4944a;
                        if (cls == Integer.TYPE) {
                            cls = Integer.class;
                        } else if (cls == Long.TYPE) {
                            cls = Long.class;
                        } else if (cls == Boolean.TYPE) {
                            cls = Boolean.class;
                        } else if (cls == Double.TYPE) {
                            cls = Double.class;
                        } else if (cls == Float.TYPE) {
                            cls = Float.class;
                        } else if (cls == Byte.TYPE) {
                            cls = Byte.class;
                        } else if (cls == Short.TYPE) {
                            cls = Short.class;
                        } else {
                            if (cls != Character.TYPE) {
                                throw new IllegalArgumentException(outline.m867o(cls, outline.m833U("Class "), " is not a primitive type"));
                            }
                            cls = Character.class;
                        }
                    }
                    if (cls == Integer.class) {
                        aVar = new StdKeySerializers.a(5, cls);
                    } else if (cls == Long.class) {
                        aVar = new StdKeySerializers.a(6, cls);
                    } else if (cls.isPrimitive() || Number.class.isAssignableFrom(cls)) {
                        aVar = new StdKeySerializers.a(8, cls);
                    } else if (cls == Class.class) {
                        aVar = new StdKeySerializers.a(3, cls);
                    } else if (Date.class.isAssignableFrom(cls)) {
                        aVar = new StdKeySerializers.a(1, cls);
                    } else if (Calendar.class.isAssignableFrom(cls)) {
                        aVar = new StdKeySerializers.a(2, cls);
                    } else if (cls == UUID.class) {
                        aVar = new StdKeySerializers.a(8, cls);
                    } else if (cls == byte[].class) {
                        aVar = new StdKeySerializers.a(7, cls);
                    } else {
                        jsonSerializerMo2000H = null;
                    }
                    jsonSerializerMo2000H = aVar;
                }
                if (jsonSerializerMo2000H == null) {
                    POJOPropertiesCollector pOJOPropertiesCollector = basicBeanDescription.f4733c;
                    if (pOJOPropertiesCollector != null) {
                        if (!pOJOPropertiesCollector.f4641i) {
                            pOJOPropertiesCollector.m1829h();
                        }
                        LinkedList<AnnotatedMember> linkedList = pOJOPropertiesCollector.f4649q;
                        if (linkedList == null) {
                            annotatedMemberMo1813b = null;
                        } else {
                            if (linkedList.size() > 1) {
                                pOJOPropertiesCollector.m1830i("Multiple 'as-key' properties defined (%s vs %s)", pOJOPropertiesCollector.f4649q.get(0), pOJOPropertiesCollector.f4649q.get(1));
                                throw null;
                            }
                            annotatedMemberMo1813b = pOJOPropertiesCollector.f4649q.get(0);
                        }
                        if (annotatedMemberMo1813b == null) {
                            annotatedMemberMo1813b = beanDescriptionM2236u.mo1813b();
                        }
                        if (annotatedMemberMo1813b != null) {
                            JsonSerializer<Object> jsonSerializerMo1971a = mo1971a(serializerProvider, annotatedMemberMo1813b.mo1821e(), jsonSerializer);
                            if (serializationConfig.m2265b()) {
                                ClassUtil.m2172d(annotatedMemberMo1813b.mo1888i(), serializationConfig.m2279q(MapperFeature.OVERRIDE_PUBLIC_ACCESS_MODIFIERS));
                            }
                            jsonSerializer = new JsonValueSerializer(annotatedMemberMo1813b, null, jsonSerializerMo1971a);
                        } else {
                            Class<?> cls2 = javaType._class;
                            if (cls2 == null) {
                                jsonSerializer = new StdKeySerializers.a(8, cls2);
                            } else if (cls2 == Enum.class) {
                                jsonSerializer = new StdKeySerializers.b();
                            } else if (ClassUtil.m2185q(cls2)) {
                                jsonSerializer = new StdKeySerializers.c(cls2, EnumValues.m2198a(serializationConfig, cls2));
                            }
                        }
                    }
                }
            }
        } else {
            jsonSerializer = jsonSerializerM2011b;
        }
        if (this._factoryConfig.m2282a()) {
            ArrayIterator2 arrayIterator22 = (ArrayIterator2) this._factoryConfig.m2283b();
            while (arrayIterator22.hasNext()) {
                Objects.requireNonNull((BeanSerializerModifier) arrayIterator22.next());
            }
        }
        return jsonSerializer;
    }

    @Override // p007b.p195g.p196a.p205c.p215g0.SerializerFactory2
    /* renamed from: c */
    public TypeSerializer mo1972c(SerializationConfig serializationConfig, JavaType javaType) {
        ArrayList arrayList;
        AnnotatedClass annotatedClass = ((BasicBeanDescription) serializationConfig.m2277o(javaType._class)).f4736f;
        TypeResolverBuilder<?> typeResolverBuilderMo1760P = serializationConfig.m2267e().mo1760P(serializationConfig, annotatedClass, javaType);
        if (typeResolverBuilderMo1760P == null) {
            typeResolverBuilderMo1760P = serializationConfig._base._typeResolverBuilder;
            arrayList = null;
        } else {
            StdSubtypeResolver stdSubtypeResolver = (StdSubtypeResolver) serializationConfig._subtypeResolver;
            Objects.requireNonNull(stdSubtypeResolver);
            AnnotationIntrospector annotationIntrospectorM2267e = serializationConfig.m2267e();
            HashMap<NamedType, NamedType> map = new HashMap<>();
            LinkedHashSet<NamedType> linkedHashSet = stdSubtypeResolver._registeredSubtypes;
            if (linkedHashSet != null) {
                Class<?> cls = annotatedClass.f4655l;
                for (NamedType namedType : linkedHashSet) {
                    if (cls.isAssignableFrom(namedType._class)) {
                        stdSubtypeResolver.m1965b(AnnotatedClassResolver.m1879h(serializationConfig, namedType._class), namedType, serializationConfig, annotationIntrospectorM2267e, map);
                    }
                }
            }
            stdSubtypeResolver.m1965b(annotatedClass, new NamedType(annotatedClass.f4655l, null), serializationConfig, annotationIntrospectorM2267e, map);
            arrayList = new ArrayList(map.values());
        }
        if (typeResolverBuilderMo1760P == null) {
            return null;
        }
        return typeResolverBuilderMo1760P.mo1953e(serializationConfig, javaType, arrayList);
    }

    /* renamed from: d */
    public JsonInclude.b m1973d(SerializerProvider serializerProvider, BeanDescription beanDescription, JavaType javaType, Class<?> cls) throws JsonMappingException {
        SerializationConfig serializationConfig = serializerProvider._config;
        JsonInclude.b bVarMo1814c = beanDescription.mo1814c(serializationConfig._configOverrides._defaultInclusion);
        serializationConfig._configOverrides.m2263a(cls);
        serializationConfig.m2273k(javaType._class, null);
        return bVarMo1814c;
    }

    /* renamed from: e */
    public final JsonSerializer<?> m1974e(SerializerProvider serializerProvider, JavaType javaType, BeanDescription beanDescription) throws JsonMappingException {
        if (JsonSerializable.class.isAssignableFrom(javaType._class)) {
            return SerializableSerializer.f4853k;
        }
        AnnotatedMember annotatedMemberMo1813b = beanDescription.mo1813b();
        if (annotatedMemberMo1813b == null) {
            return null;
        }
        if (serializerProvider._config.m2265b()) {
            ClassUtil.m2172d(annotatedMemberMo1813b.mo1888i(), serializerProvider.m2239C(MapperFeature.OVERRIDE_PUBLIC_ACCESS_MODIFIERS));
        }
        JavaType javaTypeMo1821e = annotatedMemberMo1813b.mo1821e();
        JsonSerializer<Object> jsonSerializerM1975f = m1975f(serializerProvider, annotatedMemberMo1813b);
        if (jsonSerializerM1975f == null) {
            jsonSerializerM1975f = (JsonSerializer) javaTypeMo1821e._valueHandler;
        }
        TypeSerializer typeSerializerMo1972c = (TypeSerializer) javaTypeMo1821e._typeHandler;
        if (typeSerializerMo1972c == null) {
            typeSerializerMo1972c = mo1972c(serializerProvider._config, javaTypeMo1821e);
        }
        return new JsonValueSerializer(annotatedMemberMo1813b, typeSerializerMo1972c, jsonSerializerM1975f);
    }

    /* renamed from: f */
    public JsonSerializer<Object> m1975f(SerializerProvider serializerProvider, Annotated annotated) throws JsonMappingException {
        Object objMo1756L = serializerProvider.m2257v().mo1756L(annotated);
        if (objMo1756L == null) {
            return null;
        }
        JsonSerializer<Object> jsonSerializerMo2000H = serializerProvider.mo2000H(annotated, objMo1756L);
        Object objMo1752H = serializerProvider.m2257v().mo1752H(annotated);
        Converter<Object, Object> converterM1939c = objMo1752H != null ? serializerProvider.m1939c(annotated, objMo1752H) : null;
        return converterM1939c == null ? jsonSerializerMo2000H : new StdDelegatingSerializer(converterM1939c, converterM1939c.m2197a(serializerProvider.mo1940d()), jsonSerializerMo2000H);
    }

    /* renamed from: g */
    public boolean m1976g(SerializationConfig serializationConfig, BeanDescription beanDescription, TypeSerializer typeSerializer) {
        JsonSerialize.b bVarMo1755K = serializationConfig.m2267e().mo1755K(((BasicBeanDescription) beanDescription).f4736f);
        return (bVarMo1755K == null || bVarMo1755K == JsonSerialize.b.DEFAULT_TYPING) ? serializationConfig.m2279q(MapperFeature.USE_STATIC_TYPING) : bVarMo1755K == JsonSerialize.b.STATIC;
    }
}

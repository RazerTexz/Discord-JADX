package p007b.p195g.p196a.p205c;

import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.exc.InvalidDefinitionException;
import java.io.IOException;
import java.text.DateFormat;
import java.util.Map;
import p007b.p195g.p196a.p197a.ObjectIdGenerator;
import p007b.p195g.p196a.p198b.JsonGenerator;
import p007b.p195g.p196a.p205c.p210c0.Annotated;
import p007b.p195g.p196a.p205c.p210c0.BeanPropertyDefinition;
import p007b.p195g.p196a.p205c.p215g0.ContextualSerializer;
import p007b.p195g.p196a.p205c.p215g0.DefaultSerializerProvider;
import p007b.p195g.p196a.p205c.p215g0.ResolvableSerializer;
import p007b.p195g.p196a.p205c.p215g0.SerializerCache;
import p007b.p195g.p196a.p205c.p215g0.SerializerFactory2;
import p007b.p195g.p196a.p205c.p215g0.p216t.FailingSerializer;
import p007b.p195g.p196a.p205c.p215g0.p216t.ReadOnlyClassToSerializerMap;
import p007b.p195g.p196a.p205c.p215g0.p216t.UnknownSerializer;
import p007b.p195g.p196a.p205c.p215g0.p216t.WritableObjectId;
import p007b.p195g.p196a.p205c.p215g0.p217u.NullSerializer;
import p007b.p195g.p196a.p205c.p218h0.TypeFactory;
import p007b.p195g.p196a.p205c.p219i0.ClassUtil;
import p007b.p195g.p196a.p205c.p219i0.TypeKey;
import p007b.p195g.p196a.p205c.p221z.ContextAttributes;

/* JADX INFO: renamed from: b.g.a.c.x, reason: use source file name */
/* JADX INFO: compiled from: SerializerProvider.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class SerializerProvider extends DatabindContext {

    /* JADX INFO: renamed from: j */
    public static final JsonSerializer<Object> f5061j = new FailingSerializer("Null key for a Map not allowed in JSON (use a converting NullKeySerializer?)");

    /* JADX INFO: renamed from: k */
    public static final JsonSerializer<Object> f5062k = new UnknownSerializer();
    public final SerializationConfig _config;
    public DateFormat _dateFormat;
    public JsonSerializer<Object> _keySerializer;
    public final ReadOnlyClassToSerializerMap _knownSerializers;
    public JsonSerializer<Object> _nullKeySerializer;
    public JsonSerializer<Object> _nullValueSerializer;
    public final Class<?> _serializationView;
    public final SerializerCache _serializerCache;
    public final SerializerFactory2 _serializerFactory;
    public final boolean _stdNullValueSerializer;
    public JsonSerializer<Object> _unknownTypeSerializer;

    /* JADX INFO: renamed from: l */
    public transient ContextAttributes f5063l;

    public SerializerProvider() {
        this._unknownTypeSerializer = f5062k;
        this._nullValueSerializer = NullSerializer.f4867k;
        this._nullKeySerializer = f5061j;
        this._config = null;
        this._serializerFactory = null;
        this._serializerCache = new SerializerCache();
        this._knownSerializers = null;
        this._serializationView = null;
        this.f5063l = null;
        this._stdNullValueSerializer = true;
    }

    /* JADX INFO: renamed from: A */
    public abstract Object mo1998A(BeanPropertyDefinition beanPropertyDefinition, Class<?> cls) throws JsonMappingException;

    /* JADX INFO: renamed from: B */
    public abstract boolean mo1999B(Object obj) throws JsonMappingException;

    /* JADX INFO: renamed from: C */
    public final boolean m2239C(MapperFeature mapperFeature) {
        return mapperFeature.m2222h(this._config._mapperFeatures);
    }

    /* JADX INFO: renamed from: D */
    public final boolean m2240D(SerializationFeature serializationFeature) {
        return this._config.m2237v(serializationFeature);
    }

    /* JADX INFO: renamed from: E */
    public <T> T m2241E(BeanDescription beanDescription, BeanPropertyDefinition beanPropertyDefinition, String str, Object... objArr) throws JsonMappingException {
        String str2;
        String strM1937a = m1937a(str, objArr);
        if (beanPropertyDefinition != null) {
            String strMo1858p = beanPropertyDefinition.mo1858p();
            if (strMo1858p == null) {
                str2 = "[N/A]";
            } else {
                Object[] objArr2 = new Object[1];
                if (strMo1858p.length() > 500) {
                    strMo1858p = strMo1858p.substring(0, 500) + "]...[" + strMo1858p.substring(strMo1858p.length() - 500);
                }
                objArr2[0] = strMo1858p;
                str2 = String.format("\"%s\"", objArr2);
            }
        } else {
            str2 = "N/A";
        }
        throw new InvalidDefinitionException(((DefaultSerializerProvider) this).f4808o, String.format("Invalid definition for property %s (of type %s): %s", str2, beanDescription != null ? ClassUtil.m2189u(beanDescription.f4626a._class) : "N/A", strM1937a), beanDescription, beanPropertyDefinition);
    }

    /* JADX INFO: renamed from: F */
    public <T> T m2242F(BeanDescription beanDescription, String str, Object... objArr) throws JsonMappingException {
        throw new InvalidDefinitionException(((DefaultSerializerProvider) this).f4808o, String.format("Invalid type definition for type %s: %s", ClassUtil.m2189u(beanDescription.f4626a._class), m1937a(str, objArr)), beanDescription, null);
    }

    /* JADX INFO: renamed from: G */
    public void m2243G(String str, Object... objArr) throws JsonMappingException {
        throw new JsonMappingException(((DefaultSerializerProvider) this).f4808o, m1937a(str, objArr), null);
    }

    /* JADX INFO: renamed from: H */
    public abstract JsonSerializer<Object> mo2000H(Annotated annotated, Object obj) throws JsonMappingException;

    @Override // p007b.p195g.p196a.p205c.DatabindContext
    /* JADX INFO: renamed from: d */
    public final TypeFactory mo1940d() {
        return this._config._base._typeFactory;
    }

    @Override // p007b.p195g.p196a.p205c.DatabindContext
    /* JADX INFO: renamed from: f */
    public <T> T mo1942f(JavaType javaType, String str) throws JsonMappingException {
        throw new InvalidDefinitionException(((DefaultSerializerProvider) this).f4808o, str, javaType);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: h */
    public JsonSerializer<Object> m2244h(JavaType javaType) throws JsonMappingException {
        try {
            JsonSerializer<Object> jsonSerializerMo1991b = this._serializerFactory.mo1991b(this, javaType);
            if (jsonSerializerMo1991b != 0) {
                SerializerCache serializerCache = this._serializerCache;
                synchronized (serializerCache) {
                    if (serializerCache.f4815a.put(new TypeKey(javaType, false), jsonSerializerMo1991b) == null) {
                        serializerCache.f4816b.set(null);
                    }
                    if (jsonSerializerMo1991b instanceof ResolvableSerializer) {
                        ((ResolvableSerializer) jsonSerializerMo1991b).mo2007b(this);
                    }
                }
            }
            return jsonSerializerMo1991b;
        } catch (IllegalArgumentException e) {
            throw new JsonMappingException(((DefaultSerializerProvider) this).f4808o, m1937a(ClassUtil.m2176h(e), new Object[0]), e);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: i */
    public JsonSerializer<Object> m2245i(Class<?> cls) throws JsonMappingException {
        JavaType javaTypeM2160b = this._config._base._typeFactory.m2160b(null, cls, TypeFactory.f4926l);
        try {
            JsonSerializer<Object> jsonSerializerMo1991b = this._serializerFactory.mo1991b(this, javaTypeM2160b);
            if (jsonSerializerMo1991b != 0) {
                SerializerCache serializerCache = this._serializerCache;
                synchronized (serializerCache) {
                    JsonSerializer<Object> jsonSerializerPut = serializerCache.f4815a.put(new TypeKey(cls, false), jsonSerializerMo1991b);
                    JsonSerializer<Object> jsonSerializerPut2 = serializerCache.f4815a.put(new TypeKey(javaTypeM2160b, false), jsonSerializerMo1991b);
                    if (jsonSerializerPut == null || jsonSerializerPut2 == null) {
                        serializerCache.f4816b.set(null);
                    }
                    if (jsonSerializerMo1991b instanceof ResolvableSerializer) {
                        ((ResolvableSerializer) jsonSerializerMo1991b).mo2007b(this);
                    }
                }
            }
            return jsonSerializerMo1991b;
        } catch (IllegalArgumentException e) {
            throw new JsonMappingException(((DefaultSerializerProvider) this).f4808o, m1937a(ClassUtil.m2176h(e), new Object[0]), e);
        }
    }

    /* JADX INFO: renamed from: j */
    public final DateFormat m2246j() {
        DateFormat dateFormat = this._dateFormat;
        if (dateFormat != null) {
            return dateFormat;
        }
        DateFormat dateFormat2 = (DateFormat) this._config._base._dateFormat.clone();
        this._dateFormat = dateFormat2;
        return dateFormat2;
    }

    /* JADX INFO: renamed from: k */
    public JavaType m2247k(JavaType javaType, Class<?> cls) throws IllegalArgumentException {
        return javaType._class == cls ? javaType : this._config._base._typeFactory.m2166h(javaType, cls, true);
    }

    /* JADX INFO: renamed from: l */
    public final void m2248l(JsonGenerator jsonGenerator) throws IOException {
        if (this._stdNullValueSerializer) {
            jsonGenerator.mo1631A();
        } else {
            this._nullValueSerializer.mo1807f(null, jsonGenerator, this);
        }
    }

    /* JADX INFO: renamed from: m */
    public JsonSerializer<Object> m2249m(JavaType javaType, BeanProperty beanProperty) throws JsonMappingException {
        JsonSerializer<Object> jsonSerializerM2035a = this._knownSerializers.m2035a(javaType);
        return (jsonSerializerM2035a == null && (jsonSerializerM2035a = this._serializerCache.m2008a(javaType)) == null && (jsonSerializerM2035a = m2244h(javaType)) == null) ? m2259x(javaType._class) : m2261z(jsonSerializerM2035a, beanProperty);
    }

    /* JADX INFO: renamed from: n */
    public JsonSerializer<Object> m2250n(Class<?> cls, BeanProperty beanProperty) throws JsonMappingException {
        JsonSerializer<Object> jsonSerializerM2036b = this._knownSerializers.m2036b(cls);
        return (jsonSerializerM2036b == null && (jsonSerializerM2036b = this._serializerCache.m2009b(cls)) == null && (jsonSerializerM2036b = this._serializerCache.m2008a(this._config._base._typeFactory.m2160b(null, cls, TypeFactory.f4926l))) == null && (jsonSerializerM2036b = m2245i(cls)) == null) ? m2259x(cls) : m2261z(jsonSerializerM2036b, beanProperty);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: o */
    public JsonSerializer<Object> m2251o(JavaType javaType, BeanProperty beanProperty) throws JsonMappingException {
        JsonSerializer<Object> jsonSerializerMo1971a = this._serializerFactory.mo1971a(this, javaType, this._keySerializer);
        if (jsonSerializerMo1971a instanceof ResolvableSerializer) {
            ((ResolvableSerializer) jsonSerializerMo1971a).mo2007b(this);
        }
        return m2261z(jsonSerializerMo1971a, beanProperty);
    }

    /* JADX INFO: renamed from: p */
    public abstract WritableObjectId mo2005p(Object obj, ObjectIdGenerator<?> objectIdGenerator);

    /* JADX INFO: renamed from: q */
    public JsonSerializer<Object> m2252q(JavaType javaType, BeanProperty beanProperty) throws JsonMappingException {
        JsonSerializer<Object> jsonSerializerM2035a = this._knownSerializers.m2035a(javaType);
        return (jsonSerializerM2035a == null && (jsonSerializerM2035a = this._serializerCache.m2008a(javaType)) == null && (jsonSerializerM2035a = m2244h(javaType)) == null) ? m2259x(javaType._class) : m2260y(jsonSerializerM2035a, beanProperty);
    }

    /* JADX INFO: renamed from: r */
    public JsonSerializer<Object> m2253r(Class<?> cls, BeanProperty beanProperty) throws JsonMappingException {
        JsonSerializer<Object> jsonSerializerM2036b = this._knownSerializers.m2036b(cls);
        return (jsonSerializerM2036b == null && (jsonSerializerM2036b = this._serializerCache.m2009b(cls)) == null && (jsonSerializerM2036b = this._serializerCache.m2008a(this._config._base._typeFactory.m2160b(null, cls, TypeFactory.f4926l))) == null && (jsonSerializerM2036b = m2245i(cls)) == null) ? m2259x(cls) : m2260y(jsonSerializerM2036b, beanProperty);
    }

    /* JADX INFO: renamed from: s */
    public JsonSerializer<Object> m2254s(JavaType javaType) throws JsonMappingException {
        JsonSerializer<Object> jsonSerializerM2035a = this._knownSerializers.m2035a(javaType);
        if (jsonSerializerM2035a != null) {
            return jsonSerializerM2035a;
        }
        JsonSerializer<Object> jsonSerializerM2008a = this._serializerCache.m2008a(javaType);
        if (jsonSerializerM2008a != null) {
            return jsonSerializerM2008a;
        }
        JsonSerializer<Object> jsonSerializerM2244h = m2244h(javaType);
        return jsonSerializerM2244h == null ? m2259x(javaType._class) : jsonSerializerM2244h;
    }

    /* JADX INFO: renamed from: t */
    public JsonSerializer<Object> m2255t(JavaType javaType, BeanProperty beanProperty) throws JsonMappingException {
        if (javaType != null) {
            JsonSerializer<Object> jsonSerializerM2035a = this._knownSerializers.m2035a(javaType);
            return (jsonSerializerM2035a == null && (jsonSerializerM2035a = this._serializerCache.m2008a(javaType)) == null && (jsonSerializerM2035a = m2244h(javaType)) == null) ? m2259x(javaType._class) : m2261z(jsonSerializerM2035a, beanProperty);
        }
        m2243G("Null passed for `valueType` of `findValueSerializer()`", new Object[0]);
        throw null;
    }

    /* JADX INFO: renamed from: u */
    public JsonSerializer<Object> m2256u(Class<?> cls, BeanProperty beanProperty) throws JsonMappingException {
        JsonSerializer<Object> jsonSerializerM2036b = this._knownSerializers.m2036b(cls);
        return (jsonSerializerM2036b == null && (jsonSerializerM2036b = this._serializerCache.m2009b(cls)) == null && (jsonSerializerM2036b = this._serializerCache.m2008a(this._config._base._typeFactory.m2160b(null, cls, TypeFactory.f4926l))) == null && (jsonSerializerM2036b = m2245i(cls)) == null) ? m2259x(cls) : m2261z(jsonSerializerM2036b, beanProperty);
    }

    /* JADX INFO: renamed from: v */
    public final AnnotationIntrospector m2257v() {
        return this._config.m2267e();
    }

    /* JADX INFO: renamed from: w */
    public Object m2258w(Object obj) {
        Object obj2;
        ContextAttributes.a aVar = (ContextAttributes.a) this.f5063l;
        Map<Object, Object> map = aVar.f5089l;
        if (map == null || (obj2 = map.get(obj)) == null) {
            return aVar._shared.get(obj);
        }
        if (obj2 == ContextAttributes.a.f5088k) {
            return null;
        }
        return obj2;
    }

    /* JADX INFO: renamed from: x */
    public JsonSerializer<Object> m2259x(Class<?> cls) {
        return cls == Object.class ? this._unknownTypeSerializer : new UnknownSerializer(cls);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: y */
    public JsonSerializer<?> m2260y(JsonSerializer<?> jsonSerializer, BeanProperty beanProperty) throws JsonMappingException {
        return (jsonSerializer == 0 || !(jsonSerializer instanceof ContextualSerializer)) ? jsonSerializer : ((ContextualSerializer) jsonSerializer).mo1997a(this, beanProperty);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: z */
    public JsonSerializer<?> m2261z(JsonSerializer<?> jsonSerializer, BeanProperty beanProperty) throws JsonMappingException {
        return (jsonSerializer == 0 || !(jsonSerializer instanceof ContextualSerializer)) ? jsonSerializer : ((ContextualSerializer) jsonSerializer).mo1997a(this, beanProperty);
    }

    public SerializerProvider(SerializerProvider serializerProvider, SerializationConfig serializationConfig, SerializerFactory2 serializerFactory2) {
        this._unknownTypeSerializer = f5062k;
        this._nullValueSerializer = NullSerializer.f4867k;
        JsonSerializer<Object> jsonSerializer = f5061j;
        this._nullKeySerializer = jsonSerializer;
        this._serializerFactory = serializerFactory2;
        this._config = serializationConfig;
        SerializerCache serializerCache = serializerProvider._serializerCache;
        this._serializerCache = serializerCache;
        this._unknownTypeSerializer = serializerProvider._unknownTypeSerializer;
        this._keySerializer = serializerProvider._keySerializer;
        JsonSerializer<Object> jsonSerializer2 = serializerProvider._nullValueSerializer;
        this._nullValueSerializer = jsonSerializer2;
        this._nullKeySerializer = serializerProvider._nullKeySerializer;
        this._stdNullValueSerializer = jsonSerializer2 == jsonSerializer;
        this._serializationView = serializationConfig._view;
        this.f5063l = serializationConfig._attributes;
        ReadOnlyClassToSerializerMap readOnlyClassToSerializerMap = serializerCache.f4816b.get();
        if (readOnlyClassToSerializerMap == null) {
            synchronized (serializerCache) {
                readOnlyClassToSerializerMap = serializerCache.f4816b.get();
                if (readOnlyClassToSerializerMap == null) {
                    ReadOnlyClassToSerializerMap readOnlyClassToSerializerMap2 = new ReadOnlyClassToSerializerMap(serializerCache.f4815a);
                    serializerCache.f4816b.set(readOnlyClassToSerializerMap2);
                    readOnlyClassToSerializerMap = readOnlyClassToSerializerMap2;
                }
            }
        }
        this._knownSerializers = readOnlyClassToSerializerMap;
    }
}

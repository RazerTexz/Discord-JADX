package p007b.p195g.p196a.p205c.p215g0;

import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.exc.InvalidDefinitionException;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Map;
import java.util.Objects;
import p007b.p100d.p104b.p105a.outline;
import p007b.p195g.p196a.p197a.ObjectIdGenerator;
import p007b.p195g.p196a.p198b.JsonGenerator;
import p007b.p195g.p196a.p198b.SerializableString;
import p007b.p195g.p196a.p198b.p200p.SerializedString;
import p007b.p195g.p196a.p205c.JavaType;
import p007b.p195g.p196a.p205c.JsonSerializer;
import p007b.p195g.p196a.p205c.PropertyName;
import p007b.p195g.p196a.p205c.SerializationConfig;
import p007b.p195g.p196a.p205c.SerializationFeature;
import p007b.p195g.p196a.p205c.SerializerProvider;
import p007b.p195g.p196a.p205c.p210c0.Annotated;
import p007b.p195g.p196a.p205c.p210c0.BasicBeanDescription;
import p007b.p195g.p196a.p205c.p210c0.BeanPropertyDefinition;
import p007b.p195g.p196a.p205c.p212e0.TypeSerializer;
import p007b.p195g.p196a.p205c.p215g0.p216t.ReadOnlyClassToSerializerMap;
import p007b.p195g.p196a.p205c.p215g0.p216t.TypeWrappedSerializer;
import p007b.p195g.p196a.p205c.p215g0.p216t.WritableObjectId;
import p007b.p195g.p196a.p205c.p218h0.ClassKey;
import p007b.p195g.p196a.p205c.p218h0.TypeFactory;
import p007b.p195g.p196a.p205c.p219i0.ClassUtil;
import p007b.p195g.p196a.p205c.p219i0.LRUMap;
import p007b.p195g.p196a.p205c.p219i0.RootNameLookup;
import p007b.p195g.p196a.p205c.p219i0.TypeKey;

/* compiled from: DefaultSerializerProvider.java */
/* renamed from: b.g.a.c.g0.j, reason: use source file name */
/* loaded from: classes3.dex */
public abstract class DefaultSerializerProvider extends SerializerProvider implements Serializable {
    private static final long serialVersionUID = 1;

    /* renamed from: m */
    public transient Map<Object, WritableObjectId> f4806m;

    /* renamed from: n */
    public transient ArrayList<ObjectIdGenerator<?>> f4807n;

    /* renamed from: o */
    public transient JsonGenerator f4808o;

    /* compiled from: DefaultSerializerProvider.java */
    /* renamed from: b.g.a.c.g0.j$a */
    public static final class a extends DefaultSerializerProvider {
        private static final long serialVersionUID = 1;

        public a() {
        }

        @Override // p007b.p195g.p196a.p205c.p215g0.DefaultSerializerProvider
        /* renamed from: K */
        public DefaultSerializerProvider mo2003K(SerializationConfig serializationConfig, SerializerFactory2 serializerFactory2) {
            return new a(this, serializationConfig, serializerFactory2);
        }

        public a(SerializerProvider serializerProvider, SerializationConfig serializationConfig, SerializerFactory2 serializerFactory2) {
            super(serializerProvider, serializationConfig, serializerFactory2);
        }
    }

    public DefaultSerializerProvider() {
    }

    @Override // p007b.p195g.p196a.p205c.SerializerProvider
    /* renamed from: A */
    public Object mo1998A(BeanPropertyDefinition beanPropertyDefinition, Class<?> cls) {
        if (cls == null) {
            return null;
        }
        Objects.requireNonNull(this._config._base);
        return ClassUtil.m2175g(cls, this._config.m2265b());
    }

    @Override // p007b.p195g.p196a.p205c.SerializerProvider
    /* renamed from: B */
    public boolean mo1999B(Object obj) throws JsonMappingException {
        try {
            return obj.equals(null);
        } catch (Throwable th) {
            InvalidDefinitionException invalidDefinitionException = new InvalidDefinitionException(this.f4808o, String.format("Problem determining whether filter of type '%s' should filter out `null` values: (%s) %s", obj.getClass().getName(), th.getClass().getName(), ClassUtil.m2176h(th)), m1938b(obj.getClass()));
            invalidDefinitionException.initCause(th);
            throw invalidDefinitionException;
        }
    }

    @Override // p007b.p195g.p196a.p205c.SerializerProvider
    /* renamed from: H */
    public JsonSerializer<Object> mo2000H(Annotated annotated, Object obj) throws JsonMappingException {
        JsonSerializer<Object> jsonSerializer;
        if (obj instanceof JsonSerializer) {
            jsonSerializer = (JsonSerializer) obj;
        } else {
            if (!(obj instanceof Class)) {
                JavaType javaTypeMo1821e = annotated.mo1821e();
                StringBuilder sbM833U = outline.m833U("AnnotationIntrospector returned serializer definition of type ");
                sbM833U.append(obj.getClass().getName());
                sbM833U.append("; expected type JsonSerializer or Class<JsonSerializer> instead");
                mo1942f(javaTypeMo1821e, sbM833U.toString());
                throw null;
            }
            Class cls = (Class) obj;
            if (cls == JsonSerializer.a.class || ClassUtil.m2184p(cls)) {
                return null;
            }
            if (!JsonSerializer.class.isAssignableFrom(cls)) {
                JavaType javaTypeMo1821e2 = annotated.mo1821e();
                StringBuilder sbM833U2 = outline.m833U("AnnotationIntrospector returned Class ");
                sbM833U2.append(cls.getName());
                sbM833U2.append("; expected Class<JsonSerializer>");
                mo1942f(javaTypeMo1821e2, sbM833U2.toString());
                throw null;
            }
            Objects.requireNonNull(this._config._base);
            jsonSerializer = (JsonSerializer) ClassUtil.m2175g(cls, this._config.m2265b());
        }
        if (jsonSerializer instanceof ResolvableSerializer) {
            ((ResolvableSerializer) jsonSerializer).mo2007b(this);
        }
        return jsonSerializer;
    }

    /* renamed from: I */
    public final void m2001I(JsonGenerator jsonGenerator, Object obj, JsonSerializer<Object> jsonSerializer, PropertyName propertyName) throws IOException {
        try {
            jsonGenerator.mo1651c0();
            SerializationConfig serializationConfig = this._config;
            SerializableString serializedString = propertyName._encodedSimple;
            if (serializedString == null) {
                serializedString = serializationConfig == null ? new SerializedString(propertyName._simpleName) : new SerializedString(propertyName._simpleName);
                propertyName._encodedSimple = serializedString;
            }
            jsonGenerator.mo1665x(serializedString);
            jsonSerializer.mo1807f(obj, jsonGenerator, this);
            jsonGenerator.mo1664u();
        } catch (Exception e) {
            throw m2002J(jsonGenerator, e);
        }
    }

    /* renamed from: J */
    public final IOException m2002J(JsonGenerator jsonGenerator, Exception exc) {
        if (exc instanceof IOException) {
            return (IOException) exc;
        }
        String strM2176h = ClassUtil.m2176h(exc);
        if (strM2176h == null) {
            StringBuilder sbM833U = outline.m833U("[no message for ");
            sbM833U.append(exc.getClass().getName());
            sbM833U.append("]");
            strM2176h = sbM833U.toString();
        }
        return new JsonMappingException(jsonGenerator, strM2176h, exc);
    }

    /* renamed from: K */
    public abstract DefaultSerializerProvider mo2003K(SerializationConfig serializationConfig, SerializerFactory2 serializerFactory2);

    /* renamed from: L */
    public void m2004L(JsonGenerator jsonGenerator, Object obj) throws IOException {
        JsonSerializer<Object> jsonSerializerM2256u;
        JsonSerializer<Object> jsonSerializer;
        this.f4808o = jsonGenerator;
        if (obj == null) {
            try {
                this._nullValueSerializer.mo1807f(null, jsonGenerator, this);
                return;
            } catch (Exception e) {
                throw m2002J(jsonGenerator, e);
            }
        }
        Class<?> cls = obj.getClass();
        ReadOnlyClassToSerializerMap readOnlyClassToSerializerMap = this._knownSerializers;
        ReadOnlyClassToSerializerMap.a aVar = readOnlyClassToSerializerMap.f4836a[readOnlyClassToSerializerMap.f4837b & (cls.getName().hashCode() + 1)];
        if (aVar == null) {
            jsonSerializerM2256u = null;
            break;
        }
        if (aVar.f4840c == cls && aVar.f4842e) {
            jsonSerializerM2256u = aVar.f4838a;
        } else {
            do {
                aVar = aVar.f4839b;
                if (aVar == null) {
                    jsonSerializerM2256u = null;
                    break;
                }
            } while (!(aVar.f4840c == cls && aVar.f4842e));
            jsonSerializerM2256u = aVar.f4838a;
        }
        if (jsonSerializerM2256u == null) {
            SerializerCache serializerCache = this._serializerCache;
            synchronized (serializerCache) {
                jsonSerializer = serializerCache.f4815a.get(new TypeKey(cls, true));
            }
            if (jsonSerializer != null) {
                jsonSerializerM2256u = jsonSerializer;
            } else {
                jsonSerializerM2256u = m2256u(cls, null);
                SerializerFactory2 serializerFactory2 = this._serializerFactory;
                SerializationConfig serializationConfig = this._config;
                TypeSerializer typeSerializerMo1972c = serializerFactory2.mo1972c(serializationConfig, serializationConfig._base._typeFactory.m2160b(null, cls, TypeFactory.f4926l));
                if (typeSerializerMo1972c != null) {
                    jsonSerializerM2256u = new TypeWrappedSerializer(typeSerializerMo1972c.mo1955a(null), jsonSerializerM2256u);
                }
                SerializerCache serializerCache2 = this._serializerCache;
                synchronized (serializerCache2) {
                    if (serializerCache2.f4815a.put(new TypeKey(cls, true), jsonSerializerM2256u) == null) {
                        serializerCache2.f4816b.set(null);
                    }
                }
            }
        }
        SerializationConfig serializationConfig2 = this._config;
        PropertyName propertyName = serializationConfig2._rootName;
        if (propertyName == null) {
            if (serializationConfig2.m2237v(SerializationFeature.WRAP_ROOT_VALUE)) {
                SerializationConfig serializationConfig3 = this._config;
                PropertyName propertyName2 = serializationConfig3._rootName;
                if (propertyName2 == null) {
                    RootNameLookup rootNameLookup = serializationConfig3._rootNames;
                    Objects.requireNonNull(rootNameLookup);
                    ClassKey classKey = new ClassKey(cls);
                    PropertyName propertyName3 = rootNameLookup.f4962j.f4955k.get(classKey);
                    if (propertyName3 != null) {
                        propertyName2 = propertyName3;
                    } else {
                        PropertyName propertyNameMo1750F = serializationConfig3.m2267e().mo1750F(((BasicBeanDescription) serializationConfig3.m2277o(cls)).f4736f);
                        if (propertyNameMo1750F == null || !propertyNameMo1750F.m2229c()) {
                            propertyNameMo1750F = PropertyName.m2227a(cls.getSimpleName());
                        }
                        LRUMap<ClassKey, PropertyName> lRUMap = rootNameLookup.f4962j;
                        if (lRUMap.f4955k.size() >= lRUMap.f4954j) {
                            synchronized (lRUMap) {
                                if (lRUMap.f4955k.size() >= lRUMap.f4954j) {
                                    lRUMap.f4955k.clear();
                                }
                            }
                        }
                        lRUMap.f4955k.put(classKey, propertyNameMo1750F);
                        propertyName2 = propertyNameMo1750F;
                    }
                }
                m2001I(jsonGenerator, obj, jsonSerializerM2256u, propertyName2);
                return;
            }
        } else if (!propertyName.m2230d()) {
            m2001I(jsonGenerator, obj, jsonSerializerM2256u, propertyName);
            return;
        }
        try {
            jsonSerializerM2256u.mo1807f(obj, jsonGenerator, this);
        } catch (Exception e2) {
            throw m2002J(jsonGenerator, e2);
        }
    }

    @Override // p007b.p195g.p196a.p205c.SerializerProvider
    /* renamed from: p */
    public WritableObjectId mo2005p(Object obj, ObjectIdGenerator<?> objectIdGenerator) {
        Map<Object, WritableObjectId> map = this.f4806m;
        if (map == null) {
            this.f4806m = m2240D(SerializationFeature.USE_EQUALITY_FOR_OBJECT_ID) ? new HashMap<>() : new IdentityHashMap<>();
        } else {
            WritableObjectId writableObjectId = map.get(obj);
            if (writableObjectId != null) {
                return writableObjectId;
            }
        }
        ObjectIdGenerator<?> objectIdGeneratorMo1612e = null;
        ArrayList<ObjectIdGenerator<?>> arrayList = this.f4807n;
        if (arrayList != null) {
            int i = 0;
            int size = arrayList.size();
            while (true) {
                if (i >= size) {
                    break;
                }
                ObjectIdGenerator<?> objectIdGenerator2 = this.f4807n.get(i);
                if (objectIdGenerator2.mo1608a(objectIdGenerator)) {
                    objectIdGeneratorMo1612e = objectIdGenerator2;
                    break;
                }
                i++;
            }
        } else {
            this.f4807n = new ArrayList<>(8);
        }
        if (objectIdGeneratorMo1612e == null) {
            objectIdGeneratorMo1612e = objectIdGenerator.mo1612e(this);
            this.f4807n.add(objectIdGeneratorMo1612e);
        }
        WritableObjectId writableObjectId2 = new WritableObjectId(objectIdGeneratorMo1612e);
        this.f4806m.put(obj, writableObjectId2);
        return writableObjectId2;
    }

    public DefaultSerializerProvider(SerializerProvider serializerProvider, SerializationConfig serializationConfig, SerializerFactory2 serializerFactory2) {
        super(serializerProvider, serializationConfig, serializerFactory2);
    }
}

package p007b.p195g.p196a.p205c.p215g0.p217u;

import com.fasterxml.jackson.databind.JsonMappingException;
import java.io.IOException;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Map;
import java.util.Objects;
import p007b.p195g.p196a.p197a.JsonFormat;
import p007b.p195g.p196a.p205c.AnnotationIntrospector;
import p007b.p195g.p196a.p205c.BeanProperty;
import p007b.p195g.p196a.p205c.JavaType;
import p007b.p195g.p196a.p205c.JsonSerializer;
import p007b.p195g.p196a.p205c.SerializationFeature;
import p007b.p195g.p196a.p205c.SerializerProvider;
import p007b.p195g.p196a.p205c.p210c0.AnnotatedMember;
import p007b.p195g.p196a.p205c.p215g0.PropertyFilter;
import p007b.p195g.p196a.p205c.p219i0.ClassUtil;
import p007b.p195g.p196a.p205c.p219i0.Converter;
import p007b.p195g.p196a.p205c.p221z.ContextAttributes;

/* JADX INFO: renamed from: b.g.a.c.g0.u.q0, reason: use source file name */
/* JADX INFO: compiled from: StdSerializer.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class StdSerializer<T> extends JsonSerializer<T> implements Serializable {

    /* JADX INFO: renamed from: j */
    public static final Object f4860j = new Object();
    private static final long serialVersionUID = 1;
    public final Class<T> _handledType;

    public StdSerializer(Class<T> cls) {
        this._handledType = cls;
    }

    /* JADX INFO: renamed from: j */
    public static final boolean m2072j(Object obj, Object obj2) {
        return (obj == null || obj2 == null) ? false : true;
    }

    @Override // p007b.p195g.p196a.p205c.JsonSerializer
    /* JADX INFO: renamed from: c */
    public Class<T> mo2041c() {
        return this._handledType;
    }

    /* JADX INFO: renamed from: k */
    public JsonSerializer<?> m2073k(SerializerProvider serializerProvider, BeanProperty beanProperty, JsonSerializer<?> jsonSerializer) throws JsonMappingException {
        JsonSerializer<?> stdDelegatingSerializer;
        AnnotatedMember member;
        Object objMo1751G;
        Object obj = f4860j;
        Map identityHashMap = (Map) serializerProvider.m2258w(obj);
        if (identityHashMap == null) {
            identityHashMap = new IdentityHashMap();
            ContextAttributes.a aVar = (ContextAttributes.a) serializerProvider.f5063l;
            Map<Object, Object> map = aVar.f5089l;
            if (map == null) {
                HashMap map2 = new HashMap();
                map2.put(obj, identityHashMap == null ? ContextAttributes.a.f5088k : identityHashMap);
                aVar = new ContextAttributes.a(aVar._shared, map2);
            } else {
                map.put(obj, identityHashMap);
            }
            serializerProvider.f5063l = aVar;
        } else if (identityHashMap.get(beanProperty) != null) {
            return jsonSerializer;
        }
        identityHashMap.put(beanProperty, Boolean.TRUE);
        try {
            AnnotationIntrospector annotationIntrospectorM2257v = serializerProvider.m2257v();
            if (!m2072j(annotationIntrospectorM2257v, beanProperty) || (member = beanProperty.getMember()) == null || (objMo1751G = annotationIntrospectorM2257v.mo1751G(member)) == null) {
                stdDelegatingSerializer = jsonSerializer;
            } else {
                Converter<Object, Object> converterM1939c = serializerProvider.m1939c(beanProperty.getMember(), objMo1751G);
                JavaType javaTypeM2197a = converterM1939c.m2197a(serializerProvider.mo1940d());
                stdDelegatingSerializer = new StdDelegatingSerializer(converterM1939c, javaTypeM2197a, (jsonSerializer != null || javaTypeM2197a.m2221y()) ? jsonSerializer : serializerProvider.m2254s(javaTypeM2197a));
            }
            return stdDelegatingSerializer != null ? serializerProvider.m2261z(stdDelegatingSerializer, beanProperty) : jsonSerializer;
        } finally {
            identityHashMap.remove(beanProperty);
        }
    }

    /* JADX INFO: renamed from: l */
    public JsonFormat.d m2074l(SerializerProvider serializerProvider, BeanProperty beanProperty, Class<?> cls) {
        return beanProperty != null ? beanProperty.mo1928a(serializerProvider._config, cls) : serializerProvider._config.mo2271i(cls);
    }

    /* JADX INFO: renamed from: m */
    public PropertyFilter m2075m(SerializerProvider serializerProvider, Object obj, Object obj2) throws JsonMappingException {
        Objects.requireNonNull(serializerProvider._config);
        serializerProvider.m1943g(this._handledType, "Cannot resolve PropertyFilter with id '" + obj + "'; no FilterProvider configured");
        throw null;
    }

    /* JADX INFO: renamed from: n */
    public void m2076n(SerializerProvider serializerProvider, Throwable th, Object obj, int i) throws IOException {
        while ((th instanceof InvocationTargetException) && th.getCause() != null) {
            th = th.getCause();
        }
        ClassUtil.m2191w(th);
        boolean z2 = serializerProvider == null || serializerProvider.m2240D(SerializationFeature.WRAP_EXCEPTIONS);
        if (th instanceof IOException) {
            if (!z2 || !(th instanceof JsonMappingException)) {
                throw ((IOException) th);
            }
        } else if (!z2) {
            ClassUtil.m2192x(th);
        }
        throw JsonMappingException.m8741f(th, new JsonMappingException.C10677a(obj, i));
    }

    /* JADX INFO: renamed from: o */
    public void m2077o(SerializerProvider serializerProvider, Throwable th, Object obj, String str) throws IOException {
        while ((th instanceof InvocationTargetException) && th.getCause() != null) {
            th = th.getCause();
        }
        ClassUtil.m2191w(th);
        boolean z2 = serializerProvider == null || serializerProvider.m2240D(SerializationFeature.WRAP_EXCEPTIONS);
        if (th instanceof IOException) {
            if (!z2 || !(th instanceof JsonMappingException)) {
                throw ((IOException) th);
            }
        } else if (!z2) {
            ClassUtil.m2192x(th);
        }
        int i = JsonMappingException.f19661j;
        throw JsonMappingException.m8741f(th, new JsonMappingException.C10677a(obj, str));
    }

    public StdSerializer(JavaType javaType) {
        this._handledType = (Class<T>) javaType._class;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public StdSerializer(Class<?> cls, boolean z2) {
        this._handledType = cls;
    }

    public StdSerializer(StdSerializer<?> stdSerializer) {
        this._handledType = (Class<T>) stdSerializer._handledType;
    }
}

package p007b.p195g.p196a.p205c;

import com.fasterxml.jackson.databind.JsonMappingException;
import java.lang.reflect.Type;
import java.util.Objects;
import p007b.p100d.p104b.p105a.outline;
import p007b.p195g.p196a.p197a.ObjectIdGenerator;
import p007b.p195g.p196a.p205c.p210c0.Annotated;
import p007b.p195g.p196a.p205c.p210c0.ObjectIdInfo;
import p007b.p195g.p196a.p205c.p218h0.TypeFactory;
import p007b.p195g.p196a.p205c.p219i0.ClassUtil;
import p007b.p195g.p196a.p205c.p219i0.Converter;

/* JADX INFO: renamed from: b.g.a.c.e, reason: use source file name */
/* JADX INFO: compiled from: DatabindContext.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class DatabindContext {
    /* JADX INFO: renamed from: a */
    public final String m1937a(String str, Object... objArr) {
        return objArr.length > 0 ? String.format(str, objArr) : str;
    }

    /* JADX INFO: renamed from: b */
    public JavaType m1938b(Type type) {
        if (type == null) {
            return null;
        }
        return mo1940d().m2160b(null, type, TypeFactory.f4926l);
    }

    /* JADX INFO: renamed from: c */
    public Converter<Object, Object> m1939c(Annotated annotated, Object obj) throws JsonMappingException {
        if (obj == null) {
            return null;
        }
        if (obj instanceof Converter) {
            return (Converter) obj;
        }
        if (!(obj instanceof Class)) {
            StringBuilder sbM833U = outline.m833U("AnnotationIntrospector returned Converter definition of type ");
            sbM833U.append(obj.getClass().getName());
            sbM833U.append("; expected type Converter or Class<Converter> instead");
            throw new IllegalStateException(sbM833U.toString());
        }
        Class cls = (Class) obj;
        if (cls == Converter.a.class || ClassUtil.m2184p(cls)) {
            return null;
        }
        if (!Converter.class.isAssignableFrom(cls)) {
            throw new IllegalStateException(outline.m867o(cls, outline.m833U("AnnotationIntrospector returned Class "), "; expected Class<Converter>"));
        }
        SerializationConfig serializationConfig = ((SerializerProvider) this)._config;
        Objects.requireNonNull(serializationConfig._base);
        return (Converter) ClassUtil.m2175g(cls, serializationConfig.m2265b());
    }

    /* JADX INFO: renamed from: d */
    public abstract TypeFactory mo1940d();

    /* JADX INFO: renamed from: e */
    public ObjectIdGenerator<?> m1941e(Annotated annotated, ObjectIdInfo objectIdInfo) throws JsonMappingException {
        Class<? extends ObjectIdGenerator<?>> cls = objectIdInfo.f4629c;
        SerializationConfig serializationConfig = ((SerializerProvider) this)._config;
        Objects.requireNonNull(serializationConfig._base);
        return ((ObjectIdGenerator) ClassUtil.m2175g(cls, serializationConfig.m2265b())).mo1609b(objectIdInfo.f4631e);
    }

    /* JADX INFO: renamed from: f */
    public abstract <T> T mo1942f(JavaType javaType, String str) throws JsonMappingException;

    /* JADX INFO: renamed from: g */
    public <T> T m1943g(Class<?> cls, String str) throws JsonMappingException {
        return (T) mo1942f(m1938b(cls), str);
    }
}

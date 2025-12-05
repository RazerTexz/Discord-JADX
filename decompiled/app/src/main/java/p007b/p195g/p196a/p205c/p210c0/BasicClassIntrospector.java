package p007b.p195g.p196a.p205c.p210c0;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;
import p007b.p195g.p196a.p205c.JavaType;
import p007b.p195g.p196a.p205c.JsonNode;
import p007b.p195g.p196a.p205c.p210c0.ClassIntrospector;
import p007b.p195g.p196a.p205c.p218h0.ArrayType;
import p007b.p195g.p196a.p205c.p218h0.SimpleType;
import p007b.p195g.p196a.p205c.p219i0.ClassUtil;
import p007b.p195g.p196a.p205c.p221z.MapperConfig;

/* compiled from: BasicClassIntrospector.java */
/* renamed from: b.g.a.c.c0.r, reason: use source file name */
/* loaded from: classes3.dex */
public class BasicClassIntrospector extends ClassIntrospector implements Serializable {

    /* renamed from: j */
    public static final Class<?> f4741j = JsonNode.class;

    /* renamed from: k */
    public static final BasicBeanDescription f4742k;

    /* renamed from: l */
    public static final BasicBeanDescription f4743l;

    /* renamed from: m */
    public static final BasicBeanDescription f4744m;

    /* renamed from: n */
    public static final BasicBeanDescription f4745n;

    /* renamed from: o */
    public static final BasicBeanDescription f4746o;
    private static final long serialVersionUID = 2;

    static {
        SimpleType simpleTypeM2138L = SimpleType.m2138L(String.class);
        Class<?> cls = AnnotatedClassResolver.f4692a;
        f4742k = BasicBeanDescription.m1918e(null, simpleTypeM2138L, new AnnotatedClass(String.class));
        Class cls2 = Boolean.TYPE;
        f4743l = BasicBeanDescription.m1918e(null, SimpleType.m2138L(cls2), new AnnotatedClass(cls2));
        Class cls3 = Integer.TYPE;
        f4744m = BasicBeanDescription.m1918e(null, SimpleType.m2138L(cls3), new AnnotatedClass(cls3));
        Class cls4 = Long.TYPE;
        f4745n = BasicBeanDescription.m1918e(null, SimpleType.m2138L(cls4), new AnnotatedClass(cls4));
        f4746o = BasicBeanDescription.m1918e(null, SimpleType.m2138L(Object.class), new AnnotatedClass(Object.class));
    }

    /* renamed from: a */
    public BasicBeanDescription m1920a(MapperConfig<?> mapperConfig, JavaType javaType) {
        Class<?> cls = javaType._class;
        if (cls.isPrimitive()) {
            if (cls == Integer.TYPE) {
                return f4744m;
            }
            if (cls == Long.TYPE) {
                return f4745n;
            }
            if (cls == Boolean.TYPE) {
                return f4743l;
            }
            return null;
        }
        if (!ClassUtil.m2186r(cls)) {
            if (!f4741j.isAssignableFrom(cls)) {
                return null;
            }
            Class<?> cls2 = AnnotatedClassResolver.f4692a;
            return BasicBeanDescription.m1918e(mapperConfig, javaType, new AnnotatedClass(cls));
        }
        if (cls == Object.class) {
            return f4746o;
        }
        if (cls == String.class) {
            return f4742k;
        }
        if (cls == Integer.class) {
            return f4744m;
        }
        if (cls == Long.class) {
            return f4745n;
        }
        if (cls == Boolean.class) {
            return f4743l;
        }
        return null;
    }

    /* renamed from: b */
    public AnnotatedClass m1921b(MapperConfig<?> mapperConfig, JavaType javaType, ClassIntrospector.a aVar) {
        Class<?> cls = AnnotatedClassResolver.f4692a;
        Objects.requireNonNull(javaType);
        if ((javaType instanceof ArrayType) && AnnotatedClassResolver.m1880i(mapperConfig, javaType._class)) {
            return new AnnotatedClass(javaType._class);
        }
        AnnotatedClassResolver annotatedClassResolver = new AnnotatedClassResolver(mapperConfig, javaType, aVar);
        ArrayList arrayList = new ArrayList(8);
        Class<?> cls2 = javaType._class;
        if (!(cls2 == Object.class)) {
            if (cls2.isInterface()) {
                AnnotatedClassResolver.m1876d(javaType, arrayList, false);
            } else {
                AnnotatedClassResolver.m1877e(javaType, arrayList, false);
            }
        }
        return new AnnotatedClass(javaType, annotatedClassResolver.f4699h, arrayList, annotatedClassResolver.f4700i, annotatedClassResolver.m1884g(arrayList), annotatedClassResolver.f4697f, annotatedClassResolver.f4695d, aVar, mapperConfig._base._typeFactory, annotatedClassResolver.f4701j);
    }
}

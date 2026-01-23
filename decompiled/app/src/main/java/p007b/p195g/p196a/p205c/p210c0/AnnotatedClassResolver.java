package p007b.p195g.p196a.p205c.p210c0;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import p007b.p195g.p196a.p205c.AnnotationIntrospector;
import p007b.p195g.p196a.p205c.JavaType;
import p007b.p195g.p196a.p205c.p210c0.AnnotationCollector;
import p007b.p195g.p196a.p205c.p210c0.ClassIntrospector;
import p007b.p195g.p196a.p205c.p218h0.TypeBindings;
import p007b.p195g.p196a.p205c.p219i0.Annotations;
import p007b.p195g.p196a.p205c.p219i0.ClassUtil;
import p007b.p195g.p196a.p205c.p221z.MapperConfig;
import p007b.p195g.p196a.p205c.p221z.MapperConfigBase;

/* JADX INFO: renamed from: b.g.a.c.c0.d, reason: use source file name */
/* JADX INFO: compiled from: AnnotatedClassResolver.java */
/* JADX INFO: loaded from: classes3.dex */
public class AnnotatedClassResolver {

    /* JADX INFO: renamed from: a */
    public static final Class<?> f4692a = List.class;

    /* JADX INFO: renamed from: b */
    public static final Class<?> f4693b = Map.class;

    /* JADX INFO: renamed from: c */
    public final MapperConfig<?> f4694c;

    /* JADX INFO: renamed from: d */
    public final AnnotationIntrospector f4695d;

    /* JADX INFO: renamed from: e */
    public final ClassIntrospector.a f4696e;

    /* JADX INFO: renamed from: f */
    public final TypeBindings f4697f;

    /* JADX INFO: renamed from: g */
    public final JavaType f4698g;

    /* JADX INFO: renamed from: h */
    public final Class<?> f4699h;

    /* JADX INFO: renamed from: i */
    public final Class<?> f4700i;

    /* JADX INFO: renamed from: j */
    public final boolean f4701j;

    public AnnotatedClassResolver(MapperConfig<?> mapperConfig, JavaType javaType, ClassIntrospector.a aVar) {
        this.f4694c = mapperConfig;
        this.f4698g = javaType;
        Class<?> cls = javaType._class;
        this.f4699h = cls;
        this.f4696e = aVar;
        this.f4697f = javaType.mo2136j();
        AnnotationIntrospector annotationIntrospectorM2267e = mapperConfig.m2278p() ? mapperConfig.m2267e() : null;
        this.f4695d = annotationIntrospectorM2267e;
        this.f4700i = aVar != null ? aVar.mo1885a(cls) : null;
        this.f4701j = (annotationIntrospectorM2267e == null || (ClassUtil.m2186r(cls) && javaType.mo2104v())) ? false : true;
    }

    /* JADX INFO: renamed from: d */
    public static void m1876d(JavaType javaType, List<JavaType> list, boolean z2) {
        Class<?> cls = javaType._class;
        if (z2) {
            if (m1878f(list, cls)) {
                return;
            }
            list.add(javaType);
            if (cls == f4692a || cls == f4693b) {
                return;
            }
        }
        Iterator<JavaType> it = javaType.mo2145n().iterator();
        while (it.hasNext()) {
            m1876d(it.next(), list, true);
        }
    }

    /* JADX INFO: renamed from: e */
    public static void m1877e(JavaType javaType, List<JavaType> list, boolean z2) {
        Class<?> cls = javaType._class;
        if (cls == Object.class || cls == Enum.class) {
            return;
        }
        if (z2) {
            if (m1878f(list, cls)) {
                return;
            } else {
                list.add(javaType);
            }
        }
        Iterator<JavaType> it = javaType.mo2145n().iterator();
        while (it.hasNext()) {
            m1876d(it.next(), list, true);
        }
        JavaType javaTypeMo2137q = javaType.mo2137q();
        if (javaTypeMo2137q != null) {
            m1877e(javaTypeMo2137q, list, true);
        }
    }

    /* JADX INFO: renamed from: f */
    public static boolean m1878f(List<JavaType> list, Class<?> cls) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            if (list.get(i)._class == cls) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: renamed from: h */
    public static AnnotatedClass m1879h(MapperConfig<?> mapperConfig, Class<?> cls) {
        if (cls.isArray() && m1880i(mapperConfig, cls)) {
            return new AnnotatedClass(cls);
        }
        AnnotatedClassResolver annotatedClassResolver = new AnnotatedClassResolver(mapperConfig, cls, mapperConfig);
        List<JavaType> listEmptyList = Collections.emptyList();
        return new AnnotatedClass(null, cls, listEmptyList, annotatedClassResolver.f4700i, annotatedClassResolver.m1884g(listEmptyList), annotatedClassResolver.f4697f, annotatedClassResolver.f4695d, mapperConfig, mapperConfig._base._typeFactory, annotatedClassResolver.f4701j);
    }

    /* JADX INFO: renamed from: i */
    public static boolean m1880i(MapperConfig<?> mapperConfig, Class<?> cls) {
        return mapperConfig == null || ((MapperConfigBase) mapperConfig)._mixIns.mo1885a(cls) == null;
    }

    /* JADX INFO: renamed from: a */
    public final AnnotationCollector m1881a(AnnotationCollector annotationCollector, Annotation[] annotationArr) {
        if (annotationArr != null) {
            for (Annotation annotation : annotationArr) {
                if (!annotationCollector.mo1914d(annotation)) {
                    annotationCollector = annotationCollector.mo1911a(annotation);
                    if (this.f4695d.mo1774b0(annotation)) {
                        annotationCollector = m1883c(annotationCollector, annotation);
                    }
                }
            }
        }
        return annotationCollector;
    }

    /* JADX INFO: renamed from: b */
    public final AnnotationCollector m1882b(AnnotationCollector annotationCollector, Class<?> cls, Class<?> cls2) {
        if (cls2 != null) {
            annotationCollector = m1881a(annotationCollector, ClassUtil.m2177i(cls2));
            Iterator it = ((ArrayList) ClassUtil.m2178j(cls2, cls, false)).iterator();
            while (it.hasNext()) {
                annotationCollector = m1881a(annotationCollector, ClassUtil.m2177i((Class) it.next()));
            }
        }
        return annotationCollector;
    }

    /* JADX INFO: renamed from: c */
    public final AnnotationCollector m1883c(AnnotationCollector annotationCollector, Annotation annotation) {
        for (Annotation annotation2 : ClassUtil.m2177i(annotation.annotationType())) {
            if (!(annotation2 instanceof Target) && !(annotation2 instanceof Retention) && !annotationCollector.mo1914d(annotation2)) {
                annotationCollector = annotationCollector.mo1911a(annotation2);
                if (this.f4695d.mo1774b0(annotation2)) {
                    annotationCollector = m1883c(annotationCollector, annotation2);
                }
            }
        }
        return annotationCollector;
    }

    /* JADX INFO: renamed from: g */
    public final Annotations m1884g(List<JavaType> list) {
        if (this.f4695d == null) {
            return AnnotationCollector.f4725a;
        }
        ClassIntrospector.a aVar = this.f4696e;
        boolean z2 = aVar != null && (!(aVar instanceof SimpleMixInResolver) || ((SimpleMixInResolver) aVar).m1886b());
        if (!z2 && !this.f4701j) {
            return AnnotationCollector.f4725a;
        }
        AnnotationCollector annotationCollectorM1882b = AnnotationCollector.a.f4727c;
        Class<?> cls = this.f4700i;
        if (cls != null) {
            annotationCollectorM1882b = m1882b(annotationCollectorM1882b, this.f4699h, cls);
        }
        if (this.f4701j) {
            annotationCollectorM1882b = m1881a(annotationCollectorM1882b, ClassUtil.m2177i(this.f4699h));
        }
        for (JavaType javaType : list) {
            if (z2) {
                Class<?> cls2 = javaType._class;
                annotationCollectorM1882b = m1882b(annotationCollectorM1882b, cls2, this.f4696e.mo1885a(cls2));
            }
            if (this.f4701j) {
                annotationCollectorM1882b = m1881a(annotationCollectorM1882b, ClassUtil.m2177i(javaType._class));
            }
        }
        if (z2) {
            annotationCollectorM1882b = m1882b(annotationCollectorM1882b, Object.class, this.f4696e.mo1885a(Object.class));
        }
        return annotationCollectorM1882b.mo1913c();
    }

    public AnnotatedClassResolver(MapperConfig<?> mapperConfig, Class<?> cls, ClassIntrospector.a aVar) {
        this.f4694c = mapperConfig;
        this.f4698g = null;
        this.f4699h = cls;
        this.f4696e = aVar;
        this.f4697f = TypeBindings.f4908l;
        if (mapperConfig == null) {
            this.f4695d = null;
            this.f4700i = null;
        } else {
            this.f4695d = mapperConfig.m2278p() ? mapperConfig.m2267e() : null;
            this.f4700i = aVar != null ? aVar.mo1885a(cls) : null;
        }
        this.f4701j = this.f4695d != null;
    }
}

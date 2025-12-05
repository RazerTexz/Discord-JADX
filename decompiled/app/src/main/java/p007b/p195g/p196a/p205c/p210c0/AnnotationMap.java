package p007b.p195g.p196a.p205c.p210c0;

import java.lang.annotation.Annotation;
import java.util.HashMap;
import p007b.p195g.p196a.p205c.p219i0.Annotations;

/* compiled from: AnnotationMap.java */
/* renamed from: b.g.a.c.c0.p, reason: use source file name */
/* loaded from: classes3.dex */
public final class AnnotationMap implements Annotations {

    /* renamed from: j */
    public HashMap<Class<?>, Annotation> f4731j;

    public AnnotationMap() {
    }

    /* renamed from: c */
    public static AnnotationMap m1916c(AnnotationMap annotationMap, AnnotationMap annotationMap2) {
        HashMap<Class<?>, Annotation> map;
        HashMap<Class<?>, Annotation> map2;
        if (annotationMap == null || (map = annotationMap.f4731j) == null || map.isEmpty()) {
            return annotationMap2;
        }
        if (annotationMap2 == null || (map2 = annotationMap2.f4731j) == null || map2.isEmpty()) {
            return annotationMap;
        }
        HashMap map3 = new HashMap();
        for (Annotation annotation : annotationMap2.f4731j.values()) {
            map3.put(annotation.annotationType(), annotation);
        }
        for (Annotation annotation2 : annotationMap.f4731j.values()) {
            map3.put(annotation2.annotationType(), annotation2);
        }
        return new AnnotationMap(map3);
    }

    @Override // p007b.p195g.p196a.p205c.p219i0.Annotations
    /* renamed from: a */
    public <A extends Annotation> A mo1915a(Class<A> cls) {
        HashMap<Class<?>, Annotation> map = this.f4731j;
        if (map == null) {
            return null;
        }
        return (A) map.get(cls);
    }

    /* renamed from: b */
    public boolean m1917b(Class<? extends Annotation>[] clsArr) {
        if (this.f4731j != null) {
            for (Class<? extends Annotation> cls : clsArr) {
                if (this.f4731j.containsKey(cls)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // p007b.p195g.p196a.p205c.p219i0.Annotations
    public int size() {
        HashMap<Class<?>, Annotation> map = this.f4731j;
        if (map == null) {
            return 0;
        }
        return map.size();
    }

    public String toString() {
        HashMap<Class<?>, Annotation> map = this.f4731j;
        return map == null ? "[null]" : map.toString();
    }

    public AnnotationMap(HashMap<Class<?>, Annotation> map) {
        this.f4731j = map;
    }
}

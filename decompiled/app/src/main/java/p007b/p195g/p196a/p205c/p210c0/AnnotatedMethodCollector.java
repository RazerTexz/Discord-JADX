package p007b.p195g.p196a.p205c.p210c0;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import p007b.p195g.p196a.p205c.AnnotationIntrospector;
import p007b.p195g.p196a.p205c.p210c0.AnnotationCollector;
import p007b.p195g.p196a.p205c.p210c0.ClassIntrospector;
import p007b.p195g.p196a.p205c.p219i0.ClassUtil;

/* compiled from: AnnotatedMethodCollector.java */
/* renamed from: b.g.a.c.c0.k, reason: use source file name */
/* loaded from: classes3.dex */
public class AnnotatedMethodCollector extends CollectorBase {

    /* renamed from: d */
    public final ClassIntrospector.a f4719d;

    /* renamed from: e */
    public final boolean f4720e;

    /* compiled from: AnnotatedMethodCollector.java */
    /* renamed from: b.g.a.c.c0.k$a */
    public static final class a {

        /* renamed from: a */
        public TypeResolutionContext f4721a;

        /* renamed from: b */
        public Method f4722b;

        /* renamed from: c */
        public AnnotationCollector f4723c;

        public a(TypeResolutionContext typeResolutionContext, Method method, AnnotationCollector annotationCollector) {
            this.f4721a = typeResolutionContext;
            this.f4722b = method;
            this.f4723c = annotationCollector;
        }
    }

    public AnnotatedMethodCollector(AnnotationIntrospector annotationIntrospector, ClassIntrospector.a aVar, boolean z2) {
        super(annotationIntrospector);
        this.f4719d = annotationIntrospector == null ? null : aVar;
        this.f4720e = z2;
    }

    /* renamed from: h */
    public static boolean m1907h(Method method) {
        return (Modifier.isStatic(method.getModifiers()) || method.isSynthetic() || method.isBridge() || method.getParameterTypes().length > 2) ? false : true;
    }

    /* renamed from: f */
    public final void m1908f(TypeResolutionContext typeResolutionContext, Class<?> cls, Map<MemberKey, a> map, Class<?> cls2) {
        if (cls2 != null) {
            m1909g(typeResolutionContext, cls, map, cls2);
        }
        if (cls == null) {
            return;
        }
        for (Method method : ClassUtil.m2179k(cls)) {
            if (m1907h(method)) {
                MemberKey memberKey = new MemberKey(method);
                a aVar = map.get(memberKey);
                if (aVar == null) {
                    map.put(memberKey, new a(typeResolutionContext, method, this.f4750c == null ? AnnotationCollector.a.f4727c : m1925c(method.getDeclaredAnnotations())));
                } else {
                    if (this.f4720e) {
                        aVar.f4723c = m1926d(aVar.f4723c, method.getDeclaredAnnotations());
                    }
                    Method method2 = aVar.f4722b;
                    if (method2 == null) {
                        aVar.f4722b = method;
                    } else if (Modifier.isAbstract(method2.getModifiers()) && !Modifier.isAbstract(method.getModifiers())) {
                        aVar.f4722b = method;
                        aVar.f4721a = typeResolutionContext;
                    }
                }
            }
        }
    }

    /* renamed from: g */
    public void m1909g(TypeResolutionContext typeResolutionContext, Class<?> cls, Map<MemberKey, a> map, Class<?> cls2) {
        List listEmptyList;
        if (this.f4750c == null) {
            return;
        }
        Annotation[] annotationArr = ClassUtil.f4944a;
        if (cls2 == cls || cls2 == Object.class) {
            listEmptyList = Collections.emptyList();
        } else {
            listEmptyList = new ArrayList(8);
            ClassUtil.m2169a(cls2, cls, listEmptyList, true);
        }
        Iterator it = listEmptyList.iterator();
        while (it.hasNext()) {
            for (Method method : ((Class) it.next()).getDeclaredMethods()) {
                if (m1907h(method)) {
                    MemberKey memberKey = new MemberKey(method);
                    a aVar = map.get(memberKey);
                    Annotation[] declaredAnnotations = method.getDeclaredAnnotations();
                    if (aVar == null) {
                        map.put(memberKey, new a(typeResolutionContext, null, m1925c(declaredAnnotations)));
                    } else {
                        aVar.f4723c = m1926d(aVar.f4723c, declaredAnnotations);
                    }
                }
            }
        }
    }
}

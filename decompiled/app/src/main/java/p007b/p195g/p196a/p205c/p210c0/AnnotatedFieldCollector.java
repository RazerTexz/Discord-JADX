package p007b.p195g.p196a.p205c.p210c0;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import p007b.p195g.p196a.p205c.AnnotationIntrospector;
import p007b.p195g.p196a.p205c.JavaType;
import p007b.p195g.p196a.p205c.p210c0.AnnotationCollector;
import p007b.p195g.p196a.p205c.p210c0.ClassIntrospector;
import p007b.p195g.p196a.p205c.p210c0.TypeResolutionContext;
import p007b.p195g.p196a.p205c.p218h0.TypeFactory;
import p007b.p195g.p196a.p205c.p219i0.ClassUtil;

/* compiled from: AnnotatedFieldCollector.java */
/* renamed from: b.g.a.c.c0.h, reason: use source file name */
/* loaded from: classes3.dex */
public class AnnotatedFieldCollector extends CollectorBase {

    /* renamed from: d */
    public final TypeFactory f4710d;

    /* renamed from: e */
    public final ClassIntrospector.a f4711e;

    /* renamed from: f */
    public final boolean f4712f;

    /* compiled from: AnnotatedFieldCollector.java */
    /* renamed from: b.g.a.c.c0.h$a */
    public static final class a {

        /* renamed from: a */
        public final TypeResolutionContext f4713a;

        /* renamed from: b */
        public final Field f4714b;

        /* renamed from: c */
        public AnnotationCollector f4715c = AnnotationCollector.a.f4727c;

        public a(TypeResolutionContext typeResolutionContext, Field field) {
            this.f4713a = typeResolutionContext;
            this.f4714b = field;
        }
    }

    public AnnotatedFieldCollector(AnnotationIntrospector annotationIntrospector, TypeFactory typeFactory, ClassIntrospector.a aVar, boolean z2) {
        super(annotationIntrospector);
        this.f4710d = typeFactory;
        this.f4711e = annotationIntrospector == null ? null : aVar;
        this.f4712f = z2;
    }

    /* renamed from: f */
    public final Map<String, a> m1900f(TypeResolutionContext typeResolutionContext, JavaType javaType, Map<String, a> map) {
        ClassIntrospector.a aVar;
        Class<?> clsMo1885a;
        a aVar2;
        JavaType javaTypeMo2137q = javaType.mo2137q();
        if (javaTypeMo2137q == null) {
            return map;
        }
        Class<?> cls = javaType._class;
        Map<String, a> mapM1900f = m1900f(new TypeResolutionContext.a(this.f4710d, javaTypeMo2137q.mo2136j()), javaTypeMo2137q, map);
        for (Field field : cls.getDeclaredFields()) {
            if (m1901g(field)) {
                if (mapM1900f == null) {
                    mapM1900f = new LinkedHashMap<>();
                }
                a aVar3 = new a(typeResolutionContext, field);
                if (this.f4712f) {
                    aVar3.f4715c = m1924b(aVar3.f4715c, field.getDeclaredAnnotations());
                }
                mapM1900f.put(field.getName(), aVar3);
            }
        }
        if (mapM1900f != null && (aVar = this.f4711e) != null && (clsMo1885a = aVar.mo1885a(cls)) != null) {
            Iterator it = ((ArrayList) ClassUtil.m2178j(clsMo1885a, cls, true)).iterator();
            while (it.hasNext()) {
                for (Field field2 : ((Class) it.next()).getDeclaredFields()) {
                    if (m1901g(field2) && (aVar2 = mapM1900f.get(field2.getName())) != null) {
                        aVar2.f4715c = m1924b(aVar2.f4715c, field2.getDeclaredAnnotations());
                    }
                }
            }
        }
        return mapM1900f;
    }

    /* renamed from: g */
    public final boolean m1901g(Field field) {
        return (field.isSynthetic() || Modifier.isStatic(field.getModifiers())) ? false : true;
    }
}

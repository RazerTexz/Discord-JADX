package p007b.p195g.p196a.p205c.p210c0;

import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.lang.reflect.Member;
import java.util.HashMap;
import p007b.p195g.p196a.p205c.p219i0.ClassUtil;

/* compiled from: AnnotatedMember.java */
/* renamed from: b.g.a.c.c0.i, reason: use source file name */
/* loaded from: classes3.dex */
public abstract class AnnotatedMember extends Annotated implements Serializable {
    private static final long serialVersionUID = 1;

    /* renamed from: j */
    public final transient TypeResolutionContext f4716j;

    /* renamed from: k */
    public final transient AnnotationMap f4717k;

    public AnnotatedMember(TypeResolutionContext typeResolutionContext, AnnotationMap annotationMap) {
        this.f4716j = typeResolutionContext;
        this.f4717k = annotationMap;
    }

    @Override // p007b.p195g.p196a.p205c.p210c0.Annotated
    /* renamed from: b */
    public final <A extends Annotation> A mo1818b(Class<A> cls) {
        HashMap<Class<?>, Annotation> map;
        AnnotationMap annotationMap = this.f4717k;
        if (annotationMap == null || (map = annotationMap.f4731j) == null) {
            return null;
        }
        return (A) map.get(cls);
    }

    /* renamed from: f */
    public final void m1902f(boolean z2) {
        Member memberMo1888i = mo1888i();
        if (memberMo1888i != null) {
            ClassUtil.m2172d(memberMo1888i, z2);
        }
    }

    /* renamed from: g */
    public abstract Class<?> mo1887g();

    /* renamed from: h */
    public String mo1903h() {
        return mo1887g().getName() + "#" + mo1819c();
    }

    /* renamed from: i */
    public abstract Member mo1888i();

    /* renamed from: j */
    public abstract Object mo1889j(Object obj) throws UnsupportedOperationException, IllegalArgumentException;

    /* renamed from: k */
    public final boolean m1904k(Class<?> cls) {
        HashMap<Class<?>, Annotation> map;
        AnnotationMap annotationMap = this.f4717k;
        if (annotationMap == null || (map = annotationMap.f4731j) == null) {
            return false;
        }
        return map.containsKey(cls);
    }

    /* renamed from: l */
    public abstract Annotated mo1890l(AnnotationMap annotationMap);
}

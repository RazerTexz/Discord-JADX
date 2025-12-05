package p007b.p195g.p196a.p205c;

import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.List;
import p007b.p195g.p196a.p198b.p203s.ResolvedType;
import p007b.p195g.p196a.p205c.p218h0.TypeBindings;
import p007b.p195g.p196a.p205c.p218h0.TypeFactory;
import p007b.p195g.p196a.p205c.p219i0.ClassUtil;

/* compiled from: JavaType.java */
/* renamed from: b.g.a.c.j, reason: use source file name */
/* loaded from: classes3.dex */
public abstract class JavaType extends ResolvedType implements Serializable, Type {
    private static final long serialVersionUID = 1;
    public final boolean _asStatic;
    public final Class<?> _class;
    public final int _hash;
    public final Object _typeHandler;
    public final Object _valueHandler;

    public JavaType(Class<?> cls, int i, Object obj, Object obj2, boolean z2) {
        this._class = cls;
        this._hash = cls.getName().hashCode() + i;
        this._valueHandler = obj;
        this._typeHandler = obj2;
        this._asStatic = z2;
    }

    /* renamed from: A */
    public final boolean m2215A() {
        Class<?> cls = this._class;
        Annotation[] annotationArr = ClassUtil.f4944a;
        Class<? super Object> superclass = cls.getSuperclass();
        return superclass != null && "java.lang.Record".equals(superclass.getName());
    }

    /* renamed from: B */
    public final boolean m2216B(Class<?> cls) {
        Class<?> cls2 = this._class;
        return cls2 == cls || cls.isAssignableFrom(cls2);
    }

    /* renamed from: C */
    public abstract JavaType mo2093C(Class<?> cls, TypeBindings typeBindings, JavaType javaType, JavaType[] javaTypeArr);

    /* renamed from: D */
    public abstract JavaType mo2094D(JavaType javaType);

    /* renamed from: E */
    public abstract JavaType mo2095E(Object obj);

    /* renamed from: F */
    public JavaType mo2105F(JavaType javaType) {
        Object obj = javaType._typeHandler;
        JavaType javaTypeMo2097H = obj != this._typeHandler ? mo2097H(obj) : this;
        Object obj2 = javaType._valueHandler;
        return obj2 != this._valueHandler ? javaTypeMo2097H.mo2098I(obj2) : javaTypeMo2097H;
    }

    /* renamed from: G */
    public abstract JavaType mo2096G();

    /* renamed from: H */
    public abstract JavaType mo2097H(Object obj);

    /* renamed from: I */
    public abstract JavaType mo2098I(Object obj);

    @Override // p007b.p195g.p196a.p198b.p203s.ResolvedType
    /* renamed from: a */
    public /* bridge */ /* synthetic */ ResolvedType mo1727a() {
        return mo2135p();
    }

    public abstract boolean equals(Object obj);

    /* renamed from: f */
    public abstract JavaType mo2142f(int i);

    /* renamed from: g */
    public abstract int mo2143g();

    /* renamed from: h */
    public JavaType m2217h(int i) {
        JavaType javaTypeMo2142f = mo2142f(i);
        return javaTypeMo2142f == null ? TypeFactory.m2158k() : javaTypeMo2142f;
    }

    public final int hashCode() {
        return this._hash;
    }

    /* renamed from: i */
    public abstract JavaType mo2144i(Class<?> cls);

    /* renamed from: j */
    public abstract TypeBindings mo2136j();

    /* renamed from: k */
    public JavaType mo2099k() {
        return null;
    }

    /* renamed from: l */
    public abstract StringBuilder mo2100l(StringBuilder sb);

    /* renamed from: m */
    public abstract StringBuilder mo2101m(StringBuilder sb);

    /* renamed from: n */
    public abstract List<JavaType> mo2145n();

    /* renamed from: o */
    public JavaType mo2121o() {
        return null;
    }

    /* renamed from: p */
    public JavaType mo2135p() {
        return null;
    }

    /* renamed from: q */
    public abstract JavaType mo2137q();

    /* renamed from: r */
    public boolean mo2102r() {
        return mo2143g() > 0;
    }

    /* renamed from: s */
    public boolean mo2103s() {
        return (this._typeHandler == null && this._valueHandler == null) ? false : true;
    }

    /* renamed from: t */
    public final boolean m2218t(Class<?> cls) {
        return this._class == cls;
    }

    /* renamed from: u */
    public boolean mo2111u() {
        return false;
    }

    /* renamed from: v */
    public abstract boolean mo2104v();

    /* renamed from: w */
    public final boolean m2219w() {
        return ClassUtil.m2185q(this._class);
    }

    /* renamed from: x */
    public final boolean m2220x() {
        return Modifier.isFinal(this._class.getModifiers());
    }

    /* renamed from: y */
    public final boolean m2221y() {
        return this._class == Object.class;
    }

    /* renamed from: z */
    public boolean mo2122z() {
        return false;
    }
}

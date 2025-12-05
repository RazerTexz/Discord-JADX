package p007b.p195g.p196a.p205c.p210c0;

import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.lang.reflect.Member;
import java.lang.reflect.Type;
import p007b.p100d.p104b.p105a.outline;
import p007b.p195g.p196a.p205c.JavaType;
import p007b.p195g.p196a.p205c.p219i0.ClassUtil;

/* compiled from: AnnotatedConstructor.java */
/* renamed from: b.g.a.c.c0.e, reason: use source file name */
/* loaded from: classes3.dex */
public final class AnnotatedConstructor extends AnnotatedWithParams {
    private static final long serialVersionUID = 1;
    public final Constructor<?> _constructor;
    public a _serialization;

    /* compiled from: AnnotatedConstructor.java */
    /* renamed from: b.g.a.c.c0.e$a */
    public static final class a implements Serializable {
        private static final long serialVersionUID = 1;
        public Class<?>[] args;
        public Class<?> clazz;

        public a(Constructor<?> constructor) {
            this.clazz = constructor.getDeclaringClass();
            this.args = constructor.getParameterTypes();
        }
    }

    public AnnotatedConstructor(TypeResolutionContext typeResolutionContext, Constructor<?> constructor, AnnotationMap annotationMap, AnnotationMap[] annotationMapArr) {
        super(typeResolutionContext, annotationMap, annotationMapArr);
        if (constructor == null) {
            throw new IllegalArgumentException("Null constructor not allowed");
        }
        this._constructor = constructor;
    }

    @Override // p007b.p195g.p196a.p205c.p210c0.Annotated
    /* renamed from: c */
    public String mo1819c() {
        return this._constructor.getName();
    }

    @Override // p007b.p195g.p196a.p205c.p210c0.Annotated
    /* renamed from: d */
    public Class<?> mo1820d() {
        return this._constructor.getDeclaringClass();
    }

    @Override // p007b.p195g.p196a.p205c.p210c0.Annotated
    /* renamed from: e */
    public JavaType mo1821e() {
        return this.f4716j.mo1831a(mo1820d());
    }

    @Override // p007b.p195g.p196a.p205c.p210c0.Annotated
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        return ClassUtil.m2183o(obj, AnnotatedConstructor.class) && ((AnnotatedConstructor) obj)._constructor == this._constructor;
    }

    @Override // p007b.p195g.p196a.p205c.p210c0.AnnotatedMember
    /* renamed from: g */
    public Class<?> mo1887g() {
        return this._constructor.getDeclaringClass();
    }

    @Override // p007b.p195g.p196a.p205c.p210c0.Annotated
    public int hashCode() {
        return this._constructor.getName().hashCode();
    }

    @Override // p007b.p195g.p196a.p205c.p210c0.AnnotatedMember
    /* renamed from: i */
    public Member mo1888i() {
        return this._constructor;
    }

    @Override // p007b.p195g.p196a.p205c.p210c0.AnnotatedMember
    /* renamed from: j */
    public Object mo1889j(Object obj) throws UnsupportedOperationException {
        StringBuilder sbM833U = outline.m833U("Cannot call getValue() on constructor of ");
        sbM833U.append(mo1887g().getName());
        throw new UnsupportedOperationException(sbM833U.toString());
    }

    @Override // p007b.p195g.p196a.p205c.p210c0.AnnotatedMember
    /* renamed from: l */
    public Annotated mo1890l(AnnotationMap annotationMap) {
        return new AnnotatedConstructor(this.f4716j, this._constructor, annotationMap, this._paramAnnotations);
    }

    @Override // p007b.p195g.p196a.p205c.p210c0.AnnotatedWithParams
    /* renamed from: n */
    public JavaType mo1891n(int i) {
        Type[] genericParameterTypes = this._constructor.getGenericParameterTypes();
        if (i >= genericParameterTypes.length) {
            return null;
        }
        return this.f4716j.mo1831a(genericParameterTypes[i]);
    }

    public Object readResolve() {
        a aVar = this._serialization;
        Class<?> cls = aVar.clazz;
        try {
            Constructor<?> declaredConstructor = cls.getDeclaredConstructor(aVar.args);
            if (!declaredConstructor.isAccessible()) {
                ClassUtil.m2172d(declaredConstructor, false);
            }
            return new AnnotatedConstructor(null, declaredConstructor, null, null);
        } catch (Exception unused) {
            StringBuilder sbM833U = outline.m833U("Could not find constructor with ");
            sbM833U.append(this._serialization.args.length);
            sbM833U.append(" args from Class '");
            sbM833U.append(cls.getName());
            throw new IllegalArgumentException(sbM833U.toString());
        }
    }

    public String toString() {
        int length = this._constructor.getParameterTypes().length;
        Object[] objArr = new Object[4];
        objArr[0] = ClassUtil.m2189u(this._constructor.getDeclaringClass());
        objArr[1] = Integer.valueOf(length);
        objArr[2] = length == 1 ? "" : "s";
        objArr[3] = this.f4717k;
        return String.format("[constructor for %s (%d arg%s), annotations: %s", objArr);
    }

    public Object writeReplace() {
        return new AnnotatedConstructor(new a(this._constructor));
    }

    public AnnotatedConstructor(a aVar) {
        super(null, null, null);
        this._constructor = null;
        this._serialization = aVar;
    }
}

package p007b.p195g.p196a.p205c.p210c0;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import p007b.p100d.p104b.p105a.outline;
import p007b.p195g.p196a.p205c.JavaType;
import p007b.p195g.p196a.p205c.p219i0.ClassUtil;

/* compiled from: AnnotatedMethod.java */
/* renamed from: b.g.a.c.c0.j, reason: use source file name */
/* loaded from: classes3.dex */
public final class AnnotatedMethod extends AnnotatedWithParams implements Serializable {
    private static final long serialVersionUID = 1;
    public Class<?>[] _paramClasses;
    public a _serialization;

    /* renamed from: l */
    public final transient Method f4718l;

    /* compiled from: AnnotatedMethod.java */
    /* renamed from: b.g.a.c.c0.j$a */
    public static final class a implements Serializable {
        private static final long serialVersionUID = 1;
        public Class<?>[] args;
        public Class<?> clazz;
        public String name;

        public a(Method method) {
            this.clazz = method.getDeclaringClass();
            this.name = method.getName();
            this.args = method.getParameterTypes();
        }
    }

    public AnnotatedMethod(TypeResolutionContext typeResolutionContext, Method method, AnnotationMap annotationMap, AnnotationMap[] annotationMapArr) {
        super(typeResolutionContext, annotationMap, annotationMapArr);
        if (method == null) {
            throw new IllegalArgumentException("Cannot construct AnnotatedMethod with null Method");
        }
        this.f4718l = method;
    }

    @Override // p007b.p195g.p196a.p205c.p210c0.Annotated
    /* renamed from: c */
    public String mo1819c() {
        return this.f4718l.getName();
    }

    @Override // p007b.p195g.p196a.p205c.p210c0.Annotated
    /* renamed from: d */
    public Class<?> mo1820d() {
        return this.f4718l.getReturnType();
    }

    @Override // p007b.p195g.p196a.p205c.p210c0.Annotated
    /* renamed from: e */
    public JavaType mo1821e() {
        return this.f4716j.mo1831a(this.f4718l.getGenericReturnType());
    }

    @Override // p007b.p195g.p196a.p205c.p210c0.Annotated
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        return ClassUtil.m2183o(obj, AnnotatedMethod.class) && ((AnnotatedMethod) obj).f4718l == this.f4718l;
    }

    @Override // p007b.p195g.p196a.p205c.p210c0.AnnotatedMember
    /* renamed from: g */
    public Class<?> mo1887g() {
        return this.f4718l.getDeclaringClass();
    }

    @Override // p007b.p195g.p196a.p205c.p210c0.AnnotatedMember
    /* renamed from: h */
    public String mo1903h() {
        String strMo1903h = super.mo1903h();
        int iM1905o = m1905o();
        if (iM1905o == 0) {
            return outline.m883w(strMo1903h, "()");
        }
        if (iM1905o != 1) {
            return String.format("%s(%d params)", super.mo1903h(), Integer.valueOf(m1905o()));
        }
        StringBuilder sbM836X = outline.m836X(strMo1903h, "(");
        sbM836X.append(m1906p(0).getName());
        sbM836X.append(")");
        return sbM836X.toString();
    }

    @Override // p007b.p195g.p196a.p205c.p210c0.Annotated
    public int hashCode() {
        return this.f4718l.getName().hashCode();
    }

    @Override // p007b.p195g.p196a.p205c.p210c0.AnnotatedMember
    /* renamed from: i */
    public Member mo1888i() {
        return this.f4718l;
    }

    @Override // p007b.p195g.p196a.p205c.p210c0.AnnotatedMember
    /* renamed from: j */
    public Object mo1889j(Object obj) throws IllegalArgumentException {
        try {
            return this.f4718l.invoke(obj, null);
        } catch (IllegalAccessException | InvocationTargetException e) {
            StringBuilder sbM833U = outline.m833U("Failed to getValue() with method ");
            sbM833U.append(mo1903h());
            sbM833U.append(": ");
            sbM833U.append(e.getMessage());
            throw new IllegalArgumentException(sbM833U.toString(), e);
        }
    }

    @Override // p007b.p195g.p196a.p205c.p210c0.AnnotatedMember
    /* renamed from: l */
    public Annotated mo1890l(AnnotationMap annotationMap) {
        return new AnnotatedMethod(this.f4716j, this.f4718l, annotationMap, this._paramAnnotations);
    }

    @Override // p007b.p195g.p196a.p205c.p210c0.AnnotatedWithParams
    /* renamed from: n */
    public JavaType mo1891n(int i) {
        Type[] genericParameterTypes = this.f4718l.getGenericParameterTypes();
        if (i >= genericParameterTypes.length) {
            return null;
        }
        return this.f4716j.mo1831a(genericParameterTypes[i]);
    }

    /* renamed from: o */
    public int m1905o() {
        if (this._paramClasses == null) {
            this._paramClasses = this.f4718l.getParameterTypes();
        }
        return this._paramClasses.length;
    }

    /* renamed from: p */
    public Class<?> m1906p(int i) {
        if (this._paramClasses == null) {
            this._paramClasses = this.f4718l.getParameterTypes();
        }
        Class<?>[] clsArr = this._paramClasses;
        if (i >= clsArr.length) {
            return null;
        }
        return clsArr[i];
    }

    public Object readResolve() {
        a aVar = this._serialization;
        Class<?> cls = aVar.clazz;
        try {
            Method declaredMethod = cls.getDeclaredMethod(aVar.name, aVar.args);
            if (!declaredMethod.isAccessible()) {
                ClassUtil.m2172d(declaredMethod, false);
            }
            return new AnnotatedMethod(null, declaredMethod, null, null);
        } catch (Exception unused) {
            StringBuilder sbM833U = outline.m833U("Could not find method '");
            sbM833U.append(this._serialization.name);
            sbM833U.append("' from Class '");
            sbM833U.append(cls.getName());
            throw new IllegalArgumentException(sbM833U.toString());
        }
    }

    public String toString() {
        StringBuilder sbM833U = outline.m833U("[method ");
        sbM833U.append(mo1903h());
        sbM833U.append("]");
        return sbM833U.toString();
    }

    public Object writeReplace() {
        return new AnnotatedMethod(new a(this.f4718l));
    }

    public AnnotatedMethod(a aVar) {
        super(null, null, null);
        this.f4718l = null;
        this._serialization = aVar;
    }
}

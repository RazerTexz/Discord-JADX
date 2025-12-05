package p007b.p195g.p196a.p205c.p210c0;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.Member;
import p007b.p100d.p104b.p105a.outline;
import p007b.p195g.p196a.p205c.JavaType;
import p007b.p195g.p196a.p205c.p219i0.ClassUtil;

/* compiled from: AnnotatedField.java */
/* renamed from: b.g.a.c.c0.g, reason: use source file name */
/* loaded from: classes3.dex */
public final class AnnotatedField extends AnnotatedMember implements Serializable {
    private static final long serialVersionUID = 1;
    public a _serialization;

    /* renamed from: l */
    public final transient Field f4708l;

    /* compiled from: AnnotatedField.java */
    /* renamed from: b.g.a.c.c0.g$a */
    public static final class a implements Serializable {
        private static final long serialVersionUID = 1;
        public Class<?> clazz;
        public String name;

        public a(Field field) {
            this.clazz = field.getDeclaringClass();
            this.name = field.getName();
        }
    }

    public AnnotatedField(TypeResolutionContext typeResolutionContext, Field field, AnnotationMap annotationMap) {
        super(typeResolutionContext, annotationMap);
        this.f4708l = field;
    }

    @Override // p007b.p195g.p196a.p205c.p210c0.Annotated
    /* renamed from: c */
    public String mo1819c() {
        return this.f4708l.getName();
    }

    @Override // p007b.p195g.p196a.p205c.p210c0.Annotated
    /* renamed from: d */
    public Class<?> mo1820d() {
        return this.f4708l.getType();
    }

    @Override // p007b.p195g.p196a.p205c.p210c0.Annotated
    /* renamed from: e */
    public JavaType mo1821e() {
        return this.f4716j.mo1831a(this.f4708l.getGenericType());
    }

    @Override // p007b.p195g.p196a.p205c.p210c0.Annotated
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        return ClassUtil.m2183o(obj, AnnotatedField.class) && ((AnnotatedField) obj).f4708l == this.f4708l;
    }

    @Override // p007b.p195g.p196a.p205c.p210c0.AnnotatedMember
    /* renamed from: g */
    public Class<?> mo1887g() {
        return this.f4708l.getDeclaringClass();
    }

    @Override // p007b.p195g.p196a.p205c.p210c0.Annotated
    public int hashCode() {
        return this.f4708l.getName().hashCode();
    }

    @Override // p007b.p195g.p196a.p205c.p210c0.AnnotatedMember
    /* renamed from: i */
    public Member mo1888i() {
        return this.f4708l;
    }

    @Override // p007b.p195g.p196a.p205c.p210c0.AnnotatedMember
    /* renamed from: j */
    public Object mo1889j(Object obj) throws IllegalArgumentException {
        try {
            return this.f4708l.get(obj);
        } catch (IllegalAccessException e) {
            StringBuilder sbM833U = outline.m833U("Failed to getValue() for field ");
            sbM833U.append(mo1903h());
            sbM833U.append(": ");
            sbM833U.append(e.getMessage());
            throw new IllegalArgumentException(sbM833U.toString(), e);
        }
    }

    @Override // p007b.p195g.p196a.p205c.p210c0.AnnotatedMember
    /* renamed from: l */
    public Annotated mo1890l(AnnotationMap annotationMap) {
        return new AnnotatedField(this.f4716j, this.f4708l, annotationMap);
    }

    public Object readResolve() {
        a aVar = this._serialization;
        Class<?> cls = aVar.clazz;
        try {
            Field declaredField = cls.getDeclaredField(aVar.name);
            if (!declaredField.isAccessible()) {
                ClassUtil.m2172d(declaredField, false);
            }
            return new AnnotatedField(null, declaredField, null);
        } catch (Exception unused) {
            StringBuilder sbM833U = outline.m833U("Could not find method '");
            sbM833U.append(this._serialization.name);
            sbM833U.append("' from Class '");
            sbM833U.append(cls.getName());
            throw new IllegalArgumentException(sbM833U.toString());
        }
    }

    public String toString() {
        StringBuilder sbM833U = outline.m833U("[field ");
        sbM833U.append(mo1903h());
        sbM833U.append("]");
        return sbM833U.toString();
    }

    public Object writeReplace() {
        return new AnnotatedField(new a(this.f4708l));
    }

    public AnnotatedField(a aVar) {
        super(null, null);
        this.f4708l = null;
        this._serialization = aVar;
    }
}

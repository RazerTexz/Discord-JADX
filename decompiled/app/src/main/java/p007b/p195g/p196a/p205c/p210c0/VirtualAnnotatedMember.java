package p007b.p195g.p196a.p205c.p210c0;

import java.io.Serializable;
import java.lang.reflect.Member;
import p007b.p100d.p104b.p105a.outline;
import p007b.p195g.p196a.p205c.JavaType;
import p007b.p195g.p196a.p205c.p219i0.ClassUtil;

/* compiled from: VirtualAnnotatedMember.java */
/* renamed from: b.g.a.c.c0.f0, reason: use source file name */
/* loaded from: classes3.dex */
public class VirtualAnnotatedMember extends AnnotatedMember implements Serializable {
    private static final long serialVersionUID = 1;
    public final Class<?> _declaringClass;
    public final String _name;
    public final JavaType _type;

    public VirtualAnnotatedMember(TypeResolutionContext typeResolutionContext, Class<?> cls, String str, JavaType javaType) {
        super(typeResolutionContext, null);
        this._declaringClass = cls;
        this._type = javaType;
        this._name = str;
    }

    @Override // p007b.p195g.p196a.p205c.p210c0.Annotated
    /* renamed from: c */
    public String mo1819c() {
        return this._name;
    }

    @Override // p007b.p195g.p196a.p205c.p210c0.Annotated
    /* renamed from: d */
    public Class<?> mo1820d() {
        return this._type._class;
    }

    @Override // p007b.p195g.p196a.p205c.p210c0.Annotated
    /* renamed from: e */
    public JavaType mo1821e() {
        return this._type;
    }

    @Override // p007b.p195g.p196a.p205c.p210c0.Annotated
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!ClassUtil.m2183o(obj, VirtualAnnotatedMember.class)) {
            return false;
        }
        VirtualAnnotatedMember virtualAnnotatedMember = (VirtualAnnotatedMember) obj;
        return virtualAnnotatedMember._declaringClass == this._declaringClass && virtualAnnotatedMember._name.equals(this._name);
    }

    @Override // p007b.p195g.p196a.p205c.p210c0.AnnotatedMember
    /* renamed from: g */
    public Class<?> mo1887g() {
        return this._declaringClass;
    }

    @Override // p007b.p195g.p196a.p205c.p210c0.Annotated
    public int hashCode() {
        return this._name.hashCode();
    }

    @Override // p007b.p195g.p196a.p205c.p210c0.AnnotatedMember
    /* renamed from: i */
    public Member mo1888i() {
        return null;
    }

    @Override // p007b.p195g.p196a.p205c.p210c0.AnnotatedMember
    /* renamed from: j */
    public Object mo1889j(Object obj) throws IllegalArgumentException {
        throw new IllegalArgumentException(outline.m822J(outline.m833U("Cannot get virtual property '"), this._name, "'"));
    }

    @Override // p007b.p195g.p196a.p205c.p210c0.AnnotatedMember
    /* renamed from: l */
    public Annotated mo1890l(AnnotationMap annotationMap) {
        return this;
    }

    public String toString() {
        StringBuilder sbM833U = outline.m833U("[virtual ");
        sbM833U.append(mo1903h());
        sbM833U.append("]");
        return sbM833U.toString();
    }
}

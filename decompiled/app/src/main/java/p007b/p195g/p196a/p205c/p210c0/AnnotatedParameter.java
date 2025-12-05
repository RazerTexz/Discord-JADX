package p007b.p195g.p196a.p205c.p210c0;

import java.lang.reflect.Member;
import p007b.p100d.p104b.p105a.outline;
import p007b.p195g.p196a.p205c.JavaType;
import p007b.p195g.p196a.p205c.p219i0.ClassUtil;

/* compiled from: AnnotatedParameter.java */
/* renamed from: b.g.a.c.c0.m, reason: use source file name */
/* loaded from: classes3.dex */
public final class AnnotatedParameter extends AnnotatedMember {
    private static final long serialVersionUID = 1;
    public final int _index;
    public final AnnotatedWithParams _owner;
    public final JavaType _type;

    public AnnotatedParameter(AnnotatedWithParams annotatedWithParams, JavaType javaType, TypeResolutionContext typeResolutionContext, AnnotationMap annotationMap, int i) {
        super(typeResolutionContext, annotationMap);
        this._owner = annotatedWithParams;
        this._type = javaType;
        this._index = i;
    }

    @Override // p007b.p195g.p196a.p205c.p210c0.Annotated
    /* renamed from: c */
    public String mo1819c() {
        return "";
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
        if (!ClassUtil.m2183o(obj, AnnotatedParameter.class)) {
            return false;
        }
        AnnotatedParameter annotatedParameter = (AnnotatedParameter) obj;
        return annotatedParameter._owner.equals(this._owner) && annotatedParameter._index == this._index;
    }

    @Override // p007b.p195g.p196a.p205c.p210c0.AnnotatedMember
    /* renamed from: g */
    public Class<?> mo1887g() {
        return this._owner.mo1887g();
    }

    @Override // p007b.p195g.p196a.p205c.p210c0.Annotated
    public int hashCode() {
        return this._owner.hashCode() + this._index;
    }

    @Override // p007b.p195g.p196a.p205c.p210c0.AnnotatedMember
    /* renamed from: i */
    public Member mo1888i() {
        return this._owner.mo1888i();
    }

    @Override // p007b.p195g.p196a.p205c.p210c0.AnnotatedMember
    /* renamed from: j */
    public Object mo1889j(Object obj) throws UnsupportedOperationException {
        StringBuilder sbM833U = outline.m833U("Cannot call getValue() on constructor parameter of ");
        sbM833U.append(mo1887g().getName());
        throw new UnsupportedOperationException(sbM833U.toString());
    }

    @Override // p007b.p195g.p196a.p205c.p210c0.AnnotatedMember
    /* renamed from: l */
    public Annotated mo1890l(AnnotationMap annotationMap) {
        if (annotationMap == this.f4717k) {
            return this;
        }
        AnnotatedWithParams annotatedWithParams = this._owner;
        int i = this._index;
        annotatedWithParams._paramAnnotations[i] = annotationMap;
        return annotatedWithParams.m1910m(i);
    }

    public String toString() {
        StringBuilder sbM833U = outline.m833U("[parameter #");
        sbM833U.append(this._index);
        sbM833U.append(", annotations: ");
        sbM833U.append(this.f4717k);
        sbM833U.append("]");
        return sbM833U.toString();
    }
}

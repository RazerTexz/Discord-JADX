package p007b.p195g.p196a.p205c.p218h0;

import p007b.p195g.p196a.p198b.p203s.ResolvedType;
import p007b.p195g.p196a.p205c.JavaType;

/* JADX INFO: renamed from: b.g.a.c.h0.i, reason: use source file name */
/* JADX INFO: compiled from: ReferenceType.java */
/* JADX INFO: loaded from: classes3.dex */
public class ReferenceType extends SimpleType {
    private static final long serialVersionUID = 1;
    public final JavaType _anchorType;
    public final JavaType _referencedType;

    public ReferenceType(Class<?> cls, TypeBindings typeBindings, JavaType javaType, JavaType[] javaTypeArr, JavaType javaType2, JavaType javaType3, Object obj, Object obj2, boolean z2) {
        super(cls, typeBindings, javaType, javaTypeArr, javaType2._hash, obj, obj2, z2);
        this._referencedType = javaType2;
        this._anchorType = javaType3 == null ? this : javaType3;
    }

    @Override // p007b.p195g.p196a.p205c.p218h0.SimpleType, p007b.p195g.p196a.p205c.JavaType
    /* JADX INFO: renamed from: C */
    public JavaType mo2093C(Class<?> cls, TypeBindings typeBindings, JavaType javaType, JavaType[] javaTypeArr) {
        return new ReferenceType(cls, this._bindings, javaType, javaTypeArr, this._referencedType, this._anchorType, this._valueHandler, this._typeHandler, this._asStatic);
    }

    @Override // p007b.p195g.p196a.p205c.p218h0.SimpleType, p007b.p195g.p196a.p205c.JavaType
    /* JADX INFO: renamed from: D */
    public JavaType mo2094D(JavaType javaType) {
        return this._referencedType == javaType ? this : new ReferenceType(this._class, this._bindings, this._superClass, this._superInterfaces, javaType, this._anchorType, this._valueHandler, this._typeHandler, this._asStatic);
    }

    @Override // p007b.p195g.p196a.p205c.p218h0.SimpleType, p007b.p195g.p196a.p205c.JavaType
    /* JADX INFO: renamed from: E */
    public JavaType mo2095E(Object obj) {
        JavaType javaType = this._referencedType;
        return obj == javaType._typeHandler ? this : new ReferenceType(this._class, this._bindings, this._superClass, this._superInterfaces, javaType.mo2097H(obj), this._anchorType, this._valueHandler, this._typeHandler, this._asStatic);
    }

    @Override // p007b.p195g.p196a.p205c.p218h0.SimpleType, p007b.p195g.p196a.p205c.JavaType
    /* JADX INFO: renamed from: G */
    public /* bridge */ /* synthetic */ JavaType mo2096G() {
        return m2132P();
    }

    @Override // p007b.p195g.p196a.p205c.p218h0.SimpleType, p007b.p195g.p196a.p205c.JavaType
    /* JADX INFO: renamed from: H */
    public /* bridge */ /* synthetic */ JavaType mo2097H(Object obj) {
        return m2133Q(obj);
    }

    @Override // p007b.p195g.p196a.p205c.p218h0.SimpleType, p007b.p195g.p196a.p205c.JavaType
    /* JADX INFO: renamed from: I */
    public /* bridge */ /* synthetic */ JavaType mo2098I(Object obj) {
        return m2134R(obj);
    }

    @Override // p007b.p195g.p196a.p205c.p218h0.SimpleType, p007b.p195g.p196a.p205c.p218h0.TypeBase
    /* JADX INFO: renamed from: K */
    public String mo2106K() {
        return this._class.getName() + '<' + this._referencedType.mo1729e() + '>';
    }

    @Override // p007b.p195g.p196a.p205c.p218h0.SimpleType
    /* JADX INFO: renamed from: M */
    public /* bridge */ /* synthetic */ SimpleType mo2129M() {
        return m2132P();
    }

    @Override // p007b.p195g.p196a.p205c.p218h0.SimpleType
    /* JADX INFO: renamed from: N */
    public /* bridge */ /* synthetic */ SimpleType mo2130N(Object obj) {
        return m2133Q(obj);
    }

    @Override // p007b.p195g.p196a.p205c.p218h0.SimpleType
    /* JADX INFO: renamed from: O */
    public /* bridge */ /* synthetic */ SimpleType mo2131O(Object obj) {
        return m2134R(obj);
    }

    /* JADX INFO: renamed from: P */
    public ReferenceType m2132P() {
        return this._asStatic ? this : new ReferenceType(this._class, this._bindings, this._superClass, this._superInterfaces, this._referencedType.mo2096G(), this._anchorType, this._valueHandler, this._typeHandler, true);
    }

    /* JADX INFO: renamed from: Q */
    public ReferenceType m2133Q(Object obj) {
        return obj == this._typeHandler ? this : new ReferenceType(this._class, this._bindings, this._superClass, this._superInterfaces, this._referencedType, this._anchorType, this._valueHandler, obj, this._asStatic);
    }

    /* JADX INFO: renamed from: R */
    public ReferenceType m2134R(Object obj) {
        return obj == this._valueHandler ? this : new ReferenceType(this._class, this._bindings, this._superClass, this._superInterfaces, this._referencedType, this._anchorType, obj, this._typeHandler, this._asStatic);
    }

    @Override // p007b.p195g.p196a.p205c.JavaType, p007b.p195g.p196a.p198b.p203s.ResolvedType
    /* JADX INFO: renamed from: a */
    public ResolvedType mo1727a() {
        return this._referencedType;
    }

    @Override // p007b.p195g.p196a.p198b.p203s.ResolvedType
    /* JADX INFO: renamed from: b */
    public boolean mo1728b() {
        return true;
    }

    @Override // p007b.p195g.p196a.p205c.p218h0.SimpleType, p007b.p195g.p196a.p205c.JavaType
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != ReferenceType.class) {
            return false;
        }
        ReferenceType referenceType = (ReferenceType) obj;
        if (referenceType._class != this._class) {
            return false;
        }
        return this._referencedType.equals(referenceType._referencedType);
    }

    @Override // p007b.p195g.p196a.p205c.JavaType
    /* JADX INFO: renamed from: k */
    public JavaType mo2099k() {
        return this._referencedType;
    }

    @Override // p007b.p195g.p196a.p205c.p218h0.SimpleType, p007b.p195g.p196a.p205c.JavaType
    /* JADX INFO: renamed from: l */
    public StringBuilder mo2100l(StringBuilder sb) {
        TypeBase.m2139J(this._class, sb, true);
        return sb;
    }

    @Override // p007b.p195g.p196a.p205c.p218h0.SimpleType, p007b.p195g.p196a.p205c.JavaType
    /* JADX INFO: renamed from: m */
    public StringBuilder mo2101m(StringBuilder sb) {
        TypeBase.m2139J(this._class, sb, false);
        sb.append('<');
        StringBuilder sbMo2101m = this._referencedType.mo2101m(sb);
        sbMo2101m.append(">;");
        return sbMo2101m;
    }

    @Override // p007b.p195g.p196a.p205c.JavaType
    /* JADX INFO: renamed from: p */
    public JavaType mo2135p() {
        return this._referencedType;
    }

    @Override // p007b.p195g.p196a.p205c.p218h0.SimpleType
    public String toString() {
        StringBuilder sb = new StringBuilder(40);
        sb.append("[reference type, class ");
        sb.append(mo2106K());
        sb.append('<');
        sb.append(this._referencedType);
        sb.append('>');
        sb.append(']');
        return sb.toString();
    }
}

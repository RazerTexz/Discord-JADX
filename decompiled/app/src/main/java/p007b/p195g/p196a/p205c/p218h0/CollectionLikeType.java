package p007b.p195g.p196a.p205c.p218h0;

import p007b.p100d.p104b.p105a.outline;
import p007b.p195g.p196a.p205c.JavaType;

/* compiled from: CollectionLikeType.java */
/* renamed from: b.g.a.c.h0.d, reason: use source file name */
/* loaded from: classes3.dex */
public class CollectionLikeType extends TypeBase {
    private static final long serialVersionUID = 1;
    public final JavaType _elementType;

    public CollectionLikeType(Class<?> cls, TypeBindings typeBindings, JavaType javaType, JavaType[] javaTypeArr, JavaType javaType2, Object obj, Object obj2, boolean z2) {
        super(cls, typeBindings, javaType, javaTypeArr, javaType2._hash, obj, obj2, z2);
        this._elementType = javaType2;
    }

    @Override // p007b.p195g.p196a.p205c.JavaType
    /* renamed from: C */
    public JavaType mo2093C(Class<?> cls, TypeBindings typeBindings, JavaType javaType, JavaType[] javaTypeArr) {
        return new CollectionLikeType(cls, typeBindings, javaType, javaTypeArr, this._elementType, this._valueHandler, this._typeHandler, this._asStatic);
    }

    @Override // p007b.p195g.p196a.p205c.JavaType
    /* renamed from: D */
    public JavaType mo2094D(JavaType javaType) {
        return this._elementType == javaType ? this : new CollectionLikeType(this._class, this._bindings, this._superClass, this._superInterfaces, javaType, this._valueHandler, this._typeHandler, this._asStatic);
    }

    @Override // p007b.p195g.p196a.p205c.JavaType
    /* renamed from: E */
    public /* bridge */ /* synthetic */ JavaType mo2095E(Object obj) {
        return mo2107L(obj);
    }

    @Override // p007b.p195g.p196a.p205c.JavaType
    /* renamed from: F */
    public JavaType mo2105F(JavaType javaType) {
        JavaType javaTypeMo2105F;
        JavaType javaTypeMo2105F2 = super.mo2105F(javaType);
        JavaType javaTypeMo2099k = javaType.mo2099k();
        return (javaTypeMo2099k == null || (javaTypeMo2105F = this._elementType.mo2105F(javaTypeMo2099k)) == this._elementType) ? javaTypeMo2105F2 : javaTypeMo2105F2.mo2094D(javaTypeMo2105F);
    }

    @Override // p007b.p195g.p196a.p205c.JavaType
    /* renamed from: G */
    public /* bridge */ /* synthetic */ JavaType mo2096G() {
        return mo2108M();
    }

    @Override // p007b.p195g.p196a.p205c.JavaType
    /* renamed from: H */
    public /* bridge */ /* synthetic */ JavaType mo2097H(Object obj) {
        return mo2109N(obj);
    }

    @Override // p007b.p195g.p196a.p205c.JavaType
    /* renamed from: I */
    public /* bridge */ /* synthetic */ JavaType mo2098I(Object obj) {
        return mo2110O(obj);
    }

    @Override // p007b.p195g.p196a.p205c.p218h0.TypeBase
    /* renamed from: K */
    public String mo2106K() {
        StringBuilder sb = new StringBuilder();
        sb.append(this._class.getName());
        if (this._elementType != null) {
            sb.append('<');
            sb.append(this._elementType.mo1729e());
            sb.append('>');
        }
        return sb.toString();
    }

    /* renamed from: L */
    public CollectionLikeType mo2107L(Object obj) {
        return new CollectionLikeType(this._class, this._bindings, this._superClass, this._superInterfaces, this._elementType.mo2097H(obj), this._valueHandler, this._typeHandler, this._asStatic);
    }

    /* renamed from: M */
    public CollectionLikeType mo2108M() {
        return this._asStatic ? this : new CollectionLikeType(this._class, this._bindings, this._superClass, this._superInterfaces, this._elementType.mo2096G(), this._valueHandler, this._typeHandler, true);
    }

    /* renamed from: N */
    public CollectionLikeType mo2109N(Object obj) {
        return new CollectionLikeType(this._class, this._bindings, this._superClass, this._superInterfaces, this._elementType, this._valueHandler, obj, this._asStatic);
    }

    /* renamed from: O */
    public CollectionLikeType mo2110O(Object obj) {
        return new CollectionLikeType(this._class, this._bindings, this._superClass, this._superInterfaces, this._elementType, obj, this._typeHandler, this._asStatic);
    }

    @Override // p007b.p195g.p196a.p205c.JavaType
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != getClass()) {
            return false;
        }
        CollectionLikeType collectionLikeType = (CollectionLikeType) obj;
        return this._class == collectionLikeType._class && this._elementType.equals(collectionLikeType._elementType);
    }

    @Override // p007b.p195g.p196a.p205c.JavaType
    /* renamed from: k */
    public JavaType mo2099k() {
        return this._elementType;
    }

    @Override // p007b.p195g.p196a.p205c.JavaType
    /* renamed from: l */
    public StringBuilder mo2100l(StringBuilder sb) {
        TypeBase.m2139J(this._class, sb, true);
        return sb;
    }

    @Override // p007b.p195g.p196a.p205c.JavaType
    /* renamed from: m */
    public StringBuilder mo2101m(StringBuilder sb) {
        TypeBase.m2139J(this._class, sb, false);
        sb.append('<');
        this._elementType.mo2101m(sb);
        sb.append(">;");
        return sb;
    }

    @Override // p007b.p195g.p196a.p205c.JavaType
    /* renamed from: s */
    public boolean mo2103s() {
        return super.mo2103s() || this._elementType.mo2103s();
    }

    public String toString() {
        StringBuilder sbM833U = outline.m833U("[collection-like type; class ");
        outline.m860k0(this._class, sbM833U, ", contains ");
        sbM833U.append(this._elementType);
        sbM833U.append("]");
        return sbM833U.toString();
    }

    @Override // p007b.p195g.p196a.p205c.JavaType
    /* renamed from: u */
    public boolean mo2111u() {
        return true;
    }

    @Override // p007b.p195g.p196a.p205c.JavaType
    /* renamed from: v */
    public boolean mo2104v() {
        return true;
    }
}

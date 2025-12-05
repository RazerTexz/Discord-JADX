package p007b.p195g.p196a.p205c.p218h0;

import p007b.p100d.p104b.p105a.outline;
import p007b.p195g.p196a.p205c.JavaType;

/* compiled from: CollectionType.java */
/* renamed from: b.g.a.c.h0.e, reason: use source file name */
/* loaded from: classes3.dex */
public final class CollectionType extends CollectionLikeType {
    private static final long serialVersionUID = 1;

    public CollectionType(Class<?> cls, TypeBindings typeBindings, JavaType javaType, JavaType[] javaTypeArr, JavaType javaType2, Object obj, Object obj2, boolean z2) {
        super(cls, typeBindings, javaType, javaTypeArr, javaType2, obj, obj2, z2);
    }

    @Override // p007b.p195g.p196a.p205c.p218h0.CollectionLikeType, p007b.p195g.p196a.p205c.JavaType
    /* renamed from: C */
    public JavaType mo2093C(Class<?> cls, TypeBindings typeBindings, JavaType javaType, JavaType[] javaTypeArr) {
        return new CollectionType(cls, typeBindings, javaType, javaTypeArr, this._elementType, this._valueHandler, this._typeHandler, this._asStatic);
    }

    @Override // p007b.p195g.p196a.p205c.p218h0.CollectionLikeType, p007b.p195g.p196a.p205c.JavaType
    /* renamed from: D */
    public JavaType mo2094D(JavaType javaType) {
        return this._elementType == javaType ? this : new CollectionType(this._class, this._bindings, this._superClass, this._superInterfaces, javaType, this._valueHandler, this._typeHandler, this._asStatic);
    }

    @Override // p007b.p195g.p196a.p205c.p218h0.CollectionLikeType, p007b.p195g.p196a.p205c.JavaType
    /* renamed from: E */
    public /* bridge */ /* synthetic */ JavaType mo2095E(Object obj) {
        return m2112P(obj);
    }

    @Override // p007b.p195g.p196a.p205c.p218h0.CollectionLikeType, p007b.p195g.p196a.p205c.JavaType
    /* renamed from: G */
    public /* bridge */ /* synthetic */ JavaType mo2096G() {
        return m2113Q();
    }

    @Override // p007b.p195g.p196a.p205c.p218h0.CollectionLikeType, p007b.p195g.p196a.p205c.JavaType
    /* renamed from: H */
    public /* bridge */ /* synthetic */ JavaType mo2097H(Object obj) {
        return m2114R(obj);
    }

    @Override // p007b.p195g.p196a.p205c.p218h0.CollectionLikeType, p007b.p195g.p196a.p205c.JavaType
    /* renamed from: I */
    public /* bridge */ /* synthetic */ JavaType mo2098I(Object obj) {
        return m2115S(obj);
    }

    @Override // p007b.p195g.p196a.p205c.p218h0.CollectionLikeType
    /* renamed from: L */
    public /* bridge */ /* synthetic */ CollectionLikeType mo2107L(Object obj) {
        return m2112P(obj);
    }

    @Override // p007b.p195g.p196a.p205c.p218h0.CollectionLikeType
    /* renamed from: M */
    public /* bridge */ /* synthetic */ CollectionLikeType mo2108M() {
        return m2113Q();
    }

    @Override // p007b.p195g.p196a.p205c.p218h0.CollectionLikeType
    /* renamed from: N */
    public /* bridge */ /* synthetic */ CollectionLikeType mo2109N(Object obj) {
        return m2114R(obj);
    }

    @Override // p007b.p195g.p196a.p205c.p218h0.CollectionLikeType
    /* renamed from: O */
    public /* bridge */ /* synthetic */ CollectionLikeType mo2110O(Object obj) {
        return m2115S(obj);
    }

    /* renamed from: P */
    public CollectionType m2112P(Object obj) {
        return new CollectionType(this._class, this._bindings, this._superClass, this._superInterfaces, this._elementType.mo2097H(obj), this._valueHandler, this._typeHandler, this._asStatic);
    }

    /* renamed from: Q */
    public CollectionType m2113Q() {
        return this._asStatic ? this : new CollectionType(this._class, this._bindings, this._superClass, this._superInterfaces, this._elementType.mo2096G(), this._valueHandler, this._typeHandler, true);
    }

    /* renamed from: R */
    public CollectionType m2114R(Object obj) {
        return new CollectionType(this._class, this._bindings, this._superClass, this._superInterfaces, this._elementType, this._valueHandler, obj, this._asStatic);
    }

    /* renamed from: S */
    public CollectionType m2115S(Object obj) {
        return new CollectionType(this._class, this._bindings, this._superClass, this._superInterfaces, this._elementType, obj, this._typeHandler, this._asStatic);
    }

    @Override // p007b.p195g.p196a.p205c.p218h0.CollectionLikeType
    public String toString() {
        StringBuilder sbM833U = outline.m833U("[collection type; class ");
        outline.m860k0(this._class, sbM833U, ", contains ");
        sbM833U.append(this._elementType);
        sbM833U.append("]");
        return sbM833U.toString();
    }
}

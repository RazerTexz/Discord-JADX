package p007b.p195g.p196a.p205c.p218h0;

import p007b.p100d.p104b.p105a.outline;
import p007b.p195g.p196a.p205c.JavaType;

/* compiled from: MapType.java */
/* renamed from: b.g.a.c.h0.g, reason: use source file name */
/* loaded from: classes3.dex */
public final class MapType extends MapLikeType {
    private static final long serialVersionUID = 1;

    public MapType(Class<?> cls, TypeBindings typeBindings, JavaType javaType, JavaType[] javaTypeArr, JavaType javaType2, JavaType javaType3, Object obj, Object obj2, boolean z2) {
        super(cls, typeBindings, javaType, javaTypeArr, javaType2, javaType3, obj, obj2, z2);
    }

    /* renamed from: Q */
    public static MapType m2123Q(Class<?> cls, TypeBindings typeBindings, JavaType javaType, JavaType[] javaTypeArr, JavaType javaType2, JavaType javaType3) {
        return new MapType(cls, typeBindings, javaType, javaTypeArr, javaType2, javaType3, null, null, false);
    }

    @Override // p007b.p195g.p196a.p205c.p218h0.MapLikeType, p007b.p195g.p196a.p205c.JavaType
    /* renamed from: C */
    public JavaType mo2093C(Class<?> cls, TypeBindings typeBindings, JavaType javaType, JavaType[] javaTypeArr) {
        return new MapType(cls, typeBindings, javaType, javaTypeArr, this._keyType, this._valueType, this._valueHandler, this._typeHandler, this._asStatic);
    }

    @Override // p007b.p195g.p196a.p205c.p218h0.MapLikeType, p007b.p195g.p196a.p205c.JavaType
    /* renamed from: D */
    public JavaType mo2094D(JavaType javaType) {
        return this._valueType == javaType ? this : new MapType(this._class, this._bindings, this._superClass, this._superInterfaces, this._keyType, javaType, this._valueHandler, this._typeHandler, this._asStatic);
    }

    @Override // p007b.p195g.p196a.p205c.p218h0.MapLikeType, p007b.p195g.p196a.p205c.JavaType
    /* renamed from: E */
    public /* bridge */ /* synthetic */ JavaType mo2095E(Object obj) {
        return m2124R(obj);
    }

    @Override // p007b.p195g.p196a.p205c.p218h0.MapLikeType, p007b.p195g.p196a.p205c.JavaType
    /* renamed from: G */
    public /* bridge */ /* synthetic */ JavaType mo2096G() {
        return m2125S();
    }

    @Override // p007b.p195g.p196a.p205c.p218h0.MapLikeType, p007b.p195g.p196a.p205c.JavaType
    /* renamed from: H */
    public /* bridge */ /* synthetic */ JavaType mo2097H(Object obj) {
        return m2126T(obj);
    }

    @Override // p007b.p195g.p196a.p205c.p218h0.MapLikeType, p007b.p195g.p196a.p205c.JavaType
    /* renamed from: I */
    public /* bridge */ /* synthetic */ JavaType mo2098I(Object obj) {
        return m2127U(obj);
    }

    @Override // p007b.p195g.p196a.p205c.p218h0.MapLikeType
    /* renamed from: L */
    public /* bridge */ /* synthetic */ MapLikeType mo2116L(Object obj) {
        return m2124R(obj);
    }

    @Override // p007b.p195g.p196a.p205c.p218h0.MapLikeType
    /* renamed from: M */
    public MapLikeType mo2117M(JavaType javaType) {
        return javaType == this._keyType ? this : new MapType(this._class, this._bindings, this._superClass, this._superInterfaces, javaType, this._valueType, this._valueHandler, this._typeHandler, this._asStatic);
    }

    @Override // p007b.p195g.p196a.p205c.p218h0.MapLikeType
    /* renamed from: N */
    public /* bridge */ /* synthetic */ MapLikeType mo2118N() {
        return m2125S();
    }

    @Override // p007b.p195g.p196a.p205c.p218h0.MapLikeType
    /* renamed from: O */
    public /* bridge */ /* synthetic */ MapLikeType mo2119O(Object obj) {
        return m2126T(obj);
    }

    @Override // p007b.p195g.p196a.p205c.p218h0.MapLikeType
    /* renamed from: P */
    public /* bridge */ /* synthetic */ MapLikeType mo2120P(Object obj) {
        return m2127U(obj);
    }

    /* renamed from: R */
    public MapType m2124R(Object obj) {
        return new MapType(this._class, this._bindings, this._superClass, this._superInterfaces, this._keyType, this._valueType.mo2097H(obj), this._valueHandler, this._typeHandler, this._asStatic);
    }

    /* renamed from: S */
    public MapType m2125S() {
        return this._asStatic ? this : new MapType(this._class, this._bindings, this._superClass, this._superInterfaces, this._keyType.mo2096G(), this._valueType.mo2096G(), this._valueHandler, this._typeHandler, true);
    }

    /* renamed from: T */
    public MapType m2126T(Object obj) {
        return new MapType(this._class, this._bindings, this._superClass, this._superInterfaces, this._keyType, this._valueType, this._valueHandler, obj, this._asStatic);
    }

    /* renamed from: U */
    public MapType m2127U(Object obj) {
        return new MapType(this._class, this._bindings, this._superClass, this._superInterfaces, this._keyType, this._valueType, obj, this._typeHandler, this._asStatic);
    }

    @Override // p007b.p195g.p196a.p205c.p218h0.MapLikeType
    public String toString() {
        StringBuilder sbM833U = outline.m833U("[map type; class ");
        outline.m860k0(this._class, sbM833U, ", ");
        sbM833U.append(this._keyType);
        sbM833U.append(" -> ");
        sbM833U.append(this._valueType);
        sbM833U.append("]");
        return sbM833U.toString();
    }
}

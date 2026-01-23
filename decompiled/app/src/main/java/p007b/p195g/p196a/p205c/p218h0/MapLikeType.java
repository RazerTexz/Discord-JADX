package p007b.p195g.p196a.p205c.p218h0;

import p007b.p195g.p196a.p205c.JavaType;

/* JADX INFO: renamed from: b.g.a.c.h0.f, reason: use source file name */
/* JADX INFO: compiled from: MapLikeType.java */
/* JADX INFO: loaded from: classes3.dex */
public class MapLikeType extends TypeBase {
    private static final long serialVersionUID = 1;
    public final JavaType _keyType;
    public final JavaType _valueType;

    public MapLikeType(Class<?> cls, TypeBindings typeBindings, JavaType javaType, JavaType[] javaTypeArr, JavaType javaType2, JavaType javaType3, Object obj, Object obj2, boolean z2) {
        super(cls, typeBindings, javaType, javaTypeArr, javaType2._hash ^ javaType3._hash, obj, obj2, z2);
        this._keyType = javaType2;
        this._valueType = javaType3;
    }

    @Override // p007b.p195g.p196a.p205c.JavaType
    /* JADX INFO: renamed from: C */
    public JavaType mo2093C(Class<?> cls, TypeBindings typeBindings, JavaType javaType, JavaType[] javaTypeArr) {
        return new MapLikeType(cls, typeBindings, javaType, javaTypeArr, this._keyType, this._valueType, this._valueHandler, this._typeHandler, this._asStatic);
    }

    @Override // p007b.p195g.p196a.p205c.JavaType
    /* JADX INFO: renamed from: D */
    public JavaType mo2094D(JavaType javaType) {
        return this._valueType == javaType ? this : new MapLikeType(this._class, this._bindings, this._superClass, this._superInterfaces, this._keyType, javaType, this._valueHandler, this._typeHandler, this._asStatic);
    }

    @Override // p007b.p195g.p196a.p205c.JavaType
    /* JADX INFO: renamed from: E */
    public /* bridge */ /* synthetic */ JavaType mo2095E(Object obj) {
        return mo2116L(obj);
    }

    @Override // p007b.p195g.p196a.p205c.JavaType
    /* JADX INFO: renamed from: F */
    public JavaType mo2105F(JavaType javaType) {
        JavaType javaTypeMo2105F;
        JavaType javaTypeMo2105F2;
        JavaType javaTypeMo2105F3 = super.mo2105F(javaType);
        JavaType javaTypeMo2121o = javaType.mo2121o();
        if ((javaTypeMo2105F3 instanceof MapLikeType) && javaTypeMo2121o != null && (javaTypeMo2105F2 = this._keyType.mo2105F(javaTypeMo2121o)) != this._keyType) {
            javaTypeMo2105F3 = ((MapLikeType) javaTypeMo2105F3).mo2117M(javaTypeMo2105F2);
        }
        JavaType javaTypeMo2099k = javaType.mo2099k();
        return (javaTypeMo2099k == null || (javaTypeMo2105F = this._valueType.mo2105F(javaTypeMo2099k)) == this._valueType) ? javaTypeMo2105F3 : javaTypeMo2105F3.mo2094D(javaTypeMo2105F);
    }

    @Override // p007b.p195g.p196a.p205c.JavaType
    /* JADX INFO: renamed from: G */
    public /* bridge */ /* synthetic */ JavaType mo2096G() {
        return mo2118N();
    }

    @Override // p007b.p195g.p196a.p205c.JavaType
    /* JADX INFO: renamed from: H */
    public /* bridge */ /* synthetic */ JavaType mo2097H(Object obj) {
        return mo2119O(obj);
    }

    @Override // p007b.p195g.p196a.p205c.JavaType
    /* JADX INFO: renamed from: I */
    public /* bridge */ /* synthetic */ JavaType mo2098I(Object obj) {
        return mo2120P(obj);
    }

    @Override // p007b.p195g.p196a.p205c.p218h0.TypeBase
    /* JADX INFO: renamed from: K */
    public String mo2106K() {
        StringBuilder sb = new StringBuilder();
        sb.append(this._class.getName());
        if (this._keyType != null) {
            sb.append('<');
            sb.append(this._keyType.mo1729e());
            sb.append(',');
            sb.append(this._valueType.mo1729e());
            sb.append('>');
        }
        return sb.toString();
    }

    /* JADX INFO: renamed from: L */
    public MapLikeType mo2116L(Object obj) {
        return new MapLikeType(this._class, this._bindings, this._superClass, this._superInterfaces, this._keyType, this._valueType.mo2097H(obj), this._valueHandler, this._typeHandler, this._asStatic);
    }

    /* JADX INFO: renamed from: M */
    public MapLikeType mo2117M(JavaType javaType) {
        return javaType == this._keyType ? this : new MapLikeType(this._class, this._bindings, this._superClass, this._superInterfaces, javaType, this._valueType, this._valueHandler, this._typeHandler, this._asStatic);
    }

    /* JADX INFO: renamed from: N */
    public MapLikeType mo2118N() {
        return this._asStatic ? this : new MapLikeType(this._class, this._bindings, this._superClass, this._superInterfaces, this._keyType, this._valueType.mo2096G(), this._valueHandler, this._typeHandler, true);
    }

    /* JADX INFO: renamed from: O */
    public MapLikeType mo2119O(Object obj) {
        return new MapLikeType(this._class, this._bindings, this._superClass, this._superInterfaces, this._keyType, this._valueType, this._valueHandler, obj, this._asStatic);
    }

    /* JADX INFO: renamed from: P */
    public MapLikeType mo2120P(Object obj) {
        return new MapLikeType(this._class, this._bindings, this._superClass, this._superInterfaces, this._keyType, this._valueType, obj, this._typeHandler, this._asStatic);
    }

    @Override // p007b.p195g.p196a.p205c.JavaType
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != getClass()) {
            return false;
        }
        MapLikeType mapLikeType = (MapLikeType) obj;
        return this._class == mapLikeType._class && this._keyType.equals(mapLikeType._keyType) && this._valueType.equals(mapLikeType._valueType);
    }

    @Override // p007b.p195g.p196a.p205c.JavaType
    /* JADX INFO: renamed from: k */
    public JavaType mo2099k() {
        return this._valueType;
    }

    @Override // p007b.p195g.p196a.p205c.JavaType
    /* JADX INFO: renamed from: l */
    public StringBuilder mo2100l(StringBuilder sb) {
        TypeBase.m2139J(this._class, sb, true);
        return sb;
    }

    @Override // p007b.p195g.p196a.p205c.JavaType
    /* JADX INFO: renamed from: m */
    public StringBuilder mo2101m(StringBuilder sb) {
        TypeBase.m2139J(this._class, sb, false);
        sb.append('<');
        this._keyType.mo2101m(sb);
        this._valueType.mo2101m(sb);
        sb.append(">;");
        return sb;
    }

    @Override // p007b.p195g.p196a.p205c.JavaType
    /* JADX INFO: renamed from: o */
    public JavaType mo2121o() {
        return this._keyType;
    }

    @Override // p007b.p195g.p196a.p205c.JavaType
    /* JADX INFO: renamed from: s */
    public boolean mo2103s() {
        return super.mo2103s() || this._valueType.mo2103s() || this._keyType.mo2103s();
    }

    public String toString() {
        return String.format("[map-like type; class %s, %s -> %s]", this._class.getName(), this._keyType, this._valueType);
    }

    @Override // p007b.p195g.p196a.p205c.JavaType
    /* JADX INFO: renamed from: v */
    public boolean mo2104v() {
        return true;
    }

    @Override // p007b.p195g.p196a.p205c.JavaType
    /* JADX INFO: renamed from: z */
    public boolean mo2122z() {
        return true;
    }
}

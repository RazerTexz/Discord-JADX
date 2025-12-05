package p007b.p195g.p196a.p205c.p218h0;

import java.lang.reflect.Array;
import p007b.p100d.p104b.p105a.outline;
import p007b.p195g.p196a.p205c.JavaType;

/* compiled from: ArrayType.java */
/* renamed from: b.g.a.c.h0.a, reason: use source file name */
/* loaded from: classes3.dex */
public final class ArrayType extends TypeBase {
    private static final long serialVersionUID = 1;
    public final JavaType _componentType;
    public final Object _emptyArray;

    public ArrayType(JavaType javaType, TypeBindings typeBindings, Object obj, Object obj2, Object obj3, boolean z2) {
        super(obj.getClass(), typeBindings, null, null, javaType._hash, obj2, obj3, z2);
        this._componentType = javaType;
        this._emptyArray = obj;
    }

    /* renamed from: L */
    public static ArrayType m2092L(JavaType javaType, TypeBindings typeBindings) {
        return new ArrayType(javaType, typeBindings, Array.newInstance(javaType._class, 0), null, null, false);
    }

    @Override // p007b.p195g.p196a.p205c.JavaType
    /* renamed from: C */
    public JavaType mo2093C(Class<?> cls, TypeBindings typeBindings, JavaType javaType, JavaType[] javaTypeArr) {
        return null;
    }

    @Override // p007b.p195g.p196a.p205c.JavaType
    /* renamed from: D */
    public JavaType mo2094D(JavaType javaType) throws NegativeArraySizeException {
        return new ArrayType(javaType, this._bindings, Array.newInstance(javaType._class, 0), this._valueHandler, this._typeHandler, this._asStatic);
    }

    @Override // p007b.p195g.p196a.p205c.JavaType
    /* renamed from: E */
    public JavaType mo2095E(Object obj) {
        JavaType javaType = this._componentType;
        return obj == javaType._typeHandler ? this : new ArrayType(javaType.mo2097H(obj), this._bindings, this._emptyArray, this._valueHandler, this._typeHandler, this._asStatic);
    }

    @Override // p007b.p195g.p196a.p205c.JavaType
    /* renamed from: G */
    public JavaType mo2096G() {
        return this._asStatic ? this : new ArrayType(this._componentType.mo2096G(), this._bindings, this._emptyArray, this._valueHandler, this._typeHandler, true);
    }

    @Override // p007b.p195g.p196a.p205c.JavaType
    /* renamed from: H */
    public JavaType mo2097H(Object obj) {
        return obj == this._typeHandler ? this : new ArrayType(this._componentType, this._bindings, this._emptyArray, this._valueHandler, obj, this._asStatic);
    }

    @Override // p007b.p195g.p196a.p205c.JavaType
    /* renamed from: I */
    public JavaType mo2098I(Object obj) {
        return obj == this._valueHandler ? this : new ArrayType(this._componentType, this._bindings, this._emptyArray, obj, this._typeHandler, this._asStatic);
    }

    @Override // p007b.p195g.p196a.p205c.JavaType
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj != null && obj.getClass() == ArrayType.class) {
            return this._componentType.equals(((ArrayType) obj)._componentType);
        }
        return false;
    }

    @Override // p007b.p195g.p196a.p205c.JavaType
    /* renamed from: k */
    public JavaType mo2099k() {
        return this._componentType;
    }

    @Override // p007b.p195g.p196a.p205c.JavaType
    /* renamed from: l */
    public StringBuilder mo2100l(StringBuilder sb) {
        sb.append('[');
        return this._componentType.mo2100l(sb);
    }

    @Override // p007b.p195g.p196a.p205c.JavaType
    /* renamed from: m */
    public StringBuilder mo2101m(StringBuilder sb) {
        sb.append('[');
        return this._componentType.mo2101m(sb);
    }

    @Override // p007b.p195g.p196a.p205c.JavaType
    /* renamed from: r */
    public boolean mo2102r() {
        return this._componentType.mo2102r();
    }

    @Override // p007b.p195g.p196a.p205c.JavaType
    /* renamed from: s */
    public boolean mo2103s() {
        return super.mo2103s() || this._componentType.mo2103s();
    }

    public String toString() {
        StringBuilder sbM833U = outline.m833U("[array type, component type: ");
        sbM833U.append(this._componentType);
        sbM833U.append("]");
        return sbM833U.toString();
    }

    @Override // p007b.p195g.p196a.p205c.JavaType
    /* renamed from: v */
    public boolean mo2104v() {
        return true;
    }
}

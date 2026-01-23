package p007b.p195g.p196a.p205c.p218h0;

import p007b.p195g.p196a.p205c.JavaType;

/* JADX INFO: renamed from: b.g.a.c.h0.k, reason: use source file name */
/* JADX INFO: compiled from: SimpleType.java */
/* JADX INFO: loaded from: classes3.dex */
public class SimpleType extends TypeBase {
    private static final long serialVersionUID = 1;

    public SimpleType(Class<?> cls, TypeBindings typeBindings, JavaType javaType, JavaType[] javaTypeArr, Object obj, Object obj2, boolean z2) {
        super(cls, typeBindings, javaType, javaTypeArr, 0, obj, obj2, z2);
    }

    /* JADX INFO: renamed from: L */
    public static SimpleType m2138L(Class<?> cls) {
        return new SimpleType(cls, null, null, null, null, null, false);
    }

    @Override // p007b.p195g.p196a.p205c.JavaType
    /* JADX INFO: renamed from: C */
    public JavaType mo2093C(Class<?> cls, TypeBindings typeBindings, JavaType javaType, JavaType[] javaTypeArr) {
        return null;
    }

    @Override // p007b.p195g.p196a.p205c.JavaType
    /* JADX INFO: renamed from: D */
    public JavaType mo2094D(JavaType javaType) {
        throw new IllegalArgumentException("Simple types have no content types; cannot call withContentType()");
    }

    @Override // p007b.p195g.p196a.p205c.JavaType
    /* JADX INFO: renamed from: E */
    public JavaType mo2095E(Object obj) {
        throw new IllegalArgumentException("Simple types have no content types; cannot call withContenTypeHandler()");
    }

    @Override // p007b.p195g.p196a.p205c.JavaType
    /* JADX INFO: renamed from: G */
    public /* bridge */ /* synthetic */ JavaType mo2096G() {
        return mo2129M();
    }

    @Override // p007b.p195g.p196a.p205c.JavaType
    /* JADX INFO: renamed from: H */
    public /* bridge */ /* synthetic */ JavaType mo2097H(Object obj) {
        return mo2130N(obj);
    }

    @Override // p007b.p195g.p196a.p205c.JavaType
    /* JADX INFO: renamed from: I */
    public /* bridge */ /* synthetic */ JavaType mo2098I(Object obj) {
        return mo2131O(obj);
    }

    @Override // p007b.p195g.p196a.p205c.p218h0.TypeBase
    /* JADX INFO: renamed from: K */
    public String mo2106K() {
        StringBuilder sb = new StringBuilder();
        sb.append(this._class.getName());
        int iM2155j = this._bindings.m2155j();
        if (iM2155j > 0) {
            sb.append('<');
            for (int i = 0; i < iM2155j; i++) {
                JavaType javaTypeMo2142f = mo2142f(i);
                if (i > 0) {
                    sb.append(',');
                }
                sb.append(javaTypeMo2142f.mo1729e());
            }
            sb.append('>');
        }
        return sb.toString();
    }

    /* JADX INFO: renamed from: M */
    public SimpleType mo2129M() {
        return this._asStatic ? this : new SimpleType(this._class, this._bindings, this._superClass, this._superInterfaces, this._valueHandler, this._typeHandler, true);
    }

    /* JADX INFO: renamed from: N */
    public SimpleType mo2130N(Object obj) {
        return this._typeHandler == obj ? this : new SimpleType(this._class, this._bindings, this._superClass, this._superInterfaces, this._valueHandler, obj, this._asStatic);
    }

    /* JADX INFO: renamed from: O */
    public SimpleType mo2131O(Object obj) {
        return obj == this._valueHandler ? this : new SimpleType(this._class, this._bindings, this._superClass, this._superInterfaces, obj, this._typeHandler, this._asStatic);
    }

    @Override // p007b.p195g.p196a.p205c.JavaType
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != getClass()) {
            return false;
        }
        SimpleType simpleType = (SimpleType) obj;
        if (simpleType._class != this._class) {
            return false;
        }
        return this._bindings.equals(simpleType._bindings);
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
        int iM2155j = this._bindings.m2155j();
        if (iM2155j > 0) {
            sb.append('<');
            for (int i = 0; i < iM2155j; i++) {
                sb = mo2142f(i).mo2101m(sb);
            }
            sb.append('>');
        }
        sb.append(';');
        return sb;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(40);
        sb.append("[simple type, class ");
        sb.append(mo2106K());
        sb.append(']');
        return sb.toString();
    }

    @Override // p007b.p195g.p196a.p205c.JavaType
    /* JADX INFO: renamed from: v */
    public boolean mo2104v() {
        return false;
    }

    public SimpleType(Class<?> cls) {
        this(cls, TypeBindings.f4908l, null, null, null, null, false);
    }

    public SimpleType(Class<?> cls, TypeBindings typeBindings, JavaType javaType, JavaType[] javaTypeArr, int i, Object obj, Object obj2, boolean z2) {
        super(cls, typeBindings, javaType, javaTypeArr, i, obj, obj2, z2);
    }
}

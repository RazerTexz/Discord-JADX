package p007b.p195g.p196a.p205c.p218h0;

import p007b.p195g.p196a.p205c.JavaType;

/* JADX INFO: renamed from: b.g.a.c.h0.j, reason: use source file name */
/* JADX INFO: compiled from: ResolvedRecursiveType.java */
/* JADX INFO: loaded from: classes3.dex */
public class ResolvedRecursiveType extends TypeBase {
    private static final long serialVersionUID = 1;
    public JavaType _referencedType;

    public ResolvedRecursiveType(Class<?> cls, TypeBindings typeBindings) {
        super(cls, typeBindings, null, null, 0, null, null, false);
    }

    @Override // p007b.p195g.p196a.p205c.JavaType
    /* JADX INFO: renamed from: C */
    public JavaType mo2093C(Class<?> cls, TypeBindings typeBindings, JavaType javaType, JavaType[] javaTypeArr) {
        return null;
    }

    @Override // p007b.p195g.p196a.p205c.JavaType
    /* JADX INFO: renamed from: D */
    public JavaType mo2094D(JavaType javaType) {
        return this;
    }

    @Override // p007b.p195g.p196a.p205c.JavaType
    /* JADX INFO: renamed from: E */
    public JavaType mo2095E(Object obj) {
        return this;
    }

    @Override // p007b.p195g.p196a.p205c.JavaType
    /* JADX INFO: renamed from: G */
    public JavaType mo2096G() {
        return this;
    }

    @Override // p007b.p195g.p196a.p205c.JavaType
    /* JADX INFO: renamed from: H */
    public JavaType mo2097H(Object obj) {
        return this;
    }

    @Override // p007b.p195g.p196a.p205c.JavaType
    /* JADX INFO: renamed from: I */
    public JavaType mo2098I(Object obj) {
        return this;
    }

    @Override // p007b.p195g.p196a.p205c.JavaType
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj != null && obj.getClass() == ResolvedRecursiveType.class) {
        }
        return false;
    }

    @Override // p007b.p195g.p196a.p205c.p218h0.TypeBase, p007b.p195g.p196a.p205c.JavaType
    /* JADX INFO: renamed from: j */
    public TypeBindings mo2136j() {
        JavaType javaType = this._referencedType;
        return javaType != null ? javaType.mo2136j() : this._bindings;
    }

    @Override // p007b.p195g.p196a.p205c.JavaType
    /* JADX INFO: renamed from: l */
    public StringBuilder mo2100l(StringBuilder sb) {
        JavaType javaType = this._referencedType;
        return javaType != null ? javaType.mo2100l(sb) : sb;
    }

    @Override // p007b.p195g.p196a.p205c.JavaType
    /* JADX INFO: renamed from: m */
    public StringBuilder mo2101m(StringBuilder sb) {
        JavaType javaType = this._referencedType;
        if (javaType != null) {
            return javaType.mo2100l(sb);
        }
        sb.append("?");
        return sb;
    }

    @Override // p007b.p195g.p196a.p205c.p218h0.TypeBase, p007b.p195g.p196a.p205c.JavaType
    /* JADX INFO: renamed from: q */
    public JavaType mo2137q() {
        JavaType javaType = this._referencedType;
        return javaType != null ? javaType.mo2137q() : this._superClass;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(40);
        sb.append("[recursive type; ");
        JavaType javaType = this._referencedType;
        if (javaType == null) {
            sb.append("UNRESOLVED");
        } else {
            sb.append(javaType._class.getName());
        }
        return sb.toString();
    }

    @Override // p007b.p195g.p196a.p205c.JavaType
    /* JADX INFO: renamed from: v */
    public boolean mo2104v() {
        return false;
    }
}

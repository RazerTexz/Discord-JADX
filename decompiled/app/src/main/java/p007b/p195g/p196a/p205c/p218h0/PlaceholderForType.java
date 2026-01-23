package p007b.p195g.p196a.p205c.p218h0;

import p007b.p100d.p104b.p105a.outline;
import p007b.p195g.p196a.p205c.JavaType;

/* JADX INFO: renamed from: b.g.a.c.h0.h, reason: use source file name */
/* JADX INFO: compiled from: PlaceholderForType.java */
/* JADX INFO: loaded from: classes3.dex */
public class PlaceholderForType extends TypeBase {
    private static final long serialVersionUID = 1;
    public JavaType _actualType;
    public final int _ordinal;

    public PlaceholderForType(int i) {
        super(Object.class, TypeBindings.f4908l, TypeFactory.m2158k(), null, 1, null, null, false);
        this._ordinal = i;
    }

    @Override // p007b.p195g.p196a.p205c.JavaType
    /* JADX INFO: renamed from: C */
    public JavaType mo2093C(Class<?> cls, TypeBindings typeBindings, JavaType javaType, JavaType[] javaTypeArr) {
        m2128L();
        throw null;
    }

    @Override // p007b.p195g.p196a.p205c.JavaType
    /* JADX INFO: renamed from: D */
    public JavaType mo2094D(JavaType javaType) {
        m2128L();
        throw null;
    }

    @Override // p007b.p195g.p196a.p205c.JavaType
    /* JADX INFO: renamed from: E */
    public JavaType mo2095E(Object obj) {
        m2128L();
        throw null;
    }

    @Override // p007b.p195g.p196a.p205c.JavaType
    /* JADX INFO: renamed from: G */
    public JavaType mo2096G() {
        m2128L();
        throw null;
    }

    @Override // p007b.p195g.p196a.p205c.JavaType
    /* JADX INFO: renamed from: H */
    public JavaType mo2097H(Object obj) {
        m2128L();
        throw null;
    }

    @Override // p007b.p195g.p196a.p205c.JavaType
    /* JADX INFO: renamed from: I */
    public JavaType mo2098I(Object obj) {
        m2128L();
        throw null;
    }

    @Override // p007b.p195g.p196a.p205c.p218h0.TypeBase
    /* JADX INFO: renamed from: K */
    public String mo2106K() {
        return toString();
    }

    /* JADX INFO: renamed from: L */
    public final <T> T m2128L() {
        StringBuilder sbM833U = outline.m833U("Operation should not be attempted on ");
        sbM833U.append(PlaceholderForType.class.getName());
        throw new UnsupportedOperationException(sbM833U.toString());
    }

    @Override // p007b.p195g.p196a.p205c.JavaType
    public boolean equals(Object obj) {
        return obj == this;
    }

    @Override // p007b.p195g.p196a.p205c.JavaType
    /* JADX INFO: renamed from: l */
    public StringBuilder mo2100l(StringBuilder sb) {
        sb.append('$');
        sb.append(this._ordinal + 1);
        return sb;
    }

    @Override // p007b.p195g.p196a.p205c.JavaType
    /* JADX INFO: renamed from: m */
    public StringBuilder mo2101m(StringBuilder sb) {
        mo2100l(sb);
        return sb;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        mo2100l(sb);
        return sb.toString();
    }

    @Override // p007b.p195g.p196a.p205c.JavaType
    /* JADX INFO: renamed from: v */
    public boolean mo2104v() {
        return false;
    }
}

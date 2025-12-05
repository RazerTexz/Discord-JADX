package p007b.p195g.p196a.p205c.p210c0;

import p007b.p195g.p196a.p197a.JsonInclude;
import p007b.p195g.p196a.p205c.AnnotationIntrospector;
import p007b.p195g.p196a.p205c.PropertyMetadata;
import p007b.p195g.p196a.p205c.PropertyName;

/* compiled from: BeanPropertyDefinition.java */
/* renamed from: b.g.a.c.c0.s, reason: use source file name */
/* loaded from: classes3.dex */
public abstract class BeanPropertyDefinition {

    /* renamed from: j */
    public static final JsonInclude.b f4747j;

    static {
        JsonInclude.b bVar = JsonInclude.b.f4436j;
        f4747j = JsonInclude.b.f4436j;
    }

    /* renamed from: f */
    public boolean mo1849f() {
        Annotated annotatedMo1853k = mo1853k();
        if (annotatedMo1853k == null && (annotatedMo1853k = mo1861s()) == null) {
            annotatedMo1853k = mo1854l();
        }
        return annotatedMo1853k != null;
    }

    /* renamed from: g */
    public abstract JsonInclude.b mo1850g();

    /* renamed from: h */
    public AnnotationIntrospector.a mo1851h() {
        return null;
    }

    /* renamed from: i */
    public Class<?>[] mo1852i() {
        return null;
    }

    /* renamed from: j */
    public AnnotatedMember m1922j() {
        AnnotatedMethod annotatedMethodMo1856n = mo1856n();
        return annotatedMethodMo1856n == null ? mo1854l() : annotatedMethodMo1856n;
    }

    /* renamed from: k */
    public abstract AnnotatedParameter mo1853k();

    /* renamed from: l */
    public abstract AnnotatedField mo1854l();

    /* renamed from: m */
    public abstract PropertyName mo1855m();

    /* renamed from: n */
    public abstract AnnotatedMethod mo1856n();

    /* renamed from: o */
    public abstract PropertyMetadata mo1857o();

    /* renamed from: p */
    public abstract String mo1858p();

    /* renamed from: q */
    public abstract AnnotatedMember mo1859q();

    /* renamed from: r */
    public abstract Class<?> mo1860r();

    /* renamed from: s */
    public abstract AnnotatedMethod mo1861s();

    /* renamed from: t */
    public abstract PropertyName mo1862t();

    /* renamed from: u */
    public abstract boolean mo1863u();

    /* renamed from: v */
    public boolean mo1864v() {
        return false;
    }
}

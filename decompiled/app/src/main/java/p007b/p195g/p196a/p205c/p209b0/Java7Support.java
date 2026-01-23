package p007b.p195g.p196a.p205c.p209b0;

import p007b.p195g.p196a.p205c.PropertyName;
import p007b.p195g.p196a.p205c.p210c0.Annotated;
import p007b.p195g.p196a.p205c.p210c0.AnnotatedParameter;
import p007b.p195g.p196a.p205c.p219i0.ClassUtil;

/* JADX INFO: renamed from: b.g.a.c.b0.c, reason: use source file name */
/* JADX INFO: compiled from: Java7Support.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class Java7Support {

    /* JADX INFO: renamed from: a */
    public static final Java7Support f4622a;

    static {
        Java7Support java7Support;
        try {
            java7Support = (Java7Support) ClassUtil.m2175g(Class.forName("b.g.a.c.b0.d"), false);
        } catch (Throwable unused) {
            java7Support = null;
        }
        f4622a = java7Support;
    }

    /* JADX INFO: renamed from: a */
    public abstract PropertyName mo1804a(AnnotatedParameter annotatedParameter);

    /* JADX INFO: renamed from: b */
    public abstract Boolean mo1805b(Annotated annotated);

    /* JADX INFO: renamed from: c */
    public abstract Boolean mo1806c(Annotated annotated);
}

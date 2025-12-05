package p507d0.p513e0.p514p.p515d.p517m0.p521c.p526k1.p527a;

import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: ReflectJavaClassFinder.kt */
/* renamed from: d0.e0.p.d.m0.c.k1.a.e, reason: use source file name */
/* loaded from: classes3.dex */
public final class ReflectJavaClassFinder2 {
    public static final Class<?> tryLoadClass(ClassLoader classLoader, String str) {
        Intrinsics3.checkNotNullParameter(classLoader, "<this>");
        Intrinsics3.checkNotNullParameter(str, "fqName");
        try {
            return Class.forName(str, false, classLoader);
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }
}

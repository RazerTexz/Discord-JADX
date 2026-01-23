package p007b.p225i.p408d.p410q.p413y;

import java.lang.reflect.AccessibleObject;
import p007b.p225i.p408d.p410q.JavaVersion;

/* JADX INFO: renamed from: b.i.d.q.y.b, reason: use source file name */
/* JADX INFO: compiled from: ReflectionAccessor.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class ReflectionAccessor {

    /* JADX INFO: renamed from: a */
    public static final ReflectionAccessor f13148a;

    static {
        f13148a = JavaVersion.f13123a < 9 ? new PreJava9ReflectionAccessor() : new UnsafeReflectionAccessor();
    }

    /* JADX INFO: renamed from: a */
    public abstract void mo6912a(AccessibleObject accessibleObject);
}

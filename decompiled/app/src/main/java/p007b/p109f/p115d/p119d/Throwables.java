package p007b.p109f.p115d.p119d;

/* JADX INFO: renamed from: b.f.d.d.m, reason: use source file name */
/* JADX INFO: compiled from: Throwables.java */
/* JADX INFO: loaded from: classes.dex */
public final class Throwables {
    /* JADX INFO: renamed from: a */
    public static void m972a(Throwable th) throws Throwable {
        if (Error.class.isInstance(th)) {
            throw ((Throwable) Error.class.cast(th));
        }
        if (RuntimeException.class.isInstance(th)) {
            throw ((Throwable) RuntimeException.class.cast(th));
        }
    }
}

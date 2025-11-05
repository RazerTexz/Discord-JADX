package b.f.d.d;

/* compiled from: Throwables.java */
/* loaded from: classes.dex */
public final class m {
    public static void a(Throwable th) throws Throwable {
        if (Error.class.isInstance(th)) {
            throw ((Throwable) Error.class.cast(th));
        }
        if (RuntimeException.class.isInstance(th)) {
            throw ((Throwable) RuntimeException.class.cast(th));
        }
    }
}

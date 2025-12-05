package p007b.p225i.p355b.p356a;

import com.google.errorprone.annotations.ForOverride;
import java.io.Serializable;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: Equivalence.java */
/* renamed from: b.i.b.a.d, reason: use source file name */
/* loaded from: classes3.dex */
public abstract class Equivalence<T> {

    /* compiled from: Equivalence.java */
    /* renamed from: b.i.b.a.d$a */
    public static final class a extends Equivalence<Object> implements Serializable {

        /* renamed from: j */
        public static final a f11948j = new a();
        private static final long serialVersionUID = 1;

        private Object readResolve() {
            return f11948j;
        }

        @Override // p007b.p225i.p355b.p356a.Equivalence
        /* renamed from: a */
        public boolean mo6211a(Object obj, Object obj2) {
            return obj.equals(obj2);
        }

        @Override // p007b.p225i.p355b.p356a.Equivalence
        /* renamed from: b */
        public int mo6212b(Object obj) {
            return obj.hashCode();
        }
    }

    /* compiled from: Equivalence.java */
    /* renamed from: b.i.b.a.d$b */
    public static final class b extends Equivalence<Object> implements Serializable {

        /* renamed from: j */
        public static final b f11949j = new b();
        private static final long serialVersionUID = 1;

        private Object readResolve() {
            return f11949j;
        }

        @Override // p007b.p225i.p355b.p356a.Equivalence
        /* renamed from: a */
        public boolean mo6211a(Object obj, Object obj2) {
            return false;
        }

        @Override // p007b.p225i.p355b.p356a.Equivalence
        /* renamed from: b */
        public int mo6212b(Object obj) {
            return System.identityHashCode(obj);
        }
    }

    @ForOverride
    /* renamed from: a */
    public abstract boolean mo6211a(T t, T t2);

    @ForOverride
    /* renamed from: b */
    public abstract int mo6212b(T t);

    /* renamed from: c */
    public final boolean m6213c(@NullableDecl T t, @NullableDecl T t2) {
        if (t == t2) {
            return true;
        }
        if (t == null || t2 == null) {
            return false;
        }
        return mo6211a(t, t2);
    }
}

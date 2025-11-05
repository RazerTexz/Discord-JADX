package b.i.b.b;

import java.util.Comparator;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: ComparisonChain.java */
/* loaded from: classes3.dex */
public abstract class j {
    public static final j a = new a();

    /* renamed from: b, reason: collision with root package name */
    public static final j f1646b = new b(-1);
    public static final j c = new b(1);

    /* compiled from: ComparisonChain.java */
    public static class a extends j {
        public a() {
            super(null);
        }

        @Override // b.i.b.b.j
        public j a(int i, int i2) {
            return f(i < i2 ? -1 : i > i2 ? 1 : 0);
        }

        @Override // b.i.b.b.j
        public <T> j b(@NullableDecl T t, @NullableDecl T t2, Comparator<T> comparator) {
            return f(comparator.compare(t, t2));
        }

        @Override // b.i.b.b.j
        public j c(boolean z2, boolean z3) {
            return f(z2 == z3 ? 0 : z2 ? 1 : -1);
        }

        @Override // b.i.b.b.j
        public j d(boolean z2, boolean z3) {
            return f(z3 == z2 ? 0 : z3 ? 1 : -1);
        }

        @Override // b.i.b.b.j
        public int e() {
            return 0;
        }

        public j f(int i) {
            return i < 0 ? j.f1646b : i > 0 ? j.c : j.a;
        }
    }

    /* compiled from: ComparisonChain.java */
    public static final class b extends j {
        public final int d;

        public b(int i) {
            super(null);
            this.d = i;
        }

        @Override // b.i.b.b.j
        public j a(int i, int i2) {
            return this;
        }

        @Override // b.i.b.b.j
        public <T> j b(@NullableDecl T t, @NullableDecl T t2, @NullableDecl Comparator<T> comparator) {
            return this;
        }

        @Override // b.i.b.b.j
        public j c(boolean z2, boolean z3) {
            return this;
        }

        @Override // b.i.b.b.j
        public j d(boolean z2, boolean z3) {
            return this;
        }

        @Override // b.i.b.b.j
        public int e() {
            return this.d;
        }
    }

    public j(a aVar) {
    }

    public abstract j a(int i, int i2);

    public abstract <T> j b(@NullableDecl T t, @NullableDecl T t2, Comparator<T> comparator);

    public abstract j c(boolean z2, boolean z3);

    public abstract j d(boolean z2, boolean z3);

    public abstract int e();
}

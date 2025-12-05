package p007b.p225i.p355b.p357b;

import java.util.Comparator;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: ComparisonChain.java */
/* renamed from: b.i.b.b.j, reason: use source file name */
/* loaded from: classes3.dex */
public abstract class ComparisonChain {

    /* renamed from: a */
    public static final ComparisonChain f12028a = new a();

    /* renamed from: b */
    public static final ComparisonChain f12029b = new b(-1);

    /* renamed from: c */
    public static final ComparisonChain f12030c = new b(1);

    /* compiled from: ComparisonChain.java */
    /* renamed from: b.i.b.b.j$a */
    public static class a extends ComparisonChain {
        public a() {
            super(null);
        }

        @Override // p007b.p225i.p355b.p357b.ComparisonChain
        /* renamed from: a */
        public ComparisonChain mo6254a(int i, int i2) {
            return m6259f(i < i2 ? -1 : i > i2 ? 1 : 0);
        }

        @Override // p007b.p225i.p355b.p357b.ComparisonChain
        /* renamed from: b */
        public <T> ComparisonChain mo6255b(@NullableDecl T t, @NullableDecl T t2, Comparator<T> comparator) {
            return m6259f(comparator.compare(t, t2));
        }

        @Override // p007b.p225i.p355b.p357b.ComparisonChain
        /* renamed from: c */
        public ComparisonChain mo6256c(boolean z2, boolean z3) {
            return m6259f(z2 == z3 ? 0 : z2 ? 1 : -1);
        }

        @Override // p007b.p225i.p355b.p357b.ComparisonChain
        /* renamed from: d */
        public ComparisonChain mo6257d(boolean z2, boolean z3) {
            return m6259f(z3 == z2 ? 0 : z3 ? 1 : -1);
        }

        @Override // p007b.p225i.p355b.p357b.ComparisonChain
        /* renamed from: e */
        public int mo6258e() {
            return 0;
        }

        /* renamed from: f */
        public ComparisonChain m6259f(int i) {
            return i < 0 ? ComparisonChain.f12029b : i > 0 ? ComparisonChain.f12030c : ComparisonChain.f12028a;
        }
    }

    /* compiled from: ComparisonChain.java */
    /* renamed from: b.i.b.b.j$b */
    public static final class b extends ComparisonChain {

        /* renamed from: d */
        public final int f12031d;

        public b(int i) {
            super(null);
            this.f12031d = i;
        }

        @Override // p007b.p225i.p355b.p357b.ComparisonChain
        /* renamed from: a */
        public ComparisonChain mo6254a(int i, int i2) {
            return this;
        }

        @Override // p007b.p225i.p355b.p357b.ComparisonChain
        /* renamed from: b */
        public <T> ComparisonChain mo6255b(@NullableDecl T t, @NullableDecl T t2, @NullableDecl Comparator<T> comparator) {
            return this;
        }

        @Override // p007b.p225i.p355b.p357b.ComparisonChain
        /* renamed from: c */
        public ComparisonChain mo6256c(boolean z2, boolean z3) {
            return this;
        }

        @Override // p007b.p225i.p355b.p357b.ComparisonChain
        /* renamed from: d */
        public ComparisonChain mo6257d(boolean z2, boolean z3) {
            return this;
        }

        @Override // p007b.p225i.p355b.p357b.ComparisonChain
        /* renamed from: e */
        public int mo6258e() {
            return this.f12031d;
        }
    }

    public ComparisonChain(a aVar) {
    }

    /* renamed from: a */
    public abstract ComparisonChain mo6254a(int i, int i2);

    /* renamed from: b */
    public abstract <T> ComparisonChain mo6255b(@NullableDecl T t, @NullableDecl T t2, Comparator<T> comparator);

    /* renamed from: c */
    public abstract ComparisonChain mo6256c(boolean z2, boolean z3);

    /* renamed from: d */
    public abstract ComparisonChain mo6257d(boolean z2, boolean z3);

    /* renamed from: e */
    public abstract int mo6258e();
}

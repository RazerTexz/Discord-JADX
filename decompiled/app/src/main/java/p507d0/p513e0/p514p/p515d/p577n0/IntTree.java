package p507d0.p513e0.p514p.p515d.p577n0;

/* compiled from: IntTree.java */
/* renamed from: d0.e0.p.d.n0.c, reason: use source file name */
/* loaded from: classes3.dex */
public final class IntTree<V> {

    /* renamed from: a */
    public static final IntTree<Object> f25026a = new IntTree<>();

    /* renamed from: b */
    public final long f25027b;

    /* renamed from: c */
    public final V f25028c;

    /* renamed from: d */
    public final IntTree<V> f25029d;

    /* renamed from: e */
    public final IntTree<V> f25030e;

    /* renamed from: f */
    public final int f25031f;

    public IntTree() {
        this.f25031f = 0;
        this.f25027b = 0L;
        this.f25028c = null;
        this.f25029d = null;
        this.f25030e = null;
    }

    /* renamed from: a */
    public V m10051a(long j) {
        if (this.f25031f == 0) {
            return null;
        }
        long j2 = this.f25027b;
        return j < j2 ? this.f25029d.m10051a(j - j2) : j > j2 ? this.f25030e.m10051a(j - j2) : this.f25028c;
    }

    /* renamed from: b */
    public IntTree<V> m10052b(long j, V v) {
        if (this.f25031f == 0) {
            return new IntTree<>(j, v, this, this);
        }
        long j2 = this.f25027b;
        return j < j2 ? m10053c(this.f25029d.m10052b(j - j2, v), this.f25030e) : j > j2 ? m10053c(this.f25029d, this.f25030e.m10052b(j - j2, v)) : v == this.f25028c ? this : new IntTree<>(j, v, this.f25029d, this.f25030e);
    }

    /* renamed from: c */
    public final IntTree<V> m10053c(IntTree<V> intTree, IntTree<V> intTree2) {
        if (intTree == this.f25029d && intTree2 == this.f25030e) {
            return this;
        }
        long j = this.f25027b;
        V v = this.f25028c;
        int i = intTree.f25031f;
        int i2 = intTree2.f25031f;
        if (i + i2 > 1) {
            if (i >= i2 * 5) {
                IntTree<V> intTree3 = intTree.f25029d;
                IntTree<V> intTree4 = intTree.f25030e;
                if (intTree4.f25031f < intTree3.f25031f * 2) {
                    long j2 = intTree.f25027b;
                    return new IntTree<>(j2 + j, intTree.f25028c, intTree3, new IntTree(-j2, v, intTree4.m10054d(intTree4.f25027b + j2), intTree2));
                }
                IntTree<V> intTree5 = intTree4.f25029d;
                IntTree<V> intTree6 = intTree4.f25030e;
                long j3 = intTree4.f25027b;
                long j4 = intTree.f25027b + j3 + j;
                V v2 = intTree4.f25028c;
                IntTree intTree7 = new IntTree(-j3, intTree.f25028c, intTree3, intTree5.m10054d(intTree5.f25027b + j3));
                long j5 = intTree.f25027b;
                long j6 = intTree4.f25027b;
                return new IntTree<>(j4, v2, intTree7, new IntTree((-j5) - j6, v, intTree6.m10054d(intTree6.f25027b + j6 + j5), intTree2));
            }
            if (i2 >= i * 5) {
                IntTree<V> intTree8 = intTree2.f25029d;
                IntTree<V> intTree9 = intTree2.f25030e;
                if (intTree8.f25031f < intTree9.f25031f * 2) {
                    long j7 = intTree2.f25027b;
                    return new IntTree<>(j7 + j, intTree2.f25028c, new IntTree(-j7, v, intTree, intTree8.m10054d(intTree8.f25027b + j7)), intTree9);
                }
                IntTree<V> intTree10 = intTree8.f25029d;
                IntTree<V> intTree11 = intTree8.f25030e;
                long j8 = intTree8.f25027b;
                long j9 = intTree2.f25027b;
                long j10 = j8 + j9 + j;
                V v3 = intTree8.f25028c;
                IntTree intTree12 = new IntTree((-j9) - j8, v, intTree, intTree10.m10054d(intTree10.f25027b + j8 + j9));
                long j11 = intTree8.f25027b;
                return new IntTree<>(j10, v3, intTree12, new IntTree(-j11, intTree2.f25028c, intTree11.m10054d(intTree11.f25027b + j11), intTree9));
            }
        }
        return new IntTree<>(j, v, intTree, intTree2);
    }

    /* renamed from: d */
    public final IntTree<V> m10054d(long j) {
        return (this.f25031f == 0 || j == this.f25027b) ? this : new IntTree<>(j, this.f25028c, this.f25029d, this.f25030e);
    }

    public IntTree(long j, V v, IntTree<V> intTree, IntTree<V> intTree2) {
        this.f25027b = j;
        this.f25028c = v;
        this.f25029d = intTree;
        this.f25030e = intTree2;
        this.f25031f = intTree.f25031f + 1 + intTree2.f25031f;
    }
}

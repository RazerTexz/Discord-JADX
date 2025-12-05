package p507d0.p513e0.p514p.p515d.p577n0;

/* compiled from: IntTreePMap.java */
/* renamed from: d0.e0.p.d.n0.d, reason: use source file name */
/* loaded from: classes3.dex */
public final class IntTreePMap<V> {

    /* renamed from: a */
    public static final IntTreePMap<Object> f25032a = new IntTreePMap<>(IntTree.f25026a);

    /* renamed from: b */
    public final IntTree<V> f25033b;

    public IntTreePMap(IntTree<V> intTree) {
        this.f25033b = intTree;
    }

    public static <V> IntTreePMap<V> empty() {
        return (IntTreePMap<V>) f25032a;
    }

    public V get(int i) {
        return this.f25033b.m10051a(i);
    }

    public IntTreePMap<V> plus(int i, V v) {
        IntTree<V> intTreeM10052b = this.f25033b.m10052b(i, v);
        return intTreeM10052b == this.f25033b ? this : new IntTreePMap<>(intTreeM10052b);
    }
}

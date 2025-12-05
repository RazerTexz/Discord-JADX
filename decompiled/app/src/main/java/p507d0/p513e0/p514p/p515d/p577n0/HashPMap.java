package p507d0.p513e0.p514p.p515d.p577n0;

/* compiled from: HashPMap.java */
/* renamed from: d0.e0.p.d.n0.b, reason: use source file name */
/* loaded from: classes3.dex */
public final class HashPMap<K, V> {

    /* renamed from: a */
    public static final HashPMap<Object, Object> f25023a = new HashPMap<>(IntTreePMap.empty(), 0);

    /* renamed from: b */
    public final IntTreePMap<ConsPStack<MapEntry<K, V>>> f25024b;

    /* renamed from: c */
    public final int f25025c;

    public HashPMap(IntTreePMap<ConsPStack<MapEntry<K, V>>> intTreePMap, int i) {
        this.f25024b = intTreePMap;
        this.f25025c = i;
    }

    public static <K, V> HashPMap<K, V> empty() {
        HashPMap<K, V> hashPMap = (HashPMap<K, V>) f25023a;
        if (hashPMap == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/pcollections/HashPMap", "empty"));
        }
        return hashPMap;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public V get(Object obj) {
        ConsPStack consPStackEmpty = this.f25024b.get(obj.hashCode());
        if (consPStackEmpty == null) {
            consPStackEmpty = ConsPStack.empty();
        }
        while (consPStackEmpty != null && consPStackEmpty.size() > 0) {
            MapEntry mapEntry = (MapEntry) consPStackEmpty.f25019k;
            if (mapEntry.key.equals(obj)) {
                return mapEntry.value;
            }
            consPStackEmpty = consPStackEmpty.f25020l;
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public HashPMap<K, V> plus(K k, V v) {
        ConsPStack<MapEntry<K, V>> consPStackMinus = this.f25024b.get(k.hashCode());
        if (consPStackMinus == null) {
            consPStackMinus = ConsPStack.empty();
        }
        int size = consPStackMinus.size();
        int i = 0;
        ConsPStack consPStack = consPStackMinus;
        while (consPStack != null && consPStack.size() > 0) {
            if (((MapEntry) consPStack.f25019k).key.equals(k)) {
                break;
            }
            consPStack = consPStack.f25020l;
            i++;
        }
        i = -1;
        if (i != -1) {
            consPStackMinus = consPStackMinus.minus(i);
        }
        ConsPStack<MapEntry<K, V>> consPStackPlus = consPStackMinus.plus(new MapEntry<>(k, v));
        return new HashPMap<>(this.f25024b.plus(k.hashCode(), consPStackPlus), consPStackPlus.size() + (this.f25025c - size));
    }
}

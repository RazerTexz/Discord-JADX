package d0.t.q0;

import d0.t.j;
import d0.z.d.m;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Set;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: MapBuilder.kt */
/* loaded from: classes3.dex */
public final class c<K, V> implements Map<K, V>, d0.z.d.g0.d {
    public static final a j = new a(null);
    public int k;
    public int l;
    public d0.t.q0.e<K> m;
    public d0.t.q0.f<V> n;
    public d0.t.q0.d<K, V> o;
    public boolean p;
    public K[] q;
    public V[] r;

    /* renamed from: s, reason: collision with root package name */
    public int[] f3583s;
    public int[] t;
    public int u;
    public int v;

    /* compiled from: MapBuilder.kt */
    public static final class a {
        public a(DefaultConstructorMarker defaultConstructorMarker) {
        }

        public static final int access$computeHashSize(a aVar, int i) {
            Objects.requireNonNull(aVar);
            return Integer.highestOneBit(d0.d0.f.coerceAtLeast(i, 1) * 3);
        }

        public static final int access$computeShift(a aVar, int i) {
            Objects.requireNonNull(aVar);
            return Integer.numberOfLeadingZeros(i) + 1;
        }
    }

    /* compiled from: MapBuilder.kt */
    public static final class b<K, V> extends d<K, V> implements Iterator<Map.Entry<K, V>>, d0.z.d.g0.a {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(c<K, V> cVar) {
            super(cVar);
            m.checkNotNullParameter(cVar, "map");
        }

        @Override // java.util.Iterator
        public /* bridge */ /* synthetic */ Object next() {
            return next();
        }

        public final void nextAppendString(StringBuilder sb) {
            m.checkNotNullParameter(sb, "sb");
            if (getIndex$kotlin_stdlib() >= c.access$getLength$p(getMap$kotlin_stdlib())) {
                throw new NoSuchElementException();
            }
            int index$kotlin_stdlib = getIndex$kotlin_stdlib();
            setIndex$kotlin_stdlib(index$kotlin_stdlib + 1);
            setLastIndex$kotlin_stdlib(index$kotlin_stdlib);
            Object obj = c.access$getKeysArray$p(getMap$kotlin_stdlib())[getLastIndex$kotlin_stdlib()];
            if (m.areEqual(obj, getMap$kotlin_stdlib())) {
                sb.append("(this Map)");
            } else {
                sb.append(obj);
            }
            sb.append('=');
            Object[] objArrAccess$getValuesArray$p = c.access$getValuesArray$p(getMap$kotlin_stdlib());
            m.checkNotNull(objArrAccess$getValuesArray$p);
            Object obj2 = objArrAccess$getValuesArray$p[getLastIndex$kotlin_stdlib()];
            if (m.areEqual(obj2, getMap$kotlin_stdlib())) {
                sb.append("(this Map)");
            } else {
                sb.append(obj2);
            }
            initNext$kotlin_stdlib();
        }

        public final int nextHashCode$kotlin_stdlib() {
            if (getIndex$kotlin_stdlib() >= c.access$getLength$p(getMap$kotlin_stdlib())) {
                throw new NoSuchElementException();
            }
            int index$kotlin_stdlib = getIndex$kotlin_stdlib();
            setIndex$kotlin_stdlib(index$kotlin_stdlib + 1);
            setLastIndex$kotlin_stdlib(index$kotlin_stdlib);
            Object obj = c.access$getKeysArray$p(getMap$kotlin_stdlib())[getLastIndex$kotlin_stdlib()];
            int iHashCode = obj != null ? obj.hashCode() : 0;
            Object[] objArrAccess$getValuesArray$p = c.access$getValuesArray$p(getMap$kotlin_stdlib());
            m.checkNotNull(objArrAccess$getValuesArray$p);
            Object obj2 = objArrAccess$getValuesArray$p[getLastIndex$kotlin_stdlib()];
            int iHashCode2 = iHashCode ^ (obj2 != null ? obj2.hashCode() : 0);
            initNext$kotlin_stdlib();
            return iHashCode2;
        }

        @Override // java.util.Iterator
        public C0596c<K, V> next() {
            if (getIndex$kotlin_stdlib() >= c.access$getLength$p(getMap$kotlin_stdlib())) {
                throw new NoSuchElementException();
            }
            int index$kotlin_stdlib = getIndex$kotlin_stdlib();
            setIndex$kotlin_stdlib(index$kotlin_stdlib + 1);
            setLastIndex$kotlin_stdlib(index$kotlin_stdlib);
            C0596c<K, V> c0596c = new C0596c<>(getMap$kotlin_stdlib(), getLastIndex$kotlin_stdlib());
            initNext$kotlin_stdlib();
            return c0596c;
        }
    }

    /* compiled from: MapBuilder.kt */
    /* renamed from: d0.t.q0.c$c, reason: collision with other inner class name */
    public static final class C0596c<K, V> implements Map.Entry<K, V>, d0.z.d.g0.a {
        public final c<K, V> j;
        public final int k;

        public C0596c(c<K, V> cVar, int i) {
            m.checkNotNullParameter(cVar, "map");
            this.j = cVar;
            this.k = i;
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object obj) {
            if (obj instanceof Map.Entry) {
                Map.Entry entry = (Map.Entry) obj;
                if (m.areEqual(entry.getKey(), getKey()) && m.areEqual(entry.getValue(), getValue())) {
                    return true;
                }
            }
            return false;
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            return (K) c.access$getKeysArray$p(this.j)[this.k];
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            Object[] objArrAccess$getValuesArray$p = c.access$getValuesArray$p(this.j);
            m.checkNotNull(objArrAccess$getValuesArray$p);
            return (V) objArrAccess$getValuesArray$p[this.k];
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            K key = getKey();
            int iHashCode = key != null ? key.hashCode() : 0;
            V value = getValue();
            return iHashCode ^ (value != null ? value.hashCode() : 0);
        }

        @Override // java.util.Map.Entry
        public V setValue(V v) {
            this.j.checkIsMutable$kotlin_stdlib();
            Object[] objArrAccess$allocateValuesArray = c.access$allocateValuesArray(this.j);
            int i = this.k;
            V v2 = (V) objArrAccess$allocateValuesArray[i];
            objArrAccess$allocateValuesArray[i] = v;
            return v2;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(getKey());
            sb.append('=');
            sb.append(getValue());
            return sb.toString();
        }
    }

    /* compiled from: MapBuilder.kt */
    public static class d<K, V> {
        public int j;
        public int k;
        public final c<K, V> l;

        public d(c<K, V> cVar) {
            m.checkNotNullParameter(cVar, "map");
            this.l = cVar;
            this.k = -1;
            initNext$kotlin_stdlib();
        }

        public final int getIndex$kotlin_stdlib() {
            return this.j;
        }

        public final int getLastIndex$kotlin_stdlib() {
            return this.k;
        }

        public final c<K, V> getMap$kotlin_stdlib() {
            return this.l;
        }

        public final boolean hasNext() {
            return this.j < c.access$getLength$p(this.l);
        }

        public final void initNext$kotlin_stdlib() {
            while (this.j < c.access$getLength$p(this.l)) {
                int[] iArrAccess$getPresenceArray$p = c.access$getPresenceArray$p(this.l);
                int i = this.j;
                if (iArrAccess$getPresenceArray$p[i] >= 0) {
                    return;
                } else {
                    this.j = i + 1;
                }
            }
        }

        public final void remove() {
            if (!(this.k != -1)) {
                throw new IllegalStateException("Call next() before removing element from the iterator.".toString());
            }
            this.l.checkIsMutable$kotlin_stdlib();
            c.access$removeKeyAt(this.l, this.k);
            this.k = -1;
        }

        public final void setIndex$kotlin_stdlib(int i) {
            this.j = i;
        }

        public final void setLastIndex$kotlin_stdlib(int i) {
            this.k = i;
        }
    }

    /* compiled from: MapBuilder.kt */
    public static final class e<K, V> extends d<K, V> implements Iterator<K>, d0.z.d.g0.a {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(c<K, V> cVar) {
            super(cVar);
            m.checkNotNullParameter(cVar, "map");
        }

        @Override // java.util.Iterator
        public K next() {
            if (getIndex$kotlin_stdlib() >= c.access$getLength$p(getMap$kotlin_stdlib())) {
                throw new NoSuchElementException();
            }
            int index$kotlin_stdlib = getIndex$kotlin_stdlib();
            setIndex$kotlin_stdlib(index$kotlin_stdlib + 1);
            setLastIndex$kotlin_stdlib(index$kotlin_stdlib);
            K k = (K) c.access$getKeysArray$p(getMap$kotlin_stdlib())[getLastIndex$kotlin_stdlib()];
            initNext$kotlin_stdlib();
            return k;
        }
    }

    /* compiled from: MapBuilder.kt */
    public static final class f<K, V> extends d<K, V> implements Iterator<V>, d0.z.d.g0.a {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(c<K, V> cVar) {
            super(cVar);
            m.checkNotNullParameter(cVar, "map");
        }

        @Override // java.util.Iterator
        public V next() {
            if (getIndex$kotlin_stdlib() >= c.access$getLength$p(getMap$kotlin_stdlib())) {
                throw new NoSuchElementException();
            }
            int index$kotlin_stdlib = getIndex$kotlin_stdlib();
            setIndex$kotlin_stdlib(index$kotlin_stdlib + 1);
            setLastIndex$kotlin_stdlib(index$kotlin_stdlib);
            Object[] objArrAccess$getValuesArray$p = c.access$getValuesArray$p(getMap$kotlin_stdlib());
            m.checkNotNull(objArrAccess$getValuesArray$p);
            V v = (V) objArrAccess$getValuesArray$p[getLastIndex$kotlin_stdlib()];
            initNext$kotlin_stdlib();
            return v;
        }
    }

    public c() {
        this(8);
    }

    public static final /* synthetic */ Object[] access$allocateValuesArray(c cVar) {
        return cVar.a();
    }

    public static final /* synthetic */ Object[] access$getKeysArray$p(c cVar) {
        return cVar.q;
    }

    public static final /* synthetic */ int access$getLength$p(c cVar) {
        return cVar.v;
    }

    public static final /* synthetic */ int[] access$getPresenceArray$p(c cVar) {
        return cVar.f3583s;
    }

    public static final /* synthetic */ Object[] access$getValuesArray$p(c cVar) {
        return cVar.r;
    }

    public static final /* synthetic */ void access$removeKeyAt(c cVar, int i) {
        cVar.g(i);
    }

    public final V[] a() {
        V[] vArr = this.r;
        if (vArr != null) {
            return vArr;
        }
        V[] vArr2 = (V[]) d0.t.q0.b.arrayOfUninitializedElements(this.q.length);
        this.r = vArr2;
        return vArr2;
    }

    public final int addKey$kotlin_stdlib(K k) {
        checkIsMutable$kotlin_stdlib();
        while (true) {
            int iE = e(k);
            int iCoerceAtMost = d0.d0.f.coerceAtMost(this.u * 2, this.t.length / 2);
            int i = 0;
            while (true) {
                int[] iArr = this.t;
                int i2 = iArr[iE];
                if (i2 <= 0) {
                    int i3 = this.v;
                    K[] kArr = this.q;
                    if (i3 < kArr.length) {
                        int i4 = i3 + 1;
                        this.v = i4;
                        kArr[i3] = k;
                        this.f3583s[i3] = iE;
                        iArr[iE] = i4;
                        this.l = size() + 1;
                        if (i > this.u) {
                            this.u = i;
                        }
                        return i3;
                    }
                    b(1);
                } else {
                    if (m.areEqual(this.q[i2 - 1], k)) {
                        return -i2;
                    }
                    i++;
                    if (i > iCoerceAtMost) {
                        f(this.t.length * 2);
                        break;
                    }
                    iE = iE == 0 ? this.t.length - 1 : iE - 1;
                }
            }
        }
    }

    public final void b(int i) {
        int i2 = this.v;
        int i3 = i + i2;
        K[] kArr = this.q;
        if (i3 <= kArr.length) {
            if ((i2 + i3) - size() > this.q.length) {
                f(this.t.length);
                return;
            }
            return;
        }
        int length = (kArr.length * 3) / 2;
        if (i3 <= length) {
            i3 = length;
        }
        this.q = (K[]) d0.t.q0.b.copyOfUninitializedElements(kArr, i3);
        V[] vArr = this.r;
        this.r = vArr != null ? (V[]) d0.t.q0.b.copyOfUninitializedElements(vArr, i3) : null;
        int[] iArrCopyOf = Arrays.copyOf(this.f3583s, i3);
        m.checkNotNullExpressionValue(iArrCopyOf, "java.util.Arrays.copyOf(this, newSize)");
        this.f3583s = iArrCopyOf;
        int iAccess$computeHashSize = a.access$computeHashSize(j, i3);
        if (iAccess$computeHashSize > this.t.length) {
            f(iAccess$computeHashSize);
        }
    }

    public final Map<K, V> build() {
        checkIsMutable$kotlin_stdlib();
        this.p = true;
        return this;
    }

    public final int c(K k) {
        int iE = e(k);
        int i = this.u;
        while (true) {
            int i2 = this.t[iE];
            if (i2 == 0) {
                return -1;
            }
            if (i2 > 0) {
                int i3 = i2 - 1;
                if (m.areEqual(this.q[i3], k)) {
                    return i3;
                }
            }
            i--;
            if (i < 0) {
                return -1;
            }
            iE = iE == 0 ? this.t.length - 1 : iE - 1;
        }
    }

    public final void checkIsMutable$kotlin_stdlib() {
        if (this.p) {
            throw new UnsupportedOperationException();
        }
    }

    @Override // java.util.Map
    public void clear() {
        checkIsMutable$kotlin_stdlib();
        int i = this.v - 1;
        if (i >= 0) {
            int i2 = 0;
            while (true) {
                int[] iArr = this.f3583s;
                int i3 = iArr[i2];
                if (i3 >= 0) {
                    this.t[i3] = 0;
                    iArr[i2] = -1;
                }
                if (i2 == i) {
                    break;
                } else {
                    i2++;
                }
            }
        }
        d0.t.q0.b.resetRange(this.q, 0, this.v);
        V[] vArr = this.r;
        if (vArr != null) {
            d0.t.q0.b.resetRange(vArr, 0, this.v);
        }
        this.l = 0;
        this.v = 0;
    }

    public final boolean containsAllEntries$kotlin_stdlib(Collection<?> collection) {
        m.checkNotNullParameter(collection, "m");
        for (Object obj : collection) {
            if (obj != null) {
                try {
                    if (!containsEntry$kotlin_stdlib((Map.Entry) obj)) {
                    }
                } catch (ClassCastException unused) {
                }
            }
            return false;
        }
        return true;
    }

    public final boolean containsEntry$kotlin_stdlib(Map.Entry<? extends K, ? extends V> entry) {
        m.checkNotNullParameter(entry, "entry");
        int iC = c(entry.getKey());
        if (iC < 0) {
            return false;
        }
        V[] vArr = this.r;
        m.checkNotNull(vArr);
        return m.areEqual(vArr[iC], entry.getValue());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Map
    public boolean containsKey(Object obj) {
        return c(obj) >= 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Map
    public boolean containsValue(Object obj) {
        return d(obj) >= 0;
    }

    public final int d(V v) {
        int i = this.v;
        while (true) {
            i--;
            if (i < 0) {
                return -1;
            }
            if (this.f3583s[i] >= 0) {
                V[] vArr = this.r;
                m.checkNotNull(vArr);
                if (m.areEqual(vArr[i], v)) {
                    return i;
                }
            }
        }
    }

    public final int e(K k) {
        return ((k != null ? k.hashCode() : 0) * (-1640531527)) >>> this.k;
    }

    public final b<K, V> entriesIterator$kotlin_stdlib() {
        return new b<>(this);
    }

    @Override // java.util.Map
    public final /* bridge */ Set<Map.Entry<K, V>> entrySet() {
        return getEntries();
    }

    @Override // java.util.Map
    public boolean equals(Object obj) {
        if (obj != this) {
            if (!(obj instanceof Map)) {
                return false;
            }
            Map map = (Map) obj;
            if (!(size() == map.size() && containsAllEntries$kotlin_stdlib(map.entrySet()))) {
                return false;
            }
        }
        return true;
    }

    public final void f(int i) {
        boolean z2;
        int i2;
        if (this.v > size()) {
            V[] vArr = this.r;
            int i3 = 0;
            int i4 = 0;
            while (true) {
                i2 = this.v;
                if (i3 >= i2) {
                    break;
                }
                if (this.f3583s[i3] >= 0) {
                    K[] kArr = this.q;
                    kArr[i4] = kArr[i3];
                    if (vArr != null) {
                        vArr[i4] = vArr[i3];
                    }
                    i4++;
                }
                i3++;
            }
            d0.t.q0.b.resetRange(this.q, i4, i2);
            if (vArr != null) {
                d0.t.q0.b.resetRange(vArr, i4, this.v);
            }
            this.v = i4;
        }
        int[] iArr = this.t;
        if (i != iArr.length) {
            this.t = new int[i];
            this.k = a.access$computeShift(j, i);
        } else {
            j.fill(iArr, 0, 0, iArr.length);
        }
        int i5 = 0;
        while (i5 < this.v) {
            int i6 = i5 + 1;
            int iE = e(this.q[i5]);
            int i7 = this.u;
            while (true) {
                int[] iArr2 = this.t;
                z2 = true;
                if (iArr2[iE] == 0) {
                    iArr2[iE] = i6;
                    this.f3583s[i5] = iE;
                    break;
                } else {
                    i7--;
                    if (i7 < 0) {
                        z2 = false;
                        break;
                    }
                    iE = iE == 0 ? iArr2.length - 1 : iE - 1;
                }
            }
            if (!z2) {
                throw new IllegalStateException("This cannot happen with fixed magic multiplier and grow-only hash array. Have object hashCodes changed?");
            }
            i5 = i6;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x005b A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:27:? A[LOOP:0: B:3:0x001a->B:27:?, LOOP_END, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void g(int i) {
        d0.t.q0.b.resetAt(this.q, i);
        int length = this.f3583s[i];
        int iCoerceAtMost = d0.d0.f.coerceAtMost(this.u * 2, this.t.length / 2);
        int i2 = 0;
        int i3 = length;
        while (true) {
            length = length == 0 ? this.t.length - 1 : length - 1;
            i2++;
            if (i2 > this.u) {
                this.t[i3] = 0;
                break;
            }
            int[] iArr = this.t;
            int i4 = iArr[length];
            if (i4 == 0) {
                iArr[i3] = 0;
                break;
            }
            if (i4 < 0) {
                iArr[i3] = -1;
            } else {
                int i5 = i4 - 1;
                int iE = e(this.q[i5]) - length;
                int[] iArr2 = this.t;
                if ((iE & (iArr2.length - 1)) >= i2) {
                    iArr2[i3] = i4;
                    this.f3583s[i5] = i3;
                }
                iCoerceAtMost--;
                if (iCoerceAtMost >= 0) {
                    this.t[i3] = -1;
                    break;
                }
            }
            i3 = length;
            i2 = 0;
            iCoerceAtMost--;
            if (iCoerceAtMost >= 0) {
            }
        }
        this.f3583s[i] = -1;
        this.l = size() - 1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Map
    public V get(Object obj) {
        int iC = c(obj);
        if (iC < 0) {
            return null;
        }
        V[] vArr = this.r;
        m.checkNotNull(vArr);
        return vArr[iC];
    }

    public Set<Map.Entry<K, V>> getEntries() {
        d0.t.q0.d<K, V> dVar = this.o;
        if (dVar != null) {
            return dVar;
        }
        d0.t.q0.d<K, V> dVar2 = new d0.t.q0.d<>(this);
        this.o = dVar2;
        return dVar2;
    }

    public Set<K> getKeys() {
        d0.t.q0.e<K> eVar = this.m;
        if (eVar != null) {
            return eVar;
        }
        d0.t.q0.e<K> eVar2 = new d0.t.q0.e<>(this);
        this.m = eVar2;
        return eVar2;
    }

    public int getSize() {
        return this.l;
    }

    public Collection<V> getValues() {
        d0.t.q0.f<V> fVar = this.n;
        if (fVar != null) {
            return fVar;
        }
        d0.t.q0.f<V> fVar2 = new d0.t.q0.f<>(this);
        this.n = fVar2;
        return fVar2;
    }

    @Override // java.util.Map
    public int hashCode() {
        b<K, V> bVarEntriesIterator$kotlin_stdlib = entriesIterator$kotlin_stdlib();
        int iNextHashCode$kotlin_stdlib = 0;
        while (bVarEntriesIterator$kotlin_stdlib.hasNext()) {
            iNextHashCode$kotlin_stdlib += bVarEntriesIterator$kotlin_stdlib.nextHashCode$kotlin_stdlib();
        }
        return iNextHashCode$kotlin_stdlib;
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override // java.util.Map
    public final /* bridge */ Set<K> keySet() {
        return getKeys();
    }

    public final e<K, V> keysIterator$kotlin_stdlib() {
        return new e<>(this);
    }

    @Override // java.util.Map
    public V put(K k, V v) {
        checkIsMutable$kotlin_stdlib();
        int iAddKey$kotlin_stdlib = addKey$kotlin_stdlib(k);
        V[] vArrA = a();
        if (iAddKey$kotlin_stdlib >= 0) {
            vArrA[iAddKey$kotlin_stdlib] = v;
            return null;
        }
        int i = (-iAddKey$kotlin_stdlib) - 1;
        V v2 = vArrA[i];
        vArrA[i] = v;
        return v2;
    }

    @Override // java.util.Map
    public void putAll(Map<? extends K, ? extends V> map) {
        m.checkNotNullParameter(map, "from");
        checkIsMutable$kotlin_stdlib();
        Set<Map.Entry<? extends K, ? extends V>> setEntrySet = map.entrySet();
        if (setEntrySet.isEmpty()) {
            return;
        }
        b(setEntrySet.size());
        for (Map.Entry<? extends K, ? extends V> entry : setEntrySet) {
            int iAddKey$kotlin_stdlib = addKey$kotlin_stdlib(entry.getKey());
            V[] vArrA = a();
            if (iAddKey$kotlin_stdlib >= 0) {
                vArrA[iAddKey$kotlin_stdlib] = entry.getValue();
            } else {
                int i = (-iAddKey$kotlin_stdlib) - 1;
                if (!m.areEqual(entry.getValue(), vArrA[i])) {
                    vArrA[i] = entry.getValue();
                }
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Map
    public V remove(Object obj) {
        int iRemoveKey$kotlin_stdlib = removeKey$kotlin_stdlib(obj);
        if (iRemoveKey$kotlin_stdlib < 0) {
            return null;
        }
        V[] vArr = this.r;
        m.checkNotNull(vArr);
        V v = vArr[iRemoveKey$kotlin_stdlib];
        d0.t.q0.b.resetAt(vArr, iRemoveKey$kotlin_stdlib);
        return v;
    }

    public final boolean removeEntry$kotlin_stdlib(Map.Entry<? extends K, ? extends V> entry) {
        m.checkNotNullParameter(entry, "entry");
        checkIsMutable$kotlin_stdlib();
        int iC = c(entry.getKey());
        if (iC < 0) {
            return false;
        }
        m.checkNotNull(this.r);
        if (!m.areEqual(r2[iC], entry.getValue())) {
            return false;
        }
        g(iC);
        return true;
    }

    public final int removeKey$kotlin_stdlib(K k) {
        checkIsMutable$kotlin_stdlib();
        int iC = c(k);
        if (iC < 0) {
            return -1;
        }
        g(iC);
        return iC;
    }

    public final boolean removeValue$kotlin_stdlib(V v) {
        checkIsMutable$kotlin_stdlib();
        int iD = d(v);
        if (iD < 0) {
            return false;
        }
        g(iD);
        return true;
    }

    @Override // java.util.Map
    public final /* bridge */ int size() {
        return getSize();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder((size() * 3) + 2);
        sb.append("{");
        b<K, V> bVarEntriesIterator$kotlin_stdlib = entriesIterator$kotlin_stdlib();
        int i = 0;
        while (bVarEntriesIterator$kotlin_stdlib.hasNext()) {
            if (i > 0) {
                sb.append(", ");
            }
            bVarEntriesIterator$kotlin_stdlib.nextAppendString(sb);
            i++;
        }
        sb.append("}");
        String string = sb.toString();
        m.checkNotNullExpressionValue(string, "sb.toString()");
        return string;
    }

    @Override // java.util.Map
    public final /* bridge */ Collection<V> values() {
        return getValues();
    }

    public final f<K, V> valuesIterator$kotlin_stdlib() {
        return new f<>(this);
    }

    public c(int i) {
        K[] kArr = (K[]) d0.t.q0.b.arrayOfUninitializedElements(i);
        int[] iArr = new int[i];
        a aVar = j;
        int iAccess$computeHashSize = a.access$computeHashSize(aVar, i);
        this.q = kArr;
        this.r = null;
        this.f3583s = iArr;
        this.t = new int[iAccess$computeHashSize];
        this.u = 2;
        this.v = 0;
        this.k = a.access$computeShift(aVar, iAccess$computeHashSize);
    }
}

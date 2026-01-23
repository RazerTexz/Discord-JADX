package p007b.p225i.p355b.p357b;

import com.discord.api.permission.Permission;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.concurrent.LazyInit;
import com.google.j2objc.annotations.RetainedWith;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p007b.p225i.p355b.p357b.ImmutableCollection;

/* JADX INFO: renamed from: b.i.b.b.q, reason: use source file name */
/* JADX INFO: compiled from: ImmutableMap.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class ImmutableMap2<K, V> implements Map<K, V>, Serializable {

    /* JADX INFO: renamed from: j */
    @LazyInit
    public transient ImmutableSet2<Map.Entry<K, V>> f12049j;

    /* JADX INFO: renamed from: k */
    @RetainedWith
    @LazyInit
    public transient ImmutableSet2<K> f12050k;

    /* JADX INFO: renamed from: l */
    @RetainedWith
    @LazyInit
    public transient ImmutableCollection<V> f12051l;

    /* JADX INFO: renamed from: b.i.b.b.q$a */
    /* JADX INFO: compiled from: ImmutableMap.java */
    public static class a<K, V> {

        /* JADX INFO: renamed from: a */
        public Object[] f12052a;

        /* JADX INFO: renamed from: b */
        public int f12053b = 0;

        /* JADX INFO: renamed from: c */
        public boolean f12054c = false;

        public a(int i) {
            this.f12052a = new Object[i * 2];
        }

        /* JADX WARN: Code restructure failed: missing block: B:16:0x0058, code lost:
        
            r5[r10] = r8;
            r4 = r4 + 1;
         */
        /* JADX INFO: renamed from: a */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public ImmutableMap2<K, V> m6275a() {
            this.f12054c = true;
            int i = this.f12053b;
            Object[] objArr = this.f12052a;
            if (i == 0) {
                return (RegularImmutableMap) RegularImmutableMap.f12015m;
            }
            int[] iArr = null;
            int i2 = 0;
            if (i == 1) {
                C3404f.m4366z(objArr[0], objArr[1]);
                return new RegularImmutableMap(null, objArr, 1);
            }
            C3404f.m4195C(i, objArr.length >> 1);
            int iM6279k = ImmutableSet2.m6279k(i);
            if (i == 1) {
                C3404f.m4366z(objArr[0], objArr[1]);
            } else {
                int i3 = iM6279k - 1;
                int[] iArr2 = new int[iM6279k];
                Arrays.fill(iArr2, -1);
                while (i2 < i) {
                    int i4 = i2 * 2;
                    int i5 = i4 + 0;
                    Object obj = objArr[i5];
                    Object obj2 = objArr[i4 + 1];
                    C3404f.m4366z(obj, obj2);
                    int iM4277c1 = C3404f.m4277c1(obj.hashCode());
                    while (true) {
                        int i6 = iM4277c1 & i3;
                        int i7 = iArr2[i6];
                        if (i7 == -1) {
                            break;
                        }
                        if (objArr[i7].equals(obj)) {
                            throw new IllegalArgumentException("Multiple entries with same key: " + obj + "=" + obj2 + " and " + objArr[i7] + "=" + objArr[1 ^ i7]);
                        }
                        iM4277c1 = i6 + 1;
                    }
                }
                iArr = iArr2;
            }
            return new RegularImmutableMap(iArr, objArr, i);
        }

        /* JADX INFO: renamed from: b */
        public final void m6276b(int i) {
            int i2 = i * 2;
            Object[] objArr = this.f12052a;
            if (i2 > objArr.length) {
                this.f12052a = Arrays.copyOf(objArr, ImmutableCollection.b.m6260a(objArr.length, i2));
                this.f12054c = false;
            }
        }

        @CanIgnoreReturnValue
        /* JADX INFO: renamed from: c */
        public a<K, V> m6277c(K k, V v) {
            m6276b(this.f12053b + 1);
            C3404f.m4366z(k, v);
            Object[] objArr = this.f12052a;
            int i = this.f12053b;
            objArr[i * 2] = k;
            objArr[(i * 2) + 1] = v;
            this.f12053b = i + 1;
            return this;
        }
    }

    /* JADX INFO: renamed from: b.i.b.b.q$b */
    /* JADX INFO: compiled from: ImmutableMap.java */
    public static class b implements Serializable {
        private static final long serialVersionUID = 0;
        private final Object[] keys;
        private final Object[] values;

        public b(ImmutableMap2<?, ?> immutableMap2) {
            this.keys = new Object[immutableMap2.size()];
            this.values = new Object[immutableMap2.size()];
            UnmodifiableIterator<Map.Entry<?, ?>> unmodifiableIteratorMo6251j = immutableMap2.m6274e().mo6251j();
            int i = 0;
            while (unmodifiableIteratorMo6251j.hasNext()) {
                Map.Entry<?, ?> next = unmodifiableIteratorMo6251j.next();
                this.keys[i] = next.getKey();
                this.values[i] = next.getValue();
                i++;
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public Object readResolve() {
            a aVar = new a(this.keys.length);
            int i = 0;
            while (true) {
                Object[] objArr = this.keys;
                if (i >= objArr.length) {
                    return aVar.m6275a();
                }
                aVar.m6277c(objArr[i], this.values[i]);
                i++;
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: a */
    public static <K, V> ImmutableMap2<K, V> m6273a(Map<? extends K, ? extends V> map) {
        if ((map instanceof ImmutableMap2) && !(map instanceof SortedMap)) {
            ImmutableMap2<K, V> immutableMap2 = (ImmutableMap2) map;
            if (!immutableMap2.mo6250f()) {
                return immutableMap2;
            }
        }
        Set<Map.Entry<? extends K, ? extends V>> setEntrySet = map.entrySet();
        boolean z2 = setEntrySet instanceof Collection;
        a aVar = new a(z2 ? setEntrySet.size() : 4);
        if (z2) {
            aVar.m6276b(setEntrySet.size() + aVar.f12053b);
        }
        Iterator<T> it = setEntrySet.iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            aVar.m6277c(entry.getKey(), entry.getValue());
        }
        return aVar.m6275a();
    }

    /* JADX INFO: renamed from: b */
    public abstract ImmutableSet2<Map.Entry<K, V>> mo6247b();

    /* JADX INFO: renamed from: c */
    public abstract ImmutableSet2<K> mo6248c();

    @Override // java.util.Map
    @Deprecated
    public final void clear() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    public boolean containsKey(@NullableDecl Object obj) {
        return get(obj) != null;
    }

    @Override // java.util.Map
    public boolean containsValue(@NullableDecl Object obj) {
        ImmutableCollection<V> immutableCollectionMo6249d = this.f12051l;
        if (immutableCollectionMo6249d == null) {
            immutableCollectionMo6249d = mo6249d();
            this.f12051l = immutableCollectionMo6249d;
        }
        return immutableCollectionMo6249d.contains(obj);
    }

    /* JADX INFO: renamed from: d */
    public abstract ImmutableCollection<V> mo6249d();

    /* JADX INFO: renamed from: e */
    public ImmutableSet2<Map.Entry<K, V>> m6274e() {
        ImmutableSet2<Map.Entry<K, V>> immutableSet2 = this.f12049j;
        if (immutableSet2 != null) {
            return immutableSet2;
        }
        ImmutableSet2<Map.Entry<K, V>> immutableSet2Mo6247b = mo6247b();
        this.f12049j = immutableSet2Mo6247b;
        return immutableSet2Mo6247b;
    }

    @Override // java.util.Map
    public /* bridge */ /* synthetic */ Set entrySet() {
        return m6274e();
    }

    @Override // java.util.Map
    public boolean equals(@NullableDecl Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Map) {
            return entrySet().equals(((Map) obj).entrySet());
        }
        return false;
    }

    /* JADX INFO: renamed from: f */
    public abstract boolean mo6250f();

    @Override // java.util.Map
    public abstract V get(@NullableDecl Object obj);

    @Override // java.util.Map
    public final V getOrDefault(@NullableDecl Object obj, @NullableDecl V v) {
        V v2 = get(obj);
        return v2 != null ? v2 : v;
    }

    @Override // java.util.Map
    public int hashCode() {
        return Collections2.m6238a(m6274e());
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override // java.util.Map
    public Set keySet() {
        ImmutableSet2<K> immutableSet2 = this.f12050k;
        if (immutableSet2 != null) {
            return immutableSet2;
        }
        ImmutableSet2<K> immutableSet2Mo6248c = mo6248c();
        this.f12050k = immutableSet2Mo6248c;
        return immutableSet2Mo6248c;
    }

    @Override // java.util.Map
    @CanIgnoreReturnValue
    @Deprecated
    public final V put(K k, V v) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    @Deprecated
    public final void putAll(Map<? extends K, ? extends V> map) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    @CanIgnoreReturnValue
    @Deprecated
    public final V remove(Object obj) {
        throw new UnsupportedOperationException();
    }

    public String toString() {
        int size = size();
        C3404f.m4189A(size, "size");
        StringBuilder sb = new StringBuilder((int) Math.min(((long) size) * 8, Permission.MANAGE_EMOJIS_AND_STICKERS));
        sb.append('{');
        boolean z2 = true;
        for (Map.Entry entry : entrySet()) {
            if (!z2) {
                sb.append(", ");
            }
            z2 = false;
            sb.append(entry.getKey());
            sb.append('=');
            sb.append(entry.getValue());
        }
        sb.append('}');
        return sb.toString();
    }

    @Override // java.util.Map
    public Collection values() {
        ImmutableCollection<V> immutableCollection = this.f12051l;
        if (immutableCollection != null) {
            return immutableCollection;
        }
        ImmutableCollection<V> immutableCollectionMo6249d = mo6249d();
        this.f12051l = immutableCollectionMo6249d;
        return immutableCollectionMo6249d;
    }

    public Object writeReplace() {
        return new b(this);
    }
}

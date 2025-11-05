package b.i.b.b;

import b.i.b.b.n;
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

/* compiled from: ImmutableMap.java */
/* loaded from: classes3.dex */
public abstract class q<K, V> implements Map<K, V>, Serializable {

    @LazyInit
    public transient r<Map.Entry<K, V>> j;

    @RetainedWith
    @LazyInit
    public transient r<K> k;

    @RetainedWith
    @LazyInit
    public transient n<V> l;

    /* compiled from: ImmutableMap.java */
    public static class a<K, V> {
        public Object[] a;

        /* renamed from: b, reason: collision with root package name */
        public int f1648b = 0;
        public boolean c = false;

        public a(int i) {
            this.a = new Object[i * 2];
        }

        /* JADX WARN: Code restructure failed: missing block: B:16:0x0058, code lost:
        
            r5[r10] = r8;
            r4 = r4 + 1;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public q<K, V> a() {
            this.c = true;
            int i = this.f1648b;
            Object[] objArr = this.a;
            if (i == 0) {
                return (i0) i0.m;
            }
            int[] iArr = null;
            int i2 = 0;
            if (i == 1) {
                b.i.a.f.e.o.f.z(objArr[0], objArr[1]);
                return new i0(null, objArr, 1);
            }
            b.i.a.f.e.o.f.C(i, objArr.length >> 1);
            int iK = r.k(i);
            if (i == 1) {
                b.i.a.f.e.o.f.z(objArr[0], objArr[1]);
            } else {
                int i3 = iK - 1;
                int[] iArr2 = new int[iK];
                Arrays.fill(iArr2, -1);
                while (i2 < i) {
                    int i4 = i2 * 2;
                    int i5 = i4 + 0;
                    Object obj = objArr[i5];
                    Object obj2 = objArr[i4 + 1];
                    b.i.a.f.e.o.f.z(obj, obj2);
                    int iC1 = b.i.a.f.e.o.f.c1(obj.hashCode());
                    while (true) {
                        int i6 = iC1 & i3;
                        int i7 = iArr2[i6];
                        if (i7 == -1) {
                            break;
                        }
                        if (objArr[i7].equals(obj)) {
                            throw new IllegalArgumentException("Multiple entries with same key: " + obj + "=" + obj2 + " and " + objArr[i7] + "=" + objArr[1 ^ i7]);
                        }
                        iC1 = i6 + 1;
                    }
                }
                iArr = iArr2;
            }
            return new i0(iArr, objArr, i);
        }

        public final void b(int i) {
            int i2 = i * 2;
            Object[] objArr = this.a;
            if (i2 > objArr.length) {
                this.a = Arrays.copyOf(objArr, n.b.a(objArr.length, i2));
                this.c = false;
            }
        }

        @CanIgnoreReturnValue
        public a<K, V> c(K k, V v) {
            b(this.f1648b + 1);
            b.i.a.f.e.o.f.z(k, v);
            Object[] objArr = this.a;
            int i = this.f1648b;
            objArr[i * 2] = k;
            objArr[(i * 2) + 1] = v;
            this.f1648b = i + 1;
            return this;
        }
    }

    /* compiled from: ImmutableMap.java */
    public static class b implements Serializable {
        private static final long serialVersionUID = 0;
        private final Object[] keys;
        private final Object[] values;

        public b(q<?, ?> qVar) {
            this.keys = new Object[qVar.size()];
            this.values = new Object[qVar.size()];
            s0<Map.Entry<?, ?>> s0VarJ = qVar.e().j();
            int i = 0;
            while (s0VarJ.hasNext()) {
                Map.Entry<?, ?> next = s0VarJ.next();
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
                    return aVar.a();
                }
                aVar.c(objArr[i], this.values[i]);
                i++;
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <K, V> q<K, V> a(Map<? extends K, ? extends V> map) {
        if ((map instanceof q) && !(map instanceof SortedMap)) {
            q<K, V> qVar = (q) map;
            if (!qVar.f()) {
                return qVar;
            }
        }
        Set<Map.Entry<? extends K, ? extends V>> setEntrySet = map.entrySet();
        boolean z2 = setEntrySet instanceof Collection;
        a aVar = new a(z2 ? setEntrySet.size() : 4);
        if (z2) {
            aVar.b(setEntrySet.size() + aVar.f1648b);
        }
        Iterator<T> it = setEntrySet.iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            aVar.c(entry.getKey(), entry.getValue());
        }
        return aVar.a();
    }

    public abstract r<Map.Entry<K, V>> b();

    public abstract r<K> c();

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
        n<V> nVarD = this.l;
        if (nVarD == null) {
            nVarD = d();
            this.l = nVarD;
        }
        return nVarD.contains(obj);
    }

    public abstract n<V> d();

    public r<Map.Entry<K, V>> e() {
        r<Map.Entry<K, V>> rVar = this.j;
        if (rVar != null) {
            return rVar;
        }
        r<Map.Entry<K, V>> rVarB = b();
        this.j = rVarB;
        return rVarB;
    }

    @Override // java.util.Map
    public /* bridge */ /* synthetic */ Set entrySet() {
        return e();
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

    public abstract boolean f();

    @Override // java.util.Map
    public abstract V get(@NullableDecl Object obj);

    @Override // java.util.Map
    public final V getOrDefault(@NullableDecl Object obj, @NullableDecl V v) {
        V v2 = get(obj);
        return v2 != null ? v2 : v;
    }

    @Override // java.util.Map
    public int hashCode() {
        return h.a(e());
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override // java.util.Map
    public Set keySet() {
        r<K> rVar = this.k;
        if (rVar != null) {
            return rVar;
        }
        r<K> rVarC = c();
        this.k = rVarC;
        return rVarC;
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
        b.i.a.f.e.o.f.A(size, "size");
        StringBuilder sb = new StringBuilder((int) Math.min(size * 8, Permission.MANAGE_EMOJIS_AND_STICKERS));
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
        n<V> nVar = this.l;
        if (nVar != null) {
            return nVar;
        }
        n<V> nVarD = d();
        this.l = nVarD;
        return nVarD;
    }

    public Object writeReplace() {
        return new b(this);
    }
}

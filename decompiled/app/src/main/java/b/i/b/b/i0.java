package b.i.b.b;

import java.util.AbstractMap;
import java.util.Iterator;
import java.util.Map;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: RegularImmutableMap.java */
/* loaded from: classes3.dex */
public final class i0<K, V> extends q<K, V> {
    public static final q<Object, Object> m = new i0(null, new Object[0], 0);
    private static final long serialVersionUID = 0;
    public final transient int[] n;
    public final transient Object[] o;
    public final transient int p;

    /* compiled from: RegularImmutableMap.java */
    public static class a<K, V> extends r<Map.Entry<K, V>> {
        public final transient q<K, V> m;
        public final transient Object[] n;
        public final transient int o;
        public final transient int p;

        /* compiled from: RegularImmutableMap.java */
        /* renamed from: b.i.b.b.i0$a$a, reason: collision with other inner class name */
        public class C0133a extends p<Map.Entry<K, V>> {
            public C0133a() {
            }

            @Override // java.util.List
            public Object get(int i) {
                b.i.a.f.e.o.f.x(i, a.this.p);
                a aVar = a.this;
                Object[] objArr = aVar.n;
                int i2 = i * 2;
                int i3 = aVar.o;
                return new AbstractMap.SimpleImmutableEntry(objArr[i2 + i3], objArr[i2 + (i3 ^ 1)]);
            }

            @Override // b.i.b.b.n
            public boolean i() {
                return true;
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
            public int size() {
                return a.this.p;
            }
        }

        public a(q<K, V> qVar, Object[] objArr, int i, int i2) {
            this.m = qVar;
            this.n = objArr;
            this.o = i;
            this.p = i2;
        }

        @Override // b.i.b.b.n, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            Object key = entry.getKey();
            Object value = entry.getValue();
            return value != null && value.equals(this.m.get(key));
        }

        @Override // b.i.b.b.n
        public int d(Object[] objArr, int i) {
            return c().d(objArr, i);
        }

        @Override // b.i.b.b.n
        public boolean i() {
            return true;
        }

        @Override // b.i.b.b.r, b.i.b.b.n, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public /* bridge */ /* synthetic */ Iterator iterator() {
            return j();
        }

        @Override // b.i.b.b.n
        public s0<Map.Entry<K, V>> j() {
            return c().p();
        }

        @Override // b.i.b.b.r
        public p<Map.Entry<K, V>> o() {
            return new C0133a();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return this.p;
        }
    }

    /* compiled from: RegularImmutableMap.java */
    public static final class b<K> extends r<K> {
        public final transient q<K, ?> m;
        public final transient p<K> n;

        public b(q<K, ?> qVar, p<K> pVar) {
            this.m = qVar;
            this.n = pVar;
        }

        @Override // b.i.b.b.r, b.i.b.b.n
        public p<K> c() {
            return this.n;
        }

        @Override // b.i.b.b.n, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(@NullableDecl Object obj) {
            return this.m.get(obj) != null;
        }

        @Override // b.i.b.b.n
        public int d(Object[] objArr, int i) {
            return this.n.d(objArr, i);
        }

        @Override // b.i.b.b.n
        public boolean i() {
            return true;
        }

        @Override // b.i.b.b.r, b.i.b.b.n, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public /* bridge */ /* synthetic */ Iterator iterator() {
            return j();
        }

        @Override // b.i.b.b.n
        public s0<K> j() {
            return this.n.p();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return this.m.size();
        }
    }

    /* compiled from: RegularImmutableMap.java */
    public static final class c extends p<Object> {
        public final transient Object[] l;
        public final transient int m;
        public final transient int n;

        public c(Object[] objArr, int i, int i2) {
            this.l = objArr;
            this.m = i;
            this.n = i2;
        }

        @Override // java.util.List
        public Object get(int i) {
            b.i.a.f.e.o.f.x(i, this.n);
            return this.l[(i * 2) + this.m];
        }

        @Override // b.i.b.b.n
        public boolean i() {
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.n;
        }
    }

    public i0(int[] iArr, Object[] objArr, int i) {
        this.n = iArr;
        this.o = objArr;
        this.p = i;
    }

    @Override // b.i.b.b.q
    public r<Map.Entry<K, V>> b() {
        return new a(this, this.o, 0, this.p);
    }

    @Override // b.i.b.b.q
    public r<K> c() {
        return new b(this, new c(this.o, 0, this.p));
    }

    @Override // b.i.b.b.q
    public n<V> d() {
        return new c(this.o, 1, this.p);
    }

    @Override // b.i.b.b.q
    public boolean f() {
        return false;
    }

    @Override // b.i.b.b.q, java.util.Map
    @NullableDecl
    public V get(@NullableDecl Object obj) {
        int[] iArr = this.n;
        Object[] objArr = this.o;
        int i = this.p;
        if (obj == null) {
            return null;
        }
        if (i == 1) {
            if (objArr[0].equals(obj)) {
                return (V) objArr[1];
            }
            return null;
        }
        if (iArr == null) {
            return null;
        }
        int length = iArr.length - 1;
        int iC1 = b.i.a.f.e.o.f.c1(obj.hashCode());
        while (true) {
            int i2 = iC1 & length;
            int i3 = iArr[i2];
            if (i3 == -1) {
                return null;
            }
            if (objArr[i3].equals(obj)) {
                return (V) objArr[i3 ^ 1];
            }
            iC1 = i2 + 1;
        }
    }

    @Override // java.util.Map
    public int size() {
        return this.p;
    }
}

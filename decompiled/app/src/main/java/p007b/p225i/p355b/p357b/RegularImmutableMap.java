package p007b.p225i.p355b.p357b;

import java.util.AbstractMap;
import java.util.Iterator;
import java.util.Map;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;

/* compiled from: RegularImmutableMap.java */
/* renamed from: b.i.b.b.i0, reason: use source file name */
/* loaded from: classes3.dex */
public final class RegularImmutableMap<K, V> extends ImmutableMap2<K, V> {

    /* renamed from: m */
    public static final ImmutableMap2<Object, Object> f12015m = new RegularImmutableMap(null, new Object[0], 0);
    private static final long serialVersionUID = 0;

    /* renamed from: n */
    public final transient int[] f12016n;

    /* renamed from: o */
    public final transient Object[] f12017o;

    /* renamed from: p */
    public final transient int f12018p;

    /* compiled from: RegularImmutableMap.java */
    /* renamed from: b.i.b.b.i0$a */
    public static class a<K, V> extends ImmutableSet2<Map.Entry<K, V>> {

        /* renamed from: m */
        public final transient ImmutableMap2<K, V> f12019m;

        /* renamed from: n */
        public final transient Object[] f12020n;

        /* renamed from: o */
        public final transient int f12021o;

        /* renamed from: p */
        public final transient int f12022p;

        /* compiled from: RegularImmutableMap.java */
        /* renamed from: b.i.b.b.i0$a$a, reason: collision with other inner class name */
        public class C13231a extends ImmutableList2<Map.Entry<K, V>> {
            public C13231a() {
            }

            @Override // java.util.List
            public Object get(int i) {
                C3404f.m4359x(i, a.this.f12022p);
                a aVar = a.this;
                Object[] objArr = aVar.f12020n;
                int i2 = i * 2;
                int i3 = aVar.f12021o;
                return new AbstractMap.SimpleImmutableEntry(objArr[i2 + i3], objArr[i2 + (i3 ^ 1)]);
            }

            @Override // p007b.p225i.p355b.p357b.ImmutableCollection
            /* renamed from: i */
            public boolean mo6246i() {
                return true;
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
            public int size() {
                return a.this.f12022p;
            }
        }

        public a(ImmutableMap2<K, V> immutableMap2, Object[] objArr, int i, int i2) {
            this.f12019m = immutableMap2;
            this.f12020n = objArr;
            this.f12021o = i;
            this.f12022p = i2;
        }

        @Override // p007b.p225i.p355b.p357b.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            Object key = entry.getKey();
            Object value = entry.getValue();
            return value != null && value.equals(this.f12019m.get(key));
        }

        @Override // p007b.p225i.p355b.p357b.ImmutableCollection
        /* renamed from: d */
        public int mo6242d(Object[] objArr, int i) {
            return mo6253c().mo6242d(objArr, i);
        }

        @Override // p007b.p225i.p355b.p357b.ImmutableCollection
        /* renamed from: i */
        public boolean mo6246i() {
            return true;
        }

        @Override // p007b.p225i.p355b.p357b.ImmutableSet2, p007b.p225i.p355b.p357b.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public /* bridge */ /* synthetic */ Iterator iterator() {
            return mo6251j();
        }

        @Override // p007b.p225i.p355b.p357b.ImmutableCollection
        /* renamed from: j */
        public UnmodifiableIterator<Map.Entry<K, V>> mo6251j() {
            return mo6253c().m6268p();
        }

        @Override // p007b.p225i.p355b.p357b.ImmutableSet2
        /* renamed from: o */
        public ImmutableList2<Map.Entry<K, V>> mo6252o() {
            return new C13231a();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return this.f12022p;
        }
    }

    /* compiled from: RegularImmutableMap.java */
    /* renamed from: b.i.b.b.i0$b */
    public static final class b<K> extends ImmutableSet2<K> {

        /* renamed from: m */
        public final transient ImmutableMap2<K, ?> f12023m;

        /* renamed from: n */
        public final transient ImmutableList2<K> f12024n;

        public b(ImmutableMap2<K, ?> immutableMap2, ImmutableList2<K> immutableList2) {
            this.f12023m = immutableMap2;
            this.f12024n = immutableList2;
        }

        @Override // p007b.p225i.p355b.p357b.ImmutableSet2, p007b.p225i.p355b.p357b.ImmutableCollection
        /* renamed from: c */
        public ImmutableList2<K> mo6253c() {
            return this.f12024n;
        }

        @Override // p007b.p225i.p355b.p357b.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(@NullableDecl Object obj) {
            return this.f12023m.get(obj) != null;
        }

        @Override // p007b.p225i.p355b.p357b.ImmutableCollection
        /* renamed from: d */
        public int mo6242d(Object[] objArr, int i) {
            return this.f12024n.mo6242d(objArr, i);
        }

        @Override // p007b.p225i.p355b.p357b.ImmutableCollection
        /* renamed from: i */
        public boolean mo6246i() {
            return true;
        }

        @Override // p007b.p225i.p355b.p357b.ImmutableSet2, p007b.p225i.p355b.p357b.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public /* bridge */ /* synthetic */ Iterator iterator() {
            return mo6251j();
        }

        @Override // p007b.p225i.p355b.p357b.ImmutableCollection
        /* renamed from: j */
        public UnmodifiableIterator<K> mo6251j() {
            return this.f12024n.m6268p();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return this.f12023m.size();
        }
    }

    /* compiled from: RegularImmutableMap.java */
    /* renamed from: b.i.b.b.i0$c */
    public static final class c extends ImmutableList2<Object> {

        /* renamed from: l */
        public final transient Object[] f12025l;

        /* renamed from: m */
        public final transient int f12026m;

        /* renamed from: n */
        public final transient int f12027n;

        public c(Object[] objArr, int i, int i2) {
            this.f12025l = objArr;
            this.f12026m = i;
            this.f12027n = i2;
        }

        @Override // java.util.List
        public Object get(int i) {
            C3404f.m4359x(i, this.f12027n);
            return this.f12025l[(i * 2) + this.f12026m];
        }

        @Override // p007b.p225i.p355b.p357b.ImmutableCollection
        /* renamed from: i */
        public boolean mo6246i() {
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.f12027n;
        }
    }

    public RegularImmutableMap(int[] iArr, Object[] objArr, int i) {
        this.f12016n = iArr;
        this.f12017o = objArr;
        this.f12018p = i;
    }

    @Override // p007b.p225i.p355b.p357b.ImmutableMap2
    /* renamed from: b */
    public ImmutableSet2<Map.Entry<K, V>> mo6247b() {
        return new a(this, this.f12017o, 0, this.f12018p);
    }

    @Override // p007b.p225i.p355b.p357b.ImmutableMap2
    /* renamed from: c */
    public ImmutableSet2<K> mo6248c() {
        return new b(this, new c(this.f12017o, 0, this.f12018p));
    }

    @Override // p007b.p225i.p355b.p357b.ImmutableMap2
    /* renamed from: d */
    public ImmutableCollection<V> mo6249d() {
        return new c(this.f12017o, 1, this.f12018p);
    }

    @Override // p007b.p225i.p355b.p357b.ImmutableMap2
    /* renamed from: f */
    public boolean mo6250f() {
        return false;
    }

    @Override // p007b.p225i.p355b.p357b.ImmutableMap2, java.util.Map
    @NullableDecl
    public V get(@NullableDecl Object obj) {
        int[] iArr = this.f12016n;
        Object[] objArr = this.f12017o;
        int i = this.f12018p;
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
        int iM4277c1 = C3404f.m4277c1(obj.hashCode());
        while (true) {
            int i2 = iM4277c1 & length;
            int i3 = iArr[i2];
            if (i3 == -1) {
                return null;
            }
            if (objArr[i3].equals(obj)) {
                return (V) objArr[i3 ^ 1];
            }
            iM4277c1 = i2 + 1;
        }
    }

    @Override // java.util.Map
    public int size() {
        return this.f12018p;
    }
}

package b.i.b.b;

import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.Objects;
import java.util.RandomAccess;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: AbstractMapBasedMultimap.java */
/* loaded from: classes3.dex */
public abstract class e<K, V> extends b.i.b.b.g<K, V> implements Serializable {
    private static final long serialVersionUID = 2447537837011683357L;
    public transient Map<K, Collection<V>> m;
    public transient int n;

    /* compiled from: AbstractMapBasedMultimap.java */
    public class a extends a0<K, Collection<V>> {
        public final transient Map<K, Collection<V>> l;

        /* compiled from: AbstractMapBasedMultimap.java */
        /* renamed from: b.i.b.b.e$a$a, reason: collision with other inner class name */
        public class C0131a extends x<K, Collection<V>> {
            public C0131a() {
            }

            @Override // b.i.b.b.x, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean contains(Object obj) {
                Set<Map.Entry<K, Collection<V>>> setEntrySet = a.this.l.entrySet();
                Objects.requireNonNull(setEntrySet);
                try {
                    return setEntrySet.contains(obj);
                } catch (ClassCastException | NullPointerException unused) {
                    return false;
                }
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
            public Iterator<Map.Entry<K, Collection<V>>> iterator() {
                return a.this.new b();
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean remove(Object obj) {
                Collection<V> collectionRemove;
                if (!contains(obj)) {
                    return false;
                }
                e eVar = e.this;
                Object key = ((Map.Entry) obj).getKey();
                Map<K, Collection<V>> map = eVar.m;
                Objects.requireNonNull(map);
                try {
                    collectionRemove = map.remove(key);
                } catch (ClassCastException | NullPointerException unused) {
                    collectionRemove = null;
                }
                Collection<V> collection = collectionRemove;
                if (collection == null) {
                    return true;
                }
                int size = collection.size();
                collection.clear();
                eVar.n -= size;
                return true;
            }
        }

        /* compiled from: AbstractMapBasedMultimap.java */
        public class b implements Iterator<Map.Entry<K, Collection<V>>> {
            public final Iterator<Map.Entry<K, Collection<V>>> j;

            @NullableDecl
            public Collection<V> k;

            public b() {
                this.j = a.this.l.entrySet().iterator();
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.j.hasNext();
            }

            @Override // java.util.Iterator
            public Object next() {
                Map.Entry<K, Collection<V>> next = this.j.next();
                this.k = next.getValue();
                return a.this.a(next);
            }

            @Override // java.util.Iterator
            public void remove() {
                b.i.a.f.e.o.f.E(this.k != null);
                this.j.remove();
                e.this.n -= this.k.size();
                this.k.clear();
                this.k = null;
            }
        }

        public a(Map<K, Collection<V>> map) {
            this.l = map;
        }

        public Map.Entry<K, Collection<V>> a(Map.Entry<K, Collection<V>> entry) {
            K key = entry.getKey();
            e eVar = e.this;
            Collection<V> value = entry.getValue();
            b.i.b.b.c cVar = (b.i.b.b.c) eVar;
            Objects.requireNonNull(cVar);
            List list = (List) value;
            return new o(key, list instanceof RandomAccess ? new f(cVar, key, list, null) : new j(key, list, null));
        }

        @Override // java.util.AbstractMap, java.util.Map
        public void clear() {
            Map<K, Collection<V>> map = this.l;
            e eVar = e.this;
            if (map == eVar.m) {
                eVar.d();
                return;
            }
            b bVar = new b();
            while (bVar.hasNext()) {
                bVar.next();
                bVar.remove();
            }
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(Object obj) {
            Map<K, Collection<V>> map = this.l;
            Objects.requireNonNull(map);
            try {
                return map.containsKey(obj);
            } catch (ClassCastException | NullPointerException unused) {
                return false;
            }
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean equals(@NullableDecl Object obj) {
            return this == obj || this.l.equals(obj);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Object get(Object obj) {
            Collection<V> collection;
            Map<K, Collection<V>> map = this.l;
            Objects.requireNonNull(map);
            try {
                collection = map.get(obj);
            } catch (ClassCastException | NullPointerException unused) {
                collection = null;
            }
            Collection<V> collection2 = collection;
            if (collection2 == null) {
                return null;
            }
            b.i.b.b.c cVar = (b.i.b.b.c) e.this;
            Objects.requireNonNull(cVar);
            List list = (List) collection2;
            return list instanceof RandomAccess ? new f(cVar, obj, list, null) : new j(obj, list, null);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public int hashCode() {
            return this.l.hashCode();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Set<K> keySet() {
            e eVar = e.this;
            Set<K> c0132e = eVar.j;
            if (c0132e == null) {
                d0 d0Var = (d0) eVar;
                Map<K, Collection<V>> map = d0Var.m;
                c0132e = map instanceof NavigableMap ? new C0132e((NavigableMap) d0Var.m) : map instanceof SortedMap ? new h((SortedMap) d0Var.m) : new c(d0Var.m);
                eVar.j = c0132e;
            }
            return c0132e;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Object remove(Object obj) {
            Collection<V> collectionRemove = this.l.remove(obj);
            if (collectionRemove == null) {
                return null;
            }
            Collection<V> collectionE = e.this.e();
            collectionE.addAll(collectionRemove);
            e.this.n -= collectionRemove.size();
            collectionRemove.clear();
            return collectionE;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public int size() {
            return this.l.size();
        }

        @Override // java.util.AbstractMap
        public String toString() {
            return this.l.toString();
        }
    }

    /* compiled from: AbstractMapBasedMultimap.java */
    public abstract class b<T> implements Iterator<T> {
        public final Iterator<Map.Entry<K, Collection<V>>> j;

        @NullableDecl
        public K k = null;

        @MonotonicNonNullDecl
        public Collection<V> l = null;
        public Iterator<V> m = t.INSTANCE;

        public b() {
            this.j = e.this.m.entrySet().iterator();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.j.hasNext() || this.m.hasNext();
        }

        @Override // java.util.Iterator
        public T next() {
            if (!this.m.hasNext()) {
                Map.Entry<K, Collection<V>> next = this.j.next();
                this.k = next.getKey();
                Collection<V> value = next.getValue();
                this.l = value;
                this.m = value.iterator();
            }
            return this.m.next();
        }

        @Override // java.util.Iterator
        public void remove() {
            this.m.remove();
            if (this.l.isEmpty()) {
                this.j.remove();
            }
            e.c(e.this);
        }
    }

    /* compiled from: AbstractMapBasedMultimap.java */
    public class c extends y<K, Collection<V>> {

        /* compiled from: AbstractMapBasedMultimap.java */
        public class a implements Iterator<K> {

            @NullableDecl
            public Map.Entry<K, Collection<V>> j;
            public final /* synthetic */ Iterator k;

            public a(Iterator it) {
                this.k = it;
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.k.hasNext();
            }

            @Override // java.util.Iterator
            public K next() {
                Map.Entry<K, Collection<V>> entry = (Map.Entry) this.k.next();
                this.j = entry;
                return entry.getKey();
            }

            @Override // java.util.Iterator
            public void remove() {
                b.i.a.f.e.o.f.E(this.j != null);
                Collection<V> value = this.j.getValue();
                this.k.remove();
                e.this.n -= value.size();
                value.clear();
                this.j = null;
            }
        }

        public c(Map<K, Collection<V>> map) {
            super(map);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            Iterator<K> it = iterator();
            while (true) {
                a aVar = (a) it;
                if (!aVar.hasNext()) {
                    return;
                }
                aVar.next();
                aVar.remove();
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean containsAll(Collection<?> collection) {
            return this.j.keySet().containsAll(collection);
        }

        @Override // java.util.AbstractSet, java.util.Collection, java.util.Set
        public boolean equals(@NullableDecl Object obj) {
            return this == obj || this.j.keySet().equals(obj);
        }

        @Override // java.util.AbstractSet, java.util.Collection, java.util.Set
        public int hashCode() {
            return this.j.keySet().hashCode();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<K> iterator() {
            return new a(this.j.entrySet().iterator());
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            int size;
            Collection collection = (Collection) this.j.remove(obj);
            if (collection != null) {
                size = collection.size();
                collection.clear();
                e.this.n -= size;
            } else {
                size = 0;
            }
            return size > 0;
        }
    }

    /* compiled from: AbstractMapBasedMultimap.java */
    public class d extends e<K, V>.g implements NavigableMap<K, Collection<V>> {
        public d(NavigableMap<K, Collection<V>> navigableMap) {
            super(navigableMap);
        }

        @Override // b.i.b.b.e.g
        public SortedSet b() {
            return new C0132e(g());
        }

        @Override // b.i.b.b.e.g
        public /* bridge */ /* synthetic */ SortedSet c() {
            return e();
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, Collection<V>> ceilingEntry(K k) {
            Map.Entry<K, Collection<V>> entryCeilingEntry = g().ceilingEntry(k);
            if (entryCeilingEntry == null) {
                return null;
            }
            return a(entryCeilingEntry);
        }

        @Override // java.util.NavigableMap
        public K ceilingKey(K k) {
            return g().ceilingKey(k);
        }

        @Override // b.i.b.b.e.g
        public /* bridge */ /* synthetic */ SortedMap d() {
            return g();
        }

        @Override // java.util.NavigableMap
        public NavigableSet<K> descendingKeySet() {
            return ((d) descendingMap()).navigableKeySet();
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, Collection<V>> descendingMap() {
            return new d(g().descendingMap());
        }

        public NavigableSet<K> e() {
            SortedSet<K> sortedSetB = this.n;
            if (sortedSetB == null) {
                sortedSetB = b();
                this.n = sortedSetB;
            }
            return (NavigableSet) sortedSetB;
        }

        public Map.Entry<K, Collection<V>> f(Iterator<Map.Entry<K, Collection<V>>> it) {
            if (!it.hasNext()) {
                return null;
            }
            Map.Entry<K, Collection<V>> next = it.next();
            Collection<V> collectionE = e.this.e();
            collectionE.addAll(next.getValue());
            it.remove();
            K key = next.getKey();
            Objects.requireNonNull((b.i.b.b.c) e.this);
            return new o(key, Collections.unmodifiableList((List) collectionE));
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, Collection<V>> firstEntry() {
            Map.Entry<K, Collection<V>> entryFirstEntry = g().firstEntry();
            if (entryFirstEntry == null) {
                return null;
            }
            return a(entryFirstEntry);
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, Collection<V>> floorEntry(K k) {
            Map.Entry<K, Collection<V>> entryFloorEntry = g().floorEntry(k);
            if (entryFloorEntry == null) {
                return null;
            }
            return a(entryFloorEntry);
        }

        @Override // java.util.NavigableMap
        public K floorKey(K k) {
            return g().floorKey(k);
        }

        public NavigableMap<K, Collection<V>> g() {
            return (NavigableMap) ((SortedMap) this.l);
        }

        @Override // b.i.b.b.e.g, java.util.SortedMap, java.util.NavigableMap
        public SortedMap headMap(Object obj) {
            return headMap(obj, false);
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, Collection<V>> higherEntry(K k) {
            Map.Entry<K, Collection<V>> entryHigherEntry = g().higherEntry(k);
            if (entryHigherEntry == null) {
                return null;
            }
            return a(entryHigherEntry);
        }

        @Override // java.util.NavigableMap
        public K higherKey(K k) {
            return g().higherKey(k);
        }

        @Override // b.i.b.b.e.g, b.i.b.b.e.a, java.util.AbstractMap, java.util.Map
        public /* bridge */ /* synthetic */ Set keySet() {
            return e();
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, Collection<V>> lastEntry() {
            Map.Entry<K, Collection<V>> entryLastEntry = g().lastEntry();
            if (entryLastEntry == null) {
                return null;
            }
            return a(entryLastEntry);
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, Collection<V>> lowerEntry(K k) {
            Map.Entry<K, Collection<V>> entryLowerEntry = g().lowerEntry(k);
            if (entryLowerEntry == null) {
                return null;
            }
            return a(entryLowerEntry);
        }

        @Override // java.util.NavigableMap
        public K lowerKey(K k) {
            return g().lowerKey(k);
        }

        @Override // java.util.NavigableMap
        public NavigableSet<K> navigableKeySet() {
            return e();
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, Collection<V>> pollFirstEntry() {
            return f(entrySet().iterator());
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, Collection<V>> pollLastEntry() {
            return f(((a0) descendingMap()).entrySet().iterator());
        }

        @Override // b.i.b.b.e.g, java.util.SortedMap, java.util.NavigableMap
        public SortedMap subMap(Object obj, Object obj2) {
            return subMap(obj, true, obj2, false);
        }

        @Override // b.i.b.b.e.g, java.util.SortedMap, java.util.NavigableMap
        public SortedMap tailMap(Object obj) {
            return tailMap(obj, true);
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, Collection<V>> headMap(K k, boolean z2) {
            return new d(g().headMap(k, z2));
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, Collection<V>> subMap(K k, boolean z2, K k2, boolean z3) {
            return new d(g().subMap(k, z2, k2, z3));
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, Collection<V>> tailMap(K k, boolean z2) {
            return new d(g().tailMap(k, z2));
        }
    }

    /* compiled from: AbstractMapBasedMultimap.java */
    /* renamed from: b.i.b.b.e$e, reason: collision with other inner class name */
    public class C0132e extends e<K, V>.h implements NavigableSet<K> {
        public C0132e(NavigableMap<K, Collection<V>> navigableMap) {
            super(navigableMap);
        }

        @Override // b.i.b.b.e.h
        public /* bridge */ /* synthetic */ SortedMap c() {
            return d();
        }

        @Override // java.util.NavigableSet
        public K ceiling(K k) {
            return d().ceilingKey(k);
        }

        public NavigableMap<K, Collection<V>> d() {
            return (NavigableMap) ((SortedMap) this.j);
        }

        @Override // java.util.NavigableSet
        public Iterator<K> descendingIterator() {
            return ((c) descendingSet()).iterator();
        }

        @Override // java.util.NavigableSet
        public NavigableSet<K> descendingSet() {
            return new C0132e(d().descendingMap());
        }

        @Override // java.util.NavigableSet
        public K floor(K k) {
            return d().floorKey(k);
        }

        @Override // b.i.b.b.e.h, java.util.SortedSet, java.util.NavigableSet
        public SortedSet headSet(Object obj) {
            return headSet(obj, false);
        }

        @Override // java.util.NavigableSet
        public K higher(K k) {
            return d().higherKey(k);
        }

        @Override // java.util.NavigableSet
        public K lower(K k) {
            return d().lowerKey(k);
        }

        @Override // java.util.NavigableSet
        public K pollFirst() {
            c.a aVar = (c.a) iterator();
            if (!aVar.hasNext()) {
                return null;
            }
            K k = (K) aVar.next();
            aVar.remove();
            return k;
        }

        @Override // java.util.NavigableSet
        public K pollLast() {
            Iterator<K> itDescendingIterator = descendingIterator();
            if (!itDescendingIterator.hasNext()) {
                return null;
            }
            K next = itDescendingIterator.next();
            itDescendingIterator.remove();
            return next;
        }

        @Override // b.i.b.b.e.h, java.util.SortedSet, java.util.NavigableSet
        public SortedSet subSet(Object obj, Object obj2) {
            return subSet(obj, true, obj2, false);
        }

        @Override // b.i.b.b.e.h, java.util.SortedSet, java.util.NavigableSet
        public SortedSet tailSet(Object obj) {
            return tailSet(obj, true);
        }

        @Override // java.util.NavigableSet
        public NavigableSet<K> headSet(K k, boolean z2) {
            return new C0132e(d().headMap(k, z2));
        }

        @Override // java.util.NavigableSet
        public NavigableSet<K> subSet(K k, boolean z2, K k2, boolean z3) {
            return new C0132e(d().subMap(k, z2, k2, z3));
        }

        @Override // java.util.NavigableSet
        public NavigableSet<K> tailSet(K k, boolean z2) {
            return new C0132e(d().tailMap(k, z2));
        }
    }

    /* compiled from: AbstractMapBasedMultimap.java */
    public class f extends e<K, V>.j implements RandomAccess {
        public f(@NullableDecl e eVar, K k, @NullableDecl List<V> list, e<K, V>.i iVar) {
            super(k, list, iVar);
        }
    }

    /* compiled from: AbstractMapBasedMultimap.java */
    public class g extends e<K, V>.a implements SortedMap<K, Collection<V>> {

        @MonotonicNonNullDecl
        public SortedSet<K> n;

        public g(SortedMap<K, Collection<V>> sortedMap) {
            super(sortedMap);
        }

        public SortedSet<K> b() {
            return new h(d());
        }

        public SortedSet<K> c() {
            SortedSet<K> sortedSet = this.n;
            if (sortedSet != null) {
                return sortedSet;
            }
            SortedSet<K> sortedSetB = b();
            this.n = sortedSetB;
            return sortedSetB;
        }

        @Override // java.util.SortedMap
        public Comparator<? super K> comparator() {
            return d().comparator();
        }

        public SortedMap<K, Collection<V>> d() {
            return (SortedMap) this.l;
        }

        @Override // java.util.SortedMap
        public K firstKey() {
            return d().firstKey();
        }

        public SortedMap<K, Collection<V>> headMap(K k) {
            return new g(d().headMap(k));
        }

        @Override // b.i.b.b.e.a, java.util.AbstractMap, java.util.Map
        public /* bridge */ /* synthetic */ Set keySet() {
            return c();
        }

        @Override // java.util.SortedMap
        public K lastKey() {
            return d().lastKey();
        }

        public SortedMap<K, Collection<V>> subMap(K k, K k2) {
            return new g(d().subMap(k, k2));
        }

        public SortedMap<K, Collection<V>> tailMap(K k) {
            return new g(d().tailMap(k));
        }
    }

    /* compiled from: AbstractMapBasedMultimap.java */
    public class h extends e<K, V>.c implements SortedSet<K> {
        public h(SortedMap<K, Collection<V>> sortedMap) {
            super(sortedMap);
        }

        public SortedMap<K, Collection<V>> c() {
            return (SortedMap) this.j;
        }

        @Override // java.util.SortedSet
        public Comparator<? super K> comparator() {
            return c().comparator();
        }

        @Override // java.util.SortedSet
        public K first() {
            return c().firstKey();
        }

        public SortedSet<K> headSet(K k) {
            return new h(c().headMap(k));
        }

        @Override // java.util.SortedSet
        public K last() {
            return c().lastKey();
        }

        public SortedSet<K> subSet(K k, K k2) {
            return new h(c().subMap(k, k2));
        }

        public SortedSet<K> tailSet(K k) {
            return new h(c().tailMap(k));
        }
    }

    public e(Map<K, Collection<V>> map) {
        b.i.a.f.e.o.f.v(map.isEmpty());
        this.m = map;
    }

    public static /* synthetic */ int b(e eVar) {
        int i2 = eVar.n;
        eVar.n = i2 + 1;
        return i2;
    }

    public static /* synthetic */ int c(e eVar) {
        int i2 = eVar.n;
        eVar.n = i2 - 1;
        return i2;
    }

    public void d() {
        Iterator<Collection<V>> it = this.m.values().iterator();
        while (it.hasNext()) {
            it.next().clear();
        }
        this.m.clear();
        this.n = 0;
    }

    public abstract Collection<V> e();

    /* compiled from: AbstractMapBasedMultimap.java */
    public class j extends e<K, V>.i implements List<V> {

        /* compiled from: AbstractMapBasedMultimap.java */
        public class a extends e<K, V>.i.a implements ListIterator<V> {
            public a() {
                super();
            }

            @Override // java.util.ListIterator
            public void add(V v) {
                boolean zIsEmpty = j.this.isEmpty();
                b().add(v);
                e.b(e.this);
                if (zIsEmpty) {
                    j.this.c();
                }
            }

            public final ListIterator<V> b() {
                a();
                return (ListIterator) this.j;
            }

            @Override // java.util.ListIterator
            public boolean hasPrevious() {
                return b().hasPrevious();
            }

            @Override // java.util.ListIterator
            public int nextIndex() {
                return b().nextIndex();
            }

            @Override // java.util.ListIterator
            public V previous() {
                return b().previous();
            }

            @Override // java.util.ListIterator
            public int previousIndex() {
                return b().previousIndex();
            }

            @Override // java.util.ListIterator
            public void set(V v) {
                b().set(v);
            }

            public a(int i) {
                super(((List) j.this.k).listIterator(i));
            }
        }

        public j(@NullableDecl K k, List<V> list, @NullableDecl e<K, V>.i iVar) {
            super(k, list, iVar);
        }

        @Override // java.util.List
        public void add(int i, V v) {
            d();
            boolean zIsEmpty = this.k.isEmpty();
            ((List) this.k).add(i, v);
            e.b(e.this);
            if (zIsEmpty) {
                c();
            }
        }

        @Override // java.util.List
        public boolean addAll(int i, Collection<? extends V> collection) {
            if (collection.isEmpty()) {
                return false;
            }
            int size = size();
            boolean zAddAll = ((List) this.k).addAll(i, collection);
            if (zAddAll) {
                int size2 = this.k.size();
                e eVar = e.this;
                eVar.n = (size2 - size) + eVar.n;
                if (size == 0) {
                    c();
                }
            }
            return zAddAll;
        }

        @Override // java.util.List
        public V get(int i) {
            d();
            return (V) ((List) this.k).get(i);
        }

        @Override // java.util.List
        public int indexOf(Object obj) {
            d();
            return ((List) this.k).indexOf(obj);
        }

        @Override // java.util.List
        public int lastIndexOf(Object obj) {
            d();
            return ((List) this.k).lastIndexOf(obj);
        }

        @Override // java.util.List
        public ListIterator<V> listIterator() {
            d();
            return new a();
        }

        @Override // java.util.List
        public V remove(int i) {
            d();
            V v = (V) ((List) this.k).remove(i);
            e.c(e.this);
            e();
            return v;
        }

        @Override // java.util.List
        public V set(int i, V v) {
            d();
            return (V) ((List) this.k).set(i, v);
        }

        @Override // java.util.List
        public List<V> subList(int i, int i2) {
            d();
            e eVar = e.this;
            K k = this.j;
            List listSubList = ((List) this.k).subList(i, i2);
            e<K, V>.i iVar = this.l;
            if (iVar == null) {
                iVar = this;
            }
            Objects.requireNonNull(eVar);
            return listSubList instanceof RandomAccess ? new f(eVar, k, listSubList, iVar) : new j(k, listSubList, iVar);
        }

        @Override // java.util.List
        public ListIterator<V> listIterator(int i) {
            d();
            return new a(i);
        }
    }

    /* compiled from: AbstractMapBasedMultimap.java */
    public class i extends AbstractCollection<V> {

        @NullableDecl
        public final K j;
        public Collection<V> k;

        @NullableDecl
        public final e<K, V>.i l;

        @NullableDecl
        public final Collection<V> m;

        public i(@NullableDecl K k, Collection<V> collection, @NullableDecl e<K, V>.i iVar) {
            this.j = k;
            this.k = collection;
            this.l = iVar;
            this.m = iVar == null ? null : iVar.k;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean add(V v) {
            d();
            boolean zIsEmpty = this.k.isEmpty();
            boolean zAdd = this.k.add(v);
            if (zAdd) {
                e.b(e.this);
                if (zIsEmpty) {
                    c();
                }
            }
            return zAdd;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean addAll(Collection<? extends V> collection) {
            if (collection.isEmpty()) {
                return false;
            }
            int size = size();
            boolean zAddAll = this.k.addAll(collection);
            if (zAddAll) {
                int size2 = this.k.size();
                e eVar = e.this;
                eVar.n = (size2 - size) + eVar.n;
                if (size == 0) {
                    c();
                }
            }
            return zAddAll;
        }

        public void c() {
            e<K, V>.i iVar = this.l;
            if (iVar != null) {
                iVar.c();
            } else {
                e.this.m.put(this.j, this.k);
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() {
            int size = size();
            if (size == 0) {
                return;
            }
            this.k.clear();
            e.this.n -= size;
            e();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean contains(Object obj) {
            d();
            return this.k.contains(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean containsAll(Collection<?> collection) {
            d();
            return this.k.containsAll(collection);
        }

        public void d() {
            Collection<V> collection;
            e<K, V>.i iVar = this.l;
            if (iVar != null) {
                iVar.d();
                if (this.l.k != this.m) {
                    throw new ConcurrentModificationException();
                }
            } else {
                if (!this.k.isEmpty() || (collection = e.this.m.get(this.j)) == null) {
                    return;
                }
                this.k = collection;
            }
        }

        public void e() {
            e<K, V>.i iVar = this.l;
            if (iVar != null) {
                iVar.e();
            } else if (this.k.isEmpty()) {
                e.this.m.remove(this.j);
            }
        }

        @Override // java.util.Collection
        public boolean equals(@NullableDecl Object obj) {
            if (obj == this) {
                return true;
            }
            d();
            return this.k.equals(obj);
        }

        @Override // java.util.Collection
        public int hashCode() {
            d();
            return this.k.hashCode();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<V> iterator() {
            d();
            return new a();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean remove(Object obj) {
            d();
            boolean zRemove = this.k.remove(obj);
            if (zRemove) {
                e.c(e.this);
                e();
            }
            return zRemove;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean removeAll(Collection<?> collection) {
            if (collection.isEmpty()) {
                return false;
            }
            int size = size();
            boolean zRemoveAll = this.k.removeAll(collection);
            if (zRemoveAll) {
                int size2 = this.k.size();
                e eVar = e.this;
                eVar.n = (size2 - size) + eVar.n;
                e();
            }
            return zRemoveAll;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean retainAll(Collection<?> collection) {
            Objects.requireNonNull(collection);
            int size = size();
            boolean zRetainAll = this.k.retainAll(collection);
            if (zRetainAll) {
                int size2 = this.k.size();
                e eVar = e.this;
                eVar.n = (size2 - size) + eVar.n;
                e();
            }
            return zRetainAll;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            d();
            return this.k.size();
        }

        @Override // java.util.AbstractCollection
        public String toString() {
            d();
            return this.k.toString();
        }

        /* compiled from: AbstractMapBasedMultimap.java */
        public class a implements Iterator<V> {
            public final Iterator<V> j;
            public final Collection<V> k;

            public a() {
                Collection<V> collection = i.this.k;
                this.k = collection;
                this.j = collection instanceof List ? ((List) collection).listIterator() : collection.iterator();
            }

            public void a() {
                i.this.d();
                if (i.this.k != this.k) {
                    throw new ConcurrentModificationException();
                }
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                a();
                return this.j.hasNext();
            }

            @Override // java.util.Iterator
            public V next() {
                a();
                return this.j.next();
            }

            @Override // java.util.Iterator
            public void remove() {
                this.j.remove();
                e.c(e.this);
                i.this.e();
            }

            public a(Iterator<V> it) {
                this.k = i.this.k;
                this.j = it;
            }
        }
    }
}

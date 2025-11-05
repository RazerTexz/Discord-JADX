package b.i.b.b;

import b.i.b.b.e;
import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.NavigableMap;
import java.util.Objects;
import java.util.Set;
import java.util.SortedMap;
import org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: AbstractMultimap.java */
/* loaded from: classes3.dex */
public abstract class g<K, V> implements b0<K, V> {

    @MonotonicNonNullDecl
    public transient Set<K> j;

    @MonotonicNonNullDecl
    public transient Collection<V> k;

    @MonotonicNonNullDecl
    public transient Map<K, Collection<V>> l;

    /* compiled from: AbstractMultimap.java */
    public class a extends AbstractCollection<V> {
        public a() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() {
            ((e) g.this).d();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean contains(@NullableDecl Object obj) {
            Iterator<Collection<V>> it = g.this.a().values().iterator();
            while (it.hasNext()) {
                if (it.next().contains(obj)) {
                    return true;
                }
            }
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<V> iterator() {
            e eVar = (e) g.this;
            Objects.requireNonNull(eVar);
            return new d(eVar);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return ((e) g.this).n;
        }
    }

    @Override // b.i.b.b.b0
    public Map<K, Collection<V>> a() {
        Map<K, Collection<V>> dVar = this.l;
        if (dVar == null) {
            d0 d0Var = (d0) this;
            Map<K, Collection<V>> map = d0Var.m;
            dVar = map instanceof NavigableMap ? new e.d((NavigableMap) d0Var.m) : map instanceof SortedMap ? new e.g((SortedMap) d0Var.m) : new e.a(d0Var.m);
            this.l = dVar;
        }
        return dVar;
    }

    public boolean equals(@NullableDecl Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof b0) {
            return ((c) this).a().equals(((b0) obj).a());
        }
        return false;
    }

    public int hashCode() {
        return a().hashCode();
    }

    public String toString() {
        return a().toString();
    }
}

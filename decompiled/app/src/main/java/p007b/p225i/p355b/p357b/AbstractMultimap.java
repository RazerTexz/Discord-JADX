package p007b.p225i.p355b.p357b;

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
import p007b.p225i.p355b.p357b.AbstractMapBasedMultimap2;

/* compiled from: AbstractMultimap.java */
/* renamed from: b.i.b.b.g, reason: use source file name */
/* loaded from: classes3.dex */
public abstract class AbstractMultimap<K, V> implements Multimap<K, V> {

    /* renamed from: j */
    @MonotonicNonNullDecl
    public transient Set<K> f12006j;

    /* renamed from: k */
    @MonotonicNonNullDecl
    public transient Collection<V> f12007k;

    /* renamed from: l */
    @MonotonicNonNullDecl
    public transient Map<K, Collection<V>> f12008l;

    /* compiled from: AbstractMultimap.java */
    /* renamed from: b.i.b.b.g$a */
    public class a extends AbstractCollection<V> {
        public a() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() {
            ((AbstractMapBasedMultimap2) AbstractMultimap.this).m6220d();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean contains(@NullableDecl Object obj) {
            Iterator<Collection<V>> it = AbstractMultimap.this.mo6216a().values().iterator();
            while (it.hasNext()) {
                if (it.next().contains(obj)) {
                    return true;
                }
            }
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<V> iterator() {
            AbstractMapBasedMultimap2 abstractMapBasedMultimap2 = (AbstractMapBasedMultimap2) AbstractMultimap.this;
            Objects.requireNonNull(abstractMapBasedMultimap2);
            return new AbstractMapBasedMultimap(abstractMapBasedMultimap2);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return ((AbstractMapBasedMultimap2) AbstractMultimap.this).f11974n;
        }
    }

    @Override // p007b.p225i.p355b.p357b.Multimap
    /* renamed from: a */
    public Map<K, Collection<V>> mo6216a() {
        Map<K, Collection<V>> dVar = this.f12008l;
        if (dVar == null) {
            Multimaps multimaps = (Multimaps) this;
            Map<K, Collection<V>> map = multimaps.f11973m;
            dVar = map instanceof NavigableMap ? new AbstractMapBasedMultimap2.d((NavigableMap) multimaps.f11973m) : map instanceof SortedMap ? new AbstractMapBasedMultimap2.g((SortedMap) multimaps.f11973m) : new AbstractMapBasedMultimap2.a(multimaps.f11973m);
            this.f12008l = dVar;
        }
        return dVar;
    }

    public boolean equals(@NullableDecl Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof Multimap) {
            return ((AbstractListMultimap) this).mo6216a().equals(((Multimap) obj).mo6216a());
        }
        return false;
    }

    public int hashCode() {
        return mo6216a().hashCode();
    }

    public String toString() {
        return mo6216a().toString();
    }
}

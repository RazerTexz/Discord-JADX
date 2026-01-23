package p007b.p225i.p355b.p357b;

import java.util.Collection;
import java.util.Map;
import java.util.NavigableMap;
import java.util.SortedMap;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import p007b.p225i.p355b.p357b.AbstractMapBasedMultimap2;

/* JADX INFO: renamed from: b.i.b.b.c, reason: use source file name */
/* JADX INFO: compiled from: AbstractListMultimap.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractListMultimap<K, V> extends AbstractMapBasedMultimap2<K, V> implements Multimap {
    private static final long serialVersionUID = 6588350623831699109L;

    public AbstractListMultimap(Map<K, Collection<V>> map) {
        super(map);
    }

    @Override // p007b.p225i.p355b.p357b.AbstractMultimap, p007b.p225i.p355b.p357b.Multimap
    /* JADX INFO: renamed from: a */
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

    @Override // p007b.p225i.p355b.p357b.AbstractMultimap
    public boolean equals(@NullableDecl Object obj) {
        return super.equals(obj);
    }
}

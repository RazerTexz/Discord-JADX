package b.i.b.b;

import b.i.b.b.e;
import java.util.Collection;
import java.util.Map;
import java.util.NavigableMap;
import java.util.SortedMap;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: AbstractListMultimap.java */
/* loaded from: classes3.dex */
public abstract class c<K, V> extends e<K, V> implements b0 {
    private static final long serialVersionUID = 6588350623831699109L;

    public c(Map<K, Collection<V>> map) {
        super(map);
    }

    @Override // b.i.b.b.g, b.i.b.b.b0
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

    @Override // b.i.b.b.g
    public boolean equals(@NullableDecl Object obj) {
        return super.equals(obj);
    }
}

package b.i.b.b;

import b.i.b.b.e;
import b.i.b.b.e.a.C0131a;
import java.util.AbstractMap;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl;

/* compiled from: Maps.java */
/* loaded from: classes3.dex */
public abstract class a0<K, V> extends AbstractMap<K, V> {

    @MonotonicNonNullDecl
    public transient Set<Map.Entry<K, V>> j;

    @MonotonicNonNullDecl
    public transient Collection<V> k;

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        Set<Map.Entry<K, V>> set = this.j;
        if (set != null) {
            return set;
        }
        e.a.C0131a c0131a = ((e.a) this).new C0131a();
        this.j = c0131a;
        return c0131a;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Collection<V> values() {
        Collection<V> collection = this.k;
        if (collection != null) {
            return collection;
        }
        z zVar = new z(this);
        this.k = zVar;
        return zVar;
    }
}

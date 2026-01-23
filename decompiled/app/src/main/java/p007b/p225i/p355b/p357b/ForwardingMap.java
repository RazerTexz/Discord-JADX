package p007b.p225i.p355b.p357b;

import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import p007b.p225i.p355b.p357b.MapMakerInternalMap;

/* JADX INFO: renamed from: b.i.b.b.l, reason: use source file name */
/* JADX INFO: compiled from: ForwardingMap.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class ForwardingMap<K, V> extends ForwardingObject implements Map<K, V> {
    @Override // java.util.Map
    public void clear() {
        ((MapMakerInternalMap.b) this).f12078j.clear();
    }

    @Override // java.util.Map
    public boolean containsKey(@NullableDecl Object obj) {
        return ((MapMakerInternalMap.b) this).f12078j.containsKey(obj);
    }

    @Override // java.util.Map
    public boolean containsValue(@NullableDecl Object obj) {
        return ((MapMakerInternalMap.b) this).f12078j.containsValue(obj);
    }

    @Override // java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        return ((MapMakerInternalMap.b) this).f12078j.entrySet();
    }

    @Override // java.util.Map
    public boolean equals(@NullableDecl Object obj) {
        return obj == this || ((MapMakerInternalMap.b) this).f12078j.equals(obj);
    }

    @Override // java.util.Map
    public V get(@NullableDecl Object obj) {
        return ((MapMakerInternalMap.b) this).f12078j.get(obj);
    }

    @Override // java.util.Map
    public int hashCode() {
        return ((MapMakerInternalMap.b) this).f12078j.hashCode();
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        return ((MapMakerInternalMap.b) this).f12078j.isEmpty();
    }

    @Override // java.util.Map
    public Set<K> keySet() {
        return ((MapMakerInternalMap.b) this).f12078j.keySet();
    }

    @Override // java.util.Map
    @CanIgnoreReturnValue
    public V put(K k, V v) {
        return ((MapMakerInternalMap.b) this).f12078j.put(k, v);
    }

    @Override // java.util.Map
    public void putAll(Map<? extends K, ? extends V> map) {
        ((MapMakerInternalMap.b) this).f12078j.putAll(map);
    }

    @Override // java.util.Map
    @CanIgnoreReturnValue
    public V remove(Object obj) {
        return ((MapMakerInternalMap.b) this).f12078j.remove(obj);
    }

    @Override // java.util.Map
    public int size() {
        return ((MapMakerInternalMap.b) this).f12078j.size();
    }

    @Override // java.util.Map
    public Collection<V> values() {
        return ((MapMakerInternalMap.b) this).f12078j.values();
    }
}

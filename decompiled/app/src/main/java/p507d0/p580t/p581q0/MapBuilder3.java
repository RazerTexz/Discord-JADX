package p507d0.p580t.p581q0;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: MapBuilder.kt */
/* renamed from: d0.t.q0.d, reason: use source file name */
/* loaded from: classes3.dex */
public final class MapBuilder3<K, V> extends MapBuilder<Map.Entry<K, V>, K, V> {

    /* renamed from: j */
    public final MapBuilder2<K, V> f25216j;

    public MapBuilder3(MapBuilder2<K, V> mapBuilder2) {
        Intrinsics3.checkNotNullParameter(mapBuilder2, "backing");
        this.f25216j = mapBuilder2;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public /* bridge */ /* synthetic */ boolean add(Object obj) {
        return add((Map.Entry) obj);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean addAll(Collection<? extends Map.Entry<K, V>> collection) {
        Intrinsics3.checkNotNullParameter(collection, "elements");
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public void clear() {
        this.f25216j.clear();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean containsAll(Collection<? extends Object> collection) {
        Intrinsics3.checkNotNullParameter(collection, "elements");
        return this.f25216j.containsAllEntries$kotlin_stdlib(collection);
    }

    @Override // p507d0.p580t.p581q0.MapBuilder
    public boolean containsEntry(Map.Entry<? extends K, ? extends V> entry) {
        Intrinsics3.checkNotNullParameter(entry, "element");
        return this.f25216j.containsEntry$kotlin_stdlib(entry);
    }

    @Override // p507d0.p580t.AbstractMutableSet
    public int getSize() {
        return this.f25216j.size();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean isEmpty() {
        return this.f25216j.isEmpty();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public Iterator<Map.Entry<K, V>> iterator() {
        return this.f25216j.entriesIterator$kotlin_stdlib();
    }

    @Override // p507d0.p580t.p581q0.MapBuilder
    public boolean remove(Map.Entry entry) {
        Intrinsics3.checkNotNullParameter(entry, "element");
        return this.f25216j.removeEntry$kotlin_stdlib(entry);
    }

    @Override // java.util.AbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean removeAll(Collection<? extends Object> collection) {
        Intrinsics3.checkNotNullParameter(collection, "elements");
        this.f25216j.checkIsMutable$kotlin_stdlib();
        return super.removeAll(collection);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean retainAll(Collection<? extends Object> collection) {
        Intrinsics3.checkNotNullParameter(collection, "elements");
        this.f25216j.checkIsMutable$kotlin_stdlib();
        return super.retainAll(collection);
    }

    public boolean add(Map.Entry<K, V> entry) {
        Intrinsics3.checkNotNullParameter(entry, "element");
        throw new UnsupportedOperationException();
    }
}

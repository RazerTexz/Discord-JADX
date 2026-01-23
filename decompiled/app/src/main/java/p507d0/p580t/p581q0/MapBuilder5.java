package p507d0.p580t.p581q0;

import java.util.Collection;
import java.util.Iterator;
import p507d0.p580t.AbstractMutableCollection;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.p595g0.KMarkers2;

/* JADX INFO: renamed from: d0.t.q0.f, reason: use source file name */
/* JADX INFO: compiled from: MapBuilder.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class MapBuilder5<V> extends AbstractMutableCollection<V> implements Collection<V>, KMarkers2 {

    /* JADX INFO: renamed from: j */
    public final MapBuilder2<?, V> f25218j;

    public MapBuilder5(MapBuilder2<?, V> mapBuilder2) {
        Intrinsics3.checkNotNullParameter(mapBuilder2, "backing");
        this.f25218j = mapBuilder2;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean add(V v) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean addAll(Collection<? extends V> collection) {
        Intrinsics3.checkNotNullParameter(collection, "elements");
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public void clear() {
        this.f25218j.clear();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean contains(Object obj) {
        return this.f25218j.containsValue(obj);
    }

    @Override // p507d0.p580t.AbstractMutableCollection
    public int getSize() {
        return this.f25218j.size();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean isEmpty() {
        return this.f25218j.isEmpty();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public Iterator<V> iterator() {
        return this.f25218j.valuesIterator$kotlin_stdlib();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean remove(Object obj) {
        return this.f25218j.removeValue$kotlin_stdlib(obj);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean removeAll(Collection<? extends Object> collection) {
        Intrinsics3.checkNotNullParameter(collection, "elements");
        this.f25218j.checkIsMutable$kotlin_stdlib();
        return super.removeAll(collection);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean retainAll(Collection<? extends Object> collection) {
        Intrinsics3.checkNotNullParameter(collection, "elements");
        this.f25218j.checkIsMutable$kotlin_stdlib();
        return super.retainAll(collection);
    }
}

package p507d0.p580t.p581q0;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import p507d0.p580t.AbstractMutableSet;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.p595g0.KMarkers5;

/* JADX INFO: renamed from: d0.t.q0.e, reason: use source file name */
/* JADX INFO: compiled from: MapBuilder.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class MapBuilder4<E> extends AbstractMutableSet<E> implements Set<E>, KMarkers5 {

    /* JADX INFO: renamed from: j */
    public final MapBuilder2<E, ?> f25217j;

    public MapBuilder4(MapBuilder2<E, ?> mapBuilder2) {
        Intrinsics3.checkNotNullParameter(mapBuilder2, "backing");
        this.f25217j = mapBuilder2;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean add(E e) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean addAll(Collection<? extends E> collection) {
        Intrinsics3.checkNotNullParameter(collection, "elements");
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public void clear() {
        this.f25217j.clear();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(Object obj) {
        return this.f25217j.containsKey(obj);
    }

    @Override // p507d0.p580t.AbstractMutableSet
    public int getSize() {
        return this.f25217j.size();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean isEmpty() {
        return this.f25217j.isEmpty();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public Iterator<E> iterator() {
        return this.f25217j.keysIterator$kotlin_stdlib();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean remove(Object obj) {
        return this.f25217j.removeKey$kotlin_stdlib(obj) >= 0;
    }

    @Override // java.util.AbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean removeAll(Collection<? extends Object> collection) {
        Intrinsics3.checkNotNullParameter(collection, "elements");
        this.f25217j.checkIsMutable$kotlin_stdlib();
        return super.removeAll(collection);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean retainAll(Collection<? extends Object> collection) {
        Intrinsics3.checkNotNullParameter(collection, "elements");
        this.f25217j.checkIsMutable$kotlin_stdlib();
        return super.retainAll(collection);
    }
}

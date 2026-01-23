package p507d0.p580t;

import java.util.Collection;
import java.util.Iterator;
import p507d0.p592z.p594d.ArrayIterator4;
import p507d0.p592z.p594d.CollectionToArray;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.p595g0.KMarkers;

/* JADX INFO: renamed from: d0.t.g, reason: use source file name */
/* JADX INFO: compiled from: Collections.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class Collections<T> implements Collection<T>, KMarkers {

    /* JADX INFO: renamed from: j */
    public final T[] f25184j;

    /* JADX INFO: renamed from: k */
    public final boolean f25185k;

    public Collections(T[] tArr, boolean z2) {
        Intrinsics3.checkNotNullParameter(tArr, "values");
        this.f25184j = tArr;
        this.f25185k = z2;
    }

    @Override // java.util.Collection
    public boolean add(T t) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean addAll(Collection<? extends T> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean contains(Object obj) {
        return _Arrays.contains(this.f25184j, obj);
    }

    @Override // java.util.Collection
    public boolean containsAll(Collection<? extends Object> collection) {
        Intrinsics3.checkNotNullParameter(collection, "elements");
        if (collection.isEmpty()) {
            return true;
        }
        Iterator<T> it = collection.iterator();
        while (it.hasNext()) {
            if (!contains(it.next())) {
                return false;
            }
        }
        return true;
    }

    public int getSize() {
        return this.f25184j.length;
    }

    @Override // java.util.Collection
    public boolean isEmpty() {
        return this.f25184j.length == 0;
    }

    @Override // java.util.Collection, java.lang.Iterable
    public Iterator<T> iterator() {
        return ArrayIterator4.iterator(this.f25184j);
    }

    @Override // java.util.Collection
    public boolean remove(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean removeAll(Collection<? extends Object> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean retainAll(Collection<? extends Object> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public final /* bridge */ int size() {
        return getSize();
    }

    @Override // java.util.Collection
    public final Object[] toArray() {
        return CollectionsJVM.copyToArrayOfAny(this.f25184j, this.f25185k);
    }

    @Override // java.util.Collection
    public <T> T[] toArray(T[] tArr) {
        return (T[]) CollectionToArray.toArray(this, tArr);
    }
}

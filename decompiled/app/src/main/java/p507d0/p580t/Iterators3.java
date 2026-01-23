package p507d0.p580t;

import java.util.Iterator;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.p595g0.KMarkers;

/* JADX INFO: renamed from: d0.t.b0, reason: use source file name */
/* JADX INFO: compiled from: Iterators.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class Iterators3<T> implements Iterator<IndexedValue<? extends T>>, KMarkers {

    /* JADX INFO: renamed from: j */
    public int f25175j;

    /* JADX INFO: renamed from: k */
    public final Iterator<T> f25176k;

    /* JADX WARN: Multi-variable type inference failed */
    public Iterators3(Iterator<? extends T> it) {
        Intrinsics3.checkNotNullParameter(it, "iterator");
        this.f25176k = it;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f25176k.hasNext();
    }

    @Override // java.util.Iterator
    public /* bridge */ /* synthetic */ Object next() {
        return next();
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Iterator
    public final IndexedValue<T> next() {
        int i = this.f25175j;
        this.f25175j = i + 1;
        if (i < 0) {
            Collections2.throwIndexOverflow();
        }
        return new IndexedValue<>(i, this.f25176k.next());
    }
}

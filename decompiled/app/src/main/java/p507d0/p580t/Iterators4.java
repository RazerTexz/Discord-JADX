package p507d0.p580t;

import java.util.Iterator;
import p507d0.p592z.p594d.p595g0.KMarkers;

/* JADX INFO: renamed from: d0.t.c0, reason: use source file name */
/* JADX INFO: compiled from: Iterators.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class Iterators4 implements Iterator<Integer>, KMarkers {
    @Override // java.util.Iterator
    public /* bridge */ /* synthetic */ Integer next() {
        return next();
    }

    public abstract int nextInt();

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // java.util.Iterator
    public final Integer next() {
        return Integer.valueOf(nextInt());
    }
}

package p007b.p225i.p355b.p357b;

import java.util.NoSuchElementException;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: renamed from: b.i.b.b.s, reason: use source file name */
/* JADX INFO: compiled from: Iterators.java */
/* JADX INFO: loaded from: classes3.dex */
public final class Iterators<T> extends UnmodifiableIterator<T> {

    /* JADX INFO: renamed from: j */
    public boolean f12060j;

    /* JADX INFO: renamed from: k */
    public final /* synthetic */ Object f12061k;

    public Iterators(Object obj) {
        this.f12061k = obj;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return !this.f12060j;
    }

    @Override // java.util.Iterator
    public T next() {
        if (this.f12060j) {
            throw new NoSuchElementException();
        }
        this.f12060j = true;
        return (T) this.f12061k;
    }
}

package p007b.p225i.p355b.p357b;

import java.util.Iterator;
import java.util.NoSuchElementException;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;

/* compiled from: Iterators.java */
/* renamed from: b.i.b.b.t, reason: use source file name */
/* loaded from: classes3.dex */
public enum Iterators2 implements Iterator<Object> {
    INSTANCE;

    @Override // java.util.Iterator
    public boolean hasNext() {
        return false;
    }

    @Override // java.util.Iterator
    public Object next() {
        throw new NoSuchElementException();
    }

    @Override // java.util.Iterator
    public void remove() {
        C3404f.m4201E(false);
    }
}

package p507d0.p580t;

import java.util.Iterator;
import java.util.NoSuchElementException;
import p007b.p085c.p086a.p095y.C1563b;
import p507d0.p592z.p594d.p595g0.KMarkers;

/* compiled from: AbstractIterator.kt */
/* renamed from: d0.t.b, reason: use source file name */
/* loaded from: classes3.dex */
public abstract class AbstractIterator3<T> implements Iterator<T>, KMarkers {

    /* renamed from: j */
    public int f25173j = 2;

    /* renamed from: k */
    public T f25174k;

    /* renamed from: a */
    public abstract void mo10059a();

    /* renamed from: b */
    public final void m10074b(T t) {
        this.f25174k = t;
        this.f25173j = 1;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        int i = this.f25173j;
        if (!(i != 4)) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        int iM758h = C1563b.m758h(i);
        if (iM758h != 0) {
            if (iM758h == 2) {
                return false;
            }
            this.f25173j = 4;
            mo10059a();
            if (this.f25173j != 1) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.Iterator
    public T next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        this.f25173j = 2;
        return this.f25174k;
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}

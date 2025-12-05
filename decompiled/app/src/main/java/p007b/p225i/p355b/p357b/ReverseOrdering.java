package p007b.p225i.p355b.p357b;

import java.io.Serializable;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: ReverseOrdering.java */
/* renamed from: b.i.b.b.l0, reason: use source file name */
/* loaded from: classes3.dex */
public final class ReverseOrdering<T> extends Ordering<T> implements Serializable {
    private static final long serialVersionUID = 0;
    public final Ordering<? super T> forwardOrder;

    public ReverseOrdering(Ordering<? super T> ordering) {
        this.forwardOrder = ordering;
    }

    @Override // p007b.p225i.p355b.p357b.Ordering
    /* renamed from: b */
    public <S extends T> Ordering<S> mo6236b() {
        return this.forwardOrder;
    }

    @Override // p007b.p225i.p355b.p357b.Ordering, java.util.Comparator
    public int compare(T t, T t2) {
        return this.forwardOrder.compare(t2, t);
    }

    @Override // java.util.Comparator
    public boolean equals(@NullableDecl Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ReverseOrdering) {
            return this.forwardOrder.equals(((ReverseOrdering) obj).forwardOrder);
        }
        return false;
    }

    public int hashCode() {
        return -this.forwardOrder.hashCode();
    }

    public String toString() {
        return this.forwardOrder + ".reverse()";
    }
}

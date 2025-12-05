package p007b.p225i.p355b.p357b;

import java.io.Serializable;
import java.util.Objects;

/* compiled from: ReverseNaturalOrdering.java */
/* renamed from: b.i.b.b.k0, reason: use source file name */
/* loaded from: classes3.dex */
public final class ReverseNaturalOrdering extends Ordering<Comparable> implements Serializable {

    /* renamed from: j */
    public static final ReverseNaturalOrdering f12038j = new ReverseNaturalOrdering();
    private static final long serialVersionUID = 0;

    private Object readResolve() {
        return f12038j;
    }

    @Override // p007b.p225i.p355b.p357b.Ordering
    /* renamed from: b */
    public <S extends Comparable> Ordering<S> mo6236b() {
        return NaturalOrdering.f12005j;
    }

    @Override // p007b.p225i.p355b.p357b.Ordering, java.util.Comparator
    public int compare(Object obj, Object obj2) {
        Comparable comparable = (Comparable) obj;
        Comparable comparable2 = (Comparable) obj2;
        Objects.requireNonNull(comparable);
        if (comparable == comparable2) {
            return 0;
        }
        return comparable2.compareTo(comparable);
    }

    public String toString() {
        return "Ordering.natural().reverse()";
    }
}

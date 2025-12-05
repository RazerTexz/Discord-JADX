package p007b.p225i.p355b.p357b;

import java.io.Serializable;
import java.util.Objects;

/* compiled from: NaturalOrdering.java */
/* renamed from: b.i.b.b.f0, reason: use source file name */
/* loaded from: classes3.dex */
public final class NaturalOrdering extends Ordering<Comparable> implements Serializable {

    /* renamed from: j */
    public static final NaturalOrdering f12005j = new NaturalOrdering();
    private static final long serialVersionUID = 0;

    private Object readResolve() {
        return f12005j;
    }

    @Override // p007b.p225i.p355b.p357b.Ordering
    /* renamed from: b */
    public <S extends Comparable> Ordering<S> mo6236b() {
        return ReverseNaturalOrdering.f12038j;
    }

    @Override // p007b.p225i.p355b.p357b.Ordering, java.util.Comparator
    public int compare(Object obj, Object obj2) {
        Comparable comparable = (Comparable) obj;
        Comparable comparable2 = (Comparable) obj2;
        Objects.requireNonNull(comparable);
        Objects.requireNonNull(comparable2);
        return comparable.compareTo(comparable2);
    }

    public String toString() {
        return "Ordering.natural()";
    }
}

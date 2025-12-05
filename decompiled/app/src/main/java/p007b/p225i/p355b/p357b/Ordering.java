package p007b.p225i.p355b.p357b;

import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Comparator;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: Ordering.java */
/* renamed from: b.i.b.b.g0, reason: use source file name */
/* loaded from: classes3.dex */
public abstract class Ordering<T> implements Comparator<T> {
    /* renamed from: a */
    public static <T> Ordering<T> m6237a(Comparator<T> comparator) {
        return comparator instanceof Ordering ? (Ordering) comparator : new ComparatorOrdering(comparator);
    }

    /* renamed from: b */
    public <S extends T> Ordering<S> mo6236b() {
        return new ReverseOrdering(this);
    }

    @Override // java.util.Comparator
    @CanIgnoreReturnValue
    public abstract int compare(@NullableDecl T t, @NullableDecl T t2);
}

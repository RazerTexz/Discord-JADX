package d0.d0;

import d0.z.d.m;
import java.lang.Comparable;

/* compiled from: Range.kt */
/* loaded from: classes3.dex */
public interface a<T extends Comparable<? super T>> {

    /* compiled from: Range.kt */
    /* renamed from: d0.d0.a$a, reason: collision with other inner class name */
    public static final class C0493a {
        public static <T extends Comparable<? super T>> boolean contains(a<T> aVar, T t) {
            m.checkNotNullParameter(t, "value");
            return t.compareTo(aVar.getStart()) >= 0 && t.compareTo(aVar.getEndInclusive()) <= 0;
        }

        public static <T extends Comparable<? super T>> boolean isEmpty(a<T> aVar) {
            return aVar.getStart().compareTo(aVar.getEndInclusive()) > 0;
        }
    }

    boolean contains(T t);

    T getEndInclusive();

    T getStart();
}

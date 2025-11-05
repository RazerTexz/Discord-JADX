package androidx.core.util;

import android.util.Range;
import androidx.annotation.RequiresApi;
import androidx.exifinterface.media.ExifInterface;
import d0.d0.a;
import d0.z.d.m;

/* compiled from: Range.kt */
/* loaded from: classes.dex */
public final class RangeKt {

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: Range.kt */
    /* renamed from: androidx.core.util.RangeKt$toClosedRange$1, reason: invalid class name */
    public static final class AnonymousClass1<T> implements a<T> {
        public final /* synthetic */ Range<T> $this_toClosedRange;

        public AnonymousClass1(Range<T> range) {
            this.$this_toClosedRange = range;
        }

        /* JADX WARN: Incorrect types in method signature: (TT;)Z */
        @Override // d0.d0.a
        public boolean contains(Comparable comparable) {
            return a.C0493a.contains(this, comparable);
        }

        /* JADX WARN: Incorrect return type in method signature: ()TT; */
        @Override // d0.d0.a
        public Comparable getEndInclusive() {
            return this.$this_toClosedRange.getUpper();
        }

        /* JADX WARN: Incorrect return type in method signature: ()TT; */
        @Override // d0.d0.a
        public Comparable getStart() {
            return this.$this_toClosedRange.getLower();
        }

        public boolean isEmpty() {
            return a.C0493a.isEmpty(this);
        }
    }

    @RequiresApi(21)
    public static final <T extends Comparable<? super T>> Range<T> and(Range<T> range, Range<T> range2) {
        m.checkNotNullParameter(range, "<this>");
        m.checkNotNullParameter(range2, "other");
        Range<T> rangeIntersect = range.intersect(range2);
        m.checkNotNullExpressionValue(rangeIntersect, "intersect(other)");
        return rangeIntersect;
    }

    @RequiresApi(21)
    public static final <T extends Comparable<? super T>> Range<T> plus(Range<T> range, T t) {
        m.checkNotNullParameter(range, "<this>");
        m.checkNotNullParameter(t, "value");
        Range<T> rangeExtend = range.extend((Range<T>) t);
        m.checkNotNullExpressionValue(rangeExtend, "extend(value)");
        return rangeExtend;
    }

    @RequiresApi(21)
    public static final <T extends Comparable<? super T>> Range<T> rangeTo(T t, T t2) {
        m.checkNotNullParameter(t, "<this>");
        m.checkNotNullParameter(t2, "that");
        return new Range<>(t, t2);
    }

    @RequiresApi(21)
    public static final <T extends Comparable<? super T>> a<T> toClosedRange(Range<T> range) {
        m.checkNotNullParameter(range, "<this>");
        return new AnonymousClass1(range);
    }

    @RequiresApi(21)
    public static final <T extends Comparable<? super T>> Range<T> toRange(a<T> aVar) {
        m.checkNotNullParameter(aVar, "<this>");
        return new Range<>(aVar.getStart(), aVar.getEndInclusive());
    }

    @RequiresApi(21)
    public static final <T extends Comparable<? super T>> Range<T> plus(Range<T> range, Range<T> range2) {
        m.checkNotNullParameter(range, "<this>");
        m.checkNotNullParameter(range2, "other");
        Range<T> rangeExtend = range.extend(range2);
        m.checkNotNullExpressionValue(rangeExtend, "extend(other)");
        return rangeExtend;
    }
}

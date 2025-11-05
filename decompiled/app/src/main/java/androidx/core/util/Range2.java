package androidx.core.util;

import android.util.Range;
import androidx.annotation.RequiresApi;
import androidx.exifinterface.media.ExifInterface;
import d0.d0.Range3;
import d0.z.d.Intrinsics3;

/* compiled from: Range.kt */
/* renamed from: androidx.core.util.RangeKt, reason: use source file name */
/* loaded from: classes.dex */
public final class Range2 {

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: Range.kt */
    /* renamed from: androidx.core.util.RangeKt$toClosedRange$1, reason: invalid class name */
    public static final class AnonymousClass1<T> implements Range3<T> {
        public final /* synthetic */ Range<T> $this_toClosedRange;

        public AnonymousClass1(Range<T> range) {
            this.$this_toClosedRange = range;
        }

        /* JADX WARN: Incorrect types in method signature: (TT;)Z */
        @Override // d0.d0.Range3
        public boolean contains(Comparable comparable) {
            return Range3.a.contains(this, comparable);
        }

        /* JADX WARN: Incorrect return type in method signature: ()TT; */
        @Override // d0.d0.Range3
        public Comparable getEndInclusive() {
            return this.$this_toClosedRange.getUpper();
        }

        /* JADX WARN: Incorrect return type in method signature: ()TT; */
        @Override // d0.d0.Range3
        public Comparable getStart() {
            return this.$this_toClosedRange.getLower();
        }

        public boolean isEmpty() {
            return Range3.a.isEmpty(this);
        }
    }

    @RequiresApi(21)
    public static final <T extends Comparable<? super T>> Range<T> and(Range<T> range, Range<T> range2) {
        Intrinsics3.checkNotNullParameter(range, "<this>");
        Intrinsics3.checkNotNullParameter(range2, "other");
        Range<T> rangeIntersect = range.intersect(range2);
        Intrinsics3.checkNotNullExpressionValue(rangeIntersect, "intersect(other)");
        return rangeIntersect;
    }

    @RequiresApi(21)
    public static final <T extends Comparable<? super T>> Range<T> plus(Range<T> range, T t) {
        Intrinsics3.checkNotNullParameter(range, "<this>");
        Intrinsics3.checkNotNullParameter(t, "value");
        Range<T> rangeExtend = range.extend((Range<T>) t);
        Intrinsics3.checkNotNullExpressionValue(rangeExtend, "extend(value)");
        return rangeExtend;
    }

    @RequiresApi(21)
    public static final <T extends Comparable<? super T>> Range<T> rangeTo(T t, T t2) {
        Intrinsics3.checkNotNullParameter(t, "<this>");
        Intrinsics3.checkNotNullParameter(t2, "that");
        return new Range<>(t, t2);
    }

    @RequiresApi(21)
    public static final <T extends Comparable<? super T>> Range3<T> toClosedRange(Range<T> range) {
        Intrinsics3.checkNotNullParameter(range, "<this>");
        return new AnonymousClass1(range);
    }

    @RequiresApi(21)
    public static final <T extends Comparable<? super T>> Range<T> toRange(Range3<T> range3) {
        Intrinsics3.checkNotNullParameter(range3, "<this>");
        return new Range<>(range3.getStart(), range3.getEndInclusive());
    }

    @RequiresApi(21)
    public static final <T extends Comparable<? super T>> Range<T> plus(Range<T> range, Range<T> range2) {
        Intrinsics3.checkNotNullParameter(range, "<this>");
        Intrinsics3.checkNotNullParameter(range2, "other");
        Range<T> rangeExtend = range.extend(range2);
        Intrinsics3.checkNotNullExpressionValue(rangeExtend, "extend(other)");
        return rangeExtend;
    }
}

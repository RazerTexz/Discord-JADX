package kotlin.ranges;

import d0.d0.a;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: Ranges.kt */
/* loaded from: classes3.dex */
public final class IntRange extends IntProgression implements a<Integer> {

    /* renamed from: o, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final IntRange n = new IntRange(1, 0);

    /* compiled from: Ranges.kt */
    /* renamed from: kotlin.ranges.IntRange$a, reason: from kotlin metadata */
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
        }

        public final IntRange getEMPTY() {
            return IntRange.access$getEMPTY$cp();
        }
    }

    public IntRange(int i, int i2) {
        super(i, i2, 1);
    }

    public static final /* synthetic */ IntRange access$getEMPTY$cp() {
        return n;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // d0.d0.a
    public /* bridge */ /* synthetic */ boolean contains(Comparable comparable) {
        return contains(((Number) comparable).intValue());
    }

    @Override // kotlin.ranges.IntProgression
    public boolean equals(Object other) {
        if (other instanceof IntRange) {
            if (!isEmpty() || !((IntRange) other).isEmpty()) {
                IntRange intRange = (IntRange) other;
                if (getFirst() != intRange.getFirst() || getLast() != intRange.getLast()) {
                }
            }
            return true;
        }
        return false;
    }

    @Override // d0.d0.a
    public /* bridge */ /* synthetic */ Comparable getEndInclusive() {
        return getEndInclusive();
    }

    @Override // d0.d0.a
    public /* bridge */ /* synthetic */ Comparable getStart() {
        return getStart();
    }

    @Override // kotlin.ranges.IntProgression
    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (getFirst() * 31) + getLast();
    }

    @Override // kotlin.ranges.IntProgression
    public boolean isEmpty() {
        return getFirst() > getLast();
    }

    @Override // kotlin.ranges.IntProgression
    public String toString() {
        return getFirst() + ".." + getLast();
    }

    public boolean contains(int value) {
        return getFirst() <= value && value <= getLast();
    }

    @Override // d0.d0.a
    public Integer getEndInclusive() {
        return Integer.valueOf(getLast());
    }

    @Override // d0.d0.a
    public Integer getStart() {
        return Integer.valueOf(getFirst());
    }
}

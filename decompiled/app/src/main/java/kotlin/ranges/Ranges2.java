package kotlin.ranges;

import d0.d0.Range3;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: Ranges.kt */
/* renamed from: kotlin.ranges.IntRange, reason: use source file name */
/* loaded from: classes3.dex */
public final class Ranges2 extends Progressions2 implements Range3<Integer> {

    /* renamed from: o, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final Ranges2 n = new Ranges2(1, 0);

    /* compiled from: Ranges.kt */
    /* renamed from: kotlin.ranges.IntRange$a, reason: from kotlin metadata */
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
        }

        public final Ranges2 getEMPTY() {
            return Ranges2.access$getEMPTY$cp();
        }
    }

    public Ranges2(int i, int i2) {
        super(i, i2, 1);
    }

    public static final /* synthetic */ Ranges2 access$getEMPTY$cp() {
        return n;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // d0.d0.Range3
    public /* bridge */ /* synthetic */ boolean contains(Comparable comparable) {
        return contains(((Number) comparable).intValue());
    }

    @Override // kotlin.ranges.Progressions2
    public boolean equals(Object other) {
        if (other instanceof Ranges2) {
            if (!isEmpty() || !((Ranges2) other).isEmpty()) {
                Ranges2 ranges2 = (Ranges2) other;
                if (getFirst() != ranges2.getFirst() || getLast() != ranges2.getLast()) {
                }
            }
            return true;
        }
        return false;
    }

    @Override // d0.d0.Range3
    public /* bridge */ /* synthetic */ Comparable getEndInclusive() {
        return getEndInclusive();
    }

    @Override // d0.d0.Range3
    public /* bridge */ /* synthetic */ Comparable getStart() {
        return getStart();
    }

    @Override // kotlin.ranges.Progressions2
    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (getFirst() * 31) + getLast();
    }

    @Override // kotlin.ranges.Progressions2
    public boolean isEmpty() {
        return getFirst() > getLast();
    }

    @Override // kotlin.ranges.Progressions2
    public String toString() {
        return getFirst() + ".." + getLast();
    }

    public boolean contains(int value) {
        return getFirst() <= value && value <= getLast();
    }

    @Override // d0.d0.Range3
    public Integer getEndInclusive() {
        return Integer.valueOf(getLast());
    }

    @Override // d0.d0.Range3
    public Integer getStart() {
        return Integer.valueOf(getFirst());
    }
}

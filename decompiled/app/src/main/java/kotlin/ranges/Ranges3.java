package kotlin.ranges;

import d0.d0.Progressions;
import d0.d0.Range3;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: Ranges.kt */
/* renamed from: kotlin.ranges.LongRange, reason: use source file name */
/* loaded from: classes3.dex */
public final class Ranges3 extends Progressions implements Range3<Long> {

    /* renamed from: n, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final Ranges3 m = new Ranges3(1, 0);

    /* compiled from: Ranges.kt */
    /* renamed from: kotlin.ranges.LongRange$a, reason: from kotlin metadata */
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
        }

        public final Ranges3 getEMPTY() {
            return Ranges3.access$getEMPTY$cp();
        }
    }

    public Ranges3(long j, long j2) {
        super(j, j2, 1L);
    }

    public static final /* synthetic */ Ranges3 access$getEMPTY$cp() {
        return m;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // d0.d0.Range3
    public /* bridge */ /* synthetic */ boolean contains(Comparable comparable) {
        return contains(((Number) comparable).longValue());
    }

    public boolean equals(Object other) {
        if (other instanceof Ranges3) {
            if (!isEmpty() || !((Ranges3) other).isEmpty()) {
                Ranges3 ranges3 = (Ranges3) other;
                if (getFirst() != ranges3.getFirst() || getLast() != ranges3.getLast()) {
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

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (int) ((31 * (getFirst() ^ (getFirst() >>> 32))) + (getLast() ^ (getLast() >>> 32)));
    }

    public boolean isEmpty() {
        return getFirst() > getLast();
    }

    public String toString() {
        return getFirst() + ".." + getLast();
    }

    public boolean contains(long value) {
        return getFirst() <= value && value <= getLast();
    }

    @Override // d0.d0.Range3
    public Long getEndInclusive() {
        return Long.valueOf(getLast());
    }

    @Override // d0.d0.Range3
    public Long getStart() {
        return Long.valueOf(getFirst());
    }
}

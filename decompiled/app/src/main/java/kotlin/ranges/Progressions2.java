package kotlin.ranges;

import java.util.Iterator;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p507d0.p512d0.ProgressionIterators;
import p507d0.p588x.progressionUtil;
import p507d0.p592z.p594d.p595g0.KMarkers;

/* compiled from: Progressions.kt */
/* renamed from: kotlin.ranges.IntProgression, reason: use source file name */
/* loaded from: classes3.dex */
public class Progressions2 implements Iterable<Integer>, KMarkers {

    /* renamed from: j, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: k, reason: from kotlin metadata */
    public final int first;

    /* renamed from: l, reason: from kotlin metadata */
    public final int last;

    /* renamed from: m, reason: from kotlin metadata */
    public final int step;

    /* compiled from: Progressions.kt */
    /* renamed from: kotlin.ranges.IntProgression$a, reason: from kotlin metadata */
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
        }

        public final Progressions2 fromClosedRange(int i, int i2, int i3) {
            return new Progressions2(i, i2, i3);
        }
    }

    public Progressions2(int i, int i2, int i3) {
        if (i3 == 0) {
            throw new IllegalArgumentException("Step must be non-zero.");
        }
        if (i3 == Integer.MIN_VALUE) {
            throw new IllegalArgumentException("Step must be greater than Int.MIN_VALUE to avoid overflow on negation.");
        }
        this.first = i;
        this.last = progressionUtil.getProgressionLastElement(i, i2, i3);
        this.step = i3;
    }

    public boolean equals(Object other) {
        if (other instanceof Progressions2) {
            if (!isEmpty() || !((Progressions2) other).isEmpty()) {
                Progressions2 progressions2 = (Progressions2) other;
                if (this.first != progressions2.first || this.last != progressions2.last || this.step != progressions2.step) {
                }
            }
            return true;
        }
        return false;
    }

    public final int getFirst() {
        return this.first;
    }

    public final int getLast() {
        return this.last;
    }

    public final int getStep() {
        return this.step;
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (((this.first * 31) + this.last) * 31) + this.step;
    }

    public boolean isEmpty() {
        if (this.step > 0) {
            if (this.first > this.last) {
                return true;
            }
        } else if (this.first < this.last) {
            return true;
        }
        return false;
    }

    @Override // java.lang.Iterable
    /* renamed from: iterator, reason: avoid collision after fix types in other method */
    public /* bridge */ /* synthetic */ Iterator<Integer> iterator2() {
        return iterator();
    }

    public String toString() {
        StringBuilder sb;
        int i;
        if (this.step > 0) {
            sb = new StringBuilder();
            sb.append(this.first);
            sb.append("..");
            sb.append(this.last);
            sb.append(" step ");
            i = this.step;
        } else {
            sb = new StringBuilder();
            sb.append(this.first);
            sb.append(" downTo ");
            sb.append(this.last);
            sb.append(" step ");
            i = -this.step;
        }
        sb.append(i);
        return sb.toString();
    }

    @Override // java.lang.Iterable
    public Iterator<Integer> iterator() {
        return new ProgressionIterators(this.first, this.last, this.step);
    }
}

package kotlin;

import androidx.exifinterface.media.ExifInterface;
import b.d.b.a.outline;
import d0.z.d.Intrinsics3;
import java.io.Serializable;

/* compiled from: Tuples.kt */
/* renamed from: kotlin.Triple, reason: use source file name */
/* loaded from: classes3.dex */
public final /* data */ class Tuples3<A, B, C> implements Serializable {
    private final A first;
    private final B second;
    private final C third;

    public Tuples3(A a, B b2, C c) {
        this.first = a;
        this.second = b2;
        this.third = c;
    }

    public final A component1() {
        return this.first;
    }

    public final B component2() {
        return this.second;
    }

    public final C component3() {
        return this.third;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Tuples3)) {
            return false;
        }
        Tuples3 tuples3 = (Tuples3) other;
        return Intrinsics3.areEqual(this.first, tuples3.first) && Intrinsics3.areEqual(this.second, tuples3.second) && Intrinsics3.areEqual(this.third, tuples3.third);
    }

    public final C getThird() {
        return this.third;
    }

    public int hashCode() {
        A a = this.first;
        int iHashCode = (a != null ? a.hashCode() : 0) * 31;
        B b2 = this.second;
        int iHashCode2 = (iHashCode + (b2 != null ? b2.hashCode() : 0)) * 31;
        C c = this.third;
        return iHashCode2 + (c != null ? c.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbQ = outline.Q('(');
        sbQ.append(this.first);
        sbQ.append(", ");
        sbQ.append(this.second);
        sbQ.append(", ");
        sbQ.append(this.third);
        sbQ.append(')');
        return sbQ.toString();
    }
}

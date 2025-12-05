package p507d0.p579g0;

import kotlin.ranges.Ranges2;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: Regex.kt */
/* renamed from: d0.g0.e, reason: use source file name */
/* loaded from: classes3.dex */
public final class Regex2 {

    /* renamed from: a */
    public final String f25150a;

    /* renamed from: b */
    public final Ranges2 f25151b;

    public Regex2(String str, Ranges2 ranges2) {
        Intrinsics3.checkNotNullParameter(str, "value");
        Intrinsics3.checkNotNullParameter(ranges2, "range");
        this.f25150a = str;
        this.f25151b = ranges2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Regex2)) {
            return false;
        }
        Regex2 regex2 = (Regex2) obj;
        return Intrinsics3.areEqual(this.f25150a, regex2.f25150a) && Intrinsics3.areEqual(this.f25151b, regex2.f25151b);
    }

    public final Ranges2 getRange() {
        return this.f25151b;
    }

    public final String getValue() {
        return this.f25150a;
    }

    public int hashCode() {
        String str = this.f25150a;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        Ranges2 ranges2 = this.f25151b;
        return iHashCode + (ranges2 != null ? ranges2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = outline.m833U("MatchGroup(value=");
        sbM833U.append(this.f25150a);
        sbM833U.append(", range=");
        sbM833U.append(this.f25151b);
        sbM833U.append(")");
        return sbM833U.toString();
    }
}

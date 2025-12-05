package p507d0.p513e0.p514p.p515d.p517m0.p576p;

import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: numbers.kt */
/* renamed from: d0.e0.p.d.m0.p.f, reason: use source file name */
/* loaded from: classes3.dex */
public final class numbers {

    /* renamed from: a */
    public final String f24991a;

    /* renamed from: b */
    public final int f24992b;

    public numbers(String str, int i) {
        Intrinsics3.checkNotNullParameter(str, "number");
        this.f24991a = str;
        this.f24992b = i;
    }

    public final String component1() {
        return this.f24991a;
    }

    public final int component2() {
        return this.f24992b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof numbers)) {
            return false;
        }
        numbers numbersVar = (numbers) obj;
        return Intrinsics3.areEqual(this.f24991a, numbersVar.f24991a) && this.f24992b == numbersVar.f24992b;
    }

    public int hashCode() {
        return (this.f24991a.hashCode() * 31) + this.f24992b;
    }

    public String toString() {
        StringBuilder sbM833U = outline.m833U("NumberWithRadix(number=");
        sbM833U.append(this.f24991a);
        sbM833U.append(", radix=");
        return outline.m813A(sbM833U, this.f24992b, ')');
    }
}

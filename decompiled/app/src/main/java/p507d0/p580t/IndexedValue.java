package p507d0.p580t;

import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: IndexedValue.kt */
/* renamed from: d0.t.z, reason: use source file name */
/* loaded from: classes3.dex */
public final class IndexedValue<T> {

    /* renamed from: a */
    public final int f25224a;

    /* renamed from: b */
    public final T f25225b;

    public IndexedValue(int i, T t) {
        this.f25224a = i;
        this.f25225b = t;
    }

    public final int component1() {
        return this.f25224a;
    }

    public final T component2() {
        return this.f25225b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof IndexedValue)) {
            return false;
        }
        IndexedValue indexedValue = (IndexedValue) obj;
        return this.f25224a == indexedValue.f25224a && Intrinsics3.areEqual(this.f25225b, indexedValue.f25225b);
    }

    public final int getIndex() {
        return this.f25224a;
    }

    public final T getValue() {
        return this.f25225b;
    }

    public int hashCode() {
        int i = this.f25224a * 31;
        T t = this.f25225b;
        return i + (t != null ? t.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = outline.m833U("IndexedValue(index=");
        sbM833U.append(this.f25224a);
        sbM833U.append(", value=");
        sbM833U.append(this.f25225b);
        sbM833U.append(")");
        return sbM833U.toString();
    }
}

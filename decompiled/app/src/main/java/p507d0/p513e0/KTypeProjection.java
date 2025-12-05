package p507d0.p513e0;

import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KType;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: KTypeProjection.kt */
/* renamed from: d0.e0.i, reason: use source file name */
/* loaded from: classes3.dex */
public final class KTypeProjection {

    /* renamed from: c */
    public final KVariance f22302c;

    /* renamed from: d */
    public final KType f22303d;

    /* renamed from: b */
    public static final a f22301b = new a(null);

    /* renamed from: a */
    public static final KTypeProjection f22300a = new KTypeProjection(null, null);

    /* compiled from: KTypeProjection.kt */
    /* renamed from: d0.e0.i$a */
    public static final class a {
        public a(DefaultConstructorMarker defaultConstructorMarker) {
        }

        public final KTypeProjection contravariant(KType kType) {
            Intrinsics3.checkNotNullParameter(kType, "type");
            return new KTypeProjection(KVariance.IN, kType);
        }

        public final KTypeProjection covariant(KType kType) {
            Intrinsics3.checkNotNullParameter(kType, "type");
            return new KTypeProjection(KVariance.OUT, kType);
        }

        public final KTypeProjection getSTAR() {
            return KTypeProjection.f22300a;
        }

        public final KTypeProjection invariant(KType kType) {
            Intrinsics3.checkNotNullParameter(kType, "type");
            return new KTypeProjection(KVariance.INVARIANT, kType);
        }
    }

    public KTypeProjection(KVariance kVariance, KType kType) {
        String str;
        this.f22302c = kVariance;
        this.f22303d = kType;
        if ((kVariance == null) == (kType == null)) {
            return;
        }
        if (kVariance == null) {
            str = "Star projection must have no type specified.";
        } else {
            str = "The projection variance " + kVariance + " requires type to be specified.";
        }
        throw new IllegalArgumentException(str.toString());
    }

    public final KVariance component1() {
        return this.f22302c;
    }

    public final KType component2() {
        return this.f22303d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof KTypeProjection)) {
            return false;
        }
        KTypeProjection kTypeProjection = (KTypeProjection) obj;
        return Intrinsics3.areEqual(this.f22302c, kTypeProjection.f22302c) && Intrinsics3.areEqual(this.f22303d, kTypeProjection.f22303d);
    }

    public final KType getType() {
        return this.f22303d;
    }

    public final KVariance getVariance() {
        return this.f22302c;
    }

    public int hashCode() {
        KVariance kVariance = this.f22302c;
        int iHashCode = (kVariance != null ? kVariance.hashCode() : 0) * 31;
        KType kType = this.f22303d;
        return iHashCode + (kType != null ? kType.hashCode() : 0);
    }

    public String toString() {
        KVariance kVariance = this.f22302c;
        if (kVariance == null) {
            return "*";
        }
        int iOrdinal = kVariance.ordinal();
        if (iOrdinal == 0) {
            return String.valueOf(this.f22303d);
        }
        if (iOrdinal == 1) {
            StringBuilder sbM833U = outline.m833U("in ");
            sbM833U.append(this.f22303d);
            return sbM833U.toString();
        }
        if (iOrdinal != 2) {
            throw new NoWhenBranchMatchedException();
        }
        StringBuilder sbM833U2 = outline.m833U("out ");
        sbM833U2.append(this.f22303d);
        return sbM833U2.toString();
    }
}

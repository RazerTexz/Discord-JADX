package p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p540l0;

import kotlin.jvm.internal.DefaultConstructorMarker;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: NullabilityQualifierWithMigrationStatus.kt */
/* renamed from: d0.e0.p.d.m0.e.a.l0.i, reason: use source file name */
/* loaded from: classes3.dex */
public final class NullabilityQualifierWithMigrationStatus {

    /* renamed from: a */
    public final typeQualifiers3 f23464a;

    /* renamed from: b */
    public final boolean f23465b;

    public NullabilityQualifierWithMigrationStatus(typeQualifiers3 typequalifiers3, boolean z2) {
        Intrinsics3.checkNotNullParameter(typequalifiers3, "qualifier");
        this.f23464a = typequalifiers3;
        this.f23465b = z2;
    }

    public static /* synthetic */ NullabilityQualifierWithMigrationStatus copy$default(NullabilityQualifierWithMigrationStatus nullabilityQualifierWithMigrationStatus, typeQualifiers3 typequalifiers3, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            typequalifiers3 = nullabilityQualifierWithMigrationStatus.f23464a;
        }
        if ((i & 2) != 0) {
            z2 = nullabilityQualifierWithMigrationStatus.f23465b;
        }
        return nullabilityQualifierWithMigrationStatus.copy(typequalifiers3, z2);
    }

    public final NullabilityQualifierWithMigrationStatus copy(typeQualifiers3 typequalifiers3, boolean z2) {
        Intrinsics3.checkNotNullParameter(typequalifiers3, "qualifier");
        return new NullabilityQualifierWithMigrationStatus(typequalifiers3, z2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof NullabilityQualifierWithMigrationStatus)) {
            return false;
        }
        NullabilityQualifierWithMigrationStatus nullabilityQualifierWithMigrationStatus = (NullabilityQualifierWithMigrationStatus) obj;
        return this.f23464a == nullabilityQualifierWithMigrationStatus.f23464a && this.f23465b == nullabilityQualifierWithMigrationStatus.f23465b;
    }

    public final typeQualifiers3 getQualifier() {
        return this.f23464a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int iHashCode = this.f23464a.hashCode() * 31;
        boolean z2 = this.f23465b;
        int i = z2;
        if (z2 != 0) {
            i = 1;
        }
        return iHashCode + i;
    }

    public final boolean isForWarningOnly() {
        return this.f23465b;
    }

    public String toString() {
        StringBuilder sbM833U = outline.m833U("NullabilityQualifierWithMigrationStatus(qualifier=");
        sbM833U.append(this.f23464a);
        sbM833U.append(", isForWarningOnly=");
        sbM833U.append(this.f23465b);
        sbM833U.append(')');
        return sbM833U.toString();
    }

    public /* synthetic */ NullabilityQualifierWithMigrationStatus(typeQualifiers3 typequalifiers3, boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(typequalifiers3, (i & 2) != 0 ? false : z2);
    }
}

package p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a;

import java.util.Collection;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p540l0.NullabilityQualifierWithMigrationStatus;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p540l0.typeQualifiers3;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: AnnotationQualifiersFqNames.kt */
/* renamed from: d0.e0.p.d.m0.e.a.u, reason: use source file name */
/* loaded from: classes3.dex */
public final class AnnotationQualifiersFqNames2 {

    /* renamed from: a */
    public final NullabilityQualifierWithMigrationStatus f23522a;

    /* renamed from: b */
    public final Collection<AnnotationQualifierApplicabilityType> f23523b;

    /* renamed from: c */
    public final boolean f23524c;

    /* JADX WARN: Multi-variable type inference failed */
    public AnnotationQualifiersFqNames2(NullabilityQualifierWithMigrationStatus nullabilityQualifierWithMigrationStatus, Collection<? extends AnnotationQualifierApplicabilityType> collection, boolean z2) {
        Intrinsics3.checkNotNullParameter(nullabilityQualifierWithMigrationStatus, "nullabilityQualifier");
        Intrinsics3.checkNotNullParameter(collection, "qualifierApplicabilityTypes");
        this.f23522a = nullabilityQualifierWithMigrationStatus;
        this.f23523b = collection;
        this.f23524c = z2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ AnnotationQualifiersFqNames2 copy$default(AnnotationQualifiersFqNames2 annotationQualifiersFqNames2, NullabilityQualifierWithMigrationStatus nullabilityQualifierWithMigrationStatus, Collection collection, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            nullabilityQualifierWithMigrationStatus = annotationQualifiersFqNames2.f23522a;
        }
        if ((i & 2) != 0) {
            collection = annotationQualifiersFqNames2.f23523b;
        }
        if ((i & 4) != 0) {
            z2 = annotationQualifiersFqNames2.f23524c;
        }
        return annotationQualifiersFqNames2.copy(nullabilityQualifierWithMigrationStatus, collection, z2);
    }

    public final AnnotationQualifiersFqNames2 copy(NullabilityQualifierWithMigrationStatus nullabilityQualifierWithMigrationStatus, Collection<? extends AnnotationQualifierApplicabilityType> collection, boolean z2) {
        Intrinsics3.checkNotNullParameter(nullabilityQualifierWithMigrationStatus, "nullabilityQualifier");
        Intrinsics3.checkNotNullParameter(collection, "qualifierApplicabilityTypes");
        return new AnnotationQualifiersFqNames2(nullabilityQualifierWithMigrationStatus, collection, z2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AnnotationQualifiersFqNames2)) {
            return false;
        }
        AnnotationQualifiersFqNames2 annotationQualifiersFqNames2 = (AnnotationQualifiersFqNames2) obj;
        return Intrinsics3.areEqual(this.f23522a, annotationQualifiersFqNames2.f23522a) && Intrinsics3.areEqual(this.f23523b, annotationQualifiersFqNames2.f23523b) && this.f23524c == annotationQualifiersFqNames2.f23524c;
    }

    public final boolean getAffectsTypeParameterBasedTypes() {
        return this.f23524c;
    }

    public final boolean getMakesTypeParameterNotNull() {
        return this.f23522a.getQualifier() == typeQualifiers3.NOT_NULL && this.f23524c;
    }

    public final NullabilityQualifierWithMigrationStatus getNullabilityQualifier() {
        return this.f23522a;
    }

    public final Collection<AnnotationQualifierApplicabilityType> getQualifierApplicabilityTypes() {
        return this.f23523b;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int iHashCode = (this.f23523b.hashCode() + (this.f23522a.hashCode() * 31)) * 31;
        boolean z2 = this.f23524c;
        int i = z2;
        if (z2 != 0) {
            i = 1;
        }
        return iHashCode + i;
    }

    public String toString() {
        StringBuilder sbM833U = outline.m833U("JavaDefaultQualifiers(nullabilityQualifier=");
        sbM833U.append(this.f23522a);
        sbM833U.append(", qualifierApplicabilityTypes=");
        sbM833U.append(this.f23523b);
        sbM833U.append(", affectsTypeParameterBasedTypes=");
        sbM833U.append(this.f23524c);
        sbM833U.append(')');
        return sbM833U.toString();
    }

    public /* synthetic */ AnnotationQualifiersFqNames2(NullabilityQualifierWithMigrationStatus nullabilityQualifierWithMigrationStatus, Collection collection, boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(nullabilityQualifierWithMigrationStatus, collection, (i & 4) != 0 ? nullabilityQualifierWithMigrationStatus.getQualifier() == typeQualifiers3.NOT_NULL : z2);
    }
}

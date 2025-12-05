package p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p540l0;

import p007b.p100d.p104b.p105a.outline;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.TypeParameterDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.AnnotationQualifiersFqNames2;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: signatureEnhancement.kt */
/* renamed from: d0.e0.p.d.m0.e.a.l0.s, reason: use source file name */
/* loaded from: classes3.dex */
public final class signatureEnhancement7 {

    /* renamed from: a */
    public final KotlinType f23499a;

    /* renamed from: b */
    public final AnnotationQualifiersFqNames2 f23500b;

    /* renamed from: c */
    public final TypeParameterDescriptor f23501c;

    /* renamed from: d */
    public final boolean f23502d;

    public signatureEnhancement7(KotlinType kotlinType, AnnotationQualifiersFqNames2 annotationQualifiersFqNames2, TypeParameterDescriptor typeParameterDescriptor, boolean z2) {
        Intrinsics3.checkNotNullParameter(kotlinType, "type");
        this.f23499a = kotlinType;
        this.f23500b = annotationQualifiersFqNames2;
        this.f23501c = typeParameterDescriptor;
        this.f23502d = z2;
    }

    public final KotlinType component1() {
        return this.f23499a;
    }

    public final AnnotationQualifiersFqNames2 component2() {
        return this.f23500b;
    }

    public final TypeParameterDescriptor component3() {
        return this.f23501c;
    }

    public final boolean component4() {
        return this.f23502d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof signatureEnhancement7)) {
            return false;
        }
        signatureEnhancement7 signatureenhancement7 = (signatureEnhancement7) obj;
        return Intrinsics3.areEqual(this.f23499a, signatureenhancement7.f23499a) && Intrinsics3.areEqual(this.f23500b, signatureenhancement7.f23500b) && Intrinsics3.areEqual(this.f23501c, signatureenhancement7.f23501c) && this.f23502d == signatureenhancement7.f23502d;
    }

    public final KotlinType getType() {
        return this.f23499a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int iHashCode = this.f23499a.hashCode() * 31;
        AnnotationQualifiersFqNames2 annotationQualifiersFqNames2 = this.f23500b;
        int iHashCode2 = (iHashCode + (annotationQualifiersFqNames2 == null ? 0 : annotationQualifiersFqNames2.hashCode())) * 31;
        TypeParameterDescriptor typeParameterDescriptor = this.f23501c;
        int iHashCode3 = (iHashCode2 + (typeParameterDescriptor != null ? typeParameterDescriptor.hashCode() : 0)) * 31;
        boolean z2 = this.f23502d;
        int i = z2;
        if (z2 != 0) {
            i = 1;
        }
        return iHashCode3 + i;
    }

    public String toString() {
        StringBuilder sbM833U = outline.m833U("TypeAndDefaultQualifiers(type=");
        sbM833U.append(this.f23499a);
        sbM833U.append(", defaultQualifiers=");
        sbM833U.append(this.f23500b);
        sbM833U.append(", typeParameterForArgument=");
        sbM833U.append(this.f23501c);
        sbM833U.append(", isFromStarProjection=");
        sbM833U.append(this.f23502d);
        sbM833U.append(')');
        return sbM833U.toString();
    }
}

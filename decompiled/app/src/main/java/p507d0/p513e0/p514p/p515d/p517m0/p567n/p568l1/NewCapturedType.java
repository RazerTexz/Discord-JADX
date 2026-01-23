package p507d0.p513e0.p514p.p515d.p517m0.p567n.p568l1;

import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.TypeParameterDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1.Annotations4;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.MemberScope3;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.ErrorUtils;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType3;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType4;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.TypeConstructor;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.TypeProjection;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.p570n1.EnumC11973b;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.p570n1.InterfaceC11974c;
import p507d0.p580t.Collections2;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: renamed from: d0.e0.p.d.m0.n.l1.i, reason: use source file name */
/* JADX INFO: compiled from: NewCapturedType.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class NewCapturedType extends KotlinType4 implements InterfaceC11974c {

    /* JADX INFO: renamed from: k */
    public final EnumC11973b f24809k;

    /* JADX INFO: renamed from: l */
    public final NewCapturedType2 f24810l;

    /* JADX INFO: renamed from: m */
    public final KotlinType3 f24811m;

    /* JADX INFO: renamed from: n */
    public final Annotations4 f24812n;

    /* JADX INFO: renamed from: o */
    public final boolean f24813o;

    /* JADX INFO: renamed from: p */
    public final boolean f24814p;

    public /* synthetic */ NewCapturedType(EnumC11973b enumC11973b, NewCapturedType2 newCapturedType2, KotlinType3 kotlinType3, Annotations4 annotations4, boolean z2, boolean z3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(enumC11973b, newCapturedType2, kotlinType3, (i & 8) != 0 ? Annotations4.f22735f.getEMPTY() : annotations4, (i & 16) != 0 ? false : z2, (i & 32) != 0 ? false : z3);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1.Annotations3
    public Annotations4 getAnnotations() {
        return this.f24812n;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType
    public List<TypeProjection> getArguments() {
        return Collections2.emptyList();
    }

    public final EnumC11973b getCaptureStatus() {
        return this.f24809k;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType
    public /* bridge */ /* synthetic */ TypeConstructor getConstructor() {
        return getConstructor();
    }

    public final KotlinType3 getLowerType() {
        return this.f24811m;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType
    public MemberScope3 getMemberScope() {
        MemberScope3 memberScope3CreateErrorScope = ErrorUtils.createErrorScope("No member resolution should be done on captured type!", true);
        Intrinsics3.checkNotNullExpressionValue(memberScope3CreateErrorScope, "createErrorScope(\"No member resolution should be done on captured type!\", true)");
        return memberScope3CreateErrorScope;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType
    public boolean isMarkedNullable() {
        return this.f24813o;
    }

    public final boolean isProjectionNotNull() {
        return this.f24814p;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType4, p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType3
    public /* bridge */ /* synthetic */ KotlinType4 makeNullableAsSpecified(boolean z2) {
        return makeNullableAsSpecified(z2);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType
    public /* bridge */ /* synthetic */ KotlinType refine(KotlinTypeRefiner kotlinTypeRefiner) {
        return refine(kotlinTypeRefiner);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType4, p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType3
    public /* bridge */ /* synthetic */ KotlinType4 replaceAnnotations(Annotations4 annotations4) {
        return replaceAnnotations(annotations4);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType
    public NewCapturedType2 getConstructor() {
        return this.f24810l;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType3
    public /* bridge */ /* synthetic */ KotlinType3 makeNullableAsSpecified(boolean z2) {
        return makeNullableAsSpecified(z2);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType3, p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType
    public /* bridge */ /* synthetic */ KotlinType3 refine(KotlinTypeRefiner kotlinTypeRefiner) {
        return refine(kotlinTypeRefiner);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType3
    public /* bridge */ /* synthetic */ KotlinType3 replaceAnnotations(Annotations4 annotations4) {
        return replaceAnnotations(annotations4);
    }

    public NewCapturedType(EnumC11973b enumC11973b, NewCapturedType2 newCapturedType2, KotlinType3 kotlinType3, Annotations4 annotations4, boolean z2, boolean z3) {
        Intrinsics3.checkNotNullParameter(enumC11973b, "captureStatus");
        Intrinsics3.checkNotNullParameter(newCapturedType2, "constructor");
        Intrinsics3.checkNotNullParameter(annotations4, "annotations");
        this.f24809k = enumC11973b;
        this.f24810l = newCapturedType2;
        this.f24811m = kotlinType3;
        this.f24812n = annotations4;
        this.f24813o = z2;
        this.f24814p = z3;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType4, p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType3
    public NewCapturedType makeNullableAsSpecified(boolean z2) {
        return new NewCapturedType(this.f24809k, getConstructor(), this.f24811m, getAnnotations(), z2, false, 32, null);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType3, p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType
    public NewCapturedType refine(KotlinTypeRefiner kotlinTypeRefiner) {
        Intrinsics3.checkNotNullParameter(kotlinTypeRefiner, "kotlinTypeRefiner");
        EnumC11973b enumC11973b = this.f24809k;
        NewCapturedType2 newCapturedType2Refine = getConstructor().refine(kotlinTypeRefiner);
        KotlinType3 kotlinType3 = this.f24811m;
        return new NewCapturedType(enumC11973b, newCapturedType2Refine, kotlinType3 == null ? null : kotlinTypeRefiner.refineType(kotlinType3).unwrap(), getAnnotations(), isMarkedNullable(), false, 32, null);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType4, p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType3
    public NewCapturedType replaceAnnotations(Annotations4 annotations4) {
        Intrinsics3.checkNotNullParameter(annotations4, "newAnnotations");
        return new NewCapturedType(this.f24809k, getConstructor(), this.f24811m, annotations4, isMarkedNullable(), false, 32, null);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public NewCapturedType(EnumC11973b enumC11973b, KotlinType3 kotlinType3, TypeProjection typeProjection, TypeParameterDescriptor typeParameterDescriptor) {
        this(enumC11973b, new NewCapturedType2(typeProjection, null, null, typeParameterDescriptor, 6, null), kotlinType3, null, false, false, 56, null);
        Intrinsics3.checkNotNullParameter(enumC11973b, "captureStatus");
        Intrinsics3.checkNotNullParameter(typeProjection, "projection");
        Intrinsics3.checkNotNullParameter(typeParameterDescriptor, "typeParameter");
    }
}

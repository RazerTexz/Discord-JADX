package p507d0.p513e0.p514p.p515d.p517m0.p567n;

import java.util.List;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.MemberScope3;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.p568l1.KotlinTypeRefiner;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: ErrorType.kt */
/* renamed from: d0.e0.p.d.m0.n.h1, reason: use source file name */
/* loaded from: classes3.dex */
public final class ErrorType extends ErrorType2 {

    /* renamed from: p */
    public final String f24780p;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ErrorType(String str, TypeConstructor typeConstructor, MemberScope3 memberScope3, List<? extends TypeProjection> list, boolean z2) {
        super(typeConstructor, memberScope3, list, z2, null, 16, null);
        Intrinsics3.checkNotNullParameter(str, "presentableName");
        Intrinsics3.checkNotNullParameter(typeConstructor, "constructor");
        Intrinsics3.checkNotNullParameter(memberScope3, "memberScope");
        Intrinsics3.checkNotNullParameter(list, "arguments");
        this.f24780p = str;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.ErrorType2
    public String getPresentableName() {
        return this.f24780p;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.ErrorType2, p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType3
    public /* bridge */ /* synthetic */ KotlinType3 makeNullableAsSpecified(boolean z2) {
        return makeNullableAsSpecified(z2);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.ErrorType2, p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType
    public ErrorType refine(KotlinTypeRefiner kotlinTypeRefiner) {
        Intrinsics3.checkNotNullParameter(kotlinTypeRefiner, "kotlinTypeRefiner");
        return this;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.ErrorType2, p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType3, p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType
    public /* bridge */ /* synthetic */ ErrorType2 refine(KotlinTypeRefiner kotlinTypeRefiner) {
        return refine(kotlinTypeRefiner);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.ErrorType2, p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType4, p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType3
    public KotlinType4 makeNullableAsSpecified(boolean z2) {
        return new ErrorType(getPresentableName(), getConstructor(), getMemberScope(), getArguments(), z2);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.ErrorType2, p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType
    public /* bridge */ /* synthetic */ KotlinType refine(KotlinTypeRefiner kotlinTypeRefiner) {
        return refine(kotlinTypeRefiner);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.ErrorType2, p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType3, p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType
    public /* bridge */ /* synthetic */ KotlinType3 refine(KotlinTypeRefiner kotlinTypeRefiner) {
        return refine(kotlinTypeRefiner);
    }
}

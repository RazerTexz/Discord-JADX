package p507d0.p513e0.p514p.p515d.p517m0.p552k.p555u.p556a;

import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1.Annotations4;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.MemberScope3;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.ErrorUtils;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType3;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType4;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.TypeConstructor;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.TypeProjection;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.p568l1.KotlinTypeRefiner;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.p570n1.InterfaceC11974c;
import p507d0.p580t.Collections2;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: CapturedTypeConstructor.kt */
/* renamed from: d0.e0.p.d.m0.k.u.a.a, reason: use source file name */
/* loaded from: classes3.dex */
public final class CapturedTypeConstructor extends KotlinType4 implements InterfaceC11974c {

    /* renamed from: k */
    public final TypeProjection f24428k;

    /* renamed from: l */
    public final CapturedTypeConstructor2 f24429l;

    /* renamed from: m */
    public final boolean f24430m;

    /* renamed from: n */
    public final Annotations4 f24431n;

    public /* synthetic */ CapturedTypeConstructor(TypeProjection typeProjection, CapturedTypeConstructor2 capturedTypeConstructor2, boolean z2, Annotations4 annotations4, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(typeProjection, (i & 2) != 0 ? new CapturedTypeConstructor3(typeProjection) : capturedTypeConstructor2, (i & 4) != 0 ? false : z2, (i & 8) != 0 ? Annotations4.f22735f.getEMPTY() : annotations4);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1.Annotations3
    public Annotations4 getAnnotations() {
        return this.f24431n;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType
    public List<TypeProjection> getArguments() {
        return Collections2.emptyList();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType
    public /* bridge */ /* synthetic */ TypeConstructor getConstructor() {
        return getConstructor();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType
    public MemberScope3 getMemberScope() {
        MemberScope3 memberScope3CreateErrorScope = ErrorUtils.createErrorScope("No member resolution should be done on captured type, it used only during constraint system resolution", true);
        Intrinsics3.checkNotNullExpressionValue(memberScope3CreateErrorScope, "createErrorScope(\n            \"No member resolution should be done on captured type, it used only during constraint system resolution\", true\n        )");
        return memberScope3CreateErrorScope;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType
    public boolean isMarkedNullable() {
        return this.f24430m;
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

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType4
    public String toString() {
        StringBuilder sbM833U = outline.m833U("Captured(");
        sbM833U.append(this.f24428k);
        sbM833U.append(')');
        sbM833U.append(isMarkedNullable() ? "?" : "");
        return sbM833U.toString();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType
    public CapturedTypeConstructor2 getConstructor() {
        return this.f24429l;
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

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType4, p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType3
    public CapturedTypeConstructor makeNullableAsSpecified(boolean z2) {
        return z2 == isMarkedNullable() ? this : new CapturedTypeConstructor(this.f24428k, getConstructor(), z2, getAnnotations());
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType3, p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType
    public CapturedTypeConstructor refine(KotlinTypeRefiner kotlinTypeRefiner) {
        Intrinsics3.checkNotNullParameter(kotlinTypeRefiner, "kotlinTypeRefiner");
        TypeProjection typeProjectionRefine = this.f24428k.refine(kotlinTypeRefiner);
        Intrinsics3.checkNotNullExpressionValue(typeProjectionRefine, "typeProjection.refine(kotlinTypeRefiner)");
        return new CapturedTypeConstructor(typeProjectionRefine, getConstructor(), isMarkedNullable(), getAnnotations());
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType4, p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType3
    public CapturedTypeConstructor replaceAnnotations(Annotations4 annotations4) {
        Intrinsics3.checkNotNullParameter(annotations4, "newAnnotations");
        return new CapturedTypeConstructor(this.f24428k, getConstructor(), isMarkedNullable(), annotations4);
    }

    public CapturedTypeConstructor(TypeProjection typeProjection, CapturedTypeConstructor2 capturedTypeConstructor2, boolean z2, Annotations4 annotations4) {
        Intrinsics3.checkNotNullParameter(typeProjection, "typeProjection");
        Intrinsics3.checkNotNullParameter(capturedTypeConstructor2, "constructor");
        Intrinsics3.checkNotNullParameter(annotations4, "annotations");
        this.f24428k = typeProjection;
        this.f24429l = capturedTypeConstructor2;
        this.f24430m = z2;
        this.f24431n = annotations4;
    }
}

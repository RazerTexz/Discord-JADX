package p507d0.p513e0.p514p.p515d.p517m0.p552k.p555u.p556a;

import java.util.Collection;
import java.util.List;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p513e0.p514p.p515d.p517m0.p518b.KotlinBuiltIns;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.ClassifierDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.TypeParameterDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.TypeConstructor;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.TypeProjection;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.Variance;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.p568l1.KotlinTypeRefiner;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.p568l1.NewCapturedType2;
import p507d0.p580t.Collections2;
import p507d0.p580t.CollectionsJVM;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: CapturedTypeConstructor.kt */
/* renamed from: d0.e0.p.d.m0.k.u.a.c, reason: use source file name */
/* loaded from: classes3.dex */
public final class CapturedTypeConstructor3 implements CapturedTypeConstructor2 {

    /* renamed from: a */
    public final TypeProjection f24432a;

    /* renamed from: b */
    public NewCapturedType2 f24433b;

    public CapturedTypeConstructor3(TypeProjection typeProjection) {
        Intrinsics3.checkNotNullParameter(typeProjection, "projection");
        this.f24432a = typeProjection;
        getProjection().getProjectionKind();
        Variance variance = Variance.INVARIANT;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.TypeConstructor
    public KotlinBuiltIns getBuiltIns() {
        KotlinBuiltIns builtIns = getProjection().getType().getConstructor().getBuiltIns();
        Intrinsics3.checkNotNullExpressionValue(builtIns, "projection.type.constructor.builtIns");
        return builtIns;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.TypeConstructor
    public /* bridge */ /* synthetic */ ClassifierDescriptor getDeclarationDescriptor() {
        return (ClassifierDescriptor) m11470getDeclarationDescriptor();
    }

    /* renamed from: getDeclarationDescriptor, reason: collision with other method in class */
    public Void m11470getDeclarationDescriptor() {
        return null;
    }

    public final NewCapturedType2 getNewTypeConstructor() {
        return this.f24433b;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.TypeConstructor
    public List<TypeParameterDescriptor> getParameters() {
        return Collections2.emptyList();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p552k.p555u.p556a.CapturedTypeConstructor2
    public TypeProjection getProjection() {
        return this.f24432a;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.TypeConstructor
    public Collection<KotlinType> getSupertypes() {
        KotlinType type = getProjection().getProjectionKind() == Variance.OUT_VARIANCE ? getProjection().getType() : getBuiltIns().getNullableAnyType();
        Intrinsics3.checkNotNullExpressionValue(type, "if (projection.projectionKind == Variance.OUT_VARIANCE)\n            projection.type\n        else\n            builtIns.nullableAnyType");
        return CollectionsJVM.listOf(type);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.TypeConstructor
    public boolean isDenotable() {
        return false;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.TypeConstructor
    public /* bridge */ /* synthetic */ TypeConstructor refine(KotlinTypeRefiner kotlinTypeRefiner) {
        return refine(kotlinTypeRefiner);
    }

    public final void setNewTypeConstructor(NewCapturedType2 newCapturedType2) {
        this.f24433b = newCapturedType2;
    }

    public String toString() {
        StringBuilder sbM833U = outline.m833U("CapturedTypeConstructor(");
        sbM833U.append(getProjection());
        sbM833U.append(')');
        return sbM833U.toString();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.TypeConstructor
    public CapturedTypeConstructor3 refine(KotlinTypeRefiner kotlinTypeRefiner) {
        Intrinsics3.checkNotNullParameter(kotlinTypeRefiner, "kotlinTypeRefiner");
        TypeProjection typeProjectionRefine = getProjection().refine(kotlinTypeRefiner);
        Intrinsics3.checkNotNullExpressionValue(typeProjectionRefine, "projection.refine(kotlinTypeRefiner)");
        return new CapturedTypeConstructor3(typeProjectionRefine);
    }
}

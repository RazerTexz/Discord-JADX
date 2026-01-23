package p507d0.p513e0.p514p.p515d.p517m0.p567n;

import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.TypeParameterDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1.Annotations4;
import p507d0.p513e0.p514p.p515d.p517m0.p551j.DescriptorRenderer2;
import p507d0.p513e0.p514p.p515d.p517m0.p551j.DescriptorRenderer4;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.p568l1.KotlinTypeRefiner;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.p571o1.TypeUtils2;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: renamed from: d0.e0.p.d.m0.n.w, reason: use source file name */
/* JADX INFO: compiled from: flexibleTypes.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class flexibleTypes extends KotlinType6 implements TypeCapabilities {

    /* JADX INFO: renamed from: d0.e0.p.d.m0.n.w$a */
    /* JADX INFO: compiled from: flexibleTypes.kt */
    public static final class a {
        public a(DefaultConstructorMarker defaultConstructorMarker) {
        }
    }

    static {
        new a(null);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public flexibleTypes(KotlinType4 kotlinType4, KotlinType4 kotlinType42) {
        super(kotlinType4, kotlinType42);
        Intrinsics3.checkNotNullParameter(kotlinType4, "lowerBound");
        Intrinsics3.checkNotNullParameter(kotlinType42, "upperBound");
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType6
    public KotlinType4 getDelegate() {
        return getLowerBound();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.TypeCapabilities
    public boolean isTypeVariable() {
        return (getLowerBound().getConstructor().getDeclarationDescriptor() instanceof TypeParameterDescriptor) && Intrinsics3.areEqual(getLowerBound().getConstructor(), getUpperBound().getConstructor());
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType3
    public KotlinType3 makeNullableAsSpecified(boolean z2) {
        KotlinTypeFactory kotlinTypeFactory = KotlinTypeFactory.f24748a;
        return KotlinTypeFactory.flexibleType(getLowerBound().makeNullableAsSpecified(z2), getUpperBound().makeNullableAsSpecified(z2));
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType
    public /* bridge */ /* synthetic */ KotlinType refine(KotlinTypeRefiner kotlinTypeRefiner) {
        return refine(kotlinTypeRefiner);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType6
    public String render(DescriptorRenderer2 descriptorRenderer2, DescriptorRenderer4 descriptorRenderer4) {
        Intrinsics3.checkNotNullParameter(descriptorRenderer2, "renderer");
        Intrinsics3.checkNotNullParameter(descriptorRenderer4, "options");
        if (!descriptorRenderer4.getDebugMode()) {
            return descriptorRenderer2.renderFlexibleType(descriptorRenderer2.renderType(getLowerBound()), descriptorRenderer2.renderType(getUpperBound()), TypeUtils2.getBuiltIns(this));
        }
        StringBuilder sbM829Q = outline.m829Q('(');
        sbM829Q.append(descriptorRenderer2.renderType(getLowerBound()));
        sbM829Q.append("..");
        sbM829Q.append(descriptorRenderer2.renderType(getUpperBound()));
        sbM829Q.append(')');
        return sbM829Q.toString();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType3
    public KotlinType3 replaceAnnotations(Annotations4 annotations4) {
        Intrinsics3.checkNotNullParameter(annotations4, "newAnnotations");
        KotlinTypeFactory kotlinTypeFactory = KotlinTypeFactory.f24748a;
        return KotlinTypeFactory.flexibleType(getLowerBound().replaceAnnotations(annotations4), getUpperBound().replaceAnnotations(annotations4));
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.TypeCapabilities
    public KotlinType substitutionResult(KotlinType kotlinType) {
        KotlinType3 kotlinType3FlexibleType;
        Intrinsics3.checkNotNullParameter(kotlinType, "replacement");
        KotlinType3 kotlinType3Unwrap = kotlinType.unwrap();
        if (kotlinType3Unwrap instanceof KotlinType6) {
            kotlinType3FlexibleType = kotlinType3Unwrap;
        } else {
            if (!(kotlinType3Unwrap instanceof KotlinType4)) {
                throw new NoWhenBranchMatchedException();
            }
            KotlinTypeFactory kotlinTypeFactory = KotlinTypeFactory.f24748a;
            KotlinType4 kotlinType4 = (KotlinType4) kotlinType3Unwrap;
            kotlinType3FlexibleType = KotlinTypeFactory.flexibleType(kotlinType4, kotlinType4.makeNullableAsSpecified(true));
        }
        return TypeWithEnhancement2.inheritEnhancement(kotlinType3FlexibleType, kotlinType3Unwrap);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType3, p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType
    public /* bridge */ /* synthetic */ KotlinType3 refine(KotlinTypeRefiner kotlinTypeRefiner) {
        return refine(kotlinTypeRefiner);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType3, p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType
    public KotlinType6 refine(KotlinTypeRefiner kotlinTypeRefiner) {
        Intrinsics3.checkNotNullParameter(kotlinTypeRefiner, "kotlinTypeRefiner");
        return new flexibleTypes((KotlinType4) kotlinTypeRefiner.refineType(getLowerBound()), (KotlinType4) kotlinTypeRefiner.refineType(getUpperBound()));
    }
}

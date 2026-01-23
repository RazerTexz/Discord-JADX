package p507d0.p513e0.p514p.p515d.p517m0.p567n;

import kotlin.jvm.internal.DefaultConstructorMarker;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.TypeParameterDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1.Annotations4;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.p568l1.NewCapturedType;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.p568l1.NewKotlinTypeChecker3;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.p570n1.InterfaceC11975d;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: renamed from: d0.e0.p.d.m0.n.k, reason: use source file name */
/* JADX INFO: compiled from: SpecialTypes.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class SpecialTypes3 extends SpecialTypes4 implements TypeCapabilities, InterfaceC11975d {

    /* JADX INFO: renamed from: k */
    public static final a f24788k = new a(null);

    /* JADX INFO: renamed from: l */
    public final KotlinType4 f24789l;

    /* JADX INFO: renamed from: m */
    public final boolean f24790m;

    /* JADX INFO: renamed from: d0.e0.p.d.m0.n.k$a */
    /* JADX INFO: compiled from: SpecialTypes.kt */
    public static final class a {
        public a(DefaultConstructorMarker defaultConstructorMarker) {
        }

        public final SpecialTypes3 makeDefinitelyNotNull$descriptors(KotlinType3 kotlinType3, boolean z2) {
            Intrinsics3.checkNotNullParameter(kotlinType3, "type");
            if (kotlinType3 instanceof SpecialTypes3) {
                return (SpecialTypes3) kotlinType3;
            }
            kotlinType3.getConstructor();
            if (!((kotlinType3.getConstructor().getDeclarationDescriptor() instanceof TypeParameterDescriptor) || (kotlinType3 instanceof NewCapturedType) ? (z2 && (kotlinType3.getConstructor().getDeclarationDescriptor() instanceof TypeParameterDescriptor)) ? TypeUtils.isNullableType(kotlinType3) : !NewKotlinTypeChecker3.f24825a.isSubtypeOfAny(kotlinType3) : false)) {
                return null;
            }
            if (kotlinType3 instanceof KotlinType6) {
                KotlinType6 kotlinType6 = (KotlinType6) kotlinType3;
                Intrinsics3.areEqual(kotlinType6.getLowerBound().getConstructor(), kotlinType6.getUpperBound().getConstructor());
            }
            return new SpecialTypes3(flexibleTypes2.lowerIfFlexible(kotlinType3), z2, null);
        }
    }

    public SpecialTypes3(KotlinType4 kotlinType4, boolean z2) {
        this.f24789l = kotlinType4;
        this.f24790m = z2;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.SpecialTypes4
    public KotlinType4 getDelegate() {
        return this.f24789l;
    }

    public final KotlinType4 getOriginal() {
        return this.f24789l;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.SpecialTypes4, p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType
    public boolean isMarkedNullable() {
        return false;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.TypeCapabilities
    public boolean isTypeVariable() {
        this.f24789l.getConstructor();
        return this.f24789l.getConstructor().getDeclarationDescriptor() instanceof TypeParameterDescriptor;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType3
    public /* bridge */ /* synthetic */ KotlinType3 makeNullableAsSpecified(boolean z2) {
        return makeNullableAsSpecified(z2);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType4, p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType3
    public /* bridge */ /* synthetic */ KotlinType4 replaceAnnotations(Annotations4 annotations4) {
        return replaceAnnotations(annotations4);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.SpecialTypes4
    public /* bridge */ /* synthetic */ SpecialTypes4 replaceDelegate(KotlinType4 kotlinType4) {
        return replaceDelegate(kotlinType4);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.TypeCapabilities
    public KotlinType substitutionResult(KotlinType kotlinType) {
        Intrinsics3.checkNotNullParameter(kotlinType, "replacement");
        return SpecialTypes5.makeDefinitelyNotNullOrNotNull(kotlinType.unwrap(), this.f24790m);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType4
    public String toString() {
        return this.f24789l + "!!";
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType4, p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType3
    public KotlinType4 makeNullableAsSpecified(boolean z2) {
        return z2 ? this.f24789l.makeNullableAsSpecified(z2) : this;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType3
    public /* bridge */ /* synthetic */ KotlinType3 replaceAnnotations(Annotations4 annotations4) {
        return replaceAnnotations(annotations4);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.SpecialTypes4
    public SpecialTypes3 replaceDelegate(KotlinType4 kotlinType4) {
        Intrinsics3.checkNotNullParameter(kotlinType4, "delegate");
        return new SpecialTypes3(kotlinType4, this.f24790m);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType4, p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType3
    public SpecialTypes3 replaceAnnotations(Annotations4 annotations4) {
        Intrinsics3.checkNotNullParameter(annotations4, "newAnnotations");
        return new SpecialTypes3(this.f24789l.replaceAnnotations(annotations4), this.f24790m);
    }

    public SpecialTypes3(KotlinType4 kotlinType4, boolean z2, DefaultConstructorMarker defaultConstructorMarker) {
        this.f24789l = kotlinType4;
        this.f24790m = z2;
    }
}

package p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p540l0;

import p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1.Annotations4;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType3;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType4;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType6;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinTypeFactory;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.SpecialTypes4;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.TypeCapabilities;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.TypeUtils;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.TypeWithEnhancement2;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.p571o1.TypeUtils2;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: typeEnhancement.kt */
/* renamed from: d0.e0.p.d.m0.e.a.l0.g, reason: use source file name */
/* loaded from: classes3.dex */
public final class typeEnhancement5 extends SpecialTypes4 implements TypeCapabilities {

    /* renamed from: k */
    public final KotlinType4 f23459k;

    public typeEnhancement5(KotlinType4 kotlinType4) {
        Intrinsics3.checkNotNullParameter(kotlinType4, "delegate");
        this.f23459k = kotlinType4;
    }

    /* renamed from: a */
    public final KotlinType4 m9508a(KotlinType4 kotlinType4) {
        KotlinType4 kotlinType4MakeNullableAsSpecified = kotlinType4.makeNullableAsSpecified(false);
        return !TypeUtils2.isTypeParameter(kotlinType4) ? kotlinType4MakeNullableAsSpecified : new typeEnhancement5(kotlinType4MakeNullableAsSpecified);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.SpecialTypes4
    public KotlinType4 getDelegate() {
        return this.f23459k;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.SpecialTypes4, p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType
    public boolean isMarkedNullable() {
        return false;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.TypeCapabilities
    public boolean isTypeVariable() {
        return true;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType4, p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType3
    public KotlinType4 makeNullableAsSpecified(boolean z2) {
        return z2 ? this.f23459k.makeNullableAsSpecified(true) : this;
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
        KotlinType3 kotlinType3Unwrap = kotlinType.unwrap();
        if (!TypeUtils2.isTypeParameter(kotlinType3Unwrap) && !TypeUtils.isNullableType(kotlinType3Unwrap)) {
            return kotlinType3Unwrap;
        }
        if (kotlinType3Unwrap instanceof KotlinType4) {
            return m9508a((KotlinType4) kotlinType3Unwrap);
        }
        if (!(kotlinType3Unwrap instanceof KotlinType6)) {
            throw new IllegalStateException(Intrinsics3.stringPlus("Incorrect type: ", kotlinType3Unwrap).toString());
        }
        KotlinTypeFactory kotlinTypeFactory = KotlinTypeFactory.f24748a;
        KotlinType6 kotlinType6 = (KotlinType6) kotlinType3Unwrap;
        return TypeWithEnhancement2.wrapEnhancement(KotlinTypeFactory.flexibleType(m9508a(kotlinType6.getLowerBound()), m9508a(kotlinType6.getUpperBound())), TypeWithEnhancement2.getEnhancement(kotlinType3Unwrap));
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType3
    public /* bridge */ /* synthetic */ KotlinType3 replaceAnnotations(Annotations4 annotations4) {
        return replaceAnnotations(annotations4);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.SpecialTypes4
    public typeEnhancement5 replaceDelegate(KotlinType4 kotlinType4) {
        Intrinsics3.checkNotNullParameter(kotlinType4, "delegate");
        return new typeEnhancement5(kotlinType4);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType3
    public /* bridge */ /* synthetic */ KotlinType3 makeNullableAsSpecified(boolean z2) {
        return makeNullableAsSpecified(z2);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType4, p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType3
    public typeEnhancement5 replaceAnnotations(Annotations4 annotations4) {
        Intrinsics3.checkNotNullParameter(annotations4, "newAnnotations");
        return new typeEnhancement5(this.f23459k.replaceAnnotations(annotations4));
    }
}

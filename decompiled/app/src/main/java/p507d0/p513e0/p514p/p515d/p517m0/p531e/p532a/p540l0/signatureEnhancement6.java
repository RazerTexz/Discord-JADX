package p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p540l0;

import p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType3;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType6;

/* compiled from: signatureEnhancement.kt */
/* renamed from: d0.e0.p.d.m0.e.a.l0.r, reason: use source file name */
/* loaded from: classes3.dex */
public final class signatureEnhancement6 {
    public static final boolean access$isNullabilityFlexible(KotlinType kotlinType) {
        KotlinType3 kotlinType3Unwrap = kotlinType.unwrap();
        KotlinType6 kotlinType6 = kotlinType3Unwrap instanceof KotlinType6 ? (KotlinType6) kotlinType3Unwrap : null;
        return (kotlinType6 == null || kotlinType6.getLowerBound().isMarkedNullable() == kotlinType6.getUpperBound().isMarkedNullable()) ? false : true;
    }
}

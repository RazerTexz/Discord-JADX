package p507d0.p513e0.p514p.p515d.p517m0.p567n;

import kotlin.jvm.internal.DefaultConstructorMarker;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1.Annotations4;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.p568l1.KotlinTypeRefiner;

/* compiled from: KotlinType.kt */
/* renamed from: d0.e0.p.d.m0.n.i1, reason: use source file name */
/* loaded from: classes3.dex */
public abstract class KotlinType3 extends KotlinType {
    public KotlinType3() {
        super(null);
    }

    public abstract KotlinType3 makeNullableAsSpecified(boolean z2);

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType
    public abstract KotlinType3 refine(KotlinTypeRefiner kotlinTypeRefiner);

    public abstract KotlinType3 replaceAnnotations(Annotations4 annotations4);

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType
    public final KotlinType3 unwrap() {
        return this;
    }

    public KotlinType3(DefaultConstructorMarker defaultConstructorMarker) {
        super(null);
    }
}

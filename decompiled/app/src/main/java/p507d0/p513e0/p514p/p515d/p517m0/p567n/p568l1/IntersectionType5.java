package p507d0.p513e0.p514p.p515d.p517m0.p567n.p568l1;

import kotlin.jvm.functions.Function2;
import kotlin.reflect.KDeclarationContainer;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType;
import p507d0.p592z.p594d.FunctionReference;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Reflection2;

/* compiled from: IntersectionType.kt */
/* renamed from: d0.e0.p.d.m0.n.l1.y, reason: use source file name */
/* loaded from: classes3.dex */
public final /* synthetic */ class IntersectionType5 extends FunctionReference implements Function2<KotlinType, KotlinType, Boolean> {
    public IntersectionType5(NewKotlinTypeChecker2 newKotlinTypeChecker2) {
        super(2, newKotlinTypeChecker2);
    }

    @Override // p507d0.p592z.p594d.CallableReference, kotlin.reflect.KCallable
    public final String getName() {
        return "equalTypes";
    }

    @Override // p507d0.p592z.p594d.CallableReference
    public final KDeclarationContainer getOwner() {
        return Reflection2.getOrCreateKotlinClass(NewKotlinTypeChecker2.class);
    }

    @Override // p507d0.p592z.p594d.CallableReference
    public final String getSignature() {
        return "equalTypes(Lorg/jetbrains/kotlin/types/KotlinType;Lorg/jetbrains/kotlin/types/KotlinType;)Z";
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Boolean invoke(KotlinType kotlinType, KotlinType kotlinType2) {
        return Boolean.valueOf(invoke2(kotlinType, kotlinType2));
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final boolean invoke2(KotlinType kotlinType, KotlinType kotlinType2) {
        Intrinsics3.checkNotNullParameter(kotlinType, "p0");
        Intrinsics3.checkNotNullParameter(kotlinType2, "p1");
        return ((NewKotlinTypeChecker2) this.receiver).equalTypes(kotlinType, kotlinType2);
    }
}

package p507d0.p513e0.p514p.p515d.p517m0.p552k.p557v;

import kotlin.jvm.functions.Function1;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;

/* compiled from: IntegerLiteralTypeConstructor.kt */
/* renamed from: d0.e0.p.d.m0.k.v.o, reason: use source file name */
/* loaded from: classes3.dex */
public final class IntegerLiteralTypeConstructor2 extends Lambda implements Function1<KotlinType, CharSequence> {

    /* renamed from: j */
    public static final IntegerLiteralTypeConstructor2 f24450j = new IntegerLiteralTypeConstructor2();

    public IntegerLiteralTypeConstructor2() {
        super(1);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final CharSequence invoke2(KotlinType kotlinType) {
        Intrinsics3.checkNotNullParameter(kotlinType, "it");
        return kotlinType.toString();
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ CharSequence invoke(KotlinType kotlinType) {
        return invoke2(kotlinType);
    }
}

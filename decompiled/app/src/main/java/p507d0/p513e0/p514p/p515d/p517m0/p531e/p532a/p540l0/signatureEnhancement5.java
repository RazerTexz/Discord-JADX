package p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p540l0;

import kotlin.jvm.functions.Function1;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.CallableMemberDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.ValueParameterDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;

/* compiled from: signatureEnhancement.kt */
/* renamed from: d0.e0.p.d.m0.e.a.l0.p, reason: use source file name */
/* loaded from: classes3.dex */
public final class signatureEnhancement5 extends Lambda implements Function1<CallableMemberDescriptor, KotlinType> {

    /* renamed from: $p */
    public final /* synthetic */ ValueParameterDescriptor f23491$p;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public signatureEnhancement5(ValueParameterDescriptor valueParameterDescriptor) {
        super(1);
        this.f23491$p = valueParameterDescriptor;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ KotlinType invoke(CallableMemberDescriptor callableMemberDescriptor) {
        return invoke2(callableMemberDescriptor);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final KotlinType invoke2(CallableMemberDescriptor callableMemberDescriptor) {
        Intrinsics3.checkNotNullParameter(callableMemberDescriptor, "it");
        KotlinType type = callableMemberDescriptor.getValueParameters().get(this.f23491$p.getIndex()).getType();
        Intrinsics3.checkNotNullExpressionValue(type, "it.valueParameters[p.index].type");
        return type;
    }
}

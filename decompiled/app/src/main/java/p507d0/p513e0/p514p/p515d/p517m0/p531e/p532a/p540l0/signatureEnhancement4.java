package p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p540l0;

import kotlin.jvm.functions.Function1;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.CallableMemberDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;

/* JADX INFO: renamed from: d0.e0.p.d.m0.e.a.l0.o, reason: use source file name */
/* JADX INFO: compiled from: signatureEnhancement.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class signatureEnhancement4 extends Lambda implements Function1<CallableMemberDescriptor, KotlinType> {

    /* JADX INFO: renamed from: j */
    public static final signatureEnhancement4 f23490j = new signatureEnhancement4();

    public signatureEnhancement4() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ KotlinType invoke(CallableMemberDescriptor callableMemberDescriptor) {
        return invoke2(callableMemberDescriptor);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final KotlinType invoke2(CallableMemberDescriptor callableMemberDescriptor) {
        Intrinsics3.checkNotNullParameter(callableMemberDescriptor, "it");
        KotlinType returnType = callableMemberDescriptor.getReturnType();
        Intrinsics3.checkNotNull(returnType);
        return returnType;
    }
}

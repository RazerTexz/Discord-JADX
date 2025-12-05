package p507d0.p513e0.p514p.p515d.p517m0.p552k;

import kotlin.jvm.functions.Function1;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.CallableMemberDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.DeclarationDescriptor;

/* compiled from: OverridingUtil.java */
/* renamed from: d0.e0.p.d.m0.k.l, reason: use source file name */
/* loaded from: classes3.dex */
public final class OverridingUtil2 implements Function1<CallableMemberDescriptor, Boolean> {

    /* renamed from: j */
    public final /* synthetic */ DeclarationDescriptor f24423j;

    public OverridingUtil2(DeclarationDescriptor declarationDescriptor) {
        this.f24423j = declarationDescriptor;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Boolean invoke(CallableMemberDescriptor callableMemberDescriptor) {
        return invoke2(callableMemberDescriptor);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public Boolean invoke2(CallableMemberDescriptor callableMemberDescriptor) {
        return Boolean.valueOf(callableMemberDescriptor.getContainingDeclaration() == this.f24423j);
    }
}

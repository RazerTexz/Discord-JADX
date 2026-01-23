package p507d0.p513e0.p514p.p515d.p517m0.p552k;

import kotlin.jvm.functions.Function1;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.CallableMemberDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.ClassDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.DescriptorVisibilities;

/* JADX INFO: renamed from: d0.e0.p.d.m0.k.m, reason: use source file name */
/* JADX INFO: compiled from: OverridingUtil.java */
/* JADX INFO: loaded from: classes3.dex */
public final class OverridingUtil3 implements Function1<CallableMemberDescriptor, Boolean> {

    /* JADX INFO: renamed from: j */
    public final /* synthetic */ ClassDescriptor f24424j;

    public OverridingUtil3(ClassDescriptor classDescriptor) {
        this.f24424j = classDescriptor;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Boolean invoke(CallableMemberDescriptor callableMemberDescriptor) {
        return invoke2(callableMemberDescriptor);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public Boolean invoke2(CallableMemberDescriptor callableMemberDescriptor) {
        return Boolean.valueOf(!DescriptorVisibilities.isPrivate(callableMemberDescriptor.getVisibility()) && DescriptorVisibilities.isVisibleIgnoringReceiver(callableMemberDescriptor, this.f24424j));
    }
}

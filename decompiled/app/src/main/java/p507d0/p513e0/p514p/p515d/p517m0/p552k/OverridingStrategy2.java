package p507d0.p513e0.p514p.p515d.p517m0.p552k;

import java.util.Collection;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.CallableMemberDescriptor;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: renamed from: d0.e0.p.d.m0.k.j, reason: use source file name */
/* JADX INFO: compiled from: OverridingStrategy.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class OverridingStrategy2 {
    public abstract void addFakeOverride(CallableMemberDescriptor callableMemberDescriptor);

    public abstract void inheritanceConflict(CallableMemberDescriptor callableMemberDescriptor, CallableMemberDescriptor callableMemberDescriptor2);

    public abstract void overrideConflict(CallableMemberDescriptor callableMemberDescriptor, CallableMemberDescriptor callableMemberDescriptor2);

    public void setOverriddenDescriptors(CallableMemberDescriptor callableMemberDescriptor, Collection<? extends CallableMemberDescriptor> collection) {
        Intrinsics3.checkNotNullParameter(callableMemberDescriptor, "member");
        Intrinsics3.checkNotNullParameter(collection, "overridden");
        callableMemberDescriptor.setOverriddenDescriptors(collection);
    }
}

package p507d0.p513e0.p514p.p515d.p517m0.p552k;

import p507d0.p513e0.p514p.p515d.p517m0.p521c.CallableMemberDescriptor;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: OverridingStrategy.kt */
/* renamed from: d0.e0.p.d.m0.k.i, reason: use source file name */
/* loaded from: classes3.dex */
public abstract class OverridingStrategy extends OverridingStrategy2 {
    public abstract void conflict(CallableMemberDescriptor callableMemberDescriptor, CallableMemberDescriptor callableMemberDescriptor2);

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p552k.OverridingStrategy2
    public void inheritanceConflict(CallableMemberDescriptor callableMemberDescriptor, CallableMemberDescriptor callableMemberDescriptor2) {
        Intrinsics3.checkNotNullParameter(callableMemberDescriptor, "first");
        Intrinsics3.checkNotNullParameter(callableMemberDescriptor2, "second");
        conflict(callableMemberDescriptor, callableMemberDescriptor2);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p552k.OverridingStrategy2
    public void overrideConflict(CallableMemberDescriptor callableMemberDescriptor, CallableMemberDescriptor callableMemberDescriptor2) {
        Intrinsics3.checkNotNullParameter(callableMemberDescriptor, "fromSuper");
        Intrinsics3.checkNotNullParameter(callableMemberDescriptor2, "fromCurrent");
        conflict(callableMemberDescriptor, callableMemberDescriptor2);
    }
}

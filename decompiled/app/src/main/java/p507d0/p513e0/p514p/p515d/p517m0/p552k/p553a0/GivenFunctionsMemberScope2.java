package p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0;

import java.util.ArrayList;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.CallableMemberDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.DeclarationDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.OverridingStrategy;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.OverridingUtil;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: renamed from: d0.e0.p.d.m0.k.a0.f, reason: use source file name */
/* JADX INFO: compiled from: GivenFunctionsMemberScope.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class GivenFunctionsMemberScope2 extends OverridingStrategy {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ ArrayList<DeclarationDescriptor> f24365a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ GivenFunctionsMemberScope f24366b;

    public GivenFunctionsMemberScope2(ArrayList<DeclarationDescriptor> arrayList, GivenFunctionsMemberScope givenFunctionsMemberScope) {
        this.f24365a = arrayList;
        this.f24366b = givenFunctionsMemberScope;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p552k.OverridingStrategy2
    public void addFakeOverride(CallableMemberDescriptor callableMemberDescriptor) {
        Intrinsics3.checkNotNullParameter(callableMemberDescriptor, "fakeOverride");
        OverridingUtil.resolveUnknownVisibilityForMember(callableMemberDescriptor, null);
        this.f24365a.add(callableMemberDescriptor);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p552k.OverridingStrategy
    public void conflict(CallableMemberDescriptor callableMemberDescriptor, CallableMemberDescriptor callableMemberDescriptor2) {
        Intrinsics3.checkNotNullParameter(callableMemberDescriptor, "fromSuper");
        Intrinsics3.checkNotNullParameter(callableMemberDescriptor2, "fromCurrent");
        throw new IllegalStateException(("Conflict in scope of " + this.f24366b.f24363c + ": " + callableMemberDescriptor + " vs " + callableMemberDescriptor2).toString());
    }
}

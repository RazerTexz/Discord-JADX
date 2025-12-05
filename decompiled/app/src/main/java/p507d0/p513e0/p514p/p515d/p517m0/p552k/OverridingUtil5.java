package p507d0.p513e0.p514p.p515d.p517m0.p552k;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.CallableMemberDescriptor;

/* compiled from: OverridingUtil.java */
/* renamed from: d0.e0.p.d.m0.k.o, reason: use source file name */
/* loaded from: classes3.dex */
public final class OverridingUtil5 implements Function1<CallableMemberDescriptor, Unit> {

    /* renamed from: j */
    public final /* synthetic */ OverridingStrategy2 f24425j;

    /* renamed from: k */
    public final /* synthetic */ CallableMemberDescriptor f24426k;

    public OverridingUtil5(OverridingStrategy2 overridingStrategy2, CallableMemberDescriptor callableMemberDescriptor) {
        this.f24425j = overridingStrategy2;
        this.f24426k = callableMemberDescriptor;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(CallableMemberDescriptor callableMemberDescriptor) {
        return invoke2(callableMemberDescriptor);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public Unit invoke2(CallableMemberDescriptor callableMemberDescriptor) {
        this.f24425j.inheritanceConflict(this.f24426k, callableMemberDescriptor);
        return Unit.f27425a;
    }
}

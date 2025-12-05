package p507d0.p513e0.p514p.p515d.p517m0.p552k;

import p507d0.p513e0.p514p.p515d.p517m0.p521c.CallableDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.ClassDescriptor;

/* compiled from: ExternalOverridabilityCondition.java */
/* renamed from: d0.e0.p.d.m0.k.f, reason: use source file name */
/* loaded from: classes3.dex */
public interface ExternalOverridabilityCondition {

    /* compiled from: ExternalOverridabilityCondition.java */
    /* renamed from: d0.e0.p.d.m0.k.f$a */
    public enum a {
        CONFLICTS_ONLY,
        SUCCESS_ONLY,
        BOTH
    }

    /* compiled from: ExternalOverridabilityCondition.java */
    /* renamed from: d0.e0.p.d.m0.k.f$b */
    public enum b {
        OVERRIDABLE,
        CONFLICT,
        INCOMPATIBLE,
        UNKNOWN
    }

    a getContract();

    b isOverridable(CallableDescriptor callableDescriptor, CallableDescriptor callableDescriptor2, ClassDescriptor classDescriptor);
}

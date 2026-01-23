package p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1;

import p507d0.p513e0.p514p.p515d.p517m0.p521c.ClassDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.MemberScope3;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.TypeSubstitution5;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.p568l1.KotlinTypeRefiner;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: renamed from: d0.e0.p.d.m0.c.i1.v, reason: use source file name */
/* JADX INFO: compiled from: ModuleAwareClassDescriptor.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class ModuleAwareClassDescriptor2 {
    public static final MemberScope3 getRefinedMemberScopeIfPossible(ClassDescriptor classDescriptor, TypeSubstitution5 typeSubstitution5, KotlinTypeRefiner kotlinTypeRefiner) {
        Intrinsics3.checkNotNullParameter(classDescriptor, "<this>");
        Intrinsics3.checkNotNullParameter(typeSubstitution5, "typeSubstitution");
        Intrinsics3.checkNotNullParameter(kotlinTypeRefiner, "kotlinTypeRefiner");
        return ModuleAwareClassDescriptor.f22986j.getRefinedMemberScopeIfPossible$descriptors(classDescriptor, typeSubstitution5, kotlinTypeRefiner);
    }

    public static final MemberScope3 getRefinedUnsubstitutedMemberScopeIfPossible(ClassDescriptor classDescriptor, KotlinTypeRefiner kotlinTypeRefiner) {
        Intrinsics3.checkNotNullParameter(classDescriptor, "<this>");
        Intrinsics3.checkNotNullParameter(kotlinTypeRefiner, "kotlinTypeRefiner");
        return ModuleAwareClassDescriptor.f22986j.getRefinedUnsubstitutedMemberScopeIfPossible$descriptors(classDescriptor, kotlinTypeRefiner);
    }
}

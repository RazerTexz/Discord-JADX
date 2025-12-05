package p507d0.p513e0.p514p.p515d.p517m0.p518b.p520q;

import p507d0.p513e0.p514p.p515d.p517m0.p521c.CallableMemberDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p576p.DFS;

/* compiled from: JvmBuiltInsCustomizer.kt */
/* renamed from: d0.e0.p.d.m0.b.q.m, reason: use source file name */
/* loaded from: classes3.dex */
public final class JvmBuiltInsCustomizer8 implements DFS.c<CallableMemberDescriptor> {

    /* renamed from: a */
    public static final JvmBuiltInsCustomizer8 f22665a = new JvmBuiltInsCustomizer8();

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p576p.DFS.c
    public /* bridge */ /* synthetic */ Iterable<? extends CallableMemberDescriptor> getNeighbors(CallableMemberDescriptor callableMemberDescriptor) {
        return getNeighbors2(callableMemberDescriptor);
    }

    /* renamed from: getNeighbors, reason: avoid collision after fix types in other method */
    public final Iterable<CallableMemberDescriptor> getNeighbors2(CallableMemberDescriptor callableMemberDescriptor) {
        return callableMemberDescriptor.getOriginal().getOverriddenDescriptors();
    }
}

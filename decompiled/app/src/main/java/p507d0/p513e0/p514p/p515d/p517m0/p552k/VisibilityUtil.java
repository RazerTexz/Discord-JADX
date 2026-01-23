package p507d0.p513e0.p514p.p515d.p517m0.p552k;

import java.util.Collection;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.CallableMemberDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.DescriptorVisibilities;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: renamed from: d0.e0.p.d.m0.k.t, reason: use source file name */
/* JADX INFO: compiled from: VisibilityUtil.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class VisibilityUtil {
    public static final CallableMemberDescriptor findMemberWithMaxVisibility(Collection<? extends CallableMemberDescriptor> collection) {
        Integer numCompare;
        Intrinsics3.checkNotNullParameter(collection, "descriptors");
        collection.isEmpty();
        CallableMemberDescriptor callableMemberDescriptor = null;
        for (CallableMemberDescriptor callableMemberDescriptor2 : collection) {
            if (callableMemberDescriptor == null || ((numCompare = DescriptorVisibilities.compare(callableMemberDescriptor.getVisibility(), callableMemberDescriptor2.getVisibility())) != null && numCompare.intValue() < 0)) {
                callableMemberDescriptor = callableMemberDescriptor2;
            }
        }
        Intrinsics3.checkNotNull(callableMemberDescriptor);
        return callableMemberDescriptor;
    }
}

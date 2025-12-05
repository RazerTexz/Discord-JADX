package p507d0.p513e0.p514p.p515d.p517m0.p518b;

import java.util.Set;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.ClassDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.ClassId;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.DescriptorUtils;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p559x.DescriptorUtils2;
import p507d0.p580t._Collections;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: CompanionObjectMappingUtils.kt */
/* renamed from: d0.e0.p.d.m0.b.d, reason: use source file name */
/* loaded from: classes3.dex */
public final class CompanionObjectMappingUtils {
    public static final boolean isMappedIntrinsicCompanionObject(CompanionObjectMapping companionObjectMapping, ClassDescriptor classDescriptor) {
        Intrinsics3.checkNotNullParameter(companionObjectMapping, "<this>");
        Intrinsics3.checkNotNullParameter(classDescriptor, "classDescriptor");
        if (DescriptorUtils.isCompanionObject(classDescriptor)) {
            Set<ClassId> classIds = companionObjectMapping.getClassIds();
            ClassId classId = DescriptorUtils2.getClassId(classDescriptor);
            if (_Collections.contains(classIds, classId == null ? null : classId.getOuterClassId())) {
                return true;
            }
        }
        return false;
    }
}

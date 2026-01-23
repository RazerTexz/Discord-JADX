package p507d0.p513e0.p514p.p515d.p517m0.p531e.p541b;

import p507d0.p513e0.p514p.p515d.p517m0.p521c.ClassDescriptor;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: renamed from: d0.e0.p.d.m0.e.b.t, reason: use source file name */
/* JADX INFO: compiled from: methodSignatureBuildingUtils.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class methodSignatureBuildingUtils {
    public static final String signature(SignatureBuildingComponents signatureBuildingComponents, ClassDescriptor classDescriptor, String str) {
        Intrinsics3.checkNotNullParameter(signatureBuildingComponents, "<this>");
        Intrinsics3.checkNotNullParameter(classDescriptor, "classDescriptor");
        Intrinsics3.checkNotNullParameter(str, "jvmDescriptor");
        return signatureBuildingComponents.signature(methodSignatureMapping3.getInternalName(classDescriptor), str);
    }
}

package p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a;

import java.util.EnumMap;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: renamed from: d0.e0.p.d.m0.e.a.y, reason: use source file name */
/* JADX INFO: compiled from: JavaTypeQualifiersByElementType.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class JavaTypeQualifiersByElementType {

    /* JADX INFO: renamed from: a */
    public final EnumMap<AnnotationQualifierApplicabilityType, AnnotationQualifiersFqNames2> f23530a;

    public JavaTypeQualifiersByElementType(EnumMap<AnnotationQualifierApplicabilityType, AnnotationQualifiersFqNames2> enumMap) {
        Intrinsics3.checkNotNullParameter(enumMap, "defaultQualifiers");
        this.f23530a = enumMap;
    }

    public final AnnotationQualifiersFqNames2 get(AnnotationQualifierApplicabilityType annotationQualifierApplicabilityType) {
        return this.f23530a.get(annotationQualifierApplicabilityType);
    }

    public final EnumMap<AnnotationQualifierApplicabilityType, AnnotationQualifiersFqNames2> getDefaultQualifiers() {
        return this.f23530a;
    }
}

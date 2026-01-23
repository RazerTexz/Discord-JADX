package p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a;

import kotlin.jvm.functions.Function2;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p557v.C11818j;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;

/* JADX INFO: renamed from: d0.e0.p.d.m0.e.a.d, reason: use source file name */
/* JADX INFO: compiled from: AnnotationTypeQualifierResolver.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class AnnotationTypeQualifierResolver2 extends Lambda implements Function2<C11818j, AnnotationQualifierApplicabilityType, Boolean> {

    /* JADX INFO: renamed from: j */
    public static final AnnotationTypeQualifierResolver2 f23191j = new AnnotationTypeQualifierResolver2();

    public AnnotationTypeQualifierResolver2() {
        super(2);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Boolean invoke(C11818j c11818j, AnnotationQualifierApplicabilityType annotationQualifierApplicabilityType) {
        return Boolean.valueOf(invoke2(c11818j, annotationQualifierApplicabilityType));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final boolean invoke2(C11818j c11818j, AnnotationQualifierApplicabilityType annotationQualifierApplicabilityType) {
        Intrinsics3.checkNotNullParameter(c11818j, "<this>");
        Intrinsics3.checkNotNullParameter(annotationQualifierApplicabilityType, "it");
        return Intrinsics3.areEqual(c11818j.getEnumEntryName().getIdentifier(), annotationQualifierApplicabilityType.getJavaTarget());
    }
}

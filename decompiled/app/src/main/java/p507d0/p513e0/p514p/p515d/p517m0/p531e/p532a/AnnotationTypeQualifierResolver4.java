package p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a;

import p507d0.p513e0.p514p.p515d.p517m0.p521c.ClassDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p559x.DescriptorUtils2;

/* compiled from: AnnotationTypeQualifierResolver.kt */
/* renamed from: d0.e0.p.d.m0.e.a.f, reason: use source file name */
/* loaded from: classes3.dex */
public final class AnnotationTypeQualifierResolver4 {
    public static final boolean access$isAnnotatedWithTypeQualifier(ClassDescriptor classDescriptor) {
        return AnnotationQualifiersFqNames.getBUILT_IN_TYPE_QUALIFIER_FQ_NAMES().contains(DescriptorUtils2.getFqNameSafe(classDescriptor)) || classDescriptor.getAnnotations().hasAnnotation(AnnotationQualifiersFqNames.getTYPE_QUALIFIER_FQNAME());
    }
}

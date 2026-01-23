package p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a;

import java.util.List;
import java.util.Map;
import java.util.Set;
import p507d0.Tuples;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p540l0.NullabilityQualifierWithMigrationStatus;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p540l0.typeQualifiers3;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.FqName;
import p507d0.p580t.Collections2;
import p507d0.p580t.CollectionsJVM;
import p507d0.p580t.Maps6;
import p507d0.p580t.MapsJVM;
import p507d0.p580t.Sets5;

/* JADX INFO: renamed from: d0.e0.p.d.m0.e.a.b, reason: use source file name */
/* JADX INFO: compiled from: AnnotationQualifiersFqNames.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class AnnotationQualifiersFqNames {

    /* JADX INFO: renamed from: a */
    public static final FqName f23166a = new FqName("javax.annotation.meta.TypeQualifierNickname");

    /* JADX INFO: renamed from: b */
    public static final FqName f23167b = new FqName("javax.annotation.meta.TypeQualifier");

    /* JADX INFO: renamed from: c */
    public static final FqName f23168c = new FqName("javax.annotation.meta.TypeQualifierDefault");

    /* JADX INFO: renamed from: d */
    public static final FqName f23169d = new FqName("kotlin.annotations.jvm.UnderMigration");

    /* JADX INFO: renamed from: e */
    public static final List<AnnotationQualifierApplicabilityType> f23170e;

    /* JADX INFO: renamed from: f */
    public static final Map<FqName, AnnotationQualifiersFqNames2> f23171f;

    /* JADX INFO: renamed from: g */
    public static final Map<FqName, AnnotationQualifiersFqNames2> f23172g;

    /* JADX INFO: renamed from: h */
    public static final Set<FqName> f23173h;

    static {
        AnnotationQualifierApplicabilityType annotationQualifierApplicabilityType = AnnotationQualifierApplicabilityType.VALUE_PARAMETER;
        List<AnnotationQualifierApplicabilityType> listListOf = Collections2.listOf((Object[]) new AnnotationQualifierApplicabilityType[]{AnnotationQualifierApplicabilityType.FIELD, AnnotationQualifierApplicabilityType.METHOD_RETURN_TYPE, annotationQualifierApplicabilityType, AnnotationQualifierApplicabilityType.TYPE_PARAMETER_BOUNDS, AnnotationQualifierApplicabilityType.TYPE_USE});
        f23170e = listListOf;
        FqName jspecify_default_not_null = JvmAnnotationNames2.getJSPECIFY_DEFAULT_NOT_NULL();
        typeQualifiers3 typequalifiers3 = typeQualifiers3.NOT_NULL;
        Map<FqName, AnnotationQualifiersFqNames2> mapMapOf = MapsJVM.mapOf(Tuples.m10073to(jspecify_default_not_null, new AnnotationQualifiersFqNames2(new NullabilityQualifierWithMigrationStatus(typequalifiers3, false, 2, null), listListOf, false)));
        f23171f = mapMapOf;
        f23172g = Maps6.plus(Maps6.mapOf(Tuples.m10073to(new FqName("javax.annotation.ParametersAreNullableByDefault"), new AnnotationQualifiersFqNames2(new NullabilityQualifierWithMigrationStatus(typeQualifiers3.NULLABLE, false, 2, null), CollectionsJVM.listOf(annotationQualifierApplicabilityType), false, 4, null)), Tuples.m10073to(new FqName("javax.annotation.ParametersAreNonnullByDefault"), new AnnotationQualifiersFqNames2(new NullabilityQualifierWithMigrationStatus(typequalifiers3, false, 2, null), CollectionsJVM.listOf(annotationQualifierApplicabilityType), false, 4, null))), mapMapOf);
        f23173h = Sets5.setOf((Object[]) new FqName[]{JvmAnnotationNames2.getJAVAX_NONNULL_ANNOTATION(), JvmAnnotationNames2.getJAVAX_CHECKFORNULL_ANNOTATION()});
    }

    public static final Map<FqName, AnnotationQualifiersFqNames2> getBUILT_IN_TYPE_QUALIFIER_DEFAULT_ANNOTATIONS() {
        return f23172g;
    }

    public static final Set<FqName> getBUILT_IN_TYPE_QUALIFIER_FQ_NAMES() {
        return f23173h;
    }

    public static final Map<FqName, AnnotationQualifiersFqNames2> getJSPECIFY_DEFAULT_ANNOTATIONS() {
        return f23171f;
    }

    public static final FqName getMIGRATION_ANNOTATION_FQNAME() {
        return f23169d;
    }

    public static final FqName getTYPE_QUALIFIER_DEFAULT_FQNAME() {
        return f23168c;
    }

    public static final FqName getTYPE_QUALIFIER_FQNAME() {
        return f23167b;
    }

    public static final FqName getTYPE_QUALIFIER_NICKNAME_FQNAME() {
        return f23166a;
    }
}

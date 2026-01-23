package p507d0.p513e0.p514p.p515d.p517m0.p567n;

import p507d0.p513e0.p514p.p515d.p517m0.p521c.TypeAliasDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.TypeParameterDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1.AnnotationDescriptor;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: renamed from: d0.e0.p.d.m0.n.s0, reason: use source file name */
/* JADX INFO: compiled from: TypeAliasExpansionReportStrategy.kt */
/* JADX INFO: loaded from: classes3.dex */
public interface TypeAliasExpansionReportStrategy {

    /* JADX INFO: renamed from: d0.e0.p.d.m0.n.s0$a */
    /* JADX INFO: compiled from: TypeAliasExpansionReportStrategy.kt */
    public static final class a implements TypeAliasExpansionReportStrategy {

        /* JADX INFO: renamed from: a */
        public static final a f24876a = new a();

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.TypeAliasExpansionReportStrategy
        public void boundsViolationInSubstitution(KotlinType kotlinType, KotlinType kotlinType2, KotlinType kotlinType3, TypeParameterDescriptor typeParameterDescriptor) {
            Intrinsics3.checkNotNullParameter(kotlinType, "bound");
            Intrinsics3.checkNotNullParameter(kotlinType2, "unsubstitutedArgument");
            Intrinsics3.checkNotNullParameter(kotlinType3, "argument");
            Intrinsics3.checkNotNullParameter(typeParameterDescriptor, "typeParameter");
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.TypeAliasExpansionReportStrategy
        public void conflictingProjection(TypeAliasDescriptor typeAliasDescriptor, TypeParameterDescriptor typeParameterDescriptor, KotlinType kotlinType) {
            Intrinsics3.checkNotNullParameter(typeAliasDescriptor, "typeAlias");
            Intrinsics3.checkNotNullParameter(kotlinType, "substitutedArgument");
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.TypeAliasExpansionReportStrategy
        public void recursiveTypeAlias(TypeAliasDescriptor typeAliasDescriptor) {
            Intrinsics3.checkNotNullParameter(typeAliasDescriptor, "typeAlias");
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.TypeAliasExpansionReportStrategy
        public void repeatedAnnotation(AnnotationDescriptor annotationDescriptor) {
            Intrinsics3.checkNotNullParameter(annotationDescriptor, "annotation");
        }
    }

    void boundsViolationInSubstitution(KotlinType kotlinType, KotlinType kotlinType2, KotlinType kotlinType3, TypeParameterDescriptor typeParameterDescriptor);

    void conflictingProjection(TypeAliasDescriptor typeAliasDescriptor, TypeParameterDescriptor typeParameterDescriptor, KotlinType kotlinType);

    void recursiveTypeAlias(TypeAliasDescriptor typeAliasDescriptor);

    void repeatedAnnotation(AnnotationDescriptor annotationDescriptor);
}

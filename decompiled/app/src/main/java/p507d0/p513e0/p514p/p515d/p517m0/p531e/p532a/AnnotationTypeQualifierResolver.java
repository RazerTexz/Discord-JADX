package p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.reflect.KDeclarationContainer;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.ClassDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.ClassKind;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1.AnnotationDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1.Annotations4;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1.KotlinTarget;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p533g0.JavaAnnotationMapper3;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p540l0.NullabilityQualifierWithMigrationStatus;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.FqName;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.Name;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p557v.AbstractC11815g;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p557v.C11809b;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p557v.C11818j;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p559x.DescriptorUtils2;
import p507d0.p513e0.p514p.p515d.p517m0.p566m.StorageManager;
import p507d0.p513e0.p514p.p515d.p517m0.p566m.storage4;
import p507d0.p513e0.p514p.p515d.p517m0.p576p.JavaTypeEnhancementState;
import p507d0.p513e0.p514p.p515d.p517m0.p576p.JavaTypeEnhancementState2;
import p507d0.p580t.Collections2;
import p507d0.p580t.Iterables2;
import p507d0.p580t.MutableCollections;
import p507d0.p592z.p594d.FunctionReference;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Reflection2;

/* JADX INFO: renamed from: d0.e0.p.d.m0.e.a.c, reason: use source file name */
/* JADX INFO: compiled from: AnnotationTypeQualifierResolver.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class AnnotationTypeQualifierResolver {

    /* JADX INFO: renamed from: a */
    public final JavaTypeEnhancementState f23187a;

    /* JADX INFO: renamed from: b */
    public final storage4<ClassDescriptor, AnnotationDescriptor> f23188b;

    /* JADX INFO: renamed from: d0.e0.p.d.m0.e.a.c$a */
    /* JADX INFO: compiled from: AnnotationTypeQualifierResolver.kt */
    public static final class a {

        /* JADX INFO: renamed from: a */
        public final AnnotationDescriptor f23189a;

        /* JADX INFO: renamed from: b */
        public final int f23190b;

        public a(AnnotationDescriptor annotationDescriptor, int i) {
            Intrinsics3.checkNotNullParameter(annotationDescriptor, "typeQualifier");
            this.f23189a = annotationDescriptor;
            this.f23190b = i;
        }

        public final AnnotationDescriptor component1() {
            return this.f23189a;
        }

        public final List<AnnotationQualifierApplicabilityType> component2() {
            AnnotationQualifierApplicabilityType[] annotationQualifierApplicabilityTypeArrValuesCustom = AnnotationQualifierApplicabilityType.valuesCustom();
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < 6; i++) {
                AnnotationQualifierApplicabilityType annotationQualifierApplicabilityType = annotationQualifierApplicabilityTypeArrValuesCustom[i];
                boolean z2 = true;
                if (!((this.f23190b & (1 << annotationQualifierApplicabilityType.ordinal())) != 0)) {
                    if (!((this.f23190b & 8) != 0) || annotationQualifierApplicabilityType == AnnotationQualifierApplicabilityType.TYPE_PARAMETER_BOUNDS) {
                        z2 = false;
                    }
                }
                if (z2) {
                    arrayList.add(annotationQualifierApplicabilityType);
                }
            }
            return arrayList;
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.e.a.c$b */
    /* JADX INFO: compiled from: AnnotationTypeQualifierResolver.kt */
    public /* synthetic */ class b extends FunctionReference implements Function1<ClassDescriptor, AnnotationDescriptor> {
        public b(AnnotationTypeQualifierResolver annotationTypeQualifierResolver) {
            super(1, annotationTypeQualifierResolver);
        }

        @Override // p507d0.p592z.p594d.CallableReference, kotlin.reflect.KCallable
        public final String getName() {
            return "computeTypeQualifierNickname";
        }

        @Override // p507d0.p592z.p594d.CallableReference
        public final KDeclarationContainer getOwner() {
            return Reflection2.getOrCreateKotlinClass(AnnotationTypeQualifierResolver.class);
        }

        @Override // p507d0.p592z.p594d.CallableReference
        public final String getSignature() {
            return "computeTypeQualifierNickname(Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;)Lorg/jetbrains/kotlin/descriptors/annotations/AnnotationDescriptor;";
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ AnnotationDescriptor invoke(ClassDescriptor classDescriptor) {
            return invoke2(classDescriptor);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final AnnotationDescriptor invoke2(ClassDescriptor classDescriptor) {
            Intrinsics3.checkNotNullParameter(classDescriptor, "p0");
            return AnnotationTypeQualifierResolver.access$computeTypeQualifierNickname((AnnotationTypeQualifierResolver) this.receiver, classDescriptor);
        }
    }

    public AnnotationTypeQualifierResolver(StorageManager storageManager, JavaTypeEnhancementState javaTypeEnhancementState) {
        Intrinsics3.checkNotNullParameter(storageManager, "storageManager");
        Intrinsics3.checkNotNullParameter(javaTypeEnhancementState, "javaTypeEnhancementState");
        this.f23187a = javaTypeEnhancementState;
        this.f23188b = storageManager.createMemoizedFunctionWithNullableValues(new b(this));
    }

    public static final AnnotationDescriptor access$computeTypeQualifierNickname(AnnotationTypeQualifierResolver annotationTypeQualifierResolver, ClassDescriptor classDescriptor) {
        Objects.requireNonNull(annotationTypeQualifierResolver);
        if (!classDescriptor.getAnnotations().hasAnnotation(AnnotationQualifiersFqNames.getTYPE_QUALIFIER_NICKNAME_FQNAME())) {
            return null;
        }
        Iterator<AnnotationDescriptor> it = classDescriptor.getAnnotations().iterator();
        while (it.hasNext()) {
            AnnotationDescriptor annotationDescriptorResolveTypeQualifierAnnotation = annotationTypeQualifierResolver.resolveTypeQualifierAnnotation(it.next());
            if (annotationDescriptorResolveTypeQualifierAnnotation != null) {
                return annotationDescriptorResolveTypeQualifierAnnotation;
            }
        }
        return null;
    }

    public static final List access$toKotlinTargetNames(AnnotationTypeQualifierResolver annotationTypeQualifierResolver, String str) {
        Objects.requireNonNull(annotationTypeQualifierResolver);
        Set<KotlinTarget> setMapJavaTargetArgumentByName = JavaAnnotationMapper3.f23236a.mapJavaTargetArgumentByName(str);
        ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(setMapJavaTargetArgumentByName, 10));
        Iterator<T> it = setMapJavaTargetArgumentByName.iterator();
        while (it.hasNext()) {
            arrayList.add(((KotlinTarget) it.next()).name());
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: a */
    public final List<AnnotationQualifierApplicabilityType> m9448a(AbstractC11815g<?> abstractC11815g, Function2<? super C11818j, ? super AnnotationQualifierApplicabilityType, Boolean> function2) {
        AnnotationQualifierApplicabilityType annotationQualifierApplicabilityType;
        if (abstractC11815g instanceof C11809b) {
            List<? extends AbstractC11815g<?>> value = ((C11809b) abstractC11815g).getValue();
            ArrayList arrayList = new ArrayList();
            Iterator<T> it = value.iterator();
            while (it.hasNext()) {
                MutableCollections.addAll(arrayList, m9448a((AbstractC11815g) it.next(), function2));
            }
            return arrayList;
        }
        if (!(abstractC11815g instanceof C11818j)) {
            return Collections2.emptyList();
        }
        AnnotationQualifierApplicabilityType[] annotationQualifierApplicabilityTypeArrValuesCustom = AnnotationQualifierApplicabilityType.valuesCustom();
        int i = 0;
        while (true) {
            if (i >= 6) {
                annotationQualifierApplicabilityType = null;
                break;
            }
            annotationQualifierApplicabilityType = annotationQualifierApplicabilityTypeArrValuesCustom[i];
            if (function2.invoke(abstractC11815g, annotationQualifierApplicabilityType).booleanValue()) {
                break;
            }
            i++;
        }
        return Collections2.listOfNotNull(annotationQualifierApplicabilityType);
    }

    public final a resolveAnnotation(AnnotationDescriptor annotationDescriptor) {
        Intrinsics3.checkNotNullParameter(annotationDescriptor, "annotationDescriptor");
        ClassDescriptor annotationClass = DescriptorUtils2.getAnnotationClass(annotationDescriptor);
        if (annotationClass == null) {
            return null;
        }
        Annotations4 annotations = annotationClass.getAnnotations();
        FqName fqName = JvmAnnotationNames.f23149c;
        Intrinsics3.checkNotNullExpressionValue(fqName, "TARGET_ANNOTATION");
        AnnotationDescriptor annotationDescriptorFindAnnotation = annotations.findAnnotation(fqName);
        if (annotationDescriptorFindAnnotation == null) {
            return null;
        }
        Map<Name, AbstractC11815g<?>> allValueArguments = annotationDescriptorFindAnnotation.getAllValueArguments();
        ArrayList arrayList = new ArrayList();
        Iterator<Map.Entry<Name, AbstractC11815g<?>>> it = allValueArguments.entrySet().iterator();
        while (it.hasNext()) {
            MutableCollections.addAll(arrayList, m9448a(it.next().getValue(), new AnnotationTypeQualifierResolver3(this)));
        }
        int iOrdinal = 0;
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            iOrdinal |= 1 << ((AnnotationQualifierApplicabilityType) it2.next()).ordinal();
        }
        return new a(annotationDescriptor, iOrdinal);
    }

    public final JavaTypeEnhancementState2 resolveJsr305AnnotationState(AnnotationDescriptor annotationDescriptor) {
        Intrinsics3.checkNotNullParameter(annotationDescriptor, "annotationDescriptor");
        JavaTypeEnhancementState2 javaTypeEnhancementState2ResolveJsr305CustomState = resolveJsr305CustomState(annotationDescriptor);
        return javaTypeEnhancementState2ResolveJsr305CustomState == null ? this.f23187a.getGlobalJsr305Level() : javaTypeEnhancementState2ResolveJsr305CustomState;
    }

    public final JavaTypeEnhancementState2 resolveJsr305CustomState(AnnotationDescriptor annotationDescriptor) {
        Intrinsics3.checkNotNullParameter(annotationDescriptor, "annotationDescriptor");
        Map<String, JavaTypeEnhancementState2> userDefinedLevelForSpecificJsr305Annotation = this.f23187a.getUserDefinedLevelForSpecificJsr305Annotation();
        FqName fqName = annotationDescriptor.getFqName();
        JavaTypeEnhancementState2 javaTypeEnhancementState2 = userDefinedLevelForSpecificJsr305Annotation.get(fqName == null ? null : fqName.asString());
        if (javaTypeEnhancementState2 != null) {
            return javaTypeEnhancementState2;
        }
        ClassDescriptor annotationClass = DescriptorUtils2.getAnnotationClass(annotationDescriptor);
        if (annotationClass == null) {
            return null;
        }
        AnnotationDescriptor annotationDescriptorFindAnnotation = annotationClass.getAnnotations().findAnnotation(AnnotationQualifiersFqNames.getMIGRATION_ANNOTATION_FQNAME());
        AbstractC11815g<?> abstractC11815gFirstArgument = annotationDescriptorFindAnnotation == null ? null : DescriptorUtils2.firstArgument(annotationDescriptorFindAnnotation);
        C11818j c11818j = abstractC11815gFirstArgument instanceof C11818j ? (C11818j) abstractC11815gFirstArgument : null;
        if (c11818j == null) {
            return null;
        }
        JavaTypeEnhancementState2 migrationLevelForJsr305 = this.f23187a.getMigrationLevelForJsr305();
        if (migrationLevelForJsr305 != null) {
            return migrationLevelForJsr305;
        }
        String strAsString = c11818j.getEnumEntryName().asString();
        int iHashCode = strAsString.hashCode();
        if (iHashCode == -2137067054) {
            if (strAsString.equals("IGNORE")) {
                return JavaTypeEnhancementState2.IGNORE;
            }
            return null;
        }
        if (iHashCode == -1838656823) {
            if (strAsString.equals("STRICT")) {
                return JavaTypeEnhancementState2.STRICT;
            }
            return null;
        }
        if (iHashCode == 2656902 && strAsString.equals("WARN")) {
            return JavaTypeEnhancementState2.WARN;
        }
        return null;
    }

    public final AnnotationQualifiersFqNames2 resolveQualifierBuiltInDefaultAnnotation(AnnotationDescriptor annotationDescriptor) {
        AnnotationQualifiersFqNames2 annotationQualifiersFqNames2;
        Intrinsics3.checkNotNullParameter(annotationDescriptor, "annotationDescriptor");
        if (this.f23187a.getDisabledDefaultAnnotations() || (annotationQualifiersFqNames2 = AnnotationQualifiersFqNames.getBUILT_IN_TYPE_QUALIFIER_DEFAULT_ANNOTATIONS().get(annotationDescriptor.getFqName())) == null) {
            return null;
        }
        JavaTypeEnhancementState2 jspecifyReportLevel = AnnotationQualifiersFqNames.getJSPECIFY_DEFAULT_ANNOTATIONS().containsKey(annotationDescriptor.getFqName()) ? this.f23187a.getJspecifyReportLevel() : resolveJsr305AnnotationState(annotationDescriptor);
        if (!(jspecifyReportLevel != JavaTypeEnhancementState2.IGNORE)) {
            jspecifyReportLevel = null;
        }
        if (jspecifyReportLevel == null) {
            return null;
        }
        return AnnotationQualifiersFqNames2.copy$default(annotationQualifiersFqNames2, NullabilityQualifierWithMigrationStatus.copy$default(annotationQualifiersFqNames2.getNullabilityQualifier(), null, jspecifyReportLevel.isWarning(), 1, null), null, false, 6, null);
    }

    public final AnnotationDescriptor resolveTypeQualifierAnnotation(AnnotationDescriptor annotationDescriptor) {
        ClassDescriptor annotationClass;
        Intrinsics3.checkNotNullParameter(annotationDescriptor, "annotationDescriptor");
        if (this.f23187a.getDisabledJsr305() || (annotationClass = DescriptorUtils2.getAnnotationClass(annotationDescriptor)) == null) {
            return null;
        }
        if (AnnotationTypeQualifierResolver4.access$isAnnotatedWithTypeQualifier(annotationClass)) {
            return annotationDescriptor;
        }
        if (annotationClass.getKind() != ClassKind.ANNOTATION_CLASS) {
            return null;
        }
        return this.f23188b.invoke(annotationClass);
    }

    public final a resolveTypeQualifierDefaultAnnotation(AnnotationDescriptor annotationDescriptor) {
        AnnotationDescriptor next;
        Intrinsics3.checkNotNullParameter(annotationDescriptor, "annotationDescriptor");
        if (this.f23187a.getDisabledJsr305()) {
            return null;
        }
        ClassDescriptor annotationClass = DescriptorUtils2.getAnnotationClass(annotationDescriptor);
        if (annotationClass == null || !annotationClass.getAnnotations().hasAnnotation(AnnotationQualifiersFqNames.getTYPE_QUALIFIER_DEFAULT_FQNAME())) {
            annotationClass = null;
        }
        if (annotationClass == null) {
            return null;
        }
        ClassDescriptor annotationClass2 = DescriptorUtils2.getAnnotationClass(annotationDescriptor);
        Intrinsics3.checkNotNull(annotationClass2);
        AnnotationDescriptor annotationDescriptorFindAnnotation = annotationClass2.getAnnotations().findAnnotation(AnnotationQualifiersFqNames.getTYPE_QUALIFIER_DEFAULT_FQNAME());
        Intrinsics3.checkNotNull(annotationDescriptorFindAnnotation);
        Map<Name, AbstractC11815g<?>> allValueArguments = annotationDescriptorFindAnnotation.getAllValueArguments();
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<Name, AbstractC11815g<?>> entry : allValueArguments.entrySet()) {
            MutableCollections.addAll(arrayList, Intrinsics3.areEqual(entry.getKey(), JvmAnnotationNames.f23148b) ? m9448a(entry.getValue(), AnnotationTypeQualifierResolver2.f23191j) : Collections2.emptyList());
        }
        Iterator it = arrayList.iterator();
        int iOrdinal = 0;
        while (it.hasNext()) {
            iOrdinal |= 1 << ((AnnotationQualifierApplicabilityType) it.next()).ordinal();
        }
        Iterator<AnnotationDescriptor> it2 = annotationClass.getAnnotations().iterator();
        while (true) {
            if (!it2.hasNext()) {
                next = null;
                break;
            }
            next = it2.next();
            if (resolveTypeQualifierAnnotation(next) != null) {
                break;
            }
        }
        AnnotationDescriptor annotationDescriptor2 = next;
        if (annotationDescriptor2 == null) {
            return null;
        }
        return new a(annotationDescriptor2, iOrdinal);
    }
}

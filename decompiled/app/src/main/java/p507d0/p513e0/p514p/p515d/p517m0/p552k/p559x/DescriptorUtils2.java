package p507d0.p513e0.p514p.p515d.p517m0.p552k.p559x;

import com.discord.models.domain.ModelAuditLogEntry;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Objects;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlin.reflect.KDeclarationContainer;
import kotlin.sequences.Sequence;
import p507d0.p513e0.p514p.p515d.p517m0.p518b.KotlinBuiltIns;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.CallableMemberDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.ClassDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.ClassifierDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.ClassifierDescriptorWithTypeParameters;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.DeclarationDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.ModuleDescriptor2;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.PackageFragmentDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.PropertyAccessorDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.PropertyDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.ValueParameterDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1.AnnotationDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p529d.p530b.LookupLocation2;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.ClassId;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.FqName;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.FqNameUnsafe;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.Name;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.DescriptorUtils;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.MemberScope3;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p557v.AbstractC11815g;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.p568l1.KotlinTypeRefiner;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.p568l1.KotlinTypeRefiner2;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.p568l1.KotlinTypeRefiner3;
import p507d0.p513e0.p514p.p515d.p517m0.p576p.DFS;
import p507d0.p578f0.C12075n;
import p507d0.p578f0._Sequences2;
import p507d0.p580t.Collections2;
import p507d0.p580t.CollectionsJVM;
import p507d0.p580t.Iterables2;
import p507d0.p580t._Collections;
import p507d0.p592z.p594d.FunctionReference;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;
import p507d0.p592z.p594d.Reflection2;

/* JADX INFO: renamed from: d0.e0.p.d.m0.k.x.a, reason: use source file name */
/* JADX INFO: compiled from: DescriptorUtils.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class DescriptorUtils2 {

    /* JADX INFO: renamed from: d0.e0.p.d.m0.k.x.a$a */
    /* JADX INFO: compiled from: DescriptorUtils.kt */
    public static final class a implements DFS.c<ValueParameterDescriptor> {

        /* JADX INFO: renamed from: a */
        public static final a f24455a = new a();

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p576p.DFS.c
        public /* bridge */ /* synthetic */ Iterable<? extends ValueParameterDescriptor> getNeighbors(ValueParameterDescriptor valueParameterDescriptor) {
            return getNeighbors2(valueParameterDescriptor);
        }

        /* JADX INFO: renamed from: getNeighbors, reason: avoid collision after fix types in other method */
        public final Iterable<ValueParameterDescriptor> getNeighbors2(ValueParameterDescriptor valueParameterDescriptor) {
            Collection<ValueParameterDescriptor> overriddenDescriptors = valueParameterDescriptor.getOverriddenDescriptors();
            ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(overriddenDescriptors, 10));
            Iterator<T> it = overriddenDescriptors.iterator();
            while (it.hasNext()) {
                arrayList.add(((ValueParameterDescriptor) it.next()).getOriginal());
            }
            return arrayList;
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.k.x.a$b */
    /* JADX INFO: compiled from: DescriptorUtils.kt */
    public /* synthetic */ class b extends FunctionReference implements Function1<ValueParameterDescriptor, Boolean> {

        /* JADX INFO: renamed from: j */
        public static final b f24456j = new b();

        public b() {
            super(1);
        }

        @Override // p507d0.p592z.p594d.CallableReference, kotlin.reflect.KCallable
        public final String getName() {
            return "declaresDefaultValue";
        }

        @Override // p507d0.p592z.p594d.CallableReference
        public final KDeclarationContainer getOwner() {
            return Reflection2.getOrCreateKotlinClass(ValueParameterDescriptor.class);
        }

        @Override // p507d0.p592z.p594d.CallableReference
        public final String getSignature() {
            return "declaresDefaultValue()Z";
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Boolean invoke(ValueParameterDescriptor valueParameterDescriptor) {
            return Boolean.valueOf(invoke2(valueParameterDescriptor));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final boolean invoke2(ValueParameterDescriptor valueParameterDescriptor) {
            Intrinsics3.checkNotNullParameter(valueParameterDescriptor, "p0");
            return valueParameterDescriptor.declaresDefaultValue();
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.k.x.a$c */
    /* JADX INFO: compiled from: DescriptorUtils.kt */
    public static final class c implements DFS.c<CallableMemberDescriptor> {

        /* JADX INFO: renamed from: a */
        public final /* synthetic */ boolean f24457a;

        public c(boolean z2) {
            this.f24457a = z2;
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p576p.DFS.c
        public /* bridge */ /* synthetic */ Iterable<? extends CallableMemberDescriptor> getNeighbors(CallableMemberDescriptor callableMemberDescriptor) {
            return getNeighbors2(callableMemberDescriptor);
        }

        /* JADX INFO: renamed from: getNeighbors, reason: avoid collision after fix types in other method */
        public final Iterable<CallableMemberDescriptor> getNeighbors2(CallableMemberDescriptor callableMemberDescriptor) {
            if (this.f24457a) {
                callableMemberDescriptor = callableMemberDescriptor == null ? null : callableMemberDescriptor.getOriginal();
            }
            Collection<? extends CallableMemberDescriptor> overriddenDescriptors = callableMemberDescriptor != null ? callableMemberDescriptor.getOverriddenDescriptors() : null;
            return overriddenDescriptors == null ? Collections2.emptyList() : overriddenDescriptors;
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.k.x.a$d */
    /* JADX INFO: compiled from: DescriptorUtils.kt */
    public static final class d extends DFS.b<CallableMemberDescriptor, CallableMemberDescriptor> {

        /* JADX INFO: renamed from: a */
        public final /* synthetic */ Ref$ObjectRef<CallableMemberDescriptor> f24458a;

        /* JADX INFO: renamed from: b */
        public final /* synthetic */ Function1<CallableMemberDescriptor, Boolean> f24459b;

        /* JADX WARN: Multi-variable type inference failed */
        public d(Ref$ObjectRef<CallableMemberDescriptor> ref$ObjectRef, Function1<? super CallableMemberDescriptor, Boolean> function1) {
            this.f24458a = ref$ObjectRef;
            this.f24459b = function1;
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p576p.DFS.b, p507d0.p513e0.p514p.p515d.p517m0.p576p.DFS.d
        public /* bridge */ /* synthetic */ void afterChildren(Object obj) {
            afterChildren((CallableMemberDescriptor) obj);
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p576p.DFS.d
        public /* bridge */ /* synthetic */ boolean beforeChildren(Object obj) {
            return beforeChildren((CallableMemberDescriptor) obj);
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p576p.DFS.d
        public /* bridge */ /* synthetic */ Object result() {
            return result();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public void afterChildren(CallableMemberDescriptor callableMemberDescriptor) {
            Intrinsics3.checkNotNullParameter(callableMemberDescriptor, "current");
            if (this.f24458a.element == null && this.f24459b.invoke(callableMemberDescriptor).booleanValue()) {
                this.f24458a.element = callableMemberDescriptor;
            }
        }

        public boolean beforeChildren(CallableMemberDescriptor callableMemberDescriptor) {
            Intrinsics3.checkNotNullParameter(callableMemberDescriptor, "current");
            return this.f24458a.element == null;
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p576p.DFS.d
        public CallableMemberDescriptor result() {
            return this.f24458a.element;
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.k.x.a$e */
    /* JADX INFO: compiled from: DescriptorUtils.kt */
    public static final class e extends Lambda implements Function1<DeclarationDescriptor, DeclarationDescriptor> {

        /* JADX INFO: renamed from: j */
        public static final e f24460j = new e();

        public e() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ DeclarationDescriptor invoke(DeclarationDescriptor declarationDescriptor) {
            return invoke2(declarationDescriptor);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final DeclarationDescriptor invoke2(DeclarationDescriptor declarationDescriptor) {
            Intrinsics3.checkNotNullParameter(declarationDescriptor, "it");
            return declarationDescriptor.getContainingDeclaration();
        }
    }

    static {
        Intrinsics3.checkNotNullExpressionValue(Name.identifier("value"), "identifier(\"value\")");
    }

    public static final boolean declaresOrInheritsDefaultValue(ValueParameterDescriptor valueParameterDescriptor) {
        Intrinsics3.checkNotNullParameter(valueParameterDescriptor, "<this>");
        Boolean boolIfAny = DFS.ifAny(CollectionsJVM.listOf(valueParameterDescriptor), a.f24455a, b.f24456j);
        Intrinsics3.checkNotNullExpressionValue(boolIfAny, "ifAny(\n        listOf(this),\n        { current -> current.overriddenDescriptors.map(ValueParameterDescriptor::getOriginal) },\n        ValueParameterDescriptor::declaresDefaultValue\n    )");
        return boolIfAny.booleanValue();
    }

    public static final AbstractC11815g<?> firstArgument(AnnotationDescriptor annotationDescriptor) {
        Intrinsics3.checkNotNullParameter(annotationDescriptor, "<this>");
        return (AbstractC11815g) _Collections.firstOrNull(annotationDescriptor.getAllValueArguments().values());
    }

    public static final CallableMemberDescriptor firstOverridden(CallableMemberDescriptor callableMemberDescriptor, boolean z2, Function1<? super CallableMemberDescriptor, Boolean> function1) {
        Intrinsics3.checkNotNullParameter(callableMemberDescriptor, "<this>");
        Intrinsics3.checkNotNullParameter(function1, "predicate");
        return (CallableMemberDescriptor) DFS.dfs(CollectionsJVM.listOf(callableMemberDescriptor), new c(z2), new d(new Ref$ObjectRef(), function1));
    }

    public static /* synthetic */ CallableMemberDescriptor firstOverridden$default(CallableMemberDescriptor callableMemberDescriptor, boolean z2, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            z2 = false;
        }
        return firstOverridden(callableMemberDescriptor, z2, function1);
    }

    public static final FqName fqNameOrNull(DeclarationDescriptor declarationDescriptor) {
        Intrinsics3.checkNotNullParameter(declarationDescriptor, "<this>");
        FqNameUnsafe fqNameUnsafe = getFqNameUnsafe(declarationDescriptor);
        if (!fqNameUnsafe.isSafe()) {
            fqNameUnsafe = null;
        }
        if (fqNameUnsafe == null) {
            return null;
        }
        return fqNameUnsafe.toSafe();
    }

    public static final ClassDescriptor getAnnotationClass(AnnotationDescriptor annotationDescriptor) {
        Intrinsics3.checkNotNullParameter(annotationDescriptor, "<this>");
        ClassifierDescriptor declarationDescriptor = annotationDescriptor.getType().getConstructor().getDeclarationDescriptor();
        if (declarationDescriptor instanceof ClassDescriptor) {
            return (ClassDescriptor) declarationDescriptor;
        }
        return null;
    }

    public static final KotlinBuiltIns getBuiltIns(DeclarationDescriptor declarationDescriptor) {
        Intrinsics3.checkNotNullParameter(declarationDescriptor, "<this>");
        return getModule(declarationDescriptor).getBuiltIns();
    }

    public static final ClassId getClassId(ClassifierDescriptor classifierDescriptor) {
        DeclarationDescriptor containingDeclaration;
        ClassId classId;
        if (classifierDescriptor == null || (containingDeclaration = classifierDescriptor.getContainingDeclaration()) == null) {
            return null;
        }
        if (containingDeclaration instanceof PackageFragmentDescriptor) {
            return new ClassId(((PackageFragmentDescriptor) containingDeclaration).getFqName(), classifierDescriptor.getName());
        }
        if (!(containingDeclaration instanceof ClassifierDescriptorWithTypeParameters) || (classId = getClassId((ClassifierDescriptor) containingDeclaration)) == null) {
            return null;
        }
        return classId.createNestedClassId(classifierDescriptor.getName());
    }

    public static final FqName getFqNameSafe(DeclarationDescriptor declarationDescriptor) {
        Intrinsics3.checkNotNullParameter(declarationDescriptor, "<this>");
        FqName fqNameSafe = DescriptorUtils.getFqNameSafe(declarationDescriptor);
        Intrinsics3.checkNotNullExpressionValue(fqNameSafe, "getFqNameSafe(this)");
        return fqNameSafe;
    }

    public static final FqNameUnsafe getFqNameUnsafe(DeclarationDescriptor declarationDescriptor) {
        Intrinsics3.checkNotNullParameter(declarationDescriptor, "<this>");
        FqNameUnsafe fqName = DescriptorUtils.getFqName(declarationDescriptor);
        Intrinsics3.checkNotNullExpressionValue(fqName, "getFqName(this)");
        return fqName;
    }

    public static final KotlinTypeRefiner getKotlinTypeRefiner(ModuleDescriptor2 moduleDescriptor2) {
        Intrinsics3.checkNotNullParameter(moduleDescriptor2, "<this>");
        KotlinTypeRefiner3 kotlinTypeRefiner3 = (KotlinTypeRefiner3) moduleDescriptor2.getCapability(KotlinTypeRefiner2.getREFINER_CAPABILITY());
        KotlinTypeRefiner kotlinTypeRefiner = kotlinTypeRefiner3 == null ? null : (KotlinTypeRefiner) kotlinTypeRefiner3.getValue();
        return kotlinTypeRefiner == null ? KotlinTypeRefiner.a.f24807a : kotlinTypeRefiner;
    }

    public static final ModuleDescriptor2 getModule(DeclarationDescriptor declarationDescriptor) {
        Intrinsics3.checkNotNullParameter(declarationDescriptor, "<this>");
        ModuleDescriptor2 containingModule = DescriptorUtils.getContainingModule(declarationDescriptor);
        Intrinsics3.checkNotNullExpressionValue(containingModule, "getContainingModule(this)");
        return containingModule;
    }

    public static final Sequence<DeclarationDescriptor> getParents(DeclarationDescriptor declarationDescriptor) {
        Intrinsics3.checkNotNullParameter(declarationDescriptor, "<this>");
        return _Sequences2.drop(getParentsWithSelf(declarationDescriptor), 1);
    }

    public static final Sequence<DeclarationDescriptor> getParentsWithSelf(DeclarationDescriptor declarationDescriptor) {
        Intrinsics3.checkNotNullParameter(declarationDescriptor, "<this>");
        return C12075n.generateSequence(declarationDescriptor, e.f24460j);
    }

    public static final CallableMemberDescriptor getPropertyIfAccessor(CallableMemberDescriptor callableMemberDescriptor) {
        Intrinsics3.checkNotNullParameter(callableMemberDescriptor, "<this>");
        if (!(callableMemberDescriptor instanceof PropertyAccessorDescriptor)) {
            return callableMemberDescriptor;
        }
        PropertyDescriptor correspondingProperty = ((PropertyAccessorDescriptor) callableMemberDescriptor).getCorrespondingProperty();
        Intrinsics3.checkNotNullExpressionValue(correspondingProperty, "correspondingProperty");
        return correspondingProperty;
    }

    public static final ClassDescriptor getSuperClassNotAny(ClassDescriptor classDescriptor) {
        Intrinsics3.checkNotNullParameter(classDescriptor, "<this>");
        for (KotlinType kotlinType : classDescriptor.getDefaultType().getConstructor().getSupertypes()) {
            if (!KotlinBuiltIns.isAnyOrNullableAny(kotlinType)) {
                ClassifierDescriptor declarationDescriptor = kotlinType.getConstructor().getDeclarationDescriptor();
                if (DescriptorUtils.isClassOrEnumClass(declarationDescriptor)) {
                    Objects.requireNonNull(declarationDescriptor, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
                    return (ClassDescriptor) declarationDescriptor;
                }
            }
        }
        return null;
    }

    public static final boolean isTypeRefinementEnabled(ModuleDescriptor2 moduleDescriptor2) {
        Intrinsics3.checkNotNullParameter(moduleDescriptor2, "<this>");
        KotlinTypeRefiner3 kotlinTypeRefiner3 = (KotlinTypeRefiner3) moduleDescriptor2.getCapability(KotlinTypeRefiner2.getREFINER_CAPABILITY());
        return (kotlinTypeRefiner3 == null ? null : (KotlinTypeRefiner) kotlinTypeRefiner3.getValue()) != null;
    }

    public static final ClassDescriptor resolveTopLevelClass(ModuleDescriptor2 moduleDescriptor2, FqName fqName, LookupLocation2 lookupLocation2) {
        Intrinsics3.checkNotNullParameter(moduleDescriptor2, "<this>");
        Intrinsics3.checkNotNullParameter(fqName, "topLevelClassFqName");
        Intrinsics3.checkNotNullParameter(lookupLocation2, ModelAuditLogEntry.CHANGE_KEY_LOCATION);
        fqName.isRoot();
        FqName fqNameParent = fqName.parent();
        Intrinsics3.checkNotNullExpressionValue(fqNameParent, "topLevelClassFqName.parent()");
        MemberScope3 memberScope = moduleDescriptor2.getPackage(fqNameParent).getMemberScope();
        Name nameShortName = fqName.shortName();
        Intrinsics3.checkNotNullExpressionValue(nameShortName, "topLevelClassFqName.shortName()");
        ClassifierDescriptor contributedClassifier = memberScope.getContributedClassifier(nameShortName, lookupLocation2);
        if (contributedClassifier instanceof ClassDescriptor) {
            return (ClassDescriptor) contributedClassifier;
        }
        return null;
    }
}

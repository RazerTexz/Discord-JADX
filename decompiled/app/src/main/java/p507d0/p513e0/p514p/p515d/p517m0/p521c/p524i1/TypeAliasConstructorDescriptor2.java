package p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1;

import java.util.List;
import java.util.Objects;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.CallableDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.CallableMemberDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.ClassConstructorDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.ClassDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.ClassifierDescriptorWithTypeParameters;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.ConstructorDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.DeclarationDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.DeclarationDescriptorNonRoot;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.DeclarationDescriptorWithSource;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.DescriptorVisibility2;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.FunctionDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.Modality;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.ReceiverParameterDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.SourceElement;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.TypeAliasDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.ValueParameterDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1.Annotations4;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.Name;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.DescriptorFactory;
import p507d0.p513e0.p514p.p515d.p517m0.p566m.StorageManager;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType4;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.SpecialTypes5;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.TypeSubstitutor2;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.Variance;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.flexibleTypes2;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;
import p507d0.p592z.p594d.PropertyReference1Impl;
import p507d0.p592z.p594d.Reflection2;

/* JADX INFO: renamed from: d0.e0.p.d.m0.c.i1.j0, reason: use source file name */
/* JADX INFO: compiled from: TypeAliasConstructorDescriptor.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class TypeAliasConstructorDescriptor2 extends FunctionDescriptorImpl implements TypeAliasConstructorDescriptor {

    /* JADX INFO: renamed from: M */
    public static final a f22887M = new a(null);

    /* JADX INFO: renamed from: N */
    public static final /* synthetic */ KProperty<Object>[] f22888N = {Reflection2.property1(new PropertyReference1Impl(Reflection2.getOrCreateKotlinClass(TypeAliasConstructorDescriptor2.class), "withDispatchReceiver", "getWithDispatchReceiver()Lorg/jetbrains/kotlin/descriptors/impl/TypeAliasConstructorDescriptor;"))};

    /* JADX INFO: renamed from: O */
    public final StorageManager f22889O;

    /* JADX INFO: renamed from: P */
    public final TypeAliasDescriptor f22890P;

    /* JADX INFO: renamed from: Q */
    public ClassConstructorDescriptor f22891Q;

    /* JADX INFO: renamed from: d0.e0.p.d.m0.c.i1.j0$a */
    /* JADX INFO: compiled from: TypeAliasConstructorDescriptor.kt */
    public static final class a {
        public a(DefaultConstructorMarker defaultConstructorMarker) {
        }

        public static final TypeSubstitutor2 access$getTypeSubstitutorForUnderlyingClass(a aVar, TypeAliasDescriptor typeAliasDescriptor) {
            Objects.requireNonNull(aVar);
            if (typeAliasDescriptor.getClassDescriptor() == null) {
                return null;
            }
            return TypeSubstitutor2.create(typeAliasDescriptor.getExpandedType());
        }

        public final TypeAliasConstructorDescriptor createIfAvailable(StorageManager storageManager, TypeAliasDescriptor typeAliasDescriptor, ClassConstructorDescriptor classConstructorDescriptor) {
            ClassConstructorDescriptor classConstructorDescriptorSubstitute;
            Intrinsics3.checkNotNullParameter(storageManager, "storageManager");
            Intrinsics3.checkNotNullParameter(typeAliasDescriptor, "typeAliasDescriptor");
            Intrinsics3.checkNotNullParameter(classConstructorDescriptor, "constructor");
            TypeSubstitutor2 typeSubstitutor2Create = typeAliasDescriptor.getClassDescriptor() == null ? null : TypeSubstitutor2.create(typeAliasDescriptor.getExpandedType());
            if (typeSubstitutor2Create == null || (classConstructorDescriptorSubstitute = classConstructorDescriptor.substitute(typeSubstitutor2Create)) == null) {
                return null;
            }
            Annotations4 annotations = classConstructorDescriptor.getAnnotations();
            CallableMemberDescriptor.a kind = classConstructorDescriptor.getKind();
            Intrinsics3.checkNotNullExpressionValue(kind, "constructor.kind");
            SourceElement source = typeAliasDescriptor.getSource();
            Intrinsics3.checkNotNullExpressionValue(source, "typeAliasDescriptor.source");
            TypeAliasConstructorDescriptor2 typeAliasConstructorDescriptor2 = new TypeAliasConstructorDescriptor2(storageManager, typeAliasDescriptor, classConstructorDescriptorSubstitute, null, annotations, kind, source, null);
            List<ValueParameterDescriptor> substitutedValueParameters = FunctionDescriptorImpl.getSubstitutedValueParameters(typeAliasConstructorDescriptor2, classConstructorDescriptor.getValueParameters(), typeSubstitutor2Create);
            if (substitutedValueParameters == null) {
                return null;
            }
            KotlinType4 kotlinType4LowerIfFlexible = flexibleTypes2.lowerIfFlexible(classConstructorDescriptorSubstitute.getReturnType().unwrap());
            KotlinType4 defaultType = typeAliasDescriptor.getDefaultType();
            Intrinsics3.checkNotNullExpressionValue(defaultType, "typeAliasDescriptor.defaultType");
            KotlinType4 kotlinType4WithAbbreviation = SpecialTypes5.withAbbreviation(kotlinType4LowerIfFlexible, defaultType);
            ReceiverParameterDescriptor dispatchReceiverParameter = classConstructorDescriptor.getDispatchReceiverParameter();
            typeAliasConstructorDescriptor2.initialize(dispatchReceiverParameter != null ? DescriptorFactory.createExtensionReceiverParameterForCallable(typeAliasConstructorDescriptor2, typeSubstitutor2Create.safeSubstitute(dispatchReceiverParameter.getType(), Variance.INVARIANT), Annotations4.f22735f.getEMPTY()) : null, null, typeAliasDescriptor.getDeclaredTypeParameters(), substitutedValueParameters, kotlinType4WithAbbreviation, Modality.FINAL, typeAliasDescriptor.getVisibility());
            return typeAliasConstructorDescriptor2;
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.c.i1.j0$b */
    /* JADX INFO: compiled from: TypeAliasConstructorDescriptor.kt */
    public static final class b extends Lambda implements Function0<TypeAliasConstructorDescriptor2> {
        public final /* synthetic */ ClassConstructorDescriptor $underlyingConstructorDescriptor;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(ClassConstructorDescriptor classConstructorDescriptor) {
            super(0);
            this.$underlyingConstructorDescriptor = classConstructorDescriptor;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ TypeAliasConstructorDescriptor2 invoke() {
            return invoke();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final TypeAliasConstructorDescriptor2 invoke() {
            StorageManager storageManager = TypeAliasConstructorDescriptor2.this.getStorageManager();
            TypeAliasDescriptor typeAliasDescriptor = TypeAliasConstructorDescriptor2.this.getTypeAliasDescriptor();
            ClassConstructorDescriptor classConstructorDescriptor = this.$underlyingConstructorDescriptor;
            TypeAliasConstructorDescriptor2 typeAliasConstructorDescriptor2 = TypeAliasConstructorDescriptor2.this;
            Annotations4 annotations = classConstructorDescriptor.getAnnotations();
            CallableMemberDescriptor.a kind = this.$underlyingConstructorDescriptor.getKind();
            Intrinsics3.checkNotNullExpressionValue(kind, "underlyingConstructorDescriptor.kind");
            SourceElement source = TypeAliasConstructorDescriptor2.this.getTypeAliasDescriptor().getSource();
            Intrinsics3.checkNotNullExpressionValue(source, "typeAliasDescriptor.source");
            TypeAliasConstructorDescriptor2 typeAliasConstructorDescriptor22 = new TypeAliasConstructorDescriptor2(storageManager, typeAliasDescriptor, classConstructorDescriptor, typeAliasConstructorDescriptor2, annotations, kind, source, null);
            TypeAliasConstructorDescriptor2 typeAliasConstructorDescriptor23 = TypeAliasConstructorDescriptor2.this;
            ClassConstructorDescriptor classConstructorDescriptor2 = this.$underlyingConstructorDescriptor;
            TypeSubstitutor2 typeSubstitutor2Access$getTypeSubstitutorForUnderlyingClass = a.access$getTypeSubstitutorForUnderlyingClass(TypeAliasConstructorDescriptor2.f22887M, typeAliasConstructorDescriptor23.getTypeAliasDescriptor());
            if (typeSubstitutor2Access$getTypeSubstitutorForUnderlyingClass == null) {
                return null;
            }
            ReceiverParameterDescriptor dispatchReceiverParameter = classConstructorDescriptor2.getDispatchReceiverParameter();
            typeAliasConstructorDescriptor22.initialize(null, dispatchReceiverParameter == null ? null : dispatchReceiverParameter.substitute(typeSubstitutor2Access$getTypeSubstitutorForUnderlyingClass), typeAliasConstructorDescriptor23.getTypeAliasDescriptor().getDeclaredTypeParameters(), typeAliasConstructorDescriptor23.getValueParameters(), typeAliasConstructorDescriptor23.getReturnType(), Modality.FINAL, typeAliasConstructorDescriptor23.getTypeAliasDescriptor().getVisibility());
            return typeAliasConstructorDescriptor22;
        }
    }

    public TypeAliasConstructorDescriptor2(StorageManager storageManager, TypeAliasDescriptor typeAliasDescriptor, ClassConstructorDescriptor classConstructorDescriptor, TypeAliasConstructorDescriptor typeAliasConstructorDescriptor, Annotations4 annotations4, CallableMemberDescriptor.a aVar, SourceElement sourceElement) {
        super(typeAliasDescriptor, typeAliasConstructorDescriptor, annotations4, Name.special("<init>"), aVar, sourceElement);
        this.f22889O = storageManager;
        this.f22890P = typeAliasDescriptor;
        setActual(getTypeAliasDescriptor().isActual());
        storageManager.createNullableLazyValue(new b(classConstructorDescriptor));
        this.f22891Q = classConstructorDescriptor;
    }

    public /* synthetic */ TypeAliasConstructorDescriptor2(StorageManager storageManager, TypeAliasDescriptor typeAliasDescriptor, ClassConstructorDescriptor classConstructorDescriptor, TypeAliasConstructorDescriptor typeAliasConstructorDescriptor, Annotations4 annotations4, CallableMemberDescriptor.a aVar, SourceElement sourceElement, DefaultConstructorMarker defaultConstructorMarker) {
        this(storageManager, typeAliasDescriptor, classConstructorDescriptor, typeAliasConstructorDescriptor, annotations4, aVar, sourceElement);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1.FunctionDescriptorImpl
    /* JADX INFO: renamed from: b */
    public FunctionDescriptorImpl mo9373b(DeclarationDescriptor declarationDescriptor, FunctionDescriptor functionDescriptor, CallableMemberDescriptor.a aVar, Name name, Annotations4 annotations4, SourceElement sourceElement) {
        Intrinsics3.checkNotNullParameter(declarationDescriptor, "newOwner");
        Intrinsics3.checkNotNullParameter(aVar, "kind");
        Intrinsics3.checkNotNullParameter(annotations4, "annotations");
        Intrinsics3.checkNotNullParameter(sourceElement, "source");
        return new TypeAliasConstructorDescriptor2(this.f22889O, getTypeAliasDescriptor(), getUnderlyingConstructorDescriptor(), this, annotations4, CallableMemberDescriptor.a.DECLARATION, sourceElement);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1.FunctionDescriptorImpl, p507d0.p513e0.p514p.p515d.p517m0.p521c.CallableMemberDescriptor
    public /* bridge */ /* synthetic */ CallableMemberDescriptor copy(DeclarationDescriptor declarationDescriptor, Modality modality, DescriptorVisibility2 descriptorVisibility2, CallableMemberDescriptor.a aVar, boolean z2) {
        return copy(declarationDescriptor, modality, descriptorVisibility2, aVar, z2);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.ConstructorDescriptor
    public ClassDescriptor getConstructedClass() {
        ClassDescriptor constructedClass = getUnderlyingConstructorDescriptor().getConstructedClass();
        Intrinsics3.checkNotNullExpressionValue(constructedClass, "underlyingConstructorDescriptor.constructedClass");
        return constructedClass;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1.DeclarationDescriptorNonRootImpl, p507d0.p513e0.p514p.p515d.p517m0.p521c.DeclarationDescriptor
    public /* bridge */ /* synthetic */ ClassifierDescriptorWithTypeParameters getContainingDeclaration() {
        return getContainingDeclaration();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1.FunctionDescriptorImpl, p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1.DeclarationDescriptorNonRootImpl, p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1.DeclarationDescriptorImpl, p507d0.p513e0.p514p.p515d.p517m0.p521c.DeclarationDescriptor
    public /* bridge */ /* synthetic */ CallableDescriptor getOriginal() {
        return getOriginal();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1.FunctionDescriptorImpl, p507d0.p513e0.p514p.p515d.p517m0.p521c.CallableDescriptor
    public KotlinType getReturnType() {
        KotlinType returnType = super.getReturnType();
        Intrinsics3.checkNotNull(returnType);
        return returnType;
    }

    public final StorageManager getStorageManager() {
        return this.f22889O;
    }

    public TypeAliasDescriptor getTypeAliasDescriptor() {
        return this.f22890P;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1.TypeAliasConstructorDescriptor
    public ClassConstructorDescriptor getUnderlyingConstructorDescriptor() {
        return this.f22891Q;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.ConstructorDescriptor
    public boolean isPrimary() {
        return getUnderlyingConstructorDescriptor().isPrimary();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1.FunctionDescriptorImpl, p507d0.p513e0.p514p.p515d.p517m0.p521c.FunctionDescriptor, p507d0.p513e0.p514p.p515d.p517m0.p521c.Substitutable
    public /* bridge */ /* synthetic */ ConstructorDescriptor substitute(TypeSubstitutor2 typeSubstitutor2) {
        return substitute(typeSubstitutor2);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1.FunctionDescriptorImpl, p507d0.p513e0.p514p.p515d.p517m0.p521c.CallableMemberDescriptor
    public /* bridge */ /* synthetic */ FunctionDescriptor copy(DeclarationDescriptor declarationDescriptor, Modality modality, DescriptorVisibility2 descriptorVisibility2, CallableMemberDescriptor.a aVar, boolean z2) {
        return copy(declarationDescriptor, modality, descriptorVisibility2, aVar, z2);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1.DeclarationDescriptorNonRootImpl, p507d0.p513e0.p514p.p515d.p517m0.p521c.DeclarationDescriptor
    public /* bridge */ /* synthetic */ DeclarationDescriptor getContainingDeclaration() {
        return getContainingDeclaration();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1.FunctionDescriptorImpl, p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1.DeclarationDescriptorNonRootImpl, p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1.DeclarationDescriptorImpl, p507d0.p513e0.p514p.p515d.p517m0.p521c.DeclarationDescriptor
    public /* bridge */ /* synthetic */ CallableMemberDescriptor getOriginal() {
        return getOriginal();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1.FunctionDescriptorImpl, p507d0.p513e0.p514p.p515d.p517m0.p521c.FunctionDescriptor, p507d0.p513e0.p514p.p515d.p517m0.p521c.Substitutable
    public /* bridge */ /* synthetic */ DeclarationDescriptorNonRoot substitute(TypeSubstitutor2 typeSubstitutor2) {
        return substitute(typeSubstitutor2);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1.FunctionDescriptorImpl, p507d0.p513e0.p514p.p515d.p517m0.p521c.CallableMemberDescriptor
    public TypeAliasConstructorDescriptor copy(DeclarationDescriptor declarationDescriptor, Modality modality, DescriptorVisibility2 descriptorVisibility2, CallableMemberDescriptor.a aVar, boolean z2) {
        Intrinsics3.checkNotNullParameter(declarationDescriptor, "newOwner");
        Intrinsics3.checkNotNullParameter(modality, "modality");
        Intrinsics3.checkNotNullParameter(descriptorVisibility2, "visibility");
        Intrinsics3.checkNotNullParameter(aVar, "kind");
        FunctionDescriptor functionDescriptorBuild = newCopyBuilder().setOwner(declarationDescriptor).setModality(modality).setVisibility(descriptorVisibility2).setKind(aVar).setCopyOverrides(z2).build();
        Objects.requireNonNull(functionDescriptorBuild, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.impl.TypeAliasConstructorDescriptor");
        return (TypeAliasConstructorDescriptor) functionDescriptorBuild;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1.DeclarationDescriptorNonRootImpl, p507d0.p513e0.p514p.p515d.p517m0.p521c.DeclarationDescriptor
    public TypeAliasDescriptor getContainingDeclaration() {
        return getTypeAliasDescriptor();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1.FunctionDescriptorImpl, p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1.DeclarationDescriptorNonRootImpl, p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1.DeclarationDescriptorImpl, p507d0.p513e0.p514p.p515d.p517m0.p521c.DeclarationDescriptor
    public /* bridge */ /* synthetic */ DeclarationDescriptor getOriginal() {
        return getOriginal();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1.FunctionDescriptorImpl, p507d0.p513e0.p514p.p515d.p517m0.p521c.FunctionDescriptor, p507d0.p513e0.p514p.p515d.p517m0.p521c.Substitutable
    public /* bridge */ /* synthetic */ FunctionDescriptor substitute(TypeSubstitutor2 typeSubstitutor2) {
        return substitute(typeSubstitutor2);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1.FunctionDescriptorImpl, p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1.DeclarationDescriptorNonRootImpl, p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1.DeclarationDescriptorImpl, p507d0.p513e0.p514p.p515d.p517m0.p521c.DeclarationDescriptor
    public /* bridge */ /* synthetic */ DeclarationDescriptorWithSource getOriginal() {
        return getOriginal();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1.FunctionDescriptorImpl, p507d0.p513e0.p514p.p515d.p517m0.p521c.FunctionDescriptor, p507d0.p513e0.p514p.p515d.p517m0.p521c.Substitutable
    public TypeAliasConstructorDescriptor substitute(TypeSubstitutor2 typeSubstitutor2) {
        Intrinsics3.checkNotNullParameter(typeSubstitutor2, "substitutor");
        FunctionDescriptor functionDescriptorSubstitute = super.substitute(typeSubstitutor2);
        Objects.requireNonNull(functionDescriptorSubstitute, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.impl.TypeAliasConstructorDescriptorImpl");
        TypeAliasConstructorDescriptor2 typeAliasConstructorDescriptor2 = (TypeAliasConstructorDescriptor2) functionDescriptorSubstitute;
        TypeSubstitutor2 typeSubstitutor2Create = TypeSubstitutor2.create(typeAliasConstructorDescriptor2.getReturnType());
        Intrinsics3.checkNotNullExpressionValue(typeSubstitutor2Create, "create(substitutedTypeAliasConstructor.returnType)");
        ClassConstructorDescriptor classConstructorDescriptorSubstitute = getUnderlyingConstructorDescriptor().getOriginal().substitute(typeSubstitutor2Create);
        if (classConstructorDescriptorSubstitute == null) {
            return null;
        }
        typeAliasConstructorDescriptor2.f22891Q = classConstructorDescriptorSubstitute;
        return typeAliasConstructorDescriptor2;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1.FunctionDescriptorImpl, p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1.DeclarationDescriptorNonRootImpl, p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1.DeclarationDescriptorImpl, p507d0.p513e0.p514p.p515d.p517m0.p521c.DeclarationDescriptor
    public /* bridge */ /* synthetic */ FunctionDescriptor getOriginal() {
        return getOriginal();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1.FunctionDescriptorImpl, p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1.DeclarationDescriptorNonRootImpl, p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1.DeclarationDescriptorImpl, p507d0.p513e0.p514p.p515d.p517m0.p521c.DeclarationDescriptor
    public TypeAliasConstructorDescriptor getOriginal() {
        return (TypeAliasConstructorDescriptor) super.getOriginal();
    }
}

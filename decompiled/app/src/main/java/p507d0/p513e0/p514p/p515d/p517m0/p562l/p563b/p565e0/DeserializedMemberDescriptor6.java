package p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b.p565e0;

import com.discord.models.domain.ModelAuditLogEntry;
import java.util.Collection;
import java.util.List;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.ClassDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.ClassifierDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.DeclarationDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.DeclarationDescriptorNonRoot;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.DescriptorVisibility2;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.SourceElement;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.TypeAliasDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.TypeParameterDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1.Annotations4;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1.AbstractTypeAliasDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1.AbstractTypeAliasDescriptor2;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1.TypeAliasConstructorDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.typeParameterUtils;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.C11693r;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.p547z.NameResolver;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.p547z.TypeTable;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.p547z.VersionRequirement;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.p547z.VersionRequirement2;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.Name;
import p507d0.p513e0.p514p.p515d.p517m0.p550i.MessageLite;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.MemberScope3;
import p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b.p565e0.DeserializedMemberDescriptor3;
import p507d0.p513e0.p514p.p515d.p517m0.p566m.StorageManager;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType2;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType4;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.TypeSubstitution;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.TypeSubstitutor2;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.TypeUtils;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.Variance;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: renamed from: d0.e0.p.d.m0.l.b.e0.l, reason: use source file name */
/* JADX INFO: compiled from: DeserializedMemberDescriptor.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class DeserializedMemberDescriptor6 extends AbstractTypeAliasDescriptor2 implements DeserializedMemberDescriptor3 {

    /* JADX INFO: renamed from: A */
    public KotlinType4 f24610A;

    /* JADX INFO: renamed from: B */
    public DeserializedMemberDescriptor3.a f24611B;

    /* JADX INFO: renamed from: q */
    public final StorageManager f24612q;

    /* JADX INFO: renamed from: r */
    public final C11693r f24613r;

    /* JADX INFO: renamed from: s */
    public final NameResolver f24614s;

    /* JADX INFO: renamed from: t */
    public final TypeTable f24615t;

    /* JADX INFO: renamed from: u */
    public final VersionRequirement2 f24616u;

    /* JADX INFO: renamed from: v */
    public final DeserializedContainerSource2 f24617v;

    /* JADX INFO: renamed from: w */
    public Collection<? extends TypeAliasConstructorDescriptor> f24618w;

    /* JADX INFO: renamed from: x */
    public KotlinType4 f24619x;

    /* JADX INFO: renamed from: y */
    public KotlinType4 f24620y;

    /* JADX INFO: renamed from: z */
    public List<? extends TypeParameterDescriptor> f24621z;

    /* JADX WARN: Illegal instructions before constructor call */
    public DeserializedMemberDescriptor6(StorageManager storageManager, DeclarationDescriptor declarationDescriptor, Annotations4 annotations4, Name name, DescriptorVisibility2 descriptorVisibility2, C11693r c11693r, NameResolver nameResolver, TypeTable typeTable, VersionRequirement2 versionRequirement2, DeserializedContainerSource2 deserializedContainerSource2) {
        Intrinsics3.checkNotNullParameter(storageManager, "storageManager");
        Intrinsics3.checkNotNullParameter(declarationDescriptor, "containingDeclaration");
        Intrinsics3.checkNotNullParameter(annotations4, "annotations");
        Intrinsics3.checkNotNullParameter(name, ModelAuditLogEntry.CHANGE_KEY_NAME);
        Intrinsics3.checkNotNullParameter(descriptorVisibility2, "visibility");
        Intrinsics3.checkNotNullParameter(c11693r, "proto");
        Intrinsics3.checkNotNullParameter(nameResolver, "nameResolver");
        Intrinsics3.checkNotNullParameter(typeTable, "typeTable");
        Intrinsics3.checkNotNullParameter(versionRequirement2, "versionRequirementTable");
        SourceElement sourceElement = SourceElement.f23099a;
        Intrinsics3.checkNotNullExpressionValue(sourceElement, "NO_SOURCE");
        super(declarationDescriptor, annotations4, name, sourceElement, descriptorVisibility2);
        this.f24612q = storageManager;
        this.f24613r = c11693r;
        this.f24614s = nameResolver;
        this.f24615t = typeTable;
        this.f24616u = versionRequirement2;
        this.f24617v = deserializedContainerSource2;
        this.f24611B = DeserializedMemberDescriptor3.a.COMPATIBLE;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.TypeAliasDescriptor
    public ClassDescriptor getClassDescriptor() {
        if (KotlinType2.isError(getExpandedType())) {
            return null;
        }
        ClassifierDescriptor declarationDescriptor = getExpandedType().getConstructor().getDeclarationDescriptor();
        if (declarationDescriptor instanceof ClassDescriptor) {
            return (ClassDescriptor) declarationDescriptor;
        }
        return null;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b.p565e0.DeserializedMemberDescriptor3
    public DeserializedContainerSource2 getContainerSource() {
        return this.f24617v;
    }

    public DeserializedMemberDescriptor3.a getCoroutinesExperimentalCompatibilityMode() {
        return this.f24611B;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.ClassifierDescriptor
    public KotlinType4 getDefaultType() {
        KotlinType4 kotlinType4 = this.f24610A;
        if (kotlinType4 != null) {
            return kotlinType4;
        }
        Intrinsics3.throwUninitializedPropertyAccessException("defaultTypeImpl");
        throw null;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.TypeAliasDescriptor
    public KotlinType4 getExpandedType() {
        KotlinType4 kotlinType4 = this.f24620y;
        if (kotlinType4 != null) {
            return kotlinType4;
        }
        Intrinsics3.throwUninitializedPropertyAccessException("expandedType");
        throw null;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b.p565e0.DeserializedMemberDescriptor3
    public NameResolver getNameResolver() {
        return this.f24614s;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b.p565e0.DeserializedMemberDescriptor3
    public /* bridge */ /* synthetic */ MessageLite getProto() {
        return getProto();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b.p565e0.DeserializedMemberDescriptor3
    public TypeTable getTypeTable() {
        return this.f24615t;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.TypeAliasDescriptor
    public KotlinType4 getUnderlyingType() {
        KotlinType4 kotlinType4 = this.f24619x;
        if (kotlinType4 != null) {
            return kotlinType4;
        }
        Intrinsics3.throwUninitializedPropertyAccessException("underlyingType");
        throw null;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b.p565e0.DeserializedMemberDescriptor3
    public VersionRequirement2 getVersionRequirementTable() {
        return this.f24616u;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b.p565e0.DeserializedMemberDescriptor3
    public List<VersionRequirement> getVersionRequirements() {
        return DeserializedMemberDescriptor3.b.getVersionRequirements(this);
    }

    public final void initialize(List<? extends TypeParameterDescriptor> list, KotlinType4 kotlinType4, KotlinType4 kotlinType42, DeserializedMemberDescriptor3.a aVar) {
        Intrinsics3.checkNotNullParameter(list, "declaredTypeParameters");
        Intrinsics3.checkNotNullParameter(kotlinType4, "underlyingType");
        Intrinsics3.checkNotNullParameter(kotlinType42, "expandedType");
        Intrinsics3.checkNotNullParameter(aVar, "isExperimentalCoroutineInReleaseEnvironment");
        initialize(list);
        this.f24619x = kotlinType4;
        this.f24620y = kotlinType42;
        this.f24621z = typeParameterUtils.computeConstructorTypeParameters(this);
        ClassDescriptor classDescriptor = getClassDescriptor();
        MemberScope3 unsubstitutedMemberScope = classDescriptor == null ? null : classDescriptor.getUnsubstitutedMemberScope();
        if (unsubstitutedMemberScope == null) {
            unsubstitutedMemberScope = MemberScope3.b.f24373b;
        }
        KotlinType4 kotlinType4MakeUnsubstitutedType = TypeUtils.makeUnsubstitutedType(this, unsubstitutedMemberScope, new AbstractTypeAliasDescriptor(this));
        Intrinsics3.checkNotNullExpressionValue(kotlinType4MakeUnsubstitutedType, "@OptIn(TypeRefinement::class)\n    protected fun computeDefaultType(): SimpleType =\n        TypeUtils.makeUnsubstitutedType(this, classDescriptor?.unsubstitutedMemberScope ?: MemberScope.Empty) { kotlinTypeRefiner ->\n            kotlinTypeRefiner.refineDescriptor(this)?.defaultType\n        }");
        this.f24610A = kotlinType4MakeUnsubstitutedType;
        this.f24618w = getTypeAliasConstructors();
        this.f24611B = aVar;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.Substitutable
    public /* bridge */ /* synthetic */ DeclarationDescriptorNonRoot substitute(TypeSubstitutor2 typeSubstitutor2) {
        return substitute(typeSubstitutor2);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b.p565e0.DeserializedMemberDescriptor3
    public C11693r getProto() {
        return this.f24613r;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.Substitutable
    public TypeAliasDescriptor substitute(TypeSubstitutor2 typeSubstitutor2) {
        Intrinsics3.checkNotNullParameter(typeSubstitutor2, "substitutor");
        if (typeSubstitutor2.isEmpty()) {
            return this;
        }
        StorageManager storageManager = this.f24612q;
        DeclarationDescriptor containingDeclaration = getContainingDeclaration();
        Intrinsics3.checkNotNullExpressionValue(containingDeclaration, "containingDeclaration");
        Annotations4 annotations = getAnnotations();
        Intrinsics3.checkNotNullExpressionValue(annotations, "annotations");
        Name name = getName();
        Intrinsics3.checkNotNullExpressionValue(name, ModelAuditLogEntry.CHANGE_KEY_NAME);
        DeserializedMemberDescriptor6 deserializedMemberDescriptor6 = new DeserializedMemberDescriptor6(storageManager, containingDeclaration, annotations, name, getVisibility(), getProto(), getNameResolver(), getTypeTable(), getVersionRequirementTable(), getContainerSource());
        List<TypeParameterDescriptor> declaredTypeParameters = getDeclaredTypeParameters();
        KotlinType4 underlyingType = getUnderlyingType();
        Variance variance = Variance.INVARIANT;
        KotlinType kotlinTypeSafeSubstitute = typeSubstitutor2.safeSubstitute(underlyingType, variance);
        Intrinsics3.checkNotNullExpressionValue(kotlinTypeSafeSubstitute, "substitutor.safeSubstitute(underlyingType, Variance.INVARIANT)");
        KotlinType4 kotlinType4AsSimpleType = TypeSubstitution.asSimpleType(kotlinTypeSafeSubstitute);
        KotlinType kotlinTypeSafeSubstitute2 = typeSubstitutor2.safeSubstitute(getExpandedType(), variance);
        Intrinsics3.checkNotNullExpressionValue(kotlinTypeSafeSubstitute2, "substitutor.safeSubstitute(expandedType, Variance.INVARIANT)");
        deserializedMemberDescriptor6.initialize(declaredTypeParameters, kotlinType4AsSimpleType, TypeSubstitution.asSimpleType(kotlinTypeSafeSubstitute2), getCoroutinesExperimentalCompatibilityMode());
        return deserializedMemberDescriptor6;
    }
}

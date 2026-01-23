package p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b.p565e0;

import com.discord.models.domain.ModelAuditLogEntry;
import java.util.List;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.CallableMemberDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.DeclarationDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.DescriptorVisibility2;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.FieldDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.Modality;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.PropertyDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.PropertySetterDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.SourceElement;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1.Annotations4;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1.PropertyDescriptorImpl;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1.PropertyGetterDescriptorImpl;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.C11689n;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.p547z.Flags2;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.p547z.NameResolver;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.p547z.TypeTable;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.p547z.VersionRequirement;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.p547z.VersionRequirement2;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.Name;
import p507d0.p513e0.p514p.p515d.p517m0.p550i.MessageLite;
import p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b.p565e0.DeserializedMemberDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b.p565e0.DeserializedMemberDescriptor3;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: renamed from: d0.e0.p.d.m0.l.b.e0.j, reason: use source file name */
/* JADX INFO: compiled from: DeserializedMemberDescriptor.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class DeserializedMemberDescriptor4 extends PropertyDescriptorImpl implements DeserializedMemberDescriptor {

    /* JADX INFO: renamed from: J */
    public final C11689n f24599J;

    /* JADX INFO: renamed from: K */
    public final NameResolver f24600K;

    /* JADX INFO: renamed from: L */
    public final TypeTable f24601L;

    /* JADX INFO: renamed from: M */
    public final VersionRequirement2 f24602M;

    /* JADX INFO: renamed from: N */
    public final DeserializedContainerSource2 f24603N;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DeserializedMemberDescriptor4(DeclarationDescriptor declarationDescriptor, PropertyDescriptor propertyDescriptor, Annotations4 annotations4, Modality modality, DescriptorVisibility2 descriptorVisibility2, boolean z2, Name name, CallableMemberDescriptor.a aVar, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, C11689n c11689n, NameResolver nameResolver, TypeTable typeTable, VersionRequirement2 versionRequirement2, DeserializedContainerSource2 deserializedContainerSource2) {
        super(declarationDescriptor, propertyDescriptor, annotations4, modality, descriptorVisibility2, z2, name, aVar, SourceElement.f23099a, z3, z4, z7, false, z5, z6);
        Intrinsics3.checkNotNullParameter(declarationDescriptor, "containingDeclaration");
        Intrinsics3.checkNotNullParameter(annotations4, "annotations");
        Intrinsics3.checkNotNullParameter(modality, "modality");
        Intrinsics3.checkNotNullParameter(descriptorVisibility2, "visibility");
        Intrinsics3.checkNotNullParameter(name, ModelAuditLogEntry.CHANGE_KEY_NAME);
        Intrinsics3.checkNotNullParameter(aVar, "kind");
        Intrinsics3.checkNotNullParameter(c11689n, "proto");
        Intrinsics3.checkNotNullParameter(nameResolver, "nameResolver");
        Intrinsics3.checkNotNullParameter(typeTable, "typeTable");
        Intrinsics3.checkNotNullParameter(versionRequirement2, "versionRequirementTable");
        this.f24599J = c11689n;
        this.f24600K = nameResolver;
        this.f24601L = typeTable;
        this.f24602M = versionRequirement2;
        this.f24603N = deserializedContainerSource2;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1.PropertyDescriptorImpl
    /* JADX INFO: renamed from: b */
    public PropertyDescriptorImpl mo9394b(DeclarationDescriptor declarationDescriptor, Modality modality, DescriptorVisibility2 descriptorVisibility2, PropertyDescriptor propertyDescriptor, CallableMemberDescriptor.a aVar, Name name, SourceElement sourceElement) {
        Intrinsics3.checkNotNullParameter(declarationDescriptor, "newOwner");
        Intrinsics3.checkNotNullParameter(modality, "newModality");
        Intrinsics3.checkNotNullParameter(descriptorVisibility2, "newVisibility");
        Intrinsics3.checkNotNullParameter(aVar, "kind");
        Intrinsics3.checkNotNullParameter(name, "newName");
        Intrinsics3.checkNotNullParameter(sourceElement, "source");
        return new DeserializedMemberDescriptor4(declarationDescriptor, propertyDescriptor, getAnnotations(), modality, descriptorVisibility2, isVar(), name, aVar, isLateInit(), isConst(), isExternal(), isDelegated(), isExpect(), getProto(), getNameResolver(), getTypeTable(), getVersionRequirementTable(), getContainerSource());
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b.p565e0.DeserializedMemberDescriptor3
    public DeserializedContainerSource2 getContainerSource() {
        return this.f24603N;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b.p565e0.DeserializedMemberDescriptor3
    public NameResolver getNameResolver() {
        return this.f24600K;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b.p565e0.DeserializedMemberDescriptor3
    public /* bridge */ /* synthetic */ MessageLite getProto() {
        return getProto();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b.p565e0.DeserializedMemberDescriptor3
    public TypeTable getTypeTable() {
        return this.f24601L;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b.p565e0.DeserializedMemberDescriptor3
    public VersionRequirement2 getVersionRequirementTable() {
        return this.f24602M;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b.p565e0.DeserializedMemberDescriptor3
    public List<VersionRequirement> getVersionRequirements() {
        return DeserializedMemberDescriptor.a.getVersionRequirements(this);
    }

    public final void initialize(PropertyGetterDescriptorImpl propertyGetterDescriptorImpl, PropertySetterDescriptor propertySetterDescriptor, FieldDescriptor fieldDescriptor, FieldDescriptor fieldDescriptor2, DeserializedMemberDescriptor3.a aVar) {
        Intrinsics3.checkNotNullParameter(aVar, "isExperimentalCoroutineInReleaseEnvironment");
        super.initialize(propertyGetterDescriptorImpl, propertySetterDescriptor, fieldDescriptor, fieldDescriptor2);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1.PropertyDescriptorImpl, p507d0.p513e0.p514p.p515d.p517m0.p521c.MemberDescriptor
    public boolean isExternal() {
        Boolean bool = Flags2.f24019C.get(getProto().getFlags());
        Intrinsics3.checkNotNullExpressionValue(bool, "IS_EXTERNAL_PROPERTY.get(proto.flags)");
        return bool.booleanValue();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b.p565e0.DeserializedMemberDescriptor3
    public C11689n getProto() {
        return this.f24599J;
    }
}

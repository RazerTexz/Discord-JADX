package p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b.p565e0;

import com.discord.models.domain.ModelAuditLogEntry;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.CallableDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.CallableMemberDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.DeclarationDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.DescriptorVisibility2;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.FunctionDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.Modality;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.ReceiverParameterDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.SimpleFunctionDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.SourceElement;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.TypeParameterDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.ValueParameterDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1.Annotations4;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1.FunctionDescriptorImpl;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1.SimpleFunctionDescriptorImpl;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.C11684i;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.p547z.NameResolver;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.p547z.TypeTable;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.p547z.VersionRequirement;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.p547z.VersionRequirement2;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.Name;
import p507d0.p513e0.p514p.p515d.p517m0.p550i.MessageLite;
import p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b.p565e0.DeserializedMemberDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b.p565e0.DeserializedMemberDescriptor3;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: DeserializedMemberDescriptor.kt */
/* renamed from: d0.e0.p.d.m0.l.b.e0.k, reason: use source file name */
/* loaded from: classes3.dex */
public final class DeserializedMemberDescriptor5 extends SimpleFunctionDescriptorImpl implements DeserializedMemberDescriptor {

    /* renamed from: M */
    public final C11684i f24604M;

    /* renamed from: N */
    public final NameResolver f24605N;

    /* renamed from: O */
    public final TypeTable f24606O;

    /* renamed from: P */
    public final VersionRequirement2 f24607P;

    /* renamed from: Q */
    public final DeserializedContainerSource2 f24608Q;

    /* renamed from: R */
    public DeserializedMemberDescriptor3.a f24609R;

    public /* synthetic */ DeserializedMemberDescriptor5(DeclarationDescriptor declarationDescriptor, SimpleFunctionDescriptor simpleFunctionDescriptor, Annotations4 annotations4, Name name, CallableMemberDescriptor.a aVar, C11684i c11684i, NameResolver nameResolver, TypeTable typeTable, VersionRequirement2 versionRequirement2, DeserializedContainerSource2 deserializedContainerSource2, SourceElement sourceElement, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(declarationDescriptor, simpleFunctionDescriptor, annotations4, name, aVar, c11684i, nameResolver, typeTable, versionRequirement2, deserializedContainerSource2, (i & 1024) != 0 ? null : sourceElement);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1.SimpleFunctionDescriptorImpl, p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1.FunctionDescriptorImpl
    /* renamed from: b */
    public FunctionDescriptorImpl mo9373b(DeclarationDescriptor declarationDescriptor, FunctionDescriptor functionDescriptor, CallableMemberDescriptor.a aVar, Name name, Annotations4 annotations4, SourceElement sourceElement) {
        Name name2;
        Intrinsics3.checkNotNullParameter(declarationDescriptor, "newOwner");
        Intrinsics3.checkNotNullParameter(aVar, "kind");
        Intrinsics3.checkNotNullParameter(annotations4, "annotations");
        Intrinsics3.checkNotNullParameter(sourceElement, "source");
        SimpleFunctionDescriptor simpleFunctionDescriptor = (SimpleFunctionDescriptor) functionDescriptor;
        if (name == null) {
            Name name3 = getName();
            Intrinsics3.checkNotNullExpressionValue(name3, ModelAuditLogEntry.CHANGE_KEY_NAME);
            name2 = name3;
        } else {
            name2 = name;
        }
        DeserializedMemberDescriptor5 deserializedMemberDescriptor5 = new DeserializedMemberDescriptor5(declarationDescriptor, simpleFunctionDescriptor, annotations4, name2, aVar, getProto(), getNameResolver(), getTypeTable(), getVersionRequirementTable(), getContainerSource(), sourceElement);
        deserializedMemberDescriptor5.setHasStableParameterNames(hasStableParameterNames());
        deserializedMemberDescriptor5.f24609R = getCoroutinesExperimentalCompatibilityMode();
        return deserializedMemberDescriptor5;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b.p565e0.DeserializedMemberDescriptor3
    public DeserializedContainerSource2 getContainerSource() {
        return this.f24608Q;
    }

    public DeserializedMemberDescriptor3.a getCoroutinesExperimentalCompatibilityMode() {
        return this.f24609R;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b.p565e0.DeserializedMemberDescriptor3
    public NameResolver getNameResolver() {
        return this.f24605N;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b.p565e0.DeserializedMemberDescriptor3
    public /* bridge */ /* synthetic */ MessageLite getProto() {
        return getProto();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b.p565e0.DeserializedMemberDescriptor3
    public TypeTable getTypeTable() {
        return this.f24606O;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b.p565e0.DeserializedMemberDescriptor3
    public VersionRequirement2 getVersionRequirementTable() {
        return this.f24607P;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b.p565e0.DeserializedMemberDescriptor3
    public List<VersionRequirement> getVersionRequirements() {
        return DeserializedMemberDescriptor.a.getVersionRequirements(this);
    }

    public final SimpleFunctionDescriptorImpl initialize(ReceiverParameterDescriptor receiverParameterDescriptor, ReceiverParameterDescriptor receiverParameterDescriptor2, List<? extends TypeParameterDescriptor> list, List<? extends ValueParameterDescriptor> list2, KotlinType kotlinType, Modality modality, DescriptorVisibility2 descriptorVisibility2, Map<? extends CallableDescriptor.a<?>, ?> map, DeserializedMemberDescriptor3.a aVar) {
        Intrinsics3.checkNotNullParameter(list, "typeParameters");
        Intrinsics3.checkNotNullParameter(list2, "unsubstitutedValueParameters");
        Intrinsics3.checkNotNullParameter(descriptorVisibility2, "visibility");
        Intrinsics3.checkNotNullParameter(map, "userDataMap");
        Intrinsics3.checkNotNullParameter(aVar, "isExperimentalCoroutineInReleaseEnvironment");
        SimpleFunctionDescriptorImpl simpleFunctionDescriptorImplInitialize = super.initialize(receiverParameterDescriptor, receiverParameterDescriptor2, list, list2, kotlinType, modality, descriptorVisibility2, map);
        Intrinsics3.checkNotNullExpressionValue(simpleFunctionDescriptorImplInitialize, "super.initialize(\n            extensionReceiverParameter,\n            dispatchReceiverParameter,\n            typeParameters,\n            unsubstitutedValueParameters,\n            unsubstitutedReturnType,\n            modality,\n            visibility,\n            userDataMap\n        )");
        this.f24609R = aVar;
        return simpleFunctionDescriptorImplInitialize;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DeserializedMemberDescriptor5(DeclarationDescriptor declarationDescriptor, SimpleFunctionDescriptor simpleFunctionDescriptor, Annotations4 annotations4, Name name, CallableMemberDescriptor.a aVar, C11684i c11684i, NameResolver nameResolver, TypeTable typeTable, VersionRequirement2 versionRequirement2, DeserializedContainerSource2 deserializedContainerSource2, SourceElement sourceElement) {
        super(declarationDescriptor, simpleFunctionDescriptor, annotations4, name, aVar, sourceElement == null ? SourceElement.f23099a : sourceElement);
        Intrinsics3.checkNotNullParameter(declarationDescriptor, "containingDeclaration");
        Intrinsics3.checkNotNullParameter(annotations4, "annotations");
        Intrinsics3.checkNotNullParameter(name, ModelAuditLogEntry.CHANGE_KEY_NAME);
        Intrinsics3.checkNotNullParameter(aVar, "kind");
        Intrinsics3.checkNotNullParameter(c11684i, "proto");
        Intrinsics3.checkNotNullParameter(nameResolver, "nameResolver");
        Intrinsics3.checkNotNullParameter(typeTable, "typeTable");
        Intrinsics3.checkNotNullParameter(versionRequirement2, "versionRequirementTable");
        this.f24604M = c11684i;
        this.f24605N = nameResolver;
        this.f24606O = typeTable;
        this.f24607P = versionRequirement2;
        this.f24608Q = deserializedContainerSource2;
        this.f24609R = DeserializedMemberDescriptor3.a.COMPATIBLE;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b.p565e0.DeserializedMemberDescriptor3
    public C11684i getProto() {
        return this.f24604M;
    }
}

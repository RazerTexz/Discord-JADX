package p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b.p565e0;

import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.CallableMemberDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.ClassDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.ConstructorDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.DeclarationDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.FunctionDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.SourceElement;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1.Annotations4;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1.ClassConstructorDescriptorImpl;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1.FunctionDescriptorImpl;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.C11679d;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.p547z.NameResolver;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.p547z.TypeTable;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.p547z.VersionRequirement;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.p547z.VersionRequirement2;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.Name;
import p507d0.p513e0.p514p.p515d.p517m0.p550i.MessageLite;
import p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b.p565e0.DeserializedMemberDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b.p565e0.DeserializedMemberDescriptor3;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: DeserializedMemberDescriptor.kt */
/* renamed from: d0.e0.p.d.m0.l.b.e0.c, reason: use source file name */
/* loaded from: classes3.dex */
public final class DeserializedMemberDescriptor2 extends ClassConstructorDescriptorImpl implements DeserializedMemberDescriptor {

    /* renamed from: O */
    public final C11679d f24523O;

    /* renamed from: P */
    public final NameResolver f24524P;

    /* renamed from: Q */
    public final TypeTable f24525Q;

    /* renamed from: R */
    public final VersionRequirement2 f24526R;

    /* renamed from: S */
    public final DeserializedContainerSource2 f24527S;

    /* renamed from: T */
    public DeserializedMemberDescriptor3.a f24528T;

    public /* synthetic */ DeserializedMemberDescriptor2(ClassDescriptor classDescriptor, ConstructorDescriptor constructorDescriptor, Annotations4 annotations4, boolean z2, CallableMemberDescriptor.a aVar, C11679d c11679d, NameResolver nameResolver, TypeTable typeTable, VersionRequirement2 versionRequirement2, DeserializedContainerSource2 deserializedContainerSource2, SourceElement sourceElement, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(classDescriptor, constructorDescriptor, annotations4, z2, aVar, c11679d, nameResolver, typeTable, versionRequirement2, deserializedContainerSource2, (i & 1024) != 0 ? null : sourceElement);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1.ClassConstructorDescriptorImpl, p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1.FunctionDescriptorImpl
    /* renamed from: b */
    public /* bridge */ /* synthetic */ FunctionDescriptorImpl mo9373b(DeclarationDescriptor declarationDescriptor, FunctionDescriptor functionDescriptor, CallableMemberDescriptor.a aVar, Name name, Annotations4 annotations4, SourceElement sourceElement) {
        return m9953f(declarationDescriptor, functionDescriptor, aVar, annotations4, sourceElement);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1.ClassConstructorDescriptorImpl
    /* renamed from: e */
    public /* bridge */ /* synthetic */ ClassConstructorDescriptorImpl mo9408e(DeclarationDescriptor declarationDescriptor, FunctionDescriptor functionDescriptor, CallableMemberDescriptor.a aVar, Name name, Annotations4 annotations4, SourceElement sourceElement) {
        return m9953f(declarationDescriptor, functionDescriptor, aVar, annotations4, sourceElement);
    }

    /* renamed from: f */
    public DeserializedMemberDescriptor2 m9953f(DeclarationDescriptor declarationDescriptor, FunctionDescriptor functionDescriptor, CallableMemberDescriptor.a aVar, Annotations4 annotations4, SourceElement sourceElement) {
        Intrinsics3.checkNotNullParameter(declarationDescriptor, "newOwner");
        Intrinsics3.checkNotNullParameter(aVar, "kind");
        Intrinsics3.checkNotNullParameter(annotations4, "annotations");
        Intrinsics3.checkNotNullParameter(sourceElement, "source");
        DeserializedMemberDescriptor2 deserializedMemberDescriptor2 = new DeserializedMemberDescriptor2((ClassDescriptor) declarationDescriptor, (ConstructorDescriptor) functionDescriptor, annotations4, this.f22874N, aVar, getProto(), getNameResolver(), getTypeTable(), getVersionRequirementTable(), getContainerSource(), sourceElement);
        deserializedMemberDescriptor2.setHasStableParameterNames(hasStableParameterNames());
        deserializedMemberDescriptor2.setCoroutinesExperimentalCompatibilityMode$deserialization(getCoroutinesExperimentalCompatibilityMode());
        return deserializedMemberDescriptor2;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b.p565e0.DeserializedMemberDescriptor3
    public DeserializedContainerSource2 getContainerSource() {
        return this.f24527S;
    }

    public DeserializedMemberDescriptor3.a getCoroutinesExperimentalCompatibilityMode() {
        return this.f24528T;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b.p565e0.DeserializedMemberDescriptor3
    public NameResolver getNameResolver() {
        return this.f24524P;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b.p565e0.DeserializedMemberDescriptor3
    public /* bridge */ /* synthetic */ MessageLite getProto() {
        return getProto();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b.p565e0.DeserializedMemberDescriptor3
    public TypeTable getTypeTable() {
        return this.f24525Q;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b.p565e0.DeserializedMemberDescriptor3
    public VersionRequirement2 getVersionRequirementTable() {
        return this.f24526R;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b.p565e0.DeserializedMemberDescriptor3
    public List<VersionRequirement> getVersionRequirements() {
        return DeserializedMemberDescriptor.a.getVersionRequirements(this);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1.FunctionDescriptorImpl, p507d0.p513e0.p514p.p515d.p517m0.p521c.MemberDescriptor
    public boolean isExternal() {
        return false;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1.FunctionDescriptorImpl, p507d0.p513e0.p514p.p515d.p517m0.p521c.FunctionDescriptor
    public boolean isInline() {
        return false;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1.FunctionDescriptorImpl, p507d0.p513e0.p514p.p515d.p517m0.p521c.FunctionDescriptor
    public boolean isSuspend() {
        return false;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1.FunctionDescriptorImpl, p507d0.p513e0.p514p.p515d.p517m0.p521c.FunctionDescriptor
    public boolean isTailrec() {
        return false;
    }

    public void setCoroutinesExperimentalCompatibilityMode$deserialization(DeserializedMemberDescriptor3.a aVar) {
        Intrinsics3.checkNotNullParameter(aVar, "<set-?>");
        this.f24528T = aVar;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DeserializedMemberDescriptor2(ClassDescriptor classDescriptor, ConstructorDescriptor constructorDescriptor, Annotations4 annotations4, boolean z2, CallableMemberDescriptor.a aVar, C11679d c11679d, NameResolver nameResolver, TypeTable typeTable, VersionRequirement2 versionRequirement2, DeserializedContainerSource2 deserializedContainerSource2, SourceElement sourceElement) {
        super(classDescriptor, constructorDescriptor, annotations4, z2, aVar, sourceElement == null ? SourceElement.f23099a : sourceElement);
        Intrinsics3.checkNotNullParameter(classDescriptor, "containingDeclaration");
        Intrinsics3.checkNotNullParameter(annotations4, "annotations");
        Intrinsics3.checkNotNullParameter(aVar, "kind");
        Intrinsics3.checkNotNullParameter(c11679d, "proto");
        Intrinsics3.checkNotNullParameter(nameResolver, "nameResolver");
        Intrinsics3.checkNotNullParameter(typeTable, "typeTable");
        Intrinsics3.checkNotNullParameter(versionRequirement2, "versionRequirementTable");
        this.f24523O = c11679d;
        this.f24524P = nameResolver;
        this.f24525Q = typeTable;
        this.f24526R = versionRequirement2;
        this.f24527S = deserializedContainerSource2;
        this.f24528T = DeserializedMemberDescriptor3.a.COMPATIBLE;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b.p565e0.DeserializedMemberDescriptor3
    public C11679d getProto() {
        return this.f24523O;
    }
}

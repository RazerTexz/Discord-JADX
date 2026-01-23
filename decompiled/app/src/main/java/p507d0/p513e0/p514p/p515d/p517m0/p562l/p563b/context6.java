package p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b;

import java.util.List;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.DeclarationDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.C11694s;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.p547z.BinaryVersion;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.p547z.NameResolver;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.p547z.TypeTable;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.p547z.VersionRequirement2;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.p547z.versionSpecificBehavior;
import p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b.p565e0.DeserializedContainerSource2;
import p507d0.p513e0.p514p.p515d.p517m0.p566m.StorageManager;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: renamed from: d0.e0.p.d.m0.l.b.l, reason: use source file name */
/* JADX INFO: compiled from: context.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class context6 {

    /* JADX INFO: renamed from: a */
    public final context5 f24659a;

    /* JADX INFO: renamed from: b */
    public final NameResolver f24660b;

    /* JADX INFO: renamed from: c */
    public final DeclarationDescriptor f24661c;

    /* JADX INFO: renamed from: d */
    public final TypeTable f24662d;

    /* JADX INFO: renamed from: e */
    public final VersionRequirement2 f24663e;

    /* JADX INFO: renamed from: f */
    public final BinaryVersion f24664f;

    /* JADX INFO: renamed from: g */
    public final DeserializedContainerSource2 f24665g;

    /* JADX INFO: renamed from: h */
    public final TypeDeserializer f24666h;

    /* JADX INFO: renamed from: i */
    public final MemberDeserializer f24667i;

    public context6(context5 context5Var, NameResolver nameResolver, DeclarationDescriptor declarationDescriptor, TypeTable typeTable, VersionRequirement2 versionRequirement2, BinaryVersion binaryVersion, DeserializedContainerSource2 deserializedContainerSource2, TypeDeserializer typeDeserializer, List<C11694s> list) {
        String presentableString;
        Intrinsics3.checkNotNullParameter(context5Var, "components");
        Intrinsics3.checkNotNullParameter(nameResolver, "nameResolver");
        Intrinsics3.checkNotNullParameter(declarationDescriptor, "containingDeclaration");
        Intrinsics3.checkNotNullParameter(typeTable, "typeTable");
        Intrinsics3.checkNotNullParameter(versionRequirement2, "versionRequirementTable");
        Intrinsics3.checkNotNullParameter(binaryVersion, "metadataVersion");
        Intrinsics3.checkNotNullParameter(list, "typeParameters");
        this.f24659a = context5Var;
        this.f24660b = nameResolver;
        this.f24661c = declarationDescriptor;
        this.f24662d = typeTable;
        this.f24663e = versionRequirement2;
        this.f24664f = binaryVersion;
        this.f24665g = deserializedContainerSource2;
        StringBuilder sbM833U = outline.m833U("Deserializer for \"");
        sbM833U.append(declarationDescriptor.getName());
        sbM833U.append('\"');
        this.f24666h = new TypeDeserializer(this, typeDeserializer, list, sbM833U.toString(), (deserializedContainerSource2 == null || (presentableString = deserializedContainerSource2.getPresentableString()) == null) ? "[container not found]" : presentableString, false, 32, null);
        this.f24667i = new MemberDeserializer(this);
    }

    public static /* synthetic */ context6 childContext$default(context6 context6Var, DeclarationDescriptor declarationDescriptor, List list, NameResolver nameResolver, TypeTable typeTable, VersionRequirement2 versionRequirement2, BinaryVersion binaryVersion, int i, Object obj) {
        if ((i & 4) != 0) {
            nameResolver = context6Var.f24660b;
        }
        NameResolver nameResolver2 = nameResolver;
        if ((i & 8) != 0) {
            typeTable = context6Var.f24662d;
        }
        TypeTable typeTable2 = typeTable;
        if ((i & 16) != 0) {
            versionRequirement2 = context6Var.f24663e;
        }
        VersionRequirement2 versionRequirement22 = versionRequirement2;
        if ((i & 32) != 0) {
            binaryVersion = context6Var.f24664f;
        }
        return context6Var.childContext(declarationDescriptor, list, nameResolver2, typeTable2, versionRequirement22, binaryVersion);
    }

    public final context6 childContext(DeclarationDescriptor declarationDescriptor, List<C11694s> list, NameResolver nameResolver, TypeTable typeTable, VersionRequirement2 versionRequirement2, BinaryVersion binaryVersion) {
        Intrinsics3.checkNotNullParameter(declarationDescriptor, "descriptor");
        Intrinsics3.checkNotNullParameter(list, "typeParameterProtos");
        Intrinsics3.checkNotNullParameter(nameResolver, "nameResolver");
        Intrinsics3.checkNotNullParameter(typeTable, "typeTable");
        VersionRequirement2 versionRequirement22 = versionRequirement2;
        Intrinsics3.checkNotNullParameter(versionRequirement22, "versionRequirementTable");
        Intrinsics3.checkNotNullParameter(binaryVersion, "metadataVersion");
        context5 context5Var = this.f24659a;
        if (!versionSpecificBehavior.isVersionRequirementTableWrittenCorrectly(binaryVersion)) {
            versionRequirement22 = this.f24663e;
        }
        return new context6(context5Var, nameResolver, declarationDescriptor, typeTable, versionRequirement22, binaryVersion, this.f24665g, this.f24666h, list);
    }

    public final context5 getComponents() {
        return this.f24659a;
    }

    public final DeserializedContainerSource2 getContainerSource() {
        return this.f24665g;
    }

    public final DeclarationDescriptor getContainingDeclaration() {
        return this.f24661c;
    }

    public final MemberDeserializer getMemberDeserializer() {
        return this.f24667i;
    }

    public final NameResolver getNameResolver() {
        return this.f24660b;
    }

    public final StorageManager getStorageManager() {
        return this.f24659a.getStorageManager();
    }

    public final TypeDeserializer getTypeDeserializer() {
        return this.f24666h;
    }

    public final TypeTable getTypeTable() {
        return this.f24662d;
    }

    public final VersionRequirement2 getVersionRequirementTable() {
        return this.f24663e;
    }
}

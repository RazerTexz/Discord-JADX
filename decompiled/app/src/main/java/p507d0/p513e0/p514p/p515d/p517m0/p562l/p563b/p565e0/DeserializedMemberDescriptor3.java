package p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b.p565e0;

import java.util.List;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.DeclarationDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.MemberDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.p547z.NameResolver;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.p547z.TypeTable;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.p547z.VersionRequirement;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.p547z.VersionRequirement2;
import p507d0.p513e0.p514p.p515d.p517m0.p550i.MessageLite;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: DeserializedMemberDescriptor.kt */
/* renamed from: d0.e0.p.d.m0.l.b.e0.g, reason: use source file name */
/* loaded from: classes3.dex */
public interface DeserializedMemberDescriptor3 extends DeclarationDescriptor, MemberDescriptor {

    /* compiled from: DeserializedMemberDescriptor.kt */
    /* renamed from: d0.e0.p.d.m0.l.b.e0.g$a */
    public enum a {
        COMPATIBLE,
        NEEDS_WRAPPER,
        INCOMPATIBLE;

        /* renamed from: values, reason: to resolve conflict with enum method */
        public static a[] valuesCustom() {
            a[] aVarArrValuesCustom = values();
            a[] aVarArr = new a[aVarArrValuesCustom.length];
            System.arraycopy(aVarArrValuesCustom, 0, aVarArr, 0, aVarArrValuesCustom.length);
            return aVarArr;
        }
    }

    /* compiled from: DeserializedMemberDescriptor.kt */
    /* renamed from: d0.e0.p.d.m0.l.b.e0.g$b */
    public static final class b {
        public static List<VersionRequirement> getVersionRequirements(DeserializedMemberDescriptor3 deserializedMemberDescriptor3) {
            Intrinsics3.checkNotNullParameter(deserializedMemberDescriptor3, "this");
            return VersionRequirement.f24062a.create(deserializedMemberDescriptor3.getProto(), deserializedMemberDescriptor3.getNameResolver(), deserializedMemberDescriptor3.getVersionRequirementTable());
        }
    }

    DeserializedContainerSource2 getContainerSource();

    NameResolver getNameResolver();

    MessageLite getProto();

    TypeTable getTypeTable();

    VersionRequirement2 getVersionRequirementTable();

    List<VersionRequirement> getVersionRequirements();
}

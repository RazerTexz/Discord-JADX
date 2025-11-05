package d0.e0.p.d.m0.l.b.e0;

import d0.e0.p.d.m0.c.y;
import java.util.List;

/* compiled from: DeserializedMemberDescriptor.kt */
/* loaded from: classes3.dex */
public interface g extends d0.e0.p.d.m0.c.m, y {

    /* compiled from: DeserializedMemberDescriptor.kt */
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
    public static final class b {
        public static List<d0.e0.p.d.m0.f.z.h> getVersionRequirements(g gVar) {
            d0.z.d.m.checkNotNullParameter(gVar, "this");
            return d0.e0.p.d.m0.f.z.h.a.create(gVar.getProto(), gVar.getNameResolver(), gVar.getVersionRequirementTable());
        }
    }

    f getContainerSource();

    d0.e0.p.d.m0.f.z.c getNameResolver();

    d0.e0.p.d.m0.i.n getProto();

    d0.e0.p.d.m0.f.z.g getTypeTable();

    d0.e0.p.d.m0.f.z.i getVersionRequirementTable();

    List<d0.e0.p.d.m0.f.z.h> getVersionRequirements();
}

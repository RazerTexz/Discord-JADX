package p507d0.p513e0.p514p.p515d.p517m0.p543f.p547z;

import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.C11697v;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.C11698w;
import p507d0.p580t.Collections2;
import p507d0.p580t._Collections;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: renamed from: d0.e0.p.d.m0.f.z.i, reason: use source file name */
/* JADX INFO: compiled from: VersionRequirement.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class VersionRequirement2 {

    /* JADX INFO: renamed from: a */
    public static final a f24073a = new a(null);

    /* JADX INFO: renamed from: b */
    public static final VersionRequirement2 f24074b = new VersionRequirement2(Collections2.emptyList());

    /* JADX INFO: renamed from: c */
    public final List<C11697v> f24075c;

    /* JADX INFO: renamed from: d0.e0.p.d.m0.f.z.i$a */
    /* JADX INFO: compiled from: VersionRequirement.kt */
    public static final class a {
        public a(DefaultConstructorMarker defaultConstructorMarker) {
        }

        public final VersionRequirement2 create(C11698w c11698w) {
            Intrinsics3.checkNotNullParameter(c11698w, "table");
            if (c11698w.getRequirementCount() == 0) {
                return getEMPTY();
            }
            List<C11697v> requirementList = c11698w.getRequirementList();
            Intrinsics3.checkNotNullExpressionValue(requirementList, "table.requirementList");
            return new VersionRequirement2(requirementList, null);
        }

        public final VersionRequirement2 getEMPTY() {
            return VersionRequirement2.access$getEMPTY$cp();
        }
    }

    public VersionRequirement2(List<C11697v> list) {
        this.f24075c = list;
    }

    public static final /* synthetic */ VersionRequirement2 access$getEMPTY$cp() {
        return f24074b;
    }

    public final C11697v get(int i) {
        return (C11697v) _Collections.getOrNull(this.f24075c, i);
    }

    public VersionRequirement2(List list, DefaultConstructorMarker defaultConstructorMarker) {
        this.f24075c = list;
    }
}

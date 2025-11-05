package d0.e0.p.d.m0.f.z;

import d0.e0.p.d.m0.f.v;
import d0.e0.p.d.m0.f.w;
import d0.t.n;
import d0.t.u;
import d0.z.d.m;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: VersionRequirement.kt */
/* loaded from: classes3.dex */
public final class i {
    public static final a a = new a(null);

    /* renamed from: b, reason: collision with root package name */
    public static final i f3421b = new i(n.emptyList());
    public final List<v> c;

    /* compiled from: VersionRequirement.kt */
    public static final class a {
        public a(DefaultConstructorMarker defaultConstructorMarker) {
        }

        public final i create(w wVar) {
            m.checkNotNullParameter(wVar, "table");
            if (wVar.getRequirementCount() == 0) {
                return getEMPTY();
            }
            List<v> requirementList = wVar.getRequirementList();
            m.checkNotNullExpressionValue(requirementList, "table.requirementList");
            return new i(requirementList, null);
        }

        public final i getEMPTY() {
            return i.access$getEMPTY$cp();
        }
    }

    public i(List<v> list) {
        this.c = list;
    }

    public static final /* synthetic */ i access$getEMPTY$cp() {
        return f3421b;
    }

    public final v get(int i) {
        return (v) u.getOrNull(this.c, i);
    }

    public i(List list, DefaultConstructorMarker defaultConstructorMarker) {
        this.c = list;
    }
}

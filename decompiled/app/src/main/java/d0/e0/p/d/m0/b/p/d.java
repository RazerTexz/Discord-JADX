package d0.e0.p.d.m0.b.p;

import d0.e0.p.d.m0.c.x;
import d0.e0.p.d.m0.m.o;
import d0.t.n;
import d0.z.d.m;
import java.util.List;

/* compiled from: FunctionClassScope.kt */
/* loaded from: classes3.dex */
public final class d extends d0.e0.p.d.m0.k.a0.e {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(o oVar, b bVar) {
        super(oVar, bVar);
        m.checkNotNullParameter(oVar, "storageManager");
        m.checkNotNullParameter(bVar, "containingClass");
    }

    @Override // d0.e0.p.d.m0.k.a0.e
    public List<x> a() {
        int iOrdinal = ((b) this.c).getFunctionKind().ordinal();
        return iOrdinal != 0 ? iOrdinal != 1 ? n.emptyList() : d0.t.m.listOf(e.M.create((b) this.c, true)) : d0.t.m.listOf(e.M.create((b) this.c, false));
    }
}

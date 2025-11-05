package d0.e0.p.d.m0.o;

import d0.e0.p.d.m0.c.x;
import d0.e0.p.d.m0.o.c;
import d0.z.d.m;
import java.util.List;

/* compiled from: modifierChecks.kt */
/* loaded from: classes3.dex */
public abstract class a {
    public final c check(x xVar) {
        m.checkNotNullParameter(xVar, "functionDescriptor");
        for (d dVar : getChecks$descriptors()) {
            if (dVar.isApplicable(xVar)) {
                return dVar.checkAll(xVar);
            }
        }
        return c.a.f3545b;
    }

    public abstract List<d> getChecks$descriptors();
}

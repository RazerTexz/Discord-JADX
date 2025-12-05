package p507d0.p513e0.p514p.p515d.p517m0.p573o;

import java.util.List;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.FunctionDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p573o.AbstractC12021c;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: modifierChecks.kt */
/* renamed from: d0.e0.p.d.m0.o.a */
/* loaded from: classes3.dex */
public abstract class AbstractC12019a {
    public final AbstractC12021c check(FunctionDescriptor functionDescriptor) {
        Intrinsics3.checkNotNullParameter(functionDescriptor, "functionDescriptor");
        for (C12022d c12022d : getChecks$descriptors()) {
            if (c12022d.isApplicable(functionDescriptor)) {
                return c12022d.checkAll(functionDescriptor);
            }
        }
        return AbstractC12021c.a.f24901b;
    }

    public abstract List<C12022d> getChecks$descriptors();
}

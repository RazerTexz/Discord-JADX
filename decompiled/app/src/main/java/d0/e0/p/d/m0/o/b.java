package d0.e0.p.d.m0.o;

import d0.e0.p.d.m0.c.x;
import d0.z.d.m;

/* compiled from: modifierChecks.kt */
/* loaded from: classes3.dex */
public interface b {

    /* compiled from: modifierChecks.kt */
    public static final class a {
        public static String invoke(b bVar, x xVar) {
            m.checkNotNullParameter(bVar, "this");
            m.checkNotNullParameter(xVar, "functionDescriptor");
            if (bVar.check(xVar)) {
                return null;
            }
            return bVar.getDescription();
        }
    }

    boolean check(x xVar);

    String getDescription();

    String invoke(x xVar);
}

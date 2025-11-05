package d0.e0.p.d.m0.c;

import java.util.Collection;
import java.util.List;
import kotlin.jvm.functions.Function1;

/* compiled from: ModuleDescriptor.kt */
/* loaded from: classes3.dex */
public interface c0 extends m {

    /* compiled from: ModuleDescriptor.kt */
    public static final class a {
        public static <R, D> R accept(c0 c0Var, o<R, D> oVar, D d) {
            d0.z.d.m.checkNotNullParameter(c0Var, "this");
            d0.z.d.m.checkNotNullParameter(oVar, "visitor");
            return oVar.visitModuleDeclaration(c0Var, d);
        }

        public static m getContainingDeclaration(c0 c0Var) {
            d0.z.d.m.checkNotNullParameter(c0Var, "this");
            return null;
        }
    }

    d0.e0.p.d.m0.b.h getBuiltIns();

    <T> T getCapability(b0<T> b0Var);

    List<c0> getExpectedByModules();

    j0 getPackage(d0.e0.p.d.m0.g.b bVar);

    Collection<d0.e0.p.d.m0.g.b> getSubPackagesOf(d0.e0.p.d.m0.g.b bVar, Function1<? super d0.e0.p.d.m0.g.e, Boolean> function1);

    boolean shouldSeeInternalsOf(c0 c0Var);
}

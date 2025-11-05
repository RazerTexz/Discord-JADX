package d0.e0.p.d.m0.c.h1;

import d0.e0.p.d.m0.c.t0;
import d0.z.d.m;

/* compiled from: PlatformDependentDeclarationFilter.kt */
/* loaded from: classes3.dex */
public interface c {

    /* compiled from: PlatformDependentDeclarationFilter.kt */
    public static final class a implements c {
        public static final a a = new a();

        @Override // d0.e0.p.d.m0.c.h1.c
        public boolean isFunctionAvailable(d0.e0.p.d.m0.c.e eVar, t0 t0Var) {
            m.checkNotNullParameter(eVar, "classDescriptor");
            m.checkNotNullParameter(t0Var, "functionDescriptor");
            return true;
        }
    }

    /* compiled from: PlatformDependentDeclarationFilter.kt */
    public static final class b implements c {
        public static final b a = new b();

        @Override // d0.e0.p.d.m0.c.h1.c
        public boolean isFunctionAvailable(d0.e0.p.d.m0.c.e eVar, t0 t0Var) {
            m.checkNotNullParameter(eVar, "classDescriptor");
            m.checkNotNullParameter(t0Var, "functionDescriptor");
            return !t0Var.getAnnotations().hasAnnotation(d.getPLATFORM_DEPENDENT_ANNOTATION_FQ_NAME());
        }
    }

    boolean isFunctionAvailable(d0.e0.p.d.m0.c.e eVar, t0 t0Var);
}

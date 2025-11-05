package d0.e0.p.d.m0.n;

/* compiled from: TypeAliasExpansionReportStrategy.kt */
/* loaded from: classes3.dex */
public interface s0 {

    /* compiled from: TypeAliasExpansionReportStrategy.kt */
    public static final class a implements s0 {
        public static final a a = new a();

        @Override // d0.e0.p.d.m0.n.s0
        public void boundsViolationInSubstitution(c0 c0Var, c0 c0Var2, c0 c0Var3, d0.e0.p.d.m0.c.z0 z0Var) {
            d0.z.d.m.checkNotNullParameter(c0Var, "bound");
            d0.z.d.m.checkNotNullParameter(c0Var2, "unsubstitutedArgument");
            d0.z.d.m.checkNotNullParameter(c0Var3, "argument");
            d0.z.d.m.checkNotNullParameter(z0Var, "typeParameter");
        }

        @Override // d0.e0.p.d.m0.n.s0
        public void conflictingProjection(d0.e0.p.d.m0.c.y0 y0Var, d0.e0.p.d.m0.c.z0 z0Var, c0 c0Var) {
            d0.z.d.m.checkNotNullParameter(y0Var, "typeAlias");
            d0.z.d.m.checkNotNullParameter(c0Var, "substitutedArgument");
        }

        @Override // d0.e0.p.d.m0.n.s0
        public void recursiveTypeAlias(d0.e0.p.d.m0.c.y0 y0Var) {
            d0.z.d.m.checkNotNullParameter(y0Var, "typeAlias");
        }

        @Override // d0.e0.p.d.m0.n.s0
        public void repeatedAnnotation(d0.e0.p.d.m0.c.g1.c cVar) {
            d0.z.d.m.checkNotNullParameter(cVar, "annotation");
        }
    }

    void boundsViolationInSubstitution(c0 c0Var, c0 c0Var2, c0 c0Var3, d0.e0.p.d.m0.c.z0 z0Var);

    void conflictingProjection(d0.e0.p.d.m0.c.y0 y0Var, d0.e0.p.d.m0.c.z0 z0Var, c0 c0Var);

    void recursiveTypeAlias(d0.e0.p.d.m0.c.y0 y0Var);

    void repeatedAnnotation(d0.e0.p.d.m0.c.g1.c cVar);
}

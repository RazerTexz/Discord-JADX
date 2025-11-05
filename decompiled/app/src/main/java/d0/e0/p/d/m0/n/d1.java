package d0.e0.p.d.m0.n;

/* compiled from: TypeSystemCommonBackendContext.kt */
/* loaded from: classes3.dex */
public interface d1 extends d0.e0.p.d.m0.n.n1.n {

    /* compiled from: TypeSystemCommonBackendContext.kt */
    public static final class a {
        public static d0.e0.p.d.m0.n.n1.h makeNullable(d1 d1Var, d0.e0.p.d.m0.n.n1.h hVar) {
            d0.z.d.m.checkNotNullParameter(d1Var, "this");
            d0.z.d.m.checkNotNullParameter(hVar, "receiver");
            d0.e0.p.d.m0.n.n1.i iVarAsSimpleType = d1Var.asSimpleType(hVar);
            return iVarAsSimpleType == null ? hVar : d1Var.withNullability(iVarAsSimpleType, true);
        }
    }

    d0.e0.p.d.m0.g.c getClassFqNameUnsafe(d0.e0.p.d.m0.n.n1.l lVar);

    d0.e0.p.d.m0.b.i getPrimitiveArrayType(d0.e0.p.d.m0.n.n1.l lVar);

    d0.e0.p.d.m0.b.i getPrimitiveType(d0.e0.p.d.m0.n.n1.l lVar);

    d0.e0.p.d.m0.n.n1.h getRepresentativeUpperBound(d0.e0.p.d.m0.n.n1.m mVar);

    d0.e0.p.d.m0.n.n1.h getSubstitutedUnderlyingType(d0.e0.p.d.m0.n.n1.h hVar);

    d0.e0.p.d.m0.n.n1.m getTypeParameterClassifier(d0.e0.p.d.m0.n.n1.l lVar);

    boolean hasAnnotation(d0.e0.p.d.m0.n.n1.h hVar, d0.e0.p.d.m0.g.b bVar);

    boolean isInlineClass(d0.e0.p.d.m0.n.n1.l lVar);

    boolean isUnderKotlinPackage(d0.e0.p.d.m0.n.n1.l lVar);

    d0.e0.p.d.m0.n.n1.h makeNullable(d0.e0.p.d.m0.n.n1.h hVar);
}

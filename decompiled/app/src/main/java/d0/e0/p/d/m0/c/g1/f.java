package d0.e0.p.d.m0.c.g1;

import d0.e0.p.d.m0.b.k;
import d0.e0.p.d.m0.c.c0;
import d0.e0.p.d.m0.k.v.w;
import d0.e0.p.d.m0.n.j0;
import d0.e0.p.d.m0.n.j1;
import d0.t.h0;
import d0.z.d.o;
import kotlin.jvm.functions.Function1;

/* compiled from: annotationUtil.kt */
/* loaded from: classes3.dex */
public final class f {
    public static final d0.e0.p.d.m0.g.e a;

    /* renamed from: b, reason: collision with root package name */
    public static final d0.e0.p.d.m0.g.e f3250b;
    public static final d0.e0.p.d.m0.g.e c;
    public static final d0.e0.p.d.m0.g.e d;
    public static final d0.e0.p.d.m0.g.e e;

    /* compiled from: annotationUtil.kt */
    public static final class a extends o implements Function1<c0, d0.e0.p.d.m0.n.c0> {
        public final /* synthetic */ d0.e0.p.d.m0.b.h $this_createDeprecatedAnnotation;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(d0.e0.p.d.m0.b.h hVar) {
            super(1);
            this.$this_createDeprecatedAnnotation = hVar;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ d0.e0.p.d.m0.n.c0 invoke(c0 c0Var) {
            return invoke2(c0Var);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final d0.e0.p.d.m0.n.c0 invoke2(c0 c0Var) {
            d0.z.d.m.checkNotNullParameter(c0Var, "module");
            j0 arrayType = c0Var.getBuiltIns().getArrayType(j1.INVARIANT, this.$this_createDeprecatedAnnotation.getStringType());
            d0.z.d.m.checkNotNullExpressionValue(arrayType, "module.builtIns.getArrayType(Variance.INVARIANT, stringType)");
            return arrayType;
        }
    }

    static {
        d0.e0.p.d.m0.g.e eVarIdentifier = d0.e0.p.d.m0.g.e.identifier("message");
        d0.z.d.m.checkNotNullExpressionValue(eVarIdentifier, "identifier(\"message\")");
        a = eVarIdentifier;
        d0.e0.p.d.m0.g.e eVarIdentifier2 = d0.e0.p.d.m0.g.e.identifier("replaceWith");
        d0.z.d.m.checkNotNullExpressionValue(eVarIdentifier2, "identifier(\"replaceWith\")");
        f3250b = eVarIdentifier2;
        d0.e0.p.d.m0.g.e eVarIdentifier3 = d0.e0.p.d.m0.g.e.identifier("level");
        d0.z.d.m.checkNotNullExpressionValue(eVarIdentifier3, "identifier(\"level\")");
        c = eVarIdentifier3;
        d0.e0.p.d.m0.g.e eVarIdentifier4 = d0.e0.p.d.m0.g.e.identifier("expression");
        d0.z.d.m.checkNotNullExpressionValue(eVarIdentifier4, "identifier(\"expression\")");
        d = eVarIdentifier4;
        d0.e0.p.d.m0.g.e eVarIdentifier5 = d0.e0.p.d.m0.g.e.identifier("imports");
        d0.z.d.m.checkNotNullExpressionValue(eVarIdentifier5, "identifier(\"imports\")");
        e = eVarIdentifier5;
    }

    public static final c createDeprecatedAnnotation(d0.e0.p.d.m0.b.h hVar, String str, String str2, String str3) {
        d0.z.d.m.checkNotNullParameter(hVar, "<this>");
        d0.z.d.m.checkNotNullParameter(str, "message");
        d0.z.d.m.checkNotNullParameter(str2, "replaceWith");
        d0.z.d.m.checkNotNullParameter(str3, "level");
        j jVar = new j(hVar, k.a.w, h0.mapOf(d0.o.to(d, new w(str2)), d0.o.to(e, new d0.e0.p.d.m0.k.v.b(d0.t.n.emptyList(), new a(hVar)))));
        d0.e0.p.d.m0.g.b bVar = k.a.u;
        d0.e0.p.d.m0.g.e eVar = c;
        d0.e0.p.d.m0.g.a aVar = d0.e0.p.d.m0.g.a.topLevel(k.a.v);
        d0.z.d.m.checkNotNullExpressionValue(aVar, "topLevel(StandardNames.FqNames.deprecationLevel)");
        d0.e0.p.d.m0.g.e eVarIdentifier = d0.e0.p.d.m0.g.e.identifier(str3);
        d0.z.d.m.checkNotNullExpressionValue(eVarIdentifier, "identifier(level)");
        return new j(hVar, bVar, h0.mapOf(d0.o.to(a, new w(str)), d0.o.to(f3250b, new d0.e0.p.d.m0.k.v.a(jVar)), d0.o.to(eVar, new d0.e0.p.d.m0.k.v.j(aVar, eVarIdentifier))));
    }

    public static /* synthetic */ c createDeprecatedAnnotation$default(d0.e0.p.d.m0.b.h hVar, String str, String str2, String str3, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = "";
        }
        if ((i & 4) != 0) {
            str3 = "WARNING";
        }
        return createDeprecatedAnnotation(hVar, str, str2, str3);
    }
}

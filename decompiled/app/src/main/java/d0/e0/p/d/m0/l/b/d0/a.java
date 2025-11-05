package d0.e0.p.d.m0.l.b.d0;

import com.discord.widgets.chat.input.MentionUtilsKt;
import d0.e0.p.d.m0.f.b;
import d0.e0.p.d.m0.f.i;
import d0.e0.p.d.m0.f.l;
import d0.e0.p.d.m0.f.n;
import d0.e0.p.d.m0.f.q;
import d0.e0.p.d.m0.f.s;
import d0.e0.p.d.m0.f.u;
import d0.e0.p.d.m0.i.e;
import d0.e0.p.d.m0.i.g;
import d0.g0.t;
import d0.z.d.m;
import java.util.List;

/* compiled from: BuiltInSerializerProtocol.kt */
/* loaded from: classes3.dex */
public final class a extends d0.e0.p.d.m0.l.a {
    public static final a m = new a();

    /* JADX WARN: Illegal instructions before constructor call */
    public a() {
        e eVarNewInstance = e.newInstance();
        d0.e0.p.d.m0.f.y.b.registerAllExtensions(eVarNewInstance);
        m.checkNotNullExpressionValue(eVarNewInstance, "newInstance().apply(BuiltInsProtoBuf::registerAllExtensions)");
        g.f<l, Integer> fVar = d0.e0.p.d.m0.f.y.b.a;
        m.checkNotNullExpressionValue(fVar, "packageFqName");
        g.f<d0.e0.p.d.m0.f.d, List<d0.e0.p.d.m0.f.b>> fVar2 = d0.e0.p.d.m0.f.y.b.c;
        m.checkNotNullExpressionValue(fVar2, "constructorAnnotation");
        g.f<d0.e0.p.d.m0.f.c, List<d0.e0.p.d.m0.f.b>> fVar3 = d0.e0.p.d.m0.f.y.b.f3410b;
        m.checkNotNullExpressionValue(fVar3, "classAnnotation");
        g.f<i, List<d0.e0.p.d.m0.f.b>> fVar4 = d0.e0.p.d.m0.f.y.b.d;
        m.checkNotNullExpressionValue(fVar4, "functionAnnotation");
        g.f<n, List<d0.e0.p.d.m0.f.b>> fVar5 = d0.e0.p.d.m0.f.y.b.e;
        m.checkNotNullExpressionValue(fVar5, "propertyAnnotation");
        g.f<n, List<d0.e0.p.d.m0.f.b>> fVar6 = d0.e0.p.d.m0.f.y.b.f;
        m.checkNotNullExpressionValue(fVar6, "propertyGetterAnnotation");
        g.f<n, List<d0.e0.p.d.m0.f.b>> fVar7 = d0.e0.p.d.m0.f.y.b.g;
        m.checkNotNullExpressionValue(fVar7, "propertySetterAnnotation");
        g.f<d0.e0.p.d.m0.f.g, List<d0.e0.p.d.m0.f.b>> fVar8 = d0.e0.p.d.m0.f.y.b.i;
        m.checkNotNullExpressionValue(fVar8, "enumEntryAnnotation");
        g.f<n, b.C0546b.c> fVar9 = d0.e0.p.d.m0.f.y.b.h;
        m.checkNotNullExpressionValue(fVar9, "compileTimeValue");
        g.f<u, List<d0.e0.p.d.m0.f.b>> fVar10 = d0.e0.p.d.m0.f.y.b.j;
        m.checkNotNullExpressionValue(fVar10, "parameterAnnotation");
        g.f<q, List<d0.e0.p.d.m0.f.b>> fVar11 = d0.e0.p.d.m0.f.y.b.k;
        m.checkNotNullExpressionValue(fVar11, "typeAnnotation");
        g.f<s, List<d0.e0.p.d.m0.f.b>> fVar12 = d0.e0.p.d.m0.f.y.b.l;
        m.checkNotNullExpressionValue(fVar12, "typeParameterAnnotation");
        super(eVarNewInstance, fVar, fVar2, fVar3, fVar4, fVar5, fVar6, fVar7, fVar8, fVar9, fVar10, fVar11, fVar12);
    }

    public final String getBuiltInsFileName(d0.e0.p.d.m0.g.b bVar) {
        String strAsString;
        m.checkNotNullParameter(bVar, "fqName");
        if (bVar.isRoot()) {
            strAsString = "default-package";
        } else {
            strAsString = bVar.shortName().asString();
            m.checkNotNullExpressionValue(strAsString, "fqName.shortName().asString()");
        }
        return m.stringPlus(strAsString, ".kotlin_builtins");
    }

    public final String getBuiltInsFilePath(d0.e0.p.d.m0.g.b bVar) {
        m.checkNotNullParameter(bVar, "fqName");
        StringBuilder sb = new StringBuilder();
        String strAsString = bVar.asString();
        m.checkNotNullExpressionValue(strAsString, "fqName.asString()");
        sb.append(t.replace$default(strAsString, '.', MentionUtilsKt.SLASH_CHAR, false, 4, (Object) null));
        sb.append(MentionUtilsKt.SLASH_CHAR);
        sb.append(getBuiltInsFileName(bVar));
        return sb.toString();
    }
}

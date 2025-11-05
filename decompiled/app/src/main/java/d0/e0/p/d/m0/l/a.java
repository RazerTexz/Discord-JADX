package d0.e0.p.d.m0.l;

import d0.e0.p.d.m0.f.b;
import d0.e0.p.d.m0.f.c;
import d0.e0.p.d.m0.f.d;
import d0.e0.p.d.m0.f.i;
import d0.e0.p.d.m0.f.l;
import d0.e0.p.d.m0.f.n;
import d0.e0.p.d.m0.f.q;
import d0.e0.p.d.m0.f.s;
import d0.e0.p.d.m0.f.u;
import d0.e0.p.d.m0.i.e;
import d0.e0.p.d.m0.i.g;
import d0.z.d.m;
import java.util.List;

/* compiled from: SerializerExtensionProtocol.kt */
/* loaded from: classes3.dex */
public class a {
    public final e a;

    /* renamed from: b, reason: collision with root package name */
    public final g.f<d, List<b>> f3480b;
    public final g.f<c, List<b>> c;
    public final g.f<i, List<b>> d;
    public final g.f<n, List<b>> e;
    public final g.f<n, List<b>> f;
    public final g.f<n, List<b>> g;
    public final g.f<d0.e0.p.d.m0.f.g, List<b>> h;
    public final g.f<n, b.C0546b.c> i;
    public final g.f<u, List<b>> j;
    public final g.f<q, List<b>> k;
    public final g.f<s, List<b>> l;

    public a(e eVar, g.f<l, Integer> fVar, g.f<d, List<b>> fVar2, g.f<c, List<b>> fVar3, g.f<i, List<b>> fVar4, g.f<n, List<b>> fVar5, g.f<n, List<b>> fVar6, g.f<n, List<b>> fVar7, g.f<d0.e0.p.d.m0.f.g, List<b>> fVar8, g.f<n, b.C0546b.c> fVar9, g.f<u, List<b>> fVar10, g.f<q, List<b>> fVar11, g.f<s, List<b>> fVar12) {
        m.checkNotNullParameter(eVar, "extensionRegistry");
        m.checkNotNullParameter(fVar, "packageFqName");
        m.checkNotNullParameter(fVar2, "constructorAnnotation");
        m.checkNotNullParameter(fVar3, "classAnnotation");
        m.checkNotNullParameter(fVar4, "functionAnnotation");
        m.checkNotNullParameter(fVar5, "propertyAnnotation");
        m.checkNotNullParameter(fVar6, "propertyGetterAnnotation");
        m.checkNotNullParameter(fVar7, "propertySetterAnnotation");
        m.checkNotNullParameter(fVar8, "enumEntryAnnotation");
        m.checkNotNullParameter(fVar9, "compileTimeValue");
        m.checkNotNullParameter(fVar10, "parameterAnnotation");
        m.checkNotNullParameter(fVar11, "typeAnnotation");
        m.checkNotNullParameter(fVar12, "typeParameterAnnotation");
        this.a = eVar;
        this.f3480b = fVar2;
        this.c = fVar3;
        this.d = fVar4;
        this.e = fVar5;
        this.f = fVar6;
        this.g = fVar7;
        this.h = fVar8;
        this.i = fVar9;
        this.j = fVar10;
        this.k = fVar11;
        this.l = fVar12;
    }

    public final g.f<c, List<b>> getClassAnnotation() {
        return this.c;
    }

    public final g.f<n, b.C0546b.c> getCompileTimeValue() {
        return this.i;
    }

    public final g.f<d, List<b>> getConstructorAnnotation() {
        return this.f3480b;
    }

    public final g.f<d0.e0.p.d.m0.f.g, List<b>> getEnumEntryAnnotation() {
        return this.h;
    }

    public final e getExtensionRegistry() {
        return this.a;
    }

    public final g.f<i, List<b>> getFunctionAnnotation() {
        return this.d;
    }

    public final g.f<u, List<b>> getParameterAnnotation() {
        return this.j;
    }

    public final g.f<n, List<b>> getPropertyAnnotation() {
        return this.e;
    }

    public final g.f<n, List<b>> getPropertyGetterAnnotation() {
        return this.f;
    }

    public final g.f<n, List<b>> getPropertySetterAnnotation() {
        return this.g;
    }

    public final g.f<q, List<b>> getTypeAnnotation() {
        return this.k;
    }

    public final g.f<s, List<b>> getTypeParameterAnnotation() {
        return this.l;
    }
}

package b.a.t.a;

import com.discord.simpleast.core.node.StyleNode;

/* compiled from: CodeStyleProviders.kt */
/* loaded from: classes.dex */
public final class f<R> {
    public final StyleNode.a<R> a;

    /* renamed from: b, reason: collision with root package name */
    public final StyleNode.a<R> f291b;
    public final StyleNode.a<R> c;
    public final StyleNode.a<R> d;
    public final StyleNode.a<R> e;
    public final StyleNode.a<R> f;
    public final StyleNode.a<R> g;
    public final StyleNode.a<R> h;

    public f(StyleNode.a<R> aVar, StyleNode.a<R> aVar2, StyleNode.a<R> aVar3, StyleNode.a<R> aVar4, StyleNode.a<R> aVar5, StyleNode.a<R> aVar6, StyleNode.a<R> aVar7, StyleNode.a<R> aVar8) {
        d0.z.d.m.checkNotNullParameter(aVar, "defaultStyleProvider");
        d0.z.d.m.checkNotNullParameter(aVar2, "commentStyleProvider");
        d0.z.d.m.checkNotNullParameter(aVar3, "literalStyleProvider");
        d0.z.d.m.checkNotNullParameter(aVar4, "keywordStyleProvider");
        d0.z.d.m.checkNotNullParameter(aVar5, "identifierStyleProvider");
        d0.z.d.m.checkNotNullParameter(aVar6, "typesStyleProvider");
        d0.z.d.m.checkNotNullParameter(aVar7, "genericsStyleProvider");
        d0.z.d.m.checkNotNullParameter(aVar8, "paramsStyleProvider");
        this.a = aVar;
        this.f291b = aVar2;
        this.c = aVar3;
        this.d = aVar4;
        this.e = aVar5;
        this.f = aVar6;
        this.g = aVar7;
        this.h = aVar8;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof f)) {
            return false;
        }
        f fVar = (f) obj;
        return d0.z.d.m.areEqual(this.a, fVar.a) && d0.z.d.m.areEqual(this.f291b, fVar.f291b) && d0.z.d.m.areEqual(this.c, fVar.c) && d0.z.d.m.areEqual(this.d, fVar.d) && d0.z.d.m.areEqual(this.e, fVar.e) && d0.z.d.m.areEqual(this.f, fVar.f) && d0.z.d.m.areEqual(this.g, fVar.g) && d0.z.d.m.areEqual(this.h, fVar.h);
    }

    public int hashCode() {
        StyleNode.a<R> aVar = this.a;
        int iHashCode = (aVar != null ? aVar.hashCode() : 0) * 31;
        StyleNode.a<R> aVar2 = this.f291b;
        int iHashCode2 = (iHashCode + (aVar2 != null ? aVar2.hashCode() : 0)) * 31;
        StyleNode.a<R> aVar3 = this.c;
        int iHashCode3 = (iHashCode2 + (aVar3 != null ? aVar3.hashCode() : 0)) * 31;
        StyleNode.a<R> aVar4 = this.d;
        int iHashCode4 = (iHashCode3 + (aVar4 != null ? aVar4.hashCode() : 0)) * 31;
        StyleNode.a<R> aVar5 = this.e;
        int iHashCode5 = (iHashCode4 + (aVar5 != null ? aVar5.hashCode() : 0)) * 31;
        StyleNode.a<R> aVar6 = this.f;
        int iHashCode6 = (iHashCode5 + (aVar6 != null ? aVar6.hashCode() : 0)) * 31;
        StyleNode.a<R> aVar7 = this.g;
        int iHashCode7 = (iHashCode6 + (aVar7 != null ? aVar7.hashCode() : 0)) * 31;
        StyleNode.a<R> aVar8 = this.h;
        return iHashCode7 + (aVar8 != null ? aVar8.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = b.d.b.a.a.U("CodeStyleProviders(defaultStyleProvider=");
        sbU.append(this.a);
        sbU.append(", commentStyleProvider=");
        sbU.append(this.f291b);
        sbU.append(", literalStyleProvider=");
        sbU.append(this.c);
        sbU.append(", keywordStyleProvider=");
        sbU.append(this.d);
        sbU.append(", identifierStyleProvider=");
        sbU.append(this.e);
        sbU.append(", typesStyleProvider=");
        sbU.append(this.f);
        sbU.append(", genericsStyleProvider=");
        sbU.append(this.g);
        sbU.append(", paramsStyleProvider=");
        sbU.append(this.h);
        sbU.append(")");
        return sbU.toString();
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public f() {
        g gVar = g.a;
        this(gVar, gVar, gVar, gVar, gVar, gVar, gVar, gVar);
    }
}

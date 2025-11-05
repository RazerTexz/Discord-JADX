package b.i.a.c.x2.k0;

import b.i.a.c.j1;
import b.i.a.c.x2.k0.i0;
import java.util.List;

/* compiled from: SeiReader.java */
/* loaded from: classes3.dex */
public final class e0 {
    public final List<j1> a;

    /* renamed from: b, reason: collision with root package name */
    public final b.i.a.c.x2.w[] f1246b;

    public e0(List<j1> list) {
        this.a = list;
        this.f1246b = new b.i.a.c.x2.w[list.size()];
    }

    public void a(b.i.a.c.x2.j jVar, i0.d dVar) {
        for (int i = 0; i < this.f1246b.length; i++) {
            dVar.a();
            b.i.a.c.x2.w wVarP = jVar.p(dVar.c(), 3);
            j1 j1Var = this.a.get(i);
            String str = j1Var.w;
            boolean z2 = "application/cea-608".equals(str) || "application/cea-708".equals(str);
            String strValueOf = String.valueOf(str);
            b.c.a.a0.d.m(z2, strValueOf.length() != 0 ? "Invalid closed caption mime type provided: ".concat(strValueOf) : new String("Invalid closed caption mime type provided: "));
            String strB = j1Var.l;
            if (strB == null) {
                strB = dVar.b();
            }
            j1.b bVar = new j1.b();
            bVar.a = strB;
            bVar.k = str;
            bVar.d = j1Var.o;
            bVar.c = j1Var.n;
            bVar.C = j1Var.O;
            bVar.m = j1Var.f1019y;
            wVarP.e(bVar.a());
            this.f1246b[i] = wVarP;
        }
    }
}

package b.i.a.c.a3;

import android.util.Pair;
import b.i.a.c.a3.a0;
import b.i.a.c.a3.v;
import b.i.a.c.o2;
import java.util.Objects;

/* compiled from: lambda */
/* loaded from: classes3.dex */
public final /* synthetic */ class a implements a0.b {
    public final /* synthetic */ o a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f806b;

    public /* synthetic */ a(o oVar, Object obj) {
        this.a = oVar;
        this.f806b = obj;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:37:? A[RETURN, SYNTHETIC] */
    @Override // b.i.a.c.a3.a0.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void a(a0 a0Var, o2 o2Var) {
        v.a aVar;
        a0.a aVarB;
        v.a aVar2;
        o oVar = this.a;
        Object obj = this.f806b;
        Objects.requireNonNull(oVar);
        v vVar = (v) oVar;
        if (vVar.q) {
            v.a aVar3 = vVar.n;
            vVar.n = new v.a(o2Var, aVar3.m, aVar3.n);
            u uVar = vVar.o;
            if (uVar != null) {
                vVar.v(uVar.p);
            }
        } else {
            if (!o2Var.q()) {
                o2Var.n(0, vVar.l);
                o2.c cVar = vVar.l;
                long j = cVar.f1045z;
                Object obj2 = cVar.n;
                u uVar2 = vVar.o;
                if (uVar2 != null) {
                    long j2 = uVar2.k;
                    vVar.n.h(uVar2.j.a, vVar.m);
                    long j3 = vVar.m.n + j2;
                    long j4 = j3 != vVar.n.n(0, vVar.l).f1045z ? j3 : j;
                    Pair<Object, Long> pairJ = o2Var.j(vVar.l, vVar.m, 0, j4);
                    Object obj3 = pairJ.first;
                    long jLongValue = ((Long) pairJ.second).longValue();
                    if (vVar.r) {
                        v.a aVar4 = vVar.n;
                        aVar = new v.a(o2Var, aVar4.m, aVar4.n);
                    } else {
                        aVar = new v.a(o2Var, obj2, obj3);
                    }
                    vVar.n = aVar;
                    u uVar3 = vVar.o;
                    if (uVar3 != null) {
                        vVar.v(jLongValue);
                        a0.a aVar5 = uVar3.j;
                        Object obj4 = aVar5.a;
                        if (vVar.n.n != null && obj4.equals(v.a.l)) {
                            obj4 = vVar.n.n;
                        }
                        aVarB = aVar5.b(obj4);
                    }
                }
                vVar.r = true;
                vVar.q = true;
                vVar.r(vVar.n);
                if (aVarB == null) {
                    u uVar4 = vVar.o;
                    Objects.requireNonNull(uVar4);
                    uVar4.d(aVarB);
                    return;
                }
                return;
            }
            if (vVar.r) {
                v.a aVar6 = vVar.n;
                aVar2 = new v.a(o2Var, aVar6.m, aVar6.n);
            } else {
                aVar2 = new v.a(o2Var, o2.c.j, v.a.l);
            }
            vVar.n = aVar2;
        }
        aVarB = null;
        vVar.r = true;
        vVar.q = true;
        vVar.r(vVar.n);
        if (aVarB == null) {
        }
    }
}

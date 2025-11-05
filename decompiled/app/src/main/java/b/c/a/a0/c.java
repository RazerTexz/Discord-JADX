package b.c.a.a0;

import android.graphics.PointF;
import b.c.a.a0.i0.c;
import java.io.IOException;

/* compiled from: AnimatableTransformParser.java */
/* loaded from: classes.dex */
public class c {
    public static c.a a = c.a.a("a", "p", "s", "rz", "r", "o", "so", "eo", "sk", "sa");

    /* renamed from: b, reason: collision with root package name */
    public static c.a f328b = c.a.a("k");

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:113:0x0219  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x021c  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x01c5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static b.c.a.y.k.l a(b.c.a.a0.i0.c cVar, b.c.a.d dVar) throws IOException {
        b.c.a.y.k.b bVar;
        b.c.a.y.k.g gVar;
        boolean z2;
        b.c.a.y.k.b bVar2;
        b.c.a.y.k.g gVar2;
        b.c.a.y.k.b bVar3;
        b.c.a.y.k.m<PointF, PointF> mVar;
        b.c.a.y.k.b bVarR1;
        b.c.a.y.k.b bVar4;
        boolean z3 = false;
        boolean z4 = cVar.u() == c.b.BEGIN_OBJECT;
        if (z4) {
            cVar.b();
        }
        b.c.a.y.k.b bVar5 = null;
        b.c.a.y.k.g gVar3 = null;
        b.c.a.y.k.m<PointF, PointF> mVarB = null;
        b.c.a.y.k.b bVarR12 = null;
        b.c.a.y.k.b bVarR13 = null;
        b.c.a.y.k.e eVarA = null;
        b.c.a.y.k.d dVarS1 = null;
        b.c.a.y.k.b bVarR14 = null;
        b.c.a.y.k.b bVarR15 = null;
        while (cVar.e()) {
            switch (cVar.y(a)) {
                case 0:
                    gVar2 = gVar3;
                    bVar3 = bVarR12;
                    mVar = mVarB;
                    cVar.b();
                    while (cVar.e()) {
                        if (cVar.y(f328b) != 0) {
                            cVar.A();
                            cVar.C();
                        } else {
                            eVarA = a.a(cVar, dVar);
                        }
                    }
                    cVar.d();
                    gVar3 = gVar2;
                    mVarB = mVar;
                    bVarR12 = bVar3;
                    z3 = false;
                    break;
                case 1:
                    bVar3 = bVarR12;
                    mVarB = a.b(cVar, dVar);
                    bVarR12 = bVar3;
                    z3 = false;
                    break;
                case 2:
                    bVar3 = bVarR12;
                    mVar = mVarB;
                    gVar3 = new b.c.a.y.k.g(d.o1(cVar, dVar, a0.a));
                    mVarB = mVar;
                    bVarR12 = bVar3;
                    z3 = false;
                    break;
                case 3:
                    dVar.a("Lottie doesn't support 3D layers.");
                    bVarR1 = d.r1(cVar, dVar, z3);
                    if (bVarR1.a.isEmpty()) {
                        bVar4 = bVarR1;
                        gVar2 = gVar3;
                        bVar3 = bVarR12;
                        mVar = mVarB;
                        if (((b.c.a.c0.a) bVar4.a.get(0)).f347b == 0) {
                            bVar4.a.set(0, new b.c.a.c0.a(dVar, Float.valueOf(0.0f), Float.valueOf(0.0f), null, 0.0f, Float.valueOf(dVar.l)));
                        }
                    } else {
                        bVar4 = bVarR1;
                        gVar2 = gVar3;
                        bVar3 = bVarR12;
                        mVar = mVarB;
                        bVarR1.a.add(new b.c.a.c0.a(dVar, Float.valueOf(0.0f), Float.valueOf(0.0f), null, 0.0f, Float.valueOf(dVar.l)));
                    }
                    bVar5 = bVar4;
                    gVar3 = gVar2;
                    mVarB = mVar;
                    bVarR12 = bVar3;
                    z3 = false;
                    break;
                case 4:
                    bVarR1 = d.r1(cVar, dVar, z3);
                    if (bVarR1.a.isEmpty()) {
                    }
                    bVar5 = bVar4;
                    gVar3 = gVar2;
                    mVarB = mVar;
                    bVarR12 = bVar3;
                    z3 = false;
                    break;
                case 5:
                    dVarS1 = d.s1(cVar, dVar);
                    break;
                case 6:
                    bVarR14 = d.r1(cVar, dVar, z3);
                    break;
                case 7:
                    bVarR15 = d.r1(cVar, dVar, z3);
                    break;
                case 8:
                    bVarR13 = d.r1(cVar, dVar, z3);
                    break;
                case 9:
                    bVarR12 = d.r1(cVar, dVar, z3);
                    break;
                default:
                    bVar3 = bVarR12;
                    cVar.A();
                    cVar.C();
                    bVarR12 = bVar3;
                    z3 = false;
                    break;
            }
        }
        b.c.a.y.k.g gVar4 = gVar3;
        b.c.a.y.k.b bVar6 = bVarR12;
        b.c.a.y.k.m<PointF, PointF> mVar2 = mVarB;
        if (z4) {
            cVar.d();
        }
        if (eVarA == null || (eVarA.isStatic() && eVarA.a.get(0).f347b.equals(0.0f, 0.0f))) {
            eVarA = null;
        }
        if (mVar2 == null || (!(mVar2 instanceof b.c.a.y.k.i) && mVar2.isStatic() && mVar2.b().get(0).f347b.equals(0.0f, 0.0f))) {
            mVar2 = null;
        }
        if (bVar5 == null || (bVar5.isStatic() && ((Float) ((b.c.a.c0.a) bVar5.a.get(0)).f347b).floatValue() == 0.0f)) {
            gVar = gVar4;
            bVar = null;
        } else {
            bVar = bVar5;
            gVar = gVar4;
        }
        if (gVar == null) {
            z2 = true;
        } else {
            if (gVar.isStatic()) {
                b.c.a.c0.d dVar2 = (b.c.a.c0.d) ((b.c.a.c0.a) gVar.a.get(0)).f347b;
                if (dVar2.a == 1.0f && dVar2.f350b == 1.0f) {
                }
            }
            z2 = false;
        }
        b.c.a.y.k.g gVar5 = z2 ? null : gVar;
        if (bVarR13 == null || (bVarR13.isStatic() && ((Float) ((b.c.a.c0.a) bVarR13.a.get(0)).f347b).floatValue() == 0.0f)) {
            bVarR13 = null;
        }
        if (bVar6 != null) {
            bVar2 = bVar6;
            boolean z5 = bVar6.isStatic() && ((Float) ((b.c.a.c0.a) bVar2.a.get(0)).f347b).floatValue() == 0.0f;
            return new b.c.a.y.k.l(eVarA, mVar2, gVar5, bVar, dVarS1, bVarR14, bVarR15, bVarR13, !z5 ? null : bVar2);
        }
        bVar2 = bVar6;
        return new b.c.a.y.k.l(eVarA, mVar2, gVar5, bVar, dVarS1, bVarR14, bVarR15, bVarR13, !z5 ? null : bVar2);
    }
}

package b.c.a.a0;

import android.graphics.Path;
import android.graphics.PointF;
import androidx.annotation.Nullable;
import b.c.a.a0.i0.c;
import b.c.a.y.l.g;
import b.c.a.y.l.h;
import java.io.IOException;
import java.util.ArrayList;

/* compiled from: ContentModelParser.java */
/* loaded from: classes.dex */
public class g {
    public static c.a a = c.a.a("ty", "d");

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:133:0x01fa  */
    /* JADX WARN: Removed duplicated region for block: B:388:0x069f A[LOOP:1: B:386:0x0699->B:388:0x069f, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00e3  */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static b.c.a.y.l.b a(b.c.a.a0.i0.c cVar, b.c.a.d dVar) throws IOException {
        String strT;
        String strT2;
        boolean zF;
        b.c.a.y.l.b aVar;
        b.c.a.y.l.b mVar;
        boolean zF2;
        String strT3;
        int iQ;
        String strT4;
        char c;
        cVar.b();
        int iQ2 = 2;
        while (true) {
            strT = null;
            aVar = null;
            strT4 = null;
            strT3 = null;
            if (!cVar.e()) {
                strT2 = null;
                break;
            }
            int iY = cVar.y(a);
            if (iY == 0) {
                strT2 = cVar.t();
                break;
            }
            if (iY != 1) {
                cVar.A();
                cVar.C();
            } else {
                iQ2 = cVar.q();
            }
        }
        if (strT2 == null) {
            return null;
        }
        zF = false;
        iQ = 0;
        zF2 = false;
        switch (strT2) {
            case "el":
                c.a aVar2 = e.a;
                boolean z2 = iQ2 == 3;
                String strT5 = null;
                b.c.a.y.k.m<PointF, PointF> mVarB = null;
                b.c.a.y.k.f fVarU1 = null;
                boolean zF3 = false;
                while (cVar.e()) {
                    int iY2 = cVar.y(e.a);
                    if (iY2 == 0) {
                        strT5 = cVar.t();
                    } else if (iY2 == 1) {
                        mVarB = a.b(cVar, dVar);
                    } else if (iY2 == 2) {
                        fVarU1 = d.u1(cVar, dVar);
                    } else if (iY2 == 3) {
                        zF3 = cVar.f();
                    } else if (iY2 != 4) {
                        cVar.A();
                        cVar.C();
                    } else {
                        z2 = cVar.q() == 3;
                    }
                }
                aVar = new b.c.a.y.l.a(strT5, mVarB, fVarU1, z2, zF3);
                while (cVar.e()) {
                    cVar.C();
                }
                cVar.d();
                return aVar;
            case "fl":
                c.a aVar3 = c0.a;
                int iQ3 = 1;
                String strT6 = null;
                b.c.a.y.k.a aVarP1 = null;
                b.c.a.y.k.d dVarS1 = null;
                boolean zF4 = false;
                boolean zF5 = false;
                while (cVar.e()) {
                    int iY3 = cVar.y(c0.a);
                    if (iY3 == 0) {
                        strT6 = cVar.t();
                    } else if (iY3 == 1) {
                        aVarP1 = d.p1(cVar, dVar);
                    } else if (iY3 == 2) {
                        dVarS1 = d.s1(cVar, dVar);
                    } else if (iY3 == 3) {
                        zF4 = cVar.f();
                    } else if (iY3 == 4) {
                        iQ3 = cVar.q();
                    } else if (iY3 != 5) {
                        cVar.A();
                        cVar.C();
                    } else {
                        zF5 = cVar.f();
                    }
                }
                aVar = new b.c.a.y.l.l(strT6, zF4, iQ3 == 1 ? Path.FillType.WINDING : Path.FillType.EVEN_ODD, aVarP1, dVarS1, zF5);
                while (cVar.e()) {
                }
                cVar.d();
                return aVar;
            case "gf":
                c.a aVar4 = m.a;
                Path.FillType fillType = Path.FillType.WINDING;
                String strT7 = null;
                b.c.a.y.k.c cVar2 = null;
                b.c.a.y.k.d dVarS12 = null;
                b.c.a.y.k.f fVarU12 = null;
                b.c.a.y.k.f fVarU13 = null;
                int i = 0;
                boolean zF6 = false;
                while (cVar.e()) {
                    switch (cVar.y(m.a)) {
                        case 0:
                            strT7 = cVar.t();
                            break;
                        case 1:
                            cVar.b();
                            int iQ4 = -1;
                            while (cVar.e()) {
                                int iY4 = cVar.y(m.f339b);
                                if (iY4 == 0) {
                                    iQ4 = cVar.q();
                                } else if (iY4 != 1) {
                                    cVar.A();
                                    cVar.C();
                                } else {
                                    cVar2 = new b.c.a.y.k.c(d.o1(cVar, dVar, new l(iQ4)));
                                }
                            }
                            cVar.d();
                            break;
                        case 2:
                            dVarS12 = d.s1(cVar, dVar);
                            break;
                        case 3:
                            if (cVar.q() != 1) {
                                i = 2;
                                break;
                            } else {
                                i = 1;
                                break;
                            }
                            break;
                        case 4:
                            fVarU12 = d.u1(cVar, dVar);
                            break;
                        case 5:
                            fVarU13 = d.u1(cVar, dVar);
                            break;
                        case 6:
                            fillType = cVar.q() == 1 ? Path.FillType.WINDING : Path.FillType.EVEN_ODD;
                            break;
                        case 7:
                            zF6 = cVar.f();
                            break;
                        default:
                            cVar.A();
                            cVar.C();
                            break;
                    }
                }
                aVar = new b.c.a.y.l.d(strT7, i, fillType, cVar2, dVarS12, fVarU12, fVarU13, null, null, zF6);
                while (cVar.e()) {
                }
                cVar.d();
                return aVar;
            case "gr":
                c.a aVar5 = d0.a;
                ArrayList arrayList = new ArrayList();
                while (cVar.e()) {
                    int iY5 = cVar.y(d0.a);
                    if (iY5 == 0) {
                        strT = cVar.t();
                    } else if (iY5 == 1) {
                        zF = cVar.f();
                    } else if (iY5 != 2) {
                        cVar.C();
                    } else {
                        cVar.a();
                        while (cVar.e()) {
                            b.c.a.y.l.b bVarA = a(cVar, dVar);
                            if (bVarA != null) {
                                arrayList.add(bVarA);
                            }
                        }
                        cVar.c();
                    }
                }
                mVar = new b.c.a.y.l.m(strT, arrayList, zF);
                aVar = mVar;
                while (cVar.e()) {
                }
                cVar.d();
                return aVar;
            case "gs":
                c.a aVar6 = n.a;
                ArrayList arrayList2 = new ArrayList();
                String strT8 = null;
                b.c.a.y.k.c cVar3 = null;
                b.c.a.y.k.d dVarS13 = null;
                b.c.a.y.k.f fVarU14 = null;
                b.c.a.y.k.f fVarU15 = null;
                b.c.a.y.k.b bVarQ1 = null;
                b.c.a.y.k.b bVar = null;
                int i2 = 0;
                int i3 = 0;
                int i4 = 0;
                float fN = 0.0f;
                boolean zF7 = false;
                while (cVar.e()) {
                    switch (cVar.y(n.a)) {
                        case 0:
                            strT8 = cVar.t();
                            break;
                        case 1:
                            cVar.b();
                            int iQ5 = -1;
                            while (cVar.e()) {
                                int iY6 = cVar.y(n.f340b);
                                if (iY6 == 0) {
                                    iQ5 = cVar.q();
                                } else if (iY6 != 1) {
                                    cVar.A();
                                    cVar.C();
                                } else {
                                    cVar3 = new b.c.a.y.k.c(d.o1(cVar, dVar, new l(iQ5)));
                                }
                            }
                            cVar.d();
                            break;
                        case 2:
                            dVarS13 = d.s1(cVar, dVar);
                            break;
                        case 3:
                            if (cVar.q() != 1) {
                                i2 = 2;
                                break;
                            } else {
                                i2 = 1;
                                break;
                            }
                            break;
                        case 4:
                            fVarU14 = d.u1(cVar, dVar);
                            break;
                        case 5:
                            fVarU15 = d.u1(cVar, dVar);
                            break;
                        case 6:
                            bVarQ1 = d.q1(cVar, dVar);
                            break;
                        case 7:
                            i3 = b.c.a.y.b.com$airbnb$lottie$model$content$ShapeStroke$LineCapType$s$values()[cVar.q() - 1];
                            break;
                        case 8:
                            i4 = b.c.a.y.b.com$airbnb$lottie$model$content$ShapeStroke$LineJoinType$s$values()[cVar.q() - 1];
                            break;
                        case 9:
                            fN = (float) cVar.n();
                            break;
                        case 10:
                            zF7 = cVar.f();
                            break;
                        case 11:
                            cVar.a();
                            while (cVar.e()) {
                                cVar.b();
                                b.c.a.y.k.b bVarQ12 = null;
                                String strT9 = null;
                                while (cVar.e()) {
                                    int iY7 = cVar.y(n.c);
                                    if (iY7 == 0) {
                                        strT9 = cVar.t();
                                    } else if (iY7 != 1) {
                                        cVar.A();
                                        cVar.C();
                                    } else {
                                        bVarQ12 = d.q1(cVar, dVar);
                                    }
                                }
                                cVar.d();
                                if (strT9.equals("o")) {
                                    bVar = bVarQ12;
                                } else if (strT9.equals("d") || strT9.equals("g")) {
                                    dVar.n = true;
                                    arrayList2.add(bVarQ12);
                                }
                            }
                            cVar.c();
                            if (arrayList2.size() != 1) {
                                break;
                            } else {
                                arrayList2.add(arrayList2.get(0));
                                break;
                            }
                            break;
                        default:
                            cVar.A();
                            cVar.C();
                            break;
                    }
                }
                aVar = new b.c.a.y.l.e(strT8, i2, cVar3, dVarS13, fVarU14, fVarU15, bVarQ1, i3, i4, fN, arrayList2, bVar, zF7);
                while (cVar.e()) {
                }
                cVar.d();
                return aVar;
            case "mm":
                c.a aVar7 = u.a;
                g.a aVar8 = null;
                while (cVar.e()) {
                    int iY8 = cVar.y(u.a);
                    if (iY8 == 0) {
                        strT3 = cVar.t();
                    } else if (iY8 == 1) {
                        int iQ6 = cVar.q();
                        g.a aVar9 = g.a.MERGE;
                        if (iQ6 != 1) {
                            if (iQ6 == 2) {
                                aVar8 = g.a.ADD;
                            } else if (iQ6 == 3) {
                                aVar8 = g.a.SUBTRACT;
                            } else if (iQ6 == 4) {
                                aVar8 = g.a.INTERSECT;
                            } else if (iQ6 == 5) {
                                aVar8 = g.a.EXCLUDE_INTERSECTIONS;
                            }
                        }
                        aVar8 = aVar9;
                    } else if (iY8 != 2) {
                        cVar.A();
                        cVar.C();
                    } else {
                        zF2 = cVar.f();
                    }
                }
                b.c.a.y.l.g gVar = new b.c.a.y.l.g(strT3, aVar8, zF2);
                dVar.a("Animation contains merge paths. Merge paths are only supported on KitKat+ and must be manually enabled by calling enableMergePathsForKitKatAndAbove().");
                aVar = gVar;
                while (cVar.e()) {
                }
                cVar.d();
                return aVar;
            case "rc":
                c.a aVar10 = y.a;
                String strT10 = null;
                b.c.a.y.k.m<PointF, PointF> mVarB2 = null;
                b.c.a.y.k.f fVarU16 = null;
                b.c.a.y.k.b bVarQ13 = null;
                boolean zF8 = false;
                while (cVar.e()) {
                    int iY9 = cVar.y(y.a);
                    if (iY9 == 0) {
                        strT10 = cVar.t();
                    } else if (iY9 == 1) {
                        mVarB2 = a.b(cVar, dVar);
                    } else if (iY9 == 2) {
                        fVarU16 = d.u1(cVar, dVar);
                    } else if (iY9 == 3) {
                        bVarQ13 = d.q1(cVar, dVar);
                    } else if (iY9 != 4) {
                        cVar.C();
                    } else {
                        zF8 = cVar.f();
                    }
                }
                aVar = new b.c.a.y.l.i(strT10, mVarB2, fVarU16, bVarQ13, zF8);
                while (cVar.e()) {
                }
                cVar.d();
                return aVar;
            case "rp":
                c.a aVar11 = z.a;
                String strT11 = null;
                b.c.a.y.k.b bVarR1 = null;
                b.c.a.y.k.b bVarR12 = null;
                b.c.a.y.k.l lVarA = null;
                boolean zF9 = false;
                while (cVar.e()) {
                    int iY10 = cVar.y(z.a);
                    if (iY10 == 0) {
                        strT11 = cVar.t();
                    } else if (iY10 == 1) {
                        bVarR1 = d.r1(cVar, dVar, false);
                    } else if (iY10 == 2) {
                        bVarR12 = d.r1(cVar, dVar, false);
                    } else if (iY10 == 3) {
                        lVarA = c.a(cVar, dVar);
                    } else if (iY10 != 4) {
                        cVar.C();
                    } else {
                        zF9 = cVar.f();
                    }
                }
                aVar = new b.c.a.y.l.j(strT11, bVarR1, bVarR12, lVarA, zF9);
                while (cVar.e()) {
                }
                cVar.d();
                return aVar;
            case "sh":
                c.a aVar12 = e0.a;
                boolean zF10 = false;
                b.c.a.y.k.h hVar = null;
                while (cVar.e()) {
                    int iY11 = cVar.y(e0.a);
                    if (iY11 == 0) {
                        strT4 = cVar.t();
                    } else if (iY11 == 1) {
                        iQ = cVar.q();
                    } else if (iY11 == 2) {
                        hVar = new b.c.a.y.k.h(r.a(cVar, dVar, b.c.a.b0.g.c(), b0.a));
                    } else if (iY11 != 3) {
                        cVar.C();
                    } else {
                        zF10 = cVar.f();
                    }
                }
                mVar = new b.c.a.y.l.n(strT4, iQ, hVar, zF10);
                aVar = mVar;
                while (cVar.e()) {
                }
                cVar.d();
                return aVar;
            case "sr":
                c.a aVar13 = x.a;
                String strT12 = null;
                h.a aVarF = null;
                b.c.a.y.k.b bVarR13 = null;
                b.c.a.y.k.m<PointF, PointF> mVarB3 = null;
                b.c.a.y.k.b bVarR14 = null;
                b.c.a.y.k.b bVarQ14 = null;
                b.c.a.y.k.b bVarQ15 = null;
                b.c.a.y.k.b bVarR15 = null;
                b.c.a.y.k.b bVarR16 = null;
                boolean zF11 = false;
                while (cVar.e()) {
                    switch (cVar.y(x.a)) {
                        case 0:
                            strT12 = cVar.t();
                            break;
                        case 1:
                            aVarF = h.a.f(cVar.q());
                            break;
                        case 2:
                            bVarR13 = d.r1(cVar, dVar, false);
                            break;
                        case 3:
                            mVarB3 = a.b(cVar, dVar);
                            break;
                        case 4:
                            bVarR14 = d.r1(cVar, dVar, false);
                            break;
                        case 5:
                            bVarQ15 = d.q1(cVar, dVar);
                            break;
                        case 6:
                            bVarR16 = d.r1(cVar, dVar, false);
                            break;
                        case 7:
                            bVarQ14 = d.q1(cVar, dVar);
                            break;
                        case 8:
                            bVarR15 = d.r1(cVar, dVar, false);
                            break;
                        case 9:
                            zF11 = cVar.f();
                            break;
                        default:
                            cVar.A();
                            cVar.C();
                            break;
                    }
                }
                mVar = new b.c.a.y.l.h(strT12, aVarF, bVarR13, mVarB3, bVarR14, bVarQ14, bVarQ15, bVarR15, bVarR16, zF11);
                aVar = mVar;
                while (cVar.e()) {
                }
                cVar.d();
                return aVar;
            case "st":
                c.a aVar14 = f0.a;
                ArrayList arrayList3 = new ArrayList();
                String strT13 = null;
                b.c.a.y.k.b bVar2 = null;
                b.c.a.y.k.a aVarP12 = null;
                b.c.a.y.k.d dVarS14 = null;
                b.c.a.y.k.b bVarQ16 = null;
                int i5 = 0;
                int i6 = 0;
                float fN2 = 0.0f;
                boolean zF12 = false;
                while (cVar.e()) {
                    switch (cVar.y(f0.a)) {
                        case 0:
                            strT13 = cVar.t();
                            break;
                        case 1:
                            aVarP12 = d.p1(cVar, dVar);
                            break;
                        case 2:
                            bVarQ16 = d.q1(cVar, dVar);
                            break;
                        case 3:
                            dVarS14 = d.s1(cVar, dVar);
                            break;
                        case 4:
                            i5 = b.c.a.y.b.com$airbnb$lottie$model$content$ShapeStroke$LineCapType$s$values()[cVar.q() - 1];
                            break;
                        case 5:
                            i6 = b.c.a.y.b.com$airbnb$lottie$model$content$ShapeStroke$LineJoinType$s$values()[cVar.q() - 1];
                            break;
                        case 6:
                            fN2 = (float) cVar.n();
                            break;
                        case 7:
                            zF12 = cVar.f();
                            break;
                        case 8:
                            cVar.a();
                            while (cVar.e()) {
                                cVar.b();
                                b.c.a.y.k.b bVarQ17 = null;
                                String strT14 = null;
                                while (cVar.e()) {
                                    int iY12 = cVar.y(f0.f331b);
                                    if (iY12 == 0) {
                                        strT14 = cVar.t();
                                    } else if (iY12 != 1) {
                                        cVar.A();
                                        cVar.C();
                                    } else {
                                        bVarQ17 = d.q1(cVar, dVar);
                                    }
                                }
                                cVar.d();
                                strT14.hashCode();
                                int iHashCode = strT14.hashCode();
                                if (iHashCode != 100) {
                                    if (iHashCode != 103) {
                                        c = (iHashCode == 111 && strT14.equals("o")) ? (char) 2 : (char) 65535;
                                    } else if (strT14.equals("g")) {
                                        c = 1;
                                    }
                                } else if (strT14.equals("d")) {
                                    c = 0;
                                }
                                if (c == 0 || c == 1) {
                                    dVar.n = true;
                                    arrayList3.add(bVarQ17);
                                } else if (c == 2) {
                                    bVar2 = bVarQ17;
                                }
                            }
                            cVar.c();
                            if (arrayList3.size() != 1) {
                                break;
                            } else {
                                arrayList3.add(arrayList3.get(0));
                                break;
                            }
                            break;
                        default:
                            cVar.C();
                            break;
                    }
                }
                aVar = new b.c.a.y.l.o(strT13, bVar2, arrayList3, aVarP12, dVarS14, bVarQ16, i5, i6, fN2, zF12);
                while (cVar.e()) {
                }
                cVar.d();
                return aVar;
            case "tm":
                c.a aVar15 = g0.a;
                String strT15 = null;
                b.c.a.y.k.b bVarR17 = null;
                b.c.a.y.k.b bVarR18 = null;
                b.c.a.y.k.b bVarR19 = null;
                int i7 = 0;
                boolean zF13 = false;
                while (cVar.e()) {
                    int iY13 = cVar.y(g0.a);
                    if (iY13 == 0) {
                        bVarR17 = d.r1(cVar, dVar, false);
                    } else if (iY13 == 1) {
                        bVarR18 = d.r1(cVar, dVar, false);
                    } else if (iY13 == 2) {
                        bVarR19 = d.r1(cVar, dVar, false);
                    } else if (iY13 == 3) {
                        strT15 = cVar.t();
                    } else if (iY13 == 4) {
                        int iQ7 = cVar.q();
                        if (iQ7 == 1) {
                            i7 = 1;
                        } else {
                            if (iQ7 != 2) {
                                throw new IllegalArgumentException(b.d.b.a.a.q("Unknown trim path type ", iQ7));
                            }
                            i7 = 2;
                        }
                    } else if (iY13 != 5) {
                        cVar.C();
                    } else {
                        zF13 = cVar.f();
                    }
                }
                aVar = new b.c.a.y.l.p(strT15, i7, bVarR17, bVarR18, bVarR19, zF13);
                while (cVar.e()) {
                }
                cVar.d();
                return aVar;
            case "tr":
                aVar = c.a(cVar, dVar);
                while (cVar.e()) {
                }
                cVar.d();
                return aVar;
            default:
                b.c.a.b0.c.b("Unknown shape type " + strT2);
                while (cVar.e()) {
                }
                cVar.d();
                return aVar;
        }
    }
}

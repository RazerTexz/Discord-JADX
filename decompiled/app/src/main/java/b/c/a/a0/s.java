package b.c.a.a0;

import android.graphics.Color;
import b.c.a.a0.i0.c;
import b.c.a.y.m.e;
import java.io.IOException;
import java.util.ArrayList;

/* compiled from: LayerParser.java */
/* loaded from: classes.dex */
public class s {
    public static final c.a a = c.a.a("nm", "ind", "refId", "ty", "parent", "sw", "sh", "sc", "ks", "tt", "masksProperties", "shapes", "t", "ef", "sr", "st", "w", "h", "ip", "op", "tm", "cl", "hd");

    /* renamed from: b, reason: collision with root package name */
    public static final c.a f342b = c.a.a("d", "a");
    public static final c.a c = c.a.a("nm");

    /* JADX WARN: Failed to find 'out' block for switch in B:6:0x0055. Please report as an issue. */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:113:0x0254  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x02af  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x02b4  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x02e4  */
    /* JADX WARN: Type inference failed for: r6v11 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static b.c.a.y.m.e a(b.c.a.a0.i0.c cVar, b.c.a.d dVar) throws IOException {
        ArrayList arrayList;
        ArrayList arrayList2;
        String str;
        String str2;
        long j;
        char c2;
        char c3;
        String str3;
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        cVar.b();
        Float fValueOf = Float.valueOf(1.0f);
        Float fValueOf2 = Float.valueOf(0.0f);
        int i = 1;
        boolean z2 = false;
        long jQ = -1;
        float fN = 0.0f;
        String strT = null;
        e.a aVar = null;
        String strT2 = null;
        b.c.a.y.k.l lVarA = null;
        int iC = 0;
        int iC2 = 0;
        int color = 0;
        float fN2 = 1.0f;
        float fN3 = 0.0f;
        int iC3 = 0;
        int iC4 = 0;
        b.c.a.y.k.j jVar = null;
        b.c.a.y.k.k kVar = null;
        int i2 = 1;
        b.c.a.y.k.b bVarR1 = null;
        boolean zF = false;
        long jQ2 = 0;
        String strT3 = "UNSET";
        float fN4 = 0.0f;
        while (cVar.e()) {
            switch (cVar.y(a)) {
                case 0:
                    str2 = strT;
                    strT3 = cVar.t();
                    strT = str2;
                    break;
                case 1:
                    str2 = strT;
                    jQ2 = cVar.q();
                    strT = str2;
                    break;
                case 2:
                    str2 = strT;
                    strT2 = cVar.t();
                    strT = str2;
                    break;
                case 3:
                    str2 = strT;
                    j = jQ2;
                    int iQ = cVar.q();
                    aVar = iQ < 6 ? e.a.values()[iQ] : e.a.UNKNOWN;
                    jQ2 = j;
                    strT = str2;
                    break;
                case 4:
                    str2 = strT;
                    j = jQ2;
                    jQ = cVar.q();
                    jQ2 = j;
                    strT = str2;
                    break;
                case 5:
                    str2 = strT;
                    iC = (int) (b.c.a.b0.g.c() * cVar.q());
                    strT = str2;
                    break;
                case 6:
                    str2 = strT;
                    iC2 = (int) (b.c.a.b0.g.c() * cVar.q());
                    strT = str2;
                    break;
                case 7:
                    str2 = strT;
                    color = Color.parseColor(cVar.t());
                    strT = str2;
                    break;
                case 8:
                    str2 = strT;
                    lVarA = c.a(cVar, dVar);
                    strT = str2;
                    break;
                case 9:
                    str2 = strT;
                    j = jQ2;
                    i2 = b.c.a.y.b.com$airbnb$lottie$model$layer$Layer$MatteType$s$values()[cVar.q()];
                    dVar.o++;
                    jQ2 = j;
                    strT = str2;
                    break;
                case 10:
                    str2 = strT;
                    b.c.a.y.k.h hVar = null;
                    cVar.a();
                    while (cVar.e()) {
                        cVar.b();
                        b.c.a.y.k.h hVar2 = hVar;
                        b.c.a.y.k.d dVarS1 = hVar2;
                        int i3 = 0;
                        boolean zF2 = false;
                        while (cVar.e()) {
                            String strS = cVar.s();
                            strS.hashCode();
                            long j2 = jQ2;
                            int iHashCode = strS.hashCode();
                            if (iHashCode != 111) {
                                if (iHashCode != 3588) {
                                    if (iHashCode != 104433) {
                                        c2 = (iHashCode == 3357091 && strS.equals("mode")) ? (char) 3 : (char) 65535;
                                    } else if (strS.equals("inv")) {
                                        c2 = 2;
                                    }
                                } else if (strS.equals("pt")) {
                                    c2 = 1;
                                }
                            } else if (strS.equals("o")) {
                                c2 = 0;
                            }
                            if (c2 == 0) {
                                dVarS1 = d.s1(cVar, dVar);
                            } else if (c2 == 1) {
                                hVar2 = new b.c.a.y.k.h(r.a(cVar, dVar, b.c.a.b0.g.c(), b0.a));
                            } else if (c2 == 2) {
                                zF2 = cVar.f();
                            } else if (c2 != 3) {
                                cVar.C();
                            } else {
                                String strT4 = cVar.t();
                                strT4.hashCode();
                                int iHashCode2 = strT4.hashCode();
                                if (iHashCode2 == 97) {
                                    if (strT4.equals("a")) {
                                        c3 = 0;
                                    }
                                    if (c3 != 0) {
                                    }
                                    i3 = 1;
                                } else if (iHashCode2 == 105) {
                                    if (strT4.equals("i")) {
                                        c3 = 1;
                                    }
                                    if (c3 != 0) {
                                    }
                                    i3 = 1;
                                } else if (iHashCode2 != 110) {
                                    c3 = (iHashCode2 == 115 && strT4.equals("s")) ? (char) 3 : (char) 65535;
                                    if (c3 != 0) {
                                        if (c3 == 1) {
                                            dVar.a("Animation contains intersect masks. They are not supported but will be treated like add masks.");
                                            i3 = 3;
                                        } else if (c3 == 2) {
                                            i3 = 4;
                                        } else if (c3 != 3) {
                                            b.c.a.b0.c.b("Unknown mask mode " + strS + ". Defaulting to Add.");
                                        } else {
                                            i3 = 2;
                                        }
                                    }
                                    i3 = 1;
                                } else {
                                    if (strT4.equals("n")) {
                                        c3 = 2;
                                    }
                                    if (c3 != 0) {
                                    }
                                    i3 = 1;
                                }
                            }
                            jQ2 = j2;
                            dVarS1 = dVarS1;
                        }
                        cVar.d();
                        arrayList3.add(new b.c.a.y.l.f(i3, hVar2, dVarS1, zF2));
                        jQ2 = jQ2;
                        hVar = null;
                    }
                    j = jQ2;
                    dVar.o += arrayList3.size();
                    cVar.c();
                    jQ2 = j;
                    strT = str2;
                    break;
                case 11:
                    str2 = strT;
                    cVar.a();
                    while (cVar.e()) {
                        b.c.a.y.l.b bVarA = g.a(cVar, dVar);
                        if (bVarA != null) {
                            arrayList4.add(bVarA);
                        }
                    }
                    cVar.c();
                    j = jQ2;
                    jQ2 = j;
                    strT = str2;
                    break;
                case 12:
                    cVar.b();
                    while (cVar.e()) {
                        int iY = cVar.y(f342b);
                        if (iY == 0) {
                            str3 = strT;
                            jVar = new b.c.a.y.k.j(d.o1(cVar, dVar, h.a));
                        } else if (iY != i) {
                            cVar.A();
                            cVar.C();
                        } else {
                            cVar.a();
                            if (cVar.e()) {
                                c.a aVar2 = b.a;
                                cVar.b();
                                b.c.a.y.k.k kVar2 = null;
                                while (cVar.e()) {
                                    if (cVar.y(b.a) != 0) {
                                        cVar.A();
                                        cVar.C();
                                    } else {
                                        cVar.b();
                                        b.c.a.y.k.b bVarQ1 = null;
                                        b.c.a.y.k.b bVarQ12 = null;
                                        b.c.a.y.k.a aVarP1 = null;
                                        b.c.a.y.k.a aVarP12 = null;
                                        while (cVar.e()) {
                                            int iY2 = cVar.y(b.f326b);
                                            if (iY2 == 0) {
                                                aVarP1 = d.p1(cVar, dVar);
                                            } else if (iY2 == i) {
                                                aVarP12 = d.p1(cVar, dVar);
                                            } else if (iY2 == 2) {
                                                bVarQ1 = d.q1(cVar, dVar);
                                            } else if (iY2 != 3) {
                                                cVar.A();
                                                cVar.C();
                                            } else {
                                                bVarQ12 = d.q1(cVar, dVar);
                                            }
                                            i = 1;
                                        }
                                        cVar.d();
                                        kVar2 = new b.c.a.y.k.k(aVarP1, aVarP12, bVarQ1, bVarQ12);
                                        strT = strT;
                                        i = 1;
                                    }
                                }
                                str3 = strT;
                                cVar.d();
                                kVar = kVar2 == null ? new b.c.a.y.k.k(null, null, null, null) : kVar2;
                            } else {
                                str3 = strT;
                            }
                            while (cVar.e()) {
                                cVar.C();
                            }
                            cVar.c();
                        }
                        strT = str3;
                        i = 1;
                    }
                    str2 = strT;
                    cVar.d();
                    strT = str2;
                    break;
                case 13:
                    cVar.a();
                    ArrayList arrayList5 = new ArrayList();
                    while (cVar.e()) {
                        cVar.b();
                        while (cVar.e()) {
                            if (cVar.y(c) != 0) {
                                cVar.A();
                                cVar.C();
                            } else {
                                arrayList5.add(cVar.t());
                            }
                        }
                        cVar.d();
                    }
                    cVar.c();
                    dVar.a("Lottie doesn't support layer effects. If you are using them for  fills, strokes, trim paths etc. then try adding them directly as contents  in your shape. Found: " + arrayList5);
                    str2 = strT;
                    j = jQ2;
                    jQ2 = j;
                    strT = str2;
                    break;
                case 14:
                    fN2 = (float) cVar.n();
                    str2 = strT;
                    strT = str2;
                    break;
                case 15:
                    fN3 = (float) cVar.n();
                    str2 = strT;
                    strT = str2;
                    break;
                case 16:
                    iC3 = (int) (b.c.a.b0.g.c() * cVar.q());
                    str2 = strT;
                    strT = str2;
                    break;
                case 17:
                    iC4 = (int) (b.c.a.b0.g.c() * cVar.q());
                    str2 = strT;
                    strT = str2;
                    break;
                case 18:
                    fN = (float) cVar.n();
                    str2 = strT;
                    strT = str2;
                    break;
                case 19:
                    fN4 = (float) cVar.n();
                    break;
                case 20:
                    bVarR1 = d.r1(cVar, dVar, z2);
                    break;
                case 21:
                    strT = cVar.t();
                    break;
                case 22:
                    zF = cVar.f();
                    break;
                default:
                    str2 = strT;
                    j = jQ2;
                    cVar.A();
                    cVar.C();
                    jQ2 = j;
                    strT = str2;
                    break;
            }
            i = 1;
            z2 = false;
        }
        String str4 = strT;
        long j3 = jQ2;
        cVar.d();
        float f = fN / fN2;
        float f2 = fN4 / fN2;
        ArrayList arrayList6 = new ArrayList();
        if (f > 0.0f) {
            arrayList = arrayList4;
            arrayList2 = arrayList3;
            str = str4;
            arrayList6.add(new b.c.a.c0.a(dVar, fValueOf2, fValueOf2, null, 0.0f, Float.valueOf(f)));
        } else {
            arrayList = arrayList4;
            arrayList2 = arrayList3;
            str = str4;
        }
        if (f2 <= 0.0f) {
            f2 = dVar.l;
        }
        arrayList6.add(new b.c.a.c0.a(dVar, fValueOf, fValueOf, null, f, Float.valueOf(f2)));
        arrayList6.add(new b.c.a.c0.a(dVar, fValueOf2, fValueOf2, null, f2, Float.valueOf(Float.MAX_VALUE)));
        if (strT3.endsWith(".ai") || "ai".equals(str)) {
            dVar.a("Convert your Illustrator layers to shape layers.");
        }
        return new b.c.a.y.m.e(arrayList, dVar, strT3, j3, aVar, jQ, strT2, arrayList2, lVarA, iC, iC2, color, fN2, fN3, iC3, iC4, jVar, kVar, arrayList6, i2, bVarR1, zF);
    }
}

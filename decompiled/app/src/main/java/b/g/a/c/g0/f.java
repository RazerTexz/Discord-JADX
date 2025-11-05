package b.g.a.c.g0;

import b.g.a.a.c0;
import b.g.a.a.i;
import b.g.a.a.l0;
import b.g.a.a.n;
import b.g.a.a.p;
import b.g.a.a.q;
import b.g.a.c.b;
import b.g.a.c.c0.a0;
import b.g.a.c.c0.b0;
import b.g.a.c.d;
import b.g.a.c.g0.u.d0;
import b.g.a.c.g0.u.f0;
import b.g.a.c.g0.u.i0;
import b.g.a.c.g0.u.j0;
import b.g.a.c.g0.u.s0;
import b.g.a.c.g0.u.t0;
import b.g.a.c.i0.e;
import b.g.a.c.t;
import b.g.a.c.v;
import b.g.a.c.w;
import b.g.a.c.x;
import com.fasterxml.jackson.databind.JsonMappingException;
import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.RandomAccess;
import java.util.Set;
import java.util.TimeZone;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: BeanSerializerFactory.java */
/* loaded from: classes3.dex */
public class f extends b implements Serializable {
    public static final f l = new f(null);
    private static final long serialVersionUID = 1;

    public f(b.g.a.c.z.o oVar) {
        super(null);
    }

    @Override // b.g.a.c.g0.q
    public b.g.a.c.n<Object> b(x xVar, b.g.a.c.j jVar) throws JsonMappingException {
        b.g.a.c.j jVarE0;
        Object objH;
        v vVar = xVar._config;
        b.g.a.c.c cVarU = vVar.u(jVar);
        b.g.a.c.n<?> nVarF = f(xVar, ((b.g.a.c.c0.q) cVarU).f);
        if (nVarF != null) {
            return nVarF;
        }
        b.g.a.c.b bVarE = vVar.e();
        boolean z2 = false;
        b.g.a.c.i0.e eVar = null;
        if (bVarE == null) {
            jVarE0 = jVar;
        } else {
            try {
                jVarE0 = bVarE.e0(vVar, ((b.g.a.c.c0.q) cVarU).f, jVar);
            } catch (JsonMappingException e) {
                xVar.F(cVarU, e.getMessage(), new Object[0]);
                throw null;
            }
        }
        if (jVarE0 != jVar) {
            if (!jVarE0.t(jVar._class)) {
                cVarU = vVar.u(jVarE0);
            }
            z2 = true;
        }
        b.g.a.c.c0.q qVar = (b.g.a.c.c0.q) cVarU;
        b.g.a.c.b bVar = qVar.e;
        if (bVar != null && (objH = bVar.H(qVar.f)) != null) {
            if (objH instanceof b.g.a.c.i0.e) {
                eVar = (b.g.a.c.i0.e) objH;
            } else {
                if (!(objH instanceof Class)) {
                    StringBuilder sbU = b.d.b.a.a.U("AnnotationIntrospector returned Converter definition of type ");
                    sbU.append(objH.getClass().getName());
                    sbU.append("; expected type Converter or Class<Converter> instead");
                    throw new IllegalStateException(sbU.toString());
                }
                Class cls = (Class) objH;
                if (cls != e.a.class && !b.g.a.c.i0.d.p(cls)) {
                    if (!b.g.a.c.i0.e.class.isAssignableFrom(cls)) {
                        throw new IllegalStateException(b.d.b.a.a.o(cls, b.d.b.a.a.U("AnnotationIntrospector returned Class "), "; expected Class<Converter>"));
                    }
                    Objects.requireNonNull(qVar.d._base);
                    eVar = (b.g.a.c.i0.e) b.g.a.c.i0.d.g(cls, qVar.d.b());
                }
            }
        }
        if (eVar == null) {
            return i(xVar, jVarE0, cVarU, z2);
        }
        b.g.a.c.j jVarA = eVar.a(xVar.d());
        if (!jVarA.t(jVarE0._class)) {
            cVarU = vVar.u(jVarA);
            nVarF = f(xVar, ((b.g.a.c.c0.q) cVarU).f);
        }
        if (nVarF == null && !jVarA.y()) {
            nVarF = i(xVar, jVarA, cVarU, true);
        }
        return new j0(eVar, jVarA, nVarF);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:100:0x0218  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x0259  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x02a1  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x02b0  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x02b6  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x020f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public c h(x xVar, b.g.a.c.c0.s sVar, l lVar, boolean z2, b.g.a.c.c0.i iVar) throws JsonMappingException {
        b.g.a.c.e0.g gVarC;
        boolean z3;
        boolean z4;
        boolean zB;
        Object obj;
        Class<?>[] clsArrI;
        Object objQ;
        Object objT0;
        t tVarM = sVar.m();
        b.g.a.c.j jVarE = iVar.e();
        d.a aVar = new d.a(tVarM, jVarE, sVar.t(), iVar, sVar.o());
        b.g.a.c.n<Object> nVarF = f(xVar, iVar);
        if (nVarF instanceof o) {
            ((o) nVarF).b(xVar);
        }
        b.g.a.c.n<?> nVarY = xVar.y(nVarF, aVar);
        if (jVarE.v() || jVarE.b()) {
            v vVar = xVar._config;
            b.g.a.c.j jVarK = jVarE.k();
            b.g.a.c.e0.f<?> fVarU = vVar.e().u(vVar, iVar, jVarE);
            gVarC = fVarU == null ? c(vVar, jVarK) : fVarU.e(vVar, jVarK, vVar._subtypeResolver.a(vVar, iVar, jVarK));
        } else {
            gVarC = null;
        }
        v vVar2 = xVar._config;
        b.g.a.c.e0.f<?> fVarC = vVar2.e().C(vVar2, iVar, jVarE);
        b.g.a.c.e0.g gVarC2 = fVarC == null ? c(vVar2, jVarE) : fVarC.e(vVar2, jVarE, vVar2._subtypeResolver.a(vVar2, iVar, jVarE));
        Object obj2 = p.a.NON_EMPTY;
        try {
            b.g.a.c.j jVarA = lVar.a(iVar, z2, jVarE);
            if (gVarC != null) {
                if (jVarA == null) {
                    jVarA = jVarE;
                }
                if (jVarA.k() == null) {
                    xVar.E(lVar.f702b, sVar, "serialization type " + jVarA + " has no content", new Object[0]);
                    throw null;
                }
                b.g.a.c.j jVarE2 = jVarA.E(gVarC);
                jVarE2.k();
                jVarA = jVarE2;
            }
            b.g.a.c.j jVar = jVarA == null ? jVarE : jVarA;
            b.g.a.c.c0.i iVarJ = sVar.j();
            if (iVarJ == null) {
                xVar.E(lVar.f702b, sVar, "could not determine property type", new Object[0]);
                throw null;
            }
            Class<?> clsD = iVarJ.d();
            v vVar3 = lVar.a;
            Class<?> cls = jVar._class;
            p.b bVar = lVar.e;
            vVar3.f(cls);
            vVar3.f(clsD);
            p.b[] bVarArr = {bVar, null, null};
            p.b bVar2 = p.b.j;
            int i = 0;
            p.b bVar3 = null;
            for (int i2 = 3; i < i2; i2 = 3) {
                p.b bVarA = bVarArr[i];
                if (bVarA != null) {
                    if (bVar3 != null) {
                        bVarA = bVar3.a(bVarA);
                    }
                    bVar3 = bVarA;
                }
                i++;
            }
            p.b bVarA2 = bVar3.a(sVar.g());
            p.a aVar2 = bVarA2._valueInclusion;
            if (aVar2 == p.a.USE_DEFAULTS) {
                aVar2 = p.a.ALWAYS;
            }
            int iOrdinal = aVar2.ordinal();
            if (iOrdinal != 1) {
                if (iOrdinal != 2) {
                    if (iOrdinal != 3) {
                        if (iOrdinal == 4) {
                            if (lVar.f) {
                                Object objNewInstance = lVar.d;
                                if (objNewInstance == null) {
                                    b.g.a.c.c cVar = lVar.f702b;
                                    boolean zB2 = lVar.a.b();
                                    b.g.a.c.c0.q qVar = (b.g.a.c.c0.q) cVar;
                                    b.g.a.c.c0.e eVar = qVar.f.f().a;
                                    if (eVar == null) {
                                        objNewInstance = null;
                                    } else {
                                        if (zB2) {
                                            eVar.f(qVar.d.q(b.g.a.c.p.OVERRIDE_PUBLIC_ACCESS_MODIFIERS));
                                        }
                                        try {
                                            objNewInstance = eVar._constructor.newInstance(new Object[0]);
                                        } catch (Exception e) {
                                            e = e;
                                            while (e.getCause() != null) {
                                                e = e.getCause();
                                            }
                                            b.g.a.c.i0.d.w(e);
                                            b.g.a.c.i0.d.x(e);
                                            StringBuilder sbU = b.d.b.a.a.U("Failed to instantiate bean of type ");
                                            sbU.append(qVar.f.l.getName());
                                            sbU.append(": (");
                                            sbU.append(e.getClass().getName());
                                            sbU.append(") ");
                                            sbU.append(b.g.a.c.i0.d.h(e));
                                            throw new IllegalArgumentException(sbU.toString(), e);
                                        }
                                    }
                                    if (objNewInstance == null) {
                                        objNewInstance = Boolean.FALSE;
                                    }
                                    lVar.d = objNewInstance;
                                }
                                Object obj3 = objNewInstance == Boolean.FALSE ? null : lVar.d;
                                if (obj3 != null) {
                                    if (xVar.C(b.g.a.c.p.CAN_OVERRIDE_ACCESS_MODIFIERS)) {
                                        iVar.f(lVar.a.q(b.g.a.c.p.OVERRIDE_PUBLIC_ACCESS_MODIFIERS));
                                    }
                                    try {
                                        objT0 = iVar.j(obj3);
                                        z3 = false;
                                    } catch (Exception e2) {
                                        e = e2;
                                        String strP = sVar.p();
                                        while (e.getCause() != null) {
                                            e = e.getCause();
                                        }
                                        b.g.a.c.i0.d.w(e);
                                        b.g.a.c.i0.d.x(e);
                                        StringBuilder sbY = b.d.b.a.a.Y("Failed to get property '", strP, "' of default ");
                                        sbY.append(obj3.getClass().getName());
                                        sbY.append(" instance");
                                        throw new IllegalArgumentException(sbY.toString());
                                    }
                                }
                                if (objT0 != null) {
                                }
                            } else {
                                objT0 = b.c.a.a0.d.t0(jVar);
                                z3 = true;
                                if (objT0 != null) {
                                    if (objT0.getClass().isArray()) {
                                        objT0 = b.c.a.a0.d.q0(objT0);
                                    }
                                    obj2 = objT0;
                                    zB = z3;
                                    obj = obj2;
                                }
                            }
                            clsArrI = sVar.i();
                            if (clsArrI == null) {
                            }
                            c cVar2 = new c(sVar, iVar, ((b.g.a.c.c0.q) lVar.f702b).f.t, jVarE, nVarY, gVarC2, jVarA, zB, obj, clsArrI);
                            objQ = lVar.c.q(iVar);
                            if (objQ != null) {
                            }
                            b.g.a.c.i0.n nVarQ = lVar.c.Q(iVar);
                            if (nVarQ == null) {
                            }
                        } else if (iOrdinal != 5) {
                            z3 = false;
                        } else {
                            objT0 = xVar.A(sVar, bVarA2._valueFilter);
                            if (objT0 != null) {
                                obj = objT0;
                                zB = xVar.B(objT0);
                                clsArrI = sVar.i();
                                if (clsArrI == null) {
                                    b.g.a.c.c0.q qVar2 = (b.g.a.c.c0.q) lVar.f702b;
                                    if (!qVar2.h) {
                                        qVar2.h = true;
                                        b.g.a.c.b bVar4 = qVar2.e;
                                        Class<?>[] clsArrR = bVar4 == null ? null : bVar4.R(qVar2.f);
                                        if (clsArrR == null && !qVar2.d.q(b.g.a.c.p.DEFAULT_VIEW_INCLUSION)) {
                                            clsArrR = b.g.a.c.c0.q.f693b;
                                        }
                                        qVar2.g = clsArrR;
                                    }
                                    clsArrI = qVar2.g;
                                }
                                c cVar22 = new c(sVar, iVar, ((b.g.a.c.c0.q) lVar.f702b).f.t, jVarE, nVarY, gVarC2, jVarA, zB, obj, clsArrI);
                                objQ = lVar.c.q(iVar);
                                if (objQ != null) {
                                    cVar22.e(xVar.H(iVar, objQ));
                                }
                                b.g.a.c.i0.n nVarQ2 = lVar.c.Q(iVar);
                                return nVarQ2 == null ? new b.g.a.c.g0.t.s(cVar22, nVarQ2) : cVar22;
                            }
                        }
                        obj2 = objT0;
                    } else {
                        int i3 = c.j;
                    }
                } else if (jVar.b()) {
                    int i4 = c.j;
                } else {
                    z4 = true;
                    zB = z4;
                    obj = null;
                    clsArrI = sVar.i();
                    if (clsArrI == null) {
                    }
                    c cVar222 = new c(sVar, iVar, ((b.g.a.c.c0.q) lVar.f702b).f.t, jVarE, nVarY, gVarC2, jVarA, zB, obj, clsArrI);
                    objQ = lVar.c.q(iVar);
                    if (objQ != null) {
                    }
                    b.g.a.c.i0.n nVarQ22 = lVar.c.Q(iVar);
                    if (nVarQ22 == null) {
                    }
                }
                obj = obj2;
                zB = true;
                clsArrI = sVar.i();
                if (clsArrI == null) {
                }
                c cVar2222 = new c(sVar, iVar, ((b.g.a.c.c0.q) lVar.f702b).f.t, jVarE, nVarY, gVarC2, jVarA, zB, obj, clsArrI);
                objQ = lVar.c.q(iVar);
                if (objQ != null) {
                }
                b.g.a.c.i0.n nVarQ222 = lVar.c.Q(iVar);
                if (nVarQ222 == null) {
                }
            } else {
                z3 = true;
            }
            w wVar = w.WRITE_EMPTY_JSON_ARRAYS;
            if (!jVar.v() || lVar.a.v(wVar)) {
                z4 = z3;
                zB = z4;
                obj = null;
                clsArrI = sVar.i();
                if (clsArrI == null) {
                }
                c cVar22222 = new c(sVar, iVar, ((b.g.a.c.c0.q) lVar.f702b).f.t, jVarE, nVarY, gVarC2, jVarA, zB, obj, clsArrI);
                objQ = lVar.c.q(iVar);
                if (objQ != null) {
                }
                b.g.a.c.i0.n nVarQ2222 = lVar.c.Q(iVar);
                if (nVarQ2222 == null) {
                }
            } else {
                int i5 = c.j;
                zB = z3;
                obj = obj2;
                clsArrI = sVar.i();
                if (clsArrI == null) {
                }
                c cVar222222 = new c(sVar, iVar, ((b.g.a.c.c0.q) lVar.f702b).f.t, jVarE, nVarY, gVarC2, jVarA, zB, obj, clsArrI);
                objQ = lVar.c.q(iVar);
                if (objQ != null) {
                }
                b.g.a.c.i0.n nVarQ22222 = lVar.c.Q(iVar);
                if (nVarQ22222 == null) {
                }
            }
        } catch (JsonMappingException e3) {
            xVar.E(lVar.f702b, sVar, b.g.a.c.i0.d.h(e3), new Object[0]);
            throw null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:167:0x02fc  */
    /* JADX WARN: Removed duplicated region for block: B:203:0x03c6  */
    /* JADX WARN: Removed duplicated region for block: B:262:0x04bf A[PHI: r4
      0x04bf: PHI (r4v14 int) = (r4v13 int), (r4v16 int) binds: [B:260:0x04ba, B:247:0x048b] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:349:0x0658  */
    /* JADX WARN: Removed duplicated region for block: B:353:0x065e  */
    /* JADX WARN: Removed duplicated region for block: B:356:0x0663  */
    /* JADX WARN: Removed duplicated region for block: B:408:0x0729  */
    /* JADX WARN: Removed duplicated region for block: B:429:0x078f  */
    /* JADX WARN: Removed duplicated region for block: B:431:0x0792  */
    /* JADX WARN: Removed duplicated region for block: B:432:0x0795  */
    /* JADX WARN: Removed duplicated region for block: B:479:0x0891  */
    /* JADX WARN: Removed duplicated region for block: B:604:0x0b18  */
    /* JADX WARN: Removed duplicated region for block: B:606:0x0b1b  */
    /* JADX WARN: Removed duplicated region for block: B:612:0x0b6e  */
    /* JADX WARN: Removed duplicated region for block: B:629:0x0ba5  */
    /* JADX WARN: Removed duplicated region for block: B:631:0x0bad  */
    /* JADX WARN: Removed duplicated region for block: B:676:0x0c71  */
    /* JADX WARN: Removed duplicated region for block: B:680:0x0c9d  */
    /* JADX WARN: Type inference failed for: r26v0, types: [b.g.a.c.g0.b, b.g.a.c.g0.f] */
    /* JADX WARN: Type inference failed for: r5v33, types: [b.g.a.c.g0.t.i] */
    /* JADX WARN: Type inference failed for: r5v34 */
    /* JADX WARN: Type inference failed for: r5v35 */
    /* JADX WARN: Type inference failed for: r5v8, types: [b.g.a.c.n] */
    /* JADX WARN: Type inference failed for: r5v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public b.g.a.c.n<?> i(x xVar, b.g.a.c.j jVar, b.g.a.c.c cVar, boolean z2) throws JsonMappingException {
        p.a aVar;
        p.a aVar2;
        i.c cVar2;
        Class<Enum> cls;
        b.g.a.c.c cVar3;
        int i;
        b.g.a.c.n<?> nVarE;
        b.g.a.c.n<?> nVarA;
        int i2;
        Object objT0;
        boolean zB;
        int i3;
        char c;
        int iOrdinal;
        Object objT02;
        boolean zB2;
        String str;
        String str2;
        String str3;
        b.g.a.c.g0.t.r rVar;
        boolean z3;
        ArrayList arrayList;
        boolean z4;
        ArrayList arrayList2;
        boolean zEquals;
        b.g.a.c.g0.t.j jVarA;
        b.g.a.c.c0.i first;
        boolean zQ;
        int size;
        int i4;
        List<c> list;
        b.g.a.c.n<?> nVarX;
        b.g.a.c.g0.u.m mVar;
        Class<? extends b.g.a.c.n<?>> cls2;
        boolean z5;
        boolean z6;
        b.g.a.c.e0.g gVar;
        b.g.a.c.n<Object> nVar;
        b.g.a.c.n<?> jVar2;
        i.c cVar4;
        v vVar;
        b.g.a.c.n<Object> nVar2;
        b.g.a.c.c0.q qVar;
        boolean z7;
        b.g.a.c.e0.g gVar2;
        Object objT03;
        boolean zB3;
        b.g.a.c.c cVar5 = cVar;
        boolean z8 = z2;
        Class<Enum> cls3 = Enum.class;
        i.c cVar6 = i.c.OBJECT;
        p.a aVar3 = p.a.ALWAYS;
        p.a aVar4 = p.a.USE_DEFAULTS;
        v vVar2 = xVar._config;
        if (jVar.v()) {
            boolean zG = !z8 ? g(vVar2, cVar5, null) : z8;
            v vVar3 = xVar._config;
            boolean z9 = (zG || !jVar._asStatic || (jVar.v() && jVar.k().y())) ? zG : true;
            b.g.a.c.e0.g gVarC = c(vVar3, jVar.k());
            boolean z10 = gVarC != null ? false : z9;
            b.g.a.c.c0.q qVar2 = (b.g.a.c.c0.q) cVar5;
            b.g.a.c.c0.c cVar7 = qVar2.f;
            Object objC = xVar.v().c(cVar7);
            b.g.a.c.n<Object> nVarH = objC != null ? xVar.H(cVar7, objC) : null;
            if (jVar.z()) {
                b.g.a.c.h0.f fVar = (b.g.a.c.h0.f) jVar;
                b.g.a.c.c0.c cVar8 = qVar2.f;
                Object objL = xVar.v().l(cVar8);
                b.g.a.c.n<Object> nVarH2 = objL != null ? xVar.H(cVar8, objL) : null;
                if (fVar instanceof b.g.a.c.h0.g) {
                    b.g.a.c.h0.g gVar3 = (b.g.a.c.h0.g) fVar;
                    if (cVar5.a(null).e() == cVar6) {
                        nVarE = null;
                        cVar4 = cVar6;
                    } else {
                        v vVar4 = xVar._config;
                        b.g.a.c.i0.b bVar = (b.g.a.c.i0.b) j();
                        b.g.a.c.n<?> nVarE2 = null;
                        while (true) {
                            if (!bVar.hasNext()) {
                                cVar4 = cVar6;
                                vVar = vVar4;
                                nVar2 = nVarH;
                                qVar = qVar2;
                                z7 = z10;
                                gVar2 = gVarC;
                                break;
                            }
                            vVar = vVar4;
                            nVar2 = nVarH;
                            cVar4 = cVar6;
                            qVar = qVar2;
                            z7 = z10;
                            gVar2 = gVarC;
                            nVarE2 = ((r) bVar.next()).c(vVar4, gVar3, cVar, nVarH2, gVarC, nVar2);
                            if (nVarE2 != null) {
                                break;
                            }
                            vVar4 = vVar;
                            qVar2 = qVar;
                            z10 = z7;
                            gVarC = gVar2;
                            nVarH = nVar2;
                            cVar6 = cVar4;
                        }
                        if (nVarE2 == null && (nVarE2 = e(xVar, gVar3, cVar5)) == null) {
                            Object objG = vVar.e().g(qVar.f);
                            v vVar5 = vVar;
                            n.a aVarS = vVar5.s(Map.class, qVar.f);
                            Set<String> setD = aVarS == null ? null : aVarS.d();
                            b.g.a.c.c0.c cVar9 = qVar.f;
                            b.g.a.c.b bVarE = vVar5.e();
                            q.a aVarA = bVarE == null ? null : bVarE.A(vVar5, cVar9);
                            b.g.a.c.g0.u.t tVarS = b.g.a.c.g0.u.t.s(setD, aVarA == null ? null : aVarA._included, gVar3, z7, gVar2, nVarH2, nVar2, objG);
                            b.g.a.c.j jVar3 = tVarS._valueType;
                            p.b bVarD = d(xVar, cVar5, jVar3, Map.class);
                            p.a aVar5 = bVarD == null ? aVar4 : bVarD._contentInclusion;
                            if (aVar5 == aVar4 || aVar5 == aVar3) {
                                nVarE = tVarS;
                                if (!xVar.D(w.WRITE_NULL_MAP_VALUES)) {
                                    nVarE = tVarS.v(null, true);
                                }
                            } else {
                                int iOrdinal2 = aVar5.ordinal();
                                if (iOrdinal2 != 2) {
                                    if (iOrdinal2 == 3) {
                                        objT03 = b.g.a.c.g0.u.t.l;
                                    } else if (iOrdinal2 == 4) {
                                        objT03 = b.c.a.a0.d.t0(jVar3);
                                        if (objT03 != null && objT03.getClass().isArray()) {
                                            objT03 = b.c.a.a0.d.q0(objT03);
                                        }
                                    } else if (iOrdinal2 != 5) {
                                        zB3 = true;
                                        objT03 = null;
                                    } else {
                                        objT03 = xVar.A(null, bVarD._contentFilter);
                                        if (objT03 != null) {
                                            zB3 = xVar.B(objT03);
                                        }
                                    }
                                    zB3 = true;
                                } else {
                                    if (jVar3.b()) {
                                        objT03 = b.g.a.c.g0.u.t.l;
                                        zB3 = true;
                                    }
                                    zB3 = true;
                                    objT03 = null;
                                }
                                nVarE = tVarS.v(objT03, zB3);
                            }
                        } else {
                            nVarE = nVarE2;
                        }
                        if (this._factoryConfig.a()) {
                            b.g.a.c.i0.b bVar2 = (b.g.a.c.i0.b) this._factoryConfig.b();
                            while (bVar2.hasNext()) {
                                Objects.requireNonNull((g) bVar2.next());
                            }
                        }
                    }
                } else {
                    cVar4 = cVar6;
                    b.g.a.c.n<?> nVarF = null;
                    b.g.a.c.i0.b bVar3 = (b.g.a.c.i0.b) j();
                    while (bVar3.hasNext()) {
                        b.g.a.c.h0.f fVar2 = fVar;
                        nVarF = ((r) bVar3.next()).f(vVar3, fVar, cVar, nVarH2, gVarC, nVarH);
                        if (nVarF != null) {
                            break;
                        }
                        fVar = fVar2;
                    }
                    nVarE = nVarF == null ? e(xVar, jVar, cVar) : nVarF;
                    if (nVarE != null && this._factoryConfig.a()) {
                        b.g.a.c.i0.b bVar4 = (b.g.a.c.i0.b) this._factoryConfig.b();
                        while (bVar4.hasNext()) {
                            Objects.requireNonNull((g) bVar4.next());
                        }
                    }
                }
                aVar = aVar4;
                aVar2 = aVar3;
                cls = cls3;
                cVar3 = cVar5;
                cVar2 = cVar4;
            } else {
                i.c cVar10 = cVar6;
                boolean z11 = z10;
                b.g.a.c.n<?> nVarE3 = null;
                if (jVar.u()) {
                    b.g.a.c.h0.d dVar = (b.g.a.c.h0.d) jVar;
                    if (dVar instanceof b.g.a.c.h0.e) {
                        b.g.a.c.h0.e eVar = (b.g.a.c.h0.e) dVar;
                        v vVar6 = xVar._config;
                        b.g.a.c.i0.b bVar5 = (b.g.a.c.i0.b) j();
                        while (true) {
                            if (!bVar5.hasNext()) {
                                aVar = aVar4;
                                aVar2 = aVar3;
                                cls = cls3;
                                cVar3 = cVar5;
                                cVar2 = cVar10;
                                break;
                            }
                            r rVar2 = (r) bVar5.next();
                            aVar = aVar4;
                            v vVar7 = vVar6;
                            aVar2 = aVar3;
                            cVar2 = cVar10;
                            v vVar8 = vVar6;
                            cls = cls3;
                            b.g.a.c.i0.b bVar6 = bVar5;
                            cVar3 = cVar5;
                            nVarE3 = rVar2.g(vVar7, eVar, cVar, gVarC, nVarH);
                            if (nVarE3 != null) {
                                break;
                            }
                            cls3 = cls;
                            cVar5 = cVar3;
                            aVar4 = aVar;
                            aVar3 = aVar2;
                            cVar10 = cVar2;
                            vVar6 = vVar8;
                            bVar5 = bVar6;
                        }
                        if (nVarE3 == null && (nVarE3 = e(xVar, eVar, cVar3)) == null) {
                            if (cVar3.a(null).e() != cVar2) {
                                Class<?> cls4 = eVar._class;
                                if (EnumSet.class.isAssignableFrom(cls4)) {
                                    b.g.a.c.j jVar4 = eVar._elementType;
                                    if (!(b.g.a.c.i0.d.q(jVar4._class) && jVar4._class != cls)) {
                                        jVar4 = null;
                                    }
                                    jVar2 = new b.g.a.c.g0.u.n(jVar4);
                                } else {
                                    Class<?> cls5 = eVar._elementType._class;
                                    if (!RandomAccess.class.isAssignableFrom(cls4)) {
                                        z6 = z11;
                                        gVar = gVarC;
                                        nVar = nVarH;
                                        if (cls5 == String.class && b.g.a.c.i0.d.s(nVar)) {
                                            nVarE3 = b.g.a.c.g0.t.o.k;
                                        }
                                    } else if (cls5 == String.class) {
                                        if (b.g.a.c.i0.d.s(nVarH)) {
                                            nVarE3 = b.g.a.c.g0.t.g.k;
                                        }
                                        z6 = z11;
                                        gVar = gVarC;
                                        nVar = nVarH;
                                    } else {
                                        z6 = z11;
                                        gVar = gVarC;
                                        nVar = nVarH;
                                        nVarE3 = new b.g.a.c.g0.t.f(eVar._elementType, z6, gVar, nVar);
                                    }
                                    if (nVarE3 == null) {
                                        jVar2 = new b.g.a.c.g0.u.j(eVar._elementType, z6, gVar, nVar);
                                    }
                                    nVarE = nVarE3;
                                    if (this._factoryConfig.a()) {
                                    }
                                }
                                nVarE = jVar2;
                                if (this._factoryConfig.a()) {
                                }
                            }
                            nVarE = null;
                        } else {
                            nVarE = nVarE3;
                            if (this._factoryConfig.a()) {
                                b.g.a.c.i0.b bVar7 = (b.g.a.c.i0.b) this._factoryConfig.b();
                                while (bVar7.hasNext()) {
                                    Objects.requireNonNull((g) bVar7.next());
                                }
                            }
                        }
                    } else {
                        aVar = aVar4;
                        aVar2 = aVar3;
                        cls = cls3;
                        cVar3 = cVar5;
                        b.g.a.c.e0.g gVar4 = gVarC;
                        b.g.a.c.n<Object> nVar3 = nVarH;
                        cVar2 = cVar10;
                        b.g.a.c.i0.b bVar8 = (b.g.a.c.i0.b) j();
                        b.g.a.c.n<?> nVarD = null;
                        while (bVar8.hasNext()) {
                            v vVar9 = vVar3;
                            b.g.a.c.n<Object> nVar4 = nVar3;
                            b.g.a.c.e0.g gVar5 = gVar4;
                            nVarD = ((r) bVar8.next()).d(vVar9, dVar, cVar, gVar4, nVar4);
                            if (nVarD != null) {
                                break;
                            }
                            vVar3 = vVar9;
                            gVar4 = gVar5;
                            nVar3 = nVar4;
                        }
                        nVarE = nVarD == null ? e(xVar, jVar, cVar) : nVarD;
                        if (nVarE != null && this._factoryConfig.a()) {
                            b.g.a.c.i0.b bVar9 = (b.g.a.c.i0.b) this._factoryConfig.b();
                            while (bVar9.hasNext()) {
                                Objects.requireNonNull((g) bVar9.next());
                            }
                        }
                    }
                } else {
                    aVar = aVar4;
                    aVar2 = aVar3;
                    cls = cls3;
                    cVar3 = cVar5;
                    boolean z12 = z11;
                    cVar2 = cVar10;
                    if (jVar instanceof b.g.a.c.h0.a) {
                        b.g.a.c.h0.a aVar6 = (b.g.a.c.h0.a) jVar;
                        v vVar10 = xVar._config;
                        b.g.a.c.i0.b bVar10 = (b.g.a.c.i0.b) j();
                        nVarE = null;
                        while (true) {
                            if (!bVar10.hasNext()) {
                                z5 = z12;
                                break;
                            }
                            v vVar11 = vVar10;
                            v vVar12 = vVar10;
                            z5 = z12;
                            nVarE = ((r) bVar10.next()).e(vVar11, aVar6, cVar, gVarC, nVarH);
                            if (nVarE != null) {
                                break;
                            }
                            z12 = z5;
                            vVar10 = vVar12;
                            nVarE = nVarE;
                        }
                        if (nVarE == null) {
                            Class<?> cls6 = aVar6._class;
                            if (nVarH != null) {
                                nVarE = nVarE;
                                if (b.g.a.c.i0.d.s(nVarH)) {
                                    nVarE = String[].class == cls6 ? b.g.a.c.g0.t.n.k : i0.a.get(cls6.getName());
                                }
                                if (nVarE == null) {
                                    nVarE = new d0(aVar6._componentType, z5, gVarC, nVarH);
                                }
                            }
                        }
                        if (this._factoryConfig.a()) {
                            b.g.a.c.i0.b bVar11 = (b.g.a.c.i0.b) this._factoryConfig.b();
                            while (bVar11.hasNext()) {
                                Objects.requireNonNull((g) bVar11.next());
                            }
                        }
                    } else {
                        nVarE = null;
                    }
                }
            }
            if (nVarE != null) {
                return nVarE;
            }
            i = 3;
            z8 = zG;
        } else {
            aVar = aVar4;
            aVar2 = aVar3;
            cVar2 = cVar6;
            cls = cls3;
            cVar3 = cVar5;
            if (jVar.b()) {
                b.g.a.c.h0.i iVar = (b.g.a.c.h0.i) jVar;
                b.g.a.c.j jVar5 = iVar._referencedType;
                b.g.a.c.e0.g gVarC2 = (b.g.a.c.e0.g) jVar5._typeHandler;
                v vVar13 = xVar._config;
                if (gVarC2 == null) {
                    gVarC2 = c(vVar13, jVar5);
                }
                b.g.a.c.e0.g gVar6 = gVarC2;
                b.g.a.c.n<Object> nVar5 = (b.g.a.c.n) jVar5._valueHandler;
                b.g.a.c.i0.b bVar12 = (b.g.a.c.i0.b) j();
                while (true) {
                    if (bVar12.hasNext()) {
                        b.g.a.c.n<Object> nVar6 = nVar5;
                        b.g.a.c.e0.g gVar7 = gVar6;
                        v vVar14 = vVar13;
                        nVarA = ((r) bVar12.next()).a(vVar13, iVar, cVar, gVar6, nVar6);
                        if (nVarA != null) {
                            break;
                        }
                        nVar5 = nVar6;
                        gVar6 = gVar7;
                        vVar13 = vVar14;
                    } else {
                        b.g.a.c.n<Object> nVar7 = nVar5;
                        b.g.a.c.e0.g gVar8 = gVar6;
                        if (iVar.B(AtomicReference.class)) {
                            b.g.a.c.j jVar6 = iVar._referencedType;
                            p.b bVarD2 = d(xVar, cVar3, jVar6, AtomicReference.class);
                            p.a aVar7 = bVarD2 == null ? aVar : bVarD2._contentInclusion;
                            if (aVar7 == aVar || aVar7 == aVar2) {
                                i2 = 3;
                                objT0 = null;
                                zB = false;
                            } else {
                                int iOrdinal3 = aVar7.ordinal();
                                if (iOrdinal3 != 2) {
                                    i2 = 3;
                                    if (iOrdinal3 == 3) {
                                        objT0 = b.g.a.c.g0.u.t.l;
                                    } else if (iOrdinal3 == 4) {
                                        objT0 = b.c.a.a0.d.t0(jVar6);
                                        if (objT0 != null && objT0.getClass().isArray()) {
                                            objT0 = b.c.a.a0.d.q0(objT0);
                                        }
                                    } else if (iOrdinal3 != 5) {
                                        objT0 = null;
                                    } else {
                                        objT0 = xVar.A(null, bVarD2._contentFilter);
                                        if (objT0 != null) {
                                            zB = xVar.B(objT0);
                                        }
                                    }
                                    zB = true;
                                } else {
                                    i2 = 3;
                                    if (jVar6.b()) {
                                        objT0 = b.g.a.c.g0.u.t.l;
                                    }
                                    zB = true;
                                }
                            }
                            f0<AtomicReference<?>> f0VarT = new b.g.a.c.g0.u.c(iVar, z8, gVar8, nVar7).t(objT0, zB);
                            i = i2;
                            nVarE = f0VarT;
                        } else {
                            nVarA = null;
                        }
                    }
                }
                i = 3;
                nVarE = nVarA;
            } else {
                i = 3;
                b.g.a.c.i0.b bVar13 = (b.g.a.c.i0.b) j();
                b.g.a.c.n<?> nVarB = null;
                while (bVar13.hasNext() && (nVarB = ((r) bVar13.next()).b(vVar2, jVar, cVar3)) == null) {
                }
                nVarE = nVarB;
            }
            if (nVarE == null) {
                nVarE = e(xVar, jVar, cVar);
            }
        }
        if (nVarE == null) {
            String name = jVar._class.getName();
            b.g.a.c.n<?> nVar8 = b.j.get(name);
            if (nVar8 != null || (cls2 = b.k.get(name)) == null) {
                nVarE = nVar8;
                i3 = 0;
            } else {
                i3 = 0;
                nVarE = (b.g.a.c.n) b.g.a.c.i0.d.g(cls2, false);
            }
            if (nVarE == null) {
                if (jVar.w()) {
                    v vVar15 = xVar._config;
                    i.d dVarA = cVar3.a(null);
                    if (dVarA.e() == cVar2) {
                        Iterator<b.g.a.c.c0.s> it = ((b.g.a.c.c0.q) cVar3).d().iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                break;
                            }
                            if (it.next().p().equals("declaringClass")) {
                                it.remove();
                                break;
                            }
                        }
                        mVar = null;
                    } else {
                        Class<?> cls7 = jVar._class;
                        int i5 = b.g.a.c.g0.u.m.k;
                        b.g.a.c.g0.u.m mVar2 = new b.g.a.c.g0.u.m(b.g.a.c.i0.f.a(vVar15, cls7), b.g.a.c.g0.u.m.p(cls7, dVarA, true, null));
                        if (this._factoryConfig.a()) {
                            b.g.a.c.i0.b bVar14 = (b.g.a.c.i0.b) this._factoryConfig.b();
                            while (bVar14.hasNext()) {
                                Objects.requireNonNull((g) bVar14.next());
                            }
                        }
                        mVar = mVar2;
                    }
                    c = 1;
                    nVarE = mVar;
                } else {
                    c = 1;
                    Class<?> cls8 = jVar._class;
                    ?? A = b.g.a.c.b0.f.l.a(xVar._config, jVar, cVar3);
                    if (A != 0) {
                        nVarE = A;
                    } else if (Calendar.class.isAssignableFrom(cls8)) {
                        nVarE = b.g.a.c.g0.u.h.k;
                    } else if (Date.class.isAssignableFrom(cls8)) {
                        nVarE = b.g.a.c.g0.u.k.k;
                    } else if (Map.Entry.class.isAssignableFrom(cls8)) {
                        b.g.a.c.j jVarI = jVar.i(Map.Entry.class);
                        b.g.a.c.j jVarH = jVarI.h(i3);
                        b.g.a.c.j jVarH2 = jVarI.h(1);
                        i.d dVarI = xVar._config.i(Map.Entry.class);
                        i.d dVarA2 = cVar3.a(null);
                        if (dVarA2 != null) {
                            dVarI = dVarA2.k(dVarI);
                        }
                        if (dVarI.e() == cVar2) {
                            A = 0;
                        } else {
                            A = new b.g.a.c.g0.t.i(jVarH2, jVarH, jVarH2, z8, c(xVar._config, jVarH2), null);
                            b.g.a.c.j jVar7 = A._valueType;
                            p.b bVarD3 = d(xVar, cVar3, jVar7, Map.Entry.class);
                            p.a aVar8 = bVarD3 == null ? aVar : bVarD3._contentInclusion;
                            if (aVar8 != aVar && aVar8 != aVar2) {
                                int iOrdinal4 = aVar8.ordinal();
                                if (iOrdinal4 != 2) {
                                    if (iOrdinal4 == i) {
                                        objT02 = b.g.a.c.g0.u.t.l;
                                    } else if (iOrdinal4 == 4) {
                                        objT02 = b.c.a.a0.d.t0(jVar7);
                                        if (objT02 != null && objT02.getClass().isArray()) {
                                            objT02 = b.c.a.a0.d.q0(objT02);
                                        }
                                    } else if (iOrdinal4 != 5) {
                                        objT02 = null;
                                    } else {
                                        objT02 = xVar.A(null, bVarD3._contentFilter);
                                        if (objT02 != null) {
                                            zB2 = xVar.B(objT02);
                                        }
                                        if (A._suppressableValue != objT02 || A._suppressNulls != zB2) {
                                            A = new b.g.a.c.g0.t.i(A, A._keySerializer, A._valueSerializer, objT02, zB2);
                                        }
                                    }
                                    zB2 = true;
                                    if (A._suppressableValue != objT02) {
                                        A = new b.g.a.c.g0.t.i(A, A._keySerializer, A._valueSerializer, objT02, zB2);
                                    }
                                } else {
                                    if (jVar7.b()) {
                                        objT02 = b.g.a.c.g0.u.t.l;
                                    }
                                    zB2 = true;
                                    if (A._suppressableValue != objT02) {
                                    }
                                }
                            }
                        }
                        nVarE = A;
                    } else {
                        nVarE = ByteBuffer.class.isAssignableFrom(cls8) ? new b.g.a.c.g0.u.g() : InetAddress.class.isAssignableFrom(cls8) ? new b.g.a.c.g0.u.p() : InetSocketAddress.class.isAssignableFrom(cls8) ? new b.g.a.c.g0.u.q() : TimeZone.class.isAssignableFrom(cls8) ? new s0() : Charset.class.isAssignableFrom(cls8) ? t0.k : (!Number.class.isAssignableFrom(cls8) || (iOrdinal = cVar3.a(null).e().ordinal()) == i || iOrdinal == 4) ? null : iOrdinal != 8 ? b.g.a.c.g0.u.v.k : t0.k;
                    }
                }
                if (nVarE == null) {
                    Class<?> cls9 = jVar._class;
                    Annotation[] annotationArr = b.g.a.c.i0.d.a;
                    if ((cls9.isAnnotation() ? "annotation" : cls9.isArray() ? "array" : cls.isAssignableFrom(cls9) ? "enum" : cls9.isPrimitive() ? "primitive" : null) == null) {
                        String name2 = cls9.getName();
                        boolean z13 = !(name2.startsWith("net.sf.cglib.proxy.") || name2.startsWith("org.hibernate.proxy."));
                        if (!z13 && !b.g.a.c.i0.d.q(jVar._class)) {
                            nVarX = null;
                        } else if (cVar3.a._class == Object.class) {
                            nVarX = xVar.x(Object.class);
                        } else {
                            Class<?> cls10 = jVar._class;
                            if (cls10.getName().startsWith("java.time.")) {
                                str2 = "Java 8 date/time";
                                str3 = "com.fasterxml.jackson.datatype:jackson-datatype-jsr310";
                            } else if (cls10.getName().startsWith("org.joda.time.")) {
                                str2 = "Joda date/time";
                                str3 = "com.fasterxml.jackson.datatype:jackson-datatype-joda";
                            } else {
                                str = null;
                                rVar = (str == null && xVar._config.a(jVar._class) == null) ? new b.g.a.c.g0.t.r(jVar, str) : null;
                                if (rVar == null) {
                                    nVarE = rVar;
                                } else {
                                    v vVar16 = xVar._config;
                                    e eVar2 = new e(cVar3);
                                    eVar2.c = vVar16;
                                    b.g.a.c.c0.q qVar3 = (b.g.a.c.c0.q) cVar3;
                                    List<b.g.a.c.c0.s> listD = qVar3.d();
                                    v vVar17 = xVar._config;
                                    b.g.a.c.b bVarE2 = vVar17.e();
                                    HashMap map = new HashMap();
                                    Iterator<b.g.a.c.c0.s> it2 = listD.iterator();
                                    while (it2.hasNext()) {
                                        b.g.a.c.c0.s next = it2.next();
                                        if (next.j() == null) {
                                            it2.remove();
                                        } else {
                                            Class<?> clsR = next.r();
                                            Boolean boolC0 = (Boolean) map.get(clsR);
                                            if (boolC0 == null) {
                                                vVar17.f(clsR);
                                                boolC0 = bVarE2.c0(((b.g.a.c.c0.q) vVar17.o(clsR)).f);
                                                if (boolC0 == null) {
                                                    boolC0 = Boolean.FALSE;
                                                }
                                                map.put(clsR, boolC0);
                                            }
                                            if (boolC0.booleanValue()) {
                                                it2.remove();
                                            }
                                        }
                                    }
                                    if (vVar17.q(b.g.a.c.p.REQUIRE_SETTERS_FOR_GETTERS)) {
                                        Iterator<b.g.a.c.c0.s> it3 = listD.iterator();
                                        while (it3.hasNext()) {
                                            b.g.a.c.c0.s next2 = it3.next();
                                            if (!next2.f() && !next2.u()) {
                                                it3.remove();
                                            }
                                        }
                                    }
                                    if (listD.isEmpty()) {
                                        arrayList = null;
                                        z3 = z8;
                                    } else {
                                        boolean zG2 = g(vVar17, cVar3, null);
                                        l lVar = new l(vVar17, cVar3);
                                        ArrayList arrayList3 = new ArrayList(listD.size());
                                        for (b.g.a.c.c0.s sVar : listD) {
                                            b.g.a.c.c0.i iVarJ = sVar.j();
                                            if (!sVar.v()) {
                                                b.a aVarH = sVar.h();
                                                if (aVarH == null) {
                                                    if (iVarJ instanceof b.g.a.c.c0.j) {
                                                        z4 = z8;
                                                        arrayList2 = arrayList3;
                                                        arrayList2.add(h(xVar, sVar, lVar, zG2, (b.g.a.c.c0.j) iVarJ));
                                                    } else {
                                                        z4 = z8;
                                                        arrayList2 = arrayList3;
                                                        arrayList2.add(h(xVar, sVar, lVar, zG2, (b.g.a.c.c0.g) iVarJ));
                                                    }
                                                    arrayList3 = arrayList2;
                                                    z8 = z4;
                                                } else {
                                                    if (aVarH.a == 2) {
                                                        z4 = z8;
                                                        arrayList2 = arrayList3;
                                                    }
                                                    arrayList3 = arrayList2;
                                                    z8 = z4;
                                                }
                                            } else if (iVarJ == null) {
                                                continue;
                                            } else {
                                                if (eVar2.h != null) {
                                                    StringBuilder sbU = b.d.b.a.a.U("Multiple type ids specified with ");
                                                    sbU.append(eVar2.h);
                                                    sbU.append(" and ");
                                                    sbU.append(iVarJ);
                                                    throw new IllegalArgumentException(sbU.toString());
                                                }
                                                eVar2.h = iVarJ;
                                            }
                                        }
                                        z3 = z8;
                                        arrayList = arrayList3;
                                    }
                                    if (arrayList == null) {
                                        arrayList = new ArrayList();
                                    } else {
                                        int size2 = arrayList.size();
                                        for (int i6 = 0; i6 < size2; i6++) {
                                            c cVar11 = (c) arrayList.get(i6);
                                            b.g.a.c.e0.g gVar9 = cVar11._typeSerializer;
                                            if (gVar9 != null && gVar9.c() == c0.a.EXTERNAL_PROPERTY) {
                                                t tVarA = t.a(gVar9.b());
                                                Iterator it4 = arrayList.iterator();
                                                while (true) {
                                                    if (!it4.hasNext()) {
                                                        break;
                                                    }
                                                    c cVar12 = (c) it4.next();
                                                    if (cVar12 != cVar11) {
                                                        t tVar = cVar12._wrapperName;
                                                        if (tVar != null) {
                                                            zEquals = tVar.equals(tVarA);
                                                        } else {
                                                            if (tVarA._simpleName.equals(cVar12._name._value)) {
                                                                if (!(tVarA._namespace != null)) {
                                                                    zEquals = true;
                                                                }
                                                            }
                                                            zEquals = false;
                                                        }
                                                        if (zEquals) {
                                                            cVar11._typeSerializer = null;
                                                            break;
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                    xVar.v().a(vVar16, qVar3.f, arrayList);
                                    if (this._factoryConfig.a()) {
                                        b.g.a.c.i0.b bVar15 = (b.g.a.c.i0.b) this._factoryConfig.b();
                                        while (bVar15.hasNext()) {
                                            Objects.requireNonNull((g) bVar15.next());
                                        }
                                    }
                                    n.a aVarS2 = vVar16.s(cVar3.a._class, qVar3.f);
                                    Set<String> setD2 = aVarS2 != null ? aVarS2.d() : null;
                                    Class<?> cls11 = cVar3.a._class;
                                    b.g.a.c.c0.c cVar13 = qVar3.f;
                                    b.g.a.c.b bVarE3 = vVar16.e();
                                    q.a aVarA2 = bVarE3 == null ? null : bVarE3.A(vVar16, cVar13);
                                    Set<String> set = aVarA2 != null ? aVarA2._included : null;
                                    if (set != null || (setD2 != null && !setD2.isEmpty())) {
                                        Iterator it5 = arrayList.iterator();
                                        while (it5.hasNext()) {
                                            if (b.c.a.a0.d.b2(((c) it5.next())._name._value, setD2, set)) {
                                                it5.remove();
                                            }
                                        }
                                    }
                                    if (this._factoryConfig.a()) {
                                        b.g.a.c.i0.b bVar16 = (b.g.a.c.i0.b) this._factoryConfig.b();
                                        while (bVar16.hasNext()) {
                                            Objects.requireNonNull((g) bVar16.next());
                                        }
                                    }
                                    a0 a0Var = qVar3.j;
                                    if (a0Var == null) {
                                        jVarA = null;
                                    } else {
                                        Class<? extends b.g.a.a.i0<?>> cls12 = a0Var.c;
                                        if (cls12 == l0.class) {
                                            String str4 = a0Var.f681b._simpleName;
                                            int size3 = arrayList.size();
                                            for (int i7 = 0; i7 != size3; i7++) {
                                                c cVar14 = (c) arrayList.get(i7);
                                                if (str4.equals(cVar14._name._value)) {
                                                    if (i7 > 0) {
                                                        arrayList.remove(i7);
                                                        arrayList.add(0, cVar14);
                                                    }
                                                    jVarA = b.g.a.c.g0.t.j.a(cVar14._declaredType, null, new b.g.a.c.g0.t.k(a0Var, cVar14), a0Var.f);
                                                }
                                            }
                                            Object[] objArr = new Object[2];
                                            objArr[0] = b.g.a.c.i0.d.n(cVar3.a);
                                            objArr[1] = str4 == null ? "[null]" : b.g.a.c.i0.d.c(str4);
                                            throw new IllegalArgumentException(String.format("Invalid Object Id definition for %s: cannot find property with name %s", objArr));
                                        }
                                        jVarA = b.g.a.c.g0.t.j.a(xVar.d().i(xVar.b(cls12), b.g.a.a.i0.class)[0], a0Var.f681b, xVar.e(qVar3.f, a0Var), a0Var.f);
                                    }
                                    eVar2.i = jVarA;
                                    eVar2.d = arrayList;
                                    eVar2.g = vVar16.e().g(qVar3.f);
                                    b0 b0Var = qVar3.c;
                                    if (b0Var == null) {
                                        first = null;
                                        if (first != null) {
                                            b.g.a.c.j jVarE = first.e();
                                            b.g.a.c.j jVarK = jVarE.k();
                                            b.g.a.c.e0.g gVarC3 = c(vVar16, jVarK);
                                            b.g.a.c.n nVarF2 = f(xVar, first);
                                            if (nVarF2 == null) {
                                                nVarF2 = b.g.a.c.g0.u.t.s(null, null, jVarE, vVar16.q(b.g.a.c.p.USE_STATIC_TYPING), gVarC3, null, null, null);
                                            }
                                            eVar2.f = new a(new d.a(t.a(first.c()), jVarK, null, first, b.g.a.c.s.k), first, nVarF2);
                                        }
                                        List<c> list2 = eVar2.d;
                                        zQ = vVar16.q(b.g.a.c.p.DEFAULT_VIEW_INCLUSION);
                                        size = list2.size();
                                        c[] cVarArr = new c[size];
                                        i4 = 0;
                                        int i8 = 0;
                                        while (i4 < size) {
                                            c cVar15 = list2.get(i4);
                                            Class<?>[] clsArr = cVar15._includeInViews;
                                            if (clsArr == null || clsArr.length == 0) {
                                                list = list2;
                                                if (zQ) {
                                                    cVarArr[i4] = cVar15;
                                                }
                                            } else {
                                                i8++;
                                                list = list2;
                                                cVarArr[i4] = clsArr.length == 1 ? new b.g.a.c.g0.t.e(cVar15, clsArr[0]) : new b.g.a.c.g0.t.d(cVar15, clsArr);
                                            }
                                            i4++;
                                            list2 = list;
                                        }
                                        if (zQ || i8 != 0) {
                                            if (size == eVar2.d.size()) {
                                                throw new IllegalArgumentException(String.format("Trying to set %d filtered properties; must match length of non-filtered `properties` (%d)", Integer.valueOf(size), Integer.valueOf(eVar2.d.size())));
                                            }
                                            eVar2.e = cVarArr;
                                        }
                                        if (this._factoryConfig.a()) {
                                            b.g.a.c.i0.b bVar17 = (b.g.a.c.i0.b) this._factoryConfig.b();
                                            while (bVar17.hasNext()) {
                                                Objects.requireNonNull((g) bVar17.next());
                                            }
                                        }
                                        try {
                                            nVarE = eVar2.a();
                                            if (nVarE == null) {
                                                if (jVar.A()) {
                                                    nVarE = new d(eVar2.f701b.a, eVar2, b.g.a.c.g0.u.d.k, null);
                                                } else {
                                                    Class<?> cls13 = jVar._class;
                                                    if (Iterator.class.isAssignableFrom(cls13)) {
                                                        b.g.a.c.j[] jVarArrI = vVar16._base._typeFactory.i(jVar, Iterator.class);
                                                        b.g.a.c.j jVarK2 = (jVarArrI == null || jVarArrI.length != 1) ? b.g.a.c.h0.n.k() : jVarArrI[0];
                                                        nVarE = new b.g.a.c.g0.t.h(jVarK2, z3, c(vVar16, jVarK2));
                                                    } else {
                                                        boolean z14 = z3;
                                                        if (Iterable.class.isAssignableFrom(cls13)) {
                                                            b.g.a.c.j[] jVarArrI2 = vVar16._base._typeFactory.i(jVar, Iterable.class);
                                                            b.g.a.c.j jVarK3 = (jVarArrI2 == null || jVarArrI2.length != 1) ? b.g.a.c.h0.n.k() : jVarArrI2[0];
                                                            nVarE = new b.g.a.c.g0.u.r(jVarK3, z14, c(vVar16, jVarK3));
                                                        } else {
                                                            nVarE = CharSequence.class.isAssignableFrom(cls13) ? t0.k : null;
                                                        }
                                                    }
                                                    if (nVarE == null) {
                                                        if (qVar3.f.t.size() > 0) {
                                                            nVarE = new d(eVar2.f701b.a, eVar2, b.g.a.c.g0.u.d.k, null);
                                                        }
                                                    }
                                                }
                                            }
                                        } catch (RuntimeException e) {
                                            xVar.F(cVar3, "Failed to construct BeanSerializer for %s: (%s) %s", cVar3.a, e.getClass().getName(), e.getMessage());
                                            throw null;
                                        }
                                    } else {
                                        if (!b0Var.i) {
                                            b0Var.h();
                                        }
                                        LinkedList<b.g.a.c.c0.i> linkedList = b0Var.m;
                                        if (linkedList == null) {
                                            first = null;
                                        } else {
                                            if (linkedList.size() > 1) {
                                                b0Var.i("Multiple 'any-getter' methods defined (%s vs %s)", b0Var.m.get(0), b0Var.m.get(1));
                                                throw null;
                                            }
                                            first = b0Var.m.getFirst();
                                        }
                                        if (first == null) {
                                            b0 b0Var2 = qVar3.c;
                                            if (!b0Var2.i) {
                                                b0Var2.h();
                                            }
                                            LinkedList<b.g.a.c.c0.i> linkedList2 = b0Var2.n;
                                            if (linkedList2 == null) {
                                                first = null;
                                            } else {
                                                if (linkedList2.size() > 1) {
                                                    b0Var2.i("Multiple 'any-getter' fields defined (%s vs %s)", b0Var2.n.get(0), b0Var2.n.get(1));
                                                    throw null;
                                                }
                                                first = b0Var2.n.getFirst();
                                            }
                                            if (first != null) {
                                                if (!Map.class.isAssignableFrom(first.d())) {
                                                    throw new IllegalArgumentException(String.format("Invalid 'any-getter' annotation on field '%s': type is not instance of java.util.Map", first.c()));
                                                }
                                            }
                                        } else if (!Map.class.isAssignableFrom(first.d())) {
                                            throw new IllegalArgumentException(String.format("Invalid 'any-getter' annotation on method %s(): return type is not instance of java.util.Map", first.c()));
                                        }
                                        if (first != null) {
                                        }
                                        List<c> list22 = eVar2.d;
                                        zQ = vVar16.q(b.g.a.c.p.DEFAULT_VIEW_INCLUSION);
                                        size = list22.size();
                                        c[] cVarArr2 = new c[size];
                                        i4 = 0;
                                        int i82 = 0;
                                        while (i4 < size) {
                                        }
                                        if (zQ) {
                                            if (size == eVar2.d.size()) {
                                            }
                                        }
                                    }
                                }
                                if (nVarE == null) {
                                    nVarE = xVar.x(cVar3.a._class);
                                }
                            }
                            Object[] objArr2 = new Object[i];
                            objArr2[i3] = str2;
                            objArr2[c] = b.g.a.c.i0.d.n(jVar);
                            objArr2[2] = str3;
                            str = String.format("%s type %s not supported by default: add Module \"%s\" to enable handling", objArr2);
                            if (str == null) {
                                if (rVar == null) {
                                }
                                if (nVarE == null) {
                                }
                            }
                        }
                        nVarE = nVarX;
                        if (nVarE == null) {
                        }
                    }
                }
            }
        }
        if (nVarE != null && this._factoryConfig.a()) {
            b.g.a.c.i0.b bVar18 = (b.g.a.c.i0.b) this._factoryConfig.b();
            while (bVar18.hasNext()) {
                Objects.requireNonNull((g) bVar18.next());
            }
        }
        return nVarE;
    }

    public Iterable<r> j() {
        return new b.g.a.c.i0.b(this._factoryConfig._additionalSerializers);
    }
}

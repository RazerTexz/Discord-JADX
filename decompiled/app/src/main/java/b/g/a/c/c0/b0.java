package b.g.a.c.c0;

import b.g.a.a.b;
import b.g.a.a.g;
import b.g.a.a.u;
import b.g.a.c.c0.c0;
import b.g.a.c.c0.g0;
import java.lang.annotation.Annotation;
import java.lang.reflect.Modifier;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TreeMap;

/* compiled from: POJOPropertiesCollector.java */
/* loaded from: classes3.dex */
public class b0 {
    public final b.g.a.c.z.l<?> a;

    /* renamed from: b, reason: collision with root package name */
    public final a f682b;
    public final boolean c;
    public final b.g.a.c.j d;
    public final c e;
    public final g0<?> f;
    public final b.g.a.c.b g;
    public final boolean h;
    public boolean i;
    public LinkedHashMap<String, c0> j;
    public LinkedList<c0> k;
    public Map<b.g.a.c.t, b.g.a.c.t> l;
    public LinkedList<i> m;
    public LinkedList<i> n;
    public LinkedList<j> o;
    public LinkedList<i> p;
    public LinkedList<i> q;
    public LinkedList<i> r;

    /* renamed from: s, reason: collision with root package name */
    public HashSet<String> f683s;
    public LinkedHashMap<Object, i> t;

    public b0(b.g.a.c.z.l<?> lVar, boolean z2, b.g.a.c.j jVar, c cVar, a aVar) {
        this.a = lVar;
        this.c = z2;
        this.d = jVar;
        this.e = cVar;
        if (lVar.p()) {
            this.h = true;
            this.g = lVar.e();
        } else {
            this.h = false;
            this.g = z.j;
        }
        this.f = lVar.m(jVar._class, cVar);
        this.f682b = aVar;
        lVar.q(b.g.a.c.p.USE_STD_BEAN_NAMING);
    }

    public void a(Map<String, c0> map, m mVar) {
        c0 c0VarF;
        g.a aVarD;
        String strI = this.g.i(mVar);
        if (strI == null) {
            strI = "";
        }
        b.g.a.c.t tVarN = this.g.n(mVar);
        boolean z2 = (tVarN == null || tVarN.d()) ? false : true;
        if (!z2) {
            if (strI.isEmpty() || (aVarD = this.g.d(this.a, mVar._owner)) == null || aVarD == g.a.DISABLED) {
                return;
            } else {
                tVarN = b.g.a.c.t.a(strI);
            }
        }
        b.g.a.c.t tVar = tVarN;
        String strB = b(strI);
        if (z2 && strB.isEmpty()) {
            String str = tVar._simpleName;
            c0VarF = map.get(str);
            if (c0VarF == null) {
                c0VarF = new c0(this.a, this.g, this.c, tVar);
                map.put(str, c0VarF);
            }
        } else {
            c0VarF = f(map, strB);
        }
        c0VarF.r = new c0.d<>(mVar, c0VarF.r, tVar, z2, true, false);
        this.k.add(c0VarF);
    }

    public final String b(String str) {
        b.g.a.c.t tVar;
        Map<b.g.a.c.t, b.g.a.c.t> map = this.l;
        return (map == null || (tVar = map.get(e(str))) == null) ? str : tVar._simpleName;
    }

    public void c(String str) {
        if (this.c || str == null) {
            return;
        }
        if (this.f683s == null) {
            this.f683s = new HashSet<>();
        }
        this.f683s.add(str);
    }

    public void d(b.a aVar, i iVar) {
        if (aVar == null) {
            return;
        }
        Object obj = aVar._id;
        if (this.t == null) {
            this.t = new LinkedHashMap<>();
        }
        i iVarPut = this.t.put(obj, iVar);
        if (iVarPut == null || iVarPut.getClass() != iVar.getClass()) {
            return;
        }
        throw new IllegalArgumentException("Duplicate injectable value with id '" + obj + "' (of type " + obj.getClass().getName() + ")");
    }

    public final b.g.a.c.t e(String str) {
        return b.g.a.c.t.b(str, null);
    }

    public c0 f(Map<String, c0> map, String str) {
        c0 c0Var = map.get(str);
        if (c0Var != null) {
            return c0Var;
        }
        c0 c0Var2 = new c0(this.a, this.g, this.c, b.g.a.c.t.a(str));
        map.put(str, c0Var2);
        return c0Var2;
    }

    public boolean g(c0 c0Var, List<c0> list) {
        if (list != null) {
            String str = c0Var.p._simpleName;
            int size = list.size();
            for (int i = 0; i < size; i++) {
                if (list.get(i).p._simpleName.equals(str)) {
                    list.set(i, c0Var);
                    return true;
                }
            }
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:179:0x0341  */
    /* JADX WARN: Removed duplicated region for block: B:452:0x087e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void h() {
        b.g.a.c.u uVar;
        boolean zBooleanValue;
        boolean z2;
        Collection<c0> collectionValues;
        String strC;
        HashSet<String> hashSet;
        u.a aVarT;
        c0.d<m> dVar;
        c0.d<j> dVar2;
        c0.d<g> dVar3;
        c0.d<j> dVar4;
        c0.d<j> dVar5;
        c0.d<g> dVar6;
        c0.d<m> dVar7;
        c0.d<j> dVar8;
        boolean z3;
        String strI;
        b.g.a.c.t tVar;
        boolean z4;
        boolean z5;
        boolean zF;
        String strI2;
        b.g.a.c.t tVar2;
        boolean z6;
        boolean zF2;
        b.g.a.c.t tVarE;
        boolean z7;
        boolean z8;
        boolean z9;
        LinkedHashMap<String, c0> linkedHashMap = new LinkedHashMap<>();
        b.g.a.c.b bVar = this.g;
        boolean z10 = (this.c || this.a.q(b.g.a.c.p.ALLOW_FINAL_FIELDS_AS_MUTATORS)) ? false : true;
        boolean zQ = this.a.q(b.g.a.c.p.PROPAGATE_TRANSIENT_MARKER);
        for (g gVar : this.e.g()) {
            Boolean bool = Boolean.TRUE;
            if (bool.equals(bVar.V(this.a, gVar))) {
                if (this.q == null) {
                    this.q = new LinkedList<>();
                }
                this.q.add(gVar);
            }
            if (bool.equals(bVar.W(gVar))) {
                if (this.r == null) {
                    this.r = new LinkedList<>();
                }
                this.r.add(gVar);
            } else {
                boolean zEquals = bool.equals(bVar.S(gVar));
                boolean zEquals2 = bool.equals(bVar.U(gVar));
                if (zEquals || zEquals2) {
                    if (zEquals) {
                        if (this.n == null) {
                            this.n = new LinkedList<>();
                        }
                        this.n.add(gVar);
                    }
                    if (zEquals2) {
                        if (this.p == null) {
                            this.p = new LinkedList<>();
                        }
                        this.p.add(gVar);
                    }
                } else {
                    String strI3 = bVar.i(gVar);
                    if (strI3 == null) {
                        strI3 = gVar.c();
                    }
                    Objects.requireNonNull((w) this.f682b);
                    if (strI3 != null) {
                        b.g.a.c.t tVarE2 = e(strI3);
                        b.g.a.c.t tVarE3 = bVar.E(this.a, gVar, tVarE2);
                        if (tVarE3 != null && !tVarE3.equals(tVarE2)) {
                            if (this.l == null) {
                                this.l = new HashMap();
                            }
                            this.l.put(tVarE3, tVarE2);
                        }
                        b.g.a.c.t tVarO = this.c ? bVar.o(gVar) : bVar.n(gVar);
                        boolean z11 = tVarO != null;
                        if (z11 && tVarO.d()) {
                            tVarE = e(strI3);
                            z7 = false;
                        } else {
                            tVarE = tVarO;
                            z7 = z11;
                        }
                        boolean zF3 = tVarE != null;
                        if (!zF3) {
                            g0.a aVar = (g0.a) this.f;
                            Objects.requireNonNull(aVar);
                            zF3 = aVar._fieldMinLevel.f(gVar.l);
                        }
                        boolean Z = bVar.Z(gVar);
                        if (!Modifier.isTransient(gVar.l.getModifiers()) || z11) {
                            z8 = Z;
                            z9 = zF3;
                        } else if (zQ) {
                            z9 = false;
                            z8 = true;
                        } else {
                            z8 = Z;
                            z9 = false;
                        }
                        if (!z10 || tVarE != null || z8 || !Modifier.isFinal(gVar.l.getModifiers())) {
                            c0 c0VarF = f(linkedHashMap, strI3);
                            c0VarF.q = new c0.d<>(gVar, c0VarF.q, tVarE, z7, z9, z8);
                        }
                    }
                }
            }
        }
        for (j jVar : (l) this.e.h()) {
            int iO = jVar.o();
            if (iO == 0) {
                b.g.a.c.b bVar2 = this.g;
                Class<?> returnType = jVar.l.getReturnType();
                if (returnType != Void.TYPE && (returnType != Void.class || this.a.q(b.g.a.c.p.ALLOW_VOID_VALUED_PROPERTIES))) {
                    Boolean bool2 = Boolean.TRUE;
                    if (bool2.equals(bVar2.S(jVar))) {
                        if (this.m == null) {
                            this.m = new LinkedList<>();
                        }
                        this.m.add(jVar);
                    } else if (bool2.equals(bVar2.V(this.a, jVar))) {
                        if (this.q == null) {
                            this.q = new LinkedList<>();
                        }
                        this.q.add(jVar);
                    } else if (bool2.equals(bVar2.W(jVar))) {
                        if (this.r == null) {
                            this.r = new LinkedList<>();
                        }
                        this.r.add(jVar);
                    } else {
                        b.g.a.c.t tVarO2 = bVar2.o(jVar);
                        boolean z12 = tVarO2 != null;
                        if (z12) {
                            strI = bVar2.i(jVar);
                            if (strI == null && (strI = this.f682b.c(jVar, jVar.c())) == null) {
                                strI = this.f682b.a(jVar, jVar.c());
                            }
                            if (strI == null) {
                                strI = jVar.c();
                            }
                            if (tVarO2.d()) {
                                tVarO2 = e(strI);
                                z12 = false;
                            }
                            tVar = tVarO2;
                            z4 = z12;
                            z5 = true;
                        } else {
                            strI = bVar2.i(jVar);
                            if (strI == null) {
                                strI = this.f682b.c(jVar, jVar.c());
                            }
                            if (strI == null) {
                                strI = this.f682b.a(jVar, jVar.c());
                                if (strI != null) {
                                    g0.a aVar2 = (g0.a) this.f;
                                    Objects.requireNonNull(aVar2);
                                    zF = aVar2._isGetterMinLevel.f(jVar.l);
                                }
                            } else {
                                g0.a aVar3 = (g0.a) this.f;
                                Objects.requireNonNull(aVar3);
                                zF = aVar3._getterMinLevel.f(jVar.l);
                            }
                            z4 = z12;
                            z5 = zF;
                            tVar = tVarO2;
                        }
                        String strB = b(strI);
                        boolean Z2 = bVar2.Z(jVar);
                        c0 c0VarF2 = f(linkedHashMap, strB);
                        c0VarF2.f687s = new c0.d<>(jVar, c0VarF2.f687s, tVar, z4, z5, Z2);
                    }
                }
            } else if (iO == 1) {
                b.g.a.c.b bVar3 = this.g;
                b.g.a.c.t tVarN = bVar3.n(jVar);
                boolean z13 = tVarN != null;
                if (z13) {
                    strI2 = bVar3.i(jVar);
                    if (strI2 == null) {
                        strI2 = this.f682b.b(jVar, jVar.c());
                    }
                    if (strI2 == null) {
                        strI2 = jVar.c();
                    }
                    if (tVarN.d()) {
                        tVarN = e(strI2);
                        z13 = false;
                    }
                    tVar2 = tVarN;
                    z6 = z13;
                    zF2 = true;
                } else {
                    strI2 = bVar3.i(jVar);
                    if (strI2 == null) {
                        strI2 = this.f682b.b(jVar, jVar.c());
                    }
                    if (strI2 != null) {
                        g0.a aVar4 = (g0.a) this.f;
                        Objects.requireNonNull(aVar4);
                        z6 = z13;
                        zF2 = aVar4._setterMinLevel.f(jVar.l);
                        tVar2 = tVarN;
                    }
                }
                String strB2 = b(strI2);
                boolean Z3 = bVar3.Z(jVar);
                c0 c0VarF3 = f(linkedHashMap, strB2);
                c0VarF3.t = new c0.d<>(jVar, c0VarF3.t, tVar2, z6, zF2, Z3);
            } else if (iO == 2 && Boolean.TRUE.equals(this.g.U(jVar))) {
                if (this.o == null) {
                    this.o = new LinkedList<>();
                }
                this.o.add(jVar);
            }
        }
        c cVar = this.e;
        Boolean boolValueOf = cVar.f685x;
        if (boolValueOf == null) {
            Class<?> cls = cVar.l;
            Annotation[] annotationArr = b.g.a.c.i0.d.a;
            if (Modifier.isStatic(cls.getModifiers())) {
                z3 = false;
                boolValueOf = Boolean.valueOf(z3);
                cVar.f685x = boolValueOf;
            } else {
                if ((b.g.a.c.i0.d.t(cls) ? null : cls.getEnclosingClass()) != null) {
                    z3 = true;
                }
                boolValueOf = Boolean.valueOf(z3);
                cVar.f685x = boolValueOf;
            }
        }
        if (!boolValueOf.booleanValue() && this.h) {
            for (e eVar : this.e.f().f686b) {
                if (this.k == null) {
                    this.k = new LinkedList<>();
                }
                int length = eVar._constructor.getParameterTypes().length;
                for (int i = 0; i < length; i++) {
                    a(linkedHashMap, eVar.m(i));
                }
            }
            for (j jVar2 : this.e.f().c) {
                if (this.k == null) {
                    this.k = new LinkedList<>();
                }
                int iO2 = jVar2.o();
                for (int i2 = 0; i2 < iO2; i2++) {
                    a(linkedHashMap, jVar2.m(i2));
                }
            }
        }
        Iterator<c0> it = linkedHashMap.values().iterator();
        while (it.hasNext()) {
            c0 next = it.next();
            if (!(next.z(next.q) || next.z(next.f687s) || next.z(next.t) || next.z(next.r))) {
                it.remove();
            } else if (next.y(next.q) || next.y(next.f687s) || next.y(next.t) || next.y(next.r)) {
                if (next.u()) {
                    next.q = next.G(next.q);
                    next.f687s = next.G(next.f687s);
                    next.t = next.G(next.t);
                    next.r = next.G(next.r);
                    if (!next.f()) {
                        c(next.p());
                    }
                } else {
                    it.remove();
                    c(next.p());
                }
            }
        }
        boolean zQ2 = this.a.q(b.g.a.c.p.INFER_PROPERTY_MUTATORS);
        for (c0 c0Var : linkedHashMap.values()) {
            b0 b0Var = this.c ? null : this;
            u.a aVar5 = u.a.AUTO;
            b.g.a.c.b bVar4 = c0Var.n;
            if (bVar4 == null || (!c0Var.l ? ((dVar = c0Var.r) == null || (aVarT = bVar4.t(dVar.a)) == null || aVarT == aVar5) && (((dVar2 = c0Var.t) == null || (aVarT = c0Var.n.t(dVar2.a)) == null || aVarT == aVar5) && (((dVar3 = c0Var.q) == null || (aVarT = c0Var.n.t(dVar3.a)) == null || aVarT == aVar5) && ((dVar4 = c0Var.f687s) == null || (aVarT = c0Var.n.t(dVar4.a)) == null || aVarT == aVar5))) : ((dVar5 = c0Var.f687s) == null || (aVarT = bVar4.t(dVar5.a)) == null || aVarT == aVar5) && (((dVar6 = c0Var.q) == null || (aVarT = c0Var.n.t(dVar6.a)) == null || aVarT == aVar5) && (((dVar7 = c0Var.r) == null || (aVarT = c0Var.n.t(dVar7.a)) == null || aVarT == aVar5) && ((dVar8 = c0Var.t) == null || (aVarT = c0Var.n.t(dVar8.a)) == null || aVarT == aVar5))))) {
                aVarT = null;
            }
            if (aVarT != null) {
                aVar5 = aVarT;
            }
            int iOrdinal = aVar5.ordinal();
            if (iOrdinal == 1) {
                if (b0Var != null) {
                    b0Var.c(c0Var.p());
                    Iterator<b.g.a.c.t> it2 = c0Var.L().iterator();
                    while (it2.hasNext()) {
                        b0Var.c(it2.next()._simpleName);
                    }
                }
                c0Var.t = null;
                c0Var.r = null;
                if (!c0Var.l) {
                    c0Var.q = null;
                }
            } else if (iOrdinal == 2) {
                c0Var.f687s = null;
                if (c0Var.l) {
                    c0Var.q = null;
                }
            } else if (iOrdinal != 3) {
                c0Var.f687s = c0Var.H(c0Var.f687s);
                c0Var.r = c0Var.H(c0Var.r);
                if (!zQ2 || c0Var.f687s == null) {
                    c0Var.q = c0Var.H(c0Var.q);
                    c0Var.t = c0Var.H(c0Var.t);
                }
            }
        }
        Iterator<Map.Entry<String, c0>> it3 = linkedHashMap.entrySet().iterator();
        LinkedList<c0> linkedList = null;
        while (it3.hasNext()) {
            c0 value = it3.next().getValue();
            Set<b.g.a.c.t> setL = value.L();
            if (!setL.isEmpty()) {
                it3.remove();
                if (linkedList == null) {
                    linkedList = new LinkedList();
                }
                if (setL.size() == 1) {
                    linkedList.add(new c0(value, setL.iterator().next()));
                } else {
                    HashMap map = new HashMap();
                    value.B(setL, map, value.q);
                    value.B(setL, map, value.f687s);
                    value.B(setL, map, value.t);
                    value.B(setL, map, value.r);
                    linkedList.addAll(map.values());
                }
            }
        }
        if (linkedList != null) {
            for (c0 c0Var2 : linkedList) {
                String strP = c0Var2.p();
                c0 c0Var3 = linkedHashMap.get(strP);
                if (c0Var3 == null) {
                    linkedHashMap.put(strP, c0Var2);
                } else {
                    c0Var3.K(c0Var2);
                }
                if (g(c0Var2, this.k) && (hashSet = this.f683s) != null) {
                    hashSet.remove(strP);
                }
            }
        }
        for (g gVar2 : this.e.g()) {
            d(this.g.j(gVar2), gVar2);
        }
        for (j jVar3 : (l) this.e.h()) {
            if (jVar3.o() == 1) {
                d(this.g.j(jVar3), jVar3);
            }
        }
        for (c0 c0Var4 : linkedHashMap.values()) {
            if (this.c) {
                c0.d<j> dVar9 = c0Var4.f687s;
                if (dVar9 != null) {
                    c0Var4.f687s = c0Var4.A(c0Var4.f687s, c0Var4.F(0, dVar9, c0Var4.q, c0Var4.r, c0Var4.t));
                } else {
                    c0.d<g> dVar10 = c0Var4.q;
                    if (dVar10 != null) {
                        c0Var4.q = c0Var4.A(c0Var4.q, c0Var4.F(0, dVar10, c0Var4.r, c0Var4.t));
                    }
                }
            } else {
                c0.d<m> dVar11 = c0Var4.r;
                if (dVar11 != null) {
                    c0Var4.r = c0Var4.A(c0Var4.r, c0Var4.F(0, dVar11, c0Var4.t, c0Var4.q, c0Var4.f687s));
                } else {
                    c0.d<j> dVar12 = c0Var4.t;
                    if (dVar12 != null) {
                        c0Var4.t = c0Var4.A(c0Var4.t, c0Var4.F(0, dVar12, c0Var4.q, c0Var4.f687s));
                    } else {
                        c0.d<g> dVar13 = c0Var4.q;
                        if (dVar13 != null) {
                            c0Var4.q = c0Var4.A(c0Var4.q, c0Var4.F(0, dVar13, c0Var4.f687s));
                        }
                    }
                }
            }
        }
        for (c0 c0Var5 : linkedHashMap.values()) {
            c0Var5.q = c0Var5.J(c0Var5.q);
            c0Var5.f687s = c0Var5.J(c0Var5.f687s);
            c0Var5.t = c0Var5.J(c0Var5.t);
            c0Var5.r = c0Var5.J(c0Var5.r);
        }
        Object objP = this.g.p(this.e);
        if (objP == null) {
            uVar = this.a._base._propertyNamingStrategy;
        } else if (objP instanceof b.g.a.c.u) {
            uVar = (b.g.a.c.u) objP;
        } else {
            if (!(objP instanceof Class)) {
                StringBuilder sbU = b.d.b.a.a.U("AnnotationIntrospector returned PropertyNamingStrategy definition of type ");
                sbU.append(objP.getClass().getName());
                sbU.append("; expected type PropertyNamingStrategy or Class<PropertyNamingStrategy> instead");
                throw new IllegalStateException(sbU.toString());
            }
            Class cls2 = (Class) objP;
            if (cls2 == b.g.a.c.u.class) {
                uVar = null;
            } else {
                if (!b.g.a.c.u.class.isAssignableFrom(cls2)) {
                    throw new IllegalStateException(b.d.b.a.a.o(cls2, b.d.b.a.a.U("AnnotationIntrospector returned Class "), "; expected Class<PropertyNamingStrategy>"));
                }
                Objects.requireNonNull(this.a._base);
                uVar = (b.g.a.c.u) b.g.a.c.i0.d.g(cls2, this.a.b());
            }
        }
        if (uVar != null) {
            c0[] c0VarArr = (c0[]) linkedHashMap.values().toArray(new c0[linkedHashMap.size()]);
            linkedHashMap.clear();
            for (c0 c0Var6 : c0VarArr) {
                b.g.a.c.t tVar3 = c0Var6.o;
                if (!(c0Var6.w(c0Var6.q) || c0Var6.w(c0Var6.f687s) || c0Var6.w(c0Var6.t) || c0Var6.w(c0Var6.r)) || this.a.q(b.g.a.c.p.ALLOW_EXPLICIT_PROPERTY_RENAMING)) {
                    if (this.c) {
                        strC = c0Var6.f687s != null ? uVar.c(this.a, c0Var6.n(), tVar3._simpleName) : c0Var6.q != null ? uVar.b(this.a, c0Var6.l(), tVar3._simpleName) : null;
                    } else if (c0Var6.t != null) {
                        strC = uVar.d(this.a, c0Var6.s(), tVar3._simpleName);
                    } else if (c0Var6.r != null) {
                        strC = uVar.a(this.a, c0Var6.k(), tVar3._simpleName);
                    } else if (c0Var6.q != null) {
                        strC = uVar.b(this.a, c0Var6.l(), tVar3._simpleName);
                    } else if (c0Var6.f687s != null) {
                        strC = uVar.c(this.a, c0Var6.n(), tVar3._simpleName);
                    }
                }
                if (strC == null || tVar3._simpleName.equals(strC)) {
                    strC = tVar3._simpleName;
                } else {
                    b.g.a.c.t tVar4 = c0Var6.o;
                    if (!strC.equals(tVar4._simpleName)) {
                        tVar4 = new b.g.a.c.t(strC, tVar4._namespace);
                    }
                    if (tVar4 != c0Var6.o) {
                        c0Var6 = new c0(c0Var6, tVar4);
                    }
                }
                c0 c0Var7 = linkedHashMap.get(strC);
                if (c0Var7 == null) {
                    linkedHashMap.put(strC, c0Var6);
                } else {
                    c0Var7.K(c0Var6);
                }
                g(c0Var6, this.k);
            }
        }
        if (this.a.q(b.g.a.c.p.USE_WRAPPER_NAME_AS_PROPERTY_NAME)) {
            Iterator<Map.Entry<String, c0>> it4 = linkedHashMap.entrySet().iterator();
            while (it4.hasNext()) {
                if (it4.next().getValue().q() != null) {
                    Objects.requireNonNull(this.g);
                }
            }
        }
        b.g.a.c.b bVar5 = this.g;
        Boolean boolJ = bVar5.J(this.e);
        if (boolJ == null) {
            b.g.a.c.z.l<?> lVar = this.a;
            Objects.requireNonNull(lVar);
            zBooleanValue = lVar.q(b.g.a.c.p.SORT_PROPERTIES_ALPHABETICALLY);
        } else {
            zBooleanValue = boolJ.booleanValue();
        }
        Iterator<c0> it5 = linkedHashMap.values().iterator();
        while (true) {
            if (it5.hasNext()) {
                if (it5.next().o()._index != null) {
                    z2 = true;
                    break;
                }
            } else {
                z2 = false;
                break;
            }
        }
        String[] strArrI = bVar5.I(this.e);
        if (zBooleanValue || z2 || this.k != null || strArrI != null) {
            int size = linkedHashMap.size();
            Map<? extends Object, ? extends Object> treeMap = zBooleanValue ? new TreeMap<>() : new LinkedHashMap<>(size + size);
            for (c0 c0Var8 : linkedHashMap.values()) {
                treeMap.put(c0Var8.p(), c0Var8);
            }
            LinkedHashMap linkedHashMap2 = new LinkedHashMap(size + size);
            if (strArrI != null) {
                for (String strP2 : strArrI) {
                    c0 c0Var9 = (c0) treeMap.remove(strP2);
                    if (c0Var9 == null) {
                        Iterator<c0> it6 = linkedHashMap.values().iterator();
                        while (true) {
                            if (!it6.hasNext()) {
                                break;
                            }
                            c0 next2 = it6.next();
                            if (strP2.equals(next2.p._simpleName)) {
                                strP2 = next2.p();
                                c0Var9 = next2;
                                break;
                            }
                        }
                    }
                    if (c0Var9 != null) {
                        linkedHashMap2.put(strP2, c0Var9);
                    }
                }
            }
            if (z2) {
                TreeMap treeMap2 = new TreeMap();
                Iterator<Map.Entry<? extends Object, ? extends Object>> it7 = treeMap.entrySet().iterator();
                while (it7.hasNext()) {
                    c0 c0Var10 = (c0) it7.next().getValue();
                    Integer num = c0Var10.o()._index;
                    if (num != null) {
                        treeMap2.put(num, c0Var10);
                        it7.remove();
                    }
                }
                for (c0 c0Var11 : treeMap2.values()) {
                    linkedHashMap2.put(c0Var11.p(), c0Var11);
                }
            }
            if (this.k != null && (!zBooleanValue || this.a.q(b.g.a.c.p.SORT_CREATOR_PROPERTIES_FIRST))) {
                if (zBooleanValue) {
                    TreeMap treeMap3 = new TreeMap();
                    for (c0 c0Var12 : this.k) {
                        treeMap3.put(c0Var12.p(), c0Var12);
                    }
                    collectionValues = treeMap3.values();
                } else {
                    collectionValues = this.k;
                }
                for (c0 c0Var13 : collectionValues) {
                    String strP3 = c0Var13.p();
                    if (treeMap.containsKey(strP3)) {
                        linkedHashMap2.put(strP3, c0Var13);
                    }
                }
            }
            linkedHashMap2.putAll(treeMap);
            linkedHashMap.clear();
            linkedHashMap.putAll(linkedHashMap2);
        }
        this.j = linkedHashMap;
        this.i = true;
    }

    public void i(String str, Object... objArr) {
        if (objArr.length > 0) {
            str = String.format(str, objArr);
        }
        StringBuilder sbU = b.d.b.a.a.U("Problem with definition of ");
        sbU.append(this.e);
        sbU.append(": ");
        sbU.append(str);
        throw new IllegalArgumentException(sbU.toString());
    }
}

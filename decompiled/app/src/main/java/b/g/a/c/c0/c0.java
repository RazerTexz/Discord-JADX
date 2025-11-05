package b.g.a.c.c0;

import b.g.a.a.h0;
import b.g.a.a.p;
import b.g.a.a.z;
import b.g.a.c.b;
import b.g.a.c.s;
import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/* compiled from: POJOPropertyBuilder.java */
/* loaded from: classes3.dex */
public class c0 extends s implements Comparable<c0> {
    public static final b.a k = new b.a(1, "");
    public final boolean l;
    public final b.g.a.c.z.l<?> m;
    public final b.g.a.c.b n;
    public final b.g.a.c.t o;
    public final b.g.a.c.t p;
    public d<g> q;
    public d<m> r;

    /* renamed from: s, reason: collision with root package name */
    public d<j> f687s;
    public d<j> t;
    public transient b.g.a.c.s u;
    public transient b.a v;

    /* compiled from: POJOPropertyBuilder.java */
    public class a implements e<Class<?>[]> {
        public a() {
        }

        @Override // b.g.a.c.c0.c0.e
        public Class<?>[] a(i iVar) {
            return c0.this.n.R(iVar);
        }
    }

    /* compiled from: POJOPropertyBuilder.java */
    public class b implements e<b.a> {
        public b() {
        }

        @Override // b.g.a.c.c0.c0.e
        public b.a a(i iVar) {
            return c0.this.n.D(iVar);
        }
    }

    /* compiled from: POJOPropertyBuilder.java */
    public class c implements e<Boolean> {
        public c() {
        }

        @Override // b.g.a.c.c0.c0.e
        public Boolean a(i iVar) {
            return c0.this.n.d0(iVar);
        }
    }

    /* compiled from: POJOPropertyBuilder.java */
    public static final class d<T> {
        public final T a;

        /* renamed from: b, reason: collision with root package name */
        public final d<T> f688b;
        public final b.g.a.c.t c;
        public final boolean d;
        public final boolean e;
        public final boolean f;

        public d(T t, d<T> dVar, b.g.a.c.t tVar, boolean z2, boolean z3, boolean z4) {
            this.a = t;
            this.f688b = dVar;
            b.g.a.c.t tVar2 = (tVar == null || tVar.d()) ? null : tVar;
            this.c = tVar2;
            if (z2) {
                if (tVar2 == null) {
                    throw new IllegalArgumentException("Cannot pass true for 'explName' if name is null/empty");
                }
                if (!tVar.c()) {
                    z2 = false;
                }
            }
            this.d = z2;
            this.e = z3;
            this.f = z4;
        }

        public d<T> a(d<T> dVar) {
            d<T> dVar2 = this.f688b;
            return dVar2 == null ? c(dVar) : c(dVar2.a(dVar));
        }

        public d<T> b() {
            d<T> dVar = this.f688b;
            if (dVar == null) {
                return this;
            }
            d<T> dVarB = dVar.b();
            if (this.c != null) {
                return dVarB.c == null ? c(null) : c(dVarB);
            }
            if (dVarB.c != null) {
                return dVarB;
            }
            boolean z2 = this.e;
            return z2 == dVarB.e ? c(dVarB) : z2 ? c(null) : dVarB;
        }

        public d<T> c(d<T> dVar) {
            return dVar == this.f688b ? this : new d<>(this.a, dVar, this.c, this.d, this.e, this.f);
        }

        public d<T> d() {
            d<T> dVarD;
            if (!this.f) {
                d<T> dVar = this.f688b;
                return (dVar == null || (dVarD = dVar.d()) == this.f688b) ? this : c(dVarD);
            }
            d<T> dVar2 = this.f688b;
            if (dVar2 == null) {
                return null;
            }
            return dVar2.d();
        }

        public d<T> e() {
            return this.f688b == null ? this : new d<>(this.a, null, this.c, this.d, this.e, this.f);
        }

        public d<T> f() {
            d<T> dVar = this.f688b;
            d<T> dVarF = dVar == null ? null : dVar.f();
            return this.e ? c(dVarF) : dVarF;
        }

        public String toString() {
            String str = String.format("%s[visible=%b,ignore=%b,explicitName=%b]", this.a.toString(), Boolean.valueOf(this.e), Boolean.valueOf(this.f), Boolean.valueOf(this.d));
            if (this.f688b == null) {
                return str;
            }
            StringBuilder sbX = b.d.b.a.a.X(str, ", ");
            sbX.append(this.f688b.toString());
            return sbX.toString();
        }
    }

    /* compiled from: POJOPropertyBuilder.java */
    public interface e<T> {
        T a(i iVar);
    }

    public c0(b.g.a.c.z.l<?> lVar, b.g.a.c.b bVar, boolean z2, b.g.a.c.t tVar) {
        this.m = lVar;
        this.n = bVar;
        this.p = tVar;
        this.o = tVar;
        this.l = z2;
    }

    public static <T> d<T> N(d<T> dVar, d<T> dVar2) {
        if (dVar == null) {
            return dVar2;
        }
        if (dVar2 == null) {
            return dVar;
        }
        d<T> dVar3 = dVar.f688b;
        return dVar3 == null ? dVar.c(dVar2) : dVar.c(dVar3.a(dVar2));
    }

    public final <T extends i> d<T> A(d<T> dVar, p pVar) {
        i iVar = (i) dVar.a.l(pVar);
        d<T> dVar2 = dVar.f688b;
        if (dVar2 != null) {
            dVar = dVar.c(A(dVar2, pVar));
        }
        return iVar == dVar.a ? dVar : new d<>(iVar, dVar.f688b, dVar.c, dVar.d, dVar.e, dVar.f);
    }

    /*  JADX ERROR: JadxRuntimeException in pass: ConstructorVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r8v0 ??, still in use, count: 1, list:
          (r8v0 ?? I:java.lang.Object) from 0x0023: INVOKE (r11v0 ?? I:java.util.Map), (r7v0 ?? I:java.lang.Object), (r8v0 ?? I:java.lang.Object) INTERFACE call: java.util.Map.put(java.lang.Object, java.lang.Object):java.lang.Object A[MD:(K, V):V (c)] (LINE:5)
        	at jadx.core.utils.InsnRemover.removeSsaVar(InsnRemover.java:162)
        	at jadx.core.utils.InsnRemover.unbindResult(InsnRemover.java:127)
        	at jadx.core.utils.InsnRemover.lambda$unbindInsns$1(InsnRemover.java:99)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1604)
        	at jadx.core.utils.InsnRemover.unbindInsns(InsnRemover.java:98)
        	at jadx.core.utils.InsnRemover.perform(InsnRemover.java:73)
        	at jadx.core.dex.visitors.ConstructorVisitor.replaceInvoke(ConstructorVisitor.java:59)
        	at jadx.core.dex.visitors.ConstructorVisitor.visit(ConstructorVisitor.java:42)
        */
    public final void B(
    /*  JADX ERROR: JadxRuntimeException in pass: ConstructorVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r8v0 ??, still in use, count: 1, list:
          (r8v0 ?? I:java.lang.Object) from 0x0023: INVOKE (r11v0 ?? I:java.util.Map), (r7v0 ?? I:java.lang.Object), (r8v0 ?? I:java.lang.Object) INTERFACE call: java.util.Map.put(java.lang.Object, java.lang.Object):java.lang.Object A[MD:(K, V):V (c)] (LINE:5)
        	at jadx.core.utils.InsnRemover.removeSsaVar(InsnRemover.java:162)
        	at jadx.core.utils.InsnRemover.unbindResult(InsnRemover.java:127)
        	at jadx.core.utils.InsnRemover.lambda$unbindInsns$1(InsnRemover.java:99)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1604)
        	at jadx.core.utils.InsnRemover.unbindInsns(InsnRemover.java:98)
        	at jadx.core.utils.InsnRemover.perform(InsnRemover.java:73)
        	at jadx.core.dex.visitors.ConstructorVisitor.replaceInvoke(ConstructorVisitor.java:59)
        */
    /*  JADX ERROR: Method generation error
        jadx.core.utils.exceptions.JadxRuntimeException: Code variable not set in r10v0 ??
        	at jadx.core.dex.instructions.args.SSAVar.getCodeVar(SSAVar.java:236)
        	at jadx.core.codegen.MethodGen.addMethodArguments(MethodGen.java:222)
        	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:167)
        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:405)
        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:335)
        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:301)
        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:186)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1604)
        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
        	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
        	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(ReferencePipeline.java:284)
        	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:571)
        	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:560)
        	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:153)
        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:176)
        	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:265)
        	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:632)
        	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:297)
        	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:286)
        	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:270)
        	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:161)
        	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:103)
        	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
        	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
        	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
        	at jadx.core.ProcessClass.process(ProcessClass.java:82)
        	at jadx.core.ProcessClass.generateCode(ProcessClass.java:120)
        	at jadx.core.dex.nodes.ClassNode.generateClassCode(ClassNode.java:403)
        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:391)
        	at jadx.core.dex.nodes.ClassNode.getCode(ClassNode.java:341)
        */

    public final Set<b.g.a.c.t> C(d<? extends i> dVar, Set<b.g.a.c.t> set) {
        for (d<? extends i> dVar2 = dVar; dVar2 != null; dVar2 = dVar2.f688b) {
            if (dVar2.d && dVar2.c != null) {
                if (set == null) {
                    set = new HashSet<>();
                }
                set.add(dVar2.c);
            }
        }
        return set;
    }

    public final <T extends i> p D(d<T> dVar) {
        p pVar = dVar.a.k;
        d<T> dVar2 = dVar.f688b;
        return dVar2 != null ? p.c(pVar, D(dVar2)) : pVar;
    }

    public int E(j jVar) {
        String strC = jVar.c();
        if (!strC.startsWith("get") || strC.length() <= 3) {
            return (!strC.startsWith("is") || strC.length() <= 2) ? 3 : 2;
        }
        return 1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final p F(int i, d<? extends i>... dVarArr) {
        d<? extends i> dVar = dVarArr[i];
        p pVarC = ((i) dVar.a).k;
        d<? extends i> dVar2 = dVar.f688b;
        if (dVar2 != null) {
            pVarC = p.c(pVarC, D(dVar2));
        }
        do {
            i++;
            if (i >= dVarArr.length) {
                return pVarC;
            }
        } while (dVarArr[i] == null);
        return p.c(pVarC, F(i, dVarArr));
    }

    public final <T> d<T> G(d<T> dVar) {
        return dVar == null ? dVar : dVar.d();
    }

    public final <T> d<T> H(d<T> dVar) {
        return dVar == null ? dVar : dVar.f();
    }

    public int I(j jVar) {
        String strC = jVar.c();
        return (!strC.startsWith("set") || strC.length() <= 3) ? 2 : 1;
    }

    public final <T> d<T> J(d<T> dVar) {
        return dVar == null ? dVar : dVar.b();
    }

    public void K(c0 c0Var) {
        this.q = N(this.q, c0Var.q);
        this.r = N(this.r, c0Var.r);
        this.f687s = N(this.f687s, c0Var.f687s);
        this.t = N(this.t, c0Var.t);
    }

    public Set<b.g.a.c.t> L() {
        Set<b.g.a.c.t> setC = C(this.r, C(this.t, C(this.f687s, C(this.q, null))));
        return setC == null ? Collections.emptySet() : setC;
    }

    public <T> T M(e<T> eVar) {
        d<j> dVar;
        d<g> dVar2;
        if (this.n == null) {
            return null;
        }
        if (this.l) {
            d<j> dVar3 = this.f687s;
            if (dVar3 != null) {
                tA = eVar.a(dVar3.a);
            }
        } else {
            d<m> dVar4 = this.r;
            tA = dVar4 != null ? eVar.a(dVar4.a) : null;
            if (tA == null && (dVar = this.t) != null) {
                tA = eVar.a(dVar.a);
            }
        }
        return (tA != null || (dVar2 = this.q) == null) ? tA : eVar.a(dVar2.a);
    }

    @Override // java.lang.Comparable
    public int compareTo(c0 c0Var) {
        c0 c0Var2 = c0Var;
        if (this.r != null) {
            if (c0Var2.r == null) {
                return -1;
            }
        } else if (c0Var2.r != null) {
            return 1;
        }
        return p().compareTo(c0Var2.p());
    }

    @Override // b.g.a.c.c0.s
    public boolean f() {
        return (this.r == null && this.t == null && this.q == null) ? false : true;
    }

    @Override // b.g.a.c.c0.s
    public p.b g() {
        i iVarJ = j();
        b.g.a.c.b bVar = this.n;
        p.b bVarZ = bVar == null ? null : bVar.z(iVarJ);
        if (bVarZ != null) {
            return bVarZ;
        }
        p.b bVar2 = p.b.j;
        return p.b.j;
    }

    @Override // b.g.a.c.c0.s
    public b.a h() {
        b.a aVar = this.v;
        if (aVar != null) {
            if (aVar == k) {
                return null;
            }
            return aVar;
        }
        b.a aVar2 = (b.a) M(new b());
        this.v = aVar2 == null ? k : aVar2;
        return aVar2;
    }

    @Override // b.g.a.c.c0.s
    public Class<?>[] i() {
        return (Class[]) M(new a());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // b.g.a.c.c0.s
    public m k() {
        d dVar = this.r;
        if (dVar == null) {
            return null;
        }
        do {
            T t = dVar.a;
            if (((m) t)._owner instanceof b.g.a.c.c0.e) {
                return (m) t;
            }
            dVar = dVar.f688b;
        } while (dVar != null);
        return this.r.a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // b.g.a.c.c0.s
    public g l() {
        d<g> dVar = this.q;
        if (dVar == null) {
            return null;
        }
        g gVar = dVar.a;
        for (d dVar2 = dVar.f688b; dVar2 != null; dVar2 = dVar2.f688b) {
            g gVar2 = (g) dVar2.a;
            Class<?> clsG = gVar.g();
            Class<?> clsG2 = gVar2.g();
            if (clsG != clsG2) {
                if (clsG.isAssignableFrom(clsG2)) {
                    gVar = gVar2;
                } else if (clsG2.isAssignableFrom(clsG)) {
                }
            }
            StringBuilder sbU = b.d.b.a.a.U("Multiple fields representing property \"");
            sbU.append(p());
            sbU.append("\": ");
            sbU.append(gVar.h());
            sbU.append(" vs ");
            sbU.append(gVar2.h());
            throw new IllegalArgumentException(sbU.toString());
        }
        return gVar;
    }

    @Override // b.g.a.c.c0.s
    public b.g.a.c.t m() {
        return this.o;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0045  */
    @Override // b.g.a.c.c0.s
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public j n() {
        d<j> dVar = this.f687s;
        if (dVar == null) {
            return null;
        }
        d<j> dVar2 = dVar.f688b;
        if (dVar2 == null) {
            return dVar.a;
        }
        for (d<j> dVar3 = dVar2; dVar3 != null; dVar3 = dVar3.f688b) {
            Class<?> clsG = dVar.a.g();
            Class<?> clsG2 = dVar3.a.g();
            if (clsG == clsG2) {
                int iE = E(dVar3.a);
                int iE2 = E(dVar.a);
                if (iE == iE2) {
                    StringBuilder sbU = b.d.b.a.a.U("Conflicting getter definitions for property \"");
                    sbU.append(p());
                    sbU.append("\": ");
                    sbU.append(dVar.a.h());
                    sbU.append(" vs ");
                    sbU.append(dVar3.a.h());
                    throw new IllegalArgumentException(sbU.toString());
                }
                if (iE < iE2) {
                    dVar = dVar3;
                }
            } else if (!clsG.isAssignableFrom(clsG2)) {
                if (clsG2.isAssignableFrom(clsG)) {
                    continue;
                }
            }
        }
        this.f687s = dVar.e();
        return dVar.a;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x001d  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0104  */
    @Override // b.g.a.c.c0.s
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public b.g.a.c.s o() {
        j jVar;
        h0 h0VarA;
        boolean z2;
        Boolean boolM;
        if (this.u == null) {
            h0 h0VarB = null;
            if (this.l) {
                d<j> dVar = this.f687s;
                if (dVar != null) {
                    jVar = dVar.a;
                } else {
                    d<g> dVar2 = this.q;
                    jVar = dVar2 != null ? dVar2.a : null;
                }
                if (jVar != null) {
                    this.u = b.g.a.c.s.l;
                } else {
                    Boolean boolA0 = this.n.a0(jVar);
                    String strW = this.n.w(jVar);
                    Integer numB = this.n.B(jVar);
                    String strV = this.n.v(jVar);
                    if (boolA0 == null && numB == null && strV == null) {
                        b.g.a.c.s sVar = b.g.a.c.s.l;
                        if (strW != null) {
                            sVar = new b.g.a.c.s(sVar._required, strW, sVar._index, sVar._defaultValue, sVar.m, sVar._valueNulls, sVar._contentNulls);
                        }
                        this.u = sVar;
                    } else {
                        b.g.a.c.s sVar2 = b.g.a.c.s.j;
                        this.u = (strW == null && numB == null && strV == null) ? boolA0 == null ? b.g.a.c.s.l : boolA0.booleanValue() ? b.g.a.c.s.j : b.g.a.c.s.k : new b.g.a.c.s(boolA0, strW, numB, strV, null, null, null);
                    }
                    if (!this.l) {
                        b.g.a.c.s sVarA = this.u;
                        i iVarJ = j();
                        b.g.a.c.b bVar = this.n;
                        if (bVar != null) {
                            if (iVarJ == null || (boolM = bVar.m(jVar)) == null) {
                                z2 = true;
                            } else {
                                if (boolM.booleanValue()) {
                                    sVarA = sVarA.a(new s.a(iVarJ, false));
                                }
                                z2 = false;
                            }
                            z.a aVarM = this.n.M(jVar);
                            if (aVarM != null) {
                                h0VarB = aVarM.b();
                                h0VarA = aVarM.a();
                            } else {
                                h0VarA = null;
                            }
                        } else {
                            h0VarA = null;
                            z2 = true;
                        }
                        if (z2 || h0VarB == null || h0VarA == null) {
                            if (jVar instanceof j) {
                                j jVar2 = (j) jVar;
                                Class<?> cls = jVar2.o() > 0 ? jVar2.n(0)._class : jVar.e()._class;
                                Objects.requireNonNull(this.m.f(cls));
                            }
                        }
                        if (z2 || h0VarB == null || h0VarA == null) {
                            z.a aVarL = this.m.l();
                            if (h0VarB == null) {
                                h0VarB = aVarL.b();
                            }
                            if (h0VarA == null) {
                                h0VarA = aVarL.a();
                            }
                            if (z2) {
                                if (Boolean.TRUE.equals(this.m.h()) && iVarJ != null) {
                                    sVarA = sVarA.a(new s.a(iVarJ, true));
                                }
                            }
                        }
                        h0 h0Var = h0VarB;
                        h0 h0Var2 = h0VarA;
                        if (h0Var != null || h0Var2 != null) {
                            sVarA = new b.g.a.c.s(sVarA._required, sVarA._description, sVarA._index, sVarA._defaultValue, sVarA.m, h0Var, h0Var2);
                        }
                        this.u = sVarA;
                    }
                }
            } else {
                d<m> dVar3 = this.r;
                if (dVar3 != null) {
                    jVar = dVar3.a;
                } else {
                    d<j> dVar4 = this.t;
                    if (dVar4 != null) {
                        jVar = dVar4.a;
                    } else {
                        d<g> dVar5 = this.q;
                        if (dVar5 != null) {
                            jVar = dVar5.a;
                        } else {
                            d<j> dVar6 = this.f687s;
                            if (dVar6 != null) {
                                jVar = dVar6.a;
                            }
                        }
                    }
                }
                if (jVar != null) {
                }
            }
        }
        return this.u;
    }

    @Override // b.g.a.c.c0.s
    public String p() {
        b.g.a.c.t tVar = this.o;
        if (tVar == null) {
            return null;
        }
        return tVar._simpleName;
    }

    @Override // b.g.a.c.c0.s
    public i q() {
        if (this.l) {
            return j();
        }
        i iVarK = k();
        if (iVarK == null && (iVarK = s()) == null) {
            iVarK = l();
        }
        return iVarK == null ? j() : iVarK;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x003d A[PHI: r0
      0x003d: PHI (r0v3 b.g.a.c.c0.b) = (r0v2 b.g.a.c.c0.b), (r0v5 b.g.a.c.c0.b) binds: [B:16:0x0030, B:18:0x0036] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // b.g.a.c.c0.s
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Class<?> r() {
        b.g.a.c.j jVarE;
        if (this.l) {
            b.g.a.c.c0.b bVarN = n();
            jVarE = (bVarN == null && (bVarN = l()) == null) ? b.g.a.c.h0.n.k() : bVarN.e();
        } else {
            b.g.a.c.c0.b bVarK = k();
            if (bVarK != null) {
                jVarE = (bVarK == null || (bVarK = n()) != null) ? bVarK.e() : b.g.a.c.h0.n.k();
            } else {
                j jVarS = s();
                if (jVarS != null) {
                    jVarE = jVarS.n(0);
                } else {
                    bVarK = l();
                    if (bVarK == null) {
                    }
                }
            }
        }
        return jVarE._class;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0055  */
    @Override // b.g.a.c.c0.s
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public j s() {
        d<j> dVar = this.t;
        if (dVar == null) {
            return null;
        }
        d<j> dVar2 = dVar.f688b;
        if (dVar2 == null) {
            return dVar.a;
        }
        for (d<j> dVar3 = dVar2; dVar3 != null; dVar3 = dVar3.f688b) {
            Class<?> clsG = dVar.a.g();
            Class<?> clsG2 = dVar3.a.g();
            if (clsG == clsG2) {
                j jVar = dVar3.a;
                j jVar2 = dVar.a;
                int I = I(jVar);
                int I2 = I(jVar2);
                if (I == I2) {
                    b.g.a.c.b bVar = this.n;
                    if (bVar != null) {
                        j jVarF0 = bVar.f0(this.m, jVar2, jVar);
                        if (jVarF0 != jVar2) {
                            if (jVarF0 != jVar) {
                            }
                            dVar = dVar3;
                        } else {
                            continue;
                        }
                    }
                    throw new IllegalArgumentException(String.format("Conflicting setter definitions for property \"%s\": %s vs %s", p(), dVar.a.h(), dVar3.a.h()));
                }
                if (I < I2) {
                    dVar = dVar3;
                }
            } else if (!clsG.isAssignableFrom(clsG2)) {
                if (clsG2.isAssignableFrom(clsG)) {
                    continue;
                }
            }
        }
        this.t = dVar.e();
        return dVar.a;
    }

    @Override // b.g.a.c.c0.s
    public b.g.a.c.t t() {
        b.g.a.c.b bVar;
        if (q() == null || (bVar = this.n) == null) {
            return null;
        }
        Objects.requireNonNull(bVar);
        return null;
    }

    public String toString() {
        StringBuilder sbU = b.d.b.a.a.U("[Property '");
        sbU.append(this.o);
        sbU.append("'; ctors: ");
        sbU.append(this.r);
        sbU.append(", field(s): ");
        sbU.append(this.q);
        sbU.append(", getter(s): ");
        sbU.append(this.f687s);
        sbU.append(", setter(s): ");
        sbU.append(this.t);
        sbU.append("]");
        return sbU.toString();
    }

    @Override // b.g.a.c.c0.s
    public boolean u() {
        return x(this.q) || x(this.f687s) || x(this.t) || w(this.r);
    }

    @Override // b.g.a.c.c0.s
    public boolean v() {
        Boolean bool = (Boolean) M(new c());
        return bool != null && bool.booleanValue();
    }

    public final <T> boolean w(d<T> dVar) {
        while (dVar != null) {
            if (dVar.c != null && dVar.d) {
                return true;
            }
            dVar = dVar.f688b;
        }
        return false;
    }

    public final <T> boolean x(d<T> dVar) {
        while (dVar != null) {
            b.g.a.c.t tVar = dVar.c;
            if (tVar != null && tVar.c()) {
                return true;
            }
            dVar = dVar.f688b;
        }
        return false;
    }

    public final <T> boolean y(d<T> dVar) {
        while (dVar != null) {
            if (dVar.f) {
                return true;
            }
            dVar = dVar.f688b;
        }
        return false;
    }

    public final <T> boolean z(d<T> dVar) {
        while (dVar != null) {
            if (dVar.e) {
                return true;
            }
            dVar = dVar.f688b;
        }
        return false;
    }

    public c0(b.g.a.c.z.l<?> lVar, b.g.a.c.b bVar, boolean z2, b.g.a.c.t tVar, b.g.a.c.t tVar2) {
        this.m = lVar;
        this.n = bVar;
        this.p = tVar;
        this.o = tVar2;
        this.l = z2;
    }

    public c0(c0 c0Var, b.g.a.c.t tVar) {
        this.m = c0Var.m;
        this.n = c0Var.n;
        this.p = c0Var.p;
        this.o = tVar;
        this.q = c0Var.q;
        this.r = c0Var.r;
        this.f687s = c0Var.f687s;
        this.t = c0Var.t;
        this.l = c0Var.l;
    }
}

package d0.e0.p.d.m0.e.a;

import d0.e0.p.d.m0.c.f1;
import java.util.HashMap;
import java.util.Map;

/* compiled from: JavaDescriptorVisibilities.java */
/* loaded from: classes3.dex */
public class w {
    public static final d0.e0.p.d.m0.c.u a;

    /* renamed from: b, reason: collision with root package name */
    public static final d0.e0.p.d.m0.c.u f3359b;
    public static final d0.e0.p.d.m0.c.u c;
    public static final Map<f1, d0.e0.p.d.m0.c.u> d;

    /* compiled from: JavaDescriptorVisibilities.java */
    public static class a extends d0.e0.p.d.m0.c.r {
        public a(f1 f1Var) {
            super(f1Var);
        }

        public static /* synthetic */ void a(int i) {
            Object[] objArr = new Object[3];
            if (i != 1) {
                objArr[0] = "what";
            } else {
                objArr[0] = "from";
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/load/java/JavaDescriptorVisibilities$1";
            objArr[2] = "isVisible";
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        @Override // d0.e0.p.d.m0.c.u
        public boolean isVisible(d0.e0.p.d.m0.k.a0.p.d dVar, d0.e0.p.d.m0.c.q qVar, d0.e0.p.d.m0.c.m mVar) {
            if (qVar == null) {
                a(0);
                throw null;
            }
            if (mVar != null) {
                return w.c(qVar, mVar);
            }
            a(1);
            throw null;
        }
    }

    /* compiled from: JavaDescriptorVisibilities.java */
    public static class b extends d0.e0.p.d.m0.c.r {
        public b(f1 f1Var) {
            super(f1Var);
        }

        public static /* synthetic */ void a(int i) {
            Object[] objArr = new Object[3];
            if (i != 1) {
                objArr[0] = "what";
            } else {
                objArr[0] = "from";
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/load/java/JavaDescriptorVisibilities$2";
            objArr[2] = "isVisible";
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        @Override // d0.e0.p.d.m0.c.u
        public boolean isVisible(d0.e0.p.d.m0.k.a0.p.d dVar, d0.e0.p.d.m0.c.q qVar, d0.e0.p.d.m0.c.m mVar) {
            if (qVar == null) {
                a(0);
                throw null;
            }
            if (mVar != null) {
                return w.b(dVar, qVar, mVar);
            }
            a(1);
            throw null;
        }
    }

    /* compiled from: JavaDescriptorVisibilities.java */
    public static class c extends d0.e0.p.d.m0.c.r {
        public c(f1 f1Var) {
            super(f1Var);
        }

        public static /* synthetic */ void a(int i) {
            Object[] objArr = new Object[3];
            if (i != 1) {
                objArr[0] = "what";
            } else {
                objArr[0] = "from";
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/load/java/JavaDescriptorVisibilities$3";
            objArr[2] = "isVisible";
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        @Override // d0.e0.p.d.m0.c.u
        public boolean isVisible(d0.e0.p.d.m0.k.a0.p.d dVar, d0.e0.p.d.m0.c.q qVar, d0.e0.p.d.m0.c.m mVar) {
            if (qVar == null) {
                a(0);
                throw null;
            }
            if (mVar != null) {
                return w.b(dVar, qVar, mVar);
            }
            a(1);
            throw null;
        }
    }

    static {
        a aVar = new a(d0.e0.p.d.m0.c.j1.a.c);
        a = aVar;
        b bVar = new b(d0.e0.p.d.m0.c.j1.c.c);
        f3359b = bVar;
        c cVar = new c(d0.e0.p.d.m0.c.j1.b.c);
        c = cVar;
        d = new HashMap();
        d(aVar);
        d(bVar);
        d(cVar);
    }

    public static /* synthetic */ void a(int i) {
        String str = (i == 5 || i == 6) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i == 5 || i == 6) ? 2 : 3];
        switch (i) {
            case 1:
                objArr[0] = "from";
                break;
            case 2:
                objArr[0] = "first";
                break;
            case 3:
                objArr[0] = "second";
                break;
            case 4:
                objArr[0] = "visibility";
                break;
            case 5:
            case 6:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/load/java/JavaDescriptorVisibilities";
                break;
            default:
                objArr[0] = "what";
                break;
        }
        if (i == 5 || i == 6) {
            objArr[1] = "toDescriptorVisibility";
        } else {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/load/java/JavaDescriptorVisibilities";
        }
        if (i == 2 || i == 3) {
            objArr[2] = "areInSamePackage";
        } else if (i == 4) {
            objArr[2] = "toDescriptorVisibility";
        } else if (i != 5 && i != 6) {
            objArr[2] = "isVisibleForProtectedAndPackage";
        }
        String str2 = String.format(str, objArr);
        if (i != 5 && i != 6) {
            throw new IllegalArgumentException(str2);
        }
        throw new IllegalStateException(str2);
    }

    public static boolean b(d0.e0.p.d.m0.k.a0.p.d dVar, d0.e0.p.d.m0.c.q qVar, d0.e0.p.d.m0.c.m mVar) {
        if (qVar == null) {
            a(0);
            throw null;
        }
        if (mVar == null) {
            a(1);
            throw null;
        }
        if (c(d0.e0.p.d.m0.k.e.unwrapFakeOverrideToAnyDeclaration(qVar), mVar)) {
            return true;
        }
        return d0.e0.p.d.m0.c.t.c.isVisible(dVar, qVar, mVar);
    }

    public static boolean c(d0.e0.p.d.m0.c.m mVar, d0.e0.p.d.m0.c.m mVar2) {
        if (mVar == null) {
            a(2);
            throw null;
        }
        if (mVar2 == null) {
            a(3);
            throw null;
        }
        d0.e0.p.d.m0.c.e0 e0Var = (d0.e0.p.d.m0.c.e0) d0.e0.p.d.m0.k.e.getParentOfType(mVar, d0.e0.p.d.m0.c.e0.class, false);
        d0.e0.p.d.m0.c.e0 e0Var2 = (d0.e0.p.d.m0.c.e0) d0.e0.p.d.m0.k.e.getParentOfType(mVar2, d0.e0.p.d.m0.c.e0.class, false);
        return (e0Var2 == null || e0Var == null || !e0Var.getFqName().equals(e0Var2.getFqName())) ? false : true;
    }

    public static void d(d0.e0.p.d.m0.c.u uVar) {
        d.put(uVar.getDelegate(), uVar);
    }

    public static d0.e0.p.d.m0.c.u toDescriptorVisibility(f1 f1Var) {
        if (f1Var == null) {
            a(4);
            throw null;
        }
        d0.e0.p.d.m0.c.u uVar = d.get(f1Var);
        if (uVar != null) {
            return uVar;
        }
        d0.e0.p.d.m0.c.u descriptorVisibility = d0.e0.p.d.m0.c.t.toDescriptorVisibility(f1Var);
        if (descriptorVisibility != null) {
            return descriptorVisibility;
        }
        a(5);
        throw null;
    }
}

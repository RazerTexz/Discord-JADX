package d0.e0.p.d.m0.c;

import d0.e0.p.d.m0.c.e1;
import d0.e0.p.d.m0.o.g;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.ServiceLoader;

/* compiled from: DescriptorVisibilities.java */
/* loaded from: classes3.dex */
public class t {
    public static final u a;

    /* renamed from: b, reason: collision with root package name */
    public static final u f3300b;
    public static final u c;
    public static final u d;
    public static final u e;
    public static final u f;
    public static final u g;
    public static final u h;
    public static final u i;
    public static final Map<u, Integer> j;
    public static final u k;
    public static final d0.e0.p.d.m0.k.a0.p.d l;
    public static final d0.e0.p.d.m0.k.a0.p.d m;

    @Deprecated
    public static final d0.e0.p.d.m0.k.a0.p.d n;
    public static final d0.e0.p.d.m0.o.g o;
    public static final Map<f1, u> p;

    /* compiled from: DescriptorVisibilities.java */
    public static class a implements d0.e0.p.d.m0.k.a0.p.d {
        @Override // d0.e0.p.d.m0.k.a0.p.d
        public d0.e0.p.d.m0.n.c0 getType() {
            throw new IllegalStateException("This method should not be called");
        }
    }

    /* compiled from: DescriptorVisibilities.java */
    public static class b implements d0.e0.p.d.m0.k.a0.p.d {
        @Override // d0.e0.p.d.m0.k.a0.p.d
        public d0.e0.p.d.m0.n.c0 getType() {
            throw new IllegalStateException("This method should not be called");
        }
    }

    /* compiled from: DescriptorVisibilities.java */
    public static class c implements d0.e0.p.d.m0.k.a0.p.d {
        @Override // d0.e0.p.d.m0.k.a0.p.d
        public d0.e0.p.d.m0.n.c0 getType() {
            throw new IllegalStateException("This method should not be called");
        }
    }

    /* compiled from: DescriptorVisibilities.java */
    public static class d extends r {
        public d(f1 f1Var) {
            super(f1Var);
        }

        public static /* synthetic */ void a(int i) {
            Object[] objArr = new Object[3];
            if (i == 1) {
                objArr[0] = "what";
            } else if (i != 2) {
                objArr[0] = "descriptor";
            } else {
                objArr[0] = "from";
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/DescriptorVisibilities$1";
            if (i == 1 || i == 2) {
                objArr[2] = "isVisible";
            } else {
                objArr[2] = "hasContainingSourceFile";
            }
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v0, types: [d0.e0.p.d.m0.c.m, d0.e0.p.d.m0.c.q] */
        /* JADX WARN: Type inference failed for: r5v2, types: [d0.e0.p.d.m0.c.m] */
        /* JADX WARN: Type inference failed for: r5v3, types: [d0.e0.p.d.m0.c.m] */
        /* JADX WARN: Type inference failed for: r5v4, types: [d0.e0.p.d.m0.c.m] */
        @Override // d0.e0.p.d.m0.c.u
        public boolean isVisible(d0.e0.p.d.m0.k.a0.p.d dVar, q qVar, m mVar) {
            if (qVar == 0) {
                a(1);
                throw null;
            }
            if (mVar == null) {
                a(2);
                throw null;
            }
            if (d0.e0.p.d.m0.k.e.isTopLevelDeclaration(qVar)) {
                if (mVar == null) {
                    a(0);
                    throw null;
                }
                if (d0.e0.p.d.m0.k.e.getContainingSourceFile(mVar) != v0.a) {
                    return t.inSameFile(qVar, mVar);
                }
            }
            if (qVar instanceof d0.e0.p.d.m0.c.l) {
                d0.e0.p.d.m0.c.i containingDeclaration = ((d0.e0.p.d.m0.c.l) qVar).getContainingDeclaration();
                if (d0.e0.p.d.m0.k.e.isSealedClass(containingDeclaration) && d0.e0.p.d.m0.k.e.isTopLevelDeclaration(containingDeclaration) && (mVar instanceof d0.e0.p.d.m0.c.l) && d0.e0.p.d.m0.k.e.isTopLevelDeclaration(mVar.getContainingDeclaration()) && t.inSameFile(qVar, mVar)) {
                    return true;
                }
            }
            while (qVar != 0) {
                qVar = qVar.getContainingDeclaration();
                if (((qVar instanceof d0.e0.p.d.m0.c.e) && !d0.e0.p.d.m0.k.e.isCompanionObject(qVar)) || (qVar instanceof e0)) {
                    break;
                }
            }
            if (qVar == 0) {
                return false;
            }
            while (mVar != null) {
                if (qVar == mVar) {
                    return true;
                }
                if (mVar instanceof e0) {
                    return (qVar instanceof e0) && qVar.getFqName().equals(((e0) mVar).getFqName()) && d0.e0.p.d.m0.k.e.areInSameModule(mVar, qVar);
                }
                mVar = mVar.getContainingDeclaration();
            }
            return false;
        }
    }

    /* compiled from: DescriptorVisibilities.java */
    public static class e extends r {
        public e(f1 f1Var) {
            super(f1Var);
        }

        public static /* synthetic */ void a(int i) {
            Object[] objArr = new Object[3];
            if (i != 1) {
                objArr[0] = "what";
            } else {
                objArr[0] = "from";
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/DescriptorVisibilities$2";
            objArr[2] = "isVisible";
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        @Override // d0.e0.p.d.m0.c.u
        public boolean isVisible(d0.e0.p.d.m0.k.a0.p.d dVar, q qVar, m mVar) {
            m parentOfType;
            if (qVar == null) {
                a(0);
                throw null;
            }
            if (mVar == null) {
                a(1);
                throw null;
            }
            if (t.a.isVisible(dVar, qVar, mVar)) {
                if (dVar == t.m) {
                    return true;
                }
                if (dVar != t.l && (parentOfType = d0.e0.p.d.m0.k.e.getParentOfType(qVar, d0.e0.p.d.m0.c.e.class)) != null && (dVar instanceof d0.e0.p.d.m0.k.a0.p.f)) {
                    return ((d0.e0.p.d.m0.k.a0.p.f) dVar).getClassDescriptor().getOriginal().equals(parentOfType.getOriginal());
                }
            }
            return false;
        }
    }

    /* compiled from: DescriptorVisibilities.java */
    public static class f extends r {
        public f(f1 f1Var) {
            super(f1Var);
        }

        public static /* synthetic */ void a(int i) {
            Object[] objArr = new Object[3];
            if (i == 1) {
                objArr[0] = "from";
            } else if (i == 2) {
                objArr[0] = "whatDeclaration";
            } else if (i != 3) {
                objArr[0] = "what";
            } else {
                objArr[0] = "fromClass";
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/DescriptorVisibilities$3";
            if (i == 2 || i == 3) {
                objArr[2] = "doesReceiverFitForProtectedVisibility";
            } else {
                objArr[2] = "isVisible";
            }
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        /* JADX WARN: Removed duplicated region for block: B:47:0x007b  */
        @Override // d0.e0.p.d.m0.c.u
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public boolean isVisible(d0.e0.p.d.m0.k.a0.p.d dVar, q qVar, m mVar) {
            d0.e0.p.d.m0.c.e eVar;
            boolean z2 = false;
            if (qVar == null) {
                a(0);
                throw null;
            }
            if (mVar == null) {
                a(1);
                throw null;
            }
            d0.e0.p.d.m0.c.e eVar2 = (d0.e0.p.d.m0.c.e) d0.e0.p.d.m0.k.e.getParentOfType(qVar, d0.e0.p.d.m0.c.e.class);
            d0.e0.p.d.m0.c.e eVar3 = (d0.e0.p.d.m0.c.e) d0.e0.p.d.m0.k.e.getParentOfType(mVar, d0.e0.p.d.m0.c.e.class, false);
            if (eVar3 == null) {
                return false;
            }
            if (eVar2 != null && d0.e0.p.d.m0.k.e.isCompanionObject(eVar2) && (eVar = (d0.e0.p.d.m0.c.e) d0.e0.p.d.m0.k.e.getParentOfType(eVar2, d0.e0.p.d.m0.c.e.class)) != null && d0.e0.p.d.m0.k.e.isSubclass(eVar3, eVar)) {
                return true;
            }
            q qVarUnwrapFakeOverrideToAnyDeclaration = d0.e0.p.d.m0.k.e.unwrapFakeOverrideToAnyDeclaration(qVar);
            d0.e0.p.d.m0.c.e eVar4 = (d0.e0.p.d.m0.c.e) d0.e0.p.d.m0.k.e.getParentOfType(qVarUnwrapFakeOverrideToAnyDeclaration, d0.e0.p.d.m0.c.e.class);
            if (eVar4 == null) {
                return false;
            }
            if (d0.e0.p.d.m0.k.e.isSubclass(eVar3, eVar4)) {
                if (qVarUnwrapFakeOverrideToAnyDeclaration == null) {
                    a(2);
                    throw null;
                }
                if (dVar != t.n) {
                    if ((qVarUnwrapFakeOverrideToAnyDeclaration instanceof d0.e0.p.d.m0.c.b) && !(qVarUnwrapFakeOverrideToAnyDeclaration instanceof d0.e0.p.d.m0.c.l) && dVar != t.m) {
                        if (dVar != t.l && dVar != null) {
                            d0.e0.p.d.m0.n.c0 thisType = dVar instanceof d0.e0.p.d.m0.k.a0.p.e ? ((d0.e0.p.d.m0.k.a0.p.e) dVar).getThisType() : dVar.getType();
                            if (d0.e0.p.d.m0.k.e.isSubtypeOfClass(thisType, eVar3) || d0.e0.p.d.m0.n.r.isDynamic(thisType)) {
                                z2 = true;
                            }
                        }
                    }
                }
                if (z2) {
                    return true;
                }
            }
            return isVisible(dVar, qVar, eVar3.getContainingDeclaration());
        }
    }

    /* compiled from: DescriptorVisibilities.java */
    public static class g extends r {
        public g(f1 f1Var) {
            super(f1Var);
        }

        public static /* synthetic */ void a(int i) {
            Object[] objArr = new Object[3];
            if (i != 1) {
                objArr[0] = "what";
            } else {
                objArr[0] = "from";
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/DescriptorVisibilities$4";
            objArr[2] = "isVisible";
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        @Override // d0.e0.p.d.m0.c.u
        public boolean isVisible(d0.e0.p.d.m0.k.a0.p.d dVar, q qVar, m mVar) {
            if (qVar == null) {
                a(0);
                throw null;
            }
            if (mVar == null) {
                a(1);
                throw null;
            }
            if (d0.e0.p.d.m0.k.e.getContainingModule(mVar).shouldSeeInternalsOf(d0.e0.p.d.m0.k.e.getContainingModule(qVar))) {
                return t.o.isInFriendModule(qVar, mVar);
            }
            return false;
        }
    }

    /* compiled from: DescriptorVisibilities.java */
    public static class h extends r {
        public h(f1 f1Var) {
            super(f1Var);
        }

        public static /* synthetic */ void a(int i) {
            Object[] objArr = new Object[3];
            if (i != 1) {
                objArr[0] = "what";
            } else {
                objArr[0] = "from";
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/DescriptorVisibilities$5";
            objArr[2] = "isVisible";
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        @Override // d0.e0.p.d.m0.c.u
        public boolean isVisible(d0.e0.p.d.m0.k.a0.p.d dVar, q qVar, m mVar) {
            if (qVar == null) {
                a(0);
                throw null;
            }
            if (mVar != null) {
                return true;
            }
            a(1);
            throw null;
        }
    }

    /* compiled from: DescriptorVisibilities.java */
    public static class i extends r {
        public i(f1 f1Var) {
            super(f1Var);
        }

        public static /* synthetic */ void a(int i) {
            Object[] objArr = new Object[3];
            if (i != 1) {
                objArr[0] = "what";
            } else {
                objArr[0] = "from";
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/DescriptorVisibilities$6";
            objArr[2] = "isVisible";
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        @Override // d0.e0.p.d.m0.c.u
        public boolean isVisible(d0.e0.p.d.m0.k.a0.p.d dVar, q qVar, m mVar) {
            if (qVar == null) {
                a(0);
                throw null;
            }
            if (mVar != null) {
                throw new IllegalStateException("This method shouldn't be invoked for LOCAL visibility");
            }
            a(1);
            throw null;
        }
    }

    /* compiled from: DescriptorVisibilities.java */
    public static class j extends r {
        public j(f1 f1Var) {
            super(f1Var);
        }

        public static /* synthetic */ void a(int i) {
            Object[] objArr = new Object[3];
            if (i != 1) {
                objArr[0] = "what";
            } else {
                objArr[0] = "from";
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/DescriptorVisibilities$7";
            objArr[2] = "isVisible";
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        @Override // d0.e0.p.d.m0.c.u
        public boolean isVisible(d0.e0.p.d.m0.k.a0.p.d dVar, q qVar, m mVar) {
            if (qVar == null) {
                a(0);
                throw null;
            }
            if (mVar != null) {
                throw new IllegalStateException("Visibility is unknown yet");
            }
            a(1);
            throw null;
        }
    }

    /* compiled from: DescriptorVisibilities.java */
    public static class k extends r {
        public k(f1 f1Var) {
            super(f1Var);
        }

        public static /* synthetic */ void a(int i) {
            Object[] objArr = new Object[3];
            if (i != 1) {
                objArr[0] = "what";
            } else {
                objArr[0] = "from";
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/DescriptorVisibilities$8";
            objArr[2] = "isVisible";
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        @Override // d0.e0.p.d.m0.c.u
        public boolean isVisible(d0.e0.p.d.m0.k.a0.p.d dVar, q qVar, m mVar) {
            if (qVar == null) {
                a(0);
                throw null;
            }
            if (mVar != null) {
                return false;
            }
            a(1);
            throw null;
        }
    }

    /* compiled from: DescriptorVisibilities.java */
    public static class l extends r {
        public l(f1 f1Var) {
            super(f1Var);
        }

        public static /* synthetic */ void a(int i) {
            Object[] objArr = new Object[3];
            if (i != 1) {
                objArr[0] = "what";
            } else {
                objArr[0] = "from";
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/DescriptorVisibilities$9";
            objArr[2] = "isVisible";
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        @Override // d0.e0.p.d.m0.c.u
        public boolean isVisible(d0.e0.p.d.m0.k.a0.p.d dVar, q qVar, m mVar) {
            if (qVar == null) {
                a(0);
                throw null;
            }
            if (mVar != null) {
                return false;
            }
            a(1);
            throw null;
        }
    }

    static {
        d dVar = new d(e1.e.c);
        a = dVar;
        e eVar = new e(e1.f.c);
        f3300b = eVar;
        f fVar = new f(e1.g.c);
        c = fVar;
        g gVar = new g(e1.b.c);
        d = gVar;
        h hVar = new h(e1.h.c);
        e = hVar;
        i iVar = new i(e1.d.c);
        f = iVar;
        j jVar = new j(e1.a.c);
        g = jVar;
        k kVar = new k(e1.c.c);
        h = kVar;
        l lVar = new l(e1.i.c);
        i = lVar;
        Collections.unmodifiableSet(d0.t.n0.setOf((Object[]) new u[]{dVar, eVar, gVar, iVar}));
        HashMap mapNewHashMapWithExpectedSize = d0.e0.p.d.m0.p.a.newHashMapWithExpectedSize(4);
        mapNewHashMapWithExpectedSize.put(eVar, 0);
        mapNewHashMapWithExpectedSize.put(dVar, 0);
        mapNewHashMapWithExpectedSize.put(gVar, 1);
        mapNewHashMapWithExpectedSize.put(fVar, 1);
        mapNewHashMapWithExpectedSize.put(hVar, 2);
        j = Collections.unmodifiableMap(mapNewHashMapWithExpectedSize);
        k = hVar;
        l = new a();
        m = new b();
        n = new c();
        Iterator it = ServiceLoader.load(d0.e0.p.d.m0.o.g.class, d0.e0.p.d.m0.o.g.class.getClassLoader()).iterator();
        o = it.hasNext() ? (d0.e0.p.d.m0.o.g) it.next() : g.a.a;
        p = new HashMap();
        b(dVar);
        b(eVar);
        b(fVar);
        b(gVar);
        b(hVar);
        b(iVar);
        b(jVar);
        b(kVar);
        b(lVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x003a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static /* synthetic */ void a(int i2) {
        String str = i2 != 16 ? "Argument for @NotNull parameter '%s' of %s.%s must not be null" : "@NotNull method %s.%s must not return null";
        Object[] objArr = new Object[i2 != 16 ? 3 : 2];
        if (i2 != 1 && i2 != 3 && i2 != 5 && i2 != 7) {
            switch (i2) {
                case 9:
                    break;
                case 10:
                case 12:
                    objArr[0] = "first";
                    break;
                case 11:
                case 13:
                    objArr[0] = "second";
                    break;
                case 14:
                case 15:
                    objArr[0] = "visibility";
                    break;
                case 16:
                    objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/DescriptorVisibilities";
                    break;
                default:
                    objArr[0] = "what";
                    break;
            }
        } else {
            objArr[0] = "from";
        }
        if (i2 != 16) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/DescriptorVisibilities";
        } else {
            objArr[1] = "toDescriptorVisibility";
        }
        switch (i2) {
            case 2:
            case 3:
                objArr[2] = "isVisibleIgnoringReceiver";
                break;
            case 4:
            case 5:
                objArr[2] = "isVisibleWithAnyReceiver";
                break;
            case 6:
            case 7:
                objArr[2] = "inSameFile";
                break;
            case 8:
            case 9:
                objArr[2] = "findInvisibleMember";
                break;
            case 10:
            case 11:
                objArr[2] = "compareLocal";
                break;
            case 12:
            case 13:
                objArr[2] = "compare";
                break;
            case 14:
                objArr[2] = "isPrivate";
                break;
            case 15:
                objArr[2] = "toDescriptorVisibility";
                break;
            case 16:
                break;
            default:
                objArr[2] = "isVisible";
                break;
        }
        String str2 = String.format(str, objArr);
        if (i2 == 16) {
            throw new IllegalStateException(str2);
        }
    }

    public static void b(u uVar) {
        p.put(uVar.getDelegate(), uVar);
    }

    public static Integer compare(u uVar, u uVar2) {
        if (uVar == null) {
            a(12);
            throw null;
        }
        if (uVar2 == null) {
            a(13);
            throw null;
        }
        Integer numCompareTo = uVar.compareTo(uVar2);
        if (numCompareTo != null) {
            return numCompareTo;
        }
        Integer numCompareTo2 = uVar2.compareTo(uVar);
        if (numCompareTo2 != null) {
            return Integer.valueOf(-numCompareTo2.intValue());
        }
        return null;
    }

    public static q findInvisibleMember(d0.e0.p.d.m0.k.a0.p.d dVar, q qVar, m mVar) {
        q qVarFindInvisibleMember;
        if (qVar == null) {
            a(8);
            throw null;
        }
        if (mVar == null) {
            a(9);
            throw null;
        }
        for (q qVar2 = (q) qVar.getOriginal(); qVar2 != null && qVar2.getVisibility() != f; qVar2 = (q) d0.e0.p.d.m0.k.e.getParentOfType(qVar2, q.class)) {
            if (!qVar2.getVisibility().isVisible(dVar, qVar2, mVar)) {
                return qVar2;
            }
        }
        if (!(qVar instanceof d0.e0.p.d.m0.c.i1.i0) || (qVarFindInvisibleMember = findInvisibleMember(dVar, ((d0.e0.p.d.m0.c.i1.i0) qVar).getUnderlyingConstructorDescriptor(), mVar)) == null) {
            return null;
        }
        return qVarFindInvisibleMember;
    }

    public static boolean inSameFile(m mVar, m mVar2) {
        if (mVar == null) {
            a(6);
            throw null;
        }
        if (mVar2 == null) {
            a(7);
            throw null;
        }
        v0 containingSourceFile = d0.e0.p.d.m0.k.e.getContainingSourceFile(mVar2);
        if (containingSourceFile != v0.a) {
            return containingSourceFile.equals(d0.e0.p.d.m0.k.e.getContainingSourceFile(mVar));
        }
        return false;
    }

    public static boolean isPrivate(u uVar) {
        if (uVar != null) {
            return uVar == a || uVar == f3300b;
        }
        a(14);
        throw null;
    }

    public static boolean isVisibleIgnoringReceiver(q qVar, m mVar) {
        if (qVar == null) {
            a(2);
            throw null;
        }
        if (mVar != null) {
            return findInvisibleMember(m, qVar, mVar) == null;
        }
        a(3);
        throw null;
    }

    public static u toDescriptorVisibility(f1 f1Var) {
        if (f1Var == null) {
            a(15);
            throw null;
        }
        u uVar = p.get(f1Var);
        if (uVar != null) {
            return uVar;
        }
        throw new IllegalArgumentException("Inapplicable visibility: " + f1Var);
    }
}

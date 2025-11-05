package d0.e0.p.d.m0.c.i1;

import com.discord.models.domain.ModelAuditLogEntry;
import d0.e0.p.d.m0.c.t0;
import d0.e0.p.d.m0.c.z0;
import d0.e0.p.d.m0.k.a0.i;
import d0.e0.p.d.m0.m.f;
import d0.e0.p.d.m0.n.u0;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* compiled from: EnumEntrySyntheticClassDescriptor.java */
/* loaded from: classes3.dex */
public class o extends h {
    public final u0 r;

    /* renamed from: s, reason: collision with root package name */
    public final d0.e0.p.d.m0.k.a0.i f3269s;
    public final d0.e0.p.d.m0.m.j<Set<d0.e0.p.d.m0.g.e>> t;
    public final d0.e0.p.d.m0.c.g1.g u;

    /* compiled from: EnumEntrySyntheticClassDescriptor.java */
    public class a extends d0.e0.p.d.m0.k.a0.j {

        /* renamed from: b, reason: collision with root package name */
        public final d0.e0.p.d.m0.m.h<d0.e0.p.d.m0.g.e, Collection<? extends t0>> f3270b;
        public final d0.e0.p.d.m0.m.h<d0.e0.p.d.m0.g.e, Collection<? extends d0.e0.p.d.m0.c.n0>> c;
        public final d0.e0.p.d.m0.m.j<Collection<d0.e0.p.d.m0.c.m>> d;
        public final /* synthetic */ o e;

        /* compiled from: EnumEntrySyntheticClassDescriptor.java */
        /* renamed from: d0.e0.p.d.m0.c.i1.o$a$a, reason: collision with other inner class name */
        public class C0516a implements Function1<d0.e0.p.d.m0.g.e, Collection<? extends t0>> {
            public C0516a(o oVar) {
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Collection<? extends t0> invoke(d0.e0.p.d.m0.g.e eVar) {
                return invoke2(eVar);
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public Collection<? extends t0> invoke2(d0.e0.p.d.m0.g.e eVar) {
                a aVar = a.this;
                Objects.requireNonNull(aVar);
                if (eVar != null) {
                    return aVar.c(eVar, aVar.b().getContributedFunctions(eVar, d0.e0.p.d.m0.d.b.d.FOR_NON_TRACKED_SCOPE));
                }
                a.a(8);
                throw null;
            }
        }

        /* compiled from: EnumEntrySyntheticClassDescriptor.java */
        public class b implements Function1<d0.e0.p.d.m0.g.e, Collection<? extends d0.e0.p.d.m0.c.n0>> {
            public b(o oVar) {
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Collection<? extends d0.e0.p.d.m0.c.n0> invoke(d0.e0.p.d.m0.g.e eVar) {
                return invoke2(eVar);
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public Collection<? extends d0.e0.p.d.m0.c.n0> invoke2(d0.e0.p.d.m0.g.e eVar) {
                a aVar = a.this;
                Objects.requireNonNull(aVar);
                if (eVar != null) {
                    return aVar.c(eVar, aVar.b().getContributedVariables(eVar, d0.e0.p.d.m0.d.b.d.FOR_NON_TRACKED_SCOPE));
                }
                a.a(4);
                throw null;
            }
        }

        /* compiled from: EnumEntrySyntheticClassDescriptor.java */
        public class c implements Function0<Collection<d0.e0.p.d.m0.c.m>> {
            public c(o oVar) {
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Collection<d0.e0.p.d.m0.c.m> invoke() {
                return invoke2();
            }

            @Override // kotlin.jvm.functions.Function0
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public Collection<d0.e0.p.d.m0.c.m> invoke2() {
                a aVar = a.this;
                Objects.requireNonNull(aVar);
                HashSet hashSet = new HashSet();
                for (d0.e0.p.d.m0.g.e eVar : aVar.e.t.invoke()) {
                    d0.e0.p.d.m0.d.b.d dVar = d0.e0.p.d.m0.d.b.d.FOR_NON_TRACKED_SCOPE;
                    hashSet.addAll(aVar.getContributedFunctions(eVar, dVar));
                    hashSet.addAll(aVar.getContributedVariables(eVar, dVar));
                }
                return hashSet;
            }
        }

        /* compiled from: EnumEntrySyntheticClassDescriptor.java */
        public class d extends d0.e0.p.d.m0.k.i {
            public final /* synthetic */ Set a;

            public d(a aVar, Set set) {
                this.a = set;
            }

            public static /* synthetic */ void a(int i) {
                Object[] objArr = new Object[3];
                if (i == 1) {
                    objArr[0] = "fromSuper";
                } else if (i != 2) {
                    objArr[0] = "fakeOverride";
                } else {
                    objArr[0] = "fromCurrent";
                }
                objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/EnumEntrySyntheticClassDescriptor$EnumEntryScope$4";
                if (i == 1 || i == 2) {
                    objArr[2] = "conflict";
                } else {
                    objArr[2] = "addFakeOverride";
                }
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
            }

            @Override // d0.e0.p.d.m0.k.j
            public void addFakeOverride(d0.e0.p.d.m0.c.b bVar) {
                if (bVar == null) {
                    a(0);
                    throw null;
                }
                d0.e0.p.d.m0.k.k.resolveUnknownVisibilityForMember(bVar, null);
                this.a.add(bVar);
            }

            @Override // d0.e0.p.d.m0.k.i
            public void conflict(d0.e0.p.d.m0.c.b bVar, d0.e0.p.d.m0.c.b bVar2) {
                if (bVar == null) {
                    a(1);
                    throw null;
                }
                if (bVar2 != null) {
                    return;
                }
                a(2);
                throw null;
            }
        }

        public a(o oVar, d0.e0.p.d.m0.m.o oVar2) {
            if (oVar2 == null) {
                a(0);
                throw null;
            }
            this.e = oVar;
            this.f3270b = oVar2.createMemoizedFunction(new C0516a(oVar));
            this.c = oVar2.createMemoizedFunction(new b(oVar));
            this.d = oVar2.createLazyValue(new c(oVar));
        }

        /* JADX WARN: Removed duplicated region for block: B:17:0x0024  */
        /* JADX WARN: Removed duplicated region for block: B:9:0x0014  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public static /* synthetic */ void a(int i) {
            String str;
            int i2;
            if (i != 3 && i != 7 && i != 9 && i != 12) {
                switch (i) {
                    case 15:
                    case 16:
                    case 17:
                    case 18:
                    case 19:
                        break;
                    default:
                        str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                        break;
                }
            } else {
                str = "@NotNull method %s.%s must not return null";
            }
            if (i != 3 && i != 7 && i != 9 && i != 12) {
                switch (i) {
                    case 15:
                    case 16:
                    case 17:
                    case 18:
                    case 19:
                        break;
                    default:
                        i2 = 3;
                        break;
                }
            } else {
                i2 = 2;
            }
            Object[] objArr = new Object[i2];
            switch (i) {
                case 1:
                case 4:
                case 5:
                case 8:
                case 10:
                    objArr[0] = ModelAuditLogEntry.CHANGE_KEY_NAME;
                    break;
                case 2:
                case 6:
                    objArr[0] = ModelAuditLogEntry.CHANGE_KEY_LOCATION;
                    break;
                case 3:
                case 7:
                case 9:
                case 12:
                case 15:
                case 16:
                case 17:
                case 18:
                case 19:
                    objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/EnumEntrySyntheticClassDescriptor$EnumEntryScope";
                    break;
                case 11:
                    objArr[0] = "fromSupertypes";
                    break;
                case 13:
                    objArr[0] = "kindFilter";
                    break;
                case 14:
                    objArr[0] = "nameFilter";
                    break;
                case 20:
                    objArr[0] = "p";
                    break;
                default:
                    objArr[0] = "storageManager";
                    break;
            }
            if (i == 3) {
                objArr[1] = "getContributedVariables";
            } else if (i == 7) {
                objArr[1] = "getContributedFunctions";
            } else if (i == 9) {
                objArr[1] = "getSupertypeScope";
            } else if (i != 12) {
                switch (i) {
                    case 15:
                        objArr[1] = "getContributedDescriptors";
                        break;
                    case 16:
                        objArr[1] = "computeAllDeclarations";
                        break;
                    case 17:
                        objArr[1] = "getFunctionNames";
                        break;
                    case 18:
                        objArr[1] = "getClassifierNames";
                        break;
                    case 19:
                        objArr[1] = "getVariableNames";
                        break;
                    default:
                        objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/EnumEntrySyntheticClassDescriptor$EnumEntryScope";
                        break;
                }
            } else {
                objArr[1] = "resolveFakeOverrides";
            }
            switch (i) {
                case 1:
                case 2:
                    objArr[2] = "getContributedVariables";
                    break;
                case 3:
                case 7:
                case 9:
                case 12:
                case 15:
                case 16:
                case 17:
                case 18:
                case 19:
                    break;
                case 4:
                    objArr[2] = "computeProperties";
                    break;
                case 5:
                case 6:
                    objArr[2] = "getContributedFunctions";
                    break;
                case 8:
                    objArr[2] = "computeFunctions";
                    break;
                case 10:
                case 11:
                    objArr[2] = "resolveFakeOverrides";
                    break;
                case 13:
                case 14:
                    objArr[2] = "getContributedDescriptors";
                    break;
                case 20:
                    objArr[2] = "printScopeStructure";
                    break;
                default:
                    objArr[2] = "<init>";
                    break;
            }
            String str2 = String.format(str, objArr);
            if (i != 3 && i != 7 && i != 9 && i != 12) {
                switch (i) {
                    case 15:
                    case 16:
                    case 17:
                    case 18:
                    case 19:
                        break;
                    default:
                        throw new IllegalArgumentException(str2);
                }
            }
            throw new IllegalStateException(str2);
        }

        public final d0.e0.p.d.m0.k.a0.i b() {
            d0.e0.p.d.m0.k.a0.i memberScope = this.e.getTypeConstructor().getSupertypes().iterator().next().getMemberScope();
            if (memberScope != null) {
                return memberScope;
            }
            a(9);
            throw null;
        }

        public final <D extends d0.e0.p.d.m0.c.b> Collection<? extends D> c(d0.e0.p.d.m0.g.e eVar, Collection<? extends D> collection) {
            if (eVar == null) {
                a(10);
                throw null;
            }
            if (collection == null) {
                a(11);
                throw null;
            }
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            d0.e0.p.d.m0.k.k.f3468b.generateOverridesInFunctionGroup(eVar, collection, Collections.emptySet(), this.e, new d(this, linkedHashSet));
            return linkedHashSet;
        }

        @Override // d0.e0.p.d.m0.k.a0.j, d0.e0.p.d.m0.k.a0.i
        public Set<d0.e0.p.d.m0.g.e> getClassifierNames() {
            Set<d0.e0.p.d.m0.g.e> setEmptySet = Collections.emptySet();
            if (setEmptySet != null) {
                return setEmptySet;
            }
            a(18);
            throw null;
        }

        @Override // d0.e0.p.d.m0.k.a0.j, d0.e0.p.d.m0.k.a0.l
        public Collection<d0.e0.p.d.m0.c.m> getContributedDescriptors(d0.e0.p.d.m0.k.a0.d dVar, Function1<? super d0.e0.p.d.m0.g.e, Boolean> function1) {
            if (dVar == null) {
                a(13);
                throw null;
            }
            if (function1 == null) {
                a(14);
                throw null;
            }
            Collection<d0.e0.p.d.m0.c.m> collectionInvoke = this.d.invoke();
            if (collectionInvoke != null) {
                return collectionInvoke;
            }
            a(15);
            throw null;
        }

        @Override // d0.e0.p.d.m0.k.a0.j, d0.e0.p.d.m0.k.a0.i
        public Collection<? extends t0> getContributedFunctions(d0.e0.p.d.m0.g.e eVar, d0.e0.p.d.m0.d.b.b bVar) {
            if (eVar == null) {
                a(5);
                throw null;
            }
            if (bVar == null) {
                a(6);
                throw null;
            }
            Collection<? extends t0> collection = (Collection) ((f.m) this.f3270b).invoke(eVar);
            if (collection != null) {
                return collection;
            }
            a(7);
            throw null;
        }

        @Override // d0.e0.p.d.m0.k.a0.j, d0.e0.p.d.m0.k.a0.i
        public Collection<? extends d0.e0.p.d.m0.c.n0> getContributedVariables(d0.e0.p.d.m0.g.e eVar, d0.e0.p.d.m0.d.b.b bVar) {
            if (eVar == null) {
                a(1);
                throw null;
            }
            if (bVar == null) {
                a(2);
                throw null;
            }
            Collection<? extends d0.e0.p.d.m0.c.n0> collection = (Collection) ((f.m) this.c).invoke(eVar);
            if (collection != null) {
                return collection;
            }
            a(3);
            throw null;
        }

        @Override // d0.e0.p.d.m0.k.a0.j, d0.e0.p.d.m0.k.a0.i
        public Set<d0.e0.p.d.m0.g.e> getFunctionNames() {
            Set<d0.e0.p.d.m0.g.e> setInvoke = this.e.t.invoke();
            if (setInvoke != null) {
                return setInvoke;
            }
            a(17);
            throw null;
        }

        @Override // d0.e0.p.d.m0.k.a0.j, d0.e0.p.d.m0.k.a0.i
        public Set<d0.e0.p.d.m0.g.e> getVariableNames() {
            Set<d0.e0.p.d.m0.g.e> setInvoke = this.e.t.invoke();
            if (setInvoke != null) {
                return setInvoke;
            }
            a(19);
            throw null;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o(d0.e0.p.d.m0.m.o oVar, d0.e0.p.d.m0.c.e eVar, d0.e0.p.d.m0.n.c0 c0Var, d0.e0.p.d.m0.g.e eVar2, d0.e0.p.d.m0.m.j<Set<d0.e0.p.d.m0.g.e>> jVar, d0.e0.p.d.m0.c.g1.g gVar, d0.e0.p.d.m0.c.u0 u0Var) {
        super(oVar, eVar, eVar2, u0Var, false);
        if (oVar == null) {
            a(6);
            throw null;
        }
        if (c0Var == null) {
            a(8);
            throw null;
        }
        if (eVar2 == null) {
            a(9);
            throw null;
        }
        if (jVar == null) {
            a(10);
            throw null;
        }
        if (gVar == null) {
            a(11);
            throw null;
        }
        if (u0Var == null) {
            a(12);
            throw null;
        }
        this.u = gVar;
        this.r = new d0.e0.p.d.m0.n.i(this, Collections.emptyList(), Collections.singleton(c0Var), oVar);
        this.f3269s = new a(this, oVar);
        this.t = jVar;
    }

    public static /* synthetic */ void a(int i) {
        String str;
        int i2;
        switch (i) {
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
                str = "@NotNull method %s.%s must not return null";
                break;
            default:
                str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                break;
        }
        switch (i) {
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
                i2 = 2;
                break;
            default:
                i2 = 3;
                break;
        }
        Object[] objArr = new Object[i2];
        switch (i) {
            case 1:
                objArr[0] = "enumClass";
                break;
            case 2:
            case 9:
                objArr[0] = ModelAuditLogEntry.CHANGE_KEY_NAME;
                break;
            case 3:
            case 10:
                objArr[0] = "enumMemberNames";
                break;
            case 4:
            case 11:
                objArr[0] = "annotations";
                break;
            case 5:
            case 12:
                objArr[0] = "source";
                break;
            case 6:
            default:
                objArr[0] = "storageManager";
                break;
            case 7:
                objArr[0] = "containingClass";
                break;
            case 8:
                objArr[0] = "supertype";
                break;
            case 13:
                objArr[0] = "kotlinTypeRefiner";
                break;
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/EnumEntrySyntheticClassDescriptor";
                break;
        }
        switch (i) {
            case 14:
                objArr[1] = "getUnsubstitutedMemberScope";
                break;
            case 15:
                objArr[1] = "getStaticScope";
                break;
            case 16:
                objArr[1] = "getConstructors";
                break;
            case 17:
                objArr[1] = "getTypeConstructor";
                break;
            case 18:
                objArr[1] = "getKind";
                break;
            case 19:
                objArr[1] = "getModality";
                break;
            case 20:
                objArr[1] = "getVisibility";
                break;
            case 21:
                objArr[1] = "getAnnotations";
                break;
            case 22:
                objArr[1] = "getDeclaredTypeParameters";
                break;
            case 23:
                objArr[1] = "getSealedSubclasses";
                break;
            default:
                objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/EnumEntrySyntheticClassDescriptor";
                break;
        }
        switch (i) {
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
                objArr[2] = "<init>";
                break;
            case 13:
                objArr[2] = "getUnsubstitutedMemberScope";
                break;
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
                break;
            default:
                objArr[2] = "create";
                break;
        }
        String str2 = String.format(str, objArr);
        switch (i) {
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
                throw new IllegalStateException(str2);
            default:
                throw new IllegalArgumentException(str2);
        }
    }

    public static o create(d0.e0.p.d.m0.m.o oVar, d0.e0.p.d.m0.c.e eVar, d0.e0.p.d.m0.g.e eVar2, d0.e0.p.d.m0.m.j<Set<d0.e0.p.d.m0.g.e>> jVar, d0.e0.p.d.m0.c.g1.g gVar, d0.e0.p.d.m0.c.u0 u0Var) {
        if (oVar == null) {
            a(0);
            throw null;
        }
        if (eVar == null) {
            a(1);
            throw null;
        }
        if (eVar2 == null) {
            a(2);
            throw null;
        }
        if (jVar == null) {
            a(3);
            throw null;
        }
        if (gVar == null) {
            a(4);
            throw null;
        }
        if (u0Var != null) {
            return new o(oVar, eVar, eVar.getDefaultType(), eVar2, jVar, gVar, u0Var);
        }
        a(5);
        throw null;
    }

    @Override // d0.e0.p.d.m0.c.g1.a
    public d0.e0.p.d.m0.c.g1.g getAnnotations() {
        d0.e0.p.d.m0.c.g1.g gVar = this.u;
        if (gVar != null) {
            return gVar;
        }
        a(21);
        throw null;
    }

    @Override // d0.e0.p.d.m0.c.e
    public d0.e0.p.d.m0.c.e getCompanionObjectDescriptor() {
        return null;
    }

    @Override // d0.e0.p.d.m0.c.e
    public Collection<d0.e0.p.d.m0.c.d> getConstructors() {
        List listEmptyList = Collections.emptyList();
        if (listEmptyList != null) {
            return listEmptyList;
        }
        a(16);
        throw null;
    }

    @Override // d0.e0.p.d.m0.c.e, d0.e0.p.d.m0.c.i
    public List<z0> getDeclaredTypeParameters() {
        List<z0> listEmptyList = Collections.emptyList();
        if (listEmptyList != null) {
            return listEmptyList;
        }
        a(22);
        throw null;
    }

    @Override // d0.e0.p.d.m0.c.e
    public d0.e0.p.d.m0.c.f getKind() {
        return d0.e0.p.d.m0.c.f.ENUM_ENTRY;
    }

    @Override // d0.e0.p.d.m0.c.e, d0.e0.p.d.m0.c.y
    public d0.e0.p.d.m0.c.z getModality() {
        return d0.e0.p.d.m0.c.z.FINAL;
    }

    @Override // d0.e0.p.d.m0.c.e
    public Collection<d0.e0.p.d.m0.c.e> getSealedSubclasses() {
        List listEmptyList = Collections.emptyList();
        if (listEmptyList != null) {
            return listEmptyList;
        }
        a(23);
        throw null;
    }

    @Override // d0.e0.p.d.m0.c.e
    public d0.e0.p.d.m0.k.a0.i getStaticScope() {
        i.b bVar = i.b.f3461b;
        if (bVar != null) {
            return bVar;
        }
        a(15);
        throw null;
    }

    @Override // d0.e0.p.d.m0.c.h
    public u0 getTypeConstructor() {
        u0 u0Var = this.r;
        if (u0Var != null) {
            return u0Var;
        }
        a(17);
        throw null;
    }

    @Override // d0.e0.p.d.m0.c.i1.u
    public d0.e0.p.d.m0.k.a0.i getUnsubstitutedMemberScope(d0.e0.p.d.m0.n.l1.g gVar) {
        if (gVar == null) {
            a(13);
            throw null;
        }
        d0.e0.p.d.m0.k.a0.i iVar = this.f3269s;
        if (iVar != null) {
            return iVar;
        }
        a(14);
        throw null;
    }

    @Override // d0.e0.p.d.m0.c.e
    public d0.e0.p.d.m0.c.d getUnsubstitutedPrimaryConstructor() {
        return null;
    }

    @Override // d0.e0.p.d.m0.c.e, d0.e0.p.d.m0.c.q, d0.e0.p.d.m0.c.y
    public d0.e0.p.d.m0.c.u getVisibility() {
        d0.e0.p.d.m0.c.u uVar = d0.e0.p.d.m0.c.t.e;
        if (uVar != null) {
            return uVar;
        }
        a(20);
        throw null;
    }

    @Override // d0.e0.p.d.m0.c.y
    public boolean isActual() {
        return false;
    }

    @Override // d0.e0.p.d.m0.c.e
    public boolean isCompanionObject() {
        return false;
    }

    @Override // d0.e0.p.d.m0.c.e
    public boolean isData() {
        return false;
    }

    @Override // d0.e0.p.d.m0.c.y
    public boolean isExpect() {
        return false;
    }

    @Override // d0.e0.p.d.m0.c.e
    public boolean isFun() {
        return false;
    }

    @Override // d0.e0.p.d.m0.c.e
    public boolean isInline() {
        return false;
    }

    @Override // d0.e0.p.d.m0.c.i
    public boolean isInner() {
        return false;
    }

    @Override // d0.e0.p.d.m0.c.e
    public boolean isValue() {
        return false;
    }

    public String toString() {
        StringBuilder sbU = b.d.b.a.a.U("enum entry ");
        sbU.append(getName());
        return sbU.toString();
    }
}

package d0.e0.p.d.m0.n;

import com.discord.models.domain.ModelAuditLogEntry;
import d0.e0.p.d.m0.c.b;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import kotlin.jvm.functions.Function1;

/* compiled from: ErrorUtils.java */
/* loaded from: classes3.dex */
public class t {
    public static final d0.e0.p.d.m0.c.c0 a = new a();

    /* renamed from: b, reason: collision with root package name */
    public static final c f3538b;
    public static final j0 c;
    public static final c0 d;
    public static final d0.e0.p.d.m0.c.n0 e;
    public static final Set<d0.e0.p.d.m0.c.n0> f;

    /* compiled from: ErrorUtils.java */
    public static class a implements d0.e0.p.d.m0.c.c0 {
        /* JADX WARN: Removed duplicated region for block: B:11:0x001a  */
        /* JADX WARN: Removed duplicated region for block: B:21:0x002e  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public static /* synthetic */ void a(int i) {
            String str;
            int i2;
            if (i != 1 && i != 4 && i != 5 && i != 6 && i != 13 && i != 14) {
                switch (i) {
                    case 8:
                    case 9:
                    case 10:
                        break;
                    default:
                        str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                        break;
                }
            } else {
                str = "@NotNull method %s.%s must not return null";
            }
            if (i != 1 && i != 4 && i != 5 && i != 6 && i != 13 && i != 14) {
                switch (i) {
                    case 8:
                    case 9:
                    case 10:
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
                case 6:
                case 8:
                case 9:
                case 10:
                case 13:
                case 14:
                    objArr[0] = "kotlin/reflect/jvm/internal/impl/types/ErrorUtils$1";
                    break;
                case 2:
                case 7:
                    objArr[0] = "fqName";
                    break;
                case 3:
                    objArr[0] = "nameFilter";
                    break;
                case 11:
                    objArr[0] = "visitor";
                    break;
                case 12:
                    objArr[0] = "targetModule";
                    break;
                default:
                    objArr[0] = "capability";
                    break;
            }
            if (i == 1) {
                objArr[1] = "getAnnotations";
            } else if (i == 4) {
                objArr[1] = "getSubPackagesOf";
            } else if (i == 5) {
                objArr[1] = "getName";
            } else if (i == 6) {
                objArr[1] = "getStableName";
            } else if (i == 13) {
                objArr[1] = "getOriginal";
            } else if (i != 14) {
                switch (i) {
                    case 8:
                        objArr[1] = "getAllDependencyModules";
                        break;
                    case 9:
                        objArr[1] = "getExpectedByModules";
                        break;
                    case 10:
                        objArr[1] = "getAllExpectedByModules";
                        break;
                    default:
                        objArr[1] = "kotlin/reflect/jvm/internal/impl/types/ErrorUtils$1";
                        break;
                }
            } else {
                objArr[1] = "getBuiltIns";
            }
            switch (i) {
                case 1:
                case 4:
                case 5:
                case 6:
                case 8:
                case 9:
                case 10:
                case 13:
                case 14:
                    break;
                case 2:
                case 3:
                    objArr[2] = "getSubPackagesOf";
                    break;
                case 7:
                    objArr[2] = "getPackage";
                    break;
                case 11:
                    objArr[2] = "accept";
                    break;
                case 12:
                    objArr[2] = "shouldSeeInternalsOf";
                    break;
                default:
                    objArr[2] = "getCapability";
                    break;
            }
            String str2 = String.format(str, objArr);
            if (i != 1 && i != 4 && i != 5 && i != 6 && i != 13 && i != 14) {
                switch (i) {
                    case 8:
                    case 9:
                    case 10:
                        break;
                    default:
                        throw new IllegalArgumentException(str2);
                }
            }
            throw new IllegalStateException(str2);
        }

        @Override // d0.e0.p.d.m0.c.m
        public <R, D> R accept(d0.e0.p.d.m0.c.o<R, D> oVar, D d) {
            if (oVar != null) {
                return null;
            }
            a(11);
            throw null;
        }

        @Override // d0.e0.p.d.m0.c.g1.a
        public d0.e0.p.d.m0.c.g1.g getAnnotations() {
            d0.e0.p.d.m0.c.g1.g empty = d0.e0.p.d.m0.c.g1.g.f.getEMPTY();
            if (empty != null) {
                return empty;
            }
            a(1);
            throw null;
        }

        @Override // d0.e0.p.d.m0.c.c0
        public d0.e0.p.d.m0.b.h getBuiltIns() {
            d0.e0.p.d.m0.b.e eVar = d0.e0.p.d.m0.b.e.getInstance();
            if (eVar != null) {
                return eVar;
            }
            a(14);
            throw null;
        }

        @Override // d0.e0.p.d.m0.c.c0
        public <T> T getCapability(d0.e0.p.d.m0.c.b0<T> b0Var) {
            if (b0Var != null) {
                return null;
            }
            a(0);
            throw null;
        }

        @Override // d0.e0.p.d.m0.c.m
        public d0.e0.p.d.m0.c.m getContainingDeclaration() {
            return null;
        }

        @Override // d0.e0.p.d.m0.c.c0
        public List<d0.e0.p.d.m0.c.c0> getExpectedByModules() {
            List<d0.e0.p.d.m0.c.c0> listEmptyList = d0.t.n.emptyList();
            if (listEmptyList != null) {
                return listEmptyList;
            }
            a(9);
            throw null;
        }

        @Override // d0.e0.p.d.m0.c.m
        public d0.e0.p.d.m0.g.e getName() {
            d0.e0.p.d.m0.g.e eVarSpecial = d0.e0.p.d.m0.g.e.special("<ERROR MODULE>");
            if (eVarSpecial != null) {
                return eVarSpecial;
            }
            a(5);
            throw null;
        }

        @Override // d0.e0.p.d.m0.c.m
        public d0.e0.p.d.m0.c.m getOriginal() {
            return this;
        }

        @Override // d0.e0.p.d.m0.c.c0
        public d0.e0.p.d.m0.c.j0 getPackage(d0.e0.p.d.m0.g.b bVar) {
            if (bVar != null) {
                throw new IllegalStateException("Should not be called!");
            }
            a(7);
            throw null;
        }

        @Override // d0.e0.p.d.m0.c.c0
        public Collection<d0.e0.p.d.m0.g.b> getSubPackagesOf(d0.e0.p.d.m0.g.b bVar, Function1<? super d0.e0.p.d.m0.g.e, Boolean> function1) {
            if (bVar == null) {
                a(2);
                throw null;
            }
            if (function1 == null) {
                a(3);
                throw null;
            }
            List listEmptyList = d0.t.n.emptyList();
            if (listEmptyList != null) {
                return listEmptyList;
            }
            a(4);
            throw null;
        }

        @Override // d0.e0.p.d.m0.c.c0
        public boolean shouldSeeInternalsOf(d0.e0.p.d.m0.c.c0 c0Var) {
            if (c0Var != null) {
                return false;
            }
            a(12);
            throw null;
        }
    }

    /* compiled from: ErrorUtils.java */
    public static class b implements u0 {
        public final /* synthetic */ c a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f3539b;

        public b(c cVar, String str) {
            this.a = cVar;
            this.f3539b = str;
        }

        public static /* synthetic */ void a(int i) {
            String str = i != 3 ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
            Object[] objArr = new Object[i != 3 ? 2 : 3];
            if (i != 3) {
                objArr[0] = "kotlin/reflect/jvm/internal/impl/types/ErrorUtils$2";
            } else {
                objArr[0] = "kotlinTypeRefiner";
            }
            if (i == 1) {
                objArr[1] = "getSupertypes";
            } else if (i == 2) {
                objArr[1] = "getBuiltIns";
            } else if (i == 3) {
                objArr[1] = "kotlin/reflect/jvm/internal/impl/types/ErrorUtils$2";
            } else if (i != 4) {
                objArr[1] = "getParameters";
            } else {
                objArr[1] = "refine";
            }
            if (i == 3) {
                objArr[2] = "refine";
            }
            String str2 = String.format(str, objArr);
            if (i == 3) {
                throw new IllegalArgumentException(str2);
            }
        }

        @Override // d0.e0.p.d.m0.n.u0
        public d0.e0.p.d.m0.b.h getBuiltIns() {
            d0.e0.p.d.m0.b.e eVar = d0.e0.p.d.m0.b.e.getInstance();
            if (eVar != null) {
                return eVar;
            }
            a(2);
            throw null;
        }

        @Override // d0.e0.p.d.m0.n.u0
        public d0.e0.p.d.m0.c.h getDeclarationDescriptor() {
            return this.a;
        }

        @Override // d0.e0.p.d.m0.n.u0
        public List<d0.e0.p.d.m0.c.z0> getParameters() {
            List<d0.e0.p.d.m0.c.z0> listEmptyList = d0.t.n.emptyList();
            if (listEmptyList != null) {
                return listEmptyList;
            }
            a(0);
            throw null;
        }

        @Override // d0.e0.p.d.m0.n.u0
        public Collection<c0> getSupertypes() {
            List listEmptyList = d0.t.n.emptyList();
            if (listEmptyList != null) {
                return listEmptyList;
            }
            a(1);
            throw null;
        }

        @Override // d0.e0.p.d.m0.n.u0
        public boolean isDenotable() {
            return false;
        }

        @Override // d0.e0.p.d.m0.n.u0
        public u0 refine(d0.e0.p.d.m0.n.l1.g gVar) {
            if (gVar != null) {
                return this;
            }
            a(3);
            throw null;
        }

        public String toString() {
            return this.f3539b;
        }
    }

    /* compiled from: ErrorUtils.java */
    public static class c extends d0.e0.p.d.m0.c.i1.i {
        /* JADX WARN: Illegal instructions before constructor call */
        public c(d0.e0.p.d.m0.g.e eVar) {
            if (eVar == null) {
                a(0);
                throw null;
            }
            d0.e0.p.d.m0.c.c0 errorModule = t.getErrorModule();
            d0.e0.p.d.m0.c.z zVar = d0.e0.p.d.m0.c.z.OPEN;
            d0.e0.p.d.m0.c.f fVar = d0.e0.p.d.m0.c.f.CLASS;
            List listEmptyList = Collections.emptyList();
            d0.e0.p.d.m0.c.u0 u0Var = d0.e0.p.d.m0.c.u0.a;
            super(errorModule, eVar, zVar, fVar, listEmptyList, u0Var, false, d0.e0.p.d.m0.m.f.f3514b);
            d0.e0.p.d.m0.c.i1.g gVarCreate = d0.e0.p.d.m0.c.i1.g.create(this, d0.e0.p.d.m0.c.g1.g.f.getEMPTY(), true, u0Var);
            gVarCreate.initialize(Collections.emptyList(), d0.e0.p.d.m0.c.t.d);
            d0.e0.p.d.m0.k.a0.i iVarCreateErrorScope = t.createErrorScope(getName().asString());
            gVarCreate.setReturnType(new s(t.b("<ERROR>", this), iVarCreateErrorScope));
            initialize(iVarCreateErrorScope, Collections.singleton(gVarCreate), gVarCreate);
        }

        public static /* synthetic */ void a(int i) {
            String str = (i == 2 || i == 5 || i == 8) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
            Object[] objArr = new Object[(i == 2 || i == 5 || i == 8) ? 2 : 3];
            switch (i) {
                case 1:
                    objArr[0] = "substitutor";
                    break;
                case 2:
                case 5:
                case 8:
                    objArr[0] = "kotlin/reflect/jvm/internal/impl/types/ErrorUtils$ErrorClassDescriptor";
                    break;
                case 3:
                    objArr[0] = "typeArguments";
                    break;
                case 4:
                case 7:
                    objArr[0] = "kotlinTypeRefiner";
                    break;
                case 6:
                    objArr[0] = "typeSubstitution";
                    break;
                default:
                    objArr[0] = ModelAuditLogEntry.CHANGE_KEY_NAME;
                    break;
            }
            if (i == 2) {
                objArr[1] = "substitute";
            } else if (i == 5 || i == 8) {
                objArr[1] = "getMemberScope";
            } else {
                objArr[1] = "kotlin/reflect/jvm/internal/impl/types/ErrorUtils$ErrorClassDescriptor";
            }
            switch (i) {
                case 1:
                    objArr[2] = "substitute";
                    break;
                case 2:
                case 5:
                case 8:
                    break;
                case 3:
                case 4:
                case 6:
                case 7:
                    objArr[2] = "getMemberScope";
                    break;
                default:
                    objArr[2] = "<init>";
                    break;
            }
            String str2 = String.format(str, objArr);
            if (i != 2 && i != 5 && i != 8) {
                throw new IllegalArgumentException(str2);
            }
            throw new IllegalStateException(str2);
        }

        @Override // d0.e0.p.d.m0.c.i1.a, d0.e0.p.d.m0.c.i1.u
        public d0.e0.p.d.m0.k.a0.i getMemberScope(z0 z0Var, d0.e0.p.d.m0.n.l1.g gVar) {
            if (z0Var == null) {
                a(6);
                throw null;
            }
            if (gVar == null) {
                a(7);
                throw null;
            }
            StringBuilder sbU = b.d.b.a.a.U("Error scope for class ");
            sbU.append(getName());
            sbU.append(" with arguments: ");
            sbU.append(z0Var);
            d0.e0.p.d.m0.k.a0.i iVarCreateErrorScope = t.createErrorScope(sbU.toString());
            if (iVarCreateErrorScope != null) {
                return iVarCreateErrorScope;
            }
            a(8);
            throw null;
        }

        @Override // d0.e0.p.d.m0.c.i1.a, d0.e0.p.d.m0.c.w0
        public d0.e0.p.d.m0.c.e substitute(c1 c1Var) {
            if (c1Var != null) {
                return this;
            }
            a(1);
            throw null;
        }

        @Override // d0.e0.p.d.m0.c.i1.a, d0.e0.p.d.m0.c.w0
        public /* bridge */ /* synthetic */ d0.e0.p.d.m0.c.n substitute(c1 c1Var) {
            return substitute(c1Var);
        }

        @Override // d0.e0.p.d.m0.c.i1.i
        public String toString() {
            return getName().asString();
        }
    }

    /* compiled from: ErrorUtils.java */
    public static class d implements d0.e0.p.d.m0.k.a0.i {

        /* renamed from: b, reason: collision with root package name */
        public final String f3540b;

        public d(String str, a aVar) {
            if (str != null) {
                this.f3540b = str;
            } else {
                a(0);
                throw null;
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:13:0x0019  */
        /* JADX WARN: Removed duplicated region for block: B:7:0x000d  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public static /* synthetic */ void a(int i) {
            String str;
            int i2;
            if (i != 7 && i != 18) {
                switch (i) {
                    case 10:
                    case 11:
                    case 12:
                    case 13:
                        break;
                    default:
                        str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                        break;
                }
            } else {
                str = "@NotNull method %s.%s must not return null";
            }
            if (i != 7 && i != 18) {
                switch (i) {
                    case 10:
                    case 11:
                    case 12:
                    case 13:
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
                case 3:
                case 5:
                case 8:
                case 14:
                case 19:
                    objArr[0] = ModelAuditLogEntry.CHANGE_KEY_NAME;
                    break;
                case 2:
                case 4:
                case 6:
                case 9:
                case 15:
                    objArr[0] = ModelAuditLogEntry.CHANGE_KEY_LOCATION;
                    break;
                case 7:
                case 10:
                case 11:
                case 12:
                case 13:
                case 18:
                    objArr[0] = "kotlin/reflect/jvm/internal/impl/types/ErrorUtils$ErrorScope";
                    break;
                case 16:
                    objArr[0] = "kindFilter";
                    break;
                case 17:
                    objArr[0] = "nameFilter";
                    break;
                case 20:
                    objArr[0] = "p";
                    break;
                default:
                    objArr[0] = "debugMessage";
                    break;
            }
            if (i == 7) {
                objArr[1] = "getContributedVariables";
            } else if (i != 18) {
                switch (i) {
                    case 10:
                        objArr[1] = "getContributedFunctions";
                        break;
                    case 11:
                        objArr[1] = "getFunctionNames";
                        break;
                    case 12:
                        objArr[1] = "getVariableNames";
                        break;
                    case 13:
                        objArr[1] = "getClassifierNames";
                        break;
                    default:
                        objArr[1] = "kotlin/reflect/jvm/internal/impl/types/ErrorUtils$ErrorScope";
                        break;
                }
            } else {
                objArr[1] = "getContributedDescriptors";
            }
            switch (i) {
                case 1:
                case 2:
                    objArr[2] = "getContributedClassifier";
                    break;
                case 3:
                case 4:
                    objArr[2] = "getContributedClassifierIncludeDeprecated";
                    break;
                case 5:
                case 6:
                    objArr[2] = "getContributedVariables";
                    break;
                case 7:
                case 10:
                case 11:
                case 12:
                case 13:
                case 18:
                    break;
                case 8:
                case 9:
                    objArr[2] = "getContributedFunctions";
                    break;
                case 14:
                case 15:
                    objArr[2] = "recordLookup";
                    break;
                case 16:
                case 17:
                    objArr[2] = "getContributedDescriptors";
                    break;
                case 19:
                    objArr[2] = "definitelyDoesNotContainName";
                    break;
                case 20:
                    objArr[2] = "printScopeStructure";
                    break;
                default:
                    objArr[2] = "<init>";
                    break;
            }
            String str2 = String.format(str, objArr);
            if (i != 7 && i != 18) {
                switch (i) {
                    case 10:
                    case 11:
                    case 12:
                    case 13:
                        break;
                    default:
                        throw new IllegalArgumentException(str2);
                }
            }
            throw new IllegalStateException(str2);
        }

        @Override // d0.e0.p.d.m0.k.a0.i
        public Set<d0.e0.p.d.m0.g.e> getClassifierNames() {
            Set<d0.e0.p.d.m0.g.e> setEmptySet = Collections.emptySet();
            if (setEmptySet != null) {
                return setEmptySet;
            }
            a(13);
            throw null;
        }

        @Override // d0.e0.p.d.m0.k.a0.l
        public d0.e0.p.d.m0.c.h getContributedClassifier(d0.e0.p.d.m0.g.e eVar, d0.e0.p.d.m0.d.b.b bVar) {
            if (eVar == null) {
                a(1);
                throw null;
            }
            if (bVar != null) {
                return t.createErrorClass(eVar.asString());
            }
            a(2);
            throw null;
        }

        @Override // d0.e0.p.d.m0.k.a0.l
        public Collection<d0.e0.p.d.m0.c.m> getContributedDescriptors(d0.e0.p.d.m0.k.a0.d dVar, Function1<? super d0.e0.p.d.m0.g.e, Boolean> function1) {
            if (dVar == null) {
                a(16);
                throw null;
            }
            if (function1 == null) {
                a(17);
                throw null;
            }
            List listEmptyList = Collections.emptyList();
            if (listEmptyList != null) {
                return listEmptyList;
            }
            a(18);
            throw null;
        }

        @Override // d0.e0.p.d.m0.k.a0.i
        public /* bridge */ /* synthetic */ Collection getContributedFunctions(d0.e0.p.d.m0.g.e eVar, d0.e0.p.d.m0.d.b.b bVar) {
            return getContributedFunctions(eVar, bVar);
        }

        @Override // d0.e0.p.d.m0.k.a0.i
        public Set<? extends d0.e0.p.d.m0.c.n0> getContributedVariables(d0.e0.p.d.m0.g.e eVar, d0.e0.p.d.m0.d.b.b bVar) {
            if (eVar == null) {
                a(5);
                throw null;
            }
            if (bVar == null) {
                a(6);
                throw null;
            }
            Set<d0.e0.p.d.m0.c.n0> set = t.f;
            if (set != null) {
                return set;
            }
            a(7);
            throw null;
        }

        @Override // d0.e0.p.d.m0.k.a0.i
        public Set<d0.e0.p.d.m0.g.e> getFunctionNames() {
            Set<d0.e0.p.d.m0.g.e> setEmptySet = Collections.emptySet();
            if (setEmptySet != null) {
                return setEmptySet;
            }
            a(11);
            throw null;
        }

        @Override // d0.e0.p.d.m0.k.a0.i
        public Set<d0.e0.p.d.m0.g.e> getVariableNames() {
            Set<d0.e0.p.d.m0.g.e> setEmptySet = Collections.emptySet();
            if (setEmptySet != null) {
                return setEmptySet;
            }
            a(12);
            throw null;
        }

        public String toString() {
            return b.d.b.a.a.H(b.d.b.a.a.U("ErrorScope{"), this.f3540b, '}');
        }

        @Override // d0.e0.p.d.m0.k.a0.i
        public Set<? extends d0.e0.p.d.m0.c.t0> getContributedFunctions(d0.e0.p.d.m0.g.e eVar, d0.e0.p.d.m0.d.b.b bVar) {
            if (eVar == null) {
                a(8);
                throw null;
            }
            if (bVar == null) {
                a(9);
                throw null;
            }
            d0.e0.p.d.m0.n.m1.a aVar = new d0.e0.p.d.m0.n.m1.a(t.f3538b, this);
            aVar.initialize((d0.e0.p.d.m0.c.q0) null, (d0.e0.p.d.m0.c.q0) null, Collections.emptyList(), Collections.emptyList(), (c0) t.createErrorType("<ERROR FUNCTION RETURN TYPE>"), d0.e0.p.d.m0.c.z.OPEN, d0.e0.p.d.m0.c.t.e);
            Set<? extends d0.e0.p.d.m0.c.t0> setSingleton = Collections.singleton(aVar);
            if (setSingleton != null) {
                return setSingleton;
            }
            a(10);
            throw null;
        }

        @Override // d0.e0.p.d.m0.k.a0.i
        public /* bridge */ /* synthetic */ Collection getContributedVariables(d0.e0.p.d.m0.g.e eVar, d0.e0.p.d.m0.d.b.b bVar) {
            return getContributedVariables(eVar, bVar);
        }
    }

    /* compiled from: ErrorUtils.java */
    public static class e implements d0.e0.p.d.m0.k.a0.i {

        /* renamed from: b, reason: collision with root package name */
        public final String f3541b;

        public e(String str, a aVar) {
            if (str != null) {
                this.f3541b = str;
            } else {
                a(0);
                throw null;
            }
        }

        public static /* synthetic */ void a(int i) {
            Object[] objArr = new Object[3];
            switch (i) {
                case 1:
                case 3:
                case 5:
                case 7:
                case 11:
                case 13:
                    objArr[0] = ModelAuditLogEntry.CHANGE_KEY_NAME;
                    break;
                case 2:
                case 4:
                case 6:
                case 8:
                case 12:
                    objArr[0] = ModelAuditLogEntry.CHANGE_KEY_LOCATION;
                    break;
                case 9:
                    objArr[0] = "kindFilter";
                    break;
                case 10:
                    objArr[0] = "nameFilter";
                    break;
                case 14:
                    objArr[0] = "p";
                    break;
                default:
                    objArr[0] = "message";
                    break;
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/types/ErrorUtils$ThrowingScope";
            switch (i) {
                case 1:
                case 2:
                    objArr[2] = "getContributedClassifier";
                    break;
                case 3:
                case 4:
                    objArr[2] = "getContributedClassifierIncludeDeprecated";
                    break;
                case 5:
                case 6:
                    objArr[2] = "getContributedVariables";
                    break;
                case 7:
                case 8:
                    objArr[2] = "getContributedFunctions";
                    break;
                case 9:
                case 10:
                    objArr[2] = "getContributedDescriptors";
                    break;
                case 11:
                case 12:
                    objArr[2] = "recordLookup";
                    break;
                case 13:
                    objArr[2] = "definitelyDoesNotContainName";
                    break;
                case 14:
                    objArr[2] = "printScopeStructure";
                    break;
                default:
                    objArr[2] = "<init>";
                    break;
            }
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        @Override // d0.e0.p.d.m0.k.a0.i
        public Set<d0.e0.p.d.m0.g.e> getClassifierNames() {
            throw new IllegalStateException();
        }

        @Override // d0.e0.p.d.m0.k.a0.l
        public d0.e0.p.d.m0.c.h getContributedClassifier(d0.e0.p.d.m0.g.e eVar, d0.e0.p.d.m0.d.b.b bVar) {
            if (eVar == null) {
                a(1);
                throw null;
            }
            if (bVar == null) {
                a(2);
                throw null;
            }
            throw new IllegalStateException(this.f3541b + ", required name: " + eVar);
        }

        @Override // d0.e0.p.d.m0.k.a0.l
        public Collection<d0.e0.p.d.m0.c.m> getContributedDescriptors(d0.e0.p.d.m0.k.a0.d dVar, Function1<? super d0.e0.p.d.m0.g.e, Boolean> function1) {
            if (dVar == null) {
                a(9);
                throw null;
            }
            if (function1 != null) {
                throw new IllegalStateException(this.f3541b);
            }
            a(10);
            throw null;
        }

        @Override // d0.e0.p.d.m0.k.a0.i
        public Collection<? extends d0.e0.p.d.m0.c.t0> getContributedFunctions(d0.e0.p.d.m0.g.e eVar, d0.e0.p.d.m0.d.b.b bVar) {
            if (eVar == null) {
                a(7);
                throw null;
            }
            if (bVar == null) {
                a(8);
                throw null;
            }
            throw new IllegalStateException(this.f3541b + ", required name: " + eVar);
        }

        @Override // d0.e0.p.d.m0.k.a0.i
        public Collection<? extends d0.e0.p.d.m0.c.n0> getContributedVariables(d0.e0.p.d.m0.g.e eVar, d0.e0.p.d.m0.d.b.b bVar) {
            if (eVar == null) {
                a(5);
                throw null;
            }
            if (bVar == null) {
                a(6);
                throw null;
            }
            throw new IllegalStateException(this.f3541b + ", required name: " + eVar);
        }

        @Override // d0.e0.p.d.m0.k.a0.i
        public Set<d0.e0.p.d.m0.g.e> getFunctionNames() {
            throw new IllegalStateException();
        }

        @Override // d0.e0.p.d.m0.k.a0.i
        public Set<d0.e0.p.d.m0.g.e> getVariableNames() {
            throw new IllegalStateException();
        }

        public String toString() {
            return b.d.b.a.a.H(b.d.b.a.a.U("ThrowingScope{"), this.f3541b, '}');
        }
    }

    /* compiled from: ErrorUtils.java */
    public static class f implements u0 {
        public static /* synthetic */ void a(int i) {
            String str = (i == 1 || i == 2 || i == 3 || i == 4 || i == 6) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
            Object[] objArr = new Object[(i == 1 || i == 2 || i == 3 || i == 4 || i == 6) ? 2 : 3];
            switch (i) {
                case 1:
                case 2:
                case 3:
                case 4:
                case 6:
                    objArr[0] = "kotlin/reflect/jvm/internal/impl/types/ErrorUtils$UninferredParameterTypeConstructor";
                    break;
                case 5:
                    objArr[0] = "kotlinTypeRefiner";
                    break;
                default:
                    objArr[0] = "descriptor";
                    break;
            }
            if (i == 1) {
                objArr[1] = "getTypeParameterDescriptor";
            } else if (i == 2) {
                objArr[1] = "getParameters";
            } else if (i == 3) {
                objArr[1] = "getSupertypes";
            } else if (i == 4) {
                objArr[1] = "getBuiltIns";
            } else if (i != 6) {
                objArr[1] = "kotlin/reflect/jvm/internal/impl/types/ErrorUtils$UninferredParameterTypeConstructor";
            } else {
                objArr[1] = "refine";
            }
            switch (i) {
                case 1:
                case 2:
                case 3:
                case 4:
                case 6:
                    break;
                case 5:
                    objArr[2] = "refine";
                    break;
                default:
                    objArr[2] = "<init>";
                    break;
            }
            String str2 = String.format(str, objArr);
            if (i != 1 && i != 2 && i != 3 && i != 4 && i != 6) {
                throw new IllegalArgumentException(str2);
            }
            throw new IllegalStateException(str2);
        }

        @Override // d0.e0.p.d.m0.n.u0
        public d0.e0.p.d.m0.b.h getBuiltIns() {
            d0.e0.p.d.m0.b.h builtIns = d0.e0.p.d.m0.k.x.a.getBuiltIns(null);
            if (builtIns != null) {
                return builtIns;
            }
            a(4);
            throw null;
        }

        @Override // d0.e0.p.d.m0.n.u0
        public d0.e0.p.d.m0.c.h getDeclarationDescriptor() {
            throw null;
        }

        @Override // d0.e0.p.d.m0.n.u0
        public List<d0.e0.p.d.m0.c.z0> getParameters() {
            throw null;
        }

        @Override // d0.e0.p.d.m0.n.u0
        public Collection<c0> getSupertypes() {
            throw null;
        }

        public d0.e0.p.d.m0.c.z0 getTypeParameterDescriptor() {
            a(1);
            throw null;
        }

        @Override // d0.e0.p.d.m0.n.u0
        public boolean isDenotable() {
            throw null;
        }

        @Override // d0.e0.p.d.m0.n.u0
        public u0 refine(d0.e0.p.d.m0.n.l1.g gVar) {
            if (gVar != null) {
                return this;
            }
            a(5);
            throw null;
        }
    }

    static {
        c cVar = new c(d0.e0.p.d.m0.g.e.special("<ERROR CLASS>"));
        f3538b = cVar;
        c = createErrorType("<LOOP IN SUPERTYPES>");
        j0 j0VarCreateErrorType = createErrorType("<ERROR PROPERTY TYPE>");
        d = j0VarCreateErrorType;
        d0.e0.p.d.m0.c.i1.c0 c0VarCreate = d0.e0.p.d.m0.c.i1.c0.create(cVar, d0.e0.p.d.m0.c.g1.g.f.getEMPTY(), d0.e0.p.d.m0.c.z.OPEN, d0.e0.p.d.m0.c.t.e, true, d0.e0.p.d.m0.g.e.special("<ERROR PROPERTY>"), b.a.DECLARATION, d0.e0.p.d.m0.c.u0.a, false, false, false, false, false, false);
        c0VarCreate.setType(j0VarCreateErrorType, Collections.emptyList(), null, null);
        e = c0VarCreate;
        f = Collections.singleton(c0VarCreate);
    }

    public static /* synthetic */ void a(int i) {
        String str = (i == 4 || i == 6 || i == 19) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i == 4 || i == 6 || i == 19) ? 2 : 3];
        switch (i) {
            case 1:
            case 2:
            case 3:
            case 7:
            case 11:
            case 15:
                objArr[0] = "debugMessage";
                break;
            case 4:
            case 6:
            case 19:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/types/ErrorUtils";
                break;
            case 5:
                objArr[0] = "ownerScope";
                break;
            case 8:
            case 9:
            case 16:
            case 17:
                objArr[0] = "debugName";
                break;
            case 10:
                objArr[0] = "typeConstructor";
                break;
            case 12:
            case 14:
                objArr[0] = "arguments";
                break;
            case 13:
                objArr[0] = "presentableName";
                break;
            case 18:
                objArr[0] = "errorClass";
                break;
            case 20:
                objArr[0] = "typeParameterDescriptor";
                break;
            default:
                objArr[0] = "function";
                break;
        }
        if (i == 4) {
            objArr[1] = "createErrorProperty";
        } else if (i == 6) {
            objArr[1] = "createErrorFunction";
        } else if (i != 19) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/types/ErrorUtils";
        } else {
            objArr[1] = "getErrorModule";
        }
        switch (i) {
            case 1:
                objArr[2] = "createErrorClass";
                break;
            case 2:
            case 3:
                objArr[2] = "createErrorScope";
                break;
            case 4:
            case 6:
            case 19:
                break;
            case 5:
                objArr[2] = "createErrorFunction";
                break;
            case 7:
                objArr[2] = "createErrorType";
                break;
            case 8:
                objArr[2] = "createErrorTypeWithCustomDebugName";
                break;
            case 9:
            case 10:
                objArr[2] = "createErrorTypeWithCustomConstructor";
                break;
            case 11:
            case 12:
                objArr[2] = "createErrorTypeWithArguments";
                break;
            case 13:
            case 14:
                objArr[2] = "createUnresolvedType";
                break;
            case 15:
                objArr[2] = "createErrorTypeConstructor";
                break;
            case 16:
            case 17:
            case 18:
                objArr[2] = "createErrorTypeConstructorWithCustomDebugName";
                break;
            case 20:
                objArr[2] = "createUninferredParameterType";
                break;
            default:
                objArr[2] = "containsErrorTypeInParameters";
                break;
        }
        String str2 = String.format(str, objArr);
        if (i != 4 && i != 6 && i != 19) {
            throw new IllegalArgumentException(str2);
        }
        throw new IllegalStateException(str2);
    }

    public static u0 b(String str, c cVar) {
        if (str == null) {
            a(17);
            throw null;
        }
        if (cVar != null) {
            return new b(cVar, str);
        }
        a(18);
        throw null;
    }

    public static d0.e0.p.d.m0.c.e createErrorClass(String str) {
        if (str == null) {
            a(1);
            throw null;
        }
        return new c(d0.e0.p.d.m0.g.e.special("<ERROR CLASS: " + str + ">"));
    }

    public static d0.e0.p.d.m0.k.a0.i createErrorScope(String str) {
        if (str != null) {
            return createErrorScope(str, false);
        }
        a(2);
        throw null;
    }

    public static j0 createErrorType(String str) {
        if (str != null) {
            return createErrorTypeWithArguments(str, Collections.emptyList());
        }
        a(7);
        throw null;
    }

    public static u0 createErrorTypeConstructor(String str) {
        if (str != null) {
            return b(b.d.b.a.a.y("[ERROR : ", str, "]"), f3538b);
        }
        a(15);
        throw null;
    }

    public static u0 createErrorTypeConstructorWithCustomDebugName(String str) {
        if (str != null) {
            return b(str, f3538b);
        }
        a(16);
        throw null;
    }

    public static j0 createErrorTypeWithArguments(String str, List<w0> list) {
        if (str == null) {
            a(11);
            throw null;
        }
        if (list != null) {
            return new s(createErrorTypeConstructor(str), createErrorScope(str), list, false);
        }
        a(12);
        throw null;
    }

    public static j0 createErrorTypeWithCustomConstructor(String str, u0 u0Var) {
        if (str == null) {
            a(9);
            throw null;
        }
        if (u0Var != null) {
            return new s(u0Var, createErrorScope(str));
        }
        a(10);
        throw null;
    }

    public static j0 createErrorTypeWithCustomDebugName(String str) {
        if (str != null) {
            return createErrorTypeWithCustomConstructor(str, createErrorTypeConstructorWithCustomDebugName(str));
        }
        a(8);
        throw null;
    }

    public static d0.e0.p.d.m0.c.c0 getErrorModule() {
        return a;
    }

    public static boolean isError(d0.e0.p.d.m0.c.m mVar) {
        if (mVar == null) {
            return false;
        }
        return (mVar instanceof c) || (mVar.getContainingDeclaration() instanceof c) || mVar == a;
    }

    public static boolean isUninferredParameter(c0 c0Var) {
        return c0Var != null && (c0Var.getConstructor() instanceof f);
    }

    public static d0.e0.p.d.m0.k.a0.i createErrorScope(String str, boolean z2) {
        if (str == null) {
            a(3);
            throw null;
        }
        if (z2) {
            return new e(str, null);
        }
        return new d(str, null);
    }
}

package d0.e0.p.d.m0.k;

import com.discord.models.domain.ModelAuditLogEntry;
import d0.e0.p.d.m0.c.b;
import d0.e0.p.d.m0.c.c1;
import d0.e0.p.d.m0.c.i1.b0;
import d0.e0.p.d.m0.c.m0;
import d0.e0.p.d.m0.c.n0;
import d0.e0.p.d.m0.c.p0;
import d0.e0.p.d.m0.c.q0;
import d0.e0.p.d.m0.c.x;
import d0.e0.p.d.m0.c.y;
import d0.e0.p.d.m0.c.z;
import d0.e0.p.d.m0.c.z0;
import d0.e0.p.d.m0.k.f;
import d0.e0.p.d.m0.n.c0;
import d0.e0.p.d.m0.n.e0;
import d0.e0.p.d.m0.n.l1.f;
import d0.e0.p.d.m0.n.l1.g;
import d0.e0.p.d.m0.n.u0;
import d0.t.u;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.ServiceLoader;
import java.util.Set;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* compiled from: OverridingUtil.java */
/* loaded from: classes3.dex */
public class k {
    public static final List<f> a = u.toList(ServiceLoader.load(f.class, f.class.getClassLoader()));

    /* renamed from: b, reason: collision with root package name */
    public static final k f3468b;
    public static final f.a c;
    public final d0.e0.p.d.m0.n.l1.g d;
    public final f.a e;

    /* compiled from: OverridingUtil.java */
    public static class a implements f.a {
        public static /* synthetic */ void a(int i) {
            Object[] objArr = new Object[3];
            if (i != 1) {
                objArr[0] = "a";
            } else {
                objArr[0] = "b";
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/resolve/OverridingUtil$1";
            objArr[2] = "equals";
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        @Override // d0.e0.p.d.m0.n.l1.f.a
        public boolean equals(u0 u0Var, u0 u0Var2) {
            if (u0Var == null) {
                a(0);
                throw null;
            }
            if (u0Var2 != null) {
                return u0Var.equals(u0Var2);
            }
            a(1);
            throw null;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [D] */
    /* compiled from: OverridingUtil.java */
    public static class b<D> implements Function2<D, D, Pair<d0.e0.p.d.m0.c.a, d0.e0.p.d.m0.c.a>> {
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Pair<d0.e0.p.d.m0.c.a, d0.e0.p.d.m0.c.a> invoke(Object obj, Object obj2) {
            return invoke((d0.e0.p.d.m0.c.a) obj, (d0.e0.p.d.m0.c.a) obj2);
        }

        /* JADX WARN: Incorrect types in method signature: (TD;TD;)Lkotlin/Pair<Ld0/e0/p/d/m0/c/a;Ld0/e0/p/d/m0/c/a;>; */
        public Pair invoke(d0.e0.p.d.m0.c.a aVar, d0.e0.p.d.m0.c.a aVar2) {
            return new Pair(aVar, aVar2);
        }
    }

    /* compiled from: OverridingUtil.java */
    public static class c implements Function1<d0.e0.p.d.m0.c.b, d0.e0.p.d.m0.c.a> {
        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public d0.e0.p.d.m0.c.b invoke2(d0.e0.p.d.m0.c.b bVar) {
            return bVar;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ d0.e0.p.d.m0.c.a invoke(d0.e0.p.d.m0.c.b bVar) {
            return invoke2(bVar);
        }
    }

    /* compiled from: OverridingUtil.java */
    public static class d {
        public static final d a = new d(a.OVERRIDABLE, "SUCCESS");

        /* renamed from: b, reason: collision with root package name */
        public final a f3469b;

        /* compiled from: OverridingUtil.java */
        public enum a {
            OVERRIDABLE,
            INCOMPATIBLE,
            CONFLICT
        }

        public d(a aVar, String str) {
            if (aVar == null) {
                a(3);
                throw null;
            }
            if (str != null) {
                this.f3469b = aVar;
            } else {
                a(4);
                throw null;
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:22:0x0031  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public static /* synthetic */ void a(int i) {
            String str = (i == 1 || i == 2 || i == 3 || i == 4) ? "Argument for @NotNull parameter '%s' of %s.%s must not be null" : "@NotNull method %s.%s must not return null";
            Object[] objArr = new Object[(i == 1 || i == 2 || i == 3 || i == 4) ? 3 : 2];
            if (i == 1 || i == 2) {
                objArr[0] = "debugMessage";
            } else if (i == 3) {
                objArr[0] = "success";
            } else if (i != 4) {
                objArr[0] = "kotlin/reflect/jvm/internal/impl/resolve/OverridingUtil$OverrideCompatibilityInfo";
            }
            switch (i) {
                case 1:
                case 2:
                case 3:
                case 4:
                    objArr[1] = "kotlin/reflect/jvm/internal/impl/resolve/OverridingUtil$OverrideCompatibilityInfo";
                    break;
                case 5:
                    objArr[1] = "getResult";
                    break;
                case 6:
                    objArr[1] = "getDebugMessage";
                    break;
                default:
                    objArr[1] = "success";
                    break;
            }
            if (i == 1) {
                objArr[2] = "incompatible";
            } else if (i == 2) {
                objArr[2] = "conflict";
            } else if (i == 3 || i == 4) {
                objArr[2] = "<init>";
            }
            String str2 = String.format(str, objArr);
            if (i != 1 && i != 2 && i != 3 && i != 4) {
                throw new IllegalStateException(str2);
            }
            throw new IllegalArgumentException(str2);
        }

        public static d conflict(String str) {
            if (str != null) {
                return new d(a.CONFLICT, str);
            }
            a(2);
            throw null;
        }

        public static d incompatible(String str) {
            if (str != null) {
                return new d(a.INCOMPATIBLE, str);
            }
            a(1);
            throw null;
        }

        public static d success() {
            d dVar = a;
            if (dVar != null) {
                return dVar;
            }
            a(0);
            throw null;
        }

        public a getResult() {
            a aVar = this.f3469b;
            if (aVar != null) {
                return aVar;
            }
            a(5);
            throw null;
        }
    }

    /* compiled from: OverridingUtil.java */
    public class e extends d0.e0.p.d.m0.n.l1.a {
        public final Map<u0, u0> j;

        public e(Map<u0, u0> map) {
            super(true, true, true, k.this.d);
            this.j = map;
        }

        public static /* synthetic */ void a(int i) {
            Object[] objArr = new Object[3];
            if (i == 1 || i == 3) {
                objArr[0] = "b";
            } else {
                objArr[0] = "a";
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/resolve/OverridingUtil$OverridingUtilTypeCheckerContext";
            if (i == 2 || i == 3) {
                objArr[2] = "areEqualTypeConstructorsByAxioms";
            } else {
                objArr[2] = "areEqualTypeConstructors";
            }
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        /* JADX WARN: Removed duplicated region for block: B:23:0x003f  */
        /* JADX WARN: Removed duplicated region for block: B:37:? A[RETURN, SYNTHETIC] */
        @Override // d0.e0.p.d.m0.n.l1.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public boolean areEqualTypeConstructors(u0 u0Var, u0 u0Var2) {
            boolean z2;
            if (u0Var == null) {
                a(0);
                throw null;
            }
            if (u0Var2 == null) {
                a(1);
                throw null;
            }
            if (!super.areEqualTypeConstructors(u0Var, u0Var2)) {
                if (u0Var == null) {
                    a(2);
                    throw null;
                }
                if (u0Var2 == null) {
                    a(3);
                    throw null;
                }
                if (!k.this.e.equals(u0Var, u0Var2)) {
                    Map<u0, u0> map = this.j;
                    if (map != null) {
                        u0 u0Var3 = map.get(u0Var);
                        u0 u0Var4 = this.j.get(u0Var2);
                        if ((u0Var3 != null && u0Var3.equals(u0Var2)) || (u0Var4 != null && u0Var4.equals(u0Var))) {
                            z2 = true;
                        }
                        if (z2) {
                            return false;
                        }
                    }
                    z2 = false;
                    if (z2) {
                    }
                }
            }
            return true;
        }
    }

    static {
        a aVar = new a();
        c = aVar;
        f3468b = new k(aVar, g.a.a);
    }

    public k(f.a aVar, d0.e0.p.d.m0.n.l1.g gVar) {
        if (aVar == null) {
            a(4);
            throw null;
        }
        if (gVar == null) {
            a(5);
            throw null;
        }
        this.e = aVar;
        this.d = gVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x002d A[FALL_THROUGH] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x004c A[FALL_THROUGH] */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0184  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static /* synthetic */ void a(int i) {
        String str;
        int i2;
        if (i != 9 && i != 10 && i != 14 && i != 19 && i != 93 && i != 96 && i != 101) {
            switch (i) {
                default:
                    switch (i) {
                        default:
                            switch (i) {
                                default:
                                    switch (i) {
                                        case 88:
                                        case 89:
                                        case 90:
                                            break;
                                        default:
                                            str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                                            break;
                                    }
                                case 78:
                                case 79:
                                case 80:
                                case 81:
                                case 82:
                                    break;
                            }
                        case 30:
                        case 31:
                        case 32:
                        case 33:
                        case 34:
                        case 35:
                        case 36:
                        case 37:
                            break;
                    }
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                    break;
            }
        } else {
            str = "@NotNull method %s.%s must not return null";
        }
        if (i != 9 && i != 10 && i != 14 && i != 19 && i != 93 && i != 96 && i != 101) {
            switch (i) {
                default:
                    switch (i) {
                        default:
                            switch (i) {
                                default:
                                    switch (i) {
                                        case 88:
                                        case 89:
                                        case 90:
                                            break;
                                        default:
                                            i2 = 3;
                                            break;
                                    }
                                case 78:
                                case 79:
                                case 80:
                                case 81:
                                case 82:
                                    break;
                            }
                        case 30:
                        case 31:
                        case 32:
                        case 33:
                        case 34:
                        case 35:
                        case 36:
                        case 37:
                            break;
                    }
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                    break;
            }
        } else {
            i2 = 2;
        }
        Object[] objArr = new Object[i2];
        switch (i) {
            case 1:
            case 2:
            case 5:
                objArr[0] = "kotlinTypeRefiner";
                break;
            case 3:
            default:
                objArr[0] = "equalityAxioms";
                break;
            case 4:
                objArr[0] = "axioms";
                break;
            case 6:
            case 7:
                objArr[0] = "candidateSet";
                break;
            case 8:
                objArr[0] = "transformFirst";
                break;
            case 9:
            case 10:
            case 14:
            case 19:
            case 22:
            case 23:
            case 24:
            case 25:
            case 26:
            case 27:
            case 30:
            case 31:
            case 32:
            case 33:
            case 34:
            case 35:
            case 36:
            case 37:
            case 78:
            case 79:
            case 80:
            case 81:
            case 82:
            case 88:
            case 89:
            case 90:
            case 93:
            case 96:
            case 101:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/resolve/OverridingUtil";
                break;
            case 11:
                objArr[0] = "f";
                break;
            case 12:
                objArr[0] = "g";
                break;
            case 13:
            case 15:
                objArr[0] = "descriptor";
                break;
            case 16:
                objArr[0] = "result";
                break;
            case 17:
            case 20:
            case 28:
            case 38:
                objArr[0] = "superDescriptor";
                break;
            case 18:
            case 21:
            case 29:
            case 39:
                objArr[0] = "subDescriptor";
                break;
            case 40:
            case 42:
                objArr[0] = "firstParameters";
                break;
            case 41:
            case 43:
                objArr[0] = "secondParameters";
                break;
            case 44:
                objArr[0] = "typeInSuper";
                break;
            case 45:
                objArr[0] = "typeInSub";
                break;
            case 46:
            case 49:
            case 75:
                objArr[0] = "typeChecker";
                break;
            case 47:
                objArr[0] = "superTypeParameter";
                break;
            case 48:
                objArr[0] = "subTypeParameter";
                break;
            case 50:
                objArr[0] = ModelAuditLogEntry.CHANGE_KEY_NAME;
                break;
            case 51:
                objArr[0] = "membersFromSupertypes";
                break;
            case 52:
                objArr[0] = "membersFromCurrent";
                break;
            case 53:
            case 59:
            case 62:
            case 84:
            case 87:
            case 94:
                objArr[0] = "current";
                break;
            case 54:
            case 60:
            case 64:
            case 85:
            case 104:
                objArr[0] = "strategy";
                break;
            case 55:
                objArr[0] = "overriding";
                break;
            case 56:
                objArr[0] = "fromSuper";
                break;
            case 57:
                objArr[0] = "fromCurrent";
                break;
            case 58:
                objArr[0] = "descriptorsFromSuper";
                break;
            case 61:
            case 63:
                objArr[0] = "notOverridden";
                break;
            case 65:
            case 67:
            case 71:
                objArr[0] = "a";
                break;
            case 66:
            case 68:
            case 73:
                objArr[0] = "b";
                break;
            case 69:
                objArr[0] = "candidate";
                break;
            case 70:
            case 86:
            case 91:
            case 107:
                objArr[0] = "descriptors";
                break;
            case 72:
                objArr[0] = "aReturnType";
                break;
            case 74:
                objArr[0] = "bReturnType";
                break;
            case 76:
            case 83:
                objArr[0] = "overridables";
                break;
            case 77:
            case 99:
                objArr[0] = "descriptorByHandle";
                break;
            case 92:
                objArr[0] = "classModality";
                break;
            case 95:
                objArr[0] = "toFilter";
                break;
            case 97:
            case 102:
                objArr[0] = "overrider";
                break;
            case 98:
            case 103:
                objArr[0] = "extractFrom";
                break;
            case 100:
                objArr[0] = "onConflict";
                break;
            case 105:
            case 106:
                objArr[0] = "memberDescriptor";
                break;
        }
        if (i == 9 || i == 10) {
            objArr[1] = "filterOverrides";
        } else if (i == 14) {
            objArr[1] = "getOverriddenDeclarations";
        } else if (i == 19) {
            objArr[1] = "isOverridableBy";
        } else if (i == 93) {
            objArr[1] = "getMinimalModality";
        } else if (i == 96) {
            objArr[1] = "filterVisibleFakeOverrides";
        } else if (i != 101) {
            switch (i) {
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                    break;
                default:
                    switch (i) {
                        case 30:
                        case 31:
                        case 32:
                        case 33:
                        case 34:
                        case 35:
                        case 36:
                        case 37:
                            objArr[1] = "isOverridableByWithoutExternalConditions";
                            break;
                        default:
                            switch (i) {
                                case 78:
                                case 79:
                                case 80:
                                case 81:
                                case 82:
                                    objArr[1] = "selectMostSpecificMember";
                                    break;
                                default:
                                    switch (i) {
                                        case 88:
                                        case 89:
                                        case 90:
                                            objArr[1] = "determineModalityForFakeOverride";
                                            break;
                                        default:
                                            objArr[1] = "kotlin/reflect/jvm/internal/impl/resolve/OverridingUtil";
                                            break;
                                    }
                                    break;
                            }
                            break;
                    }
                    break;
            }
        } else {
            objArr[1] = "extractMembersOverridableInBothWays";
        }
        switch (i) {
            case 1:
                objArr[2] = "createWithTypeRefiner";
                break;
            case 2:
            case 3:
                objArr[2] = "create";
                break;
            case 4:
            case 5:
                objArr[2] = "<init>";
                break;
            case 6:
                objArr[2] = "filterOutOverridden";
                break;
            case 7:
            case 8:
                objArr[2] = "filterOverrides";
                break;
            case 9:
            case 10:
            case 14:
            case 19:
            case 22:
            case 23:
            case 24:
            case 25:
            case 26:
            case 27:
            case 30:
            case 31:
            case 32:
            case 33:
            case 34:
            case 35:
            case 36:
            case 37:
            case 78:
            case 79:
            case 80:
            case 81:
            case 82:
            case 88:
            case 89:
            case 90:
            case 93:
            case 96:
            case 101:
                break;
            case 11:
            case 12:
                objArr[2] = "overrides";
                break;
            case 13:
                objArr[2] = "getOverriddenDeclarations";
                break;
            case 15:
            case 16:
                objArr[2] = "collectOverriddenDeclarations";
                break;
            case 17:
            case 18:
            case 20:
            case 21:
                objArr[2] = "isOverridableBy";
                break;
            case 28:
            case 29:
                objArr[2] = "isOverridableByWithoutExternalConditions";
                break;
            case 38:
            case 39:
                objArr[2] = "getBasicOverridabilityProblem";
                break;
            case 40:
            case 41:
                objArr[2] = "createTypeChecker";
                break;
            case 42:
            case 43:
                objArr[2] = "createTypeCheckerContext";
                break;
            case 44:
            case 45:
            case 46:
                objArr[2] = "areTypesEquivalent";
                break;
            case 47:
            case 48:
            case 49:
                objArr[2] = "areTypeParametersEquivalent";
                break;
            case 50:
            case 51:
            case 52:
            case 53:
            case 54:
                objArr[2] = "generateOverridesInFunctionGroup";
                break;
            case 55:
            case 56:
                objArr[2] = "isVisibleForOverride";
                break;
            case 57:
            case 58:
            case 59:
            case 60:
                objArr[2] = "extractAndBindOverridesForMember";
                break;
            case 61:
                objArr[2] = "allHasSameContainingDeclaration";
                break;
            case 62:
            case 63:
            case 64:
                objArr[2] = "createAndBindFakeOverrides";
                break;
            case 65:
            case 66:
                objArr[2] = "isMoreSpecific";
                break;
            case 67:
            case 68:
                objArr[2] = "isVisibilityMoreSpecific";
                break;
            case 69:
            case 70:
                objArr[2] = "isMoreSpecificThenAllOf";
                break;
            case 71:
            case 72:
            case 73:
            case 74:
            case 75:
                objArr[2] = "isReturnTypeMoreSpecific";
                break;
            case 76:
            case 77:
                objArr[2] = "selectMostSpecificMember";
                break;
            case 83:
            case 84:
            case 85:
                objArr[2] = "createAndBindFakeOverride";
                break;
            case 86:
            case 87:
                objArr[2] = "determineModalityForFakeOverride";
                break;
            case 91:
            case 92:
                objArr[2] = "getMinimalModality";
                break;
            case 94:
            case 95:
                objArr[2] = "filterVisibleFakeOverrides";
                break;
            case 97:
            case 98:
            case 99:
            case 100:
            case 102:
            case 103:
            case 104:
                objArr[2] = "extractMembersOverridableInBothWays";
                break;
            case 105:
                objArr[2] = "resolveUnknownVisibilityForMember";
                break;
            case 106:
                objArr[2] = "computeVisibilityToInherit";
                break;
            case 107:
                objArr[2] = "findMaxVisibility";
                break;
            default:
                objArr[2] = "createWithEqualityAxioms";
                break;
        }
        String str2 = String.format(str, objArr);
        if (i != 9 && i != 10 && i != 14 && i != 19 && i != 93 && i != 96 && i != 101) {
            switch (i) {
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                    break;
                default:
                    switch (i) {
                        case 30:
                        case 31:
                        case 32:
                        case 33:
                        case 34:
                        case 35:
                        case 36:
                        case 37:
                            break;
                        default:
                            switch (i) {
                                case 78:
                                case 79:
                                case 80:
                                case 81:
                                case 82:
                                    break;
                                default:
                                    switch (i) {
                                        case 88:
                                        case 89:
                                        case 90:
                                            break;
                                        default:
                                            throw new IllegalArgumentException(str2);
                                    }
                                    break;
                            }
                            break;
                    }
                    break;
            }
        }
        throw new IllegalStateException(str2);
    }

    public static void c(d0.e0.p.d.m0.c.b bVar, Set<d0.e0.p.d.m0.c.b> set) {
        if (bVar == null) {
            a(15);
            throw null;
        }
        if (set == null) {
            a(16);
            throw null;
        }
        if (bVar.getKind().isReal()) {
            set.add(bVar);
            return;
        }
        if (bVar.getOverriddenDescriptors().isEmpty()) {
            throw new IllegalStateException("No overridden descriptors found for (fake override) " + bVar);
        }
        Iterator<? extends d0.e0.p.d.m0.c.b> it = bVar.getOverriddenDescriptors().iterator();
        while (it.hasNext()) {
            c(it.next(), set);
        }
    }

    public static k create(d0.e0.p.d.m0.n.l1.g gVar, f.a aVar) {
        if (gVar == null) {
            a(2);
            throw null;
        }
        if (aVar != null) {
            return new k(aVar, gVar);
        }
        a(3);
        throw null;
    }

    public static k createWithTypeRefiner(d0.e0.p.d.m0.n.l1.g gVar) {
        if (gVar != null) {
            return new k(c, gVar);
        }
        a(1);
        throw null;
    }

    public static List<c0> d(d0.e0.p.d.m0.c.a aVar) {
        q0 extensionReceiverParameter = aVar.getExtensionReceiverParameter();
        ArrayList arrayList = new ArrayList();
        if (extensionReceiverParameter != null) {
            arrayList.add(extensionReceiverParameter.getType());
        }
        Iterator<c1> it = aVar.getValueParameters().iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().getType());
        }
        return arrayList;
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x0063, code lost:
    
        r2 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x00f0, code lost:
    
        if (r4 == false) goto L73;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x00f2, code lost:
    
        r0 = d0.e0.p.d.m0.c.t.h;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x00f5, code lost:
    
        r0 = d0.e0.p.d.m0.c.t.g;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x00f7, code lost:
    
        r0 = ((d0.e0.p.d.m0.c.b) selectMostSpecificMember(r6, new d0.e0.p.d.m0.k.k.c())).copy(r12, r2, r0, d0.e0.p.d.m0.c.b.a.FAKE_OVERRIDE, false);
        r13.setOverriddenDescriptors(r0, r6);
        r13.addFakeOverride(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x0111, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void e(Collection<d0.e0.p.d.m0.c.b> collection, d0.e0.p.d.m0.c.e eVar, j jVar) {
        z modality;
        if (collection == null) {
            a(83);
            throw null;
        }
        if (eVar == null) {
            a(84);
            throw null;
        }
        if (jVar == null) {
            a(85);
            throw null;
        }
        if (eVar == null) {
            a(94);
            throw null;
        }
        if (collection == null) {
            a(95);
            throw null;
        }
        List listFilter = u.filter(collection, new m(eVar));
        if (listFilter == null) {
            a(96);
            throw null;
        }
        boolean zIsEmpty = listFilter.isEmpty();
        Collection<? extends d0.e0.p.d.m0.c.b> collection2 = zIsEmpty ? collection : listFilter;
        Iterator<? extends d0.e0.p.d.m0.c.b> it = collection2.iterator();
        boolean z2 = false;
        boolean z3 = false;
        boolean z4 = false;
        while (true) {
            if (it.hasNext()) {
                d0.e0.p.d.m0.c.b next = it.next();
                int iOrdinal = next.getModality().ordinal();
                if (iOrdinal == 0) {
                    modality = z.FINAL;
                    break;
                }
                if (iOrdinal == 1) {
                    throw new IllegalStateException("Member cannot have SEALED modality: " + next);
                }
                if (iOrdinal == 2) {
                    z3 = true;
                } else if (iOrdinal == 3) {
                    z4 = true;
                }
            } else {
                if (eVar.isExpect() && eVar.getModality() != z.ABSTRACT && eVar.getModality() != z.SEALED) {
                    z2 = true;
                }
                if (z3 && !z4) {
                    modality = z.OPEN;
                } else if (z3 || !z4) {
                    HashSet hashSet = new HashSet();
                    Iterator<? extends d0.e0.p.d.m0.c.b> it2 = collection2.iterator();
                    while (it2.hasNext()) {
                        hashSet.addAll(getOverriddenDeclarations(it2.next()));
                    }
                    Set<d0.e0.p.d.m0.c.b> setFilterOutOverridden = filterOutOverridden(hashSet);
                    z modality2 = eVar.getModality();
                    if (setFilterOutOverridden == null) {
                        a(91);
                        throw null;
                    }
                    if (modality2 == null) {
                        a(92);
                        throw null;
                    }
                    z zVar = z.ABSTRACT;
                    for (d0.e0.p.d.m0.c.b bVar : setFilterOutOverridden) {
                        z modality3 = (z2 && bVar.getModality() == z.ABSTRACT) ? modality2 : bVar.getModality();
                        if (modality3.compareTo(zVar) < 0) {
                            zVar = modality3;
                        }
                    }
                    if (zVar == null) {
                        a(93);
                        throw null;
                    }
                    z zVar2 = zVar;
                } else {
                    modality = z2 ? eVar.getModality() : z.ABSTRACT;
                    if (modality == null) {
                        a(90);
                        throw null;
                    }
                }
            }
        }
    }

    public static <H> Collection<H> extractMembersOverridableInBothWays(H h, Collection<H> collection, Function1<H, d0.e0.p.d.m0.c.a> function1, Function1<H, Unit> function12) {
        if (h == null) {
            a(97);
            throw null;
        }
        if (collection == null) {
            a(98);
            throw null;
        }
        if (function1 == null) {
            a(99);
            throw null;
        }
        if (function12 == null) {
            a(100);
            throw null;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(h);
        d0.e0.p.d.m0.c.a aVarInvoke = function1.invoke(h);
        Iterator<H> it = collection.iterator();
        while (it.hasNext()) {
            H next = it.next();
            d0.e0.p.d.m0.c.a aVarInvoke2 = function1.invoke(next);
            if (h == next) {
                it.remove();
            } else {
                d.a bothWaysOverridability = getBothWaysOverridability(aVarInvoke, aVarInvoke2);
                if (bothWaysOverridability == d.a.OVERRIDABLE) {
                    arrayList.add(next);
                    it.remove();
                } else if (bothWaysOverridability == d.a.CONFLICT) {
                    function12.invoke(next);
                    it.remove();
                }
            }
        }
        return arrayList;
    }

    public static <D extends d0.e0.p.d.m0.c.a> Set<D> filterOutOverridden(Set<D> set) {
        if (set != null) {
            return filterOverrides(set, !set.isEmpty() && d0.e0.p.d.m0.k.x.a.isTypeRefinementEnabled(d0.e0.p.d.m0.k.x.a.getModule(set.iterator().next())), null, new b());
        }
        a(6);
        throw null;
    }

    public static <D> Set<D> filterOverrides(Set<D> set, boolean z2, Function0<?> function0, Function2<? super D, ? super D, Pair<d0.e0.p.d.m0.c.a, d0.e0.p.d.m0.c.a>> function2) {
        if (set == null) {
            a(7);
            throw null;
        }
        if (function2 == null) {
            a(8);
            throw null;
        }
        if (set.size() <= 1) {
            return set;
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (Object obj : set) {
            if (function0 != null) {
                function0.invoke();
            }
            Iterator it = linkedHashSet.iterator();
            while (true) {
                if (!it.hasNext()) {
                    linkedHashSet.add(obj);
                    break;
                }
                Pair<d0.e0.p.d.m0.c.a, d0.e0.p.d.m0.c.a> pairInvoke = function2.invoke(obj, (Object) it.next());
                d0.e0.p.d.m0.c.a aVarComponent1 = pairInvoke.component1();
                d0.e0.p.d.m0.c.a aVarComponent2 = pairInvoke.component2();
                if (!overrides(aVarComponent1, aVarComponent2, z2, true)) {
                    if (overrides(aVarComponent2, aVarComponent1, z2, true)) {
                        break;
                    }
                } else {
                    it.remove();
                }
            }
        }
        return linkedHashSet;
    }

    public static d0.e0.p.d.m0.c.u findMaxVisibility(Collection<? extends d0.e0.p.d.m0.c.b> collection) {
        d0.e0.p.d.m0.c.u uVar;
        if (collection == null) {
            a(107);
            throw null;
        }
        if (collection.isEmpty()) {
            return d0.e0.p.d.m0.c.t.k;
        }
        Iterator<? extends d0.e0.p.d.m0.c.b> it = collection.iterator();
        loop0: while (true) {
            uVar = null;
            while (it.hasNext()) {
                d0.e0.p.d.m0.c.u visibility = it.next().getVisibility();
                if (uVar != null) {
                    Integer numCompare = d0.e0.p.d.m0.c.t.compare(visibility, uVar);
                    if (numCompare == null) {
                        break;
                    }
                    if (numCompare.intValue() > 0) {
                    }
                }
                uVar = visibility;
            }
        }
        if (uVar == null) {
            return null;
        }
        Iterator<? extends d0.e0.p.d.m0.c.b> it2 = collection.iterator();
        while (it2.hasNext()) {
            Integer numCompare2 = d0.e0.p.d.m0.c.t.compare(uVar, it2.next().getVisibility());
            if (numCompare2 == null || numCompare2.intValue() < 0) {
                return null;
            }
        }
        return uVar;
    }

    public static boolean g(d0.e0.p.d.m0.c.a aVar, c0 c0Var, d0.e0.p.d.m0.c.a aVar2, c0 c0Var2, Pair<d0.e0.p.d.m0.n.l1.m, d0.e0.p.d.m0.n.l1.a> pair) {
        if (c0Var == null) {
            a(72);
            throw null;
        }
        if (c0Var2 != null) {
            return pair.getFirst().isSubtypeOf(pair.getSecond(), c0Var.unwrap(), c0Var2.unwrap());
        }
        a(74);
        throw null;
    }

    public static d getBasicOverridabilityProblem(d0.e0.p.d.m0.c.a aVar, d0.e0.p.d.m0.c.a aVar2) {
        boolean z2;
        if (aVar == null) {
            a(38);
            throw null;
        }
        if (aVar2 == null) {
            a(39);
            throw null;
        }
        boolean z3 = aVar instanceof x;
        if ((z3 && !(aVar2 instanceof x)) || (((z2 = aVar instanceof n0)) && !(aVar2 instanceof n0))) {
            return d.incompatible("Member kind mismatch");
        }
        if (!z3 && !z2) {
            throw new IllegalArgumentException("This type of CallableDescriptor cannot be checked for overridability: " + aVar);
        }
        if (!aVar.getName().equals(aVar2.getName())) {
            return d.incompatible("Name mismatch");
        }
        d dVarIncompatible = (aVar.getExtensionReceiverParameter() == null) != (aVar2.getExtensionReceiverParameter() == null) ? d.incompatible("Receiver presence mismatch") : aVar.getValueParameters().size() != aVar2.getValueParameters().size() ? d.incompatible("Value parameter number mismatch") : null;
        if (dVarIncompatible != null) {
            return dVarIncompatible;
        }
        return null;
    }

    public static d.a getBothWaysOverridability(d0.e0.p.d.m0.c.a aVar, d0.e0.p.d.m0.c.a aVar2) {
        k kVar = f3468b;
        d.a result = kVar.isOverridableBy(aVar2, aVar, null).getResult();
        d.a result2 = kVar.isOverridableBy(aVar, aVar2, null).getResult();
        d.a aVar3 = d.a.OVERRIDABLE;
        if (result == aVar3 && result2 == aVar3) {
            return aVar3;
        }
        d.a aVar4 = d.a.CONFLICT;
        return (result == aVar4 || result2 == aVar4) ? aVar4 : d.a.INCOMPATIBLE;
    }

    public static Set<d0.e0.p.d.m0.c.b> getOverriddenDeclarations(d0.e0.p.d.m0.c.b bVar) {
        if (bVar == null) {
            a(13);
            throw null;
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        c(bVar, linkedHashSet);
        return linkedHashSet;
    }

    public static boolean h(d0.e0.p.d.m0.c.q qVar, d0.e0.p.d.m0.c.q qVar2) {
        Integer numCompare = d0.e0.p.d.m0.c.t.compare(qVar.getVisibility(), qVar2.getVisibility());
        return numCompare == null || numCompare.intValue() >= 0;
    }

    public static boolean isMoreSpecific(d0.e0.p.d.m0.c.a aVar, d0.e0.p.d.m0.c.a aVar2) {
        if (aVar == null) {
            a(65);
            throw null;
        }
        if (aVar2 == null) {
            a(66);
            throw null;
        }
        c0 returnType = aVar.getReturnType();
        c0 returnType2 = aVar2.getReturnType();
        if (!h(aVar, aVar2)) {
            return false;
        }
        Pair<d0.e0.p.d.m0.n.l1.m, d0.e0.p.d.m0.n.l1.a> pairF = f3468b.f(aVar.getTypeParameters(), aVar2.getTypeParameters());
        if (aVar instanceof x) {
            return g(aVar, returnType, aVar2, returnType2, pairF);
        }
        if (!(aVar instanceof n0)) {
            StringBuilder sbU = b.d.b.a.a.U("Unexpected callable: ");
            sbU.append(aVar.getClass());
            throw new IllegalArgumentException(sbU.toString());
        }
        n0 n0Var = (n0) aVar;
        n0 n0Var2 = (n0) aVar2;
        p0 setter = n0Var.getSetter();
        p0 setter2 = n0Var2.getSetter();
        if ((setter == null || setter2 == null) ? true : h(setter, setter2)) {
            return (n0Var.isVar() && n0Var2.isVar()) ? pairF.getFirst().equalTypes(pairF.getSecond(), returnType.unwrap(), returnType2.unwrap()) : (n0Var.isVar() || !n0Var2.isVar()) && g(aVar, returnType, aVar2, returnType2, pairF);
        }
        return false;
    }

    public static boolean isVisibleForOverride(y yVar, y yVar2) {
        if (yVar == null) {
            a(55);
            throw null;
        }
        if (yVar2 != null) {
            return !d0.e0.p.d.m0.c.t.isPrivate(yVar2.getVisibility()) && d0.e0.p.d.m0.c.t.isVisibleIgnoringReceiver(yVar2, yVar);
        }
        a(56);
        throw null;
    }

    public static <D extends d0.e0.p.d.m0.c.a> boolean overrides(D d2, D d3, boolean z2, boolean z3) {
        if (d2 == null) {
            a(11);
            throw null;
        }
        if (d3 == null) {
            a(12);
            throw null;
        }
        if (!d2.equals(d3) && d0.e0.p.d.m0.k.b.a.areEquivalent(d2.getOriginal(), d3.getOriginal(), z2, z3)) {
            return true;
        }
        d0.e0.p.d.m0.c.a original = d3.getOriginal();
        Iterator it = d0.e0.p.d.m0.k.e.getAllOverriddenDescriptors(d2).iterator();
        while (it.hasNext()) {
            if (d0.e0.p.d.m0.k.b.a.areEquivalent(original, (d0.e0.p.d.m0.c.a) it.next(), z2, z3)) {
                return true;
            }
        }
        return false;
    }

    public static void resolveUnknownVisibilityForMember(d0.e0.p.d.m0.c.b bVar, Function1<d0.e0.p.d.m0.c.b, Unit> function1) {
        d0.e0.p.d.m0.c.u uVar;
        if (bVar == null) {
            a(105);
            throw null;
        }
        for (d0.e0.p.d.m0.c.b bVar2 : bVar.getOverriddenDescriptors()) {
            if (bVar2.getVisibility() == d0.e0.p.d.m0.c.t.g) {
                resolveUnknownVisibilityForMember(bVar2, function1);
            }
        }
        if (bVar.getVisibility() != d0.e0.p.d.m0.c.t.g) {
            return;
        }
        Collection<? extends d0.e0.p.d.m0.c.b> overriddenDescriptors = bVar.getOverriddenDescriptors();
        d0.e0.p.d.m0.c.u uVarFindMaxVisibility = findMaxVisibility(overriddenDescriptors);
        if (uVarFindMaxVisibility == null) {
            uVarFindMaxVisibility = null;
            break;
        }
        if (bVar.getKind() == b.a.FAKE_OVERRIDE) {
            for (d0.e0.p.d.m0.c.b bVar3 : overriddenDescriptors) {
                if (bVar3.getModality() != z.ABSTRACT && !bVar3.getVisibility().equals(uVarFindMaxVisibility)) {
                    uVarFindMaxVisibility = null;
                    break;
                }
            }
        } else {
            uVarFindMaxVisibility = uVarFindMaxVisibility.normalize();
        }
        if (uVarFindMaxVisibility == null) {
            if (function1 != null) {
                function1.invoke(bVar);
            }
            uVar = d0.e0.p.d.m0.c.t.e;
        } else {
            uVar = uVarFindMaxVisibility;
        }
        if (bVar instanceof d0.e0.p.d.m0.c.i1.c0) {
            ((d0.e0.p.d.m0.c.i1.c0) bVar).setVisibility(uVar);
            Iterator<m0> it = ((n0) bVar).getAccessors().iterator();
            while (it.hasNext()) {
                resolveUnknownVisibilityForMember(it.next(), uVarFindMaxVisibility == null ? null : function1);
            }
            return;
        }
        if (bVar instanceof d0.e0.p.d.m0.c.i1.q) {
            ((d0.e0.p.d.m0.c.i1.q) bVar).setVisibility(uVar);
            return;
        }
        b0 b0Var = (b0) bVar;
        b0Var.setVisibility(uVar);
        if (uVar != b0Var.getCorrespondingProperty().getVisibility()) {
            b0Var.setDefault(false);
        }
    }

    public static <H> H selectMostSpecificMember(Collection<H> collection, Function1<H, d0.e0.p.d.m0.c.a> function1) {
        H h;
        boolean z2;
        if (collection == null) {
            a(76);
            throw null;
        }
        if (function1 == null) {
            a(77);
            throw null;
        }
        if (collection.size() == 1) {
            H h2 = (H) u.first(collection);
            if (h2 != null) {
                return h2;
            }
            a(78);
            throw null;
        }
        ArrayList arrayList = new ArrayList(2);
        List map = u.map(collection, function1);
        H h3 = (H) u.first(collection);
        d0.e0.p.d.m0.c.a aVarInvoke = function1.invoke(h3);
        for (H h4 : collection) {
            d0.e0.p.d.m0.c.a aVarInvoke2 = function1.invoke(h4);
            if (aVarInvoke2 == null) {
                a(69);
                throw null;
            }
            if (map == null) {
                a(70);
                throw null;
            }
            Iterator it = map.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z2 = true;
                    break;
                }
                if (!isMoreSpecific(aVarInvoke2, (d0.e0.p.d.m0.c.a) it.next())) {
                    z2 = false;
                    break;
                }
            }
            if (z2) {
                arrayList.add(h4);
            }
            if (isMoreSpecific(aVarInvoke2, aVarInvoke) && !isMoreSpecific(aVarInvoke, aVarInvoke2)) {
                h3 = h4;
            }
        }
        if (arrayList.isEmpty()) {
            if (h3 != null) {
                return h3;
            }
            a(79);
            throw null;
        }
        if (arrayList.size() == 1) {
            H h5 = (H) u.first((Iterable) arrayList);
            if (h5 != null) {
                return h5;
            }
            a(80);
            throw null;
        }
        Iterator it2 = arrayList.iterator();
        while (true) {
            if (!it2.hasNext()) {
                h = null;
                break;
            }
            h = (H) it2.next();
            if (!d0.e0.p.d.m0.n.y.isFlexible(function1.invoke(h).getReturnType())) {
                break;
            }
        }
        if (h != null) {
            return h;
        }
        H h6 = (H) u.first((Iterable) arrayList);
        if (h6 != null) {
            return h6;
        }
        a(82);
        throw null;
    }

    public final boolean b(c0 c0Var, c0 c0Var2, Pair<d0.e0.p.d.m0.n.l1.m, d0.e0.p.d.m0.n.l1.a> pair) {
        if (c0Var == null) {
            a(44);
            throw null;
        }
        if (c0Var2 == null) {
            a(45);
            throw null;
        }
        if (pair == null) {
            a(46);
            throw null;
        }
        if (e0.isError(c0Var) && e0.isError(c0Var2)) {
            return true;
        }
        return pair.getFirst().equalTypes(pair.getSecond(), c0Var.unwrap(), c0Var2.unwrap());
    }

    public final Pair<d0.e0.p.d.m0.n.l1.m, d0.e0.p.d.m0.n.l1.a> f(List<z0> list, List<z0> list2) {
        e eVar;
        if (list == null) {
            a(40);
            throw null;
        }
        if (list2 == null) {
            a(41);
            throw null;
        }
        d0.e0.p.d.m0.n.l1.m mVar = new d0.e0.p.d.m0.n.l1.m(this.d);
        if (list == null) {
            a(42);
            throw null;
        }
        if (list2 == null) {
            a(43);
            throw null;
        }
        if (list.isEmpty()) {
            eVar = new e(null);
        } else {
            HashMap map = new HashMap();
            for (int i = 0; i < list.size(); i++) {
                map.put(list.get(i).getTypeConstructor(), list2.get(i).getTypeConstructor());
            }
            eVar = new e(map);
        }
        return new Pair<>(mVar, eVar);
    }

    public void generateOverridesInFunctionGroup(d0.e0.p.d.m0.g.e eVar, Collection<? extends d0.e0.p.d.m0.c.b> collection, Collection<? extends d0.e0.p.d.m0.c.b> collection2, d0.e0.p.d.m0.c.e eVar2, j jVar) {
        if (eVar == null) {
            a(50);
            throw null;
        }
        if (collection == null) {
            a(51);
            throw null;
        }
        if (collection2 == null) {
            a(52);
            throw null;
        }
        if (eVar2 == null) {
            a(53);
            throw null;
        }
        if (jVar == null) {
            a(54);
            throw null;
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet(collection);
        for (d0.e0.p.d.m0.c.b bVar : collection2) {
            if (bVar == null) {
                a(57);
                throw null;
            }
            if (collection == null) {
                a(58);
                throw null;
            }
            if (eVar2 == null) {
                a(59);
                throw null;
            }
            if (jVar == null) {
                a(60);
                throw null;
            }
            ArrayList arrayList = new ArrayList(collection.size());
            d0.e0.p.d.m0.p.j jVarCreate = d0.e0.p.d.m0.p.j.create();
            for (d0.e0.p.d.m0.c.b bVar2 : collection) {
                d.a result = isOverridableBy(bVar2, bVar, eVar2).getResult();
                boolean zIsVisibleForOverride = isVisibleForOverride(bVar, bVar2);
                int iOrdinal = result.ordinal();
                if (iOrdinal == 0) {
                    if (zIsVisibleForOverride) {
                        jVarCreate.add(bVar2);
                    }
                    arrayList.add(bVar2);
                } else if (iOrdinal == 2) {
                    if (zIsVisibleForOverride) {
                        jVar.overrideConflict(bVar2, bVar);
                    }
                    arrayList.add(bVar2);
                }
            }
            jVar.setOverriddenDescriptors(bVar, jVarCreate);
            linkedHashSet.removeAll(arrayList);
        }
        if (eVar2 == null) {
            a(62);
            throw null;
        }
        if (jVar == null) {
            a(64);
            throw null;
        }
        if (linkedHashSet.size() < 2 ? true : u.all(linkedHashSet, new l(((d0.e0.p.d.m0.c.b) linkedHashSet.iterator().next()).getContainingDeclaration()))) {
            Iterator it = linkedHashSet.iterator();
            while (it.hasNext()) {
                e(Collections.singleton((d0.e0.p.d.m0.c.b) it.next()), eVar2, jVar);
            }
            return;
        }
        LinkedList linkedList = new LinkedList(linkedHashSet);
        while (!linkedList.isEmpty()) {
            d0.e0.p.d.m0.c.b bVarFindMemberWithMaxVisibility = t.findMemberWithMaxVisibility(linkedList);
            if (bVarFindMemberWithMaxVisibility == null) {
                a(102);
                throw null;
            }
            e(extractMembersOverridableInBothWays(bVarFindMemberWithMaxVisibility, linkedList, new n(), new o(jVar, bVarFindMemberWithMaxVisibility)), eVar2, jVar);
        }
    }

    public d isOverridableBy(d0.e0.p.d.m0.c.a aVar, d0.e0.p.d.m0.c.a aVar2, d0.e0.p.d.m0.c.e eVar) {
        if (aVar == null) {
            a(17);
            throw null;
        }
        if (aVar2 == null) {
            a(18);
            throw null;
        }
        d dVarIsOverridableBy = isOverridableBy(aVar, aVar2, eVar, false);
        if (dVarIsOverridableBy != null) {
            return dVarIsOverridableBy;
        }
        a(19);
        throw null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:43:0x00c9, code lost:
    
        r15.remove();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public d isOverridableByWithoutExternalConditions(d0.e0.p.d.m0.c.a aVar, d0.e0.p.d.m0.c.a aVar2, boolean z2) {
        if (aVar == null) {
            a(28);
            throw null;
        }
        if (aVar2 == null) {
            a(29);
            throw null;
        }
        d basicOverridabilityProblem = getBasicOverridabilityProblem(aVar, aVar2);
        if (basicOverridabilityProblem != null) {
            return basicOverridabilityProblem;
        }
        List<c0> listD = d(aVar);
        List<c0> listD2 = d(aVar2);
        List<z0> typeParameters = aVar.getTypeParameters();
        List<z0> typeParameters2 = aVar2.getTypeParameters();
        if (typeParameters.size() != typeParameters2.size()) {
            int i = 0;
            while (true) {
                ArrayList arrayList = (ArrayList) listD;
                if (i >= arrayList.size()) {
                    d dVarConflict = d.conflict("Type parameter number mismatch");
                    if (dVarConflict != null) {
                        return dVarConflict;
                    }
                    a(32);
                    throw null;
                }
                if (!d0.e0.p.d.m0.n.l1.f.a.equalTypes((c0) arrayList.get(i), (c0) ((ArrayList) listD2).get(i))) {
                    d dVarIncompatible = d.incompatible("Type parameter number mismatch");
                    if (dVarIncompatible != null) {
                        return dVarIncompatible;
                    }
                    a(31);
                    throw null;
                }
                i++;
            }
        } else {
            Pair<d0.e0.p.d.m0.n.l1.m, d0.e0.p.d.m0.n.l1.a> pairF = f(typeParameters, typeParameters2);
            int i2 = 0;
            while (true) {
                boolean z3 = true;
                if (i2 < typeParameters.size()) {
                    z0 z0Var = typeParameters.get(i2);
                    z0 z0Var2 = typeParameters2.get(i2);
                    if (z0Var == null) {
                        a(47);
                        throw null;
                    }
                    if (z0Var2 == null) {
                        a(48);
                        throw null;
                    }
                    List<c0> upperBounds = z0Var.getUpperBounds();
                    ArrayList arrayList2 = new ArrayList(z0Var2.getUpperBounds());
                    if (upperBounds.size() != arrayList2.size()) {
                        z3 = false;
                        break;
                    }
                    for (c0 c0Var : upperBounds) {
                        ListIterator listIterator = arrayList2.listIterator();
                        while (listIterator.hasNext()) {
                            if (b(c0Var, (c0) listIterator.next(), pairF)) {
                                break;
                            }
                        }
                        z3 = false;
                    }
                    if (!z3) {
                        d dVarIncompatible2 = d.incompatible("Type parameter bounds mismatch");
                        if (dVarIncompatible2 != null) {
                            return dVarIncompatible2;
                        }
                        a(33);
                        throw null;
                    }
                    i2++;
                } else {
                    int i3 = 0;
                    while (true) {
                        ArrayList arrayList3 = (ArrayList) listD;
                        if (i3 >= arrayList3.size()) {
                            if ((aVar instanceof x) && (aVar2 instanceof x) && ((x) aVar).isSuspend() != ((x) aVar2).isSuspend()) {
                                d dVarConflict2 = d.conflict("Incompatible suspendability");
                                if (dVarConflict2 != null) {
                                    return dVarConflict2;
                                }
                                a(35);
                                throw null;
                            }
                            if (z2) {
                                c0 returnType = aVar.getReturnType();
                                c0 returnType2 = aVar2.getReturnType();
                                if (returnType != null && returnType2 != null) {
                                    if (!(e0.isError(returnType2) && e0.isError(returnType)) && !pairF.getFirst().isSubtypeOf(pairF.getSecond(), returnType2.unwrap(), returnType.unwrap())) {
                                        d dVarConflict3 = d.conflict("Return type mismatch");
                                        if (dVarConflict3 != null) {
                                            return dVarConflict3;
                                        }
                                        a(36);
                                        throw null;
                                    }
                                }
                            }
                            d dVarSuccess = d.success();
                            if (dVarSuccess != null) {
                                return dVarSuccess;
                            }
                            a(37);
                            throw null;
                        }
                        if (!b((c0) arrayList3.get(i3), (c0) ((ArrayList) listD2).get(i3), pairF)) {
                            d dVarIncompatible3 = d.incompatible("Value parameter type mismatch");
                            if (dVarIncompatible3 != null) {
                                return dVarIncompatible3;
                            }
                            a(34);
                            throw null;
                        }
                        i3++;
                    }
                }
            }
        }
    }

    public d isOverridableBy(d0.e0.p.d.m0.c.a aVar, d0.e0.p.d.m0.c.a aVar2, d0.e0.p.d.m0.c.e eVar, boolean z2) {
        f.a aVar3 = f.a.CONFLICTS_ONLY;
        if (aVar == null) {
            a(20);
            throw null;
        }
        if (aVar2 != null) {
            d dVarIsOverridableByWithoutExternalConditions = isOverridableByWithoutExternalConditions(aVar, aVar2, z2);
            boolean z3 = dVarIsOverridableByWithoutExternalConditions.getResult() == d.a.OVERRIDABLE;
            for (f fVar : a) {
                if (fVar.getContract() != aVar3 && (!z3 || fVar.getContract() != f.a.SUCCESS_ONLY)) {
                    int iOrdinal = fVar.isOverridable(aVar, aVar2, eVar).ordinal();
                    if (iOrdinal == 0) {
                        z3 = true;
                    } else {
                        if (iOrdinal == 1) {
                            d dVarConflict = d.conflict("External condition failed");
                            if (dVarConflict != null) {
                                return dVarConflict;
                            }
                            a(22);
                            throw null;
                        }
                        if (iOrdinal == 2) {
                            d dVarIncompatible = d.incompatible("External condition");
                            if (dVarIncompatible != null) {
                                return dVarIncompatible;
                            }
                            a(23);
                            throw null;
                        }
                    }
                }
            }
            if (!z3) {
                return dVarIsOverridableByWithoutExternalConditions;
            }
            for (f fVar2 : a) {
                if (fVar2.getContract() == aVar3) {
                    int iOrdinal2 = fVar2.isOverridable(aVar, aVar2, eVar).ordinal();
                    if (iOrdinal2 == 0) {
                        StringBuilder sbU = b.d.b.a.a.U("Contract violation in ");
                        sbU.append(fVar2.getClass().getName());
                        sbU.append(" condition. It's not supposed to end with success");
                        throw new IllegalStateException(sbU.toString());
                    }
                    if (iOrdinal2 == 1) {
                        d dVarConflict2 = d.conflict("External condition failed");
                        if (dVarConflict2 != null) {
                            return dVarConflict2;
                        }
                        a(25);
                        throw null;
                    }
                    if (iOrdinal2 == 2) {
                        d dVarIncompatible2 = d.incompatible("External condition");
                        if (dVarIncompatible2 != null) {
                            return dVarIncompatible2;
                        }
                        a(26);
                        throw null;
                    }
                }
            }
            d dVarSuccess = d.success();
            if (dVarSuccess != null) {
                return dVarSuccess;
            }
            a(27);
            throw null;
        }
        a(21);
        throw null;
    }
}

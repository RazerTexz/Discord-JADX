package d0.e0.p.d.m0.e.a.g0;

import com.discord.models.domain.ModelAuditLogEntry;
import d0.e0.p.d.m0.c.b;
import d0.e0.p.d.m0.c.c1;
import d0.e0.p.d.m0.l.b.p;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: DescriptorResolverUtils.java */
/* loaded from: classes3.dex */
public final class a {

    /* compiled from: DescriptorResolverUtils.java */
    /* renamed from: d0.e0.p.d.m0.e.a.g0.a$a, reason: collision with other inner class name */
    public static class C0520a extends d0.e0.p.d.m0.k.i {
        public final /* synthetic */ p a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Set f3313b;
        public final /* synthetic */ boolean c;

        /* compiled from: DescriptorResolverUtils.java */
        /* renamed from: d0.e0.p.d.m0.e.a.g0.a$a$a, reason: collision with other inner class name */
        public class C0521a implements Function1<d0.e0.p.d.m0.c.b, Unit> {
            public C0521a() {
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(d0.e0.p.d.m0.c.b bVar) {
                return invoke2(bVar);
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public Unit invoke2(d0.e0.p.d.m0.c.b bVar) {
                if (bVar == null) {
                    throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "descriptor", "kotlin/reflect/jvm/internal/impl/load/java/components/DescriptorResolverUtils$1$1", "invoke"));
                }
                C0520a.this.a.reportCannotInferVisibility(bVar);
                return Unit.a;
            }
        }

        public C0520a(p pVar, Set set, boolean z2) {
            this.a = pVar;
            this.f3313b = set;
            this.c = z2;
        }

        public static /* synthetic */ void a(int i) {
            Object[] objArr = new Object[3];
            if (i == 1) {
                objArr[0] = "fromSuper";
            } else if (i == 2) {
                objArr[0] = "fromCurrent";
            } else if (i == 3) {
                objArr[0] = "member";
            } else if (i != 4) {
                objArr[0] = "fakeOverride";
            } else {
                objArr[0] = "overridden";
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/load/java/components/DescriptorResolverUtils$1";
            if (i == 1 || i == 2) {
                objArr[2] = "conflict";
            } else if (i == 3 || i == 4) {
                objArr[2] = "setOverriddenDescriptors";
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
            d0.e0.p.d.m0.k.k.resolveUnknownVisibilityForMember(bVar, new C0521a());
            this.f3313b.add(bVar);
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

        @Override // d0.e0.p.d.m0.k.j
        public void setOverriddenDescriptors(d0.e0.p.d.m0.c.b bVar, Collection<? extends d0.e0.p.d.m0.c.b> collection) {
            if (bVar == null) {
                a(3);
                throw null;
            }
            if (collection == null) {
                a(4);
                throw null;
            }
            if (!this.c || bVar.getKind() == b.a.FAKE_OVERRIDE) {
                super.setOverriddenDescriptors(bVar, collection);
            }
        }
    }

    public static /* synthetic */ void a(int i) {
        String str = i != 18 ? "Argument for @NotNull parameter '%s' of %s.%s must not be null" : "@NotNull method %s.%s must not return null";
        Object[] objArr = new Object[i != 18 ? 3 : 2];
        switch (i) {
            case 1:
            case 7:
            case 13:
                objArr[0] = "membersFromSupertypes";
                break;
            case 2:
            case 8:
            case 14:
                objArr[0] = "membersFromCurrent";
                break;
            case 3:
            case 9:
            case 15:
                objArr[0] = "classDescriptor";
                break;
            case 4:
            case 10:
            case 16:
                objArr[0] = "errorReporter";
                break;
            case 5:
            case 11:
            case 17:
                objArr[0] = "overridingUtil";
                break;
            case 6:
            case 12:
            case 19:
            default:
                objArr[0] = ModelAuditLogEntry.CHANGE_KEY_NAME;
                break;
            case 18:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/load/java/components/DescriptorResolverUtils";
                break;
            case 20:
                objArr[0] = "annotationClass";
                break;
        }
        if (i != 18) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/load/java/components/DescriptorResolverUtils";
        } else {
            objArr[1] = "resolveOverrides";
        }
        switch (i) {
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
                objArr[2] = "resolveOverridesForStaticMembers";
                break;
            case 12:
            case 13:
            case 14:
            case 15:
            case 16:
            case 17:
                objArr[2] = "resolveOverrides";
                break;
            case 18:
                break;
            case 19:
            case 20:
                objArr[2] = "getAnnotationParameterByName";
                break;
            default:
                objArr[2] = "resolveOverridesForNonStaticMembers";
                break;
        }
        String str2 = String.format(str, objArr);
        if (i == 18) {
            throw new IllegalStateException(str2);
        }
    }

    public static <D extends d0.e0.p.d.m0.c.b> Collection<D> b(d0.e0.p.d.m0.g.e eVar, Collection<D> collection, Collection<D> collection2, d0.e0.p.d.m0.c.e eVar2, p pVar, d0.e0.p.d.m0.k.k kVar, boolean z2) {
        if (eVar == null) {
            a(12);
            throw null;
        }
        if (collection == null) {
            a(13);
            throw null;
        }
        if (collection2 == null) {
            a(14);
            throw null;
        }
        if (eVar2 == null) {
            a(15);
            throw null;
        }
        if (pVar == null) {
            a(16);
            throw null;
        }
        if (kVar == null) {
            a(17);
            throw null;
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        kVar.generateOverridesInFunctionGroup(eVar, collection, collection2, eVar2, new C0520a(pVar, linkedHashSet, z2));
        return linkedHashSet;
    }

    public static c1 getAnnotationParameterByName(d0.e0.p.d.m0.g.e eVar, d0.e0.p.d.m0.c.e eVar2) {
        if (eVar == null) {
            a(19);
            throw null;
        }
        if (eVar2 == null) {
            a(20);
            throw null;
        }
        Collection<d0.e0.p.d.m0.c.d> constructors = eVar2.getConstructors();
        if (constructors.size() != 1) {
            return null;
        }
        for (c1 c1Var : constructors.iterator().next().getValueParameters()) {
            if (c1Var.getName().equals(eVar)) {
                return c1Var;
            }
        }
        return null;
    }

    public static <D extends d0.e0.p.d.m0.c.b> Collection<D> resolveOverridesForNonStaticMembers(d0.e0.p.d.m0.g.e eVar, Collection<D> collection, Collection<D> collection2, d0.e0.p.d.m0.c.e eVar2, p pVar, d0.e0.p.d.m0.k.k kVar) {
        if (eVar == null) {
            a(0);
            throw null;
        }
        if (collection == null) {
            a(1);
            throw null;
        }
        if (collection2 == null) {
            a(2);
            throw null;
        }
        if (eVar2 == null) {
            a(3);
            throw null;
        }
        if (pVar == null) {
            a(4);
            throw null;
        }
        if (kVar != null) {
            return b(eVar, collection, collection2, eVar2, pVar, kVar, false);
        }
        a(5);
        throw null;
    }

    public static <D extends d0.e0.p.d.m0.c.b> Collection<D> resolveOverridesForStaticMembers(d0.e0.p.d.m0.g.e eVar, Collection<D> collection, Collection<D> collection2, d0.e0.p.d.m0.c.e eVar2, p pVar, d0.e0.p.d.m0.k.k kVar) {
        if (eVar == null) {
            a(6);
            throw null;
        }
        if (collection == null) {
            a(7);
            throw null;
        }
        if (collection2 == null) {
            a(8);
            throw null;
        }
        if (eVar2 == null) {
            a(9);
            throw null;
        }
        if (pVar == null) {
            a(10);
            throw null;
        }
        if (kVar != null) {
            return b(eVar, collection, collection2, eVar2, pVar, kVar, true);
        }
        a(11);
        throw null;
    }
}

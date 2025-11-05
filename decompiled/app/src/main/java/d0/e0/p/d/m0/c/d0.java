package d0.e0.p.d.m0.c;

import androidx.exifinterface.media.ExifInterface;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.e0.p.d.m0.k.a0.i;
import d0.e0.p.d.m0.m.f;
import d0.e0.p.d.m0.n.j1;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.ranges.IntRange;

/* compiled from: NotFoundClasses.kt */
/* loaded from: classes3.dex */
public final class d0 {
    public final d0.e0.p.d.m0.m.o a;

    /* renamed from: b, reason: collision with root package name */
    public final c0 f3243b;
    public final d0.e0.p.d.m0.m.h<d0.e0.p.d.m0.g.b, e0> c;
    public final d0.e0.p.d.m0.m.h<a, e> d;

    /* compiled from: NotFoundClasses.kt */
    public static final class a {
        public final d0.e0.p.d.m0.g.a a;

        /* renamed from: b, reason: collision with root package name */
        public final List<Integer> f3244b;

        public a(d0.e0.p.d.m0.g.a aVar, List<Integer> list) {
            d0.z.d.m.checkNotNullParameter(aVar, "classId");
            d0.z.d.m.checkNotNullParameter(list, "typeParametersCount");
            this.a = aVar;
            this.f3244b = list;
        }

        public final d0.e0.p.d.m0.g.a component1() {
            return this.a;
        }

        public final List<Integer> component2() {
            return this.f3244b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return d0.z.d.m.areEqual(this.a, aVar.a) && d0.z.d.m.areEqual(this.f3244b, aVar.f3244b);
        }

        public int hashCode() {
            return this.f3244b.hashCode() + (this.a.hashCode() * 31);
        }

        public String toString() {
            StringBuilder sbU = b.d.b.a.a.U("ClassRequest(classId=");
            sbU.append(this.a);
            sbU.append(", typeParametersCount=");
            sbU.append(this.f3244b);
            sbU.append(')');
            return sbU.toString();
        }
    }

    /* compiled from: NotFoundClasses.kt */
    public static final class b extends d0.e0.p.d.m0.c.i1.h {
        public final boolean r;

        /* renamed from: s, reason: collision with root package name */
        public final List<z0> f3245s;
        public final d0.e0.p.d.m0.n.i t;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(d0.e0.p.d.m0.m.o oVar, m mVar, d0.e0.p.d.m0.g.e eVar, boolean z2, int i) {
            super(oVar, mVar, eVar, u0.a, false);
            d0.z.d.m.checkNotNullParameter(oVar, "storageManager");
            d0.z.d.m.checkNotNullParameter(mVar, "container");
            d0.z.d.m.checkNotNullParameter(eVar, ModelAuditLogEntry.CHANGE_KEY_NAME);
            this.r = z2;
            IntRange intRangeUntil = d0.d0.f.until(0, i);
            ArrayList arrayList = new ArrayList(d0.t.o.collectionSizeOrDefault(intRangeUntil, 10));
            Iterator<Integer> it = intRangeUntil.iterator();
            while (it.hasNext()) {
                int iNextInt = ((d0.t.c0) it).nextInt();
                arrayList.add(d0.e0.p.d.m0.c.i1.k0.createWithDefaultBound(this, d0.e0.p.d.m0.c.g1.g.f.getEMPTY(), false, j1.INVARIANT, d0.e0.p.d.m0.g.e.identifier(d0.z.d.m.stringPlus(ExifInterface.GPS_DIRECTION_TRUE, Integer.valueOf(iNextInt))), iNextInt, oVar));
            }
            this.f3245s = arrayList;
            this.t = new d0.e0.p.d.m0.n.i(this, a1.computeConstructorTypeParameters(this), d0.t.m0.setOf(d0.e0.p.d.m0.k.x.a.getModule(this).getBuiltIns().getAnyType()), oVar);
        }

        @Override // d0.e0.p.d.m0.c.g1.a
        public d0.e0.p.d.m0.c.g1.g getAnnotations() {
            return d0.e0.p.d.m0.c.g1.g.f.getEMPTY();
        }

        @Override // d0.e0.p.d.m0.c.e
        public e getCompanionObjectDescriptor() {
            return null;
        }

        @Override // d0.e0.p.d.m0.c.e
        public Collection<d0.e0.p.d.m0.c.d> getConstructors() {
            return d0.t.n0.emptySet();
        }

        @Override // d0.e0.p.d.m0.c.e, d0.e0.p.d.m0.c.i
        public List<z0> getDeclaredTypeParameters() {
            return this.f3245s;
        }

        @Override // d0.e0.p.d.m0.c.e
        public f getKind() {
            return f.CLASS;
        }

        @Override // d0.e0.p.d.m0.c.e, d0.e0.p.d.m0.c.y
        public z getModality() {
            return z.FINAL;
        }

        @Override // d0.e0.p.d.m0.c.e
        public Collection<e> getSealedSubclasses() {
            return d0.t.n.emptyList();
        }

        @Override // d0.e0.p.d.m0.c.e
        public /* bridge */ /* synthetic */ d0.e0.p.d.m0.k.a0.i getStaticScope() {
            return getStaticScope();
        }

        @Override // d0.e0.p.d.m0.c.h
        public /* bridge */ /* synthetic */ d0.e0.p.d.m0.n.u0 getTypeConstructor() {
            return getTypeConstructor();
        }

        @Override // d0.e0.p.d.m0.c.i1.u
        public d0.e0.p.d.m0.k.a0.i getUnsubstitutedMemberScope(d0.e0.p.d.m0.n.l1.g gVar) {
            d0.z.d.m.checkNotNullParameter(gVar, "kotlinTypeRefiner");
            return i.b.f3461b;
        }

        @Override // d0.e0.p.d.m0.c.e
        public d0.e0.p.d.m0.c.d getUnsubstitutedPrimaryConstructor() {
            return null;
        }

        @Override // d0.e0.p.d.m0.c.e, d0.e0.p.d.m0.c.q, d0.e0.p.d.m0.c.y
        public u getVisibility() {
            u uVar = t.e;
            d0.z.d.m.checkNotNullExpressionValue(uVar, "PUBLIC");
            return uVar;
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

        @Override // d0.e0.p.d.m0.c.i1.h, d0.e0.p.d.m0.c.y
        public boolean isExternal() {
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
            return this.r;
        }

        @Override // d0.e0.p.d.m0.c.e
        public boolean isValue() {
            return false;
        }

        public String toString() {
            StringBuilder sbU = b.d.b.a.a.U("class ");
            sbU.append(getName());
            sbU.append(" (not found)");
            return sbU.toString();
        }

        @Override // d0.e0.p.d.m0.c.e
        public i.b getStaticScope() {
            return i.b.f3461b;
        }

        @Override // d0.e0.p.d.m0.c.h
        public d0.e0.p.d.m0.n.i getTypeConstructor() {
            return this.t;
        }
    }

    /* compiled from: NotFoundClasses.kt */
    public static final class c extends d0.z.d.o implements Function1<a, e> {
        public c() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ e invoke(a aVar) {
            return invoke2(aVar);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final e invoke2(a aVar) {
            d0.z.d.m.checkNotNullParameter(aVar, "$dstr$classId$typeParametersCount");
            d0.e0.p.d.m0.g.a aVarComponent1 = aVar.component1();
            List<Integer> listComponent2 = aVar.component2();
            if (aVarComponent1.isLocal()) {
                throw new UnsupportedOperationException(d0.z.d.m.stringPlus("Unresolved local class: ", aVarComponent1));
            }
            d0.e0.p.d.m0.g.a outerClassId = aVarComponent1.getOuterClassId();
            g gVar = outerClassId == null ? null : d0.this.getClass(outerClassId, d0.t.u.drop(listComponent2, 1));
            if (gVar == null) {
                d0.e0.p.d.m0.m.h hVarAccess$getPackageFragments$p = d0.access$getPackageFragments$p(d0.this);
                d0.e0.p.d.m0.g.b packageFqName = aVarComponent1.getPackageFqName();
                d0.z.d.m.checkNotNullExpressionValue(packageFqName, "classId.packageFqName");
                gVar = (g) ((f.m) hVarAccess$getPackageFragments$p).invoke(packageFqName);
            }
            g gVar2 = gVar;
            boolean zIsNestedClass = aVarComponent1.isNestedClass();
            d0.e0.p.d.m0.m.o oVarAccess$getStorageManager$p = d0.access$getStorageManager$p(d0.this);
            d0.e0.p.d.m0.g.e shortClassName = aVarComponent1.getShortClassName();
            d0.z.d.m.checkNotNullExpressionValue(shortClassName, "classId.shortClassName");
            Integer num = (Integer) d0.t.u.firstOrNull((List) listComponent2);
            return new b(oVarAccess$getStorageManager$p, gVar2, shortClassName, zIsNestedClass, num == null ? 0 : num.intValue());
        }
    }

    /* compiled from: NotFoundClasses.kt */
    public static final class d extends d0.z.d.o implements Function1<d0.e0.p.d.m0.g.b, e0> {
        public d() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ e0 invoke(d0.e0.p.d.m0.g.b bVar) {
            return invoke2(bVar);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final e0 invoke2(d0.e0.p.d.m0.g.b bVar) {
            d0.z.d.m.checkNotNullParameter(bVar, "fqName");
            return new d0.e0.p.d.m0.c.i1.n(d0.access$getModule$p(d0.this), bVar);
        }
    }

    public d0(d0.e0.p.d.m0.m.o oVar, c0 c0Var) {
        d0.z.d.m.checkNotNullParameter(oVar, "storageManager");
        d0.z.d.m.checkNotNullParameter(c0Var, "module");
        this.a = oVar;
        this.f3243b = c0Var;
        this.c = oVar.createMemoizedFunction(new d());
        this.d = oVar.createMemoizedFunction(new c());
    }

    public static final /* synthetic */ c0 access$getModule$p(d0 d0Var) {
        return d0Var.f3243b;
    }

    public static final /* synthetic */ d0.e0.p.d.m0.m.h access$getPackageFragments$p(d0 d0Var) {
        return d0Var.c;
    }

    public static final /* synthetic */ d0.e0.p.d.m0.m.o access$getStorageManager$p(d0 d0Var) {
        return d0Var.a;
    }

    public final e getClass(d0.e0.p.d.m0.g.a aVar, List<Integer> list) {
        d0.z.d.m.checkNotNullParameter(aVar, "classId");
        d0.z.d.m.checkNotNullParameter(list, "typeParametersCount");
        return (e) ((f.m) this.d).invoke(new a(aVar, list));
    }
}

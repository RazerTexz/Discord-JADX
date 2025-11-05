package d0.e0.p.d.m0.l.b;

import d0.e0.p.d.m0.b.k;
import d0.e0.p.d.m0.c.e0;
import d0.e0.p.d.m0.c.f0;
import d0.e0.p.d.m0.c.h0;
import d0.e0.p.d.m0.c.u0;
import d0.e0.p.d.m0.f.z.i;
import d0.t.m0;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: ClassDeserializer.kt */
/* loaded from: classes3.dex */
public final class h {
    public static final b a = new b(null);

    /* renamed from: b, reason: collision with root package name */
    public static final Set<d0.e0.p.d.m0.g.a> f3500b = m0.setOf(d0.e0.p.d.m0.g.a.topLevel(k.a.d.toSafe()));
    public final j c;
    public final Function1<a, d0.e0.p.d.m0.c.e> d;

    /* compiled from: ClassDeserializer.kt */
    public static final class a {
        public final d0.e0.p.d.m0.g.a a;

        /* renamed from: b, reason: collision with root package name */
        public final f f3501b;

        public a(d0.e0.p.d.m0.g.a aVar, f fVar) {
            d0.z.d.m.checkNotNullParameter(aVar, "classId");
            this.a = aVar;
            this.f3501b = fVar;
        }

        public boolean equals(Object obj) {
            return (obj instanceof a) && d0.z.d.m.areEqual(this.a, ((a) obj).a);
        }

        public final f getClassData() {
            return this.f3501b;
        }

        public final d0.e0.p.d.m0.g.a getClassId() {
            return this.a;
        }

        public int hashCode() {
            return this.a.hashCode();
        }
    }

    /* compiled from: ClassDeserializer.kt */
    public static final class b {
        public b(DefaultConstructorMarker defaultConstructorMarker) {
        }

        public final Set<d0.e0.p.d.m0.g.a> getBLACK_LIST() {
            return h.access$getBLACK_LIST$cp();
        }
    }

    /* compiled from: ClassDeserializer.kt */
    public static final class c extends d0.z.d.o implements Function1<a, d0.e0.p.d.m0.c.e> {
        public c() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ d0.e0.p.d.m0.c.e invoke(a aVar) {
            return invoke2(aVar);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final d0.e0.p.d.m0.c.e invoke2(a aVar) {
            d0.z.d.m.checkNotNullParameter(aVar, "key");
            return h.access$createClass(h.this, aVar);
        }
    }

    public h(j jVar) {
        d0.z.d.m.checkNotNullParameter(jVar, "components");
        this.c = jVar;
        this.d = jVar.getStorageManager().createMemoizedFunctionWithNullableValues(new c());
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x00bf  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final d0.e0.p.d.m0.c.e access$createClass(h hVar, a aVar) {
        Object next;
        l lVarCreateContext;
        Objects.requireNonNull(hVar);
        d0.e0.p.d.m0.g.a classId = aVar.getClassId();
        Iterator<d0.e0.p.d.m0.c.h1.b> it = hVar.c.getFictitiousClassDescriptorFactories().iterator();
        while (it.hasNext()) {
            d0.e0.p.d.m0.c.e eVarCreateClass = it.next().createClass(classId);
            if (eVarCreateClass != null) {
                return eVarCreateClass;
            }
        }
        if (a.getBLACK_LIST().contains(classId)) {
            return null;
        }
        f classData = aVar.getClassData();
        if (classData == null && (classData = hVar.c.getClassDataFinder().findClassData(classId)) == null) {
            return null;
        }
        d0.e0.p.d.m0.f.z.c cVarComponent1 = classData.component1();
        d0.e0.p.d.m0.f.c cVarComponent2 = classData.component2();
        d0.e0.p.d.m0.f.z.a aVarComponent3 = classData.component3();
        u0 u0VarComponent4 = classData.component4();
        d0.e0.p.d.m0.g.a outerClassId = classId.getOuterClassId();
        if (outerClassId != null) {
            d0.e0.p.d.m0.c.e eVarDeserializeClass$default = deserializeClass$default(hVar, outerClassId, null, 2, null);
            d0.e0.p.d.m0.l.b.e0.d dVar = eVarDeserializeClass$default instanceof d0.e0.p.d.m0.l.b.e0.d ? (d0.e0.p.d.m0.l.b.e0.d) eVarDeserializeClass$default : null;
            if (dVar == null) {
                return null;
            }
            d0.e0.p.d.m0.g.e shortClassName = classId.getShortClassName();
            d0.z.d.m.checkNotNullExpressionValue(shortClassName, "classId.shortClassName");
            if (!dVar.hasNestedClass$deserialization(shortClassName)) {
                return null;
            }
            lVarCreateContext = dVar.getC();
        } else {
            f0 packageFragmentProvider = hVar.c.getPackageFragmentProvider();
            d0.e0.p.d.m0.g.b packageFqName = classId.getPackageFqName();
            d0.z.d.m.checkNotNullExpressionValue(packageFqName, "classId.packageFqName");
            Iterator<T> it2 = h0.packageFragments(packageFragmentProvider, packageFqName).iterator();
            while (true) {
                if (!it2.hasNext()) {
                    next = null;
                    break;
                }
                next = it2.next();
                e0 e0Var = (e0) next;
                if (e0Var instanceof n) {
                    d0.e0.p.d.m0.g.e shortClassName2 = classId.getShortClassName();
                    d0.z.d.m.checkNotNullExpressionValue(shortClassName2, "classId.shortClassName");
                    boolean z2 = ((n) e0Var).hasTopLevelClass(shortClassName2);
                    if (z2) {
                        break;
                    }
                }
            }
            e0 e0Var2 = (e0) next;
            if (e0Var2 == null) {
                return null;
            }
            j jVar = hVar.c;
            d0.e0.p.d.m0.f.t typeTable = cVarComponent2.getTypeTable();
            d0.z.d.m.checkNotNullExpressionValue(typeTable, "classProto.typeTable");
            d0.e0.p.d.m0.f.z.g gVar = new d0.e0.p.d.m0.f.z.g(typeTable);
            i.a aVar2 = d0.e0.p.d.m0.f.z.i.a;
            d0.e0.p.d.m0.f.w versionRequirementTable = cVarComponent2.getVersionRequirementTable();
            d0.z.d.m.checkNotNullExpressionValue(versionRequirementTable, "classProto.versionRequirementTable");
            lVarCreateContext = jVar.createContext(e0Var2, cVarComponent1, gVar, aVar2.create(versionRequirementTable), aVarComponent3, null);
        }
        return new d0.e0.p.d.m0.l.b.e0.d(lVarCreateContext, cVarComponent2, cVarComponent1, aVarComponent3, u0VarComponent4);
    }

    public static final /* synthetic */ Set access$getBLACK_LIST$cp() {
        return f3500b;
    }

    public static /* synthetic */ d0.e0.p.d.m0.c.e deserializeClass$default(h hVar, d0.e0.p.d.m0.g.a aVar, f fVar, int i, Object obj) {
        if ((i & 2) != 0) {
            fVar = null;
        }
        return hVar.deserializeClass(aVar, fVar);
    }

    public final d0.e0.p.d.m0.c.e deserializeClass(d0.e0.p.d.m0.g.a aVar, f fVar) {
        d0.z.d.m.checkNotNullParameter(aVar, "classId");
        return this.d.invoke(new a(aVar, fVar));
    }
}

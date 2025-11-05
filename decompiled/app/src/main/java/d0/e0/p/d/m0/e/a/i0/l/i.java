package d0.e0.p.d.m0.e.a.i0.l;

import d0.e0.p.d.m0.c.i1.a0;
import d0.e0.p.d.m0.c.u0;
import d0.e0.p.d.m0.e.a.k0.u;
import d0.e0.p.d.m0.e.b.v;
import d0.t.h0;
import d0.z.d.y;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.jvm.functions.Function0;
import kotlin.reflect.KProperty;

/* compiled from: LazyJavaPackageFragment.kt */
/* loaded from: classes3.dex */
public final class i extends a0 {
    public static final /* synthetic */ KProperty<Object>[] o = {d0.z.d.a0.property1(new y(d0.z.d.a0.getOrCreateKotlinClass(i.class), "binaryClasses", "getBinaryClasses$descriptors_jvm()Ljava/util/Map;")), d0.z.d.a0.property1(new y(d0.z.d.a0.getOrCreateKotlinClass(i.class), "partToFacade", "getPartToFacade()Ljava/util/HashMap;"))};
    public final u p;
    public final d0.e0.p.d.m0.e.a.i0.g q;
    public final d0.e0.p.d.m0.m.j r;

    /* renamed from: s, reason: collision with root package name */
    public final d f3333s;
    public final d0.e0.p.d.m0.m.j<List<d0.e0.p.d.m0.g.b>> t;
    public final d0.e0.p.d.m0.c.g1.g u;

    /* compiled from: LazyJavaPackageFragment.kt */
    public static final class a extends d0.z.d.o implements Function0<Map<String, ? extends d0.e0.p.d.m0.e.b.p>> {
        public a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Map<String, ? extends d0.e0.p.d.m0.e.b.p> invoke() {
            return invoke2();
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Map<String, ? extends d0.e0.p.d.m0.e.b.p> invoke2() {
            v packagePartProvider = i.access$getC$p(i.this).getComponents().getPackagePartProvider();
            String strAsString = i.this.getFqName().asString();
            d0.z.d.m.checkNotNullExpressionValue(strAsString, "fqName.asString()");
            List<String> listFindPackageParts = packagePartProvider.findPackageParts(strAsString);
            i iVar = i.this;
            ArrayList arrayList = new ArrayList();
            for (String str : listFindPackageParts) {
                d0.e0.p.d.m0.g.a aVar = d0.e0.p.d.m0.g.a.topLevel(d0.e0.p.d.m0.k.y.c.byInternalName(str).getFqNameForTopLevelClassMaybeWithDollars());
                d0.z.d.m.checkNotNullExpressionValue(aVar, "topLevel(JvmClassName.byInternalName(partName).fqNameForTopLevelClassMaybeWithDollars)");
                d0.e0.p.d.m0.e.b.p pVarFindKotlinClass = d0.e0.p.d.m0.e.b.o.findKotlinClass(i.access$getC$p(iVar).getComponents().getKotlinClassFinder(), aVar);
                Pair pair = pVarFindKotlinClass == null ? null : d0.o.to(str, pVarFindKotlinClass);
                if (pair != null) {
                    arrayList.add(pair);
                }
            }
            return h0.toMap(arrayList);
        }
    }

    /* compiled from: LazyJavaPackageFragment.kt */
    public static final class b extends d0.z.d.o implements Function0<HashMap<d0.e0.p.d.m0.k.y.c, d0.e0.p.d.m0.k.y.c>> {
        public b() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ HashMap<d0.e0.p.d.m0.k.y.c, d0.e0.p.d.m0.k.y.c> invoke() {
            return invoke2();
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final HashMap<d0.e0.p.d.m0.k.y.c, d0.e0.p.d.m0.k.y.c> invoke2() {
            String multifileClassName;
            HashMap<d0.e0.p.d.m0.k.y.c, d0.e0.p.d.m0.k.y.c> map = new HashMap<>();
            for (Map.Entry<String, d0.e0.p.d.m0.e.b.p> entry : i.this.getBinaryClasses$descriptors_jvm().entrySet()) {
                String key = entry.getKey();
                d0.e0.p.d.m0.e.b.p value = entry.getValue();
                d0.e0.p.d.m0.k.y.c cVarByInternalName = d0.e0.p.d.m0.k.y.c.byInternalName(key);
                d0.z.d.m.checkNotNullExpressionValue(cVarByInternalName, "byInternalName(partInternalName)");
                d0.e0.p.d.m0.e.b.b0.a classHeader = value.getClassHeader();
                int iOrdinal = classHeader.getKind().ordinal();
                if (iOrdinal == 2) {
                    map.put(cVarByInternalName, cVarByInternalName);
                } else if (iOrdinal == 5 && (multifileClassName = classHeader.getMultifileClassName()) != null) {
                    d0.e0.p.d.m0.k.y.c cVarByInternalName2 = d0.e0.p.d.m0.k.y.c.byInternalName(multifileClassName);
                    d0.z.d.m.checkNotNullExpressionValue(cVarByInternalName2, "byInternalName(header.multifileClassName ?: continue@kotlinClasses)");
                    map.put(cVarByInternalName, cVarByInternalName2);
                }
            }
            return map;
        }
    }

    /* compiled from: LazyJavaPackageFragment.kt */
    public static final class c extends d0.z.d.o implements Function0<List<? extends d0.e0.p.d.m0.g.b>> {
        public c() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ List<? extends d0.e0.p.d.m0.g.b> invoke() {
            return invoke2();
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final List<? extends d0.e0.p.d.m0.g.b> invoke2() {
            Collection<u> subPackages = i.access$getJPackage$p(i.this).getSubPackages();
            ArrayList arrayList = new ArrayList(d0.t.o.collectionSizeOrDefault(subPackages, 10));
            Iterator<T> it = subPackages.iterator();
            while (it.hasNext()) {
                arrayList.add(((u) it.next()).getFqName());
            }
            return arrayList;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(d0.e0.p.d.m0.e.a.i0.g gVar, u uVar) {
        super(gVar.getModule(), uVar.getFqName());
        d0.z.d.m.checkNotNullParameter(gVar, "outerContext");
        d0.z.d.m.checkNotNullParameter(uVar, "jPackage");
        this.p = uVar;
        d0.e0.p.d.m0.e.a.i0.g gVarChildForClassOrPackage$default = d0.e0.p.d.m0.e.a.i0.a.childForClassOrPackage$default(gVar, this, null, 0, 6, null);
        this.q = gVarChildForClassOrPackage$default;
        this.r = gVarChildForClassOrPackage$default.getStorageManager().createLazyValue(new a());
        this.f3333s = new d(gVarChildForClassOrPackage$default, uVar, this);
        this.t = gVarChildForClassOrPackage$default.getStorageManager().createRecursionTolerantLazyValue(new c(), d0.t.n.emptyList());
        this.u = gVarChildForClassOrPackage$default.getComponents().getJavaTypeEnhancementState().getDisabledDefaultAnnotations() ? d0.e0.p.d.m0.c.g1.g.f.getEMPTY() : d0.e0.p.d.m0.e.a.i0.e.resolveAnnotations(gVarChildForClassOrPackage$default, uVar);
        gVarChildForClassOrPackage$default.getStorageManager().createLazyValue(new b());
    }

    public static final /* synthetic */ d0.e0.p.d.m0.e.a.i0.g access$getC$p(i iVar) {
        return iVar.q;
    }

    public static final /* synthetic */ u access$getJPackage$p(i iVar) {
        return iVar.p;
    }

    public final d0.e0.p.d.m0.c.e findClassifierByJavaClass$descriptors_jvm(d0.e0.p.d.m0.e.a.k0.g gVar) {
        d0.z.d.m.checkNotNullParameter(gVar, "jClass");
        return this.f3333s.getJavaScope$descriptors_jvm().findClassifierByJavaClass$descriptors_jvm(gVar);
    }

    @Override // d0.e0.p.d.m0.c.g1.b, d0.e0.p.d.m0.c.g1.a
    public d0.e0.p.d.m0.c.g1.g getAnnotations() {
        return this.u;
    }

    public final Map<String, d0.e0.p.d.m0.e.b.p> getBinaryClasses$descriptors_jvm() {
        return (Map) d0.e0.p.d.m0.m.n.getValue(this.r, this, (KProperty<?>) o[0]);
    }

    @Override // d0.e0.p.d.m0.c.e0
    public /* bridge */ /* synthetic */ d0.e0.p.d.m0.k.a0.i getMemberScope() {
        return getMemberScope();
    }

    @Override // d0.e0.p.d.m0.c.i1.a0, d0.e0.p.d.m0.c.i1.l, d0.e0.p.d.m0.c.p
    public u0 getSource() {
        return new d0.e0.p.d.m0.e.b.q(this);
    }

    public final List<d0.e0.p.d.m0.g.b> getSubPackageFqNames$descriptors_jvm() {
        return this.t.invoke();
    }

    @Override // d0.e0.p.d.m0.c.i1.a0, d0.e0.p.d.m0.c.i1.k
    public String toString() {
        return d0.z.d.m.stringPlus("Lazy Java package fragment: ", getFqName());
    }

    @Override // d0.e0.p.d.m0.c.e0
    public d getMemberScope() {
        return this.f3333s;
    }
}

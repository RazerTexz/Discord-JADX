package d0.e0.p.d.m0.e.a.i0.l;

import com.discord.models.domain.ModelAuditLogEntry;
import d0.e0.p.d.m0.c.c1;
import d0.e0.p.d.m0.c.i1.l0;
import d0.e0.p.d.m0.c.n0;
import d0.e0.p.d.m0.c.q0;
import d0.e0.p.d.m0.c.t0;
import d0.e0.p.d.m0.c.x;
import d0.e0.p.d.m0.c.z;
import d0.e0.p.d.m0.c.z0;
import d0.e0.p.d.m0.e.a.f0;
import d0.e0.p.d.m0.e.a.g0.g;
import d0.e0.p.d.m0.e.a.g0.j;
import d0.e0.p.d.m0.k.a0.c;
import d0.e0.p.d.m0.k.v.w;
import d0.e0.p.d.m0.m.f;
import d0.e0.p.d.m0.n.c0;
import d0.e0.p.d.m0.n.e1;
import d0.t.g0;
import d0.t.h0;
import d0.t.u;
import d0.z.d.a0;
import d0.z.d.y;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import kotlin.Pair;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;

/* compiled from: LazyJavaScope.kt */
/* loaded from: classes3.dex */
public abstract class k extends d0.e0.p.d.m0.k.a0.j {

    /* renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ KProperty<Object>[] f3335b = {a0.property1(new y(a0.getOrCreateKotlinClass(k.class), "functionNamesLazy", "getFunctionNamesLazy()Ljava/util/Set;")), a0.property1(new y(a0.getOrCreateKotlinClass(k.class), "propertyNamesLazy", "getPropertyNamesLazy()Ljava/util/Set;")), a0.property1(new y(a0.getOrCreateKotlinClass(k.class), "classNamesLazy", "getClassNamesLazy()Ljava/util/Set;"))};
    public final d0.e0.p.d.m0.e.a.i0.g c;
    public final k d;
    public final d0.e0.p.d.m0.m.j<Collection<d0.e0.p.d.m0.c.m>> e;
    public final d0.e0.p.d.m0.m.j<d0.e0.p.d.m0.e.a.i0.l.b> f;
    public final d0.e0.p.d.m0.m.h<d0.e0.p.d.m0.g.e, Collection<t0>> g;
    public final d0.e0.p.d.m0.m.i<d0.e0.p.d.m0.g.e, n0> h;
    public final d0.e0.p.d.m0.m.h<d0.e0.p.d.m0.g.e, Collection<t0>> i;
    public final d0.e0.p.d.m0.m.j j;
    public final d0.e0.p.d.m0.m.j k;
    public final d0.e0.p.d.m0.m.j l;
    public final d0.e0.p.d.m0.m.h<d0.e0.p.d.m0.g.e, List<n0>> m;

    /* compiled from: LazyJavaScope.kt */
    public static final class a {
        public final c0 a;

        /* renamed from: b, reason: collision with root package name */
        public final c0 f3336b;
        public final List<c1> c;
        public final List<z0> d;
        public final boolean e;
        public final List<String> f;

        /* JADX WARN: Multi-variable type inference failed */
        public a(c0 c0Var, c0 c0Var2, List<? extends c1> list, List<? extends z0> list2, boolean z2, List<String> list3) {
            d0.z.d.m.checkNotNullParameter(c0Var, "returnType");
            d0.z.d.m.checkNotNullParameter(list, "valueParameters");
            d0.z.d.m.checkNotNullParameter(list2, "typeParameters");
            d0.z.d.m.checkNotNullParameter(list3, "errors");
            this.a = c0Var;
            this.f3336b = c0Var2;
            this.c = list;
            this.d = list2;
            this.e = z2;
            this.f = list3;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return d0.z.d.m.areEqual(this.a, aVar.a) && d0.z.d.m.areEqual(this.f3336b, aVar.f3336b) && d0.z.d.m.areEqual(this.c, aVar.c) && d0.z.d.m.areEqual(this.d, aVar.d) && this.e == aVar.e && d0.z.d.m.areEqual(this.f, aVar.f);
        }

        public final List<String> getErrors() {
            return this.f;
        }

        public final boolean getHasStableParameterNames() {
            return this.e;
        }

        public final c0 getReceiverType() {
            return this.f3336b;
        }

        public final c0 getReturnType() {
            return this.a;
        }

        public final List<z0> getTypeParameters() {
            return this.d;
        }

        public final List<c1> getValueParameters() {
            return this.c;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            int iHashCode = this.a.hashCode() * 31;
            c0 c0Var = this.f3336b;
            int iHashCode2 = (this.d.hashCode() + ((this.c.hashCode() + ((iHashCode + (c0Var == null ? 0 : c0Var.hashCode())) * 31)) * 31)) * 31;
            boolean z2 = this.e;
            int i = z2;
            if (z2 != 0) {
                i = 1;
            }
            return this.f.hashCode() + ((iHashCode2 + i) * 31);
        }

        public String toString() {
            StringBuilder sbU = b.d.b.a.a.U("MethodSignatureData(returnType=");
            sbU.append(this.a);
            sbU.append(", receiverType=");
            sbU.append(this.f3336b);
            sbU.append(", valueParameters=");
            sbU.append(this.c);
            sbU.append(", typeParameters=");
            sbU.append(this.d);
            sbU.append(", hasStableParameterNames=");
            sbU.append(this.e);
            sbU.append(", errors=");
            sbU.append(this.f);
            sbU.append(')');
            return sbU.toString();
        }
    }

    /* compiled from: LazyJavaScope.kt */
    public static final class b {
        public final List<c1> a;

        /* renamed from: b, reason: collision with root package name */
        public final boolean f3337b;

        /* JADX WARN: Multi-variable type inference failed */
        public b(List<? extends c1> list, boolean z2) {
            d0.z.d.m.checkNotNullParameter(list, "descriptors");
            this.a = list;
            this.f3337b = z2;
        }

        public final List<c1> getDescriptors() {
            return this.a;
        }

        public final boolean getHasSynthesizedNames() {
            return this.f3337b;
        }
    }

    /* compiled from: LazyJavaScope.kt */
    public static final class c extends d0.z.d.o implements Function0<Collection<? extends d0.e0.p.d.m0.c.m>> {
        public c() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Collection<? extends d0.e0.p.d.m0.c.m> invoke() {
            return invoke2();
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Collection<? extends d0.e0.p.d.m0.c.m> invoke2() {
            k kVar = k.this;
            d0.e0.p.d.m0.k.a0.d dVar = d0.e0.p.d.m0.k.a0.d.m;
            Function1<d0.e0.p.d.m0.g.e, Boolean> all_name_filter = d0.e0.p.d.m0.k.a0.i.a.getALL_NAME_FILTER();
            Objects.requireNonNull(kVar);
            d0.z.d.m.checkNotNullParameter(dVar, "kindFilter");
            d0.z.d.m.checkNotNullParameter(all_name_filter, "nameFilter");
            d0.e0.p.d.m0.d.b.d dVar2 = d0.e0.p.d.m0.d.b.d.WHEN_GET_ALL_DESCRIPTORS;
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            if (dVar.acceptsKinds(d0.e0.p.d.m0.k.a0.d.a.getCLASSIFIERS_MASK())) {
                for (d0.e0.p.d.m0.g.e eVar : kVar.a(dVar, all_name_filter)) {
                    if (all_name_filter.invoke(eVar).booleanValue()) {
                        d0.e0.p.d.m0.p.a.addIfNotNull(linkedHashSet, kVar.getContributedClassifier(eVar, dVar2));
                    }
                }
            }
            if (dVar.acceptsKinds(d0.e0.p.d.m0.k.a0.d.a.getFUNCTIONS_MASK()) && !dVar.getExcludes().contains(c.a.a)) {
                for (d0.e0.p.d.m0.g.e eVar2 : kVar.b(dVar, all_name_filter)) {
                    if (all_name_filter.invoke(eVar2).booleanValue()) {
                        linkedHashSet.addAll(kVar.getContributedFunctions(eVar2, dVar2));
                    }
                }
            }
            if (dVar.acceptsKinds(d0.e0.p.d.m0.k.a0.d.a.getVARIABLES_MASK()) && !dVar.getExcludes().contains(c.a.a)) {
                for (d0.e0.p.d.m0.g.e eVar3 : kVar.h(dVar, all_name_filter)) {
                    if (all_name_filter.invoke(eVar3).booleanValue()) {
                        linkedHashSet.addAll(kVar.getContributedVariables(eVar3, dVar2));
                    }
                }
            }
            return u.toList(linkedHashSet);
        }
    }

    /* compiled from: LazyJavaScope.kt */
    public static final class d extends d0.z.d.o implements Function0<Set<? extends d0.e0.p.d.m0.g.e>> {
        public d() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Set<? extends d0.e0.p.d.m0.g.e> invoke() {
            return invoke2();
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Set<? extends d0.e0.p.d.m0.g.e> invoke2() {
            return k.this.a(d0.e0.p.d.m0.k.a0.d.o, null);
        }
    }

    /* compiled from: LazyJavaScope.kt */
    public static final class e extends d0.z.d.o implements Function1<d0.e0.p.d.m0.g.e, n0> {
        public e() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ n0 invoke(d0.e0.p.d.m0.g.e eVar) {
            return invoke2(eVar);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final n0 invoke2(d0.e0.p.d.m0.g.e eVar) {
            d0.z.d.m.checkNotNullParameter(eVar, ModelAuditLogEntry.CHANGE_KEY_NAME);
            k kVar = k.this;
            k kVar2 = kVar.d;
            if (kVar2 != null) {
                return (n0) k.access$getDeclaredField$p(kVar2).invoke(eVar);
            }
            d0.e0.p.d.m0.e.a.k0.n nVarFindFieldByName = kVar.f.invoke().findFieldByName(eVar);
            if (nVarFindFieldByName == null || nVarFindFieldByName.isEnumEntry()) {
                return null;
            }
            return k.access$resolveProperty(k.this, nVarFindFieldByName);
        }
    }

    /* compiled from: LazyJavaScope.kt */
    public static final class f extends d0.z.d.o implements Function1<d0.e0.p.d.m0.g.e, Collection<? extends t0>> {
        public f() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Collection<? extends t0> invoke(d0.e0.p.d.m0.g.e eVar) {
            return invoke2(eVar);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Collection<t0> invoke2(d0.e0.p.d.m0.g.e eVar) {
            d0.z.d.m.checkNotNullParameter(eVar, ModelAuditLogEntry.CHANGE_KEY_NAME);
            k kVar = k.this.d;
            if (kVar != null) {
                return (Collection) ((f.m) k.access$getDeclaredFunctions$p(kVar)).invoke(eVar);
            }
            ArrayList arrayList = new ArrayList();
            for (d0.e0.p.d.m0.e.a.k0.r rVar : k.this.f.invoke().findMethodsByName(eVar)) {
                d0.e0.p.d.m0.e.a.h0.f fVarM = k.this.m(rVar);
                if (k.this.k(fVarM)) {
                    ((g.a) k.this.c.getComponents().getJavaResolverCache()).recordMethod(rVar, fVarM);
                    arrayList.add(fVarM);
                }
            }
            k.this.c(arrayList, eVar);
            return arrayList;
        }
    }

    /* compiled from: LazyJavaScope.kt */
    public static final class g extends d0.z.d.o implements Function0<d0.e0.p.d.m0.e.a.i0.l.b> {
        public g() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ d0.e0.p.d.m0.e.a.i0.l.b invoke() {
            return invoke();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final d0.e0.p.d.m0.e.a.i0.l.b invoke() {
            return k.this.d();
        }
    }

    /* compiled from: LazyJavaScope.kt */
    public static final class h extends d0.z.d.o implements Function0<Set<? extends d0.e0.p.d.m0.g.e>> {
        public h() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Set<? extends d0.e0.p.d.m0.g.e> invoke() {
            return invoke2();
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Set<? extends d0.e0.p.d.m0.g.e> invoke2() {
            return k.this.b(d0.e0.p.d.m0.k.a0.d.p, null);
        }
    }

    /* compiled from: LazyJavaScope.kt */
    public static final class i extends d0.z.d.o implements Function1<d0.e0.p.d.m0.g.e, Collection<? extends t0>> {
        public i() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Collection<? extends t0> invoke(d0.e0.p.d.m0.g.e eVar) {
            return invoke2(eVar);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Collection<t0> invoke2(d0.e0.p.d.m0.g.e eVar) {
            d0.z.d.m.checkNotNullParameter(eVar, ModelAuditLogEntry.CHANGE_KEY_NAME);
            LinkedHashSet linkedHashSet = new LinkedHashSet((Collection) ((f.m) k.access$getDeclaredFunctions$p(k.this)).invoke(eVar));
            k.access$retainMostSpecificMethods(k.this, linkedHashSet);
            k.this.f(linkedHashSet, eVar);
            return u.toList(k.this.c.getComponents().getSignatureEnhancement().enhanceSignatures(k.this.c, linkedHashSet));
        }
    }

    /* compiled from: LazyJavaScope.kt */
    public static final class j extends d0.z.d.o implements Function1<d0.e0.p.d.m0.g.e, List<? extends n0>> {
        public j() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ List<? extends n0> invoke(d0.e0.p.d.m0.g.e eVar) {
            return invoke2(eVar);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final List<n0> invoke2(d0.e0.p.d.m0.g.e eVar) {
            d0.z.d.m.checkNotNullParameter(eVar, ModelAuditLogEntry.CHANGE_KEY_NAME);
            ArrayList arrayList = new ArrayList();
            d0.e0.p.d.m0.p.a.addIfNotNull(arrayList, k.access$getDeclaredField$p(k.this).invoke(eVar));
            k.this.g(eVar, arrayList);
            return d0.e0.p.d.m0.k.e.isAnnotationClass(k.this.j()) ? u.toList(arrayList) : u.toList(k.this.c.getComponents().getSignatureEnhancement().enhanceSignatures(k.this.c, arrayList));
        }
    }

    /* compiled from: LazyJavaScope.kt */
    /* renamed from: d0.e0.p.d.m0.e.a.i0.l.k$k, reason: collision with other inner class name */
    public static final class C0526k extends d0.z.d.o implements Function0<Set<? extends d0.e0.p.d.m0.g.e>> {
        public C0526k() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Set<? extends d0.e0.p.d.m0.g.e> invoke() {
            return invoke2();
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Set<? extends d0.e0.p.d.m0.g.e> invoke2() {
            return k.this.h(d0.e0.p.d.m0.k.a0.d.q, null);
        }
    }

    public /* synthetic */ k(d0.e0.p.d.m0.e.a.i0.g gVar, k kVar, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(gVar, (i2 & 2) != 0 ? null : kVar);
    }

    public static final /* synthetic */ d0.e0.p.d.m0.m.i access$getDeclaredField$p(k kVar) {
        return kVar.h;
    }

    public static final /* synthetic */ d0.e0.p.d.m0.m.h access$getDeclaredFunctions$p(k kVar) {
        return kVar.g;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0086  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final n0 access$resolveProperty(k kVar, d0.e0.p.d.m0.e.a.k0.n nVar) {
        boolean z2;
        Objects.requireNonNull(kVar);
        d0.e0.p.d.m0.e.a.h0.g gVarCreate = d0.e0.p.d.m0.e.a.h0.g.create(kVar.j(), d0.e0.p.d.m0.e.a.i0.e.resolveAnnotations(kVar.c, nVar), z.FINAL, f0.toDescriptorVisibility(nVar.getVisibility()), !nVar.isFinal(), nVar.getName(), kVar.c.getComponents().getSourceElementFactory().source(nVar), nVar.isFinal() && nVar.isStatic());
        d0.z.d.m.checkNotNullExpressionValue(gVarCreate, "create(\n            ownerDescriptor, annotations, Modality.FINAL, field.visibility.toDescriptorVisibility(), isVar, field.name,\n            c.components.sourceElementFactory.source(field), /* isConst = */ field.isFinalStatic\n        )");
        gVarCreate.initialize(null, null, null, null);
        c0 c0VarTransformJavaType = kVar.c.getTypeResolver().transformJavaType(nVar.getType(), d0.e0.p.d.m0.e.a.i0.m.e.toAttributes$default(d0.e0.p.d.m0.e.a.g0.k.COMMON, false, null, 3, null));
        if (d0.e0.p.d.m0.b.h.isPrimitiveType(c0VarTransformJavaType) || d0.e0.p.d.m0.b.h.isString(c0VarTransformJavaType)) {
            z2 = (nVar.isFinal() && nVar.isStatic()) && nVar.getHasConstantNotNullInitializer();
        }
        if (z2) {
            c0VarTransformJavaType = e1.makeNotNullable(c0VarTransformJavaType);
            d0.z.d.m.checkNotNullExpressionValue(c0VarTransformJavaType, "makeNotNullable(propertyType)");
        }
        gVarCreate.setType(c0VarTransformJavaType, d0.t.n.emptyList(), kVar.i(), null);
        if (d0.e0.p.d.m0.k.e.shouldRecordInitializerForProperty(gVarCreate, gVarCreate.getType())) {
            gVarCreate.setCompileTimeInitializer(kVar.c.getStorageManager().createNullableLazyValue(new l(kVar, nVar, gVarCreate)));
        }
        ((g.a) kVar.c.getComponents().getJavaResolverCache()).recordField(nVar, gVarCreate);
        return gVarCreate;
    }

    public static final void access$retainMostSpecificMethods(k kVar, Set set) {
        Objects.requireNonNull(kVar);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Object obj : set) {
            String strComputeJvmDescriptor$default = d0.e0.p.d.m0.e.b.u.computeJvmDescriptor$default((t0) obj, false, false, 2, null);
            Object arrayList = linkedHashMap.get(strComputeJvmDescriptor$default);
            if (arrayList == null) {
                arrayList = new ArrayList();
                linkedHashMap.put(strComputeJvmDescriptor$default, arrayList);
            }
            ((List) arrayList).add(obj);
        }
        for (List list : linkedHashMap.values()) {
            if (list.size() != 1) {
                Collection collectionSelectMostSpecificInEachOverridableGroup = d0.e0.p.d.m0.k.p.selectMostSpecificInEachOverridableGroup(list, m.j);
                set.removeAll(list);
                set.addAll(collectionSelectMostSpecificInEachOverridableGroup);
            }
        }
    }

    public abstract Set<d0.e0.p.d.m0.g.e> a(d0.e0.p.d.m0.k.a0.d dVar, Function1<? super d0.e0.p.d.m0.g.e, Boolean> function1);

    public abstract Set<d0.e0.p.d.m0.g.e> b(d0.e0.p.d.m0.k.a0.d dVar, Function1<? super d0.e0.p.d.m0.g.e, Boolean> function1);

    public void c(Collection<t0> collection, d0.e0.p.d.m0.g.e eVar) {
        d0.z.d.m.checkNotNullParameter(collection, "result");
        d0.z.d.m.checkNotNullParameter(eVar, ModelAuditLogEntry.CHANGE_KEY_NAME);
    }

    public abstract d0.e0.p.d.m0.e.a.i0.l.b d();

    public final c0 e(d0.e0.p.d.m0.e.a.k0.r rVar, d0.e0.p.d.m0.e.a.i0.g gVar) {
        d0.z.d.m.checkNotNullParameter(rVar, "method");
        d0.z.d.m.checkNotNullParameter(gVar, "c");
        return gVar.getTypeResolver().transformJavaType(rVar.getReturnType(), d0.e0.p.d.m0.e.a.i0.m.e.toAttributes$default(d0.e0.p.d.m0.e.a.g0.k.COMMON, rVar.getContainingClass().isAnnotationType(), null, 2, null));
    }

    public abstract void f(Collection<t0> collection, d0.e0.p.d.m0.g.e eVar);

    public abstract void g(d0.e0.p.d.m0.g.e eVar, Collection<n0> collection);

    @Override // d0.e0.p.d.m0.k.a0.j, d0.e0.p.d.m0.k.a0.i
    public Set<d0.e0.p.d.m0.g.e> getClassifierNames() {
        return (Set) d0.e0.p.d.m0.m.n.getValue(this.l, this, (KProperty<?>) f3335b[2]);
    }

    @Override // d0.e0.p.d.m0.k.a0.j, d0.e0.p.d.m0.k.a0.l
    public Collection<d0.e0.p.d.m0.c.m> getContributedDescriptors(d0.e0.p.d.m0.k.a0.d dVar, Function1<? super d0.e0.p.d.m0.g.e, Boolean> function1) {
        d0.z.d.m.checkNotNullParameter(dVar, "kindFilter");
        d0.z.d.m.checkNotNullParameter(function1, "nameFilter");
        return this.e.invoke();
    }

    @Override // d0.e0.p.d.m0.k.a0.j, d0.e0.p.d.m0.k.a0.i
    public Collection<t0> getContributedFunctions(d0.e0.p.d.m0.g.e eVar, d0.e0.p.d.m0.d.b.b bVar) {
        d0.z.d.m.checkNotNullParameter(eVar, ModelAuditLogEntry.CHANGE_KEY_NAME);
        d0.z.d.m.checkNotNullParameter(bVar, ModelAuditLogEntry.CHANGE_KEY_LOCATION);
        return !getFunctionNames().contains(eVar) ? d0.t.n.emptyList() : (Collection) ((f.m) this.i).invoke(eVar);
    }

    @Override // d0.e0.p.d.m0.k.a0.j, d0.e0.p.d.m0.k.a0.i
    public Collection<n0> getContributedVariables(d0.e0.p.d.m0.g.e eVar, d0.e0.p.d.m0.d.b.b bVar) {
        d0.z.d.m.checkNotNullParameter(eVar, ModelAuditLogEntry.CHANGE_KEY_NAME);
        d0.z.d.m.checkNotNullParameter(bVar, ModelAuditLogEntry.CHANGE_KEY_LOCATION);
        return !getVariableNames().contains(eVar) ? d0.t.n.emptyList() : (Collection) ((f.m) this.m).invoke(eVar);
    }

    @Override // d0.e0.p.d.m0.k.a0.j, d0.e0.p.d.m0.k.a0.i
    public Set<d0.e0.p.d.m0.g.e> getFunctionNames() {
        return (Set) d0.e0.p.d.m0.m.n.getValue(this.j, this, (KProperty<?>) f3335b[0]);
    }

    @Override // d0.e0.p.d.m0.k.a0.j, d0.e0.p.d.m0.k.a0.i
    public Set<d0.e0.p.d.m0.g.e> getVariableNames() {
        return (Set) d0.e0.p.d.m0.m.n.getValue(this.k, this, (KProperty<?>) f3335b[1]);
    }

    public abstract Set<d0.e0.p.d.m0.g.e> h(d0.e0.p.d.m0.k.a0.d dVar, Function1<? super d0.e0.p.d.m0.g.e, Boolean> function1);

    public abstract q0 i();

    public abstract d0.e0.p.d.m0.c.m j();

    public boolean k(d0.e0.p.d.m0.e.a.h0.f fVar) {
        d0.z.d.m.checkNotNullParameter(fVar, "<this>");
        return true;
    }

    public abstract a l(d0.e0.p.d.m0.e.a.k0.r rVar, List<? extends z0> list, c0 c0Var, List<? extends c1> list2);

    public final d0.e0.p.d.m0.e.a.h0.f m(d0.e0.p.d.m0.e.a.k0.r rVar) {
        d0.z.d.m.checkNotNullParameter(rVar, "method");
        d0.e0.p.d.m0.e.a.h0.f fVarCreateJavaMethod = d0.e0.p.d.m0.e.a.h0.f.createJavaMethod(j(), d0.e0.p.d.m0.e.a.i0.e.resolveAnnotations(this.c, rVar), rVar.getName(), this.c.getComponents().getSourceElementFactory().source(rVar), this.f.invoke().findRecordComponentByName(rVar.getName()) != null && rVar.getValueParameters().isEmpty());
        d0.z.d.m.checkNotNullExpressionValue(fVarCreateJavaMethod, "createJavaMethod(\n            ownerDescriptor, annotations, method.name, c.components.sourceElementFactory.source(method),\n            declaredMemberIndex().findRecordComponentByName(method.name) != null && method.valueParameters.isEmpty()\n        )");
        d0.e0.p.d.m0.e.a.i0.g gVarChildForMethod$default = d0.e0.p.d.m0.e.a.i0.a.childForMethod$default(this.c, fVarCreateJavaMethod, rVar, 0, 4, null);
        List<d0.e0.p.d.m0.e.a.k0.y> typeParameters = rVar.getTypeParameters();
        List<? extends z0> arrayList = new ArrayList<>(d0.t.o.collectionSizeOrDefault(typeParameters, 10));
        Iterator<T> it = typeParameters.iterator();
        while (it.hasNext()) {
            z0 z0VarResolveTypeParameter = gVarChildForMethod$default.getTypeParameterResolver().resolveTypeParameter((d0.e0.p.d.m0.e.a.k0.y) it.next());
            d0.z.d.m.checkNotNull(z0VarResolveTypeParameter);
            arrayList.add(z0VarResolveTypeParameter);
        }
        b bVarN = n(gVarChildForMethod$default, fVarCreateJavaMethod, rVar.getValueParameters());
        a aVarL = l(rVar, arrayList, e(rVar, gVarChildForMethod$default), bVarN.getDescriptors());
        c0 receiverType = aVarL.getReceiverType();
        fVarCreateJavaMethod.initialize(receiverType == null ? null : d0.e0.p.d.m0.k.d.createExtensionReceiverParameterForCallable(fVarCreateJavaMethod, receiverType, d0.e0.p.d.m0.c.g1.g.f.getEMPTY()), i(), aVarL.getTypeParameters(), aVarL.getValueParameters(), aVarL.getReturnType(), z.j.convertFromFlags(false, rVar.isAbstract(), !rVar.isFinal()), f0.toDescriptorVisibility(rVar.getVisibility()), aVarL.getReceiverType() != null ? g0.mapOf(d0.o.to(d0.e0.p.d.m0.e.a.h0.f.M, u.first((List) bVarN.getDescriptors()))) : h0.emptyMap());
        fVarCreateJavaMethod.setParameterNamesStatus(aVarL.getHasStableParameterNames(), bVarN.getHasSynthesizedNames());
        if (!aVarL.getErrors().isEmpty()) {
            ((j.a) gVarChildForMethod$default.getComponents().getSignaturePropagator()).reportSignatureErrors(fVarCreateJavaMethod, aVarL.getErrors());
        }
        return fVarCreateJavaMethod;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0119  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final b n(d0.e0.p.d.m0.e.a.i0.g gVar, x xVar, List<? extends d0.e0.p.d.m0.e.a.k0.a0> list) {
        String value;
        Pair pair;
        d0.e0.p.d.m0.g.e name;
        d0.e0.p.d.m0.e.a.i0.g gVar2 = gVar;
        d0.z.d.m.checkNotNullParameter(gVar2, "c");
        d0.z.d.m.checkNotNullParameter(xVar, "function");
        d0.z.d.m.checkNotNullParameter(list, "jValueParameters");
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        Iterable<d0.t.z> iterableWithIndex = u.withIndex(list);
        ArrayList arrayList = new ArrayList(d0.t.o.collectionSizeOrDefault(iterableWithIndex, 10));
        boolean z2 = false;
        boolean z3 = false;
        for (d0.t.z zVar : iterableWithIndex) {
            int iComponent1 = zVar.component1();
            d0.e0.p.d.m0.e.a.k0.a0 a0Var = (d0.e0.p.d.m0.e.a.k0.a0) zVar.component2();
            d0.e0.p.d.m0.c.g1.g gVarResolveAnnotations = d0.e0.p.d.m0.e.a.i0.e.resolveAnnotations(gVar2, a0Var);
            d0.e0.p.d.m0.e.a.i0.m.a attributes$default = d0.e0.p.d.m0.e.a.i0.m.e.toAttributes$default(d0.e0.p.d.m0.e.a.g0.k.COMMON, z2, null, 3, null);
            d0.e0.p.d.m0.g.b bVar = d0.e0.p.d.m0.e.a.a0.q;
            d0.z.d.m.checkNotNullExpressionValue(bVar, "PARAMETER_NAME_FQ_NAME");
            d0.e0.p.d.m0.c.g1.c cVarFindAnnotation = gVarResolveAnnotations.findAnnotation(bVar);
            d0.e0.p.d.m0.k.v.g<?> gVarFirstArgument = cVarFindAnnotation == null ? null : d0.e0.p.d.m0.k.x.a.firstArgument(cVarFindAnnotation);
            if (gVarFirstArgument != null) {
                if (!(gVarFirstArgument instanceof w)) {
                    gVarFirstArgument = null;
                }
                w wVar = (w) gVarFirstArgument;
                value = wVar == null ? null : wVar.getValue();
            }
            if (a0Var.isVararg()) {
                d0.e0.p.d.m0.e.a.k0.x type = a0Var.getType();
                d0.e0.p.d.m0.e.a.k0.f fVar = type instanceof d0.e0.p.d.m0.e.a.k0.f ? (d0.e0.p.d.m0.e.a.k0.f) type : null;
                if (fVar == null) {
                    throw new AssertionError(d0.z.d.m.stringPlus("Vararg parameter should be an array: ", a0Var));
                }
                c0 c0VarTransformArrayType = gVar.getTypeResolver().transformArrayType(fVar, attributes$default, true);
                pair = d0.o.to(c0VarTransformArrayType, gVar.getModule().getBuiltIns().getArrayElementType(c0VarTransformArrayType));
            } else {
                pair = d0.o.to(gVar.getTypeResolver().transformJavaType(a0Var.getType(), attributes$default), null);
            }
            c0 c0Var = (c0) pair.component1();
            c0 c0Var2 = (c0) pair.component2();
            if (d0.z.d.m.areEqual(((d0.e0.p.d.m0.c.i1.k) xVar).getName().asString(), "equals") && list.size() == 1 && d0.z.d.m.areEqual(gVar.getModule().getBuiltIns().getNullableAnyType(), c0Var)) {
                name = d0.e0.p.d.m0.g.e.identifier("other");
            } else if (value == null) {
                name = a0Var.getName();
                if (name == null) {
                    z3 = true;
                }
                if (name == null) {
                    name = d0.e0.p.d.m0.g.e.identifier(d0.z.d.m.stringPlus("p", Integer.valueOf(iComponent1)));
                    d0.z.d.m.checkNotNullExpressionValue(name, "identifier(\"p$index\")");
                }
            } else if ((value.length() > 0) && linkedHashSet.add(value)) {
                name = d0.e0.p.d.m0.g.e.identifier(value);
            }
            d0.e0.p.d.m0.g.e eVar = name;
            d0.z.d.m.checkNotNullExpressionValue(eVar, "if (function.name.asString() == \"equals\" &&\n                jValueParameters.size == 1 &&\n                c.module.builtIns.nullableAnyType == outType\n            ) {\n                // This is a hack to prevent numerous warnings on Kotlin classes that inherit Java classes: if you override \"equals\" in such\n                // class without this hack, you'll be warned that in the superclass the name is \"p0\" (regardless of the fact that it's\n                // \"other\" in Any)\n                // TODO: fix Java parameter name loading logic somehow (don't always load \"p0\", \"p1\", etc.)\n                Name.identifier(\"other\")\n            } else if (parameterName != null && parameterName.isNotEmpty() && usedNames.add(parameterName)) {\n                Name.identifier(parameterName)\n            } else {\n                // TODO: parameter names may be drawn from attached sources, which is slow; it's better to make them lazy\n                val javaName = javaParameter.name\n                if (javaName == null) synthesizedNames = true\n                javaName ?: Name.identifier(\"p$index\")\n            }");
            ArrayList arrayList2 = arrayList;
            arrayList2.add(new l0(xVar, null, iComponent1, gVarResolveAnnotations, eVar, c0Var, false, false, false, c0Var2, gVar.getComponents().getSourceElementFactory().source(a0Var)));
            arrayList = arrayList2;
            z3 = z3;
            z2 = false;
            gVar2 = gVar;
        }
        return new b(u.toList(arrayList), z3);
    }

    public String toString() {
        return d0.z.d.m.stringPlus("Lazy scope for ", j());
    }

    public k(d0.e0.p.d.m0.e.a.i0.g gVar, k kVar) {
        d0.z.d.m.checkNotNullParameter(gVar, "c");
        this.c = gVar;
        this.d = kVar;
        this.e = gVar.getStorageManager().createRecursionTolerantLazyValue(new c(), d0.t.n.emptyList());
        this.f = gVar.getStorageManager().createLazyValue(new g());
        this.g = gVar.getStorageManager().createMemoizedFunction(new f());
        this.h = gVar.getStorageManager().createMemoizedFunctionWithNullableValues(new e());
        this.i = gVar.getStorageManager().createMemoizedFunction(new i());
        this.j = gVar.getStorageManager().createLazyValue(new h());
        this.k = gVar.getStorageManager().createLazyValue(new C0526k());
        this.l = gVar.getStorageManager().createLazyValue(new d());
        this.m = gVar.getStorageManager().createMemoizedFunction(new j());
    }
}

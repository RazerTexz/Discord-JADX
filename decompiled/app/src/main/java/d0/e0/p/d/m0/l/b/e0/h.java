package d0.e0.p.d.m0.l.b.e0;

import com.discord.models.domain.ModelAuditLogEntry;
import d0.e0.p.d.m0.c.n0;
import d0.e0.p.d.m0.c.t0;
import d0.e0.p.d.m0.c.y0;
import d0.e0.p.d.m0.f.r;
import d0.e0.p.d.m0.i.p;
import d0.e0.p.d.m0.k.a0.d;
import d0.e0.p.d.m0.l.b.w;
import d0.e0.p.d.m0.m.f;
import d0.f0.q;
import d0.t.g0;
import d0.t.h0;
import d0.t.o0;
import d0.t.u;
import d0.z.d.a0;
import d0.z.d.o;
import d0.z.d.y;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KProperty;

/* compiled from: DeserializedMemberScope.kt */
/* loaded from: classes3.dex */
public abstract class h extends d0.e0.p.d.m0.k.a0.j {

    /* renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ KProperty<Object>[] f3492b = {a0.property1(new y(a0.getOrCreateKotlinClass(h.class), "classNames", "getClassNames$deserialization()Ljava/util/Set;")), a0.property1(new y(a0.getOrCreateKotlinClass(h.class), "classifierNamesLazy", "getClassifierNamesLazy()Ljava/util/Set;"))};
    public final d0.e0.p.d.m0.l.b.l c;
    public final a d;
    public final d0.e0.p.d.m0.m.j e;
    public final d0.e0.p.d.m0.m.k f;

    /* compiled from: DeserializedMemberScope.kt */
    public interface a {
        void addFunctionsAndPropertiesTo(Collection<d0.e0.p.d.m0.c.m> collection, d0.e0.p.d.m0.k.a0.d dVar, Function1<? super d0.e0.p.d.m0.g.e, Boolean> function1, d0.e0.p.d.m0.d.b.b bVar);

        Collection<t0> getContributedFunctions(d0.e0.p.d.m0.g.e eVar, d0.e0.p.d.m0.d.b.b bVar);

        Collection<n0> getContributedVariables(d0.e0.p.d.m0.g.e eVar, d0.e0.p.d.m0.d.b.b bVar);

        Set<d0.e0.p.d.m0.g.e> getFunctionNames();

        y0 getTypeAliasByName(d0.e0.p.d.m0.g.e eVar);

        Set<d0.e0.p.d.m0.g.e> getTypeAliasNames();

        Set<d0.e0.p.d.m0.g.e> getVariableNames();
    }

    /* compiled from: DeserializedMemberScope.kt */
    public final class b implements a {
        public static final /* synthetic */ KProperty<Object>[] a = {a0.property1(new y(a0.getOrCreateKotlinClass(b.class), "declaredFunctions", "getDeclaredFunctions()Ljava/util/List;")), a0.property1(new y(a0.getOrCreateKotlinClass(b.class), "declaredProperties", "getDeclaredProperties()Ljava/util/List;")), a0.property1(new y(a0.getOrCreateKotlinClass(b.class), "allTypeAliases", "getAllTypeAliases()Ljava/util/List;")), a0.property1(new y(a0.getOrCreateKotlinClass(b.class), "allFunctions", "getAllFunctions()Ljava/util/List;")), a0.property1(new y(a0.getOrCreateKotlinClass(b.class), "allProperties", "getAllProperties()Ljava/util/List;")), a0.property1(new y(a0.getOrCreateKotlinClass(b.class), "typeAliasesByName", "getTypeAliasesByName()Ljava/util/Map;")), a0.property1(new y(a0.getOrCreateKotlinClass(b.class), "functionsByName", "getFunctionsByName()Ljava/util/Map;")), a0.property1(new y(a0.getOrCreateKotlinClass(b.class), "propertiesByName", "getPropertiesByName()Ljava/util/Map;")), a0.property1(new y(a0.getOrCreateKotlinClass(b.class), "functionNames", "getFunctionNames()Ljava/util/Set;")), a0.property1(new y(a0.getOrCreateKotlinClass(b.class), "variableNames", "getVariableNames()Ljava/util/Set;"))};

        /* renamed from: b, reason: collision with root package name */
        public final List<d0.e0.p.d.m0.f.i> f3493b;
        public final List<d0.e0.p.d.m0.f.n> c;
        public final List<r> d;
        public final d0.e0.p.d.m0.m.j e;
        public final d0.e0.p.d.m0.m.j f;
        public final d0.e0.p.d.m0.m.j g;
        public final d0.e0.p.d.m0.m.j h;
        public final d0.e0.p.d.m0.m.j i;
        public final d0.e0.p.d.m0.m.j j;
        public final d0.e0.p.d.m0.m.j k;
        public final d0.e0.p.d.m0.m.j l;
        public final d0.e0.p.d.m0.m.j m;
        public final d0.e0.p.d.m0.m.j n;
        public final /* synthetic */ h o;

        /* compiled from: DeserializedMemberScope.kt */
        public static final class a extends o implements Function0<List<? extends t0>> {
            public a() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ List<? extends t0> invoke() {
                return invoke2();
            }

            @Override // kotlin.jvm.functions.Function0
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final List<? extends t0> invoke2() {
                return u.plus((Collection) b.access$getDeclaredFunctions(b.this), (Iterable) b.access$computeAllNonDeclaredFunctions(b.this));
            }
        }

        /* compiled from: DeserializedMemberScope.kt */
        /* renamed from: d0.e0.p.d.m0.l.b.e0.h$b$b, reason: collision with other inner class name */
        public static final class C0574b extends o implements Function0<List<? extends n0>> {
            public C0574b() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ List<? extends n0> invoke() {
                return invoke2();
            }

            @Override // kotlin.jvm.functions.Function0
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final List<? extends n0> invoke2() {
                return u.plus((Collection) b.access$getDeclaredProperties(b.this), (Iterable) b.access$computeAllNonDeclaredProperties(b.this));
            }
        }

        /* compiled from: DeserializedMemberScope.kt */
        public static final class c extends o implements Function0<List<? extends y0>> {
            public c() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ List<? extends y0> invoke() {
                return invoke2();
            }

            @Override // kotlin.jvm.functions.Function0
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final List<? extends y0> invoke2() {
                return b.access$computeTypeAliases(b.this);
            }
        }

        /* compiled from: DeserializedMemberScope.kt */
        public static final class d extends o implements Function0<List<? extends t0>> {
            public d() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ List<? extends t0> invoke() {
                return invoke2();
            }

            @Override // kotlin.jvm.functions.Function0
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final List<? extends t0> invoke2() {
                return b.access$computeFunctions(b.this);
            }
        }

        /* compiled from: DeserializedMemberScope.kt */
        public static final class e extends o implements Function0<List<? extends n0>> {
            public e() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ List<? extends n0> invoke() {
                return invoke2();
            }

            @Override // kotlin.jvm.functions.Function0
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final List<? extends n0> invoke2() {
                return b.access$computeProperties(b.this);
            }
        }

        /* compiled from: DeserializedMemberScope.kt */
        public static final class f extends o implements Function0<Set<? extends d0.e0.p.d.m0.g.e>> {
            public final /* synthetic */ h this$1;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public f(h hVar) {
                super(0);
                this.this$1 = hVar;
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Set<? extends d0.e0.p.d.m0.g.e> invoke() {
                return invoke2();
            }

            @Override // kotlin.jvm.functions.Function0
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final Set<? extends d0.e0.p.d.m0.g.e> invoke2() {
                b bVar = b.this;
                List listAccess$getFunctionList$p = b.access$getFunctionList$p(bVar);
                LinkedHashSet linkedHashSet = new LinkedHashSet();
                h hVar = bVar.o;
                Iterator it = listAccess$getFunctionList$p.iterator();
                while (it.hasNext()) {
                    linkedHashSet.add(w.getName(h.access$getC(hVar).getNameResolver(), ((d0.e0.p.d.m0.f.i) ((d0.e0.p.d.m0.i.n) it.next())).getName()));
                }
                return o0.plus((Set) linkedHashSet, (Iterable) this.this$1.g());
            }
        }

        /* compiled from: DeserializedMemberScope.kt */
        public static final class g extends o implements Function0<Map<d0.e0.p.d.m0.g.e, ? extends List<? extends t0>>> {
            public g() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Map<d0.e0.p.d.m0.g.e, ? extends List<? extends t0>> invoke() {
                return invoke2();
            }

            @Override // kotlin.jvm.functions.Function0
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final Map<d0.e0.p.d.m0.g.e, ? extends List<? extends t0>> invoke2() {
                List listAccess$getAllFunctions = b.access$getAllFunctions(b.this);
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                for (Object obj : listAccess$getAllFunctions) {
                    d0.e0.p.d.m0.g.e name = ((t0) obj).getName();
                    d0.z.d.m.checkNotNullExpressionValue(name, "it.name");
                    Object arrayList = linkedHashMap.get(name);
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                        linkedHashMap.put(name, arrayList);
                    }
                    ((List) arrayList).add(obj);
                }
                return linkedHashMap;
            }
        }

        /* compiled from: DeserializedMemberScope.kt */
        /* renamed from: d0.e0.p.d.m0.l.b.e0.h$b$h, reason: collision with other inner class name */
        public static final class C0575h extends o implements Function0<Map<d0.e0.p.d.m0.g.e, ? extends List<? extends n0>>> {
            public C0575h() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Map<d0.e0.p.d.m0.g.e, ? extends List<? extends n0>> invoke() {
                return invoke2();
            }

            @Override // kotlin.jvm.functions.Function0
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final Map<d0.e0.p.d.m0.g.e, ? extends List<? extends n0>> invoke2() {
                List listAccess$getAllProperties = b.access$getAllProperties(b.this);
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                for (Object obj : listAccess$getAllProperties) {
                    d0.e0.p.d.m0.g.e name = ((n0) obj).getName();
                    d0.z.d.m.checkNotNullExpressionValue(name, "it.name");
                    Object arrayList = linkedHashMap.get(name);
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                        linkedHashMap.put(name, arrayList);
                    }
                    ((List) arrayList).add(obj);
                }
                return linkedHashMap;
            }
        }

        /* compiled from: DeserializedMemberScope.kt */
        public static final class i extends o implements Function0<Map<d0.e0.p.d.m0.g.e, ? extends y0>> {
            public i() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Map<d0.e0.p.d.m0.g.e, ? extends y0> invoke() {
                return invoke2();
            }

            @Override // kotlin.jvm.functions.Function0
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final Map<d0.e0.p.d.m0.g.e, ? extends y0> invoke2() {
                List listAccess$getAllTypeAliases = b.access$getAllTypeAliases(b.this);
                LinkedHashMap linkedHashMap = new LinkedHashMap(d0.d0.f.coerceAtLeast(g0.mapCapacity(d0.t.o.collectionSizeOrDefault(listAccess$getAllTypeAliases, 10)), 16));
                for (Object obj : listAccess$getAllTypeAliases) {
                    d0.e0.p.d.m0.g.e name = ((y0) obj).getName();
                    d0.z.d.m.checkNotNullExpressionValue(name, "it.name");
                    linkedHashMap.put(name, obj);
                }
                return linkedHashMap;
            }
        }

        /* compiled from: DeserializedMemberScope.kt */
        public static final class j extends o implements Function0<Set<? extends d0.e0.p.d.m0.g.e>> {
            public final /* synthetic */ h this$1;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public j(h hVar) {
                super(0);
                this.this$1 = hVar;
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Set<? extends d0.e0.p.d.m0.g.e> invoke() {
                return invoke2();
            }

            @Override // kotlin.jvm.functions.Function0
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final Set<? extends d0.e0.p.d.m0.g.e> invoke2() {
                b bVar = b.this;
                List listAccess$getPropertyList$p = b.access$getPropertyList$p(bVar);
                LinkedHashSet linkedHashSet = new LinkedHashSet();
                h hVar = bVar.o;
                Iterator it = listAccess$getPropertyList$p.iterator();
                while (it.hasNext()) {
                    linkedHashSet.add(w.getName(h.access$getC(hVar).getNameResolver(), ((d0.e0.p.d.m0.f.n) ((d0.e0.p.d.m0.i.n) it.next())).getName()));
                }
                return o0.plus((Set) linkedHashSet, (Iterable) this.this$1.h());
            }
        }

        public b(h hVar, List<d0.e0.p.d.m0.f.i> list, List<d0.e0.p.d.m0.f.n> list2, List<r> list3) {
            d0.z.d.m.checkNotNullParameter(hVar, "this$0");
            d0.z.d.m.checkNotNullParameter(list, "functionList");
            d0.z.d.m.checkNotNullParameter(list2, "propertyList");
            d0.z.d.m.checkNotNullParameter(list3, "typeAliasList");
            this.o = hVar;
            this.f3493b = list;
            this.c = list2;
            this.d = hVar.c.getComponents().getConfiguration().getTypeAliasesAllowed() ? list3 : d0.t.n.emptyList();
            this.e = hVar.c.getStorageManager().createLazyValue(new d());
            this.f = hVar.c.getStorageManager().createLazyValue(new e());
            this.g = hVar.c.getStorageManager().createLazyValue(new c());
            this.h = hVar.c.getStorageManager().createLazyValue(new a());
            this.i = hVar.c.getStorageManager().createLazyValue(new C0574b());
            this.j = hVar.c.getStorageManager().createLazyValue(new i());
            this.k = hVar.c.getStorageManager().createLazyValue(new g());
            this.l = hVar.c.getStorageManager().createLazyValue(new C0575h());
            this.m = hVar.c.getStorageManager().createLazyValue(new f(hVar));
            this.n = hVar.c.getStorageManager().createLazyValue(new j(hVar));
        }

        public static final List access$computeAllNonDeclaredFunctions(b bVar) {
            Set<d0.e0.p.d.m0.g.e> setG = bVar.o.g();
            ArrayList arrayList = new ArrayList();
            for (d0.e0.p.d.m0.g.e eVar : setG) {
                List list = (List) d0.e0.p.d.m0.m.n.getValue(bVar.e, bVar, (KProperty<?>) a[0]);
                h hVar = bVar.o;
                ArrayList arrayList2 = new ArrayList();
                for (Object obj : list) {
                    if (d0.z.d.m.areEqual(((d0.e0.p.d.m0.c.m) obj).getName(), eVar)) {
                        arrayList2.add(obj);
                    }
                }
                int size = arrayList2.size();
                hVar.c(eVar, arrayList2);
                d0.t.r.addAll(arrayList, arrayList2.subList(size, arrayList2.size()));
            }
            return arrayList;
        }

        public static final List access$computeAllNonDeclaredProperties(b bVar) {
            Set<d0.e0.p.d.m0.g.e> setH = bVar.o.h();
            ArrayList arrayList = new ArrayList();
            for (d0.e0.p.d.m0.g.e eVar : setH) {
                List list = (List) d0.e0.p.d.m0.m.n.getValue(bVar.f, bVar, (KProperty<?>) a[1]);
                h hVar = bVar.o;
                ArrayList arrayList2 = new ArrayList();
                for (Object obj : list) {
                    if (d0.z.d.m.areEqual(((d0.e0.p.d.m0.c.m) obj).getName(), eVar)) {
                        arrayList2.add(obj);
                    }
                }
                int size = arrayList2.size();
                hVar.d(eVar, arrayList2);
                d0.t.r.addAll(arrayList, arrayList2.subList(size, arrayList2.size()));
            }
            return arrayList;
        }

        public static final List access$computeFunctions(b bVar) {
            List<d0.e0.p.d.m0.f.i> list = bVar.f3493b;
            h hVar = bVar.o;
            ArrayList arrayList = new ArrayList();
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                t0 t0VarLoadFunction = h.access$getC(hVar).getMemberDeserializer().loadFunction((d0.e0.p.d.m0.f.i) ((d0.e0.p.d.m0.i.n) it.next()));
                if (!hVar.j(t0VarLoadFunction)) {
                    t0VarLoadFunction = null;
                }
                if (t0VarLoadFunction != null) {
                    arrayList.add(t0VarLoadFunction);
                }
            }
            return arrayList;
        }

        public static final List access$computeProperties(b bVar) {
            List<d0.e0.p.d.m0.f.n> list = bVar.c;
            h hVar = bVar.o;
            ArrayList arrayList = new ArrayList();
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                n0 n0VarLoadProperty = h.access$getC(hVar).getMemberDeserializer().loadProperty((d0.e0.p.d.m0.f.n) ((d0.e0.p.d.m0.i.n) it.next()));
                if (n0VarLoadProperty != null) {
                    arrayList.add(n0VarLoadProperty);
                }
            }
            return arrayList;
        }

        public static final List access$computeTypeAliases(b bVar) {
            List<r> list = bVar.d;
            h hVar = bVar.o;
            ArrayList arrayList = new ArrayList();
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                y0 y0VarLoadTypeAlias = h.access$getC(hVar).getMemberDeserializer().loadTypeAlias((r) ((d0.e0.p.d.m0.i.n) it.next()));
                if (y0VarLoadTypeAlias != null) {
                    arrayList.add(y0VarLoadTypeAlias);
                }
            }
            return arrayList;
        }

        public static final List access$getAllFunctions(b bVar) {
            return (List) d0.e0.p.d.m0.m.n.getValue(bVar.h, bVar, (KProperty<?>) a[3]);
        }

        public static final List access$getAllProperties(b bVar) {
            return (List) d0.e0.p.d.m0.m.n.getValue(bVar.i, bVar, (KProperty<?>) a[4]);
        }

        public static final List access$getAllTypeAliases(b bVar) {
            return (List) d0.e0.p.d.m0.m.n.getValue(bVar.g, bVar, (KProperty<?>) a[2]);
        }

        public static final List access$getDeclaredFunctions(b bVar) {
            return (List) d0.e0.p.d.m0.m.n.getValue(bVar.e, bVar, (KProperty<?>) a[0]);
        }

        public static final List access$getDeclaredProperties(b bVar) {
            return (List) d0.e0.p.d.m0.m.n.getValue(bVar.f, bVar, (KProperty<?>) a[1]);
        }

        public static final /* synthetic */ List access$getFunctionList$p(b bVar) {
            return bVar.f3493b;
        }

        public static final /* synthetic */ List access$getPropertyList$p(b bVar) {
            return bVar.c;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // d0.e0.p.d.m0.l.b.e0.h.a
        public void addFunctionsAndPropertiesTo(Collection<d0.e0.p.d.m0.c.m> collection, d0.e0.p.d.m0.k.a0.d dVar, Function1<? super d0.e0.p.d.m0.g.e, Boolean> function1, d0.e0.p.d.m0.d.b.b bVar) {
            d0.z.d.m.checkNotNullParameter(collection, "result");
            d0.z.d.m.checkNotNullParameter(dVar, "kindFilter");
            d0.z.d.m.checkNotNullParameter(function1, "nameFilter");
            d0.z.d.m.checkNotNullParameter(bVar, ModelAuditLogEntry.CHANGE_KEY_LOCATION);
            if (dVar.acceptsKinds(d0.e0.p.d.m0.k.a0.d.a.getVARIABLES_MASK())) {
                for (Object obj : (List) d0.e0.p.d.m0.m.n.getValue(this.i, this, (KProperty<?>) a[4])) {
                    d0.e0.p.d.m0.g.e name = ((n0) obj).getName();
                    d0.z.d.m.checkNotNullExpressionValue(name, "it.name");
                    if (function1.invoke(name).booleanValue()) {
                        collection.add(obj);
                    }
                }
            }
            if (dVar.acceptsKinds(d0.e0.p.d.m0.k.a0.d.a.getFUNCTIONS_MASK())) {
                for (Object obj2 : (List) d0.e0.p.d.m0.m.n.getValue(this.h, this, (KProperty<?>) a[3])) {
                    d0.e0.p.d.m0.g.e name2 = ((t0) obj2).getName();
                    d0.z.d.m.checkNotNullExpressionValue(name2, "it.name");
                    if (function1.invoke(name2).booleanValue()) {
                        collection.add(obj2);
                    }
                }
            }
        }

        @Override // d0.e0.p.d.m0.l.b.e0.h.a
        public Collection<t0> getContributedFunctions(d0.e0.p.d.m0.g.e eVar, d0.e0.p.d.m0.d.b.b bVar) {
            Collection<t0> collection;
            d0.z.d.m.checkNotNullParameter(eVar, ModelAuditLogEntry.CHANGE_KEY_NAME);
            d0.z.d.m.checkNotNullParameter(bVar, ModelAuditLogEntry.CHANGE_KEY_LOCATION);
            return (getFunctionNames().contains(eVar) && (collection = (Collection) ((Map) d0.e0.p.d.m0.m.n.getValue(this.k, this, (KProperty<?>) a[6])).get(eVar)) != null) ? collection : d0.t.n.emptyList();
        }

        @Override // d0.e0.p.d.m0.l.b.e0.h.a
        public Collection<n0> getContributedVariables(d0.e0.p.d.m0.g.e eVar, d0.e0.p.d.m0.d.b.b bVar) {
            Collection<n0> collection;
            d0.z.d.m.checkNotNullParameter(eVar, ModelAuditLogEntry.CHANGE_KEY_NAME);
            d0.z.d.m.checkNotNullParameter(bVar, ModelAuditLogEntry.CHANGE_KEY_LOCATION);
            return (getVariableNames().contains(eVar) && (collection = (Collection) ((Map) d0.e0.p.d.m0.m.n.getValue(this.l, this, (KProperty<?>) a[7])).get(eVar)) != null) ? collection : d0.t.n.emptyList();
        }

        @Override // d0.e0.p.d.m0.l.b.e0.h.a
        public Set<d0.e0.p.d.m0.g.e> getFunctionNames() {
            return (Set) d0.e0.p.d.m0.m.n.getValue(this.m, this, (KProperty<?>) a[8]);
        }

        @Override // d0.e0.p.d.m0.l.b.e0.h.a
        public y0 getTypeAliasByName(d0.e0.p.d.m0.g.e eVar) {
            d0.z.d.m.checkNotNullParameter(eVar, ModelAuditLogEntry.CHANGE_KEY_NAME);
            return (y0) ((Map) d0.e0.p.d.m0.m.n.getValue(this.j, this, (KProperty<?>) a[5])).get(eVar);
        }

        @Override // d0.e0.p.d.m0.l.b.e0.h.a
        public Set<d0.e0.p.d.m0.g.e> getTypeAliasNames() {
            List<r> list = this.d;
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            h hVar = this.o;
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                linkedHashSet.add(w.getName(h.access$getC(hVar).getNameResolver(), ((r) ((d0.e0.p.d.m0.i.n) it.next())).getName()));
            }
            return linkedHashSet;
        }

        @Override // d0.e0.p.d.m0.l.b.e0.h.a
        public Set<d0.e0.p.d.m0.g.e> getVariableNames() {
            return (Set) d0.e0.p.d.m0.m.n.getValue(this.n, this, (KProperty<?>) a[9]);
        }
    }

    /* compiled from: DeserializedMemberScope.kt */
    public final class c implements a {
        public static final /* synthetic */ KProperty<Object>[] a = {a0.property1(new y(a0.getOrCreateKotlinClass(c.class), "functionNames", "getFunctionNames()Ljava/util/Set;")), a0.property1(new y(a0.getOrCreateKotlinClass(c.class), "variableNames", "getVariableNames()Ljava/util/Set;"))};

        /* renamed from: b, reason: collision with root package name */
        public final Map<d0.e0.p.d.m0.g.e, byte[]> f3494b;
        public final Map<d0.e0.p.d.m0.g.e, byte[]> c;
        public final Map<d0.e0.p.d.m0.g.e, byte[]> d;
        public final d0.e0.p.d.m0.m.h<d0.e0.p.d.m0.g.e, Collection<t0>> e;
        public final d0.e0.p.d.m0.m.h<d0.e0.p.d.m0.g.e, Collection<n0>> f;
        public final d0.e0.p.d.m0.m.i<d0.e0.p.d.m0.g.e, y0> g;
        public final d0.e0.p.d.m0.m.j h;
        public final d0.e0.p.d.m0.m.j i;
        public final /* synthetic */ h j;

        /* JADX INFO: Add missing generic type declarations: [M] */
        /* compiled from: DeserializedMemberScope.kt */
        public static final class a<M> extends o implements Function0<M> {
            public final /* synthetic */ ByteArrayInputStream $inputStream;
            public final /* synthetic */ p<M> $parser;
            public final /* synthetic */ h this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(p<M> pVar, ByteArrayInputStream byteArrayInputStream, h hVar) {
                super(0);
                this.$parser = pVar;
                this.$inputStream = byteArrayInputStream;
                this.this$0 = hVar;
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Object invoke() {
                return invoke();
            }

            /* JADX WARN: Incorrect return type in method signature: ()TM; */
            @Override // kotlin.jvm.functions.Function0
            public final d0.e0.p.d.m0.i.n invoke() {
                return (d0.e0.p.d.m0.i.n) ((d0.e0.p.d.m0.i.b) this.$parser).m89parseDelimitedFrom((InputStream) this.$inputStream, this.this$0.c.getComponents().getExtensionRegistryLite());
            }
        }

        /* compiled from: DeserializedMemberScope.kt */
        public static final class b extends o implements Function0<Set<? extends d0.e0.p.d.m0.g.e>> {
            public final /* synthetic */ h this$1;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public b(h hVar) {
                super(0);
                this.this$1 = hVar;
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Set<? extends d0.e0.p.d.m0.g.e> invoke() {
                return invoke2();
            }

            @Override // kotlin.jvm.functions.Function0
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final Set<? extends d0.e0.p.d.m0.g.e> invoke2() {
                return o0.plus(c.access$getFunctionProtosBytes$p(c.this).keySet(), (Iterable) this.this$1.g());
            }
        }

        /* compiled from: DeserializedMemberScope.kt */
        /* renamed from: d0.e0.p.d.m0.l.b.e0.h$c$c, reason: collision with other inner class name */
        public static final class C0576c extends o implements Function1<d0.e0.p.d.m0.g.e, Collection<? extends t0>> {
            public C0576c() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Collection<? extends t0> invoke(d0.e0.p.d.m0.g.e eVar) {
                return invoke2(eVar);
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final Collection<t0> invoke2(d0.e0.p.d.m0.g.e eVar) {
                d0.z.d.m.checkNotNullParameter(eVar, "it");
                return c.access$computeFunctions(c.this, eVar);
            }
        }

        /* compiled from: DeserializedMemberScope.kt */
        public static final class d extends o implements Function1<d0.e0.p.d.m0.g.e, Collection<? extends n0>> {
            public d() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Collection<? extends n0> invoke(d0.e0.p.d.m0.g.e eVar) {
                return invoke2(eVar);
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final Collection<n0> invoke2(d0.e0.p.d.m0.g.e eVar) {
                d0.z.d.m.checkNotNullParameter(eVar, "it");
                return c.access$computeProperties(c.this, eVar);
            }
        }

        /* compiled from: DeserializedMemberScope.kt */
        public static final class e extends o implements Function1<d0.e0.p.d.m0.g.e, y0> {
            public e() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ y0 invoke(d0.e0.p.d.m0.g.e eVar) {
                return invoke2(eVar);
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final y0 invoke2(d0.e0.p.d.m0.g.e eVar) {
                d0.z.d.m.checkNotNullParameter(eVar, "it");
                return c.access$createTypeAlias(c.this, eVar);
            }
        }

        /* compiled from: DeserializedMemberScope.kt */
        public static final class f extends o implements Function0<Set<? extends d0.e0.p.d.m0.g.e>> {
            public final /* synthetic */ h this$1;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public f(h hVar) {
                super(0);
                this.this$1 = hVar;
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Set<? extends d0.e0.p.d.m0.g.e> invoke() {
                return invoke2();
            }

            @Override // kotlin.jvm.functions.Function0
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final Set<? extends d0.e0.p.d.m0.g.e> invoke2() {
                return o0.plus(c.access$getPropertyProtosBytes$p(c.this).keySet(), (Iterable) this.this$1.h());
            }
        }

        public c(h hVar, List<d0.e0.p.d.m0.f.i> list, List<d0.e0.p.d.m0.f.n> list2, List<r> list3) throws IOException {
            Map<d0.e0.p.d.m0.g.e, byte[]> mapEmptyMap;
            d0.z.d.m.checkNotNullParameter(hVar, "this$0");
            d0.z.d.m.checkNotNullParameter(list, "functionList");
            d0.z.d.m.checkNotNullParameter(list2, "propertyList");
            d0.z.d.m.checkNotNullParameter(list3, "typeAliasList");
            this.j = hVar;
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (Object obj : list) {
                d0.e0.p.d.m0.g.e name = w.getName(h.access$getC(hVar).getNameResolver(), ((d0.e0.p.d.m0.f.i) ((d0.e0.p.d.m0.i.n) obj)).getName());
                Object arrayList = linkedHashMap.get(name);
                if (arrayList == null) {
                    arrayList = new ArrayList();
                    linkedHashMap.put(name, arrayList);
                }
                ((List) arrayList).add(obj);
            }
            this.f3494b = a(linkedHashMap);
            h hVar2 = this.j;
            LinkedHashMap linkedHashMap2 = new LinkedHashMap();
            for (Object obj2 : list2) {
                d0.e0.p.d.m0.g.e name2 = w.getName(h.access$getC(hVar2).getNameResolver(), ((d0.e0.p.d.m0.f.n) ((d0.e0.p.d.m0.i.n) obj2)).getName());
                Object arrayList2 = linkedHashMap2.get(name2);
                if (arrayList2 == null) {
                    arrayList2 = new ArrayList();
                    linkedHashMap2.put(name2, arrayList2);
                }
                ((List) arrayList2).add(obj2);
            }
            this.c = a(linkedHashMap2);
            if (this.j.c.getComponents().getConfiguration().getTypeAliasesAllowed()) {
                h hVar3 = this.j;
                LinkedHashMap linkedHashMap3 = new LinkedHashMap();
                for (Object obj3 : list3) {
                    d0.e0.p.d.m0.g.e name3 = w.getName(h.access$getC(hVar3).getNameResolver(), ((r) ((d0.e0.p.d.m0.i.n) obj3)).getName());
                    Object arrayList3 = linkedHashMap3.get(name3);
                    if (arrayList3 == null) {
                        arrayList3 = new ArrayList();
                        linkedHashMap3.put(name3, arrayList3);
                    }
                    ((List) arrayList3).add(obj3);
                }
                mapEmptyMap = a(linkedHashMap3);
            } else {
                mapEmptyMap = h0.emptyMap();
            }
            this.d = mapEmptyMap;
            this.e = this.j.c.getStorageManager().createMemoizedFunction(new C0576c());
            this.f = this.j.c.getStorageManager().createMemoizedFunction(new d());
            this.g = this.j.c.getStorageManager().createMemoizedFunctionWithNullableValues(new e());
            this.h = this.j.c.getStorageManager().createLazyValue(new b(this.j));
            this.i = this.j.c.getStorageManager().createLazyValue(new f(this.j));
        }

        public static final Collection access$computeFunctions(c cVar, d0.e0.p.d.m0.g.e eVar) {
            Map<d0.e0.p.d.m0.g.e, byte[]> map = cVar.f3494b;
            p<d0.e0.p.d.m0.f.i> pVar = d0.e0.p.d.m0.f.i.k;
            d0.z.d.m.checkNotNullExpressionValue(pVar, "PARSER");
            h hVar = cVar.j;
            byte[] bArr = map.get(eVar);
            List<d0.e0.p.d.m0.f.i> list = bArr == null ? null : q.toList(d0.f0.n.generateSequence(new a(pVar, new ByteArrayInputStream(bArr), cVar.j)));
            if (list == null) {
                list = d0.t.n.emptyList();
            }
            ArrayList arrayList = new ArrayList(list.size());
            for (d0.e0.p.d.m0.f.i iVar : list) {
                d0.e0.p.d.m0.l.b.u memberDeserializer = hVar.c.getMemberDeserializer();
                d0.z.d.m.checkNotNullExpressionValue(iVar, "it");
                t0 t0VarLoadFunction = memberDeserializer.loadFunction(iVar);
                if (!hVar.j(t0VarLoadFunction)) {
                    t0VarLoadFunction = null;
                }
                if (t0VarLoadFunction != null) {
                    arrayList.add(t0VarLoadFunction);
                }
            }
            hVar.c(eVar, arrayList);
            return d0.e0.p.d.m0.p.a.compact(arrayList);
        }

        public static final Collection access$computeProperties(c cVar, d0.e0.p.d.m0.g.e eVar) {
            Map<d0.e0.p.d.m0.g.e, byte[]> map = cVar.c;
            p<d0.e0.p.d.m0.f.n> pVar = d0.e0.p.d.m0.f.n.k;
            d0.z.d.m.checkNotNullExpressionValue(pVar, "PARSER");
            h hVar = cVar.j;
            byte[] bArr = map.get(eVar);
            List<d0.e0.p.d.m0.f.n> list = bArr == null ? null : q.toList(d0.f0.n.generateSequence(new a(pVar, new ByteArrayInputStream(bArr), cVar.j)));
            if (list == null) {
                list = d0.t.n.emptyList();
            }
            ArrayList arrayList = new ArrayList(list.size());
            for (d0.e0.p.d.m0.f.n nVar : list) {
                d0.e0.p.d.m0.l.b.u memberDeserializer = hVar.c.getMemberDeserializer();
                d0.z.d.m.checkNotNullExpressionValue(nVar, "it");
                n0 n0VarLoadProperty = memberDeserializer.loadProperty(nVar);
                if (n0VarLoadProperty != null) {
                    arrayList.add(n0VarLoadProperty);
                }
            }
            hVar.d(eVar, arrayList);
            return d0.e0.p.d.m0.p.a.compact(arrayList);
        }

        public static final y0 access$createTypeAlias(c cVar, d0.e0.p.d.m0.g.e eVar) {
            r delimitedFrom;
            byte[] bArr = cVar.d.get(eVar);
            if (bArr == null || (delimitedFrom = r.parseDelimitedFrom(new ByteArrayInputStream(bArr), cVar.j.c.getComponents().getExtensionRegistryLite())) == null) {
                return null;
            }
            return cVar.j.c.getMemberDeserializer().loadTypeAlias(delimitedFrom);
        }

        public static final /* synthetic */ Map access$getFunctionProtosBytes$p(c cVar) {
            return cVar.f3494b;
        }

        public static final /* synthetic */ Map access$getPropertyProtosBytes$p(c cVar) {
            return cVar.c;
        }

        public final Map<d0.e0.p.d.m0.g.e, byte[]> a(Map<d0.e0.p.d.m0.g.e, ? extends Collection<? extends d0.e0.p.d.m0.i.a>> map) throws IOException {
            LinkedHashMap linkedHashMap = new LinkedHashMap(g0.mapCapacity(map.size()));
            Iterator<T> it = map.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry entry = (Map.Entry) it.next();
                Object key = entry.getKey();
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                Iterable iterable = (Iterable) entry.getValue();
                ArrayList arrayList = new ArrayList(d0.t.o.collectionSizeOrDefault(iterable, 10));
                Iterator it2 = iterable.iterator();
                while (it2.hasNext()) {
                    ((d0.e0.p.d.m0.i.a) it2.next()).writeDelimitedTo(byteArrayOutputStream);
                    arrayList.add(Unit.a);
                }
                linkedHashMap.put(key, byteArrayOutputStream.toByteArray());
            }
            return linkedHashMap;
        }

        @Override // d0.e0.p.d.m0.l.b.e0.h.a
        public void addFunctionsAndPropertiesTo(Collection<d0.e0.p.d.m0.c.m> collection, d0.e0.p.d.m0.k.a0.d dVar, Function1<? super d0.e0.p.d.m0.g.e, Boolean> function1, d0.e0.p.d.m0.d.b.b bVar) {
            d0.z.d.m.checkNotNullParameter(collection, "result");
            d0.z.d.m.checkNotNullParameter(dVar, "kindFilter");
            d0.z.d.m.checkNotNullParameter(function1, "nameFilter");
            d0.z.d.m.checkNotNullParameter(bVar, ModelAuditLogEntry.CHANGE_KEY_LOCATION);
            if (dVar.acceptsKinds(d0.e0.p.d.m0.k.a0.d.a.getVARIABLES_MASK())) {
                Set<d0.e0.p.d.m0.g.e> variableNames = getVariableNames();
                ArrayList arrayList = new ArrayList();
                for (d0.e0.p.d.m0.g.e eVar : variableNames) {
                    if (function1.invoke(eVar).booleanValue()) {
                        arrayList.addAll(getContributedVariables(eVar, bVar));
                    }
                }
                d0.e0.p.d.m0.k.h hVar = d0.e0.p.d.m0.k.h.j;
                d0.z.d.m.checkNotNullExpressionValue(hVar, "INSTANCE");
                d0.t.q.sortWith(arrayList, hVar);
                collection.addAll(arrayList);
            }
            if (dVar.acceptsKinds(d0.e0.p.d.m0.k.a0.d.a.getFUNCTIONS_MASK())) {
                Set<d0.e0.p.d.m0.g.e> functionNames = getFunctionNames();
                ArrayList arrayList2 = new ArrayList();
                for (d0.e0.p.d.m0.g.e eVar2 : functionNames) {
                    if (function1.invoke(eVar2).booleanValue()) {
                        arrayList2.addAll(getContributedFunctions(eVar2, bVar));
                    }
                }
                d0.e0.p.d.m0.k.h hVar2 = d0.e0.p.d.m0.k.h.j;
                d0.z.d.m.checkNotNullExpressionValue(hVar2, "INSTANCE");
                d0.t.q.sortWith(arrayList2, hVar2);
                collection.addAll(arrayList2);
            }
        }

        @Override // d0.e0.p.d.m0.l.b.e0.h.a
        public Collection<t0> getContributedFunctions(d0.e0.p.d.m0.g.e eVar, d0.e0.p.d.m0.d.b.b bVar) {
            d0.z.d.m.checkNotNullParameter(eVar, ModelAuditLogEntry.CHANGE_KEY_NAME);
            d0.z.d.m.checkNotNullParameter(bVar, ModelAuditLogEntry.CHANGE_KEY_LOCATION);
            return !getFunctionNames().contains(eVar) ? d0.t.n.emptyList() : (Collection) ((f.m) this.e).invoke(eVar);
        }

        @Override // d0.e0.p.d.m0.l.b.e0.h.a
        public Collection<n0> getContributedVariables(d0.e0.p.d.m0.g.e eVar, d0.e0.p.d.m0.d.b.b bVar) {
            d0.z.d.m.checkNotNullParameter(eVar, ModelAuditLogEntry.CHANGE_KEY_NAME);
            d0.z.d.m.checkNotNullParameter(bVar, ModelAuditLogEntry.CHANGE_KEY_LOCATION);
            return !getVariableNames().contains(eVar) ? d0.t.n.emptyList() : (Collection) ((f.m) this.f).invoke(eVar);
        }

        @Override // d0.e0.p.d.m0.l.b.e0.h.a
        public Set<d0.e0.p.d.m0.g.e> getFunctionNames() {
            return (Set) d0.e0.p.d.m0.m.n.getValue(this.h, this, (KProperty<?>) a[0]);
        }

        @Override // d0.e0.p.d.m0.l.b.e0.h.a
        public y0 getTypeAliasByName(d0.e0.p.d.m0.g.e eVar) {
            d0.z.d.m.checkNotNullParameter(eVar, ModelAuditLogEntry.CHANGE_KEY_NAME);
            return this.g.invoke(eVar);
        }

        @Override // d0.e0.p.d.m0.l.b.e0.h.a
        public Set<d0.e0.p.d.m0.g.e> getTypeAliasNames() {
            return this.d.keySet();
        }

        @Override // d0.e0.p.d.m0.l.b.e0.h.a
        public Set<d0.e0.p.d.m0.g.e> getVariableNames() {
            return (Set) d0.e0.p.d.m0.m.n.getValue(this.i, this, (KProperty<?>) a[1]);
        }
    }

    /* compiled from: DeserializedMemberScope.kt */
    public static final class d extends o implements Function0<Set<? extends d0.e0.p.d.m0.g.e>> {
        public final /* synthetic */ Function0<Collection<d0.e0.p.d.m0.g.e>> $classNames;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public d(Function0<? extends Collection<d0.e0.p.d.m0.g.e>> function0) {
            super(0);
            this.$classNames = function0;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Set<? extends d0.e0.p.d.m0.g.e> invoke() {
            return invoke2();
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Set<? extends d0.e0.p.d.m0.g.e> invoke2() {
            return u.toSet(this.$classNames.invoke());
        }
    }

    /* compiled from: DeserializedMemberScope.kt */
    public static final class e extends o implements Function0<Set<? extends d0.e0.p.d.m0.g.e>> {
        public e() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Set<? extends d0.e0.p.d.m0.g.e> invoke() {
            return invoke2();
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Set<? extends d0.e0.p.d.m0.g.e> invoke2() {
            Set<d0.e0.p.d.m0.g.e> setF = h.this.f();
            if (setF == null) {
                return null;
            }
            return o0.plus(o0.plus((Set) h.this.getClassNames$deserialization(), (Iterable) h.access$getImpl$p(h.this).getTypeAliasNames()), (Iterable) setF);
        }
    }

    public h(d0.e0.p.d.m0.l.b.l lVar, List<d0.e0.p.d.m0.f.i> list, List<d0.e0.p.d.m0.f.n> list2, List<r> list3, Function0<? extends Collection<d0.e0.p.d.m0.g.e>> function0) {
        d0.z.d.m.checkNotNullParameter(lVar, "c");
        d0.z.d.m.checkNotNullParameter(list, "functionList");
        d0.z.d.m.checkNotNullParameter(list2, "propertyList");
        d0.z.d.m.checkNotNullParameter(list3, "typeAliasList");
        d0.z.d.m.checkNotNullParameter(function0, "classNames");
        this.c = lVar;
        this.d = lVar.getComponents().getConfiguration().getPreserveDeclarationsOrdering() ? new b(this, list, list2, list3) : new c(this, list, list2, list3);
        this.e = lVar.getStorageManager().createLazyValue(new d(function0));
        this.f = lVar.getStorageManager().createNullableLazyValue(new e());
    }

    public static final /* synthetic */ d0.e0.p.d.m0.l.b.l access$getC(h hVar) {
        return hVar.c;
    }

    public static final /* synthetic */ a access$getImpl$p(h hVar) {
        return hVar.d;
    }

    public abstract void a(Collection<d0.e0.p.d.m0.c.m> collection, Function1<? super d0.e0.p.d.m0.g.e, Boolean> function1);

    public final Collection<d0.e0.p.d.m0.c.m> b(d0.e0.p.d.m0.k.a0.d dVar, Function1<? super d0.e0.p.d.m0.g.e, Boolean> function1, d0.e0.p.d.m0.d.b.b bVar) {
        d0.z.d.m.checkNotNullParameter(dVar, "kindFilter");
        d0.z.d.m.checkNotNullParameter(function1, "nameFilter");
        d0.z.d.m.checkNotNullParameter(bVar, ModelAuditLogEntry.CHANGE_KEY_LOCATION);
        ArrayList arrayList = new ArrayList(0);
        d.a aVar = d0.e0.p.d.m0.k.a0.d.a;
        if (dVar.acceptsKinds(aVar.getSINGLETON_CLASSIFIERS_MASK())) {
            a(arrayList, function1);
        }
        this.d.addFunctionsAndPropertiesTo(arrayList, dVar, function1, bVar);
        if (dVar.acceptsKinds(aVar.getCLASSIFIERS_MASK())) {
            for (d0.e0.p.d.m0.g.e eVar : getClassNames$deserialization()) {
                if (function1.invoke(eVar).booleanValue()) {
                    d0.e0.p.d.m0.p.a.addIfNotNull(arrayList, this.c.getComponents().deserializeClass(e(eVar)));
                }
            }
        }
        if (dVar.acceptsKinds(d0.e0.p.d.m0.k.a0.d.a.getTYPE_ALIASES_MASK())) {
            for (d0.e0.p.d.m0.g.e eVar2 : this.d.getTypeAliasNames()) {
                if (function1.invoke(eVar2).booleanValue()) {
                    d0.e0.p.d.m0.p.a.addIfNotNull(arrayList, this.d.getTypeAliasByName(eVar2));
                }
            }
        }
        return d0.e0.p.d.m0.p.a.compact(arrayList);
    }

    public void c(d0.e0.p.d.m0.g.e eVar, List<t0> list) {
        d0.z.d.m.checkNotNullParameter(eVar, ModelAuditLogEntry.CHANGE_KEY_NAME);
        d0.z.d.m.checkNotNullParameter(list, "functions");
    }

    public void d(d0.e0.p.d.m0.g.e eVar, List<n0> list) {
        d0.z.d.m.checkNotNullParameter(eVar, ModelAuditLogEntry.CHANGE_KEY_NAME);
        d0.z.d.m.checkNotNullParameter(list, "descriptors");
    }

    public abstract d0.e0.p.d.m0.g.a e(d0.e0.p.d.m0.g.e eVar);

    public abstract Set<d0.e0.p.d.m0.g.e> f();

    public abstract Set<d0.e0.p.d.m0.g.e> g();

    public final Set<d0.e0.p.d.m0.g.e> getClassNames$deserialization() {
        return (Set) d0.e0.p.d.m0.m.n.getValue(this.e, this, (KProperty<?>) f3492b[0]);
    }

    @Override // d0.e0.p.d.m0.k.a0.j, d0.e0.p.d.m0.k.a0.i
    public Set<d0.e0.p.d.m0.g.e> getClassifierNames() {
        return (Set) d0.e0.p.d.m0.m.n.getValue(this.f, this, (KProperty<?>) f3492b[1]);
    }

    @Override // d0.e0.p.d.m0.k.a0.j, d0.e0.p.d.m0.k.a0.l
    public d0.e0.p.d.m0.c.h getContributedClassifier(d0.e0.p.d.m0.g.e eVar, d0.e0.p.d.m0.d.b.b bVar) {
        d0.z.d.m.checkNotNullParameter(eVar, ModelAuditLogEntry.CHANGE_KEY_NAME);
        d0.z.d.m.checkNotNullParameter(bVar, ModelAuditLogEntry.CHANGE_KEY_LOCATION);
        if (i(eVar)) {
            return this.c.getComponents().deserializeClass(e(eVar));
        }
        if (this.d.getTypeAliasNames().contains(eVar)) {
            return this.d.getTypeAliasByName(eVar);
        }
        return null;
    }

    @Override // d0.e0.p.d.m0.k.a0.j, d0.e0.p.d.m0.k.a0.i
    public Collection<t0> getContributedFunctions(d0.e0.p.d.m0.g.e eVar, d0.e0.p.d.m0.d.b.b bVar) {
        d0.z.d.m.checkNotNullParameter(eVar, ModelAuditLogEntry.CHANGE_KEY_NAME);
        d0.z.d.m.checkNotNullParameter(bVar, ModelAuditLogEntry.CHANGE_KEY_LOCATION);
        return this.d.getContributedFunctions(eVar, bVar);
    }

    @Override // d0.e0.p.d.m0.k.a0.j, d0.e0.p.d.m0.k.a0.i
    public Collection<n0> getContributedVariables(d0.e0.p.d.m0.g.e eVar, d0.e0.p.d.m0.d.b.b bVar) {
        d0.z.d.m.checkNotNullParameter(eVar, ModelAuditLogEntry.CHANGE_KEY_NAME);
        d0.z.d.m.checkNotNullParameter(bVar, ModelAuditLogEntry.CHANGE_KEY_LOCATION);
        return this.d.getContributedVariables(eVar, bVar);
    }

    @Override // d0.e0.p.d.m0.k.a0.j, d0.e0.p.d.m0.k.a0.i
    public Set<d0.e0.p.d.m0.g.e> getFunctionNames() {
        return this.d.getFunctionNames();
    }

    @Override // d0.e0.p.d.m0.k.a0.j, d0.e0.p.d.m0.k.a0.i
    public Set<d0.e0.p.d.m0.g.e> getVariableNames() {
        return this.d.getVariableNames();
    }

    public abstract Set<d0.e0.p.d.m0.g.e> h();

    public boolean i(d0.e0.p.d.m0.g.e eVar) {
        d0.z.d.m.checkNotNullParameter(eVar, ModelAuditLogEntry.CHANGE_KEY_NAME);
        return getClassNames$deserialization().contains(eVar);
    }

    public boolean j(t0 t0Var) {
        d0.z.d.m.checkNotNullParameter(t0Var, "function");
        return true;
    }
}

package p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b.p565e0;

import com.discord.models.domain.ModelAuditLogEntry;
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
import p507d0.p512d0._Ranges;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.ClassifierDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.DeclarationDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.PropertyDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.SimpleFunctionDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.TypeAliasDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p529d.p530b.LookupLocation2;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.C11684i;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.C11689n;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.C11693r;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.ClassId;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.Name;
import p507d0.p513e0.p514p.p515d.p517m0.p550i.AbstractMessageLite;
import p507d0.p513e0.p514p.p515d.p517m0.p550i.AbstractParser;
import p507d0.p513e0.p514p.p515d.p517m0.p550i.MessageLite;
import p507d0.p513e0.p514p.p515d.p517m0.p550i.Parser2;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.MemberComparator;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.MemberScope2;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.MemberScopeImpl;
import p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b.MemberDeserializer;
import p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b.NameResolverUtil;
import p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b.context6;
import p507d0.p513e0.p514p.p515d.p517m0.p566m.LockBasedStorageManager;
import p507d0.p513e0.p514p.p515d.p517m0.p566m.storage3;
import p507d0.p513e0.p514p.p515d.p517m0.p566m.storage4;
import p507d0.p513e0.p514p.p515d.p517m0.p566m.storage5;
import p507d0.p513e0.p514p.p515d.p517m0.p566m.storage6;
import p507d0.p513e0.p514p.p515d.p517m0.p566m.storage7;
import p507d0.p513e0.p514p.p515d.p517m0.p576p.collections;
import p507d0.p578f0.C12075n;
import p507d0.p578f0._Sequences2;
import p507d0.p580t.Collections2;
import p507d0.p580t.Iterables2;
import p507d0.p580t.Maps6;
import p507d0.p580t.MapsJVM;
import p507d0.p580t.MutableCollections;
import p507d0.p580t.MutableCollectionsJVM;
import p507d0.p580t._Collections;
import p507d0.p580t._Sets;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;
import p507d0.p592z.p594d.PropertyReference1Impl;
import p507d0.p592z.p594d.Reflection2;

/* JADX INFO: renamed from: d0.e0.p.d.m0.l.b.e0.h, reason: use source file name */
/* JADX INFO: compiled from: DeserializedMemberScope.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class DeserializedMemberScope extends MemberScopeImpl {

    /* JADX INFO: renamed from: b */
    public static final /* synthetic */ KProperty<Object>[] f24567b = {Reflection2.property1(new PropertyReference1Impl(Reflection2.getOrCreateKotlinClass(DeserializedMemberScope.class), "classNames", "getClassNames$deserialization()Ljava/util/Set;")), Reflection2.property1(new PropertyReference1Impl(Reflection2.getOrCreateKotlinClass(DeserializedMemberScope.class), "classifierNamesLazy", "getClassifierNamesLazy()Ljava/util/Set;"))};

    /* JADX INFO: renamed from: c */
    public final context6 f24568c;

    /* JADX INFO: renamed from: d */
    public final a f24569d;

    /* JADX INFO: renamed from: e */
    public final storage5 f24570e;

    /* JADX INFO: renamed from: f */
    public final storage6 f24571f;

    /* JADX INFO: renamed from: d0.e0.p.d.m0.l.b.e0.h$a */
    /* JADX INFO: compiled from: DeserializedMemberScope.kt */
    public interface a {
        void addFunctionsAndPropertiesTo(Collection<DeclarationDescriptor> collection, MemberScope2 memberScope2, Function1<? super Name, Boolean> function1, LookupLocation2 lookupLocation2);

        Collection<SimpleFunctionDescriptor> getContributedFunctions(Name name, LookupLocation2 lookupLocation2);

        Collection<PropertyDescriptor> getContributedVariables(Name name, LookupLocation2 lookupLocation2);

        Set<Name> getFunctionNames();

        TypeAliasDescriptor getTypeAliasByName(Name name);

        Set<Name> getTypeAliasNames();

        Set<Name> getVariableNames();
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.l.b.e0.h$b */
    /* JADX INFO: compiled from: DeserializedMemberScope.kt */
    public final class b implements a {

        /* JADX INFO: renamed from: a */
        public static final /* synthetic */ KProperty<Object>[] f24572a = {Reflection2.property1(new PropertyReference1Impl(Reflection2.getOrCreateKotlinClass(b.class), "declaredFunctions", "getDeclaredFunctions()Ljava/util/List;")), Reflection2.property1(new PropertyReference1Impl(Reflection2.getOrCreateKotlinClass(b.class), "declaredProperties", "getDeclaredProperties()Ljava/util/List;")), Reflection2.property1(new PropertyReference1Impl(Reflection2.getOrCreateKotlinClass(b.class), "allTypeAliases", "getAllTypeAliases()Ljava/util/List;")), Reflection2.property1(new PropertyReference1Impl(Reflection2.getOrCreateKotlinClass(b.class), "allFunctions", "getAllFunctions()Ljava/util/List;")), Reflection2.property1(new PropertyReference1Impl(Reflection2.getOrCreateKotlinClass(b.class), "allProperties", "getAllProperties()Ljava/util/List;")), Reflection2.property1(new PropertyReference1Impl(Reflection2.getOrCreateKotlinClass(b.class), "typeAliasesByName", "getTypeAliasesByName()Ljava/util/Map;")), Reflection2.property1(new PropertyReference1Impl(Reflection2.getOrCreateKotlinClass(b.class), "functionsByName", "getFunctionsByName()Ljava/util/Map;")), Reflection2.property1(new PropertyReference1Impl(Reflection2.getOrCreateKotlinClass(b.class), "propertiesByName", "getPropertiesByName()Ljava/util/Map;")), Reflection2.property1(new PropertyReference1Impl(Reflection2.getOrCreateKotlinClass(b.class), "functionNames", "getFunctionNames()Ljava/util/Set;")), Reflection2.property1(new PropertyReference1Impl(Reflection2.getOrCreateKotlinClass(b.class), "variableNames", "getVariableNames()Ljava/util/Set;"))};

        /* JADX INFO: renamed from: b */
        public final List<C11684i> f24573b;

        /* JADX INFO: renamed from: c */
        public final List<C11689n> f24574c;

        /* JADX INFO: renamed from: d */
        public final List<C11693r> f24575d;

        /* JADX INFO: renamed from: e */
        public final storage5 f24576e;

        /* JADX INFO: renamed from: f */
        public final storage5 f24577f;

        /* JADX INFO: renamed from: g */
        public final storage5 f24578g;

        /* JADX INFO: renamed from: h */
        public final storage5 f24579h;

        /* JADX INFO: renamed from: i */
        public final storage5 f24580i;

        /* JADX INFO: renamed from: j */
        public final storage5 f24581j;

        /* JADX INFO: renamed from: k */
        public final storage5 f24582k;

        /* JADX INFO: renamed from: l */
        public final storage5 f24583l;

        /* JADX INFO: renamed from: m */
        public final storage5 f24584m;

        /* JADX INFO: renamed from: n */
        public final storage5 f24585n;

        /* JADX INFO: renamed from: o */
        public final /* synthetic */ DeserializedMemberScope f24586o;

        /* JADX INFO: renamed from: d0.e0.p.d.m0.l.b.e0.h$b$a */
        /* JADX INFO: compiled from: DeserializedMemberScope.kt */
        public static final class a extends Lambda implements Function0<List<? extends SimpleFunctionDescriptor>> {
            public a() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ List<? extends SimpleFunctionDescriptor> invoke() {
                return invoke2();
            }

            @Override // kotlin.jvm.functions.Function0
            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final List<? extends SimpleFunctionDescriptor> invoke2() {
                return _Collections.plus((Collection) b.access$getDeclaredFunctions(b.this), (Iterable) b.access$computeAllNonDeclaredFunctions(b.this));
            }
        }

        /* JADX INFO: renamed from: d0.e0.p.d.m0.l.b.e0.h$b$b, reason: collision with other inner class name */
        /* JADX INFO: compiled from: DeserializedMemberScope.kt */
        public static final class C13332b extends Lambda implements Function0<List<? extends PropertyDescriptor>> {
            public C13332b() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ List<? extends PropertyDescriptor> invoke() {
                return invoke2();
            }

            @Override // kotlin.jvm.functions.Function0
            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final List<? extends PropertyDescriptor> invoke2() {
                return _Collections.plus((Collection) b.access$getDeclaredProperties(b.this), (Iterable) b.access$computeAllNonDeclaredProperties(b.this));
            }
        }

        /* JADX INFO: renamed from: d0.e0.p.d.m0.l.b.e0.h$b$c */
        /* JADX INFO: compiled from: DeserializedMemberScope.kt */
        public static final class c extends Lambda implements Function0<List<? extends TypeAliasDescriptor>> {
            public c() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ List<? extends TypeAliasDescriptor> invoke() {
                return invoke2();
            }

            @Override // kotlin.jvm.functions.Function0
            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final List<? extends TypeAliasDescriptor> invoke2() {
                return b.access$computeTypeAliases(b.this);
            }
        }

        /* JADX INFO: renamed from: d0.e0.p.d.m0.l.b.e0.h$b$d */
        /* JADX INFO: compiled from: DeserializedMemberScope.kt */
        public static final class d extends Lambda implements Function0<List<? extends SimpleFunctionDescriptor>> {
            public d() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ List<? extends SimpleFunctionDescriptor> invoke() {
                return invoke2();
            }

            @Override // kotlin.jvm.functions.Function0
            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final List<? extends SimpleFunctionDescriptor> invoke2() {
                return b.access$computeFunctions(b.this);
            }
        }

        /* JADX INFO: renamed from: d0.e0.p.d.m0.l.b.e0.h$b$e */
        /* JADX INFO: compiled from: DeserializedMemberScope.kt */
        public static final class e extends Lambda implements Function0<List<? extends PropertyDescriptor>> {
            public e() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ List<? extends PropertyDescriptor> invoke() {
                return invoke2();
            }

            @Override // kotlin.jvm.functions.Function0
            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final List<? extends PropertyDescriptor> invoke2() {
                return b.access$computeProperties(b.this);
            }
        }

        /* JADX INFO: renamed from: d0.e0.p.d.m0.l.b.e0.h$b$f */
        /* JADX INFO: compiled from: DeserializedMemberScope.kt */
        public static final class f extends Lambda implements Function0<Set<? extends Name>> {
            public final /* synthetic */ DeserializedMemberScope this$1;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public f(DeserializedMemberScope deserializedMemberScope) {
                super(0);
                this.this$1 = deserializedMemberScope;
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Set<? extends Name> invoke() {
                return invoke2();
            }

            @Override // kotlin.jvm.functions.Function0
            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final Set<? extends Name> invoke2() {
                b bVar = b.this;
                List listAccess$getFunctionList$p = b.access$getFunctionList$p(bVar);
                LinkedHashSet linkedHashSet = new LinkedHashSet();
                DeserializedMemberScope deserializedMemberScope = bVar.f24586o;
                Iterator it = listAccess$getFunctionList$p.iterator();
                while (it.hasNext()) {
                    linkedHashSet.add(NameResolverUtil.getName(DeserializedMemberScope.access$getC(deserializedMemberScope).getNameResolver(), ((C11684i) ((MessageLite) it.next())).getName()));
                }
                return _Sets.plus((Set) linkedHashSet, (Iterable) this.this$1.mo9960g());
            }
        }

        /* JADX INFO: renamed from: d0.e0.p.d.m0.l.b.e0.h$b$g */
        /* JADX INFO: compiled from: DeserializedMemberScope.kt */
        public static final class g extends Lambda implements Function0<Map<Name, ? extends List<? extends SimpleFunctionDescriptor>>> {
            public g() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Map<Name, ? extends List<? extends SimpleFunctionDescriptor>> invoke() {
                return invoke2();
            }

            @Override // kotlin.jvm.functions.Function0
            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final Map<Name, ? extends List<? extends SimpleFunctionDescriptor>> invoke2() {
                List listAccess$getAllFunctions = b.access$getAllFunctions(b.this);
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                for (Object obj : listAccess$getAllFunctions) {
                    Name name = ((SimpleFunctionDescriptor) obj).getName();
                    Intrinsics3.checkNotNullExpressionValue(name, "it.name");
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

        /* JADX INFO: renamed from: d0.e0.p.d.m0.l.b.e0.h$b$h */
        /* JADX INFO: compiled from: DeserializedMemberScope.kt */
        public static final class h extends Lambda implements Function0<Map<Name, ? extends List<? extends PropertyDescriptor>>> {
            public h() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Map<Name, ? extends List<? extends PropertyDescriptor>> invoke() {
                return invoke2();
            }

            @Override // kotlin.jvm.functions.Function0
            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final Map<Name, ? extends List<? extends PropertyDescriptor>> invoke2() {
                List listAccess$getAllProperties = b.access$getAllProperties(b.this);
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                for (Object obj : listAccess$getAllProperties) {
                    Name name = ((PropertyDescriptor) obj).getName();
                    Intrinsics3.checkNotNullExpressionValue(name, "it.name");
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

        /* JADX INFO: renamed from: d0.e0.p.d.m0.l.b.e0.h$b$i */
        /* JADX INFO: compiled from: DeserializedMemberScope.kt */
        public static final class i extends Lambda implements Function0<Map<Name, ? extends TypeAliasDescriptor>> {
            public i() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Map<Name, ? extends TypeAliasDescriptor> invoke() {
                return invoke2();
            }

            @Override // kotlin.jvm.functions.Function0
            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final Map<Name, ? extends TypeAliasDescriptor> invoke2() {
                List listAccess$getAllTypeAliases = b.access$getAllTypeAliases(b.this);
                LinkedHashMap linkedHashMap = new LinkedHashMap(_Ranges.coerceAtLeast(MapsJVM.mapCapacity(Iterables2.collectionSizeOrDefault(listAccess$getAllTypeAliases, 10)), 16));
                for (Object obj : listAccess$getAllTypeAliases) {
                    Name name = ((TypeAliasDescriptor) obj).getName();
                    Intrinsics3.checkNotNullExpressionValue(name, "it.name");
                    linkedHashMap.put(name, obj);
                }
                return linkedHashMap;
            }
        }

        /* JADX INFO: renamed from: d0.e0.p.d.m0.l.b.e0.h$b$j */
        /* JADX INFO: compiled from: DeserializedMemberScope.kt */
        public static final class j extends Lambda implements Function0<Set<? extends Name>> {
            public final /* synthetic */ DeserializedMemberScope this$1;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public j(DeserializedMemberScope deserializedMemberScope) {
                super(0);
                this.this$1 = deserializedMemberScope;
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Set<? extends Name> invoke() {
                return invoke2();
            }

            @Override // kotlin.jvm.functions.Function0
            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final Set<? extends Name> invoke2() {
                b bVar = b.this;
                List listAccess$getPropertyList$p = b.access$getPropertyList$p(bVar);
                LinkedHashSet linkedHashSet = new LinkedHashSet();
                DeserializedMemberScope deserializedMemberScope = bVar.f24586o;
                Iterator it = listAccess$getPropertyList$p.iterator();
                while (it.hasNext()) {
                    linkedHashSet.add(NameResolverUtil.getName(DeserializedMemberScope.access$getC(deserializedMemberScope).getNameResolver(), ((C11689n) ((MessageLite) it.next())).getName()));
                }
                return _Sets.plus((Set) linkedHashSet, (Iterable) this.this$1.mo9961h());
            }
        }

        public b(DeserializedMemberScope deserializedMemberScope, List<C11684i> list, List<C11689n> list2, List<C11693r> list3) {
            Intrinsics3.checkNotNullParameter(deserializedMemberScope, "this$0");
            Intrinsics3.checkNotNullParameter(list, "functionList");
            Intrinsics3.checkNotNullParameter(list2, "propertyList");
            Intrinsics3.checkNotNullParameter(list3, "typeAliasList");
            this.f24586o = deserializedMemberScope;
            this.f24573b = list;
            this.f24574c = list2;
            this.f24575d = deserializedMemberScope.f24568c.getComponents().getConfiguration().getTypeAliasesAllowed() ? list3 : Collections2.emptyList();
            this.f24576e = deserializedMemberScope.f24568c.getStorageManager().createLazyValue(new d());
            this.f24577f = deserializedMemberScope.f24568c.getStorageManager().createLazyValue(new e());
            this.f24578g = deserializedMemberScope.f24568c.getStorageManager().createLazyValue(new c());
            this.f24579h = deserializedMemberScope.f24568c.getStorageManager().createLazyValue(new a());
            this.f24580i = deserializedMemberScope.f24568c.getStorageManager().createLazyValue(new C13332b());
            this.f24581j = deserializedMemberScope.f24568c.getStorageManager().createLazyValue(new i());
            this.f24582k = deserializedMemberScope.f24568c.getStorageManager().createLazyValue(new g());
            this.f24583l = deserializedMemberScope.f24568c.getStorageManager().createLazyValue(new h());
            this.f24584m = deserializedMemberScope.f24568c.getStorageManager().createLazyValue(new f(deserializedMemberScope));
            this.f24585n = deserializedMemberScope.f24568c.getStorageManager().createLazyValue(new j(deserializedMemberScope));
        }

        public static final List access$computeAllNonDeclaredFunctions(b bVar) {
            Set<Name> setMo9960g = bVar.f24586o.mo9960g();
            ArrayList arrayList = new ArrayList();
            for (Name name : setMo9960g) {
                List list = (List) storage7.getValue(bVar.f24576e, bVar, (KProperty<?>) f24572a[0]);
                DeserializedMemberScope deserializedMemberScope = bVar.f24586o;
                ArrayList arrayList2 = new ArrayList();
                for (Object obj : list) {
                    if (Intrinsics3.areEqual(((DeclarationDescriptor) obj).getName(), name)) {
                        arrayList2.add(obj);
                    }
                }
                int size = arrayList2.size();
                deserializedMemberScope.mo9956c(name, arrayList2);
                MutableCollections.addAll(arrayList, arrayList2.subList(size, arrayList2.size()));
            }
            return arrayList;
        }

        public static final List access$computeAllNonDeclaredProperties(b bVar) {
            Set<Name> setMo9961h = bVar.f24586o.mo9961h();
            ArrayList arrayList = new ArrayList();
            for (Name name : setMo9961h) {
                List list = (List) storage7.getValue(bVar.f24577f, bVar, (KProperty<?>) f24572a[1]);
                DeserializedMemberScope deserializedMemberScope = bVar.f24586o;
                ArrayList arrayList2 = new ArrayList();
                for (Object obj : list) {
                    if (Intrinsics3.areEqual(((DeclarationDescriptor) obj).getName(), name)) {
                        arrayList2.add(obj);
                    }
                }
                int size = arrayList2.size();
                deserializedMemberScope.mo9957d(name, arrayList2);
                MutableCollections.addAll(arrayList, arrayList2.subList(size, arrayList2.size()));
            }
            return arrayList;
        }

        public static final List access$computeFunctions(b bVar) {
            List<C11684i> list = bVar.f24573b;
            DeserializedMemberScope deserializedMemberScope = bVar.f24586o;
            ArrayList arrayList = new ArrayList();
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                SimpleFunctionDescriptor simpleFunctionDescriptorLoadFunction = DeserializedMemberScope.access$getC(deserializedMemberScope).getMemberDeserializer().loadFunction((C11684i) ((MessageLite) it.next()));
                if (!deserializedMemberScope.mo9962j(simpleFunctionDescriptorLoadFunction)) {
                    simpleFunctionDescriptorLoadFunction = null;
                }
                if (simpleFunctionDescriptorLoadFunction != null) {
                    arrayList.add(simpleFunctionDescriptorLoadFunction);
                }
            }
            return arrayList;
        }

        public static final List access$computeProperties(b bVar) {
            List<C11689n> list = bVar.f24574c;
            DeserializedMemberScope deserializedMemberScope = bVar.f24586o;
            ArrayList arrayList = new ArrayList();
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                PropertyDescriptor propertyDescriptorLoadProperty = DeserializedMemberScope.access$getC(deserializedMemberScope).getMemberDeserializer().loadProperty((C11689n) ((MessageLite) it.next()));
                if (propertyDescriptorLoadProperty != null) {
                    arrayList.add(propertyDescriptorLoadProperty);
                }
            }
            return arrayList;
        }

        public static final List access$computeTypeAliases(b bVar) {
            List<C11693r> list = bVar.f24575d;
            DeserializedMemberScope deserializedMemberScope = bVar.f24586o;
            ArrayList arrayList = new ArrayList();
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                TypeAliasDescriptor typeAliasDescriptorLoadTypeAlias = DeserializedMemberScope.access$getC(deserializedMemberScope).getMemberDeserializer().loadTypeAlias((C11693r) ((MessageLite) it.next()));
                if (typeAliasDescriptorLoadTypeAlias != null) {
                    arrayList.add(typeAliasDescriptorLoadTypeAlias);
                }
            }
            return arrayList;
        }

        public static final List access$getAllFunctions(b bVar) {
            return (List) storage7.getValue(bVar.f24579h, bVar, (KProperty<?>) f24572a[3]);
        }

        public static final List access$getAllProperties(b bVar) {
            return (List) storage7.getValue(bVar.f24580i, bVar, (KProperty<?>) f24572a[4]);
        }

        public static final List access$getAllTypeAliases(b bVar) {
            return (List) storage7.getValue(bVar.f24578g, bVar, (KProperty<?>) f24572a[2]);
        }

        public static final List access$getDeclaredFunctions(b bVar) {
            return (List) storage7.getValue(bVar.f24576e, bVar, (KProperty<?>) f24572a[0]);
        }

        public static final List access$getDeclaredProperties(b bVar) {
            return (List) storage7.getValue(bVar.f24577f, bVar, (KProperty<?>) f24572a[1]);
        }

        public static final /* synthetic */ List access$getFunctionList$p(b bVar) {
            return bVar.f24573b;
        }

        public static final /* synthetic */ List access$getPropertyList$p(b bVar) {
            return bVar.f24574c;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b.p565e0.DeserializedMemberScope.a
        public void addFunctionsAndPropertiesTo(Collection<DeclarationDescriptor> collection, MemberScope2 memberScope2, Function1<? super Name, Boolean> function1, LookupLocation2 lookupLocation2) {
            Intrinsics3.checkNotNullParameter(collection, "result");
            Intrinsics3.checkNotNullParameter(memberScope2, "kindFilter");
            Intrinsics3.checkNotNullParameter(function1, "nameFilter");
            Intrinsics3.checkNotNullParameter(lookupLocation2, ModelAuditLogEntry.CHANGE_KEY_LOCATION);
            if (memberScope2.acceptsKinds(MemberScope2.f24339a.getVARIABLES_MASK())) {
                for (Object obj : (List) storage7.getValue(this.f24580i, this, (KProperty<?>) f24572a[4])) {
                    Name name = ((PropertyDescriptor) obj).getName();
                    Intrinsics3.checkNotNullExpressionValue(name, "it.name");
                    if (function1.invoke(name).booleanValue()) {
                        collection.add(obj);
                    }
                }
            }
            if (memberScope2.acceptsKinds(MemberScope2.f24339a.getFUNCTIONS_MASK())) {
                for (Object obj2 : (List) storage7.getValue(this.f24579h, this, (KProperty<?>) f24572a[3])) {
                    Name name2 = ((SimpleFunctionDescriptor) obj2).getName();
                    Intrinsics3.checkNotNullExpressionValue(name2, "it.name");
                    if (function1.invoke(name2).booleanValue()) {
                        collection.add(obj2);
                    }
                }
            }
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b.p565e0.DeserializedMemberScope.a
        public Collection<SimpleFunctionDescriptor> getContributedFunctions(Name name, LookupLocation2 lookupLocation2) {
            Collection<SimpleFunctionDescriptor> collection;
            Intrinsics3.checkNotNullParameter(name, ModelAuditLogEntry.CHANGE_KEY_NAME);
            Intrinsics3.checkNotNullParameter(lookupLocation2, ModelAuditLogEntry.CHANGE_KEY_LOCATION);
            return (getFunctionNames().contains(name) && (collection = (Collection) ((Map) storage7.getValue(this.f24582k, this, (KProperty<?>) f24572a[6])).get(name)) != null) ? collection : Collections2.emptyList();
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b.p565e0.DeserializedMemberScope.a
        public Collection<PropertyDescriptor> getContributedVariables(Name name, LookupLocation2 lookupLocation2) {
            Collection<PropertyDescriptor> collection;
            Intrinsics3.checkNotNullParameter(name, ModelAuditLogEntry.CHANGE_KEY_NAME);
            Intrinsics3.checkNotNullParameter(lookupLocation2, ModelAuditLogEntry.CHANGE_KEY_LOCATION);
            return (getVariableNames().contains(name) && (collection = (Collection) ((Map) storage7.getValue(this.f24583l, this, (KProperty<?>) f24572a[7])).get(name)) != null) ? collection : Collections2.emptyList();
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b.p565e0.DeserializedMemberScope.a
        public Set<Name> getFunctionNames() {
            return (Set) storage7.getValue(this.f24584m, this, (KProperty<?>) f24572a[8]);
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b.p565e0.DeserializedMemberScope.a
        public TypeAliasDescriptor getTypeAliasByName(Name name) {
            Intrinsics3.checkNotNullParameter(name, ModelAuditLogEntry.CHANGE_KEY_NAME);
            return (TypeAliasDescriptor) ((Map) storage7.getValue(this.f24581j, this, (KProperty<?>) f24572a[5])).get(name);
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b.p565e0.DeserializedMemberScope.a
        public Set<Name> getTypeAliasNames() {
            List<C11693r> list = this.f24575d;
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            DeserializedMemberScope deserializedMemberScope = this.f24586o;
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                linkedHashSet.add(NameResolverUtil.getName(DeserializedMemberScope.access$getC(deserializedMemberScope).getNameResolver(), ((C11693r) ((MessageLite) it.next())).getName()));
            }
            return linkedHashSet;
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b.p565e0.DeserializedMemberScope.a
        public Set<Name> getVariableNames() {
            return (Set) storage7.getValue(this.f24585n, this, (KProperty<?>) f24572a[9]);
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.l.b.e0.h$c */
    /* JADX INFO: compiled from: DeserializedMemberScope.kt */
    public final class c implements a {

        /* JADX INFO: renamed from: a */
        public static final /* synthetic */ KProperty<Object>[] f24587a = {Reflection2.property1(new PropertyReference1Impl(Reflection2.getOrCreateKotlinClass(c.class), "functionNames", "getFunctionNames()Ljava/util/Set;")), Reflection2.property1(new PropertyReference1Impl(Reflection2.getOrCreateKotlinClass(c.class), "variableNames", "getVariableNames()Ljava/util/Set;"))};

        /* JADX INFO: renamed from: b */
        public final Map<Name, byte[]> f24588b;

        /* JADX INFO: renamed from: c */
        public final Map<Name, byte[]> f24589c;

        /* JADX INFO: renamed from: d */
        public final Map<Name, byte[]> f24590d;

        /* JADX INFO: renamed from: e */
        public final storage3<Name, Collection<SimpleFunctionDescriptor>> f24591e;

        /* JADX INFO: renamed from: f */
        public final storage3<Name, Collection<PropertyDescriptor>> f24592f;

        /* JADX INFO: renamed from: g */
        public final storage4<Name, TypeAliasDescriptor> f24593g;

        /* JADX INFO: renamed from: h */
        public final storage5 f24594h;

        /* JADX INFO: renamed from: i */
        public final storage5 f24595i;

        /* JADX INFO: renamed from: j */
        public final /* synthetic */ DeserializedMemberScope f24596j;

        /* JADX INFO: Add missing generic type declarations: [M] */
        /* JADX INFO: renamed from: d0.e0.p.d.m0.l.b.e0.h$c$a */
        /* JADX INFO: compiled from: DeserializedMemberScope.kt */
        public static final class a<M> extends Lambda implements Function0<M> {
            public final /* synthetic */ ByteArrayInputStream $inputStream;
            public final /* synthetic */ Parser2<M> $parser;
            public final /* synthetic */ DeserializedMemberScope this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(Parser2<M> parser2, ByteArrayInputStream byteArrayInputStream, DeserializedMemberScope deserializedMemberScope) {
                super(0);
                this.$parser = parser2;
                this.$inputStream = byteArrayInputStream;
                this.this$0 = deserializedMemberScope;
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Object invoke() {
                return invoke();
            }

            /* JADX WARN: Incorrect return type in method signature: ()TM; */
            @Override // kotlin.jvm.functions.Function0
            public final MessageLite invoke() {
                return (MessageLite) ((AbstractParser) this.$parser).m11466parseDelimitedFrom((InputStream) this.$inputStream, this.this$0.f24568c.getComponents().getExtensionRegistryLite());
            }
        }

        /* JADX INFO: renamed from: d0.e0.p.d.m0.l.b.e0.h$c$b */
        /* JADX INFO: compiled from: DeserializedMemberScope.kt */
        public static final class b extends Lambda implements Function0<Set<? extends Name>> {
            public final /* synthetic */ DeserializedMemberScope this$1;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public b(DeserializedMemberScope deserializedMemberScope) {
                super(0);
                this.this$1 = deserializedMemberScope;
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Set<? extends Name> invoke() {
                return invoke2();
            }

            @Override // kotlin.jvm.functions.Function0
            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final Set<? extends Name> invoke2() {
                return _Sets.plus(c.access$getFunctionProtosBytes$p(c.this).keySet(), (Iterable) this.this$1.mo9960g());
            }
        }

        /* JADX INFO: renamed from: d0.e0.p.d.m0.l.b.e0.h$c$c, reason: collision with other inner class name */
        /* JADX INFO: compiled from: DeserializedMemberScope.kt */
        public static final class C13333c extends Lambda implements Function1<Name, Collection<? extends SimpleFunctionDescriptor>> {
            public C13333c() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Collection<? extends SimpleFunctionDescriptor> invoke(Name name) {
                return invoke2(name);
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final Collection<SimpleFunctionDescriptor> invoke2(Name name) {
                Intrinsics3.checkNotNullParameter(name, "it");
                return c.access$computeFunctions(c.this, name);
            }
        }

        /* JADX INFO: renamed from: d0.e0.p.d.m0.l.b.e0.h$c$d */
        /* JADX INFO: compiled from: DeserializedMemberScope.kt */
        public static final class d extends Lambda implements Function1<Name, Collection<? extends PropertyDescriptor>> {
            public d() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Collection<? extends PropertyDescriptor> invoke(Name name) {
                return invoke2(name);
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final Collection<PropertyDescriptor> invoke2(Name name) {
                Intrinsics3.checkNotNullParameter(name, "it");
                return c.access$computeProperties(c.this, name);
            }
        }

        /* JADX INFO: renamed from: d0.e0.p.d.m0.l.b.e0.h$c$e */
        /* JADX INFO: compiled from: DeserializedMemberScope.kt */
        public static final class e extends Lambda implements Function1<Name, TypeAliasDescriptor> {
            public e() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ TypeAliasDescriptor invoke(Name name) {
                return invoke2(name);
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final TypeAliasDescriptor invoke2(Name name) {
                Intrinsics3.checkNotNullParameter(name, "it");
                return c.access$createTypeAlias(c.this, name);
            }
        }

        /* JADX INFO: renamed from: d0.e0.p.d.m0.l.b.e0.h$c$f */
        /* JADX INFO: compiled from: DeserializedMemberScope.kt */
        public static final class f extends Lambda implements Function0<Set<? extends Name>> {
            public final /* synthetic */ DeserializedMemberScope this$1;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public f(DeserializedMemberScope deserializedMemberScope) {
                super(0);
                this.this$1 = deserializedMemberScope;
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Set<? extends Name> invoke() {
                return invoke2();
            }

            @Override // kotlin.jvm.functions.Function0
            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final Set<? extends Name> invoke2() {
                return _Sets.plus(c.access$getPropertyProtosBytes$p(c.this).keySet(), (Iterable) this.this$1.mo9961h());
            }
        }

        public c(DeserializedMemberScope deserializedMemberScope, List<C11684i> list, List<C11689n> list2, List<C11693r> list3) throws IOException {
            Map<Name, byte[]> mapEmptyMap;
            Intrinsics3.checkNotNullParameter(deserializedMemberScope, "this$0");
            Intrinsics3.checkNotNullParameter(list, "functionList");
            Intrinsics3.checkNotNullParameter(list2, "propertyList");
            Intrinsics3.checkNotNullParameter(list3, "typeAliasList");
            this.f24596j = deserializedMemberScope;
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (Object obj : list) {
                Name name = NameResolverUtil.getName(DeserializedMemberScope.access$getC(deserializedMemberScope).getNameResolver(), ((C11684i) ((MessageLite) obj)).getName());
                Object arrayList = linkedHashMap.get(name);
                if (arrayList == null) {
                    arrayList = new ArrayList();
                    linkedHashMap.put(name, arrayList);
                }
                ((List) arrayList).add(obj);
            }
            this.f24588b = m9966a(linkedHashMap);
            DeserializedMemberScope deserializedMemberScope2 = this.f24596j;
            LinkedHashMap linkedHashMap2 = new LinkedHashMap();
            for (Object obj2 : list2) {
                Name name2 = NameResolverUtil.getName(DeserializedMemberScope.access$getC(deserializedMemberScope2).getNameResolver(), ((C11689n) ((MessageLite) obj2)).getName());
                Object arrayList2 = linkedHashMap2.get(name2);
                if (arrayList2 == null) {
                    arrayList2 = new ArrayList();
                    linkedHashMap2.put(name2, arrayList2);
                }
                ((List) arrayList2).add(obj2);
            }
            this.f24589c = m9966a(linkedHashMap2);
            if (this.f24596j.f24568c.getComponents().getConfiguration().getTypeAliasesAllowed()) {
                DeserializedMemberScope deserializedMemberScope3 = this.f24596j;
                LinkedHashMap linkedHashMap3 = new LinkedHashMap();
                for (Object obj3 : list3) {
                    Name name3 = NameResolverUtil.getName(DeserializedMemberScope.access$getC(deserializedMemberScope3).getNameResolver(), ((C11693r) ((MessageLite) obj3)).getName());
                    Object arrayList3 = linkedHashMap3.get(name3);
                    if (arrayList3 == null) {
                        arrayList3 = new ArrayList();
                        linkedHashMap3.put(name3, arrayList3);
                    }
                    ((List) arrayList3).add(obj3);
                }
                mapEmptyMap = m9966a(linkedHashMap3);
            } else {
                mapEmptyMap = Maps6.emptyMap();
            }
            this.f24590d = mapEmptyMap;
            this.f24591e = this.f24596j.f24568c.getStorageManager().createMemoizedFunction(new C13333c());
            this.f24592f = this.f24596j.f24568c.getStorageManager().createMemoizedFunction(new d());
            this.f24593g = this.f24596j.f24568c.getStorageManager().createMemoizedFunctionWithNullableValues(new e());
            this.f24594h = this.f24596j.f24568c.getStorageManager().createLazyValue(new b(this.f24596j));
            this.f24595i = this.f24596j.f24568c.getStorageManager().createLazyValue(new f(this.f24596j));
        }

        public static final Collection access$computeFunctions(c cVar, Name name) {
            Map<Name, byte[]> map = cVar.f24588b;
            Parser2<C11684i> parser2 = C11684i.f23831k;
            Intrinsics3.checkNotNullExpressionValue(parser2, "PARSER");
            DeserializedMemberScope deserializedMemberScope = cVar.f24596j;
            byte[] bArr = map.get(name);
            List<C11684i> list = bArr == null ? null : _Sequences2.toList(C12075n.generateSequence(new a(parser2, new ByteArrayInputStream(bArr), cVar.f24596j)));
            if (list == null) {
                list = Collections2.emptyList();
            }
            ArrayList arrayList = new ArrayList(list.size());
            for (C11684i c11684i : list) {
                MemberDeserializer memberDeserializer = deserializedMemberScope.f24568c.getMemberDeserializer();
                Intrinsics3.checkNotNullExpressionValue(c11684i, "it");
                SimpleFunctionDescriptor simpleFunctionDescriptorLoadFunction = memberDeserializer.loadFunction(c11684i);
                if (!deserializedMemberScope.mo9962j(simpleFunctionDescriptorLoadFunction)) {
                    simpleFunctionDescriptorLoadFunction = null;
                }
                if (simpleFunctionDescriptorLoadFunction != null) {
                    arrayList.add(simpleFunctionDescriptorLoadFunction);
                }
            }
            deserializedMemberScope.mo9956c(name, arrayList);
            return collections.compact(arrayList);
        }

        public static final Collection access$computeProperties(c cVar, Name name) {
            Map<Name, byte[]> map = cVar.f24589c;
            Parser2<C11689n> parser2 = C11689n.f23871k;
            Intrinsics3.checkNotNullExpressionValue(parser2, "PARSER");
            DeserializedMemberScope deserializedMemberScope = cVar.f24596j;
            byte[] bArr = map.get(name);
            List<C11689n> list = bArr == null ? null : _Sequences2.toList(C12075n.generateSequence(new a(parser2, new ByteArrayInputStream(bArr), cVar.f24596j)));
            if (list == null) {
                list = Collections2.emptyList();
            }
            ArrayList arrayList = new ArrayList(list.size());
            for (C11689n c11689n : list) {
                MemberDeserializer memberDeserializer = deserializedMemberScope.f24568c.getMemberDeserializer();
                Intrinsics3.checkNotNullExpressionValue(c11689n, "it");
                PropertyDescriptor propertyDescriptorLoadProperty = memberDeserializer.loadProperty(c11689n);
                if (propertyDescriptorLoadProperty != null) {
                    arrayList.add(propertyDescriptorLoadProperty);
                }
            }
            deserializedMemberScope.mo9957d(name, arrayList);
            return collections.compact(arrayList);
        }

        public static final TypeAliasDescriptor access$createTypeAlias(c cVar, Name name) {
            C11693r delimitedFrom;
            byte[] bArr = cVar.f24590d.get(name);
            if (bArr == null || (delimitedFrom = C11693r.parseDelimitedFrom(new ByteArrayInputStream(bArr), cVar.f24596j.f24568c.getComponents().getExtensionRegistryLite())) == null) {
                return null;
            }
            return cVar.f24596j.f24568c.getMemberDeserializer().loadTypeAlias(delimitedFrom);
        }

        public static final /* synthetic */ Map access$getFunctionProtosBytes$p(c cVar) {
            return cVar.f24588b;
        }

        public static final /* synthetic */ Map access$getPropertyProtosBytes$p(c cVar) {
            return cVar.f24589c;
        }

        /* JADX INFO: renamed from: a */
        public final Map<Name, byte[]> m9966a(Map<Name, ? extends Collection<? extends AbstractMessageLite>> map) throws IOException {
            LinkedHashMap linkedHashMap = new LinkedHashMap(MapsJVM.mapCapacity(map.size()));
            Iterator<T> it = map.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry entry = (Map.Entry) it.next();
                Object key = entry.getKey();
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                Iterable iterable = (Iterable) entry.getValue();
                ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(iterable, 10));
                Iterator it2 = iterable.iterator();
                while (it2.hasNext()) {
                    ((AbstractMessageLite) it2.next()).writeDelimitedTo(byteArrayOutputStream);
                    arrayList.add(Unit.f27425a);
                }
                linkedHashMap.put(key, byteArrayOutputStream.toByteArray());
            }
            return linkedHashMap;
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b.p565e0.DeserializedMemberScope.a
        public void addFunctionsAndPropertiesTo(Collection<DeclarationDescriptor> collection, MemberScope2 memberScope2, Function1<? super Name, Boolean> function1, LookupLocation2 lookupLocation2) {
            Intrinsics3.checkNotNullParameter(collection, "result");
            Intrinsics3.checkNotNullParameter(memberScope2, "kindFilter");
            Intrinsics3.checkNotNullParameter(function1, "nameFilter");
            Intrinsics3.checkNotNullParameter(lookupLocation2, ModelAuditLogEntry.CHANGE_KEY_LOCATION);
            if (memberScope2.acceptsKinds(MemberScope2.f24339a.getVARIABLES_MASK())) {
                Set<Name> variableNames = getVariableNames();
                ArrayList arrayList = new ArrayList();
                for (Name name : variableNames) {
                    if (function1.invoke(name).booleanValue()) {
                        arrayList.addAll(getContributedVariables(name, lookupLocation2));
                    }
                }
                MemberComparator memberComparator = MemberComparator.f24409j;
                Intrinsics3.checkNotNullExpressionValue(memberComparator, "INSTANCE");
                MutableCollectionsJVM.sortWith(arrayList, memberComparator);
                collection.addAll(arrayList);
            }
            if (memberScope2.acceptsKinds(MemberScope2.f24339a.getFUNCTIONS_MASK())) {
                Set<Name> functionNames = getFunctionNames();
                ArrayList arrayList2 = new ArrayList();
                for (Name name2 : functionNames) {
                    if (function1.invoke(name2).booleanValue()) {
                        arrayList2.addAll(getContributedFunctions(name2, lookupLocation2));
                    }
                }
                MemberComparator memberComparator2 = MemberComparator.f24409j;
                Intrinsics3.checkNotNullExpressionValue(memberComparator2, "INSTANCE");
                MutableCollectionsJVM.sortWith(arrayList2, memberComparator2);
                collection.addAll(arrayList2);
            }
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b.p565e0.DeserializedMemberScope.a
        public Collection<SimpleFunctionDescriptor> getContributedFunctions(Name name, LookupLocation2 lookupLocation2) {
            Intrinsics3.checkNotNullParameter(name, ModelAuditLogEntry.CHANGE_KEY_NAME);
            Intrinsics3.checkNotNullParameter(lookupLocation2, ModelAuditLogEntry.CHANGE_KEY_LOCATION);
            return !getFunctionNames().contains(name) ? Collections2.emptyList() : (Collection) ((LockBasedStorageManager.m) this.f24591e).invoke(name);
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b.p565e0.DeserializedMemberScope.a
        public Collection<PropertyDescriptor> getContributedVariables(Name name, LookupLocation2 lookupLocation2) {
            Intrinsics3.checkNotNullParameter(name, ModelAuditLogEntry.CHANGE_KEY_NAME);
            Intrinsics3.checkNotNullParameter(lookupLocation2, ModelAuditLogEntry.CHANGE_KEY_LOCATION);
            return !getVariableNames().contains(name) ? Collections2.emptyList() : (Collection) ((LockBasedStorageManager.m) this.f24592f).invoke(name);
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b.p565e0.DeserializedMemberScope.a
        public Set<Name> getFunctionNames() {
            return (Set) storage7.getValue(this.f24594h, this, (KProperty<?>) f24587a[0]);
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b.p565e0.DeserializedMemberScope.a
        public TypeAliasDescriptor getTypeAliasByName(Name name) {
            Intrinsics3.checkNotNullParameter(name, ModelAuditLogEntry.CHANGE_KEY_NAME);
            return this.f24593g.invoke(name);
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b.p565e0.DeserializedMemberScope.a
        public Set<Name> getTypeAliasNames() {
            return this.f24590d.keySet();
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b.p565e0.DeserializedMemberScope.a
        public Set<Name> getVariableNames() {
            return (Set) storage7.getValue(this.f24595i, this, (KProperty<?>) f24587a[1]);
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.l.b.e0.h$d */
    /* JADX INFO: compiled from: DeserializedMemberScope.kt */
    public static final class d extends Lambda implements Function0<Set<? extends Name>> {
        public final /* synthetic */ Function0<Collection<Name>> $classNames;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public d(Function0<? extends Collection<Name>> function0) {
            super(0);
            this.$classNames = function0;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Set<? extends Name> invoke() {
            return invoke2();
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Set<? extends Name> invoke2() {
            return _Collections.toSet(this.$classNames.invoke());
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.l.b.e0.h$e */
    /* JADX INFO: compiled from: DeserializedMemberScope.kt */
    public static final class e extends Lambda implements Function0<Set<? extends Name>> {
        public e() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Set<? extends Name> invoke() {
            return invoke2();
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Set<? extends Name> invoke2() {
            Set<Name> setMo9959f = DeserializedMemberScope.this.mo9959f();
            if (setMo9959f == null) {
                return null;
            }
            return _Sets.plus(_Sets.plus((Set) DeserializedMemberScope.this.getClassNames$deserialization(), (Iterable) DeserializedMemberScope.access$getImpl$p(DeserializedMemberScope.this).getTypeAliasNames()), (Iterable) setMo9959f);
        }
    }

    public DeserializedMemberScope(context6 context6Var, List<C11684i> list, List<C11689n> list2, List<C11693r> list3, Function0<? extends Collection<Name>> function0) {
        Intrinsics3.checkNotNullParameter(context6Var, "c");
        Intrinsics3.checkNotNullParameter(list, "functionList");
        Intrinsics3.checkNotNullParameter(list2, "propertyList");
        Intrinsics3.checkNotNullParameter(list3, "typeAliasList");
        Intrinsics3.checkNotNullParameter(function0, "classNames");
        this.f24568c = context6Var;
        this.f24569d = context6Var.getComponents().getConfiguration().getPreserveDeclarationsOrdering() ? new b(this, list, list2, list3) : new c(this, list, list2, list3);
        this.f24570e = context6Var.getStorageManager().createLazyValue(new d(function0));
        this.f24571f = context6Var.getStorageManager().createNullableLazyValue(new e());
    }

    public static final /* synthetic */ context6 access$getC(DeserializedMemberScope deserializedMemberScope) {
        return deserializedMemberScope.f24568c;
    }

    public static final /* synthetic */ a access$getImpl$p(DeserializedMemberScope deserializedMemberScope) {
        return deserializedMemberScope.f24569d;
    }

    /* JADX INFO: renamed from: a */
    public abstract void mo9955a(Collection<DeclarationDescriptor> collection, Function1<? super Name, Boolean> function1);

    /* JADX INFO: renamed from: b */
    public final Collection<DeclarationDescriptor> m9964b(MemberScope2 memberScope2, Function1<? super Name, Boolean> function1, LookupLocation2 lookupLocation2) {
        Intrinsics3.checkNotNullParameter(memberScope2, "kindFilter");
        Intrinsics3.checkNotNullParameter(function1, "nameFilter");
        Intrinsics3.checkNotNullParameter(lookupLocation2, ModelAuditLogEntry.CHANGE_KEY_LOCATION);
        ArrayList arrayList = new ArrayList(0);
        MemberScope2.a aVar = MemberScope2.f24339a;
        if (memberScope2.acceptsKinds(aVar.getSINGLETON_CLASSIFIERS_MASK())) {
            mo9955a(arrayList, function1);
        }
        this.f24569d.addFunctionsAndPropertiesTo(arrayList, memberScope2, function1, lookupLocation2);
        if (memberScope2.acceptsKinds(aVar.getCLASSIFIERS_MASK())) {
            for (Name name : getClassNames$deserialization()) {
                if (function1.invoke(name).booleanValue()) {
                    collections.addIfNotNull(arrayList, this.f24568c.getComponents().deserializeClass(mo9958e(name)));
                }
            }
        }
        if (memberScope2.acceptsKinds(MemberScope2.f24339a.getTYPE_ALIASES_MASK())) {
            for (Name name2 : this.f24569d.getTypeAliasNames()) {
                if (function1.invoke(name2).booleanValue()) {
                    collections.addIfNotNull(arrayList, this.f24569d.getTypeAliasByName(name2));
                }
            }
        }
        return collections.compact(arrayList);
    }

    /* JADX INFO: renamed from: c */
    public void mo9956c(Name name, List<SimpleFunctionDescriptor> list) {
        Intrinsics3.checkNotNullParameter(name, ModelAuditLogEntry.CHANGE_KEY_NAME);
        Intrinsics3.checkNotNullParameter(list, "functions");
    }

    /* JADX INFO: renamed from: d */
    public void mo9957d(Name name, List<PropertyDescriptor> list) {
        Intrinsics3.checkNotNullParameter(name, ModelAuditLogEntry.CHANGE_KEY_NAME);
        Intrinsics3.checkNotNullParameter(list, "descriptors");
    }

    /* JADX INFO: renamed from: e */
    public abstract ClassId mo9958e(Name name);

    /* JADX INFO: renamed from: f */
    public abstract Set<Name> mo9959f();

    /* JADX INFO: renamed from: g */
    public abstract Set<Name> mo9960g();

    public final Set<Name> getClassNames$deserialization() {
        return (Set) storage7.getValue(this.f24570e, this, (KProperty<?>) f24567b[0]);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.MemberScopeImpl, p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.MemberScope3
    public Set<Name> getClassifierNames() {
        return (Set) storage7.getValue(this.f24571f, this, (KProperty<?>) f24567b[1]);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.MemberScopeImpl, p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.ResolutionScope
    public ClassifierDescriptor getContributedClassifier(Name name, LookupLocation2 lookupLocation2) {
        Intrinsics3.checkNotNullParameter(name, ModelAuditLogEntry.CHANGE_KEY_NAME);
        Intrinsics3.checkNotNullParameter(lookupLocation2, ModelAuditLogEntry.CHANGE_KEY_LOCATION);
        if (mo9965i(name)) {
            return this.f24568c.getComponents().deserializeClass(mo9958e(name));
        }
        if (this.f24569d.getTypeAliasNames().contains(name)) {
            return this.f24569d.getTypeAliasByName(name);
        }
        return null;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.MemberScopeImpl, p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.MemberScope3
    public Collection<SimpleFunctionDescriptor> getContributedFunctions(Name name, LookupLocation2 lookupLocation2) {
        Intrinsics3.checkNotNullParameter(name, ModelAuditLogEntry.CHANGE_KEY_NAME);
        Intrinsics3.checkNotNullParameter(lookupLocation2, ModelAuditLogEntry.CHANGE_KEY_LOCATION);
        return this.f24569d.getContributedFunctions(name, lookupLocation2);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.MemberScopeImpl, p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.MemberScope3
    public Collection<PropertyDescriptor> getContributedVariables(Name name, LookupLocation2 lookupLocation2) {
        Intrinsics3.checkNotNullParameter(name, ModelAuditLogEntry.CHANGE_KEY_NAME);
        Intrinsics3.checkNotNullParameter(lookupLocation2, ModelAuditLogEntry.CHANGE_KEY_LOCATION);
        return this.f24569d.getContributedVariables(name, lookupLocation2);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.MemberScopeImpl, p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.MemberScope3
    public Set<Name> getFunctionNames() {
        return this.f24569d.getFunctionNames();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.MemberScopeImpl, p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.MemberScope3
    public Set<Name> getVariableNames() {
        return this.f24569d.getVariableNames();
    }

    /* JADX INFO: renamed from: h */
    public abstract Set<Name> mo9961h();

    /* JADX INFO: renamed from: i */
    public boolean mo9965i(Name name) {
        Intrinsics3.checkNotNullParameter(name, ModelAuditLogEntry.CHANGE_KEY_NAME);
        return getClassNames$deserialization().contains(name);
    }

    /* JADX INFO: renamed from: j */
    public boolean mo9962j(SimpleFunctionDescriptor simpleFunctionDescriptor) {
        Intrinsics3.checkNotNullParameter(simpleFunctionDescriptor, "function");
        return true;
    }
}

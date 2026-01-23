package p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p535i0.p536l;

import com.discord.models.domain.ModelAuditLogEntry;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import kotlin.Tuples2;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import p007b.p100d.p104b.p105a.outline;
import p507d0.Tuples;
import p507d0.p513e0.p514p.p515d.p517m0.p518b.KotlinBuiltIns;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.DeclarationDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.FunctionDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.Modality;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.PropertyDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.ReceiverParameterDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.SimpleFunctionDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.TypeParameterDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.ValueParameterDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1.AnnotationDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1.Annotations4;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1.DeclarationDescriptorImpl;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1.ValueParameterDescriptorImpl;
import p507d0.p513e0.p514p.p515d.p517m0.p529d.p530b.LookupLocation2;
import p507d0.p513e0.p514p.p515d.p517m0.p529d.p530b.LookupLocation3;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.JvmAnnotationNames;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p533g0.JavaResolverCache;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p533g0.SignaturePropagator;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p533g0.TypeUsage;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p534h0.JavaMethodDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p534h0.JavaPropertyDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p535i0.LazyJavaAnnotations2;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p535i0.context;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p535i0.context4;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p535i0.p537m.JavaTypeResolver;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p535i0.p537m.JavaTypeResolver5;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.InterfaceC11565a0;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.InterfaceC11581n;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.InterfaceC11585r;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.InterfaceC11592y;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.javaTypes2;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.javaTypes5;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.utils2;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p541b.methodSignatureMapping3;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.FqName;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.Name;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.DescriptorFactory;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.DescriptorUtils;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.overridingUtils;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.MemberScope;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.MemberScope2;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.MemberScope3;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.MemberScopeImpl;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p557v.AbstractC11815g;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p557v.C11831w;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p559x.DescriptorUtils2;
import p507d0.p513e0.p514p.p515d.p517m0.p566m.LockBasedStorageManager;
import p507d0.p513e0.p514p.p515d.p517m0.p566m.storage3;
import p507d0.p513e0.p514p.p515d.p517m0.p566m.storage4;
import p507d0.p513e0.p514p.p515d.p517m0.p566m.storage5;
import p507d0.p513e0.p514p.p515d.p517m0.p566m.storage7;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.TypeUtils;
import p507d0.p513e0.p514p.p515d.p517m0.p576p.collections;
import p507d0.p580t.Collections2;
import p507d0.p580t.IndexedValue;
import p507d0.p580t.Iterables2;
import p507d0.p580t.Maps6;
import p507d0.p580t.MapsJVM;
import p507d0.p580t._Collections;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;
import p507d0.p592z.p594d.PropertyReference1Impl;
import p507d0.p592z.p594d.Reflection2;

/* JADX INFO: renamed from: d0.e0.p.d.m0.e.a.i0.l.k, reason: use source file name */
/* JADX INFO: compiled from: LazyJavaScope.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class LazyJavaScope extends MemberScopeImpl {

    /* JADX INFO: renamed from: b */
    public static final /* synthetic */ KProperty<Object>[] f23388b = {Reflection2.property1(new PropertyReference1Impl(Reflection2.getOrCreateKotlinClass(LazyJavaScope.class), "functionNamesLazy", "getFunctionNamesLazy()Ljava/util/Set;")), Reflection2.property1(new PropertyReference1Impl(Reflection2.getOrCreateKotlinClass(LazyJavaScope.class), "propertyNamesLazy", "getPropertyNamesLazy()Ljava/util/Set;")), Reflection2.property1(new PropertyReference1Impl(Reflection2.getOrCreateKotlinClass(LazyJavaScope.class), "classNamesLazy", "getClassNamesLazy()Ljava/util/Set;"))};

    /* JADX INFO: renamed from: c */
    public final context4 f23389c;

    /* JADX INFO: renamed from: d */
    public final LazyJavaScope f23390d;

    /* JADX INFO: renamed from: e */
    public final storage5<Collection<DeclarationDescriptor>> f23391e;

    /* JADX INFO: renamed from: f */
    public final storage5<DeclaredMemberIndex2> f23392f;

    /* JADX INFO: renamed from: g */
    public final storage3<Name, Collection<SimpleFunctionDescriptor>> f23393g;

    /* JADX INFO: renamed from: h */
    public final storage4<Name, PropertyDescriptor> f23394h;

    /* JADX INFO: renamed from: i */
    public final storage3<Name, Collection<SimpleFunctionDescriptor>> f23395i;

    /* JADX INFO: renamed from: j */
    public final storage5 f23396j;

    /* JADX INFO: renamed from: k */
    public final storage5 f23397k;

    /* JADX INFO: renamed from: l */
    public final storage5 f23398l;

    /* JADX INFO: renamed from: m */
    public final storage3<Name, List<PropertyDescriptor>> f23399m;

    /* JADX INFO: renamed from: d0.e0.p.d.m0.e.a.i0.l.k$a */
    /* JADX INFO: compiled from: LazyJavaScope.kt */
    public static final class a {

        /* JADX INFO: renamed from: a */
        public final KotlinType f23400a;

        /* JADX INFO: renamed from: b */
        public final KotlinType f23401b;

        /* JADX INFO: renamed from: c */
        public final List<ValueParameterDescriptor> f23402c;

        /* JADX INFO: renamed from: d */
        public final List<TypeParameterDescriptor> f23403d;

        /* JADX INFO: renamed from: e */
        public final boolean f23404e;

        /* JADX INFO: renamed from: f */
        public final List<String> f23405f;

        /* JADX WARN: Multi-variable type inference failed */
        public a(KotlinType kotlinType, KotlinType kotlinType2, List<? extends ValueParameterDescriptor> list, List<? extends TypeParameterDescriptor> list2, boolean z2, List<String> list3) {
            Intrinsics3.checkNotNullParameter(kotlinType, "returnType");
            Intrinsics3.checkNotNullParameter(list, "valueParameters");
            Intrinsics3.checkNotNullParameter(list2, "typeParameters");
            Intrinsics3.checkNotNullParameter(list3, "errors");
            this.f23400a = kotlinType;
            this.f23401b = kotlinType2;
            this.f23402c = list;
            this.f23403d = list2;
            this.f23404e = z2;
            this.f23405f = list3;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return Intrinsics3.areEqual(this.f23400a, aVar.f23400a) && Intrinsics3.areEqual(this.f23401b, aVar.f23401b) && Intrinsics3.areEqual(this.f23402c, aVar.f23402c) && Intrinsics3.areEqual(this.f23403d, aVar.f23403d) && this.f23404e == aVar.f23404e && Intrinsics3.areEqual(this.f23405f, aVar.f23405f);
        }

        public final List<String> getErrors() {
            return this.f23405f;
        }

        public final boolean getHasStableParameterNames() {
            return this.f23404e;
        }

        public final KotlinType getReceiverType() {
            return this.f23401b;
        }

        public final KotlinType getReturnType() {
            return this.f23400a;
        }

        public final List<TypeParameterDescriptor> getTypeParameters() {
            return this.f23403d;
        }

        public final List<ValueParameterDescriptor> getValueParameters() {
            return this.f23402c;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r1v12 */
        /* JADX WARN: Type inference failed for: r1v14 */
        /* JADX WARN: Type inference failed for: r1v8, types: [int] */
        public int hashCode() {
            int iHashCode = this.f23400a.hashCode() * 31;
            KotlinType kotlinType = this.f23401b;
            int iHashCode2 = (this.f23403d.hashCode() + ((this.f23402c.hashCode() + ((iHashCode + (kotlinType == null ? 0 : kotlinType.hashCode())) * 31)) * 31)) * 31;
            boolean z2 = this.f23404e;
            ?? r1 = z2;
            if (z2) {
                r1 = 1;
            }
            return this.f23405f.hashCode() + ((iHashCode2 + r1) * 31);
        }

        public String toString() {
            StringBuilder sbM833U = outline.m833U("MethodSignatureData(returnType=");
            sbM833U.append(this.f23400a);
            sbM833U.append(", receiverType=");
            sbM833U.append(this.f23401b);
            sbM833U.append(", valueParameters=");
            sbM833U.append(this.f23402c);
            sbM833U.append(", typeParameters=");
            sbM833U.append(this.f23403d);
            sbM833U.append(", hasStableParameterNames=");
            sbM833U.append(this.f23404e);
            sbM833U.append(", errors=");
            sbM833U.append(this.f23405f);
            sbM833U.append(')');
            return sbM833U.toString();
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.e.a.i0.l.k$b */
    /* JADX INFO: compiled from: LazyJavaScope.kt */
    public static final class b {

        /* JADX INFO: renamed from: a */
        public final List<ValueParameterDescriptor> f23406a;

        /* JADX INFO: renamed from: b */
        public final boolean f23407b;

        /* JADX WARN: Multi-variable type inference failed */
        public b(List<? extends ValueParameterDescriptor> list, boolean z2) {
            Intrinsics3.checkNotNullParameter(list, "descriptors");
            this.f23406a = list;
            this.f23407b = z2;
        }

        public final List<ValueParameterDescriptor> getDescriptors() {
            return this.f23406a;
        }

        public final boolean getHasSynthesizedNames() {
            return this.f23407b;
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.e.a.i0.l.k$c */
    /* JADX INFO: compiled from: LazyJavaScope.kt */
    public static final class c extends Lambda implements Function0<Collection<? extends DeclarationDescriptor>> {
        public c() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Collection<? extends DeclarationDescriptor> invoke() {
            return invoke2();
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Collection<? extends DeclarationDescriptor> invoke2() {
            LazyJavaScope lazyJavaScope = LazyJavaScope.this;
            MemberScope2 memberScope2 = MemberScope2.f24351m;
            Function1<Name, Boolean> all_name_filter = MemberScope3.f24369a.getALL_NAME_FILTER();
            Objects.requireNonNull(lazyJavaScope);
            Intrinsics3.checkNotNullParameter(memberScope2, "kindFilter");
            Intrinsics3.checkNotNullParameter(all_name_filter, "nameFilter");
            LookupLocation3 lookupLocation3 = LookupLocation3.WHEN_GET_ALL_DESCRIPTORS;
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            if (memberScope2.acceptsKinds(MemberScope2.f24339a.getCLASSIFIERS_MASK())) {
                for (Name name : lazyJavaScope.mo9470a(memberScope2, all_name_filter)) {
                    if (all_name_filter.invoke(name).booleanValue()) {
                        collections.addIfNotNull(linkedHashSet, lazyJavaScope.getContributedClassifier(name, lookupLocation3));
                    }
                }
            }
            if (memberScope2.acceptsKinds(MemberScope2.f24339a.getFUNCTIONS_MASK()) && !memberScope2.getExcludes().contains(MemberScope.a.f24336a)) {
                for (Name name2 : lazyJavaScope.mo9471b(memberScope2, all_name_filter)) {
                    if (all_name_filter.invoke(name2).booleanValue()) {
                        linkedHashSet.addAll(lazyJavaScope.getContributedFunctions(name2, lookupLocation3));
                    }
                }
            }
            if (memberScope2.acceptsKinds(MemberScope2.f24339a.getVARIABLES_MASK()) && !memberScope2.getExcludes().contains(MemberScope.a.f24336a)) {
                for (Name name3 : lazyJavaScope.mo9476h(memberScope2, all_name_filter)) {
                    if (all_name_filter.invoke(name3).booleanValue()) {
                        linkedHashSet.addAll(lazyJavaScope.getContributedVariables(name3, lookupLocation3));
                    }
                }
            }
            return _Collections.toList(linkedHashSet);
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.e.a.i0.l.k$d */
    /* JADX INFO: compiled from: LazyJavaScope.kt */
    public static final class d extends Lambda implements Function0<Set<? extends Name>> {
        public d() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Set<? extends Name> invoke() {
            return invoke2();
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Set<? extends Name> invoke2() {
            return LazyJavaScope.this.mo9470a(MemberScope2.f24353o, null);
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.e.a.i0.l.k$e */
    /* JADX INFO: compiled from: LazyJavaScope.kt */
    public static final class e extends Lambda implements Function1<Name, PropertyDescriptor> {
        public e() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ PropertyDescriptor invoke(Name name) {
            return invoke2(name);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final PropertyDescriptor invoke2(Name name) {
            Intrinsics3.checkNotNullParameter(name, ModelAuditLogEntry.CHANGE_KEY_NAME);
            LazyJavaScope lazyJavaScope = LazyJavaScope.this;
            LazyJavaScope lazyJavaScope2 = lazyJavaScope.f23390d;
            if (lazyJavaScope2 != null) {
                return (PropertyDescriptor) LazyJavaScope.access$getDeclaredField$p(lazyJavaScope2).invoke(name);
            }
            InterfaceC11581n interfaceC11581nFindFieldByName = lazyJavaScope.f23392f.invoke().findFieldByName(name);
            if (interfaceC11581nFindFieldByName == null || interfaceC11581nFindFieldByName.isEnumEntry()) {
                return null;
            }
            return LazyJavaScope.access$resolveProperty(LazyJavaScope.this, interfaceC11581nFindFieldByName);
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.e.a.i0.l.k$f */
    /* JADX INFO: compiled from: LazyJavaScope.kt */
    public static final class f extends Lambda implements Function1<Name, Collection<? extends SimpleFunctionDescriptor>> {
        public f() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Collection<? extends SimpleFunctionDescriptor> invoke(Name name) {
            return invoke2(name);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Collection<SimpleFunctionDescriptor> invoke2(Name name) {
            Intrinsics3.checkNotNullParameter(name, ModelAuditLogEntry.CHANGE_KEY_NAME);
            LazyJavaScope lazyJavaScope = LazyJavaScope.this.f23390d;
            if (lazyJavaScope != null) {
                return (Collection) ((LockBasedStorageManager.m) LazyJavaScope.access$getDeclaredFunctions$p(lazyJavaScope)).invoke(name);
            }
            ArrayList arrayList = new ArrayList();
            for (InterfaceC11585r interfaceC11585r : LazyJavaScope.this.f23392f.invoke().findMethodsByName(name)) {
                JavaMethodDescriptor javaMethodDescriptorM9495m = LazyJavaScope.this.m9495m(interfaceC11585r);
                if (LazyJavaScope.this.mo9479k(javaMethodDescriptorM9495m)) {
                    ((JavaResolverCache.a) LazyJavaScope.this.f23389c.getComponents().getJavaResolverCache()).recordMethod(interfaceC11585r, javaMethodDescriptorM9495m);
                    arrayList.add(javaMethodDescriptorM9495m);
                }
            }
            LazyJavaScope.this.mo9472c(arrayList, name);
            return arrayList;
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.e.a.i0.l.k$g */
    /* JADX INFO: compiled from: LazyJavaScope.kt */
    public static final class g extends Lambda implements Function0<DeclaredMemberIndex2> {
        public g() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ DeclaredMemberIndex2 invoke() {
            return invoke();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final DeclaredMemberIndex2 invoke() {
            return LazyJavaScope.this.mo9473d();
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.e.a.i0.l.k$h */
    /* JADX INFO: compiled from: LazyJavaScope.kt */
    public static final class h extends Lambda implements Function0<Set<? extends Name>> {
        public h() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Set<? extends Name> invoke() {
            return invoke2();
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Set<? extends Name> invoke2() {
            return LazyJavaScope.this.mo9471b(MemberScope2.f24354p, null);
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.e.a.i0.l.k$i */
    /* JADX INFO: compiled from: LazyJavaScope.kt */
    public static final class i extends Lambda implements Function1<Name, Collection<? extends SimpleFunctionDescriptor>> {
        public i() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Collection<? extends SimpleFunctionDescriptor> invoke(Name name) {
            return invoke2(name);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Collection<SimpleFunctionDescriptor> invoke2(Name name) {
            Intrinsics3.checkNotNullParameter(name, ModelAuditLogEntry.CHANGE_KEY_NAME);
            LinkedHashSet linkedHashSet = new LinkedHashSet((Collection) ((LockBasedStorageManager.m) LazyJavaScope.access$getDeclaredFunctions$p(LazyJavaScope.this)).invoke(name));
            LazyJavaScope.access$retainMostSpecificMethods(LazyJavaScope.this, linkedHashSet);
            LazyJavaScope.this.mo9474f(linkedHashSet, name);
            return _Collections.toList(LazyJavaScope.this.f23389c.getComponents().getSignatureEnhancement().enhanceSignatures(LazyJavaScope.this.f23389c, linkedHashSet));
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.e.a.i0.l.k$j */
    /* JADX INFO: compiled from: LazyJavaScope.kt */
    public static final class j extends Lambda implements Function1<Name, List<? extends PropertyDescriptor>> {
        public j() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ List<? extends PropertyDescriptor> invoke(Name name) {
            return invoke2(name);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final List<PropertyDescriptor> invoke2(Name name) {
            Intrinsics3.checkNotNullParameter(name, ModelAuditLogEntry.CHANGE_KEY_NAME);
            ArrayList arrayList = new ArrayList();
            collections.addIfNotNull(arrayList, LazyJavaScope.access$getDeclaredField$p(LazyJavaScope.this).invoke(name));
            LazyJavaScope.this.mo9475g(name, arrayList);
            return DescriptorUtils.isAnnotationClass(LazyJavaScope.this.mo9478j()) ? _Collections.toList(arrayList) : _Collections.toList(LazyJavaScope.this.f23389c.getComponents().getSignatureEnhancement().enhanceSignatures(LazyJavaScope.this.f23389c, arrayList));
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.e.a.i0.l.k$k */
    /* JADX INFO: compiled from: LazyJavaScope.kt */
    public static final class k extends Lambda implements Function0<Set<? extends Name>> {
        public k() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Set<? extends Name> invoke() {
            return invoke2();
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Set<? extends Name> invoke2() {
            return LazyJavaScope.this.mo9476h(MemberScope2.f24355q, null);
        }
    }

    public /* synthetic */ LazyJavaScope(context4 context4Var, LazyJavaScope lazyJavaScope, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context4Var, (i2 & 2) != 0 ? null : lazyJavaScope);
    }

    public static final /* synthetic */ storage4 access$getDeclaredField$p(LazyJavaScope lazyJavaScope) {
        return lazyJavaScope.f23394h;
    }

    public static final /* synthetic */ storage3 access$getDeclaredFunctions$p(LazyJavaScope lazyJavaScope) {
        return lazyJavaScope.f23393g;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0086  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final PropertyDescriptor access$resolveProperty(LazyJavaScope lazyJavaScope, InterfaceC11581n interfaceC11581n) {
        boolean z2;
        Objects.requireNonNull(lazyJavaScope);
        JavaPropertyDescriptor javaPropertyDescriptorCreate = JavaPropertyDescriptor.create(lazyJavaScope.mo9478j(), LazyJavaAnnotations2.resolveAnnotations(lazyJavaScope.f23389c, interfaceC11581n), Modality.FINAL, utils2.toDescriptorVisibility(interfaceC11581n.getVisibility()), !interfaceC11581n.isFinal(), interfaceC11581n.getName(), lazyJavaScope.f23389c.getComponents().getSourceElementFactory().source(interfaceC11581n), interfaceC11581n.isFinal() && interfaceC11581n.isStatic());
        Intrinsics3.checkNotNullExpressionValue(javaPropertyDescriptorCreate, "create(\n            ownerDescriptor, annotations, Modality.FINAL, field.visibility.toDescriptorVisibility(), isVar, field.name,\n            c.components.sourceElementFactory.source(field), /* isConst = */ field.isFinalStatic\n        )");
        javaPropertyDescriptorCreate.initialize(null, null, null, null);
        KotlinType kotlinTypeTransformJavaType = lazyJavaScope.f23389c.getTypeResolver().transformJavaType(interfaceC11581n.getType(), JavaTypeResolver5.toAttributes$default(TypeUsage.COMMON, false, null, 3, null));
        if (KotlinBuiltIns.isPrimitiveType(kotlinTypeTransformJavaType) || KotlinBuiltIns.isString(kotlinTypeTransformJavaType)) {
            z2 = (interfaceC11581n.isFinal() && interfaceC11581n.isStatic()) && interfaceC11581n.getHasConstantNotNullInitializer();
        }
        if (z2) {
            kotlinTypeTransformJavaType = TypeUtils.makeNotNullable(kotlinTypeTransformJavaType);
            Intrinsics3.checkNotNullExpressionValue(kotlinTypeTransformJavaType, "makeNotNullable(propertyType)");
        }
        javaPropertyDescriptorCreate.setType(kotlinTypeTransformJavaType, Collections2.emptyList(), lazyJavaScope.mo9477i(), null);
        if (DescriptorUtils.shouldRecordInitializerForProperty(javaPropertyDescriptorCreate, javaPropertyDescriptorCreate.getType())) {
            javaPropertyDescriptorCreate.setCompileTimeInitializer(lazyJavaScope.f23389c.getStorageManager().createNullableLazyValue(new LazyJavaScope2(lazyJavaScope, interfaceC11581n, javaPropertyDescriptorCreate)));
        }
        ((JavaResolverCache.a) lazyJavaScope.f23389c.getComponents().getJavaResolverCache()).recordField(interfaceC11581n, javaPropertyDescriptorCreate);
        return javaPropertyDescriptorCreate;
    }

    public static final void access$retainMostSpecificMethods(LazyJavaScope lazyJavaScope, Set set) {
        Objects.requireNonNull(lazyJavaScope);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Object obj : set) {
            String strComputeJvmDescriptor$default = methodSignatureMapping3.computeJvmDescriptor$default((SimpleFunctionDescriptor) obj, false, false, 2, null);
            Object arrayList = linkedHashMap.get(strComputeJvmDescriptor$default);
            if (arrayList == null) {
                arrayList = new ArrayList();
                linkedHashMap.put(strComputeJvmDescriptor$default, arrayList);
            }
            ((List) arrayList).add(obj);
        }
        for (List list : linkedHashMap.values()) {
            if (list.size() != 1) {
                Collection collectionSelectMostSpecificInEachOverridableGroup = overridingUtils.selectMostSpecificInEachOverridableGroup(list, LazyJavaScope3.f23408j);
                set.removeAll(list);
                set.addAll(collectionSelectMostSpecificInEachOverridableGroup);
            }
        }
    }

    /* JADX INFO: renamed from: a */
    public abstract Set<Name> mo9470a(MemberScope2 memberScope2, Function1<? super Name, Boolean> function1);

    /* JADX INFO: renamed from: b */
    public abstract Set<Name> mo9471b(MemberScope2 memberScope2, Function1<? super Name, Boolean> function1);

    /* JADX INFO: renamed from: c */
    public void mo9472c(Collection<SimpleFunctionDescriptor> collection, Name name) {
        Intrinsics3.checkNotNullParameter(collection, "result");
        Intrinsics3.checkNotNullParameter(name, ModelAuditLogEntry.CHANGE_KEY_NAME);
    }

    /* JADX INFO: renamed from: d */
    public abstract DeclaredMemberIndex2 mo9473d();

    /* JADX INFO: renamed from: e */
    public final KotlinType m9494e(InterfaceC11585r interfaceC11585r, context4 context4Var) {
        Intrinsics3.checkNotNullParameter(interfaceC11585r, "method");
        Intrinsics3.checkNotNullParameter(context4Var, "c");
        return context4Var.getTypeResolver().transformJavaType(interfaceC11585r.getReturnType(), JavaTypeResolver5.toAttributes$default(TypeUsage.COMMON, interfaceC11585r.getContainingClass().isAnnotationType(), null, 2, null));
    }

    /* JADX INFO: renamed from: f */
    public abstract void mo9474f(Collection<SimpleFunctionDescriptor> collection, Name name);

    /* JADX INFO: renamed from: g */
    public abstract void mo9475g(Name name, Collection<PropertyDescriptor> collection);

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.MemberScopeImpl, p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.MemberScope3
    public Set<Name> getClassifierNames() {
        return (Set) storage7.getValue(this.f23398l, this, (KProperty<?>) f23388b[2]);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.MemberScopeImpl, p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.ResolutionScope
    public Collection<DeclarationDescriptor> getContributedDescriptors(MemberScope2 memberScope2, Function1<? super Name, Boolean> function1) {
        Intrinsics3.checkNotNullParameter(memberScope2, "kindFilter");
        Intrinsics3.checkNotNullParameter(function1, "nameFilter");
        return this.f23391e.invoke();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.MemberScopeImpl, p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.MemberScope3
    public Collection<SimpleFunctionDescriptor> getContributedFunctions(Name name, LookupLocation2 lookupLocation2) {
        Intrinsics3.checkNotNullParameter(name, ModelAuditLogEntry.CHANGE_KEY_NAME);
        Intrinsics3.checkNotNullParameter(lookupLocation2, ModelAuditLogEntry.CHANGE_KEY_LOCATION);
        return !getFunctionNames().contains(name) ? Collections2.emptyList() : (Collection) ((LockBasedStorageManager.m) this.f23395i).invoke(name);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.MemberScopeImpl, p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.MemberScope3
    public Collection<PropertyDescriptor> getContributedVariables(Name name, LookupLocation2 lookupLocation2) {
        Intrinsics3.checkNotNullParameter(name, ModelAuditLogEntry.CHANGE_KEY_NAME);
        Intrinsics3.checkNotNullParameter(lookupLocation2, ModelAuditLogEntry.CHANGE_KEY_LOCATION);
        return !getVariableNames().contains(name) ? Collections2.emptyList() : (Collection) ((LockBasedStorageManager.m) this.f23399m).invoke(name);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.MemberScopeImpl, p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.MemberScope3
    public Set<Name> getFunctionNames() {
        return (Set) storage7.getValue(this.f23396j, this, (KProperty<?>) f23388b[0]);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.MemberScopeImpl, p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.MemberScope3
    public Set<Name> getVariableNames() {
        return (Set) storage7.getValue(this.f23397k, this, (KProperty<?>) f23388b[1]);
    }

    /* JADX INFO: renamed from: h */
    public abstract Set<Name> mo9476h(MemberScope2 memberScope2, Function1<? super Name, Boolean> function1);

    /* JADX INFO: renamed from: i */
    public abstract ReceiverParameterDescriptor mo9477i();

    /* JADX INFO: renamed from: j */
    public abstract DeclarationDescriptor mo9478j();

    /* JADX INFO: renamed from: k */
    public boolean mo9479k(JavaMethodDescriptor javaMethodDescriptor) {
        Intrinsics3.checkNotNullParameter(javaMethodDescriptor, "<this>");
        return true;
    }

    /* JADX INFO: renamed from: l */
    public abstract a mo9480l(InterfaceC11585r interfaceC11585r, List<? extends TypeParameterDescriptor> list, KotlinType kotlinType, List<? extends ValueParameterDescriptor> list2);

    /* JADX INFO: renamed from: m */
    public final JavaMethodDescriptor m9495m(InterfaceC11585r interfaceC11585r) {
        Intrinsics3.checkNotNullParameter(interfaceC11585r, "method");
        JavaMethodDescriptor javaMethodDescriptorCreateJavaMethod = JavaMethodDescriptor.createJavaMethod(mo9478j(), LazyJavaAnnotations2.resolveAnnotations(this.f23389c, interfaceC11585r), interfaceC11585r.getName(), this.f23389c.getComponents().getSourceElementFactory().source(interfaceC11585r), this.f23392f.invoke().findRecordComponentByName(interfaceC11585r.getName()) != null && interfaceC11585r.getValueParameters().isEmpty());
        Intrinsics3.checkNotNullExpressionValue(javaMethodDescriptorCreateJavaMethod, "createJavaMethod(\n            ownerDescriptor, annotations, method.name, c.components.sourceElementFactory.source(method),\n            declaredMemberIndex().findRecordComponentByName(method.name) != null && method.valueParameters.isEmpty()\n        )");
        context4 context4VarChildForMethod$default = context.childForMethod$default(this.f23389c, javaMethodDescriptorCreateJavaMethod, interfaceC11585r, 0, 4, null);
        List<InterfaceC11592y> typeParameters = interfaceC11585r.getTypeParameters();
        List<? extends TypeParameterDescriptor> arrayList = new ArrayList<>(Iterables2.collectionSizeOrDefault(typeParameters, 10));
        Iterator<T> it = typeParameters.iterator();
        while (it.hasNext()) {
            TypeParameterDescriptor typeParameterDescriptorResolveTypeParameter = context4VarChildForMethod$default.getTypeParameterResolver().resolveTypeParameter((InterfaceC11592y) it.next());
            Intrinsics3.checkNotNull(typeParameterDescriptorResolveTypeParameter);
            arrayList.add(typeParameterDescriptorResolveTypeParameter);
        }
        b bVarM9496n = m9496n(context4VarChildForMethod$default, javaMethodDescriptorCreateJavaMethod, interfaceC11585r.getValueParameters());
        a aVarMo9480l = mo9480l(interfaceC11585r, arrayList, m9494e(interfaceC11585r, context4VarChildForMethod$default), bVarM9496n.getDescriptors());
        KotlinType receiverType = aVarMo9480l.getReceiverType();
        javaMethodDescriptorCreateJavaMethod.initialize(receiverType == null ? null : DescriptorFactory.createExtensionReceiverParameterForCallable(javaMethodDescriptorCreateJavaMethod, receiverType, Annotations4.f22735f.getEMPTY()), mo9477i(), aVarMo9480l.getTypeParameters(), aVarMo9480l.getValueParameters(), aVarMo9480l.getReturnType(), Modality.f23104j.convertFromFlags(false, interfaceC11585r.isAbstract(), !interfaceC11585r.isFinal()), utils2.toDescriptorVisibility(interfaceC11585r.getVisibility()), aVarMo9480l.getReceiverType() != null ? MapsJVM.mapOf(Tuples.m10073to(JavaMethodDescriptor.f23262M, _Collections.first((List) bVarM9496n.getDescriptors()))) : Maps6.emptyMap());
        javaMethodDescriptorCreateJavaMethod.setParameterNamesStatus(aVarMo9480l.getHasStableParameterNames(), bVarM9496n.getHasSynthesizedNames());
        if (!aVarMo9480l.getErrors().isEmpty()) {
            ((SignaturePropagator.a) context4VarChildForMethod$default.getComponents().getSignaturePropagator()).reportSignatureErrors(javaMethodDescriptorCreateJavaMethod, aVarMo9480l.getErrors());
        }
        return javaMethodDescriptorCreateJavaMethod;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0119  */
    /* JADX INFO: renamed from: n */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final b m9496n(context4 context4Var, FunctionDescriptor functionDescriptor, List<? extends InterfaceC11565a0> list) {
        String value;
        Tuples2 tuples2M10073to;
        Name name;
        context4 context4Var2 = context4Var;
        Intrinsics3.checkNotNullParameter(context4Var2, "c");
        Intrinsics3.checkNotNullParameter(functionDescriptor, "function");
        Intrinsics3.checkNotNullParameter(list, "jValueParameters");
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        Iterable<IndexedValue> iterableWithIndex = _Collections.withIndex(list);
        ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(iterableWithIndex, 10));
        boolean z2 = false;
        boolean z3 = false;
        for (IndexedValue indexedValue : iterableWithIndex) {
            int iComponent1 = indexedValue.component1();
            InterfaceC11565a0 interfaceC11565a0 = (InterfaceC11565a0) indexedValue.component2();
            Annotations4 annotations4ResolveAnnotations = LazyJavaAnnotations2.resolveAnnotations(context4Var2, interfaceC11565a0);
            JavaTypeResolver attributes$default = JavaTypeResolver5.toAttributes$default(TypeUsage.COMMON, z2, null, 3, null);
            FqName fqName = JvmAnnotationNames.f23163q;
            Intrinsics3.checkNotNullExpressionValue(fqName, "PARAMETER_NAME_FQ_NAME");
            AnnotationDescriptor annotationDescriptorFindAnnotation = annotations4ResolveAnnotations.findAnnotation(fqName);
            AbstractC11815g<?> abstractC11815gFirstArgument = annotationDescriptorFindAnnotation == null ? null : DescriptorUtils2.firstArgument(annotationDescriptorFindAnnotation);
            if (abstractC11815gFirstArgument != null) {
                if (!(abstractC11815gFirstArgument instanceof C11831w)) {
                    abstractC11815gFirstArgument = null;
                }
                C11831w c11831w = (C11831w) abstractC11815gFirstArgument;
                value = c11831w == null ? null : c11831w.getValue();
            }
            if (interfaceC11565a0.isVararg()) {
                javaTypes5 type = interfaceC11565a0.getType();
                javaTypes2 javatypes2 = type instanceof javaTypes2 ? (javaTypes2) type : null;
                if (javatypes2 == null) {
                    throw new AssertionError(Intrinsics3.stringPlus("Vararg parameter should be an array: ", interfaceC11565a0));
                }
                KotlinType kotlinTypeTransformArrayType = context4Var.getTypeResolver().transformArrayType(javatypes2, attributes$default, true);
                tuples2M10073to = Tuples.m10073to(kotlinTypeTransformArrayType, context4Var.getModule().getBuiltIns().getArrayElementType(kotlinTypeTransformArrayType));
            } else {
                tuples2M10073to = Tuples.m10073to(context4Var.getTypeResolver().transformJavaType(interfaceC11565a0.getType(), attributes$default), null);
            }
            KotlinType kotlinType = (KotlinType) tuples2M10073to.component1();
            KotlinType kotlinType2 = (KotlinType) tuples2M10073to.component2();
            if (Intrinsics3.areEqual(((DeclarationDescriptorImpl) functionDescriptor).getName().asString(), "equals") && list.size() == 1 && Intrinsics3.areEqual(context4Var.getModule().getBuiltIns().getNullableAnyType(), kotlinType)) {
                name = Name.identifier("other");
            } else if (value == null) {
                name = interfaceC11565a0.getName();
                if (name == null) {
                    z3 = true;
                }
                if (name == null) {
                    name = Name.identifier(Intrinsics3.stringPlus("p", Integer.valueOf(iComponent1)));
                    Intrinsics3.checkNotNullExpressionValue(name, "identifier(\"p$index\")");
                }
            } else if ((value.length() > 0) && linkedHashSet.add(value)) {
                name = Name.identifier(value);
            }
            Name name2 = name;
            Intrinsics3.checkNotNullExpressionValue(name2, "if (function.name.asString() == \"equals\" &&\n                jValueParameters.size == 1 &&\n                c.module.builtIns.nullableAnyType == outType\n            ) {\n                // This is a hack to prevent numerous warnings on Kotlin classes that inherit Java classes: if you override \"equals\" in such\n                // class without this hack, you'll be warned that in the superclass the name is \"p0\" (regardless of the fact that it's\n                // \"other\" in Any)\n                // TODO: fix Java parameter name loading logic somehow (don't always load \"p0\", \"p1\", etc.)\n                Name.identifier(\"other\")\n            } else if (parameterName != null && parameterName.isNotEmpty() && usedNames.add(parameterName)) {\n                Name.identifier(parameterName)\n            } else {\n                // TODO: parameter names may be drawn from attached sources, which is slow; it's better to make them lazy\n                val javaName = javaParameter.name\n                if (javaName == null) synthesizedNames = true\n                javaName ?: Name.identifier(\"p$index\")\n            }");
            ArrayList arrayList2 = arrayList;
            arrayList2.add(new ValueParameterDescriptorImpl(functionDescriptor, null, iComponent1, annotations4ResolveAnnotations, name2, kotlinType, false, false, false, kotlinType2, context4Var.getComponents().getSourceElementFactory().source(interfaceC11565a0)));
            arrayList = arrayList2;
            z3 = z3;
            z2 = false;
            context4Var2 = context4Var;
        }
        return new b(_Collections.toList(arrayList), z3);
    }

    public String toString() {
        return Intrinsics3.stringPlus("Lazy scope for ", mo9478j());
    }

    public LazyJavaScope(context4 context4Var, LazyJavaScope lazyJavaScope) {
        Intrinsics3.checkNotNullParameter(context4Var, "c");
        this.f23389c = context4Var;
        this.f23390d = lazyJavaScope;
        this.f23391e = context4Var.getStorageManager().createRecursionTolerantLazyValue(new c(), Collections2.emptyList());
        this.f23392f = context4Var.getStorageManager().createLazyValue(new g());
        this.f23393g = context4Var.getStorageManager().createMemoizedFunction(new f());
        this.f23394h = context4Var.getStorageManager().createMemoizedFunctionWithNullableValues(new e());
        this.f23395i = context4Var.getStorageManager().createMemoizedFunction(new i());
        this.f23396j = context4Var.getStorageManager().createLazyValue(new h());
        this.f23397k = context4Var.getStorageManager().createLazyValue(new k());
        this.f23398l = context4Var.getStorageManager().createLazyValue(new d());
        this.f23399m = context4Var.getStorageManager().createMemoizedFunction(new j());
    }
}

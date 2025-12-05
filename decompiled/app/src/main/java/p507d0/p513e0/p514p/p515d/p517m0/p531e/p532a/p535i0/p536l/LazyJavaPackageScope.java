package p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p535i0.p536l;

import com.discord.models.domain.ModelAuditLogEntry;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.ClassDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.ClassifierDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.DeclarationDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.PropertyDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.SimpleFunctionDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p529d.p530b.LookupLocation2;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.JavaClassFinder;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p535i0.context4;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p535i0.p536l.DeclaredMemberIndex2;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.EnumC11569c0;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.InterfaceC11574g;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.InterfaceC11588u;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p541b.KotlinClassFinder;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p541b.KotlinClassFinder2;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p541b.KotlinJvmBinaryClass;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p541b.p542b0.KotlinClassHeader;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.ClassId;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.FqName;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.Name;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.SpecialNames;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.MemberScope2;
import p507d0.p513e0.p514p.p515d.p517m0.p566m.storage4;
import p507d0.p513e0.p514p.p515d.p517m0.p566m.storage6;
import p507d0.p513e0.p514p.p515d.p517m0.p576p.functions;
import p507d0.p580t.Collections2;
import p507d0.p580t.Sets5;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;

/* compiled from: LazyJavaPackageScope.kt */
/* renamed from: d0.e0.p.d.m0.e.a.i0.l.j, reason: use source file name */
/* loaded from: classes3.dex */
public final class LazyJavaPackageScope extends LazyJavaStaticScope {

    /* renamed from: n */
    public final InterfaceC11588u f23377n;

    /* renamed from: o */
    public final LazyJavaPackageFragment f23378o;

    /* renamed from: p */
    public final storage6<Set<String>> f23379p;

    /* renamed from: q */
    public final storage4<a, ClassDescriptor> f23380q;

    /* compiled from: LazyJavaPackageScope.kt */
    /* renamed from: d0.e0.p.d.m0.e.a.i0.l.j$a */
    public static final class a {

        /* renamed from: a */
        public final Name f23381a;

        /* renamed from: b */
        public final InterfaceC11574g f23382b;

        public a(Name name, InterfaceC11574g interfaceC11574g) {
            Intrinsics3.checkNotNullParameter(name, ModelAuditLogEntry.CHANGE_KEY_NAME);
            this.f23381a = name;
            this.f23382b = interfaceC11574g;
        }

        public boolean equals(Object obj) {
            return (obj instanceof a) && Intrinsics3.areEqual(this.f23381a, ((a) obj).f23381a);
        }

        public final InterfaceC11574g getJavaClass() {
            return this.f23382b;
        }

        public final Name getName() {
            return this.f23381a;
        }

        public int hashCode() {
            return this.f23381a.hashCode();
        }
    }

    /* compiled from: LazyJavaPackageScope.kt */
    /* renamed from: d0.e0.p.d.m0.e.a.i0.l.j$b */
    public static abstract class b {

        /* compiled from: LazyJavaPackageScope.kt */
        /* renamed from: d0.e0.p.d.m0.e.a.i0.l.j$b$a */
        public static final class a extends b {

            /* renamed from: a */
            public final ClassDescriptor f23383a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(ClassDescriptor classDescriptor) {
                super(null);
                Intrinsics3.checkNotNullParameter(classDescriptor, "descriptor");
                this.f23383a = classDescriptor;
            }

            public final ClassDescriptor getDescriptor() {
                return this.f23383a;
            }
        }

        /* compiled from: LazyJavaPackageScope.kt */
        /* renamed from: d0.e0.p.d.m0.e.a.i0.l.j$b$b, reason: collision with other inner class name */
        public static final class C13311b extends b {

            /* renamed from: a */
            public static final C13311b f23384a = new C13311b();

            public C13311b() {
                super(null);
            }
        }

        /* compiled from: LazyJavaPackageScope.kt */
        /* renamed from: d0.e0.p.d.m0.e.a.i0.l.j$b$c */
        public static final class c extends b {

            /* renamed from: a */
            public static final c f23385a = new c();

            public c() {
                super(null);
            }
        }

        public b(DefaultConstructorMarker defaultConstructorMarker) {
        }
    }

    /* compiled from: LazyJavaPackageScope.kt */
    /* renamed from: d0.e0.p.d.m0.e.a.i0.l.j$c */
    public static final class c extends Lambda implements Function1<a, ClassDescriptor> {

        /* renamed from: $c */
        public final /* synthetic */ context4 f23386$c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(context4 context4Var) {
            super(1);
            this.f23386$c = context4Var;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ ClassDescriptor invoke(a aVar) {
            return invoke2(aVar);
        }

        /* JADX WARN: Removed duplicated region for block: B:31:0x0091  */
        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final ClassDescriptor invoke2(a aVar) {
            Intrinsics3.checkNotNullParameter(aVar, "request");
            ClassId classId = new ClassId(LazyJavaPackageScope.this.f23378o.getFqName(), aVar.getName());
            KotlinClassFinder.a aVarFindKotlinClassOrContent = aVar.getJavaClass() != null ? this.f23386$c.getComponents().getKotlinClassFinder().findKotlinClassOrContent(aVar.getJavaClass()) : this.f23386$c.getComponents().getKotlinClassFinder().findKotlinClassOrContent(classId);
            KotlinJvmBinaryClass kotlinJvmBinaryClass = aVarFindKotlinClassOrContent == null ? null : aVarFindKotlinClassOrContent.toKotlinJvmBinaryClass();
            ClassId classId2 = kotlinJvmBinaryClass == null ? null : kotlinJvmBinaryClass.getClassId();
            if (classId2 != null && (classId2.isNestedClass() || classId2.isLocal())) {
                return null;
            }
            b bVarAccess$resolveKotlinBinaryClass = LazyJavaPackageScope.access$resolveKotlinBinaryClass(LazyJavaPackageScope.this, kotlinJvmBinaryClass);
            if (bVarAccess$resolveKotlinBinaryClass instanceof b.a) {
                return ((b.a) bVarAccess$resolveKotlinBinaryClass).getDescriptor();
            }
            if (bVarAccess$resolveKotlinBinaryClass instanceof b.c) {
                return null;
            }
            if (!(bVarAccess$resolveKotlinBinaryClass instanceof b.C13311b)) {
                throw new NoWhenBranchMatchedException();
            }
            InterfaceC11574g javaClass = aVar.getJavaClass();
            if (javaClass == null) {
                JavaClassFinder finder = this.f23386$c.getComponents().getFinder();
                if (aVarFindKotlinClassOrContent != null) {
                    if (!(aVarFindKotlinClassOrContent instanceof KotlinClassFinder.a.C13316a)) {
                        aVarFindKotlinClassOrContent = null;
                    }
                    KotlinClassFinder.a.C13316a c13316a = (KotlinClassFinder.a.C13316a) aVarFindKotlinClassOrContent;
                    byte[] content = c13316a == null ? null : c13316a.getContent();
                    javaClass = finder.findClass(new JavaClassFinder.a(classId, content, null, 4, null));
                }
            }
            InterfaceC11574g interfaceC11574g = javaClass;
            if ((interfaceC11574g == null ? null : interfaceC11574g.getLightClassOriginKind()) != EnumC11569c0.BINARY) {
                FqName fqName = interfaceC11574g == null ? null : interfaceC11574g.getFqName();
                if (fqName == null || fqName.isRoot() || !Intrinsics3.areEqual(fqName.parent(), LazyJavaPackageScope.this.f23378o.getFqName())) {
                    return null;
                }
                LazyJavaClassDescriptor lazyJavaClassDescriptor = new LazyJavaClassDescriptor(this.f23386$c, LazyJavaPackageScope.this.f23378o, interfaceC11574g, null, 8, null);
                this.f23386$c.getComponents().getJavaClassesTracker().reportClass(lazyJavaClassDescriptor);
                return lazyJavaClassDescriptor;
            }
            throw new IllegalStateException("Couldn't find kotlin binary class for light class created by kotlin binary file\nJavaClass: " + interfaceC11574g + "\nClassId: " + classId + "\nfindKotlinClass(JavaClass) = " + KotlinClassFinder2.findKotlinClass(this.f23386$c.getComponents().getKotlinClassFinder(), interfaceC11574g) + "\nfindKotlinClass(ClassId) = " + KotlinClassFinder2.findKotlinClass(this.f23386$c.getComponents().getKotlinClassFinder(), classId) + '\n');
        }
    }

    /* compiled from: LazyJavaPackageScope.kt */
    /* renamed from: d0.e0.p.d.m0.e.a.i0.l.j$d */
    public static final class d extends Lambda implements Function0<Set<? extends String>> {

        /* renamed from: $c */
        public final /* synthetic */ context4 f23387$c;
        public final /* synthetic */ LazyJavaPackageScope this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(context4 context4Var, LazyJavaPackageScope lazyJavaPackageScope) {
            super(0);
            this.f23387$c = context4Var;
            this.this$0 = lazyJavaPackageScope;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Set<? extends String> invoke() {
            return invoke2();
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Set<? extends String> invoke2() {
            return this.f23387$c.getComponents().getFinder().knownClassNamesInPackage(this.this$0.f23378o.getFqName());
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LazyJavaPackageScope(context4 context4Var, InterfaceC11588u interfaceC11588u, LazyJavaPackageFragment lazyJavaPackageFragment) {
        super(context4Var);
        Intrinsics3.checkNotNullParameter(context4Var, "c");
        Intrinsics3.checkNotNullParameter(interfaceC11588u, "jPackage");
        Intrinsics3.checkNotNullParameter(lazyJavaPackageFragment, "ownerDescriptor");
        this.f23377n = interfaceC11588u;
        this.f23378o = lazyJavaPackageFragment;
        this.f23379p = context4Var.getStorageManager().createNullableLazyValue(new d(context4Var, this));
        this.f23380q = context4Var.getStorageManager().createMemoizedFunctionWithNullableValues(new c(context4Var));
    }

    public static final b access$resolveKotlinBinaryClass(LazyJavaPackageScope lazyJavaPackageScope, KotlinJvmBinaryClass kotlinJvmBinaryClass) {
        Objects.requireNonNull(lazyJavaPackageScope);
        if (kotlinJvmBinaryClass == null) {
            return b.C13311b.f23384a;
        }
        if (kotlinJvmBinaryClass.getClassHeader().getKind() != KotlinClassHeader.a.CLASS) {
            return b.c.f23385a;
        }
        ClassDescriptor classDescriptorResolveClass = lazyJavaPackageScope.f23389c.getComponents().getDeserializedDescriptorResolver().resolveClass(kotlinJvmBinaryClass);
        return classDescriptorResolveClass != null ? new b.a(classDescriptorResolveClass) : b.C13311b.f23384a;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p535i0.p536l.LazyJavaScope
    /* renamed from: a */
    public Set<Name> mo9470a(MemberScope2 memberScope2, Function1<? super Name, Boolean> function1) {
        Intrinsics3.checkNotNullParameter(memberScope2, "kindFilter");
        if (!memberScope2.acceptsKinds(MemberScope2.f24339a.getNON_SINGLETON_CLASSIFIERS_MASK())) {
            return Sets5.emptySet();
        }
        Set<String> setInvoke = this.f23379p.invoke();
        if (setInvoke != null) {
            HashSet hashSet = new HashSet();
            Iterator<T> it = setInvoke.iterator();
            while (it.hasNext()) {
                hashSet.add(Name.identifier((String) it.next()));
            }
            return hashSet;
        }
        InterfaceC11588u interfaceC11588u = this.f23377n;
        if (function1 == null) {
            function1 = functions.alwaysTrue();
        }
        Collection<InterfaceC11574g> classes = interfaceC11588u.getClasses(function1);
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (InterfaceC11574g interfaceC11574g : classes) {
            Name name = interfaceC11574g.getLightClassOriginKind() == EnumC11569c0.SOURCE ? null : interfaceC11574g.getName();
            if (name != null) {
                linkedHashSet.add(name);
            }
        }
        return linkedHashSet;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p535i0.p536l.LazyJavaScope
    /* renamed from: b */
    public Set<Name> mo9471b(MemberScope2 memberScope2, Function1<? super Name, Boolean> function1) {
        Intrinsics3.checkNotNullParameter(memberScope2, "kindFilter");
        return Sets5.emptySet();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p535i0.p536l.LazyJavaScope
    /* renamed from: d */
    public DeclaredMemberIndex2 mo9473d() {
        return DeclaredMemberIndex2.a.f23328a;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p535i0.p536l.LazyJavaScope
    /* renamed from: f */
    public void mo9474f(Collection<SimpleFunctionDescriptor> collection, Name name) {
        Intrinsics3.checkNotNullParameter(collection, "result");
        Intrinsics3.checkNotNullParameter(name, ModelAuditLogEntry.CHANGE_KEY_NAME);
    }

    public final ClassDescriptor findClassifierByJavaClass$descriptors_jvm(InterfaceC11574g interfaceC11574g) {
        Intrinsics3.checkNotNullParameter(interfaceC11574g, "javaClass");
        return m9493o(interfaceC11574g.getName(), interfaceC11574g);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.MemberScopeImpl, p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.ResolutionScope
    public /* bridge */ /* synthetic */ ClassifierDescriptor getContributedClassifier(Name name, LookupLocation2 lookupLocation2) {
        return getContributedClassifier(name, lookupLocation2);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x005b  */
    @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p535i0.p536l.LazyJavaScope, p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.MemberScopeImpl, p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.ResolutionScope
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Collection<DeclarationDescriptor> getContributedDescriptors(MemberScope2 memberScope2, Function1<? super Name, Boolean> function1) {
        boolean z2;
        Intrinsics3.checkNotNullParameter(memberScope2, "kindFilter");
        Intrinsics3.checkNotNullParameter(function1, "nameFilter");
        MemberScope2.a aVar = MemberScope2.f24339a;
        if (!memberScope2.acceptsKinds(aVar.getNON_SINGLETON_CLASSIFIERS_MASK() | aVar.getCLASSIFIERS_MASK())) {
            return Collections2.emptyList();
        }
        Collection<DeclarationDescriptor> collectionInvoke = this.f23391e.invoke();
        ArrayList arrayList = new ArrayList();
        for (Object obj : collectionInvoke) {
            DeclarationDescriptor declarationDescriptor = (DeclarationDescriptor) obj;
            if (declarationDescriptor instanceof ClassDescriptor) {
                Name name = ((ClassDescriptor) declarationDescriptor).getName();
                Intrinsics3.checkNotNullExpressionValue(name, "it.name");
                z2 = function1.invoke(name).booleanValue();
            }
            if (z2) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p535i0.p536l.LazyJavaScope, p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.MemberScopeImpl, p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.MemberScope3
    public Collection<PropertyDescriptor> getContributedVariables(Name name, LookupLocation2 lookupLocation2) {
        Intrinsics3.checkNotNullParameter(name, ModelAuditLogEntry.CHANGE_KEY_NAME);
        Intrinsics3.checkNotNullParameter(lookupLocation2, ModelAuditLogEntry.CHANGE_KEY_LOCATION);
        return Collections2.emptyList();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p535i0.p536l.LazyJavaScope
    /* renamed from: h */
    public Set<Name> mo9476h(MemberScope2 memberScope2, Function1<? super Name, Boolean> function1) {
        Intrinsics3.checkNotNullParameter(memberScope2, "kindFilter");
        return Sets5.emptySet();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p535i0.p536l.LazyJavaScope
    /* renamed from: j */
    public DeclarationDescriptor mo9478j() {
        return this.f23378o;
    }

    /* renamed from: o */
    public final ClassDescriptor m9493o(Name name, InterfaceC11574g interfaceC11574g) {
        if (!SpecialNames.isSafeIdentifier(name)) {
            return null;
        }
        Set<String> setInvoke = this.f23379p.invoke();
        if (interfaceC11574g != null || setInvoke == null || setInvoke.contains(name.asString())) {
            return this.f23380q.invoke(new a(name, interfaceC11574g));
        }
        return null;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.MemberScopeImpl, p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.ResolutionScope
    public ClassDescriptor getContributedClassifier(Name name, LookupLocation2 lookupLocation2) {
        Intrinsics3.checkNotNullParameter(name, ModelAuditLogEntry.CHANGE_KEY_NAME);
        Intrinsics3.checkNotNullParameter(lookupLocation2, ModelAuditLogEntry.CHANGE_KEY_LOCATION);
        return m9493o(name, null);
    }
}

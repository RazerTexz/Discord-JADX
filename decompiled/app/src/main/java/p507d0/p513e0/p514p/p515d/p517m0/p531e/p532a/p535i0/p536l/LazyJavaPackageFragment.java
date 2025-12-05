package p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p535i0.p536l;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Tuples2;
import kotlin.jvm.functions.Function0;
import kotlin.reflect.KProperty;
import p507d0.Tuples;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.ClassDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.SourceElement;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1.Annotations4;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1.PackageFragmentDescriptorImpl;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p535i0.LazyJavaAnnotations2;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p535i0.context;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p535i0.context4;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.InterfaceC11574g;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.InterfaceC11588u;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p541b.KotlinClassFinder2;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p541b.KotlinJvmBinaryClass;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p541b.KotlinJvmBinaryPackageSourceElement;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p541b.PackagePartProvider;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p541b.p542b0.KotlinClassHeader;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.ClassId;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.FqName;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.MemberScope3;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p560y.JvmClassName;
import p507d0.p513e0.p514p.p515d.p517m0.p566m.storage5;
import p507d0.p513e0.p514p.p515d.p517m0.p566m.storage7;
import p507d0.p580t.Collections2;
import p507d0.p580t.Iterables2;
import p507d0.p580t.Maps6;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;
import p507d0.p592z.p594d.PropertyReference1Impl;
import p507d0.p592z.p594d.Reflection2;

/* compiled from: LazyJavaPackageFragment.kt */
/* renamed from: d0.e0.p.d.m0.e.a.i0.l.i, reason: use source file name */
/* loaded from: classes3.dex */
public final class LazyJavaPackageFragment extends PackageFragmentDescriptorImpl {

    /* renamed from: o */
    public static final /* synthetic */ KProperty<Object>[] f23370o = {Reflection2.property1(new PropertyReference1Impl(Reflection2.getOrCreateKotlinClass(LazyJavaPackageFragment.class), "binaryClasses", "getBinaryClasses$descriptors_jvm()Ljava/util/Map;")), Reflection2.property1(new PropertyReference1Impl(Reflection2.getOrCreateKotlinClass(LazyJavaPackageFragment.class), "partToFacade", "getPartToFacade()Ljava/util/HashMap;"))};

    /* renamed from: p */
    public final InterfaceC11588u f23371p;

    /* renamed from: q */
    public final context4 f23372q;

    /* renamed from: r */
    public final storage5 f23373r;

    /* renamed from: s */
    public final JvmPackageScope f23374s;

    /* renamed from: t */
    public final storage5<List<FqName>> f23375t;

    /* renamed from: u */
    public final Annotations4 f23376u;

    /* compiled from: LazyJavaPackageFragment.kt */
    /* renamed from: d0.e0.p.d.m0.e.a.i0.l.i$a */
    public static final class a extends Lambda implements Function0<Map<String, ? extends KotlinJvmBinaryClass>> {
        public a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Map<String, ? extends KotlinJvmBinaryClass> invoke() {
            return invoke2();
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Map<String, ? extends KotlinJvmBinaryClass> invoke2() {
            PackagePartProvider packagePartProvider = LazyJavaPackageFragment.access$getC$p(LazyJavaPackageFragment.this).getComponents().getPackagePartProvider();
            String strAsString = LazyJavaPackageFragment.this.getFqName().asString();
            Intrinsics3.checkNotNullExpressionValue(strAsString, "fqName.asString()");
            List<String> listFindPackageParts = packagePartProvider.findPackageParts(strAsString);
            LazyJavaPackageFragment lazyJavaPackageFragment = LazyJavaPackageFragment.this;
            ArrayList arrayList = new ArrayList();
            for (String str : listFindPackageParts) {
                ClassId classId = ClassId.topLevel(JvmClassName.byInternalName(str).getFqNameForTopLevelClassMaybeWithDollars());
                Intrinsics3.checkNotNullExpressionValue(classId, "topLevel(JvmClassName.byInternalName(partName).fqNameForTopLevelClassMaybeWithDollars)");
                KotlinJvmBinaryClass kotlinJvmBinaryClassFindKotlinClass = KotlinClassFinder2.findKotlinClass(LazyJavaPackageFragment.access$getC$p(lazyJavaPackageFragment).getComponents().getKotlinClassFinder(), classId);
                Tuples2 tuples2M10073to = kotlinJvmBinaryClassFindKotlinClass == null ? null : Tuples.m10073to(str, kotlinJvmBinaryClassFindKotlinClass);
                if (tuples2M10073to != null) {
                    arrayList.add(tuples2M10073to);
                }
            }
            return Maps6.toMap(arrayList);
        }
    }

    /* compiled from: LazyJavaPackageFragment.kt */
    /* renamed from: d0.e0.p.d.m0.e.a.i0.l.i$b */
    public static final class b extends Lambda implements Function0<HashMap<JvmClassName, JvmClassName>> {
        public b() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ HashMap<JvmClassName, JvmClassName> invoke() {
            return invoke2();
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final HashMap<JvmClassName, JvmClassName> invoke2() {
            String multifileClassName;
            HashMap<JvmClassName, JvmClassName> map = new HashMap<>();
            for (Map.Entry<String, KotlinJvmBinaryClass> entry : LazyJavaPackageFragment.this.getBinaryClasses$descriptors_jvm().entrySet()) {
                String key = entry.getKey();
                KotlinJvmBinaryClass value = entry.getValue();
                JvmClassName jvmClassNameByInternalName = JvmClassName.byInternalName(key);
                Intrinsics3.checkNotNullExpressionValue(jvmClassNameByInternalName, "byInternalName(partInternalName)");
                KotlinClassHeader classHeader = value.getClassHeader();
                int iOrdinal = classHeader.getKind().ordinal();
                if (iOrdinal == 2) {
                    map.put(jvmClassNameByInternalName, jvmClassNameByInternalName);
                } else if (iOrdinal == 5 && (multifileClassName = classHeader.getMultifileClassName()) != null) {
                    JvmClassName jvmClassNameByInternalName2 = JvmClassName.byInternalName(multifileClassName);
                    Intrinsics3.checkNotNullExpressionValue(jvmClassNameByInternalName2, "byInternalName(header.multifileClassName ?: continue@kotlinClasses)");
                    map.put(jvmClassNameByInternalName, jvmClassNameByInternalName2);
                }
            }
            return map;
        }
    }

    /* compiled from: LazyJavaPackageFragment.kt */
    /* renamed from: d0.e0.p.d.m0.e.a.i0.l.i$c */
    public static final class c extends Lambda implements Function0<List<? extends FqName>> {
        public c() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ List<? extends FqName> invoke() {
            return invoke2();
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final List<? extends FqName> invoke2() {
            Collection<InterfaceC11588u> subPackages = LazyJavaPackageFragment.access$getJPackage$p(LazyJavaPackageFragment.this).getSubPackages();
            ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(subPackages, 10));
            Iterator<T> it = subPackages.iterator();
            while (it.hasNext()) {
                arrayList.add(((InterfaceC11588u) it.next()).getFqName());
            }
            return arrayList;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LazyJavaPackageFragment(context4 context4Var, InterfaceC11588u interfaceC11588u) {
        super(context4Var.getModule(), interfaceC11588u.getFqName());
        Intrinsics3.checkNotNullParameter(context4Var, "outerContext");
        Intrinsics3.checkNotNullParameter(interfaceC11588u, "jPackage");
        this.f23371p = interfaceC11588u;
        context4 context4VarChildForClassOrPackage$default = context.childForClassOrPackage$default(context4Var, this, null, 0, 6, null);
        this.f23372q = context4VarChildForClassOrPackage$default;
        this.f23373r = context4VarChildForClassOrPackage$default.getStorageManager().createLazyValue(new a());
        this.f23374s = new JvmPackageScope(context4VarChildForClassOrPackage$default, interfaceC11588u, this);
        this.f23375t = context4VarChildForClassOrPackage$default.getStorageManager().createRecursionTolerantLazyValue(new c(), Collections2.emptyList());
        this.f23376u = context4VarChildForClassOrPackage$default.getComponents().getJavaTypeEnhancementState().getDisabledDefaultAnnotations() ? Annotations4.f22735f.getEMPTY() : LazyJavaAnnotations2.resolveAnnotations(context4VarChildForClassOrPackage$default, interfaceC11588u);
        context4VarChildForClassOrPackage$default.getStorageManager().createLazyValue(new b());
    }

    public static final /* synthetic */ context4 access$getC$p(LazyJavaPackageFragment lazyJavaPackageFragment) {
        return lazyJavaPackageFragment.f23372q;
    }

    public static final /* synthetic */ InterfaceC11588u access$getJPackage$p(LazyJavaPackageFragment lazyJavaPackageFragment) {
        return lazyJavaPackageFragment.f23371p;
    }

    public final ClassDescriptor findClassifierByJavaClass$descriptors_jvm(InterfaceC11574g interfaceC11574g) {
        Intrinsics3.checkNotNullParameter(interfaceC11574g, "jClass");
        return this.f23374s.getJavaScope$descriptors_jvm().findClassifierByJavaClass$descriptors_jvm(interfaceC11574g);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1.AnnotatedImpl, p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1.Annotations3
    public Annotations4 getAnnotations() {
        return this.f23376u;
    }

    public final Map<String, KotlinJvmBinaryClass> getBinaryClasses$descriptors_jvm() {
        return (Map) storage7.getValue(this.f23373r, this, (KProperty<?>) f23370o[0]);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.PackageFragmentDescriptor
    public /* bridge */ /* synthetic */ MemberScope3 getMemberScope() {
        return getMemberScope();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1.PackageFragmentDescriptorImpl, p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1.DeclarationDescriptorNonRootImpl, p507d0.p513e0.p514p.p515d.p517m0.p521c.DeclarationDescriptorWithSource
    public SourceElement getSource() {
        return new KotlinJvmBinaryPackageSourceElement(this);
    }

    public final List<FqName> getSubPackageFqNames$descriptors_jvm() {
        return this.f23375t.invoke();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1.PackageFragmentDescriptorImpl, p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1.DeclarationDescriptorImpl
    public String toString() {
        return Intrinsics3.stringPlus("Lazy Java package fragment: ", getFqName());
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.PackageFragmentDescriptor
    public JvmPackageScope getMemberScope() {
        return this.f23374s;
    }
}

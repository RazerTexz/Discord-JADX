package p507d0.p513e0.p514p.p515d.p517m0.p521c.p526k1.p527a;

import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p507d0.p513e0.p514p.p515d.p517m0.p518b.p520q.JvmBuiltIns;
import p507d0.p513e0.p514p.p515d.p517m0.p518b.p520q.JvmBuiltInsPackageFragmentProvider;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.ModuleDescriptor2;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.NotFoundClasses;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.PackageFragmentProvider3;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1.CompositePackageFragmentProvider;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1.ModuleDescriptorImpl3;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p533g0.JavaResolverCache;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p535i0.LazyJavaPackageFragmentProvider;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p535i0.ModuleClassResolver2;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p541b.DeserializationComponentsForJava;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p541b.DeserializedDescriptorResolver;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.Name;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p560y.JavaDescriptorResolver;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p561z.SamConversionResolverImpl;
import p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b.DeserializationConfiguration;
import p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b.context5;
import p507d0.p513e0.p514p.p515d.p517m0.p566m.LockBasedStorageManager;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.p568l1.NewKotlinTypeChecker;
import p507d0.p580t.Collections2;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: RuntimeModuleData.kt */
/* renamed from: d0.e0.p.d.m0.c.k1.a.k, reason: use source file name */
/* loaded from: classes3.dex */
public final class RuntimeModuleData {

    /* renamed from: a */
    public static final a f23022a = new a(null);

    /* renamed from: b */
    public final context5 f23023b;

    /* renamed from: c */
    public final PackagePartScopeCache f23024c;

    /* compiled from: RuntimeModuleData.kt */
    /* renamed from: d0.e0.p.d.m0.c.k1.a.k$a */
    public static final class a {
        public a(DefaultConstructorMarker defaultConstructorMarker) {
        }

        public final RuntimeModuleData create(ClassLoader classLoader) {
            Intrinsics3.checkNotNullParameter(classLoader, "classLoader");
            LockBasedStorageManager lockBasedStorageManager = new LockBasedStorageManager("RuntimeModuleData");
            JvmBuiltIns jvmBuiltIns = new JvmBuiltIns(lockBasedStorageManager, JvmBuiltIns.a.FROM_DEPENDENCIES);
            Name nameSpecial = Name.special("<runtime module for " + classLoader + '>');
            Intrinsics3.checkNotNullExpressionValue(nameSpecial, "special(\"<runtime module for $classLoader>\")");
            ModuleDescriptorImpl3 moduleDescriptorImpl3 = new ModuleDescriptorImpl3(nameSpecial, lockBasedStorageManager, jvmBuiltIns, null, null, null, 56, null);
            jvmBuiltIns.setBuiltInsModule(moduleDescriptorImpl3);
            jvmBuiltIns.initialize(moduleDescriptorImpl3, true);
            ReflectKotlinClassFinder reflectKotlinClassFinder = new ReflectKotlinClassFinder(classLoader);
            DeserializedDescriptorResolver deserializedDescriptorResolver = new DeserializedDescriptorResolver();
            ModuleClassResolver2 moduleClassResolver2 = new ModuleClassResolver2();
            NotFoundClasses notFoundClasses = new NotFoundClasses(lockBasedStorageManager, moduleDescriptorImpl3);
            LazyJavaPackageFragmentProvider lazyJavaPackageFragmentProviderMakeLazyJavaPackageFragmentFromClassLoaderProvider$default = RuntimeModuleData2.makeLazyJavaPackageFragmentFromClassLoaderProvider$default(classLoader, moduleDescriptorImpl3, lockBasedStorageManager, notFoundClasses, reflectKotlinClassFinder, deserializedDescriptorResolver, moduleClassResolver2, null, 128, null);
            DeserializationComponentsForJava deserializationComponentsForJavaMakeDeserializationComponentsForJava = RuntimeModuleData2.makeDeserializationComponentsForJava(moduleDescriptorImpl3, lockBasedStorageManager, notFoundClasses, lazyJavaPackageFragmentProviderMakeLazyJavaPackageFragmentFromClassLoaderProvider$default, reflectKotlinClassFinder, deserializedDescriptorResolver);
            deserializedDescriptorResolver.setComponents(deserializationComponentsForJavaMakeDeserializationComponentsForJava);
            JavaResolverCache javaResolverCache = JavaResolverCache.f23244a;
            Intrinsics3.checkNotNullExpressionValue(javaResolverCache, "EMPTY");
            JavaDescriptorResolver javaDescriptorResolver = new JavaDescriptorResolver(lazyJavaPackageFragmentProviderMakeLazyJavaPackageFragmentFromClassLoaderProvider$default, javaResolverCache);
            moduleClassResolver2.setResolver(javaDescriptorResolver);
            ClassLoader classLoader2 = Unit.class.getClassLoader();
            Intrinsics3.checkNotNullExpressionValue(classLoader2, "stdlibClassLoader");
            JvmBuiltInsPackageFragmentProvider jvmBuiltInsPackageFragmentProvider = new JvmBuiltInsPackageFragmentProvider(lockBasedStorageManager, new ReflectKotlinClassFinder(classLoader2), moduleDescriptorImpl3, notFoundClasses, jvmBuiltIns.getCustomizer(), jvmBuiltIns.getCustomizer(), DeserializationConfiguration.a.f24658a, NewKotlinTypeChecker.f24820b.getDefault(), new SamConversionResolverImpl(lockBasedStorageManager, Collections2.emptyList()));
            moduleDescriptorImpl3.setDependencies(moduleDescriptorImpl3);
            moduleDescriptorImpl3.initialize(new CompositePackageFragmentProvider(Collections2.listOf((Object[]) new PackageFragmentProvider3[]{javaDescriptorResolver.getPackageFragmentProvider(), jvmBuiltInsPackageFragmentProvider})));
            return new RuntimeModuleData(deserializationComponentsForJavaMakeDeserializationComponentsForJava.getComponents(), new PackagePartScopeCache(deserializedDescriptorResolver, reflectKotlinClassFinder), null);
        }
    }

    public RuntimeModuleData(context5 context5Var, PackagePartScopeCache packagePartScopeCache, DefaultConstructorMarker defaultConstructorMarker) {
        this.f23023b = context5Var;
        this.f23024c = packagePartScopeCache;
    }

    public final context5 getDeserialization() {
        return this.f23023b;
    }

    public final ModuleDescriptor2 getModule() {
        return this.f23023b.getModuleDescriptor();
    }

    public final PackagePartScopeCache getPackagePartScopeCache() {
        return this.f23024c;
    }
}

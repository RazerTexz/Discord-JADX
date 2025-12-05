package p507d0.p513e0.p514p.p515d.p517m0.p521c.p526k1.p527a;

import p507d0.p513e0.p514p.p515d.p517m0.p518b.ReflectionTypes;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.ModuleDescriptor2;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.NotFoundClasses;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.SupertypeLoopChecker;
import p507d0.p513e0.p514p.p515d.p517m0.p529d.p530b.LookupTracker;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.AnnotationTypeQualifierResolver;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.JavaClassesTracker;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p533g0.JavaPropertyInitializerEvaluator;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p533g0.JavaResolverCache;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p533g0.SignaturePropagator;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p535i0.LazyJavaPackageFragmentProvider;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p535i0.ModuleClassResolver;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p535i0.context2;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p535i0.context3;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p540l0.signatureEnhancement;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p540l0.typeEnhancement4;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p541b.BinaryClassAnnotationAndConstantLoaderImpl;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p541b.DeserializationComponentsForJava;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p541b.DeserializedDescriptorResolver;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p541b.JavaClassDataFinder;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p541b.KotlinClassFinder;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p541b.PackagePartProvider;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p561z.SamConversionResolverImpl;
import p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b.ContractDeserializer;
import p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b.DeserializationConfiguration;
import p507d0.p513e0.p514p.p515d.p517m0.p566m.StorageManager;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.p568l1.NewKotlinTypeChecker;
import p507d0.p513e0.p514p.p515d.p517m0.p576p.JavaTypeEnhancementState;
import p507d0.p580t.Collections2;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: RuntimeModuleData.kt */
/* renamed from: d0.e0.p.d.m0.c.k1.a.l, reason: use source file name */
/* loaded from: classes3.dex */
public final class RuntimeModuleData2 {
    public static final DeserializationComponentsForJava makeDeserializationComponentsForJava(ModuleDescriptor2 moduleDescriptor2, StorageManager storageManager, NotFoundClasses notFoundClasses, LazyJavaPackageFragmentProvider lazyJavaPackageFragmentProvider, KotlinClassFinder kotlinClassFinder, DeserializedDescriptorResolver deserializedDescriptorResolver) {
        Intrinsics3.checkNotNullParameter(moduleDescriptor2, "module");
        Intrinsics3.checkNotNullParameter(storageManager, "storageManager");
        Intrinsics3.checkNotNullParameter(notFoundClasses, "notFoundClasses");
        Intrinsics3.checkNotNullParameter(lazyJavaPackageFragmentProvider, "lazyJavaPackageFragmentProvider");
        Intrinsics3.checkNotNullParameter(kotlinClassFinder, "reflectKotlinClassFinder");
        Intrinsics3.checkNotNullParameter(deserializedDescriptorResolver, "deserializedDescriptorResolver");
        return new DeserializationComponentsForJava(storageManager, moduleDescriptor2, DeserializationConfiguration.a.f24658a, new JavaClassDataFinder(kotlinClassFinder, deserializedDescriptorResolver), new BinaryClassAnnotationAndConstantLoaderImpl(moduleDescriptor2, notFoundClasses, storageManager, kotlinClassFinder), lazyJavaPackageFragmentProvider, notFoundClasses, RuntimeErrorReporter.f23021b, LookupTracker.a.f23110a, ContractDeserializer.f24635a.getDEFAULT(), NewKotlinTypeChecker.f24820b.getDefault());
    }

    public static final LazyJavaPackageFragmentProvider makeLazyJavaPackageFragmentFromClassLoaderProvider(ClassLoader classLoader, ModuleDescriptor2 moduleDescriptor2, StorageManager storageManager, NotFoundClasses notFoundClasses, KotlinClassFinder kotlinClassFinder, DeserializedDescriptorResolver deserializedDescriptorResolver, ModuleClassResolver moduleClassResolver, PackagePartProvider packagePartProvider) {
        Intrinsics3.checkNotNullParameter(classLoader, "classLoader");
        Intrinsics3.checkNotNullParameter(moduleDescriptor2, "module");
        Intrinsics3.checkNotNullParameter(storageManager, "storageManager");
        Intrinsics3.checkNotNullParameter(notFoundClasses, "notFoundClasses");
        Intrinsics3.checkNotNullParameter(kotlinClassFinder, "reflectKotlinClassFinder");
        Intrinsics3.checkNotNullParameter(deserializedDescriptorResolver, "deserializedDescriptorResolver");
        Intrinsics3.checkNotNullParameter(moduleClassResolver, "singleModuleClassResolver");
        Intrinsics3.checkNotNullParameter(packagePartProvider, "packagePartProvider");
        JavaTypeEnhancementState javaTypeEnhancementState = JavaTypeEnhancementState.f24982b;
        AnnotationTypeQualifierResolver annotationTypeQualifierResolver = new AnnotationTypeQualifierResolver(storageManager, javaTypeEnhancementState);
        ReflectJavaClassFinder reflectJavaClassFinder = new ReflectJavaClassFinder(classLoader);
        SignaturePropagator signaturePropagator = SignaturePropagator.f23249a;
        Intrinsics3.checkNotNullExpressionValue(signaturePropagator, "DO_NOTHING");
        RuntimeErrorReporter runtimeErrorReporter = RuntimeErrorReporter.f23021b;
        JavaResolverCache javaResolverCache = JavaResolverCache.f23244a;
        Intrinsics3.checkNotNullExpressionValue(javaResolverCache, "EMPTY");
        JavaPropertyInitializerEvaluator.a aVar = JavaPropertyInitializerEvaluator.a.f23243a;
        SamConversionResolverImpl samConversionResolverImpl = new SamConversionResolverImpl(storageManager, Collections2.emptyList());
        RuntimeSourceElementFactory runtimeSourceElementFactory = RuntimeSourceElementFactory.f23025a;
        SupertypeLoopChecker.a aVar2 = SupertypeLoopChecker.a.f23103a;
        LookupTracker.a aVar3 = LookupTracker.a.f23110a;
        ReflectionTypes reflectionTypes = new ReflectionTypes(moduleDescriptor2, notFoundClasses);
        context3.a aVar4 = context3.a.f23303a;
        return new LazyJavaPackageFragmentProvider(new context2(storageManager, reflectJavaClassFinder, kotlinClassFinder, deserializedDescriptorResolver, signaturePropagator, runtimeErrorReporter, javaResolverCache, aVar, samConversionResolverImpl, runtimeSourceElementFactory, moduleClassResolver, packagePartProvider, aVar2, aVar3, moduleDescriptor2, reflectionTypes, annotationTypeQualifierResolver, new signatureEnhancement(annotationTypeQualifierResolver, javaTypeEnhancementState, new typeEnhancement4(aVar4)), JavaClassesTracker.a.f23521a, aVar4, NewKotlinTypeChecker.f24820b.getDefault(), javaTypeEnhancementState));
    }

    public static /* synthetic */ LazyJavaPackageFragmentProvider makeLazyJavaPackageFragmentFromClassLoaderProvider$default(ClassLoader classLoader, ModuleDescriptor2 moduleDescriptor2, StorageManager storageManager, NotFoundClasses notFoundClasses, KotlinClassFinder kotlinClassFinder, DeserializedDescriptorResolver deserializedDescriptorResolver, ModuleClassResolver moduleClassResolver, PackagePartProvider packagePartProvider, int i, Object obj) {
        return makeLazyJavaPackageFragmentFromClassLoaderProvider(classLoader, moduleDescriptor2, storageManager, notFoundClasses, kotlinClassFinder, deserializedDescriptorResolver, moduleClassResolver, (i & 128) != 0 ? PackagePartProvider.a.f23635a : packagePartProvider);
    }
}

package p507d0.p513e0.p514p.p515d.p517m0.p531e.p541b;

import java.util.List;
import p507d0.p513e0.p514p.p515d.p517m0.p518b.KotlinBuiltIns;
import p507d0.p513e0.p514p.p515d.p517m0.p518b.p520q.JvmBuiltIns;
import p507d0.p513e0.p514p.p515d.p517m0.p518b.p520q.JvmBuiltInsCustomizer2;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.ModuleDescriptor2;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.NotFoundClasses;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p523h1.AdditionalClassPartsProvider;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p523h1.PlatformDependentDeclarationFilter;
import p507d0.p513e0.p514p.p515d.p517m0.p529d.p530b.LookupTracker;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p535i0.LazyJavaPackageFragmentProvider;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.p544a0.p545b.JvmProtoBufUtil;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p561z.SamConversionResolverImpl;
import p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b.ContractDeserializer;
import p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b.DeserializationConfiguration;
import p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b.ErrorReporter;
import p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b.LocalClassifierTypeSettings;
import p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b.context5;
import p507d0.p513e0.p514p.p515d.p517m0.p566m.StorageManager;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.p568l1.NewKotlinTypeChecker;
import p507d0.p580t.Collections2;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: renamed from: d0.e0.p.d.m0.e.b.e, reason: use source file name */
/* JADX INFO: compiled from: DeserializationComponentsForJava.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class DeserializationComponentsForJava {

    /* JADX INFO: renamed from: a */
    public final context5 f23602a;

    public DeserializationComponentsForJava(StorageManager storageManager, ModuleDescriptor2 moduleDescriptor2, DeserializationConfiguration deserializationConfiguration, JavaClassDataFinder javaClassDataFinder, BinaryClassAnnotationAndConstantLoaderImpl binaryClassAnnotationAndConstantLoaderImpl, LazyJavaPackageFragmentProvider lazyJavaPackageFragmentProvider, NotFoundClasses notFoundClasses, ErrorReporter errorReporter, LookupTracker lookupTracker, ContractDeserializer contractDeserializer, NewKotlinTypeChecker newKotlinTypeChecker) {
        Intrinsics3.checkNotNullParameter(storageManager, "storageManager");
        Intrinsics3.checkNotNullParameter(moduleDescriptor2, "moduleDescriptor");
        Intrinsics3.checkNotNullParameter(deserializationConfiguration, "configuration");
        Intrinsics3.checkNotNullParameter(javaClassDataFinder, "classDataFinder");
        Intrinsics3.checkNotNullParameter(binaryClassAnnotationAndConstantLoaderImpl, "annotationAndConstantLoader");
        Intrinsics3.checkNotNullParameter(lazyJavaPackageFragmentProvider, "packageFragmentProvider");
        Intrinsics3.checkNotNullParameter(notFoundClasses, "notFoundClasses");
        Intrinsics3.checkNotNullParameter(errorReporter, "errorReporter");
        Intrinsics3.checkNotNullParameter(lookupTracker, "lookupTracker");
        Intrinsics3.checkNotNullParameter(contractDeserializer, "contractDeserializer");
        Intrinsics3.checkNotNullParameter(newKotlinTypeChecker, "kotlinTypeChecker");
        KotlinBuiltIns builtIns = moduleDescriptor2.getBuiltIns();
        JvmBuiltIns jvmBuiltIns = builtIns instanceof JvmBuiltIns ? (JvmBuiltIns) builtIns : null;
        LocalClassifierTypeSettings.a aVar = LocalClassifierTypeSettings.a.f24682a;
        JavaFlexibleTypeDeserializer javaFlexibleTypeDeserializer = JavaFlexibleTypeDeserializer.f23613a;
        List listEmptyList = Collections2.emptyList();
        AdditionalClassPartsProvider customizer = jvmBuiltIns == null ? null : jvmBuiltIns.getCustomizer();
        AdditionalClassPartsProvider additionalClassPartsProvider = customizer == null ? AdditionalClassPartsProvider.a.f22796a : customizer;
        JvmBuiltInsCustomizer2 customizer2 = jvmBuiltIns != null ? jvmBuiltIns.getCustomizer() : null;
        this.f23602a = new context5(storageManager, moduleDescriptor2, deserializationConfiguration, javaClassDataFinder, binaryClassAnnotationAndConstantLoaderImpl, lazyJavaPackageFragmentProvider, aVar, errorReporter, lookupTracker, javaFlexibleTypeDeserializer, listEmptyList, notFoundClasses, contractDeserializer, additionalClassPartsProvider, customizer2 == null ? PlatformDependentDeclarationFilter.b.f22798a : customizer2, JvmProtoBufUtil.f23720a.getEXTENSION_REGISTRY(), newKotlinTypeChecker, new SamConversionResolverImpl(storageManager, Collections2.emptyList()), null, 262144, null);
    }

    public final context5 getComponents() {
        return this.f23602a;
    }
}

package p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b.p564d0;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KDeclarationContainer;
import org.objectweb.asm.Opcodes;
import p507d0.p513e0.p514p.p515d.p517m0.p518b.BuiltInsLoader;
import p507d0.p513e0.p514p.p515d.p517m0.p518b.StandardNames;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.ModuleDescriptor2;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.NotFoundClasses;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.PackageFragmentProvider;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.PackageFragmentProviderImpl;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p523h1.AdditionalClassPartsProvider;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p523h1.ClassDescriptorFactory;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p523h1.PlatformDependentDeclarationFilter;
import p507d0.p513e0.p514p.p515d.p517m0.p529d.p530b.LookupTracker;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.FqName;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p561z.SamConversionResolverImpl;
import p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b.AnnotationAndConstantLoaderImpl;
import p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b.ContractDeserializer;
import p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b.DeserializationConfiguration;
import p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b.DeserializedClassDataFinder;
import p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b.ErrorReporter;
import p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b.FlexibleTypeDeserializer;
import p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b.LocalClassifierTypeSettings;
import p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b.context5;
import p507d0.p513e0.p514p.p515d.p517m0.p566m.StorageManager;
import p507d0.p580t.Collections2;
import p507d0.p580t.Iterables2;
import p507d0.p592z.p594d.FunctionReference;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Reflection2;

/* compiled from: BuiltInsLoaderImpl.kt */
/* renamed from: d0.e0.p.d.m0.l.b.d0.b, reason: use source file name */
/* loaded from: classes3.dex */
public final class BuiltInsLoaderImpl implements BuiltInsLoader {

    /* renamed from: b */
    public final BuiltInsResourceLoader f24516b = new BuiltInsResourceLoader();

    /* compiled from: BuiltInsLoaderImpl.kt */
    /* renamed from: d0.e0.p.d.m0.l.b.d0.b$a */
    public /* synthetic */ class a extends FunctionReference implements Function1<String, InputStream> {
        public a(BuiltInsResourceLoader builtInsResourceLoader) {
            super(1, builtInsResourceLoader);
        }

        @Override // p507d0.p592z.p594d.CallableReference, kotlin.reflect.KCallable
        public final String getName() {
            return "loadResource";
        }

        @Override // p507d0.p592z.p594d.CallableReference
        public final KDeclarationContainer getOwner() {
            return Reflection2.getOrCreateKotlinClass(BuiltInsResourceLoader.class);
        }

        @Override // p507d0.p592z.p594d.CallableReference
        public final String getSignature() {
            return "loadResource(Ljava/lang/String;)Ljava/io/InputStream;";
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final InputStream invoke2(String str) {
            Intrinsics3.checkNotNullParameter(str, "p0");
            return ((BuiltInsResourceLoader) this.receiver).loadResource(str);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ InputStream invoke(String str) {
            return invoke2(str);
        }
    }

    public final PackageFragmentProvider createBuiltInPackageFragmentProvider(StorageManager storageManager, ModuleDescriptor2 moduleDescriptor2, Set<FqName> set, Iterable<? extends ClassDescriptorFactory> iterable, PlatformDependentDeclarationFilter platformDependentDeclarationFilter, AdditionalClassPartsProvider additionalClassPartsProvider, boolean z2, Function1<? super String, ? extends InputStream> function1) {
        Intrinsics3.checkNotNullParameter(storageManager, "storageManager");
        Intrinsics3.checkNotNullParameter(moduleDescriptor2, "module");
        Intrinsics3.checkNotNullParameter(set, "packageFqNames");
        Intrinsics3.checkNotNullParameter(iterable, "classDescriptorFactories");
        Intrinsics3.checkNotNullParameter(platformDependentDeclarationFilter, "platformDependentDeclarationFilter");
        Intrinsics3.checkNotNullParameter(additionalClassPartsProvider, "additionalClassPartsProvider");
        Intrinsics3.checkNotNullParameter(function1, "loadResource");
        ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(set, 10));
        for (FqName fqName : set) {
            String builtInsFilePath = BuiltInSerializerProtocol.f24515m.getBuiltInsFilePath(fqName);
            InputStream inputStreamInvoke = function1.invoke(builtInsFilePath);
            if (inputStreamInvoke == null) {
                throw new IllegalStateException(Intrinsics3.stringPlus("Resource not found in classpath: ", builtInsFilePath));
            }
            arrayList.add(BuiltInsPackageFragmentImpl.f24517v.create(fqName, storageManager, moduleDescriptor2, inputStreamInvoke, z2));
        }
        PackageFragmentProviderImpl packageFragmentProviderImpl = new PackageFragmentProviderImpl(arrayList);
        NotFoundClasses notFoundClasses = new NotFoundClasses(storageManager, moduleDescriptor2);
        DeserializationConfiguration.a aVar = DeserializationConfiguration.a.f24658a;
        DeserializedClassDataFinder deserializedClassDataFinder = new DeserializedClassDataFinder(packageFragmentProviderImpl);
        BuiltInSerializerProtocol builtInSerializerProtocol = BuiltInSerializerProtocol.f24515m;
        AnnotationAndConstantLoaderImpl annotationAndConstantLoaderImpl = new AnnotationAndConstantLoaderImpl(moduleDescriptor2, notFoundClasses, builtInSerializerProtocol);
        LocalClassifierTypeSettings.a aVar2 = LocalClassifierTypeSettings.a.f24682a;
        ErrorReporter errorReporter = ErrorReporter.f24676a;
        Intrinsics3.checkNotNullExpressionValue(errorReporter, "DO_NOTHING");
        context5 context5Var = new context5(storageManager, moduleDescriptor2, aVar, deserializedClassDataFinder, annotationAndConstantLoaderImpl, packageFragmentProviderImpl, aVar2, errorReporter, LookupTracker.a.f23110a, FlexibleTypeDeserializer.a.f24677a, iterable, notFoundClasses, ContractDeserializer.f24635a.getDEFAULT(), additionalClassPartsProvider, platformDependentDeclarationFilter, builtInSerializerProtocol.getExtensionRegistry(), null, new SamConversionResolverImpl(storageManager, Collections2.emptyList()), null, Opcodes.ASM5, null);
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((BuiltInsPackageFragmentImpl) it.next()).initialize(context5Var);
        }
        return packageFragmentProviderImpl;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p518b.BuiltInsLoader
    public PackageFragmentProvider createPackageFragmentProvider(StorageManager storageManager, ModuleDescriptor2 moduleDescriptor2, Iterable<? extends ClassDescriptorFactory> iterable, PlatformDependentDeclarationFilter platformDependentDeclarationFilter, AdditionalClassPartsProvider additionalClassPartsProvider, boolean z2) {
        Intrinsics3.checkNotNullParameter(storageManager, "storageManager");
        Intrinsics3.checkNotNullParameter(moduleDescriptor2, "builtInsModule");
        Intrinsics3.checkNotNullParameter(iterable, "classDescriptorFactories");
        Intrinsics3.checkNotNullParameter(platformDependentDeclarationFilter, "platformDependentDeclarationFilter");
        Intrinsics3.checkNotNullParameter(additionalClassPartsProvider, "additionalClassPartsProvider");
        return createBuiltInPackageFragmentProvider(storageManager, moduleDescriptor2, StandardNames.f22503p, iterable, platformDependentDeclarationFilter, additionalClassPartsProvider, z2, new a(this.f24516b));
    }
}

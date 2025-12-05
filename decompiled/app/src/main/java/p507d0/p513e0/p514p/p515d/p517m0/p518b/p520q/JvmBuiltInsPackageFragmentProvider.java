package p507d0.p513e0.p514p.p515d.p517m0.p518b.p520q;

import p507d0.p513e0.p514p.p515d.p517m0.p518b.p519p.BuiltInFictitiousFunctionClassFactory;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.ModuleDescriptor2;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.NotFoundClasses;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p523h1.AdditionalClassPartsProvider;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p523h1.ClassDescriptorFactory;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p523h1.PlatformDependentDeclarationFilter;
import p507d0.p513e0.p514p.p515d.p517m0.p529d.p530b.LookupTracker;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p541b.KotlinClassFinder;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p561z.SamConversionResolver;
import p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b.AbstractDeserializedPackageFragmentProvider;
import p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b.AnnotationAndConstantLoaderImpl;
import p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b.ContractDeserializer;
import p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b.DeserializationConfiguration;
import p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b.DeserializedClassDataFinder;
import p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b.ErrorReporter;
import p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b.FlexibleTypeDeserializer;
import p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b.LocalClassifierTypeSettings;
import p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b.context5;
import p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b.p564d0.BuiltInSerializerProtocol;
import p507d0.p513e0.p514p.p515d.p517m0.p566m.StorageManager;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.p568l1.NewKotlinTypeChecker;
import p507d0.p580t.Collections2;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: JvmBuiltInsPackageFragmentProvider.kt */
/* renamed from: d0.e0.p.d.m0.b.q.o, reason: use source file name */
/* loaded from: classes3.dex */
public final class JvmBuiltInsPackageFragmentProvider extends AbstractDeserializedPackageFragmentProvider {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public JvmBuiltInsPackageFragmentProvider(StorageManager storageManager, KotlinClassFinder kotlinClassFinder, ModuleDescriptor2 moduleDescriptor2, NotFoundClasses notFoundClasses, AdditionalClassPartsProvider additionalClassPartsProvider, PlatformDependentDeclarationFilter platformDependentDeclarationFilter, DeserializationConfiguration deserializationConfiguration, NewKotlinTypeChecker newKotlinTypeChecker, SamConversionResolver samConversionResolver) {
        super(storageManager, kotlinClassFinder, moduleDescriptor2);
        Intrinsics3.checkNotNullParameter(storageManager, "storageManager");
        Intrinsics3.checkNotNullParameter(kotlinClassFinder, "finder");
        Intrinsics3.checkNotNullParameter(moduleDescriptor2, "moduleDescriptor");
        Intrinsics3.checkNotNullParameter(notFoundClasses, "notFoundClasses");
        Intrinsics3.checkNotNullParameter(additionalClassPartsProvider, "additionalClassPartsProvider");
        Intrinsics3.checkNotNullParameter(platformDependentDeclarationFilter, "platformDependentDeclarationFilter");
        Intrinsics3.checkNotNullParameter(deserializationConfiguration, "deserializationConfiguration");
        Intrinsics3.checkNotNullParameter(newKotlinTypeChecker, "kotlinTypeChecker");
        Intrinsics3.checkNotNullParameter(samConversionResolver, "samConversionResolver");
        DeserializedClassDataFinder deserializedClassDataFinder = new DeserializedClassDataFinder(this);
        BuiltInSerializerProtocol builtInSerializerProtocol = BuiltInSerializerProtocol.f24515m;
        AnnotationAndConstantLoaderImpl annotationAndConstantLoaderImpl = new AnnotationAndConstantLoaderImpl(moduleDescriptor2, notFoundClasses, builtInSerializerProtocol);
        LocalClassifierTypeSettings.a aVar = LocalClassifierTypeSettings.a.f24682a;
        ErrorReporter errorReporter = ErrorReporter.f24676a;
        Intrinsics3.checkNotNullExpressionValue(errorReporter, "DO_NOTHING");
        context5 context5Var = new context5(storageManager, moduleDescriptor2, deserializationConfiguration, deserializedClassDataFinder, annotationAndConstantLoaderImpl, this, aVar, errorReporter, LookupTracker.a.f23110a, FlexibleTypeDeserializer.a.f24677a, Collections2.listOf((Object[]) new ClassDescriptorFactory[]{new BuiltInFictitiousFunctionClassFactory(storageManager, moduleDescriptor2), new JvmBuiltInClassDescriptorFactory(storageManager, moduleDescriptor2, null, 4, null)}), notFoundClasses, ContractDeserializer.f24635a.getDEFAULT(), additionalClassPartsProvider, platformDependentDeclarationFilter, builtInSerializerProtocol.getExtensionRegistry(), newKotlinTypeChecker, samConversionResolver, null, 262144, null);
        Intrinsics3.checkNotNullParameter(context5Var, "<set-?>");
        this.f24493d = context5Var;
    }
}

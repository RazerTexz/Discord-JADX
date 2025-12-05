package p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b;

import kotlin.jvm.internal.DefaultConstructorMarker;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.ClassDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.ModuleDescriptor2;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.NotFoundClasses;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.PackageFragmentDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.PackageFragmentProvider;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1.AnnotationDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p523h1.AdditionalClassPartsProvider;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p523h1.ClassDescriptorFactory;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p523h1.PlatformDependentDeclarationFilter;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p523h1.PlatformDependentTypeTransformer;
import p507d0.p513e0.p514p.p515d.p517m0.p529d.p530b.LookupTracker;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.p547z.BinaryVersion;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.p547z.NameResolver;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.p547z.TypeTable;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.p547z.VersionRequirement2;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.ClassId;
import p507d0.p513e0.p514p.p515d.p517m0.p550i.ExtensionRegistryLite;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p557v.AbstractC11815g;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p561z.SamConversionResolver;
import p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b.p565e0.DeserializedContainerSource2;
import p507d0.p513e0.p514p.p515d.p517m0.p566m.StorageManager;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.p568l1.NewKotlinTypeChecker;
import p507d0.p580t.Collections2;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: context.kt */
/* renamed from: d0.e0.p.d.m0.l.b.j, reason: use source file name */
/* loaded from: classes3.dex */
public final class context5 {

    /* renamed from: a */
    public final StorageManager f24638a;

    /* renamed from: b */
    public final ModuleDescriptor2 f24639b;

    /* renamed from: c */
    public final DeserializationConfiguration f24640c;

    /* renamed from: d */
    public final ClassDataFinder f24641d;

    /* renamed from: e */
    public final AnnotationAndConstantLoader<AnnotationDescriptor, AbstractC11815g<?>> f24642e;

    /* renamed from: f */
    public final PackageFragmentProvider f24643f;

    /* renamed from: g */
    public final LocalClassifierTypeSettings f24644g;

    /* renamed from: h */
    public final ErrorReporter f24645h;

    /* renamed from: i */
    public final LookupTracker f24646i;

    /* renamed from: j */
    public final FlexibleTypeDeserializer f24647j;

    /* renamed from: k */
    public final Iterable<ClassDescriptorFactory> f24648k;

    /* renamed from: l */
    public final NotFoundClasses f24649l;

    /* renamed from: m */
    public final ContractDeserializer f24650m;

    /* renamed from: n */
    public final AdditionalClassPartsProvider f24651n;

    /* renamed from: o */
    public final PlatformDependentDeclarationFilter f24652o;

    /* renamed from: p */
    public final ExtensionRegistryLite f24653p;

    /* renamed from: q */
    public final NewKotlinTypeChecker f24654q;

    /* renamed from: r */
    public final SamConversionResolver f24655r;

    /* renamed from: s */
    public final PlatformDependentTypeTransformer f24656s;

    /* renamed from: t */
    public final ClassDeserializer f24657t;

    /* JADX WARN: Multi-variable type inference failed */
    public context5(StorageManager storageManager, ModuleDescriptor2 moduleDescriptor2, DeserializationConfiguration deserializationConfiguration, ClassDataFinder classDataFinder, AnnotationAndConstantLoader<? extends AnnotationDescriptor, ? extends AbstractC11815g<?>> annotationAndConstantLoader, PackageFragmentProvider packageFragmentProvider, LocalClassifierTypeSettings localClassifierTypeSettings, ErrorReporter errorReporter, LookupTracker lookupTracker, FlexibleTypeDeserializer flexibleTypeDeserializer, Iterable<? extends ClassDescriptorFactory> iterable, NotFoundClasses notFoundClasses, ContractDeserializer contractDeserializer, AdditionalClassPartsProvider additionalClassPartsProvider, PlatformDependentDeclarationFilter platformDependentDeclarationFilter, ExtensionRegistryLite extensionRegistryLite, NewKotlinTypeChecker newKotlinTypeChecker, SamConversionResolver samConversionResolver, PlatformDependentTypeTransformer platformDependentTypeTransformer) {
        Intrinsics3.checkNotNullParameter(storageManager, "storageManager");
        Intrinsics3.checkNotNullParameter(moduleDescriptor2, "moduleDescriptor");
        Intrinsics3.checkNotNullParameter(deserializationConfiguration, "configuration");
        Intrinsics3.checkNotNullParameter(classDataFinder, "classDataFinder");
        Intrinsics3.checkNotNullParameter(annotationAndConstantLoader, "annotationAndConstantLoader");
        Intrinsics3.checkNotNullParameter(packageFragmentProvider, "packageFragmentProvider");
        Intrinsics3.checkNotNullParameter(localClassifierTypeSettings, "localClassifierTypeSettings");
        Intrinsics3.checkNotNullParameter(errorReporter, "errorReporter");
        Intrinsics3.checkNotNullParameter(lookupTracker, "lookupTracker");
        Intrinsics3.checkNotNullParameter(flexibleTypeDeserializer, "flexibleTypeDeserializer");
        Intrinsics3.checkNotNullParameter(iterable, "fictitiousClassDescriptorFactories");
        Intrinsics3.checkNotNullParameter(notFoundClasses, "notFoundClasses");
        Intrinsics3.checkNotNullParameter(contractDeserializer, "contractDeserializer");
        Intrinsics3.checkNotNullParameter(additionalClassPartsProvider, "additionalClassPartsProvider");
        Intrinsics3.checkNotNullParameter(platformDependentDeclarationFilter, "platformDependentDeclarationFilter");
        Intrinsics3.checkNotNullParameter(extensionRegistryLite, "extensionRegistryLite");
        Intrinsics3.checkNotNullParameter(newKotlinTypeChecker, "kotlinTypeChecker");
        Intrinsics3.checkNotNullParameter(samConversionResolver, "samConversionResolver");
        Intrinsics3.checkNotNullParameter(platformDependentTypeTransformer, "platformDependentTypeTransformer");
        this.f24638a = storageManager;
        this.f24639b = moduleDescriptor2;
        this.f24640c = deserializationConfiguration;
        this.f24641d = classDataFinder;
        this.f24642e = annotationAndConstantLoader;
        this.f24643f = packageFragmentProvider;
        this.f24644g = localClassifierTypeSettings;
        this.f24645h = errorReporter;
        this.f24646i = lookupTracker;
        this.f24647j = flexibleTypeDeserializer;
        this.f24648k = iterable;
        this.f24649l = notFoundClasses;
        this.f24650m = contractDeserializer;
        this.f24651n = additionalClassPartsProvider;
        this.f24652o = platformDependentDeclarationFilter;
        this.f24653p = extensionRegistryLite;
        this.f24654q = newKotlinTypeChecker;
        this.f24655r = samConversionResolver;
        this.f24656s = platformDependentTypeTransformer;
        this.f24657t = new ClassDeserializer(this);
    }

    public final context6 createContext(PackageFragmentDescriptor packageFragmentDescriptor, NameResolver nameResolver, TypeTable typeTable, VersionRequirement2 versionRequirement2, BinaryVersion binaryVersion, DeserializedContainerSource2 deserializedContainerSource2) {
        Intrinsics3.checkNotNullParameter(packageFragmentDescriptor, "descriptor");
        Intrinsics3.checkNotNullParameter(nameResolver, "nameResolver");
        Intrinsics3.checkNotNullParameter(typeTable, "typeTable");
        Intrinsics3.checkNotNullParameter(versionRequirement2, "versionRequirementTable");
        Intrinsics3.checkNotNullParameter(binaryVersion, "metadataVersion");
        return new context6(this, nameResolver, packageFragmentDescriptor, typeTable, versionRequirement2, binaryVersion, deserializedContainerSource2, null, Collections2.emptyList());
    }

    public final ClassDescriptor deserializeClass(ClassId classId) {
        Intrinsics3.checkNotNullParameter(classId, "classId");
        return ClassDeserializer.deserializeClass$default(this.f24657t, classId, null, 2, null);
    }

    public final AdditionalClassPartsProvider getAdditionalClassPartsProvider() {
        return this.f24651n;
    }

    public final AnnotationAndConstantLoader<AnnotationDescriptor, AbstractC11815g<?>> getAnnotationAndConstantLoader() {
        return this.f24642e;
    }

    public final ClassDataFinder getClassDataFinder() {
        return this.f24641d;
    }

    public final ClassDeserializer getClassDeserializer() {
        return this.f24657t;
    }

    public final DeserializationConfiguration getConfiguration() {
        return this.f24640c;
    }

    public final ContractDeserializer getContractDeserializer() {
        return this.f24650m;
    }

    public final ErrorReporter getErrorReporter() {
        return this.f24645h;
    }

    public final ExtensionRegistryLite getExtensionRegistryLite() {
        return this.f24653p;
    }

    public final Iterable<ClassDescriptorFactory> getFictitiousClassDescriptorFactories() {
        return this.f24648k;
    }

    public final FlexibleTypeDeserializer getFlexibleTypeDeserializer() {
        return this.f24647j;
    }

    public final NewKotlinTypeChecker getKotlinTypeChecker() {
        return this.f24654q;
    }

    public final LocalClassifierTypeSettings getLocalClassifierTypeSettings() {
        return this.f24644g;
    }

    public final LookupTracker getLookupTracker() {
        return this.f24646i;
    }

    public final ModuleDescriptor2 getModuleDescriptor() {
        return this.f24639b;
    }

    public final NotFoundClasses getNotFoundClasses() {
        return this.f24649l;
    }

    public final PackageFragmentProvider getPackageFragmentProvider() {
        return this.f24643f;
    }

    public final PlatformDependentDeclarationFilter getPlatformDependentDeclarationFilter() {
        return this.f24652o;
    }

    public final PlatformDependentTypeTransformer getPlatformDependentTypeTransformer() {
        return this.f24656s;
    }

    public final StorageManager getStorageManager() {
        return this.f24638a;
    }

    public /* synthetic */ context5(StorageManager storageManager, ModuleDescriptor2 moduleDescriptor2, DeserializationConfiguration deserializationConfiguration, ClassDataFinder classDataFinder, AnnotationAndConstantLoader annotationAndConstantLoader, PackageFragmentProvider packageFragmentProvider, LocalClassifierTypeSettings localClassifierTypeSettings, ErrorReporter errorReporter, LookupTracker lookupTracker, FlexibleTypeDeserializer flexibleTypeDeserializer, Iterable iterable, NotFoundClasses notFoundClasses, ContractDeserializer contractDeserializer, AdditionalClassPartsProvider additionalClassPartsProvider, PlatformDependentDeclarationFilter platformDependentDeclarationFilter, ExtensionRegistryLite extensionRegistryLite, NewKotlinTypeChecker newKotlinTypeChecker, SamConversionResolver samConversionResolver, PlatformDependentTypeTransformer platformDependentTypeTransformer, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(storageManager, moduleDescriptor2, deserializationConfiguration, classDataFinder, annotationAndConstantLoader, packageFragmentProvider, localClassifierTypeSettings, errorReporter, lookupTracker, flexibleTypeDeserializer, iterable, notFoundClasses, contractDeserializer, (i & 8192) != 0 ? AdditionalClassPartsProvider.a.f22796a : additionalClassPartsProvider, (i & 16384) != 0 ? PlatformDependentDeclarationFilter.a.f22797a : platformDependentDeclarationFilter, extensionRegistryLite, (65536 & i) != 0 ? NewKotlinTypeChecker.f24820b.getDefault() : newKotlinTypeChecker, samConversionResolver, (i & 262144) != 0 ? PlatformDependentTypeTransformer.a.f22800a : platformDependentTypeTransformer);
    }
}

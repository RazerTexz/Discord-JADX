package p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p535i0;

import p507d0.p513e0.p514p.p515d.p517m0.p518b.ReflectionTypes;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.ModuleDescriptor2;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.SupertypeLoopChecker;
import p507d0.p513e0.p514p.p515d.p517m0.p529d.p530b.LookupTracker;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.AnnotationTypeQualifierResolver;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.JavaClassFinder;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.JavaClassesTracker;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p533g0.JavaPropertyInitializerEvaluator;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p533g0.JavaResolverCache;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p533g0.SignaturePropagator;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p538j0.JavaSourceElementFactory2;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p540l0.signatureEnhancement;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p541b.DeserializedDescriptorResolver;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p541b.KotlinClassFinder;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p541b.PackagePartProvider;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p561z.SamConversionResolver;
import p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b.ErrorReporter;
import p507d0.p513e0.p514p.p515d.p517m0.p566m.StorageManager;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.p568l1.NewKotlinTypeChecker;
import p507d0.p513e0.p514p.p515d.p517m0.p576p.JavaTypeEnhancementState;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: context.kt */
/* renamed from: d0.e0.p.d.m0.e.a.i0.b, reason: use source file name */
/* loaded from: classes3.dex */
public final class context2 {

    /* renamed from: a */
    public final StorageManager f23281a;

    /* renamed from: b */
    public final JavaClassFinder f23282b;

    /* renamed from: c */
    public final KotlinClassFinder f23283c;

    /* renamed from: d */
    public final DeserializedDescriptorResolver f23284d;

    /* renamed from: e */
    public final SignaturePropagator f23285e;

    /* renamed from: f */
    public final ErrorReporter f23286f;

    /* renamed from: g */
    public final JavaResolverCache f23287g;

    /* renamed from: h */
    public final JavaPropertyInitializerEvaluator f23288h;

    /* renamed from: i */
    public final SamConversionResolver f23289i;

    /* renamed from: j */
    public final JavaSourceElementFactory2 f23290j;

    /* renamed from: k */
    public final ModuleClassResolver f23291k;

    /* renamed from: l */
    public final PackagePartProvider f23292l;

    /* renamed from: m */
    public final SupertypeLoopChecker f23293m;

    /* renamed from: n */
    public final LookupTracker f23294n;

    /* renamed from: o */
    public final ModuleDescriptor2 f23295o;

    /* renamed from: p */
    public final ReflectionTypes f23296p;

    /* renamed from: q */
    public final AnnotationTypeQualifierResolver f23297q;

    /* renamed from: r */
    public final signatureEnhancement f23298r;

    /* renamed from: s */
    public final JavaClassesTracker f23299s;

    /* renamed from: t */
    public final context3 f23300t;

    /* renamed from: u */
    public final NewKotlinTypeChecker f23301u;

    /* renamed from: v */
    public final JavaTypeEnhancementState f23302v;

    public context2(StorageManager storageManager, JavaClassFinder javaClassFinder, KotlinClassFinder kotlinClassFinder, DeserializedDescriptorResolver deserializedDescriptorResolver, SignaturePropagator signaturePropagator, ErrorReporter errorReporter, JavaResolverCache javaResolverCache, JavaPropertyInitializerEvaluator javaPropertyInitializerEvaluator, SamConversionResolver samConversionResolver, JavaSourceElementFactory2 javaSourceElementFactory2, ModuleClassResolver moduleClassResolver, PackagePartProvider packagePartProvider, SupertypeLoopChecker supertypeLoopChecker, LookupTracker lookupTracker, ModuleDescriptor2 moduleDescriptor2, ReflectionTypes reflectionTypes, AnnotationTypeQualifierResolver annotationTypeQualifierResolver, signatureEnhancement signatureenhancement, JavaClassesTracker javaClassesTracker, context3 context3Var, NewKotlinTypeChecker newKotlinTypeChecker, JavaTypeEnhancementState javaTypeEnhancementState) {
        Intrinsics3.checkNotNullParameter(storageManager, "storageManager");
        Intrinsics3.checkNotNullParameter(javaClassFinder, "finder");
        Intrinsics3.checkNotNullParameter(kotlinClassFinder, "kotlinClassFinder");
        Intrinsics3.checkNotNullParameter(deserializedDescriptorResolver, "deserializedDescriptorResolver");
        Intrinsics3.checkNotNullParameter(signaturePropagator, "signaturePropagator");
        Intrinsics3.checkNotNullParameter(errorReporter, "errorReporter");
        Intrinsics3.checkNotNullParameter(javaResolverCache, "javaResolverCache");
        Intrinsics3.checkNotNullParameter(javaPropertyInitializerEvaluator, "javaPropertyInitializerEvaluator");
        Intrinsics3.checkNotNullParameter(samConversionResolver, "samConversionResolver");
        Intrinsics3.checkNotNullParameter(javaSourceElementFactory2, "sourceElementFactory");
        Intrinsics3.checkNotNullParameter(moduleClassResolver, "moduleClassResolver");
        Intrinsics3.checkNotNullParameter(packagePartProvider, "packagePartProvider");
        Intrinsics3.checkNotNullParameter(supertypeLoopChecker, "supertypeLoopChecker");
        Intrinsics3.checkNotNullParameter(lookupTracker, "lookupTracker");
        Intrinsics3.checkNotNullParameter(moduleDescriptor2, "module");
        Intrinsics3.checkNotNullParameter(reflectionTypes, "reflectionTypes");
        Intrinsics3.checkNotNullParameter(annotationTypeQualifierResolver, "annotationTypeQualifierResolver");
        Intrinsics3.checkNotNullParameter(signatureenhancement, "signatureEnhancement");
        Intrinsics3.checkNotNullParameter(javaClassesTracker, "javaClassesTracker");
        Intrinsics3.checkNotNullParameter(context3Var, "settings");
        Intrinsics3.checkNotNullParameter(newKotlinTypeChecker, "kotlinTypeChecker");
        Intrinsics3.checkNotNullParameter(javaTypeEnhancementState, "javaTypeEnhancementState");
        this.f23281a = storageManager;
        this.f23282b = javaClassFinder;
        this.f23283c = kotlinClassFinder;
        this.f23284d = deserializedDescriptorResolver;
        this.f23285e = signaturePropagator;
        this.f23286f = errorReporter;
        this.f23287g = javaResolverCache;
        this.f23288h = javaPropertyInitializerEvaluator;
        this.f23289i = samConversionResolver;
        this.f23290j = javaSourceElementFactory2;
        this.f23291k = moduleClassResolver;
        this.f23292l = packagePartProvider;
        this.f23293m = supertypeLoopChecker;
        this.f23294n = lookupTracker;
        this.f23295o = moduleDescriptor2;
        this.f23296p = reflectionTypes;
        this.f23297q = annotationTypeQualifierResolver;
        this.f23298r = signatureenhancement;
        this.f23299s = javaClassesTracker;
        this.f23300t = context3Var;
        this.f23301u = newKotlinTypeChecker;
        this.f23302v = javaTypeEnhancementState;
    }

    public final AnnotationTypeQualifierResolver getAnnotationTypeQualifierResolver() {
        return this.f23297q;
    }

    public final DeserializedDescriptorResolver getDeserializedDescriptorResolver() {
        return this.f23284d;
    }

    public final ErrorReporter getErrorReporter() {
        return this.f23286f;
    }

    public final JavaClassFinder getFinder() {
        return this.f23282b;
    }

    public final JavaClassesTracker getJavaClassesTracker() {
        return this.f23299s;
    }

    public final JavaPropertyInitializerEvaluator getJavaPropertyInitializerEvaluator() {
        return this.f23288h;
    }

    public final JavaResolverCache getJavaResolverCache() {
        return this.f23287g;
    }

    public final JavaTypeEnhancementState getJavaTypeEnhancementState() {
        return this.f23302v;
    }

    public final KotlinClassFinder getKotlinClassFinder() {
        return this.f23283c;
    }

    public final NewKotlinTypeChecker getKotlinTypeChecker() {
        return this.f23301u;
    }

    public final LookupTracker getLookupTracker() {
        return this.f23294n;
    }

    public final ModuleDescriptor2 getModule() {
        return this.f23295o;
    }

    public final ModuleClassResolver getModuleClassResolver() {
        return this.f23291k;
    }

    public final PackagePartProvider getPackagePartProvider() {
        return this.f23292l;
    }

    public final ReflectionTypes getReflectionTypes() {
        return this.f23296p;
    }

    public final context3 getSettings() {
        return this.f23300t;
    }

    public final signatureEnhancement getSignatureEnhancement() {
        return this.f23298r;
    }

    public final SignaturePropagator getSignaturePropagator() {
        return this.f23285e;
    }

    public final JavaSourceElementFactory2 getSourceElementFactory() {
        return this.f23290j;
    }

    public final StorageManager getStorageManager() {
        return this.f23281a;
    }

    public final SupertypeLoopChecker getSupertypeLoopChecker() {
        return this.f23293m;
    }

    public final context2 replace(JavaResolverCache javaResolverCache) {
        Intrinsics3.checkNotNullParameter(javaResolverCache, "javaResolverCache");
        return new context2(this.f23281a, this.f23282b, this.f23283c, this.f23284d, this.f23285e, this.f23286f, javaResolverCache, this.f23288h, this.f23289i, this.f23290j, this.f23291k, this.f23292l, this.f23293m, this.f23294n, this.f23295o, this.f23296p, this.f23297q, this.f23298r, this.f23299s, this.f23300t, this.f23301u, this.f23302v);
    }
}

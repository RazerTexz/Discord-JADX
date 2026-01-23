package p507d0.p513e0.p514p.p515d.p517m0.p518b;

import java.util.ServiceLoader;
import kotlin.Lazy;
import kotlin.jvm.functions.Function0;
import p507d0.Lazy5;
import p507d0.LazyJVM;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.ModuleDescriptor2;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.PackageFragmentProvider;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p523h1.AdditionalClassPartsProvider;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p523h1.ClassDescriptorFactory;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p523h1.PlatformDependentDeclarationFilter;
import p507d0.p513e0.p514p.p515d.p517m0.p566m.StorageManager;
import p507d0.p580t._Collections;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;

/* JADX INFO: renamed from: d0.e0.p.d.m0.b.a, reason: use source file name */
/* JADX INFO: compiled from: BuiltInsLoader.kt */
/* JADX INFO: loaded from: classes3.dex */
public interface BuiltInsLoader {

    /* JADX INFO: renamed from: a */
    public static final a f22451a = a.f22452a;

    /* JADX INFO: renamed from: d0.e0.p.d.m0.b.a$a */
    /* JADX INFO: compiled from: BuiltInsLoader.kt */
    public static final class a {

        /* JADX INFO: renamed from: a */
        public static final /* synthetic */ a f22452a = new a();

        /* JADX INFO: renamed from: b */
        public static final Lazy<BuiltInsLoader> f22453b = LazyJVM.lazy(Lazy5.PUBLICATION, C13304a.f22454j);

        /* JADX INFO: renamed from: d0.e0.p.d.m0.b.a$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: BuiltInsLoader.kt */
        public static final class C13304a extends Lambda implements Function0<BuiltInsLoader> {

            /* JADX INFO: renamed from: j */
            public static final C13304a f22454j = new C13304a();

            public C13304a() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ BuiltInsLoader invoke() {
                return invoke();
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final BuiltInsLoader invoke() {
                ServiceLoader serviceLoaderLoad = ServiceLoader.load(BuiltInsLoader.class, BuiltInsLoader.class.getClassLoader());
                Intrinsics3.checkNotNullExpressionValue(serviceLoaderLoad, "implementations");
                BuiltInsLoader builtInsLoader = (BuiltInsLoader) _Collections.firstOrNull(serviceLoaderLoad);
                if (builtInsLoader != null) {
                    return builtInsLoader;
                }
                throw new IllegalStateException("No BuiltInsLoader implementation was found. Please ensure that the META-INF/services/ is not stripped from your application and that the Java virtual machine is not running under a security manager");
            }
        }

        public final BuiltInsLoader getInstance() {
            return f22453b.getValue();
        }
    }

    PackageFragmentProvider createPackageFragmentProvider(StorageManager storageManager, ModuleDescriptor2 moduleDescriptor2, Iterable<? extends ClassDescriptorFactory> iterable, PlatformDependentDeclarationFilter platformDependentDeclarationFilter, AdditionalClassPartsProvider additionalClassPartsProvider, boolean z2);
}

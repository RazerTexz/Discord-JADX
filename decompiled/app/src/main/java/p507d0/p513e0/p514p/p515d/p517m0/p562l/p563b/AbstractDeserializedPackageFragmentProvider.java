package p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b;

import java.io.InputStream;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import kotlin.jvm.functions.Function1;
import p507d0.p513e0.p514p.p515d.p517m0.p518b.p520q.JvmBuiltInsPackageFragmentProvider;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.ModuleDescriptor2;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.PackageFragmentDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.PackageFragmentProvider3;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.FqName;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.Name;
import p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b.p564d0.BuiltInsPackageFragmentImpl;
import p507d0.p513e0.p514p.p515d.p517m0.p566m.StorageManager;
import p507d0.p513e0.p514p.p515d.p517m0.p566m.storage4;
import p507d0.p513e0.p514p.p515d.p517m0.p576p.collections;
import p507d0.p580t.Collections2;
import p507d0.p580t.Sets5;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;

/* JADX INFO: renamed from: d0.e0.p.d.m0.l.b.a, reason: use source file name */
/* JADX INFO: compiled from: AbstractDeserializedPackageFragmentProvider.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractDeserializedPackageFragmentProvider implements PackageFragmentProvider3 {

    /* JADX INFO: renamed from: a */
    public final StorageManager f24490a;

    /* JADX INFO: renamed from: b */
    public final KotlinMetadataFinder f24491b;

    /* JADX INFO: renamed from: c */
    public final ModuleDescriptor2 f24492c;

    /* JADX INFO: renamed from: d */
    public context5 f24493d;

    /* JADX INFO: renamed from: e */
    public final storage4<FqName, PackageFragmentDescriptor> f24494e;

    /* JADX INFO: renamed from: d0.e0.p.d.m0.l.b.a$a */
    /* JADX INFO: compiled from: AbstractDeserializedPackageFragmentProvider.kt */
    public static final class a extends Lambda implements Function1<FqName, PackageFragmentDescriptor> {
        public a() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ PackageFragmentDescriptor invoke(FqName fqName) {
            return invoke2(fqName);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final PackageFragmentDescriptor invoke2(FqName fqName) {
            Intrinsics3.checkNotNullParameter(fqName, "fqName");
            JvmBuiltInsPackageFragmentProvider jvmBuiltInsPackageFragmentProvider = (JvmBuiltInsPackageFragmentProvider) AbstractDeserializedPackageFragmentProvider.this;
            Objects.requireNonNull(jvmBuiltInsPackageFragmentProvider);
            Intrinsics3.checkNotNullParameter(fqName, "fqName");
            InputStream inputStreamFindBuiltInsData = jvmBuiltInsPackageFragmentProvider.f24491b.findBuiltInsData(fqName);
            BuiltInsPackageFragmentImpl builtInsPackageFragmentImplCreate = inputStreamFindBuiltInsData == null ? null : BuiltInsPackageFragmentImpl.f24517v.create(fqName, jvmBuiltInsPackageFragmentProvider.f24490a, jvmBuiltInsPackageFragmentProvider.f24492c, inputStreamFindBuiltInsData, false);
            if (builtInsPackageFragmentImplCreate == null) {
                return null;
            }
            context5 context5Var = AbstractDeserializedPackageFragmentProvider.this.f24493d;
            if (context5Var != null) {
                builtInsPackageFragmentImplCreate.initialize(context5Var);
                return builtInsPackageFragmentImplCreate;
            }
            Intrinsics3.throwUninitializedPropertyAccessException("components");
            throw null;
        }
    }

    public AbstractDeserializedPackageFragmentProvider(StorageManager storageManager, KotlinMetadataFinder kotlinMetadataFinder, ModuleDescriptor2 moduleDescriptor2) {
        Intrinsics3.checkNotNullParameter(storageManager, "storageManager");
        Intrinsics3.checkNotNullParameter(kotlinMetadataFinder, "finder");
        Intrinsics3.checkNotNullParameter(moduleDescriptor2, "moduleDescriptor");
        this.f24490a = storageManager;
        this.f24491b = kotlinMetadataFinder;
        this.f24492c = moduleDescriptor2;
        this.f24494e = storageManager.createMemoizedFunctionWithNullableValues(new a());
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.PackageFragmentProvider3
    public void collectPackageFragments(FqName fqName, Collection<PackageFragmentDescriptor> collection) {
        Intrinsics3.checkNotNullParameter(fqName, "fqName");
        Intrinsics3.checkNotNullParameter(collection, "packageFragments");
        collections.addIfNotNull(collection, this.f24494e.invoke(fqName));
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.PackageFragmentProvider
    public List<PackageFragmentDescriptor> getPackageFragments(FqName fqName) {
        Intrinsics3.checkNotNullParameter(fqName, "fqName");
        return Collections2.listOfNotNull(this.f24494e.invoke(fqName));
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.PackageFragmentProvider
    public Collection<FqName> getSubPackagesOf(FqName fqName, Function1<? super Name, Boolean> function1) {
        Intrinsics3.checkNotNullParameter(fqName, "fqName");
        Intrinsics3.checkNotNullParameter(function1, "nameFilter");
        return Sets5.emptySet();
    }
}

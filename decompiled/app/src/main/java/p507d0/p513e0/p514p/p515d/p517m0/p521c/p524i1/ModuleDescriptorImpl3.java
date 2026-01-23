package p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.jvm.internal.impl.descriptors.InvalidModuleException;
import p007b.p100d.p104b.p105a.outline;
import p507d0.LazyJVM;
import p507d0.p513e0.p514p.p515d.p517m0.p518b.KotlinBuiltIns;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.DeclarationDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.DeclarationDescriptorVisitor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.ModuleCapability;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.ModuleDescriptor2;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.PackageFragmentProvider;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.PackageViewDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1.Annotations4;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.FqName;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.Name;
import p507d0.p513e0.p514p.p515d.p517m0.p549h.TargetPlatform;
import p507d0.p513e0.p514p.p515d.p517m0.p566m.LockBasedStorageManager;
import p507d0.p513e0.p514p.p515d.p517m0.p566m.StorageManager;
import p507d0.p513e0.p514p.p515d.p517m0.p566m.storage3;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.p568l1.KotlinTypeRefiner2;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.p568l1.KotlinTypeRefiner3;
import p507d0.p580t.Collections2;
import p507d0.p580t.Iterables2;
import p507d0.p580t.Maps6;
import p507d0.p580t.Sets5;
import p507d0.p580t._Arrays;
import p507d0.p580t._Collections;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;

/* JADX INFO: renamed from: d0.e0.p.d.m0.c.i1.y, reason: use source file name */
/* JADX INFO: compiled from: ModuleDescriptorImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class ModuleDescriptorImpl3 extends DeclarationDescriptorImpl implements ModuleDescriptor2 {

    /* JADX INFO: renamed from: l */
    public final StorageManager f22990l;

    /* JADX INFO: renamed from: m */
    public final KotlinBuiltIns f22991m;

    /* JADX INFO: renamed from: n */
    public final Map<ModuleCapability<?>, Object> f22992n;

    /* JADX INFO: renamed from: o */
    public ModuleDescriptorImpl f22993o;

    /* JADX INFO: renamed from: p */
    public PackageFragmentProvider f22994p;

    /* JADX INFO: renamed from: q */
    public boolean f22995q;

    /* JADX INFO: renamed from: r */
    public final storage3<FqName, PackageViewDescriptor> f22996r;

    /* JADX INFO: renamed from: s */
    public final Lazy f22997s;

    /* JADX INFO: renamed from: d0.e0.p.d.m0.c.i1.y$a */
    /* JADX INFO: compiled from: ModuleDescriptorImpl.kt */
    public static final class a extends Lambda implements Function0<CompositePackageFragmentProvider> {
        public a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ CompositePackageFragmentProvider invoke() {
            return invoke();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final CompositePackageFragmentProvider invoke() {
            ModuleDescriptorImpl moduleDescriptorImplAccess$getDependencies$p = ModuleDescriptorImpl3.access$getDependencies$p(ModuleDescriptorImpl3.this);
            ModuleDescriptorImpl3 moduleDescriptorImpl3 = ModuleDescriptorImpl3.this;
            if (moduleDescriptorImplAccess$getDependencies$p == null) {
                StringBuilder sbM833U = outline.m833U("Dependencies of module ");
                sbM833U.append(ModuleDescriptorImpl3.access$getId(moduleDescriptorImpl3));
                sbM833U.append(" were not set before querying module content");
                throw new AssertionError(sbM833U.toString());
            }
            List<ModuleDescriptorImpl3> allDependencies = moduleDescriptorImplAccess$getDependencies$p.getAllDependencies();
            allDependencies.contains(ModuleDescriptorImpl3.this);
            Iterator<T> it = allDependencies.iterator();
            while (it.hasNext()) {
                ModuleDescriptorImpl3.access$isInitialized((ModuleDescriptorImpl3) it.next());
            }
            ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(allDependencies, 10));
            Iterator<T> it2 = allDependencies.iterator();
            while (it2.hasNext()) {
                PackageFragmentProvider packageFragmentProviderAccess$getPackageFragmentProviderForModuleContent$p = ModuleDescriptorImpl3.access$getPackageFragmentProviderForModuleContent$p((ModuleDescriptorImpl3) it2.next());
                Intrinsics3.checkNotNull(packageFragmentProviderAccess$getPackageFragmentProviderForModuleContent$p);
                arrayList.add(packageFragmentProviderAccess$getPackageFragmentProviderForModuleContent$p);
            }
            return new CompositePackageFragmentProvider(arrayList);
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.c.i1.y$b */
    /* JADX INFO: compiled from: ModuleDescriptorImpl.kt */
    public static final class b extends Lambda implements Function1<FqName, PackageViewDescriptor> {
        public b() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ PackageViewDescriptor invoke(FqName fqName) {
            return invoke2(fqName);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final PackageViewDescriptor invoke2(FqName fqName) {
            Intrinsics3.checkNotNullParameter(fqName, "fqName");
            ModuleDescriptorImpl3 moduleDescriptorImpl3 = ModuleDescriptorImpl3.this;
            return new LazyPackageViewDescriptorImpl(moduleDescriptorImpl3, fqName, ModuleDescriptorImpl3.access$getStorageManager$p(moduleDescriptorImpl3));
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ModuleDescriptorImpl3(Name name, StorageManager storageManager, KotlinBuiltIns kotlinBuiltIns, TargetPlatform targetPlatform) {
        this(name, storageManager, kotlinBuiltIns, targetPlatform, null, null, 48, null);
        Intrinsics3.checkNotNullParameter(name, "moduleName");
        Intrinsics3.checkNotNullParameter(storageManager, "storageManager");
        Intrinsics3.checkNotNullParameter(kotlinBuiltIns, "builtIns");
    }

    public /* synthetic */ ModuleDescriptorImpl3(Name name, StorageManager storageManager, KotlinBuiltIns kotlinBuiltIns, TargetPlatform targetPlatform, Map map, Name name2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(name, storageManager, kotlinBuiltIns, (i & 8) != 0 ? null : targetPlatform, (i & 16) != 0 ? Maps6.emptyMap() : map, (i & 32) != 0 ? null : name2);
    }

    public static final /* synthetic */ ModuleDescriptorImpl access$getDependencies$p(ModuleDescriptorImpl3 moduleDescriptorImpl3) {
        return moduleDescriptorImpl3.f22993o;
    }

    public static final /* synthetic */ String access$getId(ModuleDescriptorImpl3 moduleDescriptorImpl3) {
        return moduleDescriptorImpl3.m9430b();
    }

    public static final /* synthetic */ PackageFragmentProvider access$getPackageFragmentProviderForModuleContent$p(ModuleDescriptorImpl3 moduleDescriptorImpl3) {
        return moduleDescriptorImpl3.f22994p;
    }

    public static final /* synthetic */ StorageManager access$getStorageManager$p(ModuleDescriptorImpl3 moduleDescriptorImpl3) {
        return moduleDescriptorImpl3.f22990l;
    }

    public static final boolean access$isInitialized(ModuleDescriptorImpl3 moduleDescriptorImpl3) {
        return moduleDescriptorImpl3.f22994p != null;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.DeclarationDescriptor
    public <R, D> R accept(DeclarationDescriptorVisitor<R, D> declarationDescriptorVisitor, D d) {
        return (R) ModuleDescriptor2.a.accept(this, declarationDescriptorVisitor, d);
    }

    public void assertValid() {
        if (!isValid()) {
            throw new InvalidModuleException(Intrinsics3.stringPlus("Accessing invalid module descriptor ", this));
        }
    }

    /* JADX INFO: renamed from: b */
    public final String m9430b() {
        String string = getName().toString();
        Intrinsics3.checkNotNullExpressionValue(string, "name.toString()");
        return string;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.ModuleDescriptor2
    public KotlinBuiltIns getBuiltIns() {
        return this.f22991m;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.ModuleDescriptor2
    public <T> T getCapability(ModuleCapability<T> moduleCapability) {
        Intrinsics3.checkNotNullParameter(moduleCapability, "capability");
        return (T) this.f22992n.get(moduleCapability);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.DeclarationDescriptor
    public DeclarationDescriptor getContainingDeclaration() {
        return ModuleDescriptor2.a.getContainingDeclaration(this);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.ModuleDescriptor2
    public List<ModuleDescriptor2> getExpectedByModules() {
        ModuleDescriptorImpl moduleDescriptorImpl = this.f22993o;
        if (moduleDescriptorImpl != null) {
            return moduleDescriptorImpl.getDirectExpectedByDependencies();
        }
        StringBuilder sbM833U = outline.m833U("Dependencies of module ");
        sbM833U.append(m9430b());
        sbM833U.append(" were not set");
        throw new AssertionError(sbM833U.toString());
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.ModuleDescriptor2
    public PackageViewDescriptor getPackage(FqName fqName) {
        Intrinsics3.checkNotNullParameter(fqName, "fqName");
        assertValid();
        return (PackageViewDescriptor) ((LockBasedStorageManager.m) this.f22996r).invoke(fqName);
    }

    public final PackageFragmentProvider getPackageFragmentProvider() {
        assertValid();
        return (CompositePackageFragmentProvider) this.f22997s.getValue();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.ModuleDescriptor2
    public Collection<FqName> getSubPackagesOf(FqName fqName, Function1<? super Name, Boolean> function1) {
        Intrinsics3.checkNotNullParameter(fqName, "fqName");
        Intrinsics3.checkNotNullParameter(function1, "nameFilter");
        assertValid();
        return getPackageFragmentProvider().getSubPackagesOf(fqName, function1);
    }

    public final void initialize(PackageFragmentProvider packageFragmentProvider) {
        Intrinsics3.checkNotNullParameter(packageFragmentProvider, "providerForModuleContent");
        this.f22994p = packageFragmentProvider;
    }

    public boolean isValid() {
        return this.f22995q;
    }

    public final void setDependencies(ModuleDescriptorImpl moduleDescriptorImpl) {
        Intrinsics3.checkNotNullParameter(moduleDescriptorImpl, "dependencies");
        ModuleDescriptorImpl moduleDescriptorImpl2 = this.f22993o;
        this.f22993o = moduleDescriptorImpl;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.ModuleDescriptor2
    public boolean shouldSeeInternalsOf(ModuleDescriptor2 moduleDescriptor2) {
        Intrinsics3.checkNotNullParameter(moduleDescriptor2, "targetModule");
        if (Intrinsics3.areEqual(this, moduleDescriptor2)) {
            return true;
        }
        ModuleDescriptorImpl moduleDescriptorImpl = this.f22993o;
        Intrinsics3.checkNotNull(moduleDescriptorImpl);
        return _Collections.contains(moduleDescriptorImpl.getModulesWhoseInternalsAreVisible(), moduleDescriptor2) || getExpectedByModules().contains(moduleDescriptor2) || moduleDescriptor2.getExpectedByModules().contains(this);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ModuleDescriptorImpl3(Name name, StorageManager storageManager, KotlinBuiltIns kotlinBuiltIns, TargetPlatform targetPlatform, Map<ModuleCapability<?>, ? extends Object> map, Name name2) {
        super(Annotations4.f22735f.getEMPTY(), name);
        Intrinsics3.checkNotNullParameter(name, "moduleName");
        Intrinsics3.checkNotNullParameter(storageManager, "storageManager");
        Intrinsics3.checkNotNullParameter(kotlinBuiltIns, "builtIns");
        Intrinsics3.checkNotNullParameter(map, "capabilities");
        this.f22990l = storageManager;
        this.f22991m = kotlinBuiltIns;
        if (name.isSpecial()) {
            Map<ModuleCapability<?>, Object> mutableMap = Maps6.toMutableMap(map);
            this.f22992n = mutableMap;
            mutableMap.put(KotlinTypeRefiner2.getREFINER_CAPABILITY(), new KotlinTypeRefiner3(null));
            this.f22995q = true;
            this.f22996r = storageManager.createMemoizedFunction(new b());
            this.f22997s = LazyJVM.lazy(new a());
            return;
        }
        throw new IllegalArgumentException(Intrinsics3.stringPlus("Module name must be special: ", name));
    }

    public final void setDependencies(ModuleDescriptorImpl3... moduleDescriptorImpl3Arr) {
        Intrinsics3.checkNotNullParameter(moduleDescriptorImpl3Arr, "descriptors");
        setDependencies(_Arrays.toList(moduleDescriptorImpl3Arr));
    }

    public final void setDependencies(List<ModuleDescriptorImpl3> list) {
        Intrinsics3.checkNotNullParameter(list, "descriptors");
        setDependencies(list, Sets5.emptySet());
    }

    public final void setDependencies(List<ModuleDescriptorImpl3> list, Set<ModuleDescriptorImpl3> set) {
        Intrinsics3.checkNotNullParameter(list, "descriptors");
        Intrinsics3.checkNotNullParameter(set, "friends");
        setDependencies(new ModuleDescriptorImpl2(list, set, Collections2.emptyList(), Sets5.emptySet()));
    }
}

package p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.functions.Function0;
import kotlin.reflect.KProperty;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.DeclarationDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.DeclarationDescriptorVisitor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.ModuleDescriptor2;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.PackageFragmentDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.PackageFragmentProvider2;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.PackageViewDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1.Annotations4;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.FqName;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.ChainedMemberScope;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.LazyScopeAdapter;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.MemberScope3;
import p507d0.p513e0.p514p.p515d.p517m0.p566m.StorageManager;
import p507d0.p513e0.p514p.p515d.p517m0.p566m.storage5;
import p507d0.p513e0.p514p.p515d.p517m0.p566m.storage7;
import p507d0.p580t.Iterables2;
import p507d0.p580t._Collections;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;
import p507d0.p592z.p594d.PropertyReference1Impl;
import p507d0.p592z.p594d.Reflection2;

/* compiled from: LazyPackageViewDescriptorImpl.kt */
/* renamed from: d0.e0.p.d.m0.c.i1.s, reason: use source file name */
/* loaded from: classes3.dex */
public final class LazyPackageViewDescriptorImpl extends DeclarationDescriptorImpl implements PackageViewDescriptor {

    /* renamed from: l */
    public static final /* synthetic */ KProperty<Object>[] f22975l = {Reflection2.property1(new PropertyReference1Impl(Reflection2.getOrCreateKotlinClass(LazyPackageViewDescriptorImpl.class), "fragments", "getFragments()Ljava/util/List;"))};

    /* renamed from: m */
    public final ModuleDescriptorImpl3 f22976m;

    /* renamed from: n */
    public final FqName f22977n;

    /* renamed from: o */
    public final storage5 f22978o;

    /* renamed from: p */
    public final MemberScope3 f22979p;

    /* compiled from: LazyPackageViewDescriptorImpl.kt */
    /* renamed from: d0.e0.p.d.m0.c.i1.s$a */
    public static final class a extends Lambda implements Function0<List<? extends PackageFragmentDescriptor>> {
        public a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ List<? extends PackageFragmentDescriptor> invoke() {
            return invoke2();
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final List<? extends PackageFragmentDescriptor> invoke2() {
            return PackageFragmentProvider2.packageFragments(LazyPackageViewDescriptorImpl.this.getModule().getPackageFragmentProvider(), LazyPackageViewDescriptorImpl.this.getFqName());
        }
    }

    /* compiled from: LazyPackageViewDescriptorImpl.kt */
    /* renamed from: d0.e0.p.d.m0.c.i1.s$b */
    public static final class b extends Lambda implements Function0<MemberScope3> {
        public b() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ MemberScope3 invoke() {
            return invoke();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final MemberScope3 invoke() {
            if (LazyPackageViewDescriptorImpl.this.getFragments().isEmpty()) {
                return MemberScope3.b.f24373b;
            }
            List<PackageFragmentDescriptor> fragments = LazyPackageViewDescriptorImpl.this.getFragments();
            ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(fragments, 10));
            Iterator<T> it = fragments.iterator();
            while (it.hasNext()) {
                arrayList.add(((PackageFragmentDescriptor) it.next()).getMemberScope());
            }
            List listPlus = _Collections.plus((Collection<? extends SubpackagesScope>) arrayList, new SubpackagesScope(LazyPackageViewDescriptorImpl.this.getModule(), LazyPackageViewDescriptorImpl.this.getFqName()));
            ChainedMemberScope.a aVar = ChainedMemberScope.f24333b;
            StringBuilder sbM833U = outline.m833U("package view scope for ");
            sbM833U.append(LazyPackageViewDescriptorImpl.this.getFqName());
            sbM833U.append(" in ");
            sbM833U.append(LazyPackageViewDescriptorImpl.this.getModule().getName());
            return aVar.create(sbM833U.toString(), listPlus);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LazyPackageViewDescriptorImpl(ModuleDescriptorImpl3 moduleDescriptorImpl3, FqName fqName, StorageManager storageManager) {
        super(Annotations4.f22735f.getEMPTY(), fqName.shortNameOrSpecial());
        Intrinsics3.checkNotNullParameter(moduleDescriptorImpl3, "module");
        Intrinsics3.checkNotNullParameter(fqName, "fqName");
        Intrinsics3.checkNotNullParameter(storageManager, "storageManager");
        this.f22976m = moduleDescriptorImpl3;
        this.f22977n = fqName;
        this.f22978o = storageManager.createLazyValue(new a());
        this.f22979p = new LazyScopeAdapter(storageManager, new b());
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.DeclarationDescriptor
    public <R, D> R accept(DeclarationDescriptorVisitor<R, D> declarationDescriptorVisitor, D d) {
        Intrinsics3.checkNotNullParameter(declarationDescriptorVisitor, "visitor");
        return declarationDescriptorVisitor.visitPackageViewDescriptor(this, d);
    }

    public boolean equals(Object obj) {
        PackageViewDescriptor packageViewDescriptor = obj instanceof PackageViewDescriptor ? (PackageViewDescriptor) obj : null;
        return packageViewDescriptor != null && Intrinsics3.areEqual(getFqName(), packageViewDescriptor.getFqName()) && Intrinsics3.areEqual(getModule(), packageViewDescriptor.getModule());
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.DeclarationDescriptor
    public /* bridge */ /* synthetic */ DeclarationDescriptor getContainingDeclaration() {
        return getContainingDeclaration();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.PackageViewDescriptor
    public FqName getFqName() {
        return this.f22977n;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.PackageViewDescriptor
    public List<PackageFragmentDescriptor> getFragments() {
        return (List) storage7.getValue(this.f22978o, this, (KProperty<?>) f22975l[0]);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.PackageViewDescriptor
    public MemberScope3 getMemberScope() {
        return this.f22979p;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.PackageViewDescriptor
    public /* bridge */ /* synthetic */ ModuleDescriptor2 getModule() {
        return getModule();
    }

    public int hashCode() {
        return getFqName().hashCode() + (getModule().hashCode() * 31);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.PackageViewDescriptor
    public boolean isEmpty() {
        return PackageViewDescriptor.a.isEmpty(this);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.DeclarationDescriptor
    public PackageViewDescriptor getContainingDeclaration() {
        if (getFqName().isRoot()) {
            return null;
        }
        ModuleDescriptorImpl3 module = getModule();
        FqName fqNameParent = getFqName().parent();
        Intrinsics3.checkNotNullExpressionValue(fqNameParent, "fqName.parent()");
        return module.getPackage(fqNameParent);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.PackageViewDescriptor
    public ModuleDescriptorImpl3 getModule() {
        return this.f22976m;
    }
}

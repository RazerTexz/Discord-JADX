package p507d0.p513e0.p514p.p515d.p517m0.p521c;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.jvm.functions.Function1;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.FqName;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.Name;
import p507d0.p578f0._Sequences2;
import p507d0.p580t._Collections;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;

/* compiled from: PackageFragmentProviderImpl.kt */
/* renamed from: d0.e0.p.d.m0.c.g0, reason: use source file name */
/* loaded from: classes3.dex */
public final class PackageFragmentProviderImpl implements PackageFragmentProvider3 {

    /* renamed from: a */
    public final Collection<PackageFragmentDescriptor> f22714a;

    /* compiled from: PackageFragmentProviderImpl.kt */
    /* renamed from: d0.e0.p.d.m0.c.g0$a */
    public static final class a extends Lambda implements Function1<PackageFragmentDescriptor, FqName> {

        /* renamed from: j */
        public static final a f22715j = new a();

        public a() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ FqName invoke(PackageFragmentDescriptor packageFragmentDescriptor) {
            return invoke2(packageFragmentDescriptor);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final FqName invoke2(PackageFragmentDescriptor packageFragmentDescriptor) {
            Intrinsics3.checkNotNullParameter(packageFragmentDescriptor, "it");
            return packageFragmentDescriptor.getFqName();
        }
    }

    /* compiled from: PackageFragmentProviderImpl.kt */
    /* renamed from: d0.e0.p.d.m0.c.g0$b */
    public static final class b extends Lambda implements Function1<FqName, Boolean> {
        public final /* synthetic */ FqName $fqName;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(FqName fqName) {
            super(1);
            this.$fqName = fqName;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Boolean invoke(FqName fqName) {
            return Boolean.valueOf(invoke2(fqName));
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final boolean invoke2(FqName fqName) {
            Intrinsics3.checkNotNullParameter(fqName, "it");
            return !fqName.isRoot() && Intrinsics3.areEqual(fqName.parent(), this.$fqName);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public PackageFragmentProviderImpl(Collection<? extends PackageFragmentDescriptor> collection) {
        Intrinsics3.checkNotNullParameter(collection, "packageFragments");
        this.f22714a = collection;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.PackageFragmentProvider3
    public void collectPackageFragments(FqName fqName, Collection<PackageFragmentDescriptor> collection) {
        Intrinsics3.checkNotNullParameter(fqName, "fqName");
        Intrinsics3.checkNotNullParameter(collection, "packageFragments");
        for (Object obj : this.f22714a) {
            if (Intrinsics3.areEqual(((PackageFragmentDescriptor) obj).getFqName(), fqName)) {
                collection.add(obj);
            }
        }
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.PackageFragmentProvider
    public List<PackageFragmentDescriptor> getPackageFragments(FqName fqName) {
        Intrinsics3.checkNotNullParameter(fqName, "fqName");
        Collection<PackageFragmentDescriptor> collection = this.f22714a;
        ArrayList arrayList = new ArrayList();
        for (Object obj : collection) {
            if (Intrinsics3.areEqual(((PackageFragmentDescriptor) obj).getFqName(), fqName)) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.PackageFragmentProvider
    public Collection<FqName> getSubPackagesOf(FqName fqName, Function1<? super Name, Boolean> function1) {
        Intrinsics3.checkNotNullParameter(fqName, "fqName");
        Intrinsics3.checkNotNullParameter(function1, "nameFilter");
        return _Sequences2.toList(_Sequences2.filter(_Sequences2.map(_Collections.asSequence(this.f22714a), a.f22715j), new b(fqName)));
    }
}

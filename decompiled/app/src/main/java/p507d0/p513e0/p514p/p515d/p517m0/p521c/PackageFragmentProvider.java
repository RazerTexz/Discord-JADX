package p507d0.p513e0.p514p.p515d.p517m0.p521c;

import java.util.Collection;
import java.util.List;
import kotlin.jvm.functions.Function1;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.FqName;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.Name;

/* compiled from: PackageFragmentProvider.kt */
/* renamed from: d0.e0.p.d.m0.c.f0, reason: use source file name */
/* loaded from: classes3.dex */
public interface PackageFragmentProvider {
    List<PackageFragmentDescriptor> getPackageFragments(FqName fqName);

    Collection<FqName> getSubPackagesOf(FqName fqName, Function1<? super Name, Boolean> function1);
}

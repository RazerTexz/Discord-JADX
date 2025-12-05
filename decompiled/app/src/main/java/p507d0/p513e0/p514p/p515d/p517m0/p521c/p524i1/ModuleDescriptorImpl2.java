package p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1;

import java.util.List;
import java.util.Set;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: ModuleDescriptorImpl.kt */
/* renamed from: d0.e0.p.d.m0.c.i1.x, reason: use source file name */
/* loaded from: classes3.dex */
public final class ModuleDescriptorImpl2 implements ModuleDescriptorImpl {

    /* renamed from: a */
    public final List<ModuleDescriptorImpl3> f22987a;

    /* renamed from: b */
    public final Set<ModuleDescriptorImpl3> f22988b;

    /* renamed from: c */
    public final List<ModuleDescriptorImpl3> f22989c;

    public ModuleDescriptorImpl2(List<ModuleDescriptorImpl3> list, Set<ModuleDescriptorImpl3> set, List<ModuleDescriptorImpl3> list2, Set<ModuleDescriptorImpl3> set2) {
        Intrinsics3.checkNotNullParameter(list, "allDependencies");
        Intrinsics3.checkNotNullParameter(set, "modulesWhoseInternalsAreVisible");
        Intrinsics3.checkNotNullParameter(list2, "directExpectedByDependencies");
        Intrinsics3.checkNotNullParameter(set2, "allExpectedByDependencies");
        this.f22987a = list;
        this.f22988b = set;
        this.f22989c = list2;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1.ModuleDescriptorImpl
    public List<ModuleDescriptorImpl3> getAllDependencies() {
        return this.f22987a;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1.ModuleDescriptorImpl
    public List<ModuleDescriptorImpl3> getDirectExpectedByDependencies() {
        return this.f22989c;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1.ModuleDescriptorImpl
    public Set<ModuleDescriptorImpl3> getModulesWhoseInternalsAreVisible() {
        return this.f22988b;
    }
}

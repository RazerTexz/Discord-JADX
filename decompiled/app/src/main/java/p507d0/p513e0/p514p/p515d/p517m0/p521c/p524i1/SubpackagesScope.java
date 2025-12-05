package p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1;

import com.discord.models.domain.ModelAuditLogEntry;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import kotlin.jvm.functions.Function1;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.DeclarationDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.ModuleDescriptor2;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.PackageViewDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.FqName;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.Name;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.MemberScope;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.MemberScope2;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.MemberScopeImpl;
import p507d0.p513e0.p514p.p515d.p517m0.p576p.collections;
import p507d0.p580t.Collections2;
import p507d0.p580t.Sets5;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: SubpackagesScope.kt */
/* renamed from: d0.e0.p.d.m0.c.i1.h0, reason: use source file name */
/* loaded from: classes3.dex */
public class SubpackagesScope extends MemberScopeImpl {

    /* renamed from: b */
    public final ModuleDescriptor2 f22878b;

    /* renamed from: c */
    public final FqName f22879c;

    public SubpackagesScope(ModuleDescriptor2 moduleDescriptor2, FqName fqName) {
        Intrinsics3.checkNotNullParameter(moduleDescriptor2, "moduleDescriptor");
        Intrinsics3.checkNotNullParameter(fqName, "fqName");
        this.f22878b = moduleDescriptor2;
        this.f22879c = fqName;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.MemberScopeImpl, p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.MemberScope3
    public Set<Name> getClassifierNames() {
        return Sets5.emptySet();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.MemberScopeImpl, p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.ResolutionScope
    public Collection<DeclarationDescriptor> getContributedDescriptors(MemberScope2 memberScope2, Function1<? super Name, Boolean> function1) {
        Intrinsics3.checkNotNullParameter(memberScope2, "kindFilter");
        Intrinsics3.checkNotNullParameter(function1, "nameFilter");
        if (!memberScope2.acceptsKinds(MemberScope2.f24339a.getPACKAGES_MASK())) {
            return Collections2.emptyList();
        }
        if (this.f22879c.isRoot() && memberScope2.getExcludes().contains(MemberScope.b.f24338a)) {
            return Collections2.emptyList();
        }
        Collection<FqName> subPackagesOf = this.f22878b.getSubPackagesOf(this.f22879c, function1);
        ArrayList arrayList = new ArrayList(subPackagesOf.size());
        Iterator<FqName> it = subPackagesOf.iterator();
        while (it.hasNext()) {
            Name nameShortName = it.next().shortName();
            Intrinsics3.checkNotNullExpressionValue(nameShortName, "subFqName.shortName()");
            if (function1.invoke(nameShortName).booleanValue()) {
                Intrinsics3.checkNotNullParameter(nameShortName, ModelAuditLogEntry.CHANGE_KEY_NAME);
                PackageViewDescriptor packageViewDescriptor = null;
                if (!nameShortName.isSpecial()) {
                    ModuleDescriptor2 moduleDescriptor2 = this.f22878b;
                    FqName fqNameChild = this.f22879c.child(nameShortName);
                    Intrinsics3.checkNotNullExpressionValue(fqNameChild, "fqName.child(name)");
                    PackageViewDescriptor packageViewDescriptor2 = moduleDescriptor2.getPackage(fqNameChild);
                    if (!packageViewDescriptor2.isEmpty()) {
                        packageViewDescriptor = packageViewDescriptor2;
                    }
                }
                collections.addIfNotNull(arrayList, packageViewDescriptor);
            }
        }
        return arrayList;
    }
}

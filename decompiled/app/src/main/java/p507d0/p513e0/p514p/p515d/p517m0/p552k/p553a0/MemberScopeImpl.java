package p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0;

import com.discord.models.domain.ModelAuditLogEntry;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.jvm.functions.Function1;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.ClassifierDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.DeclarationDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.PropertyDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.SimpleFunctionDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p529d.p530b.LookupLocation2;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.Name;
import p507d0.p513e0.p514p.p515d.p517m0.p576p.functions;
import p507d0.p580t.Collections2;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: renamed from: d0.e0.p.d.m0.k.a0.j, reason: use source file name */
/* JADX INFO: compiled from: MemberScopeImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class MemberScopeImpl implements MemberScope3 {
    @Override // p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.MemberScope3
    public Set<Name> getClassifierNames() {
        return null;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.ResolutionScope
    public ClassifierDescriptor getContributedClassifier(Name name, LookupLocation2 lookupLocation2) {
        Intrinsics3.checkNotNullParameter(name, ModelAuditLogEntry.CHANGE_KEY_NAME);
        Intrinsics3.checkNotNullParameter(lookupLocation2, ModelAuditLogEntry.CHANGE_KEY_LOCATION);
        return null;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.ResolutionScope
    public Collection<DeclarationDescriptor> getContributedDescriptors(MemberScope2 memberScope2, Function1<? super Name, Boolean> function1) {
        Intrinsics3.checkNotNullParameter(memberScope2, "kindFilter");
        Intrinsics3.checkNotNullParameter(function1, "nameFilter");
        return Collections2.emptyList();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.MemberScope3
    public Collection<? extends SimpleFunctionDescriptor> getContributedFunctions(Name name, LookupLocation2 lookupLocation2) {
        Intrinsics3.checkNotNullParameter(name, ModelAuditLogEntry.CHANGE_KEY_NAME);
        Intrinsics3.checkNotNullParameter(lookupLocation2, ModelAuditLogEntry.CHANGE_KEY_LOCATION);
        return Collections2.emptyList();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.MemberScope3
    public Collection<? extends PropertyDescriptor> getContributedVariables(Name name, LookupLocation2 lookupLocation2) {
        Intrinsics3.checkNotNullParameter(name, ModelAuditLogEntry.CHANGE_KEY_NAME);
        Intrinsics3.checkNotNullParameter(lookupLocation2, ModelAuditLogEntry.CHANGE_KEY_LOCATION);
        return Collections2.emptyList();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.MemberScope3
    public Set<Name> getFunctionNames() {
        Collection<DeclarationDescriptor> contributedDescriptors = getContributedDescriptors(MemberScope2.f24354p, functions.alwaysTrue());
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (Object obj : contributedDescriptors) {
            if (obj instanceof SimpleFunctionDescriptor) {
                Name name = ((SimpleFunctionDescriptor) obj).getName();
                Intrinsics3.checkNotNullExpressionValue(name, "it.name");
                linkedHashSet.add(name);
            }
        }
        return linkedHashSet;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.MemberScope3
    public Set<Name> getVariableNames() {
        Collection<DeclarationDescriptor> contributedDescriptors = getContributedDescriptors(MemberScope2.f24355q, functions.alwaysTrue());
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (Object obj : contributedDescriptors) {
            if (obj instanceof SimpleFunctionDescriptor) {
                Name name = ((SimpleFunctionDescriptor) obj).getName();
                Intrinsics3.checkNotNullExpressionValue(name, "it.name");
                linkedHashSet.add(name);
            }
        }
        return linkedHashSet;
    }
}

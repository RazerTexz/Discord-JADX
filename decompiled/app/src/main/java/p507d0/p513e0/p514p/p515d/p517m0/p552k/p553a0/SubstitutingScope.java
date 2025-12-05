package p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0;

import com.discord.models.domain.ModelAuditLogEntry;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import p507d0.LazyJVM;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.ClassifierDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.DeclarationDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.PropertyDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.SimpleFunctionDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.Substitutable;
import p507d0.p513e0.p514p.p515d.p517m0.p529d.p530b.LookupLocation2;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.Name;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.ResolutionScope;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p555u.p556a.CapturedTypeConstructor4;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.TypeSubstitution5;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.TypeSubstitutor2;
import p507d0.p513e0.p514p.p515d.p517m0.p576p.collections;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;

/* compiled from: SubstitutingScope.kt */
/* renamed from: d0.e0.p.d.m0.k.a0.n, reason: use source file name */
/* loaded from: classes3.dex */
public final class SubstitutingScope implements MemberScope3 {

    /* renamed from: b */
    public final MemberScope3 f24377b;

    /* renamed from: c */
    public final TypeSubstitutor2 f24378c;

    /* renamed from: d */
    public Map<DeclarationDescriptor, DeclarationDescriptor> f24379d;

    /* renamed from: e */
    public final Lazy f24380e;

    /* compiled from: SubstitutingScope.kt */
    /* renamed from: d0.e0.p.d.m0.k.a0.n$a */
    public static final class a extends Lambda implements Function0<Collection<? extends DeclarationDescriptor>> {
        public a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Collection<? extends DeclarationDescriptor> invoke() {
            return invoke2();
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Collection<? extends DeclarationDescriptor> invoke2() {
            SubstitutingScope substitutingScope = SubstitutingScope.this;
            return SubstitutingScope.access$substitute(substitutingScope, ResolutionScope.a.getContributedDescriptors$default(SubstitutingScope.access$getWorkerScope$p(substitutingScope), null, null, 3, null));
        }
    }

    public SubstitutingScope(MemberScope3 memberScope3, TypeSubstitutor2 typeSubstitutor2) {
        Intrinsics3.checkNotNullParameter(memberScope3, "workerScope");
        Intrinsics3.checkNotNullParameter(typeSubstitutor2, "givenSubstitutor");
        this.f24377b = memberScope3;
        TypeSubstitution5 substitution = typeSubstitutor2.getSubstitution();
        Intrinsics3.checkNotNullExpressionValue(substitution, "givenSubstitutor.substitution");
        this.f24378c = CapturedTypeConstructor4.wrapWithCapturingSubstitution$default(substitution, false, 1, null).buildSubstitutor();
        this.f24380e = LazyJVM.lazy(new a());
    }

    public static final /* synthetic */ MemberScope3 access$getWorkerScope$p(SubstitutingScope substitutingScope) {
        return substitutingScope.f24377b;
    }

    public static final /* synthetic */ Collection access$substitute(SubstitutingScope substitutingScope, Collection collection) {
        return substitutingScope.m9912a(collection);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: a */
    public final <D extends DeclarationDescriptor> Collection<D> m9912a(Collection<? extends D> collection) {
        if (this.f24378c.isEmpty() || collection.isEmpty()) {
            return collection;
        }
        LinkedHashSet linkedHashSetNewLinkedHashSetWithExpectedSize = collections.newLinkedHashSetWithExpectedSize(collection.size());
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            linkedHashSetNewLinkedHashSetWithExpectedSize.add(m9913b((DeclarationDescriptor) it.next()));
        }
        return linkedHashSetNewLinkedHashSetWithExpectedSize;
    }

    /* renamed from: b */
    public final <D extends DeclarationDescriptor> D m9913b(D d) {
        if (this.f24378c.isEmpty()) {
            return d;
        }
        if (this.f24379d == null) {
            this.f24379d = new HashMap();
        }
        Map<DeclarationDescriptor, DeclarationDescriptor> map = this.f24379d;
        Intrinsics3.checkNotNull(map);
        DeclarationDescriptor declarationDescriptorSubstitute = map.get(d);
        if (declarationDescriptorSubstitute == null) {
            if (!(d instanceof Substitutable)) {
                throw new IllegalStateException(Intrinsics3.stringPlus("Unknown descriptor in scope: ", d).toString());
            }
            declarationDescriptorSubstitute = ((Substitutable) d).substitute(this.f24378c);
            if (declarationDescriptorSubstitute == null) {
                throw new AssertionError("We expect that no conflict should happen while substitution is guaranteed to generate invariant projection, but " + d + " substitution fails");
            }
            map.put(d, declarationDescriptorSubstitute);
        }
        return (D) declarationDescriptorSubstitute;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.MemberScope3
    public Set<Name> getClassifierNames() {
        return this.f24377b.getClassifierNames();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.ResolutionScope
    public ClassifierDescriptor getContributedClassifier(Name name, LookupLocation2 lookupLocation2) {
        Intrinsics3.checkNotNullParameter(name, ModelAuditLogEntry.CHANGE_KEY_NAME);
        Intrinsics3.checkNotNullParameter(lookupLocation2, ModelAuditLogEntry.CHANGE_KEY_LOCATION);
        ClassifierDescriptor contributedClassifier = this.f24377b.getContributedClassifier(name, lookupLocation2);
        if (contributedClassifier == null) {
            return null;
        }
        return (ClassifierDescriptor) m9913b(contributedClassifier);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.ResolutionScope
    public Collection<DeclarationDescriptor> getContributedDescriptors(MemberScope2 memberScope2, Function1<? super Name, Boolean> function1) {
        Intrinsics3.checkNotNullParameter(memberScope2, "kindFilter");
        Intrinsics3.checkNotNullParameter(function1, "nameFilter");
        return (Collection) this.f24380e.getValue();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.MemberScope3
    public Collection<? extends SimpleFunctionDescriptor> getContributedFunctions(Name name, LookupLocation2 lookupLocation2) {
        Intrinsics3.checkNotNullParameter(name, ModelAuditLogEntry.CHANGE_KEY_NAME);
        Intrinsics3.checkNotNullParameter(lookupLocation2, ModelAuditLogEntry.CHANGE_KEY_LOCATION);
        return m9912a(this.f24377b.getContributedFunctions(name, lookupLocation2));
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.MemberScope3
    public Collection<? extends PropertyDescriptor> getContributedVariables(Name name, LookupLocation2 lookupLocation2) {
        Intrinsics3.checkNotNullParameter(name, ModelAuditLogEntry.CHANGE_KEY_NAME);
        Intrinsics3.checkNotNullParameter(lookupLocation2, ModelAuditLogEntry.CHANGE_KEY_LOCATION);
        return m9912a(this.f24377b.getContributedVariables(name, lookupLocation2));
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.MemberScope3
    public Set<Name> getFunctionNames() {
        return this.f24377b.getFunctionNames();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.MemberScope3
    public Set<Name> getVariableNames() {
        return this.f24377b.getVariableNames();
    }
}

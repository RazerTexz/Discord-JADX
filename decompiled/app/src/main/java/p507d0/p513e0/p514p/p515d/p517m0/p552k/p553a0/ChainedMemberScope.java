package p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0;

import com.discord.models.domain.ModelAuditLogEntry;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.ClassifierDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.ClassifierDescriptorWithTypeParameters;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.DeclarationDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.PropertyDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.SimpleFunctionDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p529d.p530b.LookupLocation2;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.Name;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.MemberScope3;
import p507d0.p513e0.p514p.p515d.p517m0.p573o.p575n.scopeUtils;
import p507d0.p513e0.p514p.p515d.p517m0.p576p.SmartList;
import p507d0.p580t.Collections2;
import p507d0.p580t.MutableCollections;
import p507d0.p580t.Sets5;
import p507d0.p580t._Arrays;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: ChainedMemberScope.kt */
/* renamed from: d0.e0.p.d.m0.k.a0.b, reason: use source file name */
/* loaded from: classes3.dex */
public final class ChainedMemberScope implements MemberScope3 {

    /* renamed from: b */
    public static final a f24333b = new a(null);

    /* renamed from: c */
    public final String f24334c;

    /* renamed from: d */
    public final MemberScope3[] f24335d;

    /* compiled from: ChainedMemberScope.kt */
    /* renamed from: d0.e0.p.d.m0.k.a0.b$a */
    public static final class a {
        public a(DefaultConstructorMarker defaultConstructorMarker) {
        }

        public final MemberScope3 create(String str, Iterable<? extends MemberScope3> iterable) {
            Intrinsics3.checkNotNullParameter(str, "debugName");
            Intrinsics3.checkNotNullParameter(iterable, "scopes");
            SmartList smartList = new SmartList();
            for (MemberScope3 memberScope3 : iterable) {
                if (memberScope3 != MemberScope3.b.f24373b) {
                    if (memberScope3 instanceof ChainedMemberScope) {
                        MutableCollections.addAll(smartList, ChainedMemberScope.access$getScopes$p((ChainedMemberScope) memberScope3));
                    } else {
                        smartList.add(memberScope3);
                    }
                }
            }
            return createOrSingle$descriptors(str, smartList);
        }

        public final MemberScope3 createOrSingle$descriptors(String str, List<? extends MemberScope3> list) {
            Intrinsics3.checkNotNullParameter(str, "debugName");
            Intrinsics3.checkNotNullParameter(list, "scopes");
            int size = list.size();
            if (size == 0) {
                return MemberScope3.b.f24373b;
            }
            if (size == 1) {
                return list.get(0);
            }
            Object[] array = list.toArray(new MemberScope3[0]);
            Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
            return new ChainedMemberScope(str, (MemberScope3[]) array, null);
        }
    }

    public ChainedMemberScope(String str, MemberScope3[] memberScope3Arr, DefaultConstructorMarker defaultConstructorMarker) {
        this.f24334c = str;
        this.f24335d = memberScope3Arr;
    }

    public static final /* synthetic */ MemberScope3[] access$getScopes$p(ChainedMemberScope chainedMemberScope) {
        return chainedMemberScope.f24335d;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.MemberScope3
    public Set<Name> getClassifierNames() {
        return MemberScope4.flatMapClassifierNamesOrNull(_Arrays.asIterable(this.f24335d));
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.ResolutionScope
    public ClassifierDescriptor getContributedClassifier(Name name, LookupLocation2 lookupLocation2) {
        Intrinsics3.checkNotNullParameter(name, ModelAuditLogEntry.CHANGE_KEY_NAME);
        Intrinsics3.checkNotNullParameter(lookupLocation2, ModelAuditLogEntry.CHANGE_KEY_LOCATION);
        MemberScope3[] memberScope3Arr = this.f24335d;
        int length = memberScope3Arr.length;
        ClassifierDescriptor classifierDescriptor = null;
        int i = 0;
        while (i < length) {
            MemberScope3 memberScope3 = memberScope3Arr[i];
            i++;
            ClassifierDescriptor contributedClassifier = memberScope3.getContributedClassifier(name, lookupLocation2);
            if (contributedClassifier != null) {
                if (!(contributedClassifier instanceof ClassifierDescriptorWithTypeParameters) || !((ClassifierDescriptorWithTypeParameters) contributedClassifier).isExpect()) {
                    return contributedClassifier;
                }
                if (classifierDescriptor == null) {
                    classifierDescriptor = contributedClassifier;
                }
            }
        }
        return classifierDescriptor;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.ResolutionScope
    public Collection<DeclarationDescriptor> getContributedDescriptors(MemberScope2 memberScope2, Function1<? super Name, Boolean> function1) {
        Intrinsics3.checkNotNullParameter(memberScope2, "kindFilter");
        Intrinsics3.checkNotNullParameter(function1, "nameFilter");
        MemberScope3[] memberScope3Arr = this.f24335d;
        int length = memberScope3Arr.length;
        if (length == 0) {
            return Collections2.emptyList();
        }
        int i = 0;
        if (length == 1) {
            return memberScope3Arr[0].getContributedDescriptors(memberScope2, function1);
        }
        Collection<DeclarationDescriptor> collectionConcat = null;
        int length2 = memberScope3Arr.length;
        while (i < length2) {
            MemberScope3 memberScope3 = memberScope3Arr[i];
            i++;
            collectionConcat = scopeUtils.concat(collectionConcat, memberScope3.getContributedDescriptors(memberScope2, function1));
        }
        return collectionConcat == null ? Sets5.emptySet() : collectionConcat;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.MemberScope3
    public Collection<SimpleFunctionDescriptor> getContributedFunctions(Name name, LookupLocation2 lookupLocation2) {
        Intrinsics3.checkNotNullParameter(name, ModelAuditLogEntry.CHANGE_KEY_NAME);
        Intrinsics3.checkNotNullParameter(lookupLocation2, ModelAuditLogEntry.CHANGE_KEY_LOCATION);
        MemberScope3[] memberScope3Arr = this.f24335d;
        int length = memberScope3Arr.length;
        if (length == 0) {
            return Collections2.emptyList();
        }
        int i = 0;
        if (length == 1) {
            return memberScope3Arr[0].getContributedFunctions(name, lookupLocation2);
        }
        Collection<SimpleFunctionDescriptor> collectionConcat = null;
        int length2 = memberScope3Arr.length;
        while (i < length2) {
            MemberScope3 memberScope3 = memberScope3Arr[i];
            i++;
            collectionConcat = scopeUtils.concat(collectionConcat, memberScope3.getContributedFunctions(name, lookupLocation2));
        }
        return collectionConcat == null ? Sets5.emptySet() : collectionConcat;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.MemberScope3
    public Collection<PropertyDescriptor> getContributedVariables(Name name, LookupLocation2 lookupLocation2) {
        Intrinsics3.checkNotNullParameter(name, ModelAuditLogEntry.CHANGE_KEY_NAME);
        Intrinsics3.checkNotNullParameter(lookupLocation2, ModelAuditLogEntry.CHANGE_KEY_LOCATION);
        MemberScope3[] memberScope3Arr = this.f24335d;
        int length = memberScope3Arr.length;
        if (length == 0) {
            return Collections2.emptyList();
        }
        int i = 0;
        if (length == 1) {
            return memberScope3Arr[0].getContributedVariables(name, lookupLocation2);
        }
        Collection<PropertyDescriptor> collectionConcat = null;
        int length2 = memberScope3Arr.length;
        while (i < length2) {
            MemberScope3 memberScope3 = memberScope3Arr[i];
            i++;
            collectionConcat = scopeUtils.concat(collectionConcat, memberScope3.getContributedVariables(name, lookupLocation2));
        }
        return collectionConcat == null ? Sets5.emptySet() : collectionConcat;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.MemberScope3
    public Set<Name> getFunctionNames() {
        MemberScope3[] memberScope3Arr = this.f24335d;
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (MemberScope3 memberScope3 : memberScope3Arr) {
            MutableCollections.addAll(linkedHashSet, memberScope3.getFunctionNames());
        }
        return linkedHashSet;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.MemberScope3
    public Set<Name> getVariableNames() {
        MemberScope3[] memberScope3Arr = this.f24335d;
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (MemberScope3 memberScope3 : memberScope3Arr) {
            MutableCollections.addAll(linkedHashSet, memberScope3.getVariableNames());
        }
        return linkedHashSet;
    }

    public String toString() {
        return this.f24334c;
    }
}

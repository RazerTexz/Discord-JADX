package p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p535i0.p536l;

import com.discord.models.domain.ModelAuditLogEntry;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.functions.Function1;
import p507d0.p513e0.p514p.p515d.p517m0.p518b.StandardNames;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.ClassifierDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.DeclarationDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.PropertyDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.SimpleFunctionDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p529d.p530b.LookupLocation2;
import p507d0.p513e0.p514p.p515d.p517m0.p529d.p530b.LookupLocation3;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p533g0.DescriptorResolverUtils;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p534h0.util3;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p535i0.context4;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.InterfaceC11574g;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.Name;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.DescriptorFactory;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.MemberScope2;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.MemberScope3;
import p507d0.p513e0.p514p.p515d.p517m0.p576p.DFS;
import p507d0.p580t.Collections2;
import p507d0.p580t.CollectionsJVM;
import p507d0.p580t.Iterables2;
import p507d0.p580t.MutableCollections;
import p507d0.p580t.Sets5;
import p507d0.p580t._Collections;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;

/* compiled from: LazyJavaStaticClassScope.kt */
/* renamed from: d0.e0.p.d.m0.e.a.i0.l.o, reason: use source file name */
/* loaded from: classes3.dex */
public final class LazyJavaStaticClassScope2 extends LazyJavaStaticScope {

    /* renamed from: n */
    public final InterfaceC11574g f23410n;

    /* renamed from: o */
    public final LazyJavaClassDescriptor f23411o;

    /* compiled from: LazyJavaStaticClassScope.kt */
    /* renamed from: d0.e0.p.d.m0.e.a.i0.l.o$a */
    public static final class a extends Lambda implements Function1<MemberScope3, Collection<? extends PropertyDescriptor>> {
        public final /* synthetic */ Name $name;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Name name) {
            super(1);
            this.$name = name;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Collection<? extends PropertyDescriptor> invoke(MemberScope3 memberScope3) {
            return invoke2(memberScope3);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Collection<? extends PropertyDescriptor> invoke2(MemberScope3 memberScope3) {
            Intrinsics3.checkNotNullParameter(memberScope3, "it");
            return memberScope3.getContributedVariables(this.$name, LookupLocation3.WHEN_GET_SUPER_MEMBERS);
        }
    }

    /* compiled from: LazyJavaStaticClassScope.kt */
    /* renamed from: d0.e0.p.d.m0.e.a.i0.l.o$b */
    public static final class b extends Lambda implements Function1<MemberScope3, Collection<? extends Name>> {

        /* renamed from: j */
        public static final b f23412j = new b();

        public b() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Collection<? extends Name> invoke(MemberScope3 memberScope3) {
            return invoke2(memberScope3);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Collection<Name> invoke2(MemberScope3 memberScope3) {
            Intrinsics3.checkNotNullParameter(memberScope3, "it");
            return memberScope3.getVariableNames();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LazyJavaStaticClassScope2(context4 context4Var, InterfaceC11574g interfaceC11574g, LazyJavaClassDescriptor lazyJavaClassDescriptor) {
        super(context4Var);
        Intrinsics3.checkNotNullParameter(context4Var, "c");
        Intrinsics3.checkNotNullParameter(interfaceC11574g, "jClass");
        Intrinsics3.checkNotNullParameter(lazyJavaClassDescriptor, "ownerDescriptor");
        this.f23410n = interfaceC11574g;
        this.f23411o = lazyJavaClassDescriptor;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p535i0.p536l.LazyJavaScope
    /* renamed from: a */
    public Set<Name> mo9470a(MemberScope2 memberScope2, Function1<? super Name, Boolean> function1) {
        Intrinsics3.checkNotNullParameter(memberScope2, "kindFilter");
        return Sets5.emptySet();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p535i0.p536l.LazyJavaScope
    /* renamed from: b */
    public Set<Name> mo9471b(MemberScope2 memberScope2, Function1<? super Name, Boolean> function1) {
        Intrinsics3.checkNotNullParameter(memberScope2, "kindFilter");
        Set<Name> mutableSet = _Collections.toMutableSet(this.f23392f.invoke().getMethodNames());
        LazyJavaStaticClassScope2 parentJavaStaticClassScope = util3.getParentJavaStaticClassScope(this.f23411o);
        Set<Name> functionNames = parentJavaStaticClassScope == null ? null : parentJavaStaticClassScope.getFunctionNames();
        if (functionNames == null) {
            functionNames = Sets5.emptySet();
        }
        mutableSet.addAll(functionNames);
        if (this.f23410n.isEnum()) {
            mutableSet.addAll(Collections2.listOf((Object[]) new Name[]{StandardNames.f22490c, StandardNames.f22489b}));
        }
        return mutableSet;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p535i0.p536l.LazyJavaScope
    /* renamed from: d */
    public DeclaredMemberIndex2 mo9473d() {
        return new DeclaredMemberIndex(this.f23410n, LazyJavaStaticClassScope.f23409j);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p535i0.p536l.LazyJavaScope
    /* renamed from: f */
    public void mo9474f(Collection<SimpleFunctionDescriptor> collection, Name name) {
        Intrinsics3.checkNotNullParameter(collection, "result");
        Intrinsics3.checkNotNullParameter(name, ModelAuditLogEntry.CHANGE_KEY_NAME);
        LazyJavaStaticClassScope2 parentJavaStaticClassScope = util3.getParentJavaStaticClassScope(this.f23411o);
        Collection<? extends SimpleFunctionDescriptor> collectionResolveOverridesForStaticMembers = DescriptorResolverUtils.resolveOverridesForStaticMembers(name, parentJavaStaticClassScope == null ? Sets5.emptySet() : _Collections.toSet(parentJavaStaticClassScope.getContributedFunctions(name, LookupLocation3.WHEN_GET_SUPER_MEMBERS)), collection, this.f23411o, this.f23389c.getComponents().getErrorReporter(), this.f23389c.getComponents().getKotlinTypeChecker().getOverridingUtil());
        Intrinsics3.checkNotNullExpressionValue(collectionResolveOverridesForStaticMembers, "resolveOverridesForStaticMembers(\n            name,\n            functionsFromSupertypes,\n            result,\n            ownerDescriptor,\n            c.components.errorReporter,\n            c.components.kotlinTypeChecker.overridingUtil\n        )");
        collection.addAll(collectionResolveOverridesForStaticMembers);
        if (this.f23410n.isEnum()) {
            if (Intrinsics3.areEqual(name, StandardNames.f22490c)) {
                SimpleFunctionDescriptor simpleFunctionDescriptorCreateEnumValueOfMethod = DescriptorFactory.createEnumValueOfMethod(this.f23411o);
                Intrinsics3.checkNotNullExpressionValue(simpleFunctionDescriptorCreateEnumValueOfMethod, "createEnumValueOfMethod(ownerDescriptor)");
                collection.add(simpleFunctionDescriptorCreateEnumValueOfMethod);
            } else if (Intrinsics3.areEqual(name, StandardNames.f22489b)) {
                SimpleFunctionDescriptor simpleFunctionDescriptorCreateEnumValuesMethod = DescriptorFactory.createEnumValuesMethod(this.f23411o);
                Intrinsics3.checkNotNullExpressionValue(simpleFunctionDescriptorCreateEnumValuesMethod, "createEnumValuesMethod(ownerDescriptor)");
                collection.add(simpleFunctionDescriptorCreateEnumValuesMethod);
            }
        }
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p535i0.p536l.LazyJavaStaticScope, p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p535i0.p536l.LazyJavaScope
    /* renamed from: g */
    public void mo9475g(Name name, Collection<PropertyDescriptor> collection) {
        Intrinsics3.checkNotNullParameter(name, ModelAuditLogEntry.CHANGE_KEY_NAME);
        Intrinsics3.checkNotNullParameter(collection, "result");
        LazyJavaClassDescriptor lazyJavaClassDescriptor = this.f23411o;
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        DFS.dfs(CollectionsJVM.listOf(lazyJavaClassDescriptor), LazyJavaStaticClassScope3.f23413a, new LazyJavaStaticClassScope4(lazyJavaClassDescriptor, linkedHashSet, new a(name)));
        if (!collection.isEmpty()) {
            Collection<? extends PropertyDescriptor> collectionResolveOverridesForStaticMembers = DescriptorResolverUtils.resolveOverridesForStaticMembers(name, linkedHashSet, collection, this.f23411o, this.f23389c.getComponents().getErrorReporter(), this.f23389c.getComponents().getKotlinTypeChecker().getOverridingUtil());
            Intrinsics3.checkNotNullExpressionValue(collectionResolveOverridesForStaticMembers, "resolveOverridesForStaticMembers(\n                    name,\n                    propertiesFromSupertypes,\n                    result,\n                    ownerDescriptor,\n                    c.components.errorReporter,\n                    c.components.kotlinTypeChecker.overridingUtil\n                )");
            collection.addAll(collectionResolveOverridesForStaticMembers);
            return;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Object obj : linkedHashSet) {
            PropertyDescriptor propertyDescriptorM9497o = m9497o((PropertyDescriptor) obj);
            Object arrayList = linkedHashMap.get(propertyDescriptorM9497o);
            if (arrayList == null) {
                arrayList = new ArrayList();
                linkedHashMap.put(propertyDescriptorM9497o, arrayList);
            }
            ((List) arrayList).add(obj);
        }
        ArrayList arrayList2 = new ArrayList();
        Iterator it = linkedHashMap.entrySet().iterator();
        while (it.hasNext()) {
            Collection collectionResolveOverridesForStaticMembers2 = DescriptorResolverUtils.resolveOverridesForStaticMembers(name, (Collection) ((Map.Entry) it.next()).getValue(), collection, this.f23411o, this.f23389c.getComponents().getErrorReporter(), this.f23389c.getComponents().getKotlinTypeChecker().getOverridingUtil());
            Intrinsics3.checkNotNullExpressionValue(collectionResolveOverridesForStaticMembers2, "resolveOverridesForStaticMembers(\n                    name, it.value, result, ownerDescriptor, c.components.errorReporter,\n                    c.components.kotlinTypeChecker.overridingUtil\n                )");
            MutableCollections.addAll(arrayList2, collectionResolveOverridesForStaticMembers2);
        }
        collection.addAll(arrayList2);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.MemberScopeImpl, p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.ResolutionScope
    public ClassifierDescriptor getContributedClassifier(Name name, LookupLocation2 lookupLocation2) {
        Intrinsics3.checkNotNullParameter(name, ModelAuditLogEntry.CHANGE_KEY_NAME);
        Intrinsics3.checkNotNullParameter(lookupLocation2, ModelAuditLogEntry.CHANGE_KEY_LOCATION);
        return null;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p535i0.p536l.LazyJavaScope
    /* renamed from: h */
    public Set<Name> mo9476h(MemberScope2 memberScope2, Function1<? super Name, Boolean> function1) {
        Intrinsics3.checkNotNullParameter(memberScope2, "kindFilter");
        Set<Name> mutableSet = _Collections.toMutableSet(this.f23392f.invoke().getFieldNames());
        LazyJavaClassDescriptor lazyJavaClassDescriptor = this.f23411o;
        DFS.dfs(CollectionsJVM.listOf(lazyJavaClassDescriptor), LazyJavaStaticClassScope3.f23413a, new LazyJavaStaticClassScope4(lazyJavaClassDescriptor, mutableSet, b.f23412j));
        return mutableSet;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p535i0.p536l.LazyJavaScope
    /* renamed from: j */
    public DeclarationDescriptor mo9478j() {
        return this.f23411o;
    }

    /* renamed from: o */
    public final PropertyDescriptor m9497o(PropertyDescriptor propertyDescriptor) {
        if (propertyDescriptor.getKind().isReal()) {
            return propertyDescriptor;
        }
        Collection<? extends PropertyDescriptor> overriddenDescriptors = propertyDescriptor.getOverriddenDescriptors();
        Intrinsics3.checkNotNullExpressionValue(overriddenDescriptors, "this.overriddenDescriptors");
        ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(overriddenDescriptors, 10));
        for (PropertyDescriptor propertyDescriptor2 : overriddenDescriptors) {
            Intrinsics3.checkNotNullExpressionValue(propertyDescriptor2, "it");
            arrayList.add(m9497o(propertyDescriptor2));
        }
        return (PropertyDescriptor) _Collections.single(_Collections.distinct(arrayList));
    }
}

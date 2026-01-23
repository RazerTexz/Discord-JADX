package p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p535i0.p536l;

import com.discord.models.domain.ModelAuditLogEntry;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KProperty;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.ClassDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.ClassifierDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.ClassifierDescriptorWithTypeParameters;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.DeclarationDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.PropertyDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.SimpleFunctionDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p529d.p530b.LookupLocation2;
import p507d0.p513e0.p514p.p515d.p517m0.p529d.utils;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p535i0.context4;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.InterfaceC11588u;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p541b.KotlinJvmBinaryClass;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.Name;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.MemberScope2;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.MemberScope3;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.MemberScope4;
import p507d0.p513e0.p514p.p515d.p517m0.p566m.storage5;
import p507d0.p513e0.p514p.p515d.p517m0.p566m.storage7;
import p507d0.p513e0.p514p.p515d.p517m0.p573o.p575n.scopeUtils;
import p507d0.p580t.MutableCollections;
import p507d0.p580t.Sets5;
import p507d0.p580t._Arrays;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;
import p507d0.p592z.p594d.PropertyReference1Impl;
import p507d0.p592z.p594d.Reflection2;

/* JADX INFO: renamed from: d0.e0.p.d.m0.e.a.i0.l.d, reason: use source file name */
/* JADX INFO: compiled from: JvmPackageScope.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class JvmPackageScope implements MemberScope3 {

    /* JADX INFO: renamed from: b */
    public static final /* synthetic */ KProperty<Object>[] f23329b = {Reflection2.property1(new PropertyReference1Impl(Reflection2.getOrCreateKotlinClass(JvmPackageScope.class), "kotlinScopes", "getKotlinScopes()[Lorg/jetbrains/kotlin/resolve/scopes/MemberScope;"))};

    /* JADX INFO: renamed from: c */
    public final context4 f23330c;

    /* JADX INFO: renamed from: d */
    public final LazyJavaPackageFragment f23331d;

    /* JADX INFO: renamed from: e */
    public final LazyJavaPackageScope f23332e;

    /* JADX INFO: renamed from: f */
    public final storage5 f23333f;

    /* JADX INFO: renamed from: d0.e0.p.d.m0.e.a.i0.l.d$a */
    /* JADX INFO: compiled from: JvmPackageScope.kt */
    public static final class a extends Lambda implements Function0<MemberScope3[]> {
        public a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ MemberScope3[] invoke() {
            return invoke2();
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final MemberScope3[] invoke2() {
            Collection<KotlinJvmBinaryClass> collectionValues = JvmPackageScope.access$getPackageFragment$p(JvmPackageScope.this).getBinaryClasses$descriptors_jvm().values();
            JvmPackageScope jvmPackageScope = JvmPackageScope.this;
            ArrayList arrayList = new ArrayList();
            Iterator<T> it = collectionValues.iterator();
            while (it.hasNext()) {
                MemberScope3 memberScope3CreateKotlinPackagePartScope = JvmPackageScope.access$getC$p(jvmPackageScope).getComponents().getDeserializedDescriptorResolver().createKotlinPackagePartScope(JvmPackageScope.access$getPackageFragment$p(jvmPackageScope), (KotlinJvmBinaryClass) it.next());
                if (memberScope3CreateKotlinPackagePartScope != null) {
                    arrayList.add(memberScope3CreateKotlinPackagePartScope);
                }
            }
            Object[] array = scopeUtils.listOfNonEmptyScopes(arrayList).toArray(new MemberScope3[0]);
            Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
            return (MemberScope3[]) array;
        }
    }

    public JvmPackageScope(context4 context4Var, InterfaceC11588u interfaceC11588u, LazyJavaPackageFragment lazyJavaPackageFragment) {
        Intrinsics3.checkNotNullParameter(context4Var, "c");
        Intrinsics3.checkNotNullParameter(interfaceC11588u, "jPackage");
        Intrinsics3.checkNotNullParameter(lazyJavaPackageFragment, "packageFragment");
        this.f23330c = context4Var;
        this.f23331d = lazyJavaPackageFragment;
        this.f23332e = new LazyJavaPackageScope(context4Var, interfaceC11588u, lazyJavaPackageFragment);
        this.f23333f = context4Var.getStorageManager().createLazyValue(new a());
    }

    public static final /* synthetic */ context4 access$getC$p(JvmPackageScope jvmPackageScope) {
        return jvmPackageScope.f23330c;
    }

    public static final /* synthetic */ LazyJavaPackageFragment access$getPackageFragment$p(JvmPackageScope jvmPackageScope) {
        return jvmPackageScope.f23331d;
    }

    /* JADX INFO: renamed from: a */
    public final MemberScope3[] m9462a() {
        return (MemberScope3[]) storage7.getValue(this.f23333f, this, (KProperty<?>) f23329b[0]);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.MemberScope3
    public Set<Name> getClassifierNames() {
        Set<Name> setFlatMapClassifierNamesOrNull = MemberScope4.flatMapClassifierNamesOrNull(_Arrays.asIterable(m9462a()));
        if (setFlatMapClassifierNamesOrNull == null) {
            return null;
        }
        setFlatMapClassifierNamesOrNull.addAll(getJavaScope$descriptors_jvm().getClassifierNames());
        return setFlatMapClassifierNamesOrNull;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.ResolutionScope
    public ClassifierDescriptor getContributedClassifier(Name name, LookupLocation2 lookupLocation2) {
        Intrinsics3.checkNotNullParameter(name, ModelAuditLogEntry.CHANGE_KEY_NAME);
        Intrinsics3.checkNotNullParameter(lookupLocation2, ModelAuditLogEntry.CHANGE_KEY_LOCATION);
        recordLookup(name, lookupLocation2);
        ClassDescriptor contributedClassifier = this.f23332e.getContributedClassifier(name, lookupLocation2);
        if (contributedClassifier != null) {
            return contributedClassifier;
        }
        MemberScope3[] memberScope3ArrM9462a = m9462a();
        ClassifierDescriptor classifierDescriptor = null;
        int i = 0;
        int length = memberScope3ArrM9462a.length;
        while (i < length) {
            MemberScope3 memberScope3 = memberScope3ArrM9462a[i];
            i++;
            ClassifierDescriptor contributedClassifier2 = memberScope3.getContributedClassifier(name, lookupLocation2);
            if (contributedClassifier2 != null) {
                if (!(contributedClassifier2 instanceof ClassifierDescriptorWithTypeParameters) || !((ClassifierDescriptorWithTypeParameters) contributedClassifier2).isExpect()) {
                    return contributedClassifier2;
                }
                if (classifierDescriptor == null) {
                    classifierDescriptor = contributedClassifier2;
                }
            }
        }
        return classifierDescriptor;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.ResolutionScope
    public Collection<DeclarationDescriptor> getContributedDescriptors(MemberScope2 memberScope2, Function1<? super Name, Boolean> function1) {
        Intrinsics3.checkNotNullParameter(memberScope2, "kindFilter");
        Intrinsics3.checkNotNullParameter(function1, "nameFilter");
        LazyJavaPackageScope lazyJavaPackageScope = this.f23332e;
        MemberScope3[] memberScope3ArrM9462a = m9462a();
        Collection<DeclarationDescriptor> contributedDescriptors = lazyJavaPackageScope.getContributedDescriptors(memberScope2, function1);
        int length = memberScope3ArrM9462a.length;
        int i = 0;
        while (i < length) {
            MemberScope3 memberScope3 = memberScope3ArrM9462a[i];
            i++;
            contributedDescriptors = scopeUtils.concat(contributedDescriptors, memberScope3.getContributedDescriptors(memberScope2, function1));
        }
        return contributedDescriptors == null ? Sets5.emptySet() : contributedDescriptors;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.MemberScope3
    public Collection<SimpleFunctionDescriptor> getContributedFunctions(Name name, LookupLocation2 lookupLocation2) {
        Intrinsics3.checkNotNullParameter(name, ModelAuditLogEntry.CHANGE_KEY_NAME);
        Intrinsics3.checkNotNullParameter(lookupLocation2, ModelAuditLogEntry.CHANGE_KEY_LOCATION);
        recordLookup(name, lookupLocation2);
        LazyJavaPackageScope lazyJavaPackageScope = this.f23332e;
        MemberScope3[] memberScope3ArrM9462a = m9462a();
        Collection<? extends SimpleFunctionDescriptor> contributedFunctions = lazyJavaPackageScope.getContributedFunctions(name, lookupLocation2);
        int length = memberScope3ArrM9462a.length;
        int i = 0;
        Collection collectionConcat = contributedFunctions;
        while (i < length) {
            MemberScope3 memberScope3 = memberScope3ArrM9462a[i];
            i++;
            collectionConcat = scopeUtils.concat(collectionConcat, memberScope3.getContributedFunctions(name, lookupLocation2));
        }
        return collectionConcat == null ? Sets5.emptySet() : collectionConcat;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.MemberScope3
    public Collection<PropertyDescriptor> getContributedVariables(Name name, LookupLocation2 lookupLocation2) {
        Intrinsics3.checkNotNullParameter(name, ModelAuditLogEntry.CHANGE_KEY_NAME);
        Intrinsics3.checkNotNullParameter(lookupLocation2, ModelAuditLogEntry.CHANGE_KEY_LOCATION);
        recordLookup(name, lookupLocation2);
        LazyJavaPackageScope lazyJavaPackageScope = this.f23332e;
        MemberScope3[] memberScope3ArrM9462a = m9462a();
        Collection<? extends PropertyDescriptor> contributedVariables = lazyJavaPackageScope.getContributedVariables(name, lookupLocation2);
        int length = memberScope3ArrM9462a.length;
        int i = 0;
        Collection collectionConcat = contributedVariables;
        while (i < length) {
            MemberScope3 memberScope3 = memberScope3ArrM9462a[i];
            i++;
            collectionConcat = scopeUtils.concat(collectionConcat, memberScope3.getContributedVariables(name, lookupLocation2));
        }
        return collectionConcat == null ? Sets5.emptySet() : collectionConcat;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.MemberScope3
    public Set<Name> getFunctionNames() {
        MemberScope3[] memberScope3ArrM9462a = m9462a();
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (MemberScope3 memberScope3 : memberScope3ArrM9462a) {
            MutableCollections.addAll(linkedHashSet, memberScope3.getFunctionNames());
        }
        linkedHashSet.addAll(getJavaScope$descriptors_jvm().getFunctionNames());
        return linkedHashSet;
    }

    public final LazyJavaPackageScope getJavaScope$descriptors_jvm() {
        return this.f23332e;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.MemberScope3
    public Set<Name> getVariableNames() {
        MemberScope3[] memberScope3ArrM9462a = m9462a();
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (MemberScope3 memberScope3 : memberScope3ArrM9462a) {
            MutableCollections.addAll(linkedHashSet, memberScope3.getVariableNames());
        }
        linkedHashSet.addAll(getJavaScope$descriptors_jvm().getVariableNames());
        return linkedHashSet;
    }

    public void recordLookup(Name name, LookupLocation2 lookupLocation2) {
        Intrinsics3.checkNotNullParameter(name, ModelAuditLogEntry.CHANGE_KEY_NAME);
        Intrinsics3.checkNotNullParameter(lookupLocation2, ModelAuditLogEntry.CHANGE_KEY_LOCATION);
        utils.record(this.f23330c.getComponents().getLookupTracker(), lookupLocation2, this.f23331d, name);
    }
}

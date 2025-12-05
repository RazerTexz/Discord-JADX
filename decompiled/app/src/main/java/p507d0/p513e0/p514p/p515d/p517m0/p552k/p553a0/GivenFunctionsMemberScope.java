package p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0;

import com.discord.models.domain.ModelAuditLogEntry;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KProperty;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.CallableMemberDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.ClassDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.DeclarationDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.FunctionDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.PropertyDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.SimpleFunctionDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p529d.p530b.LookupLocation2;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.Name;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.OverridingUtil;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.ResolutionScope;
import p507d0.p513e0.p514p.p515d.p517m0.p566m.StorageManager;
import p507d0.p513e0.p514p.p515d.p517m0.p566m.storage5;
import p507d0.p513e0.p514p.p515d.p517m0.p566m.storage7;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType;
import p507d0.p513e0.p514p.p515d.p517m0.p576p.SmartList;
import p507d0.p513e0.p514p.p515d.p517m0.p576p.collections;
import p507d0.p580t.Collections2;
import p507d0.p580t.MutableCollections;
import p507d0.p580t._Collections;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;
import p507d0.p592z.p594d.PropertyReference1Impl;
import p507d0.p592z.p594d.Reflection2;

/* compiled from: GivenFunctionsMemberScope.kt */
/* renamed from: d0.e0.p.d.m0.k.a0.e, reason: use source file name */
/* loaded from: classes3.dex */
public abstract class GivenFunctionsMemberScope extends MemberScopeImpl {

    /* renamed from: b */
    public static final /* synthetic */ KProperty<Object>[] f24362b = {Reflection2.property1(new PropertyReference1Impl(Reflection2.getOrCreateKotlinClass(GivenFunctionsMemberScope.class), "allDescriptors", "getAllDescriptors()Ljava/util/List;"))};

    /* renamed from: c */
    public final ClassDescriptor f24363c;

    /* renamed from: d */
    public final storage5 f24364d;

    /* compiled from: GivenFunctionsMemberScope.kt */
    /* renamed from: d0.e0.p.d.m0.k.a0.e$a */
    public static final class a extends Lambda implements Function0<List<? extends DeclarationDescriptor>> {
        public a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ List<? extends DeclarationDescriptor> invoke() {
            return invoke2();
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final List<? extends DeclarationDescriptor> invoke2() {
            List<FunctionDescriptor> listMo9372a = GivenFunctionsMemberScope.this.mo9372a();
            return _Collections.plus((Collection) listMo9372a, (Iterable) GivenFunctionsMemberScope.access$createFakeOverrides(GivenFunctionsMemberScope.this, listMo9372a));
        }
    }

    public GivenFunctionsMemberScope(StorageManager storageManager, ClassDescriptor classDescriptor) {
        Intrinsics3.checkNotNullParameter(storageManager, "storageManager");
        Intrinsics3.checkNotNullParameter(classDescriptor, "containingClass");
        this.f24363c = classDescriptor;
        this.f24364d = storageManager.createLazyValue(new a());
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v4, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r5v5 */
    /* JADX WARN: Type inference failed for: r5v7, types: [java.util.ArrayList] */
    public static final List access$createFakeOverrides(GivenFunctionsMemberScope givenFunctionsMemberScope, List list) {
        Collection<? extends CallableMemberDescriptor> collectionEmptyList;
        Objects.requireNonNull(givenFunctionsMemberScope);
        ArrayList arrayList = new ArrayList(3);
        Collection<KotlinType> supertypes = givenFunctionsMemberScope.f24363c.getTypeConstructor().getSupertypes();
        Intrinsics3.checkNotNullExpressionValue(supertypes, "containingClass.typeConstructor.supertypes");
        ArrayList arrayList2 = new ArrayList();
        Iterator it = supertypes.iterator();
        while (it.hasNext()) {
            MutableCollections.addAll(arrayList2, ResolutionScope.a.getContributedDescriptors$default(((KotlinType) it.next()).getMemberScope(), null, null, 3, null));
        }
        ArrayList arrayList3 = new ArrayList();
        for (Object obj : arrayList2) {
            if (obj instanceof CallableMemberDescriptor) {
                arrayList3.add(obj);
            }
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Object obj2 : arrayList3) {
            Name name = ((CallableMemberDescriptor) obj2).getName();
            Object arrayList4 = linkedHashMap.get(name);
            if (arrayList4 == null) {
                arrayList4 = new ArrayList();
                linkedHashMap.put(name, arrayList4);
            }
            ((List) arrayList4).add(obj2);
        }
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            Name name2 = (Name) entry.getKey();
            List list2 = (List) entry.getValue();
            LinkedHashMap linkedHashMap2 = new LinkedHashMap();
            for (Object obj3 : list2) {
                Boolean boolValueOf = Boolean.valueOf(((CallableMemberDescriptor) obj3) instanceof FunctionDescriptor);
                Object arrayList5 = linkedHashMap2.get(boolValueOf);
                if (arrayList5 == null) {
                    arrayList5 = new ArrayList();
                    linkedHashMap2.put(boolValueOf, arrayList5);
                }
                ((List) arrayList5).add(obj3);
            }
            for (Map.Entry entry2 : linkedHashMap2.entrySet()) {
                boolean zBooleanValue = ((Boolean) entry2.getKey()).booleanValue();
                List list3 = (List) entry2.getValue();
                OverridingUtil overridingUtil = OverridingUtil.f24411b;
                if (zBooleanValue) {
                    collectionEmptyList = new ArrayList();
                    for (Object obj4 : list) {
                        if (Intrinsics3.areEqual(((FunctionDescriptor) obj4).getName(), name2)) {
                            collectionEmptyList.add(obj4);
                        }
                    }
                } else {
                    collectionEmptyList = Collections2.emptyList();
                }
                overridingUtil.generateOverridesInFunctionGroup(name2, list3, collectionEmptyList, givenFunctionsMemberScope.f24363c, new GivenFunctionsMemberScope2(arrayList, givenFunctionsMemberScope));
            }
        }
        return collections.compact(arrayList);
    }

    /* renamed from: a */
    public abstract List<FunctionDescriptor> mo9372a();

    /* renamed from: b */
    public final List<DeclarationDescriptor> m9911b() {
        return (List) storage7.getValue(this.f24364d, this, (KProperty<?>) f24362b[0]);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.MemberScopeImpl, p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.ResolutionScope
    public Collection<DeclarationDescriptor> getContributedDescriptors(MemberScope2 memberScope2, Function1<? super Name, Boolean> function1) {
        Intrinsics3.checkNotNullParameter(memberScope2, "kindFilter");
        Intrinsics3.checkNotNullParameter(function1, "nameFilter");
        return !memberScope2.acceptsKinds(MemberScope2.f24352n.getKindMask()) ? Collections2.emptyList() : m9911b();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.MemberScopeImpl, p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.MemberScope3
    public Collection<SimpleFunctionDescriptor> getContributedFunctions(Name name, LookupLocation2 lookupLocation2) {
        Intrinsics3.checkNotNullParameter(name, ModelAuditLogEntry.CHANGE_KEY_NAME);
        Intrinsics3.checkNotNullParameter(lookupLocation2, ModelAuditLogEntry.CHANGE_KEY_LOCATION);
        List<DeclarationDescriptor> listM9911b = m9911b();
        SmartList smartList = new SmartList();
        for (Object obj : listM9911b) {
            if ((obj instanceof SimpleFunctionDescriptor) && Intrinsics3.areEqual(((SimpleFunctionDescriptor) obj).getName(), name)) {
                smartList.add(obj);
            }
        }
        return smartList;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.MemberScopeImpl, p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.MemberScope3
    public Collection<PropertyDescriptor> getContributedVariables(Name name, LookupLocation2 lookupLocation2) {
        Intrinsics3.checkNotNullParameter(name, ModelAuditLogEntry.CHANGE_KEY_NAME);
        Intrinsics3.checkNotNullParameter(lookupLocation2, ModelAuditLogEntry.CHANGE_KEY_LOCATION);
        List<DeclarationDescriptor> listM9911b = m9911b();
        SmartList smartList = new SmartList();
        for (Object obj : listM9911b) {
            if ((obj instanceof PropertyDescriptor) && Intrinsics3.areEqual(((PropertyDescriptor) obj).getName(), name)) {
                smartList.add(obj);
            }
        }
        return smartList;
    }
}

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
import kotlin.sequences.Sequence;
import p507d0.p512d0._Ranges;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.InterfaceC11574g;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.InterfaceC11581n;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.InterfaceC11584q;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.InterfaceC11585r;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.InterfaceC11587t;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.InterfaceC11590w;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.javaLoading;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.Name;
import p507d0.p578f0._Sequences2;
import p507d0.p580t.Collections2;
import p507d0.p580t.Iterables2;
import p507d0.p580t.MapsJVM;
import p507d0.p580t._Collections;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;

/* JADX INFO: renamed from: d0.e0.p.d.m0.e.a.i0.l.a, reason: use source file name */
/* JADX INFO: compiled from: DeclaredMemberIndex.kt */
/* JADX INFO: loaded from: classes3.dex */
public class DeclaredMemberIndex implements DeclaredMemberIndex2 {

    /* JADX INFO: renamed from: a */
    public final InterfaceC11574g f23322a;

    /* JADX INFO: renamed from: b */
    public final Function1<InterfaceC11584q, Boolean> f23323b;

    /* JADX INFO: renamed from: c */
    public final Function1<InterfaceC11585r, Boolean> f23324c;

    /* JADX INFO: renamed from: d */
    public final Map<Name, List<InterfaceC11585r>> f23325d;

    /* JADX INFO: renamed from: e */
    public final Map<Name, InterfaceC11581n> f23326e;

    /* JADX INFO: renamed from: f */
    public final Map<Name, InterfaceC11590w> f23327f;

    /* JADX INFO: renamed from: d0.e0.p.d.m0.e.a.i0.l.a$a */
    /* JADX INFO: compiled from: DeclaredMemberIndex.kt */
    public static final class a extends Lambda implements Function1<InterfaceC11585r, Boolean> {
        public a() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Boolean invoke(InterfaceC11585r interfaceC11585r) {
            return Boolean.valueOf(invoke2(interfaceC11585r));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final boolean invoke2(InterfaceC11585r interfaceC11585r) {
            Intrinsics3.checkNotNullParameter(interfaceC11585r, "m");
            return ((Boolean) DeclaredMemberIndex.access$getMemberFilter$p(DeclaredMemberIndex.this).invoke(interfaceC11585r)).booleanValue() && !javaLoading.isObjectMethodInInterface(interfaceC11585r);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public DeclaredMemberIndex(InterfaceC11574g interfaceC11574g, Function1<? super InterfaceC11584q, Boolean> function1) {
        Intrinsics3.checkNotNullParameter(interfaceC11574g, "jClass");
        Intrinsics3.checkNotNullParameter(function1, "memberFilter");
        this.f23322a = interfaceC11574g;
        this.f23323b = function1;
        a aVar = new a();
        this.f23324c = aVar;
        Sequence sequenceFilter = _Sequences2.filter(_Collections.asSequence(interfaceC11574g.getMethods()), aVar);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Object obj : sequenceFilter) {
            Name name = ((InterfaceC11585r) obj).getName();
            Object arrayList = linkedHashMap.get(name);
            if (arrayList == null) {
                arrayList = new ArrayList();
                linkedHashMap.put(name, arrayList);
            }
            ((List) arrayList).add(obj);
        }
        this.f23325d = linkedHashMap;
        Sequence sequenceFilter2 = _Sequences2.filter(_Collections.asSequence(this.f23322a.getFields()), this.f23323b);
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        for (Object obj2 : sequenceFilter2) {
            linkedHashMap2.put(((InterfaceC11581n) obj2).getName(), obj2);
        }
        this.f23326e = linkedHashMap2;
        Collection<InterfaceC11590w> recordComponents = this.f23322a.getRecordComponents();
        Function1<InterfaceC11584q, Boolean> function12 = this.f23323b;
        ArrayList arrayList2 = new ArrayList();
        for (Object obj3 : recordComponents) {
            if (((Boolean) function12.invoke(obj3)).booleanValue()) {
                arrayList2.add(obj3);
            }
        }
        LinkedHashMap linkedHashMap3 = new LinkedHashMap(_Ranges.coerceAtLeast(MapsJVM.mapCapacity(Iterables2.collectionSizeOrDefault(arrayList2, 10)), 16));
        for (Object obj4 : arrayList2) {
            linkedHashMap3.put(((InterfaceC11590w) obj4).getName(), obj4);
        }
        this.f23327f = linkedHashMap3;
    }

    public static final /* synthetic */ Function1 access$getMemberFilter$p(DeclaredMemberIndex declaredMemberIndex) {
        return declaredMemberIndex.f23323b;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p535i0.p536l.DeclaredMemberIndex2
    public InterfaceC11581n findFieldByName(Name name) {
        Intrinsics3.checkNotNullParameter(name, ModelAuditLogEntry.CHANGE_KEY_NAME);
        return this.f23326e.get(name);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p535i0.p536l.DeclaredMemberIndex2
    public Collection<InterfaceC11585r> findMethodsByName(Name name) {
        Intrinsics3.checkNotNullParameter(name, ModelAuditLogEntry.CHANGE_KEY_NAME);
        List<InterfaceC11585r> list = this.f23325d.get(name);
        return list == null ? Collections2.emptyList() : list;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p535i0.p536l.DeclaredMemberIndex2
    public InterfaceC11590w findRecordComponentByName(Name name) {
        Intrinsics3.checkNotNullParameter(name, ModelAuditLogEntry.CHANGE_KEY_NAME);
        return this.f23327f.get(name);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p535i0.p536l.DeclaredMemberIndex2
    public Set<Name> getFieldNames() {
        Sequence sequenceFilter = _Sequences2.filter(_Collections.asSequence(this.f23322a.getFields()), this.f23323b);
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        Iterator it = sequenceFilter.iterator();
        while (it.hasNext()) {
            linkedHashSet.add(((InterfaceC11587t) it.next()).getName());
        }
        return linkedHashSet;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p535i0.p536l.DeclaredMemberIndex2
    public Set<Name> getMethodNames() {
        Sequence sequenceFilter = _Sequences2.filter(_Collections.asSequence(this.f23322a.getMethods()), this.f23324c);
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        Iterator it = sequenceFilter.iterator();
        while (it.hasNext()) {
            linkedHashSet.add(((InterfaceC11587t) it.next()).getName());
        }
        return linkedHashSet;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p535i0.p536l.DeclaredMemberIndex2
    public Set<Name> getRecordComponentNames() {
        return this.f23327f.keySet();
    }
}

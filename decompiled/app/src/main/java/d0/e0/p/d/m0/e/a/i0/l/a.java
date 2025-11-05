package d0.e0.p.d.m0.e.a.i0.l;

import com.discord.models.domain.ModelAuditLogEntry;
import d0.e0.p.d.m0.e.a.k0.t;
import d0.e0.p.d.m0.e.a.k0.w;
import d0.t.g0;
import d0.t.u;
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

/* compiled from: DeclaredMemberIndex.kt */
/* loaded from: classes3.dex */
public class a implements b {
    public final d0.e0.p.d.m0.e.a.k0.g a;

    /* renamed from: b, reason: collision with root package name */
    public final Function1<d0.e0.p.d.m0.e.a.k0.q, Boolean> f3325b;
    public final Function1<d0.e0.p.d.m0.e.a.k0.r, Boolean> c;
    public final Map<d0.e0.p.d.m0.g.e, List<d0.e0.p.d.m0.e.a.k0.r>> d;
    public final Map<d0.e0.p.d.m0.g.e, d0.e0.p.d.m0.e.a.k0.n> e;
    public final Map<d0.e0.p.d.m0.g.e, w> f;

    /* compiled from: DeclaredMemberIndex.kt */
    /* renamed from: d0.e0.p.d.m0.e.a.i0.l.a$a, reason: collision with other inner class name */
    public static final class C0523a extends d0.z.d.o implements Function1<d0.e0.p.d.m0.e.a.k0.r, Boolean> {
        public C0523a() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Boolean invoke(d0.e0.p.d.m0.e.a.k0.r rVar) {
            return Boolean.valueOf(invoke2(rVar));
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final boolean invoke2(d0.e0.p.d.m0.e.a.k0.r rVar) {
            d0.z.d.m.checkNotNullParameter(rVar, "m");
            return ((Boolean) a.access$getMemberFilter$p(a.this).invoke(rVar)).booleanValue() && !d0.e0.p.d.m0.e.a.k0.p.isObjectMethodInInterface(rVar);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public a(d0.e0.p.d.m0.e.a.k0.g gVar, Function1<? super d0.e0.p.d.m0.e.a.k0.q, Boolean> function1) {
        d0.z.d.m.checkNotNullParameter(gVar, "jClass");
        d0.z.d.m.checkNotNullParameter(function1, "memberFilter");
        this.a = gVar;
        this.f3325b = function1;
        C0523a c0523a = new C0523a();
        this.c = c0523a;
        Sequence sequenceFilter = d0.f0.q.filter(u.asSequence(gVar.getMethods()), c0523a);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Object obj : sequenceFilter) {
            d0.e0.p.d.m0.g.e name = ((d0.e0.p.d.m0.e.a.k0.r) obj).getName();
            Object arrayList = linkedHashMap.get(name);
            if (arrayList == null) {
                arrayList = new ArrayList();
                linkedHashMap.put(name, arrayList);
            }
            ((List) arrayList).add(obj);
        }
        this.d = linkedHashMap;
        Sequence sequenceFilter2 = d0.f0.q.filter(u.asSequence(this.a.getFields()), this.f3325b);
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        for (Object obj2 : sequenceFilter2) {
            linkedHashMap2.put(((d0.e0.p.d.m0.e.a.k0.n) obj2).getName(), obj2);
        }
        this.e = linkedHashMap2;
        Collection<w> recordComponents = this.a.getRecordComponents();
        Function1<d0.e0.p.d.m0.e.a.k0.q, Boolean> function12 = this.f3325b;
        ArrayList arrayList2 = new ArrayList();
        for (Object obj3 : recordComponents) {
            if (((Boolean) function12.invoke(obj3)).booleanValue()) {
                arrayList2.add(obj3);
            }
        }
        LinkedHashMap linkedHashMap3 = new LinkedHashMap(d0.d0.f.coerceAtLeast(g0.mapCapacity(d0.t.o.collectionSizeOrDefault(arrayList2, 10)), 16));
        for (Object obj4 : arrayList2) {
            linkedHashMap3.put(((w) obj4).getName(), obj4);
        }
        this.f = linkedHashMap3;
    }

    public static final /* synthetic */ Function1 access$getMemberFilter$p(a aVar) {
        return aVar.f3325b;
    }

    @Override // d0.e0.p.d.m0.e.a.i0.l.b
    public d0.e0.p.d.m0.e.a.k0.n findFieldByName(d0.e0.p.d.m0.g.e eVar) {
        d0.z.d.m.checkNotNullParameter(eVar, ModelAuditLogEntry.CHANGE_KEY_NAME);
        return this.e.get(eVar);
    }

    @Override // d0.e0.p.d.m0.e.a.i0.l.b
    public Collection<d0.e0.p.d.m0.e.a.k0.r> findMethodsByName(d0.e0.p.d.m0.g.e eVar) {
        d0.z.d.m.checkNotNullParameter(eVar, ModelAuditLogEntry.CHANGE_KEY_NAME);
        List<d0.e0.p.d.m0.e.a.k0.r> list = this.d.get(eVar);
        return list == null ? d0.t.n.emptyList() : list;
    }

    @Override // d0.e0.p.d.m0.e.a.i0.l.b
    public w findRecordComponentByName(d0.e0.p.d.m0.g.e eVar) {
        d0.z.d.m.checkNotNullParameter(eVar, ModelAuditLogEntry.CHANGE_KEY_NAME);
        return this.f.get(eVar);
    }

    @Override // d0.e0.p.d.m0.e.a.i0.l.b
    public Set<d0.e0.p.d.m0.g.e> getFieldNames() {
        Sequence sequenceFilter = d0.f0.q.filter(u.asSequence(this.a.getFields()), this.f3325b);
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        Iterator it = sequenceFilter.iterator();
        while (it.hasNext()) {
            linkedHashSet.add(((t) it.next()).getName());
        }
        return linkedHashSet;
    }

    @Override // d0.e0.p.d.m0.e.a.i0.l.b
    public Set<d0.e0.p.d.m0.g.e> getMethodNames() {
        Sequence sequenceFilter = d0.f0.q.filter(u.asSequence(this.a.getMethods()), this.c);
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        Iterator it = sequenceFilter.iterator();
        while (it.hasNext()) {
            linkedHashSet.add(((t) it.next()).getName());
        }
        return linkedHashSet;
    }

    @Override // d0.e0.p.d.m0.e.a.i0.l.b
    public Set<d0.e0.p.d.m0.g.e> getRecordComponentNames() {
        return this.f.keySet();
    }
}

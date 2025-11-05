package d0.e0.p.d.m0.k.a0;

import com.discord.models.domain.ModelAuditLogEntry;
import d0.e0.p.d.m0.c.t0;
import d0.e0.p.d.m0.k.a0.i;
import d0.t.n0;
import d0.t.r;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: ChainedMemberScope.kt */
/* loaded from: classes3.dex */
public final class b implements i {

    /* renamed from: b, reason: collision with root package name */
    public static final a f3451b = new a(null);
    public final String c;
    public final i[] d;

    /* compiled from: ChainedMemberScope.kt */
    public static final class a {
        public a(DefaultConstructorMarker defaultConstructorMarker) {
        }

        public final i create(String str, Iterable<? extends i> iterable) {
            d0.z.d.m.checkNotNullParameter(str, "debugName");
            d0.z.d.m.checkNotNullParameter(iterable, "scopes");
            d0.e0.p.d.m0.p.i iVar = new d0.e0.p.d.m0.p.i();
            for (i iVar2 : iterable) {
                if (iVar2 != i.b.f3461b) {
                    if (iVar2 instanceof b) {
                        r.addAll(iVar, b.access$getScopes$p((b) iVar2));
                    } else {
                        iVar.add(iVar2);
                    }
                }
            }
            return createOrSingle$descriptors(str, iVar);
        }

        public final i createOrSingle$descriptors(String str, List<? extends i> list) {
            d0.z.d.m.checkNotNullParameter(str, "debugName");
            d0.z.d.m.checkNotNullParameter(list, "scopes");
            int size = list.size();
            if (size == 0) {
                return i.b.f3461b;
            }
            if (size == 1) {
                return list.get(0);
            }
            Object[] array = list.toArray(new i[0]);
            Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
            return new b(str, (i[]) array, null);
        }
    }

    public b(String str, i[] iVarArr, DefaultConstructorMarker defaultConstructorMarker) {
        this.c = str;
        this.d = iVarArr;
    }

    public static final /* synthetic */ i[] access$getScopes$p(b bVar) {
        return bVar.d;
    }

    @Override // d0.e0.p.d.m0.k.a0.i
    public Set<d0.e0.p.d.m0.g.e> getClassifierNames() {
        return k.flatMapClassifierNamesOrNull(d0.t.k.asIterable(this.d));
    }

    @Override // d0.e0.p.d.m0.k.a0.l
    public d0.e0.p.d.m0.c.h getContributedClassifier(d0.e0.p.d.m0.g.e eVar, d0.e0.p.d.m0.d.b.b bVar) {
        d0.z.d.m.checkNotNullParameter(eVar, ModelAuditLogEntry.CHANGE_KEY_NAME);
        d0.z.d.m.checkNotNullParameter(bVar, ModelAuditLogEntry.CHANGE_KEY_LOCATION);
        i[] iVarArr = this.d;
        int length = iVarArr.length;
        d0.e0.p.d.m0.c.h hVar = null;
        int i = 0;
        while (i < length) {
            i iVar = iVarArr[i];
            i++;
            d0.e0.p.d.m0.c.h contributedClassifier = iVar.getContributedClassifier(eVar, bVar);
            if (contributedClassifier != null) {
                if (!(contributedClassifier instanceof d0.e0.p.d.m0.c.i) || !((d0.e0.p.d.m0.c.i) contributedClassifier).isExpect()) {
                    return contributedClassifier;
                }
                if (hVar == null) {
                    hVar = contributedClassifier;
                }
            }
        }
        return hVar;
    }

    @Override // d0.e0.p.d.m0.k.a0.l
    public Collection<d0.e0.p.d.m0.c.m> getContributedDescriptors(d dVar, Function1<? super d0.e0.p.d.m0.g.e, Boolean> function1) {
        d0.z.d.m.checkNotNullParameter(dVar, "kindFilter");
        d0.z.d.m.checkNotNullParameter(function1, "nameFilter");
        i[] iVarArr = this.d;
        int length = iVarArr.length;
        if (length == 0) {
            return d0.t.n.emptyList();
        }
        int i = 0;
        if (length == 1) {
            return iVarArr[0].getContributedDescriptors(dVar, function1);
        }
        Collection<d0.e0.p.d.m0.c.m> collectionConcat = null;
        int length2 = iVarArr.length;
        while (i < length2) {
            i iVar = iVarArr[i];
            i++;
            collectionConcat = d0.e0.p.d.m0.o.n.a.concat(collectionConcat, iVar.getContributedDescriptors(dVar, function1));
        }
        return collectionConcat == null ? n0.emptySet() : collectionConcat;
    }

    @Override // d0.e0.p.d.m0.k.a0.i
    public Collection<t0> getContributedFunctions(d0.e0.p.d.m0.g.e eVar, d0.e0.p.d.m0.d.b.b bVar) {
        d0.z.d.m.checkNotNullParameter(eVar, ModelAuditLogEntry.CHANGE_KEY_NAME);
        d0.z.d.m.checkNotNullParameter(bVar, ModelAuditLogEntry.CHANGE_KEY_LOCATION);
        i[] iVarArr = this.d;
        int length = iVarArr.length;
        if (length == 0) {
            return d0.t.n.emptyList();
        }
        int i = 0;
        if (length == 1) {
            return iVarArr[0].getContributedFunctions(eVar, bVar);
        }
        Collection<t0> collectionConcat = null;
        int length2 = iVarArr.length;
        while (i < length2) {
            i iVar = iVarArr[i];
            i++;
            collectionConcat = d0.e0.p.d.m0.o.n.a.concat(collectionConcat, iVar.getContributedFunctions(eVar, bVar));
        }
        return collectionConcat == null ? n0.emptySet() : collectionConcat;
    }

    @Override // d0.e0.p.d.m0.k.a0.i
    public Collection<d0.e0.p.d.m0.c.n0> getContributedVariables(d0.e0.p.d.m0.g.e eVar, d0.e0.p.d.m0.d.b.b bVar) {
        d0.z.d.m.checkNotNullParameter(eVar, ModelAuditLogEntry.CHANGE_KEY_NAME);
        d0.z.d.m.checkNotNullParameter(bVar, ModelAuditLogEntry.CHANGE_KEY_LOCATION);
        i[] iVarArr = this.d;
        int length = iVarArr.length;
        if (length == 0) {
            return d0.t.n.emptyList();
        }
        int i = 0;
        if (length == 1) {
            return iVarArr[0].getContributedVariables(eVar, bVar);
        }
        Collection<d0.e0.p.d.m0.c.n0> collectionConcat = null;
        int length2 = iVarArr.length;
        while (i < length2) {
            i iVar = iVarArr[i];
            i++;
            collectionConcat = d0.e0.p.d.m0.o.n.a.concat(collectionConcat, iVar.getContributedVariables(eVar, bVar));
        }
        return collectionConcat == null ? n0.emptySet() : collectionConcat;
    }

    @Override // d0.e0.p.d.m0.k.a0.i
    public Set<d0.e0.p.d.m0.g.e> getFunctionNames() {
        i[] iVarArr = this.d;
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (i iVar : iVarArr) {
            r.addAll(linkedHashSet, iVar.getFunctionNames());
        }
        return linkedHashSet;
    }

    @Override // d0.e0.p.d.m0.k.a0.i
    public Set<d0.e0.p.d.m0.g.e> getVariableNames() {
        i[] iVarArr = this.d;
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (i iVar : iVarArr) {
            r.addAll(linkedHashSet, iVar.getVariableNames());
        }
        return linkedHashSet;
    }

    public String toString() {
        return this.c;
    }
}

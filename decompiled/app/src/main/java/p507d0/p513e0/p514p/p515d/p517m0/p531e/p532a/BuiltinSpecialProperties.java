package p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a;

import com.discord.models.domain.ModelAuditLogEntry;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Tuples2;
import p507d0.Tuples;
import p507d0.p513e0.p514p.p515d.p517m0.p518b.StandardNames;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.FqName;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.FqNameUnsafe;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.Name;
import p507d0.p580t.Collections2;
import p507d0.p580t.Iterables2;
import p507d0.p580t.Maps6;
import p507d0.p580t._Collections;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: renamed from: d0.e0.p.d.m0.e.a.i, reason: use source file name */
/* JADX INFO: compiled from: BuiltinSpecialProperties.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class BuiltinSpecialProperties {

    /* JADX INFO: renamed from: a */
    public static final BuiltinSpecialProperties f23276a = new BuiltinSpecialProperties();

    /* JADX INFO: renamed from: b */
    public static final Map<FqName, Name> f23277b;

    /* JADX INFO: renamed from: c */
    public static final Map<Name, List<Name>> f23278c;

    /* JADX INFO: renamed from: d */
    public static final Set<FqName> f23279d;

    /* JADX INFO: renamed from: e */
    public static final Set<Name> f23280e;

    static {
        FqNameUnsafe fqNameUnsafe = StandardNames.a.f22563r;
        FqName fqName = StandardNames.a.f22517N;
        Map<FqName, Name> mapMapOf = Maps6.mapOf(Tuples.m10073to(BuiltinSpecialProperties2.access$childSafe(fqNameUnsafe, ModelAuditLogEntry.CHANGE_KEY_NAME), Name.identifier(ModelAuditLogEntry.CHANGE_KEY_NAME)), Tuples.m10073to(BuiltinSpecialProperties2.access$childSafe(fqNameUnsafe, "ordinal"), Name.identifier("ordinal")), Tuples.m10073to(BuiltinSpecialProperties2.access$child(StandardNames.a.f22513J, "size"), Name.identifier("size")), Tuples.m10073to(BuiltinSpecialProperties2.access$child(fqName, "size"), Name.identifier("size")), Tuples.m10073to(BuiltinSpecialProperties2.access$childSafe(StandardNames.a.f22540f, "length"), Name.identifier("length")), Tuples.m10073to(BuiltinSpecialProperties2.access$child(fqName, "keys"), Name.identifier("keySet")), Tuples.m10073to(BuiltinSpecialProperties2.access$child(fqName, "values"), Name.identifier("values")), Tuples.m10073to(BuiltinSpecialProperties2.access$child(fqName, "entries"), Name.identifier("entrySet")));
        f23277b = mapMapOf;
        Set<Map.Entry<FqName, Name>> setEntrySet = mapMapOf.entrySet();
        ArrayList<Tuples2> arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(setEntrySet, 10));
        Iterator<T> it = setEntrySet.iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            arrayList.add(new Tuples2(((FqName) entry.getKey()).shortName(), entry.getValue()));
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Tuples2 tuples2 : arrayList) {
            Name name = (Name) tuples2.getSecond();
            Object arrayList2 = linkedHashMap.get(name);
            if (arrayList2 == null) {
                arrayList2 = new ArrayList();
                linkedHashMap.put(name, arrayList2);
            }
            ((List) arrayList2).add((Name) tuples2.getFirst());
        }
        f23278c = linkedHashMap;
        Set<FqName> setKeySet = f23277b.keySet();
        f23279d = setKeySet;
        ArrayList arrayList3 = new ArrayList(Iterables2.collectionSizeOrDefault(setKeySet, 10));
        Iterator<T> it2 = setKeySet.iterator();
        while (it2.hasNext()) {
            arrayList3.add(((FqName) it2.next()).shortName());
        }
        f23280e = _Collections.toSet(arrayList3);
    }

    public final Map<FqName, Name> getPROPERTY_FQ_NAME_TO_JVM_GETTER_NAME_MAP() {
        return f23277b;
    }

    public final List<Name> getPropertyNameCandidatesBySpecialGetterName(Name name) {
        Intrinsics3.checkNotNullParameter(name, "name1");
        List<Name> list = f23278c.get(name);
        return list == null ? Collections2.emptyList() : list;
    }

    public final Set<FqName> getSPECIAL_FQ_NAMES() {
        return f23279d;
    }

    public final Set<Name> getSPECIAL_SHORT_NAMES() {
        return f23280e;
    }
}

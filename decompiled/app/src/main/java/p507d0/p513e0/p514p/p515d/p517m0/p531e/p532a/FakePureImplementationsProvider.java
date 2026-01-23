package p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import p507d0.p513e0.p514p.p515d.p517m0.p518b.StandardNames;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.FqName;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: renamed from: d0.e0.p.d.m0.e.a.q, reason: use source file name */
/* JADX INFO: compiled from: FakePureImplementationsProvider.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class FakePureImplementationsProvider {

    /* JADX INFO: renamed from: a */
    public static final FakePureImplementationsProvider f23516a;

    /* JADX INFO: renamed from: b */
    public static final HashMap<FqName, FqName> f23517b;

    static {
        FakePureImplementationsProvider fakePureImplementationsProvider = new FakePureImplementationsProvider();
        f23516a = fakePureImplementationsProvider;
        f23517b = new HashMap<>();
        fakePureImplementationsProvider.m9519b(StandardNames.a.f22522S, fakePureImplementationsProvider.m9518a("java.util.ArrayList", "java.util.LinkedList"));
        fakePureImplementationsProvider.m9519b(StandardNames.a.f22524U, fakePureImplementationsProvider.m9518a("java.util.HashSet", "java.util.TreeSet", "java.util.LinkedHashSet"));
        fakePureImplementationsProvider.m9519b(StandardNames.a.f22525V, fakePureImplementationsProvider.m9518a("java.util.HashMap", "java.util.TreeMap", "java.util.LinkedHashMap", "java.util.concurrent.ConcurrentHashMap", "java.util.concurrent.ConcurrentSkipListMap"));
        fakePureImplementationsProvider.m9519b(new FqName("java.util.function.Function"), fakePureImplementationsProvider.m9518a("java.util.function.UnaryOperator"));
        fakePureImplementationsProvider.m9519b(new FqName("java.util.function.BiFunction"), fakePureImplementationsProvider.m9518a("java.util.function.BinaryOperator"));
    }

    /* JADX INFO: renamed from: a */
    public final List<FqName> m9518a(String... strArr) {
        ArrayList arrayList = new ArrayList(strArr.length);
        for (String str : strArr) {
            arrayList.add(new FqName(str));
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: b */
    public final void m9519b(FqName fqName, List<FqName> list) {
        AbstractMap abstractMap = f23517b;
        for (Object obj : list) {
            abstractMap.put(obj, fqName);
        }
    }

    public final FqName getPurelyImplementedInterface(FqName fqName) {
        Intrinsics3.checkNotNullParameter(fqName, "classFqName");
        return f23517b.get(fqName);
    }
}

package p507d0.p513e0.p514p.p515d.p517m0.p518b;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import p507d0.p513e0.p514p.p515d.p517m0.p518b.StandardNames;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.ClassId;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.FqName;
import p507d0.p580t.Iterables2;
import p507d0.p580t._Collections;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: renamed from: d0.e0.p.d.m0.b.c, reason: use source file name */
/* JADX INFO: compiled from: CompanionObjectMapping.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class CompanionObjectMapping {

    /* JADX INFO: renamed from: a */
    public static final CompanionObjectMapping f22455a = new CompanionObjectMapping();

    /* JADX INFO: renamed from: b */
    public static final Set<ClassId> f22456b;

    static {
        Set<PrimitiveType> set = PrimitiveType.f22472j;
        StandardNames standardNames = StandardNames.f22488a;
        ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(set, 10));
        Iterator<T> it = set.iterator();
        while (it.hasNext()) {
            arrayList.add(StandardNames.getPrimitiveFqName((PrimitiveType) it.next()));
        }
        FqName safe = StandardNames.a.f22542g.toSafe();
        Intrinsics3.checkNotNullExpressionValue(safe, "string.toSafe()");
        List listPlus = _Collections.plus((Collection<? extends FqName>) arrayList, safe);
        FqName safe2 = StandardNames.a.f22546i.toSafe();
        Intrinsics3.checkNotNullExpressionValue(safe2, "_boolean.toSafe()");
        List listPlus2 = _Collections.plus((Collection<? extends FqName>) listPlus, safe2);
        FqName safe3 = StandardNames.a.f22563r.toSafe();
        Intrinsics3.checkNotNullExpressionValue(safe3, "_enum.toSafe()");
        List listPlus3 = _Collections.plus((Collection<? extends FqName>) listPlus2, safe3);
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        Iterator it2 = listPlus3.iterator();
        while (it2.hasNext()) {
            linkedHashSet.add(ClassId.topLevel((FqName) it2.next()));
        }
        f22456b = linkedHashSet;
    }

    public final Set<ClassId> allClassesWithIntrinsicCompanions() {
        return f22456b;
    }

    public final Set<ClassId> getClassIds() {
        return f22456b;
    }
}

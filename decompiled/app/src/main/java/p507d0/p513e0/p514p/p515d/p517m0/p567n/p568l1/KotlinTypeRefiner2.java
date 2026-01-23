package p507d0.p513e0.p514p.p515d.p517m0.p567n.p568l1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.ModuleCapability;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType;
import p507d0.p580t.Iterables2;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: renamed from: d0.e0.p.d.m0.n.l1.h, reason: use source file name */
/* JADX INFO: compiled from: KotlinTypeRefiner.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class KotlinTypeRefiner2 {

    /* JADX INFO: renamed from: a */
    public static final ModuleCapability<KotlinTypeRefiner3<KotlinTypeRefiner>> f24808a = new ModuleCapability<>("KotlinTypeRefiner");

    public static final ModuleCapability<KotlinTypeRefiner3<KotlinTypeRefiner>> getREFINER_CAPABILITY() {
        return f24808a;
    }

    public static final List<KotlinType> refineTypes(KotlinTypeRefiner kotlinTypeRefiner, Iterable<? extends KotlinType> iterable) {
        Intrinsics3.checkNotNullParameter(kotlinTypeRefiner, "<this>");
        Intrinsics3.checkNotNullParameter(iterable, "types");
        ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(iterable, 10));
        Iterator<? extends KotlinType> it = iterable.iterator();
        while (it.hasNext()) {
            arrayList.add(kotlinTypeRefiner.refineType(it.next()));
        }
        return arrayList;
    }
}

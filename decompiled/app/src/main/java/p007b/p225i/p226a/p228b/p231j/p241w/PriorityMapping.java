package p007b.p225i.p226a.p228b.p231j.p241w;

import android.util.SparseArray;
import androidx.annotation.NonNull;
import java.util.EnumMap;
import p007b.p100d.p104b.p105a.outline;
import p007b.p225i.p226a.p228b.Priority3;

/* JADX INFO: renamed from: b.i.a.b.j.w.a, reason: use source file name */
/* JADX INFO: compiled from: PriorityMapping.java */
/* JADX INFO: loaded from: classes3.dex */
public final class PriorityMapping {

    /* JADX INFO: renamed from: a */
    public static SparseArray<Priority3> f5461a = new SparseArray<>();

    /* JADX INFO: renamed from: b */
    public static EnumMap<Priority3, Integer> f5462b;

    static {
        EnumMap<Priority3, Integer> enumMap = new EnumMap<>(Priority3.class);
        f5462b = enumMap;
        enumMap.put(Priority3.DEFAULT, 0);
        f5462b.put(Priority3.VERY_LOW, 1);
        f5462b.put(Priority3.HIGHEST, 2);
        for (K k : f5462b.keySet()) {
            f5461a.append(f5462b.get(k).intValue(), k);
        }
    }

    /* JADX INFO: renamed from: a */
    public static int m2414a(@NonNull Priority3 priority3) {
        Integer num = f5462b.get(priority3);
        if (num != null) {
            return num.intValue();
        }
        throw new IllegalStateException("PriorityMapping is missing known Priority value " + priority3);
    }

    @NonNull
    /* JADX INFO: renamed from: b */
    public static Priority3 m2415b(int i) {
        Priority3 priority3 = f5461a.get(i);
        if (priority3 != null) {
            return priority3;
        }
        throw new IllegalArgumentException(outline.m871q("Unknown Priority for value ", i));
    }
}

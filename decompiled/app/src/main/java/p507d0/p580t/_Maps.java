package p507d0.p580t;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Tuples2;
import kotlin.sequences.Sequence;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: _Maps.kt */
/* renamed from: d0.t.i0, reason: use source file name */
/* loaded from: classes3.dex */
public class _Maps extends Maps6 {
    public static final <K, V> Sequence<Map.Entry<K, V>> asSequence(Map<? extends K, ? extends V> map) {
        Intrinsics3.checkNotNullParameter(map, "$this$asSequence");
        return _Collections.asSequence(map.entrySet());
    }

    public static final <K, V> List<Tuples2<K, V>> toList(Map<? extends K, ? extends V> map) {
        Intrinsics3.checkNotNullParameter(map, "$this$toList");
        if (map.size() == 0) {
            return Collections2.emptyList();
        }
        Iterator<Map.Entry<? extends K, ? extends V>> it = map.entrySet().iterator();
        if (!it.hasNext()) {
            return Collections2.emptyList();
        }
        Map.Entry<? extends K, ? extends V> next = it.next();
        if (!it.hasNext()) {
            return CollectionsJVM.listOf(new Tuples2(next.getKey(), next.getValue()));
        }
        ArrayList arrayList = new ArrayList(map.size());
        arrayList.add(new Tuples2(next.getKey(), next.getValue()));
        do {
            Map.Entry<? extends K, ? extends V> next2 = it.next();
            arrayList.add(new Tuples2(next2.getKey(), next2.getValue()));
        } while (it.hasNext());
        return arrayList;
    }
}

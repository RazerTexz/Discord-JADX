package p507d0.p580t.p581q0;

import java.util.Map;
import java.util.Map.Entry;
import p507d0.p580t.AbstractMutableSet;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: renamed from: d0.t.q0.a, reason: use source file name */
/* JADX INFO: compiled from: MapBuilder.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class MapBuilder<E extends Map.Entry<? extends K, ? extends V>, K, V> extends AbstractMutableSet<E> {
    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final /* bridge */ boolean contains(Object obj) {
        if (obj instanceof Map.Entry) {
            return contains((Map.Entry) obj);
        }
        return false;
    }

    public abstract boolean containsEntry(Map.Entry<? extends K, ? extends V> entry);

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final /* bridge */ boolean remove(Object obj) {
        if (obj instanceof Map.Entry) {
            return remove((Map.Entry) obj);
        }
        return false;
    }

    public abstract /* bridge */ boolean remove(Map.Entry entry);

    public final boolean contains(E e) {
        Intrinsics3.checkNotNullParameter(e, "element");
        return containsEntry(e);
    }
}

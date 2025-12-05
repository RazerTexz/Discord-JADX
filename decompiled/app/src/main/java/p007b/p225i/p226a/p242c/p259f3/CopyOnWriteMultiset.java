package p007b.p225i.p226a.p242c.p259f3;

import androidx.annotation.GuardedBy;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* compiled from: CopyOnWriteMultiset.java */
/* renamed from: b.i.a.c.f3.l, reason: use source file name */
/* loaded from: classes3.dex */
public final class CopyOnWriteMultiset<E> implements Iterable<E> {

    /* renamed from: j */
    public final Object f6729j = new Object();

    /* renamed from: k */
    @GuardedBy("lock")
    public final Map<E, Integer> f6730k = new HashMap();

    /* renamed from: l */
    @GuardedBy("lock")
    public Set<E> f6731l = Collections.emptySet();

    /* renamed from: m */
    @GuardedBy("lock")
    public List<E> f6732m = Collections.emptyList();

    /* renamed from: c */
    public int m3027c(E e) {
        int iIntValue;
        synchronized (this.f6729j) {
            iIntValue = this.f6730k.containsKey(e) ? this.f6730k.get(e).intValue() : 0;
        }
        return iIntValue;
    }

    @Override // java.lang.Iterable
    public Iterator<E> iterator() {
        Iterator<E> it;
        synchronized (this.f6729j) {
            it = this.f6732m.iterator();
        }
        return it;
    }
}

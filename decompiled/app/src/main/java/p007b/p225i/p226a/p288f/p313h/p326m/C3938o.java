package p007b.p225i.p226a.p288f.p313h.p326m;

import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.WeakHashMap;

/* renamed from: b.i.a.f.h.m.o */
/* loaded from: classes3.dex */
public final class C3938o<K, V> {

    /* renamed from: a */
    public final Map<K, WeakReference<V>> f10465a = new WeakHashMap();

    /* renamed from: a */
    public final boolean m5407a(K k) {
        return m5408b(k) != null;
    }

    /* renamed from: b */
    public final V m5408b(K k) {
        WeakReference<V> weakReference = this.f10465a.get(k);
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }
}

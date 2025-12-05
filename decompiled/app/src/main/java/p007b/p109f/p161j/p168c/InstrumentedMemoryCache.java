package p007b.p109f.p161j.p168c;

import com.facebook.common.references.CloseableReference;
import p007b.p109f.p115d.p119d.Predicate2;

/* compiled from: InstrumentedMemoryCache.java */
/* renamed from: b.f.j.c.s, reason: use source file name */
/* loaded from: classes.dex */
public class InstrumentedMemoryCache<K, V> implements MemoryCache<K, V> {

    /* renamed from: a */
    public final MemoryCache<K, V> f3687a;

    /* renamed from: b */
    public final MemoryCacheTracker f3688b;

    public InstrumentedMemoryCache(MemoryCache<K, V> memoryCache, MemoryCacheTracker memoryCacheTracker) {
        this.f3687a = memoryCache;
        this.f3688b = memoryCacheTracker;
    }

    @Override // p007b.p109f.p161j.p168c.MemoryCache
    /* renamed from: a */
    public CloseableReference<V> mo1235a(K k, CloseableReference<V> closeableReference) {
        this.f3688b.mo1234c(k);
        return this.f3687a.mo1235a(k, closeableReference);
    }

    @Override // p007b.p109f.p161j.p168c.MemoryCache
    /* renamed from: d */
    public int mo1236d(Predicate2<K> predicate2) {
        return this.f3687a.mo1236d(predicate2);
    }

    @Override // p007b.p109f.p161j.p168c.MemoryCache
    public CloseableReference<V> get(K k) {
        CloseableReference<V> closeableReference = this.f3687a.get(k);
        if (closeableReference == null) {
            this.f3688b.mo1233b(k);
        } else {
            this.f3688b.mo1232a(k);
        }
        return closeableReference;
    }
}

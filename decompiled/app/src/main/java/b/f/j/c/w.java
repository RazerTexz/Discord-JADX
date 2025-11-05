package b.f.j.c;

import com.facebook.common.references.CloseableReference;

/* compiled from: MemoryCache.java */
/* loaded from: classes.dex */
public interface w<K, V> extends b.f.d.g.b {

    /* compiled from: MemoryCache.java */
    public interface a {
    }

    CloseableReference<V> a(K k, CloseableReference<V> closeableReference);

    boolean contains(K k);

    int d(b.f.d.d.j<K> jVar);

    CloseableReference<V> get(K k);
}

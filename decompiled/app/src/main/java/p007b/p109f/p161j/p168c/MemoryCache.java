package p007b.p109f.p161j.p168c;

import com.facebook.common.references.CloseableReference;
import p007b.p109f.p115d.p119d.Predicate2;
import p007b.p109f.p115d.p122g.MemoryTrimmable;

/* compiled from: MemoryCache.java */
/* renamed from: b.f.j.c.w, reason: use source file name */
/* loaded from: classes.dex */
public interface MemoryCache<K, V> extends MemoryTrimmable {

    /* compiled from: MemoryCache.java */
    /* renamed from: b.f.j.c.w$a */
    public interface a {
    }

    /* renamed from: a */
    CloseableReference<V> mo1235a(K k, CloseableReference<V> closeableReference);

    boolean contains(K k);

    /* renamed from: d */
    int mo1236d(Predicate2<K> predicate2);

    CloseableReference<V> get(K k);
}

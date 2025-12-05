package p007b.p109f.p161j.p168c;

import androidx.annotation.VisibleForTesting;
import com.facebook.common.references.CloseableReference;
import java.util.Objects;
import p007b.p109f.p115d.p122g.MemoryTrimmable;

/* compiled from: CountingMemoryCache.java */
/* renamed from: b.f.j.c.m, reason: use source file name */
/* loaded from: classes.dex */
public interface CountingMemoryCache<K, V> extends MemoryCache<K, V>, MemoryTrimmable {

    /* compiled from: CountingMemoryCache.java */
    @VisibleForTesting
    /* renamed from: b.f.j.c.m$a */
    public static class a<K, V> {

        /* renamed from: a */
        public final K f3678a;

        /* renamed from: b */
        public final CloseableReference<V> f3679b;

        /* renamed from: c */
        public int f3680c;

        /* renamed from: d */
        public boolean f3681d;

        /* renamed from: e */
        public final b<K> f3682e;

        /* renamed from: f */
        public int f3683f;

        public a(K k, CloseableReference<V> closeableReference, b<K> bVar, int i) {
            Objects.requireNonNull(k);
            this.f3678a = k;
            CloseableReference<V> closeableReferenceM8636n = CloseableReference.m8636n(closeableReference);
            Objects.requireNonNull(closeableReferenceM8636n);
            this.f3679b = closeableReferenceM8636n;
            this.f3680c = 0;
            this.f3681d = false;
            this.f3682e = bVar;
            this.f3683f = i;
        }
    }

    /* compiled from: CountingMemoryCache.java */
    /* renamed from: b.f.j.c.m$b */
    public interface b<K> {
    }

    /* renamed from: b */
    CloseableReference<V> mo1227b(K k);

    /* renamed from: c */
    CloseableReference<V> mo1228c(K k, CloseableReference<V> closeableReference, b<K> bVar);
}

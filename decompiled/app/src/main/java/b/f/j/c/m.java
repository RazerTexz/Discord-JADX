package b.f.j.c;

import androidx.annotation.VisibleForTesting;
import com.facebook.common.references.CloseableReference;
import java.util.Objects;

/* compiled from: CountingMemoryCache.java */
/* loaded from: classes.dex */
public interface m<K, V> extends w<K, V>, b.f.d.g.b {

    /* compiled from: CountingMemoryCache.java */
    @VisibleForTesting
    public static class a<K, V> {
        public final K a;

        /* renamed from: b, reason: collision with root package name */
        public final CloseableReference<V> f558b;
        public int c;
        public boolean d;
        public final b<K> e;
        public int f;

        public a(K k, CloseableReference<V> closeableReference, b<K> bVar, int i) {
            Objects.requireNonNull(k);
            this.a = k;
            CloseableReference<V> closeableReferenceN = CloseableReference.n(closeableReference);
            Objects.requireNonNull(closeableReferenceN);
            this.f558b = closeableReferenceN;
            this.c = 0;
            this.d = false;
            this.e = bVar;
            this.f = i;
        }
    }

    /* compiled from: CountingMemoryCache.java */
    public interface b<K> {
    }

    CloseableReference<V> b(K k);

    CloseableReference<V> c(K k, CloseableReference<V> closeableReference, b<K> bVar);
}

package p007b.p109f.p161j.p168c;

import com.facebook.cache.common.CacheKey;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.common.references.CloseableReference;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import p007b.p085c.p086a.p087a0.AnimatableValueParser;
import p007b.p109f.p115d.p120e.FLog;
import p007b.p109f.p161j.p175j.EncodedImage2;

/* JADX INFO: renamed from: b.f.j.c.a0, reason: use source file name */
/* JADX INFO: compiled from: StagingArea.java */
/* JADX INFO: loaded from: classes.dex */
public class StagingArea {

    /* JADX INFO: renamed from: a */
    public Map<CacheKey, EncodedImage2> f3647a = new HashMap();

    /* JADX INFO: renamed from: a */
    public synchronized EncodedImage2 m1208a(CacheKey cacheKey) {
        Objects.requireNonNull(cacheKey);
        EncodedImage2 encodedImage2M1336a = this.f3647a.get(cacheKey);
        if (encodedImage2M1336a != null) {
            synchronized (encodedImage2M1336a) {
                if (!EncodedImage2.m1338u(encodedImage2M1336a)) {
                    this.f3647a.remove(cacheKey);
                    FLog.m985m(StagingArea.class, "Found closed reference %d for key %s (%d)", Integer.valueOf(System.identityHashCode(encodedImage2M1336a)), cacheKey.mo930b(), Integer.valueOf(System.identityHashCode(cacheKey)));
                    return null;
                }
                encodedImage2M1336a = EncodedImage2.m1336a(encodedImage2M1336a);
            }
        }
        return encodedImage2M1336a;
    }

    /* JADX INFO: renamed from: b */
    public synchronized void m1209b(CacheKey cacheKey, EncodedImage2 encodedImage2) {
        AnimatableValueParser.m527i(Boolean.valueOf(EncodedImage2.m1338u(encodedImage2)));
        EncodedImage2 encodedImage2Put = this.f3647a.put(cacheKey, EncodedImage2.m1336a(encodedImage2));
        if (encodedImage2Put != null) {
            encodedImage2Put.close();
        }
        synchronized (this) {
            this.f3647a.size();
            int i = FLog.f3102a;
        }
    }

    /* JADX INFO: renamed from: c */
    public boolean m1210c(CacheKey cacheKey) {
        EncodedImage2 encodedImage2Remove;
        Objects.requireNonNull(cacheKey);
        synchronized (this) {
            encodedImage2Remove = this.f3647a.remove(cacheKey);
        }
        if (encodedImage2Remove == null) {
            return false;
        }
        try {
            return encodedImage2Remove.m1346t();
        } finally {
            encodedImage2Remove.close();
        }
    }

    /* JADX INFO: renamed from: d */
    public synchronized boolean m1211d(CacheKey cacheKey, EncodedImage2 encodedImage2) {
        Objects.requireNonNull(cacheKey);
        Objects.requireNonNull(encodedImage2);
        AnimatableValueParser.m527i(Boolean.valueOf(EncodedImage2.m1338u(encodedImage2)));
        EncodedImage2 encodedImage22 = this.f3647a.get(cacheKey);
        if (encodedImage22 == null) {
            return false;
        }
        CloseableReference<PooledByteBuffer> closeableReferenceM1340c = encodedImage22.m1340c();
        CloseableReference<PooledByteBuffer> closeableReferenceM1340c2 = encodedImage2.m1340c();
        if (closeableReferenceM1340c != null && closeableReferenceM1340c2 != null) {
            try {
                if (closeableReferenceM1340c.m8642u() == closeableReferenceM1340c2.m8642u()) {
                    this.f3647a.remove(cacheKey);
                    synchronized (this) {
                        this.f3647a.size();
                        int i = FLog.f3102a;
                    }
                    return true;
                }
            } finally {
                closeableReferenceM1340c2.close();
                closeableReferenceM1340c.close();
                encodedImage22.close();
            }
        }
        if (closeableReferenceM1340c2 != null) {
            closeableReferenceM1340c2.close();
        }
        if (closeableReferenceM1340c != null) {
            closeableReferenceM1340c.close();
        }
        encodedImage22.close();
        return false;
    }
}

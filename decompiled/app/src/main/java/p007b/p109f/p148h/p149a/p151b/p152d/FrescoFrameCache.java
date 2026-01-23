package p007b.p109f.p148h.p149a.p151b.p152d;

import android.graphics.Bitmap;
import android.util.SparseArray;
import androidx.annotation.VisibleForTesting;
import com.facebook.cache.common.CacheKey;
import com.facebook.common.references.CloseableReference;
import java.util.Iterator;
import java.util.Objects;
import p007b.p109f.p115d.p120e.FLog;
import p007b.p109f.p148h.p149a.p151b.BitmapFrameCache;
import p007b.p109f.p161j.p162a.p165c.AnimatedFrameCache;
import p007b.p109f.p161j.p175j.CloseableImage;
import p007b.p109f.p161j.p175j.CloseableStaticBitmap;
import p007b.p109f.p161j.p175j.ImmutableQualityInfo;

/* JADX INFO: renamed from: b.f.h.a.b.d.b, reason: use source file name */
/* JADX INFO: compiled from: FrescoFrameCache.java */
/* JADX INFO: loaded from: classes.dex */
public class FrescoFrameCache implements BitmapFrameCache {

    /* JADX INFO: renamed from: a */
    public final AnimatedFrameCache f3509a;

    /* JADX INFO: renamed from: b */
    public final boolean f3510b;

    /* JADX INFO: renamed from: c */
    public final SparseArray<CloseableReference<CloseableImage>> f3511c = new SparseArray<>();

    /* JADX INFO: renamed from: d */
    public CloseableReference<CloseableImage> f3512d;

    public FrescoFrameCache(AnimatedFrameCache animatedFrameCache, boolean z2) {
        this.f3509a = animatedFrameCache;
        this.f3510b = z2;
    }

    @VisibleForTesting
    /* JADX INFO: renamed from: g */
    public static CloseableReference<Bitmap> m1157g(CloseableReference<CloseableImage> closeableReference) {
        CloseableReference<Bitmap> closeableReferenceM8636n;
        try {
            if (!CloseableReference.m8640y(closeableReference) || !(closeableReference.m8642u() instanceof CloseableStaticBitmap)) {
                if (closeableReference != null) {
                    closeableReference.close();
                }
                return null;
            }
            CloseableStaticBitmap closeableStaticBitmap = (CloseableStaticBitmap) closeableReference.m8642u();
            synchronized (closeableStaticBitmap) {
                closeableReferenceM8636n = CloseableReference.m8636n(closeableStaticBitmap.f3886l);
            }
            closeableReference.close();
            return closeableReferenceM8636n;
        } catch (Throwable th) {
            Class<CloseableReference> cls = CloseableReference.f19438j;
            if (closeableReference != null) {
                closeableReference.close();
            }
            throw th;
        }
    }

    @Override // p007b.p109f.p148h.p149a.p151b.BitmapFrameCache
    /* JADX INFO: renamed from: a */
    public synchronized CloseableReference<Bitmap> mo1151a(int i, int i2, int i3) {
        CacheKey next;
        CloseableReference<CloseableImage> closeableReference = null;
        if (!this.f3510b) {
            return null;
        }
        AnimatedFrameCache animatedFrameCache = this.f3509a;
        while (true) {
            synchronized (animatedFrameCache) {
                Iterator<CacheKey> it = animatedFrameCache.f3637d.iterator();
                if (it.hasNext()) {
                    next = it.next();
                    it.remove();
                } else {
                    next = null;
                }
            }
            if (next == null) {
                break;
            }
            CloseableReference<CloseableImage> closeableReferenceMo1227b = animatedFrameCache.f3635b.mo1227b(next);
            if (closeableReferenceMo1227b != null) {
                closeableReference = closeableReferenceMo1227b;
                break;
            }
        }
        return m1157g(closeableReference);
    }

    @Override // p007b.p109f.p148h.p149a.p151b.BitmapFrameCache
    /* JADX INFO: renamed from: b */
    public synchronized void mo1152b(int i, CloseableReference<Bitmap> closeableReference, int i2) {
        CloseableReference closeableReference2 = null;
        try {
            CloseableReference<CloseableImage> closeableReferenceM8632A = CloseableReference.m8632A(new CloseableStaticBitmap(closeableReference, ImmutableQualityInfo.f3908a, 0, 0));
            if (closeableReferenceM8632A == null) {
                if (closeableReferenceM8632A != null) {
                    closeableReferenceM8632A.close();
                }
                return;
            }
            AnimatedFrameCache animatedFrameCache = this.f3509a;
            CloseableReference<CloseableImage> closeableReferenceMo1228c = animatedFrameCache.f3635b.mo1228c(new AnimatedFrameCache.b(animatedFrameCache.f3634a, i), closeableReferenceM8632A, animatedFrameCache.f3636c);
            if (CloseableReference.m8640y(closeableReferenceMo1228c)) {
                CloseableReference<CloseableImage> closeableReference3 = this.f3511c.get(i);
                if (closeableReference3 != null) {
                    closeableReference3.close();
                }
                this.f3511c.put(i, closeableReferenceMo1228c);
                int i3 = FLog.f3102a;
            }
            closeableReferenceM8632A.close();
        } catch (Throwable th) {
            if (0 != 0) {
                closeableReference2.close();
            }
            throw th;
        }
    }

    @Override // p007b.p109f.p148h.p149a.p151b.BitmapFrameCache
    /* JADX INFO: renamed from: c */
    public synchronized boolean mo1153c(int i) {
        AnimatedFrameCache animatedFrameCache;
        animatedFrameCache = this.f3509a;
        return animatedFrameCache.f3635b.contains(new AnimatedFrameCache.b(animatedFrameCache.f3634a, i));
    }

    @Override // p007b.p109f.p148h.p149a.p151b.BitmapFrameCache
    public synchronized void clear() {
        CloseableReference<CloseableImage> closeableReference = this.f3512d;
        Class<CloseableReference> cls = CloseableReference.f19438j;
        if (closeableReference != null) {
            closeableReference.close();
        }
        this.f3512d = null;
        for (int i = 0; i < this.f3511c.size(); i++) {
            CloseableReference<CloseableImage> closeableReferenceValueAt = this.f3511c.valueAt(i);
            if (closeableReferenceValueAt != null) {
                closeableReferenceValueAt.close();
            }
        }
        this.f3511c.clear();
    }

    @Override // p007b.p109f.p148h.p149a.p151b.BitmapFrameCache
    /* JADX INFO: renamed from: d */
    public synchronized CloseableReference<Bitmap> mo1154d(int i) {
        AnimatedFrameCache animatedFrameCache;
        animatedFrameCache = this.f3509a;
        return m1157g(animatedFrameCache.f3635b.get(new AnimatedFrameCache.b(animatedFrameCache.f3634a, i)));
    }

    @Override // p007b.p109f.p148h.p149a.p151b.BitmapFrameCache
    /* JADX INFO: renamed from: e */
    public synchronized void mo1155e(int i, CloseableReference<Bitmap> closeableReference, int i2) {
        CloseableReference<CloseableImage> closeableReferenceM8632A;
        try {
            synchronized (this) {
                Objects.requireNonNull(closeableReference);
                synchronized (this) {
                    CloseableReference<CloseableImage> closeableReference2 = this.f3511c.get(i);
                    if (closeableReference2 != null) {
                        this.f3511c.delete(i);
                        Class<CloseableReference> cls = CloseableReference.f19438j;
                        closeableReference2.close();
                        int i3 = FLog.f3102a;
                    }
                }
                return;
            }
            closeableReferenceM8632A = CloseableReference.m8632A(new CloseableStaticBitmap(closeableReference, ImmutableQualityInfo.f3908a, 0, 0));
            if (closeableReferenceM8632A != null) {
                CloseableReference<CloseableImage> closeableReference3 = this.f3512d;
                if (closeableReference3 != null) {
                    closeableReference3.close();
                }
                AnimatedFrameCache animatedFrameCache = this.f3509a;
                this.f3512d = animatedFrameCache.f3635b.mo1228c(new AnimatedFrameCache.b(animatedFrameCache.f3634a, i), closeableReferenceM8632A, animatedFrameCache.f3636c);
            }
            return;
        } finally {
            if (closeableReferenceM8632A != null) {
                closeableReferenceM8632A.close();
            }
        }
        closeableReferenceM8632A = null;
    }

    @Override // p007b.p109f.p148h.p149a.p151b.BitmapFrameCache
    /* JADX INFO: renamed from: f */
    public synchronized CloseableReference<Bitmap> mo1156f(int i) {
        return m1157g(CloseableReference.m8636n(this.f3512d));
    }
}

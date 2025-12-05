package p007b.p109f.p161j.p177l;

import android.graphics.Bitmap;
import java.util.LinkedList;
import java.util.Objects;
import p007b.p109f.p115d.p122g.MemoryTrimmableRegistry;
import p007b.p109f.p161j.p177l.BucketMap;

/* compiled from: LruBitmapPool.java */
/* renamed from: b.f.j.l.p, reason: use source file name */
/* loaded from: classes3.dex */
public class LruBitmapPool implements BitmapPool {

    /* renamed from: a */
    public final LruBucketsPoolBackend<Bitmap> f3945a = new BitmapPoolBackend();

    /* renamed from: b */
    public final int f3946b;

    /* renamed from: c */
    public int f3947c;

    /* renamed from: d */
    public final PoolStatsTracker f3948d;

    /* renamed from: e */
    public int f3949e;

    public LruBitmapPool(int i, int i2, PoolStatsTracker poolStatsTracker, MemoryTrimmableRegistry memoryTrimmableRegistry) {
        this.f3946b = i;
        this.f3947c = i2;
        this.f3948d = poolStatsTracker;
    }

    @Override // p007b.p109f.p115d.p122g.Pool2
    public Bitmap get(int i) {
        Bitmap bitmapMo1373a;
        Bitmap bitmapM1392c;
        synchronized (this) {
            int i2 = this.f3949e;
            int i3 = this.f3946b;
            if (i2 > i3) {
                synchronized (this) {
                    while (this.f3949e > i3 && (bitmapM1392c = this.f3945a.m1392c()) != null) {
                        int iMo1374b = this.f3945a.mo1374b(bitmapM1392c);
                        this.f3949e -= iMo1374b;
                        this.f3948d.mo1403e(iMo1374b);
                    }
                }
            }
            bitmapMo1373a = this.f3945a.mo1373a(i);
            if (bitmapMo1373a != null) {
                int iMo1374b2 = this.f3945a.mo1374b(bitmapMo1373a);
                this.f3949e -= iMo1374b2;
                this.f3948d.mo1400b(iMo1374b2);
            } else {
                this.f3948d.mo1399a(i);
                bitmapMo1373a = Bitmap.createBitmap(1, i, Bitmap.Config.ALPHA_8);
            }
        }
        return bitmapMo1373a;
    }

    @Override // p007b.p109f.p115d.p122g.Pool2, p007b.p109f.p115d.p123h.ResourceReleaser
    public void release(Object obj) {
        boolean zAdd;
        Bitmap bitmap = (Bitmap) obj;
        int iMo1374b = this.f3945a.mo1374b(bitmap);
        if (iMo1374b <= this.f3947c) {
            this.f3948d.mo1405g(iMo1374b);
            BitmapPoolBackend bitmapPoolBackend = (BitmapPoolBackend) this.f3945a;
            Objects.requireNonNull(bitmapPoolBackend);
            if (bitmapPoolBackend.m1375d(bitmap)) {
                synchronized (bitmapPoolBackend) {
                    zAdd = bitmapPoolBackend.f3950a.add(bitmap);
                }
                if (zAdd) {
                    BucketMap<T> bucketMap = bitmapPoolBackend.f3951b;
                    int iMo1374b2 = bitmapPoolBackend.mo1374b(bitmap);
                    synchronized (bucketMap) {
                        BucketMap.b bVar = (BucketMap.b) bucketMap.f3931a.get(iMo1374b2);
                        if (bVar == null) {
                            BucketMap.b bVar2 = new BucketMap.b(null, iMo1374b2, new LinkedList(), null, null);
                            bucketMap.f3931a.put(iMo1374b2, bVar2);
                            bVar = bVar2;
                        }
                        bVar.f3936c.addLast(bitmap);
                        bucketMap.m1380a(bVar);
                    }
                }
            }
            synchronized (this) {
                this.f3949e += iMo1374b;
            }
        }
    }
}

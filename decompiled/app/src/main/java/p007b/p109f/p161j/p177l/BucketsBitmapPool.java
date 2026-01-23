package p007b.p109f.p161j.p177l;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import com.facebook.imagepipeline.memory.BasePool;
import p007b.p109f.p115d.p122g.MemoryTrimmableRegistry;

/* JADX INFO: renamed from: b.f.j.l.h, reason: use source file name */
/* JADX INFO: compiled from: BucketsBitmapPool.java */
/* JADX INFO: loaded from: classes3.dex */
@TargetApi(21)
public class BucketsBitmapPool extends BasePool<Bitmap> implements BitmapPool {
    public BucketsBitmapPool(MemoryTrimmableRegistry memoryTrimmableRegistry, PoolParams poolParams, PoolStatsTracker poolStatsTracker, boolean z2) {
        super(memoryTrimmableRegistry, poolParams, poolStatsTracker);
        this.f19557j = z2;
        m8699m();
    }

    @Override // com.facebook.imagepipeline.memory.BasePool
    /* JADX INFO: renamed from: e */
    public Bitmap mo1382e(int i) {
        return Bitmap.createBitmap(1, (int) Math.ceil(((double) i) / 2.0d), Bitmap.Config.RGB_565);
    }

    @Override // com.facebook.imagepipeline.memory.BasePool
    /* JADX INFO: renamed from: g */
    public void mo1383g(Bitmap bitmap) {
        bitmap.recycle();
    }

    @Override // com.facebook.imagepipeline.memory.BasePool
    /* JADX INFO: renamed from: i */
    public int mo1384i(int i) {
        return i;
    }

    @Override // com.facebook.imagepipeline.memory.BasePool
    /* JADX INFO: renamed from: j */
    public int mo1385j(Bitmap bitmap) {
        return bitmap.getAllocationByteCount();
    }

    @Override // com.facebook.imagepipeline.memory.BasePool
    /* JADX INFO: renamed from: k */
    public int mo1386k(int i) {
        return i;
    }

    @Override // com.facebook.imagepipeline.memory.BasePool
    /* JADX INFO: renamed from: l */
    public Bitmap mo1387l(Bucket2<Bitmap> bucket2) {
        Bitmap bitmap = (Bitmap) super.mo1387l(bucket2);
        if (bitmap != null) {
            bitmap.eraseColor(0);
        }
        return bitmap;
    }

    @Override // com.facebook.imagepipeline.memory.BasePool
    /* JADX INFO: renamed from: o */
    public boolean mo1388o(Bitmap bitmap) {
        Bitmap bitmap2 = bitmap;
        return !bitmap2.isRecycled() && bitmap2.isMutable();
    }
}

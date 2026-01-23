package p007b.p109f.p161j.p177l;

import android.graphics.Bitmap;
import p007b.p109f.p115d.p120e.FLog;
import p007b.p109f.p161j.p177l.BucketMap;
import p007b.p109f.p186k.BitmapUtil;

/* JADX INFO: renamed from: b.f.j.l.e, reason: use source file name */
/* JADX INFO: compiled from: BitmapPoolBackend.java */
/* JADX INFO: loaded from: classes3.dex */
public class BitmapPoolBackend extends LruBucketsPoolBackend<Bitmap> {
    @Override // p007b.p109f.p161j.p177l.LruBucketsPoolBackend
    /* JADX INFO: renamed from: a */
    public Bitmap mo1373a(int i) {
        Object objPollFirst;
        BucketMap<T> bucketMap = this.f3951b;
        synchronized (bucketMap) {
            BucketMap.b bVar = (BucketMap.b) bucketMap.f3931a.get(i);
            if (bVar == null) {
                objPollFirst = null;
            } else {
                objPollFirst = bVar.f3936c.pollFirst();
                bucketMap.m1380a(bVar);
            }
        }
        if (objPollFirst != null) {
            synchronized (this) {
                this.f3950a.remove(objPollFirst);
            }
        }
        Bitmap bitmap = (Bitmap) objPollFirst;
        if (bitmap == null || !m1375d(bitmap)) {
            return null;
        }
        bitmap.eraseColor(0);
        return bitmap;
    }

    @Override // p007b.p109f.p161j.p177l.LruBucketsPoolBackend
    /* JADX INFO: renamed from: b */
    public int mo1374b(Bitmap bitmap) {
        return BitmapUtil.m1541d(bitmap);
    }

    /* JADX INFO: renamed from: d */
    public boolean m1375d(Bitmap bitmap) {
        if (bitmap == null) {
            return false;
        }
        if (bitmap.isRecycled()) {
            FLog.m988p("BitmapPoolBackend", "Cannot reuse a recycled bitmap: %s", bitmap);
            return false;
        }
        if (bitmap.isMutable()) {
            return true;
        }
        FLog.m988p("BitmapPoolBackend", "Cannot reuse an immutable bitmap: %s", bitmap);
        return false;
    }
}

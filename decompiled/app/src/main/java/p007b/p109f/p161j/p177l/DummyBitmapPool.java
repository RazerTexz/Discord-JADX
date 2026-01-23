package p007b.p109f.p161j.p177l;

import android.graphics.Bitmap;
import java.util.Objects;

/* JADX INFO: renamed from: b.f.j.l.l, reason: use source file name */
/* JADX INFO: compiled from: DummyBitmapPool.java */
/* JADX INFO: loaded from: classes3.dex */
public class DummyBitmapPool implements BitmapPool {
    @Override // p007b.p109f.p115d.p122g.Pool2
    public Bitmap get(int i) {
        return Bitmap.createBitmap(1, (int) Math.ceil(((double) i) / 2.0d), Bitmap.Config.RGB_565);
    }

    @Override // p007b.p109f.p115d.p122g.Pool2, p007b.p109f.p115d.p123h.ResourceReleaser
    public void release(Object obj) {
        Bitmap bitmap = (Bitmap) obj;
        Objects.requireNonNull(bitmap);
        bitmap.recycle();
    }
}

package p007b.p109f.p161j.p177l;

import android.graphics.Bitmap;
import java.util.Objects;

/* compiled from: DummyBitmapPool.java */
/* renamed from: b.f.j.l.l, reason: use source file name */
/* loaded from: classes3.dex */
public class DummyBitmapPool implements BitmapPool {
    @Override // p007b.p109f.p115d.p122g.Pool2
    public Bitmap get(int i) {
        return Bitmap.createBitmap(1, (int) Math.ceil(i / 2.0d), Bitmap.Config.RGB_565);
    }

    @Override // p007b.p109f.p115d.p122g.Pool2, p007b.p109f.p115d.p123h.ResourceReleaser
    public void release(Object obj) {
        Bitmap bitmap = (Bitmap) obj;
        Objects.requireNonNull(bitmap);
        bitmap.recycle();
    }
}

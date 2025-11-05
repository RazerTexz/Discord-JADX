package b.f.j.l;

import android.graphics.Bitmap;
import java.util.Objects;

/* compiled from: DummyBitmapPool.java */
/* loaded from: classes3.dex */
public class l implements d {
    @Override // b.f.d.g.e
    public Bitmap get(int i) {
        return Bitmap.createBitmap(1, (int) Math.ceil(i / 2.0d), Bitmap.Config.RGB_565);
    }

    @Override // b.f.d.g.e, b.f.d.h.f
    public void release(Object obj) {
        Bitmap bitmap = (Bitmap) obj;
        Objects.requireNonNull(bitmap);
        bitmap.recycle();
    }
}

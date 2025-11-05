package b.f.j.n;

import android.graphics.Bitmap;
import android.graphics.ColorSpace;
import android.graphics.Rect;
import b.f.j.j.e;
import com.facebook.common.references.CloseableReference;

/* compiled from: PlatformDecoder.java */
/* loaded from: classes3.dex */
public interface d {
    CloseableReference<Bitmap> a(e eVar, Bitmap.Config config, Rect rect, ColorSpace colorSpace);

    CloseableReference<Bitmap> b(e eVar, Bitmap.Config config, Rect rect, int i, ColorSpace colorSpace);
}

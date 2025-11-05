package b.f.j.b;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import b.f.j.l.d;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory;

/* compiled from: ArtBitmapFactory.java */
@TargetApi(21)
/* loaded from: classes2.dex */
public class a extends PlatformBitmapFactory {
    public final d a;

    /* renamed from: b, reason: collision with root package name */
    public final b.f.j.e.a f552b;

    public a(d dVar, b.f.j.e.a aVar) {
        this.a = dVar;
        this.f552b = aVar;
    }

    @Override // com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory
    public CloseableReference<Bitmap> b(int i, int i2, Bitmap.Config config) {
        Bitmap bitmap = this.a.get(b.f.k.a.c(i, i2, config));
        b.c.a.a0.d.i(Boolean.valueOf(bitmap.getAllocationByteCount() >= b.f.k.a.b(config) * (i * i2)));
        bitmap.reconfigure(i, i2, config);
        return CloseableReference.H(bitmap, this.a, this.f552b.a);
    }
}

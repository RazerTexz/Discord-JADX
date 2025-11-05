package b.f.j.a.b;

import android.graphics.Bitmap;
import b.f.j.a.a.f;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory;
import java.util.Objects;

/* compiled from: AnimatedImageFactoryImpl.java */
/* loaded from: classes2.dex */
public class e implements d {
    public static c a;

    /* renamed from: b, reason: collision with root package name */
    public static c f547b;
    public final b.f.j.a.c.b c;
    public final PlatformBitmapFactory d;

    static {
        c cVar;
        c cVar2 = null;
        try {
            cVar = (c) Class.forName("com.facebook.animated.gif.GifImage").newInstance();
        } catch (Throwable unused) {
            cVar = null;
        }
        a = cVar;
        try {
            cVar2 = (c) Class.forName("com.facebook.animated.webp.WebPImage").newInstance();
        } catch (Throwable unused2) {
        }
        f547b = cVar2;
    }

    public e(b.f.j.a.c.b bVar, PlatformBitmapFactory platformBitmapFactory) {
        this.c = bVar;
        this.d = platformBitmapFactory;
    }

    public final b.f.j.j.c a(b.f.j.d.b bVar, b.f.j.a.a.c cVar, Bitmap.Config config) {
        try {
            Objects.requireNonNull(bVar);
            f fVar = new f(cVar);
            fVar.f545b = CloseableReference.n(null);
            fVar.d = 0;
            fVar.c = CloseableReference.q(null);
            fVar.e = null;
            b.f.j.j.a aVar = new b.f.j.j.a(fVar.a());
            CloseableReference.t(null);
            return aVar;
        } catch (Throwable th) {
            Class<CloseableReference> cls = CloseableReference.j;
            CloseableReference.t(null);
            throw th;
        }
    }
}

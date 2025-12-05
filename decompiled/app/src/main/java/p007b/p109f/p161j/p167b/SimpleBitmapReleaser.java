package p007b.p109f.p161j.p167b;

import android.graphics.Bitmap;
import p007b.p109f.p115d.p123h.ResourceReleaser;

/* compiled from: SimpleBitmapReleaser.java */
/* renamed from: b.f.j.b.b, reason: use source file name */
/* loaded from: classes2.dex */
public class SimpleBitmapReleaser implements ResourceReleaser<Bitmap> {

    /* renamed from: a */
    public static SimpleBitmapReleaser f3646a;

    /* renamed from: a */
    public static SimpleBitmapReleaser m1207a() {
        if (f3646a == null) {
            f3646a = new SimpleBitmapReleaser();
        }
        return f3646a;
    }

    @Override // p007b.p109f.p115d.p123h.ResourceReleaser
    public void release(Bitmap bitmap) {
        bitmap.recycle();
    }
}

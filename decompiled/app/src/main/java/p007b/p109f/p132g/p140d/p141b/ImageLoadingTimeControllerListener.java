package p007b.p109f.p132g.p140d.p141b;

import android.graphics.drawable.Animatable;
import p007b.p109f.p132g.p139c.BaseControllerListener;
import p007b.p109f.p132g.p140d.DebugControllerOverlayDrawable;

/* compiled from: ImageLoadingTimeControllerListener.java */
/* renamed from: b.f.g.d.b.a, reason: use source file name */
/* loaded from: classes.dex */
public class ImageLoadingTimeControllerListener extends BaseControllerListener {

    /* renamed from: a */
    public long f3320a = -1;

    /* renamed from: b */
    public long f3321b = -1;

    /* renamed from: c */
    public ImageLoadingTimeListener f3322c;

    public ImageLoadingTimeControllerListener(ImageLoadingTimeListener imageLoadingTimeListener) {
        this.f3322c = imageLoadingTimeListener;
    }

    @Override // p007b.p109f.p132g.p139c.BaseControllerListener, com.facebook.drawee.controller.ControllerListener
    public void onFinalImageSet(String str, Object obj, Animatable animatable) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        this.f3321b = jCurrentTimeMillis;
        ImageLoadingTimeListener imageLoadingTimeListener = this.f3322c;
        if (imageLoadingTimeListener != null) {
            DebugControllerOverlayDrawable debugControllerOverlayDrawable = (DebugControllerOverlayDrawable) imageLoadingTimeListener;
            debugControllerOverlayDrawable.f3300B = jCurrentTimeMillis - this.f3320a;
            debugControllerOverlayDrawable.invalidateSelf();
        }
    }

    @Override // p007b.p109f.p132g.p139c.BaseControllerListener, com.facebook.drawee.controller.ControllerListener
    public void onSubmit(String str, Object obj) {
        this.f3320a = System.currentTimeMillis();
    }
}

package p007b.p109f.p132g.p133a.p134a;

import android.content.res.Resources;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import p007b.p109f.p132g.p142e.OrientedDrawable;
import p007b.p109f.p161j.p174i.DrawableFactory;
import p007b.p109f.p161j.p175j.CloseableImage;
import p007b.p109f.p161j.p175j.CloseableStaticBitmap;
import p007b.p109f.p161j.p183r.FrescoSystrace;

/* JADX INFO: renamed from: b.f.g.a.a.a, reason: use source file name */
/* JADX INFO: compiled from: DefaultDrawableFactory.java */
/* JADX INFO: loaded from: classes.dex */
public class DefaultDrawableFactory implements DrawableFactory {

    /* JADX INFO: renamed from: a */
    public final Resources f3166a;

    /* JADX INFO: renamed from: b */
    public final DrawableFactory f3167b;

    public DefaultDrawableFactory(Resources resources, DrawableFactory drawableFactory) {
        this.f3166a = resources;
        this.f3167b = drawableFactory;
    }

    @Override // p007b.p109f.p161j.p174i.DrawableFactory
    /* JADX INFO: renamed from: a */
    public boolean mo1035a(CloseableImage closeableImage) {
        return true;
    }

    @Override // p007b.p109f.p161j.p174i.DrawableFactory
    /* JADX INFO: renamed from: b */
    public Drawable mo1036b(CloseableImage closeableImage) {
        try {
            FrescoSystrace.m1527b();
            if (!(closeableImage instanceof CloseableStaticBitmap)) {
                DrawableFactory drawableFactory = this.f3167b;
                if (drawableFactory == null || !drawableFactory.mo1035a(closeableImage)) {
                    return null;
                }
                return this.f3167b.mo1036b(closeableImage);
            }
            CloseableStaticBitmap closeableStaticBitmap = (CloseableStaticBitmap) closeableImage;
            BitmapDrawable bitmapDrawable = new BitmapDrawable(this.f3166a, closeableStaticBitmap.f3887m);
            int i = closeableStaticBitmap.f3889o;
            if (!((i == 0 || i == -1) ? false : true)) {
                int i2 = closeableStaticBitmap.f3890p;
                if (!((i2 == 1 || i2 == 0) ? false : true)) {
                    return bitmapDrawable;
                }
            }
            return new OrientedDrawable(bitmapDrawable, closeableStaticBitmap.f3889o, closeableStaticBitmap.f3890p);
        } finally {
            FrescoSystrace.m1527b();
        }
    }
}

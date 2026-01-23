package p007b.p109f.p132g.p143f;

import android.content.res.Resources;
import android.graphics.PointF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.NinePatchDrawable;
import com.facebook.drawee.drawable.ScalingUtils$ScaleType;
import p007b.p085c.p086a.p087a0.AnimatableValueParser;
import p007b.p109f.p115d.p120e.FLog;
import p007b.p109f.p132g.p142e.DrawableParent;
import p007b.p109f.p132g.p142e.ForwardingDrawable;
import p007b.p109f.p132g.p142e.Rounded;
import p007b.p109f.p132g.p142e.RoundedBitmapDrawable2;
import p007b.p109f.p132g.p142e.RoundedColorDrawable;
import p007b.p109f.p132g.p142e.RoundedCornersDrawable;
import p007b.p109f.p132g.p142e.RoundedNinePatchDrawable;
import p007b.p109f.p132g.p142e.ScaleTypeDrawable;
import p007b.p109f.p161j.p183r.FrescoSystrace;

/* JADX INFO: renamed from: b.f.g.f.d, reason: use source file name */
/* JADX INFO: compiled from: WrappingUtils.java */
/* JADX INFO: loaded from: classes.dex */
public class WrappingUtils {

    /* JADX INFO: renamed from: a */
    public static final Drawable f3479a = new ColorDrawable(0);

    /* JADX INFO: renamed from: a */
    public static Drawable m1126a(Drawable drawable, RoundingParams roundingParams, Resources resources) {
        if (drawable instanceof BitmapDrawable) {
            BitmapDrawable bitmapDrawable = (BitmapDrawable) drawable;
            RoundedBitmapDrawable2 roundedBitmapDrawable2 = new RoundedBitmapDrawable2(resources, bitmapDrawable.getBitmap(), bitmapDrawable.getPaint());
            m1127b(roundedBitmapDrawable2, roundingParams);
            return roundedBitmapDrawable2;
        }
        if (drawable instanceof NinePatchDrawable) {
            RoundedNinePatchDrawable roundedNinePatchDrawable = new RoundedNinePatchDrawable((NinePatchDrawable) drawable);
            m1127b(roundedNinePatchDrawable, roundingParams);
            return roundedNinePatchDrawable;
        }
        if (!(drawable instanceof ColorDrawable)) {
            FLog.m987o("WrappingUtils", "Don't know how to round that drawable: %s", drawable);
            return drawable;
        }
        RoundedColorDrawable roundedColorDrawable = new RoundedColorDrawable(((ColorDrawable) drawable).getColor());
        m1127b(roundedColorDrawable, roundingParams);
        return roundedColorDrawable;
    }

    /* JADX INFO: renamed from: b */
    public static void m1127b(Rounded rounded, RoundingParams roundingParams) {
        rounded.mo1107c(roundingParams.f3472b);
        rounded.mo1112m(roundingParams.f3473c);
        rounded.mo1106a(roundingParams.f3476f, roundingParams.f3475e);
        rounded.mo1110i(roundingParams.f3477g);
        rounded.mo1109f(false);
        rounded.mo1108e(roundingParams.f3478h);
    }

    /* JADX INFO: renamed from: c */
    public static Drawable m1128c(Drawable drawable, RoundingParams roundingParams, Resources resources) {
        try {
            FrescoSystrace.m1527b();
            if (drawable != null && roundingParams != null && roundingParams.f3471a == 2) {
                if (!(drawable instanceof ForwardingDrawable)) {
                    return m1126a(drawable, roundingParams, resources);
                }
                DrawableParent drawableParent = (ForwardingDrawable) drawable;
                while (true) {
                    Object objMo1091l = drawableParent.mo1091l();
                    if (objMo1091l == drawableParent || !(objMo1091l instanceof DrawableParent)) {
                        break;
                    }
                    drawableParent = (DrawableParent) objMo1091l;
                }
                drawableParent.mo1090g(m1126a(drawableParent.mo1090g(f3479a), roundingParams, resources));
                return drawable;
            }
            return drawable;
        } finally {
            FrescoSystrace.m1527b();
        }
    }

    /* JADX INFO: renamed from: d */
    public static Drawable m1129d(Drawable drawable, RoundingParams roundingParams) {
        try {
            FrescoSystrace.m1527b();
            if (drawable != null && roundingParams != null && roundingParams.f3471a == 1) {
                RoundedCornersDrawable roundedCornersDrawable = new RoundedCornersDrawable(drawable);
                m1127b(roundedCornersDrawable, roundingParams);
                roundedCornersDrawable.f3403x = roundingParams.f3474d;
                roundedCornersDrawable.invalidateSelf();
                return roundedCornersDrawable;
            }
            return drawable;
        } finally {
            FrescoSystrace.m1527b();
        }
    }

    /* JADX INFO: renamed from: e */
    public static Drawable m1130e(Drawable drawable, ScalingUtils$ScaleType scalingUtils$ScaleType, PointF pointF) {
        FrescoSystrace.m1527b();
        if (drawable == null || scalingUtils$ScaleType == null) {
            FrescoSystrace.m1527b();
            return drawable;
        }
        ScaleTypeDrawable scaleTypeDrawable = new ScaleTypeDrawable(drawable, scalingUtils$ScaleType);
        if (pointF != null && !AnimatableValueParser.m520g0(scaleTypeDrawable.f3437p, pointF)) {
            if (scaleTypeDrawable.f3437p == null) {
                scaleTypeDrawable.f3437p = new PointF();
            }
            scaleTypeDrawable.f3437p.set(pointF);
            scaleTypeDrawable.m1118p();
            scaleTypeDrawable.invalidateSelf();
        }
        FrescoSystrace.m1527b();
        return scaleTypeDrawable;
    }
}

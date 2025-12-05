package p007b.p225i.p226a.p341g.p353l.p354l;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.View;
import androidx.annotation.FloatRange;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import p007b.p100d.p104b.p105a.outline;

/* compiled from: TransitionUtils.java */
@RequiresApi(21)
/* renamed from: b.i.a.g.l.l.k, reason: use source file name */
/* loaded from: classes3.dex */
public class TransitionUtils5 {

    /* renamed from: a */
    public static final RectF f11937a = new RectF();

    /* compiled from: TransitionUtils.java */
    /* renamed from: b.i.a.g.l.l.k$a */
    public interface a {
        /* renamed from: a */
        void mo6208a(Canvas canvas);
    }

    @NonNull
    /* renamed from: a */
    public static <T> T m6200a(@Nullable T t, @NonNull T t2) {
        return t != null ? t : t2;
    }

    /* renamed from: b */
    public static View m6201b(View view, @IdRes int i) throws Resources.NotFoundException {
        String resourceName = view.getResources().getResourceName(i);
        while (view != null) {
            if (view.getId() != i) {
                Object parent = view.getParent();
                if (!(parent instanceof View)) {
                    break;
                }
                view = (View) parent;
            } else {
                return view;
            }
        }
        throw new IllegalArgumentException(outline.m883w(resourceName, " is not a valid ancestor"));
    }

    /* renamed from: c */
    public static RectF m6202c(View view) {
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        return new RectF(iArr[0], iArr[1], view.getWidth() + r1, view.getHeight() + r0);
    }

    /* renamed from: d */
    public static float m6203d(float f, float f2, float f3) {
        return outline.m839a(f2, f, f3, f);
    }

    /* renamed from: e */
    public static float m6204e(float f, float f2, @FloatRange(from = 0.0d, m75to = 1.0d) float f3, @FloatRange(from = 0.0d, m75to = 1.0d) float f4, @FloatRange(from = 0.0d, m75to = 1.0d) float f5) {
        return m6205f(f, f2, f3, f4, f5, false);
    }

    /* renamed from: f */
    public static float m6205f(float f, float f2, @FloatRange(from = 0.0d, m75to = 1.0d) float f3, @FloatRange(from = 0.0d, m75to = 1.0d) float f4, @FloatRange(from = 0.0d) float f5, boolean z2) {
        return (!z2 || (f5 >= 0.0f && f5 <= 1.0f)) ? f5 < f3 ? f : f5 > f4 ? f2 : m6203d(f, f2, (f5 - f3) / (f4 - f3)) : m6203d(f, f2, f5);
    }

    /* renamed from: g */
    public static int m6206g(int i, int i2, @FloatRange(from = 0.0d, m75to = 1.0d) float f, @FloatRange(from = 0.0d, m75to = 1.0d) float f2, @FloatRange(from = 0.0d, m75to = 1.0d) float f3) {
        return f3 < f ? i : f3 > f2 ? i2 : (int) m6203d(i, i2, (f3 - f) / (f2 - f));
    }

    /* renamed from: h */
    public static void m6207h(Canvas canvas, Rect rect, float f, float f2, float f3, int i, a aVar) {
        if (i <= 0) {
            return;
        }
        int iSave = canvas.save();
        canvas.translate(f, f2);
        canvas.scale(f3, f3);
        if (i < 255) {
            RectF rectF = f11937a;
            rectF.set(rect);
            canvas.saveLayerAlpha(rectF, i);
        }
        aVar.mo6208a(canvas);
        canvas.restoreToCount(iSave);
    }
}

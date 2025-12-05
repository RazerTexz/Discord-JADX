package p007b.p085c.p086a.p089b0;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.RectF;
import android.os.Build;
import java.io.Closeable;
import p007b.p085c.p086a.L;

/* compiled from: Utils.java */
/* renamed from: b.c.a.b0.g, reason: use source file name */
/* loaded from: classes.dex */
public final class Utils {

    /* renamed from: a */
    public static final PathMeasure f2309a = new PathMeasure();

    /* renamed from: b */
    public static final Path f2310b = new Path();

    /* renamed from: c */
    public static final Path f2311c = new Path();

    /* renamed from: d */
    public static final float[] f2312d = new float[4];

    /* renamed from: e */
    public static final float f2313e = (float) (Math.sqrt(2.0d) / 2.0d);

    /* renamed from: f */
    public static float f2314f = -1.0f;

    /* renamed from: a */
    public static void m657a(Path path, float f, float f2, float f3) {
        PathMeasure pathMeasure = f2309a;
        pathMeasure.setPath(path, false);
        float length = pathMeasure.getLength();
        if (f == 1.0f && f2 == 0.0f) {
            L.m663a("applyTrimPathIfNeeded");
            return;
        }
        if (length < 1.0f || Math.abs((f2 - f) - 1.0f) < 0.01d) {
            L.m663a("applyTrimPathIfNeeded");
            return;
        }
        float f4 = f * length;
        float f5 = f2 * length;
        float f6 = f3 * length;
        float fMin = Math.min(f4, f5) + f6;
        float fMax = Math.max(f4, f5) + f6;
        if (fMin >= length && fMax >= length) {
            fMin = MiscUtils.m654d(fMin, length);
            fMax = MiscUtils.m654d(fMax, length);
        }
        if (fMin < 0.0f) {
            fMin = MiscUtils.m654d(fMin, length);
        }
        if (fMax < 0.0f) {
            fMax = MiscUtils.m654d(fMax, length);
        }
        if (fMin == fMax) {
            path.reset();
            L.m663a("applyTrimPathIfNeeded");
            return;
        }
        if (fMin >= fMax) {
            fMin -= length;
        }
        Path path2 = f2310b;
        path2.reset();
        pathMeasure.getSegment(fMin, fMax, path2, true);
        if (fMax > length) {
            Path path3 = f2311c;
            path3.reset();
            pathMeasure.getSegment(0.0f, fMax % length, path3, true);
            path2.addPath(path3);
        } else if (fMin < 0.0f) {
            Path path4 = f2311c;
            path4.reset();
            pathMeasure.getSegment(fMin + length, length, path4, true);
            path2.addPath(path4);
        }
        path.set(path2);
        L.m663a("applyTrimPathIfNeeded");
    }

    /* renamed from: b */
    public static void m658b(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (RuntimeException e) {
                throw e;
            } catch (Exception unused) {
            }
        }
    }

    /* renamed from: c */
    public static float m659c() {
        if (f2314f == -1.0f) {
            f2314f = Resources.getSystem().getDisplayMetrics().density;
        }
        return f2314f;
    }

    /* renamed from: d */
    public static float m660d(Matrix matrix) {
        float[] fArr = f2312d;
        fArr[0] = 0.0f;
        fArr[1] = 0.0f;
        float f = f2313e;
        fArr[2] = f;
        fArr[3] = f;
        matrix.mapPoints(fArr);
        return (float) Math.hypot(fArr[2] - fArr[0], fArr[3] - fArr[1]);
    }

    /* renamed from: e */
    public static Bitmap m661e(Bitmap bitmap, int i, int i2) {
        if (bitmap.getWidth() == i && bitmap.getHeight() == i2) {
            return bitmap;
        }
        Bitmap bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(bitmap, i, i2, true);
        bitmap.recycle();
        return bitmapCreateScaledBitmap;
    }

    /* renamed from: f */
    public static void m662f(Canvas canvas, RectF rectF, Paint paint, int i) {
        if (Build.VERSION.SDK_INT < 23) {
            canvas.saveLayer(rectF, paint, i);
        } else {
            canvas.saveLayer(rectF, paint);
        }
        L.m663a("Utils#saveLayer");
    }
}

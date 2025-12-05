package p007b.p085c.p086a.p087a0;

import android.graphics.PathMeasure;
import android.graphics.PointF;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import androidx.collection.SparseArrayCompat;
import androidx.core.view.animation.PathInterpolatorCompat;
import java.io.IOException;
import java.lang.ref.WeakReference;
import p007b.p085c.p086a.LottieComposition;
import p007b.p085c.p086a.p087a0.p088i0.JsonReader2;
import p007b.p085c.p086a.p089b0.MiscUtils;
import p007b.p085c.p086a.p089b0.Utils;
import p007b.p085c.p086a.p090c0.Keyframe;

/* compiled from: KeyframeParser.java */
/* renamed from: b.c.a.a0.q, reason: use source file name */
/* loaded from: classes.dex */
public class KeyframeParser {

    /* renamed from: b */
    public static SparseArrayCompat<WeakReference<Interpolator>> f2277b;

    /* renamed from: a */
    public static final Interpolator f2276a = new LinearInterpolator();

    /* renamed from: c */
    public static JsonReader2.a f2278c = JsonReader2.a.m616a("t", "s", "e", "o", "i", "h", "to", "ti");

    /* renamed from: a */
    public static <T> Keyframe<T> m631a(JsonReader2 jsonReader2, LottieComposition lottieComposition, float f, ValueParser<T> valueParser, boolean z2) throws IOException {
        Interpolator interpolator;
        T t;
        WeakReference<Interpolator> weakReference;
        Interpolator interpolatorCreate;
        if (!z2) {
            return new Keyframe<>(valueParser.mo413a(jsonReader2, f));
        }
        jsonReader2.mo604b();
        int i = 1;
        PointF pointFM628b = null;
        PointF pointFM628b2 = null;
        T tMo413a = null;
        T tMo413a2 = null;
        PointF pointFM628b3 = null;
        PointF pointFM628b4 = null;
        boolean z3 = false;
        float fMo609n = 0.0f;
        while (jsonReader2.mo607e()) {
            switch (jsonReader2.mo615y(f2278c)) {
                case 0:
                    fMo609n = (float) jsonReader2.mo609n();
                    break;
                case 1:
                    tMo413a2 = valueParser.mo413a(jsonReader2, f);
                    continue;
                case 2:
                    tMo413a = valueParser.mo413a(jsonReader2, f);
                    continue;
                case 3:
                    pointFM628b = JsonUtils.m628b(jsonReader2, f);
                    continue;
                case 4:
                    pointFM628b2 = JsonUtils.m628b(jsonReader2, f);
                    continue;
                case 5:
                    if (jsonReader2.mo610q() == i) {
                        z3 = true;
                    } else {
                        z3 = false;
                        continue;
                    }
                    break;
                case 6:
                    pointFM628b4 = JsonUtils.m628b(jsonReader2, f);
                    continue;
                case 7:
                    pointFM628b3 = JsonUtils.m628b(jsonReader2, f);
                    continue;
                default:
                    jsonReader2.mo601C();
                    break;
            }
            i = 1;
        }
        jsonReader2.mo606d();
        if (z3) {
            interpolator = f2276a;
            t = tMo413a2;
        } else {
            if (pointFM628b == null || pointFM628b2 == null) {
                interpolator = f2276a;
            } else {
                float f2 = -f;
                pointFM628b.x = MiscUtils.m652b(pointFM628b.x, f2, f);
                pointFM628b.y = MiscUtils.m652b(pointFM628b.y, -100.0f, 100.0f);
                pointFM628b2.x = MiscUtils.m652b(pointFM628b2.x, f2, f);
                float fM652b = MiscUtils.m652b(pointFM628b2.y, -100.0f, 100.0f);
                pointFM628b2.y = fM652b;
                float f3 = pointFM628b.x;
                float f4 = pointFM628b.y;
                float f5 = pointFM628b2.x;
                PathMeasure pathMeasure = Utils.f2309a;
                int i2 = f3 != 0.0f ? (int) (527 * f3) : 17;
                if (f4 != 0.0f) {
                    i2 = (int) (i2 * 31 * f4);
                }
                if (f5 != 0.0f) {
                    i2 = (int) (i2 * 31 * f5);
                }
                if (fM652b != 0.0f) {
                    i2 = (int) (i2 * 31 * fM652b);
                }
                synchronized (KeyframeParser.class) {
                    if (f2277b == null) {
                        f2277b = new SparseArrayCompat<>();
                    }
                    weakReference = f2277b.get(i2);
                }
                interpolator = weakReference != null ? weakReference.get() : null;
                if (weakReference == null || interpolator == null) {
                    pointFM628b.x /= f;
                    pointFM628b.y /= f;
                    float f6 = pointFM628b2.x / f;
                    pointFM628b2.x = f6;
                    float f7 = pointFM628b2.y / f;
                    pointFM628b2.y = f7;
                    try {
                        interpolatorCreate = PathInterpolatorCompat.create(pointFM628b.x, pointFM628b.y, f6, f7);
                    } catch (IllegalArgumentException e) {
                        interpolatorCreate = e.getMessage().equals("The Path cannot loop back on itself.") ? PathInterpolatorCompat.create(Math.min(pointFM628b.x, 1.0f), pointFM628b.y, Math.max(pointFM628b2.x, 0.0f), pointFM628b2.y) : new LinearInterpolator();
                    }
                    interpolator = interpolatorCreate;
                    try {
                        WeakReference<Interpolator> weakReference2 = new WeakReference<>(interpolator);
                        synchronized (KeyframeParser.class) {
                            f2277b.put(i2, weakReference2);
                        }
                    } catch (ArrayIndexOutOfBoundsException unused) {
                    }
                }
            }
            t = tMo413a;
        }
        Keyframe<T> keyframe = new Keyframe<>(lottieComposition, tMo413a2, t, interpolator, fMo609n, null);
        keyframe.f2328m = pointFM628b4;
        keyframe.f2329n = pointFM628b3;
        return keyframe;
    }
}

package p007b.p085c.p086a.p089b0;

import android.graphics.PointF;
import androidx.annotation.FloatRange;
import java.util.List;
import p007b.p085c.p086a.p091w.p092b.KeyPathElementContent;
import p007b.p085c.p086a.p095y.KeyPath;
import p007b.p100d.p104b.p105a.outline;

/* compiled from: MiscUtils.java */
/* renamed from: b.c.a.b0.f, reason: use source file name */
/* loaded from: classes.dex */
public class MiscUtils {

    /* renamed from: a */
    public static PointF f2308a = new PointF();

    /* renamed from: a */
    public static PointF m651a(PointF pointF, PointF pointF2) {
        return new PointF(pointF.x + pointF2.x, pointF.y + pointF2.y);
    }

    /* renamed from: b */
    public static float m652b(float f, float f2, float f3) {
        return Math.max(f2, Math.min(f3, f));
    }

    /* renamed from: c */
    public static int m653c(int i, int i2, int i3) {
        return Math.max(i2, Math.min(i3, i));
    }

    /* renamed from: d */
    public static int m654d(float f, float f2) {
        int i = (int) f;
        int i2 = (int) f2;
        int i3 = i / i2;
        int i4 = i % i2;
        if (!((i ^ i2) >= 0) && i4 != 0) {
            i3--;
        }
        return i - (i2 * i3);
    }

    /* renamed from: e */
    public static float m655e(float f, float f2, @FloatRange(from = 0.0d, m75to = 1.0d) float f3) {
        return outline.m839a(f2, f, f3, f);
    }

    /* renamed from: f */
    public static void m656f(KeyPath keyPath, int i, List<KeyPath> list, KeyPath keyPath2, KeyPathElementContent keyPathElementContent) {
        if (keyPath.m768c(keyPathElementContent.getName(), i)) {
            list.add(keyPath2.m766a(keyPathElementContent.getName()).m772g(keyPathElementContent));
        }
    }
}

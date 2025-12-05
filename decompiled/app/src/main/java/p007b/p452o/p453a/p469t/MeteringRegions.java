package p007b.p452o.p453a.p469t;

import android.graphics.PointF;
import android.graphics.RectF;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/* compiled from: MeteringRegions.java */
/* renamed from: b.o.a.t.b, reason: use source file name */
/* loaded from: classes3.dex */
public class MeteringRegions {

    /* renamed from: a */
    @VisibleForTesting
    public final List<MeteringRegion> f14142a;

    public MeteringRegions(@NonNull List<MeteringRegion> list) {
        this.f14142a = list;
    }

    @NonNull
    /* renamed from: a */
    public static RectF m7409a(@NonNull PointF pointF, float f, float f2) {
        float f3 = pointF.x;
        float f4 = f / 2.0f;
        float f5 = pointF.y;
        float f6 = f2 / 2.0f;
        return new RectF(f3 - f4, f5 - f6, f3 + f4, f5 + f6);
    }

    @NonNull
    /* renamed from: b */
    public <T> List<T> m7410b(int i, @NonNull MeteringTransform<T> meteringTransform) {
        ArrayList arrayList = new ArrayList();
        Collections.sort(this.f14142a);
        for (MeteringRegion meteringRegion : this.f14142a) {
            arrayList.add(meteringTransform.mo7354a(meteringRegion.f14140j, meteringRegion.f14141k));
        }
        return arrayList.subList(0, Math.min(i, arrayList.size()));
    }

    @NonNull
    /* renamed from: c */
    public MeteringRegions m7411c(@NonNull MeteringTransform meteringTransform) {
        ArrayList arrayList = new ArrayList();
        for (MeteringRegion meteringRegion : this.f14142a) {
            Objects.requireNonNull(meteringRegion);
            RectF rectF = new RectF(Float.MAX_VALUE, Float.MAX_VALUE, -3.4028235E38f, -3.4028235E38f);
            PointF pointF = new PointF();
            RectF rectF2 = meteringRegion.f14140j;
            pointF.set(rectF2.left, rectF2.top);
            PointF pointFMo7355b = meteringTransform.mo7355b(pointF);
            meteringRegion.m7408f(rectF, pointFMo7355b);
            RectF rectF3 = meteringRegion.f14140j;
            pointFMo7355b.set(rectF3.right, rectF3.top);
            PointF pointFMo7355b2 = meteringTransform.mo7355b(pointFMo7355b);
            meteringRegion.m7408f(rectF, pointFMo7355b2);
            RectF rectF4 = meteringRegion.f14140j;
            pointFMo7355b2.set(rectF4.right, rectF4.bottom);
            PointF pointFMo7355b3 = meteringTransform.mo7355b(pointFMo7355b2);
            meteringRegion.m7408f(rectF, pointFMo7355b3);
            RectF rectF5 = meteringRegion.f14140j;
            pointFMo7355b3.set(rectF5.left, rectF5.bottom);
            meteringRegion.m7408f(rectF, meteringTransform.mo7355b(pointFMo7355b3));
            arrayList.add(new MeteringRegion(rectF, meteringRegion.f14141k));
        }
        return new MeteringRegions(arrayList);
    }
}

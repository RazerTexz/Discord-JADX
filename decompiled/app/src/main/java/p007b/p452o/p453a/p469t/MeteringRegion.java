package p007b.p452o.p453a.p469t;

import android.graphics.PointF;
import android.graphics.RectF;
import androidx.annotation.NonNull;

/* compiled from: MeteringRegion.java */
/* renamed from: b.o.a.t.a, reason: use source file name */
/* loaded from: classes3.dex */
public class MeteringRegion implements Comparable<MeteringRegion> {

    /* renamed from: j */
    public final RectF f14140j;

    /* renamed from: k */
    public final int f14141k;

    public MeteringRegion(@NonNull RectF rectF, int i) {
        this.f14140j = rectF;
        this.f14141k = i;
    }

    @Override // java.lang.Comparable
    public int compareTo(@NonNull MeteringRegion meteringRegion) {
        return -Integer.valueOf(this.f14141k).compareTo(Integer.valueOf(meteringRegion.f14141k));
    }

    /* renamed from: f */
    public final void m7408f(@NonNull RectF rectF, @NonNull PointF pointF) {
        rectF.left = Math.min(rectF.left, pointF.x);
        rectF.top = Math.min(rectF.top, pointF.y);
        rectF.right = Math.max(rectF.right, pointF.x);
        rectF.bottom = Math.max(rectF.bottom, pointF.y);
    }
}

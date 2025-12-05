package p007b.p109f.p132g.p142e;

import android.graphics.Matrix;
import android.graphics.Rect;
import com.facebook.drawee.drawable.ScalingUtils$ScaleType;

/* compiled from: ScalingUtils.java */
/* renamed from: b.f.g.e.r */
/* loaded from: classes.dex */
public class C1784r extends AbstractC1783q {

    /* renamed from: l */
    public static final ScalingUtils$ScaleType f3442l = new C1784r();

    @Override // p007b.p109f.p132g.p142e.AbstractC1783q
    /* renamed from: b */
    public void mo1092b(Matrix matrix, Rect rect, int i, int i2, float f, float f2, float f3, float f4) {
        matrix.setTranslate((int) (((rect.width() - i) * 0.5f) + rect.left + 0.5f), (int) (((rect.height() - i2) * 0.5f) + rect.top + 0.5f));
    }

    public String toString() {
        return "center";
    }
}

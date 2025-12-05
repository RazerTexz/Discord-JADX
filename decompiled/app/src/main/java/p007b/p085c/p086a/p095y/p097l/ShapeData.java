package p007b.p085c.p086a.p095y.p097l;

import android.graphics.PointF;
import java.util.ArrayList;
import java.util.List;
import p007b.p085c.p086a.p095y.CubicCurveData;
import p007b.p100d.p104b.p105a.outline;

/* compiled from: ShapeData.java */
/* renamed from: b.c.a.y.l.k, reason: use source file name */
/* loaded from: classes.dex */
public class ShapeData {

    /* renamed from: a */
    public final List<CubicCurveData> f2803a;

    /* renamed from: b */
    public PointF f2804b;

    /* renamed from: c */
    public boolean f2805c;

    public ShapeData(PointF pointF, boolean z2, List<CubicCurveData> list) {
        this.f2804b = pointF;
        this.f2805c = z2;
        this.f2803a = new ArrayList(list);
    }

    public String toString() {
        StringBuilder sbM833U = outline.m833U("ShapeData{numCurves=");
        sbM833U.append(this.f2803a.size());
        sbM833U.append("closed=");
        sbM833U.append(this.f2805c);
        sbM833U.append('}');
        return sbM833U.toString();
    }

    public ShapeData() {
        this.f2803a = new ArrayList();
    }
}

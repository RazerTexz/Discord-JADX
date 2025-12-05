package p007b.p085c.p086a.p091w.p093c;

import android.graphics.Path;
import android.graphics.PointF;
import java.util.List;
import p007b.p085c.p086a.p089b0.Logger2;
import p007b.p085c.p086a.p089b0.MiscUtils;
import p007b.p085c.p086a.p090c0.Keyframe;
import p007b.p085c.p086a.p095y.CubicCurveData;
import p007b.p085c.p086a.p095y.p097l.ShapeData;
import p007b.p100d.p104b.p105a.outline;

/* compiled from: ShapeKeyframeAnimation.java */
/* renamed from: b.c.a.w.c.l, reason: use source file name */
/* loaded from: classes.dex */
public class ShapeKeyframeAnimation extends BaseKeyframeAnimation<ShapeData, Path> {

    /* renamed from: i */
    public final ShapeData f2622i;

    /* renamed from: j */
    public final Path f2623j;

    public ShapeKeyframeAnimation(List<Keyframe<ShapeData>> list) {
        super(list);
        this.f2622i = new ShapeData();
        this.f2623j = new Path();
    }

    @Override // p007b.p085c.p086a.p091w.p093c.BaseKeyframeAnimation
    /* renamed from: f */
    public Path mo728f(Keyframe<ShapeData> keyframe, float f) {
        ShapeData shapeData = keyframe.f2317b;
        ShapeData shapeData2 = keyframe.f2318c;
        ShapeData shapeData3 = this.f2622i;
        if (shapeData3.f2804b == null) {
            shapeData3.f2804b = new PointF();
        }
        shapeData3.f2805c = shapeData.f2805c || shapeData2.f2805c;
        if (shapeData.f2803a.size() != shapeData2.f2803a.size()) {
            StringBuilder sbM833U = outline.m833U("Curves must have the same number of control points. Shape 1: ");
            sbM833U.append(shapeData.f2803a.size());
            sbM833U.append("\tShape 2: ");
            sbM833U.append(shapeData2.f2803a.size());
            Logger2.m640b(sbM833U.toString());
        }
        int iMin = Math.min(shapeData.f2803a.size(), shapeData2.f2803a.size());
        if (shapeData3.f2803a.size() < iMin) {
            for (int size = shapeData3.f2803a.size(); size < iMin; size++) {
                shapeData3.f2803a.add(new CubicCurveData());
            }
        } else if (shapeData3.f2803a.size() > iMin) {
            for (int size2 = shapeData3.f2803a.size() - 1; size2 >= iMin; size2--) {
                shapeData3.f2803a.remove(r5.size() - 1);
            }
        }
        PointF pointF = shapeData.f2804b;
        PointF pointF2 = shapeData2.f2804b;
        float fM655e = MiscUtils.m655e(pointF.x, pointF2.x, f);
        float fM655e2 = MiscUtils.m655e(pointF.y, pointF2.y, f);
        if (shapeData3.f2804b == null) {
            shapeData3.f2804b = new PointF();
        }
        shapeData3.f2804b.set(fM655e, fM655e2);
        for (int size3 = shapeData3.f2803a.size() - 1; size3 >= 0; size3--) {
            CubicCurveData cubicCurveData = shapeData.f2803a.get(size3);
            CubicCurveData cubicCurveData2 = shapeData2.f2803a.get(size3);
            PointF pointF3 = cubicCurveData.f2652a;
            PointF pointF4 = cubicCurveData.f2653b;
            PointF pointF5 = cubicCurveData.f2654c;
            PointF pointF6 = cubicCurveData2.f2652a;
            PointF pointF7 = cubicCurveData2.f2653b;
            PointF pointF8 = cubicCurveData2.f2654c;
            shapeData3.f2803a.get(size3).f2652a.set(MiscUtils.m655e(pointF3.x, pointF6.x, f), MiscUtils.m655e(pointF3.y, pointF6.y, f));
            shapeData3.f2803a.get(size3).f2653b.set(MiscUtils.m655e(pointF4.x, pointF7.x, f), MiscUtils.m655e(pointF4.y, pointF7.y, f));
            shapeData3.f2803a.get(size3).f2654c.set(MiscUtils.m655e(pointF5.x, pointF8.x, f), MiscUtils.m655e(pointF5.y, pointF8.y, f));
        }
        ShapeData shapeData4 = this.f2622i;
        Path path = this.f2623j;
        path.reset();
        PointF pointF9 = shapeData4.f2804b;
        path.moveTo(pointF9.x, pointF9.y);
        MiscUtils.f2308a.set(pointF9.x, pointF9.y);
        for (int i = 0; i < shapeData4.f2803a.size(); i++) {
            CubicCurveData cubicCurveData3 = shapeData4.f2803a.get(i);
            PointF pointF10 = cubicCurveData3.f2652a;
            PointF pointF11 = cubicCurveData3.f2653b;
            PointF pointF12 = cubicCurveData3.f2654c;
            if (pointF10.equals(MiscUtils.f2308a) && pointF11.equals(pointF12)) {
                path.lineTo(pointF12.x, pointF12.y);
            } else {
                path.cubicTo(pointF10.x, pointF10.y, pointF11.x, pointF11.y, pointF12.x, pointF12.y);
            }
            MiscUtils.f2308a.set(pointF12.x, pointF12.y);
        }
        if (shapeData4.f2805c) {
            path.close();
        }
        return this.f2623j;
    }
}

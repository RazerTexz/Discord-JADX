package b.c.a.w.c;

import android.graphics.PointF;
import java.util.List;

/* compiled from: IntegerKeyframeAnimation.java */
/* loaded from: classes.dex */
public class e extends f<Integer> {
    public e(List<b.c.a.c0.a<Integer>> list) {
        super(list);
    }

    @Override // b.c.a.w.c.a
    public Object f(b.c.a.c0.a aVar, float f) {
        return Integer.valueOf(j(aVar, f));
    }

    public int j(b.c.a.c0.a<Integer> aVar, float f) {
        Integer num;
        if (aVar.f347b == null || aVar.c == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        b.c.a.c0.c<A> cVar = this.e;
        if (cVar != 0 && (num = (Integer) cVar.a(aVar.e, aVar.f.floatValue(), aVar.f347b, aVar.c, f, d(), this.d)) != null) {
            return num.intValue();
        }
        if (aVar.i == 784923401) {
            aVar.i = aVar.f347b.intValue();
        }
        int i = aVar.i;
        if (aVar.j == 784923401) {
            aVar.j = aVar.c.intValue();
        }
        int i2 = aVar.j;
        PointF pointF = b.c.a.b0.f.a;
        return (int) ((f * (i2 - i)) + i);
    }
}

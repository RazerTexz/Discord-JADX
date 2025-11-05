package b.c.a.w.c;

import java.util.List;

/* compiled from: ColorKeyframeAnimation.java */
/* loaded from: classes.dex */
public class b extends f<Integer> {
    public b(List<b.c.a.c0.a<Integer>> list) {
        super(list);
    }

    @Override // b.c.a.w.c.a
    public Object f(b.c.a.c0.a aVar, float f) {
        return Integer.valueOf(j(aVar, f));
    }

    public int j(b.c.a.c0.a<Integer> aVar, float f) {
        Integer num;
        Integer num2 = aVar.f347b;
        if (num2 == null || aVar.c == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        int iIntValue = num2.intValue();
        int iIntValue2 = aVar.c.intValue();
        b.c.a.c0.c<A> cVar = this.e;
        return (cVar == 0 || (num = (Integer) cVar.a(aVar.e, aVar.f.floatValue(), Integer.valueOf(iIntValue), Integer.valueOf(iIntValue2), f, d(), this.d)) == null) ? b.c.a.a0.d.i0(b.c.a.b0.f.b(f, 0.0f, 1.0f), iIntValue, iIntValue2) : num.intValue();
    }
}

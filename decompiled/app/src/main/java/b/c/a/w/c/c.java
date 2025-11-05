package b.c.a.w.c;

import java.util.List;

/* compiled from: FloatKeyframeAnimation.java */
/* loaded from: classes.dex */
public class c extends f<Float> {
    public c(List<b.c.a.c0.a<Float>> list) {
        super(list);
    }

    @Override // b.c.a.w.c.a
    public Object f(b.c.a.c0.a aVar, float f) {
        return Float.valueOf(k(aVar, f));
    }

    public float j() {
        return k(a(), c());
    }

    public float k(b.c.a.c0.a<Float> aVar, float f) {
        Float f2;
        if (aVar.f347b == null || aVar.c == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        b.c.a.c0.c<A> cVar = this.e;
        if (cVar != 0 && (f2 = (Float) cVar.a(aVar.e, aVar.f.floatValue(), aVar.f347b, aVar.c, f, d(), this.d)) != null) {
            return f2.floatValue();
        }
        if (aVar.g == -3987645.8f) {
            aVar.g = aVar.f347b.floatValue();
        }
        float f3 = aVar.g;
        if (aVar.h == -3987645.8f) {
            aVar.h = aVar.c.floatValue();
        }
        return b.c.a.b0.f.e(f3, aVar.h, f);
    }
}

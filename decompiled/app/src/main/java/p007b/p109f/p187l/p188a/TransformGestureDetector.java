package p007b.p109f.p187l.p188a;

import p007b.p109f.p187l.p188a.MultiPointerGestureDetector;

/* compiled from: TransformGestureDetector.java */
/* renamed from: b.f.l.a.b, reason: use source file name */
/* loaded from: classes3.dex */
public class TransformGestureDetector implements MultiPointerGestureDetector.a {

    /* renamed from: a */
    public final MultiPointerGestureDetector f4287a;

    /* renamed from: b */
    public a f4288b = null;

    /* compiled from: TransformGestureDetector.java */
    /* renamed from: b.f.l.a.b$a */
    public interface a {
        /* renamed from: b */
        void mo1549b(TransformGestureDetector transformGestureDetector);

        /* renamed from: c */
        void mo1550c(TransformGestureDetector transformGestureDetector);
    }

    public TransformGestureDetector(MultiPointerGestureDetector multiPointerGestureDetector) {
        this.f4287a = multiPointerGestureDetector;
        multiPointerGestureDetector.f4286h = this;
    }

    /* renamed from: a */
    public final float m1545a(float[] fArr, int i) {
        float f = 0.0f;
        for (int i2 = 0; i2 < i; i2++) {
            f += fArr[i2];
        }
        if (i > 0) {
            return f / i;
        }
        return 0.0f;
    }

    /* renamed from: b */
    public float m1546b() {
        MultiPointerGestureDetector multiPointerGestureDetector = this.f4287a;
        return m1545a(multiPointerGestureDetector.f4282d, multiPointerGestureDetector.f4280b);
    }

    /* renamed from: c */
    public float m1547c() {
        MultiPointerGestureDetector multiPointerGestureDetector = this.f4287a;
        return m1545a(multiPointerGestureDetector.f4283e, multiPointerGestureDetector.f4280b);
    }

    /* renamed from: d */
    public void m1548d() {
        MultiPointerGestureDetector multiPointerGestureDetector = this.f4287a;
        if (multiPointerGestureDetector.f4279a) {
            multiPointerGestureDetector.m1544c();
            for (int i = 0; i < 2; i++) {
                multiPointerGestureDetector.f4282d[i] = multiPointerGestureDetector.f4284f[i];
                multiPointerGestureDetector.f4283e[i] = multiPointerGestureDetector.f4285g[i];
            }
            multiPointerGestureDetector.m1543b();
        }
    }
}

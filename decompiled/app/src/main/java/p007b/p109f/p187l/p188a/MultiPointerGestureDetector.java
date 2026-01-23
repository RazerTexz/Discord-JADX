package p007b.p109f.p187l.p188a;

import p007b.p109f.p115d.p120e.FLog;
import p007b.p109f.p187l.p188a.TransformGestureDetector;
import p007b.p109f.p187l.p189b.DefaultZoomableController;

/* JADX INFO: renamed from: b.f.l.a.a, reason: use source file name */
/* JADX INFO: compiled from: MultiPointerGestureDetector.java */
/* JADX INFO: loaded from: classes3.dex */
public class MultiPointerGestureDetector {

    /* JADX INFO: renamed from: a */
    public boolean f4279a;

    /* JADX INFO: renamed from: b */
    public int f4280b;

    /* JADX INFO: renamed from: c */
    public final int[] f4281c = new int[2];

    /* JADX INFO: renamed from: d */
    public final float[] f4282d = new float[2];

    /* JADX INFO: renamed from: e */
    public final float[] f4283e = new float[2];

    /* JADX INFO: renamed from: f */
    public final float[] f4284f = new float[2];

    /* JADX INFO: renamed from: g */
    public final float[] f4285g = new float[2];

    /* JADX INFO: renamed from: h */
    public a f4286h = null;

    /* JADX INFO: renamed from: b.f.l.a.a$a */
    /* JADX INFO: compiled from: MultiPointerGestureDetector.java */
    public interface a {
    }

    public MultiPointerGestureDetector() {
        m1542a();
    }

    /* JADX INFO: renamed from: a */
    public void m1542a() {
        this.f4279a = false;
        this.f4280b = 0;
        for (int i = 0; i < 2; i++) {
            this.f4281c[i] = -1;
        }
    }

    /* JADX INFO: renamed from: b */
    public final void m1543b() {
        TransformGestureDetector transformGestureDetector;
        TransformGestureDetector.a aVar;
        if (this.f4279a) {
            return;
        }
        a aVar2 = this.f4286h;
        if (aVar2 != null && (aVar = (transformGestureDetector = (TransformGestureDetector) aVar2).f4288b) != null) {
            aVar.mo1550c(transformGestureDetector);
        }
        this.f4279a = true;
    }

    /* JADX INFO: renamed from: c */
    public final void m1544c() {
        TransformGestureDetector.a aVar;
        if (this.f4279a) {
            this.f4279a = false;
            a aVar2 = this.f4286h;
            if (aVar2 == null || (aVar = ((TransformGestureDetector) aVar2).f4288b) == null) {
                return;
            }
            FLog.m981i(DefaultZoomableController.class, "onGestureEnd");
        }
    }
}

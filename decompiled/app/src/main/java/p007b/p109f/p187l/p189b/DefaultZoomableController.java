package p007b.p109f.p187l.p189b;

import android.graphics.Matrix;
import android.graphics.RectF;
import android.view.MotionEvent;
import com.discord.models.domain.ModelAuditLogEntry;
import com.facebook.samples.zoomable.ZoomableDraweeView;
import java.util.Objects;
import p007b.p109f.p115d.p120e.FLog;
import p007b.p109f.p187l.p188a.MultiPointerGestureDetector;
import p007b.p109f.p187l.p188a.TransformGestureDetector;
import p007b.p109f.p187l.p189b.ZoomableController;

/* compiled from: DefaultZoomableController.java */
/* renamed from: b.f.l.b.c, reason: use source file name */
/* loaded from: classes3.dex */
public class DefaultZoomableController implements ZoomableController, TransformGestureDetector.a {

    /* renamed from: a */
    public TransformGestureDetector f4299a;

    /* renamed from: b */
    public ZoomableController.a f4300b = null;

    /* renamed from: c */
    public boolean f4301c = false;

    /* renamed from: d */
    public final RectF f4302d = new RectF();

    /* renamed from: e */
    public final RectF f4303e = new RectF();

    /* renamed from: f */
    public final RectF f4304f = new RectF();

    /* renamed from: g */
    public final Matrix f4305g = new Matrix();

    /* renamed from: h */
    public final Matrix f4306h = new Matrix();

    /* renamed from: i */
    public final Matrix f4307i = new Matrix();

    /* renamed from: j */
    public final float[] f4308j = new float[9];

    /* renamed from: k */
    public final RectF f4309k = new RectF();

    /* renamed from: l */
    public boolean f4310l;

    static {
        new RectF(0.0f, 0.0f, 1.0f, 1.0f);
    }

    public DefaultZoomableController(TransformGestureDetector transformGestureDetector) {
        this.f4299a = transformGestureDetector;
        transformGestureDetector.f4288b = this;
    }

    /* renamed from: l */
    public static boolean m1557l(int i, int i2) {
        return (i & i2) != 0;
    }

    @Override // p007b.p109f.p187l.p189b.ZoomableController
    /* renamed from: a */
    public boolean mo1551a() {
        this.f4306h.getValues(this.f4308j);
        float[] fArr = this.f4308j;
        fArr[0] = fArr[0] - 1.0f;
        fArr[4] = fArr[4] - 1.0f;
        fArr[8] = fArr[8] - 1.0f;
        for (int i = 0; i < 9; i++) {
            if (Math.abs(this.f4308j[i]) > 0.001f) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: b */
    public void mo1549b(TransformGestureDetector transformGestureDetector) {
        float fHypot;
        FLog.m981i(DefaultZoomableController.class, "onGestureUpdate");
        Matrix matrix = this.f4306h;
        TransformGestureDetector transformGestureDetector2 = this.f4299a;
        matrix.set(this.f4305g);
        MultiPointerGestureDetector multiPointerGestureDetector = transformGestureDetector2.f4287a;
        if (multiPointerGestureDetector.f4280b < 2) {
            fHypot = 1.0f;
        } else {
            float[] fArr = multiPointerGestureDetector.f4282d;
            float f = fArr[1] - fArr[0];
            float[] fArr2 = multiPointerGestureDetector.f4283e;
            float f2 = fArr2[1] - fArr2[0];
            float[] fArr3 = multiPointerGestureDetector.f4284f;
            float f3 = fArr3[1] - fArr3[0];
            float[] fArr4 = multiPointerGestureDetector.f4285g;
            fHypot = ((float) Math.hypot(f3, fArr4[1] - fArr4[0])) / ((float) Math.hypot(f, f2));
        }
        matrix.postScale(fHypot, fHypot, transformGestureDetector2.m1546b(), transformGestureDetector2.m1547c());
        boolean zM1560f = m1560f(matrix, transformGestureDetector2.m1546b(), transformGestureDetector2.m1547c(), 7) | false;
        MultiPointerGestureDetector multiPointerGestureDetector2 = transformGestureDetector2.f4287a;
        float fM1545a = transformGestureDetector2.m1545a(multiPointerGestureDetector2.f4284f, multiPointerGestureDetector2.f4280b);
        MultiPointerGestureDetector multiPointerGestureDetector3 = transformGestureDetector2.f4287a;
        float fM1545a2 = fM1545a - transformGestureDetector2.m1545a(multiPointerGestureDetector3.f4282d, multiPointerGestureDetector3.f4280b);
        MultiPointerGestureDetector multiPointerGestureDetector4 = transformGestureDetector2.f4287a;
        float fM1545a3 = transformGestureDetector2.m1545a(multiPointerGestureDetector4.f4285g, multiPointerGestureDetector4.f4280b);
        MultiPointerGestureDetector multiPointerGestureDetector5 = transformGestureDetector2.f4287a;
        matrix.postTranslate(fM1545a2, fM1545a3 - transformGestureDetector2.m1545a(multiPointerGestureDetector5.f4283e, multiPointerGestureDetector5.f4280b));
        boolean zM1561g = m1561g(matrix, 7) | zM1560f;
        m1563i();
        if (zM1561g) {
            this.f4299a.m1548d();
        }
        this.f4310l = zM1561g;
    }

    /* renamed from: c */
    public void mo1550c(TransformGestureDetector transformGestureDetector) {
        FLog.m981i(DefaultZoomableController.class, "onGestureBegin");
        this.f4305g.set(this.f4306h);
        RectF rectF = this.f4304f;
        float f = rectF.left;
        RectF rectF2 = this.f4302d;
        this.f4310l = !(f < rectF2.left - 0.001f && rectF.top < rectF2.top - 0.001f && rectF.right > rectF2.right + 0.001f && rectF.bottom > rectF2.bottom + 0.001f);
    }

    /* renamed from: d */
    public final float m1558d(float f, float f2, float f3, float f4, float f5) {
        float f6 = f2 - f;
        float f7 = f4 - f3;
        if (f6 < Math.min(f5 - f3, f4 - f5) * 2.0f) {
            return f5 - ((f2 + f) / 2.0f);
        }
        if (f6 < f7) {
            return f5 < (f3 + f4) / 2.0f ? f3 - f : f4 - f2;
        }
        if (f > f3) {
            return f3 - f;
        }
        if (f2 < f4) {
            return f4 - f2;
        }
        return 0.0f;
    }

    /* renamed from: e */
    public float m1559e() {
        this.f4306h.getValues(this.f4308j);
        return this.f4308j[0];
    }

    /* renamed from: f */
    public final boolean m1560f(Matrix matrix, float f, float f2, int i) {
        if (!m1557l(i, 4)) {
            return false;
        }
        matrix.getValues(this.f4308j);
        float f3 = this.f4308j[0];
        float fMin = Math.min(Math.max(1.0f, f3), 2.0f);
        if (fMin == f3) {
            return false;
        }
        float f4 = fMin / f3;
        matrix.postScale(f4, f4, f, f2);
        return true;
    }

    /* renamed from: g */
    public final boolean m1561g(Matrix matrix, int i) {
        float fM1558d;
        float fM1558d2;
        if (!m1557l(i, 3)) {
            return false;
        }
        RectF rectF = this.f4309k;
        rectF.set(this.f4303e);
        matrix.mapRect(rectF);
        if (m1557l(i, 1)) {
            float f = rectF.left;
            float f2 = rectF.right;
            RectF rectF2 = this.f4302d;
            fM1558d = m1558d(f, f2, rectF2.left, rectF2.right, this.f4303e.centerX());
        } else {
            fM1558d = 0.0f;
        }
        if (m1557l(i, 2)) {
            float f3 = rectF.top;
            float f4 = rectF.bottom;
            RectF rectF3 = this.f4302d;
            fM1558d2 = m1558d(f3, f4, rectF3.top, rectF3.bottom, this.f4303e.centerY());
        } else {
            fM1558d2 = 0.0f;
        }
        if (fM1558d == 0.0f && fM1558d2 == 0.0f) {
            return false;
        }
        matrix.postTranslate(fM1558d, fM1558d2);
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x006d  */
    /* renamed from: h */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean m1562h(MotionEvent motionEvent) {
        MultiPointerGestureDetector.a aVar;
        TransformGestureDetector transformGestureDetector;
        TransformGestureDetector.a aVar2;
        motionEvent.getAction();
        int i = FLog.f3102a;
        int i2 = 0;
        if (!this.f4301c) {
            return false;
        }
        MultiPointerGestureDetector multiPointerGestureDetector = this.f4299a.f4287a;
        Objects.requireNonNull(multiPointerGestureDetector);
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0 || actionMasked == 1) {
            motionEvent.getPointerCount();
            motionEvent.getActionMasked();
            multiPointerGestureDetector.m1544c();
            multiPointerGestureDetector.f4280b = 0;
            while (i2 < 2) {
                int pointerCount = motionEvent.getPointerCount();
                int actionMasked2 = motionEvent.getActionMasked();
                int i3 = ((actionMasked2 == 1 || actionMasked2 == 6) && i2 >= motionEvent.getActionIndex()) ? i2 + 1 : i2;
                if (i3 >= pointerCount) {
                    i3 = -1;
                }
                if (i3 == -1) {
                    multiPointerGestureDetector.f4281c[i2] = -1;
                } else {
                    multiPointerGestureDetector.f4281c[i2] = motionEvent.getPointerId(i3);
                    float[] fArr = multiPointerGestureDetector.f4284f;
                    float[] fArr2 = multiPointerGestureDetector.f4282d;
                    float x2 = motionEvent.getX(i3);
                    fArr2[i2] = x2;
                    fArr[i2] = x2;
                    float[] fArr3 = multiPointerGestureDetector.f4285g;
                    float[] fArr4 = multiPointerGestureDetector.f4283e;
                    float y2 = motionEvent.getY(i3);
                    fArr4[i2] = y2;
                    fArr3[i2] = y2;
                    multiPointerGestureDetector.f4280b++;
                }
                i2++;
            }
            if (multiPointerGestureDetector.f4280b > 0) {
                multiPointerGestureDetector.m1543b();
            }
        } else if (actionMasked == 2) {
            while (i2 < 2) {
                int iFindPointerIndex = motionEvent.findPointerIndex(multiPointerGestureDetector.f4281c[i2]);
                if (iFindPointerIndex != -1) {
                    multiPointerGestureDetector.f4284f[i2] = motionEvent.getX(iFindPointerIndex);
                    multiPointerGestureDetector.f4285g[i2] = motionEvent.getY(iFindPointerIndex);
                }
                i2++;
            }
            if (!multiPointerGestureDetector.f4279a && multiPointerGestureDetector.f4280b > 0) {
                multiPointerGestureDetector.m1543b();
            }
            if (multiPointerGestureDetector.f4279a && (aVar = multiPointerGestureDetector.f4286h) != null && (aVar2 = (transformGestureDetector = (TransformGestureDetector) aVar).f4288b) != null) {
                aVar2.mo1549b(transformGestureDetector);
            }
        } else if (actionMasked == 3) {
            multiPointerGestureDetector.m1544c();
            multiPointerGestureDetector.m1542a();
        } else if (actionMasked == 5 || actionMasked == 6) {
        }
        return true;
    }

    /* renamed from: i */
    public final void m1563i() {
        this.f4306h.mapRect(this.f4304f, this.f4303e);
        ZoomableController.a aVar = this.f4300b;
        if (aVar == null || !this.f4301c) {
            return;
        }
        ZoomableDraweeView zoomableDraweeView = ZoomableDraweeView.this;
        zoomableDraweeView.getLogTag();
        zoomableDraweeView.hashCode();
        int i = FLog.f3102a;
        if (zoomableDraweeView.f19632n != null && ((DefaultZoomableController) zoomableDraweeView.f19633o).m1559e() > 1.1f) {
            zoomableDraweeView.m8725a(zoomableDraweeView.f19632n, null);
        }
        zoomableDraweeView.invalidate();
    }

    /* renamed from: j */
    public void mo1552j() {
        FLog.m981i(DefaultZoomableController.class, ModelAuditLogEntry.CHANGE_KEY_PERMISSIONS_RESET);
        this.f4299a.f4287a.m1542a();
        this.f4305g.reset();
        this.f4306h.reset();
        m1563i();
    }

    /* renamed from: k */
    public void m1564k(boolean z2) {
        this.f4301c = z2;
        if (z2) {
            return;
        }
        mo1552j();
    }
}

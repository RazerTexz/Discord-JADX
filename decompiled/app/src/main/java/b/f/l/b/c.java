package b.f.l.b;

import android.graphics.Matrix;
import android.graphics.RectF;
import android.view.MotionEvent;
import b.f.l.a.a;
import b.f.l.a.b;
import b.f.l.b.e;
import com.discord.models.domain.ModelAuditLogEntry;
import com.facebook.samples.zoomable.ZoomableDraweeView;
import java.util.Objects;

/* compiled from: DefaultZoomableController.java */
/* loaded from: classes3.dex */
public class c implements e, b.a {
    public b.f.l.a.b a;

    /* renamed from: b, reason: collision with root package name */
    public e.a f651b = null;
    public boolean c = false;
    public final RectF d = new RectF();
    public final RectF e = new RectF();
    public final RectF f = new RectF();
    public final Matrix g = new Matrix();
    public final Matrix h = new Matrix();
    public final Matrix i = new Matrix();
    public final float[] j = new float[9];
    public final RectF k = new RectF();
    public boolean l;

    static {
        new RectF(0.0f, 0.0f, 1.0f, 1.0f);
    }

    public c(b.f.l.a.b bVar) {
        this.a = bVar;
        bVar.f648b = this;
    }

    public static boolean l(int i, int i2) {
        return (i & i2) != 0;
    }

    @Override // b.f.l.b.e
    public boolean a() {
        this.h.getValues(this.j);
        float[] fArr = this.j;
        fArr[0] = fArr[0] - 1.0f;
        fArr[4] = fArr[4] - 1.0f;
        fArr[8] = fArr[8] - 1.0f;
        for (int i = 0; i < 9; i++) {
            if (Math.abs(this.j[i]) > 0.001f) {
                return false;
            }
        }
        return true;
    }

    public void b(b.f.l.a.b bVar) {
        float fHypot;
        b.f.d.e.a.i(c.class, "onGestureUpdate");
        Matrix matrix = this.h;
        b.f.l.a.b bVar2 = this.a;
        matrix.set(this.g);
        b.f.l.a.a aVar = bVar2.a;
        if (aVar.f647b < 2) {
            fHypot = 1.0f;
        } else {
            float[] fArr = aVar.d;
            float f = fArr[1] - fArr[0];
            float[] fArr2 = aVar.e;
            float f2 = fArr2[1] - fArr2[0];
            float[] fArr3 = aVar.f;
            float f3 = fArr3[1] - fArr3[0];
            float[] fArr4 = aVar.g;
            fHypot = ((float) Math.hypot(f3, fArr4[1] - fArr4[0])) / ((float) Math.hypot(f, f2));
        }
        matrix.postScale(fHypot, fHypot, bVar2.b(), bVar2.c());
        boolean zF = f(matrix, bVar2.b(), bVar2.c(), 7) | false;
        b.f.l.a.a aVar2 = bVar2.a;
        float fA = bVar2.a(aVar2.f, aVar2.f647b);
        b.f.l.a.a aVar3 = bVar2.a;
        float fA2 = fA - bVar2.a(aVar3.d, aVar3.f647b);
        b.f.l.a.a aVar4 = bVar2.a;
        float fA3 = bVar2.a(aVar4.g, aVar4.f647b);
        b.f.l.a.a aVar5 = bVar2.a;
        matrix.postTranslate(fA2, fA3 - bVar2.a(aVar5.e, aVar5.f647b));
        boolean zG = g(matrix, 7) | zF;
        i();
        if (zG) {
            this.a.d();
        }
        this.l = zG;
    }

    public void c(b.f.l.a.b bVar) {
        b.f.d.e.a.i(c.class, "onGestureBegin");
        this.g.set(this.h);
        RectF rectF = this.f;
        float f = rectF.left;
        RectF rectF2 = this.d;
        this.l = !(f < rectF2.left - 0.001f && rectF.top < rectF2.top - 0.001f && rectF.right > rectF2.right + 0.001f && rectF.bottom > rectF2.bottom + 0.001f);
    }

    public final float d(float f, float f2, float f3, float f4, float f5) {
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

    public float e() {
        this.h.getValues(this.j);
        return this.j[0];
    }

    public final boolean f(Matrix matrix, float f, float f2, int i) {
        if (!l(i, 4)) {
            return false;
        }
        matrix.getValues(this.j);
        float f3 = this.j[0];
        float fMin = Math.min(Math.max(1.0f, f3), 2.0f);
        if (fMin == f3) {
            return false;
        }
        float f4 = fMin / f3;
        matrix.postScale(f4, f4, f, f2);
        return true;
    }

    public final boolean g(Matrix matrix, int i) {
        float fD;
        float fD2;
        if (!l(i, 3)) {
            return false;
        }
        RectF rectF = this.k;
        rectF.set(this.e);
        matrix.mapRect(rectF);
        if (l(i, 1)) {
            float f = rectF.left;
            float f2 = rectF.right;
            RectF rectF2 = this.d;
            fD = d(f, f2, rectF2.left, rectF2.right, this.e.centerX());
        } else {
            fD = 0.0f;
        }
        if (l(i, 2)) {
            float f3 = rectF.top;
            float f4 = rectF.bottom;
            RectF rectF3 = this.d;
            fD2 = d(f3, f4, rectF3.top, rectF3.bottom, this.e.centerY());
        } else {
            fD2 = 0.0f;
        }
        if (fD == 0.0f && fD2 == 0.0f) {
            return false;
        }
        matrix.postTranslate(fD, fD2);
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x006d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean h(MotionEvent motionEvent) {
        a.InterfaceC0076a interfaceC0076a;
        b.f.l.a.b bVar;
        b.a aVar;
        motionEvent.getAction();
        int i = b.f.d.e.a.a;
        int i2 = 0;
        if (!this.c) {
            return false;
        }
        b.f.l.a.a aVar2 = this.a.a;
        Objects.requireNonNull(aVar2);
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0 || actionMasked == 1) {
            motionEvent.getPointerCount();
            motionEvent.getActionMasked();
            aVar2.c();
            aVar2.f647b = 0;
            while (i2 < 2) {
                int pointerCount = motionEvent.getPointerCount();
                int actionMasked2 = motionEvent.getActionMasked();
                int i3 = ((actionMasked2 == 1 || actionMasked2 == 6) && i2 >= motionEvent.getActionIndex()) ? i2 + 1 : i2;
                if (i3 >= pointerCount) {
                    i3 = -1;
                }
                if (i3 == -1) {
                    aVar2.c[i2] = -1;
                } else {
                    aVar2.c[i2] = motionEvent.getPointerId(i3);
                    float[] fArr = aVar2.f;
                    float[] fArr2 = aVar2.d;
                    float x2 = motionEvent.getX(i3);
                    fArr2[i2] = x2;
                    fArr[i2] = x2;
                    float[] fArr3 = aVar2.g;
                    float[] fArr4 = aVar2.e;
                    float y2 = motionEvent.getY(i3);
                    fArr4[i2] = y2;
                    fArr3[i2] = y2;
                    aVar2.f647b++;
                }
                i2++;
            }
            if (aVar2.f647b > 0) {
                aVar2.b();
            }
        } else if (actionMasked == 2) {
            while (i2 < 2) {
                int iFindPointerIndex = motionEvent.findPointerIndex(aVar2.c[i2]);
                if (iFindPointerIndex != -1) {
                    aVar2.f[i2] = motionEvent.getX(iFindPointerIndex);
                    aVar2.g[i2] = motionEvent.getY(iFindPointerIndex);
                }
                i2++;
            }
            if (!aVar2.a && aVar2.f647b > 0) {
                aVar2.b();
            }
            if (aVar2.a && (interfaceC0076a = aVar2.h) != null && (aVar = (bVar = (b.f.l.a.b) interfaceC0076a).f648b) != null) {
                aVar.b(bVar);
            }
        } else if (actionMasked == 3) {
            aVar2.c();
            aVar2.a();
        } else if (actionMasked == 5 || actionMasked == 6) {
        }
        return true;
    }

    public final void i() {
        this.h.mapRect(this.f, this.e);
        e.a aVar = this.f651b;
        if (aVar == null || !this.c) {
            return;
        }
        ZoomableDraweeView zoomableDraweeView = ZoomableDraweeView.this;
        zoomableDraweeView.getLogTag();
        zoomableDraweeView.hashCode();
        int i = b.f.d.e.a.a;
        if (zoomableDraweeView.n != null && ((c) zoomableDraweeView.o).e() > 1.1f) {
            zoomableDraweeView.a(zoomableDraweeView.n, null);
        }
        zoomableDraweeView.invalidate();
    }

    public void j() {
        b.f.d.e.a.i(c.class, ModelAuditLogEntry.CHANGE_KEY_PERMISSIONS_RESET);
        this.a.a.a();
        this.g.reset();
        this.h.reset();
        i();
    }

    public void k(boolean z2) {
        this.c = z2;
        if (z2) {
            return;
        }
        j();
    }
}

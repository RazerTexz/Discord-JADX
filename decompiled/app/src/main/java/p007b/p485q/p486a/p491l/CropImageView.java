package p007b.p485q.p486a.p491l;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import androidx.annotation.IntRange;
import androidx.annotation.Nullable;
import com.yalantis.ucrop.UCropActivity;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p007b.p485q.p486a.p487h.CropBoundsChangeListener;
import p007b.p485q.p486a.p491l.TransformImageView2;

/* JADX INFO: renamed from: b.q.a.l.a, reason: use source file name */
/* JADX INFO: compiled from: CropImageView.java */
/* JADX INFO: loaded from: classes3.dex */
public class CropImageView extends TransformImageView2 {

    /* JADX INFO: renamed from: A */
    public float f14454A;

    /* JADX INFO: renamed from: B */
    public float f14455B;

    /* JADX INFO: renamed from: C */
    public CropBoundsChangeListener f14456C;

    /* JADX INFO: renamed from: D */
    public Runnable f14457D;

    /* JADX INFO: renamed from: E */
    public Runnable f14458E;

    /* JADX INFO: renamed from: F */
    public float f14459F;

    /* JADX INFO: renamed from: G */
    public float f14460G;

    /* JADX INFO: renamed from: H */
    public int f14461H;

    /* JADX INFO: renamed from: I */
    public int f14462I;

    /* JADX INFO: renamed from: J */
    public long f14463J;

    /* JADX INFO: renamed from: y */
    public final RectF f14464y;

    /* JADX INFO: renamed from: z */
    public final Matrix f14465z;

    /* JADX INFO: renamed from: b.q.a.l.a$a */
    /* JADX INFO: compiled from: CropImageView.java */
    public static class a implements Runnable {

        /* JADX INFO: renamed from: j */
        public final WeakReference<CropImageView> f14466j;

        /* JADX INFO: renamed from: k */
        public final long f14467k;

        /* JADX INFO: renamed from: l */
        public final long f14468l = System.currentTimeMillis();

        /* JADX INFO: renamed from: m */
        public final float f14469m;

        /* JADX INFO: renamed from: n */
        public final float f14470n;

        /* JADX INFO: renamed from: o */
        public final float f14471o;

        /* JADX INFO: renamed from: p */
        public final float f14472p;

        /* JADX INFO: renamed from: q */
        public final float f14473q;

        /* JADX INFO: renamed from: r */
        public final float f14474r;

        /* JADX INFO: renamed from: s */
        public final boolean f14475s;

        public a(CropImageView cropImageView, long j, float f, float f2, float f3, float f4, float f5, float f6, boolean z2) {
            this.f14466j = new WeakReference<>(cropImageView);
            this.f14467k = j;
            this.f14469m = f;
            this.f14470n = f2;
            this.f14471o = f3;
            this.f14472p = f4;
            this.f14473q = f5;
            this.f14474r = f6;
            this.f14475s = z2;
        }

        @Override // java.lang.Runnable
        public void run() {
            CropImageView cropImageView = this.f14466j.get();
            if (cropImageView == null) {
                return;
            }
            float fMin = Math.min(this.f14467k, System.currentTimeMillis() - this.f14468l);
            float f = this.f14471o;
            float f2 = this.f14467k;
            float f3 = (fMin / f2) - 1.0f;
            float f4 = (f3 * f3 * f3) + 1.0f;
            float f5 = (f * f4) + 0.0f;
            float f6 = (f4 * this.f14472p) + 0.0f;
            float fM4246T = C3404f.m4246T(fMin, 0.0f, this.f14474r, f2);
            if (fMin < this.f14467k) {
                float[] fArr = cropImageView.f14485k;
                cropImageView.m7488g(f5 - (fArr[0] - this.f14469m), f6 - (fArr[1] - this.f14470n));
                if (!this.f14475s) {
                    cropImageView.m7483l(this.f14473q + fM4246T, cropImageView.f14464y.centerX(), cropImageView.f14464y.centerY());
                }
                if (cropImageView.m7481j(cropImageView.f14484j)) {
                    return;
                }
                cropImageView.post(this);
            }
        }
    }

    /* JADX INFO: renamed from: b.q.a.l.a$b */
    /* JADX INFO: compiled from: CropImageView.java */
    public static class b implements Runnable {

        /* JADX INFO: renamed from: j */
        public final WeakReference<CropImageView> f14476j;

        /* JADX INFO: renamed from: k */
        public final long f14477k;

        /* JADX INFO: renamed from: l */
        public final long f14478l = System.currentTimeMillis();

        /* JADX INFO: renamed from: m */
        public final float f14479m;

        /* JADX INFO: renamed from: n */
        public final float f14480n;

        /* JADX INFO: renamed from: o */
        public final float f14481o;

        /* JADX INFO: renamed from: p */
        public final float f14482p;

        public b(CropImageView cropImageView, long j, float f, float f2, float f3, float f4) {
            this.f14476j = new WeakReference<>(cropImageView);
            this.f14477k = j;
            this.f14479m = f;
            this.f14480n = f2;
            this.f14481o = f3;
            this.f14482p = f4;
        }

        @Override // java.lang.Runnable
        public void run() {
            CropImageView cropImageView = this.f14476j.get();
            if (cropImageView == null) {
                return;
            }
            float fMin = Math.min(this.f14477k, System.currentTimeMillis() - this.f14478l);
            float fM4246T = C3404f.m4246T(fMin, 0.0f, this.f14480n, this.f14477k);
            if (fMin >= this.f14477k) {
                cropImageView.setImageToWrapCropBounds(true);
            } else {
                cropImageView.m7483l(this.f14479m + fM4246T, this.f14481o, this.f14482p);
                cropImageView.post(this);
            }
        }
    }

    public CropImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @Override // p007b.p485q.p486a.p491l.TransformImageView2
    /* JADX INFO: renamed from: d */
    public void mo7477d() {
        super.mo7477d();
        Drawable drawable = getDrawable();
        if (drawable == null) {
            return;
        }
        float intrinsicWidth = drawable.getIntrinsicWidth();
        float intrinsicHeight = drawable.getIntrinsicHeight();
        if (this.f14454A == 0.0f) {
            this.f14454A = intrinsicWidth / intrinsicHeight;
        }
        int i = this.f14488n;
        float f = i;
        float f2 = this.f14454A;
        int i2 = (int) (f / f2);
        int i3 = this.f14489o;
        if (i2 > i3) {
            float f3 = i3;
            this.f14464y.set((i - ((int) (f2 * f3))) / 2, 0.0f, r5 + r2, f3);
        } else {
            this.f14464y.set(0.0f, (i3 - i2) / 2, f, i2 + r7);
        }
        m7479h(intrinsicWidth, intrinsicHeight);
        float fWidth = this.f14464y.width();
        float fHeight = this.f14464y.height();
        float fMax = Math.max(this.f14464y.width() / intrinsicWidth, this.f14464y.height() / intrinsicHeight);
        RectF rectF = this.f14464y;
        float f4 = ((fWidth - (intrinsicWidth * fMax)) / 2.0f) + rectF.left;
        float f5 = ((fHeight - (intrinsicHeight * fMax)) / 2.0f) + rectF.top;
        this.f14487m.reset();
        this.f14487m.postScale(fMax, fMax);
        this.f14487m.postTranslate(f4, f5);
        setImageMatrix(this.f14487m);
        CropBoundsChangeListener cropBoundsChangeListener = this.f14456C;
        if (cropBoundsChangeListener != null) {
            ((UCropView2) cropBoundsChangeListener).f14499a.f22242k.setTargetAspectRatio(this.f14454A);
        }
        TransformImageView2.a aVar = this.f14490p;
        if (aVar != null) {
            ((UCropActivity.C11200a) aVar).m9323b(getCurrentScale());
            ((UCropActivity.C11200a) this.f14490p).m9322a(getCurrentAngle());
        }
    }

    @Override // p007b.p485q.p486a.p491l.TransformImageView2
    /* JADX INFO: renamed from: f */
    public void mo7478f(float f, float f2, float f3) {
        if (f > 1.0f && getCurrentScale() * f <= getMaxScale()) {
            super.mo7478f(f, f2, f3);
        } else {
            if (f >= 1.0f || getCurrentScale() * f < getMinScale()) {
                return;
            }
            super.mo7478f(f, f2, f3);
        }
    }

    @Nullable
    public CropBoundsChangeListener getCropBoundsChangeListener() {
        return this.f14456C;
    }

    public float getMaxScale() {
        return this.f14459F;
    }

    public float getMinScale() {
        return this.f14460G;
    }

    public float getTargetAspectRatio() {
        return this.f14454A;
    }

    /* JADX INFO: renamed from: h */
    public final void m7479h(float f, float f2) {
        float fMin = Math.min(Math.min(this.f14464y.width() / f, this.f14464y.width() / f2), Math.min(this.f14464y.height() / f2, this.f14464y.height() / f));
        this.f14460G = fMin;
        this.f14459F = fMin * this.f14455B;
    }

    /* JADX INFO: renamed from: i */
    public void m7480i() {
        removeCallbacks(this.f14457D);
        removeCallbacks(this.f14458E);
    }

    /* JADX INFO: renamed from: j */
    public boolean m7481j(float[] fArr) {
        this.f14465z.reset();
        this.f14465z.setRotate(-getCurrentAngle());
        float[] fArrCopyOf = Arrays.copyOf(fArr, fArr.length);
        this.f14465z.mapPoints(fArrCopyOf);
        float[] fArrM4288f0 = C3404f.m4288f0(this.f14464y);
        this.f14465z.mapPoints(fArrM4288f0);
        return C3404f.m4365y1(fArrCopyOf).contains(C3404f.m4365y1(fArrM4288f0));
    }

    /* JADX INFO: renamed from: k */
    public void m7482k(float f) {
        m7487e(f, this.f14464y.centerX(), this.f14464y.centerY());
    }

    /* JADX INFO: renamed from: l */
    public void m7483l(float f, float f2, float f3) {
        if (f <= getMaxScale()) {
            mo7478f(f / getCurrentScale(), f2, f3);
        }
    }

    public void setCropBoundsChangeListener(@Nullable CropBoundsChangeListener cropBoundsChangeListener) {
        this.f14456C = cropBoundsChangeListener;
    }

    public void setCropRect(RectF rectF) {
        this.f14454A = rectF.width() / rectF.height();
        this.f14464y.set(rectF.left - getPaddingLeft(), rectF.top - getPaddingTop(), rectF.right - getPaddingRight(), rectF.bottom - getPaddingBottom());
        if (getDrawable() != null) {
            m7479h(r6.getIntrinsicWidth(), r6.getIntrinsicHeight());
        }
        setImageToWrapCropBounds(true);
    }

    public void setImageToWrapCropBounds(boolean z2) {
        float f;
        float f2;
        float fMax;
        float f3;
        if (!this.f14494t || m7481j(this.f14484j)) {
            return;
        }
        float[] fArr = this.f14485k;
        float f4 = fArr[0];
        float f5 = fArr[1];
        float currentScale = getCurrentScale();
        float fCenterX = this.f14464y.centerX() - f4;
        float fCenterY = this.f14464y.centerY() - f5;
        this.f14465z.reset();
        this.f14465z.setTranslate(fCenterX, fCenterY);
        float[] fArr2 = this.f14484j;
        float[] fArrCopyOf = Arrays.copyOf(fArr2, fArr2.length);
        this.f14465z.mapPoints(fArrCopyOf);
        boolean zM7481j = m7481j(fArrCopyOf);
        if (zM7481j) {
            this.f14465z.reset();
            this.f14465z.setRotate(-getCurrentAngle());
            float[] fArr3 = this.f14484j;
            float[] fArrCopyOf2 = Arrays.copyOf(fArr3, fArr3.length);
            float[] fArrM4288f0 = C3404f.m4288f0(this.f14464y);
            this.f14465z.mapPoints(fArrCopyOf2);
            this.f14465z.mapPoints(fArrM4288f0);
            RectF rectFM4365y1 = C3404f.m4365y1(fArrCopyOf2);
            RectF rectFM4365y12 = C3404f.m4365y1(fArrM4288f0);
            float f6 = rectFM4365y1.left - rectFM4365y12.left;
            float f7 = rectFM4365y1.top - rectFM4365y12.top;
            float f8 = rectFM4365y1.right - rectFM4365y12.right;
            float f9 = rectFM4365y1.bottom - rectFM4365y12.bottom;
            float[] fArr4 = new float[4];
            if (f6 <= 0.0f) {
                f6 = 0.0f;
            }
            fArr4[0] = f6;
            if (f7 <= 0.0f) {
                f7 = 0.0f;
            }
            fArr4[1] = f7;
            if (f8 >= 0.0f) {
                f8 = 0.0f;
            }
            fArr4[2] = f8;
            if (f9 >= 0.0f) {
                f9 = 0.0f;
            }
            fArr4[3] = f9;
            this.f14465z.reset();
            this.f14465z.setRotate(getCurrentAngle());
            this.f14465z.mapPoints(fArr4);
            f2 = -(fArr4[0] + fArr4[2]);
            f3 = -(fArr4[1] + fArr4[3]);
            f = currentScale;
            fMax = 0.0f;
        } else {
            RectF rectF = new RectF(this.f14464y);
            this.f14465z.reset();
            this.f14465z.setRotate(getCurrentAngle());
            this.f14465z.mapRect(rectF);
            float[] fArr5 = this.f14484j;
            f = currentScale;
            float[] fArr6 = {(float) Math.sqrt(Math.pow(fArr5[1] - fArr5[3], 2.0d) + Math.pow(fArr5[0] - fArr5[2], 2.0d)), (float) Math.sqrt(Math.pow(fArr5[3] - fArr5[5], 2.0d) + Math.pow(fArr5[2] - fArr5[4], 2.0d))};
            f2 = fCenterX;
            fMax = (Math.max(rectF.width() / fArr6[0], rectF.height() / fArr6[1]) * f) - f;
            f3 = fCenterY;
        }
        if (z2) {
            a aVar = new a(this, this.f14463J, f4, f5, f2, f3, f, fMax, zM7481j);
            this.f14457D = aVar;
            post(aVar);
        } else {
            m7488g(f2, f3);
            if (zM7481j) {
                return;
            }
            m7483l(f + fMax, this.f14464y.centerX(), this.f14464y.centerY());
        }
    }

    public void setImageToWrapCropBoundsAnimDuration(@IntRange(from = 100) long j) {
        if (j <= 0) {
            throw new IllegalArgumentException("Animation duration cannot be negative value.");
        }
        this.f14463J = j;
    }

    public void setMaxResultImageSizeX(@IntRange(from = 10) int i) {
        this.f14461H = i;
    }

    public void setMaxResultImageSizeY(@IntRange(from = 10) int i) {
        this.f14462I = i;
    }

    public void setMaxScaleMultiplier(float f) {
        this.f14455B = f;
    }

    public void setTargetAspectRatio(float f) {
        if (getDrawable() == null) {
            this.f14454A = f;
            return;
        }
        if (f == 0.0f) {
            this.f14454A = r0.getIntrinsicWidth() / r0.getIntrinsicHeight();
        } else {
            this.f14454A = f;
        }
        CropBoundsChangeListener cropBoundsChangeListener = this.f14456C;
        if (cropBoundsChangeListener != null) {
            ((UCropView2) cropBoundsChangeListener).f14499a.f22242k.setTargetAspectRatio(this.f14454A);
        }
    }

    public CropImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f14464y = new RectF();
        this.f14465z = new Matrix();
        this.f14455B = 10.0f;
        this.f14458E = null;
        this.f14461H = 0;
        this.f14462I = 0;
        this.f14463J = 500L;
    }
}

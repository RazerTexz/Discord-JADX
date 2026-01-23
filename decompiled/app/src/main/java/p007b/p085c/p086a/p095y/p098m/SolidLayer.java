package p007b.p085c.p086a.p095y.p098m;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import androidx.annotation.Nullable;
import p007b.p085c.p086a.LottieDrawable;
import p007b.p085c.p086a.LottieProperty;
import p007b.p085c.p086a.p090c0.LottieValueCallback;
import p007b.p085c.p086a.p091w.LPaint;
import p007b.p085c.p086a.p091w.p093c.BaseKeyframeAnimation;
import p007b.p085c.p086a.p091w.p093c.ValueCallbackKeyframeAnimation;

/* JADX INFO: renamed from: b.c.a.y.m.h, reason: use source file name */
/* JADX INFO: compiled from: SolidLayer.java */
/* JADX INFO: loaded from: classes.dex */
public class SolidLayer extends BaseLayer2 {

    /* JADX INFO: renamed from: A */
    public final Path f2899A;

    /* JADX INFO: renamed from: B */
    public final Layer2 f2900B;

    /* JADX INFO: renamed from: C */
    @Nullable
    public BaseKeyframeAnimation<ColorFilter, ColorFilter> f2901C;

    /* JADX INFO: renamed from: x */
    public final RectF f2902x;

    /* JADX INFO: renamed from: y */
    public final Paint f2903y;

    /* JADX INFO: renamed from: z */
    public final float[] f2904z;

    public SolidLayer(LottieDrawable lottieDrawable, Layer2 layer2) {
        super(lottieDrawable, layer2);
        this.f2902x = new RectF();
        LPaint lPaint = new LPaint();
        this.f2903y = lPaint;
        this.f2904z = new float[8];
        this.f2899A = new Path();
        this.f2900B = layer2;
        lPaint.setAlpha(0);
        lPaint.setStyle(Paint.Style.FILL);
        lPaint.setColor(layer2.f2879l);
    }

    @Override // p007b.p085c.p086a.p095y.p098m.BaseLayer2, p007b.p085c.p086a.p091w.p092b.DrawingContent
    /* JADX INFO: renamed from: d */
    public void mo712d(RectF rectF, Matrix matrix, boolean z2) {
        super.mo712d(rectF, matrix, z2);
        RectF rectF2 = this.f2902x;
        Layer2 layer2 = this.f2900B;
        rectF2.set(0.0f, 0.0f, layer2.f2877j, layer2.f2878k);
        this.f2848m.mapRect(this.f2902x);
        rectF.set(this.f2902x);
    }

    @Override // p007b.p085c.p086a.p095y.p098m.BaseLayer2, p007b.p085c.p086a.p095y.KeyPathElement
    /* JADX INFO: renamed from: g */
    public <T> void mo714g(T t, @Nullable LottieValueCallback<T> lottieValueCallback) {
        this.f2857v.m745c(t, lottieValueCallback);
        if (t == LottieProperty.f2421C) {
            if (lottieValueCallback == null) {
                this.f2901C = null;
            } else {
                this.f2901C = new ValueCallbackKeyframeAnimation(lottieValueCallback, null);
            }
        }
    }

    @Override // p007b.p085c.p086a.p095y.p098m.BaseLayer2
    /* JADX INFO: renamed from: j */
    public void mo780j(Canvas canvas, Matrix matrix, int i) {
        int iAlpha = Color.alpha(this.f2900B.f2879l);
        if (iAlpha == 0) {
            return;
        }
        int iIntValue = (int) ((((iAlpha / 255.0f) * (this.f2857v.f2636j == null ? 100 : r1.mo727e().intValue())) / 100.0f) * (i / 255.0f) * 255.0f);
        this.f2903y.setAlpha(iIntValue);
        BaseKeyframeAnimation<ColorFilter, ColorFilter> baseKeyframeAnimation = this.f2901C;
        if (baseKeyframeAnimation != null) {
            this.f2903y.setColorFilter(baseKeyframeAnimation.mo727e());
        }
        if (iIntValue > 0) {
            float[] fArr = this.f2904z;
            fArr[0] = 0.0f;
            fArr[1] = 0.0f;
            Layer2 layer2 = this.f2900B;
            int i2 = layer2.f2877j;
            fArr[2] = i2;
            fArr[3] = 0.0f;
            fArr[4] = i2;
            int i3 = layer2.f2878k;
            fArr[5] = i3;
            fArr[6] = 0.0f;
            fArr[7] = i3;
            matrix.mapPoints(fArr);
            this.f2899A.reset();
            Path path = this.f2899A;
            float[] fArr2 = this.f2904z;
            path.moveTo(fArr2[0], fArr2[1]);
            Path path2 = this.f2899A;
            float[] fArr3 = this.f2904z;
            path2.lineTo(fArr3[2], fArr3[3]);
            Path path3 = this.f2899A;
            float[] fArr4 = this.f2904z;
            path3.lineTo(fArr4[4], fArr4[5]);
            Path path4 = this.f2899A;
            float[] fArr5 = this.f2904z;
            path4.lineTo(fArr5[6], fArr5[7]);
            Path path5 = this.f2899A;
            float[] fArr6 = this.f2904z;
            path5.lineTo(fArr6[0], fArr6[1]);
            this.f2899A.close();
            canvas.drawPath(this.f2899A, this.f2903y);
        }
    }
}

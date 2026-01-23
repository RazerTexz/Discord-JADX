package p007b.p085c.p086a.p091w.p093c;

import android.graphics.Matrix;
import android.graphics.PointF;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Collections;
import p007b.p085c.p086a.LottieProperty;
import p007b.p085c.p086a.p090c0.Keyframe;
import p007b.p085c.p086a.p090c0.LottieValueCallback;
import p007b.p085c.p086a.p090c0.ScaleXY;
import p007b.p085c.p086a.p091w.p093c.BaseKeyframeAnimation;
import p007b.p085c.p086a.p095y.p096k.AnimatableFloatValue;
import p007b.p085c.p086a.p095y.p096k.AnimatableIntegerValue;
import p007b.p085c.p086a.p095y.p096k.AnimatablePathValue;
import p007b.p085c.p086a.p095y.p096k.AnimatableScaleValue;
import p007b.p085c.p086a.p095y.p096k.AnimatableTransform;
import p007b.p085c.p086a.p095y.p096k.AnimatableValue;
import p007b.p085c.p086a.p095y.p098m.BaseLayer2;

/* JADX INFO: renamed from: b.c.a.w.c.o, reason: use source file name */
/* JADX INFO: compiled from: TransformKeyframeAnimation.java */
/* JADX INFO: loaded from: classes.dex */
public class TransformKeyframeAnimation {

    /* JADX INFO: renamed from: a */
    public final Matrix f2627a = new Matrix();

    /* JADX INFO: renamed from: b */
    public final Matrix f2628b;

    /* JADX INFO: renamed from: c */
    public final Matrix f2629c;

    /* JADX INFO: renamed from: d */
    public final Matrix f2630d;

    /* JADX INFO: renamed from: e */
    public final float[] f2631e;

    /* JADX INFO: renamed from: f */
    @NonNull
    public BaseKeyframeAnimation<PointF, PointF> f2632f;

    /* JADX INFO: renamed from: g */
    @NonNull
    public BaseKeyframeAnimation<?, PointF> f2633g;

    /* JADX INFO: renamed from: h */
    @NonNull
    public BaseKeyframeAnimation<ScaleXY, ScaleXY> f2634h;

    /* JADX INFO: renamed from: i */
    @NonNull
    public BaseKeyframeAnimation<Float, Float> f2635i;

    /* JADX INFO: renamed from: j */
    @NonNull
    public BaseKeyframeAnimation<Integer, Integer> f2636j;

    /* JADX INFO: renamed from: k */
    @Nullable
    public FloatKeyframeAnimation f2637k;

    /* JADX INFO: renamed from: l */
    @Nullable
    public FloatKeyframeAnimation f2638l;

    /* JADX INFO: renamed from: m */
    @Nullable
    public BaseKeyframeAnimation<?, Float> f2639m;

    /* JADX INFO: renamed from: n */
    @Nullable
    public BaseKeyframeAnimation<?, Float> f2640n;

    public TransformKeyframeAnimation(AnimatableTransform animatableTransform) {
        AnimatablePathValue animatablePathValue = animatableTransform.f2729a;
        this.f2632f = animatablePathValue == null ? null : animatablePathValue.mo773a();
        AnimatableValue<PointF, PointF> animatableValue = animatableTransform.f2730b;
        this.f2633g = animatableValue == null ? null : animatableValue.mo773a();
        AnimatableScaleValue animatableScaleValue = animatableTransform.f2731c;
        this.f2634h = animatableScaleValue == null ? null : animatableScaleValue.mo773a();
        AnimatableFloatValue animatableFloatValue = animatableTransform.f2732d;
        this.f2635i = animatableFloatValue == null ? null : animatableFloatValue.mo773a();
        AnimatableFloatValue animatableFloatValue2 = animatableTransform.f2734f;
        FloatKeyframeAnimation floatKeyframeAnimation = animatableFloatValue2 == null ? null : (FloatKeyframeAnimation) animatableFloatValue2.mo773a();
        this.f2637k = floatKeyframeAnimation;
        if (floatKeyframeAnimation != null) {
            this.f2628b = new Matrix();
            this.f2629c = new Matrix();
            this.f2630d = new Matrix();
            this.f2631e = new float[9];
        } else {
            this.f2628b = null;
            this.f2629c = null;
            this.f2630d = null;
            this.f2631e = null;
        }
        AnimatableFloatValue animatableFloatValue3 = animatableTransform.f2735g;
        this.f2638l = animatableFloatValue3 == null ? null : (FloatKeyframeAnimation) animatableFloatValue3.mo773a();
        AnimatableIntegerValue animatableIntegerValue = animatableTransform.f2733e;
        if (animatableIntegerValue != null) {
            this.f2636j = animatableIntegerValue.mo773a();
        }
        AnimatableFloatValue animatableFloatValue4 = animatableTransform.f2736h;
        if (animatableFloatValue4 != null) {
            this.f2639m = animatableFloatValue4.mo773a();
        } else {
            this.f2639m = null;
        }
        AnimatableFloatValue animatableFloatValue5 = animatableTransform.f2737i;
        if (animatableFloatValue5 != null) {
            this.f2640n = animatableFloatValue5.mo773a();
        } else {
            this.f2640n = null;
        }
    }

    /* JADX INFO: renamed from: a */
    public void m743a(BaseLayer2 baseLayer2) {
        baseLayer2.m777e(this.f2636j);
        baseLayer2.m777e(this.f2639m);
        baseLayer2.m777e(this.f2640n);
        baseLayer2.m777e(this.f2632f);
        baseLayer2.m777e(this.f2633g);
        baseLayer2.m777e(this.f2634h);
        baseLayer2.m777e(this.f2635i);
        baseLayer2.m777e(this.f2637k);
        baseLayer2.m777e(this.f2638l);
    }

    /* JADX INFO: renamed from: b */
    public void m744b(BaseKeyframeAnimation.b bVar) {
        BaseKeyframeAnimation<Integer, Integer> baseKeyframeAnimation = this.f2636j;
        if (baseKeyframeAnimation != null) {
            baseKeyframeAnimation.f2596a.add(bVar);
        }
        BaseKeyframeAnimation<?, Float> baseKeyframeAnimation2 = this.f2639m;
        if (baseKeyframeAnimation2 != null) {
            baseKeyframeAnimation2.f2596a.add(bVar);
        }
        BaseKeyframeAnimation<?, Float> baseKeyframeAnimation3 = this.f2640n;
        if (baseKeyframeAnimation3 != null) {
            baseKeyframeAnimation3.f2596a.add(bVar);
        }
        BaseKeyframeAnimation<PointF, PointF> baseKeyframeAnimation4 = this.f2632f;
        if (baseKeyframeAnimation4 != null) {
            baseKeyframeAnimation4.f2596a.add(bVar);
        }
        BaseKeyframeAnimation<?, PointF> baseKeyframeAnimation5 = this.f2633g;
        if (baseKeyframeAnimation5 != null) {
            baseKeyframeAnimation5.f2596a.add(bVar);
        }
        BaseKeyframeAnimation<ScaleXY, ScaleXY> baseKeyframeAnimation6 = this.f2634h;
        if (baseKeyframeAnimation6 != null) {
            baseKeyframeAnimation6.f2596a.add(bVar);
        }
        BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation7 = this.f2635i;
        if (baseKeyframeAnimation7 != null) {
            baseKeyframeAnimation7.f2596a.add(bVar);
        }
        FloatKeyframeAnimation floatKeyframeAnimation = this.f2637k;
        if (floatKeyframeAnimation != null) {
            floatKeyframeAnimation.f2596a.add(bVar);
        }
        FloatKeyframeAnimation floatKeyframeAnimation2 = this.f2638l;
        if (floatKeyframeAnimation2 != null) {
            floatKeyframeAnimation2.f2596a.add(bVar);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: c */
    public <T> boolean m745c(T t, @Nullable LottieValueCallback<T> lottieValueCallback) {
        FloatKeyframeAnimation floatKeyframeAnimation;
        FloatKeyframeAnimation floatKeyframeAnimation2;
        BaseKeyframeAnimation<?, Float> baseKeyframeAnimation;
        BaseKeyframeAnimation<?, Float> baseKeyframeAnimation2;
        if (t == LottieProperty.f2427e) {
            BaseKeyframeAnimation<PointF, PointF> baseKeyframeAnimation3 = this.f2632f;
            if (baseKeyframeAnimation3 == null) {
                this.f2632f = new ValueCallbackKeyframeAnimation(lottieValueCallback, new PointF());
                return true;
            }
            LottieValueCallback<PointF> lottieValueCallback2 = baseKeyframeAnimation3.f2600e;
            baseKeyframeAnimation3.f2600e = lottieValueCallback;
            return true;
        }
        if (t == LottieProperty.f2428f) {
            BaseKeyframeAnimation<?, PointF> baseKeyframeAnimation4 = this.f2633g;
            if (baseKeyframeAnimation4 == null) {
                this.f2633g = new ValueCallbackKeyframeAnimation(lottieValueCallback, new PointF());
                return true;
            }
            LottieValueCallback<PointF> lottieValueCallback3 = baseKeyframeAnimation4.f2600e;
            baseKeyframeAnimation4.f2600e = lottieValueCallback;
            return true;
        }
        if (t == LottieProperty.f2433k) {
            BaseKeyframeAnimation<ScaleXY, ScaleXY> baseKeyframeAnimation5 = this.f2634h;
            if (baseKeyframeAnimation5 == null) {
                this.f2634h = new ValueCallbackKeyframeAnimation(lottieValueCallback, new ScaleXY());
                return true;
            }
            LottieValueCallback<ScaleXY> lottieValueCallback4 = baseKeyframeAnimation5.f2600e;
            baseKeyframeAnimation5.f2600e = lottieValueCallback;
            return true;
        }
        if (t == LottieProperty.f2434l) {
            BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation6 = this.f2635i;
            if (baseKeyframeAnimation6 == null) {
                this.f2635i = new ValueCallbackKeyframeAnimation(lottieValueCallback, Float.valueOf(0.0f));
                return true;
            }
            LottieValueCallback<Float> lottieValueCallback5 = baseKeyframeAnimation6.f2600e;
            baseKeyframeAnimation6.f2600e = lottieValueCallback;
            return true;
        }
        if (t == LottieProperty.f2425c) {
            BaseKeyframeAnimation<Integer, Integer> baseKeyframeAnimation7 = this.f2636j;
            if (baseKeyframeAnimation7 == null) {
                this.f2636j = new ValueCallbackKeyframeAnimation(lottieValueCallback, 100);
                return true;
            }
            LottieValueCallback<Integer> lottieValueCallback6 = baseKeyframeAnimation7.f2600e;
            baseKeyframeAnimation7.f2600e = lottieValueCallback;
            return true;
        }
        if (t == LottieProperty.f2447y && (baseKeyframeAnimation2 = this.f2639m) != null) {
            if (baseKeyframeAnimation2 == null) {
                this.f2639m = new ValueCallbackKeyframeAnimation(lottieValueCallback, 100);
                return true;
            }
            LottieValueCallback<Float> lottieValueCallback7 = baseKeyframeAnimation2.f2600e;
            baseKeyframeAnimation2.f2600e = lottieValueCallback;
            return true;
        }
        if (t == LottieProperty.f2448z && (baseKeyframeAnimation = this.f2640n) != null) {
            if (baseKeyframeAnimation == null) {
                this.f2640n = new ValueCallbackKeyframeAnimation(lottieValueCallback, 100);
                return true;
            }
            LottieValueCallback<Float> lottieValueCallback8 = baseKeyframeAnimation.f2600e;
            baseKeyframeAnimation.f2600e = lottieValueCallback;
            return true;
        }
        if (t == LottieProperty.f2435m && (floatKeyframeAnimation2 = this.f2637k) != null) {
            if (floatKeyframeAnimation2 == null) {
                this.f2637k = new FloatKeyframeAnimation(Collections.singletonList(new Keyframe(Float.valueOf(0.0f))));
            }
            FloatKeyframeAnimation floatKeyframeAnimation3 = this.f2637k;
            Object obj = floatKeyframeAnimation3.f2600e;
            floatKeyframeAnimation3.f2600e = lottieValueCallback;
            return true;
        }
        if (t != LottieProperty.f2436n || (floatKeyframeAnimation = this.f2638l) == null) {
            return false;
        }
        if (floatKeyframeAnimation == null) {
            this.f2638l = new FloatKeyframeAnimation(Collections.singletonList(new Keyframe(Float.valueOf(0.0f))));
        }
        FloatKeyframeAnimation floatKeyframeAnimation4 = this.f2638l;
        Object obj2 = floatKeyframeAnimation4.f2600e;
        floatKeyframeAnimation4.f2600e = lottieValueCallback;
        return true;
    }

    /* JADX INFO: renamed from: d */
    public final void m746d() {
        for (int i = 0; i < 9; i++) {
            this.f2631e[i] = 0.0f;
        }
    }

    /* JADX INFO: renamed from: e */
    public Matrix m747e() {
        this.f2627a.reset();
        BaseKeyframeAnimation<?, PointF> baseKeyframeAnimation = this.f2633g;
        if (baseKeyframeAnimation != null) {
            PointF pointFMo727e = baseKeyframeAnimation.mo727e();
            float f = pointFMo727e.x;
            if (f != 0.0f || pointFMo727e.y != 0.0f) {
                this.f2627a.preTranslate(f, pointFMo727e.y);
            }
        }
        BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation2 = this.f2635i;
        if (baseKeyframeAnimation2 != null) {
            float fFloatValue = baseKeyframeAnimation2 instanceof ValueCallbackKeyframeAnimation ? baseKeyframeAnimation2.mo727e().floatValue() : ((FloatKeyframeAnimation) baseKeyframeAnimation2).m739j();
            if (fFloatValue != 0.0f) {
                this.f2627a.preRotate(fFloatValue);
            }
        }
        if (this.f2637k != null) {
            float fCos = this.f2638l == null ? 0.0f : (float) Math.cos(Math.toRadians((-r0.m739j()) + 90.0f));
            float fSin = this.f2638l == null ? 1.0f : (float) Math.sin(Math.toRadians((-r4.m739j()) + 90.0f));
            float fTan = (float) Math.tan(Math.toRadians(this.f2637k.m739j()));
            m746d();
            float[] fArr = this.f2631e;
            fArr[0] = fCos;
            fArr[1] = fSin;
            float f2 = -fSin;
            fArr[3] = f2;
            fArr[4] = fCos;
            fArr[8] = 1.0f;
            this.f2628b.setValues(fArr);
            m746d();
            float[] fArr2 = this.f2631e;
            fArr2[0] = 1.0f;
            fArr2[3] = fTan;
            fArr2[4] = 1.0f;
            fArr2[8] = 1.0f;
            this.f2629c.setValues(fArr2);
            m746d();
            float[] fArr3 = this.f2631e;
            fArr3[0] = fCos;
            fArr3[1] = f2;
            fArr3[3] = fSin;
            fArr3[4] = fCos;
            fArr3[8] = 1.0f;
            this.f2630d.setValues(fArr3);
            this.f2629c.preConcat(this.f2628b);
            this.f2630d.preConcat(this.f2629c);
            this.f2627a.preConcat(this.f2630d);
        }
        BaseKeyframeAnimation<ScaleXY, ScaleXY> baseKeyframeAnimation3 = this.f2634h;
        if (baseKeyframeAnimation3 != null) {
            ScaleXY scaleXYMo727e = baseKeyframeAnimation3.mo727e();
            float f3 = scaleXYMo727e.f2334a;
            if (f3 != 1.0f || scaleXYMo727e.f2335b != 1.0f) {
                this.f2627a.preScale(f3, scaleXYMo727e.f2335b);
            }
        }
        BaseKeyframeAnimation<PointF, PointF> baseKeyframeAnimation4 = this.f2632f;
        if (baseKeyframeAnimation4 != null) {
            PointF pointFMo727e2 = baseKeyframeAnimation4.mo727e();
            float f4 = pointFMo727e2.x;
            if (f4 != 0.0f || pointFMo727e2.y != 0.0f) {
                this.f2627a.preTranslate(-f4, -pointFMo727e2.y);
            }
        }
        return this.f2627a;
    }

    /* JADX INFO: renamed from: f */
    public Matrix m748f(float f) {
        BaseKeyframeAnimation<?, PointF> baseKeyframeAnimation = this.f2633g;
        PointF pointFMo727e = baseKeyframeAnimation == null ? null : baseKeyframeAnimation.mo727e();
        BaseKeyframeAnimation<ScaleXY, ScaleXY> baseKeyframeAnimation2 = this.f2634h;
        ScaleXY scaleXYMo727e = baseKeyframeAnimation2 == null ? null : baseKeyframeAnimation2.mo727e();
        this.f2627a.reset();
        if (pointFMo727e != null) {
            this.f2627a.preTranslate(pointFMo727e.x * f, pointFMo727e.y * f);
        }
        if (scaleXYMo727e != null) {
            double d = f;
            this.f2627a.preScale((float) Math.pow(scaleXYMo727e.f2334a, d), (float) Math.pow(scaleXYMo727e.f2335b, d));
        }
        BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation3 = this.f2635i;
        if (baseKeyframeAnimation3 != null) {
            float fFloatValue = baseKeyframeAnimation3.mo727e().floatValue();
            BaseKeyframeAnimation<PointF, PointF> baseKeyframeAnimation4 = this.f2632f;
            PointF pointFMo727e2 = baseKeyframeAnimation4 != null ? baseKeyframeAnimation4.mo727e() : null;
            this.f2627a.preRotate(fFloatValue * f, pointFMo727e2 == null ? 0.0f : pointFMo727e2.x, pointFMo727e2 != null ? pointFMo727e2.y : 0.0f);
        }
        return this.f2627a;
    }
}

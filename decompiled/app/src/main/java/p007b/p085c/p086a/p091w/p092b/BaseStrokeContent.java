package p007b.p085c.p086a.p091w.p092b;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.DashPathEffect;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.RectF;
import androidx.annotation.CallSuper;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;
import p007b.p085c.p086a.L;
import p007b.p085c.p086a.LottieDrawable;
import p007b.p085c.p086a.LottieProperty;
import p007b.p085c.p086a.p089b0.MiscUtils;
import p007b.p085c.p086a.p089b0.Utils;
import p007b.p085c.p086a.p090c0.LottieValueCallback;
import p007b.p085c.p086a.p091w.LPaint;
import p007b.p085c.p086a.p091w.p093c.BaseKeyframeAnimation;
import p007b.p085c.p086a.p091w.p093c.FloatKeyframeAnimation;
import p007b.p085c.p086a.p091w.p093c.IntegerKeyframeAnimation;
import p007b.p085c.p086a.p091w.p093c.ValueCallbackKeyframeAnimation;
import p007b.p085c.p086a.p095y.KeyPath;
import p007b.p085c.p086a.p095y.p096k.AnimatableFloatValue;
import p007b.p085c.p086a.p095y.p096k.AnimatableIntegerValue;
import p007b.p085c.p086a.p095y.p098m.BaseLayer2;

/* compiled from: BaseStrokeContent.java */
/* renamed from: b.c.a.w.b.a, reason: use source file name */
/* loaded from: classes.dex */
public abstract class BaseStrokeContent implements BaseKeyframeAnimation.b, KeyPathElementContent, DrawingContent {

    /* renamed from: e */
    public final LottieDrawable f2469e;

    /* renamed from: f */
    public final BaseLayer2 f2470f;

    /* renamed from: h */
    public final float[] f2472h;

    /* renamed from: i */
    public final Paint f2473i;

    /* renamed from: j */
    public final BaseKeyframeAnimation<?, Float> f2474j;

    /* renamed from: k */
    public final BaseKeyframeAnimation<?, Integer> f2475k;

    /* renamed from: l */
    public final List<BaseKeyframeAnimation<?, Float>> f2476l;

    /* renamed from: m */
    @Nullable
    public final BaseKeyframeAnimation<?, Float> f2477m;

    /* renamed from: n */
    @Nullable
    public BaseKeyframeAnimation<ColorFilter, ColorFilter> f2478n;

    /* renamed from: a */
    public final PathMeasure f2465a = new PathMeasure();

    /* renamed from: b */
    public final Path f2466b = new Path();

    /* renamed from: c */
    public final Path f2467c = new Path();

    /* renamed from: d */
    public final RectF f2468d = new RectF();

    /* renamed from: g */
    public final List<b> f2471g = new ArrayList();

    /* compiled from: BaseStrokeContent.java */
    /* renamed from: b.c.a.w.b.a$b */
    public static final class b {

        /* renamed from: a */
        public final List<PathContent> f2479a = new ArrayList();

        /* renamed from: b */
        @Nullable
        public final TrimPathContent f2480b;

        public b(TrimPathContent trimPathContent, a aVar) {
            this.f2480b = trimPathContent;
        }
    }

    public BaseStrokeContent(LottieDrawable lottieDrawable, BaseLayer2 baseLayer2, Paint.Cap cap, Paint.Join join, float f, AnimatableIntegerValue animatableIntegerValue, AnimatableFloatValue animatableFloatValue, List<AnimatableFloatValue> list, AnimatableFloatValue animatableFloatValue2) {
        LPaint lPaint = new LPaint(1);
        this.f2473i = lPaint;
        this.f2469e = lottieDrawable;
        this.f2470f = baseLayer2;
        lPaint.setStyle(Paint.Style.STROKE);
        lPaint.setStrokeCap(cap);
        lPaint.setStrokeJoin(join);
        lPaint.setStrokeMiter(f);
        this.f2475k = animatableIntegerValue.mo773a();
        this.f2474j = animatableFloatValue.mo773a();
        if (animatableFloatValue2 == null) {
            this.f2477m = null;
        } else {
            this.f2477m = animatableFloatValue2.mo773a();
        }
        this.f2476l = new ArrayList(list.size());
        this.f2472h = new float[list.size()];
        for (int i = 0; i < list.size(); i++) {
            this.f2476l.add(list.get(i).mo773a());
        }
        baseLayer2.m777e(this.f2475k);
        baseLayer2.m777e(this.f2474j);
        for (int i2 = 0; i2 < this.f2476l.size(); i2++) {
            baseLayer2.m777e(this.f2476l.get(i2));
        }
        BaseKeyframeAnimation<?, Float> baseKeyframeAnimation = this.f2477m;
        if (baseKeyframeAnimation != null) {
            baseLayer2.m777e(baseKeyframeAnimation);
        }
        this.f2475k.f2596a.add(this);
        this.f2474j.f2596a.add(this);
        for (int i3 = 0; i3 < list.size(); i3++) {
            this.f2476l.get(i3).f2596a.add(this);
        }
        BaseKeyframeAnimation<?, Float> baseKeyframeAnimation2 = this.f2477m;
        if (baseKeyframeAnimation2 != null) {
            baseKeyframeAnimation2.f2596a.add(this);
        }
    }

    @Override // p007b.p085c.p086a.p091w.p093c.BaseKeyframeAnimation.b
    /* renamed from: a */
    public void mo709a() {
        this.f2469e.invalidateSelf();
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0052  */
    @Override // p007b.p085c.p086a.p091w.p092b.Content2
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void mo710b(List<Content2> list, List<Content2> list2) {
        TrimPathContent trimPathContent = null;
        for (int size = list.size() - 1; size >= 0; size--) {
            Content2 content2 = list.get(size);
            if (content2 instanceof TrimPathContent) {
                TrimPathContent trimPathContent2 = (TrimPathContent) content2;
                if (trimPathContent2.f2592c == 2) {
                    trimPathContent = trimPathContent2;
                }
            }
        }
        if (trimPathContent != null) {
            trimPathContent.f2591b.add(this);
        }
        b bVar = null;
        for (int size2 = list2.size() - 1; size2 >= 0; size2--) {
            Content2 content22 = list2.get(size2);
            if (content22 instanceof TrimPathContent) {
                TrimPathContent trimPathContent3 = (TrimPathContent) content22;
                if (trimPathContent3.f2592c == 2) {
                    if (bVar != null) {
                        this.f2471g.add(bVar);
                    }
                    bVar = new b(trimPathContent3, null);
                    trimPathContent3.f2591b.add(this);
                } else if (content22 instanceof PathContent) {
                    if (bVar == null) {
                        bVar = new b(trimPathContent, null);
                    }
                    bVar.f2479a.add((PathContent) content22);
                }
            }
        }
        if (bVar != null) {
            this.f2471g.add(bVar);
        }
    }

    @Override // p007b.p085c.p086a.p095y.KeyPathElement
    /* renamed from: c */
    public void mo711c(KeyPath keyPath, int i, List<KeyPath> list, KeyPath keyPath2) {
        MiscUtils.m656f(keyPath, i, list, keyPath2, this);
    }

    @Override // p007b.p085c.p086a.p091w.p092b.DrawingContent
    /* renamed from: d */
    public void mo712d(RectF rectF, Matrix matrix, boolean z2) {
        this.f2466b.reset();
        for (int i = 0; i < this.f2471g.size(); i++) {
            b bVar = this.f2471g.get(i);
            for (int i2 = 0; i2 < bVar.f2479a.size(); i2++) {
                this.f2466b.addPath(bVar.f2479a.get(i2).getPath(), matrix);
            }
        }
        this.f2466b.computeBounds(this.f2468d, false);
        float fM739j = ((FloatKeyframeAnimation) this.f2474j).m739j();
        RectF rectF2 = this.f2468d;
        float f = fM739j / 2.0f;
        rectF2.set(rectF2.left - f, rectF2.top - f, rectF2.right + f, rectF2.bottom + f);
        rectF.set(this.f2468d);
        rectF.set(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f);
        L.m663a("StrokeContent#getBounds");
    }

    /* JADX WARN: Removed duplicated region for block: B:69:0x01ff  */
    @Override // p007b.p085c.p086a.p091w.p092b.DrawingContent
    /* renamed from: f */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void mo713f(Canvas canvas, Matrix matrix, int i) {
        float[] fArr = Utils.f2312d;
        boolean z2 = false;
        fArr[0] = 0.0f;
        fArr[1] = 0.0f;
        fArr[2] = 37394.73f;
        fArr[3] = 39575.234f;
        matrix.mapPoints(fArr);
        if (fArr[0] == fArr[2] || fArr[1] == fArr[3]) {
            L.m663a("StrokeContent#draw");
            return;
        }
        IntegerKeyframeAnimation integerKeyframeAnimation = (IntegerKeyframeAnimation) this.f2475k;
        float fM741j = (i / 255.0f) * integerKeyframeAnimation.m741j(integerKeyframeAnimation.m723a(), integerKeyframeAnimation.m725c());
        float f = 100.0f;
        this.f2473i.setAlpha(MiscUtils.m653c((int) ((fM741j / 100.0f) * 255.0f), 0, 255));
        this.f2473i.setStrokeWidth(Utils.m660d(matrix) * ((FloatKeyframeAnimation) this.f2474j).m739j());
        if (this.f2473i.getStrokeWidth() <= 0.0f) {
            L.m663a("StrokeContent#draw");
            return;
        }
        float f2 = 1.0f;
        if (this.f2476l.isEmpty()) {
            L.m663a("StrokeContent#applyDashPattern");
        } else {
            float fM660d = Utils.m660d(matrix);
            for (int i2 = 0; i2 < this.f2476l.size(); i2++) {
                this.f2472h[i2] = this.f2476l.get(i2).mo727e().floatValue();
                if (i2 % 2 == 0) {
                    float[] fArr2 = this.f2472h;
                    if (fArr2[i2] < 1.0f) {
                        fArr2[i2] = 1.0f;
                    }
                } else {
                    float[] fArr3 = this.f2472h;
                    if (fArr3[i2] < 0.1f) {
                        fArr3[i2] = 0.1f;
                    }
                }
                float[] fArr4 = this.f2472h;
                fArr4[i2] = fArr4[i2] * fM660d;
            }
            BaseKeyframeAnimation<?, Float> baseKeyframeAnimation = this.f2477m;
            this.f2473i.setPathEffect(new DashPathEffect(this.f2472h, baseKeyframeAnimation == null ? 0.0f : baseKeyframeAnimation.mo727e().floatValue() * fM660d));
            L.m663a("StrokeContent#applyDashPattern");
        }
        BaseKeyframeAnimation<ColorFilter, ColorFilter> baseKeyframeAnimation2 = this.f2478n;
        if (baseKeyframeAnimation2 != null) {
            this.f2473i.setColorFilter(baseKeyframeAnimation2.mo727e());
        }
        int i3 = 0;
        while (i3 < this.f2471g.size()) {
            b bVar = this.f2471g.get(i3);
            TrimPathContent trimPathContent = bVar.f2480b;
            if (trimPathContent == null) {
                this.f2466b.reset();
                for (int size = bVar.f2479a.size() - 1; size >= 0; size--) {
                    this.f2466b.addPath(bVar.f2479a.get(size).getPath(), matrix);
                }
                L.m663a("StrokeContent#buildPath");
                canvas.drawPath(this.f2466b, this.f2473i);
                L.m663a("StrokeContent#drawPath");
            } else if (trimPathContent == null) {
                L.m663a("StrokeContent#applyTrimPath");
            } else {
                this.f2466b.reset();
                int size2 = bVar.f2479a.size();
                while (true) {
                    size2--;
                    if (size2 < 0) {
                        break;
                    } else {
                        this.f2466b.addPath(bVar.f2479a.get(size2).getPath(), matrix);
                    }
                }
                this.f2465a.setPath(this.f2466b, z2);
                float length = this.f2465a.getLength();
                while (this.f2465a.nextContour()) {
                    length += this.f2465a.getLength();
                }
                float fFloatValue = (bVar.f2480b.f2595f.mo727e().floatValue() * length) / 360.0f;
                float fFloatValue2 = ((bVar.f2480b.f2593d.mo727e().floatValue() * length) / f) + fFloatValue;
                float fFloatValue3 = ((bVar.f2480b.f2594e.mo727e().floatValue() * length) / f) + fFloatValue;
                int size3 = bVar.f2479a.size() - 1;
                float f3 = 0.0f;
                while (size3 >= 0) {
                    this.f2467c.set(bVar.f2479a.get(size3).getPath());
                    this.f2467c.transform(matrix);
                    this.f2465a.setPath(this.f2467c, z2);
                    float length2 = this.f2465a.getLength();
                    if (fFloatValue3 > length) {
                        float f4 = fFloatValue3 - length;
                        if (f4 >= f3 + length2 || f3 >= f4) {
                            float f5 = f3 + length2;
                            if (f5 >= fFloatValue2 && f3 <= fFloatValue3) {
                                if (f5 > fFloatValue3 || fFloatValue2 >= f3) {
                                    Utils.m657a(this.f2467c, fFloatValue2 < f3 ? 0.0f : (fFloatValue2 - f3) / length2, fFloatValue3 > f5 ? 1.0f : (fFloatValue3 - f3) / length2, 0.0f);
                                    canvas.drawPath(this.f2467c, this.f2473i);
                                } else {
                                    canvas.drawPath(this.f2467c, this.f2473i);
                                }
                            }
                        } else {
                            Utils.m657a(this.f2467c, fFloatValue2 > length ? (fFloatValue2 - length) / length2 : 0.0f, Math.min(f4 / length2, f2), 0.0f);
                            canvas.drawPath(this.f2467c, this.f2473i);
                        }
                    }
                    f3 += length2;
                    size3--;
                    z2 = false;
                    f2 = 1.0f;
                }
                L.m663a("StrokeContent#applyTrimPath");
            }
            i3++;
            z2 = false;
            f = 100.0f;
            f2 = 1.0f;
        }
        L.m663a("StrokeContent#draw");
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // p007b.p085c.p086a.p095y.KeyPathElement
    @CallSuper
    /* renamed from: g */
    public <T> void mo714g(T t, @Nullable LottieValueCallback<T> lottieValueCallback) {
        if (t == LottieProperty.f2426d) {
            BaseKeyframeAnimation<?, Integer> baseKeyframeAnimation = this.f2475k;
            LottieValueCallback<Integer> lottieValueCallback2 = baseKeyframeAnimation.f2600e;
            baseKeyframeAnimation.f2600e = lottieValueCallback;
            return;
        }
        if (t == LottieProperty.f2437o) {
            BaseKeyframeAnimation<?, Float> baseKeyframeAnimation2 = this.f2474j;
            LottieValueCallback<Float> lottieValueCallback3 = baseKeyframeAnimation2.f2600e;
            baseKeyframeAnimation2.f2600e = lottieValueCallback;
        } else if (t == LottieProperty.f2421C) {
            BaseKeyframeAnimation<ColorFilter, ColorFilter> baseKeyframeAnimation3 = this.f2478n;
            if (baseKeyframeAnimation3 != null) {
                this.f2470f.f2856u.remove(baseKeyframeAnimation3);
            }
            if (lottieValueCallback == 0) {
                this.f2478n = null;
                return;
            }
            ValueCallbackKeyframeAnimation valueCallbackKeyframeAnimation = new ValueCallbackKeyframeAnimation(lottieValueCallback, null);
            this.f2478n = valueCallbackKeyframeAnimation;
            valueCallbackKeyframeAnimation.f2596a.add(this);
            this.f2470f.m777e(this.f2478n);
        }
    }
}

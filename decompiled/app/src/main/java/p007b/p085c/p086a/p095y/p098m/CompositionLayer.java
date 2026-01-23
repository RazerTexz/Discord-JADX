package p007b.p085c.p086a.p095y.p098m;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import androidx.annotation.FloatRange;
import androidx.annotation.Nullable;
import androidx.collection.LongSparseArray;
import java.util.ArrayList;
import java.util.List;
import p007b.p085c.p086a.L;
import p007b.p085c.p086a.LottieComposition;
import p007b.p085c.p086a.LottieDrawable;
import p007b.p085c.p086a.LottieProperty;
import p007b.p085c.p086a.p089b0.Logger2;
import p007b.p085c.p086a.p089b0.Utils;
import p007b.p085c.p086a.p090c0.LottieValueCallback;
import p007b.p085c.p086a.p091w.p093c.BaseKeyframeAnimation;
import p007b.p085c.p086a.p091w.p093c.ValueCallbackKeyframeAnimation;
import p007b.p085c.p086a.p095y.C1563b;
import p007b.p085c.p086a.p095y.KeyPath;
import p007b.p085c.p086a.p095y.p096k.AnimatableFloatValue;
import p007b.p100d.p104b.p105a.outline;

/* JADX INFO: renamed from: b.c.a.y.m.c, reason: use source file name */
/* JADX INFO: compiled from: CompositionLayer.java */
/* JADX INFO: loaded from: classes.dex */
public class CompositionLayer extends BaseLayer2 {

    /* JADX INFO: renamed from: A */
    public final RectF f2859A;

    /* JADX INFO: renamed from: B */
    public Paint f2860B;

    /* JADX INFO: renamed from: x */
    @Nullable
    public BaseKeyframeAnimation<Float, Float> f2861x;

    /* JADX INFO: renamed from: y */
    public final List<BaseLayer2> f2862y;

    /* JADX INFO: renamed from: z */
    public final RectF f2863z;

    public CompositionLayer(LottieDrawable lottieDrawable, Layer2 layer2, List<Layer2> list, LottieComposition lottieComposition) {
        int i;
        BaseLayer2 baseLayer2;
        BaseLayer2 compositionLayer;
        super(lottieDrawable, layer2);
        this.f2862y = new ArrayList();
        this.f2863z = new RectF();
        this.f2859A = new RectF();
        this.f2860B = new Paint();
        AnimatableFloatValue animatableFloatValue = layer2.f2886s;
        if (animatableFloatValue != null) {
            BaseKeyframeAnimation<Float, Float> baseKeyframeAnimationMo773a = animatableFloatValue.mo773a();
            this.f2861x = baseKeyframeAnimationMo773a;
            m777e(baseKeyframeAnimationMo773a);
            this.f2861x.f2596a.add(this);
        } else {
            this.f2861x = null;
        }
        LongSparseArray longSparseArray = new LongSparseArray(lottieComposition.f2344i.size());
        int size = list.size() - 1;
        BaseLayer2 baseLayer22 = null;
        while (true) {
            if (size < 0) {
                break;
            }
            Layer2 layer22 = list.get(size);
            int iOrdinal = layer22.f2872e.ordinal();
            if (iOrdinal == 0) {
                compositionLayer = new CompositionLayer(lottieDrawable, layer22, lottieComposition.f2338c.get(layer22.f2874g), lottieComposition);
            } else if (iOrdinal == 1) {
                compositionLayer = new SolidLayer(lottieDrawable, layer22);
            } else if (iOrdinal == 2) {
                compositionLayer = new ImageLayer(lottieDrawable, layer22);
            } else if (iOrdinal == 3) {
                compositionLayer = new NullLayer(lottieDrawable, layer22);
            } else if (iOrdinal == 4) {
                compositionLayer = new ShapeLayer(lottieDrawable, layer22);
            } else if (iOrdinal != 5) {
                StringBuilder sbM833U = outline.m833U("Unknown layer type ");
                sbM833U.append(layer22.f2872e);
                Logger2.m640b(sbM833U.toString());
                compositionLayer = null;
            } else {
                compositionLayer = new TextLayer(lottieDrawable, layer22);
            }
            if (compositionLayer != null) {
                longSparseArray.put(compositionLayer.f2850o.f2871d, compositionLayer);
                if (baseLayer22 != null) {
                    baseLayer22.f2853r = compositionLayer;
                    baseLayer22 = null;
                } else {
                    this.f2862y.add(0, compositionLayer);
                    int iM758h = C1563b.m758h(layer22.f2888u);
                    if (iM758h == 1 || iM758h == 2) {
                        baseLayer22 = compositionLayer;
                    }
                }
            }
            size--;
        }
        for (i = 0; i < longSparseArray.size(); i++) {
            BaseLayer2 baseLayer23 = (BaseLayer2) longSparseArray.get(longSparseArray.keyAt(i));
            if (baseLayer23 != null && (baseLayer2 = (BaseLayer2) longSparseArray.get(baseLayer23.f2850o.f2873f)) != null) {
                baseLayer23.f2854s = baseLayer2;
            }
        }
    }

    @Override // p007b.p085c.p086a.p095y.p098m.BaseLayer2, p007b.p085c.p086a.p091w.p092b.DrawingContent
    /* JADX INFO: renamed from: d */
    public void mo712d(RectF rectF, Matrix matrix, boolean z2) {
        super.mo712d(rectF, matrix, z2);
        for (int size = this.f2862y.size() - 1; size >= 0; size--) {
            this.f2863z.set(0.0f, 0.0f, 0.0f, 0.0f);
            this.f2862y.get(size).mo712d(this.f2863z, this.f2848m, true);
            rectF.union(this.f2863z);
        }
    }

    @Override // p007b.p085c.p086a.p095y.p098m.BaseLayer2, p007b.p085c.p086a.p095y.KeyPathElement
    /* JADX INFO: renamed from: g */
    public <T> void mo714g(T t, @Nullable LottieValueCallback<T> lottieValueCallback) {
        this.f2857v.m745c(t, lottieValueCallback);
        if (t == LottieProperty.f2419A) {
            if (lottieValueCallback == null) {
                BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation = this.f2861x;
                if (baseKeyframeAnimation != null) {
                    baseKeyframeAnimation.m731i(null);
                    return;
                }
                return;
            }
            ValueCallbackKeyframeAnimation valueCallbackKeyframeAnimation = new ValueCallbackKeyframeAnimation(lottieValueCallback, null);
            this.f2861x = valueCallbackKeyframeAnimation;
            valueCallbackKeyframeAnimation.f2596a.add(this);
            m777e(this.f2861x);
        }
    }

    @Override // p007b.p085c.p086a.p095y.p098m.BaseLayer2
    /* JADX INFO: renamed from: j */
    public void mo780j(Canvas canvas, Matrix matrix, int i) {
        RectF rectF = this.f2859A;
        Layer2 layer2 = this.f2850o;
        rectF.set(0.0f, 0.0f, layer2.f2882o, layer2.f2883p);
        matrix.mapRect(this.f2859A);
        boolean z2 = this.f2849n.f2366A && this.f2862y.size() > 1 && i != 255;
        if (z2) {
            this.f2860B.setAlpha(i);
            Utils.m662f(canvas, this.f2859A, this.f2860B, 31);
        } else {
            canvas.save();
        }
        if (z2) {
            i = 255;
        }
        for (int size = this.f2862y.size() - 1; size >= 0; size--) {
            if (!this.f2859A.isEmpty() ? canvas.clipRect(this.f2859A) : true) {
                this.f2862y.get(size).mo713f(canvas, matrix, i);
            }
        }
        canvas.restore();
        L.m663a("CompositionLayer#draw");
    }

    @Override // p007b.p085c.p086a.p095y.p098m.BaseLayer2
    /* JADX INFO: renamed from: n */
    public void mo784n(KeyPath keyPath, int i, List<KeyPath> list, KeyPath keyPath2) {
        for (int i2 = 0; i2 < this.f2862y.size(); i2++) {
            this.f2862y.get(i2).mo711c(keyPath, i, list, keyPath2);
        }
    }

    @Override // p007b.p085c.p086a.p095y.p098m.BaseLayer2
    /* JADX INFO: renamed from: o */
    public void mo785o(@FloatRange(from = 0.0d, m75to = 1.0d) float f) {
        super.mo785o(f);
        if (this.f2861x != null) {
            f = ((this.f2861x.mo727e().floatValue() * this.f2850o.f2869b.f2348m) - this.f2850o.f2869b.f2346k) / (this.f2849n.f2370k.m671c() + 0.01f);
        }
        if (this.f2861x == null) {
            Layer2 layer2 = this.f2850o;
            f -= layer2.f2881n / layer2.f2869b.m671c();
        }
        float f2 = this.f2850o.f2880m;
        if (f2 != 0.0f) {
            f /= f2;
        }
        int size = this.f2862y.size();
        while (true) {
            size--;
            if (size < 0) {
                return;
            } else {
                this.f2862y.get(size).mo785o(f);
            }
        }
    }
}

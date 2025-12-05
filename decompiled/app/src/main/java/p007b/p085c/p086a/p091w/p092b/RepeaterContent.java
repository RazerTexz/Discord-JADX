package p007b.p085c.p086a.p091w.p092b;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RectF;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;
import java.util.Objects;
import p007b.p085c.p086a.LottieDrawable;
import p007b.p085c.p086a.LottieProperty;
import p007b.p085c.p086a.p089b0.MiscUtils;
import p007b.p085c.p086a.p090c0.LottieValueCallback;
import p007b.p085c.p086a.p091w.p093c.BaseKeyframeAnimation;
import p007b.p085c.p086a.p091w.p093c.TransformKeyframeAnimation;
import p007b.p085c.p086a.p095y.KeyPath;
import p007b.p085c.p086a.p095y.p096k.AnimatableTransform;
import p007b.p085c.p086a.p095y.p097l.Repeater;
import p007b.p085c.p086a.p095y.p098m.BaseLayer2;

/* compiled from: RepeaterContent.java */
/* renamed from: b.c.a.w.b.p, reason: use source file name */
/* loaded from: classes.dex */
public class RepeaterContent implements DrawingContent, PathContent, GreedyContent, BaseKeyframeAnimation.b, KeyPathElementContent {

    /* renamed from: a */
    public final Matrix f2569a = new Matrix();

    /* renamed from: b */
    public final Path f2570b = new Path();

    /* renamed from: c */
    public final LottieDrawable f2571c;

    /* renamed from: d */
    public final BaseLayer2 f2572d;

    /* renamed from: e */
    public final String f2573e;

    /* renamed from: f */
    public final boolean f2574f;

    /* renamed from: g */
    public final BaseKeyframeAnimation<Float, Float> f2575g;

    /* renamed from: h */
    public final BaseKeyframeAnimation<Float, Float> f2576h;

    /* renamed from: i */
    public final TransformKeyframeAnimation f2577i;

    /* renamed from: j */
    public ContentGroup f2578j;

    public RepeaterContent(LottieDrawable lottieDrawable, BaseLayer2 baseLayer2, Repeater repeater) {
        this.f2571c = lottieDrawable;
        this.f2572d = baseLayer2;
        this.f2573e = repeater.f2798a;
        this.f2574f = repeater.f2802e;
        BaseKeyframeAnimation<Float, Float> baseKeyframeAnimationMo773a = repeater.f2799b.mo773a();
        this.f2575g = baseKeyframeAnimationMo773a;
        baseLayer2.m777e(baseKeyframeAnimationMo773a);
        baseKeyframeAnimationMo773a.f2596a.add(this);
        BaseKeyframeAnimation<Float, Float> baseKeyframeAnimationMo773a2 = repeater.f2800c.mo773a();
        this.f2576h = baseKeyframeAnimationMo773a2;
        baseLayer2.m777e(baseKeyframeAnimationMo773a2);
        baseKeyframeAnimationMo773a2.f2596a.add(this);
        AnimatableTransform animatableTransform = repeater.f2801d;
        Objects.requireNonNull(animatableTransform);
        TransformKeyframeAnimation transformKeyframeAnimation = new TransformKeyframeAnimation(animatableTransform);
        this.f2577i = transformKeyframeAnimation;
        transformKeyframeAnimation.m743a(baseLayer2);
        transformKeyframeAnimation.m744b(this);
    }

    @Override // p007b.p085c.p086a.p091w.p093c.BaseKeyframeAnimation.b
    /* renamed from: a */
    public void mo709a() {
        this.f2571c.invalidateSelf();
    }

    @Override // p007b.p085c.p086a.p091w.p092b.Content2
    /* renamed from: b */
    public void mo710b(List<Content2> list, List<Content2> list2) {
        this.f2578j.mo710b(list, list2);
    }

    @Override // p007b.p085c.p086a.p095y.KeyPathElement
    /* renamed from: c */
    public void mo711c(KeyPath keyPath, int i, List<KeyPath> list, KeyPath keyPath2) {
        MiscUtils.m656f(keyPath, i, list, keyPath2, this);
    }

    @Override // p007b.p085c.p086a.p091w.p092b.DrawingContent
    /* renamed from: d */
    public void mo712d(RectF rectF, Matrix matrix, boolean z2) {
        this.f2578j.mo712d(rectF, matrix, z2);
    }

    @Override // p007b.p085c.p086a.p091w.p092b.GreedyContent
    /* renamed from: e */
    public void mo721e(ListIterator<Content2> listIterator) {
        if (this.f2578j != null) {
            return;
        }
        while (listIterator.hasPrevious() && listIterator.previous() != this) {
        }
        ArrayList arrayList = new ArrayList();
        while (listIterator.hasPrevious()) {
            arrayList.add(listIterator.previous());
            listIterator.remove();
        }
        Collections.reverse(arrayList);
        this.f2578j = new ContentGroup(this.f2571c, this.f2572d, "Repeater", this.f2574f, arrayList, null);
    }

    @Override // p007b.p085c.p086a.p091w.p092b.DrawingContent
    /* renamed from: f */
    public void mo713f(Canvas canvas, Matrix matrix, int i) {
        float fFloatValue = this.f2575g.mo727e().floatValue();
        float fFloatValue2 = this.f2576h.mo727e().floatValue();
        float fFloatValue3 = this.f2577i.f2639m.mo727e().floatValue() / 100.0f;
        float fFloatValue4 = this.f2577i.f2640n.mo727e().floatValue() / 100.0f;
        for (int i2 = ((int) fFloatValue) - 1; i2 >= 0; i2--) {
            this.f2569a.set(matrix);
            float f = i2;
            this.f2569a.preConcat(this.f2577i.m748f(f + fFloatValue2));
            this.f2578j.mo713f(canvas, this.f2569a, (int) (MiscUtils.m655e(fFloatValue3, fFloatValue4, f / fFloatValue) * i));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // p007b.p085c.p086a.p095y.KeyPathElement
    /* renamed from: g */
    public <T> void mo714g(T t, @Nullable LottieValueCallback<T> lottieValueCallback) {
        if (this.f2577i.m745c(t, lottieValueCallback)) {
            return;
        }
        if (t == LottieProperty.f2439q) {
            BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation = this.f2575g;
            LottieValueCallback<Float> lottieValueCallback2 = baseKeyframeAnimation.f2600e;
            baseKeyframeAnimation.f2600e = lottieValueCallback;
        } else if (t == LottieProperty.f2440r) {
            BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation2 = this.f2576h;
            LottieValueCallback<Float> lottieValueCallback3 = baseKeyframeAnimation2.f2600e;
            baseKeyframeAnimation2.f2600e = lottieValueCallback;
        }
    }

    @Override // p007b.p085c.p086a.p091w.p092b.Content2
    public String getName() {
        return this.f2573e;
    }

    @Override // p007b.p085c.p086a.p091w.p092b.PathContent
    public Path getPath() {
        Path path = this.f2578j.getPath();
        this.f2570b.reset();
        float fFloatValue = this.f2575g.mo727e().floatValue();
        float fFloatValue2 = this.f2576h.mo727e().floatValue();
        for (int i = ((int) fFloatValue) - 1; i >= 0; i--) {
            this.f2569a.set(this.f2577i.m748f(i + fFloatValue2));
            this.f2570b.addPath(path, this.f2569a);
        }
        return this.f2570b;
    }
}

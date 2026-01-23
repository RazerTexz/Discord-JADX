package p007b.p085c.p086a.p095y.p096k;

import android.graphics.PointF;
import androidx.annotation.Nullable;
import p007b.p085c.p086a.LottieDrawable;
import p007b.p085c.p086a.p091w.p092b.Content2;
import p007b.p085c.p086a.p095y.p097l.ContentModel2;
import p007b.p085c.p086a.p095y.p098m.BaseLayer2;

/* JADX INFO: renamed from: b.c.a.y.k.l, reason: use source file name */
/* JADX INFO: compiled from: AnimatableTransform.java */
/* JADX INFO: loaded from: classes.dex */
public class AnimatableTransform implements ContentModel2 {

    /* JADX INFO: renamed from: a */
    @Nullable
    public final AnimatablePathValue f2729a;

    /* JADX INFO: renamed from: b */
    @Nullable
    public final AnimatableValue<PointF, PointF> f2730b;

    /* JADX INFO: renamed from: c */
    @Nullable
    public final AnimatableScaleValue f2731c;

    /* JADX INFO: renamed from: d */
    @Nullable
    public final AnimatableFloatValue f2732d;

    /* JADX INFO: renamed from: e */
    @Nullable
    public final AnimatableIntegerValue f2733e;

    /* JADX INFO: renamed from: f */
    @Nullable
    public final AnimatableFloatValue f2734f;

    /* JADX INFO: renamed from: g */
    @Nullable
    public final AnimatableFloatValue f2735g;

    /* JADX INFO: renamed from: h */
    @Nullable
    public final AnimatableFloatValue f2736h;

    /* JADX INFO: renamed from: i */
    @Nullable
    public final AnimatableFloatValue f2737i;

    public AnimatableTransform() {
        this(null, null, null, null, null, null, null, null, null);
    }

    @Override // p007b.p085c.p086a.p095y.p097l.ContentModel2
    @Nullable
    /* JADX INFO: renamed from: a */
    public Content2 mo775a(LottieDrawable lottieDrawable, BaseLayer2 baseLayer2) {
        return null;
    }

    public AnimatableTransform(@Nullable AnimatablePathValue animatablePathValue, @Nullable AnimatableValue<PointF, PointF> animatableValue, @Nullable AnimatableScaleValue animatableScaleValue, @Nullable AnimatableFloatValue animatableFloatValue, @Nullable AnimatableIntegerValue animatableIntegerValue, @Nullable AnimatableFloatValue animatableFloatValue2, @Nullable AnimatableFloatValue animatableFloatValue3, @Nullable AnimatableFloatValue animatableFloatValue4, @Nullable AnimatableFloatValue animatableFloatValue5) {
        this.f2729a = animatablePathValue;
        this.f2730b = animatableValue;
        this.f2731c = animatableScaleValue;
        this.f2732d = animatableFloatValue;
        this.f2733e = animatableIntegerValue;
        this.f2736h = animatableFloatValue2;
        this.f2737i = animatableFloatValue3;
        this.f2734f = animatableFloatValue4;
        this.f2735g = animatableFloatValue5;
    }
}

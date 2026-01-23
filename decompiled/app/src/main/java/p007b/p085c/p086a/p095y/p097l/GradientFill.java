package p007b.p085c.p086a.p095y.p097l;

import android.graphics.Path;
import p007b.p085c.p086a.LottieDrawable;
import p007b.p085c.p086a.p091w.p092b.Content2;
import p007b.p085c.p086a.p091w.p092b.GradientFillContent;
import p007b.p085c.p086a.p095y.p096k.AnimatableFloatValue;
import p007b.p085c.p086a.p095y.p096k.AnimatableGradientColorValue;
import p007b.p085c.p086a.p095y.p096k.AnimatableIntegerValue;
import p007b.p085c.p086a.p095y.p096k.AnimatablePointValue;
import p007b.p085c.p086a.p095y.p098m.BaseLayer2;

/* JADX INFO: renamed from: b.c.a.y.l.d, reason: use source file name */
/* JADX INFO: compiled from: GradientFill.java */
/* JADX INFO: loaded from: classes.dex */
public class GradientFill implements ContentModel2 {

    /* JADX INFO: renamed from: a */
    public final int f2746a;

    /* JADX INFO: renamed from: b */
    public final Path.FillType f2747b;

    /* JADX INFO: renamed from: c */
    public final AnimatableGradientColorValue f2748c;

    /* JADX INFO: renamed from: d */
    public final AnimatableIntegerValue f2749d;

    /* JADX INFO: renamed from: e */
    public final AnimatablePointValue f2750e;

    /* JADX INFO: renamed from: f */
    public final AnimatablePointValue f2751f;

    /* JADX INFO: renamed from: g */
    public final String f2752g;

    /* JADX INFO: renamed from: h */
    public final boolean f2753h;

    public GradientFill(String str, int i, Path.FillType fillType, AnimatableGradientColorValue animatableGradientColorValue, AnimatableIntegerValue animatableIntegerValue, AnimatablePointValue animatablePointValue, AnimatablePointValue animatablePointValue2, AnimatableFloatValue animatableFloatValue, AnimatableFloatValue animatableFloatValue2, boolean z2) {
        this.f2746a = i;
        this.f2747b = fillType;
        this.f2748c = animatableGradientColorValue;
        this.f2749d = animatableIntegerValue;
        this.f2750e = animatablePointValue;
        this.f2751f = animatablePointValue2;
        this.f2752g = str;
        this.f2753h = z2;
    }

    @Override // p007b.p085c.p086a.p095y.p097l.ContentModel2
    /* JADX INFO: renamed from: a */
    public Content2 mo775a(LottieDrawable lottieDrawable, BaseLayer2 baseLayer2) {
        return new GradientFillContent(lottieDrawable, baseLayer2, this);
    }
}

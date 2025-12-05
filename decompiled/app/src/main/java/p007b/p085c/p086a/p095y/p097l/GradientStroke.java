package p007b.p085c.p086a.p095y.p097l;

import androidx.annotation.Nullable;
import java.util.List;
import p007b.p085c.p086a.LottieDrawable;
import p007b.p085c.p086a.p091w.p092b.Content2;
import p007b.p085c.p086a.p091w.p092b.GradientStrokeContent;
import p007b.p085c.p086a.p095y.p096k.AnimatableFloatValue;
import p007b.p085c.p086a.p095y.p096k.AnimatableGradientColorValue;
import p007b.p085c.p086a.p095y.p096k.AnimatableIntegerValue;
import p007b.p085c.p086a.p095y.p096k.AnimatablePointValue;
import p007b.p085c.p086a.p095y.p098m.BaseLayer2;

/* compiled from: GradientStroke.java */
/* renamed from: b.c.a.y.l.e, reason: use source file name */
/* loaded from: classes.dex */
public class GradientStroke implements ContentModel2 {

    /* renamed from: a */
    public final String f2754a;

    /* renamed from: b */
    public final int f2755b;

    /* renamed from: c */
    public final AnimatableGradientColorValue f2756c;

    /* renamed from: d */
    public final AnimatableIntegerValue f2757d;

    /* renamed from: e */
    public final AnimatablePointValue f2758e;

    /* renamed from: f */
    public final AnimatablePointValue f2759f;

    /* renamed from: g */
    public final AnimatableFloatValue f2760g;

    /* renamed from: h */
    public final int f2761h;

    /* renamed from: i */
    public final int f2762i;

    /* renamed from: j */
    public final float f2763j;

    /* renamed from: k */
    public final List<AnimatableFloatValue> f2764k;

    /* renamed from: l */
    @Nullable
    public final AnimatableFloatValue f2765l;

    /* renamed from: m */
    public final boolean f2766m;

    /* JADX WARN: Incorrect types in method signature: (Ljava/lang/String;Ljava/lang/Object;Lb/c/a/y/k/c;Lb/c/a/y/k/d;Lb/c/a/y/k/f;Lb/c/a/y/k/f;Lb/c/a/y/k/b;Ljava/lang/Object;Ljava/lang/Object;FLjava/util/List<Lb/c/a/y/k/b;>;Lb/c/a/y/k/b;Z)V */
    public GradientStroke(String str, int i, AnimatableGradientColorValue animatableGradientColorValue, AnimatableIntegerValue animatableIntegerValue, AnimatablePointValue animatablePointValue, AnimatablePointValue animatablePointValue2, AnimatableFloatValue animatableFloatValue, int i2, int i3, float f, List list, @Nullable AnimatableFloatValue animatableFloatValue2, boolean z2) {
        this.f2754a = str;
        this.f2755b = i;
        this.f2756c = animatableGradientColorValue;
        this.f2757d = animatableIntegerValue;
        this.f2758e = animatablePointValue;
        this.f2759f = animatablePointValue2;
        this.f2760g = animatableFloatValue;
        this.f2761h = i2;
        this.f2762i = i3;
        this.f2763j = f;
        this.f2764k = list;
        this.f2765l = animatableFloatValue2;
        this.f2766m = z2;
    }

    @Override // p007b.p085c.p086a.p095y.p097l.ContentModel2
    /* renamed from: a */
    public Content2 mo775a(LottieDrawable lottieDrawable, BaseLayer2 baseLayer2) {
        return new GradientStrokeContent(lottieDrawable, baseLayer2, this);
    }
}

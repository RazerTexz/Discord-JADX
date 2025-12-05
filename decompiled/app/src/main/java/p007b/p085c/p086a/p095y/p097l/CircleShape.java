package p007b.p085c.p086a.p095y.p097l;

import android.graphics.PointF;
import p007b.p085c.p086a.LottieDrawable;
import p007b.p085c.p086a.p091w.p092b.Content2;
import p007b.p085c.p086a.p091w.p092b.EllipseContent;
import p007b.p085c.p086a.p095y.p096k.AnimatablePointValue;
import p007b.p085c.p086a.p095y.p096k.AnimatableValue;
import p007b.p085c.p086a.p095y.p098m.BaseLayer2;

/* compiled from: CircleShape.java */
/* renamed from: b.c.a.y.l.a, reason: use source file name */
/* loaded from: classes.dex */
public class CircleShape implements ContentModel2 {

    /* renamed from: a */
    public final String f2739a;

    /* renamed from: b */
    public final AnimatableValue<PointF, PointF> f2740b;

    /* renamed from: c */
    public final AnimatablePointValue f2741c;

    /* renamed from: d */
    public final boolean f2742d;

    /* renamed from: e */
    public final boolean f2743e;

    public CircleShape(String str, AnimatableValue<PointF, PointF> animatableValue, AnimatablePointValue animatablePointValue, boolean z2, boolean z3) {
        this.f2739a = str;
        this.f2740b = animatableValue;
        this.f2741c = animatablePointValue;
        this.f2742d = z2;
        this.f2743e = z3;
    }

    @Override // p007b.p085c.p086a.p095y.p097l.ContentModel2
    /* renamed from: a */
    public Content2 mo775a(LottieDrawable lottieDrawable, BaseLayer2 baseLayer2) {
        return new EllipseContent(lottieDrawable, baseLayer2, this);
    }
}

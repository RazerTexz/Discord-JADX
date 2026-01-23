package p007b.p085c.p086a.p095y.p097l;

import android.graphics.PointF;
import p007b.p085c.p086a.LottieDrawable;
import p007b.p085c.p086a.p091w.p092b.Content2;
import p007b.p085c.p086a.p091w.p092b.RectangleContent;
import p007b.p085c.p086a.p095y.p096k.AnimatableFloatValue;
import p007b.p085c.p086a.p095y.p096k.AnimatablePointValue;
import p007b.p085c.p086a.p095y.p096k.AnimatableValue;
import p007b.p085c.p086a.p095y.p098m.BaseLayer2;
import p007b.p100d.p104b.p105a.outline;

/* JADX INFO: renamed from: b.c.a.y.l.i, reason: use source file name */
/* JADX INFO: compiled from: RectangleShape.java */
/* JADX INFO: loaded from: classes.dex */
public class RectangleShape implements ContentModel2 {

    /* JADX INFO: renamed from: a */
    public final String f2793a;

    /* JADX INFO: renamed from: b */
    public final AnimatableValue<PointF, PointF> f2794b;

    /* JADX INFO: renamed from: c */
    public final AnimatablePointValue f2795c;

    /* JADX INFO: renamed from: d */
    public final AnimatableFloatValue f2796d;

    /* JADX INFO: renamed from: e */
    public final boolean f2797e;

    public RectangleShape(String str, AnimatableValue<PointF, PointF> animatableValue, AnimatablePointValue animatablePointValue, AnimatableFloatValue animatableFloatValue, boolean z2) {
        this.f2793a = str;
        this.f2794b = animatableValue;
        this.f2795c = animatablePointValue;
        this.f2796d = animatableFloatValue;
        this.f2797e = z2;
    }

    @Override // p007b.p085c.p086a.p095y.p097l.ContentModel2
    /* JADX INFO: renamed from: a */
    public Content2 mo775a(LottieDrawable lottieDrawable, BaseLayer2 baseLayer2) {
        return new RectangleContent(lottieDrawable, baseLayer2, this);
    }

    public String toString() {
        StringBuilder sbM833U = outline.m833U("RectangleShape{position=");
        sbM833U.append(this.f2794b);
        sbM833U.append(", size=");
        sbM833U.append(this.f2795c);
        sbM833U.append('}');
        return sbM833U.toString();
    }
}

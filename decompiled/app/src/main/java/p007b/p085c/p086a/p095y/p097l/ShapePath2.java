package p007b.p085c.p086a.p095y.p097l;

import p007b.p085c.p086a.LottieDrawable;
import p007b.p085c.p086a.p091w.p092b.Content2;
import p007b.p085c.p086a.p091w.p092b.ShapeContent;
import p007b.p085c.p086a.p095y.p096k.AnimatableShapeValue;
import p007b.p085c.p086a.p095y.p098m.BaseLayer2;
import p007b.p100d.p104b.p105a.outline;

/* compiled from: ShapePath.java */
/* renamed from: b.c.a.y.l.n, reason: use source file name */
/* loaded from: classes.dex */
public class ShapePath2 implements ContentModel2 {

    /* renamed from: a */
    public final String f2815a;

    /* renamed from: b */
    public final int f2816b;

    /* renamed from: c */
    public final AnimatableShapeValue f2817c;

    /* renamed from: d */
    public final boolean f2818d;

    public ShapePath2(String str, int i, AnimatableShapeValue animatableShapeValue, boolean z2) {
        this.f2815a = str;
        this.f2816b = i;
        this.f2817c = animatableShapeValue;
        this.f2818d = z2;
    }

    @Override // p007b.p085c.p086a.p095y.p097l.ContentModel2
    /* renamed from: a */
    public Content2 mo775a(LottieDrawable lottieDrawable, BaseLayer2 baseLayer2) {
        return new ShapeContent(lottieDrawable, baseLayer2, this);
    }

    public String toString() {
        StringBuilder sbM833U = outline.m833U("ShapePath{name=");
        sbM833U.append(this.f2815a);
        sbM833U.append(", index=");
        return outline.m813A(sbM833U, this.f2816b, '}');
    }
}

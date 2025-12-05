package p007b.p085c.p086a.p095y.p097l;

import p007b.p085c.p086a.LottieDrawable;
import p007b.p085c.p086a.p091w.p092b.Content2;
import p007b.p085c.p086a.p091w.p092b.TrimPathContent;
import p007b.p085c.p086a.p095y.p096k.AnimatableFloatValue;
import p007b.p085c.p086a.p095y.p098m.BaseLayer2;
import p007b.p100d.p104b.p105a.outline;

/* compiled from: ShapeTrimPath.java */
/* renamed from: b.c.a.y.l.p, reason: use source file name */
/* loaded from: classes.dex */
public class ShapeTrimPath implements ContentModel2 {

    /* renamed from: a */
    public final String f2829a;

    /* renamed from: b */
    public final int f2830b;

    /* renamed from: c */
    public final AnimatableFloatValue f2831c;

    /* renamed from: d */
    public final AnimatableFloatValue f2832d;

    /* renamed from: e */
    public final AnimatableFloatValue f2833e;

    /* renamed from: f */
    public final boolean f2834f;

    public ShapeTrimPath(String str, int i, AnimatableFloatValue animatableFloatValue, AnimatableFloatValue animatableFloatValue2, AnimatableFloatValue animatableFloatValue3, boolean z2) {
        this.f2829a = str;
        this.f2830b = i;
        this.f2831c = animatableFloatValue;
        this.f2832d = animatableFloatValue2;
        this.f2833e = animatableFloatValue3;
        this.f2834f = z2;
    }

    @Override // p007b.p085c.p086a.p095y.p097l.ContentModel2
    /* renamed from: a */
    public Content2 mo775a(LottieDrawable lottieDrawable, BaseLayer2 baseLayer2) {
        return new TrimPathContent(baseLayer2, this);
    }

    public String toString() {
        StringBuilder sbM833U = outline.m833U("Trim Path: {start: ");
        sbM833U.append(this.f2831c);
        sbM833U.append(", end: ");
        sbM833U.append(this.f2832d);
        sbM833U.append(", offset: ");
        sbM833U.append(this.f2833e);
        sbM833U.append("}");
        return sbM833U.toString();
    }
}

package p007b.p085c.p086a.p095y.p097l;

import androidx.annotation.Nullable;
import p007b.p085c.p086a.LottieDrawable;
import p007b.p085c.p086a.p091w.p092b.Content2;
import p007b.p085c.p086a.p091w.p092b.RepeaterContent;
import p007b.p085c.p086a.p095y.p096k.AnimatableFloatValue;
import p007b.p085c.p086a.p095y.p096k.AnimatableTransform;
import p007b.p085c.p086a.p095y.p098m.BaseLayer2;

/* compiled from: Repeater.java */
/* renamed from: b.c.a.y.l.j, reason: use source file name */
/* loaded from: classes.dex */
public class Repeater implements ContentModel2 {

    /* renamed from: a */
    public final String f2798a;

    /* renamed from: b */
    public final AnimatableFloatValue f2799b;

    /* renamed from: c */
    public final AnimatableFloatValue f2800c;

    /* renamed from: d */
    public final AnimatableTransform f2801d;

    /* renamed from: e */
    public final boolean f2802e;

    public Repeater(String str, AnimatableFloatValue animatableFloatValue, AnimatableFloatValue animatableFloatValue2, AnimatableTransform animatableTransform, boolean z2) {
        this.f2798a = str;
        this.f2799b = animatableFloatValue;
        this.f2800c = animatableFloatValue2;
        this.f2801d = animatableTransform;
        this.f2802e = z2;
    }

    @Override // p007b.p085c.p086a.p095y.p097l.ContentModel2
    @Nullable
    /* renamed from: a */
    public Content2 mo775a(LottieDrawable lottieDrawable, BaseLayer2 baseLayer2) {
        return new RepeaterContent(lottieDrawable, baseLayer2, this);
    }
}

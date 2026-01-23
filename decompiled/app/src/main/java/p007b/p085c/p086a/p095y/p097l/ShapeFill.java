package p007b.p085c.p086a.p095y.p097l;

import android.graphics.Path;
import androidx.annotation.Nullable;
import p007b.p085c.p086a.LottieDrawable;
import p007b.p085c.p086a.p091w.p092b.Content2;
import p007b.p085c.p086a.p091w.p092b.FillContent;
import p007b.p085c.p086a.p095y.p096k.AnimatableColorValue;
import p007b.p085c.p086a.p095y.p096k.AnimatableIntegerValue;
import p007b.p085c.p086a.p095y.p098m.BaseLayer2;
import p007b.p100d.p104b.p105a.outline;

/* JADX INFO: renamed from: b.c.a.y.l.l, reason: use source file name */
/* JADX INFO: compiled from: ShapeFill.java */
/* JADX INFO: loaded from: classes.dex */
public class ShapeFill implements ContentModel2 {

    /* JADX INFO: renamed from: a */
    public final boolean f2806a;

    /* JADX INFO: renamed from: b */
    public final Path.FillType f2807b;

    /* JADX INFO: renamed from: c */
    public final String f2808c;

    /* JADX INFO: renamed from: d */
    @Nullable
    public final AnimatableColorValue f2809d;

    /* JADX INFO: renamed from: e */
    @Nullable
    public final AnimatableIntegerValue f2810e;

    /* JADX INFO: renamed from: f */
    public final boolean f2811f;

    public ShapeFill(String str, boolean z2, Path.FillType fillType, @Nullable AnimatableColorValue animatableColorValue, @Nullable AnimatableIntegerValue animatableIntegerValue, boolean z3) {
        this.f2808c = str;
        this.f2806a = z2;
        this.f2807b = fillType;
        this.f2809d = animatableColorValue;
        this.f2810e = animatableIntegerValue;
        this.f2811f = z3;
    }

    @Override // p007b.p085c.p086a.p095y.p097l.ContentModel2
    /* JADX INFO: renamed from: a */
    public Content2 mo775a(LottieDrawable lottieDrawable, BaseLayer2 baseLayer2) {
        return new FillContent(lottieDrawable, baseLayer2, this);
    }

    public String toString() {
        StringBuilder sbM833U = outline.m833U("ShapeFill{color=, fillEnabled=");
        sbM833U.append(this.f2806a);
        sbM833U.append('}');
        return sbM833U.toString();
    }
}

package p007b.p085c.p086a.p095y.p097l;

import android.graphics.PointF;
import p007b.p085c.p086a.LottieDrawable;
import p007b.p085c.p086a.p091w.p092b.Content2;
import p007b.p085c.p086a.p091w.p092b.PolystarContent;
import p007b.p085c.p086a.p095y.p096k.AnimatableFloatValue;
import p007b.p085c.p086a.p095y.p096k.AnimatableValue;
import p007b.p085c.p086a.p095y.p098m.BaseLayer2;

/* JADX INFO: renamed from: b.c.a.y.l.h, reason: use source file name */
/* JADX INFO: compiled from: PolystarShape.java */
/* JADX INFO: loaded from: classes.dex */
public class PolystarShape implements ContentModel2 {

    /* JADX INFO: renamed from: a */
    public final String f2780a;

    /* JADX INFO: renamed from: b */
    public final a f2781b;

    /* JADX INFO: renamed from: c */
    public final AnimatableFloatValue f2782c;

    /* JADX INFO: renamed from: d */
    public final AnimatableValue<PointF, PointF> f2783d;

    /* JADX INFO: renamed from: e */
    public final AnimatableFloatValue f2784e;

    /* JADX INFO: renamed from: f */
    public final AnimatableFloatValue f2785f;

    /* JADX INFO: renamed from: g */
    public final AnimatableFloatValue f2786g;

    /* JADX INFO: renamed from: h */
    public final AnimatableFloatValue f2787h;

    /* JADX INFO: renamed from: i */
    public final AnimatableFloatValue f2788i;

    /* JADX INFO: renamed from: j */
    public final boolean f2789j;

    /* JADX INFO: renamed from: b.c.a.y.l.h$a */
    /* JADX INFO: compiled from: PolystarShape.java */
    public enum a {
        STAR(1),
        POLYGON(2);

        private final int value;

        a(int i) {
            this.value = i;
        }

        /* JADX INFO: renamed from: f */
        public static a m776f(int i) {
            a[] aVarArrValues = values();
            for (int i2 = 0; i2 < 2; i2++) {
                a aVar = aVarArrValues[i2];
                if (aVar.value == i) {
                    return aVar;
                }
            }
            return null;
        }
    }

    public PolystarShape(String str, a aVar, AnimatableFloatValue animatableFloatValue, AnimatableValue<PointF, PointF> animatableValue, AnimatableFloatValue animatableFloatValue2, AnimatableFloatValue animatableFloatValue3, AnimatableFloatValue animatableFloatValue4, AnimatableFloatValue animatableFloatValue5, AnimatableFloatValue animatableFloatValue6, boolean z2) {
        this.f2780a = str;
        this.f2781b = aVar;
        this.f2782c = animatableFloatValue;
        this.f2783d = animatableValue;
        this.f2784e = animatableFloatValue2;
        this.f2785f = animatableFloatValue3;
        this.f2786g = animatableFloatValue4;
        this.f2787h = animatableFloatValue5;
        this.f2788i = animatableFloatValue6;
        this.f2789j = z2;
    }

    @Override // p007b.p085c.p086a.p095y.p097l.ContentModel2
    /* JADX INFO: renamed from: a */
    public Content2 mo775a(LottieDrawable lottieDrawable, BaseLayer2 baseLayer2) {
        return new PolystarContent(lottieDrawable, baseLayer2, this);
    }
}

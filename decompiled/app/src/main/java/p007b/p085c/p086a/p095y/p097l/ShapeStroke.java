package p007b.p085c.p086a.p095y.p097l;

import androidx.annotation.Nullable;
import java.util.List;
import p007b.p085c.p086a.LottieDrawable;
import p007b.p085c.p086a.p091w.p092b.Content2;
import p007b.p085c.p086a.p091w.p092b.StrokeContent;
import p007b.p085c.p086a.p095y.p096k.AnimatableColorValue;
import p007b.p085c.p086a.p095y.p096k.AnimatableFloatValue;
import p007b.p085c.p086a.p095y.p096k.AnimatableIntegerValue;
import p007b.p085c.p086a.p095y.p098m.BaseLayer2;

/* compiled from: ShapeStroke.java */
/* renamed from: b.c.a.y.l.o, reason: use source file name */
/* loaded from: classes.dex */
public class ShapeStroke implements ContentModel2 {

    /* renamed from: a */
    public final String f2819a;

    /* renamed from: b */
    @Nullable
    public final AnimatableFloatValue f2820b;

    /* renamed from: c */
    public final List<AnimatableFloatValue> f2821c;

    /* renamed from: d */
    public final AnimatableColorValue f2822d;

    /* renamed from: e */
    public final AnimatableIntegerValue f2823e;

    /* renamed from: f */
    public final AnimatableFloatValue f2824f;

    /* renamed from: g */
    public final int f2825g;

    /* renamed from: h */
    public final int f2826h;

    /* renamed from: i */
    public final float f2827i;

    /* renamed from: j */
    public final boolean f2828j;

    /* JADX WARN: Incorrect types in method signature: (Ljava/lang/String;Lb/c/a/y/k/b;Ljava/util/List<Lb/c/a/y/k/b;>;Lb/c/a/y/k/a;Lb/c/a/y/k/d;Lb/c/a/y/k/b;Ljava/lang/Object;Ljava/lang/Object;FZ)V */
    public ShapeStroke(String str, @Nullable AnimatableFloatValue animatableFloatValue, List list, AnimatableColorValue animatableColorValue, AnimatableIntegerValue animatableIntegerValue, AnimatableFloatValue animatableFloatValue2, int i, int i2, float f, boolean z2) {
        this.f2819a = str;
        this.f2820b = animatableFloatValue;
        this.f2821c = list;
        this.f2822d = animatableColorValue;
        this.f2823e = animatableIntegerValue;
        this.f2824f = animatableFloatValue2;
        this.f2825g = i;
        this.f2826h = i2;
        this.f2827i = f;
        this.f2828j = z2;
    }

    @Override // p007b.p085c.p086a.p095y.p097l.ContentModel2
    /* renamed from: a */
    public Content2 mo775a(LottieDrawable lottieDrawable, BaseLayer2 baseLayer2) {
        return new StrokeContent(lottieDrawable, baseLayer2, this);
    }
}

package p007b.p085c.p086a.p095y.p097l;

import java.util.Arrays;
import java.util.List;
import p007b.p085c.p086a.LottieDrawable;
import p007b.p085c.p086a.p091w.p092b.Content2;
import p007b.p085c.p086a.p091w.p092b.ContentGroup;
import p007b.p085c.p086a.p095y.p098m.BaseLayer2;
import p007b.p100d.p104b.p105a.outline;

/* compiled from: ShapeGroup.java */
/* renamed from: b.c.a.y.l.m, reason: use source file name */
/* loaded from: classes.dex */
public class ShapeGroup implements ContentModel2 {

    /* renamed from: a */
    public final String f2812a;

    /* renamed from: b */
    public final List<ContentModel2> f2813b;

    /* renamed from: c */
    public final boolean f2814c;

    public ShapeGroup(String str, List<ContentModel2> list, boolean z2) {
        this.f2812a = str;
        this.f2813b = list;
        this.f2814c = z2;
    }

    @Override // p007b.p085c.p086a.p095y.p097l.ContentModel2
    /* renamed from: a */
    public Content2 mo775a(LottieDrawable lottieDrawable, BaseLayer2 baseLayer2) {
        return new ContentGroup(lottieDrawable, baseLayer2, this);
    }

    public String toString() {
        StringBuilder sbM833U = outline.m833U("ShapeGroup{name='");
        sbM833U.append(this.f2812a);
        sbM833U.append("' Shapes: ");
        sbM833U.append(Arrays.toString(this.f2813b.toArray()));
        sbM833U.append('}');
        return sbM833U.toString();
    }
}

package p007b.p085c.p086a.p091w.p092b;

import android.graphics.Path;
import java.util.List;
import p007b.p085c.p086a.LottieDrawable;
import p007b.p085c.p086a.p091w.p093c.BaseKeyframeAnimation;
import p007b.p085c.p086a.p095y.p097l.ShapeData;
import p007b.p085c.p086a.p095y.p097l.ShapePath2;
import p007b.p085c.p086a.p095y.p098m.BaseLayer2;

/* compiled from: ShapeContent.java */
/* renamed from: b.c.a.w.b.q, reason: use source file name */
/* loaded from: classes.dex */
public class ShapeContent implements PathContent, BaseKeyframeAnimation.b {

    /* renamed from: b */
    public final boolean f2580b;

    /* renamed from: c */
    public final LottieDrawable f2581c;

    /* renamed from: d */
    public final BaseKeyframeAnimation<?, Path> f2582d;

    /* renamed from: e */
    public boolean f2583e;

    /* renamed from: a */
    public final Path f2579a = new Path();

    /* renamed from: f */
    public CompoundTrimPathContent f2584f = new CompoundTrimPathContent();

    public ShapeContent(LottieDrawable lottieDrawable, BaseLayer2 baseLayer2, ShapePath2 shapePath2) {
        this.f2580b = shapePath2.f2818d;
        this.f2581c = lottieDrawable;
        BaseKeyframeAnimation<ShapeData, Path> baseKeyframeAnimationMo773a = shapePath2.f2817c.mo773a();
        this.f2582d = baseKeyframeAnimationMo773a;
        baseLayer2.m777e(baseKeyframeAnimationMo773a);
        baseKeyframeAnimationMo773a.f2596a.add(this);
    }

    @Override // p007b.p085c.p086a.p091w.p093c.BaseKeyframeAnimation.b
    /* renamed from: a */
    public void mo709a() {
        this.f2583e = false;
        this.f2581c.invalidateSelf();
    }

    @Override // p007b.p085c.p086a.p091w.p092b.Content2
    /* renamed from: b */
    public void mo710b(List<Content2> list, List<Content2> list2) {
        for (int i = 0; i < list.size(); i++) {
            Content2 content2 = list.get(i);
            if (content2 instanceof TrimPathContent) {
                TrimPathContent trimPathContent = (TrimPathContent) content2;
                if (trimPathContent.f2592c == 1) {
                    this.f2584f.f2481a.add(trimPathContent);
                    trimPathContent.f2591b.add(this);
                }
            }
        }
    }

    @Override // p007b.p085c.p086a.p091w.p092b.PathContent
    public Path getPath() {
        if (this.f2583e) {
            return this.f2579a;
        }
        this.f2579a.reset();
        if (this.f2580b) {
            this.f2583e = true;
            return this.f2579a;
        }
        this.f2579a.set(this.f2582d.mo727e());
        this.f2579a.setFillType(Path.FillType.EVEN_ODD);
        this.f2584f.m715a(this.f2579a);
        this.f2583e = true;
        return this.f2579a;
    }
}

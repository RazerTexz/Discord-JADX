package p007b.p085c.p086a.p091w.p092b;

import java.util.ArrayList;
import java.util.List;
import p007b.p085c.p086a.p091w.p093c.BaseKeyframeAnimation;
import p007b.p085c.p086a.p095y.p097l.ShapeTrimPath;
import p007b.p085c.p086a.p095y.p098m.BaseLayer2;

/* JADX INFO: renamed from: b.c.a.w.b.s, reason: use source file name */
/* JADX INFO: compiled from: TrimPathContent.java */
/* JADX INFO: loaded from: classes.dex */
public class TrimPathContent implements Content2, BaseKeyframeAnimation.b {

    /* JADX INFO: renamed from: a */
    public final boolean f2590a;

    /* JADX INFO: renamed from: b */
    public final List<BaseKeyframeAnimation.b> f2591b = new ArrayList();

    /* JADX INFO: renamed from: c */
    public final int f2592c;

    /* JADX INFO: renamed from: d */
    public final BaseKeyframeAnimation<?, Float> f2593d;

    /* JADX INFO: renamed from: e */
    public final BaseKeyframeAnimation<?, Float> f2594e;

    /* JADX INFO: renamed from: f */
    public final BaseKeyframeAnimation<?, Float> f2595f;

    public TrimPathContent(BaseLayer2 baseLayer2, ShapeTrimPath shapeTrimPath) {
        this.f2590a = shapeTrimPath.f2834f;
        this.f2592c = shapeTrimPath.f2830b;
        BaseKeyframeAnimation<Float, Float> baseKeyframeAnimationMo773a = shapeTrimPath.f2831c.mo773a();
        this.f2593d = baseKeyframeAnimationMo773a;
        BaseKeyframeAnimation<Float, Float> baseKeyframeAnimationMo773a2 = shapeTrimPath.f2832d.mo773a();
        this.f2594e = baseKeyframeAnimationMo773a2;
        BaseKeyframeAnimation<Float, Float> baseKeyframeAnimationMo773a3 = shapeTrimPath.f2833e.mo773a();
        this.f2595f = baseKeyframeAnimationMo773a3;
        baseLayer2.m777e(baseKeyframeAnimationMo773a);
        baseLayer2.m777e(baseKeyframeAnimationMo773a2);
        baseLayer2.m777e(baseKeyframeAnimationMo773a3);
        baseKeyframeAnimationMo773a.f2596a.add(this);
        baseKeyframeAnimationMo773a2.f2596a.add(this);
        baseKeyframeAnimationMo773a3.f2596a.add(this);
    }

    @Override // p007b.p085c.p086a.p091w.p093c.BaseKeyframeAnimation.b
    /* JADX INFO: renamed from: a */
    public void mo709a() {
        for (int i = 0; i < this.f2591b.size(); i++) {
            this.f2591b.get(i).mo709a();
        }
    }

    @Override // p007b.p085c.p086a.p091w.p092b.Content2
    /* JADX INFO: renamed from: b */
    public void mo710b(List<Content2> list, List<Content2> list2) {
    }
}
